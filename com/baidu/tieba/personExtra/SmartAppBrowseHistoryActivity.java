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
    private NoNetworkView dlX;
    private com.baidu.tbadk.m.h dmO;
    private BdRecyclerView eqv;
    private TextView ihV;
    private h ihW;
    private i ihX;
    private j ihY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ihZ = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pu(true);
                SmartAppBrowseHistoryActivity.this.yh(0);
            } else if (SmartAppBrowseHistoryActivity.this.ihW != null) {
                SmartAppBrowseHistoryActivity.this.pu(v.aa(aVar.bYU()));
                SmartAppBrowseHistoryActivity.this.yh(v.Z(aVar.bYU()));
                SmartAppBrowseHistoryActivity.this.ihW.T(aVar.bYU());
                SmartAppBrowseHistoryActivity.this.ihW.notifyDataSetChanged();
            }
        }
    };
    private j.a iia = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void BZ(String str) {
            if (SmartAppBrowseHistoryActivity.this.ihW != null) {
                SmartAppBrowseHistoryActivity.this.ihW.Ca(str);
                if (SmartAppBrowseHistoryActivity.this.ihW.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pu(true);
                }
                SmartAppBrowseHistoryActivity.this.yh(SmartAppBrowseHistoryActivity.this.ihW.getItemCount());
                SmartAppBrowseHistoryActivity.this.ihW.notifyDataSetChanged();
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
                if (SmartAppBrowseHistoryActivity.this.ihW != null) {
                    SmartAppBrowseHistoryActivity.this.ihW.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener cll = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ihY == null) {
                    SmartAppBrowseHistoryActivity.this.ihY = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ihY.create();
                    SmartAppBrowseHistoryActivity.this.ihY.a(SmartAppBrowseHistoryActivity.this.iia);
                }
                SmartAppBrowseHistoryActivity.this.ihY.c(smartApp);
                SmartAppBrowseHistoryActivity.this.ihY.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener eqq = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (SmartAppBrowseHistoryActivity.this.dmO != null) {
                    SmartAppBrowseHistoryActivity.this.dmO.dettachView(SmartAppBrowseHistoryActivity.this.bnL);
                    SmartAppBrowseHistoryActivity.this.dmO = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.eqv.setVisibility(0);
            }
        }
    };
    private View.OnClickListener iib = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        bZI();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dlX = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bW(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.iib)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.bnL = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.eqv = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.eqv.setLayoutManager(new LinearLayoutManager(this));
        this.ihW = new h(getActivity());
        this.ihW.S(this.mOnItemClickListener);
        this.ihW.d(this.cll);
        this.eqv.setAdapter(this.ihW);
        this.ihV = new TextView(getActivity());
        this.ihV.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(getActivity(), R.dimen.tbds182)));
        this.ihV.setGravity(17);
        this.ihV.setText(R.string.list_has_no_more);
        this.ihV.setTextSize(0, l.g(getActivity(), R.dimen.tbds33));
    }

    private void bZI() {
        if (com.baidu.adp.lib.util.j.jG()) {
            loadData();
            return;
        }
        this.eqv.setVisibility(8);
        if (this.dmO == null) {
            this.dmO = new com.baidu.tbadk.m.h(getActivity(), this.eqq);
        }
        this.dmO.kE(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.dmO.qw(getString(R.string.neterror));
        this.dmO.attachView(this.bnL, true);
        this.dmO.asB();
        this.dmO.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ihW != null) {
            this.ihW.notifyDataSetChanged();
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
        if (this.ihX == null) {
            this.ihX = new i();
            this.ihX.a(this.ihZ);
        }
        this.ihX.aVL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (z) {
            if (this.eqv != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.eqv.removeHeaderView(this.mNoDataView);
                this.eqv.addHeaderView(this.mNoDataView);
            }
        } else if (this.eqv != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eqv.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(int i) {
        if (l.g(getActivity(), R.dimen.tbds177) * i >= l.ah(getActivity()) - this.mNavigationBar.getHeight()) {
            this.eqv.removeFooterView(this.ihV);
            this.eqv.addFooterView(this.ihV);
            return;
        }
        this.eqv.removeFooterView(this.ihV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dlX.onChangeSkinType(getPageContext(), i);
        if (this.dmO != null) {
            this.dmO.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            al.k(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ihV != null) {
            al.k(this.ihV, R.color.cp_bg_line_d);
            al.j(this.ihV, R.color.cp_cont_d);
        }
        al.l(this.eqv, R.color.cp_bg_line_d);
    }
}
