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
/* loaded from: classes7.dex */
public class p44 extends EventTargetImpl implements m44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o04 a;
    @V8JavascriptField
    public String adUnitId;
    public String b;
    public boolean c;
    public n44 d;
    public o44 e;
    public Map<String, String> f;
    public xz3 g;
    public b h;
    public boolean i;
    public boolean j;
    public gq3 k;
    public n04 l;

    /* loaded from: classes7.dex */
    public class a implements n04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p44 a;

        /* renamed from: com.baidu.tieba.p44$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0431a implements gq3 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            @Override // com.baidu.tieba.gq3
            public void onViewDestroy() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            public C0431a(a aVar) {
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

            @Override // com.baidu.tieba.gq3
            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.i = false;
                    this.a.a.a.i0();
                }
            }

            @Override // com.baidu.tieba.gq3
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

        public a(p44 p44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p44Var;
        }

        @Override // com.baidu.tieba.n04
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                f44.a(this.a.getType(), "click", i);
            }
        }

        @Override // com.baidu.tieba.n04
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = q44.b(str);
                this.a.dispatchEvent(jSEvent);
                q04.k(this.a.f, str);
                this.a.destroy();
            }
        }

        @Override // com.baidu.tieba.n04
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (this.a.d != null) {
                        this.a.d.c();
                    }
                    l44.b().c(16, "");
                    f44.b(this.a.getType(), "success");
                    return;
                }
                if (this.a.d != null) {
                    this.a.d.b(str);
                }
                l44.b().c(17, str);
                f44.c(this.a.getType(), "fail", str);
            }
        }

        @Override // com.baidu.tieba.n04
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
                        this.a.k = new C0431a(this);
                        p44.K(this.a.k);
                    }
                } else if (this.a.e != null) {
                    this.a.e.b(str);
                }
            }
        }

        @Override // com.baidu.tieba.n04
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = q44.a(z);
                this.a.dispatchEvent(jSEvent);
                f44.a(this.a.getType(), "pageclose", i);
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p44 this$0;

        public b(p44 p44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = p44Var;
        }

        public /* synthetic */ b(p44 p44Var, a aVar) {
            this(p44Var);
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
    public p44(ri2 ri2Var, JsObject jsObject) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ri2Var, jsObject};
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
        o32 F = o32.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.b = F.B("appSid");
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.b)) {
            boolean g = b14.g();
            this.c = g;
            if (g) {
                this.b = b14.c();
                this.adUnitId = b14.d();
            }
            this.f = q04.a("video", "game", this.b, this.adUnitId, this.c);
            this.g = new d44();
            o04 o04Var = new o04(uw2.T().getActivity(), this.b, this.adUnitId, this.c, this.l, this.g);
            this.a = o04Var;
            o04Var.k0(this.f);
            loadAd(null);
            return;
        }
        ri2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    public static void K(gq3 gq3Var) {
        ys1 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, gq3Var) == null) && (V = uw2.T().V()) != null) {
            V.e(gq3Var);
        }
    }

    public static void L(gq3 gq3Var) {
        ys1 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, gq3Var) == null) && (V = uw2.T().V()) != null) {
            V.f(gq3Var);
        }
    }

    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            synchronized (this) {
                this.d = n44.d(o32.F(jsObject));
                l44.b().a(this.d);
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
                f44.d(getType());
                this.e = o44.d(o32.F(jsObject));
                if (this.a != null) {
                    this.a.l0();
                }
            }
        }
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h != null) {
                AppRuntime.getAppContext().unregisterReceiver(this.h);
                this.h = null;
            }
            gq3 gq3Var = this.k;
            if (gq3Var != null) {
                L(gq3Var);
                this.k = null;
            }
        }
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c) {
                return "gdtvideo";
            }
            return "video";
        }
        return (String) invokeV.objValue;
    }
}
