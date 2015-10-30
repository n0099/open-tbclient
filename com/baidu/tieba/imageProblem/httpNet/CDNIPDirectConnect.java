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
import com.baidu.tbadk.cdnOptimize.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
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
    private static volatile CDNIPDirectConnect bQB;
    private TbCdnMobileGetIpModel bQz;
    private long bQq = 0;
    private boolean bQr = false;
    private final float bQs = 100.0f;
    private CdnCacheItem bQt = null;
    private IPListReceiver bQu = null;
    private final long bQv = 3600000;
    private final long bQw = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long bQx = 10000;
    private final int bQy = 1003;
    public a bQA = null;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CDNIPDirectConnect.m413getInstance().normalUserStartTachometerCdnList();
            }
        }
    };

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNIPDirectConnect m413getInstance() {
        if (bQB == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (bQB == null) {
                    bQB = new CDNIPDirectConnect();
                }
            }
        }
        return bQB;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.bQA = new a();
            this.bQz = new TbCdnMobileGetIpModel();
            aao();
            this.bQu = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m411getInst().getApp().registerReceiver(this.bQu, intentFilter);
            if (TbadkCoreApplication.m411getInst().isMainProcess(true) && k.jc()) {
                try {
                    TbadkCoreApplication.m411getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.abV = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void aao() {
        CdnCacheItem aap = aap();
        long currentTimeMillis = System.currentTimeMillis();
        if (aap != null && aap.firstUseIpTime > 0 && currentTimeMillis - aap.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.bQt = aap;
        }
        if (this.bQt == null) {
            this.bQt = new CdnCacheItem();
            this.bQt.firstUseIpTime = currentTimeMillis;
            this.bQt.identifier = getNetIdentifier();
        }
        if (0 == this.bQt.firstUseIpTime) {
            this.bQt.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.bQt.identifier == null || netIdentifier == null || this.bQt.identifier.equals(netIdentifier)) ? false : true;
        if (i.iN()) {
            if (this.bQt.lastTachometerTime == 0 || z || (this.bQt.getIsUsedIp() && currentTimeMillis - this.bQt.lastTachometerTime > 3600000)) {
                this.bQt.lastTachometerTime = currentTimeMillis;
                this.bQt.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m411getInst().getApp(), true, false);
            }
        } else if (this.bQt.mobileLastTachometerTime == 0 || z || (this.bQt.mobileIsUsedIp() && currentTimeMillis - this.bQt.mobileLastTachometerTime > 3600000)) {
            this.bQt.identifier = netIdentifier;
            aan();
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
                    CDNIPDirectConnect.this.bQt.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.bQt);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.bQr = true;
                }
                CDNIPDirectConnect.this.bQt.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.bQt);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (com.baidu.tbadk.util.e.fK(str)) {
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
        return z ? S(str, i) : T(str, i);
    }

    private HttpGet S(String str, int i) {
        String ipString;
        if (!this.bQt.getIsUsedIp() || (ipString = this.bQt.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.bQt.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return aQ(str, ipString);
    }

    private HttpGet T(String str, int i) {
        String mobileCdnIp;
        if (!this.bQA.Sw || (mobileCdnIp = this.bQt.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.bQt.mobileLastTachometerTime > 3600000) {
            aan();
        }
        return aQ(str, mobileCdnIp);
    }

    private HttpGet aQ(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && com.baidu.tbadk.util.e.fJ(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = com.baidu.tbadk.util.e.fK(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
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
        return this.bQt.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.bQq = System.currentTimeMillis();
        this.bQt.lastTachometerTime = this.bQq;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m411getInst().getApp(), false, false);
    }

    private void aan() {
        if (this.bQA.Sw) {
            this.bQt.mobileLastTachometerTime = System.currentTimeMillis();
            this.bQz.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!com.baidu.tbadk.util.e.fL(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (CDNProblemUploader.m414getInstance().getmCdnLogData() != null) {
                        i = CDNProblemUploader.m414getInstance().getmCdnLogData().getErrRank();
                    } else {
                        i = 25;
                    }
                } else if (CDNProblemUploader.m414getInstance().getmCdnLogData() != null) {
                    i = CDNProblemUploader.m414getInstance().getmCdnLogData().getSlowRank();
                } else {
                    i = 10;
                }
            } else if (CDNProblemUploader.m414getInstance().getmCdnLogData() != null) {
                i = -CDNProblemUploader.m414getInstance().getmCdnLogData().getSuccRank();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.bQt.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.bQt);
                    }
                } else if (this.bQt.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.bQt);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.bQt.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    aan();
                    b(this.bQt);
                }
            } else if (this.bQt.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                aan();
                b(this.bQt);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.bQr;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.bQA;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.bQA = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (i.iN()) {
            return this.bQt.getIpString(i);
        }
        if (this.bQA.Sw) {
            return this.bQt.getMobileCdnIp(i);
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

    private CdnCacheItem T(byte[] bArr) {
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

    private CdnCacheItem aap() {
        String string = b.tr().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return T(c.decode(string));
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CdnCacheItem cdnCacheItem) {
        byte[] a;
        if (TbadkCoreApplication.m411getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String encodeBytes = c.encodeBytes(a);
                if (encodeBytes != null) {
                    b.tr().putString("cdn_iplist_cache_key_three", encodeBytes);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (i.iN()) {
            try {
                WifiManager wifiManager = (WifiManager) TbadkCoreApplication.m411getInst().getContext().getSystemService("wifi");
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
                return ((TelephonyManager) TbadkCoreApplication.m411getInst().getContext().getSystemService("phone")).getSubscriberId();
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean hasImageProblem() {
        return (this.bQt != null ? this.bQt.hasImageProblem() : false) || this.bQr;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.bQt.setIpDisableTime(i);
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
                            CDNIPDirectConnect.m413getInstance().normalUserStartTachometerCdnList();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.m413getInstance().normalUserStartTachometerCdnList();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
