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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.e;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.d1.t;
import c.a.t0.o.a;
import c.a.t0.s.j0.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCDNTachometerService;
import com.baidu.tieba.imageProblem.cdnOptimize.TbCdnMobileGetIpModel;
import com.baidu.tieba.imageProblem.util.CDNProblemUploader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes12.dex */
public class CDNIPDirectConnect extends ICDNIPDirectConnect {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile CDNIPDirectConnect f45545h;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45546b;

    /* renamed from: c  reason: collision with root package name */
    public CdnCacheItem f45547c;

    /* renamed from: d  reason: collision with root package name */
    public IPListReceiver f45548d;

    /* renamed from: e  reason: collision with root package name */
    public TbCdnMobileGetIpModel f45549e;

    /* renamed from: f  reason: collision with root package name */
    public a f45550f;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: g  reason: collision with root package name */
    public final Handler f45551g;

    /* loaded from: classes12.dex */
    public class CDNNetworkChangeReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MOBILE = 2;
        public static final int NOTSET = -1;
        public static final int WIFI = 1;
        public static final String WIFI_STRING = "WIFI";
        public transient /* synthetic */ FieldHolder $fh;
        public int NETWORK_STATUS;
        public final /* synthetic */ CDNIPDirectConnect this$0;

        public CDNNetworkChangeReceiver(CDNIPDirectConnect cDNIPDirectConnect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cDNIPDirectConnect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cDNIPDirectConnect;
            this.NETWORK_STATUS = -1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
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

    /* loaded from: classes12.dex */
    public class IPListReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CDNIPDirectConnect this$0;

        public IPListReceiver(CDNIPDirectConnect cDNIPDirectConnect) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cDNIPDirectConnect};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cDNIPDirectConnect;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && intent.getAction().equals(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION)) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_KEY);
                boolean z = false;
                if (intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_ISMOBILE, false)) {
                    this.this$0.f45547c.setMobileIpList(stringArrayListExtra);
                    CDNIPDirectConnect cDNIPDirectConnect = this.this$0;
                    cDNIPDirectConnect.k(cDNIPDirectConnect.f45547c);
                    return;
                }
                boolean booleanExtra = intent.getBooleanExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NEED_USEIP, false);
                int intExtra = intent.getIntExtra(TbCDNTachometerService.TB_CDNIP_BROADCASE_NUM, -1);
                int size = stringArrayListExtra == null ? 0 : stringArrayListExtra.size();
                if ((1 == intExtra || 2 == intExtra) && size > 0) {
                    z = true;
                } else if ((1 == intExtra || 2 == intExtra) && size == 0) {
                    this.this$0.f45546b = true;
                }
                this.this$0.f45547c.setIpList(stringArrayListExtra, booleanExtra, z);
                if (size > 0) {
                    CDNIPDirectConnect cDNIPDirectConnect2 = this.this$0;
                    cDNIPDirectConnect2.k(cDNIPDirectConnect2.f45547c);
                }
            }
        }
    }

    public CDNIPDirectConnect() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.f45546b = false;
        this.f45547c = null;
        this.f45548d = null;
        this.f45550f = null;
        this.f45551g = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what == 1003) {
                        CDNIPDirectConnect.getInstance().normalUserStartTachometerCdnList();
                    }
                }
            }
        };
    }

    public static CDNIPDirectConnect getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f45545h == null) {
                synchronized (CDNIPDirectConnect.class) {
                    if (f45545h == null) {
                        f45545h = new CDNIPDirectConnect();
                    }
                }
            }
            return f45545h;
        }
        return (CDNIPDirectConnect) invokeV.objValue;
    }

    public final CdnCacheItem d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
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
        return (CdnCacheItem) invokeL.objValue;
    }

    public final byte[] e(CdnCacheItem cdnCacheItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cdnCacheItem)) == null) {
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
        return (byte[]) invokeL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CdnCacheItem g2 = g();
            long currentTimeMillis = System.currentTimeMillis();
            if (g2 != null) {
                long j2 = g2.firstUseIpTime;
                if (j2 > 0 && currentTimeMillis - j2 < 604800000) {
                    this.f45547c = g2;
                }
            }
            if (this.f45547c == null) {
                CdnCacheItem cdnCacheItem = new CdnCacheItem();
                this.f45547c = cdnCacheItem;
                cdnCacheItem.firstUseIpTime = currentTimeMillis;
                cdnCacheItem.identifier = getNetIdentifier();
            }
            CdnCacheItem cdnCacheItem2 = this.f45547c;
            if (0 == cdnCacheItem2.firstUseIpTime) {
                cdnCacheItem2.firstUseIpTime = currentTimeMillis;
            }
        }
    }

    public final CdnCacheItem g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String q = b.k().q("cdn_iplist_cache_key_three", "");
            if (q != null && q.length() != 0) {
                try {
                    return d(e.d(q));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (CdnCacheItem) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public String getAllIPListCanUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45547c.getAllIpFromItem() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public a getCDNImageTimeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45550f : (a) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public String getCachedCdnIp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (l.H()) {
                return this.f45547c.getIpString(i2);
            }
            if (this.f45550f.f13358g) {
                return this.f45547c.getMobileCdnIp(i2);
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public String getNetIdentifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                if (l.H()) {
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
        return (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f45550f.f13358g) {
            this.f45547c.mobileLastTachometerTime = System.currentTimeMillis();
            this.f45549e.startGetMobileIpList();
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public boolean hasImageProblem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            CdnCacheItem cdnCacheItem = this.f45547c;
            return (cdnCacheItem != null ? cdnCacheItem.hasImageProblem() : false) || this.f45546b;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public HttpGet httpGetFactory(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, str3)) == null) {
            if (str != null && str.length() != 0 && str2 != null && str2.length() != 0 && str3 != null && str3.length() != 0 && t.b(str)) {
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
        return (HttpGet) invokeLLL.objValue;
    }

    public final HttpGet i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (str == null) {
                return null;
            }
            if (str2 != null && !str2.contains("hiphotos") && t.a(str)) {
                try {
                    System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
                    URL url = new URL(str);
                    String host = url.getHost();
                    if (t.b(str)) {
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
        return (HttpGet) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                this.f45550f = new a();
                this.f45549e = new TbCdnMobileGetIpModel();
                f();
                this.f45548d = new IPListReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(TbCDNTachometerService.TB_CDNIP_BROADCASE_ACTION);
                TbadkCoreApplication.getInst().getApp().registerReceiver(this.f45548d, intentFilter);
                if (TbadkCoreApplication.getInst().isMainProcess(true) && n.B()) {
                    try {
                        TbadkCoreApplication.getInst().getApp().registerReceiver(new CDNNetworkChangeReceiver(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                this.f45551g.sendEmptyMessageDelayed(1003, 10000L);
                this.isAlreadyInit = true;
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public boolean isShouldCDNFallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f45546b : invokeV.booleanValue;
    }

    public final HttpGet j(String str, int i2) {
        InterceptResult invokeLI;
        String mobileCdnIp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i2)) == null) {
            if (this.f45550f.f13358g && (mobileCdnIp = this.f45547c.getMobileCdnIp(i2)) != null) {
                if (System.currentTimeMillis() - this.f45547c.mobileLastTachometerTime > 3600000) {
                    h();
                }
                return i(str, mobileCdnIp);
            }
            return new HttpGet(str);
        }
        return (HttpGet) invokeLI.objValue;
    }

    public final void k(CdnCacheItem cdnCacheItem) {
        byte[] e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, cdnCacheItem) == null) || !TbadkCoreApplication.getInst().isMainProcess(true) || (e2 = e(cdnCacheItem)) == null || e2.length <= 0) {
            return;
        }
        try {
            String j2 = e.j(e2);
            if (j2 != null) {
                b.k().y("cdn_iplist_cache_key_three", j2);
            }
        } catch (Exception e3) {
            BdLog.e(e3);
        }
    }

    public final HttpGet l(String str, int i2) {
        InterceptResult invokeLI;
        String ipString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (this.f45547c.getIsUsedIp() && (ipString = this.f45547c.getIpString(i2)) != null) {
                if (System.currentTimeMillis() - this.f45547c.lastTachometerTime > 3600000) {
                    regetCdnIpList();
                }
                return i(str, ipString);
            }
            return new HttpGet(str);
        }
        return (HttpGet) invokeLI.objValue;
    }

    public void normalUserStartTachometerCdnList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String netIdentifier = getNetIdentifier();
            String str = this.f45547c.identifier;
            boolean z = (str == null || netIdentifier == null || str.equals(netIdentifier)) ? false : true;
            if (l.H()) {
                CdnCacheItem cdnCacheItem = this.f45547c;
                if (cdnCacheItem.lastTachometerTime == 0 || z || (cdnCacheItem.getIsUsedIp() && currentTimeMillis - this.f45547c.lastTachometerTime > 3600000)) {
                    CdnCacheItem cdnCacheItem2 = this.f45547c;
                    cdnCacheItem2.lastTachometerTime = currentTimeMillis;
                    cdnCacheItem2.identifier = netIdentifier;
                    TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), true, false);
                    return;
                }
                return;
            }
            CdnCacheItem cdnCacheItem3 = this.f45547c;
            if (cdnCacheItem3.mobileLastTachometerTime == 0 || z || (cdnCacheItem3.mobileIsUsedIp() && currentTimeMillis - this.f45547c.mobileLastTachometerTime > 3600000)) {
                this.f45547c.identifier = netIdentifier;
                h();
            }
        }
    }

    public void regetCdnIpList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.a = currentTimeMillis;
            this.f45547c.lastTachometerTime = currentTimeMillis;
            TbCDNTachometerService.startTachometerService(TbadkCoreApplication.getInst().getApp(), false, false);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void result(String str, String str2, boolean z, boolean z2, boolean z3) {
        int d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || t.c(str)) {
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
                if (this.f45547c.setIPRank(d2, 100.0f, str2) >= 100.0f) {
                    regetCdnIpList();
                    k(this.f45547c);
                }
            } else if (this.f45547c.setCdnDomainRank(d2, 100.0f) >= 100.0f) {
                regetCdnIpList();
                k(this.f45547c);
            }
        } else if (str2 != null && str2.length() > 0) {
            if (this.f45547c.setMoblieIPRank(d2, 100.0f, str2) >= 100.0f) {
                h();
                k(this.f45547c);
            }
        } else if (this.f45547c.setMoblieIPRank(d2, 100.0f, null) >= 100.0f) {
            h();
            k(this.f45547c);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void setCDNImageTimeData(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.f45550f = aVar;
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public void setIpDisableTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f45547c.setIpDisableTime(i2);
        }
    }

    @Override // com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect
    public HttpGet httpGetFactory(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return l(str, i2);
            }
            return j(str, i2);
        }
        return (HttpGet) invokeCommon.objValue;
    }
}
