package com.baidu.tieba.lego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.p0.s.f0.f;
import d.a.q0.n1.h;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.n1.p.e f18177e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.s.f0.g f18178f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f18179g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f18180h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.n1.n.a f18181i;
    public TbPageContext<?> j;
    public d.a.q0.n1.c k;
    public h l;
    public d.a.p0.f0.g m;
    public d.a.p0.f0.h n;
    public long o;
    public String p;
    public boolean q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public h.c u;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18182a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoHotPageView legoHotPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18182a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12866a) {
                return;
            }
            this.f18182a.p(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18183a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LegoHotPageView legoHotPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18183a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.q0.n1.p.b bVar = new d.a.q0.n1.p.b();
                bVar.f61264a = String.valueOf(customResponsedMessage.getData());
                bVar.f61265b = true;
                this.f18183a.p(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18184a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoHotPageView legoHotPageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18184a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.q0.n1.p.b bVar = new d.a.q0.n1.p.b();
                bVar.f61264a = String.valueOf(customResponsedMessage.getData());
                bVar.f61265b = false;
                this.f18184a.p(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18185a;

        public d(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18185a = legoHotPageView;
        }

        @Override // d.a.q0.n1.h.c
        public void a(List<d.a.q0.n1.p.d> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || this.f18185a.k == null) {
                return;
            }
            this.f18185a.k.a(list);
        }

        @Override // d.a.q0.n1.h.c
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) == null) {
                boolean t = this.f18185a.t();
                this.f18185a.r();
                if (t) {
                    LegoHotPageView legoHotPageView = this.f18185a;
                    legoHotPageView.x(true, legoHotPageView.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (this.f18185a.k != null) {
                    this.f18185a.k.c(j, str);
                }
            }
        }

        @Override // d.a.q0.n1.h.c
        public void c(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) || this.f18185a.k == null || this.f18185a.f18177e == null) {
                return;
            }
            this.f18185a.k.e(this.f18185a.f18177e.f61283a, this.f18185a.f18177e.f61284b, i2, str);
        }

        @Override // d.a.q0.n1.h.c
        public void d(String str, String str2, String str3, List<d.a.q0.n1.p.e> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) || this.f18185a.k == null) {
                return;
            }
            this.f18185a.k.d(str, str2, str3, list);
        }

        @Override // d.a.q0.n1.h.c
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.f18185a.q();
                if (i2 != 1) {
                    this.f18185a.f18180h.setVisibility(8);
                    LegoHotPageView legoHotPageView = this.f18185a;
                    legoHotPageView.y(legoHotPageView, str, true);
                } else if (j.z()) {
                    this.f18185a.j.showToast(str);
                }
            }
        }

        @Override // d.a.q0.n1.h.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f18185a.q();
                this.f18185a.r();
                this.f18185a.f18180h.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18186e;

        public e(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18186e = legoHotPageView;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f18186e.l.m(this.f18186e.o, this.f18186e.p);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18187e;

        public f(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18187e = legoHotPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f18187e.q) {
                if (this.f18187e.f18179g != null) {
                    this.f18187e.f18179g.O();
                }
                this.f18187e.l.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f18188e;

        public g(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18188e = legoHotPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18188e.l == null) {
                return;
            }
            if (this.f18188e.f18177e != null) {
                this.f18188e.l.m(this.f18188e.f18177e.f61283a, this.f18188e.f18177e.f61284b);
            } else {
                this.f18188e.l.m(this.f18188e.o, this.f18188e.p);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this, 2001115);
        this.s = new b(this, 2001335);
        this.t = new c(this, 2001336);
        this.u = new d(this);
        s(context);
    }

    private void setHasMore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            this.q = z;
            if (this.f18180h == null) {
                return;
            }
            if (this.f18179g.b().getParent() == null) {
                this.f18180h.setNextPage(this.f18179g);
            }
            if (this.q) {
                this.f18179g.A(getContext().getString(R.string.pb_load_more));
            } else {
                this.f18179g.A("");
            }
        }
    }

    public void A(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) {
            PbListView pbListView = this.f18179g;
            if (pbListView != null) {
                pbListView.f();
            }
            this.l.i(z, dataRes, 0, null);
            setHasMore(this.l.c());
        }
    }

    public void B(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            PbListView pbListView = this.f18179g;
            if (pbListView != null) {
                pbListView.f();
            }
            this.l.i(true, null, i2, str);
        }
    }

    public long getTagCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.q0.n1.p.e eVar = this.f18177e;
            if (eVar == null) {
                return 0L;
            }
            return eVar.f61283a;
        }
        return invokeV.longValue;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, absListView, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            v();
        }
    }

    public final void p(Object obj) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, obj) == null) || this.f18181i == null || (hVar = this.l) == null || hVar.b() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.l.b()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f18181i.notifyDataSetChanged();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.p0.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.dettachView(this);
                this.m = null;
            }
            d.a.q0.n1.c cVar = this.k;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public final void r() {
        d.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dettachView(this);
        this.n = null;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            d.a.d.a.f<?> a2 = d.a.d.a.j.a(context);
            a2.registerListener(this.r);
            a2.registerListener(this.s);
            a2.registerListener(this.t);
            if (a2 instanceof TbPageContext) {
                this.j = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f18180h = bdListView;
            bdListView.setDividerHeight(0);
            this.f18180h.setSelector(17170445);
            d.a.q0.n1.n.a aVar = new d.a.q0.n1.n.a(this.j);
            this.f18181i = aVar;
            this.f18180h.setAdapter((ListAdapter) aVar);
            PbListView pbListView = new PbListView(context);
            this.f18179g = pbListView;
            pbListView.a();
            this.f18179g.o(R.color.CAM_X0204);
            this.f18179g.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f18179g.d(TbadkCoreApplication.getInst().getSkinType());
            d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(this.j);
            this.f18178f = gVar;
            this.f18180h.setPullRefresh(gVar);
            this.f18178f.B(true);
            this.f18178f.a(new e(this));
            this.f18180h.setOnSrollToBottomListener(new f(this));
            this.f18180h.setOnScrollListener(this);
            h hVar = new h(this.f18180h, this.f18181i);
            this.l = hVar;
            hVar.l(this.u);
            addView(this.f18180h);
        }
    }

    public void setCallback(d.a.q0.n1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        d.a.p0.s.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || (gVar = this.f18178f) == null) {
            return;
        }
        gVar.a0(bdUniqueId);
    }

    public void setTagInfo(d.a.q0.n1.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f18177e = eVar;
        }
    }

    public void setViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            u(true);
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            u(false);
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.p0.f0.h hVar = this.n;
            return hVar != null && hVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || this.f18180h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18180h.getChildCount(); i2++) {
            View childAt = this.f18180h.getChildAt(i2);
            if (childAt instanceof d.a.q0.n1.o.l.e) {
                if (z) {
                    ((d.a.q0.n1.o.l.e) childAt).f();
                } else {
                    ((d.a.q0.n1.o.l.e) childAt).j();
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f18180h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18180h.getChildCount(); i2++) {
            View childAt = this.f18180h.getChildAt(i2);
            if (childAt instanceof d.a.q0.n1.o.l.e) {
                ((d.a.q0.n1.o.l.e) childAt).i();
            }
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            d.a.p0.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            d.a.p0.f0.h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            d.a.p0.s.f0.g gVar2 = this.f18178f;
            if (gVar2 != null) {
                gVar2.I(i2);
            }
            BdListView bdListView = this.f18180h;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204, i2);
            }
            PbListView pbListView = this.f18179g;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f18179g.d(i2);
            }
        }
    }

    public final void x(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.m == null) {
                if (i2 < 0) {
                    this.m = new d.a.p0.f0.g(getContext());
                } else {
                    this.m = new d.a.p0.f0.g(getContext(), i2);
                }
                this.m.onChangeSkinType();
            }
            this.m.attachView(this, z);
        }
    }

    public final void y(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view, str, z) == null) {
            if (this.n == null) {
                this.n = new d.a.p0.f0.h(getContext(), new g(this));
            }
            this.n.j(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.n.l(str);
            this.n.attachView(view, z);
            this.n.o();
        }
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048596, this, j, str) == null) {
            this.o = j;
            this.p = str;
            h hVar = this.l;
            if (hVar != null) {
                hVar.m(j, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = new a(this, 2001115);
        this.s = new b(this, 2001335);
        this.t = new c(this, 2001336);
        this.u = new d(this);
        s(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.r = new a(this, 2001115);
        this.s = new b(this, 2001335);
        this.t = new c(this, 2001336);
        this.u = new d(this);
        s(context);
    }
}
