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
import com.baidu.tieba.cp5;
import com.baidu.tieba.g9;
import com.baidu.tieba.hj8;
import com.baidu.tieba.ki8;
import com.baidu.tieba.kj8;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.model.WebViewCard;
import com.baidu.tieba.m9;
import com.baidu.tieba.nj8;
import com.baidu.tieba.oj8;
import com.baidu.tieba.qj8;
import com.baidu.tieba.ri;
import com.baidu.tieba.ri5;
import com.baidu.tieba.sg;
import com.baidu.tieba.ur6;
import com.baidu.tieba.wh8;
import com.baidu.tieba.y65;
import com.baidu.tieba.z65;
import com.baidu.tieba.zh8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class LegoListView extends FrameLayout implements BdListView.p, AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ur6.b A;
    public View.OnTouchListener B;
    public z65 a;
    public BdListView b;
    public PbListView c;
    public ki8 d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public wh8 j;
    public ri5 k;
    public zh8 l;
    public qj8 m;
    public TbPageContext<?> n;
    public int o;
    public oj8 p;
    public kj8 q;
    public ur6 r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    public void setImmersive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.k(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
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
                nj8 nj8Var = new nj8();
                nj8Var.a = String.valueOf(customResponsedMessage.getData());
                nj8Var.b = true;
                this.a.k(nj8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                nj8 nj8Var = new nj8();
                nj8Var.a = String.valueOf(customResponsedMessage.getData());
                nj8Var.b = false;
                this.a.k(nj8Var);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.v = true;
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.w();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ur6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoListView a;

        @Override // com.baidu.tieba.ur6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ur6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

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

        @Override // com.baidu.tieba.ur6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.u = false;
            LegoListView legoListView = this.a;
            legoListView.d.H(legoListView.u);
        }

        @Override // com.baidu.tieba.ur6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) {
                return;
            }
            this.a.u = true;
            LegoListView legoListView = this.a;
            legoListView.d.H(legoListView.u);
        }
    }

    /* loaded from: classes6.dex */
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
                if (view2 == this.a.b && this.a.r != null) {
                    this.a.r.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null) {
                this.a.q.h(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements y65.g {
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

        @Override // com.baidu.tieba.y65.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.a.j == null) {
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
            if (this.b != null && (pbListView = this.c) != null) {
                if (!this.e) {
                    pbListView.F("");
                } else if (z) {
                    pbListView.F(getContext().getString(R.string.pb_load_more));
                } else {
                    pbListView.F("");
                }
            }
        }
    }

    public final void k(Object obj) {
        oj8 oj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && this.d != null && (oj8Var = this.p) != null && oj8Var.c() != null) {
            boolean z = false;
            for (ICardInfo iCardInfo : this.p.c()) {
                if (iCardInfo.responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                this.d.notifyDataSetChanged();
            }
        }
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            View childAt = this.b.getChildAt(i2);
            if (childAt instanceof hj8) {
                if (z) {
                    ((hj8) childAt).e();
                } else {
                    ((hj8) childAt).h();
                }
            }
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

    public final void m(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            g9<?> a2 = m9.a(context);
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
            ki8 ki8Var = new ki8(this.n);
            this.d = ki8Var;
            this.b.setAdapter((ListAdapter) ki8Var);
            this.o = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070353);
            s(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean p(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048586, this, j, str)) == null) {
            qj8 qj8Var = this.m;
            if (qj8Var != null && j == qj8Var.a && TextUtils.equals(str, qj8Var.b)) {
                return true;
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    public final void l(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            ri5 ri5Var = this.k;
            if (ri5Var != null) {
                ri5Var.dettachView(view2);
                this.k = null;
            }
            z65 z65Var = this.a;
            if (z65Var != null) {
                z65Var.A(true);
            }
            ki8 ki8Var = this.d;
            if (ki8Var != null) {
                ki8Var.G(true);
                this.d.notifyDataSetChanged();
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            cp5.a(this.n, this);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204, i2);
            ki8 ki8Var = this.d;
            if (ki8Var != null) {
                ki8Var.notifyDataSetChanged();
            }
            z65 z65Var = this.a;
            if (z65Var != null) {
                z65Var.H(i2);
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.e(i2);
            }
        }
    }

    public void setCallback(wh8 wh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, wh8Var) == null) {
            this.j = wh8Var;
        }
    }

    public void setFriction(float f2) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048591, this, f2) == null) && (bdListView = this.b) != null) {
            bdListView.setFriction(f2);
        }
    }

    public void setScrollCallback(zh8 zh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, zh8Var) == null) {
            this.l = zh8Var;
        }
    }

    public void v(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        z65 z65Var = this.a;
        if (z65Var != null) {
            z65Var.a0(bdUniqueId);
        }
        this.z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.z);
    }

    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (BdListView) invokeV.objValue;
    }

    public kj8 getPlaySwitchController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return (kj8) invokeV.objValue;
    }

    public void setViewBackGround() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            q(true);
        }
    }

    public void t() {
        kj8 kj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (kj8Var = this.q) != null) {
            kj8Var.c();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            x(this, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
            y();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.e) {
                wh8 wh8Var = this.j;
                qj8 qj8Var = this.m;
                wh8Var.a(1, qj8Var.a, qj8Var.b, "");
                return;
            }
            wh8 wh8Var2 = this.j;
            qj8 qj8Var2 = this.m;
            wh8Var2.b(qj8Var2.a, qj8Var2.b);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            z65 z65Var = new z65(this.n);
            this.a = z65Var;
            this.b.setPullRefresh(z65Var);
            PbListView pbListView = new PbListView(context);
            this.c = pbListView;
            pbListView.a();
            this.c.r(R.color.CAM_X0204);
            this.c.H(SkinManager.getColor(R.color.CAM_X0109));
            this.c.e(TbadkCoreApplication.getInst().getSkinType());
            this.a.f(new i(this, null));
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.y();
            }
            this.i = false;
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.g();
            }
            if (this.d.getCount() <= 0 && this.e) {
                this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.c(str), null, null);
                this.d.C(new ArrayList());
            }
            l(this);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.q = new kj8(this.n, this.b);
            ur6 ur6Var = new ur6();
            this.r = ur6Var;
            ur6Var.d(this.A);
            this.b.setOnTouchListener(this.B);
            this.b.setRecyclerListener(new h(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
            View childAt = this.b.getChildAt(i2);
            if (childAt instanceof hj8) {
                ((hj8) childAt).d();
            }
        }
        kj8 kj8Var = this.q;
        if (kj8Var != null) {
            kj8Var.j(this.s, this.t, this.u, 1);
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
        qj8 qj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, absListView, i2) == null) && i2 == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            zh8 zh8Var = this.l;
            if (zh8Var != null && (qj8Var = this.m) != null) {
                zh8Var.a(qj8Var, this.b.getFirstVisiblePosition());
            }
            r();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.h && ri.F() && !this.i) {
            this.i = true;
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.S();
            }
            wh8 wh8Var = this.j;
            if (wh8Var == null) {
                return;
            }
            if (this.d == null) {
                qj8 qj8Var = this.m;
                wh8Var.a(1, qj8Var.a, qj8Var.b, "");
                return;
            }
            oj8 oj8Var = this.p;
            if (oj8Var != null) {
                wh8 wh8Var2 = this.j;
                qj8 qj8Var2 = this.m;
                wh8Var2.a(oj8Var.a() + 1, qj8Var2.a, qj8Var2.b, this.p.f());
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q(false);
            kj8 kj8Var = this.q;
            if (kj8Var != null) {
                kj8Var.n(true);
                this.q.k(this.s, this.t, this.u, true);
            }
            if (this.g || this.f) {
                return;
            }
            if (this.e && !ri.F()) {
                if (this.d.isEmpty()) {
                    this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0db6), null, null);
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

    public void u(oj8 oj8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, oj8Var, z) == null) {
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.y();
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.g();
            }
            if (oj8Var == null) {
                setHasMore(false);
                l(this);
                this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                this.d.notifyDataSetChanged();
                return;
            }
            this.p = oj8Var;
            this.i = false;
            this.f = oj8Var.m();
            this.e = oj8Var.l();
            this.g = oj8Var.n();
            this.m = oj8Var.h();
            setHasMore(oj8Var.hasMore());
            List<ICardInfo> c2 = oj8Var.c();
            if (this.d != null) {
                if (c2 != null && c2.size() > 0) {
                    PbListView pbListView2 = this.c;
                    if (pbListView2 != null) {
                        if (pbListView2.c().getParent() == null) {
                            this.b.setNextPage(this.c);
                        }
                        if (this.h) {
                            this.c.F(getContext().getString(R.string.pb_load_more));
                        } else if (c2.get(c2.size() - 1) instanceof WebViewCard) {
                            this.c.F("");
                        } else {
                            this.c.F(getContext().getString(R.string.list_no_more));
                        }
                    }
                } else {
                    if (this.e && this.f) {
                        this.d.F(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, this.o), NoDataViewFactory.e.a(R.string.invite_friend_no_data_now), null, null);
                    } else {
                        this.d.F(null, null, null, null);
                    }
                    setHasMore(false);
                }
                this.d.C(c2);
            }
            if (z) {
                this.b.setSelection(oj8Var.g());
            }
            if (this.f || (c2 != null && !c2.isEmpty())) {
                l(this);
            }
        }
    }

    public final void x(View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (this.k == null) {
                if (i2 < 0) {
                    this.k = new ri5(getContext());
                } else {
                    this.k = new ri5(getContext(), i2);
                }
                this.k.onChangeSkinType();
            }
            this.k.attachView(view2, z);
            z65 z65Var = this.a;
            if (z65Var != null) {
                z65Var.A(false);
            }
            ki8 ki8Var = this.d;
            if (ki8Var != null) {
                ki8Var.G(false);
                this.d.notifyDataSetChanged();
            }
        }
    }
}
