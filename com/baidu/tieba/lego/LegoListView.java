package com.baidu.tieba.lego;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.p0.i0.a;
import d.a.p0.n1.o.l.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public CustomMessageListener D;
    public a.b E;
    public View.OnTouchListener F;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r.f0.g f18133e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f18134f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f18135g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.n1.n.a f18136h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18137i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public d.a.p0.n1.d n;
    public d.a.o0.d0.g o;
    public d.a.p0.n1.g p;
    public d.a.p0.n1.p.e q;
    public TbPageContext<?> r;
    public int s;
    public d.a.p0.n1.p.c t;
    public m u;
    public d.a.p0.i0.a v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18138a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoListView legoListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i2)};
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
            this.f18138a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12817a) {
                return;
            }
            this.f18138a.k(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18139a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LegoListView legoListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i2)};
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
            this.f18139a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.p0.n1.p.b bVar = new d.a.p0.n1.p.b();
                bVar.f60650a = String.valueOf(customResponsedMessage.getData());
                bVar.f60651b = true;
                this.f18139a.k(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18140a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoListView legoListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i2)};
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
            this.f18140a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.p0.n1.p.b bVar = new d.a.p0.n1.p.b();
                bVar.f60650a = String.valueOf(customResponsedMessage.getData());
                bVar.f60651b = false;
                this.f18140a.k(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18141a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LegoListView legoListView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i2)};
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
            this.f18141a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f18141a.z = true;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18142e;

        public e(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18142e = legoListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18142e.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18143a;

        public f(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18143a = legoListView;
        }

        @Override // d.a.p0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f18143a.y = false;
                LegoListView legoListView = this.f18143a;
                legoListView.f18136h.H(legoListView.y);
            }
        }

        @Override // d.a.p0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f18143a.y = true;
                LegoListView legoListView = this.f18143a;
                legoListView.f18136h.H(legoListView.y);
            }
        }

        @Override // d.a.p0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.p0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18144e;

        public g(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18144e = legoListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f18144e.f18134f || this.f18144e.v == null) {
                    return false;
                }
                this.f18144e.v.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18145e;

        public h(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18145e = legoListView;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18145e.u == null) {
                return;
            }
            this.f18145e.u.h(view);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18146e;

        public i(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18146e = legoListView;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f18146e.n == null) {
                return;
            }
            this.f18146e.y();
        }

        public /* synthetic */ i(LegoListView legoListView, a aVar) {
            this(legoListView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LegoListView(Context context) {
        this(context, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void setHasMore(boolean z) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            this.l = z;
            if (this.f18134f == null || (pbListView = this.f18135g) == null) {
                return;
            }
            if (!this.f18137i) {
                pbListView.A("");
            } else if (z) {
                pbListView.A(getContext().getString(R.string.pb_load_more));
            } else {
                pbListView.A("");
            }
        }
    }

    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18134f : (BdListView) invokeV.objValue;
    }

    public m getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (m) invokeV.objValue;
    }

    public final void k(Object obj) {
        d.a.p0.n1.p.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f18136h == null || (cVar = this.t) == null || cVar.e() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.t.e()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f18136h.notifyDataSetChanged();
        }
    }

    public final void l(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            d.a.o0.d0.g gVar = this.o;
            if (gVar != null) {
                gVar.dettachView(view);
                this.o = null;
            }
            d.a.o0.r.f0.g gVar2 = this.f18133e;
            if (gVar2 != null) {
                gVar2.B(true);
            }
            d.a.p0.n1.n.a aVar = this.f18136h;
            if (aVar != null) {
                aVar.G(true);
                this.f18136h.notifyDataSetChanged();
            }
        }
    }

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            d.a.c.a.f<?> a2 = j.a(context);
            a2.registerListener(this.A);
            a2.registerListener(this.B);
            a2.registerListener(this.C);
            if (a2 instanceof TbPageContext) {
                this.r = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f18134f = bdListView;
            bdListView.setDividerHeight(0);
            this.f18134f.setSelector(17170445);
            addView(this.f18134f);
            if (!z) {
                this.f18134f.setVerticalScrollBarEnabled(true);
                n(context);
            } else {
                this.f18134f.setTranscriptMode(1);
                this.f18134f.setVerticalScrollBarEnabled(false);
            }
            this.f18134f.setOnSrollToBottomListener(this);
            this.f18134f.setOnScrollListener(this);
            o();
            d.a.p0.n1.n.a aVar = new d.a.p0.n1.n.a(this.r);
            this.f18136h = aVar;
            this.f18134f.setAdapter((ListAdapter) aVar);
            this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(this.r);
            this.f18133e = gVar;
            this.f18134f.setPullRefresh(gVar);
            PbListView pbListView = new PbListView(context);
            this.f18135g = pbListView;
            pbListView.a();
            this.f18135g.o(R.color.CAM_X0204);
            this.f18135g.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f18135g.d(TbadkCoreApplication.getInst().getSkinType());
            this.f18133e.a(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u = new m(this.r, this.f18134f);
            d.a.p0.i0.a aVar = new d.a.p0.i0.a();
            this.v = aVar;
            aVar.d(this.E);
            this.f18134f.setOnTouchListener(this.F);
            this.f18134f.setRecyclerListener(new h(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i2, i3, i4) == null) {
            this.w = i2;
            this.x = (i2 + i3) - 1;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        d.a.p0.n1.p.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            d.a.p0.n1.g gVar = this.p;
            if (gVar != null && (eVar = this.q) != null) {
                gVar.a(eVar, this.f18134f.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.l && l.D() && !this.m) {
            this.m = true;
            PbListView pbListView = this.f18135g;
            if (pbListView != null) {
                pbListView.O();
            }
            d.a.p0.n1.d dVar = this.n;
            if (dVar == null) {
                return;
            }
            if (this.f18136h == null) {
                d.a.p0.n1.p.e eVar = this.q;
                dVar.a(1, eVar.f60669a, eVar.f60670b, "");
                return;
            }
            d.a.p0.n1.p.c cVar = this.t;
            if (cVar != null) {
                d.a.p0.n1.d dVar2 = this.n;
                d.a.p0.n1.p.e eVar2 = this.q;
                dVar2.a(cVar.b() + 1, eVar2.f60669a, eVar2.f60670b, this.t.g());
            }
        }
    }

    public boolean p(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, str)) == null) {
            d.a.p0.n1.p.e eVar = this.q;
            return eVar != null && j == eVar.f60669a && TextUtils.equals(str, eVar.f60670b);
        }
        return invokeJL.booleanValue;
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f18134f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18134f.getChildCount(); i2++) {
            View childAt = this.f18134f.getChildAt(i2);
            if (childAt instanceof d.a.p0.n1.o.l.e) {
                if (z) {
                    ((d.a.p0.n1.o.l.e) childAt).f();
                } else {
                    ((d.a.p0.n1.o.l.e) childAt).j();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f18134f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18134f.getChildCount(); i2++) {
            View childAt = this.f18134f.getChildAt(i2);
            if (childAt instanceof d.a.p0.n1.o.l.e) {
                ((d.a.p0.n1.o.l.e) childAt).i();
            }
        }
        m mVar = this.u;
        if (mVar != null) {
            mVar.j(this.w, this.x, this.y, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            d.a.o0.s0.a.a(this.r, this);
            SkinManager.setBackgroundColor(this.f18134f, R.color.CAM_X0204, i2);
            d.a.p0.n1.n.a aVar = this.f18136h;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            d.a.o0.r.f0.g gVar = this.f18133e;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.f18135g;
            if (pbListView != null) {
                pbListView.d(i2);
            }
        }
    }

    public void setCallback(d.a.p0.n1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || (bdListView = this.f18134f) == null) {
            return;
        }
        bdListView.setFriction(f2);
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void setScrollCallback(d.a.p0.n1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.p = gVar;
        }
    }

    public void setViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            q(true);
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q(false);
            m mVar = this.u;
            if (mVar != null) {
                mVar.n(true);
                this.u.k(this.w, this.x, this.y, true);
            }
            if (this.k || this.j) {
                return;
            }
            if (this.f18137i && !l.D()) {
                if (this.f18136h.isEmpty()) {
                    this.f18136h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.neterror), null, null);
                    this.f18136h.notifyDataSetChanged();
                }
            } else if (this.z) {
                this.z = false;
                d.a.c.e.m.e.a().postDelayed(new e(this), 200L);
            } else {
                w();
            }
        }
    }

    public void t() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (mVar = this.u) == null) {
            return;
        }
        mVar.c();
    }

    public void u(d.a.p0.n1.p.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, cVar, z) == null) {
            BdListView bdListView = this.f18134f;
            if (bdListView != null) {
                bdListView.z();
            }
            PbListView pbListView = this.f18135g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (cVar == null) {
                setHasMore(false);
                l(this);
                this.f18136h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                this.f18136h.notifyDataSetChanged();
                return;
            }
            this.t = cVar;
            this.m = false;
            this.j = cVar.n();
            this.f18137i = cVar.m();
            this.k = cVar.o();
            this.q = cVar.i();
            setHasMore(cVar.a());
            List<ICardInfo> e2 = cVar.e();
            if (this.f18136h != null) {
                if (e2 != null && e2.size() > 0) {
                    PbListView pbListView2 = this.f18135g;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.f18134f.setNextPage(this.f18135g);
                        }
                        if (this.l) {
                            this.f18135g.A(getContext().getString(R.string.pb_load_more));
                        } else if (e2.get(e2.size() - 1) instanceof WebViewCard) {
                            this.f18135g.A("");
                        } else {
                            this.f18135g.A(getContext().getString(R.string.list_no_more));
                        }
                    }
                } else {
                    if (this.f18137i && this.j) {
                        this.f18136h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                    } else {
                        this.f18136h.F(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.f18136h.C(e2);
            }
            if (z) {
                this.f18134f.setSelection(cVar.h());
            }
            if (this.j || !(e2 == null || e2.isEmpty())) {
                l(this);
            }
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        d.a.o0.r.f0.g gVar = this.f18133e;
        if (gVar != null) {
            gVar.a0(bdUniqueId);
        }
        this.D.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.D);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
            y();
        }
    }

    public final void x(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.o == null) {
                if (i2 < 0) {
                    this.o = new d.a.o0.d0.g(getContext());
                } else {
                    this.o = new d.a.o0.d0.g(getContext(), i2);
                }
                this.o.onChangeSkinType();
            }
            this.o.attachView(view, z);
            d.a.o0.r.f0.g gVar = this.f18133e;
            if (gVar != null) {
                gVar.B(false);
            }
            d.a.p0.n1.n.a aVar = this.f18136h;
            if (aVar != null) {
                aVar.G(false);
                this.f18136h.notifyDataSetChanged();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.f18137i) {
                d.a.p0.n1.d dVar = this.n;
                d.a.p0.n1.p.e eVar = this.q;
                dVar.a(1, eVar.f60669a, eVar.f60670b, "");
                return;
            }
            d.a.p0.n1.d dVar2 = this.n;
            d.a.p0.n1.p.e eVar2 = this.q;
            dVar2.b(eVar2.f60669a, eVar2.f60670b);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.f18134f;
            if (bdListView != null) {
                bdListView.z();
            }
            this.m = false;
            PbListView pbListView = this.f18135g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (this.f18136h.getCount() <= 0 && this.f18137i) {
                this.f18136h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.c(str), null, null);
                this.f18136h.C(new ArrayList());
            }
            l(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoListView(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.w = 0;
        this.x = 0;
        this.z = false;
        this.A = new a(this, 2001115);
        this.B = new b(this, 2001335);
        this.C = new c(this, 2001336);
        this.D = new d(this, 2016448);
        this.E = new f(this);
        this.F = new g(this);
        m(context, z);
    }
}
