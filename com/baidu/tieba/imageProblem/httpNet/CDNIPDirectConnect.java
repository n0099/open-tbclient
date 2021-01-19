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
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.b.e;
import com.baidu.tbadk.i.a;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes7.dex */
public class CDNIPDirectConnect extends e {
    private static volatile CDNIPDirectConnect kOR;
    private TbCdnMobileGetIpModel kOP;
    private long kOG = 0;
    private boolean kOH = false;
    private final float kOI = 100.0f;
    private CdnCacheItem kOJ = null;
    private IPListReceiver kOK = null;
    private final long kOL = BdKVCache.MILLS_1Hour;
    private final long kOM = 604800000;
    private final long kON = 10000;
    private final int kOO = 1003;
    public a kOQ = null;
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
        if (kOR == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (kOR == null) {
                    kOR = new CDNIPDirectConnect();
                }
            }
        }
        return kOR;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public void init() {
        try {
            this.kOQ = new a();
            this.kOP = new TbCdnMobileGetIpModel();
            cYB();
            this.kOK = new IPListReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.getInst().getApp().registerReceiver(this.kOK, intentFilter);
            if (TbadkCoreApplication.getInst().isMainProcess(true) && l.isMainThread()) {
                try {
                    TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.eZB = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void cYB() {
        CdnCacheItem cYC = cYC();
        long currentTimeMillis = System.currentTimeMillis();
        if (cYC != null && cYC.firstUseIpTime > 0 && currentTimeMillis - cYC.firstUseIpTime < 604800000) {
            this.kOJ = cYC;
        }
        if (this.kOJ == null) {
            this.kOJ = new CdnCacheItem();
            this.kOJ.firstUseIpTime = currentTimeMillis;
            this.kOJ.identifier = getNetIdentifier();
        }
        if (0 == this.kOJ.firstUseIpTime) {
            this.kOJ.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.kOJ.identifier == null || netIdentifier == null || this.kOJ.identifier.equals(netIdentifier)) ? false : true;
        if (j.isWifiNet()) {
            if (this.kOJ.lastTachometerTime == 0 || z || (this.kOJ.getIsUsedIp() && currentTimeMillis - this.kOJ.lastTachometerTime > BdKVCache.MILLS_1Hour)) {
                this.kOJ.lastTachometerTime = currentTimeMillis;
                this.kOJ.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
            }
        } else if (this.kOJ.mobileLastTachometerTime == 0 || z || (this.kOJ.mobileIsUsedIp() && currentTimeMillis - this.kOJ.mobileLastTachometerTime > BdKVCache.MILLS_1Hour)) {
            this.kOJ.identifier = netIdentifier;
            cYA();
        }
    }

    /* loaded from: classes7.dex */
    private class IPListReceiver extends BroadcastReceiver {
        private IPListReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
                if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                    CDNIPDirectConnect.this.kOJ.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.kOJ);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.kOH = true;
                }
                CDNIPDirectConnect.this.kOJ.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size > 0) {
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.kOJ);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (m.isCdn(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public HttpGet httpGetFactory(String str, int i, boolean z) {
        return z ? by(str, i) : bz(str, i);
    }

    private HttpGet by(String str, int i) {
        String ipString;
        if (!this.kOJ.getIsUsedIp() || (ipString = this.kOJ.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.kOJ.lastTachometerTime > BdKVCache.MILLS_1Hour) {
            regetCdnIpList();
        }
        return fD(str, ipString);
    }

    private HttpGet bz(String str, int i) {
        String mobileCdnIp;
        if (!this.kOQ.eHg || (mobileCdnIp = this.kOJ.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.kOJ.mobileLastTachometerTime > BdKVCache.MILLS_1Hour) {
            cYA();
        }
        return fD(str, mobileCdnIp);
    }

    private HttpGet fD(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && m.canUseIp(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = m.isCdn(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public String getAllIPListCanUsed() {
        return this.kOJ.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.kOG = System.currentTimeMillis();
        this.kOJ.lastTachometerTime = this.kOG;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), false, false);
    }

    private void cYA() {
        if (this.kOQ.eHg) {
            this.kOJ.mobileLastTachometerTime = System.currentTimeMillis();
            this.kOP.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!m.isPortrait(str)) {
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
                    if (this.kOJ.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.kOJ);
                    }
                } else if (this.kOJ.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.kOJ);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.kOJ.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    cYA();
                    b(this.kOJ);
                }
            } else if (this.kOJ.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                cYA();
                b(this.kOJ);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public boolean isShouldCDNFallBack() {
        return this.kOH;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public a getCDNImageTimeData() {
        return this.kOQ;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public void setCDNImageTimeData(a aVar) {
        this.kOQ = aVar;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public String getCachedCdnIp(int i) {
        if (j.isWifiNet()) {
            return this.kOJ.getIpString(i);
        }
        if (this.kOQ.eHg) {
            return this.kOJ.getMobileCdnIp(i);
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

    private CdnCacheItem ae(byte[] bArr) {
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

    private CdnCacheItem cYC() {
        String string = b.brx().getString(SharedPrefConfig.CDN_IPLIST_CACHE_KEY, "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return ae(c.decode(string));
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CdnCacheItem cdnCacheItem) {
        byte[] a2;
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (a2 = a(cdnCacheItem)) != null && a2.length > 0) {
            try {
                String encodeBytes = c.encodeBytes(a2);
                if (encodeBytes != null) {
                    b.brx().putString(SharedPrefConfig.CDN_IPLIST_CACHE_KEY, encodeBytes);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (!ad.bsf()) {
            return "";
        }
        if (j.isWifiNet()) {
            try {
                WifiManager wifiManager = (WifiManager) TbadkCoreApplication.getInst().getContext().getSystemService("wifi");
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
                if (ad.checkReadPhoneState(context)) {
                    return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public boolean hasImageProblem() {
        return (this.kOJ != null ? this.kOJ.hasImageProblem() : false) || this.kOH;
    }

    @Override // com.baidu.tbadk.core.util.b.e
    public void setIpDisableTime(int i) {
        this.kOJ.setIpDisableTime(i);
    }

    /* loaded from: classes7.dex */
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
            if (ad.bsf()) {
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
}
