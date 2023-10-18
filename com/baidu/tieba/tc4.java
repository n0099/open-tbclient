package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.tieba.sc4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.http.client.methods.HttpPut;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes8.dex */
public class tc4 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile tc4 c;
    public static volatile tc4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) ? response : invokeLI.objValue;
        }

        public a(tc4 tc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948176388, "Lcom/baidu/tieba/tc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948176388, "Lcom/baidu/tieba/tc4;");
                return;
            }
        }
        b = hc4.c();
    }

    public ic4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new ic4(this);
        }
        return (ic4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public jc4 deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new jc4(this);
        }
        return (jc4) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public OkHttpClient.Builder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getOkHttpClient().newBuilder();
        }
        return (OkHttpClient.Builder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: j */
    public kc4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new kc4(this);
        }
        return (kc4) invokeV.objValue;
    }

    public final ResponseCallback k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new a(this);
        }
        return (ResponseCallback) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: m */
    public lc4 headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new lc4(this);
        }
        return (lc4) invokeV.objValue;
    }

    public mc4 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new mc4(this);
        }
        return (mc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public oc4 postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new oc4(this);
        }
        return (oc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public nc4 postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return new nc4(this);
        }
        return (nc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public pc4 postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return new pc4(this);
        }
        return (pc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: s */
    public qc4 putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new qc4(this);
        }
        return (qc4) invokeV.objValue;
    }

    public rc4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new rc4(this);
        }
        return (rc4) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc4() {
        super(hc4.b().getAppContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.a = hc4.a();
    }

    public static tc4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (tc4.class) {
                    if (c == null) {
                        c = new tc4();
                        c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return c;
        }
        return (tc4) invokeV.objValue;
    }

    public static tc4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d == null) {
                synchronized (tc4.class) {
                    if (d == null) {
                        d = new tc4();
                        d.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return d;
        }
        return (tc4) invokeV.objValue;
    }

    public static tc4 h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return g();
        }
        return (tc4) invokeL.objValue;
    }

    public void d(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sc4Var) == null) {
            sc4Var.b = "GET";
            t(sc4Var);
        }
    }

    public void e(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sc4Var) == null) {
            sc4Var.b = "POST";
            t(sc4Var);
        }
    }

    public void f(sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sc4Var) == null) {
            sc4Var.b = HttpPut.METHOD_NAME;
            t(sc4Var);
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (b) {
                    Log.e("SwanHttpManager", ExceptionMessage.URL_EMPTY);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            OkHttpClient initClient = super.initClient();
            List<Interceptor> l = hc4.b().l();
            if (l != null && l.size() > 0) {
                OkHttpClient.Builder newBuilder = initClient.newBuilder();
                for (Interceptor interceptor : l) {
                    newBuilder.addNetworkInterceptor(interceptor);
                }
                if (hc4.b().i()) {
                    try {
                        Iterator<Interceptor> it = newBuilder.interceptors().iterator();
                        while (it.hasNext()) {
                            String obj = it.next().toString();
                            if (obj.contains("RequestFilter") || obj.contains("SimCardFreeHeader")) {
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        if (b) {
                            th.printStackTrace();
                        }
                    }
                }
                gc4 b2 = hc4.b();
                if (b2 != null && b2.k() > 0) {
                    newBuilder.connectionPool(new ConnectionPool(b2.k(), 5L, TimeUnit.MINUTES));
                }
                return newBuilder.build();
            }
            return initClient;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public void t(@NonNull sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, sc4Var) == null) {
            if (sc4Var.e == null) {
                sc4Var.e = k();
            }
            if (n(sc4Var.a)) {
                sc4Var.e.onFail(new Exception("url is invalid"));
                return;
            }
            HttpRequestBuilder a2 = uc4.a(sc4Var);
            u(a2, sc4Var);
            a2.build().executeAsync(sc4Var.e);
        }
    }

    public void v(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpRequestBuilder) == null) {
            int m = hc4.b().m();
            if (m > 0) {
                httpRequestBuilder.connectionTimeout(m);
            }
            int readTimeout = hc4.b().getReadTimeout();
            if (readTimeout > 0) {
                httpRequestBuilder.readTimeout(readTimeout);
            }
            int g = hc4.b().g();
            if (g > 0) {
                httpRequestBuilder.writeTimeout(g);
            }
        }
    }

    public void w(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            int m = hc4.b().m();
            if (m > 0) {
                builder.connectTimeout(m, TimeUnit.MILLISECONDS);
            }
            int readTimeout = hc4.b().getReadTimeout();
            if (readTimeout > 0) {
                builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
            }
            int g = hc4.b().g();
            if (g > 0) {
                builder.writeTimeout(g, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder, sc4 sc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, httpRequestBuilder, sc4Var) == null) {
            if (httpRequestBuilder != null && sc4Var != null) {
                httpRequestBuilder.url(sc4Var.a);
                Map<String, String> map = sc4Var.c;
                if (map != null && map.size() > 0) {
                    httpRequestBuilder.headers(sc4Var.c);
                }
                if (sc4Var.f) {
                    httpRequestBuilder.userAgent(hc4.b().getUserAgent());
                }
                if (sc4Var.g) {
                    httpRequestBuilder.cookieManager(hc4.b().f());
                }
                if (sc4Var.h) {
                    sc4.a b2 = sc4Var.b();
                    if (b2 == null) {
                        v(httpRequestBuilder);
                    } else {
                        x(httpRequestBuilder, b2);
                    }
                }
                Object obj = sc4Var.i;
                if (obj != null) {
                    httpRequestBuilder.tag(obj);
                }
                if (sc4Var.k != 0) {
                    httpRequestBuilder.enableStat(true);
                    httpRequestBuilder.requestFrom(sc4Var.j);
                    httpRequestBuilder.requestSubFrom(sc4Var.k);
                }
            } else if (b) {
                Log.e("SwanHttpManager", "setNetworkConfig fail");
            }
        }
    }

    public final void x(HttpRequestBuilder httpRequestBuilder, @NonNull sc4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, httpRequestBuilder, aVar) == null) {
            int i = aVar.a;
            if (i <= 0) {
                i = hc4.b().m();
            }
            if (i > 0) {
                httpRequestBuilder.connectionTimeout(i);
            }
            int i2 = aVar.b;
            if (i2 <= 0) {
                i2 = hc4.b().getReadTimeout();
            }
            if (i2 > 0) {
                httpRequestBuilder.readTimeout(i2);
            }
            int i3 = aVar.c;
            if (i3 <= 0) {
                i3 = hc4.b().g();
            }
            if (i3 > 0) {
                httpRequestBuilder.writeTimeout(i3);
            }
        }
    }
}
