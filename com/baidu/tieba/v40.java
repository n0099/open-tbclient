package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class v40 implements r40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static HashMap<String, Integer> a;
        public static a b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.v40$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0486a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String a;
            public String b;
            public String c;
            public int d;

            public C0486a(Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, context, networkInfo) == null) {
                    if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                        if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                            this.a = lowerCase;
                            this.b = "10.0.0.172";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                            this.a = lowerCase;
                            this.b = "10.0.0.200";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                            this.a = lowerCase;
                            return;
                        }
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost == null || defaultHost.length() <= 0) {
                        return;
                    }
                    this.b = defaultHost;
                    if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.b.trim())) {
                        return;
                    }
                    Integer.toString(defaultPort);
                }
            }

            @SuppressLint({"MissingPermission"})
            public final void b(Context context) {
                NetworkInfo networkInfo;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
                    try {
                        networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception unused) {
                        networkInfo = null;
                    }
                    if (networkInfo != null) {
                        if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                            this.c = "wifi";
                        } else {
                            a(context, networkInfo);
                            this.c = this.a;
                        }
                        this.d = networkInfo.getSubtype();
                        networkInfo.getSubtypeName();
                    }
                }
            }

            public int c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
            }

            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (String) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394517574, "Lcom/baidu/tieba/v40$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-394517574, "Lcom/baidu/tieba/v40$a;");
                    return;
                }
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            a = hashMap;
            hashMap.put("WIFI", 1);
            a.put("3GNET", 21);
            a.put("3GWAP", 22);
            a.put("CMNET", 31);
            a.put("UNINET", 32);
            a.put("CTNET", 33);
            a.put("CMWAP", 41);
            a.put("UNIWAP", 42);
            a.put("CTWAP", 43);
            b = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : (a) invokeV.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                C0486a c0486a = new C0486a(context);
                String d = c0486a.d();
                int c = c0486a.c();
                if (TextUtils.isEmpty(d)) {
                    sb = new StringBuilder();
                } else {
                    Integer num = a.get(d.toUpperCase());
                    r3 = num != null ? num : 5;
                    sb = new StringBuilder();
                }
                sb.append(r3);
                sb.append("_");
                sb.append(c);
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static b c;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public DisplayMetrics b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394517543, "Lcom/baidu/tieba/v40$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-394517543, "Lcom/baidu/tieba/v40$b;");
                    return;
                }
            }
            c = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c : (b) invokeV.objValue;
        }

        public static String d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return "0.8";
                }
            }
            return (String) invokeL.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                synchronized (b.class) {
                    if (TextUtils.isEmpty(this.a)) {
                        this.a = c(context);
                    }
                }
                return this.a;
            }
            return (String) invokeL.objValue;
        }

        public final String c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                int e = e(context.getApplicationContext());
                int f = f(context.getApplicationContext());
                int g = g(context.getApplicationContext());
                String d = d(context.getApplicationContext());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e);
                stringBuffer.append("_");
                stringBuffer.append(f);
                stringBuffer.append("_");
                stringBuffer.append("android");
                stringBuffer.append("_");
                stringBuffer.append(d);
                stringBuffer.append("_");
                stringBuffer.append(g);
                return stringBuffer.toString();
            }
            return (String) invokeL.objValue;
        }

        public final int e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.b;
                if (displayMetrics != null) {
                    return displayMetrics.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.b;
                if (displayMetrics != null) {
                    return displayMetrics.heightPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int g(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.b;
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final void h(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null && this.b == null) {
                this.b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static c e;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-394517512, "Lcom/baidu/tieba/v40$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-394517512, "Lcom/baidu/tieba/v40$c;");
                    return;
                }
            }
            e = new c();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            c();
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? e : (c) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String str = Build.MODEL;
                this.a = str;
                if (TextUtils.isEmpty(str)) {
                    this.a = "NUL";
                } else {
                    this.a = this.a.replace("_", "-");
                }
                String str2 = Build.MANUFACTURER;
                this.b = str2;
                if (TextUtils.isEmpty(str2)) {
                    this.b = "NUL";
                } else {
                    this.b = this.b.replace("_", "-");
                }
                String str3 = Build.VERSION.RELEASE;
                this.c = str3;
                this.c = TextUtils.isEmpty(str3) ? "0.0" : this.c.replace("_", "-");
                this.d = d();
            }
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.a;
                String str2 = this.c;
                int i = Build.VERSION.SDK_INT;
                String str3 = this.b;
                return str + "_" + str2 + "_" + i + "_" + str3;
            }
            return (String) invokeV.objValue;
        }
    }

    public v40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.r40
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a().b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r40
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? b.a().b(context) : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r40
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() : invokeV.longValue;
    }

    @Override // com.baidu.tieba.r40
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r40
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? j30.f(context).h() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r40
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? a.a().b(context) : (String) invokeL.objValue;
    }
}
