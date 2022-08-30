package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l44 extends g44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int j;
    public m44 k;
    public m44 l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l44 a;

        public a(l44 l44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l44Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null || this.a.j < -1) {
                return;
            }
            if (this.a.j == -1) {
                this.a.c.o();
            } else {
                this.a.c.u(this.a.j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l44 a;

        public b(l44 l44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l44Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                l44 l44Var = this.a;
                RecommendItemModel y = l44Var.y(l44Var.j);
                this.a.k.b.setImageURI(y.iconUrl);
                this.a.k.c.setText(y.appName);
                this.a.k.a.setAlpha(1.0f);
                l44 l44Var2 = this.a;
                RecommendItemModel y2 = this.a.y(l44Var2.x(l44Var2.j));
                this.a.l.b.setImageURI(y2.iconUrl);
                this.a.l.c.setText(y2.appName);
                this.a.l.a.setAlpha(0.0f);
                l44.super.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l44(@NonNull Context context, @NonNull j44 j44Var) {
        super(context, j44Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, j44Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (j44) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = -2;
    }

    @Override // com.baidu.tieba.g44, com.baidu.tieba.h44
    public void e(o44 o44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, o44Var) == null) {
            super.e(o44Var);
            if (z(o44Var)) {
                return;
            }
            this.j = -2;
            this.l.b.setImageURI(o44Var.a.iconUrl);
            this.l.c.setText(o44Var.a.appName);
        }
    }

    @Override // com.baidu.tieba.g44
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            m44 m44Var = new m44(this.a);
            this.l = m44Var;
            m44Var.a.setAlpha(0.0f);
            frameLayout.addView(this.l.a);
            m44 m44Var2 = new m44(this.a);
            this.k = m44Var2;
            m44Var2.a.setAlpha(0.0f);
            this.k.b.setActualImageResource(17170445);
            this.k.c.setText((CharSequence) null);
            frameLayout.addView(this.k.a);
            this.k.a.setOnClickListener(new a(this));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g44
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z(this.b)) {
                this.k.a.setAlpha(1.0f);
                this.k.b.setActualImageResource(R.drawable.obfuscated_res_0x7f080168);
                this.k.c.setText(R.string.obfuscated_res_0x7f0f133a);
                super.k();
                return;
            }
            this.j = x(this.j);
            this.l.a.animate().setDuration(160L).alpha(1.0f);
            this.k.a.animate().setDuration(160L).alpha(0.0f).setListener(new b(this));
        }
    }

    public final int x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int i2 = i + 1;
            if (i2 == this.b.b.size()) {
                return -1;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final RecommendItemModel y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i == -1 ? this.b.a : this.b.b.get(i) : (RecommendItemModel) invokeI.objValue;
    }

    public final boolean z(o44 o44Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, o44Var)) == null) ? o44Var == null || o44Var.b == null || o44Var.a == null : invokeL.booleanValue;
    }
}
