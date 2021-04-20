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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.b.c.e.p.c;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.h0.n.a;
import d.b.h0.r.d0.b;
import d.b.h0.z0.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes4.dex */
public class CDNIPDirectConnect extends ICDNIPDirectConnect {

    /* renamed from: h  reason: collision with root package name */
    public static volatile CDNIPDirectConnect f18112h;

    /* renamed from: e  reason: collision with root package name */
    public TbCdnMobileGetIpModel f18117e;

    /* renamed from: a  reason: collision with root package name */
    public long f18113a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f18114b = false;

    /* renamed from: c  reason: collision with root package name */
    public CdnCacheItem f18115c = null;

    /* renamed from: d  reason: collision with root package name */
    public IPListReceiver f18116d = null;

    /* renamed from: f  reason: collision with root package name */
    public a f18118f = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: g  reason: collision with root package name */
    public final Handler f18119g = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CDNIPDirectConnect.getInstance().normalUserStartTachometerCdnList();
            }
        }
    };

    /* loaded from: classes4.dex */
    public class CDNNetworkChangeReceiver extends BroadcastReceiver {
        public static final int MOBILE = 2;
        public static final int NOTSET = -1;
        public static final int WIFI = 1;
        public static final String WIFI_STRING = "WIFI";
        public int NETWORK_STATUS = -1;

        public CDNNetworkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
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

    /* loaded from: classes4.dex */
    public class IPListReceiver extends BroadcastReceiver {
        public IPListReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
                return;
            }
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
            boolean z = false;
            if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                CDNIPDirectConnect.this.f18115c.setMobileIpList(stringArrayListExtra);
                CDNIPDirectConnect cDNIPDirectConnect = CDNIPDirectConnect.this;
                cDNIPDirectConnect.k(cDNIPDirectConnect.f18115c);
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
            int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
            int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
            if ((1 == intExtra || 2 == intExtra) && size > 0) {
                z = true;
            } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                CDNIPDirectConnect.this.f18114b = true;
            }
            CDNIPDirectConnect.this.f18115c.setIpList(stringArrayListExtra, booleanExtra, z);
            if (size > 0) {
                CDNIPDirectConnect cDNIPDirectConnect2 = CDNIPDirectConnect.this;
                cDNIPDirectConnect2.k(cDNIPDirectConnect2.f18115c);
            }
        }
    }

    public static CDNIPDirectConnect getInstance() {
        if (f18112h == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (f18112h == null) {
                    f18112h = new CDNIPDirectConnect();
                }
            }
        }
        return f18112h;
    }

    public final CdnCacheItem d(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                byteArrayInputStream.close();
                if (readObject instanceof CdnCacheItem) {
                    return (CdnCacheItem) readObject;
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return null;
    }

    public final byte[] e(CdnCacheItem cdnCacheItem) {
        if (cdnCacheItem != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(cdnCacheItem);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                objectOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return null;
    }

    public final void f() {
        CdnCacheItem g2 = g();
        long currentTimeMillis = System.currentTimeMillis();
        if (g2 != null) {
            long j = g2.firstUseIpTime;
            if (j > 0 && currentTimeMillis - j < 604800000) {
                this.f18115c = g2;
            }
        }
        if (this.f18115c == null) {
            CdnCacheItem cdnCacheItem = new CdnCacheItem();
            this.f18115c = cdnCacheItem;
            cdnCacheItem.firstUseIpTime = currentTimeMillis;
            cdnCacheItem.identifier = getNetIdentifier();
        }
        CdnCacheItem cdnCacheItem2 = this.f18115c;
        if (0 == cdnCacheItem2.firstUseIpTime) {
            cdnCacheItem2.firstUseIpTime = currentTimeMillis;
        }
    }

    public final CdnCacheItem g() {
        String p = b.j().p("cdn_iplist_cache_key_three", "");
        if (p != null && p.length() != 0) {
            try {
                return d(c.d(p));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public String getAllIPListCanUsed() {
        return this.f18115c.getAllIpFromItem();
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public a getCDNImageTimeData() {
        return this.f18118f;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public String getCachedCdnIp(int i) {
        if (j.H()) {
            return this.f18115c.getIpString(i);
        }
        if (this.f18118f.f50776g) {
            return this.f18115c.getMobileCdnIp(i);
        }
        return null;
    }

    public String getNetIdentifier() {
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            if (j.H()) {
                try {
                    WifiManager wifiManager = (WifiManager) TbadkCoreApplication.getInst().getContext().getSystemService("wifi");
                    if (!wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(true);
                    }
                    return wifiManager.getConnectionInfo().getSSID();
                } catch (Error e2) {
                    BdLog.e(e2);
                    return null;
                } catch (Exception e3) {
                    BdLog.e(e3);
                    return null;
                }
            }
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                if (PermissionUtil.checkReadPhoneState(context)) {
                    return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                }
                return null;
            } catch (Exception e4) {
                BdLog.e(e4);
                return null;
            }
        }
        return "";
    }

    public final void h() {
        if (this.f18118f.f50776g) {
            this.f18115c.mobileLastTachometerTime = System.currentTimeMillis();
            this.f18117e.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public boolean hasImageProblem() {
        CdnCacheItem cdnCacheItem = this.f18115c;
        return (cdnCacheItem != null ? cdnCacheItem.hasImageProblem() : false) || this.f18114b;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0 && o.b(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", str3);
                return httpGet;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final HttpGet i(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && o.a(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = url.getHost();
                if (o.b(str)) {
                    host = "tbcdn.hiphotos.baidu.com";
                }
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception unused) {
            }
        }
        return new HttpGet(str);
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void init() {
        try {
            this.f18118f = new a();
            this.f18117e = new TbCdnMobileGetIpModel();
            f();
            this.f18116d = new IPListReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.getInst().getApp().registerReceiver(this.f18116d, intentFilter);
            if (TbadkCoreApplication.getInst().isMainProcess(true) && l.B()) {
                try {
                    TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f18119g.sendEmptyMessageDelayed(1003, 10000L);
            this.isAlreadyInit = true;
        } catch (Exception e3) {
            BdLog.e(e3);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public boolean isShouldCDNFallBack() {
        return this.f18114b;
    }

    public final HttpGet j(String str, int i) {
        String mobileCdnIp;
        if (this.f18118f.f50776g && (mobileCdnIp = this.f18115c.getMobileCdnIp(i)) != null) {
            if (System.currentTimeMillis() - this.f18115c.mobileLastTachometerTime > VideoCloudSetting.HOUR_MILLISECOND) {
                h();
            }
            return i(str, mobileCdnIp);
        }
        return new HttpGet(str);
    }

    public final void k(CdnCacheItem cdnCacheItem) {
        byte[] e2;
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (e2 = e(cdnCacheItem)) != null && e2.length > 0) {
            try {
                String j = c.j(e2);
                if (j != null) {
                    b.j().x("cdn_iplist_cache_key_three", j);
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public final HttpGet l(String str, int i) {
        String ipString;
        if (this.f18115c.getIsUsedIp() && (ipString = this.f18115c.getIpString(i)) != null) {
            if (System.currentTimeMillis() - this.f18115c.lastTachometerTime > VideoCloudSetting.HOUR_MILLISECOND) {
                regetCdnIpList();
            }
            return i(str, ipString);
        }
        return new HttpGet(str);
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        String str = this.f18115c.identifier;
        boolean z = (str == null || netIdentifier == null || str.equals(netIdentifier)) ? false : true;
        if (j.H()) {
            CdnCacheItem cdnCacheItem = this.f18115c;
            if (cdnCacheItem.lastTachometerTime == 0 || z || (cdnCacheItem.getIsUsedIp() && currentTimeMillis - this.f18115c.lastTachometerTime > VideoCloudSetting.HOUR_MILLISECOND)) {
                CdnCacheItem cdnCacheItem2 = this.f18115c;
                cdnCacheItem2.lastTachometerTime = currentTimeMillis;
                cdnCacheItem2.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
                return;
            }
            return;
        }
        CdnCacheItem cdnCacheItem3 = this.f18115c;
        if (cdnCacheItem3.mobileLastTachometerTime == 0 || z || (cdnCacheItem3.mobileIsUsedIp() && currentTimeMillis - this.f18115c.mobileLastTachometerTime > VideoCloudSetting.HOUR_MILLISECOND)) {
            this.f18115c.identifier = netIdentifier;
            h();
        }
    }

    public void regetCdnIpList() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f18113a = currentTimeMillis;
        this.f18115c.lastTachometerTime = currentTimeMillis;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), false, false);
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int d2;
        if (o.c(str)) {
            return;
        }
        if (!z2 && z) {
            d2 = CDNProblemUploader.getInstance().getmCdnLogData() != null ? -CDNProblemUploader.getInstance().getmCdnLogData().e() : -25;
        } else if (!z) {
            d2 = CDNProblemUploader.getInstance().getmCdnLogData() != null ? CDNProblemUploader.getInstance().getmCdnLogData().b() : 25;
        } else {
            d2 = CDNProblemUploader.getInstance().getmCdnLogData() != null ? CDNProblemUploader.getInstance().getmCdnLogData().d() : 10;
        }
        if (z3) {
            if (str2 != null && str2.length() > 0) {
                if (this.f18115c.setIPRank(d2, 100.0f, str2) >= 100.0f) {
                    regetCdnIpList();
                    k(this.f18115c);
                }
            } else if (this.f18115c.setCdnDomainRank(d2, 100.0f) >= 100.0f) {
                regetCdnIpList();
                k(this.f18115c);
            }
        } else if (str2 != null && str2.length() > 0) {
            if (this.f18115c.setMoblieIPRank(d2, 100.0f, str2) >= 100.0f) {
                h();
                k(this.f18115c);
            }
        } else if (this.f18115c.setMoblieIPRank(d2, 100.0f, null) >= 100.0f) {
            h();
            k(this.f18115c);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void setCDNImageTimeData(a aVar) {
        this.f18118f = aVar;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void setIpDisableTime(int i) {
        this.f18115c.setIpDisableTime(i);
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public HttpGet httpGetFactory(String str, int i, boolean z) {
        if (z) {
            return l(str, i);
        }
        return j(str, i);
    }
}
