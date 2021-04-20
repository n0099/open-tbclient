package com.baidu.tieba.setting.forbiddenforum;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import d.b.h0.r.s.a;
import d.b.h0.r.s.l;
import d.b.i0.v2.a.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForbiddenForumActivity extends BaseActivity {
    public d.b.h0.r.s.j bottomDialog;
    public d.b.h0.r.s.l bottomDialogView;
    public d.b.i0.v2.a.a cancelModel;
    public PbListView loadMoreView;
    public d.b.i0.v2.a.c model;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public BdRecyclerView recyclerView;
    public View rootView;
    public BdListView.p onScrollToBottomListener = new c();
    public RecyclerView.Adapter adapter = new d();
    public c.b onDataResListener = new e();
    public BdRecyclerView.i onItemClickListener = new a();
    public HttpMessageListener cancelForbiddenListener = new b(CmdConfigHttp.CMD_CANCEL_FORBIDDEN_FORUM);

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void c(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            if (ForbiddenForumActivity.this.model != null) {
                if (ForbiddenForumActivity.this.model.g() == null && ListUtils.isEmpty(ForbiddenForumActivity.this.model.g().f63037a)) {
                    return;
                }
                d.b.i0.v2.a.b bVar = ForbiddenForumActivity.this.model.g().f63037a.get(i);
                ForbiddenForumActivity.this.showBottomDialog(bVar.f63029b, bVar.f63030c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String str;
            if (httpResponsedMessage == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
                if (httpMessage.getParams() != null) {
                    str = String.valueOf(httpMessage.getParams().get("forum_id"));
                    BdTopToast bdTopToast = new BdTopToast(ForbiddenForumActivity.this);
                    if (httpResponsedMessage.getError() != 0) {
                        bdTopToast.h(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_sucessful));
                        bdTopToast.i(true);
                        TiebaStatic.log(new StatisticItem("c14057").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", str));
                        ForbiddenForumActivity.this.model.f(str);
                        ForbiddenForumActivity.this.adapter.notifyDataSetChanged();
                    } else {
                        bdTopToast.h(ForbiddenForumActivity.this.getString(R.string.cancel_forbidden_failed));
                        bdTopToast.i(false);
                    }
                    bdTopToast.j((ViewGroup) ForbiddenForumActivity.this.rootView);
                }
            }
            str = "";
            BdTopToast bdTopToast2 = new BdTopToast(ForbiddenForumActivity.this);
            if (httpResponsedMessage.getError() != 0) {
            }
            bdTopToast2.j((ViewGroup) ForbiddenForumActivity.this.rootView);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (ForbiddenForumActivity.this.model.g().f63038b) {
                ForbiddenForumActivity.this.model.j();
                ForbiddenForumActivity.this.showLoadMoreView();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.Adapter {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ForbiddenForumActivity.this.model.g().f63037a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ((l) viewHolder).a(ForbiddenForumActivity.this.model.g().f63037a.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new l(LayoutInflater.from(ForbiddenForumActivity.this).inflate(R.layout.forbidden_forum_item_view, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.b {
        public e() {
        }

        @Override // d.b.i0.v2.a.c.b
        public void a(d.b.i0.v2.a.d dVar) {
            if (ForbiddenForumActivity.this.isLoadingViewAttached()) {
                ForbiddenForumActivity forbiddenForumActivity = ForbiddenForumActivity.this;
                forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
            }
            if (ListUtils.isEmpty(ForbiddenForumActivity.this.model.g().f63037a)) {
                ForbiddenForumActivity.this.showNoDataView();
                return;
            }
            ForbiddenForumActivity.this.adapter.notifyDataSetChanged();
            if (dVar == null || dVar.f63038b) {
                return;
            }
            ForbiddenForumActivity.this.showLoadMoreViewNoMore();
        }

        @Override // d.b.i0.v2.a.c.b
        public void onError(int i, String str) {
            ForbiddenForumActivity forbiddenForumActivity = ForbiddenForumActivity.this;
            forbiddenForumActivity.hideLoadingView(forbiddenForumActivity.rootView);
            ForbiddenForumActivity forbiddenForumActivity2 = ForbiddenForumActivity.this;
            forbiddenForumActivity2.showNetRefreshView(forbiddenForumActivity2.rootView, str, true);
            ForbiddenForumActivity.this.recyclerView.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.c {
        public f() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            ForbiddenForumActivity.this.hideBottomDialog();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements l.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20639b;

        public g(String str, String str2) {
            this.f20638a = str;
            this.f20639b = str2;
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            ForbiddenForumActivity.this.hideBottomDialog();
            ForbiddenForumActivity.this.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ForbiddenForumActivity.this.getActivity()).createNormalCfg(this.f20638a, null)));
            TiebaStatic.log(new StatisticItem("c14058").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f20639b));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements l.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20641a;

        public h(String str) {
            this.f20641a = str;
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            ForbiddenForumActivity.this.hideBottomDialog();
            ForbiddenForumActivity.this.showCancelForbiddenDialog(this.f20641a);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements DialogInterface.OnDismissListener {
        public i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ForbiddenForumActivity.this.bottomDialog = null;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20644e;

        public j(String str) {
            this.f20644e = str;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ForbiddenForumActivity.this.cancelModel.a(this.f20644e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements a.e {
        public k() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class l extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f20647a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20648b;

        /* renamed from: c  reason: collision with root package name */
        public int f20649c;

        public l(@NonNull View view) {
            super(view);
            this.f20649c = 3;
            BarImageView barImageView = (BarImageView) view.findViewById(R.id.img_bar);
            this.f20647a = barImageView;
            barImageView.setPlaceHolder(1);
            this.f20647a.setShowOval(true);
            this.f20647a.setAutoChangeStyle(true);
            this.f20647a.setStrokeWith(d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f20647a.setStrokeColorResId(R.color.CAM_X0401);
            this.f20647a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f20648b = (TextView) view.findViewById(R.id.text_bar);
        }

        public void a(d.b.i0.v2.a.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f20647a.W(bVar.f63028a, 10, false);
            TextView textView = this.f20648b;
            textView.setText(bVar.f63029b + TbadkCoreApplication.getInst().getString(R.string.forum));
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public final void b(int i) {
            if (this.f20649c != i) {
                SkinManager.setBackgroundColor(this.itemView, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f20648b, R.color.CAM_X0105);
                this.f20649c = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideBottomDialog() {
        d.b.h0.r.s.j jVar = this.bottomDialog;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.bottomDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomDialog(String str, String str2) {
        if (this.bottomDialog != null) {
            return;
        }
        if (this.bottomDialogView == null) {
            d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(this);
            this.bottomDialogView = lVar;
            lVar.m(new f());
        }
        ArrayList arrayList = new ArrayList();
        d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(this.bottomDialogView);
        hVar.n(getString(R.string.open_the_forum));
        hVar.m(new g(str, str2));
        arrayList.add(hVar);
        d.b.h0.r.s.h hVar2 = new d.b.h0.r.s.h(this.bottomDialogView);
        hVar2.n(getString(R.string.cancel_forbidden));
        hVar2.m(new h(str2));
        arrayList.add(hVar2);
        this.bottomDialogView.k(arrayList);
        d.b.h0.r.s.l lVar2 = this.bottomDialogView;
        lVar2.q(str + TbadkCoreApplication.getInst().getString(R.string.forum));
        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(getPageContext(), this.bottomDialogView);
        this.bottomDialog = jVar;
        jVar.setOnDismissListener(new i());
        this.bottomDialog.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCancelForbiddenDialog(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getActivity());
        aVar.setMessage(getString(R.string.confirm_cancel_forbidden_forum));
        aVar.setOnlyMessageShowCenter(true);
        aVar.setPositiveButton(R.string.confirm, new j(str));
        aVar.setNegativeButton(R.string.cancel, new k());
        aVar.create(getPageContext()).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        if (this.noDataView == null) {
            this.noDataView = NoDataViewFactory.a(this, this.rootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, d.b.c.e.p.l.g(this, R.dimen.tbds308) + this.navigationBar.getBottom()), NoDataViewFactory.e.a(R.string.no_forbidden_forum), null);
            NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
            aVar.i(NoDataViewFactory.ImgType.CREATE);
            this.noDataView.setImgOption(aVar.f());
        }
        if (this.noDataView.getVisibility() == 0) {
            return;
        }
        this.noDataView.f(getPageContext(), TbadkApplication.getInst().getSkinType());
        this.noDataView.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundColor(this.rootView, R.color.CAM_X0204);
        this.navigationBar.onChangeSkinType(getPageContext(), i2);
        d.b.h0.r.s.l lVar = this.bottomDialogView;
        if (lVar != null) {
            lVar.j();
        }
        RecyclerView.Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_forbidden_forum);
        this.rootView = findViewById(R.id.root_view);
        d.b.i0.v2.a.c cVar = new d.b.i0.v2.a.c(getUniqueId());
        this.model = cVar;
        cVar.k(this.onDataResListener);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.navigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getString(R.string.privacy_forbidden_forum));
        this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.navigationBar.isShowBottomLine(true);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.recyclerView = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.adapter);
        this.recyclerView.setOnSrollToBottomListener(this.onScrollToBottomListener);
        this.recyclerView.setOnItemClickListener(this.onItemClickListener);
        this.model.j();
        showLoadingView(this.rootView);
        this.cancelModel = new d.b.i0.v2.a.a();
        registerListener(this.cancelForbiddenListener);
        TiebaStatic.log(new StatisticItem("c14056").param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.rootView);
        this.recyclerView.setVisibility(0);
        this.model.j();
        showLoadingView(this.rootView);
    }

    public void showLoadMoreView() {
        if (this.loadMoreView == null) {
            PbListView pbListView = new PbListView(this);
            this.loadMoreView = pbListView;
            pbListView.a();
            this.loadMoreView.o(R.color.CAM_X0205);
            this.loadMoreView.v();
            this.loadMoreView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.loadMoreView.E(R.dimen.tbfontsize33);
            this.loadMoreView.y(R.color.CAM_X0110);
            this.recyclerView.setNextPage(this.loadMoreView);
        }
        this.loadMoreView.H();
        this.loadMoreView.O();
        this.loadMoreView.A(this.recyclerView.getContext().getString(R.string.list_loading));
        this.loadMoreView.J(1);
    }

    public void showLoadMoreViewNoMore() {
        PbListView pbListView = this.loadMoreView;
        if (pbListView == null) {
            return;
        }
        pbListView.k(d.b.c.e.p.l.g(this, R.dimen.tbds180));
    }
}
