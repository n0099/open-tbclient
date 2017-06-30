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
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.e.a;
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
/* loaded from: classes2.dex */
public class CDNIPDirectConnect extends e {
    private static volatile CDNIPDirectConnect dxg;
    private TbCdnMobileGetIpModel dxe;
    private long dwV = 0;
    private boolean dwW = false;
    private final float dwX = 100.0f;
    private CdnCacheItem dwY = null;
    private IPListReceiver dwZ = null;
    private final long dxa = 3600000;
    private final long dxb = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long dxc = 10000;
    private final int dxd = 1003;
    public a dxf = null;
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
        if (dxg == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (dxg == null) {
                    dxg = new CDNIPDirectConnect();
                }
            }
        }
        return dxg;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.dxf = new a();
            this.dxe = new TbCdnMobileGetIpModel();
            ayA();
            this.dwZ = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m9getInst().getApp().registerReceiver(this.dwZ, intentFilter);
            if (TbadkCoreApplication.m9getInst().isMainProcess(true) && k.hz()) {
                try {
                    TbadkCoreApplication.m9getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.ahf = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void ayA() {
        CdnCacheItem ayB = ayB();
        long currentTimeMillis = System.currentTimeMillis();
        if (ayB != null && ayB.firstUseIpTime > 0 && currentTimeMillis - ayB.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.dwY = ayB;
        }
        if (this.dwY == null) {
            this.dwY = new CdnCacheItem();
            this.dwY.firstUseIpTime = currentTimeMillis;
            this.dwY.identifier = getNetIdentifier();
        }
        if (0 == this.dwY.firstUseIpTime) {
            this.dwY.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.dwY.identifier == null || netIdentifier == null || this.dwY.identifier.equals(netIdentifier)) ? false : true;
        if (i.hk()) {
            if (this.dwY.lastTachometerTime == 0 || z || (this.dwY.getIsUsedIp() && currentTimeMillis - this.dwY.lastTachometerTime > 3600000)) {
                this.dwY.lastTachometerTime = currentTimeMillis;
                this.dwY.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m9getInst().getApp(), true, false);
            }
        } else if (this.dwY.mobileLastTachometerTime == 0 || z || (this.dwY.mobileIsUsedIp() && currentTimeMillis - this.dwY.mobileLastTachometerTime > 3600000)) {
            this.dwY.identifier = netIdentifier;
            ayz();
        }
    }

    /* loaded from: classes2.dex */
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
                    CDNIPDirectConnect.this.dwY.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.dwY);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.dwW = true;
                }
                CDNIPDirectConnect.this.dwY.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.dwY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (com.baidu.tbadk.util.i.gx(str)) {
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
        return z ? ah(str, i) : ai(str, i);
    }

    private HttpGet ah(String str, int i) {
        String ipString;
        if (!this.dwY.getIsUsedIp() || (ipString = this.dwY.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.dwY.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return bq(str, ipString);
    }

    private HttpGet ai(String str, int i) {
        String mobileCdnIp;
        if (!this.dxf.QR || (mobileCdnIp = this.dwY.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.dwY.mobileLastTachometerTime > 3600000) {
            ayz();
        }
        return bq(str, mobileCdnIp);
    }

    private HttpGet bq(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && com.baidu.tbadk.util.i.gw(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = com.baidu.tbadk.util.i.gx(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
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
        return this.dwY.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.dwV = System.currentTimeMillis();
        this.dwY.lastTachometerTime = this.dwV;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m9getInst().getApp(), false, false);
    }

    private void ayz() {
        if (this.dxf.QR) {
            this.dwY.mobileLastTachometerTime = System.currentTimeMillis();
            this.dxe.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!com.baidu.tbadk.util.i.gy(str)) {
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
                    if (this.dwY.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.dwY);
                    }
                } else if (this.dwY.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.dwY);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.dwY.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    ayz();
                    b(this.dwY);
                }
            } else if (this.dwY.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                ayz();
                b(this.dwY);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.dwW;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.dxf;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.dxf = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (i.hk()) {
            return this.dwY.getIpString(i);
        }
        if (this.dxf.QR) {
            return this.dwY.getMobileCdnIp(i);
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

    private CdnCacheItem ayB() {
        String string = b.getInstance().getString("cdn_iplist_cache_key_three", "");
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
                    b.getInstance().putString("cdn_iplist_cache_key_three", encodeBytes);
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
                if (ag.aG(context)) {
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
        return (this.dwY != null ? this.dwY.hasImageProblem() : false) || this.dwW;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.dwY.setIpDisableTime(i);
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
