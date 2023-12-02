package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tieba.mz3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class kz3 extends EventTargetImpl implements nz3, mz3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public ud2 b;
    public String c;
    public boolean d;
    public vt3 e;
    public av3 f;
    public boolean g;
    public Map<String, String> h;
    public rz3 i;
    public zt3 j;
    @V8JavascriptField
    public mz3 style;

    /* loaded from: classes7.dex */
    public class a implements zt3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz3 a;

        public a(kz3 kz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz3Var;
        }

        @Override // com.baidu.tieba.zt3
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.a.i == null) {
                return;
            }
            if (z) {
                this.a.i.c();
            } else {
                this.a.i.b("3010010");
            }
        }

        @Override // com.baidu.tieba.zt3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = lz3.a(str);
                this.a.dispatchEvent(jSEvent);
                tv3.k(this.a.h, str);
            }
        }

        @Override // com.baidu.tieba.zt3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                String str2 = "gdtbanner";
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (!this.a.g) {
                        str2 = "banner";
                    }
                    iz3.b(str2, "success");
                    return;
                }
                if (!this.a.g) {
                    str2 = "banner";
                }
                iz3.c(str2, "fail", str);
            }
        }

        @Override // com.baidu.tieba.zt3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = lz3.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.zt3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                iz3.b("gdtbanner", "click");
            }
        }

        @Override // com.baidu.tieba.zt3
        public void onClose() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                x84 A = x84.A();
                String str2 = this.a.adUnitId;
                A.K(str2, "" + System.currentTimeMillis());
                if (this.a.g) {
                    str = "gdtbanner";
                } else {
                    str = "banner";
                }
                iz3.b(str, "close");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kz3 a;

        public b(kz3 kz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kz3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = lz3.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                tv3.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz3(ud2 ud2Var, JsObject jsObject) {
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
        this.style = null;
        this.h = new TreeMap();
        this.j = new a(this);
        this.b = ud2Var;
        sy1 G = sy1.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.a = G.C("appSid");
            sy1 x = G.x("style");
            if (x != null) {
                this.style = new mz3(x);
            }
        }
        boolean e = ew3.e();
        this.g = e;
        if (e) {
            this.a = ew3.a();
            this.adUnitId = ew3.b();
        }
        Map<String, String> a2 = tv3.a("banner", "game", this.a, this.adUnitId, this.g);
        this.h = a2;
        tv3.m("loadApi", a2);
        if (!A()) {
            return;
        }
        if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
            gz3 gz3Var = new gz3();
            this.f = gz3Var;
            vt3 vt3Var = new vt3(this.a, this.adUnitId, this.j, gz3Var);
            this.e = vt3Var;
            vt3Var.F(this.h);
            mz3 mz3Var = this.style;
            if (mz3Var != null) {
                this.e.E(mz3Var.left, mz3Var.top, mz3Var.width, mz3Var.height);
                this.style.b(this);
            }
            iz3.b(this.g ? "gdtbanner" : "banner", null);
            return;
        }
        ud2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    @Override // com.baidu.tieba.mz3.a
    public void i(String str) {
        vt3 vt3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !this.d && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && (vt3Var = this.e) != null) {
            vt3Var.H(str);
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                x84 A = x84.A();
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
            if (!TextUtils.isEmpty(this.c)) {
                this.b.postOnJSThread(new b(this));
                iz3.c("banner", "reject", this.c);
                return false;
            }
            return true;
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
            vt3 vt3Var = this.e;
            if (vt3Var != null) {
                vt3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        vt3 vt3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (vt3Var = this.e) != null) {
            vt3Var.B();
        }
    }

    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            if (this.g) {
                str = "gdtbanner";
            } else {
                str = "banner";
            }
            iz3.d(str);
            tv3.m("showApi", this.h);
            if (A() && this.e != null) {
                x84.A().E();
                this.i = rz3.d(sy1.G(jsObject));
                this.e.G(jsObject);
            }
        }
    }
}
