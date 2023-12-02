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
/* loaded from: classes8.dex */
public final class r22 extends w12<TextView, s22> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r22(@NonNull Context context, @NonNull s22 s22Var) {
        super(context, s22Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, s22Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (x12) objArr2[1]);
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
    @Override // com.baidu.tieba.w12, com.baidu.tieba.y12, com.baidu.tieba.a22
    @NonNull
    /* renamed from: b0 */
    public c32 k(@NonNull s22 s22Var, @NonNull s22 s22Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, s22Var, s22Var2)) == null) {
            c32 k = super.k(s22Var, s22Var2);
            if (!TextUtils.equals(s22Var.E, s22Var2.E) && (TextUtils.equals(s22Var.E, "scroll") || TextUtils.equals(s22Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(s22Var.E, s22Var2.E) || (TextUtils.equals(s22Var2.E, "scroll") && s22Var.D != s22Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (c32) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y12
    /* renamed from: e0 */
    public void S(@NonNull TextView textView, @NonNull s22 s22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, s22Var) == null) {
            if (a22.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (s22Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(s22Var);
            }
            ViewParent parent = textView.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(s22Var.k);
            gradientDrawable.setCornerRadius(s22Var.n);
            gradientDrawable.setStroke(s22Var.l, s22Var.m);
            ((View) parent).setBackground(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y12
    /* renamed from: d0 */
    public void R(@NonNull View view2, @NonNull s22 s22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, s22Var) == null) {
            if (a22.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (s22Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            super.R((View) parent, s22Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a22
    @NonNull
    /* renamed from: c0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return this.j;
        }
        return (TextView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a22
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
