package com.baidu.tieba.write.write.work.classdialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.f1.p.a.d.d;
import c.a.q0.f1.p.a.f.c;
import c.a.q0.x0.a;
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
import java.util.List;
/* loaded from: classes8.dex */
public class SelectClassDialogView extends ViewGroup implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f59276e;

    /* renamed from: f  reason: collision with root package name */
    public c<String> f59277f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectClassDialogView(ViewGroup viewGroup, Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59276e = viewGroup;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.class_pickerview_options, this.f59276e, true);
            c<String> cVar = new c<>(this.f59276e, true);
            this.f59277f = cVar;
            cVar.t(9);
            this.f59277f.C(UtilHelper.getDimenPixelSize(R.dimen.T_X06) / 3);
            this.f59277f.q(SkinManager.getColor(R.color.CAM_X0203));
            this.f59277f.s(WheelView.DividerType.FILL);
            this.f59277f.v(3.0f);
            this.f59277f.B(SkinManager.getColor(R.color.CAM_X0611));
            this.f59277f.z(SkinManager.getColor(R.color.CAM_X0611));
            this.f59277f.m(Typeface.DEFAULT_BOLD);
            this.f59277f.k(true);
            this.f59277f.o(false);
        }
    }

    @Override // c.a.q0.x0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59277f.i() == null || this.f59277f.i().length < 2 || this.f59277f.i()[0] <= 0 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // c.a.q0.x0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f59277f.q(SkinManager.getColor(R.color.CAM_X0203));
            this.f59277f.B(SkinManager.getColor(R.color.CAM_X0105));
            this.f59277f.z(SkinManager.getColor(R.color.CAM_X0105));
            this.f59277f.j();
        }
    }

    public void setCurrentItems(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.f59277f.n(i2, i3, 0);
        }
    }

    public void setOnOptionsSelectChangeListener(d dVar) {
        c<String> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) || (cVar = this.f59277f) == null) {
            return;
        }
        cVar.w(dVar);
    }

    public void setPicker(List<String> list, List<List<String>> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) {
            this.f59277f.x(list, list2, null);
        }
    }
}
