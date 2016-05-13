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
    private static volatile CDNIPDirectConnect cBp;
    private TbCdnMobileGetIpModel cBn;
    private long cBe = 0;
    private boolean cBf = false;
    private final float cBg = 100.0f;
    private CdnCacheItem cBh = null;
    private IPListReceiver cBi = null;
    private final long cBj = 3600000;
    private final long cBk = TbConfig.APP_OVERDUR_DRAFT_BOX;
    private final long cBl = 10000;
    private final int cBm = 1003;
    public a cBo = null;
    private final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1003) {
                CDNIPDirectConnect.m19getInstance().normalUserStartTachometerCdnList();
            }
        }
    };

    /* renamed from: getInstance  reason: collision with other method in class */
    public static CDNIPDirectConnect m19getInstance() {
        if (cBp == null) {
            synchronized (CDNIPDirectConnect.class) {
                if (cBp == null) {
                    cBp = new CDNIPDirectConnect();
                }
            }
        }
        return cBp;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void init() {
        try {
            this.cBo = new a();
            this.cBn = new TbCdnMobileGetIpModel();
            amp();
            this.cBi = new IPListReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
            TbadkCoreApplication.m11getInst().getApp().registerReceiver(this.cBi, intentFilter);
            if (TbadkCoreApplication.m11getInst().isMainProcess(true) && k.fG()) {
                try {
                    TbadkCoreApplication.m11getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            this.handler.sendEmptyMessageDelayed(1003, 10000L);
            this.YG = true;
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    private void amp() {
        CdnCacheItem amq = amq();
        long currentTimeMillis = System.currentTimeMillis();
        if (amq != null && amq.firstUseIpTime > 0 && currentTimeMillis - amq.firstUseIpTime < TbConfig.APP_OVERDUR_DRAFT_BOX) {
            this.cBh = amq;
        }
        if (this.cBh == null) {
            this.cBh = new CdnCacheItem();
            this.cBh.firstUseIpTime = currentTimeMillis;
            this.cBh.identifier = getNetIdentifier();
        }
        if (0 == this.cBh.firstUseIpTime) {
            this.cBh.firstUseIpTime = currentTimeMillis;
        }
    }

    public void normalUserStartTachometerCdnList() {
        long currentTimeMillis = System.currentTimeMillis();
        String netIdentifier = getNetIdentifier();
        boolean z = (this.cBh.identifier == null || netIdentifier == null || this.cBh.identifier.equals(netIdentifier)) ? false : true;
        if (i.fr()) {
            if (this.cBh.lastTachometerTime == 0 || z || (this.cBh.getIsUsedIp() && currentTimeMillis - this.cBh.lastTachometerTime > 3600000)) {
                this.cBh.lastTachometerTime = currentTimeMillis;
                this.cBh.identifier = netIdentifier;
                TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m11getInst().getApp(), true, false);
            }
        } else if (this.cBh.mobileLastTachometerTime == 0 || z || (this.cBh.mobileIsUsedIp() && currentTimeMillis - this.cBh.mobileLastTachometerTime > 3600000)) {
            this.cBh.identifier = netIdentifier;
            amo();
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
                    CDNIPDirectConnect.this.cBh.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.cBh);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    CDNIPDirectConnect.this.cBf = true;
                }
                CDNIPDirectConnect.this.cBh.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size <= 0) {
                    return;
                }
                CDNIPDirectConnect.this.b(CDNIPDirectConnect.this.cBh);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        if (h.gh(str)) {
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
        return z ? aj(str, i) : ak(str, i);
    }

    private HttpGet aj(String str, int i) {
        String ipString;
        if (!this.cBh.getIsUsedIp() || (ipString = this.cBh.getIpString(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.cBh.lastTachometerTime > 3600000) {
            regetCdnIpList();
        }
        return bl(str, ipString);
    }

    private HttpGet ak(String str, int i) {
        String mobileCdnIp;
        if (!this.cBo.KW || (mobileCdnIp = this.cBh.getMobileCdnIp(i)) == null) {
            return new HttpGet(str);
        }
        if (System.currentTimeMillis() - this.cBh.mobileLastTachometerTime > 3600000) {
            amo();
        }
        return bl(str, mobileCdnIp);
    }

    private HttpGet bl(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 != null && !str2.contains("hiphotos") && h.gg(str)) {
            try {
                System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                URL url = new URL(str);
                String host = h.gh(str) ? "tbcdn.hiphotos.baidu.com" : url.getHost();
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
        return this.cBh.getAllIpFromItem();
    }

    public void regetCdnIpList() {
        this.cBe = System.currentTimeMillis();
        this.cBh.lastTachometerTime = this.cBe;
        TbCDNTachometerService.startTachometerService(TbadkCoreApplication.m11getInst().getApp(), false, false);
    }

    private void amo() {
        if (this.cBo.KW) {
            this.cBh.mobileLastTachometerTime = System.currentTimeMillis();
            this.cBn.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int i;
        if (!h.gi(str)) {
            if (z2 || !z) {
                if (!z) {
                    if (CDNProblemUploader.m20getInstance().getmCdnLogData() != null) {
                        i = CDNProblemUploader.m20getInstance().getmCdnLogData().getErrRank();
                    } else {
                        i = 25;
                    }
                } else if (CDNProblemUploader.m20getInstance().getmCdnLogData() != null) {
                    i = CDNProblemUploader.m20getInstance().getmCdnLogData().getSlowRank();
                } else {
                    i = 10;
                }
            } else if (CDNProblemUploader.m20getInstance().getmCdnLogData() != null) {
                i = -CDNProblemUploader.m20getInstance().getmCdnLogData().getSuccRank();
            } else {
                i = -25;
            }
            if (z3) {
                if (str2 != null && str2.length() > 0) {
                    if (this.cBh.setIPRank(i, 100.0f, str2) >= 100.0f) {
                        regetCdnIpList();
                        b(this.cBh);
                    }
                } else if (this.cBh.setCdnDomainRank(i, 100.0f) >= 100.0f) {
                    regetCdnIpList();
                    b(this.cBh);
                }
            } else if (str2 != null && str2.length() > 0) {
                if (this.cBh.setMoblieIPRank(i, 100.0f, str2) >= 100.0f) {
                    amo();
                    b(this.cBh);
                }
            } else if (this.cBh.setMoblieIPRank(i, 100.0f, null) >= 100.0f) {
                amo();
                b(this.cBh);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public boolean isShouldCDNFallBack() {
        return this.cBf;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public a getCDNImageTimeData() {
        return this.cBo;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setCDNImageTimeData(a aVar) {
        this.cBo = aVar;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public String getCachedCdnIp(int i) {
        if (i.fr()) {
            return this.cBh.getIpString(i);
        }
        if (this.cBo.KW) {
            return this.cBh.getMobileCdnIp(i);
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

    private CdnCacheItem amq() {
        String string = b.sR().getString("cdn_iplist_cache_key_three", "");
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
        if (TbadkCoreApplication.m11getInst().isMainProcess(true) && (a = a(cdnCacheItem)) != null && a.length > 0) {
            try {
                String encodeBytes = c.encodeBytes(a);
                if (encodeBytes != null) {
                    b.sR().putString("cdn_iplist_cache_key_three", encodeBytes);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public String getNetIdentifier() {
        if (i.fr()) {
            try {
                WifiManager wifiManager = (WifiManager) TbadkCoreApplication.m11getInst().getContext().getSystemService("wifi");
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
                Context context = TbadkCoreApplication.m11getInst().getContext();
                if (ag.U(context)) {
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
        return (this.cBh != null ? this.cBh.hasImageProblem() : false) || this.cBf;
    }

    @Override // com.baidu.tbadk.core.util.a.e
    public void setIpDisableTime(int i) {
        this.cBh.setIpDisableTime(i);
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
                            CDNIPDirectConnect.m19getInstance().normalUserStartTachometerCdnList();
                        }
                        this.NETWORK_STATUS = 1;
                        return;
                    }
                    if (this.NETWORK_STATUS != -1) {
                        CDNIPDirectConnect.m19getInstance().normalUserStartTachometerCdnList();
                    }
                    this.NETWORK_STATUS = 2;
                }
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }
}
