package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class oa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public kb7 c;
    public db7 d;
    public ya7 e;
    public ab7 f;
    public za7 g;
    public bb7 h;
    public lb7 i;
    public cb7 j;
    public fb7 k;
    public hb7 l;
    public gb7 m;
    public jb7 n;
    public wa7 o;
    public ua7 p;
    public ta7 q;
    public va7 r;
    public eb7 s;
    public ib7 t;
    public xa7 u;
    public mb7 v;
    public List<ln> w;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa7 a;

        public a(oa7 oa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oa7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.E(0) instanceof nb7)) {
                    this.a.b.G(0);
                }
            }
        }
    }

    public oa7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {homePageTabFeedFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new LinkedList();
        this.a = homePageTabFeedFragment;
        this.b = bdTypeRecyclerView;
        c();
    }

    public void e(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        mb7 mb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (mb7Var = this.v) != null) {
            mb7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (ln lnVar : this.w) {
                if (lnVar instanceof qa7) {
                    ((qa7) lnVar).h(str);
                }
            }
        }
    }

    public final View.OnClickListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            kb7 kb7Var = new kb7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.P1(), this.a.O1());
            this.c = kb7Var;
            kb7Var.w(this.b);
            this.w.add(this.c);
            db7 db7Var = new db7(this.a.getPageContext());
            this.d = db7Var;
            db7Var.v(this.b);
            this.w.add(this.d);
            ya7 ya7Var = new ya7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.P1());
            this.e = ya7Var;
            ya7Var.x(this.b);
            this.w.add(this.e);
            ab7 ab7Var = new ab7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.f = ab7Var;
            ab7Var.w(this.b);
            this.w.add(this.f);
            za7 za7Var = new za7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.P1());
            this.g = za7Var;
            za7Var.w(this.b);
            this.w.add(this.g);
            bb7 bb7Var = new bb7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.h = bb7Var;
            bb7Var.w(this.b);
            this.w.add(this.h);
            lb7 lb7Var = new lb7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.P1());
            this.i = lb7Var;
            lb7Var.z(this.b);
            this.w.add(this.i);
            cb7 cb7Var = new cb7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.P1());
            this.j = cb7Var;
            cb7Var.w(this.b);
            if ("fashion".equals(this.a.O1()) || "local".equals(this.a.O1())) {
                this.w.add(this.j);
            }
            fb7 fb7Var = new fb7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.P1());
            this.k = fb7Var;
            fb7Var.u(this.b);
            this.w.add(this.k);
            hb7 hb7Var = new hb7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.P1());
            this.l = hb7Var;
            hb7Var.v(this.b);
            this.w.add(this.l);
            gb7 gb7Var = new gb7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.P1());
            this.m = gb7Var;
            gb7Var.u(this.b);
            this.w.add(this.m);
            jb7 jb7Var = new jb7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.n = jb7Var;
            jb7Var.v(this.b);
            this.w.add(this.n);
            wa7 wa7Var = new wa7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.P1());
            this.o = wa7Var;
            wa7Var.x(this.b);
            this.w.add(this.o);
            va7 va7Var = new va7(this.a.getPageContext(), n96.O0, this.a.P1());
            this.r = va7Var;
            this.w.add(va7Var);
            ua7 ua7Var = new ua7(this.a.getPageContext(), yu4.e);
            this.p = ua7Var;
            ua7Var.v(this.b);
            this.w.add(this.p);
            ta7 ta7Var = new ta7(this.a.getPageContext(), dt4.b);
            this.q = ta7Var;
            ta7Var.y(this.b);
            this.w.add(this.q);
            eb7 eb7Var = new eb7(this.a.getPageContext());
            this.s = eb7Var;
            eb7Var.u(this.b);
            this.w.add(this.s);
            ib7 ib7Var = new ib7(this.a.getPageContext());
            this.t = ib7Var;
            ib7Var.u(this.b);
            this.w.add(this.t);
            xa7 xa7Var = new xa7(this.a.getPageContext(), b());
            this.u = xa7Var;
            this.w.add(xa7Var);
            mb7 mb7Var = new mb7(this.a.getPageContext());
            this.v = mb7Var;
            this.w.add(mb7Var);
            this.b.a(this.w);
        }
    }
}
