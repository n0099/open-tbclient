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
/* loaded from: classes8.dex */
public class s94 extends n94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int j;
    public t94 k;
    public t94 l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s94 a;

        public a(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s94Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c == null || this.a.j < -1) {
                return;
            }
            if (this.a.j == -1) {
                this.a.c.o();
            } else {
                this.a.c.u(this.a.j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s94 a;

        public b(s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s94Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                s94 s94Var = this.a;
                RecommendItemModel y = s94Var.y(s94Var.j);
                this.a.k.b.setImageURI(y.iconUrl);
                this.a.k.c.setText(y.appName);
                this.a.k.a.setAlpha(1.0f);
                s94 s94Var2 = this.a;
                RecommendItemModel y2 = this.a.y(s94Var2.x(s94Var2.j));
                this.a.l.b.setImageURI(y2.iconUrl);
                this.a.l.c.setText(y2.appName);
                this.a.l.a.setAlpha(0.0f);
                s94.super.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s94(@NonNull Context context, @NonNull q94 q94Var) {
        super(context, q94Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, q94Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (q94) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = -2;
    }

    @Override // com.baidu.tieba.n94, com.baidu.tieba.o94
    public void e(v94 v94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v94Var) == null) {
            super.e(v94Var);
            if (z(v94Var)) {
                return;
            }
            this.j = -2;
            this.l.b.setImageURI(v94Var.a.iconUrl);
            this.l.c.setText(v94Var.a.appName);
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == -1) {
                return this.b.a;
            }
            return this.b.b.get(i);
        }
        return (RecommendItemModel) invokeI.objValue;
    }

    public final boolean z(v94 v94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v94Var)) == null) {
            if (v94Var != null && v94Var.b != null && v94Var.a != null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.n94
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            t94 t94Var = new t94(this.a);
            this.l = t94Var;
            t94Var.a.setAlpha(0.0f);
            frameLayout.addView(this.l.a);
            t94 t94Var2 = new t94(this.a);
            this.k = t94Var2;
            t94Var2.a.setAlpha(0.0f);
            this.k.b.setActualImageResource(17170445);
            this.k.c.setText((CharSequence) null);
            frameLayout.addView(this.k.a);
            this.k.a.setOnClickListener(new a(this));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n94
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z(this.b)) {
                this.k.a.setAlpha(1.0f);
                this.k.b.setActualImageResource(R.drawable.obfuscated_res_0x7f080187);
                this.k.c.setText(R.string.obfuscated_res_0x7f0f15f1);
                super.k();
                return;
            }
            this.j = x(this.j);
            this.l.a.animate().setDuration(160L).alpha(1.0f);
            this.k.a.animate().setDuration(160L).alpha(0.0f).setListener(new b(this));
        }
    }
}
