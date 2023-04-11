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
public class xs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public tt7 c;
    public mt7 d;
    public ht7 e;
    public jt7 f;
    public it7 g;
    public kt7 h;
    public ut7 i;
    public lt7 j;
    public ot7 k;
    public qt7 l;
    public pt7 m;
    public st7 n;
    public ft7 o;
    public dt7 p;
    public ct7 q;
    public et7 r;
    public nt7 s;
    public rt7 t;
    public gt7 u;
    public vt7 v;
    public List<um> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs7 a;

        public a(xs7 xs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xs7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof wt7)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public xs7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<hn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        vt7 vt7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (vt7Var = this.v) != null) {
            vt7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (um umVar : this.w) {
                if (umVar instanceof zs7) {
                    ((zs7) umVar).h(str);
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
            tt7 tt7Var = new tt7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.R1(), this.a.Q1());
            this.c = tt7Var;
            tt7Var.y(this.b);
            this.w.add(this.c);
            mt7 mt7Var = new mt7(this.a.getPageContext());
            this.d = mt7Var;
            mt7Var.x(this.b);
            this.w.add(this.d);
            ht7 ht7Var = new ht7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.R1());
            this.e = ht7Var;
            ht7Var.z(this.b);
            this.w.add(this.e);
            jt7 jt7Var = new jt7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.f = jt7Var;
            jt7Var.y(this.b);
            this.w.add(this.f);
            it7 it7Var = new it7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.R1());
            this.g = it7Var;
            it7Var.y(this.b);
            this.w.add(this.g);
            kt7 kt7Var = new kt7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.h = kt7Var;
            kt7Var.y(this.b);
            this.w.add(this.h);
            ut7 ut7Var = new ut7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.R1());
            this.i = ut7Var;
            ut7Var.B(this.b);
            this.w.add(this.i);
            lt7 lt7Var = new lt7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.R1());
            this.j = lt7Var;
            lt7Var.y(this.b);
            if ("fashion".equals(this.a.Q1()) || "local".equals(this.a.Q1())) {
                this.w.add(this.j);
            }
            ot7 ot7Var = new ot7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.R1());
            this.k = ot7Var;
            ot7Var.u(this.b);
            this.w.add(this.k);
            qt7 qt7Var = new qt7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.R1());
            this.l = qt7Var;
            qt7Var.x(this.b);
            this.w.add(this.l);
            pt7 pt7Var = new pt7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.R1());
            this.m = pt7Var;
            pt7Var.u(this.b);
            this.w.add(this.m);
            st7 st7Var = new st7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.R1());
            this.n = st7Var;
            st7Var.x(this.b);
            this.w.add(this.n);
            ft7 ft7Var = new ft7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.R1());
            this.o = ft7Var;
            ft7Var.z(this.b);
            this.w.add(this.o);
            et7 et7Var = new et7(this.a.getPageContext(), lh6.Q0, this.a.R1());
            this.r = et7Var;
            this.w.add(et7Var);
            dt7 dt7Var = new dt7(this.a.getPageContext(), dz4.e);
            this.p = dt7Var;
            dt7Var.x(this.b);
            this.w.add(this.p);
            ct7 ct7Var = new ct7(this.a.getPageContext(), ix4.b);
            this.q = ct7Var;
            ct7Var.A(this.b);
            this.w.add(this.q);
            nt7 nt7Var = new nt7(this.a.getPageContext());
            this.s = nt7Var;
            nt7Var.u(this.b);
            this.w.add(this.s);
            rt7 rt7Var = new rt7(this.a.getPageContext());
            this.t = rt7Var;
            rt7Var.u(this.b);
            this.w.add(this.t);
            gt7 gt7Var = new gt7(this.a.getPageContext(), b());
            this.u = gt7Var;
            this.w.add(gt7Var);
            vt7 vt7Var = new vt7(this.a.getPageContext());
            this.v = vt7Var;
            this.w.add(vt7Var);
            this.b.addAdapters(this.w);
        }
    }
}
