package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class o70 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile o70 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient a;
    public Context b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947985025, "Lcom/baidu/tieba/o70;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947985025, "Lcom/baidu/tieba/o70;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p70 a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ q70 c;
        public final /* synthetic */ o70 d;

        public a(o70 o70Var, p70 p70Var, byte[] bArr, q70 q70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o70Var, p70Var, bArr, q70Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o70Var;
            this.a = p70Var;
            this.b = bArr;
            this.c = q70Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.c(this.a.getMethod(), this.a.getHost(), this.a.getRequestParameter(), this.b, this.a.getHeaders(), this.a.getContentType(), this.c);
            }
        }
    }

    public o70(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
        this.b = context;
    }

    public final Headers d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        String str2 = str.toString();
                        builder.add(str2, map.get(str2));
                    }
                }
                return builder.build();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Headers) invokeL.objValue;
    }

    public static o70 e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (c == null) {
                synchronized (o70.class) {
                    if (c == null) {
                        c = new o70(context);
                    }
                }
            }
            return c;
        }
        return (o70) invokeL.objValue;
    }

    public void b(Context context, p70 p70Var, q70 q70Var, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{context, p70Var, q70Var, bArr, Boolean.valueOf(z)}) != null) || q70Var == null) {
            return;
        }
        if (context != null && p70Var != null && !TextUtils.isEmpty(p70Var.getHost())) {
            if (z) {
                s70.a().b(new a(this, p70Var, bArr, q70Var));
                return;
            } else {
                c(p70Var.getMethod(), p70Var.getHost(), p70Var.getRequestParameter(), bArr, p70Var.getHeaders(), p70Var.getContentType(), q70Var);
                return;
            }
        }
        q70Var.a(d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
    }

    public final void c(String str, String str2, byte[] bArr, byte[] bArr2, Map<String, String> map, String str3, q70 q70Var) {
        Request build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, bArr, bArr2, map, str3, q70Var}) == null) {
            try {
                if ("POST".equals(str)) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "application/x-www-form-urlencoded";
                    }
                    build = new Request.Builder().url(str2).headers(d(map)).removeHeader("User-Agent").addHeader("User-Agent", f()).post(RequestBody.create(MediaType.parse(str3), bArr2)).build();
                } else {
                    if (bArr != null && bArr.length > 0) {
                        str2 = str2 + "?" + new String(bArr);
                    }
                    build = new Request.Builder().url(str2).headers(d(map)).removeHeader("User-Agent").addHeader("User-Agent", f()).build();
                }
                Response execute = this.a.newCall(build).execute();
                byte[] bytes = execute.body().bytes();
                x70.c("HttpExecutor", "requestUrl:" + str2 + "\nrequest method: " + str + "\nrequest contentType: " + str3 + "\nresponse : " + new String(bytes));
                q70Var.onSuccess(execute.code(), bytes);
            } catch (Exception e) {
                e.printStackTrace();
                if (q70Var != null) {
                    q70Var.a(d, "Http Unknown exception".getBytes());
                }
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    property = WebSettings.getDefaultUserAgent(this.b);
                } catch (Exception unused) {
                    property = System.getProperty("http.agent");
                }
            } else {
                property = System.getProperty("http.agent");
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
            }
            x70.a("HttpExecutor", "getUserAgent:" + stringBuffer.toString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
