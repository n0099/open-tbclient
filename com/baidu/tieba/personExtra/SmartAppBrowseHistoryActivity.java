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
    private FrameLayout boW;
    private NoNetworkView dpy;
    private com.baidu.tbadk.m.h dqr;
    private BdRecyclerView exk;
    private TextView irq;
    private h irr;
    private i irs;
    private j irt;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a iru = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pM(true);
                SmartAppBrowseHistoryActivity.this.yR(0);
            } else if (SmartAppBrowseHistoryActivity.this.irr != null) {
                SmartAppBrowseHistoryActivity.this.pM(v.aa(aVar.ccP()));
                SmartAppBrowseHistoryActivity.this.yR(v.Z(aVar.ccP()));
                SmartAppBrowseHistoryActivity.this.irr.T(aVar.ccP());
                SmartAppBrowseHistoryActivity.this.irr.notifyDataSetChanged();
            }
        }
    };
    private j.a irv = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Dm(String str) {
            if (SmartAppBrowseHistoryActivity.this.irr != null) {
                SmartAppBrowseHistoryActivity.this.irr.Dn(str);
                if (SmartAppBrowseHistoryActivity.this.irr.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pM(true);
                }
                SmartAppBrowseHistoryActivity.this.yR(SmartAppBrowseHistoryActivity.this.irr.getItemCount());
                SmartAppBrowseHistoryActivity.this.irr.notifyDataSetChanged();
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
                        ba.ajK().c(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "personal_center_list");
                anVar.n(VideoPlayActivityConfig.OBJ_ID, smartApp.swan_app_id.longValue());
                anVar.bT("obj_name", smartApp.name);
                anVar.P("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.irr != null) {
                    SmartAppBrowseHistoryActivity.this.irr.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener cnB = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.irt == null) {
                    SmartAppBrowseHistoryActivity.this.irt = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.irt.create();
                    SmartAppBrowseHistoryActivity.this.irt.a(SmartAppBrowseHistoryActivity.this.irv);
                }
                SmartAppBrowseHistoryActivity.this.irt.c(smartApp);
                SmartAppBrowseHistoryActivity.this.irt.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener exf = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (SmartAppBrowseHistoryActivity.this.dqr != null) {
                    SmartAppBrowseHistoryActivity.this.dqr.dettachView(SmartAppBrowseHistoryActivity.this.boW);
                    SmartAppBrowseHistoryActivity.this.dqr = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.exk.setVisibility(0);
            }
        }
    };
    private View.OnClickListener irw = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cdD();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dpy = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bX(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.irw)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.boW = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.exk = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.exk.setLayoutManager(new LinearLayoutManager(this));
        this.irr = new h(getActivity());
        this.irr.U(this.mOnItemClickListener);
        this.irr.d(this.cnB);
        this.exk.setAdapter(this.irr);
        this.irq = new TextView(getActivity());
        this.irq.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(getActivity(), R.dimen.tbds182)));
        this.irq.setGravity(17);
        this.irq.setText(R.string.list_has_no_more);
        this.irq.setTextSize(0, l.g(getActivity(), R.dimen.tbds33));
    }

    private void cdD() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            loadData();
            return;
        }
        this.exk.setVisibility(8);
        if (this.dqr == null) {
            this.dqr = new com.baidu.tbadk.m.h(getActivity(), this.exf);
        }
        this.dqr.kO(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.dqr.qY(getString(R.string.neterror));
        this.dqr.attachView(this.boW, true);
        this.dqr.atW();
        this.dqr.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.irr != null) {
            this.irr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.akI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.irs == null) {
            this.irs = new i();
            this.irs.a(this.iru);
        }
        this.irs.aYn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(boolean z) {
        if (z) {
            if (this.exk != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.exk.removeHeaderView(this.mNoDataView);
                this.exk.addHeaderView(this.mNoDataView);
            }
        } else if (this.exk != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.exk.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(int i) {
        if (l.g(getActivity(), R.dimen.tbds177) * i >= l.ah(getActivity()) - this.mNavigationBar.getHeight()) {
            this.exk.removeFooterView(this.irq);
            this.exk.addFooterView(this.irq);
            return;
        }
        this.exk.removeFooterView(this.irq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dpy.onChangeSkinType(getPageContext(), i);
        if (this.dqr != null) {
            this.dqr.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.k(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.irq != null) {
            am.k(this.irq, R.color.cp_bg_line_d);
            am.j(this.irq, R.color.cp_cont_d);
        }
        am.l(this.exk, R.color.cp_bg_line_d);
        if (this.irr != null) {
            this.irr.notifyDataSetChanged();
        }
    }
}
