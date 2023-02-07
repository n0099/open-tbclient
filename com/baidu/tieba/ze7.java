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
public class ze7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public vf7 c;
    public of7 d;
    public jf7 e;
    public lf7 f;
    public kf7 g;
    public mf7 h;
    public wf7 i;
    public nf7 j;
    public qf7 k;
    public sf7 l;
    public rf7 m;
    public uf7 n;
    public hf7 o;
    public ff7 p;
    public ef7 q;
    public gf7 r;
    public pf7 s;
    public tf7 t;
    public if7 u;
    public xf7 v;
    public List<qn> w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze7 a;

        public a(ze7 ze7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.E(0) instanceof yf7)) {
                    this.a.b.G(0);
                }
            }
        }
    }

    public ze7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        xf7 xf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (xf7Var = this.v) != null) {
            xf7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (qn qnVar : this.w) {
                if (qnVar instanceof bf7) {
                    ((bf7) qnVar).h(str);
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
            vf7 vf7Var = new vf7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.P1(), this.a.O1());
            this.c = vf7Var;
            vf7Var.w(this.b);
            this.w.add(this.c);
            of7 of7Var = new of7(this.a.getPageContext());
            this.d = of7Var;
            of7Var.v(this.b);
            this.w.add(this.d);
            jf7 jf7Var = new jf7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.P1());
            this.e = jf7Var;
            jf7Var.x(this.b);
            this.w.add(this.e);
            lf7 lf7Var = new lf7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.f = lf7Var;
            lf7Var.w(this.b);
            this.w.add(this.f);
            kf7 kf7Var = new kf7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.P1());
            this.g = kf7Var;
            kf7Var.w(this.b);
            this.w.add(this.g);
            mf7 mf7Var = new mf7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.h = mf7Var;
            mf7Var.w(this.b);
            this.w.add(this.h);
            wf7 wf7Var = new wf7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.P1());
            this.i = wf7Var;
            wf7Var.z(this.b);
            this.w.add(this.i);
            nf7 nf7Var = new nf7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.P1());
            this.j = nf7Var;
            nf7Var.w(this.b);
            if ("fashion".equals(this.a.O1()) || "local".equals(this.a.O1())) {
                this.w.add(this.j);
            }
            qf7 qf7Var = new qf7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.P1());
            this.k = qf7Var;
            qf7Var.u(this.b);
            this.w.add(this.k);
            sf7 sf7Var = new sf7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.P1());
            this.l = sf7Var;
            sf7Var.v(this.b);
            this.w.add(this.l);
            rf7 rf7Var = new rf7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.P1());
            this.m = rf7Var;
            rf7Var.u(this.b);
            this.w.add(this.m);
            uf7 uf7Var = new uf7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.P1());
            this.n = uf7Var;
            uf7Var.v(this.b);
            this.w.add(this.n);
            hf7 hf7Var = new hf7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.P1());
            this.o = hf7Var;
            hf7Var.x(this.b);
            this.w.add(this.o);
            gf7 gf7Var = new gf7(this.a.getPageContext(), zd6.P0, this.a.P1());
            this.r = gf7Var;
            this.w.add(gf7Var);
            ff7 ff7Var = new ff7(this.a.getPageContext(), lz4.e);
            this.p = ff7Var;
            ff7Var.v(this.b);
            this.w.add(this.p);
            ef7 ef7Var = new ef7(this.a.getPageContext(), qx4.b);
            this.q = ef7Var;
            ef7Var.y(this.b);
            this.w.add(this.q);
            pf7 pf7Var = new pf7(this.a.getPageContext());
            this.s = pf7Var;
            pf7Var.u(this.b);
            this.w.add(this.s);
            tf7 tf7Var = new tf7(this.a.getPageContext());
            this.t = tf7Var;
            tf7Var.u(this.b);
            this.w.add(this.t);
            if7 if7Var = new if7(this.a.getPageContext(), b());
            this.u = if7Var;
            this.w.add(if7Var);
            xf7 xf7Var = new xf7(this.a.getPageContext());
            this.v = xf7Var;
            this.w.add(xf7Var);
            this.b.a(this.w);
        }
    }
}
