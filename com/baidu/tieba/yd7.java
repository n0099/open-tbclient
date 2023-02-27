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
public class yd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<qn> b;
    public jo c;
    public wd7 d;
    public be7 e;
    public rd7 f;
    public td7 g;
    public sd7 h;
    public ud7 i;
    public vd7 j;
    public xd7 k;

    public yd7(TbPageContext tbPageContext, jo joVar) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (joVar = this.c) != null) {
            joVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ae7(this.a));
            this.b.add(new zd7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            wd7 wd7Var = new wd7(this.a);
            this.d = wd7Var;
            wd7Var.v(this.c);
            this.b.add(this.d);
            be7 be7Var = new be7(this.a);
            this.e = be7Var;
            be7Var.v(this.c);
            this.b.add(this.e);
            rd7 rd7Var = new rd7(this.a);
            this.f = rd7Var;
            rd7Var.v(this.c);
            this.b.add(this.f);
            td7 td7Var = new td7(this.a);
            this.g = td7Var;
            td7Var.v(this.c);
            this.b.add(this.g);
            sd7 sd7Var = new sd7(this.a);
            this.h = sd7Var;
            sd7Var.v(this.c);
            this.b.add(this.h);
            ud7 ud7Var = new ud7(this.a);
            this.i = ud7Var;
            ud7Var.v(this.c);
            this.b.add(this.i);
            vd7 vd7Var = new vd7(this.a);
            this.j = vd7Var;
            vd7Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            xd7 xd7Var = new xd7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = xd7Var;
            xd7Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void d(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(pw4 pw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pw4Var) == null) {
            for (qn qnVar : this.b) {
                if (qnVar instanceof qd7) {
                    ((qd7) qnVar).u(pw4Var);
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
