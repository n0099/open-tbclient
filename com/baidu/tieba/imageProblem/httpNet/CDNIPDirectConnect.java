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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.util.h;
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
    private static volatile CDNIPDirectConnect dgM;
    private TbCdnMobileGetIpModel dgK;
    private long dgB = 0;
    private boolean dgC = false;
    private final float dgD = 100.0f;
    private CdnCacheItem dgE = null;
    private IPListReceiver dgF = null;
    private final long dgG = 3600000;
    private final long dgH = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long dgI = 10000;
    private final int dgJ = 1003;
    public a dgL = null;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CDNIPDirectConnect.m13getInstance().normalUserStartTachometerCdnList();
            }
        }
    };

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNIPDirectConnect m13getInstance() {
        if (dgM == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (dgM == null) {
                    dgM = new CDNIPDirectConnect();
                }
            }
        }
        return dgM;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.dgL = new a();
            this.dgK = new TbCdnMobileGetIpModel();
            auB();
            this.dgF = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m9getInst().getApp().registerReceiver(this.dgF, intentFilter);
            if (TbadkCoreApplication.m9getInst().isMainProcess(true) && k.fH()) {
                try {
                    TbadkCoreApplication.m9getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.YX = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void auB() {
        CdnCacheItem auC = auC();
        long currentTimeMillis = System.currentTimeMillis();
        if (auC != null && auC.firstUseIpTime > 0 && currentTimeMillis - auC.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.dgE = auC;
        }
        if (this.dgE == null) {
            this.dgE = new CdnCacheItem();
            this.dgE.firstUseIpTime = currentTimeMillis;
            this.dgE.identifier = getNetIdentifier();
        }
        if (0 == this.dgE.firstUseIpTime) {
            this.dgE.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.dgE.identifier == null || netIdentifier == null || this.dgE.identifier.equals(netIdentifier)) ? false : true;
        if (i.fs()) {
            if (this.dgE.lastTachometerTime == 0 || z || (this.dgE.getIsUsedIp() && currentTimeMillis - this.dgE.lastTachometerTime > 3600000)) {
                this.dgE.lastTachometerTime = currentTimeMillis;
                this.dgE.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m9getInst().getApp(), true, false);
            }
        } else if (this.dgE.mobileLastTachometerTime == 0 || z || (this.dgE.mobileIsUsedIp() && currentTimeMillis - this.dgE.mobileLastTachometerTime > 3600000)) {
            this.dgE.identifier = netIdentifier;
            auA();
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
                    CDNIPDirectConnect.this.dgE.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.dgE);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.dgC = true;
                }
                CDNIPDirectConnect.this.dgE.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.dgE);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (h.gn(str)) {
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
        return z ? aq(str, i) : ar(str, i);
    }

    private HttpGet aq(String str, int i) {
        String ipString;
        if (!this.dgE.getIsUsedIp() || (ipString = this.dgE.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.dgE.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return bl(str, ipString);
    }

    private HttpGet ar(String str, int i) {
        String mobileCdnIp;
        if (!this.dgL.KW || (mobileCdnIp = this.dgE.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.dgE.mobileLastTachometerTime > 3600000) {
            auA();
        }
        return bl(str, mobileCdnIp);
    }

    private HttpGet bl(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && h.gm(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = h.gn(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
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
        return this.dgE.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.dgB = System.currentTimeMillis();
        this.dgE.lastTachometerTime = this.dgB;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m9getInst().getApp(), false, false);
    }

    private void auA() {
        if (this.dgL.KW) {
            this.dgE.mobileLastTachometerTime = System.currentTimeMillis();
            this.dgK.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!h.go(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (CDNProblemUploader.m14getInstance().getmCdnLogData() != null) {
                        i = CDNProblemUploader.m14getInstance().getmCdnLogData().getErrRank();
                    } else {
                        i = 25;
                    }
                } else if (CDNProblemUploader.m14getInstance().getmCdnLogData() != null) {
                    i = CDNProblemUploader.m14getInstance().getmCdnLogData().getSlowRank();
                } else {
                    i = 10;
                }
            } else if (CDNProblemUploader.m14getInstance().getmCdnLogData() != null) {
                i = -CDNProblemUploader.m14getInstance().getmCdnLogData().getSuccRank();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.dgE.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.dgE);
                    }
                } else if (this.dgE.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.dgE);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.dgE.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    auA();
                    b(this.dgE);
                }
            } else if (this.dgE.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                auA();
                b(this.dgE);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.dgC;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.dgL;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.dgL = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (i.fs()) {
            return this.dgE.getIpString(i);
        }
        if (this.dgL.KW) {
            return this.dgE.getMobileCdnIp(i);
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

    private CdnCacheItem z(byte[] bArr) {
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

    private CdnCacheItem auC() {
        String string = b.sO().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return z(c.decode(string));
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
                    b.sO().putString("cdn_iplist_cache_key_three", encodeBytes);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (i.fs()) {
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
                if (ag.T(context)) {
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
        return (this.dgE != null ? this.dgE.hasImageProblem() : false) || this.dgC;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.dgE.setIpDisableTime(i);
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
                            CDNIPDirectConnect.m13getInstance().normalUserStartTachometerCdnList();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.m13getInstance().normalUserStartTachometerCdnList();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
