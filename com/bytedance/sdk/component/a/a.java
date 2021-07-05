package com.bytedance.sdk.component.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.component.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27610a;

    /* renamed from: b  reason: collision with root package name */
    public m f27611b;

    /* renamed from: c  reason: collision with root package name */
    public h f27612c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f27613d;

    /* renamed from: e  reason: collision with root package name */
    public String f27614e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f27615f;

    /* renamed from: g  reason: collision with root package name */
    public g f27616g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, g> f27617h;

    public a() {
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
        this.f27613d = new Handler(Looper.getMainLooper());
        this.f27615f = false;
        this.f27617h = new HashMap();
    }

    @NonNull
    public abstract Context a(j jVar);

    @Nullable
    public abstract String a();

    @AnyThread
    public abstract void a(String str);

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27616g.a();
            for (g gVar : this.f27617h.values()) {
                gVar.a();
            }
            this.f27613d.removeCallbacksAndMessages(null);
            this.f27615f = true;
        }
    }

    public abstract void b(j jVar);

    public void invokeMethod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f27615f) {
            return;
        }
        i.a("Received call: " + str);
        this.f27613d.post(new Runnable(this, str) { // from class: com.bytedance.sdk.component.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f27618a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f27619b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27619b = this;
                this.f27618a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f27619b.f27615f) {
                    return;
                }
                p pVar = null;
                try {
                    pVar = this.f27619b.a(new JSONObject(this.f27618a));
                } catch (JSONException e2) {
                    i.b("Exception thrown while parsing function.", e2);
                }
                if (p.a(pVar)) {
                    i.a("By pass invalid call: " + pVar);
                    if (pVar != null) {
                        this.f27619b.b(x.a(new r(pVar.f27656a, "Failed to parse invocation.")), pVar);
                        return;
                    }
                    return;
                }
                this.f27619b.a(pVar);
            }
        });
    }

    public void a(String str, @Nullable p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, pVar) == null) {
            a(str);
        }
    }

    @MainThread
    public final void a(p pVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) || this.f27615f || (a2 = a()) == null) {
            return;
        }
        g b2 = b(pVar.f27662g);
        if (b2 == null) {
            i.b("Received call with unknown namespace, " + pVar);
            m mVar = this.f27611b;
            if (mVar != null) {
                mVar.a(a(), pVar.f27659d, 2);
            }
            b(x.a(new r(-4, "Namespace " + pVar.f27662g + " unknown.")), pVar);
            return;
        }
        f fVar = new f();
        fVar.f27626b = a2;
        fVar.f27625a = this.f27610a;
        fVar.f27627c = b2;
        try {
            g.a a3 = b2.a(pVar, fVar);
            if (a3 == null) {
                i.b("Received call but not registered, " + pVar);
                if (this.f27611b != null) {
                    this.f27611b.a(a(), pVar.f27659d, 2);
                }
                b(x.a(new r(-2, "Function " + pVar.f27659d + " is not registered.")), pVar);
                return;
            }
            if (a3.f27643a) {
                b(a3.f27644b, pVar);
            }
            if (this.f27611b != null) {
                this.f27611b.a(a(), pVar.f27659d);
            }
        } catch (Exception e2) {
            i.a("call finished with error, " + pVar, e2);
            b(x.a(e2), pVar);
        }
    }

    public final void b(String str, p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, pVar) == null) || this.f27615f) {
            return;
        }
        if (TextUtils.isEmpty(pVar.f27661f)) {
            i.a("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith(StringUtil.ARRAY_START) || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Illegal callback data: " + str));
        }
        i.a("Invoking js callback: " + pVar.f27661f);
        a("{\"__msg_type\":\"callback\",\"__callback_id\":\"" + pVar.f27661f + "\",\"__params\":" + str + "}", pVar);
    }

    @Nullable
    private g b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (!TextUtils.equals(str, this.f27614e) && !TextUtils.isEmpty(str)) {
                return this.f27617h.get(str);
            }
            return this.f27616g;
        }
        return (g) invokeL.objValue;
    }

    public final void a(j jVar, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jVar, uVar) == null) {
            this.f27610a = a(jVar);
            this.f27612c = jVar.f27650d;
            this.f27611b = jVar.f27655i;
            this.f27616g = new g(jVar, this, uVar);
            this.f27614e = jVar.k;
            b(jVar);
        }
    }

    public final <T> void a(String str, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, t) == null) || this.f27615f) {
            return;
        }
        String a2 = this.f27612c.a((h) t);
        i.a("Sending js event: " + str);
        a("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + a2 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            if (this.f27615f) {
                return null;
            }
            String optString = jSONObject.optString("__callback_id");
            String optString2 = jSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
            String a2 = a();
            if (a2 == null) {
                m mVar = this.f27611b;
                if (mVar != null) {
                    mVar.a(null, null, 3);
                }
                return null;
            }
            try {
                String string = jSONObject.getString("__msg_type");
                String string2 = jSONObject.getString("params");
                String string3 = jSONObject.getString("JSSDK");
                return p.a().a(string3).b(string).c(optString2).d(string2).e(optString).f(jSONObject.optString("namespace")).g(jSONObject.optString("__iframe_url")).a();
            } catch (JSONException e2) {
                i.b("Failed to create call.", e2);
                m mVar2 = this.f27611b;
                if (mVar2 != null) {
                    mVar2.a(a2, optString2, 1);
                }
                return p.a(optString, -1);
            }
        }
        return (p) invokeL.objValue;
    }
}
