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
/* loaded from: classes8.dex */
public class ua2 extends va2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public FrameLayout O0;

    /* loaded from: classes8.dex */
    public class a extends sc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ua2 c;

        public a(ua2 ua2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ua2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ua2Var;
        }

        @Override // com.baidu.tieba.sc2, com.baidu.tieba.vc2
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return vj3.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false);
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948204195, "Lcom/baidu/tieba/ua2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948204195, "Lcom/baidu/tieba/ua2;");
                return;
            }
        }
        P0 = rr1.a;
    }

    public ua2() {
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

    @Override // com.baidu.tieba.va2
    public vc2 b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (vc2) invokeV.objValue;
    }

    public URI i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(zq3.c().a().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // com.baidu.tieba.va2
    public qx1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return bi2.U().f0().a(getContext());
        }
        return (qx1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.na2
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.j2();
            cr3.a().j();
        }
    }

    public URI j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return new URI(zq3.c().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (f2()) {
                return 19;
            }
            return this.N0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.na2
    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            ox1 ox1Var = this.H0;
            if (ox1Var != null) {
                hashMap.put("webViewUrl", ox1Var.getUrl());
            }
            il2 il2Var = new il2("sharebtn", hashMap);
            uw2.T().m(a2, il2Var);
            h82.i("SwanAppWebModeFragment", "share msg: " + il2Var.s().toString());
        }
    }

    @Override // com.baidu.tieba.va2, com.baidu.tieba.na2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.W1(view2);
            this.f0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.topMargin = yo3.t();
            this.f0.setLayoutParams(layoutParams);
        }
    }

    public void l3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.N0 = i;
        }
    }

    @Override // com.baidu.tieba.va2
    public void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new oh4(activity, this.f0, k3(), ou2.K(), new qq3());
                new x03(this.g0, this, this.h0).z();
            }
        }
    }

    @Override // com.baidu.tieba.va2, com.baidu.tieba.na2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(fi2.n(gb3.K().getAppId()));
            }
            this.g0.u(ou2.M().a(), I1(), this.h0, false);
        }
    }

    @Override // com.baidu.tieba.na2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI j3 = j3();
            URI i3 = i3();
            if (j3 != null && i3 != null) {
                if (!TextUtils.equals(j3.getPath(), i3.getPath()) && !TextUtils.equals(j3.getQuery(), i3.getQuery())) {
                    this.G0.loadUrl(i3.toString());
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: refresh url " + i3.toString());
                    }
                    zq3.c().m("3");
                    cr3.b("3");
                    cr3.a().m();
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                        return;
                    }
                    return;
                }
                rh3.s(gb3.K().q().W());
                if (P0) {
                    Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.ox1] */
    @Override // com.baidu.tieba.va2, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e6, viewGroup, false);
            W1(inflate);
            qx1 j = j();
            this.G0 = j;
            j.X(b3());
            this.H0 = this.G0.r();
            cr3.a().i(this.I0);
            zq3.c().m("0");
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bb);
            this.O0 = frameLayout;
            this.G0.i(frameLayout, this.H0.covertToView());
            Y2(this.O0);
            if (V1()) {
                inflate = Y1(inflate);
                y1(0, true);
            }
            yo3.Q(getActivity());
            zq3.c().p(this.G0.a());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
