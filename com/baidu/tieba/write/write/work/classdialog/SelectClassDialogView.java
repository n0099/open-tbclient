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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.if5;
import com.repackage.qf5;
import com.repackage.s85;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectClassDialogView extends ViewGroup implements s85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public qf5<String> b;

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
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01dd, this.a, true);
            qf5<String> qf5Var = new qf5<>(this.a, true);
            this.b = qf5Var;
            qf5Var.t(9);
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

    @Override // com.repackage.s85
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.repackage.s85
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.s85
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.i() == null || this.b.i().length < 2 || this.b.i()[0] < 0 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
        }
    }

    @Override // com.repackage.s85
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b.q(SkinManager.getColor(R.color.CAM_X0203));
            this.b.B(SkinManager.getColor(R.color.CAM_X0105));
            this.b.z(SkinManager.getColor(R.color.CAM_X0105));
            this.b.j();
        }
    }

    public void setCurrentItems(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            this.b.n(i, i2, 0);
        }
    }

    public void setOnOptionsSelectChangeListener(if5 if5Var) {
        qf5<String> qf5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, if5Var) == null) || (qf5Var = this.b) == null) {
            return;
        }
        qf5Var.w(if5Var);
    }

    public void setPicker(List<String> list, List<List<String>> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) {
            this.b.x(list, list2, null);
        }
    }
}
