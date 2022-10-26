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
public class yz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List b;
    public ko c;
    public wz6 d;
    public b07 e;
    public rz6 f;
    public tz6 g;
    public sz6 h;
    public uz6 i;
    public vz6 j;
    public xz6 k;

    public yz6(TbPageContext tbPageContext, ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, koVar};
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
        this.c = koVar;
        b();
    }

    public List a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        ko koVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (koVar = this.c) != null) {
            koVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new a07(this.a));
            this.b.add(new zz6(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            wz6 wz6Var = new wz6(this.a);
            this.d = wz6Var;
            wz6Var.v(this.c);
            this.b.add(this.d);
            b07 b07Var = new b07(this.a);
            this.e = b07Var;
            b07Var.v(this.c);
            this.b.add(this.e);
            rz6 rz6Var = new rz6(this.a);
            this.f = rz6Var;
            rz6Var.v(this.c);
            this.b.add(this.f);
            tz6 tz6Var = new tz6(this.a);
            this.g = tz6Var;
            tz6Var.v(this.c);
            this.b.add(this.g);
            sz6 sz6Var = new sz6(this.a);
            this.h = sz6Var;
            sz6Var.v(this.c);
            this.b.add(this.h);
            uz6 uz6Var = new uz6(this.a);
            this.i = uz6Var;
            uz6Var.v(this.c);
            this.b.add(this.i);
            vz6 vz6Var = new vz6(this.a);
            this.j = vz6Var;
            vz6Var.v(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            xz6 xz6Var = new xz6(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = xz6Var;
            xz6Var.v(this.c);
            this.b.add(this.k);
            this.c.a(this.b);
        }
    }

    public void d(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(rp4 rp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rp4Var) == null) {
            for (rn rnVar : this.b) {
                if (rnVar instanceof qz6) {
                    ((qz6) rnVar).u(rp4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (rn rnVar : this.b) {
                rnVar.setPageId(bdUniqueId);
            }
        }
    }
}
