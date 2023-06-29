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
/* loaded from: classes7.dex */
public class qy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public oy7 d;
    public ty7 e;
    public jy7 f;
    public ly7 g;
    public ky7 h;
    public my7 i;
    public ny7 j;
    public py7 k;

    public qy7(TbPageContext tbPageContext, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cdo};
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
        this.c = cdo;
        b();
    }

    public List<xn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cdo = this.c) != null) {
            cdo.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new sy7(this.a));
            this.b.add(new ry7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            oy7 oy7Var = new oy7(this.a);
            this.d = oy7Var;
            oy7Var.x(this.c);
            this.b.add(this.d);
            ty7 ty7Var = new ty7(this.a);
            this.e = ty7Var;
            ty7Var.x(this.c);
            this.b.add(this.e);
            jy7 jy7Var = new jy7(this.a);
            this.f = jy7Var;
            jy7Var.x(this.c);
            this.b.add(this.f);
            ly7 ly7Var = new ly7(this.a);
            this.g = ly7Var;
            ly7Var.x(this.c);
            this.b.add(this.g);
            ky7 ky7Var = new ky7(this.a);
            this.h = ky7Var;
            ky7Var.x(this.c);
            this.b.add(this.h);
            my7 my7Var = new my7(this.a);
            this.i = my7Var;
            my7Var.x(this.c);
            this.b.add(this.i);
            ny7 ny7Var = new ny7(this.a);
            this.j = ny7Var;
            ny7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            py7 py7Var = new py7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = py7Var;
            py7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zz4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof iy7) {
                    ((iy7) knVar).u(zz4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (kn knVar : this.b) {
                knVar.setPageId(bdUniqueId);
            }
        }
    }
}
