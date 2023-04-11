package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CandidateSearchActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.SelectRuleView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.barselect.BarVoteActivity;
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.view.FloatMyRecordCard;
import com.baidu.tieba.barselect.view.SearchView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import com.baidu.tieba.barselect.view.VoteStatusCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ManagerElection;
/* loaded from: classes5.dex */
public class pa6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FloatMyRecordCard A;
    public TextView B;
    public int C;
    public PbListView D;
    public NoNetworkView E;
    public NoDataView F;
    public pg5 G;
    public ViewGroup H;
    public View.OnClickListener I;
    public View.OnClickListener J;
    public boolean K;
    public VoteStatusCard.c L;
    public RecyclerView.OnScrollListener M;
    public BdListView.p N;
    public int a;
    public BarVoteActivity b;
    public int c;
    public int d;
    public int e;
    public float f;
    public int g;
    public va6 h;
    public LinearLayoutManager i;
    public RelativeLayout j;
    public View k;
    public ViewGroup l;
    public TbImageView m;
    public View n;
    public View o;
    public NavigationBar p;
    public View q;
    public TextView r;
    public BdRecyclerView s;
    public VoteStatusCard t;
    public VoteCandidateCard u;
    public View v;
    public TextView w;
    public SelectRuleView x;
    public SearchView y;
    public VoteAdapter z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        public a(pa6 pa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.G != null) {
                    this.a.G.dettachView(this.a.k);
                    this.a.G = null;
                }
                this.a.b.B1();
                if (this.a.s != null) {
                    this.a.s.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements VoteStatusCard.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        public b(pa6 pa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa6Var;
        }

        @Override // com.baidu.tieba.barselect.view.VoteStatusCard.c
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.refresh();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        public c(pa6 pa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa6Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                this.a.g = i;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if ((this.a.g == 1 || this.a.g == 2) && this.a.l != null && this.a.p != null && this.a.p.getBarBgView() != null && this.a.p.getBackImageView() != null) {
                    pa6 pa6Var = this.a;
                    pa6Var.f = Math.abs(pa6Var.l.getTop()) / this.a.a;
                    this.a.p.getBarBgView().setAlpha(this.a.f);
                    this.a.q.setAlpha(this.a.f);
                    if (this.a.f > 0.5d) {
                        if (this.a.e == 0) {
                            SkinManager.setImageResource(this.a.p.getBackImageView(), R.drawable.icon_return_bg_s, this.a.c);
                            SkinManager.setViewTextColor(this.a.r, R.color.CAM_X0105, 1, this.a.c);
                            SkinManager.setViewTextColor(this.a.p.mCenterText, R.color.CAM_X0105, 1, this.a.c);
                            this.a.e = 1;
                        }
                        this.a.p.getBackImageView().setAlpha((this.a.f * 2.0f) - 1.0f);
                        this.a.r.setAlpha((this.a.f * 2.0f) - 1.0f);
                        this.a.p.mCenterText.setAlpha((this.a.f * 2.0f) - 1.0f);
                    } else if (this.a.f <= 0.5d) {
                        if (this.a.e == 1) {
                            SkinManager.setImageResource(this.a.p.getBackImageView(), R.drawable.icon_return_bg, this.a.c);
                            SkinManager.setViewTextColor(this.a.r, R.color.CAM_X0101, 1, this.a.c);
                            SkinManager.setViewTextColor(this.a.p.mCenterText, R.color.CAM_X0101, 1, this.a.c);
                            this.a.e = 0;
                        }
                        this.a.p.getBackImageView().setAlpha(1.0f - (this.a.f * 2.0f));
                        this.a.r.setAlpha(1.0f - (this.a.f * 2.0f));
                        this.a.p.mCenterText.setAlpha(1.0f - (this.a.f * 2.0f));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        public d(pa6 pa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa6Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.s != null) {
                    this.a.s.stopScroll();
                }
                if (this.a.D != null && this.a.b != null) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        if (this.a.d == eb6.c) {
                            this.a.D.N(ii.g(this.a.b, R.dimen.tbds152));
                        }
                        this.a.s.setNextPage(this.a.D);
                        this.a.D.E(null);
                        if (this.a.K) {
                            this.a.D.P();
                            this.a.b.A1();
                            return;
                        }
                        this.a.D.F(this.a.b.getResources().getString(R.string.list_has_no_more));
                        this.a.D.g();
                        return;
                    }
                    this.a.s.setNextPage(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa6 a;

        public e(pa6 pa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BarVoteActivity barVoteActivity = this.a.b;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CandidateSearchActivityConfig(barVoteActivity, this.a.b.d + "")));
            }
        }
    }

    public pa6(BarVoteActivity barVoteActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {barVoteActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.d = -1;
        this.e = 0;
        this.f = 0.0f;
        this.J = new a(this);
        this.L = new b(this);
        this.M = new c(this);
        this.N = new d(this);
        this.b = barVoteActivity;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(barVoteActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0141, (ViewGroup) null);
        this.j = relativeLayout;
        this.b.addContentView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        BarVoteActivity barVoteActivity2 = this.b;
        barVoteActivity2.showLoadingView(this.j, false, ii.g(barVoteActivity2, R.dimen.obfuscated_res_0x7f0702bc));
        this.k = this.j.findViewById(R.id.obfuscated_res_0x7f091498);
        this.H = (ViewGroup) this.j.findViewById(R.id.obfuscated_res_0x7f091855);
        this.o = this.j.findViewById(R.id.obfuscated_res_0x7f0917b3);
        View findViewById = this.j.findViewById(R.id.obfuscated_res_0x7f0917b4);
        this.q = findViewById;
        findViewById.setAlpha(0.0f);
        NavigationBar navigationBar = (NavigationBar) this.j.findViewById(R.id.obfuscated_res_0x7f092837);
        this.p = navigationBar;
        navigationBar.setCenterTextTitle(this.b.getResources().getString(R.string.bar_manager_recruit));
        if (this.p.getBarBgView() != null) {
            this.p.getBarBgView().setAlpha(0.0f);
        }
        this.a = ii.g(this.b, R.dimen.tbds402);
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView textView = (TextView) this.p.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.b).findViewById(R.id.right_textview);
        this.r = textView;
        textView.setText(R.string.bar_election_rule);
        this.r.setOnClickListener(this.b);
        this.s = (BdRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f092835);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
        this.i = linearLayoutManager;
        this.s.setLayoutManager(linearLayoutManager);
        VoteAdapter voteAdapter = new VoteAdapter(barVoteActivity.getPageContext());
        this.z = voteAdapter;
        this.s.setAdapter(voteAdapter);
        this.l = (ViewGroup) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d097e, (ViewGroup) null, false);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.m = (TbImageView) this.l.findViewById(R.id.obfuscated_res_0x7f090e82);
        this.m.setLayoutParams(new LinearLayout.LayoutParams(-1, (ii.l(this.b) * 884) / 1076));
        this.s.addHeaderView(this.l);
        this.s.addOnScrollListener(this.M);
        this.s.setOnSrollToBottomListener(this.N);
        this.C = this.b.getResources().getDimensionPixelSize(R.dimen.tbds134);
        View view2 = new View(this.b);
        this.n = view2;
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.C));
        this.n.setVisibility(4);
        this.s.addFooterView(this.n);
        VoteStatusCard voteStatusCard = (VoteStatusCard) this.l.findViewById(R.id.obfuscated_res_0x7f09283b);
        this.t = voteStatusCard;
        voteStatusCard.setOnRefreshListener(this.L);
        this.v = this.l.findViewById(R.id.obfuscated_res_0x7f09034b);
        this.w = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f09034f);
        SelectRuleView selectRuleView = (SelectRuleView) this.l.findViewById(R.id.obfuscated_res_0x7f09034c);
        this.x = selectRuleView;
        selectRuleView.setType(1);
        this.u = (VoteCandidateCard) this.l.findViewById(R.id.obfuscated_res_0x7f09282b);
        SearchView searchView = (SearchView) this.l.findViewById(R.id.obfuscated_res_0x7f092839);
        this.y = searchView;
        searchView.a(new e(this));
        this.A = (FloatMyRecordCard) this.j.findViewById(R.id.obfuscated_res_0x7f090af4);
        this.B = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f092843);
        PbListView pbListView = new PbListView(this.b);
        this.D = pbListView;
        pbListView.c();
        this.D.r(R.color.CAM_X0204);
        this.D.v(ii.g(this.b, R.dimen.tbds182));
        this.D.A();
        this.D.J(R.dimen.tbfontsize33);
        this.D.H(SkinManager.getColor(R.color.CAM_X0107));
        this.D.D(R.color.CAM_X0110);
        this.D.u();
        this.E = (NoNetworkView) this.j.findViewById(R.id.no_network_view);
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.I = onClickListener;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            A(i, false);
        }
    }

    public void A(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (!z && this.c == i) {
                return;
            }
            this.c = i;
            pg5 pg5Var = this.G;
            if (pg5Var != null) {
                pg5Var.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204, i);
            NavigationBar navigationBar = this.p;
            if (navigationBar != null) {
                SkinManager.setBackgroundColor(navigationBar.getBarBgView(), R.color.CAM_X0207, i);
                float f = this.f;
                if (f > 0.5d) {
                    SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                    SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                } else if (f <= 0.5d) {
                    va6 va6Var = this.h;
                    if (va6Var != null && va6Var.a() != null && this.h.a().h() <= 2 && this.h.a().h() >= 1) {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0101, 1, i);
                    } else {
                        SkinManager.setImageResource(this.p.getBackImageView(), R.drawable.icon_return_bg_s, i);
                        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
                        SkinManager.setViewTextColor(this.p.mCenterText, R.color.CAM_X0105, 1, i);
                    }
                }
                SkinManager.setBackgroundResource(this.q, R.drawable.top_view_shadow, i);
            }
            SkinManager.setImageResource(this.m, R.drawable.pic_recruit_firstfigure, i);
            this.t.f(i);
            this.u.c(i);
            this.y.d(i);
            SkinManager.setBackgroundResource(this.v, R.drawable.bar_select_bg_shadow_and_radius, i);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            SelectRuleView selectRuleView = this.x;
            if (selectRuleView != null) {
                selectRuleView.d(i);
            }
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0109, 1, i);
            this.A.d(i);
            PbListView pbListView = this.D;
            if (pbListView != null) {
                pbListView.H(SkinManager.getColor(i, (int) R.color.CAM_X0107));
                this.D.e(i);
            }
            this.E.d(this.b.getPageContext(), i);
            VoteAdapter voteAdapter = this.z;
            if (voteAdapter != null) {
                voteAdapter.notifyDataSetChanged();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.d == eb6.c) {
                this.D.N(ii.g(this.b, R.dimen.tbds152));
            }
            this.D.E(this.b);
            this.s.setNextPage(this.D);
            if (this.K) {
                this.D.O();
                return;
            }
            this.D.F(this.b.getResources().getString(R.string.list_has_no_more));
            this.D.g();
        }
    }

    public void C(va6 va6Var) {
        ua6 a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, va6Var) != null) || va6Var == null) {
            return;
        }
        this.K = va6Var.d();
        if (va6Var.a() != null && (a2 = va6Var.a()) != null) {
            int h = a2.h();
            this.d = h;
            if (h == eb6.c) {
                this.y.setVisibility(8);
                this.B.setVisibility(8);
                this.u.setVisibility(8);
            }
        }
        this.t.setData(va6Var);
        VoteAdapter voteAdapter = this.z;
        if (voteAdapter != null) {
            this.h = va6Var;
            voteAdapter.n(va6Var);
        }
        int i = this.d;
        if (i == eb6.c) {
            this.A.setVisibility(0);
            this.A.setData(va6Var);
            this.v.setVisibility(8);
        } else if (i == eb6.b) {
            this.u.setData(VoteCandidateCard.A, va6Var);
            this.A.setVisibility(8);
            this.y.setRank(va6Var.a().c());
            if (va6Var.e() != null) {
                ManagerElection e2 = va6Var.e();
                if (ListUtils.isEmpty(e2.vote_condition_pic) && ListUtils.isEmpty(e2.vote_condition_title) && ListUtils.isEmpty(e2.vote_condition)) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(0);
                    this.x.setData(e2.vote_condition_pic, e2.vote_condition_title, e2.vote_condition);
                }
            } else {
                this.v.setVisibility(8);
            }
        } else {
            this.A.setVisibility(8);
            this.v.setVisibility(8);
        }
        B();
        A(TbadkCoreApplication.getInst().getSkinType(), true);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdRecyclerView bdRecyclerView = this.s;
            if (bdRecyclerView != null) {
                bdRecyclerView.setVisibility(8);
            }
            this.b.hideLoadingView(w());
            if (this.F != null) {
                x();
            }
            if (this.G == null) {
                this.G = new pg5(this.b, this.J);
            }
            this.G.k(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds340));
            this.G.m(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d1b));
            this.G.attachView(this.k, true);
            this.G.p();
            this.G.onChangeSkinType();
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            pg5 pg5Var = this.G;
            if (pg5Var != null) {
                pg5Var.dettachView(this.k);
                this.G = null;
            }
            this.b.hideLoadingView(w());
            if (this.F == null) {
                NoDataView a2 = NoDataViewFactory.a(this.b, this.H, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 300), NoDataViewFactory.e.c(str), null);
                this.F = a2;
                a2.setOnClickListener(this.I);
            }
            this.F.setTextOption(NoDataViewFactory.e.c(str));
            this.F.f(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.F.setVisibility(0);
        }
    }

    public BdRecyclerView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.s;
        }
        return (BdRecyclerView) invokeV.objValue;
    }

    public PbListView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D;
        }
        return (PbListView) invokeV.objValue;
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public void x() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (noDataView = this.F) != null) {
            noDataView.setVisibility(8);
        }
    }

    public void y() {
        VoteStatusCard voteStatusCard;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (voteStatusCard = this.t) != null) {
            voteStatusCard.e();
        }
    }
}
