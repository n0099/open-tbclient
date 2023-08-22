package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.ma2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ra2 extends ja2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M0;
    public transient /* synthetic */ FieldHolder $fh;
    public mx1 G0;
    public kx1 H0;
    public String I0;
    public String J0;
    public String K0;
    public boolean L0;

    public void Y2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frameLayout) == null) {
        }
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ja2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a extends SwanAppWebViewWidget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 b0;

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean T1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ra2 ra2Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b0 = ra2Var;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean S1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b0.L0;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends oc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 c;

        public b(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ra2Var;
        }

        @Override // com.baidu.tieba.oc2, com.baidu.tieba.rc2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.c.Z2(str) && this.c.K0 != null) {
                    ra2 ra2Var = this.c;
                    ra2Var.f0.setTitle(ra2Var.K0);
                    return;
                }
                this.c.f0.setTitle(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 a;

        public c(ra2 ra2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ra2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.H0.canGoBack()) {
                    this.a.H0.goBack();
                } else {
                    this.a.j2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d13 a;
        public JSONObject b;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new JSONObject();
            this.a = d13.d(str, str);
        }

        public void c(zo4 zo4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zo4Var) != null) || zo4Var == null) {
                return;
            }
            this.a.b = this.b.toString();
            ra2 e3 = ra2.e3(this.a, "default_webview");
            bp4 a = zo4Var.a();
            a.a(R.id.obfuscated_res_0x7f09018a, e3);
            a.d(null);
            a.e();
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.b.put("should_check_domain", z);
                } catch (JSONException e) {
                    if (ra2.M0) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = this.b.toString();
                ra2.f3("default_webview", this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948114822, "Lcom/baidu/tieba/ra2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948114822, "Lcom/baidu/tieba/ra2;");
                return;
            }
        }
        M0 = nr1.a;
    }

    public ra2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.L0 = true;
    }

    @Override // com.baidu.tieba.ja2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            kx1 kx1Var = this.H0;
            if (kx1Var != null && kx1Var.canGoBack()) {
                this.H0.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public rc2 b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new b(this);
        }
        return (rc2) invokeV.objValue;
    }

    public mx1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new a(this, getContext());
        }
        return (mx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.G0.R();
            c3();
            this.g0.s(ku2.M().a(), I1());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            mx1 mx1Var = this.G0;
            if (mx1Var != null) {
                mx1Var.destroy();
                this.G0 = null;
            }
            super.z0();
        }
    }

    public static d d3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return new d(str);
        }
        return (d) invokeL.objValue;
    }

    public void h3(d13 d13Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, d13Var) == null) && d13Var != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", d13Var.c);
            bundle.putString("params", d13Var.b);
            j1(bundle);
        }
    }

    @Override // com.baidu.tieba.ja2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            mx1 mx1Var = this.G0;
            if (mx1Var != null) {
                return mx1Var.isSlidable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.v0(bundle);
            g3();
            if (M0) {
                Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
            }
        }
    }

    public static boolean a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ma2 U = qw2.T().U();
            if (U == null) {
                d82.i("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            d82.i("SwanAppWebViewFragment", "page closed! ");
            ma2.b h = U.h();
            h.n(ma2.i, ma2.h);
            h.g();
            h.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ra2 e3(d13 d13Var, String str) {
        InterceptResult invokeLL;
        char c2;
        ra2 x33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, d13Var, str)) == null) {
            switch (str.hashCode()) {
                case -1750679182:
                    if (str.equals("allianceLogin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -718660690:
                    if (str.equals("web_mode")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -130826522:
                    if (str.equals("allianceChooseAddress")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 113553927:
                    if (str.equals("wxPay")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 570452084:
                    if (str.equals("adLanding")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1221126139:
                    if (str.equals("default_webview")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1339472410:
                    if (str.equals("qrCodePay")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    x33Var = new x33();
                    break;
                case 1:
                    x33Var = new SwanAppAdLandingFragment();
                    break;
                case 2:
                    x33Var = new ra2();
                    break;
                case 3:
                    x33Var = new py1();
                    break;
                case 4:
                    x33Var = new xy1();
                    break;
                case 5:
                    x33Var = new t33();
                    break;
                case 6:
                    x33Var = new qa2();
                    break;
                default:
                    if (M0) {
                        Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    }
                    x33Var = null;
                    break;
            }
            if (x33Var != null) {
                x33Var.h3(d13Var);
            }
            return x33Var;
        }
        return (ra2) invokeLL.objValue;
    }

    public static boolean f3(String str, d13 d13Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, d13Var)) == null) {
            ma2 U = qw2.T().U();
            if (U == null) {
                d82.i("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            d82.i("SwanAppWebViewFragment", "open page url=" + d13Var.c);
            ma2.b h = U.h();
            h.n(ma2.g, ma2.i);
            h.k(str, d13Var).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ja2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.W1(view2);
            v2(-1);
            E2(-16777216);
            SwanAppActionBar swanAppActionBar = this.f0;
            String str = this.K0;
            if (str == null) {
                str = "";
            }
            swanAppActionBar.setTitle(str);
            this.f0.setRightZoneVisibility(false);
            z2(true);
            this.f0.setLeftBackViewClickListener(new c(this));
        }
    }

    public final boolean Z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.equals(this.I0, str) && !TextUtils.equals(this.I0.replace("http://", "").replace("https://", ""), str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g3() {
        Bundle o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (o = o()) != null) {
            this.I0 = o.getString("url");
            String string = o.getString("params");
            this.J0 = string;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.J0);
                this.K0 = jSONObject.optString("fallback_title", null);
                this.L0 = jSONObject.optBoolean("should_check_domain", true);
            } catch (JSONException e) {
                if (M0) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.kx1] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e4, viewGroup, false);
            W1(inflate);
            mx1 j = j();
            this.G0 = j;
            j.X(b3());
            this.H0 = this.G0.r();
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bf);
            this.G0.i(frameLayout, this.H0.covertToView());
            Y2(frameLayout);
            if (V1()) {
                inflate = Y1(inflate);
            }
            return E1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
