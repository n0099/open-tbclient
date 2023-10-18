package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.al9;
import com.baidu.tieba.ao9;
import com.baidu.tieba.co9;
import com.baidu.tieba.do9;
import com.baidu.tieba.eo5;
import com.baidu.tieba.ho9;
import com.baidu.tieba.ki;
import com.baidu.tieba.ko9;
import com.baidu.tieba.l45;
import com.baidu.tieba.m45;
import com.baidu.tieba.nf9;
import com.baidu.tieba.oea;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pea;
import com.baidu.tieba.pi9;
import com.baidu.tieba.qm9;
import com.baidu.tieba.uj9;
import com.baidu.tieba.ye9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements ao9, ko9.b, eo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l45.g A;
    public CustomMessageListener B;
    public final CustomMessageListener C;
    public final BdListView.p D;
    public AbsPbActivity a;
    public AbsVideoPbFragment b;
    public View c;
    public BdTypeRecyclerView d;
    public ki e;
    public LinearLayoutManager f;
    public co9 g;
    public ho9 h;
    public PbListView i;
    public View j;
    public ko9 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public PbReplyTitleViewHolder q;
    public BdSwipeRefreshLayout r;
    public m45 s;
    public boolean t;
    public int u;
    public boolean v;
    public ViewTreeObserver.OnGlobalLayoutListener w;
    public boolean x;
    public boolean y;
    public RecyclerView.OnScrollListener z;

    @Override // com.baidu.tieba.eo5
    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.eo5
    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.eo5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public a(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    this.a.a0().D4();
                    this.a.a0().E4();
                }
                if (this.a.a0() != null) {
                    this.a.a0().v4(i);
                }
                if (i != 0) {
                    return;
                }
                this.a.K2(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                this.a.F2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements l45.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.e0() != null && this.a.e0().r2(true)) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.a.r2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Integer.valueOf(i)};
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
            this.a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.e0() != null && this.a.e0().s1() != null && this.a.e0().s1().F() != null) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                oea oeaVar = null;
                Iterator<pea> it = this.a.e0().s1().F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    pea next = it.next();
                    if (next instanceof oea) {
                        oea oeaVar2 = (oea) next;
                        if (str.equals(oeaVar2.E1())) {
                            oeaVar = oeaVar2;
                            break;
                        }
                    }
                }
                if (oeaVar != null && this.a.g != null && this.a.d != null) {
                    this.a.e0().s1().F().remove(oeaVar);
                    if (this.a.g.a() != null) {
                        this.a.g.a().remove(oeaVar);
                    }
                    if (this.a.d.getListView2().getData() != null) {
                        this.a.d.getListView2().getData().remove(oeaVar);
                    }
                    this.a.n2();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g != null) {
                this.a.g.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Integer.valueOf(i)};
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
            this.a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.e0() != null && (customResponsedMessage.getData() instanceof ye9)) {
                ye9 ye9Var = (ye9) customResponsedMessage.getData();
                if (StringHelper.equals(this.a.e0().M1(), ye9Var.Q())) {
                    this.a.e0().D0(ye9Var.O());
                    this.a.e0().y2(ye9Var, 3, "");
                    MessageManager.getInstance().unRegisterStickyMode(2921648);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view2, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{recyclerView, view2, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view2, Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{recyclerView, view2, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(DetailInfoAndReplyFragment detailInfoAndReplyFragment, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, context};
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
            this.a = detailInfoAndReplyFragment;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public g(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.x || this.a.a0() == null) {
                return;
            }
            this.a.x = true;
            this.a.a0().q3(this.a.d, false);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public h(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.mIsLogin) {
                return;
            }
            if (!this.a.v && this.a.p2() && this.a.e0() != null) {
                StatisticItem statisticItem = new StatisticItem("c13999");
                statisticItem.param("tid", this.a.e0().M1());
                statisticItem.param("fid", this.a.e0().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                this.a.v = true;
            }
            if (this.a.e0().p2(false)) {
                this.a.O2();
                if (this.a.getPageContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                }
            } else if (this.a.e0().s1() != null) {
                this.a.I2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DetailInfoAndReplyFragment a;

        public i(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = detailInfoAndReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ViewHelper.skipToLoginActivity(this.a.getContext());
                this.a.B1(true);
                this.a.getPageContext().getPageActivity().finish();
            }
        }
    }

    public DetailInfoAndReplyFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = 0;
        this.s = null;
        this.t = false;
        this.v = false;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new c(this, 2016331);
        this.C = new e(this, 2921648);
        this.D = new h(this);
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07bc, (ViewGroup) null));
            this.q = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.v = false;
            pbReplyTitleViewHolder.s(a0().O3());
            this.q.r(a0().T0);
            this.q.u(8);
        }
    }

    public final void F2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (bdTypeRecyclerView = this.d) != null && this.f != null && this.g != null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.g.e();
            int headerViewsCount2 = this.d.getHeaderViewsCount() + this.g.d();
            int findFirstVisibleItemPosition = this.f.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.q.u(0);
            } else {
                this.q.u(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.q.u(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onDestroy();
            co9 co9Var = this.g;
            if (co9Var != null) {
                co9Var.o();
            }
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().unRegisterListener(this.C);
            pi9.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.w);
            }
            if (getActivity() instanceof PbActivity) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921757));
            }
        }
    }

    public int v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                if (e0() != null && e0().s1() != null && lastVisiblePosition >= e0().s1().F().size()) {
                    return e0().s1().F().size() - 2;
                }
                return lastVisiblePosition;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static DetailInfoAndReplyFragment E2(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.b = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ko9.b
    public void B1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.p = z;
        }
    }

    public void L2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && (pbListView = this.i) != null) {
            pbListView.H(str);
        }
    }

    public void M2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && (pbListView = this.i) != null) {
            pbListView.M(str, this.u);
        }
    }

    public void N2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ye9 s1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onActivityCreated(bundle);
            PbModel e0 = e0();
            if (e0 != null && (s1 = e0.s1()) != null) {
                o2(true, 0, 3, 0, s1, "", 1, true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.a = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            super.showLoadingView(view2);
        }
    }

    public void J2(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getLayoutManager() != null && (this.d.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.d.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.u = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092902);
            this.d = bdTypeRecyclerView;
            this.e = new ki(bdTypeRecyclerView);
            f fVar = new f(this, getContext());
            this.f = fVar;
            this.d.setLayoutManager(fVar);
            do9 do9Var = new do9(this, this.d);
            this.g = do9Var;
            do9Var.A(a0().O3());
            this.g.v(a0().P3());
            this.g.y(a0().S3());
            this.g.x(this.h.c());
            this.g.E(this.h.d());
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.i = pbListView;
            View findViewById = pbListView.c().findViewById(R.id.pb_more_view);
            this.j = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(a0().O3());
                SkinManager.setBackgroundResource(this.j, R.drawable.pb_foot_more_trans_selector);
            }
            this.i.D();
            this.i.r(R.drawable.pb_foot_more_trans_selector);
            this.i.s(R.drawable.pb_foot_more_trans_selector);
            this.i.v();
            this.d.setOnSrollToBottomListener(this.D);
            this.d.addOnScrollListener(this.z);
            this.d.setOnTouchListener(a0().T3());
            this.w = new g(this);
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.w);
            if (this.s == null) {
                m45 m45Var = new m45(getPageContext());
                this.s = m45Var;
                m45Var.f();
                this.s.a(this.A);
            }
            if (this.r == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091b91);
                this.r = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.s);
                this.r.setEnabled(false);
                SkinManager.setBackgroundColor(this.r, R.color.CAM_X0205);
            }
            A2();
            this.g.z(a0().T0);
            registerListener(this.B);
            registerListener(this.C);
        }
    }

    public void C2() {
        ye9 s1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (s1 = e0().s1()) == null) {
            return;
        }
        this.g.u(e0().L1());
        this.g.s(s1);
        n2();
        ArrayList<pea> F = s1.F();
        if (s1.y().b() == 0 || F == null || F.size() < s1.y().e()) {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).L() != 1)) {
                if (s1.y().b() == 0) {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.i.n();
            } else if (D2()) {
                this.i.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1014), this.u);
            } else {
                this.i.M(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1015), this.u);
            }
        }
        a0().A4(s1);
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (e0() != null) {
                return e0().V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.d == null) {
        }
    }

    public void H2() {
        co9 co9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (co9Var = this.g) != null) {
            co9Var.n();
        }
    }

    public void I2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.o != 2) {
            this.d.setNextPage(this.i);
            this.o = 2;
        }
    }

    @Override // com.baidu.tieba.eo5
    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.canScrollVertically(-1) || z2()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.i.D();
            this.i.U();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment a0() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.b == null && (absPbActivity = this.a) != null) {
                Fragment E1 = absPbActivity.E1();
                if (E1 instanceof AbsVideoPbFragment) {
                    this.b = (AbsVideoPbFragment) E1;
                }
            }
            return this.b;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return a0().e0();
        }
        return (PbModel) invokeV.objValue;
    }

    public AbsPbActivity l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                return absPbActivity;
            }
            return a0().l0();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final void n2() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (bdTypeRecyclerView = this.d) == null) {
            return;
        }
        if (this.e == null) {
            this.e = new ki(bdTypeRecyclerView);
        }
        this.e.e(new d(this));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onPause();
            qm9.a();
            if (a0() != null) {
                pi9.a().i(l0());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onResume();
            this.p = false;
            K2(false);
        }
    }

    public void r2() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (bdSwipeRefreshLayout = this.r) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.r.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: s2 */
    public co9 c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.g;
        }
        return (co9) invokeV.objValue;
    }

    public int t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int u2() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.d.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public BdTypeRecyclerView w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.d;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public View x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public ho9 y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.h;
        }
        return (ho9) invokeV.objValue;
    }

    public final void K2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && a0() != null && l0() != null && l0().J1() != null && this.g.f() != null) {
            pi9.a().f(l0().J1().g2(), this.g.f().x(), this.q.l(), l0().getPageStayDurationItem(), z, null, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.e(i2);
                if (this.j != null) {
                    getBaseFragmentActivity().getLayoutMode().onModeChanged(this.j);
                    SkinManager.setBackgroundResource(this.j, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.q;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.n(i2);
            }
            n2();
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tieba.ao9
    public void P1(boolean z, int i2, int i3, int i4, ye9 ye9Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ye9Var, str, Integer.valueOf(i5)}) == null) && getActivity() != null) {
            o2(z, i2, i3, i4, ye9Var, str, i5, false);
        }
    }

    public void P2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && z && this.l) {
            this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.d.setNextPage(this.i);
            this.o = 2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            super.onUserChanged(z);
            P2(z);
            if (a0() != null && a0().o != null) {
                this.b.o.I();
            }
            if (z && this.p) {
                O2();
                e0().p2(true);
            }
        }
    }

    public void Q2(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            co9 co9Var = this.g;
            if (co9Var != null) {
                co9Var.w(z);
                n2();
            }
            if (z && a0() != null) {
                qm9.d(getPageContext(), e0(), this, a0().getView());
            }
            ye9 s1 = e0().s1();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            if (s1 != null) {
                str = s1.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void o2(boolean z, int i2, int i3, int i4, ye9 ye9Var, String str, int i5, boolean z2) {
        int size;
        int i6;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ye9Var, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) && z && e0() != null && ye9Var != null) {
            if (!z2) {
                if (this.y) {
                    e0().z0();
                } else {
                    this.y = true;
                }
            }
            this.t = e0().L1();
            boolean isEnabled = this.r.isEnabled();
            if (ye9Var.y().c() == 0 && this.t) {
                this.r.setEnabled(false);
            } else if (!isEnabled) {
                this.r.setEnabled(true);
                this.r.o();
            }
            this.g.u(this.t);
            this.g.t(ye9Var, z2);
            this.l = false;
            if (TbadkCoreApplication.isLogin()) {
                this.d.setNextPage(this.i);
                this.o = 2;
                if (a0() != null && a0().o != null) {
                    this.b.o.W();
                }
            } else {
                this.l = true;
                if (ye9Var.y().b() == 1) {
                    if (this.k == null) {
                        ko9 ko9Var = new ko9(this, this);
                        this.k = ko9Var;
                        ko9Var.a();
                        this.k.h();
                        if (this.g instanceof do9) {
                            this.k.i(new i(this));
                        }
                    }
                    this.d.setNextPage(this.k);
                } else {
                    this.d.setNextPage(this.i);
                }
                this.o = 3;
            }
            if (this.q != null) {
                nf9 nf9Var = new nf9(nf9.g);
                nf9Var.c = D2();
                nf9Var.b = ye9Var.g;
                nf9Var.d = ye9Var.j0();
                nf9Var.e = ye9Var.f;
                this.q.i(nf9Var);
            }
            ArrayList<pea> F = ye9Var.F();
            if (ye9Var.y().b() != 0 && F != null && F.size() >= ye9Var.y().e()) {
                if (e0().b1()) {
                    if (this.n) {
                        q2();
                        if (ye9Var.y().b() != 0) {
                            this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.i.D();
                        this.i.R();
                    }
                } else {
                    this.i.D();
                    this.i.R();
                }
                this.i.n();
            } else {
                if (ye9Var.y().b() == 0) {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.i.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.i.n();
                if (ye9Var.y().b() == 0 || F == null) {
                    I2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (this.d.getData() == null && ye9Var.F() == null) {
                                        size2 = 0;
                                    } else {
                                        size2 = this.d.getData().size() - ye9Var.F().size();
                                    }
                                    BdTypeRecyclerView bdTypeRecyclerView = this.d;
                                    if (i4 > 0) {
                                        i7 = i4 + size2;
                                    } else {
                                        i7 = 0;
                                    }
                                    bdTypeRecyclerView.setSelection(i7);
                                    this.i.g();
                                    this.i.H(getString(R.string.obfuscated_res_0x7f0f100e));
                                    this.i.B();
                                }
                            } else {
                                if (i5 == 1) {
                                    Parcelable e2 = uj9.b().e();
                                    if (e2 instanceof RecyclerView.SavedState) {
                                        this.d.onRestoreInstanceState(e2);
                                    }
                                }
                                this.d.setSelection(0);
                            }
                        } else {
                            this.d.setSelection(0);
                        }
                    } else {
                        this.n = false;
                    }
                } else if (i5 == 1) {
                    Parcelable e3 = uj9.b().e();
                    if (e3 instanceof RecyclerView.SavedState) {
                        this.d.onRestoreInstanceState(e3);
                        if (ListUtils.getCount(F) > 1 && ye9Var.y().b() > 0) {
                            this.i.g();
                            this.i.H(getString(R.string.obfuscated_res_0x7f0f100e));
                            this.i.B();
                        }
                    }
                }
            } else {
                if (this.d.getData() == null && ye9Var.F() == null) {
                    size = 0;
                } else {
                    size = this.d.getData().size() - ye9Var.F().size();
                }
                BdTypeRecyclerView bdTypeRecyclerView2 = this.d;
                if (i4 > 1) {
                    i6 = (i4 + size) - 2;
                } else {
                    i6 = 0;
                }
                bdTypeRecyclerView2.setSelection(i6);
            }
            if (this.m) {
                G2();
                this.m = false;
                if (i5 == 0) {
                    N2(true);
                }
            }
            a0().A4(ye9Var);
            if (this.i != null) {
                if (ye9Var.y().b() == 0) {
                    this.i.O(8);
                } else {
                    this.i.O(0);
                }
            }
            if (al9.a(w2())) {
                if (e0().x2()) {
                    al9.c(w2(), e0().S0());
                }
                AbsPbActivity absPbActivity = this.a;
                if (absPbActivity instanceof PbActivity) {
                    ((PbActivity) absPbActivity).e2(ye9Var.f(), this.d);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, layoutInflater, viewGroup, bundle)) == null) {
            this.h = new ho9(this);
            this.c = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0792, (ViewGroup) null);
            B2();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbListView pbListView = this.i;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.i.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            PbListView pbListView = this.i;
            if (pbListView != null) {
                pbListView.B();
                this.i.g();
            }
            if (a0() != null && a0().o != null) {
                this.b.o.W();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public final boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (e0() == null || e0().q1() == null || e0().q1().c() != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
