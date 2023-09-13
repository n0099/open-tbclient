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
import com.baidu.tieba.ki4;
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
/* loaded from: classes6.dex */
public class li4 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile li4 c;
    public static volatile li4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
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

        public a(li4 li4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li4Var};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943826, "Lcom/baidu/tieba/li4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943826, "Lcom/baidu/tieba/li4;");
                return;
            }
        }
        b = zh4.c();
    }

    public ai4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new ai4(this);
        }
        return (ai4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public bi4 deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new bi4(this);
        }
        return (bi4) invokeV.objValue;
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
    public ci4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new ci4(this);
        }
        return (ci4) invokeV.objValue;
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
    public di4 headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new di4(this);
        }
        return (di4) invokeV.objValue;
    }

    public ei4 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new ei4(this);
        }
        return (ei4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public gi4 postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new gi4(this);
        }
        return (gi4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public fi4 postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return new fi4(this);
        }
        return (fi4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public hi4 postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return new hi4(this);
        }
        return (hi4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: s */
    public ii4 putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new ii4(this);
        }
        return (ii4) invokeV.objValue;
    }

    public ji4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new ji4(this);
        }
        return (ji4) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public li4() {
        super(zh4.b().getAppContext());
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
        this.a = zh4.a();
    }

    public static li4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (li4.class) {
                    if (c == null) {
                        c = new li4();
                        c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return c;
        }
        return (li4) invokeV.objValue;
    }

    public static li4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d == null) {
                synchronized (li4.class) {
                    if (d == null) {
                        d = new li4();
                        d.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return d;
        }
        return (li4) invokeV.objValue;
    }

    public static li4 h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return g();
        }
        return (li4) invokeL.objValue;
    }

    public void d(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ki4Var) == null) {
            ki4Var.b = "GET";
            t(ki4Var);
        }
    }

    public void e(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ki4Var) == null) {
            ki4Var.b = "POST";
            t(ki4Var);
        }
    }

    public void f(ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ki4Var) == null) {
            ki4Var.b = HttpPut.METHOD_NAME;
            t(ki4Var);
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
            List<Interceptor> l = zh4.b().l();
            if (l != null && l.size() > 0) {
                OkHttpClient.Builder newBuilder = initClient.newBuilder();
                for (Interceptor interceptor : l) {
                    newBuilder.addNetworkInterceptor(interceptor);
                }
                if (zh4.b().i()) {
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
                yh4 b2 = zh4.b();
                if (b2 != null && b2.k() > 0) {
                    newBuilder.connectionPool(new ConnectionPool(b2.k(), 5L, TimeUnit.MINUTES));
                }
                return newBuilder.build();
            }
            return initClient;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public void t(@NonNull ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ki4Var) == null) {
            if (ki4Var.e == null) {
                ki4Var.e = k();
            }
            if (n(ki4Var.a)) {
                ki4Var.e.onFail(new Exception("url is invalid"));
                return;
            }
            HttpRequestBuilder a2 = mi4.a(ki4Var);
            u(a2, ki4Var);
            a2.build().executeAsync(ki4Var.e);
        }
    }

    public void v(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpRequestBuilder) == null) {
            int m = zh4.b().m();
            if (m > 0) {
                httpRequestBuilder.connectionTimeout(m);
            }
            int readTimeout = zh4.b().getReadTimeout();
            if (readTimeout > 0) {
                httpRequestBuilder.readTimeout(readTimeout);
            }
            int g = zh4.b().g();
            if (g > 0) {
                httpRequestBuilder.writeTimeout(g);
            }
        }
    }

    public void w(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            int m = zh4.b().m();
            if (m > 0) {
                builder.connectTimeout(m, TimeUnit.MILLISECONDS);
            }
            int readTimeout = zh4.b().getReadTimeout();
            if (readTimeout > 0) {
                builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
            }
            int g = zh4.b().g();
            if (g > 0) {
                builder.writeTimeout(g, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder, ki4 ki4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, httpRequestBuilder, ki4Var) == null) {
            if (httpRequestBuilder != null && ki4Var != null) {
                httpRequestBuilder.url(ki4Var.a);
                Map<String, String> map = ki4Var.c;
                if (map != null && map.size() > 0) {
                    httpRequestBuilder.headers(ki4Var.c);
                }
                if (ki4Var.f) {
                    httpRequestBuilder.userAgent(zh4.b().getUserAgent());
                }
                if (ki4Var.g) {
                    httpRequestBuilder.cookieManager(zh4.b().f());
                }
                if (ki4Var.h) {
                    ki4.a b2 = ki4Var.b();
                    if (b2 == null) {
                        v(httpRequestBuilder);
                    } else {
                        x(httpRequestBuilder, b2);
                    }
                }
                Object obj = ki4Var.i;
                if (obj != null) {
                    httpRequestBuilder.tag(obj);
                }
                if (ki4Var.k != 0) {
                    httpRequestBuilder.enableStat(true);
                    httpRequestBuilder.requestFrom(ki4Var.j);
                    httpRequestBuilder.requestSubFrom(ki4Var.k);
                }
            } else if (b) {
                Log.e("SwanHttpManager", "setNetworkConfig fail");
            }
        }
    }

    public final void x(HttpRequestBuilder httpRequestBuilder, @NonNull ki4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, httpRequestBuilder, aVar) == null) {
            int i = aVar.a;
            if (i <= 0) {
                i = zh4.b().m();
            }
            if (i > 0) {
                httpRequestBuilder.connectionTimeout(i);
            }
            int i2 = aVar.b;
            if (i2 <= 0) {
                i2 = zh4.b().getReadTimeout();
            }
            if (i2 > 0) {
                httpRequestBuilder.readTimeout(i2);
            }
            int i3 = aVar.c;
            if (i3 <= 0) {
                i3 = zh4.b().g();
            }
            if (i3 > 0) {
                httpRequestBuilder.writeTimeout(i3);
            }
        }
    }
}
