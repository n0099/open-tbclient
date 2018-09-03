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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.g.a;
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
/* loaded from: classes2.dex */
public class CDNIPDirectConnect extends e {
    private static volatile CDNIPDirectConnect eLn;
    private TbCdnMobileGetIpModel eLl;
    private long eLc = 0;
    private boolean eLd = false;
    private final float eLe = 100.0f;
    private CdnCacheItem eLf = null;
    private IPListReceiver eLg = null;
    private final long eLh = 3600000;
    private final long eLi = 604800000;
    private final long eLj = 10000;
    private final int eLk = 1003;
    public a eLm = null;
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
        if (eLn == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (eLn == null) {
                    eLn = new CDNIPDirectConnect();
                }
            }
        }
        return eLn;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.eLm = new a();
            this.eLl = new TbCdnMobileGetIpModel();
            aQc();
            this.eLg = new IPListReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.getInst().getApp().registerReceiver(this.eLg, intentFilter);
            if (TbadkCoreApplication.getInst().isMainProcess(true) && l.jU()) {
                try {
                    TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.arY = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void aQc() {
        CdnCacheItem aQd = aQd();
        long currentTimeMillis = System.currentTimeMillis();
        if (aQd != null && aQd.firstUseIpTime > 0 && currentTimeMillis - aQd.firstUseIpTime < 604800000) {
            this.eLf = aQd;
        }
        if (this.eLf == null) {
            this.eLf = new CdnCacheItem();
            this.eLf.firstUseIpTime = currentTimeMillis;
            this.eLf.identifier = getNetIdentifier();
        }
        if (0 == this.eLf.firstUseIpTime) {
            this.eLf.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.eLf.identifier == null || netIdentifier == null || this.eLf.identifier.equals(netIdentifier)) ? false : true;
        if (j.jF()) {
            if (this.eLf.lastTachometerTime == 0 || z || (this.eLf.getIsUsedIp() && currentTimeMillis - this.eLf.lastTachometerTime > 3600000)) {
                this.eLf.lastTachometerTime = currentTimeMillis;
                this.eLf.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
            }
        } else if (this.eLf.mobileLastTachometerTime == 0 || z || (this.eLf.mobileIsUsedIp() && currentTimeMillis - this.eLf.mobileLastTachometerTime > 3600000)) {
            this.eLf.identifier = netIdentifier;
            aQb();
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
                    CDNIPDirectConnect.this.eLf.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.eLf);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.eLd = true;
                }
                CDNIPDirectConnect.this.eLf.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size > 0) {
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.eLf);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (h.hw(str)) {
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

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, int i, boolean z) {
        return z ? at(str, i) : au(str, i);
    }

    private HttpGet at(String str, int i) {
        String ipString;
        if (!this.eLf.getIsUsedIp() || (ipString = this.eLf.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.eLf.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return by(str, ipString);
    }

    private HttpGet au(String str, int i) {
        String mobileCdnIp;
        if (!this.eLm.abA || (mobileCdnIp = this.eLf.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.eLf.mobileLastTachometerTime > 3600000) {
            aQb();
        }
        return by(str, mobileCdnIp);
    }

    private HttpGet by(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && h.hv(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = h.hw(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
                HttpGet httpGet = new HttpGet(url.getProtocol() + "://" + str2 + url.getPath());
                httpGet.addHeader("Host", host);
                return httpGet;
            } catch (Exception e) {
            }
        }
        return new HttpGet(str);
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getAllIPListCanUsed() {
        return this.eLf.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.eLc = System.currentTimeMillis();
        this.eLf.lastTachometerTime = this.eLc;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), false, false);
    }

    private void aQb() {
        if (this.eLm.abA) {
            this.eLf.mobileLastTachometerTime = System.currentTimeMillis();
            this.eLl.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!h.hx(str)) {
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
                    if (this.eLf.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.eLf);
                    }
                } else if (this.eLf.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.eLf);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.eLf.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    aQb();
                    b(this.eLf);
                }
            } else if (this.eLf.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                aQb();
                b(this.eLf);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.eLd;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.eLm;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.eLm = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (j.jF()) {
            return this.eLf.getIpString(i);
        }
        if (this.eLm.abA) {
            return this.eLf.getMobileCdnIp(i);
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

    private CdnCacheItem aQd() {
        String string = b.getInstance().getString("cdn_iplist_cache_key_three", "");
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
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
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
        if (j.jF()) {
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
                if (ac.aP(context)) {
                    return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean hasImageProblem() {
        return (this.eLf != null ? this.eLf.hasImageProblem() : false) || this.eLd;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.eLf.setIpDisableTime(i);
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
