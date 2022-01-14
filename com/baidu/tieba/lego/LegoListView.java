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
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.s0.s.j0.f;
import c.a.t0.q0.a;
import c.a.t0.x1.o.l.m;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public a.b D;
    public View.OnTouchListener E;
    public c.a.t0.x1.n.a cardListAdapter;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s.j0.g f45452e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f45453f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f45454g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45455h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45456i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f45457j;
    public boolean k;
    public boolean l;
    public c.a.t0.x1.d m;
    public c.a.s0.g0.g n;
    public c.a.t0.x1.g o;
    public c.a.t0.x1.p.e p;
    public TbPageContext<?> q;
    public int r;
    public c.a.t0.x1.p.c s;
    public m t;
    public c.a.t0.q0.a u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public CustomMessageListener z;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.k(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.t0.x1.p.b bVar = new c.a.t0.x1.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f25236b = true;
                this.a.k(bVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.t0.x1.p.b bVar = new c.a.t0.x1.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f25236b = false;
                this.a.k(bVar);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.y = true;
        }
    }

    /* loaded from: classes12.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f45458e;

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
            this.f45458e = legoListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45458e.r();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

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
            this.a = legoListView;
        }

        @Override // c.a.t0.q0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.a.x = false;
                LegoListView legoListView = this.a;
                legoListView.cardListAdapter.F(legoListView.x);
            }
        }

        @Override // c.a.t0.q0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.a.x = true;
                LegoListView legoListView = this.a;
                legoListView.cardListAdapter.F(legoListView.x);
            }
        }

        @Override // c.a.t0.q0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.t0.q0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f45459e;

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
            this.f45459e = legoListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f45459e.f45453f || this.f45459e.u == null) {
                    return false;
                }
                this.f45459e.u.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class h implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f45460e;

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
            this.f45460e = legoListView;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45460e.t == null) {
                return;
            }
            this.f45460e.t.h(view);
        }
    }

    /* loaded from: classes12.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f45461e;

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
            this.f45461e = legoListView;
        }

        @Override // c.a.s0.s.j0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f45461e.m == null) {
                return;
            }
            this.f45461e.t();
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
            this.k = z;
            if (this.f45453f == null || (pbListView = this.f45454g) == null) {
                return;
            }
            if (!this.f45455h) {
                pbListView.D("");
            } else if (z) {
                pbListView.D(getContext().getString(R.string.pb_load_more));
            } else {
                pbListView.D("");
            }
        }
    }

    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45453f : (BdListView) invokeV.objValue;
    }

    public m getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t : (m) invokeV.objValue;
    }

    public boolean isSelf(long j2, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, str)) == null) {
            c.a.t0.x1.p.e eVar = this.p;
            return eVar != null && j2 == eVar.a && TextUtils.equals(str, eVar.f25253b);
        }
        return invokeJL.booleanValue;
    }

    public final void k(Object obj) {
        c.a.t0.x1.p.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.cardListAdapter == null || (cVar = this.s) == null || cVar.d() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.s.d()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.cardListAdapter.notifyDataSetChanged();
        }
    }

    public final void l(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            c.a.s0.g0.g gVar = this.n;
            if (gVar != null) {
                gVar.dettachView(view);
                this.n = null;
            }
            c.a.s0.s.j0.g gVar2 = this.f45452e;
            if (gVar2 != null) {
                gVar2.v(true);
            }
            c.a.t0.x1.n.a aVar = this.cardListAdapter;
            if (aVar != null) {
                aVar.E(true);
                this.cardListAdapter.notifyDataSetChanged();
            }
        }
    }

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            c.a.d.a.f<?> a2 = j.a(context);
            a2.registerListener(this.z);
            a2.registerListener(this.A);
            a2.registerListener(this.B);
            if (a2 instanceof TbPageContext) {
                this.q = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f45453f = bdListView;
            bdListView.setDividerHeight(0);
            this.f45453f.setSelector(17170445);
            addView(this.f45453f);
            if (!z) {
                this.f45453f.setVerticalScrollBarEnabled(true);
                n(context);
            } else {
                this.f45453f.setTranscriptMode(1);
                this.f45453f.setVerticalScrollBarEnabled(false);
            }
            this.f45453f.setOnSrollToBottomListener(this);
            this.f45453f.setOnScrollListener(this);
            o();
            c.a.t0.x1.n.a aVar = new c.a.t0.x1.n.a(this.q);
            this.cardListAdapter = aVar;
            this.f45453f.setAdapter((ListAdapter) aVar);
            this.r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            c.a.s0.s.j0.g gVar = new c.a.s0.s.j0.g(this.q);
            this.f45452e = gVar;
            this.f45453f.setPullRefresh(gVar);
            PbListView pbListView = new PbListView(context);
            this.f45454g = pbListView;
            pbListView.a();
            this.f45454g.p(R.color.CAM_X0204);
            this.f45454g.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f45454g.d(TbadkCoreApplication.getInst().getSkinType());
            this.f45452e.a(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t = new m(this.q, this.f45453f);
            c.a.t0.q0.a aVar = new c.a.t0.q0.a();
            this.u = aVar;
            aVar.d(this.D);
            this.f45453f.setOnTouchListener(this.E);
            this.f45453f.setRecyclerListener(new h(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.s0.x0.a.a(this.q, this);
            SkinManager.setBackgroundColor(this.f45453f, R.color.CAM_X0204, i2);
            c.a.t0.x1.n.a aVar = this.cardListAdapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            c.a.s0.s.j0.g gVar = this.f45452e;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f45454g;
            if (pbListView != null) {
                pbListView.d(i2);
            }
        }
    }

    public void onDestory() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mVar = this.t) == null) {
            return;
        }
        mVar.c();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048586, this, absListView, i2, i3, i4) == null) {
            this.v = i2;
            this.w = (i2 + i3) - 1;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        c.a.t0.x1.p.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            c.a.t0.x1.g gVar = this.o;
            if (gVar != null && (eVar = this.p) != null) {
                gVar.a(eVar, this.f45453f.getFirstVisiblePosition());
            }
            q();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.k && n.C() && !this.l) {
            this.l = true;
            PbListView pbListView = this.f45454g;
            if (pbListView != null) {
                pbListView.R();
            }
            c.a.t0.x1.d dVar = this.m;
            if (dVar == null) {
                return;
            }
            if (this.cardListAdapter == null) {
                c.a.t0.x1.p.e eVar = this.p;
                dVar.a(1, eVar.a, eVar.f25253b, "");
                return;
            }
            c.a.t0.x1.p.c cVar = this.s;
            if (cVar != null) {
                c.a.t0.x1.d dVar2 = this.m;
                c.a.t0.x1.p.e eVar2 = this.p;
                dVar2.a(cVar.b() + 1, eVar2.a, eVar2.f25253b, this.s.f());
            }
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.f45453f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f45453f.getChildCount(); i2++) {
            View childAt = this.f45453f.getChildAt(i2);
            if (childAt instanceof c.a.t0.x1.o.l.e) {
                if (z) {
                    ((c.a.t0.x1.o.l.e) childAt).onViewBackground();
                } else {
                    ((c.a.t0.x1.o.l.e) childAt).onViewForeground();
                }
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f45453f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f45453f.getChildCount(); i2++) {
            View childAt = this.f45453f.getChildAt(i2);
            if (childAt instanceof c.a.t0.x1.o.l.e) {
                ((c.a.t0.x1.o.l.e) childAt).onScrollIdle();
            }
        }
        m mVar = this.t;
        if (mVar != null) {
            mVar.j(this.v, this.w, this.x, 1);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            s(this, false, getResources().getDimensionPixelSize(R.dimen.ds300));
            t();
        }
    }

    public void refreshView(c.a.t0.x1.p.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, cVar, z) == null) {
            BdListView bdListView = this.f45453f;
            if (bdListView != null) {
                bdListView.completePullRefresh();
            }
            PbListView pbListView = this.f45454g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (cVar == null) {
                setHasMore(false);
                l(this);
                this.cardListAdapter.D(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.r), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                this.cardListAdapter.notifyDataSetChanged();
                return;
            }
            this.s = cVar;
            this.l = false;
            this.f45456i = cVar.m();
            this.f45455h = cVar.l();
            this.f45457j = cVar.n();
            this.p = cVar.h();
            setHasMore(cVar.hasMore());
            List<ICardInfo> d2 = cVar.d();
            if (this.cardListAdapter != null) {
                if (d2 != null && d2.size() > 0) {
                    PbListView pbListView2 = this.f45454g;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.f45453f.setNextPage(this.f45454g);
                        }
                        if (this.k) {
                            this.f45454g.D(getContext().getString(R.string.pb_load_more));
                        } else if (d2.get(d2.size() - 1) instanceof WebViewCard) {
                            this.f45454g.D("");
                        } else {
                            this.f45454g.D(getContext().getString(R.string.list_no_more));
                        }
                    }
                } else {
                    if (this.f45455h && this.f45456i) {
                        this.cardListAdapter.D(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.r), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                    } else {
                        this.cardListAdapter.D(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.cardListAdapter.A(d2);
            }
            if (z) {
                this.f45453f.setSelection(cVar.g());
            }
            if (this.f45456i || !(d2 == null || d2.isEmpty())) {
                l(this);
            }
        }
    }

    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        c.a.s0.s.j0.g gVar = this.f45452e;
        if (gVar != null) {
            gVar.V(bdUniqueId);
        }
        this.C.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.C);
    }

    public final void s(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.n == null) {
                if (i2 < 0) {
                    this.n = new c.a.s0.g0.g(getContext());
                } else {
                    this.n = new c.a.s0.g0.g(getContext(), i2);
                }
                this.n.onChangeSkinType();
            }
            this.n.attachView(view, z);
            c.a.s0.s.j0.g gVar = this.f45452e;
            if (gVar != null) {
                gVar.v(false);
            }
            c.a.t0.x1.n.a aVar = this.cardListAdapter;
            if (aVar != null) {
                aVar.E(false);
                this.cardListAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setCallback(c.a.t0.x1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048596, this, f2) == null) || (bdListView = this.f45453f) == null) {
            return;
        }
        bdListView.setFriction(f2);
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
        }
    }

    public void setScrollCallback(c.a.t0.x1.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.o = gVar;
        }
    }

    public void setViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            p(true);
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            p(false);
            m mVar = this.t;
            if (mVar != null) {
                mVar.n(true);
                this.t.k(this.v, this.w, this.x, true);
            }
            if (this.f45457j || this.f45456i) {
                return;
            }
            if (this.f45455h && !n.C()) {
                if (this.cardListAdapter.isEmpty()) {
                    this.cardListAdapter.D(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.r), NoDataViewFactory.e.a(R.string.neterror), null, null);
                    this.cardListAdapter.notifyDataSetChanged();
                }
            } else if (this.y) {
                this.y = false;
                c.a.d.f.m.e.a().postDelayed(new e(this), 200L);
            } else {
                r();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.f45455h) {
                c.a.t0.x1.d dVar = this.m;
                c.a.t0.x1.p.e eVar = this.p;
                dVar.a(1, eVar.a, eVar.f25253b, "");
                return;
            }
            c.a.t0.x1.d dVar2 = this.m;
            c.a.t0.x1.p.e eVar2 = this.p;
            dVar2.b(eVar2.a, eVar2.f25253b);
        }
    }

    public void updateError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.f45453f;
            if (bdListView != null) {
                bdListView.completePullRefresh();
            }
            this.l = false;
            PbListView pbListView = this.f45454g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (this.cardListAdapter.getCount() <= 0 && this.f45455h) {
                this.cardListAdapter.D(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.r), NoDataViewFactory.e.c(str), null, null);
                this.cardListAdapter.A(new ArrayList());
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
        this.v = 0;
        this.w = 0;
        this.y = false;
        this.z = new a(this, 2001115);
        this.A = new b(this, 2001335);
        this.B = new c(this, 2001336);
        this.C = new d(this, 2016448);
        this.D = new f(this);
        this.E = new g(this);
        m(context, z);
    }
}
