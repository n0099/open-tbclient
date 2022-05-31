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
import com.repackage.b9;
import com.repackage.ba7;
import com.repackage.ea7;
import com.repackage.f9;
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.li;
import com.repackage.mb7;
import com.repackage.mg;
import com.repackage.pa7;
import com.repackage.pb7;
import com.repackage.q85;
import com.repackage.s35;
import com.repackage.sb7;
import com.repackage.tb7;
import com.repackage.vb7;
import com.repackage.x16;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x16.b A;
    public View.OnTouchListener B;
    public gt4 a;
    public BdListView b;
    public PbListView c;
    public pa7 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public ba7 j;
    public s35 k;
    public ea7 l;
    public vb7 m;
    public TbPageContext<?> n;
    public int o;
    public tb7 p;
    public pb7 q;
    public x16 r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                sb7 sb7Var = new sb7();
                sb7Var.a = String.valueOf(customResponsedMessage.getData());
                sb7Var.b = true;
                this.a.k(sb7Var);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                sb7 sb7Var = new sb7();
                sb7Var.a = String.valueOf(customResponsedMessage.getData());
                sb7Var.b = false;
                this.a.k(sb7Var);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class f implements x16.b {
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

        @Override // com.repackage.x16.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.u = false;
                LegoListView legoListView = this.a;
                legoListView.d.H(legoListView.u);
            }
        }

        @Override // com.repackage.x16.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.u = true;
                LegoListView legoListView = this.a;
                legoListView.d.H(legoListView.u);
            }
        }

        @Override // com.repackage.x16.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.x16.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class i implements ft4.g {
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

        @Override // com.repackage.ft4.g
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
            this.h = z;
            if (this.b == null || (pbListView = this.c) == null) {
                return;
            }
            if (!this.e) {
                pbListView.C("");
            } else if (z) {
                pbListView.C(getContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
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

    public pb7 getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.q : (pb7) invokeV.objValue;
    }

    public final void k(Object obj) {
        tb7 tb7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) || this.d == null || (tb7Var = this.p) == null || tb7Var.d() == null) {
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
            s35 s35Var = this.k;
            if (s35Var != null) {
                s35Var.dettachView(view2);
                this.k = null;
            }
            gt4 gt4Var = this.a;
            if (gt4Var != null) {
                gt4Var.A(true);
            }
            pa7 pa7Var = this.d;
            if (pa7Var != null) {
                pa7Var.G(true);
                this.d.notifyDataSetChanged();
            }
        }
    }

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            b9<?> a2 = f9.a(context);
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
            pa7 pa7Var = new pa7(this.n);
            this.d = pa7Var;
            this.b.setAdapter((ListAdapter) pa7Var);
            this.o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023f);
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            gt4 gt4Var = new gt4(this.n);
            this.a = gt4Var;
            this.b.setPullRefresh(gt4Var);
            PbListView pbListView = new PbListView(context);
            this.c = pbListView;
            pbListView.a();
            this.c.p(R.color.CAM_X0204);
            this.c.E(SkinManager.getColor(R.color.CAM_X0109));
            this.c.d(TbadkCoreApplication.getInst().getSkinType());
            this.a.e(new i(this, null));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q = new pb7(this.n, this.b);
            x16 x16Var = new x16();
            this.r = x16Var;
            x16Var.d(this.A);
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
        vb7 vb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            ea7 ea7Var = this.l;
            if (ea7Var != null && (vb7Var = this.m) != null) {
                ea7Var.a(vb7Var, this.b.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.h && li.D() && !this.i) {
            this.i = true;
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.Q();
            }
            ba7 ba7Var = this.j;
            if (ba7Var == null) {
                return;
            }
            if (this.d == null) {
                vb7 vb7Var = this.m;
                ba7Var.a(1, vb7Var.a, vb7Var.b, "");
                return;
            }
            tb7 tb7Var = this.p;
            if (tb7Var != null) {
                ba7 ba7Var2 = this.j;
                vb7 vb7Var2 = this.m;
                ba7Var2.a(tb7Var.b() + 1, vb7Var2.a, vb7Var2.b, this.p.f());
            }
        }
    }

    public boolean p(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, str)) == null) {
            vb7 vb7Var = this.m;
            return vb7Var != null && j == vb7Var.a && TextUtils.equals(str, vb7Var.b);
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
            if (childAt instanceof mb7) {
                if (z) {
                    ((mb7) childAt).g();
                } else {
                    ((mb7) childAt).h();
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
            if (childAt instanceof mb7) {
                ((mb7) childAt).f();
            }
        }
        pb7 pb7Var = this.q;
        if (pb7Var != null) {
            pb7Var.j(this.s, this.t, this.u, 1);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            q85.a(this.n, this);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204, i2);
            pa7 pa7Var = this.d;
            if (pa7Var != null) {
                pa7Var.notifyDataSetChanged();
            }
            gt4 gt4Var = this.a;
            if (gt4Var != null) {
                gt4Var.H(i2);
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.d(i2);
            }
        }
    }

    public void setCallback(ba7 ba7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ba7Var) == null) {
            this.j = ba7Var;
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

    public void setScrollCallback(ea7 ea7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, ea7Var) == null) {
            this.l = ea7Var;
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
            pb7 pb7Var = this.q;
            if (pb7Var != null) {
                pb7Var.n(true);
                this.q.k(this.s, this.t, this.u, true);
            }
            if (this.g || this.f) {
                return;
            }
            if (this.e && !li.D()) {
                if (this.d.isEmpty()) {
                    this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c33), null, null);
                    this.d.notifyDataSetChanged();
                }
            } else if (this.v) {
                this.v = false;
                mg.a().postDelayed(new e(this), 200L);
            } else {
                w();
            }
        }
    }

    public void t() {
        pb7 pb7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (pb7Var = this.q) == null) {
            return;
        }
        pb7Var.c();
    }

    public void u(tb7 tb7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, tb7Var, z) == null) {
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.z();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.f();
            }
            if (tb7Var == null) {
                setHasMore(false);
                l(this);
                this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0942), null, null);
                this.d.notifyDataSetChanged();
                return;
            }
            this.p = tb7Var;
            this.i = false;
            this.f = tb7Var.m();
            this.e = tb7Var.l();
            this.g = tb7Var.n();
            this.m = tb7Var.h();
            setHasMore(tb7Var.hasMore());
            List<ICardInfo> d2 = tb7Var.d();
            if (this.d != null) {
                if (d2 != null && d2.size() > 0) {
                    PbListView pbListView2 = this.c;
                    if (pbListView2 != null) {
                        if (pbListView2.b().getParent() == null) {
                            this.b.setNextPage(this.c);
                        }
                        if (this.h) {
                            this.c.C(getContext().getString(R.string.obfuscated_res_0x7f0f0dc7));
                        } else if (d2.get(d2.size() - 1) instanceof WebViewCard) {
                            this.c.C("");
                        } else {
                            this.c.C(getContext().getString(R.string.obfuscated_res_0x7f0f09f5));
                        }
                    }
                } else {
                    if (this.e && this.f) {
                        this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0942), null, null);
                    } else {
                        this.d.F(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.d.C(d2);
            }
            if (z) {
                this.b.setSelection(tb7Var.g());
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
        gt4 gt4Var = this.a;
        if (gt4Var != null) {
            gt4Var.a0(bdUniqueId);
        }
        this.z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.z);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x(this, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07029c));
            y();
        }
    }

    public final void x(View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.k == null) {
                if (i2 < 0) {
                    this.k = new s35(getContext());
                } else {
                    this.k = new s35(getContext(), i2);
                }
                this.k.onChangeSkinType();
            }
            this.k.attachView(view2, z);
            gt4 gt4Var = this.a;
            if (gt4Var != null) {
                gt4Var.A(false);
            }
            pa7 pa7Var = this.d;
            if (pa7Var != null) {
                pa7Var.G(false);
                this.d.notifyDataSetChanged();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.e) {
                ba7 ba7Var = this.j;
                vb7 vb7Var = this.m;
                ba7Var.a(1, vb7Var.a, vb7Var.b, "");
                return;
            }
            ba7 ba7Var2 = this.j;
            vb7 vb7Var2 = this.m;
            ba7Var2.b(vb7Var2.a, vb7Var2.b);
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
