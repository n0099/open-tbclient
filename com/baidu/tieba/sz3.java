package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class sz3 extends EventTargetImpl implements pz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rv3 a;
    @V8JavascriptField
    public String adUnitId;
    public String b;
    public boolean c;
    public qz3 d;
    public rz3 e;
    public Map<String, String> f;
    public av3 g;
    public b h;
    public boolean i;
    public boolean j;
    public jl3 k;
    public qv3 l;

    /* loaded from: classes8.dex */
    public class a implements qv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz3 a;

        /* renamed from: com.baidu.tieba.sz3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0476a implements jl3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // com.baidu.tieba.jl3
            public void onViewDestroy() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            public C0476a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.jl3
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.i = false;
                    this.a.a.a.i0();
                }
            }

            @Override // com.baidu.tieba.jl3
            public void k() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a.i = true;
                    if (this.a.a.j) {
                        this.a.a.a.N();
                    }
                }
            }
        }

        public a(sz3 sz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz3Var;
        }

        @Override // com.baidu.tieba.qv3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                iz3.a(this.a.K(), "click", i);
            }
        }

        @Override // com.baidu.tieba.qv3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = tz3.b(str);
                this.a.dispatchEvent(jSEvent);
                tv3.k(this.a.f, str);
                this.a.destroy();
            }
        }

        @Override // com.baidu.tieba.qv3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.d != null) {
                        this.a.d.c();
                    }
                    oz3.b().c(16, "");
                    iz3.b(this.a.K(), "success");
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.b(str);
                }
                oz3.b().c(17, str);
                iz3.c(this.a.K(), "fail", str);
            }
        }

        @Override // com.baidu.tieba.qv3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    if (this.a.e != null) {
                        this.a.e.c();
                    }
                    if (this.a.h == null) {
                        this.a.h = new b(this.a, null);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        AppRuntime.getAppContext().registerReceiver(this.a.h, intentFilter);
                    }
                    if (this.a.k == null) {
                        this.a.k = new C0476a(this);
                        sz3.L(this.a.k);
                    }
                } else if (this.a.e != null) {
                    this.a.e.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.qv3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = tz3.a(z);
                this.a.dispatchEvent(jSEvent);
                iz3.a(this.a.K(), "pageclose", i);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz3 this$0;

        public b(sz3 sz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sz3Var;
        }

        public /* synthetic */ b(sz3 sz3Var, a aVar) {
            this(sz3Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    this.this$0.j = true;
                    if (this.this$0.i) {
                        this.this$0.a.N();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    this.this$0.j = false;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz3(ud2 ud2Var, JsObject jsObject) {
        super(ud2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var, jsObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adUnitId = "";
        this.f = new TreeMap();
        this.j = true;
        this.l = new a(this);
        sy1 G = sy1.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.b = G.C("appSid");
        }
        if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.b)) {
            boolean g = ew3.g();
            this.c = g;
            if (g) {
                this.b = ew3.c();
                this.adUnitId = ew3.d();
            }
            this.f = tv3.a("video", "game", this.b, this.adUnitId, this.c);
            this.g = new gz3();
            rv3 rv3Var = new rv3(xr2.V().getActivity(), this.b, this.adUnitId, this.c, this.l, this.g);
            this.a = rv3Var;
            rv3Var.k0(this.f);
            loadAd(null);
            return;
        }
        ud2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void L(jl3 jl3Var) {
        co1 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, jl3Var) == null) && (X = xr2.V().X()) != null) {
            X.e(jl3Var);
        }
    }

    public static void M(jl3 jl3Var) {
        co1 X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, jl3Var) == null) && (X = xr2.V().X()) != null) {
            X.f(jl3Var);
        }
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.d = qz3.d(sy1.G(jsObject));
                oz3.b().a(this.d);
                if (this.a != null) {
                    this.a.c0();
                }
            }
        }
    }

    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) {
            synchronized (this) {
                iz3.d(K());
                this.e = rz3.d(sy1.G(jsObject));
                if (this.a != null) {
                    this.a.l0();
                }
            }
        }
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.c) {
                return "gdtvideo";
            }
            return "video";
        }
        return (String) invokeV.objValue;
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.h != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.h);
                this.h = null;
            }
            jl3 jl3Var = this.k;
            if (jl3Var != null) {
                M(jl3Var);
                this.k = null;
            }
        }
    }
}
