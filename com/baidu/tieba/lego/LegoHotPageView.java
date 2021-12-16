package com.baidu.tieba.lego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.f.p.k;
import c.a.r0.s.i0.f;
import c.a.s0.x1.h;
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
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes12.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.x1.p.e f46969e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.s.i0.g f46970f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f46971g;

    /* renamed from: h  reason: collision with root package name */
    public BdListView f46972h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.x1.n.a f46973i;

    /* renamed from: j  reason: collision with root package name */
    public TbPageContext<?> f46974j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.s0.x1.c f46975k;
    public h l;
    public c.a.r0.g0.g m;
    public c.a.r0.g0.h n;
    public long o;
    public String p;
    public boolean q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public CustomMessageListener t;
    public h.c u;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

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
            this.a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.p(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

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
            this.a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.s0.x1.p.b bVar = new c.a.s0.x1.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f25515b = true;
                this.a.p(bVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

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
            this.a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.s0.x1.p.b bVar = new c.a.s0.x1.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f25515b = false;
                this.a.p(bVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

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
            this.a = legoHotPageView;
        }

        @Override // c.a.s0.x1.h.c
        public void a(List<c.a.s0.x1.p.d> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || this.a.f46975k == null) {
                return;
            }
            this.a.f46975k.a(list);
        }

        @Override // c.a.s0.x1.h.c
        public void b(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, str) == null) {
                boolean t = this.a.t();
                this.a.r();
                if (t) {
                    LegoHotPageView legoHotPageView = this.a;
                    legoHotPageView.v(true, legoHotPageView.getResources().getDimensionPixelSize(R.dimen.ds360));
                }
                if (this.a.f46975k != null) {
                    this.a.f46975k.c(j2, str);
                }
            }
        }

        @Override // c.a.s0.x1.h.c
        public void c(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) || this.a.f46975k == null || this.a.f46969e == null) {
                return;
            }
            this.a.f46975k.e(this.a.f46969e.a, this.a.f46969e.f25533b, i2, str);
        }

        @Override // c.a.s0.x1.h.c
        public void d(String str, String str2, String str3, List<c.a.s0.x1.p.e> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) || this.a.f46975k == null) {
                return;
            }
            this.a.f46975k.d(str, str2, str3, list);
        }

        @Override // c.a.s0.x1.h.c
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) {
                this.a.q();
                if (i2 != 1) {
                    this.a.f46972h.setVisibility(8);
                    LegoHotPageView legoHotPageView = this.a;
                    legoHotPageView.w(legoHotPageView, str, true);
                } else if (k.z()) {
                    this.a.f46974j.showToast(str);
                }
            }
        }

        @Override // c.a.s0.x1.h.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.q();
                this.a.r();
                this.a.f46972h.setVisibility(0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f46976e;

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
            this.f46976e = legoHotPageView;
        }

        @Override // c.a.r0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f46976e.l.update(this.f46976e.o, this.f46976e.p);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f46977e;

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
            this.f46977e = legoHotPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f46977e.q) {
                if (this.f46977e.f46971g != null) {
                    this.f46977e.f46971g.R();
                }
                this.f46977e.l.g();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoHotPageView f46978e;

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
            this.f46978e = legoHotPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46978e.l == null) {
                return;
            }
            if (this.f46978e.f46969e != null) {
                this.f46978e.l.update(this.f46978e.f46969e.a, this.f46978e.f46969e.f25533b);
            } else {
                this.f46978e.l.update(this.f46978e.o, this.f46978e.p);
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
            if (this.f46972h == null) {
                return;
            }
            if (this.f46971g.b().getParent() == null) {
                this.f46972h.setNextPage(this.f46971g);
            }
            if (this.q) {
                this.f46971g.D(getContext().getString(R.string.pb_load_more));
            } else {
                this.f46971g.D("");
            }
        }
    }

    public long getTagCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.s0.x1.p.e eVar = this.f46969e;
            if (eVar == null) {
                return 0L;
            }
            return eVar.a;
        }
        return invokeV.longValue;
    }

    public void notifyListViewBackground(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f46972h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f46972h.getChildCount(); i2++) {
            View childAt = this.f46972h.getChildAt(i2);
            if (childAt instanceof c.a.s0.x1.o.l.e) {
                if (z) {
                    ((c.a.s0.x1.o.l.e) childAt).onViewBackground();
                } else {
                    ((c.a.s0.x1.o.l.e) childAt).onViewForeground();
                }
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c.a.r0.g0.g gVar = this.m;
            if (gVar != null) {
                gVar.onChangeSkinType();
            }
            c.a.r0.g0.h hVar = this.n;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            c.a.r0.s.i0.g gVar2 = this.f46970f;
            if (gVar2 != null) {
                gVar2.C(i2);
            }
            BdListView bdListView = this.f46972h;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204, i2);
            }
            PbListView pbListView = this.f46971g;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f46971g.d(i2);
            }
        }
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
            u();
        }
    }

    public final void p(Object obj) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, obj) == null) || this.f46973i == null || (hVar = this.l) == null || hVar.b() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.l.b()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f46973i.notifyDataSetChanged();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.r0.g0.g gVar = this.m;
            if (gVar != null) {
                gVar.dettachView(this);
                this.m = null;
            }
            c.a.s0.x1.c cVar = this.f46975k;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public final void r() {
        c.a.r0.g0.h hVar;
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
            c.a.d.a.f<?> a2 = j.a(context);
            a2.registerListener(this.r);
            a2.registerListener(this.s);
            a2.registerListener(this.t);
            if (a2 instanceof TbPageContext) {
                this.f46974j = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f46972h = bdListView;
            bdListView.setDividerHeight(0);
            this.f46972h.setSelector(17170445);
            c.a.s0.x1.n.a aVar = new c.a.s0.x1.n.a(this.f46974j);
            this.f46973i = aVar;
            this.f46972h.setAdapter((ListAdapter) aVar);
            PbListView pbListView = new PbListView(context);
            this.f46971g = pbListView;
            pbListView.a();
            this.f46971g.p(R.color.CAM_X0204);
            this.f46971g.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f46971g.d(TbadkCoreApplication.getInst().getSkinType());
            c.a.r0.s.i0.g gVar = new c.a.r0.s.i0.g(this.f46974j);
            this.f46970f = gVar;
            this.f46972h.setPullRefresh(gVar);
            this.f46970f.v(true);
            this.f46970f.a(new e(this));
            this.f46972h.setOnSrollToBottomListener(new f(this));
            this.f46972h.setOnScrollListener(this);
            h hVar = new h(this.f46972h, this.f46973i);
            this.l = hVar;
            hVar.l(this.u);
            addView(this.f46972h);
        }
    }

    public void setCallback(c.a.s0.x1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f46975k = cVar;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        c.a.r0.s.i0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || (gVar = this.f46970f) == null) {
            return;
        }
        gVar.V(bdUniqueId);
    }

    public void setTagInfo(c.a.s0.x1.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.f46969e = eVar;
        }
    }

    public void setViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            notifyListViewBackground(true);
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            notifyListViewBackground(false);
        }
    }

    public void startFirstLoad(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048590, this, j2, str) == null) {
            this.o = j2;
            this.p = str;
            h hVar = this.l;
            if (hVar != null) {
                hVar.update(j2, str);
            }
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.r0.g0.h hVar = this.n;
            return hVar != null && hVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f46972h == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f46972h.getChildCount(); i2++) {
            View childAt = this.f46972h.getChildAt(i2);
            if (childAt instanceof c.a.s0.x1.o.l.e) {
                ((c.a.s0.x1.o.l.e) childAt).onScrollIdle();
            }
        }
    }

    public void updateData(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, dataRes, z) == null) {
            PbListView pbListView = this.f46971g;
            if (pbListView != null) {
                pbListView.f();
            }
            this.l.i(z, dataRes, 0, null);
            setHasMore(this.l.c());
        }
    }

    public void updateError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, str, i2) == null) {
            PbListView pbListView = this.f46971g;
            if (pbListView != null) {
                pbListView.f();
            }
            this.l.i(true, null, i2, str);
        }
    }

    public final void v(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.m == null) {
                if (i2 < 0) {
                    this.m = new c.a.r0.g0.g(getContext());
                } else {
                    this.m = new c.a.r0.g0.g(getContext(), i2);
                }
                this.m.onChangeSkinType();
            }
            this.m.attachView(this, z);
        }
    }

    public final void w(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048596, this, view, str, z) == null) {
            if (this.n == null) {
                this.n = new c.a.r0.g0.h(getContext(), new g(this));
            }
            this.n.k(getResources().getDimensionPixelSize(R.dimen.ds160));
            this.n.m(str);
            this.n.attachView(view, z);
            this.n.p();
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
