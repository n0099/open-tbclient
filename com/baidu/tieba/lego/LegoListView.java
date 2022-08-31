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
import com.baidu.tieba.bv4;
import com.baidu.tieba.cv4;
import com.baidu.tieba.d9;
import com.baidu.tieba.ee7;
import com.baidu.tieba.he7;
import com.baidu.tieba.i9;
import com.baidu.tieba.k65;
import com.baidu.tieba.kb5;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.tieba.pf7;
import com.baidu.tieba.ri;
import com.baidu.tieba.se7;
import com.baidu.tieba.sf7;
import com.baidu.tieba.sg;
import com.baidu.tieba.t56;
import com.baidu.tieba.vf7;
import com.baidu.tieba.wf7;
import com.baidu.tieba.yf7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t56.b A;
    public View.OnTouchListener B;
    public cv4 a;
    public BdListView b;
    public PbListView c;
    public se7 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ee7 j;
    public k65 k;
    public he7 l;
    public yf7 m;
    public TbPageContext<?> n;
    public int o;
    public wf7 p;
    public sf7 q;
    public t56 r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                vf7 vf7Var = new vf7();
                vf7Var.a = String.valueOf(customResponsedMessage.getData());
                vf7Var.b = true;
                this.a.k(vf7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                vf7 vf7Var = new vf7();
                vf7Var.a = String.valueOf(customResponsedMessage.getData());
                vf7Var.b = false;
                this.a.k(vf7Var);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class f implements t56.b {
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

        @Override // com.baidu.tieba.t56.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.u = false;
                LegoListView legoListView = this.a;
                legoListView.d.H(legoListView.u);
            }
        }

        @Override // com.baidu.tieba.t56.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.u = true;
                LegoListView legoListView = this.a;
                legoListView.d.H(legoListView.u);
            }
        }

        @Override // com.baidu.tieba.t56.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.t56.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (view2 != this.a.b || this.a.r == null) {
                    return false;
                }
                this.a.r.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
        public void onMovedToScrapHeap(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.q == null) {
                return;
            }
            this.a.q.h(view2);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements bv4.g {
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

        @Override // com.baidu.tieba.bv4.g
        public void e(boolean z) {
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
            this.h = z;
            if (this.b == null || (pbListView = this.c) == null) {
                return;
            }
            if (!this.e) {
                pbListView.C("");
            } else if (z) {
                pbListView.C(getContext().getString(R.string.obfuscated_res_0x7f0f0dda));
            } else {
                pbListView.C("");
            }
        }
    }

    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (BdListView) invokeV.objValue;
    }

    public sf7 getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : (sf7) invokeV.objValue;
    }

    public final void k(Object obj) {
        wf7 wf7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.d == null || (wf7Var = this.p) == null || wf7Var.d() == null) {
            return;
        }
        boolean z = false;
        for (ICardInfo iCardInfo : this.p.d()) {
            if (iCardInfo.responseAttention(obj)) {
                z = true;
            }
        }
        if (z) {
            this.d.notifyDataSetChanged();
        }
    }

    public final void l(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            k65 k65Var = this.k;
            if (k65Var != null) {
                k65Var.dettachView(view2);
                this.k = null;
            }
            cv4 cv4Var = this.a;
            if (cv4Var != null) {
                cv4Var.A(true);
            }
            se7 se7Var = this.d;
            if (se7Var != null) {
                se7Var.G(true);
                this.d.notifyDataSetChanged();
            }
        }
    }

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            d9<?> a2 = i9.a(context);
            a2.registerListener(this.w);
            a2.registerListener(this.x);
            a2.registerListener(this.y);
            if (a2 instanceof TbPageContext) {
                this.n = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.b = bdListView;
            bdListView.setDividerHeight(0);
            this.b.setSelector(17170445);
            addView(this.b);
            if (!z) {
                this.b.setVerticalScrollBarEnabled(true);
                n(context);
            } else {
                this.b.setTranscriptMode(1);
                this.b.setVerticalScrollBarEnabled(false);
            }
            this.b.setOnSrollToBottomListener(this);
            this.b.setOnScrollListener(this);
            o();
            se7 se7Var = new se7(this.n);
            this.d = se7Var;
            this.b.setAdapter((ListAdapter) se7Var);
            this.o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023c);
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            cv4 cv4Var = new cv4(this.n);
            this.a = cv4Var;
            this.b.setPullRefresh(cv4Var);
            PbListView pbListView = new PbListView(context);
            this.c = pbListView;
            pbListView.a();
            this.c.p(R.color.CAM_X0204);
            this.c.E(SkinManager.getColor(R.color.CAM_X0109));
            this.c.d(TbadkCoreApplication.getInst().getSkinType());
            this.a.f(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q = new sf7(this.n, this.b);
            t56 t56Var = new t56();
            this.r = t56Var;
            t56Var.d(this.A);
            this.b.setOnTouchListener(this.B);
            this.b.setRecyclerListener(new h(this));
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
        yf7 yf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            he7 he7Var = this.l;
            if (he7Var != null && (yf7Var = this.m) != null) {
                he7Var.a(yf7Var, this.b.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.h && ri.D() && !this.i) {
            this.i = true;
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.Q();
            }
            ee7 ee7Var = this.j;
            if (ee7Var == null) {
                return;
            }
            if (this.d == null) {
                yf7 yf7Var = this.m;
                ee7Var.a(1, yf7Var.a, yf7Var.b, "");
                return;
            }
            wf7 wf7Var = this.p;
            if (wf7Var != null) {
                ee7 ee7Var2 = this.j;
                yf7 yf7Var2 = this.m;
                ee7Var2.a(wf7Var.b() + 1, yf7Var2.a, yf7Var2.b, this.p.f());
            }
        }
    }

    public boolean p(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, str)) == null) {
            yf7 yf7Var = this.m;
            return yf7Var != null && j == yf7Var.a && TextUtils.equals(str, yf7Var.b);
        }
        return invokeJL.booleanValue;
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            View childAt = this.b.getChildAt(i2);
            if (childAt instanceof pf7) {
                if (z) {
                    ((pf7) childAt).d();
                } else {
                    ((pf7) childAt).h();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            View childAt = this.b.getChildAt(i2);
            if (childAt instanceof pf7) {
                ((pf7) childAt).g();
            }
        }
        sf7 sf7Var = this.q;
        if (sf7Var != null) {
            sf7Var.j(this.s, this.t, this.u, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            kb5.a(this.n, this);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204, i2);
            se7 se7Var = this.d;
            if (se7Var != null) {
                se7Var.notifyDataSetChanged();
            }
            cv4 cv4Var = this.a;
            if (cv4Var != null) {
                cv4Var.H(i2);
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.d(i2);
            }
        }
    }

    public void setCallback(ee7 ee7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ee7Var) == null) {
            this.j = ee7Var;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || (bdListView = this.b) == null) {
            return;
        }
        bdListView.setFriction(f2);
    }

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void setScrollCallback(he7 he7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, he7Var) == null) {
            this.l = he7Var;
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
            sf7 sf7Var = this.q;
            if (sf7Var != null) {
                sf7Var.n(true);
                this.q.k(this.s, this.t, this.u, true);
            }
            if (this.g || this.f) {
                return;
            }
            if (this.e && !ri.D()) {
                if (this.d.isEmpty()) {
                    this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c40), null, null);
                    this.d.notifyDataSetChanged();
                }
            } else if (this.v) {
                this.v = false;
                sg.a().postDelayed(new e(this), 200L);
            } else {
                w();
            }
        }
    }

    public void t() {
        sf7 sf7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (sf7Var = this.q) == null) {
            return;
        }
        sf7Var.c();
    }

    public void u(wf7 wf7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, wf7Var, z) == null) {
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.z();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.f();
            }
            if (wf7Var == null) {
                setHasMore(false);
                l(this);
                this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0958), null, null);
                this.d.notifyDataSetChanged();
                return;
            }
            this.p = wf7Var;
            this.i = false;
            this.f = wf7Var.m();
            this.e = wf7Var.l();
            this.g = wf7Var.n();
            this.m = wf7Var.h();
            setHasMore(wf7Var.hasMore());
            List<ICardInfo> d2 = wf7Var.d();
            if (this.d != null) {
                if (d2 != null && d2.size() > 0) {
                    PbListView pbListView2 = this.c;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.b.setNextPage(this.c);
                        }
                        if (this.h) {
                            this.c.C(getContext().getString(R.string.obfuscated_res_0x7f0f0dda));
                        } else if (d2.get(d2.size() - 1) instanceof WebViewCard) {
                            this.c.C("");
                        } else {
                            this.c.C(getContext().getString(R.string.obfuscated_res_0x7f0f09ee));
                        }
                    }
                } else {
                    if (this.e && this.f) {
                        this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0958), null, null);
                    } else {
                        this.d.F(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.d.C(d2);
            }
            if (z) {
                this.b.setSelection(wf7Var.g());
            }
            if (this.f || !(d2 == null || d2.isEmpty())) {
                l(this);
            }
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        cv4 cv4Var = this.a;
        if (cv4Var != null) {
            cv4Var.b0(bdUniqueId);
        }
        this.z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.z);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x(this, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070299));
            y();
        }
    }

    public final void x(View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.k == null) {
                if (i2 < 0) {
                    this.k = new k65(getContext());
                } else {
                    this.k = new k65(getContext(), i2);
                }
                this.k.onChangeSkinType();
            }
            this.k.attachView(view2, z);
            cv4 cv4Var = this.a;
            if (cv4Var != null) {
                cv4Var.A(false);
            }
            se7 se7Var = this.d;
            if (se7Var != null) {
                se7Var.G(false);
                this.d.notifyDataSetChanged();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.e) {
                ee7 ee7Var = this.j;
                yf7 yf7Var = this.m;
                ee7Var.a(1, yf7Var.a, yf7Var.b, "");
                return;
            }
            ee7 ee7Var2 = this.j;
            yf7 yf7Var2 = this.m;
            ee7Var2.b(yf7Var2.a, yf7Var2.b);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.z();
            }
            this.i = false;
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.f();
            }
            if (this.d.getCount() <= 0 && this.e) {
                this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.c(str), null, null);
                this.d.C(new ArrayList());
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
