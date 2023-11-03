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
/* loaded from: classes9.dex */
public class yf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ug8 c;
    public ng8 d;
    public ig8 e;
    public kg8 f;
    public jg8 g;
    public lg8 h;
    public vg8 i;
    public mg8 j;
    public pg8 k;
    public rg8 l;
    public qg8 m;
    public tg8 n;
    public gg8 o;
    public eg8 p;
    public dg8 q;
    public fg8 r;
    public og8 s;
    public sg8 t;
    public hg8 u;
    public wg8 v;
    public List<bi> w;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yf8 a;

        public a(yf8 yf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof xg8)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public yf8(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<oi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        wg8 wg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (wg8Var = this.v) != null) {
            wg8Var.x(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (bi biVar : this.w) {
                if (biVar instanceof ag8) {
                    ((ag8) biVar).h(str);
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
            ug8 ug8Var = new ug8(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.H2(), this.a.G2());
            this.c = ug8Var;
            ug8Var.z(this.b);
            this.w.add(this.c);
            ng8 ng8Var = new ng8(this.a.getPageContext());
            this.d = ng8Var;
            ng8Var.y(this.b);
            this.w.add(this.d);
            ig8 ig8Var = new ig8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.H2());
            this.e = ig8Var;
            ig8Var.A(this.b);
            this.w.add(this.e);
            kg8 kg8Var = new kg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.H2());
            this.f = kg8Var;
            kg8Var.z(this.b);
            this.w.add(this.f);
            jg8 jg8Var = new jg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.H2());
            this.g = jg8Var;
            jg8Var.z(this.b);
            this.w.add(this.g);
            lg8 lg8Var = new lg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.H2());
            this.h = lg8Var;
            lg8Var.z(this.b);
            this.w.add(this.h);
            vg8 vg8Var = new vg8(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.H2());
            this.i = vg8Var;
            vg8Var.C(this.b);
            this.w.add(this.i);
            mg8 mg8Var = new mg8(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.H2());
            this.j = mg8Var;
            mg8Var.z(this.b);
            if ("fashion".equals(this.a.G2()) || "local".equals(this.a.G2())) {
                this.w.add(this.j);
            }
            pg8 pg8Var = new pg8(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.H2());
            this.k = pg8Var;
            pg8Var.x(this.b);
            this.w.add(this.k);
            rg8 rg8Var = new rg8(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.H2());
            this.l = rg8Var;
            rg8Var.y(this.b);
            this.w.add(this.l);
            qg8 qg8Var = new qg8(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.H2());
            this.m = qg8Var;
            qg8Var.x(this.b);
            this.w.add(this.m);
            tg8 tg8Var = new tg8(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.H2());
            this.n = tg8Var;
            tg8Var.y(this.b);
            this.w.add(this.n);
            gg8 gg8Var = new gg8(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.H2());
            this.o = gg8Var;
            gg8Var.A(this.b);
            this.w.add(this.o);
            fg8 fg8Var = new fg8(this.a.getPageContext(), mm6.S0, this.a.H2());
            this.r = fg8Var;
            this.w.add(fg8Var);
            eg8 eg8Var = new eg8(this.a.getPageContext(), wy4.e);
            this.p = eg8Var;
            eg8Var.y(this.b);
            this.w.add(this.p);
            dg8 dg8Var = new dg8(this.a.getPageContext(), bx4.b);
            this.q = dg8Var;
            dg8Var.B(this.b);
            this.w.add(this.q);
            og8 og8Var = new og8(this.a.getPageContext());
            this.s = og8Var;
            og8Var.x(this.b);
            this.w.add(this.s);
            sg8 sg8Var = new sg8(this.a.getPageContext());
            this.t = sg8Var;
            sg8Var.x(this.b);
            this.w.add(this.t);
            hg8 hg8Var = new hg8(this.a.getPageContext(), b());
            this.u = hg8Var;
            this.w.add(hg8Var);
            wg8 wg8Var = new wg8(this.a.getPageContext());
            this.v = wg8Var;
            this.w.add(wg8Var);
            this.b.addAdapters(this.w);
        }
    }
}
