package com.baidu.tieba;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.tieba.nv5;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class qv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaRecentHistoryActivity a;
    public TbPageContext b;
    public View c;
    public FrameLayout d;
    public BdListView e;
    public NoNetworkView f;
    public PbListView g;
    public zx4 h;
    public lv5 i;
    public int j;
    public pv5 k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class a implements nv5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv5 a;

        public a(qv5 qv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qv5Var;
        }

        @Override // com.baidu.tieba.nv5.c
        public void a(pv5 pv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pv5Var) == null) {
                this.a.k = pv5Var;
                this.a.m(pv5Var.a.getAuthor(), pv5Var.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(qv5 qv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 0) {
                kv5.b().e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qv5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(qv5 qv5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qv5Var, Integer.valueOf(i)};
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
            this.a = qv5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().c) || this.a.k == null) {
                    return;
                }
                if (updateAttentionMessage.getData().c.equals(String.valueOf((this.a.k.a == null || this.a.k.a.getAuthor() == null) ? -100L : this.a.k.a.getAuthor().getUserIdLong()))) {
                    if (updateAttentionMessage.getData().a) {
                        this.a.k.b = true;
                        if (this.a.i instanceof nv5) {
                            this.a.i.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    this.a.k.b = false;
                }
            }
        }
    }

    public qv5(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i;
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.z();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.j;
            if (i == 0) {
                this.i = new mv5(this.b);
            } else if (1 == i) {
                this.i = new nv5(this.b);
                n();
                ((nv5) this.i).i(new a(this));
            }
            this.e.setAdapter((ListAdapter) this.i);
            this.e.setOnScrollListener(new b(this));
        }
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (ViewGroup) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
        }
    }

    public void j() {
        ColorDrawable colorDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07f7, (ViewGroup) null);
            this.c = inflate;
            inflate.setPadding(0, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275), 0, 0);
            this.d = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091f59);
            this.e = (BdListView) this.c.findViewById(R.id.obfuscated_res_0x7f091f5a);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                colorDrawable = new ColorDrawable(this.a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
            } else {
                colorDrawable = new ColorDrawable(this.a.getPageContext().getResources().getColor(R.color.CAM_X0204));
            }
            this.e.setDivider(colorDrawable);
            this.e.setDividerHeight(this.a.getActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
            this.f = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f091f5b);
            zx4 zx4Var = new zx4(this.b);
            this.h = zx4Var;
            zx4Var.b0(this.a.getUniqueId());
            this.e.setPullRefresh(this.h);
            PbListView pbListView = new PbListView(this.a);
            this.g = pbListView;
            pbListView.a();
            i();
        }
    }

    public void k(int i) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (noNetworkView = this.f) == null) {
            return;
        }
        noNetworkView.d(this.b, i);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.l == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void m(MetaData metaData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData, z) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.b.getPageActivity());
                return;
            }
            String valueOf = String.valueOf(metaData.getUserId());
            AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l = new c(this, 2001115);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void o(List<pv5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            lv5 lv5Var = this.i;
            if (lv5Var instanceof mv5) {
                lv5Var.c(list);
            } else if (lv5Var instanceof nv5) {
                lv5Var.c(list);
            }
            if (z) {
                s();
            } else {
                t();
            }
        }
    }

    public void p(yx4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.h.f(gVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.setNextPage(null);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.e.setNextPage(this.g);
        }
        this.g.P();
        this.g.R();
    }

    public final void t() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.e.setNextPage(this.g);
        }
        this.g.D(this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a01));
        this.g.f();
    }
}
