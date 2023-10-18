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
/* loaded from: classes7.dex */
public class oh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public bo9 b;
    public TbPageContext<?> c;
    public List<lh> d;
    public ei e;
    public ph9 f;
    public qh9 g;
    public rh9 h;
    public sh9 i;
    public th9 j;
    public uh9 k;
    public PbRecomChildTitleAdapter l;
    public gj9 m;

    public oh9(bo9 bo9Var, BdUniqueId bdUniqueId, ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bo9Var, bdUniqueId, eiVar};
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
        this.e = eiVar;
        this.a = bdUniqueId;
        this.b = bo9Var;
        this.c = bo9Var.getPageContext();
        c();
        f(eiVar);
        eiVar.addAdapters(this.d);
    }

    public List<lh> a() {
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
        ei eiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (eiVar = this.e) != null && eiVar.getListAdapter() != null) {
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
            this.h = new rh9(this.c, rk6.G0);
            this.g = new qh9(this.c, rk6.H0);
            this.f = new ph9(this.c, rk6.I0);
            this.i = new sh9(this.c, rk6.F0);
            this.j = new th9(this.c, rk6.L0);
            this.k = new uh9(this.c, sk6.U);
            this.l = new PbRecomChildTitleAdapter(this.b, cl6.b);
            this.m = new gj9(this.b, gf9.c, this.a);
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

    public final void f(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eiVar) == null) {
            this.h.z(eiVar);
            this.g.z(eiVar);
            this.f.z(eiVar);
            this.i.z(eiVar);
            this.j.z(eiVar);
            this.k.C(eiVar);
        }
    }

    public void g(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e.setData(list);
        }
    }
}
