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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.a.e;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.g.a;
import com.baidu.tbadk.util.i;
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
/* loaded from: classes4.dex */
public class CDNIPDirectConnect extends e {
    private static volatile CDNIPDirectConnect faq;
    private TbCdnMobileGetIpModel fao;
    private long faf = 0;
    private boolean fag = false;
    private final float fah = 100.0f;
    private CdnCacheItem fai = null;
    private IPListReceiver faj = null;
    private final long fak = 3600000;
    private final long fal = 604800000;
    private final long fam = ErrDef.Feature.WEIGHT;
    private final int fan = 1003;
    public a fap = null;
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
        if (faq == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (faq == null) {
                    faq = new CDNIPDirectConnect();
                }
            }
        }
        return faq;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.fap = new a();
            this.fao = new TbCdnMobileGetIpModel();
            aVE();
            this.faj = new IPListReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.getInst().getApp().registerReceiver(this.faj, intentFilter);
            if (TbadkCoreApplication.getInst().isMainProcess(true) && l.ln()) {
                try {
                    TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, ErrDef.Feature.WEIGHT);
            this.azh = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void aVE() {
        CdnCacheItem aVF = aVF();
        long currentTimeMillis = System.currentTimeMillis();
        if (aVF != null && aVF.firstUseIpTime > 0 && currentTimeMillis - aVF.firstUseIpTime < 604800000) {
            this.fai = aVF;
        }
        if (this.fai == null) {
            this.fai = new CdnCacheItem();
            this.fai.firstUseIpTime = currentTimeMillis;
            this.fai.identifier = getNetIdentifier();
        }
        if (0 == this.fai.firstUseIpTime) {
            this.fai.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.fai.identifier == null || netIdentifier == null || this.fai.identifier.equals(netIdentifier)) ? false : true;
        if (j.kY()) {
            if (this.fai.lastTachometerTime == 0 || z || (this.fai.getIsUsedIp() && currentTimeMillis - this.fai.lastTachometerTime > 3600000)) {
                this.fai.lastTachometerTime = currentTimeMillis;
                this.fai.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
            }
        } else if (this.fai.mobileLastTachometerTime == 0 || z || (this.fai.mobileIsUsedIp() && currentTimeMillis - this.fai.mobileLastTachometerTime > 3600000)) {
            this.fai.identifier = netIdentifier;
            aVD();
        }
    }

    /* loaded from: classes4.dex */
    private class IPListReceiver extends BroadcastReceiver {
        private IPListReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
                if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                    CDNIPDirectConnect.this.fai.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.fai);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.fag = true;
                }
                CDNIPDirectConnect.this.fai.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size > 0) {
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.fai);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (i.ii(str)) {
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
        return z ? aC(str, i) : aD(str, i);
    }

    private HttpGet aC(String str, int i) {
        String ipString;
        if (!this.fai.getIsUsedIp() || (ipString = this.fai.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.fai.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return bS(str, ipString);
    }

    private HttpGet aD(String str, int i) {
        String mobileCdnIp;
        if (!this.fap.aiZ || (mobileCdnIp = this.fai.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.fai.mobileLastTachometerTime > 3600000) {
            aVD();
        }
        return bS(str, mobileCdnIp);
    }

    private HttpGet bS(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && i.ih(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = i.ii(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
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
        return this.fai.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.faf = System.currentTimeMillis();
        this.fai.lastTachometerTime = this.faf;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), false, false);
    }

    private void aVD() {
        if (this.fap.aiZ) {
            this.fai.mobileLastTachometerTime = System.currentTimeMillis();
            this.fao.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!i.ij(str)) {
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
                    if (this.fai.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.fai);
                    }
                } else if (this.fai.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.fai);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.fai.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    aVD();
                    b(this.fai);
                }
            } else if (this.fai.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                aVD();
                b(this.fai);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.fag;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.fap;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.fap = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (j.kY()) {
            return this.fai.getIpString(i);
        }
        if (this.fap.aiZ) {
            return this.fai.getMobileCdnIp(i);
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

    private CdnCacheItem L(byte[] bArr) {
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

    private CdnCacheItem aVF() {
        String string = b.getInstance().getString("cdn_iplist_cache_key_three", "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return L(c.decode(string));
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
        if (j.kY()) {
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
                if (ab.bD(context)) {
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
        return (this.fai != null ? this.fai.hasImageProblem() : false) || this.fag;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.fai.setIpDisableTime(i);
    }

    /* loaded from: classes4.dex */
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
