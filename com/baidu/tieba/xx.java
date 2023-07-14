package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tieba.t15;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class xx<T extends t15> implements sy, ry<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mz a;
    public Context b;
    public Boolean c;
    public up6<T> d;
    public a e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(t15 t15Var);
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    public abstract View l();

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
        }
    }

    public xx(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = Boolean.FALSE;
        this.b = context;
    }

    public up6<T> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (up6) invokeV.objValue;
    }

    public Boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (Boolean) invokeV.objValue;
    }

    public final ThreadCardView j(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, view2, i)) == null) {
            if (view2 != null && view2.getParent() != null && i != 0) {
                if (view2.getParent() instanceof ThreadCardView) {
                    return (ThreadCardView) view2.getParent();
                }
                return j((View) view2.getParent(), i - 1);
            }
            return null;
        }
        return (ThreadCardView) invokeLI.objValue;
    }

    public void n(int i, xz.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, bVar) == null) {
            this.a.n(i, bVar);
        }
    }

    public void p(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void s(View view2, int i) {
        ThreadCardView j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, view2, i) == null) && (j = j(view2, i)) != null) {
            d85 d = d85.d(j);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
        }
    }

    public void o(mz mzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mzVar) == null) {
            this.a = mzVar;
        }
    }

    public void q(up6<T> up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, up6Var) == null) {
            this.d = up6Var;
        }
    }

    public void t(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bool) == null) {
            this.c = bool;
        }
    }
}
