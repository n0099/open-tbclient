package com.baidu.tieba;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tn7 extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public int b;
    public int c;
    public FrameLayout.LayoutParams d;

    public tn7(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view2 == null) {
            return;
        }
        this.a = view2;
        if (view2.getVisibility() == 8 && i2 > 0) {
            this.b = i2;
        } else {
            this.b = this.a.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
        this.d = layoutParams;
        this.c = i;
        if (i == 0) {
            layoutParams.bottomMargin = -this.b;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), transformation}) == null) {
            super.applyTransformation(f, transformation);
            if (f < 1.0f) {
                if (this.c == 0) {
                    FrameLayout.LayoutParams layoutParams = this.d;
                    int i = this.b;
                    layoutParams.bottomMargin = (-i) + ((int) (i * f));
                } else {
                    this.d.bottomMargin = -((int) (this.b * f));
                }
                this.a.requestLayout();
            } else if (this.c == 0) {
                this.d.bottomMargin = 0;
                this.a.requestLayout();
                this.b = this.a.getMeasuredHeight();
            } else {
                this.d.bottomMargin = -this.b;
                this.a.setVisibility(8);
                this.a.requestLayout();
            }
        }
    }
}
