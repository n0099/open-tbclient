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
/* loaded from: classes6.dex */
public final class k72 extends o62<TextView, l72> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k72(@NonNull Context context, @NonNull l72 l72Var) {
        super(context, l72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, l72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (p62) objArr2[1]);
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
    @Override // com.baidu.tieba.o62, com.baidu.tieba.q62, com.baidu.tieba.s62
    @NonNull
    /* renamed from: Z */
    public v72 k(@NonNull l72 l72Var, @NonNull l72 l72Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, l72Var, l72Var2)) == null) {
            v72 k = super.k(l72Var, l72Var2);
            if (!TextUtils.equals(l72Var.E, l72Var2.E) && (TextUtils.equals(l72Var.E, "scroll") || TextUtils.equals(l72Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(l72Var.E, l72Var2.E) || (TextUtils.equals(l72Var2.E, "scroll") && l72Var.D != l72Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (v72) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q62
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull l72 l72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, l72Var) == null) {
            if (s62.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (l72Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(l72Var);
            }
            ViewParent parent = textView.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(l72Var.k);
            gradientDrawable.setCornerRadius(l72Var.n);
            gradientDrawable.setStroke(l72Var.l, l72Var.m);
            ((View) parent).setBackground(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q62
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull l72 l72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, l72Var) == null) {
            if (s62.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (l72Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            super.P((View) parent, l72Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
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

    @Override // com.baidu.tieba.s62
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
