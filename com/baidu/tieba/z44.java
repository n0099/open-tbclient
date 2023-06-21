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
import com.baidu.tieba.b54;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class z44 extends EventTargetImpl implements c54, b54.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @V8JavascriptField
    public String adUnitId;
    public jj2 b;
    public String c;
    public boolean d;
    public kz3 e;
    public p04 f;
    public boolean g;
    public Map<String, String> h;
    public g54 i;
    public oz3 j;
    @V8JavascriptField
    public b54 style;

    /* loaded from: classes8.dex */
    public class a implements oz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z44 a;

        public a(z44 z44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z44Var;
        }

        @Override // com.baidu.tieba.oz3
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

        @Override // com.baidu.tieba.oz3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = a54.a(str);
                this.a.dispatchEvent(jSEvent);
                i14.k(this.a.h, str);
            }
        }

        @Override // com.baidu.tieba.oz3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                String str2 = "gdtbanner";
                if (z) {
                    this.a.dispatchEvent(new JSEvent("load"));
                    if (!this.a.g) {
                        str2 = SpeedStatsUtils.UBC_VALUE_BANNER;
                    }
                    x44.b(str2, "success");
                    return;
                }
                if (!this.a.g) {
                    str2 = SpeedStatsUtils.UBC_VALUE_BANNER;
                }
                x44.c(str2, "fail", str);
            }
        }

        @Override // com.baidu.tieba.oz3
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = a54.b(i, i2);
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.baidu.tieba.oz3
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g) {
                x44.b("gdtbanner", "click");
            }
        }

        @Override // com.baidu.tieba.oz3
        public void onClose() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.destroy();
                me4 A = me4.A();
                String str2 = this.a.adUnitId;
                A.K(str2, "" + System.currentTimeMillis());
                if (this.a.g) {
                    str = "gdtbanner";
                } else {
                    str = SpeedStatsUtils.UBC_VALUE_BANNER;
                }
                x44.b(str, "close");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z44 a;

        public b(z44 z44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z44Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = a54.a(this.a.c);
                this.a.dispatchEvent(jSEvent);
                i14.k(this.a.h, this.a.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z44(jj2 jj2Var, JsObject jsObject) {
        super(jj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jj2Var, jsObject};
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
        this.b = jj2Var;
        g42 F = g42.F(jsObject);
        if (F != null) {
            this.adUnitId = F.B("adUnitId");
            this.a = F.B("appSid");
            g42 w = F.w("style");
            if (w != null) {
                this.style = new b54(w);
            }
        }
        boolean e = t14.e();
        this.g = e;
        if (e) {
            this.a = t14.a();
            this.adUnitId = t14.b();
        }
        String str = this.a;
        String str2 = this.adUnitId;
        boolean z = this.g;
        String str3 = SpeedStatsUtils.UBC_VALUE_BANNER;
        Map<String, String> a2 = i14.a(SpeedStatsUtils.UBC_VALUE_BANNER, "game", str, str2, z);
        this.h = a2;
        i14.m("loadApi", a2);
        if (!B()) {
            return;
        }
        if (F != null && !TextUtils.isEmpty(this.adUnitId) && !TextUtils.isEmpty(this.a) && this.style != null) {
            v44 v44Var = new v44();
            this.f = v44Var;
            kz3 kz3Var = new kz3(this.a, this.adUnitId, this.j, v44Var);
            this.e = kz3Var;
            kz3Var.F(this.h);
            b54 b54Var = this.style;
            if (b54Var != null) {
                this.e.E(b54Var.left, b54Var.top, b54Var.width, b54Var.height);
                this.style.b(this);
            }
            x44.b(this.g ? "gdtbanner" : str3, null);
            return;
        }
        jj2Var.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
    }

    @Override // com.baidu.tieba.b54.a
    public void i(String str) {
        kz3 kz3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !this.d && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && (kz3Var = this.e) != null) {
            kz3Var.H(str);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                me4 A = me4.A();
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
                x44.c(SpeedStatsUtils.UBC_VALUE_BANNER, "reject", this.c);
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
            kz3 kz3Var = this.e;
            if (kz3Var != null) {
                kz3Var.y();
                this.e = null;
            }
        }
    }

    @JavascriptInterface
    public void hide() {
        kz3 kz3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (kz3Var = this.e) != null) {
            kz3Var.B();
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
                str = SpeedStatsUtils.UBC_VALUE_BANNER;
            }
            x44.d(str);
            i14.m("showApi", this.h);
            if (B() && this.e != null) {
                me4.A().E();
                this.i = g54.d(g42.F(jsObject));
                this.e.G(jsObject);
            }
        }
    }
}
