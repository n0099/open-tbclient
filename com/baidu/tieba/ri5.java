package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.tieba.ta5;
import com.baidu.tieba.vi5;
import com.baidu.tieba.vi5.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class ri5<T extends ta5, D extends vi5.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ViewType b;
    public T c;
    public D d;

    public abstract void d(ViewType viewType, T t, D d);

    public abstract T f(ViewType viewType, ViewGroup viewGroup);

    public ri5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
    }

    public final void a(View view2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (t = this.c) != null) {
            t.attachView(view2);
        }
    }

    public final void b(View view2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (t = this.c) != null) {
            t.dettachView(view2);
        }
    }

    public void e(int i) {
        ViewType viewType;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.a != i && (viewType = this.b) != null && (t = this.c) != null) {
                d(viewType, t, this.d);
            }
            this.a = i;
        }
    }

    public final View c(ViewType viewType, ViewGroup viewGroup, D d) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewType, viewGroup, d)) == null) {
            this.b = viewType;
            this.d = d;
            if (this.c == null) {
                this.c = f(viewType, viewGroup);
            }
            View view2 = this.c.getView();
            if (viewGroup.indexOfChild(view2) < 0) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                a(viewGroup);
            } else if (viewGroup.indexOfChild(view2) != viewGroup.getChildCount() - 1) {
                view2.bringToFront();
            }
            d(viewType, this.c, d);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }
}
