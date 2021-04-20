package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.h0.z0.l;
import d.b.i0.h2.h;
import d.b.i0.h2.i;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    public SmartAppBrowseHistoryAdapter mAdapter;
    public i mHistoryRecordMoreDialog;
    public FrameLayout mListContainer;
    public h mModel;
    public NavigationBar mNavigationBar;
    public d.b.h0.d0.h mNetRefreshView;
    public NoDataView mNoDataView;
    public TextView mNoMoreDataView;
    public NoNetworkView mNoNetworkView;
    public BdRecyclerView mRecyclerView;
    public h.b mDataLoadCallback = new a();
    public i.b mItemMoreDialogCallBack = new b();
    public View.OnClickListener mOnItemClickListener = new c();
    public View.OnLongClickListener mOnLongClickListener = new d();
    public View.OnClickListener mOnNoNetButtonClickListener = new e();
    public View.OnClickListener mNoDataViewRefreshListener = new f();

    /* loaded from: classes3.dex */
    public class a implements h.b {
        public a() {
        }

        @Override // d.b.i0.h2.h.b
        public void a(boolean z, d.b.i0.h2.a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.dealNoDataView(true);
                SmartAppBrowseHistoryActivity.this.dealNoMoreDataView(0);
            } else if (SmartAppBrowseHistoryActivity.this.mAdapter != null) {
                SmartAppBrowseHistoryActivity.this.dealNoDataView(ListUtils.isEmpty(aVar.a()));
                SmartAppBrowseHistoryActivity.this.dealNoMoreDataView(ListUtils.getCount(aVar.a()));
                SmartAppBrowseHistoryActivity.this.mAdapter.l(aVar.a());
                SmartAppBrowseHistoryActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.b {
        public b() {
        }

        @Override // d.b.i0.h2.i.b
        public void a(String str) {
            if (SmartAppBrowseHistoryActivity.this.mAdapter != null) {
                SmartAppBrowseHistoryActivity.this.mAdapter.k(str);
                if (SmartAppBrowseHistoryActivity.this.mAdapter.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.dealNoDataView(true);
                }
                SmartAppBrowseHistoryActivity smartAppBrowseHistoryActivity = SmartAppBrowseHistoryActivity.this;
                smartAppBrowseHistoryActivity.dealNoMoreDataView(smartAppBrowseHistoryActivity.mAdapter.getItemCount());
                SmartAppBrowseHistoryActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (!d.b.i0.s.a.b(smartApp.id, smartApp.link, "1191000600000000", smartApp.is_game)) {
                    if (k.isEmpty(smartApp.h5_url)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_source", "personal_center_list");
                statisticItem.param("obj_id", smartApp.swan_app_id.longValue());
                statisticItem.param("obj_name", smartApp.name);
                statisticItem.param("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(statisticItem);
                if (SmartAppBrowseHistoryActivity.this.mAdapter != null) {
                    SmartAppBrowseHistoryActivity.this.mAdapter.h(smartApp);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnLongClickListener {
        public d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.mHistoryRecordMoreDialog == null) {
                    SmartAppBrowseHistoryActivity.this.mHistoryRecordMoreDialog = new i(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.mHistoryRecordMoreDialog.e();
                    SmartAppBrowseHistoryActivity.this.mHistoryRecordMoreDialog.f(SmartAppBrowseHistoryActivity.this.mItemMoreDialogCallBack);
                }
                SmartAppBrowseHistoryActivity.this.mHistoryRecordMoreDialog.d(smartApp);
                SmartAppBrowseHistoryActivity.this.mHistoryRecordMoreDialog.g();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.A()) {
                if (SmartAppBrowseHistoryActivity.this.mNetRefreshView != null) {
                    SmartAppBrowseHistoryActivity.this.mNetRefreshView.dettachView(SmartAppBrowseHistoryActivity.this.mListContainer);
                    SmartAppBrowseHistoryActivity.this.mNetRefreshView = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.mRecyclerView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.a() && j.A()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealNoDataView(boolean z) {
        if (z) {
            if (this.mRecyclerView != null) {
                NoDataView noDataView = this.mNoDataView;
                if (noDataView != null) {
                    noDataView.setVisibility(0);
                }
                this.mRecyclerView.removeHeaderView(this.mNoDataView);
                this.mRecyclerView.s(this.mNoDataView);
            }
        } else if (this.mRecyclerView != null) {
            NoDataView noDataView2 = this.mNoDataView;
            if (noDataView2 != null) {
                noDataView2.setVisibility(8);
            }
            this.mRecyclerView.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealNoMoreDataView(int i) {
        if (d.b.c.e.p.l.g(getActivity(), R.dimen.tbds177) * i >= d.b.c.e.p.l.i(getActivity()) - this.mNavigationBar.getHeight()) {
            this.mRecyclerView.y(this.mNoMoreDataView);
            this.mRecyclerView.r(this.mNoMoreDataView);
            return;
        }
        this.mRecyclerView.y(this.mNoMoreDataView);
    }

    private void firstLoadData() {
        if (j.A()) {
            loadData();
            return;
        }
        this.mRecyclerView.setVisibility(8);
        if (this.mNetRefreshView == null) {
            this.mNetRefreshView = new d.b.h0.d0.h(getActivity(), this.mOnNoNetButtonClickListener);
        }
        this.mNetRefreshView.j(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.mNetRefreshView.l(getString(R.string.neterror));
        this.mNetRefreshView.attachView(this.mListContainer, true);
        this.mNetRefreshView.o();
        this.mNetRefreshView.onChangeSkinType();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar = navigationBar;
        navigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNoNetworkView = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.d(null, getString(R.string.no_history_now)), NoDataViewFactory.c.a(new NoDataViewFactory.b(getResources().getString(R.string.refresh), this.mNoDataViewRefreshListener)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.mListContainer = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.mRecyclerView = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = new SmartAppBrowseHistoryAdapter(getActivity());
        this.mAdapter = smartAppBrowseHistoryAdapter;
        smartAppBrowseHistoryAdapter.m(this.mOnItemClickListener);
        this.mAdapter.n(this.mOnLongClickListener);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mNoMoreDataView = new TextView(getActivity());
        this.mNoMoreDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, d.b.c.e.p.l.g(getActivity(), R.dimen.tbds182)));
        this.mNoMoreDataView.setGravity(17);
        this.mNoMoreDataView.setText(R.string.list_has_no_more);
        this.mNoMoreDataView.setTextSize(0, d.b.c.e.p.l.g(getActivity(), R.dimen.tbds33));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mModel == null) {
            h hVar = new h();
            this.mModel = hVar;
            hVar.g(this.mDataLoadCallback);
        }
        this.mModel.f();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetworkView.c(getPageContext(), i);
        d.b.h0.d0.h hVar = this.mNetRefreshView;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            SkinManager.setBackgroundResource(noDataView, R.color.CAM_X0201);
            this.mNoDataView.f(getPageContext(), i);
        }
        TextView textView = this.mNoMoreDataView;
        if (textView != null) {
            SkinManager.setBackgroundResource(textView, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.mNoMoreDataView, R.color.CAM_X0109);
        }
        SkinManager.setBackgroundColor(this.mRecyclerView, R.color.CAM_X0201);
        SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = this.mAdapter;
        if (smartAppBrowseHistoryAdapter != null) {
            smartAppBrowseHistoryAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        firstLoadData();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.d(getPageContext());
        }
        SmartAppBrowseHistoryAdapter smartAppBrowseHistoryAdapter = this.mAdapter;
        if (smartAppBrowseHistoryAdapter != null) {
            smartAppBrowseHistoryAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.e();
        }
    }
}
