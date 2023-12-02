package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w52 extends q52 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout G0;
    public RelativeLayout H0;

    @Override // com.baidu.tieba.q52
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public w52() {
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

    public static w52 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new w52();
        }
        return (w52) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View A0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0958, viewGroup, false);
            a2(inflate);
            b3(inflate);
            if (Z1()) {
                inflate = c2(inflate);
            }
            return I1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.q52
    public void a2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            b2(view2);
            A2(-1);
            J2(-16777216);
            C2(X(R.string.obfuscated_res_0x7f0f1514));
            E2(true);
            Q2(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091829) {
                rp2.t0().a();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090330) {
                d3();
            }
        }
    }

    public final void b3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091829);
            this.G0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (rp2.y0().d() || !ek3.G()) {
                this.G0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090330);
            this.H0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (q52.F0) {
                Log.d("SwanAppBaseFragment", "startSettingFragment");
            }
            t52 R1 = R1();
            if (R1 == null) {
                c63.f(z(), R.string.obfuscated_res_0x7f0f01dd).G();
                return;
            }
            t52.b i = R1.i("navigateTo");
            i.n(t52.g, t52.i);
            i.k("authority", null).a();
            aw2.o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }
}
