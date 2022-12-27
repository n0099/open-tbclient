package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y69 a;
    public final r9 b;
    public final zn c;
    public Runnable d;
    public boolean e;
    public Runnable f;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z69 a;

        public a(z69 z69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z69Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.d();
            }
        }
    }

    public z69(r9 r9Var, zn znVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, znVar};
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
        this.c = znVar;
    }

    @NonNull
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
            float j = yi.j(TbadkCoreApplication.getInst());
            int i = (int) (0.0f * j);
            int i2 = (int) (j * 0.66f);
            if (rect.top >= i && rect.bottom <= i2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (view2.getTag(R.id.virtual_image_user_head) instanceof y69)) {
            ((y69) view2.getTag(R.id.virtual_image_user_head)).e();
            view2.setTag(R.id.virtual_image_user_head, null);
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
            this.d = new Runnable() { // from class: com.baidu.tieba.x69
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        z69.this.f();
                    }
                }
            };
        }
        ah.a().postDelayed(this.d, i);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d != null) {
            ah.a().removeCallbacks(this.d);
        }
    }

    public final void f() {
        zn znVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.b != null && (znVar = this.c) != null && znVar.getListView().getChildCount() != 0 && this.c.getContentViewsCount() != 0) {
            Context context = this.c.getListView().getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    int childCount = this.c.getListView().getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = this.c.getListView().getChildAt(i);
                        if (childAt != null && (childAt.getTag(R.id.virtual_image_user_head) instanceof y69)) {
                            y69 y69Var = (y69) childAt.getTag(R.id.virtual_image_user_head);
                            if (c(b(childAt))) {
                                y69Var.play();
                            }
                        }
                    }
                }
            }
        }
    }

    public void g() {
        zn znVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.e && this.b != null && (znVar = this.c) != null && znVar.getListView() != null && this.c.getListView().getChildCount() != 0 && this.c.getContentViewsCount() != 0) {
            int childCount = this.c.getListView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getListView().getChildAt(i);
                if (childAt != null && (childAt.getTag(R.id.virtual_image_user_head) instanceof y69)) {
                    y69 y69Var = (y69) childAt.getTag(R.id.virtual_image_user_head);
                    this.a = y69Var;
                    if (y69Var.c()) {
                        this.a.b();
                        ry4.l().v("key_reaction_guide_show_number", true);
                        ah.a().postDelayed(this.f, 4000L);
                        return;
                    }
                }
            }
        }
    }
}
