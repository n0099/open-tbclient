package com.baidu.tieba.imageProblem.httpNet;

import d.b.b.e.p.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class CdnCacheItem implements Serializable {
    public static final int TB_CDNCACHEITEM_ERROR = -1;
    public static final int TB_CDN_IP_DISABLE_TIME = 3600000;
    public static final long serialVersionUID = 6622778689529331355L;
    public HashMap<String, Long> disableIpMap;
    public int ipDisableTime;
    public ArrayList<TBIPListItem> ipList;
    public ArrayList<TBIPListItem> mobileIpList;
    public boolean mobileIsUsedIp;
    public static Object mLock = new Object();
    public static Object mDomainLock = new Object();
    public boolean isUsedIp = false;
    public long lastTachometerTime = 0;
    public long firstUseIpTime = 0;
    public String identifier = null;
    public int cdnDomainRank = 0;
    public int mobileCdnDomainRank = 0;
    public long mobileLastTachometerTime = 0;
    public HashMap<String, String> ipHashMap = new HashMap<>();

    /* loaded from: classes4.dex */
    public class TBIPListItem implements Serializable {
        public static final long serialVersionUID = -99289965442562023L;
        public String cdnIp;
        public int ipRank;

        public TBIPListItem() {
            this.ipRank = 0;
        }
    }

    public CdnCacheItem() {
        this.ipList = null;
        this.mobileIpList = null;
        this.ipList = new ArrayList<>();
        this.mobileIpList = new ArrayList<>();
    }

    private int disableIpTime() {
        int i = this.ipDisableTime;
        if (i < 0) {
            return 3600000;
        }
        return i;
    }

    private void setDisableIpMap() {
        if (this.disableIpMap == null) {
            this.disableIpMap = new HashMap<>();
        }
    }

    public String getAllIpFromItem() {
        ArrayList<TBIPListItem> arrayList = this.ipList;
        if (arrayList == null || arrayList.size() == 0) {
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

    public String getIpString(int i) {
        ArrayList<TBIPListItem> arrayList;
        if (!this.isUsedIp || (arrayList = this.ipList) == null || arrayList.size() == 0) {
            return null;
        }
        synchronized (mLock) {
            if (this.ipList != null && this.ipList.size() != 0) {
                int size = i % this.ipList.size();
                if (size >= this.ipList.size()) {
                    return null;
                }
                TBIPListItem tBIPListItem = this.ipList.get(size);
                if (tBIPListItem == null) {
                    return null;
                }
                return tBIPListItem.cdnIp;
            }
            return null;
        }
    }

    public boolean getIsUsedIp() {
        return this.isUsedIp;
    }

    public String getMobileCdnIp(int i) {
        ArrayList<TBIPListItem> arrayList = this.mobileIpList;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        synchronized (mLock) {
            if (this.mobileIpList != null && this.mobileIpList.size() != 0) {
                int size = i % this.mobileIpList.size();
                if (size >= this.mobileIpList.size()) {
                    return null;
                }
                TBIPListItem tBIPListItem = this.mobileIpList.get(size);
                if (tBIPListItem == null) {
                    return null;
                }
                return tBIPListItem.cdnIp;
            }
            return null;
        }
    }

    public boolean hasImageProblem() {
        return j.H() ? this.cdnDomainRank > 0 || this.isUsedIp : this.cdnDomainRank > 0 || this.mobileIsUsedIp;
    }

    public boolean mobileIsUsedIp() {
        return this.mobileIsUsedIp;
    }

    public int setCdnDomainRank(int i, float f2) {
        int i2;
        synchronized (mDomainLock) {
            int i3 = this.cdnDomainRank + i;
            this.cdnDomainRank = i3;
            if (i3 < 0) {
                this.cdnDomainRank = 0;
            }
            i2 = this.cdnDomainRank;
            if (this.cdnDomainRank > f2) {
                this.cdnDomainRank = 0;
                this.isUsedIp = true;
            }
        }
        return i2;
    }

    public int setIPRank(int i, float f2, String str) {
        if (str == null) {
            return -1;
        }
        synchronized (mLock) {
            TBIPListItem tBIPListItem = null;
            int size = this.ipList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = 0;
                    break;
                }
                TBIPListItem tBIPListItem2 = this.ipList.get(i2);
                if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                    tBIPListItem = tBIPListItem2;
                    break;
                }
                i2++;
            }
            if (tBIPListItem == null) {
                return -1;
            }
            int i3 = tBIPListItem.ipRank + i;
            tBIPListItem.ipRank = i3;
            if (i3 >= f2) {
                this.ipHashMap.remove(tBIPListItem.cdnIp);
                this.ipList.remove(i2);
                long currentTimeMillis = System.currentTimeMillis();
                setDisableIpMap();
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

    public void setIpDisableTime(int i) {
        this.ipDisableTime = i * 1000;
    }

    public void setIpList(ArrayList<String> arrayList, boolean z, boolean z2) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (mLock) {
            setDisableIpMap();
            if (z2) {
                this.ipList.clear();
                this.ipHashMap.clear();
            }
            this.isUsedIp = z;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                String str = arrayList.get(i);
                Long l = this.disableIpMap.get(str);
                if (l != null && System.currentTimeMillis() - l.longValue() >= disableIpTime()) {
                    this.disableIpMap.remove(str);
                }
                if (this.ipHashMap.get(str) == null && this.disableIpMap.get(str) == null) {
                    TBIPListItem tBIPListItem = new TBIPListItem();
                    tBIPListItem.cdnIp = str;
                    this.ipList.add(tBIPListItem);
                    this.ipHashMap.put(str, "1");
                }
            }
        }
    }

    public void setMobileIpList(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (mLock) {
            this.mobileIpList.clear();
            TBIPListItem tBIPListItem = new TBIPListItem();
            tBIPListItem.cdnIp = "c.hiphotos.baidu.com";
            this.mobileIpList.add(tBIPListItem);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TBIPListItem tBIPListItem2 = new TBIPListItem();
                tBIPListItem2.cdnIp = arrayList.get(i);
                this.mobileIpList.add(tBIPListItem2);
            }
        }
    }

    public int setMoblieIPRank(int i, float f2, String str) {
        synchronized (mLock) {
            if (str == null) {
                int i2 = this.mobileCdnDomainRank + i;
                this.mobileCdnDomainRank = i2;
                if (i2 < 0) {
                    this.mobileCdnDomainRank = 0;
                }
                int i3 = this.mobileCdnDomainRank;
                if (this.mobileCdnDomainRank > f2) {
                    this.mobileCdnDomainRank = 0;
                    this.mobileIsUsedIp = true;
                }
                return i3;
            }
            TBIPListItem tBIPListItem = null;
            int size = this.mobileIpList.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i4 = 0;
                    break;
                }
                TBIPListItem tBIPListItem2 = this.mobileIpList.get(i4);
                if (str.equalsIgnoreCase(tBIPListItem2.cdnIp)) {
                    tBIPListItem = tBIPListItem2;
                    break;
                }
                i4++;
            }
            if (tBIPListItem == null) {
                return -1;
            }
            int i5 = tBIPListItem.ipRank + i;
            tBIPListItem.ipRank = i5;
            if (i5 >= f2) {
                this.mobileIpList.remove(i4);
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
