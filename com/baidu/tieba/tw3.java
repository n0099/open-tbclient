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
/* loaded from: classes6.dex */
public class tw3 extends EventTargetImpl implements qw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ss3 a;
    @V8JavascriptField
    public String adUnitId;
    public String b;
    public boolean c;
    public rw3 d;
    public sw3 e;
    public Map<String, String> f;
    public bs3 g;
    public b h;
    public boolean i;
    public boolean j;
    public ki3 k;
    public rs3 l;

    /* loaded from: classes6.dex */
    public class a implements rs3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw3 a;

        /* renamed from: com.baidu.tieba.tw3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0433a implements ki3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0433a(a aVar) {
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

            @Override // com.baidu.tieba.ki3
            public void e() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.i = false;
                    this.a.a.a.i0();
                }
            }

            @Override // com.baidu.tieba.ki3
            public void l() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a.i = true;
                    if (this.a.a.j) {
                        this.a.a.a.N();
                    }
                }
            }

            @Override // com.baidu.tieba.ki3
            public void onViewDestroy() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }
        }

        public a(tw3 tw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tw3Var;
        }

        @Override // com.baidu.tieba.rs3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.d != null) {
                        this.a.d.c();
                    }
                    pw3.b().c(16, "");
                    jw3.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.b(str);
                }
                pw3.b().c(17, str);
                jw3.c(this.a.getType(), com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // com.baidu.tieba.rs3
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
                        this.a.k = new C0433a(this);
                        tw3.L(this.a.k);
                    }
                } else if (this.a.e != null) {
                    this.a.e.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.rs3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = uw3.a(z);
                this.a.dispatchEvent(jSEvent);
                jw3.a(this.a.getType(), "pageclose", i);
                this.a.destroy();
            }
        }

        @Override // com.baidu.tieba.rs3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                jw3.a(this.a.getType(), "click", i);
            }
        }

        @Override // com.baidu.tieba.rs3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = uw3.b(str);
                this.a.dispatchEvent(jSEvent);
                us3.k(this.a.f, str);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw3 this$0;

        public b(tw3 tw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = tw3Var;
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

        public /* synthetic */ b(tw3 tw3Var, a aVar) {
            this(tw3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tw3(va2 va2Var, JsObject jsObject) {
        super(va2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {va2Var, jsObject};
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
        sv1 F = sv1.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.b = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.b)) {
            boolean g = ft3.g();
            this.c = g;
            if (g) {
                this.b = ft3.c();
                this.adUnitId = ft3.d();
            }
            this.f = us3.a("video", "game", this.b, this.adUnitId, this.c);
            this.g = new hw3();
            ss3 ss3Var = new ss3(yo2.U().getActivity(), this.b, this.adUnitId, this.c, this.l, this.g);
            this.a = ss3Var;
            ss3Var.k0(this.f);
            loadAd(null);
            return;
        }
        va2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void L(ki3 ki3Var) {
        cl1 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, ki3Var) == null) || (W = yo2.U().W()) == null) {
            return;
        }
        W.e(ki3Var);
    }

    public static void M(ki3 ki3Var) {
        cl1 W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, ki3Var) == null) || (W = yo2.U().W()) == null) {
            return;
        }
        W.f(ki3Var);
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.h);
                this.h = null;
            }
            ki3 ki3Var = this.k;
            if (ki3Var != null) {
                M(ki3Var);
                this.k = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c ? "gdtvideo" : "video" : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.d = rw3.d(sv1.F(jsObject));
                pw3.b().a(this.d);
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
                jw3.d(getType());
                this.e = sw3.d(sv1.F(jsObject));
                if (this.a != null) {
                    this.a.l0();
                }
            }
        }
    }
}
