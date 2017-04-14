package com.baidu.tieba.imageProblem.httpNet;

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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.e.a;
import com.baidu.tbadk.util.g;
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
/* loaded from: classes.dex */
public class CDNIPDirectConnect extends e {
    private static volatile CDNIPDirectConnect dnv;
    private TbCdnMobileGetIpModel dnt;
    private long dnk = 0;
    private boolean dnl = false;
    private final float dnm = 100.0f;
    private CdnCacheItem dnn = null;
    private IPListReceiver dno = null;
    private final long dnp = 3600000;
    private final long dnq = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long dnr = 10000;
    private final int dns = 1003;
    public a dnu = null;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CDNIPDirectConnect.m21getInstance().normalUserStartTachometerCdnList();
            }
        }
    };

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNIPDirectConnect m21getInstance() {
        if (dnv == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (dnv == null) {
                    dnv = new CDNIPDirectConnect();
                }
            }
        }
        return dnv;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.dnu = new a();
            this.dnt = new TbCdnMobileGetIpModel();
            awb();
            this.dno = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m9getInst().getApp().registerReceiver(this.dno, intentFilter);
            if (TbadkCoreApplication.m9getInst().isMainProcess(true) && k.hz()) {
                try {
                    TbadkCoreApplication.m9getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.ahn = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void awb() {
        CdnCacheItem awc = awc();
        long currentTimeMillis = System.currentTimeMillis();
        if (awc != null && awc.firstUseIpTime > 0 && currentTimeMillis - awc.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.dnn = awc;
        }
        if (this.dnn == null) {
            this.dnn = new CdnCacheItem();
            this.dnn.firstUseIpTime = currentTimeMillis;
            this.dnn.identifier = getNetIdentifier();
        }
        if (0 == this.dnn.firstUseIpTime) {
            this.dnn.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.dnn.identifier == null || netIdentifier == null || this.dnn.identifier.equals(netIdentifier)) ? false : true;
        if (i.hk()) {
            if (this.dnn.lastTachometerTime == 0 || z || (this.dnn.getIsUsedIp() && currentTimeMillis - this.dnn.lastTachometerTime > 3600000)) {
                this.dnn.lastTachometerTime = currentTimeMillis;
                this.dnn.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m9getInst().getApp(), true, false);
            }
        } else if (this.dnn.mobileLastTachometerTime == 0 || z || (this.dnn.mobileIsUsedIp() && currentTimeMillis - this.dnn.mobileLastTachometerTime > 3600000)) {
            this.dnn.identifier = netIdentifier;
            awa();
        }
    }

    /* loaded from: classes.dex */
    private class IPListReceiver extends BroadcastReceiver {
        private IPListReceiver() {
        }

        /* synthetic */ IPListReceiver(CDNIPDirectConnect cDNIPDirectConnect, IPListReceiver iPListReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
                if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                    CDNIPDirectConnect.this.dnn.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.dnn);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.dnl = true;
                }
                CDNIPDirectConnect.this.dnn.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.dnn);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (g.gf(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, int i, boolean z) {
        return z ? ae(str, i) : af(str, i);
    }

    private HttpGet ae(String str, int i) {
        String ipString;
        if (!this.dnn.getIsUsedIp() || (ipString = this.dnn.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.dnn.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return bm(str, ipString);
    }

    private HttpGet af(String str, int i) {
        String mobileCdnIp;
        if (!this.dnu.RR || (mobileCdnIp = this.dnn.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.dnn.mobileLastTachometerTime > 3600000) {
            awa();
        }
        return bm(str, mobileCdnIp);
    }

    private HttpGet bm(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && g.ge(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = g.gf(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getAllIPListCanUsed() {
        return this.dnn.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.dnk = System.currentTimeMillis();
        this.dnn.lastTachometerTime = this.dnk;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m9getInst().getApp(), false, false);
    }

    private void awa() {
        if (this.dnu.RR) {
            this.dnn.mobileLastTachometerTime = System.currentTimeMillis();
            this.dnt.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!g.gg(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (CDNProblemUploader.m22getInstance().getmCdnLogData() != null) {
                        i = CDNProblemUploader.m22getInstance().getmCdnLogData().getErrRank();
                    } else {
                        i = 25;
                    }
                } else if (CDNProblemUploader.m22getInstance().getmCdnLogData() != null) {
                    i = CDNProblemUploader.m22getInstance().getmCdnLogData().getSlowRank();
                } else {
                    i = 10;
                }
            } else if (CDNProblemUploader.m22getInstance().getmCdnLogData() != null) {
                i = -CDNProblemUploader.m22getInstance().getmCdnLogData().getSuccRank();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.dnn.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.dnn);
                    }
                } else if (this.dnn.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.dnn);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.dnn.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    awa();
                    b(this.dnn);
                }
            } else if (this.dnn.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                awa();
                b(this.dnn);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.dnl;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.dnu;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.dnu = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (i.hk()) {
            return this.dnn.getIpString(i);
        }
        if (this.dnu.RR) {
            return this.dnn.getMobileCdnIp(i);
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

    private CdnCacheItem B(byte[] bArr) {
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

    private CdnCacheItem awc() {
        String string = b.uL().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return B(c.decode(string));
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CdnCacheItem cdnCacheItem) {
        byte[] a;
        if (TbadkCoreApplication.m9getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String encodeBytes = c.encodeBytes(a);
                if (encodeBytes != null) {
                    b.uL().putString("cdn_iplist_cache_key_three", encodeBytes);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (i.hk()) {
            try {
                WifiManager wifiManager = (WifiManager) TbadkCoreApplication.m9getInst().getContext().getSystemService("wifi");
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
                Context context = TbadkCoreApplication.m9getInst().getContext();
                if (ae.aD(context)) {
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
        return (this.dnn != null ? this.dnn.hasImageProblem() : false) || this.dnl;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.dnn.setIpDisableTime(i);
    }

    /* loaded from: classes.dex */
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
                            CDNIPDirectConnect.m21getInstance().normalUserStartTachometerCdnList();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.m21getInstance().normalUserStartTachometerCdnList();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
