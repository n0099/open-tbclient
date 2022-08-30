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
/* loaded from: classes5.dex */
public abstract class r41<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y41 a;
    public u41 b;

    public r41(u41 u41Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u41Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = u41Var.f();
        this.b = u41Var;
    }

    public r41<T> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.d(z);
            return this;
        }
        return (r41) invokeZ.objValue;
    }

    public r41<T> b(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, viewGroup)) == null) {
            this.a.s(view2, viewGroup);
            return this;
        }
        return (r41) invokeLL.objValue;
    }

    public r41<T> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.b.m(i);
            return this;
        }
        return (r41) invokeI.objValue;
    }

    public r41<T> d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (i != -1) {
                try {
                    this.a.w(i);
                } catch (Exception e) {
                    zh0.h("BubbleBuilder", "", e);
                    this.a.w(-1);
                    return this;
                }
            }
            if (i2 != -1) {
                try {
                    this.a.x(i2);
                } catch (Exception e2) {
                    zh0.h("BubbleBuilder", "", e2);
                    this.a.x(-1);
                }
            }
            return this;
        }
        return (r41) invokeII.objValue;
    }

    public r41<T> e(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bubblePosition)) == null) {
            this.b.e().d = false;
            this.b.e().e = bubblePosition;
            return this;
        }
        return (r41) invokeL.objValue;
    }

    public r41<T> f(BubbleManager.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.b.n(bVar);
            return this;
        }
        return (r41) invokeL.objValue;
    }

    public r41<T> g(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            this.b.e().q(f);
            return this;
        }
        return (r41) invokeF.objValue;
    }
}
