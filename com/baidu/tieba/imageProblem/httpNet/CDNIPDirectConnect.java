package com.baidu.tieba.imageProblem.httpNet;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.c;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.i.a;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class CDNIPDirectConnect extends e {
    private static volatile CDNIPDirectConnect gZP;
    private TbCdnMobileGetIpModel gZN;
    private long gZE = 0;
    private boolean gZF = false;
    private final float gZG = 100.0f;
    private CdnCacheItem gZH = null;
    private IPListReceiver gZI = null;
    private final long gZJ = 3600000;
    private final long gZK = 604800000;
    private final long gZL = 10000;
    private final int gZM = 1003;
    public a gZO = null;
    @SuppressLint({"HandlerLeak"})
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CDNIPDirectConnect.getInstance().normalUserStartTachometerCdnList();
            }
        }
    };

    public static CDNIPDirectConnect getInstance() {
        if (gZP == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (gZP == null) {
                    gZP = new CDNIPDirectConnect();
                }
            }
        }
        return gZP;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.gZO = new a();
            this.gZN = new TbCdnMobileGetIpModel();
            bJe();
            this.gZI = new IPListReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.getInst().getApp().registerReceiver(this.gZI, intentFilter);
            if (TbadkCoreApplication.getInst().isMainProcess(true) && l.ks()) {
                try {
                    TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.bUL = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void bJe() {
        CdnCacheItem bJf = bJf();
        long currentTimeMillis = System.currentTimeMillis();
        if (bJf != null && bJf.firstUseIpTime > 0 && currentTimeMillis - bJf.firstUseIpTime < 604800000) {
            this.gZH = bJf;
        }
        if (this.gZH == null) {
            this.gZH = new CdnCacheItem();
            this.gZH.firstUseIpTime = currentTimeMillis;
            this.gZH.identifier = getNetIdentifier();
        }
        if (0 == this.gZH.firstUseIpTime) {
            this.gZH.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.gZH.identifier == null || netIdentifier == null || this.gZH.identifier.equals(netIdentifier)) ? false : true;
        if (j.kd()) {
            if (this.gZH.lastTachometerTime == 0 || z || (this.gZH.getIsUsedIp() && currentTimeMillis - this.gZH.lastTachometerTime > 3600000)) {
                this.gZH.lastTachometerTime = currentTimeMillis;
                this.gZH.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
            }
        } else if (this.gZH.mobileLastTachometerTime == 0 || z || (this.gZH.mobileIsUsedIp() && currentTimeMillis - this.gZH.mobileLastTachometerTime > 3600000)) {
            this.gZH.identifier = netIdentifier;
            bJd();
        }
    }

    /* loaded from: classes2.dex */
    private class IPListReceiver extends BroadcastReceiver {
        private IPListReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
                if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                    CDNIPDirectConnect.this.gZH.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.gZH);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.gZF = true;
                }
                CDNIPDirectConnect.this.gZH.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size > 0) {
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.gZH);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (com.baidu.tbadk.util.l.rf(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader(HTTP.TARGET_HOST, str3);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, int i, boolean z) {
        return z ? aW(str, i) : aX(str, i);
    }

    private HttpGet aW(String str, int i) {
        String ipString;
        if (!this.gZH.getIsUsedIp() || (ipString = this.gZH.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.gZH.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return du(str, ipString);
    }

    private HttpGet aX(String str, int i) {
        String mobileCdnIp;
        if (!this.gZO.bCH || (mobileCdnIp = this.gZH.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.gZH.mobileLastTachometerTime > 3600000) {
            bJd();
        }
        return du(str, mobileCdnIp);
    }

    private HttpGet du(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && com.baidu.tbadk.util.l.re(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = com.baidu.tbadk.util.l.rf(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader(HTTP.TARGET_HOST, host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getAllIPListCanUsed() {
        return this.gZH.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.gZE = System.currentTimeMillis();
        this.gZH.lastTachometerTime = this.gZE;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), false, false);
    }

    private void bJd() {
        if (this.gZO.bCH) {
            this.gZH.mobileLastTachometerTime = System.currentTimeMillis();
            this.gZN.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!com.baidu.tbadk.util.l.rg(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (CDNProblemUploader.getInstance().getmCdnLogData() != null) {
                        i = CDNProblemUploader.getInstance().getmCdnLogData().getErrRank();
                    } else {
                        i = 25;
                    }
                } else if (CDNProblemUploader.getInstance().getmCdnLogData() != null) {
                    i = CDNProblemUploader.getInstance().getmCdnLogData().getSlowRank();
                } else {
                    i = 10;
                }
            } else if (CDNProblemUploader.getInstance().getmCdnLogData() != null) {
                i = -CDNProblemUploader.getInstance().getmCdnLogData().getSuccRank();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.gZH.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.gZH);
                    }
                } else if (this.gZH.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.gZH);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.gZH.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    bJd();
                    b(this.gZH);
                }
            } else if (this.gZH.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                bJd();
                b(this.gZH);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.gZF;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.gZO;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.gZO = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (j.kd()) {
            return this.gZH.getIpString(i);
        }
        if (this.gZO.bCH) {
            return this.gZH.getMobileCdnIp(i);
        }
        return null;
    }

    private byte[] a(CdnCacheItem cdnCacheItem) {
        if (cdnCacheItem != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(cdnCacheItem);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                objectOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return null;
    }

    private CdnCacheItem Q(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            if (readObject instanceof CdnCacheItem) {
                return (CdnCacheItem) readObject;
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    private CdnCacheItem bJf() {
        String string = b.ahO().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return Q(c.decode(string));
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CdnCacheItem cdnCacheItem) {
        byte[] a;
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String encodeBytes = c.encodeBytes(a);
                if (encodeBytes != null) {
                    b.ahO().putString("cdn_iplist_cache_key_three", encodeBytes);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (j.kd()) {
            try {
                WifiManager wifiManager = (WifiManager) TbadkCoreApplication.getInst().getContext().getSystemService(IXAdSystemUtils.NT_WIFI);
                if (!wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                }
                return wifiManager.getConnectionInfo().getSSID();
            } catch (Error e) {
                BdLog.e(e);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        } else {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                if (ab.cA(context)) {
                    return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean hasImageProblem() {
        return (this.gZH != null ? this.gZH.hasImageProblem() : false) || this.gZF;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.gZH.setIpDisableTime(i);
    }

    /* loaded from: classes2.dex */
    public class CDNNetworkChangeReceiver extends BroadcastReceiver {
        private static final int MOBILE = 2;
        private static final int NOTSET = -1;
        private static final int WIFI = 1;
        private static final String WIFI_STRING = "WIFI";
        private int NETWORK_STATUS = -1;

        public CDNNetworkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z = false;
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    z = true;
                }
                if (z) {
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase(WIFI_STRING)) {
                        if (this.NETWORK_STATUS != -1) {
                            CDNIPDirectConnect.getInstance().normalUserStartTachometerCdnList();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.getInstance().normalUserStartTachometerCdnList();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
