package com.baidu.tieba;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mb1 extends kb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qb1 c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mb1() {
        this(new qb1());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((qb1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public qb1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (qb1) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb1(qb1 qb1Var) {
        super(qb1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qb1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nb1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = qb1Var;
    }

    public mb1 i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            super.a(z);
            return this;
        }
        return (mb1) invokeZ.objValue;
    }

    public mb1 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            super.c(i);
            return this;
        }
        return (mb1) invokeI.objValue;
    }

    public mb1 n(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bubblePosition)) == null) {
            super.e(bubblePosition);
            return this;
        }
        return (mb1) invokeL.objValue;
    }

    public mb1 o(BubbleManager.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            super.f(bVar);
            return this;
        }
        return (mb1) invokeL.objValue;
    }

    public mb1 p(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f)) == null) {
            super.g(f);
            return this;
        }
        return (mb1) invokeF.objValue;
    }

    public mb1 q(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
            this.c.f().D(charSequence);
            return this;
        }
        return (mb1) invokeL.objValue;
    }

    public mb1 j(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, viewGroup)) == null) {
            super.b(view2, viewGroup);
            return this;
        }
        return (mb1) invokeLL.objValue;
    }

    public mb1 l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) {
            super.d(i, i2);
            return this;
        }
        return (mb1) invokeII.objValue;
    }

    public mb1 m(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            this.c.s(i, f);
            return this;
        }
        return (mb1) invokeCommon.objValue;
    }

    public mb1 r(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i, i2)) == null) {
            try {
                this.c.f().E(i, i2);
                return this;
            } catch (Exception e) {
                lj0.h("BubbleTextBuilder", "", e);
                this.c.f().E(Color.parseColor("#CC000000"), Color.parseColor("#CC000000"));
                return this;
            }
        }
        return (mb1) invokeII.objValue;
    }
}
