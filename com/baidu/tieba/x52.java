package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class x52 extends y52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public FrameLayout O0;

    /* loaded from: classes9.dex */
    public class a extends v72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x52 c;

        public a(x52 x52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = x52Var;
        }

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return ye3.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false);
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251284, "Lcom/baidu/tieba/x52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251284, "Lcom/baidu/tieba/x52;");
                return;
            }
        }
        P0 = vm1.a;
    }

    public x52() {
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
        this.N0 = 20;
    }

    @Override // com.baidu.tieba.y52
    public y72 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new a(this);
        }
        return (y72) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y52
    public us1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ed2.V().g0().a(z());
        }
        return (us1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q52
    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.n2();
            fm3.a().j();
        }
    }

    public URI n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return new URI(cm3.c().a().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public URI o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return new URI(cm3.c().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (j2()) {
                return 19;
            }
            return this.N0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.ss1] */
    @Override // com.baidu.tieba.y52, com.baidu.swan.support.v4.app.Fragment
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e6, viewGroup, false);
            a2(inflate);
            us1 j = j();
            this.G0 = j;
            j.V(g3());
            this.H0 = this.G0.getWebView();
            fm3.a().i(this.I0);
            cm3.c().m("0");
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901e2);
            this.O0 = frameLayout;
            this.G0.i(frameLayout, this.H0.covertToView());
            d3(this.O0);
            if (Z1()) {
                inflate = c2(inflate);
                B1(0, true);
            }
            bk3.Q(n());
            cm3.c().p(this.G0.a());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.q52
    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.G0 == null) {
                if (P0) {
                    Log.e("SwanAppWebModeFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String a2 = this.G0.a();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
            ss1 ss1Var = this.H0;
            if (ss1Var != null) {
                hashMap.put("webViewUrl", ss1Var.getUrl());
            }
            lg2 lg2Var = new lg2("sharebtn", hashMap);
            xr2.V().n(a2, lg2Var);
            k32.i("SwanAppWebModeFragment", "share msg: " + lg2Var.s().toString());
        }
    }

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public void a2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.a2(view2);
            this.f0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.topMargin = bk3.t();
            this.f0.setLayoutParams(layoutParams);
        }
    }

    public void q3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.N0 = i;
        }
    }

    @Override // com.baidu.tieba.y52
    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FragmentActivity n = n();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(z());
            }
            if (n != null && this.g0 == null) {
                this.g0 = new rc4(n, this.f0, p3(), rp2.K(), new tl3());
                new aw2(this.g0, this, this.h0).z();
            }
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            URI o3 = o3();
            URI n3 = n3();
            if (o3 != null && n3 != null) {
                if (!TextUtils.equals(o3.getPath(), n3.getPath()) && !TextUtils.equals(o3.getQuery(), n3.getQuery())) {
                    this.G0.loadUrl(n3.toString());
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: refresh url " + n3.toString());
                    }
                    cm3.c().m("3");
                    fm3.b("3");
                    fm3.a().m();
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                        return;
                    }
                    return;
                }
                uc3.s(j63.K().q().X());
                if (P0) {
                    Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
                }
            }
        }
    }

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(id2.n(j63.K().getAppId()));
            }
            this.g0.t(rp2.M().a(), M1(), this.h0, false);
        }
    }
}
