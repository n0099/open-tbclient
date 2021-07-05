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
import d.a.r0.r.f0.f;
import d.a.s0.i0.a;
import d.a.s0.n1.o.l.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
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
    public d.a.r0.r.f0.g f18093e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f18094f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f18095g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.n1.n.a f18096h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18097i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public d.a.s0.n1.d n;
    public d.a.r0.d0.g o;
    public d.a.s0.n1.g p;
    public d.a.s0.n1.p.e q;
    public TbPageContext<?> r;
    public int s;
    public d.a.s0.n1.p.c t;
    public n u;
    public d.a.s0.i0.a v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18098a;

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
            this.f18098a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f12800a) {
                return;
            }
            this.f18098a.k(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18099a;

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
            this.f18099a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.s0.n1.p.b bVar = new d.a.s0.n1.p.b();
                bVar.f63884a = String.valueOf(customResponsedMessage.getData());
                bVar.f63885b = true;
                this.f18099a.k(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18100a;

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
            this.f18100a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                d.a.s0.n1.p.b bVar = new d.a.s0.n1.p.b();
                bVar.f63884a = String.valueOf(customResponsedMessage.getData());
                bVar.f63885b = false;
                this.f18100a.k(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18101a;

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
            this.f18101a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f18101a.z = true;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18102e;

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
            this.f18102e = legoListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18102e.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18103a;

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
            this.f18103a = legoListView;
        }

        @Override // d.a.s0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f18103a.y = false;
                LegoListView legoListView = this.f18103a;
                legoListView.f18096h.H(legoListView.y);
            }
        }

        @Override // d.a.s0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f18103a.y = true;
                LegoListView legoListView = this.f18103a;
                legoListView.f18096h.H(legoListView.y);
            }
        }

        @Override // d.a.s0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18104e;

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
            this.f18104e = legoListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f18104e.f18094f || this.f18104e.v == null) {
                    return false;
                }
                this.f18104e.v.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18105e;

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
            this.f18105e = legoListView;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f18105e.u == null) {
                return;
            }
            this.f18105e.u.h(view);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f18106e;

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
            this.f18106e = legoListView;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f18106e.n == null) {
                return;
            }
            this.f18106e.y();
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
            if (this.f18094f == null || (pbListView = this.f18095g) == null) {
                return;
            }
            if (!this.f18097i) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18094f : (BdListView) invokeV.objValue;
    }

    public n getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (n) invokeV.objValue;
    }

    public final void k(Object obj) {
        d.a.s0.n1.p.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f18096h == null || (cVar = this.t) == null || cVar.e() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.t.e()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f18096h.notifyDataSetChanged();
        }
    }

    public final void l(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            d.a.r0.d0.g gVar = this.o;
            if (gVar != null) {
                gVar.dettachView(view);
                this.o = null;
            }
            d.a.r0.r.f0.g gVar2 = this.f18093e;
            if (gVar2 != null) {
                gVar2.B(true);
            }
            d.a.s0.n1.n.a aVar = this.f18096h;
            if (aVar != null) {
                aVar.G(true);
                this.f18096h.notifyDataSetChanged();
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
            this.f18094f = bdListView;
            bdListView.setDividerHeight(0);
            this.f18094f.setSelector(17170445);
            addView(this.f18094f);
            if (!z) {
                this.f18094f.setVerticalScrollBarEnabled(true);
                n(context);
            } else {
                this.f18094f.setTranscriptMode(1);
                this.f18094f.setVerticalScrollBarEnabled(false);
            }
            this.f18094f.setOnSrollToBottomListener(this);
            this.f18094f.setOnScrollListener(this);
            o();
            d.a.s0.n1.n.a aVar = new d.a.s0.n1.n.a(this.r);
            this.f18096h = aVar;
            this.f18094f.setAdapter((ListAdapter) aVar);
            this.s = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(this.r);
            this.f18093e = gVar;
            this.f18094f.setPullRefresh(gVar);
            PbListView pbListView = new PbListView(context);
            this.f18095g = pbListView;
            pbListView.a();
            this.f18095g.o(R.color.CAM_X0204);
            this.f18095g.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f18095g.d(TbadkCoreApplication.getInst().getSkinType());
            this.f18093e.a(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u = new n(this.r, this.f18094f);
            d.a.s0.i0.a aVar = new d.a.s0.i0.a();
            this.v = aVar;
            aVar.d(this.E);
            this.f18094f.setOnTouchListener(this.F);
            this.f18094f.setRecyclerListener(new h(this));
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
        d.a.s0.n1.p.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            d.a.s0.n1.g gVar = this.p;
            if (gVar != null && (eVar = this.q) != null) {
                gVar.a(eVar, this.f18094f.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.l && l.D() && !this.m) {
            this.m = true;
            PbListView pbListView = this.f18095g;
            if (pbListView != null) {
                pbListView.O();
            }
            d.a.s0.n1.d dVar = this.n;
            if (dVar == null) {
                return;
            }
            if (this.f18096h == null) {
                d.a.s0.n1.p.e eVar = this.q;
                dVar.a(1, eVar.f63903a, eVar.f63904b, "");
                return;
            }
            d.a.s0.n1.p.c cVar = this.t;
            if (cVar != null) {
                d.a.s0.n1.d dVar2 = this.n;
                d.a.s0.n1.p.e eVar2 = this.q;
                dVar2.a(cVar.b() + 1, eVar2.f63903a, eVar2.f63904b, this.t.g());
            }
        }
    }

    public boolean p(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, str)) == null) {
            d.a.s0.n1.p.e eVar = this.q;
            return eVar != null && j == eVar.f63903a && TextUtils.equals(str, eVar.f63904b);
        }
        return invokeJL.booleanValue;
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f18094f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18094f.getChildCount(); i2++) {
            View childAt = this.f18094f.getChildAt(i2);
            if (childAt instanceof d.a.s0.n1.o.l.e) {
                if (z) {
                    ((d.a.s0.n1.o.l.e) childAt).f();
                } else {
                    ((d.a.s0.n1.o.l.e) childAt).k();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f18094f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f18094f.getChildCount(); i2++) {
            View childAt = this.f18094f.getChildAt(i2);
            if (childAt instanceof d.a.s0.n1.o.l.e) {
                ((d.a.s0.n1.o.l.e) childAt).j();
            }
        }
        n nVar = this.u;
        if (nVar != null) {
            nVar.j(this.w, this.x, this.y, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            d.a.r0.s0.a.a(this.r, this);
            SkinManager.setBackgroundColor(this.f18094f, R.color.CAM_X0204, i2);
            d.a.s0.n1.n.a aVar = this.f18096h;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            d.a.r0.r.f0.g gVar = this.f18093e;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.f18095g;
            if (pbListView != null) {
                pbListView.d(i2);
            }
        }
    }

    public void setCallback(d.a.s0.n1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || (bdListView = this.f18094f) == null) {
            return;
        }
        bdListView.setFriction(f2);
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void setScrollCallback(d.a.s0.n1.g gVar) {
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
            n nVar = this.u;
            if (nVar != null) {
                nVar.n(true);
                this.u.k(this.w, this.x, this.y, true);
            }
            if (this.k || this.j) {
                return;
            }
            if (this.f18097i && !l.D()) {
                if (this.f18096h.isEmpty()) {
                    this.f18096h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.neterror), null, null);
                    this.f18096h.notifyDataSetChanged();
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
        n nVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (nVar = this.u) == null) {
            return;
        }
        nVar.c();
    }

    public void u(d.a.s0.n1.p.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, cVar, z) == null) {
            BdListView bdListView = this.f18094f;
            if (bdListView != null) {
                bdListView.z();
            }
            PbListView pbListView = this.f18095g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (cVar == null) {
                setHasMore(false);
                l(this);
                this.f18096h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                this.f18096h.notifyDataSetChanged();
                return;
            }
            this.t = cVar;
            this.m = false;
            this.j = cVar.n();
            this.f18097i = cVar.m();
            this.k = cVar.o();
            this.q = cVar.i();
            setHasMore(cVar.a());
            List<ICardInfo> e2 = cVar.e();
            if (this.f18096h != null) {
                if (e2 != null && e2.size() > 0) {
                    PbListView pbListView2 = this.f18095g;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.f18094f.setNextPage(this.f18095g);
                        }
                        if (this.l) {
                            this.f18095g.A(getContext().getString(R.string.pb_load_more));
                        } else if (e2.get(e2.size() - 1) instanceof WebViewCard) {
                            this.f18095g.A("");
                        } else {
                            this.f18095g.A(getContext().getString(R.string.list_no_more));
                        }
                    }
                } else {
                    if (this.f18097i && this.j) {
                        this.f18096h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                    } else {
                        this.f18096h.F(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.f18096h.C(e2);
            }
            if (z) {
                this.f18094f.setSelection(cVar.h());
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
        d.a.r0.r.f0.g gVar = this.f18093e;
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
                    this.o = new d.a.r0.d0.g(getContext());
                } else {
                    this.o = new d.a.r0.d0.g(getContext(), i2);
                }
                this.o.onChangeSkinType();
            }
            this.o.attachView(view, z);
            d.a.r0.r.f0.g gVar = this.f18093e;
            if (gVar != null) {
                gVar.B(false);
            }
            d.a.s0.n1.n.a aVar = this.f18096h;
            if (aVar != null) {
                aVar.G(false);
                this.f18096h.notifyDataSetChanged();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.f18097i) {
                d.a.s0.n1.d dVar = this.n;
                d.a.s0.n1.p.e eVar = this.q;
                dVar.a(1, eVar.f63903a, eVar.f63904b, "");
                return;
            }
            d.a.s0.n1.d dVar2 = this.n;
            d.a.s0.n1.p.e eVar2 = this.q;
            dVar2.b(eVar2.f63903a, eVar2.f63904b);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.f18094f;
            if (bdListView != null) {
                bdListView.z();
            }
            this.m = false;
            PbListView pbListView = this.f18095g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (this.f18096h.getCount() <= 0 && this.f18097i) {
                this.f18096h.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.s), NoDataViewFactory.e.c(str), null, null);
                this.f18096h.C(new ArrayList());
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
