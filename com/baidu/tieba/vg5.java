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
/* loaded from: classes6.dex */
public abstract class vg5<T, V extends TypeAdapter.ViewHolder> extends kn<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public TbPageContext<?> c;
    public Cdo d;
    public lq4 e;
    public ih5 f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public vg5(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f == null) {
            this.f = new ih5(this.d);
        }
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

    public boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if ((i & this.a) > 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void G(ih5 ih5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ih5Var) == null) {
            this.f = ih5Var;
        }
    }

    public void H(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lq4Var) == null) {
            this.e = lq4Var;
        }
    }

    public void J(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.mPageId = bdUniqueId;
        }
    }

    public void K(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cdo) == null) {
            this.d = cdo;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a = i | this.a;
        }
    }

    public void L(View view2, vr4 vr4Var, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{view2, vr4Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || vr4Var == null) {
            return;
        }
        lq4 lq4Var = this.e;
        if (lq4Var != null) {
            lq4Var.d(view2, vr4Var, vr4Var.position, j);
        } else {
            kh5.a(new jh5(StatsType.SHOW, vr4Var, view2, this.mPageId));
        }
    }

    public void m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, tbPageContext, bdUniqueId) == null) && tbPageContext != null) {
            this.mContext = tbPageContext.getPageActivity();
            this.c = tbPageContext;
            this.mPageId = bdUniqueId;
        }
    }

    public void u(View view2, vr4 vr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, view2, vr4Var) != null) || vr4Var == null) {
            return;
        }
        lq4 lq4Var = this.e;
        if (lq4Var != null) {
            int i = vr4Var.position;
            lq4Var.c(view2, vr4Var, i, i);
            return;
        }
        kh5.a(new jh5(StatsType.CLICK, vr4Var, view2, this.mPageId));
    }
}
