package com.baidu.tieba;

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
/* loaded from: classes6.dex */
public abstract class te5<T, V extends TypeAdapter.ViewHolder> extends qn<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public TbPageContext<?> c;
    public jo d;
    public qp4 e;
    public gf5 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext == null ? null : tbPageContext.getPageActivity(), bdUniqueId);
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
        this.a = 0;
        this.b = true;
        m(tbPageContext, tbPageContext != null ? tbPageContext.getUniqueId() : null);
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            t();
            return this.f.a;
        }
        return invokeV.intValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t();
            return this.f.i;
        }
        return (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            t();
            return this.f.c;
        }
        return (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            t();
            return this.f.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? (i & this.a) > 0 : invokeI.booleanValue;
    }

    public void G(gf5 gf5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gf5Var) == null) {
            this.f = gf5Var;
        }
    }

    public void H(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, qp4Var) == null) {
            this.e = qp4Var;
        }
    }

    public void I(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
        }
    }

    public void K(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, joVar) == null) {
            this.d = joVar;
        }
    }

    public void L(View view2, yq4 yq4Var, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{view2, yq4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || yq4Var == null) {
            return;
        }
        qp4 qp4Var = this.e;
        if (qp4Var != null) {
            qp4Var.d(view2, yq4Var, yq4Var.position, j);
        } else {
            if5.a(new hf5(StatsType.SHOW, yq4Var, view2, this.mPageId));
        }
    }

    public void m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, tbPageContext, bdUniqueId) == null) || tbPageContext == null) {
            return;
        }
        this.mContext = tbPageContext.getPageActivity();
        this.c = tbPageContext;
        this.mPageId = bdUniqueId;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a = i | this.a;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f == null) {
            this.f = new gf5(this.d);
        }
    }

    public void u(View view2, yq4 yq4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, view2, yq4Var) == null) || yq4Var == null) {
            return;
        }
        qp4 qp4Var = this.e;
        if (qp4Var != null) {
            int i = yq4Var.position;
            qp4Var.c(view2, yq4Var, i, i);
            return;
        }
        if5.a(new hf5(StatsType.CLICK, yq4Var, view2, this.mPageId));
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            t();
            return this.f.e;
        }
        return invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            t();
            return this.f.f;
        }
        return invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            t();
            return this.f.b;
        }
        return (String) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            t();
            return this.f.g;
        }
        return invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            t();
            return this.f.h;
        }
        return invokeV.intValue;
    }
}
