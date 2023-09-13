package com.baidu.tieba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ty1 extends va2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.va2, com.baidu.tieba.na2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a extends sc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty1 c;

        public a(ty1 ty1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ty1Var;
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

    public ty1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

    public final void i3() {
        tr1 d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !SwanAppAllianceLoginHelper.d.c() && (d = SwanAppAllianceLoginHelper.d.d()) != null) {
            d.onResult(-2);
        }
    }

    @Override // com.baidu.tieba.va2
    public qx1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return bi2.U().f0().f(getContext());
        }
        return (qx1) invokeV.objValue;
    }

    public final int j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (f2()) {
                return 18;
            }
            return 12;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.va2, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            i3();
            super.z0();
        }
    }

    @Override // com.baidu.tieba.va2, com.baidu.tieba.na2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ox1 ox1Var = this.H0;
            if (ox1Var != null && ox1Var.canGoBack()) {
                this.H0.goBack();
                return true;
            }
            i3();
            SwanAppAllianceLoginHelper.d.a(uy1.d(), uy1.a());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.va2
    public void c3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            this.g0 = new oh4(activity, this.f0, j3(), ou2.K(), new qq3());
            new x03(this.g0, this).z();
        }
    }

    @Override // com.baidu.tieba.va2, com.baidu.tieba.na2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.W1(view2);
            this.f0.setRightZoneVisibility(true);
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.ox1] */
    @Override // com.baidu.tieba.va2, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e7, viewGroup, false);
            W1(inflate);
            qx1 j = j();
            this.G0 = j;
            j.X(b3());
            this.H0 = this.G0.r();
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bb);
            this.G0.i(frameLayout, this.H0.covertToView());
            Y2(frameLayout);
            if (V1()) {
                return Y1(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
