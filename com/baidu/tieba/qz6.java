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
/* loaded from: classes5.dex */
public class qz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public oz6 d;
    public tz6 e;
    public jz6 f;
    public lz6 g;
    public kz6 h;
    public mz6 i;
    public nz6 j;
    public pz6 k;

    public qz6(TbPageContext tbPageContext, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, joVar};
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
        this.c = joVar;
        b();
    }

    public List<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c.getData() : (List) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new sz6(this.a));
            this.b.add(new rz6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            oz6 oz6Var = new oz6(this.a);
            this.d = oz6Var;
            oz6Var.v(this.c);
            this.b.add(this.d);
            tz6 tz6Var = new tz6(this.a);
            this.e = tz6Var;
            tz6Var.v(this.c);
            this.b.add(this.e);
            jz6 jz6Var = new jz6(this.a);
            this.f = jz6Var;
            jz6Var.v(this.c);
            this.b.add(this.f);
            lz6 lz6Var = new lz6(this.a);
            this.g = lz6Var;
            lz6Var.v(this.c);
            this.b.add(this.g);
            kz6 kz6Var = new kz6(this.a);
            this.h = kz6Var;
            kz6Var.v(this.c);
            this.b.add(this.h);
            mz6 mz6Var = new mz6(this.a);
            this.i = mz6Var;
            mz6Var.v(this.c);
            this.b.add(this.i);
            nz6 nz6Var = new nz6(this.a);
            this.j = nz6Var;
            nz6Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            pz6 pz6Var = new pz6(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = pz6Var;
            pz6Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void c() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (joVar = this.c) == null) {
            return;
        }
        joVar.getListAdapter().notifyDataSetChanged();
    }

    public void d(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qp4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof iz6) {
                    ((iz6) qnVar).u(qp4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (qn qnVar : this.b) {
                qnVar.setPageId(bdUniqueId);
            }
        }
    }
}
