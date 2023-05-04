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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.eg8;
import com.baidu.tieba.g9;
import com.baidu.tieba.ih5;
import com.baidu.tieba.jh5;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lh8;
import com.baidu.tieba.og8;
import com.baidu.tieba.p55;
import com.baidu.tieba.q55;
import com.baidu.tieba.rh8;
import com.baidu.tieba.th8;
import com.baidu.tieba.uh8;
import com.baidu.tieba.zf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class LegoHotPageView extends FrameLayout implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uh8 a;
    public q55 b;
    public PbListView c;
    public BdListView d;
    public og8 e;
    public TbPageContext<?> f;
    public zf8 g;
    public eg8 h;
    public ih5 i;
    public jh5 j;
    public long k;
    public String l;
    public boolean m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public eg8.c q;

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048579, this, absListView, i, i2, i3) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoHotPageView legoHotPageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i)};
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
            this.a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) == null || updateAttentionMessage.getData() == null || !updateAttentionMessage.getData().a) {
                return;
            }
            this.a.p(updateAttentionMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LegoHotPageView legoHotPageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i)};
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
            this.a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                rh8 rh8Var = new rh8();
                rh8Var.a = String.valueOf(customResponsedMessage.getData());
                rh8Var.b = true;
                this.a.p(rh8Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LegoHotPageView legoHotPageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView, Integer.valueOf(i)};
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
            this.a = legoHotPageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                rh8 rh8Var = new rh8();
                rh8Var.a = String.valueOf(customResponsedMessage.getData());
                rh8Var.b = false;
                this.a.p(rh8Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements eg8.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoHotPageView;
        }

        @Override // com.baidu.tieba.eg8.c
        public void a(List<th8> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && this.a.g != null) {
                this.a.g.a(list);
            }
        }

        @Override // com.baidu.tieba.eg8.c
        public void b(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, str) != null) {
                return;
            }
            boolean t = this.a.t();
            this.a.r();
            if (t) {
                LegoHotPageView legoHotPageView = this.a;
                legoHotPageView.x(true, legoHotPageView.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ab));
            }
            if (this.a.g != null) {
                this.a.g.c(j, str);
            }
        }

        @Override // com.baidu.tieba.eg8.c
        public void c(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) && this.a.g != null && this.a.a != null) {
                this.a.g.e(this.a.a.a, this.a.a.b, i, str);
            }
        }

        @Override // com.baidu.tieba.eg8.c
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048580, this, i, str) != null) {
                return;
            }
            this.a.q();
            if (i == 1) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.f.showToast(str);
                    return;
                }
                return;
            }
            this.a.d.setVisibility(8);
            LegoHotPageView legoHotPageView = this.a;
            legoHotPageView.y(legoHotPageView, str, true);
        }

        @Override // com.baidu.tieba.eg8.c
        public void d(String str, String str2, String str3, List<uh8> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, list) == null) && this.a.g != null) {
                this.a.g.d(str, str2, str3, list);
            }
        }

        @Override // com.baidu.tieba.eg8.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
                return;
            }
            this.a.q();
            this.a.r();
            this.a.d.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements p55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

        public e(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoHotPageView;
        }

        @Override // com.baidu.tieba.p55.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.h.update(this.a.k, this.a.l);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

        public f(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoHotPageView;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.m) {
                if (this.a.c != null) {
                    this.a.c.S();
                }
                this.a.h.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoHotPageView a;

        public g(LegoHotPageView legoHotPageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoHotPageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = legoHotPageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.h == null) {
                return;
            }
            if (this.a.a != null) {
                this.a.h.update(this.a.a.a, this.a.a.b);
            } else {
                this.a.h.update(this.a.k, this.a.l);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this, 2001115);
        this.o = new b(this, 2001335);
        this.p = new c(this, 2001336);
        this.q = new d(this);
        s(context);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new a(this, 2001115);
        this.o = new b(this, 2001335);
        this.p = new c(this, 2001336);
        this.q = new d(this);
        s(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoHotPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = new a(this, 2001115);
        this.o = new b(this, 2001335);
        this.p = new c(this, 2001336);
        this.q = new d(this);
        s(context);
    }

    public void A(DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, dataRes, z) == null) {
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.g();
            }
            this.h.i(z, dataRes, 0, null);
            setHasMore(this.h.c());
        }
    }

    public void B(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.g();
            }
            this.h.i(true, null, i, str);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, absListView, i) == null) && i == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, -1));
            v();
        }
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048596, this, j, str) == null) {
            this.k = j;
            this.l = str;
            eg8 eg8Var = this.h;
            if (eg8Var != null) {
                eg8Var.update(j, str);
            }
        }
    }

    public void setCallback(zf8 zf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zf8Var) == null) {
            this.g = zf8Var;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        q55 q55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) && (q55Var = this.b) != null) {
            q55Var.a0(bdUniqueId);
        }
    }

    public void setTagInfo(uh8 uh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, uh8Var) == null) {
            this.a = uh8Var;
        }
    }

    private void setHasMore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            this.m = z;
            if (this.d == null) {
                return;
            }
            if (this.c.c().getParent() == null) {
                this.d.setNextPage(this.c);
            }
            if (this.m) {
                this.c.F(getContext().getString(R.string.pb_load_more));
            } else {
                this.c.F("");
            }
        }
    }

    public final void p(Object obj) {
        eg8 eg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && this.e != null && (eg8Var = this.h) != null && eg8Var.b() != null) {
            boolean z = false;
            for (ICardInfo iCardInfo : this.h.b()) {
                if (iCardInfo.responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                this.e.notifyDataSetChanged();
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048591, this, z) != null) || this.d == null) {
            return;
        }
        for (int i = 0; i < this.d.getChildCount(); i++) {
            View childAt = this.d.getChildAt(i);
            if (childAt instanceof lh8) {
                if (z) {
                    ((lh8) childAt).f();
                } else {
                    ((lh8) childAt).h();
                }
            }
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            ih5 ih5Var = this.i;
            if (ih5Var != null) {
                ih5Var.onChangeSkinType();
            }
            jh5 jh5Var = this.j;
            if (jh5Var != null) {
                jh5Var.onChangeSkinType();
            }
            q55 q55Var = this.b;
            if (q55Var != null) {
                q55Var.H(i);
            }
            BdListView bdListView = this.d;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0204, i);
            }
            PbListView pbListView = this.c;
            if (pbListView != null) {
                pbListView.H(SkinManager.getColor(R.color.CAM_X0109));
                this.c.e(i);
            }
        }
    }

    public long getTagCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            uh8 uh8Var = this.a;
            if (uh8Var == null) {
                return 0L;
            }
            return uh8Var.a;
        }
        return invokeV.longValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ih5 ih5Var = this.i;
            if (ih5Var != null) {
                ih5Var.dettachView(this);
                this.i = null;
            }
            zf8 zf8Var = this.g;
            if (zf8Var != null) {
                zf8Var.b();
            }
        }
    }

    public final void r() {
        jh5 jh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (jh5Var = this.j) != null) {
            jh5Var.dettachView(this);
            this.j = null;
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
            jh5 jh5Var = this.j;
            if (jh5Var != null && jh5Var.isViewAttached()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.d == null) {
            return;
        }
        for (int i = 0; i < this.d.getChildCount(); i++) {
            View childAt = this.d.getChildAt(i);
            if (childAt instanceof lh8) {
                ((lh8) childAt).e();
            }
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            a9<?> a2 = g9.a(context);
            a2.registerListener(this.n);
            a2.registerListener(this.o);
            a2.registerListener(this.p);
            if (a2 instanceof TbPageContext) {
                this.f = (TbPageContext) a2;
            }
            BdListView bdListView = new BdListView(context);
            this.d = bdListView;
            bdListView.setDividerHeight(0);
            this.d.setSelector(17170445);
            og8 og8Var = new og8(this.f);
            this.e = og8Var;
            this.d.setAdapter((ListAdapter) og8Var);
            PbListView pbListView = new PbListView(context);
            this.c = pbListView;
            pbListView.a();
            this.c.r(R.color.CAM_X0204);
            this.c.H(SkinManager.getColor(R.color.CAM_X0109));
            this.c.e(TbadkCoreApplication.getInst().getSkinType());
            q55 q55Var = new q55(this.f);
            this.b = q55Var;
            this.d.setPullRefresh(q55Var);
            this.b.A(true);
            this.b.f(new e(this));
            this.d.setOnSrollToBottomListener(new f(this));
            this.d.setOnScrollListener(this);
            eg8 eg8Var = new eg8(this.d, this.e);
            this.h = eg8Var;
            eg8Var.l(this.q);
            addView(this.d);
        }
    }

    public final void x(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.i == null) {
                if (i < 0) {
                    this.i = new ih5(getContext());
                } else {
                    this.i = new ih5(getContext(), i);
                }
                this.i.onChangeSkinType();
            }
            this.i.attachView(this, z);
        }
    }

    public final void y(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048595, this, view2, str, z) == null) {
            if (this.j == null) {
                this.j = new jh5(getContext(), new g(this));
            }
            this.j.k(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070254));
            this.j.m(str);
            this.j.attachView(view2, z);
            this.j.p();
        }
    }
}
