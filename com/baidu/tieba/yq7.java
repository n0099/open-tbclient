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
public class yq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<vm> b;
    public on c;
    public wq7 d;
    public br7 e;
    public rq7 f;
    public tq7 g;
    public sq7 h;
    public uq7 i;
    public vq7 j;
    public xq7 k;

    public yq7(TbPageContext tbPageContext, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onVar};
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
        this.c = onVar;
        b();
    }

    public List<in> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.getData();
        }
        return (List) invokeV.objValue;
    }

    public void c() {
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (onVar = this.c) != null) {
            onVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(new ar7(this.a));
            this.b.add(new zq7(this.a));
            this.b.add(new LoadingViewAdapter(this.a));
            wq7 wq7Var = new wq7(this.a);
            this.d = wq7Var;
            wq7Var.x(this.c);
            this.b.add(this.d);
            br7 br7Var = new br7(this.a);
            this.e = br7Var;
            br7Var.x(this.c);
            this.b.add(this.e);
            rq7 rq7Var = new rq7(this.a);
            this.f = rq7Var;
            rq7Var.x(this.c);
            this.b.add(this.f);
            tq7 tq7Var = new tq7(this.a);
            this.g = tq7Var;
            tq7Var.x(this.c);
            this.b.add(this.g);
            sq7 sq7Var = new sq7(this.a);
            this.h = sq7Var;
            sq7Var.x(this.c);
            this.b.add(this.h);
            uq7 uq7Var = new uq7(this.a);
            this.i = uq7Var;
            uq7Var.x(this.c);
            this.b.add(this.i);
            vq7 vq7Var = new vq7(this.a);
            this.j = vq7Var;
            vq7Var.x(this.c);
            this.b.add(this.j);
            TbPageContext tbPageContext = this.a;
            xq7 xq7Var = new xq7(tbPageContext, ThreadData.TYPE_RECOMMEND_INFO, tbPageContext.getUniqueId());
            this.k = xq7Var;
            xq7Var.x(this.c);
            this.b.add(this.k);
            this.c.addAdapters(this.b);
        }
    }

    public void d(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.c.setData(list);
        }
    }

    public void e(qv4 qv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qv4Var) == null) {
            for (vm vmVar : this.b) {
                if (vmVar instanceof qq7) {
                    ((qq7) vmVar).u(qv4Var);
                }
            }
        }
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            for (vm vmVar : this.b) {
                vmVar.setPageId(bdUniqueId);
            }
        }
    }
}
