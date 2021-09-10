package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import c.a.e.e.p.l;
import c.a.r0.j3.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AdCloseReasonCheckBox extends CheckBox {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56372e;

    /* renamed from: f  reason: collision with root package name */
    public GradientDrawable f56373f;

    /* renamed from: g  reason: collision with root package name */
    public GradientDrawable f56374g;

    /* renamed from: h  reason: collision with root package name */
    public StateListDrawable f56375h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseReasonCheckBox(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f56372e = context;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            b(R.string.J_X07, l.g(context, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0304);
            SkinManager.setViewCheckedTextColorSelector(this, R.color.CAM_X0105, R.color.CAM_X0304, R.color.CAM_X0105);
            int g2 = l.g(context, R.dimen.ds24);
            setPadding(g2, 0, g2, 0);
            setGravity(17);
            setButtonDrawable((Drawable) null);
        }
    }

    public final void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i2).split(",")[0]);
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.f56373f = gradientDrawable;
            gradientDrawable.setShape(0);
            float f2 = parseInt;
            this.f56373f.setCornerRadius(f2);
            this.f56373f.setStroke(i3, SkinManager.getColor(i4));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.f56374g = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.f56374g.setCornerRadius(f2);
            this.f56374g.setStroke(i3, c.a(SkinManager.getColor(i5), 0.5f));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f56375h = stateListDrawable;
            stateListDrawable.addState(new int[]{-16842912}, this.f56373f);
            this.f56375h.addState(new int[]{16842912}, this.f56374g);
            setBackgroundDrawable(this.f56375h);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56372e = context;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56372e = context;
        a(context);
    }
}
