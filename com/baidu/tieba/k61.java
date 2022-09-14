package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class k61<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r61 a;
    public n61 b;

    public k61(n61 n61Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n61Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n61Var.f();
        this.b = n61Var;
    }

    public k61<T> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.d(z);
            return this;
        }
        return (k61) invokeZ.objValue;
    }

    public k61<T> b(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, viewGroup)) == null) {
            this.a.s(view2, viewGroup);
            return this;
        }
        return (k61) invokeLL.objValue;
    }

    public k61<T> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.b.m(i);
            return this;
        }
        return (k61) invokeI.objValue;
    }

    public k61<T> d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (i != -1) {
                try {
                    this.a.w(i);
                } catch (Exception e) {
                    jj0.h("BubbleBuilder", "", e);
                    this.a.w(-1);
                    return this;
                }
            }
            if (i2 != -1) {
                try {
                    this.a.x(i2);
                } catch (Exception e2) {
                    jj0.h("BubbleBuilder", "", e2);
                    this.a.x(-1);
                }
            }
            return this;
        }
        return (k61) invokeII.objValue;
    }

    public k61<T> e(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bubblePosition)) == null) {
            this.b.e().d = false;
            this.b.e().e = bubblePosition;
            return this;
        }
        return (k61) invokeL.objValue;
    }

    public k61<T> f(BubbleManager.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.b.n(bVar);
            return this;
        }
        return (k61) invokeL.objValue;
    }

    public k61<T> g(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            this.b.e().q(f);
            return this;
        }
        return (k61) invokeF.objValue;
    }
}
