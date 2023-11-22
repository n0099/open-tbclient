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
public class zf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public vg8 c;
    public og8 d;
    public jg8 e;
    public lg8 f;
    public kg8 g;
    public mg8 h;
    public wg8 i;
    public ng8 j;
    public qg8 k;
    public sg8 l;
    public rg8 m;
    public ug8 n;
    public hg8 o;
    public fg8 p;
    public eg8 q;
    public gg8 r;
    public pg8 s;
    public tg8 t;
    public ig8 u;
    public xg8 v;
    public List<bi> w;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf8 a;

        public a(zf8 zf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof yg8)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public zf8(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        xg8 xg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (xg8Var = this.v) != null) {
            xg8Var.x(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (bi biVar : this.w) {
                if (biVar instanceof bg8) {
                    ((bg8) biVar).h(str);
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
            vg8 vg8Var = new vg8(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.H2(), this.a.G2());
            this.c = vg8Var;
            vg8Var.z(this.b);
            this.w.add(this.c);
            og8 og8Var = new og8(this.a.getPageContext());
            this.d = og8Var;
            og8Var.y(this.b);
            this.w.add(this.d);
            jg8 jg8Var = new jg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.H2());
            this.e = jg8Var;
            jg8Var.A(this.b);
            this.w.add(this.e);
            lg8 lg8Var = new lg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.H2());
            this.f = lg8Var;
            lg8Var.z(this.b);
            this.w.add(this.f);
            kg8 kg8Var = new kg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.H2());
            this.g = kg8Var;
            kg8Var.z(this.b);
            this.w.add(this.g);
            mg8 mg8Var = new mg8(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.H2());
            this.h = mg8Var;
            mg8Var.z(this.b);
            this.w.add(this.h);
            wg8 wg8Var = new wg8(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.H2());
            this.i = wg8Var;
            wg8Var.C(this.b);
            this.w.add(this.i);
            ng8 ng8Var = new ng8(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.H2());
            this.j = ng8Var;
            ng8Var.z(this.b);
            if ("fashion".equals(this.a.G2()) || "local".equals(this.a.G2())) {
                this.w.add(this.j);
            }
            qg8 qg8Var = new qg8(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.H2());
            this.k = qg8Var;
            qg8Var.x(this.b);
            this.w.add(this.k);
            sg8 sg8Var = new sg8(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.H2());
            this.l = sg8Var;
            sg8Var.y(this.b);
            this.w.add(this.l);
            rg8 rg8Var = new rg8(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.H2());
            this.m = rg8Var;
            rg8Var.x(this.b);
            this.w.add(this.m);
            ug8 ug8Var = new ug8(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.H2());
            this.n = ug8Var;
            ug8Var.y(this.b);
            this.w.add(this.n);
            hg8 hg8Var = new hg8(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.H2());
            this.o = hg8Var;
            hg8Var.A(this.b);
            this.w.add(this.o);
            gg8 gg8Var = new gg8(this.a.getPageContext(), nm6.S0, this.a.H2());
            this.r = gg8Var;
            this.w.add(gg8Var);
            fg8 fg8Var = new fg8(this.a.getPageContext(), wy4.e);
            this.p = fg8Var;
            fg8Var.y(this.b);
            this.w.add(this.p);
            eg8 eg8Var = new eg8(this.a.getPageContext(), bx4.b);
            this.q = eg8Var;
            eg8Var.B(this.b);
            this.w.add(this.q);
            pg8 pg8Var = new pg8(this.a.getPageContext());
            this.s = pg8Var;
            pg8Var.x(this.b);
            this.w.add(this.s);
            tg8 tg8Var = new tg8(this.a.getPageContext());
            this.t = tg8Var;
            tg8Var.x(this.b);
            this.w.add(this.t);
            ig8 ig8Var = new ig8(this.a.getPageContext(), b());
            this.u = ig8Var;
            this.w.add(ig8Var);
            xg8 xg8Var = new xg8(this.a.getPageContext());
            this.v = xg8Var;
            this.w.add(xg8Var);
            this.b.addAdapters(this.w);
        }
    }
}
