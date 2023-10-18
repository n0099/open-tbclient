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
import com.baidu.tieba.ry3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class py3 extends EventTargetImpl implements sy3, ry3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public zc2 b;
    public String c;
    public boolean d;
    public at3 e;
    public fu3 f;
    public boolean g;
    public Map<String, String> h;
    public wy3 i;
    public et3 j;
    @V8JavascriptField
    public ry3 style;

    /* loaded from: classes7.dex */
    public class a implements et3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py3 a;

        public a(py3 py3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py3Var;
        }

        @Override // com.baidu.tieba.et3
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

        @Override // com.baidu.tieba.et3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = qy3.a(str);
                this.a.dispatchEvent(jSEvent);
                yu3.k(this.a.h, str);
            }
        }

        @Override // com.baidu.tieba.et3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                String str2 = "gdtbanner";
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (!this.a.g) {
                        str2 = "banner";
                    }
                    ny3.b(str2, "success");
                    return;
                }
                if (!this.a.g) {
                    str2 = "banner";
                }
                ny3.c(str2, "fail", str);
            }
        }

        @Override // com.baidu.tieba.et3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = qy3.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.et3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                ny3.b("gdtbanner", "click");
            }
        }

        @Override // com.baidu.tieba.et3
        public void onClose() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                c84 A = c84.A();
                String str2 = this.a.adUnitId;
                A.K(str2, "" + System.currentTimeMillis());
                if (this.a.g) {
                    str = "gdtbanner";
                } else {
                    str = "banner";
                }
                ny3.b(str, "close");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py3 a;

        public b(py3 py3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = qy3.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                yu3.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public py3(zc2 zc2Var, JsObject jsObject) {
        super(zc2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc2Var, jsObject};
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
        this.b = zc2Var;
        xx1 G = xx1.G(jsObject);
        if (G != null) {
            this.adUnitId = G.C("adUnitId");
            this.a = G.C("appSid");
            xx1 x = G.x("style");
            if (x != null) {
                this.style = new ry3(x);
            }
        }
        boolean e = jv3.e();
        this.g = e;
        if (e) {
            this.a = jv3.a();
            this.adUnitId = jv3.b();
        }
        Map<String, String> a2 = yu3.a("banner", "game", this.a, this.adUnitId, this.g);
        this.h = a2;
        yu3.m("loadApi", a2);
        if (!A()) {
            return;
        }
        if (G != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
            ly3 ly3Var = new ly3();
            this.f = ly3Var;
            at3 at3Var = new at3(this.a, this.adUnitId, this.j, ly3Var);
            this.e = at3Var;
            at3Var.F(this.h);
            ry3 ry3Var = this.style;
            if (ry3Var != null) {
                this.e.E(ry3Var.left, ry3Var.top, ry3Var.width, ry3Var.height);
                this.style.b(this);
            }
            ny3.b(this.g ? "gdtbanner" : "banner", null);
            return;
        }
        zc2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    @Override // com.baidu.tieba.ry3.a
    public void i(String str) {
        at3 at3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !this.d && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && (at3Var = this.e) != null) {
            at3Var.H(str);
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                c84 A = c84.A();
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
                ny3.c("banner", "reject", this.c);
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
            at3 at3Var = this.e;
            if (at3Var != null) {
                at3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        at3 at3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (at3Var = this.e) != null) {
            at3Var.B();
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
            ny3.d(str);
            yu3.m("showApi", this.h);
            if (A() && this.e != null) {
                c84.A().E();
                this.i = wy3.d(xx1.G(jsObject));
                this.e.G(jsObject);
            }
        }
    }
}
