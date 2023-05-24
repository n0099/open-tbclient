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
public class iw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HomePageTabFeedFragment a;
    public BdTypeRecyclerView b;
    public ex7 c;
    public xw7 d;
    public sw7 e;
    public uw7 f;
    public tw7 g;
    public vw7 h;
    public fx7 i;
    public ww7 j;
    public zw7 k;
    public bx7 l;
    public ax7 m;
    public dx7 n;
    public qw7 o;
    public ow7 p;
    public nw7 q;
    public pw7 r;
    public yw7 s;
    public cx7 t;
    public rw7 u;
    public gx7 v;
    public List<en> w;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iw7 a;

        public a(iw7 iw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TbSingleton.getInstance().setShouldShowHomeLocalCompleteInfoCard(false);
                if (this.a.b.getCount() != 0 && (this.a.b.getItem(0) instanceof hx7)) {
                    this.a.b.removeItem(0);
                }
            }
        }
    }

    public iw7(HomePageTabFeedFragment homePageTabFeedFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void e(ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b.setData(arrayList);
        }
    }

    public void f(boolean z) {
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && (gx7Var = this.v) != null) {
            gx7Var.u(z);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            for (en enVar : this.w) {
                if (enVar instanceof kw7) {
                    ((kw7) enVar).h(str);
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
            ex7 ex7Var = new ex7(this.a.getPageContext(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId(), this.a.T1(), this.a.S1());
            this.c = ex7Var;
            ex7Var.y(this.b);
            this.w.add(this.c);
            xw7 xw7Var = new xw7(this.a.getPageContext());
            this.d = xw7Var;
            xw7Var.x(this.b);
            this.w.add(this.d);
            sw7 sw7Var = new sw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, this.a.getUniqueId(), this.a.T1());
            this.e = sw7Var;
            sw7Var.z(this.b);
            this.w.add(this.e);
            uw7 uw7Var = new uw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId(), this.a.T1());
            this.f = uw7Var;
            uw7Var.y(this.b);
            this.w.add(this.f);
            tw7 tw7Var = new tw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId(), this.a.T1());
            this.g = tw7Var;
            tw7Var.y(this.b);
            this.w.add(this.g);
            vw7 vw7Var = new vw7(this.a.getPageContext(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId(), this.a.T1());
            this.h = vw7Var;
            vw7Var.y(this.b);
            this.w.add(this.h);
            fx7 fx7Var = new fx7(this.a.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId(), this.a.T1());
            this.i = fx7Var;
            fx7Var.B(this.b);
            this.w.add(this.i);
            ww7 ww7Var = new ww7(this.a.getPageContext(), ThreadData.TYPE_ENTER_FORUM, this.a.getUniqueId(), this.a.T1());
            this.j = ww7Var;
            ww7Var.y(this.b);
            if ("fashion".equals(this.a.S1()) || "local".equals(this.a.S1())) {
                this.w.add(this.j);
            }
            zw7 zw7Var = new zw7(this.a.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId(), this.a.T1());
            this.k = zw7Var;
            zw7Var.u(this.b);
            this.w.add(this.k);
            bx7 bx7Var = new bx7(this.a.getPageContext(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId(), this.a.T1());
            this.l = bx7Var;
            bx7Var.x(this.b);
            this.w.add(this.l);
            ax7 ax7Var = new ax7(this.a.getPageContext(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId(), this.a.T1());
            this.m = ax7Var;
            ax7Var.u(this.b);
            this.w.add(this.m);
            dx7 dx7Var = new dx7(this.a.getPageContext(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId(), this.a.T1());
            this.n = dx7Var;
            dx7Var.x(this.b);
            this.w.add(this.n);
            qw7 qw7Var = new qw7(this.a.getPageContext(), ThreadData.TYPE_ARTICLE, this.a.getUniqueId(), this.a.T1());
            this.o = qw7Var;
            qw7Var.z(this.b);
            this.w.add(this.o);
            pw7 pw7Var = new pw7(this.a.getPageContext(), kk6.Q0, this.a.T1());
            this.r = pw7Var;
            this.w.add(pw7Var);
            ow7 ow7Var = new ow7(this.a.getPageContext(), d15.e);
            this.p = ow7Var;
            ow7Var.x(this.b);
            this.w.add(this.p);
            nw7 nw7Var = new nw7(this.a.getPageContext(), iz4.b);
            this.q = nw7Var;
            nw7Var.A(this.b);
            this.w.add(this.q);
            yw7 yw7Var = new yw7(this.a.getPageContext());
            this.s = yw7Var;
            yw7Var.u(this.b);
            this.w.add(this.s);
            cx7 cx7Var = new cx7(this.a.getPageContext());
            this.t = cx7Var;
            cx7Var.u(this.b);
            this.w.add(this.t);
            rw7 rw7Var = new rw7(this.a.getPageContext(), b());
            this.u = rw7Var;
            this.w.add(rw7Var);
            gx7 gx7Var = new gx7(this.a.getPageContext());
            this.v = gx7Var;
            this.w.add(gx7Var);
            this.b.addAdapters(this.w);
        }
    }
}
