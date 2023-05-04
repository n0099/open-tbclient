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
/* loaded from: classes6.dex */
public class tu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public pv7 c;
    public iv7 d;
    public dv7 e;
    public fv7 f;
    public ev7 g;
    public gv7 h;
    public qv7 i;
    public hv7 j;
    public kv7 k;
    public mv7 l;
    public lv7 m;
    public ov7 n;
    public bv7 o;
    public zu7 p;
    public yu7 q;
    public av7 r;
    public jv7 s;
    public nv7 t;
    public cv7 u;
    public rv7 v;
    public List<vm> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu7 a;

        public a(tu7 tu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tu7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof sv7)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public tu7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        rv7 rv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (rv7Var = this.v) != null) {
            rv7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (vm vmVar : this.w) {
                if (vmVar instanceof vu7) {
                    ((vu7) vmVar).h(str);
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
            pv7 pv7Var = new pv7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.S1(), this.a.R1());
            this.c = pv7Var;
            pv7Var.y(this.b);
            this.w.add(this.c);
            iv7 iv7Var = new iv7(this.a.getPageContext());
            this.d = iv7Var;
            iv7Var.x(this.b);
            this.w.add(this.d);
            dv7 dv7Var = new dv7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.S1());
            this.e = dv7Var;
            dv7Var.z(this.b);
            this.w.add(this.e);
            fv7 fv7Var = new fv7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.S1());
            this.f = fv7Var;
            fv7Var.y(this.b);
            this.w.add(this.f);
            ev7 ev7Var = new ev7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.S1());
            this.g = ev7Var;
            ev7Var.y(this.b);
            this.w.add(this.g);
            gv7 gv7Var = new gv7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.S1());
            this.h = gv7Var;
            gv7Var.y(this.b);
            this.w.add(this.h);
            qv7 qv7Var = new qv7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.S1());
            this.i = qv7Var;
            qv7Var.B(this.b);
            this.w.add(this.i);
            hv7 hv7Var = new hv7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.S1());
            this.j = hv7Var;
            hv7Var.y(this.b);
            if ("fashion".equals(this.a.R1()) || "local".equals(this.a.R1())) {
                this.w.add(this.j);
            }
            kv7 kv7Var = new kv7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.S1());
            this.k = kv7Var;
            kv7Var.u(this.b);
            this.w.add(this.k);
            mv7 mv7Var = new mv7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.S1());
            this.l = mv7Var;
            mv7Var.x(this.b);
            this.w.add(this.l);
            lv7 lv7Var = new lv7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.S1());
            this.m = lv7Var;
            lv7Var.u(this.b);
            this.w.add(this.m);
            ov7 ov7Var = new ov7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.S1());
            this.n = ov7Var;
            ov7Var.x(this.b);
            this.w.add(this.n);
            bv7 bv7Var = new bv7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.S1());
            this.o = bv7Var;
            bv7Var.z(this.b);
            this.w.add(this.o);
            av7 av7Var = new av7(this.a.getPageContext(), xi6.Q0, this.a.S1());
            this.r = av7Var;
            this.w.add(av7Var);
            zu7 zu7Var = new zu7(this.a.getPageContext(), uz4.e);
            this.p = zu7Var;
            zu7Var.x(this.b);
            this.w.add(this.p);
            yu7 yu7Var = new yu7(this.a.getPageContext(), zx4.b);
            this.q = yu7Var;
            yu7Var.A(this.b);
            this.w.add(this.q);
            jv7 jv7Var = new jv7(this.a.getPageContext());
            this.s = jv7Var;
            jv7Var.u(this.b);
            this.w.add(this.s);
            nv7 nv7Var = new nv7(this.a.getPageContext());
            this.t = nv7Var;
            nv7Var.u(this.b);
            this.w.add(this.t);
            cv7 cv7Var = new cv7(this.a.getPageContext(), b());
            this.u = cv7Var;
            this.w.add(cv7Var);
            rv7 rv7Var = new rv7(this.a.getPageContext());
            this.v = rv7Var;
            this.w.add(rv7Var);
            this.b.addAdapters(this.w);
        }
    }
}
