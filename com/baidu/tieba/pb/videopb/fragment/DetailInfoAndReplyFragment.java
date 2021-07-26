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
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.b2;
import d.a.q0.h2.k.e.m0;
import d.a.q0.h2.p.e;
import d.a.q0.h3.h0.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements d.a.q0.h2.o.a, e.b, d.a.p0.v0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public ViewTreeObserver.OnGlobalLayoutListener E;
    public boolean F;
    public RecyclerView.OnScrollListener G;
    public final f.g H;
    public CustomMessageListener I;
    public final BdListView.p J;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f19911e;

    /* renamed from: f  reason: collision with root package name */
    public AbsVideoPbFragment f19912f;

    /* renamed from: g  reason: collision with root package name */
    public View f19913g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f19914h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f19915i;
    public d.a.q0.h2.o.f.a j;
    public d.a.q0.h2.o.g.b k;
    public PbListView l;
    public View m;
    public d.a.q0.h2.p.e n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean t;
    public LinearLayout u;
    public PbReplyTitleViewHolder v;
    public PbChildTitleViewHolder w;
    public BdSwipeRefreshLayout x;
    public d.a.p0.s.f0.g y;
    public boolean z;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19916a;

        public a(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19916a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    this.f19916a.v().o4();
                    this.f19916a.v().q4();
                }
                if (this.f19916a.v() != null) {
                    this.f19916a.v().b4(i2);
                }
                if (i2 == 0) {
                    this.f19916a.x1(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                this.f19916a.r1();
                if (recyclerView.canScrollVertically(-1)) {
                    this.f19916a.A = 2;
                    return;
                }
                if (Math.abs(i3) > 0 && this.f19916a.A != 0) {
                    this.f19916a.o.setVisibility(8);
                }
                this.f19916a.A = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19917e;

        public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19917e = detailInfoAndReplyFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19917e.y() != null && this.f19917e.y().y1(true)) {
                    TiebaStatic.eventStat(this.f19917e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                } else {
                    this.f19917e.c1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19918a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DetailInfoAndReplyFragment detailInfoAndReplyFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Integer.valueOf(i2)};
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
            this.f19918a = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19918a.y() == null || this.f19918a.y().L0() == null || this.f19918a.y().L0().E() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o oVar = null;
            Iterator<PostData> it = this.f19918a.y().L0().E().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next instanceof o) {
                    o oVar2 = (o) next;
                    if (str.equals(oVar2.D0())) {
                        oVar = oVar2;
                        break;
                    }
                }
            }
            if (oVar == null || this.f19918a.j == null || this.f19918a.f19914h == null) {
                return;
            }
            this.f19918a.y().L0().E().remove(oVar);
            if (this.f19918a.j.a() != null) {
                this.f19918a.j.a().remove(oVar);
            }
            if (this.f19918a.f19914h.getListView2().getData() != null) {
                this.f19918a.f19914h.getListView2().getData().remove(oVar);
            }
            this.f19918a.j.k();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19919a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19919a = detailInfoAndReplyFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{recyclerView, view, rect, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19920e;

        public e(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19920e = detailInfoAndReplyFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19920e.F || this.f19920e.v() == null) {
                return;
            }
            this.f19920e.F = true;
            this.f19920e.v().H2(this.f19920e.f19914h, false);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19921e;

        public f(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19921e = detailInfoAndReplyFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool != null && bool.booleanValue()) {
                    this.f19921e.D1();
                } else {
                    this.f19921e.l();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19922e;

        public g(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19922e = detailInfoAndReplyFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19922e.mIsLogin) {
                if (!this.f19922e.D && this.f19922e.a1() && this.f19922e.y() != null) {
                    StatisticItem statisticItem = new StatisticItem("c13999");
                    statisticItem.param("tid", this.f19922e.y().b1());
                    statisticItem.param("fid", this.f19922e.y().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    this.f19922e.D = true;
                }
                if (this.f19922e.y().u1(false)) {
                    this.f19922e.B1();
                    if (this.f19922e.getPageContext() != null) {
                        TiebaStatic.eventStat(this.f19922e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (this.f19922e.y().L0() != null) {
                    this.f19922e.v1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19923e;

        public h(DetailInfoAndReplyFragment detailInfoAndReplyFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19923e = detailInfoAndReplyFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f19923e.getContext());
                this.f19923e.p0(true);
                this.f19923e.getPageContext().getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f19924e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19925f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DetailInfoAndReplyFragment f19926g;

        public i(DetailInfoAndReplyFragment detailInfoAndReplyFragment, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {detailInfoAndReplyFragment, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19926g = detailInfoAndReplyFragment;
            this.f19924e = z;
            this.f19925f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f19924e) {
                this.f19926g.w1(this.f19925f, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
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
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 0;
        this.y = null;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.D = false;
        this.G = new a(this);
        this.H = new b(this);
        this.I = new c(this, 2016331);
        this.J = new g(this);
    }

    public static DetailInfoAndReplyFragment q1(AbsVideoPbFragment absVideoPbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, absVideoPbFragment)) == null) {
            Bundle bundle = new Bundle();
            DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
            detailInfoAndReplyFragment.setArguments(bundle);
            detailInfoAndReplyFragment.f19912f = absVideoPbFragment;
            return detailInfoAndReplyFragment;
        }
        return (DetailInfoAndReplyFragment) invokeL.objValue;
    }

    public void A1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.q = z;
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.x();
            this.l.O();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.TRUE));
        }
    }

    public void C1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (view = this.o) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    @Override // d.a.q0.h2.o.a
    public void D0(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) || getActivity() == null) {
            return;
        }
        Z0(z, i2, i3, i4, eVar, str, i5, false);
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(8);
        }
        showLoadingView(viewGroup);
    }

    public void E1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z && this.p) {
            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.f19914h.setNextPage(this.l);
            this.s = 2;
        }
    }

    public final void Z0(boolean z, int i2, int i3, int i4, d.a.q0.h2.h.e eVar, String str, int i5, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5), Boolean.valueOf(z2)}) == null) {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            if (!z || y() == null || eVar == null) {
                return;
            }
            this.z = y().Z0();
            boolean isEnabled = this.x.isEnabled();
            boolean z3 = true;
            int i6 = 0;
            if (eVar.x().c() == 0 && this.z) {
                this.x.setEnabled(false);
            } else if (!isEnabled) {
                this.x.setEnabled(true);
                this.x.o();
            }
            this.j.s(videoPbViewModel.l());
            this.j.t(this.z);
            this.j.r(eVar, z2);
            this.p = false;
            if (TbadkCoreApplication.isLogin()) {
                this.f19914h.setNextPage(this.l);
                this.s = 2;
                if (v() != null && v().T != null) {
                    this.f19912f.T.V();
                }
            } else {
                this.p = true;
                if (eVar.x().b() == 1) {
                    if (this.n == null) {
                        d.a.q0.h2.p.e eVar2 = new d.a.q0.h2.p.e(this, this);
                        this.n = eVar2;
                        eVar2.a();
                        this.n.g();
                        if (this.j instanceof d.a.q0.h2.o.f.b) {
                            this.n.h(new h(this));
                        }
                    }
                    this.f19914h.setNextPage(this.n);
                } else {
                    this.f19914h.setNextPage(this.l);
                }
                this.s = 3;
            }
            if (this.v != null) {
                d.a.q0.h2.h.o oVar = new d.a.q0.h2.h.o(d.a.q0.h2.h.o.l);
                b2 N = eVar.N();
                if (N != null) {
                    N.Q0();
                }
                y().Z0();
                oVar.f57477h = p1();
                oVar.f57476g = eVar.f57443g;
                eVar.c();
                oVar.f57478i = eVar.e0();
                oVar.k = eVar.f57442f;
                this.v.h(oVar);
            }
            ArrayList<PostData> E = eVar.E();
            if (eVar.x().b() != 0 && E != null && E.size() >= eVar.x().e()) {
                if (y().v0()) {
                    if (this.r) {
                        b1();
                        if (eVar.x().b() != 0) {
                            this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.l.x();
                        this.l.L();
                    }
                } else {
                    this.l.x();
                    this.l.L();
                }
                this.l.j();
            } else {
                if (eVar.x().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
                if (eVar.x().b() == 0 || E == null) {
                    v1();
                }
            }
            if (i3 == 2) {
                this.f19914h.setSelection(i4 > 1 ? (i4 + ((this.f19914h.getData() == null && eVar.E() == null) ? 0 : this.f19914h.getData().size() - eVar.E().size())) - 2 : 0);
            } else if (i3 != 3) {
                if (i3 == 4) {
                    this.r = false;
                } else if (i3 == 5) {
                    this.f19914h.setSelection(0);
                } else if (i3 == 6) {
                    if (i5 == 1) {
                        Parcelable e2 = m0.b().e();
                        if (e2 instanceof RecyclerView.SavedState) {
                            this.f19914h.onRestoreInstanceState(e2);
                        }
                    }
                    this.f19914h.setSelection(0);
                } else if (i3 == 8) {
                    this.f19914h.setSelection(i4 > 0 ? i4 + ((this.f19914h.getData() == null && eVar.E() == null) ? 0 : this.f19914h.getData().size() - eVar.E().size()) : 0);
                    this.l.f();
                    this.l.A(getString(R.string.pb_load_more_without_point));
                    this.l.v();
                }
            } else if (i5 == 1) {
                Parcelable e3 = m0.b().e();
                if (e3 instanceof RecyclerView.SavedState) {
                    this.f19914h.onRestoreInstanceState(e3);
                    if (ListUtils.getCount(E) > 1 && eVar.x().b() > 0) {
                        this.l.f();
                        this.l.A(getString(R.string.pb_load_more_without_point));
                        this.l.v();
                    }
                }
            }
            if (this.q) {
                t1();
                this.q = false;
                if (i5 == 0) {
                    A1(true);
                }
            }
            v().j4(eVar);
            if (this.l != null) {
                if (eVar.x().b() != 0 && !d.a.p0.e1.b.e.d()) {
                    this.l.I(0);
                } else {
                    this.l.I(8);
                }
            }
            if (ListUtils.getCount(this.j.a()) <= 0 || !videoPbViewModel.m()) {
                return;
            }
            videoPbViewModel.w(false);
            String o0 = y().o0();
            ArrayList<n> a2 = this.j.a();
            if (a2 != null) {
                if (!k.isEmpty(o0)) {
                    for (int i7 = 0; i7 < a2.size(); i7++) {
                        if (a2.get(i7).getType() == PostData.u0 && o0.equals(((PostData) a2.get(i7)).E())) {
                            i6 = i7;
                            break;
                        }
                    }
                } else {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= a2.size()) {
                            break;
                        } else if (a2.get(i8).getType() == d.a.q0.h2.h.o.l) {
                            i6 = i8;
                            break;
                        } else {
                            i8++;
                        }
                    }
                }
                z3 = false;
                if (i6 != 0) {
                    d.a.d.e.m.e.a().post(new i(this, z3, i6));
                }
            }
        }
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PbListView pbListView = this.l;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.l.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
        }
        return invokeV.booleanValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.v();
                this.l.f();
            }
            if (v() != null && v().T != null) {
                this.f19912f.T.V();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, Boolean.FALSE));
        }
    }

    public void c1() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (bdSwipeRefreshLayout = this.x) != null && bdSwipeRefreshLayout.isEnabled()) {
            this.x.setRefreshing(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: d1 */
    public d.a.q0.h2.o.f.a M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (d.a.q0.h2.o.f.a) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19914h;
            if (bdTypeRecyclerView != null) {
                return bdTypeRecyclerView.getFirstVisiblePosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int f1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19914h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getCount() <= 0 || (childAt = this.f19914h.getChildAt(0)) == null) {
                return 0;
            }
            return childAt.getTop();
        }
        return invokeV.intValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19914h;
            if (bdTypeRecyclerView != null) {
                int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
                return (y() == null || y().L0() == null || lastVisiblePosition < y().L0().E().size()) ? lastVisiblePosition : y().L0().E().size() - 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.v0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public BdTypeRecyclerView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f19914h : (BdTypeRecyclerView) invokeV.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.B : invokeV.intValue;
    }

    @Override // d.a.p0.v0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.v0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19914h;
            return (bdTypeRecyclerView == null || (childAt = bdTypeRecyclerView.getChildAt(0)) == null || childAt.getTop() != 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public View j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.A : invokeV.intValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || getView() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        hideLoadingView(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(0);
        }
    }

    public d.a.q0.h2.o.g.b l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k : (d.a.q0.h2.o.g.b) invokeV.objValue;
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
            this.v = pbReplyTitleViewHolder;
            pbReplyTitleViewHolder.u = false;
            pbReplyTitleViewHolder.p(v().h3());
            this.v.o(v().Q1);
            this.v.r(8);
            if (!this.f19912f.N3()) {
                this.u.addView(this.v.j());
            }
            this.w = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
            d.a.q0.h2.h.d dVar = new d.a.q0.h2.h.d();
            dVar.e(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
            this.w.b(dVar);
            this.w.e(8);
            if (this.f19912f.N3()) {
                return;
            }
            this.u.addView(this.w.c());
        }
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.C = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            this.f19914h = (BdTypeRecyclerView) this.f19913g.findViewById(R.id.video_pb_reply_list);
            d dVar = new d(this, getContext());
            this.f19915i = dVar;
            this.f19914h.setLayoutManager(dVar);
            if (this.f19912f.N3()) {
                this.j = new d.a.q0.h2.o.f.b(this, this.f19914h);
            } else {
                this.j = new d.a.q0.h2.o.f.d(this, this.f19914h);
            }
            this.j.y(v().h3());
            this.j.u(v().i3());
            this.j.w(v().l3());
            this.j.v(this.k.i());
            this.j.B(this.k.l());
            this.o = this.f19913g.findViewById(R.id.reply_pager_title_shadow);
            PbListView pbListView = new PbListView(getPageContext().getPageActivity());
            this.l = pbListView;
            View findViewById = pbListView.b().findViewById(R.id.pb_more_view);
            this.m = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(v().h3());
                SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
            }
            this.l.x();
            this.l.n(R.drawable.pb_foot_more_trans_selector);
            this.l.o(R.drawable.pb_foot_more_trans_selector);
            this.l.q();
            this.f19914h.setOnSrollToBottomListener(this.J);
            this.f19914h.addOnScrollListener(this.G);
            this.f19914h.setOnTouchListener(v().m3());
            this.E = new e(this);
            this.f19914h.getViewTreeObserver().addOnGlobalLayoutListener(this.E);
            if (this.y == null) {
                d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(getPageContext());
                this.y = gVar;
                gVar.n();
                this.y.a(this.H);
            }
            if (this.x == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f19913g.findViewById(R.id.pb_video_pull_refresh_layout);
                this.x = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.y);
                this.x.setEnabled(false);
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
            }
            this.u = (LinearLayout) this.f19913g.findViewById(R.id.video_pb_suck_container);
            m1();
            this.j.x(v().Q1);
            registerListener(this.I);
            if (d.a.p0.e1.b.e.d()) {
                this.l.I(8);
                this.m.setVisibility(8);
            }
        }
    }

    public void o1() {
        d.a.q0.h2.h.e L0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (L0 = y().L0()) == null) {
            return;
        }
        this.j.t(y().Z0());
        this.j.q(L0);
        this.j.k();
        ArrayList<PostData> E = L0.E();
        if (L0.x().b() == 0 || E == null || E.size() < L0.x().e()) {
            if (ListUtils.getCount(E) != 0 && (ListUtils.getCount(E) != 1 || E.get(0) == null || E.get(0).A() != 1)) {
                if (L0.x().b() == 0) {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.l.A(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.l.j();
            } else if (p1()) {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.C);
            } else {
                this.l.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.C);
            }
        }
        v().j4(L0);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.onActivityCreated(bundle);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(z()).get(VideoPbViewModel.class);
            videoPbViewModel.n().observe(this, new f(this));
            Z0(true, 0, 3, 0, videoPbViewModel.c(), "", 1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            super.onAttach(context);
            if (context instanceof AbsPbActivity) {
                this.f19911e = (AbsPbActivity) context;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            super.onChangeSkinType(i2);
            PbListView pbListView = this.l;
            if (pbListView != null) {
                pbListView.d(i2);
                if (this.m != null) {
                    getBaseFragmentActivity().getLayoutMode().j(this.m);
                    SkinManager.setBackgroundResource(this.m, R.drawable.pb_foot_more_trans_selector);
                }
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.v;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.l(i2);
            }
            PbChildTitleViewHolder pbChildTitleViewHolder = this.w;
            if (pbChildTitleViewHolder != null) {
                pbChildTitleViewHolder.d();
            }
            d.a.q0.h2.o.f.a aVar = this.j;
            if (aVar != null) {
                aVar.k();
            }
            View view = this.o;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.personalize_tab_shadow);
            }
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201);
            if (d.a.p0.e1.b.e.d()) {
                SkinManager.setBackgroundColor(this.f19914h, R.color.CAM_X0202);
                return;
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f19914h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setBackgroundResource(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bundle) == null) {
            super.onCreate(bundle);
            this.needLogStayDuration = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = new d.a.q0.h2.o.g.b(this);
            this.f19913g = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
            n1();
            return this.f19913g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onDestroy();
            d.a.q0.h2.o.f.a aVar = this.j;
            if (aVar != null) {
                aVar.m();
            }
            MessageManager.getInstance().unRegisterListener(this.I);
            d.a.q0.h2.k.e.n.a().d();
            BdTypeRecyclerView bdTypeRecyclerView = this.f19914h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.E);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onPause();
            if (v() != null) {
                d.a.q0.h2.k.e.n.a().j(z());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onResume();
            this.t = false;
            x1(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            super.onUserChanged(z);
            E1(z);
            if (v() != null && v().T != null) {
                this.f19912f.T.H();
            }
            if (z && this.t) {
                B1();
                y().u1(true);
            }
        }
    }

    @Override // d.a.p0.v0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
        }
    }

    @Override // d.a.q0.h2.p.e.b
    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.t = z;
        }
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (y() != null) {
                return y().q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r1() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (bdTypeRecyclerView = this.f19914h) == null || this.f19915i == null || this.j == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount() + this.j.d();
        int headerViewsCount2 = this.f19914h.getHeaderViewsCount() + this.j.c();
        int findFirstVisibleItemPosition = this.f19915i.findFirstVisibleItemPosition();
        if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
            this.v.r(0);
        } else {
            this.v.r(8);
        }
        if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
            this.w.e(0);
            this.v.r(8);
        } else {
            this.w.e(8);
        }
        if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
            C1(0);
        } else {
            C1(8);
        }
    }

    public void s1(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z) == null) || (bdTypeRecyclerView = this.f19914h) == null) {
            return;
        }
        bdTypeRecyclerView.setCanFling(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view) == null) {
            super.showLoadingView(view);
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || this.f19914h == null) {
        }
    }

    public void u1() {
        d.a.q0.h2.o.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.l();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsVideoPbFragment v() {
        InterceptResult invokeV;
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.f19912f == null && (absPbActivity = this.f19911e) != null) {
                Fragment findFragment = absPbActivity.findFragment();
                if (findFragment instanceof AbsVideoPbFragment) {
                    this.f19912f = (AbsVideoPbFragment) findFragment;
                }
            }
            return this.f19912f;
        }
        return (AbsVideoPbFragment) invokeV.objValue;
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.s == 2) {
            return;
        }
        this.f19914h.setNextPage(this.l);
        this.s = 2;
    }

    public void w1(int i2, int i3) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048622, this, i2, i3) == null) || (bdTypeRecyclerView = this.f19914h) == null || bdTypeRecyclerView.getLayoutManager() == null || !(this.f19914h.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) this.f19914h.getLayoutManager()).scrollToPositionWithOffset(i2, i3);
    }

    public final void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || v() == null || z() == null || z().getPbModel() == null || this.j.e() == null) {
            return;
        }
        d.a.q0.h2.k.e.n.a().g(z().getPbModel().l1(), this.j.e().i0(), this.v.j(), z().getPageStayDurationItem(), z, null, null);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? v().y() : (PbModel) invokeV.objValue;
    }

    public void y1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.A(str);
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public AbsPbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            AbsPbActivity absPbActivity = this.f19911e;
            return absPbActivity != null ? absPbActivity : v().z();
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void z1(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, str) == null) || (pbListView = this.l) == null) {
            return;
        }
        pbListView.F(str, this.C);
    }
}
