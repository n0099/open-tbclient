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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.cdnOptimize.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.httpNet.e;
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
    private static volatile CDNIPDirectConnect bvu;
    private TbCdnMobileGetIpModel bvs;
    private long bvj = 0;
    private boolean bvk = false;
    private final float bvl = 100.0f;
    private CdnCacheItem bvm = null;
    private IPListReceiver bvn = null;
    private final long bvo = 3600000;
    private final long bvp = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long bvq = 10000;
    private final int bvr = 1003;
    public a bvt = null;
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
        if (bvu == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (bvu == null) {
                    bvu = new CDNIPDirectConnect();
                }
            }
        }
        return bvu;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void init() {
        try {
            this.bvt = new a();
            this.bvs = new TbCdnMobileGetIpModel();
            VV();
            this.bvn = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m411getInst().getApp().registerReceiver(this.bvn, intentFilter);
            if (TbadkCoreApplication.m411getInst().isMainProcess(true) && n.iW()) {
                try {
                    TbadkCoreApplication.m411getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.Wb = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void VV() {
        CdnCacheItem VW = VW();
        long currentTimeMillis = System.currentTimeMillis();
        if (VW != null && VW.firstUseIpTime > 0 && currentTimeMillis - VW.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.bvm = VW;
        }
        if (this.bvm == null) {
            this.bvm = new CdnCacheItem();
            this.bvm.firstUseIpTime = currentTimeMillis;
            this.bvm.identifier = getNetIdentifier();
        }
        if (0 == this.bvm.firstUseIpTime) {
            this.bvm.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.bvm.identifier == null || netIdentifier == null || this.bvm.identifier.equals(netIdentifier)) ? false : true;
        if (k.iI()) {
            if (this.bvm.lastTachometerTime == 0 || z || (this.bvm.getIsUsedIp() && currentTimeMillis - this.bvm.lastTachometerTime > 3600000)) {
                this.bvm.lastTachometerTime = currentTimeMillis;
                this.bvm.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m411getInst().getApp(), true, false);
            }
        } else if (this.bvm.mobileLastTachometerTime == 0 || z || (this.bvm.mobileIsUsedIp() && currentTimeMillis - this.bvm.mobileLastTachometerTime > 3600000)) {
            this.bvm.identifier = netIdentifier;
            VU();
        }
    }

    /* loaded from: classes.dex */
    class IPListReceiver extends BroadcastReceiver {
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
                    CDNIPDirectConnect.this.bvm.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.bvm);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.bvk = true;
                }
                CDNIPDirectConnect.this.bvm.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.bvm);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (g.eH(str)) {
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

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public HttpGet httpGetFactory(String str, int i, boolean z) {
        return z ? M(str, i) : N(str, i);
    }

    private HttpGet M(String str, int i) {
        String ipString;
        if (!this.bvm.getIsUsedIp() || (ipString = this.bvm.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.bvm.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return aK(str, ipString);
    }

    private HttpGet N(String str, int i) {
        String mobileCdnIp;
        if (!this.bvt.NF || (mobileCdnIp = this.bvm.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.bvm.mobileLastTachometerTime > 3600000) {
            VU();
        }
        return aK(str, mobileCdnIp);
    }

    private HttpGet aK(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && g.eG(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = g.eH(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    public void regetCdnIpList() {
        this.bvj = System.currentTimeMillis();
        this.bvm.lastTachometerTime = this.bvj;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m411getInst().getApp(), false, false);
    }

    private void VU() {
        if (this.bvt.NF) {
            this.bvm.mobileLastTachometerTime = System.currentTimeMillis();
            this.bvs.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!g.eI(str)) {
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
                    if (this.bvm.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.bvm);
                    }
                } else if (this.bvm.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.bvm);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.bvm.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    VU();
                    b(this.bvm);
                }
            } else if (this.bvm.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                VU();
                b(this.bvm);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public boolean isShouldCDNFallBack() {
        return this.bvk;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public a getCDNImageTimeData() {
        return this.bvt;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void setCDNImageTimeData(a aVar) {
        this.bvt = aVar;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public String getCachedCdnIp(int i) {
        if (k.iI()) {
            return this.bvm.getIpString(i);
        }
        if (this.bvt.NF) {
            return this.bvm.getMobileCdnIp(i);
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

    private CdnCacheItem C(byte[] bArr) {
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

    private CdnCacheItem VW() {
        String string = b.rB().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return C(c.decode(string));
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
                String m = c.m(a);
                if (m != null) {
                    b.rB().putString("cdn_iplist_cache_key_three", m);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (k.iI()) {
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

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public boolean hasImageProblem() {
        return (this.bvm != null ? this.bvm.hasImageProblem() : false) || this.bvk;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void setIpDisableTime(int i) {
        this.bvm.setIpDisableTime(i);
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
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
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
