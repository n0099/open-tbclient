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
import d.a.c.e.p.c;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.n.a;
import d.a.m0.r.d0.b;
import d.a.m0.z0.o;
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
    public static volatile CDNIPDirectConnect f17767h;

    /* renamed from: e  reason: collision with root package name */
    public TbCdnMobileGetIpModel f17772e;

    /* renamed from: a  reason: collision with root package name */
    public long f17768a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17769b = false;

    /* renamed from: c  reason: collision with root package name */
    public CdnCacheItem f17770c = null;

    /* renamed from: d  reason: collision with root package name */
    public IPListReceiver f17771d = null;

    /* renamed from: f  reason: collision with root package name */
    public a f17773f = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: g  reason: collision with root package name */
    public final Handler f17774g = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
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
                CDNIPDirectConnect.this.f17770c.setMobileIpList(stringArrayListExtra);
                CDNIPDirectConnect cDNIPDirectConnect = CDNIPDirectConnect.this;
                cDNIPDirectConnect.k(cDNIPDirectConnect.f17770c);
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
            int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
            int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
            if ((1 == intExtra || 2 == intExtra) && size > 0) {
                z = true;
            } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                CDNIPDirectConnect.this.f17769b = true;
            }
            CDNIPDirectConnect.this.f17770c.setIpList(stringArrayListExtra, booleanExtra, z);
            if (size > 0) {
                CDNIPDirectConnect cDNIPDirectConnect2 = CDNIPDirectConnect.this;
                cDNIPDirectConnect2.k(cDNIPDirectConnect2.f17770c);
            }
        }
    }

    public static CDNIPDirectConnect getInstance() {
        if (f17767h == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (f17767h == null) {
                    f17767h = new CDNIPDirectConnect();
                }
            }
        }
        return f17767h;
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
                this.f17770c = g2;
            }
        }
        if (this.f17770c == null) {
            CdnCacheItem cdnCacheItem = new CdnCacheItem();
            this.f17770c = cdnCacheItem;
            cdnCacheItem.firstUseIpTime = currentTimeMillis;
            cdnCacheItem.identifier = getNetIdentifier();
        }
        CdnCacheItem cdnCacheItem2 = this.f17770c;
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
        return this.f17770c.getAllIpFromItem();
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public a getCDNImageTimeData() {
        return this.f17773f;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public String getCachedCdnIp(int i2) {
        if (j.H()) {
            return this.f17770c.getIpString(i2);
        }
        if (this.f17773f.f53264g) {
            return this.f17770c.getMobileCdnIp(i2);
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
        if (this.f17773f.f53264g) {
            this.f17770c.mobileLastTachometerTime = System.currentTimeMillis();
            this.f17772e.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public boolean hasImageProblem() {
        CdnCacheItem cdnCacheItem = this.f17770c;
        return (cdnCacheItem != null ? cdnCacheItem.hasImageProblem() : false) || this.f17769b;
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
            this.f17773f = new a();
            this.f17772e = new TbCdnMobileGetIpModel();
            f();
            this.f17771d = new IPListReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.getInst().getApp().registerReceiver(this.f17771d, intentFilter);
            if (TbadkCoreApplication.getInst().isMainProcess(true) && l.C()) {
                try {
                    TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            this.f17774g.sendEmptyMessageDelayed(1003, 10000L);
            this.isAlreadyInit = true;
        } catch (Exception e3) {
            BdLog.e(e3);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public boolean isShouldCDNFallBack() {
        return this.f17769b;
    }

    public final HttpGet j(String str, int i2) {
        String mobileCdnIp;
        if (this.f17773f.f53264g && (mobileCdnIp = this.f17770c.getMobileCdnIp(i2)) != null) {
            if (System.currentTimeMillis() - this.f17770c.mobileLastTachometerTime > 3600000) {
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

    public final HttpGet l(String str, int i2) {
        String ipString;
        if (this.f17770c.getIsUsedIp() && (ipString = this.f17770c.getIpString(i2)) != null) {
            if (System.currentTimeMillis() - this.f17770c.lastTachometerTime > 3600000) {
                regetCdnIpList();
            }
            return i(str, ipString);
        }
        return new HttpGet(str);
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        String str = this.f17770c.identifier;
        boolean z = (str == null || netIdentifier == null || str.equals(netIdentifier)) ? false : true;
        if (j.H()) {
            CdnCacheItem cdnCacheItem = this.f17770c;
            if (cdnCacheItem.lastTachometerTime == 0 || z || (cdnCacheItem.getIsUsedIp() && currentTimeMillis - this.f17770c.lastTachometerTime > 3600000)) {
                CdnCacheItem cdnCacheItem2 = this.f17770c;
                cdnCacheItem2.lastTachometerTime = currentTimeMillis;
                cdnCacheItem2.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
                return;
            }
            return;
        }
        CdnCacheItem cdnCacheItem3 = this.f17770c;
        if (cdnCacheItem3.mobileLastTachometerTime == 0 || z || (cdnCacheItem3.mobileIsUsedIp() && currentTimeMillis - this.f17770c.mobileLastTachometerTime > 3600000)) {
            this.f17770c.identifier = netIdentifier;
            h();
        }
    }

    public void regetCdnIpList() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f17768a = currentTimeMillis;
        this.f17770c.lastTachometerTime = currentTimeMillis;
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
                if (this.f17770c.setIPRank(d2, 100.0f, str2) >= 100.0f) {
                    regetCdnIpList();
                    k(this.f17770c);
                }
            } else if (this.f17770c.setCdnDomainRank(d2, 100.0f) >= 100.0f) {
                regetCdnIpList();
                k(this.f17770c);
            }
        } else if (str2 != null && str2.length() > 0) {
            if (this.f17770c.setMoblieIPRank(d2, 100.0f, str2) >= 100.0f) {
                h();
                k(this.f17770c);
            }
        } else if (this.f17770c.setMoblieIPRank(d2, 100.0f, null) >= 100.0f) {
            h();
            k(this.f17770c);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void setCDNImageTimeData(a aVar) {
        this.f17773f = aVar;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void setIpDisableTime(int i2) {
        this.f17770c.setIpDisableTime(i2);
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public HttpGet httpGetFactory(String str, int i2, boolean z) {
        if (z) {
            return l(str, i2);
        }
        return j(str, i2);
    }
}
