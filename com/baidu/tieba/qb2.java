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
import com.baidu.tieba.lb2;
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
public class qb2 extends ib2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M0;
    public transient /* synthetic */ FieldHolder $fh;
    public ly1 G0;
    public jy1 H0;
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

    @Override // com.baidu.tieba.ib2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
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
        public final /* synthetic */ qb2 b0;

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
        public a(qb2 qb2Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb2Var, context};
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
            this.b0 = qb2Var;
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
    public class b extends nd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb2 c;

        public b(qb2 qb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qb2Var;
        }

        @Override // com.baidu.tieba.nd2, com.baidu.tieba.qd2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.c.Z2(str) && this.c.K0 != null) {
                    qb2 qb2Var = this.c;
                    qb2Var.f0.setTitle(qb2Var.K0);
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
        public final /* synthetic */ qb2 a;

        public c(qb2 qb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb2Var;
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
        public c23 a;
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
            this.a = c23.d(str, str);
        }

        public void c(yp4 yp4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yp4Var) != null) || yp4Var == null) {
                return;
            }
            this.a.b = this.b.toString();
            qb2 e3 = qb2.e3(this.a, "default_webview");
            aq4 a = yp4Var.a();
            a.a(R.id.obfuscated_res_0x7f090187, e3);
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
                    if (qb2.M0) {
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
                qb2.f3("default_webview", this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948085992, "Lcom/baidu/tieba/qb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948085992, "Lcom/baidu/tieba/qb2;");
                return;
            }
        }
        M0 = ms1.a;
    }

    public qb2() {
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

    @Override // com.baidu.tieba.ib2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jy1 jy1Var = this.H0;
            if (jy1Var != null && jy1Var.canGoBack()) {
                this.H0.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public qd2 b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new b(this);
        }
        return (qd2) invokeV.objValue;
    }

    public ly1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new a(this, getContext());
        }
        return (ly1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ib2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.G0.R();
            c3();
            this.g0.t(jv2.M().a(), J1());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ly1 ly1Var = this.G0;
            if (ly1Var != null) {
                ly1Var.destroy();
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

    public void h3(c23 c23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, c23Var) == null) && c23Var != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", c23Var.c);
            bundle.putString("params", c23Var.b);
            k1(bundle);
        }
    }

    @Override // com.baidu.tieba.ib2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            ly1 ly1Var = this.G0;
            if (ly1Var != null) {
                return ly1Var.isSlidable(motionEvent);
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
            lb2 U = px2.T().U();
            if (U == null) {
                c92.i("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            c92.i("SwanAppWebViewFragment", "page closed! ");
            lb2.b h = U.h();
            h.n(lb2.i, lb2.h);
            h.g();
            h.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static qb2 e3(c23 c23Var, String str) {
        InterceptResult invokeLL;
        char c2;
        qb2 w43Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, c23Var, str)) == null) {
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
                    w43Var = new w43();
                    break;
                case 1:
                    w43Var = new SwanAppAdLandingFragment();
                    break;
                case 2:
                    w43Var = new qb2();
                    break;
                case 3:
                    w43Var = new oz1();
                    break;
                case 4:
                    w43Var = new wz1();
                    break;
                case 5:
                    w43Var = new s43();
                    break;
                case 6:
                    w43Var = new pb2();
                    break;
                default:
                    if (M0) {
                        Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    }
                    w43Var = null;
                    break;
            }
            if (w43Var != null) {
                w43Var.h3(c23Var);
            }
            return w43Var;
        }
        return (qb2) invokeLL.objValue;
    }

    public static boolean f3(String str, c23 c23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, c23Var)) == null) {
            lb2 U = px2.T().U();
            if (U == null) {
                c92.i("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            c92.i("SwanAppWebViewFragment", "open page url=" + c23Var.c);
            lb2.b h = U.h();
            h.n(lb2.g, lb2.i);
            h.k(str, c23Var).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.ib2
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

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.jy1] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e3, viewGroup, false);
            W1(inflate);
            ly1 j = j();
            this.G0 = j;
            j.W(b3());
            this.H0 = this.G0.r();
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc);
            this.G0.i(frameLayout, this.H0.covertToView());
            Y2(frameLayout);
            if (V1()) {
                inflate = Y1(inflate);
            }
            return F1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
