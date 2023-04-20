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
/* loaded from: classes7.dex */
public class ys7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ut7 c;
    public nt7 d;
    public it7 e;
    public kt7 f;
    public jt7 g;
    public lt7 h;
    public vt7 i;
    public mt7 j;
    public pt7 k;
    public rt7 l;
    public qt7 m;
    public tt7 n;
    public gt7 o;
    public et7 p;
    public dt7 q;
    public ft7 r;
    public ot7 s;
    public st7 t;
    public ht7 u;
    public wt7 v;
    public List<vm> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ys7 a;

        public a(ys7 ys7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ys7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof xt7)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public ys7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        wt7 wt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (wt7Var = this.v) != null) {
            wt7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (vm vmVar : this.w) {
                if (vmVar instanceof at7) {
                    ((at7) vmVar).h(str);
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
            ut7 ut7Var = new ut7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.R1(), this.a.Q1());
            this.c = ut7Var;
            ut7Var.y(this.b);
            this.w.add(this.c);
            nt7 nt7Var = new nt7(this.a.getPageContext());
            this.d = nt7Var;
            nt7Var.x(this.b);
            this.w.add(this.d);
            it7 it7Var = new it7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.R1());
            this.e = it7Var;
            it7Var.z(this.b);
            this.w.add(this.e);
            kt7 kt7Var = new kt7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.f = kt7Var;
            kt7Var.y(this.b);
            this.w.add(this.f);
            jt7 jt7Var = new jt7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.R1());
            this.g = jt7Var;
            jt7Var.y(this.b);
            this.w.add(this.g);
            lt7 lt7Var = new lt7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.h = lt7Var;
            lt7Var.y(this.b);
            this.w.add(this.h);
            vt7 vt7Var = new vt7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.R1());
            this.i = vt7Var;
            vt7Var.B(this.b);
            this.w.add(this.i);
            mt7 mt7Var = new mt7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.R1());
            this.j = mt7Var;
            mt7Var.y(this.b);
            if ("fashion".equals(this.a.Q1()) || "local".equals(this.a.Q1())) {
                this.w.add(this.j);
            }
            pt7 pt7Var = new pt7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.R1());
            this.k = pt7Var;
            pt7Var.u(this.b);
            this.w.add(this.k);
            rt7 rt7Var = new rt7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.R1());
            this.l = rt7Var;
            rt7Var.x(this.b);
            this.w.add(this.l);
            qt7 qt7Var = new qt7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.R1());
            this.m = qt7Var;
            qt7Var.u(this.b);
            this.w.add(this.m);
            tt7 tt7Var = new tt7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.n = tt7Var;
            tt7Var.x(this.b);
            this.w.add(this.n);
            gt7 gt7Var = new gt7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.R1());
            this.o = gt7Var;
            gt7Var.z(this.b);
            this.w.add(this.o);
            ft7 ft7Var = new ft7(this.a.getPageContext(), mh6.Q0, this.a.R1());
            this.r = ft7Var;
            this.w.add(ft7Var);
            et7 et7Var = new et7(this.a.getPageContext(), ez4.e);
            this.p = et7Var;
            et7Var.x(this.b);
            this.w.add(this.p);
            dt7 dt7Var = new dt7(this.a.getPageContext(), jx4.b);
            this.q = dt7Var;
            dt7Var.A(this.b);
            this.w.add(this.q);
            ot7 ot7Var = new ot7(this.a.getPageContext());
            this.s = ot7Var;
            ot7Var.u(this.b);
            this.w.add(this.s);
            st7 st7Var = new st7(this.a.getPageContext());
            this.t = st7Var;
            st7Var.u(this.b);
            this.w.add(this.t);
            ht7 ht7Var = new ht7(this.a.getPageContext(), b());
            this.u = ht7Var;
            this.w.add(ht7Var);
            wt7 wt7Var = new wt7(this.a.getPageContext());
            this.v = wt7Var;
            this.w.add(wt7Var);
            this.b.addAdapters(this.w);
        }
    }
}
