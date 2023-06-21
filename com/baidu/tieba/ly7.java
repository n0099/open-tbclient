package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.LoadingViewAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ly7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<jn> b;
    public co c;
    public jy7 d;
    public oy7 e;
    public ey7 f;
    public gy7 g;
    public fy7 h;
    public hy7 i;
    public iy7 j;
    public ky7 k;

    public ly7(TbPageContext tbPageContext, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, coVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = coVar;
        b();
    }

    public List<wn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (coVar = this.c) != null) {
            coVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ny7(this.a));
            this.b.add(new my7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            jy7 jy7Var = new jy7(this.a);
            this.d = jy7Var;
            jy7Var.x(this.c);
            this.b.add(this.d);
            oy7 oy7Var = new oy7(this.a);
            this.e = oy7Var;
            oy7Var.x(this.c);
            this.b.add(this.e);
            ey7 ey7Var = new ey7(this.a);
            this.f = ey7Var;
            ey7Var.x(this.c);
            this.b.add(this.f);
            gy7 gy7Var = new gy7(this.a);
            this.g = gy7Var;
            gy7Var.x(this.c);
            this.b.add(this.g);
            fy7 fy7Var = new fy7(this.a);
            this.h = fy7Var;
            fy7Var.x(this.c);
            this.b.add(this.h);
            hy7 hy7Var = new hy7(this.a);
            this.i = hy7Var;
            hy7Var.x(this.c);
            this.b.add(this.i);
            iy7 iy7Var = new iy7(this.a);
            this.j = iy7Var;
            iy7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            ky7 ky7Var = new ky7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = ky7Var;
            ky7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wz4Var) == null) {
            for (jn jnVar : this.b) {
                if (jnVar instanceof dy7) {
                    ((dy7) jnVar).u(wz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (jn jnVar : this.b) {
                jnVar.setPageId(bdUniqueId);
            }
        }
    }
}
