package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaFriendRoomAdapter;
import com.baidu.tieba.homepage.personalize.adapter.HomePageAlaLiveThreadAdapter;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class td7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ld7 A;
    public nd7 B;
    public kd7 C;
    public dd7 D;
    public gd7 E;
    public hd7 F;
    public jd7 G;
    public sc7 H;
    public qd7 I;
    public d97 J;
    public e97 K;
    public qc7 L;
    public qn M;
    public qn N;
    public qn O;
    public qn P;
    public qn Q;
    public qn R;
    public qn S;
    public List<qn> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<qn> a;
    public CustomMessageListener a0;
    public jo b;
    public List<Cdo> c;
    public TbPageContext<?> d;
    public pc7 e;
    public rd7 f;
    public rc7 g;
    public dd7 h;
    public od7 i;
    public xc7 j;
    public yc7 k;
    public zc7 l;
    public id7 m;
    public ad7 n;
    public fd7 o;
    public cd7 p;
    public ed7 q;
    public wc7 r;
    public vc7 s;
    public uc7 t;
    public pd7 u;
    public tc7 v;
    public bd7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public md7 z;

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ td7 b;

        public a(td7 td7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = td7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setData(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(td7 td7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    td7 td7Var = this.a;
                    td7Var.y(td7Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(td7 td7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.g(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(td7 td7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                bw7 bw7Var = new bw7();
                bw7Var.a = String.valueOf(customResponsedMessage.getData());
                bw7Var.b = true;
                this.a.g(bw7Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(td7 td7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                bw7 bw7Var = new bw7();
                bw7Var.a = String.valueOf(customResponsedMessage.getData());
                bw7Var.b = false;
                this.a.g(bw7Var);
            }
        }
    }

    public td7(Context context, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, joVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.X = new b(this, 2016470);
        this.Y = new c(this, 2001115);
        this.Z = new d(this, 2001335);
        this.a0 = new e(this, 2001336);
        this.a = new ArrayList();
        this.b = joVar;
        this.d = (TbPageContext) da.a(context);
        j(context);
        x(joVar);
        joVar.a(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof mw5) {
                ((mw5) qnVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (qn qnVar : this.a) {
                if (qnVar instanceof t77) {
                    ((t77) qnVar).s(aVar);
                }
            }
        }
    }

    public void u(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public void y(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            j19.f(list, 2);
            this.b.setData(list);
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.V = f();
        }
    }

    public List<Cdo> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void l() {
        jo joVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (joVar = this.b) != null) {
            joVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        pd7 pd7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pd7Var = this.u) != null) {
            pd7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pd7 pd7Var = this.u;
            if (pd7Var != null) {
                pd7Var.onResume();
            }
            if (!UbsABTestHelper.isFeedVideoImmersionTransition()) {
                l();
            }
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<qn> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = j19.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ev7 b2 = jw7.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                dd7 dd7Var = this.h;
                if (dd7Var != null && (bdUniqueId = dd7Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.T.add(b2);
            }
            this.b.a(this.T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<Cdo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (Cdo cdo : list) {
                if ((cdo instanceof ICardInfo) && ((ICardInfo) cdo).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                l();
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            dd7 dd7Var = this.h;
            if (dd7Var != null) {
                dd7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            zc7 zc7Var = this.l;
            if (zc7Var != null) {
                zc7Var.setFromCDN(z);
            }
            tc7 tc7Var = this.v;
            if (tc7Var != null) {
                tc7Var.setFromCDN(z);
            }
            qn qnVar = this.N;
            if (qnVar != null && (qnVar instanceof ms8)) {
                ((ms8) qnVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new pc7(this.d);
            this.f = new rd7(this.d);
            this.g = new rc7(this.d, be7.b);
            this.h = new dd7(this.d, ae6.i0);
            this.i = new od7(this.d, ae6.B0);
            this.j = new xc7(this.d, ae6.J0);
            this.k = new yc7(this.d, ae6.C0);
            this.l = new zc7(this.d, ae6.K0);
            this.m = new id7(this.d, ae6.I0);
            this.n = new ad7(this.d, ae6.L0);
            this.o = new fd7(this.d, ae6.M0);
            this.p = new cd7(this.d, ae6.N0);
            this.q = new ed7(this.d, ae6.O0);
            this.r = new wc7(this.d, ae6.D0);
            this.s = new vc7(this.d, ae6.E0);
            this.t = new uc7(this.d, ae6.F0);
            this.u = new pd7(this.d, be6.U);
            this.w = new bd7(this.d, ae6.r0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, zd6.P0);
            this.I = new qd7(this.d, ae6.H0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, zd6.Q0);
            this.z = new md7(this.d, ae6.s0);
            this.A = new ld7(this.d, ae6.t0);
            this.B = new nd7(this.d, ae6.v0);
            this.C = new kd7(this.d, ae6.u0);
            this.D = new dd7(this.d, ae6.j0);
            this.E = new gd7(this.d, ae6.w0);
            this.F = new hd7(this.d, ae6.x0);
            this.G = new jd7(this.d, bh7.d0);
            this.H = new sc7(this.d, vd6.P0);
            this.v = new tc7(this.d, ae6.G0);
            this.J = new d97(this.d, ae6.y0, (byte) 3);
            this.K = new e97(this.d, ae6.z0, (byte) 3);
            this.L = new qc7(this.d, sx5.g);
            this.a.add(this.e);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            this.a.add(this.n);
            this.a.add(this.o);
            this.a.add(this.p);
            this.a.add(this.q);
            this.a.add(this.r);
            this.a.add(this.s);
            this.a.add(this.t);
            this.a.add(this.u);
            this.a.add(this.w);
            this.a.add(this.D);
            this.a.add(new ReadProgessDelegetAdapter(this.d, me7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new sd7(this.d, de7.e));
            this.a.add(this.E);
            this.a.add(this.F);
            this.a.add(this.G);
            this.a.add(this.H);
            this.a.add(this.v);
            this.a.add(this.J);
            this.a.add(this.K);
            this.a.add(this.I);
            this.a.add(this.L);
            e();
            k();
            q("page_recommend");
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!ThreadData.isRecAppLoaded.get()) {
                AdvertAppInfo.v.set(false);
                return;
            }
            this.M = qs8.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = qs8.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = qs8.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = qs8.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = qs8.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = qs8.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = qs8.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(f67.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(f67.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            dd7 dd7Var = this.h;
            if (dd7Var != null) {
                dd7Var.B(bVar);
            }
            id7 id7Var = this.m;
            if (id7Var != null) {
                id7Var.A(bVar);
            }
            yc7 yc7Var = this.k;
            if (yc7Var != null) {
                yc7Var.y(bVar);
            }
            bd7 bd7Var = this.w;
            if (bd7Var != null) {
                bd7Var.x(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.x(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.x(bVar);
            }
            md7 md7Var = this.z;
            if (md7Var != null) {
                md7Var.x(bVar);
            }
            ld7 ld7Var = this.A;
            if (ld7Var != null) {
                ld7Var.C(bVar);
            }
            kd7 kd7Var = this.C;
            if (kd7Var != null) {
                kd7Var.z(bVar);
            }
            nd7 nd7Var = this.B;
            if (nd7Var != null) {
                nd7Var.A(bVar);
            }
            dd7 dd7Var2 = this.D;
            if (dd7Var2 != null) {
                dd7Var2.B(bVar);
            }
            gd7 gd7Var = this.E;
            if (gd7Var != null) {
                gd7Var.A(bVar);
            }
            hd7 hd7Var = this.F;
            if (hd7Var != null) {
                hd7Var.z(bVar);
            }
            jd7 jd7Var = this.G;
            if (jd7Var != null) {
                jd7Var.v(bVar);
            }
            sc7 sc7Var = this.H;
            if (sc7Var != null) {
                sc7Var.z(bVar);
            }
        }
    }

    public final void x(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, joVar) == null) {
            this.i.C(joVar);
            this.j.A(joVar);
            this.k.z(joVar);
            this.l.A(joVar);
            this.m.C(joVar);
            this.n.u(joVar);
            this.o.v(joVar);
            this.p.u(joVar);
            this.q.A(joVar);
            this.r.A(joVar);
            this.s.A(joVar);
            this.t.A(joVar);
            this.v.B(joVar);
            this.u.D(joVar);
            this.H.A(joVar);
            this.A.D(joVar);
            this.A.D(joVar);
            this.C.A(joVar);
            this.J.u(joVar);
            this.K.u(joVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            rc7 rc7Var = this.g;
            if (rc7Var != null) {
                rc7Var.u(bdUniqueId);
            }
            dd7 dd7Var = this.h;
            if (dd7Var != null) {
                dd7Var.b = bdUniqueId;
            }
            od7 od7Var = this.i;
            if (od7Var != null) {
                od7Var.b = bdUniqueId;
            }
            xc7 xc7Var = this.j;
            if (xc7Var != null) {
                xc7Var.a = bdUniqueId;
            }
            yc7 yc7Var = this.k;
            if (yc7Var != null) {
                yc7Var.a = bdUniqueId;
            }
            zc7 zc7Var = this.l;
            if (zc7Var != null) {
                zc7Var.a = bdUniqueId;
            }
            id7 id7Var = this.m;
            if (id7Var != null) {
                id7Var.a = bdUniqueId;
            }
            ad7 ad7Var = this.n;
            if (ad7Var != null) {
                ad7Var.a = bdUniqueId;
            }
            fd7 fd7Var = this.o;
            if (fd7Var != null) {
                fd7Var.a = bdUniqueId;
            }
            cd7 cd7Var = this.p;
            if (cd7Var != null) {
                cd7Var.a = bdUniqueId;
            }
            ed7 ed7Var = this.q;
            if (ed7Var != null) {
                ed7Var.a = bdUniqueId;
            }
            wc7 wc7Var = this.r;
            if (wc7Var != null) {
                wc7Var.a = bdUniqueId;
            }
            vc7 vc7Var = this.s;
            if (vc7Var != null) {
                vc7Var.a = bdUniqueId;
            }
            uc7 uc7Var = this.t;
            if (uc7Var != null) {
                uc7Var.a = bdUniqueId;
            }
            bd7 bd7Var = this.w;
            if (bd7Var != null) {
                bd7Var.b = bdUniqueId;
            }
            pd7 pd7Var = this.u;
            if (pd7Var != null) {
                pd7Var.a = bdUniqueId;
            }
            pc7 pc7Var = this.e;
            if (pc7Var != null) {
                pc7Var.v(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            qd7 qd7Var = this.I;
            if (qd7Var != null) {
                qd7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            md7 md7Var = this.z;
            if (md7Var != null) {
                md7Var.b = bdUniqueId;
            }
            ld7 ld7Var = this.A;
            if (ld7Var != null) {
                ld7Var.b = bdUniqueId;
            }
            kd7 kd7Var = this.C;
            if (kd7Var != null) {
                kd7Var.b = bdUniqueId;
            }
            nd7 nd7Var = this.B;
            if (nd7Var != null) {
                nd7Var.b = bdUniqueId;
            }
            dd7 dd7Var2 = this.D;
            if (dd7Var2 != null) {
                dd7Var2.b = bdUniqueId;
            }
            gd7 gd7Var = this.E;
            if (gd7Var != null) {
                gd7Var.a = bdUniqueId;
            }
            hd7 hd7Var = this.F;
            if (hd7Var != null) {
                hd7Var.a = bdUniqueId;
            }
            jd7 jd7Var = this.G;
            if (jd7Var != null) {
                jd7Var.a = bdUniqueId;
            }
            sc7 sc7Var = this.H;
            if (sc7Var != null) {
                sc7Var.b = bdUniqueId;
            }
            tc7 tc7Var = this.v;
            if (tc7Var != null) {
                tc7Var.a = bdUniqueId;
            }
            d97 d97Var = this.J;
            if (d97Var != null) {
                d97Var.b = bdUniqueId;
            }
            e97 e97Var = this.K;
            if (e97Var != null) {
                e97Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (qn qnVar : this.T) {
                    if (qnVar instanceof ev7) {
                        ((ev7) qnVar).setUniqueId(bdUniqueId);
                    }
                }
            }
            this.Y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Y);
            this.Z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
            this.a0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
            if (!this.V) {
                this.X.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.X);
            }
        }
    }

    public void w(je7 je7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, je7Var) == null) {
            this.h.C(je7Var);
            this.i.B(je7Var);
            this.j.z(je7Var);
            this.l.z(je7Var);
            this.m.B(je7Var);
            this.q.z(je7Var);
            this.r.z(je7Var);
            this.s.z(je7Var);
            this.t.z(je7Var);
            this.u.C(je7Var);
            this.v.A(je7Var);
        }
    }

    public void z(List<Cdo> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            j19.f(list, 2);
            ViewGroup listView = this.b.getListView();
            if (i > 0 && (listView instanceof BdRecyclerView)) {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) listView;
                int firstVisiblePosition = bdRecyclerView.getFirstVisiblePosition();
                int i2 = 0;
                View childAt = bdRecyclerView.getChildAt(0);
                if (childAt != null) {
                    i2 = childAt.getTop();
                }
                RecyclerView.LayoutManager layoutManager = bdRecyclerView.getLayoutManager();
                int i3 = firstVisiblePosition - i;
                if (layoutManager instanceof LinearLayoutManager) {
                    bdRecyclerView.B();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.C();
                }
            }
            kh.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
