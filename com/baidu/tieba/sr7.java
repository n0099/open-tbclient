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
public class sr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kr7 A;
    public mr7 B;
    public jr7 C;
    public cr7 D;
    public fr7 E;
    public gr7 F;
    public ir7 G;
    public rq7 H;
    public pr7 I;
    public cn7 J;
    public dn7 K;
    public pq7 L;
    public um M;
    public um N;
    public um O;
    public um P;
    public um Q;
    public um R;
    public um S;
    public List<um> T;
    public boolean U;
    public boolean V;
    public f W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;
    public List<um> a;
    public CustomMessageListener a0;
    public nn b;
    public List<hn> c;
    public TbPageContext<?> d;
    public oq7 e;
    public qr7 f;
    public qq7 g;
    public cr7 h;
    public nr7 i;
    public wq7 j;
    public xq7 k;
    public yq7 l;
    public hr7 m;
    public zq7 n;
    public er7 o;
    public br7 p;
    public dr7 q;
    public vq7 r;
    public uq7 s;
    public tq7 t;
    public or7 u;
    public sq7 v;
    public ar7 w;
    public HomePageAlaLiveThreadAdapter x;
    public HomePageAlaFriendRoomAdapter y;
    public lr7 z;

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
        public final /* synthetic */ sr7 b;

        public a(sr7 sr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sr7Var;
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
        public final /* synthetic */ sr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sr7 sr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr7Var, Integer.valueOf(i)};
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
            this.a = sr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.f();
                if (this.a.c != null) {
                    sr7 sr7Var = this.a;
                    sr7Var.y(sr7Var.c);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(sr7 sr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr7Var, Integer.valueOf(i)};
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
            this.a = sr7Var;
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
        public final /* synthetic */ sr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(sr7 sr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr7Var, Integer.valueOf(i)};
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
            this.a = sr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                bf8 bf8Var = new bf8();
                bf8Var.a = String.valueOf(customResponsedMessage.getData());
                bf8Var.b = true;
                this.a.g(bf8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(sr7 sr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr7Var, Integer.valueOf(i)};
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
            this.a = sr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                bf8 bf8Var = new bf8();
                bf8Var.a = String.valueOf(customResponsedMessage.getData());
                bf8Var.b = false;
                this.a.g(bf8Var);
            }
        }
    }

    public sr7(Context context, nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, nnVar};
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
        this.b = nnVar;
        this.d = (TbPageContext) g9.a(context);
        j(context);
        x(nnVar);
        nnVar.addAdapters(this.a);
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            l();
            this.e.s(i);
        }
    }

    public final void q(String str) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || (list = this.a) == null) {
            return;
        }
        for (um umVar : list) {
            if (umVar instanceof py5) {
                ((py5) umVar).g(str);
            }
        }
    }

    public void r(FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            for (um umVar : this.a) {
                if (umVar instanceof sl7) {
                    ((sl7) umVar).s(aVar);
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

    public void y(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            rk9.f(list, 2);
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

    public List<hn> h() {
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
        nn nnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (nnVar = this.b) != null) {
            nnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void o() {
        or7 or7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (or7Var = this.u) != null) {
            or7Var.onPause();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            or7 or7Var = this.u;
            if (or7Var != null) {
                or7Var.onResume();
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
            List<um> list = this.T;
            if (list != null && list.size() > 0) {
                return true;
            }
            this.T = new ArrayList();
            ArrayList<BdUniqueId> g = rk9.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                ee8 b2 = jf8.d().b(this.d, g.get(i), 2);
                if (this.U) {
                    b2.s(3);
                }
                cr7 cr7Var = this.h;
                if (cr7Var != null && (bdUniqueId = cr7Var.b) != null) {
                    b2.setUniqueId(bdUniqueId);
                }
                this.T.add(b2);
            }
            this.b.addAdapters(this.T);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void g(Object obj) {
        List<hn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && (list = this.c) != null) {
            boolean z = false;
            for (hn hnVar : list) {
                if ((hnVar instanceof ICardInfo) && ((ICardInfo) hnVar).responseAttention(obj)) {
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
            cr7 cr7Var = this.h;
            if (cr7Var != null) {
                cr7Var.setFromCDN(z);
                this.D.setFromCDN(z);
                this.w.setFromCDN(z);
                this.z.setFromCDN(z);
            }
            yq7 yq7Var = this.l;
            if (yq7Var != null) {
                yq7Var.setFromCDN(z);
            }
            sq7 sq7Var = this.v;
            if (sq7Var != null) {
                sq7Var.setFromCDN(z);
            }
            um umVar = this.N;
            if (umVar != null && (umVar instanceof ra9)) {
                ((ra9) umVar).setIsFromCDN(z);
            }
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.e = new oq7(this.d);
            this.f = new qr7(this.d);
            this.g = new qq7(this.d, zr7.b);
            this.h = new cr7(this.d, mh6.j0);
            this.i = new nr7(this.d, mh6.C0);
            this.j = new wq7(this.d, mh6.K0);
            this.k = new xq7(this.d, mh6.D0);
            this.l = new yq7(this.d, mh6.L0);
            this.m = new hr7(this.d, mh6.J0);
            this.n = new zq7(this.d, mh6.M0);
            this.o = new er7(this.d, mh6.N0);
            this.p = new br7(this.d, mh6.O0);
            this.q = new dr7(this.d, mh6.P0);
            this.r = new vq7(this.d, mh6.E0);
            this.s = new uq7(this.d, mh6.F0);
            this.t = new tq7(this.d, mh6.G0);
            this.u = new or7(this.d, nh6.U);
            this.w = new ar7(this.d, mh6.s0);
            this.x = new HomePageAlaLiveThreadAdapter(this.d, lh6.Q0);
            this.I = new pr7(this.d, mh6.I0);
            this.y = new HomePageAlaFriendRoomAdapter(this.d, lh6.R0);
            this.z = new lr7(this.d, mh6.t0);
            this.A = new kr7(this.d, mh6.u0);
            this.B = new mr7(this.d, mh6.w0);
            this.C = new jr7(this.d, mh6.v0);
            this.D = new cr7(this.d, mh6.r0);
            this.E = new fr7(this.d, mh6.x0);
            this.F = new gr7(this.d, mh6.y0);
            this.G = new ir7(this.d, bv7.d0);
            this.H = new rq7(this.d, hh6.Q0);
            this.v = new sq7(this.d, mh6.H0);
            this.J = new cn7(this.d, mh6.z0, (byte) 3);
            this.K = new dn7(this.d, mh6.A0, (byte) 3);
            this.L = new pq7(this.d, vz5.g);
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
            this.a.add(new ReadProgessDelegetAdapter(this.d, ks7.c));
            this.a.add(this.x);
            this.a.add(this.y);
            this.a.add(this.z);
            this.a.add(this.A);
            this.a.add(this.C);
            this.a.add(this.B);
            this.a.add(new rr7(this.d, bs7.e));
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
            this.M = va9.l().g(this.d, AdvertAppInfo.y, "INDEX");
            this.N = va9.l().g(this.d, AdvertAppInfo.z, "INDEX");
            this.O = va9.l().g(this.d, AdvertAppInfo.A, "INDEX");
            this.P = va9.l().g(this.d, AdvertAppInfo.B, "INDEX");
            this.Q = va9.l().g(this.d, AdvertAppInfo.C, "INDEX");
            this.R = va9.l().g(this.d, AdvertAppInfo.E, "INDEX");
            this.S = va9.l().g(this.d, AdvertAppInfo.D, "INDEX");
            this.a.add(this.M);
            this.a.add(this.N);
            this.a.add(this.O);
            this.a.add(this.P);
            this.a.add(this.Q);
            this.a.add(this.R);
            this.a.add(this.S);
            if (this.d.getPageActivity() instanceof BaseFragmentActivity) {
                this.a.add(ek7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.H));
                this.a.add(ek7.e().b((BaseFragmentActivity) this.d.getPageActivity(), AdvertAppInfo.G));
            }
            AdvertAppInfo.v.set(true);
        }
    }

    public void t(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            cr7 cr7Var = this.h;
            if (cr7Var != null) {
                cr7Var.D(bVar);
            }
            hr7 hr7Var = this.m;
            if (hr7Var != null) {
                hr7Var.C(bVar);
            }
            xq7 xq7Var = this.k;
            if (xq7Var != null) {
                xq7Var.A(bVar);
            }
            ar7 ar7Var = this.w;
            if (ar7Var != null) {
                ar7Var.z(bVar);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.z(bVar);
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.z(bVar);
            }
            lr7 lr7Var = this.z;
            if (lr7Var != null) {
                lr7Var.z(bVar);
            }
            kr7 kr7Var = this.A;
            if (kr7Var != null) {
                kr7Var.E(bVar);
            }
            jr7 jr7Var = this.C;
            if (jr7Var != null) {
                jr7Var.B(bVar);
            }
            mr7 mr7Var = this.B;
            if (mr7Var != null) {
                mr7Var.C(bVar);
            }
            cr7 cr7Var2 = this.D;
            if (cr7Var2 != null) {
                cr7Var2.D(bVar);
            }
            fr7 fr7Var = this.E;
            if (fr7Var != null) {
                fr7Var.C(bVar);
            }
            gr7 gr7Var = this.F;
            if (gr7Var != null) {
                gr7Var.B(bVar);
            }
            ir7 ir7Var = this.G;
            if (ir7Var != null) {
                ir7Var.x(bVar);
            }
            rq7 rq7Var = this.H;
            if (rq7Var != null) {
                rq7Var.B(bVar);
            }
        }
    }

    public final void x(nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nnVar) == null) {
            this.i.E(nnVar);
            this.j.C(nnVar);
            this.k.B(nnVar);
            this.l.C(nnVar);
            this.m.E(nnVar);
            this.n.u(nnVar);
            this.o.x(nnVar);
            this.p.u(nnVar);
            this.q.C(nnVar);
            this.r.C(nnVar);
            this.s.C(nnVar);
            this.t.C(nnVar);
            this.v.D(nnVar);
            this.u.F(nnVar);
            this.H.C(nnVar);
            this.A.F(nnVar);
            this.A.F(nnVar);
            this.C.C(nnVar);
            this.J.u(nnVar);
            this.K.u(nnVar);
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            qq7 qq7Var = this.g;
            if (qq7Var != null) {
                qq7Var.u(bdUniqueId);
            }
            cr7 cr7Var = this.h;
            if (cr7Var != null) {
                cr7Var.b = bdUniqueId;
            }
            nr7 nr7Var = this.i;
            if (nr7Var != null) {
                nr7Var.b = bdUniqueId;
            }
            wq7 wq7Var = this.j;
            if (wq7Var != null) {
                wq7Var.a = bdUniqueId;
            }
            xq7 xq7Var = this.k;
            if (xq7Var != null) {
                xq7Var.a = bdUniqueId;
            }
            yq7 yq7Var = this.l;
            if (yq7Var != null) {
                yq7Var.a = bdUniqueId;
            }
            hr7 hr7Var = this.m;
            if (hr7Var != null) {
                hr7Var.a = bdUniqueId;
            }
            zq7 zq7Var = this.n;
            if (zq7Var != null) {
                zq7Var.a = bdUniqueId;
            }
            er7 er7Var = this.o;
            if (er7Var != null) {
                er7Var.a = bdUniqueId;
            }
            br7 br7Var = this.p;
            if (br7Var != null) {
                br7Var.a = bdUniqueId;
            }
            dr7 dr7Var = this.q;
            if (dr7Var != null) {
                dr7Var.a = bdUniqueId;
            }
            vq7 vq7Var = this.r;
            if (vq7Var != null) {
                vq7Var.a = bdUniqueId;
            }
            uq7 uq7Var = this.s;
            if (uq7Var != null) {
                uq7Var.a = bdUniqueId;
            }
            tq7 tq7Var = this.t;
            if (tq7Var != null) {
                tq7Var.a = bdUniqueId;
            }
            ar7 ar7Var = this.w;
            if (ar7Var != null) {
                ar7Var.b = bdUniqueId;
            }
            or7 or7Var = this.u;
            if (or7Var != null) {
                or7Var.a = bdUniqueId;
            }
            oq7 oq7Var = this.e;
            if (oq7Var != null) {
                oq7Var.x(bdUniqueId);
            }
            HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter = this.x;
            if (homePageAlaLiveThreadAdapter != null) {
                homePageAlaLiveThreadAdapter.a = bdUniqueId;
            }
            pr7 pr7Var = this.I;
            if (pr7Var != null) {
                pr7Var.a = bdUniqueId;
            }
            HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter = this.y;
            if (homePageAlaFriendRoomAdapter != null) {
                homePageAlaFriendRoomAdapter.a = bdUniqueId;
            }
            lr7 lr7Var = this.z;
            if (lr7Var != null) {
                lr7Var.b = bdUniqueId;
            }
            kr7 kr7Var = this.A;
            if (kr7Var != null) {
                kr7Var.b = bdUniqueId;
            }
            jr7 jr7Var = this.C;
            if (jr7Var != null) {
                jr7Var.b = bdUniqueId;
            }
            mr7 mr7Var = this.B;
            if (mr7Var != null) {
                mr7Var.b = bdUniqueId;
            }
            cr7 cr7Var2 = this.D;
            if (cr7Var2 != null) {
                cr7Var2.b = bdUniqueId;
            }
            fr7 fr7Var = this.E;
            if (fr7Var != null) {
                fr7Var.a = bdUniqueId;
            }
            gr7 gr7Var = this.F;
            if (gr7Var != null) {
                gr7Var.a = bdUniqueId;
            }
            ir7 ir7Var = this.G;
            if (ir7Var != null) {
                ir7Var.a = bdUniqueId;
            }
            rq7 rq7Var = this.H;
            if (rq7Var != null) {
                rq7Var.b = bdUniqueId;
            }
            sq7 sq7Var = this.v;
            if (sq7Var != null) {
                sq7Var.a = bdUniqueId;
            }
            cn7 cn7Var = this.J;
            if (cn7Var != null) {
                cn7Var.b = bdUniqueId;
            }
            dn7 dn7Var = this.K;
            if (dn7Var != null) {
                dn7Var.b = bdUniqueId;
            }
            if (!ListUtils.isEmpty(this.T)) {
                for (um umVar : this.T) {
                    if (umVar instanceof ee8) {
                        ((ee8) umVar).setUniqueId(bdUniqueId);
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

    public void w(hs7 hs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hs7Var) == null) {
            this.h.E(hs7Var);
            this.i.D(hs7Var);
            this.j.B(hs7Var);
            this.l.B(hs7Var);
            this.m.D(hs7Var);
            this.q.B(hs7Var);
            this.r.B(hs7Var);
            this.s.B(hs7Var);
            this.t.B(hs7Var);
            this.u.E(hs7Var);
            this.v.C(hs7Var);
        }
    }

    public void z(List<hn> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i) == null) {
            rk9.f(list, 2);
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
                    bdRecyclerView.startInterceptLayout();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, i2);
                    bdRecyclerView.stopIntercerceptLayout();
                }
            }
            ng.e(new a(this, list));
            this.c = list;
            f fVar = this.W;
            if (fVar != null) {
                fVar.a();
            }
        }
    }
}
