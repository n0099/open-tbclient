package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class sz1 extends wy1<TextView, tz1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz1(@NonNull Context context, @NonNull tz1 tz1Var) {
        super(context, tz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (xy1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.i = new SwanAppComponentContainerView(context);
        this.j = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wy1, com.baidu.tieba.yy1, com.baidu.tieba.az1
    @NonNull
    /* renamed from: Z */
    public d02 k(@NonNull tz1 tz1Var, @NonNull tz1 tz1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, tz1Var, tz1Var2)) == null) {
            d02 k = super.k(tz1Var, tz1Var2);
            if (!TextUtils.equals(tz1Var.E, tz1Var2.E) && (TextUtils.equals(tz1Var.E, "scroll") || TextUtils.equals(tz1Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(tz1Var.E, tz1Var2.E) || (TextUtils.equals(tz1Var2.E, "scroll") && tz1Var.D != tz1Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (d02) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.az1
    @NonNull
    /* renamed from: a0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.j : (TextView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yy1
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull tz1 tz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, tz1Var) == null) {
            if (az1.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (tz1Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                super.P((View) parent, tz1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yy1
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull tz1 tz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, tz1Var) == null) {
            if (az1.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (tz1Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(tz1Var);
            }
            ViewParent parent = textView.getParent();
            if (parent instanceof View) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(tz1Var.k);
                gradientDrawable.setCornerRadius(tz1Var.n);
                gradientDrawable.setStroke(tz1Var.l, tz1Var.m);
                ((View) parent).setBackground(gradientDrawable);
            }
        }
    }

    @Override // com.baidu.tieba.az1
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? this.i : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
