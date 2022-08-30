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
/* loaded from: classes5.dex */
public class n02 extends o02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean O0;
    public transient /* synthetic */ FieldHolder $fh;
    public int M0;
    public FrameLayout N0;

    /* loaded from: classes5.dex */
    public class a extends l22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n02 c;

        public a(n02 n02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n02Var;
        }

        @Override // com.baidu.tieba.l22, com.baidu.tieba.o22
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? super.b(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? o93.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false) : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947948569, "Lcom/baidu/tieba/n02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947948569, "Lcom/baidu/tieba/n02;");
                return;
            }
        }
        O0 = kh1.a;
    }

    public n02() {
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
        this.M0 = 20;
    }

    @Override // com.baidu.tieba.g02
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.F0 == null) {
                if (O0) {
                    Log.e("SwanAppWebModeFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String a2 = this.F0.a();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
            hn1 hn1Var = this.G0;
            if (hn1Var != null) {
                hashMap.put("webViewUrl", hn1Var.getUrl());
            }
            bb2 bb2Var = new bb2("sharebtn", hashMap);
            nm2.U().m(a2, bb2Var);
            ay1.i("SwanAppWebModeFragment", "share msg: " + bb2Var.s().toString());
        }
    }

    @Override // com.baidu.tieba.o02, com.baidu.tieba.g02
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.U1(view2);
            this.f0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.topMargin = re3.t();
            this.f0.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.o02
    public o22 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (o22) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o02
    public void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.g0 != null) {
                return;
            }
            this.g0 = new f74(activity, this.f0, i3(), hk2.K(), new jg3());
            new qq2(this.g0, this, this.h0).z();
        }
    }

    public URI g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(sg3.c().a().e());
            } catch (Exception e) {
                if (O0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g02
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h2();
            vg3.a().j();
        }
    }

    public URI h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new URI(sg3.c().e());
            } catch (Exception e) {
                if (O0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (d2()) {
                return 19;
            }
            return this.M0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.o02
    public jn1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? u72.U().f0().a(getContext()) : (jn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o02, com.baidu.tieba.g02
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(y72.n(z03.K().getAppId()));
            }
            this.g0.u(hk2.M().a(), H1(), this.h0, false);
        }
    }

    public void j3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.M0 = i;
        }
    }

    @Override // com.baidu.tieba.g02, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI h3 = h3();
            URI g3 = g3();
            if (h3 == null || g3 == null) {
                return;
            }
            if (!TextUtils.equals(h3.getPath(), g3.getPath()) && !TextUtils.equals(h3.getQuery(), g3.getQuery())) {
                this.F0.loadUrl(g3.toString());
                if (O0) {
                    Log.i("SwanAppWebModeFragment", "onResume: refresh url " + g3.toString());
                }
                sg3.c().m("3");
                vg3.b("3");
                vg3.a().m();
                if (O0) {
                    Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                    return;
                }
                return;
            }
            k73.s(z03.K().q().W());
            if (O0) {
                Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.hn1] */
    @Override // com.baidu.tieba.o02, com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00db, viewGroup, false);
            U1(inflate);
            jn1 j = j();
            this.F0 = j;
            j.Y(Z2());
            this.G0 = this.F0.r();
            vg3.a().i(this.H0);
            sg3.c().m("0");
            this.F0.loadUrl(this.H0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901ac);
            this.N0 = frameLayout;
            this.F0.i(frameLayout, this.G0.covertToView());
            W2(this.N0);
            if (T1()) {
                inflate = W1(inflate);
                x1(0, true);
            }
            re3.Q(getActivity());
            sg3.c().p(this.F0.a());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
