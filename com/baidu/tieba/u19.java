package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t19 a;
    public final r9 b;
    public final go c;
    public Runnable d;
    public boolean e;
    public Runnable f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u19 a;

        public a(u19 u19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u19Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.d();
            }
        }
    }

    public u19(r9 r9Var, go goVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, goVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.b = r9Var;
        this.c = goVar;
    }

    public final Rect b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            return rect;
        }
        return (Rect) invokeL.objValue;
    }

    public final boolean c(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) {
            float i = fj.i(TbadkCoreApplication.getInst());
            int i2 = (int) (0.0f * i);
            int i3 = (int) (i * 0.66f);
            if (rect.top >= i2 && rect.bottom <= i3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (view2.getTag(R.id.obfuscated_res_0x7f0925f2) instanceof t19)) {
            ((t19) view2.getTag(R.id.obfuscated_res_0x7f0925f2)).e();
            view2.setTag(R.id.obfuscated_res_0x7f0925f2, null);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e = z;
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.e) {
            return;
        }
        if (this.d == null) {
            this.d = new Runnable() { // from class: com.baidu.tieba.s19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        u19.this.f();
                    }
                }
            };
        }
        hh.a().postDelayed(this.d, i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d != null) {
            hh.a().removeCallbacks(this.d);
        }
    }

    public final void f() {
        go goVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null && (goVar = this.c) != null && goVar.getListView().getChildCount() != 0 && this.c.getContentViewsCount() != 0) {
            Context context = this.c.getListView().getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    int childCount = this.c.getListView().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.c.getListView().getChildAt(i);
                        if (childAt != null && (childAt.getTag(R.id.obfuscated_res_0x7f0925f2) instanceof t19)) {
                            t19 t19Var = (t19) childAt.getTag(R.id.obfuscated_res_0x7f0925f2);
                            if (c(b(childAt))) {
                                t19Var.play();
                            }
                        }
                    }
                }
            }
        }
    }

    public void g() {
        go goVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.e && this.b != null && (goVar = this.c) != null && goVar.getListView() != null && this.c.getListView().getChildCount() != 0 && this.c.getContentViewsCount() != 0) {
            int childCount = this.c.getListView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getListView().getChildAt(i);
                if (childAt != null && (childAt.getTag(R.id.obfuscated_res_0x7f0925f2) instanceof t19)) {
                    t19 t19Var = (t19) childAt.getTag(R.id.obfuscated_res_0x7f0925f2);
                    this.a = t19Var;
                    if (t19Var.c()) {
                        this.a.b();
                        ux4.k().u("key_reaction_guide_show_number", true);
                        hh.a().postDelayed(this.f, 4000L);
                        return;
                    }
                }
            }
        }
    }
}
