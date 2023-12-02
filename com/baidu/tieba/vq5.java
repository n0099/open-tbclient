package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.template.adapter.stats.StatsType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class vq5<T, V extends TypeAdapter.ViewHolder> extends ci<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public TbPageContext<?> c;
    public vi d;
    public av4 e;
    public ir5 f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public vq5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(r1, bdUniqueId);
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tbPageContext == null) {
            pageActivity = null;
        } else {
            pageActivity = tbPageContext.getPageActivity();
        }
        this.a = 0;
        this.b = true;
        n(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            u();
            return this.f.b;
        }
        return (String) invokeV.objValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            u();
            return this.f.g;
        }
        return invokeV.intValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            u();
            return this.f.h;
        }
        return invokeV.intValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            u();
            return this.f.a;
        }
        return invokeV.intValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            u();
            return this.f.i;
        }
        return (String) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            u();
            return this.f.c;
        }
        return (String) invokeV.objValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u();
            return this.f.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f == null) {
            this.f = new ir5(this.d);
        }
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            u();
            return this.f.e;
        }
        return invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            u();
            return this.f.f;
        }
        return invokeV.intValue;
    }

    public boolean I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if ((i & this.a) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void J(ir5 ir5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ir5Var) == null) {
            this.f = ir5Var;
        }
    }

    public void K(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, av4Var) == null) {
            this.e = av4Var;
        }
    }

    public void L(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
        }
    }

    public void M(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, viVar) == null) {
            this.d = viVar;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a = i | this.a;
        }
    }

    public void N(View view2, fw4 fw4Var, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{view2, fw4Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || fw4Var == null) {
            return;
        }
        av4 av4Var = this.e;
        if (av4Var != null) {
            av4Var.d(view2, fw4Var, fw4Var.position, j);
        } else {
            kr5.a(new jr5(StatsType.SHOW, fw4Var, view2, this.mPageId));
        }
    }

    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, tbPageContext, bdUniqueId) == null) && tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.c = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void x(View view2, fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048593, this, view2, fw4Var) != null) || fw4Var == null) {
            return;
        }
        av4 av4Var = this.e;
        if (av4Var != null) {
            int i = fw4Var.position;
            av4Var.b(view2, fw4Var, i, i);
            return;
        }
        kr5.a(new jr5(StatsType.CLICK, fw4Var, view2, this.mPageId));
    }
}
