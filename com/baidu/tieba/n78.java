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
/* loaded from: classes5.dex */
public class n78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f78 a;
    public c78 b;
    public k78 c;
    public l78 d;
    public g78 e;
    public j78 f;
    public e78 g;
    public h78 h;
    public i78 i;
    public BdTypeListView j;
    public d78 k;
    public m78 l;
    public List<kn> m;

    public n78(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new f78(tbPageContext, a88.b);
            this.b = new c78(tbPageContext, u78.f);
            this.c = new k78(tbPageContext, g88.b);
            this.d = new l78(tbPageContext, h88.c);
            this.e = new g78(tbPageContext, w78.b);
            this.f = new j78(tbPageContext, x78.b);
            this.k = new d78(tbPageContext, y78.c);
            this.h = new h78(tbPageContext, c88.b);
            this.i = new i78(tbPageContext, d88.b);
            this.g = new e78(tbPageContext, z78.l);
            this.l = new m78(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
            bdTypeListView.a(this.m);
        }
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.j) != null && (bdTypeListView.getAdapter2() instanceof on)) {
            this.j.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        m78 m78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (m78Var = this.l) != null) {
            m78Var.onDestroy();
        }
    }

    public void d() {
        m78 m78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (m78Var = this.l) != null) {
            m78Var.onPause();
        }
    }

    public void f() {
        m78 m78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (m78Var = this.l) != null) {
            m78Var.onResume();
        }
    }

    public void g() {
        h78 h78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (h78Var = this.h) != null) {
            h78Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            m78 m78Var = this.l;
            if (m78Var != null) {
                m78Var.u(z);
            }
            d78 d78Var = this.k;
            if (d78Var != null) {
                d78Var.v(z);
            }
            j78 j78Var = this.f;
            if (j78Var != null) {
                j78Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        d78 d78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (d78Var = this.k) != null) {
            d78Var.u(z);
        }
    }
}
