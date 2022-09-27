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
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x22 extends r22 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout F0;
    public RelativeLayout G0;

    public x22() {
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

    public static x22 V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new x22() : (x22) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r22
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r22
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            V1(view2);
            t2(-1);
            C2(-16777216);
            v2(G(R.string.obfuscated_res_0x7f0f126a));
            x2(true);
            J2(false);
        }
    }

    public final void U2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091521);
            this.F0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (sm2.y0().d() || !fh3.G()) {
                this.F0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902f7);
            this.G0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (r22.E0) {
                Log.d("SwanAppBaseFragment", "startSettingFragment");
            }
            u22 M1 = M1();
            if (M1 == null) {
                d33.f(getContext(), R.string.obfuscated_res_0x7f0f01a6).G();
                return;
            }
            u22.b i = M1.i("navigateTo");
            i.n(u22.g, u22.i);
            i.k("authority", null).a();
            bt2.o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    @Override // com.baidu.tieba.r22
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r22
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r22
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091521) {
                sm2.t0().a();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0902f7) {
                W2();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View x0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d081c, viewGroup, false);
            U1(inflate);
            U2(inflate);
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
