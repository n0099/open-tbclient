package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.tieba.oa4;
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
/* loaded from: classes5.dex */
public class pa4 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile pa4 c;
    public static volatile pa4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pa4 pa4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055302, "Lcom/baidu/tieba/pa4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055302, "Lcom/baidu/tieba/pa4;");
                return;
            }
        }
        b = da4.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pa4() {
        super(da4.b().getAppContext());
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
        this.a = da4.a();
    }

    public static pa4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (pa4.class) {
                    if (c == null) {
                        c = new pa4();
                        c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return c;
        }
        return (pa4) invokeV.objValue;
    }

    public static pa4 h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? g() : (pa4) invokeL.objValue;
    }

    public static pa4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d == null) {
                synchronized (pa4.class) {
                    if (d == null) {
                        d = new pa4();
                        d.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return d;
        }
        return (pa4) invokeV.objValue;
    }

    public ea4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ea4(this) : (ea4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public fa4 deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new fa4(this) : (fa4) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public void d(oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oa4Var) == null) {
            oa4Var.b = "GET";
            t(oa4Var);
        }
    }

    public void e(oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oa4Var) == null) {
            oa4Var.b = "POST";
            t(oa4Var);
        }
    }

    public void f(oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oa4Var) == null) {
            oa4Var.b = HttpPut.METHOD_NAME;
            t(oa4Var);
        }
    }

    public OkHttpClient.Builder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getOkHttpClient().newBuilder() : (OkHttpClient.Builder) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            OkHttpClient initClient = super.initClient();
            List<Interceptor> l = da4.b().l();
            if (l == null || l.size() <= 0) {
                return initClient;
            }
            OkHttpClient.Builder newBuilder = initClient.newBuilder();
            for (Interceptor interceptor : l) {
                newBuilder.addNetworkInterceptor(interceptor);
            }
            if (da4.b().i()) {
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
            ca4 b2 = da4.b();
            if (b2 != null && b2.k() > 0) {
                newBuilder.connectionPool(new ConnectionPool(b2.k(), 5L, TimeUnit.MINUTES));
            }
            return newBuilder.build();
        }
        return (OkHttpClient) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: j */
    public ga4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new ga4(this) : (ga4) invokeV.objValue;
    }

    public final ResponseCallback k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this) : (ResponseCallback) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: m */
    public ha4 headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new ha4(this) : (ha4) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (b) {
                    Log.e("SwanHttpManager", "url is empty");
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ia4 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new ia4(this) : (ia4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public ka4 postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new ka4(this) : (ka4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public ja4 postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new ja4(this) : (ja4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public la4 postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? new la4(this) : (la4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: s */
    public ma4 putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new ma4(this) : (ma4) invokeV.objValue;
    }

    public void t(@NonNull oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, oa4Var) == null) {
            if (oa4Var.e == null) {
                oa4Var.e = k();
            }
            if (n(oa4Var.a)) {
                oa4Var.e.onFail(new Exception("url is invalid"));
                return;
            }
            HttpRequestBuilder a2 = qa4.a(oa4Var);
            u(a2, oa4Var);
            a2.build().executeAsync(oa4Var.e);
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder, oa4 oa4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, httpRequestBuilder, oa4Var) == null) {
            if (httpRequestBuilder != null && oa4Var != null) {
                httpRequestBuilder.url(oa4Var.a);
                Map<String, String> map = oa4Var.c;
                if (map != null && map.size() > 0) {
                    httpRequestBuilder.headers(oa4Var.c);
                }
                if (oa4Var.f) {
                    httpRequestBuilder.userAgent(da4.b().getUserAgent());
                }
                if (oa4Var.g) {
                    httpRequestBuilder.cookieManager(da4.b().f());
                }
                if (oa4Var.h) {
                    oa4.a b2 = oa4Var.b();
                    if (b2 == null) {
                        v(httpRequestBuilder);
                    } else {
                        x(httpRequestBuilder, b2);
                    }
                }
                Object obj = oa4Var.i;
                if (obj != null) {
                    httpRequestBuilder.tag(obj);
                }
                if (oa4Var.k != 0) {
                    httpRequestBuilder.enableStat(true);
                    httpRequestBuilder.requestFrom(oa4Var.j);
                    httpRequestBuilder.requestSubFrom(oa4Var.k);
                }
            } else if (b) {
                Log.e("SwanHttpManager", "setNetworkConfig fail");
            }
        }
    }

    public void v(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpRequestBuilder) == null) {
            int m = da4.b().m();
            if (m > 0) {
                httpRequestBuilder.connectionTimeout(m);
            }
            int readTimeout = da4.b().getReadTimeout();
            if (readTimeout > 0) {
                httpRequestBuilder.readTimeout(readTimeout);
            }
            int g = da4.b().g();
            if (g > 0) {
                httpRequestBuilder.writeTimeout(g);
            }
        }
    }

    public void w(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            int m = da4.b().m();
            if (m > 0) {
                builder.connectTimeout(m, TimeUnit.MILLISECONDS);
            }
            int readTimeout = da4.b().getReadTimeout();
            if (readTimeout > 0) {
                builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
            }
            int g = da4.b().g();
            if (g > 0) {
                builder.writeTimeout(g, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void x(HttpRequestBuilder httpRequestBuilder, @NonNull oa4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, httpRequestBuilder, aVar) == null) {
            int i = aVar.a;
            if (i <= 0) {
                i = da4.b().m();
            }
            if (i > 0) {
                httpRequestBuilder.connectionTimeout(i);
            }
            int i2 = aVar.b;
            if (i2 <= 0) {
                i2 = da4.b().getReadTimeout();
            }
            if (i2 > 0) {
                httpRequestBuilder.readTimeout(i2);
            }
            int i3 = aVar.c;
            if (i3 <= 0) {
                i3 = da4.b().g();
            }
            if (i3 > 0) {
                httpRequestBuilder.writeTimeout(i3);
            }
        }
    }

    public na4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? new na4(this) : (na4) invokeV.objValue;
    }
}
