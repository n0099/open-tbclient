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
public class ug9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public bn9 b;
    public TbPageContext<?> c;
    public List<ln> d;
    public eo e;
    public vg9 f;
    public wg9 g;
    public xg9 h;
    public yg9 i;
    public zg9 j;
    public ah9 k;
    public PbRecomChildTitleAdapter l;
    public li9 m;

    public ug9(bn9 bn9Var, BdUniqueId bdUniqueId, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn9Var, bdUniqueId, eoVar};
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
        this.e = eoVar;
        this.a = bdUniqueId;
        this.b = bn9Var;
        this.c = bn9Var.getPageContext();
        c();
        f(eoVar);
        eoVar.addAdapters(this.d);
    }

    public List<ln> a() {
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
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (eoVar = this.e) != null && eoVar.getListAdapter() != null) {
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
            this.h = new xg9(this.c, kq6.G0);
            this.g = new wg9(this.c, kq6.H0);
            this.f = new vg9(this.c, kq6.I0);
            this.i = new yg9(this.c, kq6.F0);
            this.j = new zg9(this.c, kq6.L0);
            this.k = new ah9(this.c, lq6.U);
            this.l = new PbRecomChildTitleAdapter(this.b, uq6.b);
            this.m = new li9(this.b, hf9.c, this.a);
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

    public final void f(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eoVar) == null) {
            this.h.z(eoVar);
            this.g.z(eoVar);
            this.f.z(eoVar);
            this.i.z(eoVar);
            this.j.z(eoVar);
            this.k.C(eoVar);
        }
    }

    public void g(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e.setData(list);
        }
    }
}
