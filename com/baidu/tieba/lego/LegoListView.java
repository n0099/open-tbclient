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
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.o0.s.f0.f;
import c.a.p0.i0.a;
import c.a.p0.o1.o.l.m;
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
/* loaded from: classes7.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public CustomMessageListener C;
    public a.b D;
    public View.OnTouchListener E;
    public c.a.p0.o1.n.a cardListAdapter;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.s.f0.g f53454e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f53455f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f53456g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53457h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53458i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f53459j;
    public boolean k;
    public boolean l;
    public c.a.p0.o1.d m;
    public c.a.o0.f0.g n;
    public c.a.p0.o1.g o;
    public c.a.p0.o1.p.e p;
    public TbPageContext<?> q;
    public int r;
    public c.a.p0.o1.p.c s;
    public m t;
    public c.a.p0.i0.a u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public CustomMessageListener z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53460a;

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
            this.f53460a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().f47847a) {
                return;
            }
            this.f53460a.k(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53461a;

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
            this.f53461a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.p0.o1.p.b bVar = new c.a.p0.o1.p.b();
                bVar.f22720a = String.valueOf(customResponsedMessage.getData());
                bVar.f22721b = true;
                this.f53461a.k(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53462a;

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
            this.f53462a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.p0.o1.p.b bVar = new c.a.p0.o1.p.b();
                bVar.f22720a = String.valueOf(customResponsedMessage.getData());
                bVar.f22721b = false;
                this.f53462a.k(bVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53463a;

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
            this.f53463a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f53463a.y = true;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53464e;

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
            this.f53464e = legoListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53464e.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53465a;

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
            this.f53465a = legoListView;
        }

        @Override // c.a.p0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f53465a.x = false;
                LegoListView legoListView = this.f53465a;
                legoListView.cardListAdapter.F(legoListView.x);
            }
        }

        @Override // c.a.p0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f53465a.x = true;
                LegoListView legoListView = this.f53465a;
                legoListView.cardListAdapter.F(legoListView.x);
            }
        }

        @Override // c.a.p0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.p0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53466e;

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
            this.f53466e = legoListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.f53466e.f53455f || this.f53466e.u == null) {
                    return false;
                }
                this.f53466e.u.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53467e;

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
            this.f53467e = legoListView;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f53467e.t == null) {
                return;
            }
            this.f53467e.t.h(view);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LegoListView f53468e;

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
            this.f53468e = legoListView;
        }

        @Override // c.a.o0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f53468e.m == null) {
                return;
            }
            this.f53468e.t();
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
            if (this.f53455f == null || (pbListView = this.f53456g) == null) {
                return;
            }
            if (!this.f53457h) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53455f : (BdListView) invokeV.objValue;
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
            c.a.p0.o1.p.e eVar = this.p;
            return eVar != null && j2 == eVar.f22740a && TextUtils.equals(str, eVar.f22741b);
        }
        return invokeJL.booleanValue;
    }

    public final void k(Object obj) {
        c.a.p0.o1.p.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || this.cardListAdapter == null || (cVar = this.s) == null || cVar.e() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.s.e()) {
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
            c.a.o0.f0.g gVar = this.n;
            if (gVar != null) {
                gVar.dettachView(view);
                this.n = null;
            }
            c.a.o0.s.f0.g gVar2 = this.f53454e;
            if (gVar2 != null) {
                gVar2.w(true);
            }
            c.a.p0.o1.n.a aVar = this.cardListAdapter;
            if (aVar != null) {
                aVar.E(true);
                this.cardListAdapter.notifyDataSetChanged();
            }
        }
    }

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            c.a.e.a.f<?> a2 = j.a(context);
            a2.registerListener(this.z);
            a2.registerListener(this.A);
            a2.registerListener(this.B);
            if (a2 instanceof TbPageContext) {
                this.q = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f53455f = bdListView;
            bdListView.setDividerHeight(0);
            this.f53455f.setSelector(17170445);
            addView(this.f53455f);
            if (!z) {
                this.f53455f.setVerticalScrollBarEnabled(true);
                n(context);
            } else {
                this.f53455f.setTranscriptMode(1);
                this.f53455f.setVerticalScrollBarEnabled(false);
            }
            this.f53455f.setOnSrollToBottomListener(this);
            this.f53455f.setOnScrollListener(this);
            o();
            c.a.p0.o1.n.a aVar = new c.a.p0.o1.n.a(this.q);
            this.cardListAdapter = aVar;
            this.f53455f.setAdapter((ListAdapter) aVar);
            this.r = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds120);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            c.a.o0.s.f0.g gVar = new c.a.o0.s.f0.g(this.q);
            this.f53454e = gVar;
            this.f53455f.setPullRefresh(gVar);
            PbListView pbListView = new PbListView(context);
            this.f53456g = pbListView;
            pbListView.a();
            this.f53456g.o(R.color.CAM_X0204);
            this.f53456g.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f53456g.d(TbadkCoreApplication.getInst().getSkinType());
            this.f53454e.a(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.t = new m(this.q, this.f53455f);
            c.a.p0.i0.a aVar = new c.a.p0.i0.a();
            this.u = aVar;
            aVar.d(this.D);
            this.f53455f.setOnTouchListener(this.E);
            this.f53455f.setRecyclerListener(new h(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.o0.u0.a.a(this.q, this);
            SkinManager.setBackgroundColor(this.f53455f, R.color.CAM_X0204, i2);
            c.a.p0.o1.n.a aVar = this.cardListAdapter;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            c.a.o0.s.f0.g gVar = this.f53454e;
            if (gVar != null) {
                gVar.D(i2);
            }
            PbListView pbListView = this.f53456g;
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
        c.a.p0.o1.p.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            c.a.p0.o1.g gVar = this.o;
            if (gVar != null && (eVar = this.p) != null) {
                gVar.a(eVar, this.f53455f.getFirstVisiblePosition());
            }
            q();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.k && l.D() && !this.l) {
            this.l = true;
            PbListView pbListView = this.f53456g;
            if (pbListView != null) {
                pbListView.O();
            }
            c.a.p0.o1.d dVar = this.m;
            if (dVar == null) {
                return;
            }
            if (this.cardListAdapter == null) {
                c.a.p0.o1.p.e eVar = this.p;
                dVar.a(1, eVar.f22740a, eVar.f22741b, "");
                return;
            }
            c.a.p0.o1.p.c cVar = this.s;
            if (cVar != null) {
                c.a.p0.o1.d dVar2 = this.m;
                c.a.p0.o1.p.e eVar2 = this.p;
                dVar2.a(cVar.b() + 1, eVar2.f22740a, eVar2.f22741b, this.s.g());
            }
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.f53455f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f53455f.getChildCount(); i2++) {
            View childAt = this.f53455f.getChildAt(i2);
            if (childAt instanceof c.a.p0.o1.o.l.e) {
                if (z) {
                    ((c.a.p0.o1.o.l.e) childAt).onViewBackground();
                } else {
                    ((c.a.p0.o1.o.l.e) childAt).onViewForeground();
                }
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f53455f == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f53455f.getChildCount(); i2++) {
            View childAt = this.f53455f.getChildAt(i2);
            if (childAt instanceof c.a.p0.o1.o.l.e) {
                ((c.a.p0.o1.o.l.e) childAt).onScrollIdle();
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

    public void refreshView(c.a.p0.o1.p.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, cVar, z) == null) {
            BdListView bdListView = this.f53455f;
            if (bdListView != null) {
                bdListView.completePullRefresh();
            }
            PbListView pbListView = this.f53456g;
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
            this.f53458i = cVar.n();
            this.f53457h = cVar.m();
            this.f53459j = cVar.o();
            this.p = cVar.i();
            setHasMore(cVar.a());
            List<ICardInfo> e2 = cVar.e();
            if (this.cardListAdapter != null) {
                if (e2 != null && e2.size() > 0) {
                    PbListView pbListView2 = this.f53456g;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.f53455f.setNextPage(this.f53456g);
                        }
                        if (this.k) {
                            this.f53456g.A(getContext().getString(R.string.pb_load_more));
                        } else if (e2.get(e2.size() - 1) instanceof WebViewCard) {
                            this.f53456g.A("");
                        } else {
                            this.f53456g.A(getContext().getString(R.string.list_no_more));
                        }
                    }
                } else {
                    if (this.f53457h && this.f53458i) {
                        this.cardListAdapter.D(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.r), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                    } else {
                        this.cardListAdapter.D(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.cardListAdapter.A(e2);
            }
            if (z) {
                this.f53455f.setSelection(cVar.h());
            }
            if (this.f53458i || !(e2 == null || e2.isEmpty())) {
                l(this);
            }
        }
    }

    public void registerListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        c.a.o0.s.f0.g gVar = this.f53454e;
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
                    this.n = new c.a.o0.f0.g(getContext());
                } else {
                    this.n = new c.a.o0.f0.g(getContext(), i2);
                }
                this.n.onChangeSkinType();
            }
            this.n.attachView(view, z);
            c.a.o0.s.f0.g gVar = this.f53454e;
            if (gVar != null) {
                gVar.w(false);
            }
            c.a.p0.o1.n.a aVar = this.cardListAdapter;
            if (aVar != null) {
                aVar.E(false);
                this.cardListAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setCallback(c.a.p0.o1.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.m = dVar;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048596, this, f2) == null) || (bdListView = this.f53455f) == null) {
            return;
        }
        bdListView.setFriction(f2);
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
        }
    }

    public void setScrollCallback(c.a.p0.o1.g gVar) {
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
            if (this.f53459j || this.f53458i) {
                return;
            }
            if (this.f53457h && !l.D()) {
                if (this.cardListAdapter.isEmpty()) {
                    this.cardListAdapter.D(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.r), NoDataViewFactory.e.a(R.string.neterror), null, null);
                    this.cardListAdapter.notifyDataSetChanged();
                }
            } else if (this.y) {
                this.y = false;
                c.a.e.e.m.e.a().postDelayed(new e(this), 200L);
            } else {
                r();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.f53457h) {
                c.a.p0.o1.d dVar = this.m;
                c.a.p0.o1.p.e eVar = this.p;
                dVar.a(1, eVar.f22740a, eVar.f22741b, "");
                return;
            }
            c.a.p0.o1.d dVar2 = this.m;
            c.a.p0.o1.p.e eVar2 = this.p;
            dVar2.b(eVar2.f22740a, eVar2.f22741b);
        }
    }

    public void updateError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.f53455f;
            if (bdListView != null) {
                bdListView.completePullRefresh();
            }
            this.l = false;
            PbListView pbListView = this.f53456g;
            if (pbListView != null) {
                pbListView.f();
            }
            if (this.cardListAdapter.getCount() <= 0 && this.f53457h) {
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
