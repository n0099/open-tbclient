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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
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
    private FrameLayout bnL;
    private NoNetworkView dlW;
    private com.baidu.tbadk.m.h dmN;
    private BdRecyclerView equ;
    private TextView ihR;
    private h ihS;
    private i ihT;
    private j ihU;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ihV = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pt(true);
                SmartAppBrowseHistoryActivity.this.yh(0);
            } else if (SmartAppBrowseHistoryActivity.this.ihS != null) {
                SmartAppBrowseHistoryActivity.this.pt(v.aa(aVar.bYQ()));
                SmartAppBrowseHistoryActivity.this.yh(v.Z(aVar.bYQ()));
                SmartAppBrowseHistoryActivity.this.ihS.T(aVar.bYQ());
                SmartAppBrowseHistoryActivity.this.ihS.notifyDataSetChanged();
            }
        }
    };
    private j.a ihW = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void BX(String str) {
            if (SmartAppBrowseHistoryActivity.this.ihS != null) {
                SmartAppBrowseHistoryActivity.this.ihS.BY(str);
                if (SmartAppBrowseHistoryActivity.this.ihS.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pt(true);
                }
                SmartAppBrowseHistoryActivity.this.yh(SmartAppBrowseHistoryActivity.this.ihS.getItemCount());
                SmartAppBrowseHistoryActivity.this.ihS.notifyDataSetChanged();
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
                    if (!ap.isEmpty(smartApp.h5_url)) {
                        ba.aiz().c(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                am amVar = new am("c13274");
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "personal_center_list");
                amVar.l(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue());
                amVar.bT("obj_name", smartApp.name);
                amVar.P("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(amVar);
                if (SmartAppBrowseHistoryActivity.this.ihS != null) {
                    SmartAppBrowseHistoryActivity.this.ihS.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener clk = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ihU == null) {
                    SmartAppBrowseHistoryActivity.this.ihU = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ihU.create();
                    SmartAppBrowseHistoryActivity.this.ihU.a(SmartAppBrowseHistoryActivity.this.ihW);
                }
                SmartAppBrowseHistoryActivity.this.ihU.c(smartApp);
                SmartAppBrowseHistoryActivity.this.ihU.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener eqp = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (SmartAppBrowseHistoryActivity.this.dmN != null) {
                    SmartAppBrowseHistoryActivity.this.dmN.dettachView(SmartAppBrowseHistoryActivity.this.bnL);
                    SmartAppBrowseHistoryActivity.this.dmN = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.equ.setVisibility(0);
            }
        }
    };
    private View.OnClickListener ihX = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tbadk.util.i.isFastDoubleClick() && com.baidu.adp.lib.util.j.jG()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        bZE();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dlW = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bW(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.ihX)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.bnL = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.equ = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.equ.setLayoutManager(new LinearLayoutManager(this));
        this.ihS = new h(getActivity());
        this.ihS.S(this.mOnItemClickListener);
        this.ihS.d(this.clk);
        this.equ.setAdapter(this.ihS);
        this.ihR = new TextView(getActivity());
        this.ihR.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(getActivity(), R.dimen.tbds182)));
        this.ihR.setGravity(17);
        this.ihR.setText(R.string.list_has_no_more);
        this.ihR.setTextSize(0, l.g(getActivity(), R.dimen.tbds33));
    }

    private void bZE() {
        if (com.baidu.adp.lib.util.j.jG()) {
            loadData();
            return;
        }
        this.equ.setVisibility(8);
        if (this.dmN == null) {
            this.dmN = new com.baidu.tbadk.m.h(getActivity(), this.eqp);
        }
        this.dmN.kE(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.dmN.qx(getString(R.string.neterror));
        this.dmN.attachView(this.bnL, true);
        this.dmN.asB();
        this.dmN.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ihS != null) {
            this.ihS.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.ihT == null) {
            this.ihT = new i();
            this.ihT.a(this.ihV);
        }
        this.ihT.aVI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (z) {
            if (this.equ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.equ.removeHeaderView(this.mNoDataView);
                this.equ.addHeaderView(this.mNoDataView);
            }
        } else if (this.equ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.equ.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(int i) {
        if (l.g(getActivity(), R.dimen.tbds177) * i >= l.ah(getActivity()) - this.mNavigationBar.getHeight()) {
            this.equ.removeFooterView(this.ihR);
            this.equ.addFooterView(this.ihR);
            return;
        }
        this.equ.removeFooterView(this.ihR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlW.onChangeSkinType(getPageContext(), i);
        if (this.dmN != null) {
            this.dmN.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            al.k(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ihR != null) {
            al.k(this.ihR, R.color.cp_bg_line_d);
            al.j(this.ihR, R.color.cp_cont_d);
        }
        al.l(this.equ, R.color.cp_bg_line_d);
    }
}
