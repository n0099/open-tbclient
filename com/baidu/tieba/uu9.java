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
public class uu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public h1a b;
    public TbPageContext<?> c;
    public List<bi> d;
    public ui e;
    public vu9 f;
    public wu9 g;
    public xu9 h;
    public yu9 i;
    public zu9 j;
    public av9 k;
    public PbRecomChildTitleAdapter l;
    public mw9 m;

    public uu9(h1a h1aVar, BdUniqueId bdUniqueId, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h1aVar, bdUniqueId, uiVar};
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
        this.e = uiVar;
        this.a = bdUniqueId;
        this.b = h1aVar;
        this.c = h1aVar.getPageContext();
        c();
        f(uiVar);
        uiVar.addAdapters(this.d);
    }

    public List<bi> a() {
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
        ui uiVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (uiVar = this.e) != null && uiVar.getListAdapter() != null) {
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
            this.h = new xu9(this.c, om6.G0);
            this.g = new wu9(this.c, om6.H0);
            this.f = new vu9(this.c, om6.I0);
            this.i = new yu9(this.c, om6.F0);
            this.j = new zu9(this.c, om6.L0);
            this.k = new av9(this.c, pm6.U);
            this.l = new PbRecomChildTitleAdapter(this.b, zm6.b);
            this.m = new mw9(this.b, ms9.c, this.a);
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

    public final void f(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uiVar) == null) {
            this.h.A(uiVar);
            this.g.A(uiVar);
            this.f.A(uiVar);
            this.i.A(uiVar);
            this.j.A(uiVar);
            this.k.D(uiVar);
        }
    }

    public void g(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.e.setData(list);
        }
    }
}
