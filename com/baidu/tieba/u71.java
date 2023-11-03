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
/* loaded from: classes8.dex */
public abstract class u71<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b81 a;
    public x71 b;

    public u71(x71 x71Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x71Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = x71Var.f();
        this.b = x71Var;
    }

    public u71<T> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.b.d(z);
            return this;
        }
        return (u71) invokeZ.objValue;
    }

    public u71<T> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.b.n(i);
            return this;
        }
        return (u71) invokeI.objValue;
    }

    public u71<T> e(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bubblePosition)) == null) {
            this.b.e().d = false;
            this.b.e().e = bubblePosition;
            return this;
        }
        return (u71) invokeL.objValue;
    }

    public u71<T> f(BubbleManager.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.b.o(bVar);
            return this;
        }
        return (u71) invokeL.objValue;
    }

    public u71<T> g(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            this.b.e().q(f);
            return this;
        }
        return (u71) invokeF.objValue;
    }

    public u71<T> b(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, viewGroup)) == null) {
            this.a.s(view2, viewGroup);
            return this;
        }
        return (u71) invokeLL.objValue;
    }

    public u71<T> d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            if (i != -1) {
                try {
                    this.a.w(i);
                } catch (Exception e) {
                    gg0.h("BubbleBuilder", "", e);
                    this.a.w(-1);
                    return this;
                }
            }
            if (i2 != -1) {
                try {
                    this.a.x(i2);
                } catch (Exception e2) {
                    gg0.h("BubbleBuilder", "", e2);
                    this.a.x(-1);
                }
            }
            return this;
        }
        return (u71) invokeII.objValue;
    }
}
