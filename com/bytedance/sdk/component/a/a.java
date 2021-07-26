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
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27878a;

    /* renamed from: b  reason: collision with root package name */
    public m f27879b;

    /* renamed from: c  reason: collision with root package name */
    public h f27880c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f27881d;

    /* renamed from: e  reason: collision with root package name */
    public String f27882e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f27883f;

    /* renamed from: g  reason: collision with root package name */
    public g f27884g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, g> f27885h;

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
        this.f27881d = new Handler(Looper.getMainLooper());
        this.f27883f = false;
        this.f27885h = new HashMap();
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
            this.f27884g.a();
            for (g gVar : this.f27885h.values()) {
                gVar.a();
            }
            this.f27881d.removeCallbacksAndMessages(null);
            this.f27883f = true;
        }
    }

    public abstract void b(j jVar);

    public void invokeMethod(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f27883f) {
            return;
        }
        i.a("Received call: " + str);
        this.f27881d.post(new Runnable(this, str) { // from class: com.bytedance.sdk.component.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f27886a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f27887b;

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
                this.f27887b = this;
                this.f27886a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f27887b.f27883f) {
                    return;
                }
                q qVar = null;
                try {
                    qVar = this.f27887b.a(new JSONObject(this.f27886a));
                } catch (JSONException e2) {
                    i.b("Exception thrown while parsing function.", e2);
                }
                if (q.a(qVar)) {
                    i.a("By pass invalid call: " + qVar);
                    if (qVar != null) {
                        this.f27887b.b(y.a(new s(qVar.f27925a, "Failed to parse invocation.")), qVar);
                        return;
                    }
                    return;
                }
                this.f27887b.a(qVar);
            }
        });
    }

    public void a(String str, @Nullable q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, qVar) == null) {
            a(str);
        }
    }

    @MainThread
    public final void a(q qVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, qVar) == null) || this.f27883f || (a2 = a()) == null) {
            return;
        }
        g b2 = b(qVar.f27931g);
        if (b2 == null) {
            i.b("Received call with unknown namespace, " + qVar);
            m mVar = this.f27879b;
            if (mVar != null) {
                mVar.a(a(), qVar.f27928d, 2);
            }
            b(y.a(new s(-4, "Namespace " + qVar.f27931g + " unknown.")), qVar);
            return;
        }
        f fVar = new f();
        fVar.f27894b = a2;
        fVar.f27893a = this.f27878a;
        fVar.f27895c = b2;
        try {
            g.a a3 = b2.a(qVar, fVar);
            if (a3 == null) {
                i.b("Received call but not registered, " + qVar);
                if (this.f27879b != null) {
                    this.f27879b.a(a(), qVar.f27928d, 2);
                }
                b(y.a(new s(-2, "Function " + qVar.f27928d + " is not registered.")), qVar);
                return;
            }
            if (a3.f27911a) {
                b(a3.f27912b, qVar);
            }
            if (this.f27879b != null) {
                this.f27879b.a(a(), qVar.f27928d);
            }
        } catch (Exception e2) {
            i.a("call finished with error, " + qVar, e2);
            b(y.a(e2), qVar);
        }
    }

    public final void b(String str, q qVar) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, qVar) == null) || this.f27883f) {
            return;
        }
        if (TextUtils.isEmpty(qVar.f27930f)) {
            i.a("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith(StringUtil.ARRAY_START) || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Illegal callback data: " + str));
        }
        i.a("Invoking js callback: " + qVar.f27930f);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        a(p.a().a("__msg_type", "callback").a("__callback_id", qVar.f27930f).a("__params", jSONObject).b(), qVar);
    }

    @Nullable
    private g b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (!TextUtils.equals(str, this.f27882e) && !TextUtils.isEmpty(str)) {
                return this.f27885h.get(str);
            }
            return this.f27884g;
        }
        return (g) invokeL.objValue;
    }

    public final void a(j jVar, v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jVar, vVar) == null) {
            this.f27878a = a(jVar);
            this.f27880c = jVar.f27918d;
            this.f27879b = jVar.f27923i;
            this.f27884g = new g(jVar, this, vVar);
            this.f27882e = jVar.k;
            b(jVar);
        }
    }

    public final <T> void a(String str, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, t) == null) || this.f27883f) {
            return;
        }
        String a2 = this.f27880c.a((h) t);
        i.a("Sending js event: " + str);
        a("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + a2 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            if (this.f27883f) {
                return null;
            }
            String optString = jSONObject.optString("__callback_id");
            String optString2 = jSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
            String a2 = a();
            if (a2 == null) {
                m mVar = this.f27879b;
                if (mVar != null) {
                    mVar.a(null, null, 3);
                }
                return null;
            }
            try {
                String string = jSONObject.getString("__msg_type");
                String string2 = jSONObject.getString("params");
                String string3 = jSONObject.getString("JSSDK");
                return q.a().a(string3).b(string).c(optString2).d(string2).e(optString).f(jSONObject.optString("namespace")).g(jSONObject.optString("__iframe_url")).a();
            } catch (JSONException e2) {
                i.b("Failed to create call.", e2);
                m mVar2 = this.f27879b;
                if (mVar2 != null) {
                    mVar2.a(a2, optString2, 1);
                }
                return q.a(optString, -1);
            }
        }
        return (q) invokeL.objValue;
    }
}
