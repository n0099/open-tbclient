package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.breathetip.tipview.BreatheTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class s55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public int b;
    public int c;

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 32;
        }
        return invokeV.intValue;
    }

    public s55() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final void a(int i, int i2, Rect rect, r55 r55Var) {
        LinearLayout.LayoutParams layoutParams;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), rect, r55Var}) == null) {
            if (r55Var.getView().getLayoutParams() instanceof LinearLayout.LayoutParams) {
                layoutParams = (LinearLayout.LayoutParams) r55Var.getView().getLayoutParams();
            } else {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            int dimens = (i / 2) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X017);
            boolean z2 = false;
            if (rect.centerX() >= dimens) {
                z = true;
            } else {
                z = false;
            }
            if (BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getContext()) - rect.centerX() >= dimens) {
                z2 = true;
            }
            if (z && z2) {
                layoutParams.gravity = 1;
            } else if (z) {
                layoutParams.gravity = 5;
                this.b = (-(i - i2)) / 2;
            } else {
                layoutParams.gravity = 3;
                this.b = (i - i2) / 2;
            }
            this.a.addView(r55Var.getView(), layoutParams);
        }
    }

    public final void b(int i, int i2, Rect rect, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), rect, view2}) == null) {
            if (i > rect.centerY() - (i2 / 2)) {
                this.a.addView(view2);
                this.c = ((rect.height() + i2) / 2) + i;
                return;
            }
            this.a.addView(view2, 0);
            this.c = (rect.height() + i2) / 2;
        }
    }

    public void h(BreatheTipView breatheTipView, r55 r55Var, View view2) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, breatheTipView, r55Var, view2) == null) {
            LinearLayout linearLayout = new LinearLayout(breatheTipView.getContext());
            this.a = linearLayout;
            linearLayout.setOrientation(1);
            Rect rect = new Rect();
            if (view2 != null) {
                view2.getGlobalVisibleRect(rect);
            }
            int i3 = 0;
            if (breatheTipView.getLayoutParams() != null) {
                i = breatheTipView.getLayoutParams().height;
            } else {
                i = 0;
            }
            if (breatheTipView.getLayoutParams() != null) {
                i2 = breatheTipView.getLayoutParams().width;
            } else {
                i2 = 0;
            }
            if (r55Var.getView().getLayoutParams() != null) {
                i3 = r55Var.getView().getLayoutParams().width;
            }
            a(i2, i3, rect, r55Var);
            b(i, i3, rect, breatheTipView);
        }
    }
}
