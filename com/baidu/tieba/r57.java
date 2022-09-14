package com.baidu.tieba;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.dz;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.lx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class r57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.RecyclerListener A;
    public RecyclerView.OnScrollListener B;
    public BaseFragment a;
    public TbPageContext b;
    public View c;
    public BdTypeRecyclerView d;
    public BigdaySwipeRefreshLayout e;
    public u17 f;
    public k27 g;
    public t85 h;
    public PbListView i;
    public s85 j;
    public h57 k;
    public View l;
    public FrameLayout m;
    public ca8 n;
    public NEGFeedBackView.b o;
    public rx6 p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public BdUniqueId v;
    public lx4.h w;
    public lx4.f x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a implements lx4.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r57 a;

        public a(r57 r57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r57Var;
        }

        @Override // com.baidu.tieba.lx4.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.Y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lx4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r57 a;

        public b(r57 r57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r57Var;
        }

        @Override // com.baidu.tieba.lx4.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.N(true);
                if (this.a.n == null || this.a.s || !this.a.t) {
                    return;
                }
                this.a.n.n(this.a.q, this.a.r, this.a.u, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r57 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.k.c();
                    this.a.a.A();
                    if (this.a.a.s || !this.a.a.t) {
                        return;
                    }
                    this.a.a.n.n(this.a.a.q, this.a.a.r, this.a.a.u, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(r57 r57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var, Integer.valueOf(i)};
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
            this.a = r57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                gh.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(r57 r57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var, Integer.valueOf(i)};
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
            this.a = r57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder q;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (q = this.a.q()) == null || q.a() == null) {
                    return;
                }
                q.a().o(new dz.a(3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r57 a;

        public e(r57 r57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r57Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.n != null) {
                this.a.n.k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).a().stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ r57 b;

        public f(r57 r57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r57Var;
            this.a = -1;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.q = i;
                this.b.r = (i + i2) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (i == 0 && this.b.n != null && this.b.t) {
                    this.b.n.m(this.b.q, this.b.r, this.b.u, 1);
                }
                if (this.a == i) {
                    return;
                }
                this.a = i;
                if (i == 1) {
                    this.b.P(true);
                } else {
                    this.b.a0();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView instanceof BdRecyclerView) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                } else {
                    i3 = 0;
                }
                a(i4, (i3 - i4) + 1);
                if (this.b.p != null) {
                    this.b.p.j();
                }
            }
        }
    }

    public r57(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = true;
        this.u = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this, 2921420);
        this.z = new d(this, 2921381);
        this.A = new e(this);
        this.B = new f(this);
        this.a = baseFragment;
        this.b = tbPageContext;
        this.v = bdUniqueId;
        this.o = bVar;
        x();
    }

    public void A() {
        rx6 rx6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (rx6Var = this.p) == null) {
            return;
        }
        rx6Var.f();
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
            ca8 ca8Var = this.n;
            if (ca8Var == null) {
                return;
            }
            ca8Var.r(!z);
            ThreadCardViewHolder q = q();
            boolean z2 = false;
            if (q != null && q.a() != null) {
                z2 = q.a().o(new dz.a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.n.x();
            } else if (this.t) {
                this.n.n(this.q, this.r, this.u, true);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            s85 s85Var = this.j;
            if (s85Var != null) {
                s85Var.n();
            }
            Z(null);
            u17 u17Var = this.f;
            if (u17Var != null) {
                u17Var.Z();
            }
            h57 h57Var = this.k;
            if (h57Var != null) {
                h57Var.d();
            }
            ca8 ca8Var = this.n;
            if (ca8Var != null) {
                ca8Var.h();
            }
            p();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public void D() {
        h57 h57Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (h57Var = this.k) == null) {
            return;
        }
        h57Var.e();
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            B(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            B(false);
        }
    }

    public void G() {
        ca8 ca8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ca8Var = this.n) != null && this.t) {
            ca8Var.n(this.q, this.r, this.u, true);
        }
    }

    public final boolean H(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h57 h57Var = this.k;
            if (h57Var != null) {
                h57Var.c();
            }
            A();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.y.setTag(this.v);
            MessageManager.getInstance().registerListener(this.y);
            this.z.setTag(this.v);
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            List<Integer> t = t(str, this.d);
            int intValue = t.get(0).intValue();
            int intValue2 = t.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.d.E(intValue, intValue2);
        }
    }

    public void L(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            h57 h57Var = this.k;
            if (h57Var != null) {
                h57Var.f(list);
            }
            G();
        }
    }

    public void M(lx4.g gVar) {
        u17 u17Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) || (u17Var = this.f) == null) {
            return;
        }
        u17Var.f(gVar);
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.t = z;
        }
    }

    public void O(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.s = z;
        }
    }

    public void R(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) || (pbListView = this.i) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.i);
        }
        this.i.t(ej.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.i.D(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1559));
        this.i.C(onClickListener);
        this.i.f();
    }

    public void S() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (pbListView = this.i) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.i);
        }
        this.i.t(ej.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.i.D(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0a56));
        this.i.C(null);
        this.i.R();
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || y()) {
            return;
        }
        if (this.j == null) {
            s85 s85Var = new s85(this.b.getPageActivity());
            this.j = s85Var;
            s85Var.onChangeSkinType();
        }
        this.j.attachView(this.c, false);
    }

    public void U(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            if (this.h == null) {
                this.h = new t85(this.b.getPageActivity(), onClickListener);
            }
            this.h.p();
            this.h.m(null);
            this.h.n(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0fd9));
            this.h.i(R.drawable.new_pic_emotion_08);
            this.h.l(0);
            this.h.attachView(this.m, false);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.h == null) {
                this.h = new t85(this.b.getPageActivity(), null);
            }
            this.h.e();
            this.h.i(R.drawable.new_pic_emotion_03);
            this.h.o(this.b.getString(R.string.obfuscated_res_0x7f0f0c72));
            this.h.attachView(this.m, false);
        }
    }

    public void W() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (pbListView = this.i) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.d.setNextPage(this.i);
        }
        this.i.t(ej.f(this.b.getPageActivity(), R.dimen.tbds178));
        this.i.D(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f155c));
        this.i.C(null);
        this.i.f();
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.e.setRefreshing(true);
        }
    }

    public void Y() {
        ca8 ca8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (ca8Var = this.n) == null) {
            return;
        }
        ca8Var.x();
    }

    public void Z(lx4.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVar) == null) {
            this.e.z(iVar);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (H(this.d)) {
                P(false);
            } else {
                P(true);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            s85 s85Var = this.j;
            if (s85Var != null) {
                s85Var.r(TbadkCoreApplication.getInst().getSkinType());
                this.j.onChangeSkinType();
            }
            t85 t85Var = this.h;
            if (t85Var != null) {
                t85Var.onChangeSkinType();
            }
            u17 u17Var = this.f;
            if (u17Var != null) {
                u17Var.H(skinType);
            }
            h57 h57Var = this.k;
            if (h57Var != null) {
                h57Var.c();
            }
            A();
            rx6 rx6Var = this.p;
            if (rx6Var != null) {
                rx6Var.n();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            L(new LinkedList());
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.B);
                this.d.setRecyclerListener(null);
            }
            u17 u17Var = this.f;
            if (u17Var != null) {
                u17Var.g(null);
                this.f.m(null);
            }
        }
    }

    public final ThreadCardViewHolder q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ca8 ca8Var = this.n;
            if (ca8Var == null || ca8Var.j() == null || !(this.n.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.n.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<Cdo> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            h57 h57Var = this.k;
            if (h57Var != null) {
                return h57Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final List<Integer> t(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                Cdo B = bdTypeRecyclerView.B(i3);
                if (B instanceof c26) {
                    c26 c26Var = (c26) B;
                    if (c26Var.getThreadData() != null && c26Var.getThreadData().getTid().equals(str)) {
                        if (!z) {
                            i = i3;
                        }
                        z = true;
                        i2 = i3;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void u() {
        s85 s85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (s85Var = this.j) == null) {
            return;
        }
        s85Var.dettachView(this.c);
    }

    public void v() {
        t85 t85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (t85Var = this.h) == null) {
            return;
        }
        t85Var.dettachView(this.m);
        this.h = null;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.addOnScrollListener(this.B);
            this.d.setRecyclerListener(this.A);
            this.f.g(this.w);
            this.f.m(this.x);
            this.f.b0(this.b.getUniqueId());
            J();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08e2, (ViewGroup) null);
            this.c = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092571);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092574);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.b.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.d.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.p = new rx6(this.m, this.d);
            if (this.a.getArguments() != null) {
                this.p.p(this.a.getArguments().getString("tab_name"));
            }
            this.p.o(this.b);
            ca8 ca8Var = new ca8(this.b, this.d);
            this.n = ca8Var;
            ca8Var.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.n.u(this.v);
            this.e = (BigdaySwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092575);
            u17 u17Var = new u17(this.b);
            this.f = u17Var;
            this.e.setProgressView(u17Var);
            int i = (int) (this.b.getResources().getDisplayMetrics().density * 86.0f);
            this.e.setCustomDistances(i, i, i * 2);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.i = pbListView;
            pbListView.a();
            this.i.p(R.color.transparent);
            this.i.t(ej.f(this.b.getPageActivity(), R.dimen.tbds178));
            this.i.y();
            this.i.H(R.dimen.tbfontsize36);
            this.i.F(SkinManager.getColor(R.color.CAM_X0109));
            this.i.B(R.color.CAM_X0110);
            this.i.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            h57 h57Var = new h57(this.b, this.d);
            this.k = h57Var;
            h57Var.g(this.o);
            this.k.h(this.v);
            k27 k27Var = new k27();
            this.g = k27Var;
            k27Var.a(this.v);
            this.k.i(this.g);
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f09256e);
            n();
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            s85 s85Var = this.j;
            if (s85Var == null) {
                return false;
            }
            return s85Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void z() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
    }
}
