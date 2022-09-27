package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class r14 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final Set<String> g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public sv1 b;
    public String c;
    public va2 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSEvent a;
        public final /* synthetic */ r14 b;

        public a(r14 r14Var, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r14Var, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r14Var;
            this.a = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                r14.super.dispatchEvent(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;
        public final /* synthetic */ r14 b;

        public b(r14 r14Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r14Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r14Var;
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x54.call(this.b.b, true, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ r14 c;

        public c(r14 r14Var, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r14Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r14Var;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b24 b24Var = new b24();
                b24Var.errMsg = this.a;
                b24Var.statusCode = this.b;
                x54.call(this.c.b, false, b24Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948068756, "Lcom/baidu/tieba/r14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948068756, "Lcom/baidu/tieba/r14;");
                return;
            }
        }
        e = vj1.a;
        f = Sets.newHashSet("REFERER", "USER-AGENT");
        g = Sets.newHashSet("localhost", "127.0.0.1");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r14(@NonNull va2 va2Var, sv1 sv1Var) {
        super(va2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var, sv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.d = va2Var;
        this.c = y();
        this.b = sv1Var;
    }

    public static void F(@NonNull Request.Builder builder, sv1 sv1Var, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, builder, sv1Var, map) == null) || sv1Var == null || sv1Var.k() < 1) {
            return;
        }
        for (String str : sv1Var.j()) {
            if (!TextUtils.isEmpty(str) && !f.contains(str.toUpperCase(Locale.US))) {
                String f2 = fh3.f(sv1Var.H(str));
                if (!TextUtils.isEmpty(f2)) {
                    if (map != null) {
                        map.put(str.toLowerCase(Locale.US), f2);
                    }
                    builder.header(str, f2);
                }
            }
        }
    }

    public boolean A(@Nullable HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpUrl)) == null) ? (httpUrl == null || g.contains(httpUrl.host().toLowerCase(Locale.US))) ? false : true : invokeL.booleanValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            l33 M = l33.M();
            return M != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", M.O(), M.V()) : "";
        }
        return (String) invokeV.objValue;
    }

    public void C(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, str2) == null) {
            this.d.postOnJSThread(new c(this, str2, i));
        }
    }

    public void D(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.d.postOnJSThread(new b(this, obj));
        }
    }

    public HttpUrl E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (k33.K().w() == null) {
                if (A(parse)) {
                    return parse;
                }
                return null;
            } else if ((e && kz2.o()) || A(parse)) {
                return parse;
            } else {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public void G(@NonNull Request.Builder builder, sv1 sv1Var, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{builder, sv1Var, map, Boolean.valueOf(z)}) == null) {
            F(builder, sv1Var, map);
            if (z) {
                builder.header("Referer", B());
            }
        }
    }

    public void H(sv1 sv1Var) {
        sv1 sv1Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, sv1Var) == null) || sv1Var == null || (sv1Var2 = this.b) == null) {
            return;
        }
        sv1Var2.G("success", sv1Var.u("success"));
        this.b.G(com.baidu.pass.biometrics.face.liveness.b.a.g0, sv1Var.u(com.baidu.pass.biometrics.face.liveness.b.a.g0));
        this.b.G(TaskProcessData.keyComplete, sv1Var.u(TaskProcessData.keyComplete));
    }

    public JSONObject I(Headers headers) throws JSONException {
        InterceptResult invokeL;
        List<String> values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, headers)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (headers == null) {
                return jSONObject;
            }
            for (String str : headers.names()) {
                if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = values.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(values.get(i));
                        if (i == size - 1) {
                            break;
                        }
                        sb.append(",");
                    }
                    jSONObject.put(str, sb.toString());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @JavascriptInterface
    public void abort() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.b == null || l33.M() == null) {
            return;
        }
        l33.M().i0().cancelTag(this.c);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSEvent)) == null) {
            this.d.postOnJSThread(new a(this, jSEvent));
            return true;
        }
        return invokeL.booleanValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String g0 = l33.g0();
            if (TextUtils.isEmpty(g0)) {
                return "";
            }
            return g0 + "_" + System.currentTimeMillis();
        }
        return (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String B = this.b.B("url");
            if (this.b != null && !TextUtils.isEmpty(this.c)) {
                if (TextUtils.isEmpty(B)) {
                    C("", -1, "request:url is invalid");
                    return null;
                } else if (l33.M() == null) {
                    C("", -1, "request:swanApp is null");
                    return null;
                } else {
                    HttpUrl E = E(B);
                    if (E == null) {
                        C(B, -1, "request:url scheme is invalid");
                        return null;
                    }
                    String url = E.url().toString();
                    int c2 = c43.c("request", url, "");
                    if (c2 != 0) {
                        if (c2 == 1) {
                            C(url, -1, "request:host not in white list");
                            return null;
                        } else if (c2 != 2) {
                            C(url, -1, "request:host not in white list");
                            return null;
                        } else {
                            C(url, -1, "request:url header must be https or wss");
                            return null;
                        }
                    }
                    return url;
                }
            }
            C("", 0, "request:swanApp is null");
            return null;
        }
        return (String) invokeV.objValue;
    }
}
