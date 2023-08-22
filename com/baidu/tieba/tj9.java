package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.adapter.PbRecomChildTitleAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public aq9 b;
    public TbPageContext<?> c;
    public List<om> d;
    public hn e;
    public uj9 f;
    public vj9 g;
    public wj9 h;
    public xj9 i;
    public yj9 j;
    public zj9 k;
    public PbRecomChildTitleAdapter l;
    public ll9 m;

    public tj9(aq9 aq9Var, BdUniqueId bdUniqueId, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aq9Var, bdUniqueId, hnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.e = hnVar;
        this.a = bdUniqueId;
        this.b = aq9Var;
        this.c = aq9Var.getPageContext();
        c();
        f(hnVar);
        hnVar.addAdapters(this.d);
    }

    public List<om> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter != null && pbRecomChildTitleAdapter.u() != null) {
                return this.l.u().itemView;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hnVar = this.e) != null && hnVar.getListAdapter() != null) {
            this.e.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = new wj9(this.c, zo6.G0);
            this.g = new vj9(this.c, zo6.H0);
            this.f = new uj9(this.c, zo6.I0);
            this.i = new xj9(this.c, zo6.F0);
            this.j = new yj9(this.c, zo6.L0);
            this.k = new zj9(this.c, ap6.U);
            this.l = new PbRecomChildTitleAdapter(this.b, jp6.b);
            this.m = new ll9(this.b, gi9.c, this.a);
            this.d.add(this.h);
            this.d.add(this.g);
            this.d.add(this.f);
            this.d.add(this.i);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
        }
    }

    public final void f(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hnVar) == null) {
            this.h.z(hnVar);
            this.g.z(hnVar);
            this.f.z(hnVar);
            this.i.z(hnVar);
            this.j.z(hnVar);
            this.k.C(hnVar);
        }
    }

    public void g(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e.setData(list);
        }
    }
}
