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
/* loaded from: classes6.dex */
public class jl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public rr9 b;
    public TbPageContext<?> c;
    public List<pm> d;
    public in e;
    public kl9 f;
    public ll9 g;
    public ml9 h;
    public nl9 i;
    public ol9 j;
    public pl9 k;
    public PbRecomChildTitleAdapter l;
    public bn9 m;

    public jl9(rr9 rr9Var, BdUniqueId bdUniqueId, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rr9Var, bdUniqueId, inVar};
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
        this.e = inVar;
        this.a = bdUniqueId;
        this.b = rr9Var;
        this.c = rr9Var.getPageContext();
        c();
        f(inVar);
        inVar.addAdapters(this.d);
    }

    public List<pm> a() {
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
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (inVar = this.e) != null && inVar.getListAdapter() != null) {
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
            this.h = new ml9(this.c, cq6.G0);
            this.g = new ll9(this.c, cq6.H0);
            this.f = new kl9(this.c, cq6.I0);
            this.i = new nl9(this.c, cq6.F0);
            this.j = new ol9(this.c, cq6.L0);
            this.k = new pl9(this.c, dq6.U);
            this.l = new PbRecomChildTitleAdapter(this.b, nq6.b);
            this.m = new bn9(this.b, ij9.c, this.a);
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

    public final void f(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, inVar) == null) {
            this.h.z(inVar);
            this.g.z(inVar);
            this.f.z(inVar);
            this.i.z(inVar);
            this.j.z(inVar);
            this.k.C(inVar);
        }
    }

    public void g(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e.setData(list);
        }
    }
}
