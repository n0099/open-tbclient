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
    private static volatile CDNIPDirectConnect bys;
    private TbCdnMobileGetIpModel byq;
    private long byh = 0;
    private boolean byi = false;
    private final float byj = 100.0f;
    private CdnCacheItem byk = null;
    private IPListReceiver byl = null;
    private final long bym = 3600000;
    private final long byn = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long byo = 10000;
    private final int byp = 1003;
    public a byr = null;
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
        if (bys == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (bys == null) {
                    bys = new CDNIPDirectConnect();
                }
            }
        }
        return bys;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void init() {
        try {
            this.byr = new a();
            this.byq = new TbCdnMobileGetIpModel();
            XA();
            this.byl = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m411getInst().getApp().registerReceiver(this.byl, intentFilter);
            if (TbadkCoreApplication.m411getInst().isMainProcess(true) && n.jl()) {
                try {
                    TbadkCoreApplication.m411getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.WL = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void XA() {
        CdnCacheItem XB = XB();
        long currentTimeMillis = System.currentTimeMillis();
        if (XB != null && XB.firstUseIpTime > 0 && currentTimeMillis - XB.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.byk = XB;
        }
        if (this.byk == null) {
            this.byk = new CdnCacheItem();
            this.byk.firstUseIpTime = currentTimeMillis;
            this.byk.identifier = getNetIdentifier();
        }
        if (0 == this.byk.firstUseIpTime) {
            this.byk.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.byk.identifier == null || netIdentifier == null || this.byk.identifier.equals(netIdentifier)) ? false : true;
        if (k.iY()) {
            if (this.byk.lastTachometerTime == 0 || z || (this.byk.getIsUsedIp() && currentTimeMillis - this.byk.lastTachometerTime > 3600000)) {
                this.byk.lastTachometerTime = currentTimeMillis;
                this.byk.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m411getInst().getApp(), true, false);
            }
        } else if (this.byk.mobileLastTachometerTime == 0 || z || (this.byk.mobileIsUsedIp() && currentTimeMillis - this.byk.mobileLastTachometerTime > 3600000)) {
            this.byk.identifier = netIdentifier;
            Xz();
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
                    CDNIPDirectConnect.this.byk.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.byk);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.byi = true;
                }
                CDNIPDirectConnect.this.byk.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.byk);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (g.ff(str)) {
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
        if (!this.byk.getIsUsedIp() || (ipString = this.byk.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.byk.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return aP(str, ipString);
    }

    private HttpGet N(String str, int i) {
        String mobileCdnIp;
        if (!this.byr.NZ || (mobileCdnIp = this.byk.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.byk.mobileLastTachometerTime > 3600000) {
            Xz();
        }
        return aP(str, mobileCdnIp);
    }

    private HttpGet aP(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && g.fe(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = g.ff(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(String.valueOf(url.getProtocol()) + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    public void regetCdnIpList() {
        this.byh = System.currentTimeMillis();
        this.byk.lastTachometerTime = this.byh;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m411getInst().getApp(), false, false);
    }

    private void Xz() {
        if (this.byr.NZ) {
            this.byk.mobileLastTachometerTime = System.currentTimeMillis();
            this.byq.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!g.fg(str)) {
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
                    if (this.byk.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.byk);
                    }
                } else if (this.byk.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.byk);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.byk.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    Xz();
                    b(this.byk);
                }
            } else if (this.byk.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                Xz();
                b(this.byk);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public boolean isShouldCDNFallBack() {
        return this.byi;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public a getCDNImageTimeData() {
        return this.byr;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void setCDNImageTimeData(a aVar) {
        this.byr = aVar;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public String getCachedCdnIp(int i) {
        if (k.iY()) {
            return this.byk.getIpString(i);
        }
        if (this.byr.NZ) {
            return this.byk.getMobileCdnIp(i);
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

    private CdnCacheItem XB() {
        String string = b.sl().getString("cdn_iplist_cache_key_three", "");
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
                    b.sl().putString("cdn_iplist_cache_key_three", m);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (k.iY()) {
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
        return (this.byk != null ? this.byk.hasImageProblem() : false) || this.byi;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.e
    public void setIpDisableTime(int i) {
        this.byk.setIpDisableTime(i);
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
