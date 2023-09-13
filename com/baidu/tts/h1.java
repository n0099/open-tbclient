package com.baidu.tts;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.e2;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public final HashMap<String, b> b;

    /* loaded from: classes9.dex */
    public class a extends m1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String b;
        public final /* synthetic */ String[] c;

        public a(h1 h1Var, String str, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1Var, str, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = str;
            this.c = strArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x010a A[Catch: JSONException -> 0x0114, TryCatch #1 {JSONException -> 0x0114, blocks: (B:5:0x000e, B:31:0x00e8, B:33:0x010a, B:34:0x010f, B:30:0x00d2, B:10:0x0043, B:7:0x002d), top: B:44:0x000e, inners: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x010f A[Catch: JSONException -> 0x0114, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0114, blocks: (B:5:0x000e, B:31:0x00e8, B:33:0x010a, B:34:0x010f, B:30:0x00d2, B:10:0x0043, B:7:0x002d), top: B:44:0x000e, inners: #2 }] */
        @Override // com.baidu.tts.m1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, Map<String, List<String>> map, String str, byte[] bArr) {
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), map, str, bArr}) == null) {
                String str4 = "";
                try {
                    String str5 = new String(bArr);
                    LoggerProxy.d("HttpDNS", "response: " + str5);
                    JSONObject jSONObject = new JSONObject(str5);
                    try {
                        str2 = jSONObject.getJSONObject("data").getJSONObject(this.b).getJSONArray("ip").getString(0);
                    } catch (Exception e) {
                        LoggerProxy.d("HttpDNS", "JSONException " + e.toString());
                        str2 = "";
                    }
                    try {
                        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONObject(this.b).getJSONArray("ipv6");
                        if (jSONArray.length() < 1) {
                            str3 = "";
                        } else {
                            str3 = jSONArray.getString(0);
                        }
                        try {
                            if (str3.isEmpty()) {
                                str3 = jSONObject.getJSONObject("ext-info").getJSONObject("ipv6-group").getJSONObject(this.b).getJSONArray("ipv6").getString(0);
                            }
                            if (!str3.isEmpty()) {
                                boolean c = w0.c(str3);
                                LoggerProxy.d("HttpDNS", "ipv6 isConnect:" + c);
                                if (c) {
                                    str4 = PreferencesUtil.LEFT_MOUNT + str3 + PreferencesUtil.RIGHT_MOUNT;
                                }
                            } else {
                                str4 = str3;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str4 = str3;
                            LoggerProxy.d("HttpDNS", "JSONException " + e.toString());
                            LoggerProxy.d("HttpDNS", "ipv6: " + str4 + " ipv4: " + str2);
                            if (!str4.isEmpty()) {
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    LoggerProxy.d("HttpDNS", "ipv6: " + str4 + " ipv4: " + str2);
                    if (!str4.isEmpty()) {
                        this.c[0] = str2;
                    } else {
                        this.c[0] = str4;
                    }
                } catch (JSONException e4) {
                    LoggerProxy.d("HttpDNS", "JSONException " + e4.toString());
                }
            }
        }

        @Override // com.baidu.tts.m1
        public void a(int i, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), map, str, bArr, th}) == null) {
                LoggerProxy.d("HttpDNS", "onFailure statusCode: " + i + " responseBody: " + ((Object) null));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;
        public long d;
        public String e;
        public long f;

        public b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "CacheIp{mHost='" + this.a + "', mNetType=" + this.b + ", mHttpDnsIp='" + this.c + "', mHttpDnsExpireTime=" + this.d + ", mLocalDnsIp='" + this.e + "', mLocalDnsExpireTime=" + this.f + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final /* synthetic */ c[] e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1525872521, "Lcom/baidu/tts/h1$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1525872521, "Lcom/baidu/tts/h1$c;");
                    return;
                }
            }
            c cVar = new c("TYPE_DEFAULT_DNS_ON", 0);
            a = cVar;
            c cVar2 = new c("TYPE_HTTP_DNS_ON", 1);
            b = cVar2;
            c cVar3 = new c("TYPE_LOCAL_DNS_ON", 2);
            c = cVar3;
            c cVar4 = new c("TYPE_DNS_OFF", 3);
            d = cVar4;
            e = new c[]{cVar, cVar2, cVar3, cVar4};
        }

        public c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static c valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (c) Enum.valueOf(c.class, str);
            }
            return (c) invokeL.objValue;
        }

        public static c[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (c[]) e.clone();
            }
            return (c[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final h1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1525872552, "Lcom/baidu/tts/h1$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1525872552, "Lcom/baidu/tts/h1$d;");
                    return;
                }
            }
            a = new h1();
        }
    }

    public h1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c.a;
        this.b = new HashMap<>();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return SpeechDecoder.isIpv4Reachable();
            } catch (Throwable th) {
                LoggerProxy.d("HttpDNS", th.toString());
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return SpeechDecoder.isIpv6Reachable();
            } catch (Throwable th) {
                LoggerProxy.d("HttpDNS", th.toString());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        boolean z;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!String.format("%s.", str).matches("^((\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.){4}$") && !String.format("%s:", str).matches("^(([\\da-fA-F]{1,4}):){8}$")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return str;
            }
            String[] strArr = {""};
            String a2 = l2.a("aHR0cHM6Ly8xODAuNzYuNzYuMTEyL3Y2Lw==");
            boolean a3 = a();
            boolean b2 = b();
            LoggerProxy.d("HttpDNS", "isIpv4Reachable: " + a3 + " isIpv6Reachable:" + b());
            if (b2 && a3) {
                a2 = l2.a("aHR0cHM6Ly8xODAuNzYuNzYuMTEyL3Y2Lw==");
                str2 = "ipv4,ipv6";
                str3 = "&group=ipv6_11_23";
            } else if (!a3 && b2) {
                a2 = l2.a("aHR0cHM6Ly9bMjQwYzo0MDA2Ojo2NjY2XS92Ni8=");
                str2 = "ipv6";
                str3 = "&group=ipv6";
            } else {
                str2 = DnsTransmitter.TYPE_VALUE_IPV4;
                str3 = "";
            }
            String format = String.format("%s%s/?dn=%s&type=%s%s", a2, "0012", str, str2, str3);
            LoggerProxy.d("HttpDNS", "HttpDNS url: " + format);
            g1 g1Var = new g1();
            HashMap hashMap = new HashMap();
            hashMap.put("Host", DnsTransmitter.IDC_HOST);
            hashMap.put("Accept-Encoding", "identity");
            g1Var.e = hashMap;
            g1Var.a = 3000;
            int i = e2.j;
            int i2 = e2.b.a.b.a;
            long currentTimeMillis = System.currentTimeMillis();
            g1Var.a(format, "", "GET", new a(this, str, strArr));
            String str4 = strArr[0];
            if (!TextUtils.isEmpty(str4)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String a4 = a(str, i2);
                b bVar = this.b.get(a4);
                if (bVar == null) {
                    bVar = new b(str, i2);
                }
                bVar.c = str4;
                bVar.d = 300000 + currentTimeMillis2;
                this.b.put(a4, bVar);
                LoggerProxy.d("HttpDNS", "http cacheIp = " + bVar.toString() + " , cost = " + (currentTimeMillis2 - currentTimeMillis));
            }
            return str4;
        }
        return (String) invokeL.objValue;
    }

    public final String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            return str + "_" + i;
        }
        return (String) invokeLI.objValue;
    }

    public String a(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            String replaceFirst = str.replaceFirst(SpeechSynthesizer.REQUEST_PROTOCOL_WS, "http");
            try {
                String host = new URL(replaceFirst).getHost();
                int ordinal = this.a.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            str2 = null;
                        } else {
                            str2 = c(host, z);
                        }
                    } else {
                        str2 = b(host, z);
                    }
                } else {
                    String b2 = b(host, z);
                    if (TextUtils.isEmpty(b2)) {
                        str2 = c(host, z);
                    } else {
                        str2 = b2;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    return replaceFirst.replace(host, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return (String) invokeLZ.objValue;
    }

    public final String b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = e2.j;
            String a2 = a(str, e2.b.a.b.a);
            b bVar = this.b.get(a2);
            if (bVar != null && bVar.d > currentTimeMillis) {
                String str2 = bVar.c;
                if (!TextUtils.isEmpty(str2)) {
                    LoggerProxy.d("HttpDNS", "cacheIp key = " + a2 + " , httpDnsIp = " + str2);
                    return str2;
                }
            }
            if (z) {
                return a(str);
            }
            return null;
        }
        return (String) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0004, B:6:0x0024, B:12:0x0036, B:13:0x004c, B:15:0x0052, B:17:0x0064, B:18:0x0069, B:20:0x0078), top: B:29:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0004, B:6:0x0024, B:12:0x0036, B:13:0x004c, B:15:0x0052, B:17:0x0064, B:18:0x0069, B:20:0x0078), top: B:29:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str) {
        boolean z;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int i = e2.j;
                int i2 = e2.b.a.b.a;
                String hostAddress = InetAddress.getByName(str).getHostAddress();
                if (!l2.a.matcher(hostAddress).matches() && !l2.b.matcher(hostAddress).matches()) {
                    z = false;
                    if (z) {
                        hostAddress = PreferencesUtil.LEFT_MOUNT + hostAddress + PreferencesUtil.RIGHT_MOUNT;
                    }
                    if (!TextUtils.isEmpty(hostAddress)) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String a2 = a(str, i2);
                        b bVar = this.b.get(a2);
                        if (bVar == null) {
                            bVar = new b(str, i2);
                        }
                        bVar.e = hostAddress;
                        bVar.f = 300000 + currentTimeMillis2;
                        this.b.put(a2, bVar);
                        LoggerProxy.d("HttpDNS", "local cacheIp = " + bVar.toString() + " , cost = " + (currentTimeMillis2 - currentTimeMillis));
                    }
                    return hostAddress;
                }
                z = true;
                if (z) {
                }
                if (!TextUtils.isEmpty(hostAddress)) {
                }
                return hostAddress;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final String c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i = e2.j;
            String a2 = a(str, e2.b.a.b.a);
            LoggerProxy.d("HttpDNS", "cacheIp indexes = " + a2);
            b bVar = this.b.get(a2);
            if (bVar != null && bVar.f > currentTimeMillis) {
                String str2 = bVar.e;
                if (!TextUtils.isEmpty(str2)) {
                    LoggerProxy.d("HttpDNS", "cacheIp indexes = " + a2 + " , localDnsIp = " + str2);
                    return str2;
                }
            }
            if (z) {
                return b(str);
            }
            return null;
        }
        return (String) invokeLZ.objValue;
    }
}
