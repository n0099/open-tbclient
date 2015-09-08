package com.baidu.tieba.imageProblem.httpNet;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class CdnCacheItem implements Serializable {
    private static final long serialVersionUID = 6622778689529331355L;
    private HashMap<String, Long> disableIpMap;
    private int ipDisableTime;
    private ArrayList<TBIPListItem> ipList;
    private ArrayList<TBIPListItem> mobileIpList;
    private boolean mobileIsUsedIp;
    private static Object mLock = new Object();
    private static Object bMP = new Object();
    private boolean isUsedIp = false;
    public long lastTachometerTime = 0;
    public long firstUseIpTime = 0;
    public String identifier = null;
    private int cdnDomainRank = 0;
    private final int TB_CDN_IP_DISABLE_TIME = TbadkCoreApplication.APP_ENTER_FORE_SEND_PV_INTERNAL;
    private int mobileCdnDomainRank = 0;
    public long mobileLastTachometerTime = 0;
    private HashMap<String, String> ipHashMap = new HashMap<>();

    public CdnCacheItem() {
        this.ipList = null;
        this.mobileIpList = null;
        this.ipList = new ArrayList<>();
        this.mobileIpList = new ArrayList<>();
    }

    public String getIpString(int i) {
        String str;
        if (this.isUsedIp) {
            if (this.ipList == null || this.ipList.size() == 0) {
                return null;
            }
            synchronized (mLock) {
                if (this.ipList == null || this.ipList.size() == 0) {
                    str = null;
                } else {
                    int size = i % this.ipList.size();
                    if (size >= this.ipList.size()) {
                        str = null;
                    } else {
                        TBIPListItem tBIPListItem = this.ipList.get(size);
                        str = tBIPListItem == null ? null : tBIPListItem.cdnIp;
                    }
                }
            }
            return str;
        }
        return null;
    }

    public String getAllIpFromItem() {
        if (this.ipList == null || this.ipList.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(50);
        int size = this.ipList.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.ipList.get(i).cdnIp);
            sb.append(",");
        }
        return sb.toString();
    }

    public int setIPRank(int i, float f, String str) {
        int i2;
        TBIPListItem tBIPListItem;
        if (str == null) {
            return -1;
        }
        synchronized (mLock) {
            int size = this.ipList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i2 = 0;
                    tBIPListItem = null;
                    break;
                }
                TBIPListItem tBIPListItem2 = this.ipList.get(i3);
                if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                    int i4 = i3;
                    tBIPListItem = tBIPListItem2;
                    i2 = i4;
                    break;
                }
                i3++;
            }
            if (tBIPListItem == null) {
                return -1;
            }
            tBIPListItem.ipRank += i;
            if (tBIPListItem.ipRank >= f) {
                this.ipHashMap.remove(tBIPListItem.cdnIp);
                this.ipList.remove(i2);
                long currentTimeMillis = System.currentTimeMillis();
                Zk();
                this.disableIpMap.put(tBIPListItem.cdnIp, Long.valueOf(currentTimeMillis));
            }
            if (tBIPListItem.ipRank < 0) {
                tBIPListItem.ipRank = 0;
            }
            if (this.ipList.size() == 0) {
                this.isUsedIp = false;
            }
            return tBIPListItem.ipRank;
        }
    }

    public int setCdnDomainRank(int i, float f) {
        int i2;
        synchronized (bMP) {
            this.cdnDomainRank += i;
            if (this.cdnDomainRank < 0) {
                this.cdnDomainRank = 0;
            }
            i2 = this.cdnDomainRank;
            if (this.cdnDomainRank > f) {
                this.cdnDomainRank = 0;
                this.isUsedIp = true;
            }
        }
        return i2;
    }

    public boolean hasImageProblem() {
        return i.iM() ? this.cdnDomainRank > 0 || this.isUsedIp : this.cdnDomainRank > 0 || this.mobileIsUsedIp;
    }

    public boolean getIsUsedIp() {
        return this.isUsedIp;
    }

    /* loaded from: classes.dex */
    private class TBIPListItem implements Serializable {
        private static final long serialVersionUID = -99289965442562023L;
        public String cdnIp;
        public int ipRank;

        private TBIPListItem() {
            this.ipRank = 0;
        }

        /* synthetic */ TBIPListItem(CdnCacheItem cdnCacheItem, TBIPListItem tBIPListItem) {
            this();
        }
    }

    public void setIpList(ArrayList<String> arrayList, boolean z, boolean z2) {
        if (arrayList != null && arrayList.size() != 0) {
            synchronized (mLock) {
                Zk();
                if (z2) {
                    this.ipList.clear();
                    this.ipHashMap.clear();
                }
                this.isUsedIp = z;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = arrayList.get(i);
                    Long l = this.disableIpMap.get(str);
                    if (l != null && System.currentTimeMillis() - l.longValue() >= Zl()) {
                        this.disableIpMap.remove(str);
                    }
                    if (this.ipHashMap.get(str) == null && this.disableIpMap.get(str) == null) {
                        TBIPListItem tBIPListItem = new TBIPListItem(this, null);
                        tBIPListItem.cdnIp = str;
                        this.ipList.add(tBIPListItem);
                        this.ipHashMap.put(str, "1");
                    }
                }
            }
        }
    }

    private void Zk() {
        if (this.disableIpMap == null) {
            this.disableIpMap = new HashMap<>();
        }
    }

    private int Zl() {
        return this.ipDisableTime < 0 ? TbadkCoreApplication.APP_ENTER_FORE_SEND_PV_INTERNAL : this.ipDisableTime;
    }

    public void setIpDisableTime(int i) {
        this.ipDisableTime = i * 1000;
    }

    public boolean mobileIsUsedIp() {
        return this.mobileIsUsedIp;
    }

    public String getMobileCdnIp(int i) {
        String str;
        if (this.mobileIpList == null || this.mobileIpList.size() == 0) {
            return null;
        }
        synchronized (mLock) {
            if (this.mobileIpList == null || this.mobileIpList.size() == 0) {
                str = null;
            } else {
                int size = i % this.mobileIpList.size();
                if (size >= this.mobileIpList.size()) {
                    str = null;
                } else {
                    TBIPListItem tBIPListItem = this.mobileIpList.get(size);
                    str = tBIPListItem == null ? null : tBIPListItem.cdnIp;
                }
            }
        }
        return str;
    }

    public void setMobileIpList(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            synchronized (mLock) {
                this.mobileIpList.clear();
                TBIPListItem tBIPListItem = new TBIPListItem(this, null);
                tBIPListItem.cdnIp = "c.hiphotos.baidu.com";
                this.mobileIpList.add(tBIPListItem);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    TBIPListItem tBIPListItem2 = new TBIPListItem(this, null);
                    tBIPListItem2.cdnIp = arrayList.get(i);
                    this.mobileIpList.add(tBIPListItem2);
                }
            }
        }
    }

    public int setMoblieIPRank(int i, float f, String str) {
        int i2;
        TBIPListItem tBIPListItem;
        synchronized (mLock) {
            if (str == null) {
                this.mobileCdnDomainRank += i;
                if (this.mobileCdnDomainRank < 0) {
                    this.mobileCdnDomainRank = 0;
                }
                int i3 = this.mobileCdnDomainRank;
                if (this.mobileCdnDomainRank > f) {
                    this.mobileCdnDomainRank = 0;
                    this.mobileIsUsedIp = true;
                }
                return i3;
            }
            int size = this.mobileIpList.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i2 = 0;
                    tBIPListItem = null;
                    break;
                }
                TBIPListItem tBIPListItem2 = this.mobileIpList.get(i4);
                if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                    int i5 = i4;
                    tBIPListItem = tBIPListItem2;
                    i2 = i5;
                    break;
                }
                i4++;
            }
            if (tBIPListItem == null) {
                return -1;
            }
            tBIPListItem.ipRank += i;
            if (tBIPListItem.ipRank >= f) {
                this.mobileIpList.remove(i2);
                this.mobileIsUsedIp = true;
            }
            if (tBIPListItem.ipRank < 0) {
                tBIPListItem.ipRank = 0;
            }
            if (this.mobileIpList.size() == 0) {
                this.mobileIsUsedIp = false;
            }
            return tBIPListItem.ipRank;
        }
    }
}
