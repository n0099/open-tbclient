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
public class o78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g78 a;
    public d78 b;
    public l78 c;
    public m78 d;
    public h78 e;
    public k78 f;
    public f78 g;
    public i78 h;
    public j78 i;
    public BdTypeListView j;
    public e78 k;
    public n78 l;
    public List<kn> m;

    public o78(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
            this.a = new g78(tbPageContext, b88.b);
            this.b = new d78(tbPageContext, v78.f);
            this.c = new l78(tbPageContext, h88.b);
            this.d = new m78(tbPageContext, i88.c);
            this.e = new h78(tbPageContext, x78.b);
            this.f = new k78(tbPageContext, y78.b);
            this.k = new e78(tbPageContext, z78.c);
            this.h = new i78(tbPageContext, d88.b);
            this.i = new j78(tbPageContext, e88.b);
            this.g = new f78(tbPageContext, a88.l);
            this.l = new n78(tbPageContext, PersonVipCardData.PERSON_VIP_CARD_DATA);
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
        n78 n78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (n78Var = this.l) != null) {
            n78Var.onDestroy();
        }
    }

    public void d() {
        n78 n78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (n78Var = this.l) != null) {
            n78Var.onPause();
        }
    }

    public void f() {
        n78 n78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (n78Var = this.l) != null) {
            n78Var.onResume();
        }
    }

    public void g() {
        i78 i78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (i78Var = this.h) != null) {
            i78Var.onScroll();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            n78 n78Var = this.l;
            if (n78Var != null) {
                n78Var.u(z);
            }
            e78 e78Var = this.k;
            if (e78Var != null) {
                e78Var.v(z);
            }
            k78 k78Var = this.f;
            if (k78Var != null) {
                k78Var.u(z);
            }
        }
    }

    public void h(boolean z) {
        e78 e78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (e78Var = this.k) != null) {
            e78Var.u(z);
        }
    }
}
