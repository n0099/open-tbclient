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
import c.a.o0.r.l0.f;
import c.a.p0.b2.o.l.m;
import c.a.p0.s0.a;
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
/* loaded from: classes5.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b A;
    public View.OnTouchListener B;
    public c.a.o0.r.l0.g a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f34179b;

    /* renamed from: c  reason: collision with root package name */
    public PbListView f34180c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.b2.n.a f34181d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34182e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34183f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34184g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34185h;
    public boolean i;
    public c.a.p0.b2.d j;
    public c.a.o0.f0.g k;
    public c.a.p0.b2.g l;
    public c.a.p0.b2.p.e m;
    public TbPageContext<?> n;
    public int o;
    public c.a.p0.b2.p.c p;
    public m q;
    public c.a.p0.s0.a r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoListView legoListView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i)};
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

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LegoListView legoListView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i)};
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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.p0.b2.p.b bVar = new c.a.p0.b2.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f12556b = true;
                this.a.k(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoListView legoListView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i)};
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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                c.a.p0.b2.p.b bVar = new c.a.p0.b2.p.b();
                bVar.a = String.valueOf(customResponsedMessage.getData());
                bVar.f12556b = false;
                this.a.k(bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LegoListView legoListView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView, Integer.valueOf(i)};
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
            this.a = legoListView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.v = true;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        public e(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListView;
        }

        @Override // c.a.p0.s0.a.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.u = false;
                LegoListView legoListView = this.a;
                legoListView.f34181d.H(legoListView.u);
            }
        }

        @Override // c.a.p0.s0.a.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.u = true;
                LegoListView legoListView = this.a;
                legoListView.f34181d.H(legoListView.u);
            }
        }

        @Override // c.a.p0.s0.a.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // c.a.p0.s0.a.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        public g(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view != this.a.f34179b || this.a.r == null) {
                    return false;
                }
                this.a.r.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        public h(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListView;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.q == null) {
                return;
            }
            this.a.q.h(view);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        public i(LegoListView legoListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoListView;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.j == null) {
                return;
            }
            this.a.y();
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
            this.f34185h = z;
            if (this.f34179b == null || (pbListView = this.f34180c) == null) {
                return;
            }
            if (!this.f34182e) {
                pbListView.D("");
            } else if (z) {
                pbListView.D(getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
            } else {
                pbListView.D("");
            }
        }
    }

    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34179b : (BdListView) invokeV.objValue;
    }

    public m getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : (m) invokeV.objValue;
    }

    public final void k(Object obj) {
        c.a.p0.b2.p.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.f34181d == null || (cVar = this.p) == null || cVar.d() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.p.d()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.f34181d.notifyDataSetChanged();
        }
    }

    public final void l(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.o0.f0.g gVar = this.k;
            if (gVar != null) {
                gVar.dettachView(view);
                this.k = null;
            }
            c.a.o0.r.l0.g gVar2 = this.a;
            if (gVar2 != null) {
                gVar2.A(true);
            }
            c.a.p0.b2.n.a aVar = this.f34181d;
            if (aVar != null) {
                aVar.G(true);
                this.f34181d.notifyDataSetChanged();
            }
        }
    }

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            c.a.d.a.f<?> a2 = j.a(context);
            a2.registerListener(this.w);
            a2.registerListener(this.x);
            a2.registerListener(this.y);
            if (a2 instanceof TbPageContext) {
                this.n = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.f34179b = bdListView;
            bdListView.setDividerHeight(0);
            this.f34179b.setSelector(17170445);
            addView(this.f34179b);
            if (!z) {
                this.f34179b.setVerticalScrollBarEnabled(true);
                n(context);
            } else {
                this.f34179b.setTranscriptMode(1);
                this.f34179b.setVerticalScrollBarEnabled(false);
            }
            this.f34179b.setOnSrollToBottomListener(this);
            this.f34179b.setOnScrollListener(this);
            o();
            c.a.p0.b2.n.a aVar = new c.a.p0.b2.n.a(this.n);
            this.f34181d = aVar;
            this.f34179b.setAdapter((ListAdapter) aVar);
            this.o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070235);
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(this.n);
            this.a = gVar;
            this.f34179b.setPullRefresh(gVar);
            PbListView pbListView = new PbListView(context);
            this.f34180c = pbListView;
            pbListView.a();
            this.f34180c.p(R.color.CAM_X0204);
            this.f34180c.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f34180c.d(TbadkCoreApplication.getInst().getSkinType());
            this.a.f(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q = new m(this.n, this.f34179b);
            c.a.p0.s0.a aVar = new c.a.p0.s0.a();
            this.r = aVar;
            aVar.d(this.A);
            this.f34179b.setOnTouchListener(this.B);
            this.f34179b.setRecyclerListener(new h(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048583, this, absListView, i2, i3, i4) == null) {
            this.s = i2;
            this.t = (i2 + i3) - 1;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        c.a.p0.b2.p.e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            c.a.p0.b2.g gVar = this.l;
            if (gVar != null && (eVar = this.m) != null) {
                gVar.a(eVar, this.f34179b.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f34185h && n.C() && !this.i) {
            this.i = true;
            PbListView pbListView = this.f34180c;
            if (pbListView != null) {
                pbListView.R();
            }
            c.a.p0.b2.d dVar = this.j;
            if (dVar == null) {
                return;
            }
            if (this.f34181d == null) {
                c.a.p0.b2.p.e eVar = this.m;
                dVar.a(1, eVar.a, eVar.f12571b, "");
                return;
            }
            c.a.p0.b2.p.c cVar = this.p;
            if (cVar != null) {
                c.a.p0.b2.d dVar2 = this.j;
                c.a.p0.b2.p.e eVar2 = this.m;
                dVar2.a(cVar.b() + 1, eVar2.a, eVar2.f12571b, this.p.f());
            }
        }
    }

    public boolean p(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, str)) == null) {
            c.a.p0.b2.p.e eVar = this.m;
            return eVar != null && j == eVar.a && TextUtils.equals(str, eVar.f12571b);
        }
        return invokeJL.booleanValue;
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f34179b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f34179b.getChildCount(); i2++) {
            View childAt = this.f34179b.getChildAt(i2);
            if (childAt instanceof c.a.p0.b2.o.l.e) {
                if (z) {
                    ((c.a.p0.b2.o.l.e) childAt).g();
                } else {
                    ((c.a.p0.b2.o.l.e) childAt).h();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f34179b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f34179b.getChildCount(); i2++) {
            View childAt = this.f34179b.getChildAt(i2);
            if (childAt instanceof c.a.p0.b2.o.l.e) {
                ((c.a.p0.b2.o.l.e) childAt).f();
            }
        }
        m mVar = this.q;
        if (mVar != null) {
            mVar.j(this.s, this.t, this.u, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            c.a.o0.w0.a.a(this.n, this);
            SkinManager.setBackgroundColor(this.f34179b, R.color.CAM_X0204, i2);
            c.a.p0.b2.n.a aVar = this.f34181d;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            c.a.o0.r.l0.g gVar = this.a;
            if (gVar != null) {
                gVar.H(i2);
            }
            PbListView pbListView = this.f34180c;
            if (pbListView != null) {
                pbListView.d(i2);
            }
        }
    }

    public void setCallback(c.a.p0.b2.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || (bdListView = this.f34179b) == null) {
            return;
        }
        bdListView.setFriction(f2);
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void setScrollCallback(c.a.p0.b2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.l = gVar;
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
            m mVar = this.q;
            if (mVar != null) {
                mVar.n(true);
                this.q.k(this.s, this.t, this.u, true);
            }
            if (this.f34184g || this.f34183f) {
                return;
            }
            if (this.f34182e && !n.C()) {
                if (this.f34181d.isEmpty()) {
                    this.f34181d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c15), null, null);
                    this.f34181d.notifyDataSetChanged();
                }
            } else if (this.v) {
                this.v = false;
                c.a.d.f.m.e.a().postDelayed(new e(this), 200L);
            } else {
                w();
            }
        }
    }

    public void t() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (mVar = this.q) == null) {
            return;
        }
        mVar.c();
    }

    public void u(c.a.p0.b2.p.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, cVar, z) == null) {
            BdListView bdListView = this.f34179b;
            if (bdListView != null) {
                bdListView.z();
            }
            PbListView pbListView = this.f34180c;
            if (pbListView != null) {
                pbListView.f();
            }
            if (cVar == null) {
                setHasMore(false);
                l(this);
                this.f34181d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0938), null, null);
                this.f34181d.notifyDataSetChanged();
                return;
            }
            this.p = cVar;
            this.i = false;
            this.f34183f = cVar.m();
            this.f34182e = cVar.l();
            this.f34184g = cVar.n();
            this.m = cVar.h();
            setHasMore(cVar.hasMore());
            List<ICardInfo> d2 = cVar.d();
            if (this.f34181d != null) {
                if (d2 != null && d2.size() > 0) {
                    PbListView pbListView2 = this.f34180c;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.f34179b.setNextPage(this.f34180c);
                        }
                        if (this.f34185h) {
                            this.f34180c.D(getContext().getString(R.string.obfuscated_res_0x7f0f0da7));
                        } else if (d2.get(d2.size() - 1) instanceof WebViewCard) {
                            this.f34180c.D("");
                        } else {
                            this.f34180c.D(getContext().getString(R.string.obfuscated_res_0x7f0f09e8));
                        }
                    }
                } else {
                    if (this.f34182e && this.f34183f) {
                        this.f34181d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0938), null, null);
                    } else {
                        this.f34181d.F(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.f34181d.C(d2);
            }
            if (z) {
                this.f34179b.setSelection(cVar.g());
            }
            if (this.f34183f || !(d2 == null || d2.isEmpty())) {
                l(this);
            }
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        c.a.o0.r.l0.g gVar = this.a;
        if (gVar != null) {
            gVar.a0(bdUniqueId);
        }
        this.z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.z);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x(this, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
            y();
        }
    }

    public final void x(View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.k == null) {
                if (i2 < 0) {
                    this.k = new c.a.o0.f0.g(getContext());
                } else {
                    this.k = new c.a.o0.f0.g(getContext(), i2);
                }
                this.k.onChangeSkinType();
            }
            this.k.attachView(view, z);
            c.a.o0.r.l0.g gVar = this.a;
            if (gVar != null) {
                gVar.A(false);
            }
            c.a.p0.b2.n.a aVar = this.f34181d;
            if (aVar != null) {
                aVar.G(false);
                this.f34181d.notifyDataSetChanged();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.f34182e) {
                c.a.p0.b2.d dVar = this.j;
                c.a.p0.b2.p.e eVar = this.m;
                dVar.a(1, eVar.a, eVar.f12571b, "");
                return;
            }
            c.a.p0.b2.d dVar2 = this.j;
            c.a.p0.b2.p.e eVar2 = this.m;
            dVar2.b(eVar2.a, eVar2.f12571b);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.f34179b;
            if (bdListView != null) {
                bdListView.z();
            }
            this.i = false;
            PbListView pbListView = this.f34180c;
            if (pbListView != null) {
                pbListView.f();
            }
            if (this.f34181d.getCount() <= 0 && this.f34182e) {
                this.f34181d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.c(str), null, null);
                this.f34181d.C(new ArrayList());
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
        this.s = 0;
        this.t = 0;
        this.v = false;
        this.w = new a(this, 2001115);
        this.x = new b(this, 2001335);
        this.y = new c(this, 2001336);
        this.z = new d(this, 2016448);
        this.A = new f(this);
        this.B = new g(this);
        m(context, z);
    }
}
