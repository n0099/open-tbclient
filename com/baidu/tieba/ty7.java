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
public class ty7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public o48 b;
    public TbPageContext<?> c;
    public List<jn> d;
    public co e;
    public uy7 f;
    public vy7 g;
    public wy7 h;
    public xy7 i;
    public yy7 j;
    public zy7 k;
    public PbRecomChildTitleAdapter l;
    public j08 m;

    public void f(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dx7Var) == null) {
        }
    }

    public ty7(o48 o48Var, BdUniqueId bdUniqueId, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o48Var, bdUniqueId, coVar};
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
        this.e = coVar;
        this.a = bdUniqueId;
        this.b = o48Var;
        this.c = o48Var.getPageContext();
        c();
        g(coVar);
        coVar.a(this.d);
    }

    public List<jn> a() {
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
        co coVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (coVar = this.e) != null && coVar.getListAdapter() != null) {
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
            this.h = new wy7(this.c, o46.B0);
            this.g = new vy7(this.c, o46.C0);
            this.f = new uy7(this.c, o46.D0);
            this.i = new xy7(this.c, o46.A0);
            this.j = new yy7(this.c, o46.G0);
            this.k = new zy7(this.c, p46.U);
            this.l = new PbRecomChildTitleAdapter(this.b, y46.b);
            this.m = new j08(this.b, jx7.c, this.a);
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

    public final void g(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, coVar) == null) {
            this.h.x(coVar);
            this.g.x(coVar);
            this.f.x(coVar);
            this.i.x(coVar);
            this.j.x(coVar);
            this.k.A(coVar);
        }
    }

    public void h(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.e.setData(list);
        }
    }
}
