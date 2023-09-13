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
/* loaded from: classes7.dex */
public final class o72 extends s62<TextView, p72> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o72(@NonNull Context context, @NonNull p72 p72Var) {
        super(context, p72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, p72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (t62) objArr2[1]);
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
    @Override // com.baidu.tieba.s62, com.baidu.tieba.u62, com.baidu.tieba.w62
    @NonNull
    /* renamed from: Z */
    public z72 k(@NonNull p72 p72Var, @NonNull p72 p72Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, p72Var, p72Var2)) == null) {
            z72 k = super.k(p72Var, p72Var2);
            if (!TextUtils.equals(p72Var.E, p72Var2.E) && (TextUtils.equals(p72Var.E, "scroll") || TextUtils.equals(p72Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(p72Var.E, p72Var2.E) || (TextUtils.equals(p72Var2.E, "scroll") && p72Var.D != p72Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (z72) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull p72 p72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, p72Var) == null) {
            if (w62.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (p72Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(p72Var);
            }
            ViewParent parent = textView.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(p72Var.k);
            gradientDrawable.setCornerRadius(p72Var.n);
            gradientDrawable.setStroke(p72Var.l, p72Var.m);
            ((View) parent).setBackground(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull p72 p72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, p72Var) == null) {
            if (w62.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (p72Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            super.P((View) parent, p72Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w62
    @NonNull
    /* renamed from: a0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return this.j;
        }
        return (TextView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w62
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            return this.i;
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }
}
