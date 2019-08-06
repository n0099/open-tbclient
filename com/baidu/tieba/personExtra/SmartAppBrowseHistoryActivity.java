package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.i;
import com.baidu.tieba.personExtra.j;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout boy;
    private NoNetworkView dnM;
    private com.baidu.tbadk.m.h doG;
    private BdRecyclerView evA;
    private TextView ipr;
    private h ips;
    private i ipt;
    private j ipu;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ipv = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pJ(true);
                SmartAppBrowseHistoryActivity.this.yO(0);
            } else if (SmartAppBrowseHistoryActivity.this.ips != null) {
                SmartAppBrowseHistoryActivity.this.pJ(v.aa(aVar.ccb()));
                SmartAppBrowseHistoryActivity.this.yO(v.Z(aVar.ccb()));
                SmartAppBrowseHistoryActivity.this.ips.T(aVar.ccb());
                SmartAppBrowseHistoryActivity.this.ips.notifyDataSetChanged();
            }
        }
    };
    private j.a ipw = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void CN(String str) {
            if (SmartAppBrowseHistoryActivity.this.ips != null) {
                SmartAppBrowseHistoryActivity.this.ips.CO(str);
                if (SmartAppBrowseHistoryActivity.this.ips.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pJ(true);
                }
                SmartAppBrowseHistoryActivity.this.yO(SmartAppBrowseHistoryActivity.this.ips.getItemCount());
                SmartAppBrowseHistoryActivity.this.ips.notifyDataSetChanged();
            }
        }
    };
    private View.OnClickListener mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (!com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191000600000000", smartApp.is_game)) {
                    if (!aq.isEmpty(smartApp.h5_url)) {
                        bb.ajE().c(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "personal_center_list");
                anVar.l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue());
                anVar.bT("obj_name", smartApp.name);
                anVar.P("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.ips != null) {
                    SmartAppBrowseHistoryActivity.this.ips.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener cmF = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ipu == null) {
                    SmartAppBrowseHistoryActivity.this.ipu = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ipu.create();
                    SmartAppBrowseHistoryActivity.this.ipu.a(SmartAppBrowseHistoryActivity.this.ipw);
                }
                SmartAppBrowseHistoryActivity.this.ipu.c(smartApp);
                SmartAppBrowseHistoryActivity.this.ipu.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener evv = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (SmartAppBrowseHistoryActivity.this.doG != null) {
                    SmartAppBrowseHistoryActivity.this.doG.dettachView(SmartAppBrowseHistoryActivity.this.boy);
                    SmartAppBrowseHistoryActivity.this.doG = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.evA.setVisibility(0);
            }
        }
    };
    private View.OnClickListener ipx = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tbadk.util.i.isFastDoubleClick() && com.baidu.adp.lib.util.j.jQ()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        ccP();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dnM = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bX(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.ipx)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.boy = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.evA = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.evA.setLayoutManager(new LinearLayoutManager(this));
        this.ips = new h(getActivity());
        this.ips.U(this.mOnItemClickListener);
        this.ips.d(this.cmF);
        this.evA.setAdapter(this.ips);
        this.ipr = new TextView(getActivity());
        this.ipr.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(getActivity(), R.dimen.tbds182)));
        this.ipr.setGravity(17);
        this.ipr.setText(R.string.list_has_no_more);
        this.ipr.setTextSize(0, l.g(getActivity(), R.dimen.tbds33));
    }

    private void ccP() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            loadData();
            return;
        }
        this.evA.setVisibility(8);
        if (this.doG == null) {
            this.doG = new com.baidu.tbadk.m.h(getActivity(), this.evv);
        }
        this.doG.kL(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.doG.qN(getString(R.string.neterror));
        this.doG.attachView(this.boy, true);
        this.doG.atK();
        this.doG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ips != null) {
            this.ips.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.akw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.ipt == null) {
            this.ipt = new i();
            this.ipt.a(this.ipv);
        }
        this.ipt.aXJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(boolean z) {
        if (z) {
            if (this.evA != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.evA.removeHeaderView(this.mNoDataView);
                this.evA.addHeaderView(this.mNoDataView);
            }
        } else if (this.evA != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.evA.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO(int i) {
        if (l.g(getActivity(), R.dimen.tbds177) * i >= l.ah(getActivity()) - this.mNavigationBar.getHeight()) {
            this.evA.removeFooterView(this.ipr);
            this.evA.addFooterView(this.ipr);
            return;
        }
        this.evA.removeFooterView(this.ipr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnM.onChangeSkinType(getPageContext(), i);
        if (this.doG != null) {
            this.doG.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.k(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ipr != null) {
            am.k(this.ipr, R.color.cp_bg_line_d);
            am.j(this.ipr, R.color.cp_cont_d);
        }
        am.l(this.evA, R.color.cp_bg_line_d);
    }
}
