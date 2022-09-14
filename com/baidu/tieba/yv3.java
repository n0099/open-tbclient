package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tieba.aw3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class yv3 extends EventTargetImpl implements bw3, aw3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public ia2 b;
    public String c;
    public boolean d;
    public jq3 e;
    public or3 f;
    public boolean g;
    public Map<String, String> h;
    public fw3 i;
    public nq3 j;
    @V8JavascriptField
    public aw3 style;

    /* loaded from: classes6.dex */
    public class a implements nq3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv3 a;

        public a(yv3 yv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv3Var;
        }

        @Override // com.baidu.tieba.nq3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    wv3.b(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "success");
                    return;
                }
                wv3.c(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }

        @Override // com.baidu.tieba.nq3
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a.i == null) {
                return;
            }
            if (z) {
                this.a.i.c();
            } else {
                this.a.i.b("3010010");
            }
        }

        @Override // com.baidu.tieba.nq3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = zv3.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.nq3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                wv3.b("gdtbanner", "click");
            }
        }

        @Override // com.baidu.tieba.nq3
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                l54 A = l54.A();
                String str = this.a.adUnitId;
                A.K(str, "" + System.currentTimeMillis());
                wv3.b(this.a.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER, "close");
            }
        }

        @Override // com.baidu.tieba.nq3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = zv3.a(str);
                this.a.dispatchEvent(jSEvent);
                hs3.k(this.a.h, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yv3 a;

        public b(yv3 yv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = zv3.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                hs3.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv3(ia2 ia2Var, JsObject jsObject) {
        super(ia2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia2Var, jsObject};
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
        this.style = null;
        this.h = new TreeMap();
        this.j = new a(this);
        this.b = ia2Var;
        fv1 F = fv1.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.a = F.B("appSid");
            fv1 w = F.w("style");
            if (w != null) {
                this.style = new aw3(w);
            }
        }
        boolean e = ss3.e();
        this.g = e;
        if (e) {
            this.a = ss3.a();
            this.adUnitId = ss3.b();
        }
        String str = this.a;
        String str2 = this.adUnitId;
        boolean z = this.g;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a2 = hs3.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.h = a2;
        hs3.m("loadApi", a2);
        if (B()) {
            if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
                uv3 uv3Var = new uv3();
                this.f = uv3Var;
                jq3 jq3Var = new jq3(this.a, this.adUnitId, this.j, uv3Var);
                this.e = jq3Var;
                jq3Var.F(this.h);
                aw3 aw3Var = this.style;
                if (aw3Var != null) {
                    this.e.E(aw3Var.left, aw3Var.top, aw3Var.width, aw3Var.height);
                    this.style.b(this);
                }
                wv3.b(this.g ? "gdtbanner" : str3, null);
                return;
            }
            ia2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                l54 A = l54.A();
                if (!A.k()) {
                    if (!A.l()) {
                        if (A.t(this.adUnitId)) {
                            this.c = "3010011";
                        }
                    } else {
                        this.c = "3010013";
                    }
                } else {
                    this.c = "3010012";
                }
            }
            if (TextUtils.isEmpty(this.c)) {
                return true;
            }
            this.b.postOnJSThread(new b(this));
            wv3.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.c);
            return false;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = true;
            removeEventListener("error", null);
            removeEventListener("load", null);
            removeEventListener("resize", null);
            jq3 jq3Var = this.e;
            if (jq3Var != null) {
                jq3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        jq3 jq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jq3Var = this.e) == null) {
            return;
        }
        jq3Var.B();
    }

    @Override // com.baidu.tieba.aw3.a
    public void i(String str) {
        jq3 jq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.d || TextUtils.isEmpty(str) || str.equals("height") || this.style == null || (jq3Var = this.e) == null) {
            return;
        }
        jq3Var.H(str);
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            wv3.d(this.g ? "gdtbanner" : SpeedStatsUtils.UBC_VALUE_BANNER);
            hs3.m("showApi", this.h);
            if (!B() || this.e == null) {
                return;
            }
            l54.A().E();
            this.i = fw3.d(fv1.F(jsObject));
            this.e.G(jsObject);
        }
    }
}
