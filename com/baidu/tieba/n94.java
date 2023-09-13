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
/* loaded from: classes7.dex */
public class n94 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final Set<String> g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public o32 b;
    public String c;
    public ri2 d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSEvent a;
        public final /* synthetic */ n94 b;

        public a(n94 n94Var, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n94Var;
            this.a = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            n94.super.dispatchEvent(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Object a;
        public final /* synthetic */ n94 b;

        public b(n94 n94Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n94Var;
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                td4.call(this.b.b, true, this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ n94 c;

        public c(n94 n94Var, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n94Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n94Var;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                x94 x94Var = new x94();
                x94Var.errMsg = this.a;
                x94Var.statusCode = this.b;
                td4.call(this.c.b, false, x94Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957280, "Lcom/baidu/tieba/n94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957280, "Lcom/baidu/tieba/n94;");
                return;
            }
        }
        e = rr1.a;
        f = Sets.newHashSet("REFERER", "USER-AGENT");
        g = Sets.newHashSet("localhost", "127.0.0.1");
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            hb3 M = hb3.M();
            if (M != null) {
                return String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", M.O(), M.V());
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String g0 = hb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return "";
            }
            return g0 + "_" + System.currentTimeMillis();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n94(@NonNull ri2 ri2Var, o32 o32Var) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var, o32Var};
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
        this.d = ri2Var;
        this.c = x();
        this.b = o32Var;
    }

    public static void E(@NonNull Request.Builder builder, o32 o32Var, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, builder, o32Var, map) == null) && o32Var != null && o32Var.k() >= 1) {
            for (String str : o32Var.j()) {
                if (!TextUtils.isEmpty(str) && !f.contains(str.toUpperCase(Locale.US))) {
                    String f2 = bp3.f(o32Var.H(str));
                    if (!TextUtils.isEmpty(f2)) {
                        if (map != null) {
                            map.put(str.toLowerCase(Locale.US), f2);
                        }
                        builder.header(str, f2);
                    }
                }
            }
        }
    }

    public void B(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) {
            this.d.postOnJSThread(new c(this, str2, i));
        }
    }

    public void C(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            this.d.postOnJSThread(new b(this, obj));
        }
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSEvent)) == null) {
            this.d.postOnJSThread(new a(this, jSEvent));
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean z(@Nullable HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, httpUrl)) == null) {
            if (httpUrl != null && !g.contains(httpUrl.host().toLowerCase(Locale.US))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HttpUrl D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (gb3.K().w() == null) {
                if (!z(parse)) {
                    return null;
                }
                return parse;
            } else if (e && g73.o()) {
                return parse;
            } else {
                if (!z(parse)) {
                    return null;
                }
                return parse;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public void G(o32 o32Var) {
        o32 o32Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, o32Var) == null) && o32Var != null && (o32Var2 = this.b) != null) {
            o32Var2.G("success", o32Var.u("success"));
            this.b.G("fail", o32Var.u("fail"));
            this.b.G(TaskProcessData.keyComplete, o32Var.u(TaskProcessData.keyComplete));
        }
    }

    public void F(@NonNull Request.Builder builder, o32 o32Var, Map<String, String> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{builder, o32Var, map, Boolean.valueOf(z)}) == null) {
            E(builder, o32Var, map);
            if (z) {
                builder.header("Referer", A());
            }
        }
    }

    public JSONObject H(Headers headers) throws JSONException {
        InterceptResult invokeL;
        List<String> values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, headers)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b != null && hb3.M() != null) {
            hb3.M().i0().cancelTag(this.c);
        }
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String B = this.b.B("url");
            if (this.b != null && !TextUtils.isEmpty(this.c)) {
                if (TextUtils.isEmpty(B)) {
                    B("", -1, "request:url is invalid");
                    return null;
                } else if (hb3.M() == null) {
                    B("", -1, "request:swanApp is null");
                    return null;
                } else {
                    HttpUrl D = D(B);
                    if (D == null) {
                        B(B, -1, "request:url scheme is invalid");
                        return null;
                    }
                    String url = D.url().toString();
                    int c2 = yb3.c("request", url, "");
                    if (c2 != 0) {
                        if (c2 != 1) {
                            if (c2 != 2) {
                                B(url, -1, "request:host not in white list");
                                return null;
                            }
                            B(url, -1, "request:url header must be https or wss");
                            return null;
                        }
                        B(url, -1, "request:host not in white list");
                        return null;
                    }
                    return url;
                }
            }
            B("", 0, "request:swanApp is null");
            return null;
        }
        return (String) invokeV.objValue;
    }
}
