package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jv9 a;
    public gv9 b;
    public ov9 c;
    public pv9 d;
    public kv9 e;
    public nv9 f;
    public iv9 g;
    public lv9 h;
    public mv9 i;
    public BdTypeListView j;
    public hv9 k;
    public qv9 l;
    public List<om> m;

    public rv9(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.j = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public final void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, bdTypeListView, tbPageContext, bdUniqueId) == null) {
            this.a = new jv9(tbPageContext, fw9.b);
            this.b = new gv9(tbPageContext, zv9.f);
            this.c = new ov9(tbPageContext, lw9.b);
            this.d = new pv9(tbPageContext, mw9.b);
            this.e = new kv9(tbPageContext, bw9.b);
            this.f = new nv9(tbPageContext, cw9.b);
            this.k = new hv9(tbPageContext, dw9.b);
            this.h = new lv9(tbPageContext, hw9.b);
            this.i = new mv9(tbPageContext, iw9.b);
            this.g = new iv9(tbPageContext, ew9.p);
            this.l = new qv9(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
            this.m.add(this.a);
            this.m.add(this.l);
            this.m.add(this.b);
            this.m.add(this.e);
            this.m.add(this.f);
            this.m.add(this.c);
            this.m.add(this.d);
            this.m.add(this.h);
            this.m.add(this.i);
            this.m.add(this.g);
            this.m.add(this.k);
            bdTypeListView.addAdapters(this.m);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof sm)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (qv9Var = this.l) != null) {
            qv9Var.onDestroy();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qv9 qv9Var = this.l;
            if (qv9Var != null) {
                qv9Var.onPause();
            }
            ov9 ov9Var = this.c;
            if (ov9Var != null) {
                ov9Var.onPause();
            }
        }
    }

    public void f() {
        qv9 qv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (qv9Var = this.l) != null) {
            qv9Var.onResume();
        }
    }

    public void g() {
        lv9 lv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (lv9Var = this.h) != null) {
            lv9Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            qv9 qv9Var = this.l;
            if (qv9Var != null) {
                qv9Var.u(z);
            }
            hv9 hv9Var = this.k;
            if (hv9Var != null) {
                hv9Var.u(z);
            }
            nv9 nv9Var = this.f;
            if (nv9Var != null) {
                nv9Var.u(z);
            }
            ov9 ov9Var = this.c;
            if (ov9Var != null) {
                ov9Var.u(z);
            }
        }
    }
}
