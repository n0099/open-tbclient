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
public class oy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public h6a b;
    public TbPageContext<?> c;
    public List<ci> d;
    public vi e;
    public py9 f;
    public qy9 g;
    public ry9 h;
    public sy9 i;
    public ty9 j;
    public uy9 k;
    public PbRecomChildTitleAdapter l;
    public q0a m;

    public oy9(h6a h6aVar, BdUniqueId bdUniqueId, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h6aVar, bdUniqueId, viVar};
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
        this.e = viVar;
        this.a = bdUniqueId;
        this.b = h6aVar;
        this.c = h6aVar.getPageContext();
        c();
        f(viVar);
        viVar.addAdapters(this.d);
    }

    public List<ci> a() {
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
            if (pbRecomChildTitleAdapter != null && pbRecomChildTitleAdapter.x() != null) {
                return this.l.x().itemView;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void d() {
        vi viVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (viVar = this.e) != null && viVar.getListAdapter() != null) {
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
            this.h = new ry9(this.c, dn6.G0);
            this.g = new qy9(this.c, dn6.H0);
            this.f = new py9(this.c, dn6.I0);
            this.i = new sy9(this.c, dn6.F0);
            this.j = new ty9(this.c, dn6.L0);
            this.k = new uy9(this.c, en6.U);
            this.l = new PbRecomChildTitleAdapter(this.b, on6.b);
            this.m = new q0a(this.b, hw9.c, this.a);
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

    public final void f(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viVar) == null) {
            this.h.A(viVar);
            this.g.A(viVar);
            this.f.A(viVar);
            this.i.A(viVar);
            this.j.A(viVar);
            this.k.D(viVar);
        }
    }

    public void g(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e.setData(list);
        }
    }
}
