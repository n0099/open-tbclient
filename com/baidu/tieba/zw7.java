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
public class zw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public t28 b;
    public TbPageContext<?> c;
    public List<qn> d;
    public jo e;
    public ax7 f;
    public bx7 g;
    public cx7 h;
    public dx7 i;
    public ex7 j;
    public fx7 k;
    public PbRecomChildTitleAdapter l;
    public py7 m;

    public zw7(t28 t28Var, BdUniqueId bdUniqueId, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t28Var, bdUniqueId, joVar};
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
        this.e = joVar;
        this.a = bdUniqueId;
        this.b = t28Var;
        this.c = t28Var.getPageContext();
        c();
        g(joVar);
        joVar.a(this.d);
    }

    public List<qn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PbRecomChildTitleAdapter pbRecomChildTitleAdapter = this.l;
            if (pbRecomChildTitleAdapter == null || pbRecomChildTitleAdapter.u() == null) {
                return null;
            }
            return this.l.u().itemView;
        }
        return (View) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = new cx7(this.c, x26.B0);
            this.g = new bx7(this.c, x26.C0);
            this.f = new ax7(this.c, x26.D0);
            this.i = new dx7(this.c, x26.A0);
            this.j = new ex7(this.c, x26.G0);
            this.k = new fx7(this.c, y26.U);
            this.l = new PbRecomChildTitleAdapter(this.b, h36.b);
            this.m = new py7(this.b, pv7.c, this.a);
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

    public void d() {
        jo joVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (joVar = this.e) == null || joVar.getListAdapter() == null) {
            return;
        }
        this.e.getListAdapter().notifyDataSetChanged();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void f(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jv7Var) == null) {
        }
    }

    public final void g(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, joVar) == null) {
            this.h.x(joVar);
            this.g.x(joVar);
            this.f.x(joVar);
            this.i.x(joVar);
            this.j.x(joVar);
            this.k.A(joVar);
        }
    }

    public void h(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.e.setData(list);
        }
    }
}
