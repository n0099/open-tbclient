package com.baidu.tieba.write.write.work.classdialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.baidu.tieba.h26;
import com.baidu.tieba.it5;
import com.baidu.tieba.p26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class SelectClassDialogView extends ViewGroup implements it5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public p26<String> b;

    @Override // com.baidu.tieba.it5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.it5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectClassDialogView(ViewGroup viewGroup, Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, context};
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
        this.a = viewGroup;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0202, this.a, true);
            p26<String> p26Var = new p26<>(this.a, true);
            this.b = p26Var;
            p26Var.t(9);
            this.b.C(UtilHelper.getDimenPixelSize(R.dimen.T_X06) / 3);
            this.b.q(SkinManager.getColor(R.color.CAM_X0203));
            this.b.s(WheelView.DividerType.FILL);
            this.b.v(3.0f);
            this.b.B(SkinManager.getColor(R.color.CAM_X0611));
            this.b.z(SkinManager.getColor(R.color.CAM_X0611));
            this.b.m(Typeface.DEFAULT_BOLD);
            this.b.k(true);
            this.b.o(false);
        }
    }

    @Override // com.baidu.tieba.it5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.b.q(SkinManager.getColor(R.color.CAM_X0203));
            this.b.B(SkinManager.getColor(R.color.CAM_X0105));
            this.b.z(SkinManager.getColor(R.color.CAM_X0105));
            this.b.j();
        }
    }

    public void setCurrentItems(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.b.n(i, i2, 0);
        }
    }

    public void setPicker(List<String> list, List<List<String>> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, list, list2) == null) {
            this.b.x(list, list2, null);
        }
    }

    public void setOnOptionsSelectChangeListener(h26 h26Var) {
        p26<String> p26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, h26Var) == null) && (p26Var = this.b) != null) {
            p26Var.w(h26Var);
        }
    }

    @Override // com.baidu.tieba.it5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.b.i() != null && this.b.i().length >= 2 && this.b.i()[0] >= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
