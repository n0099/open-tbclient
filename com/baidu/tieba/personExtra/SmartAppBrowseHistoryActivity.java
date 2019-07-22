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
    private NoNetworkView dnF;
    private com.baidu.tbadk.m.h doz;
    private BdRecyclerView evt;
    private TextView ion;
    private h ioo;
    private i iop;
    private j ioq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ior = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pI(true);
                SmartAppBrowseHistoryActivity.this.yM(0);
            } else if (SmartAppBrowseHistoryActivity.this.ioo != null) {
                SmartAppBrowseHistoryActivity.this.pI(v.aa(aVar.cbJ()));
                SmartAppBrowseHistoryActivity.this.yM(v.Z(aVar.cbJ()));
                SmartAppBrowseHistoryActivity.this.ioo.T(aVar.cbJ());
                SmartAppBrowseHistoryActivity.this.ioo.notifyDataSetChanged();
            }
        }
    };
    private j.a ios = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void CM(String str) {
            if (SmartAppBrowseHistoryActivity.this.ioo != null) {
                SmartAppBrowseHistoryActivity.this.ioo.CN(str);
                if (SmartAppBrowseHistoryActivity.this.ioo.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pI(true);
                }
                SmartAppBrowseHistoryActivity.this.yM(SmartAppBrowseHistoryActivity.this.ioo.getItemCount());
                SmartAppBrowseHistoryActivity.this.ioo.notifyDataSetChanged();
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
                        bb.ajC().c(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
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
                if (SmartAppBrowseHistoryActivity.this.ioo != null) {
                    SmartAppBrowseHistoryActivity.this.ioo.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener cmy = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ioq == null) {
                    SmartAppBrowseHistoryActivity.this.ioq = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ioq.create();
                    SmartAppBrowseHistoryActivity.this.ioq.a(SmartAppBrowseHistoryActivity.this.ios);
                }
                SmartAppBrowseHistoryActivity.this.ioq.c(smartApp);
                SmartAppBrowseHistoryActivity.this.ioq.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener evo = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (SmartAppBrowseHistoryActivity.this.doz != null) {
                    SmartAppBrowseHistoryActivity.this.doz.dettachView(SmartAppBrowseHistoryActivity.this.boy);
                    SmartAppBrowseHistoryActivity.this.doz = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.evt.setVisibility(0);
            }
        }
    };
    private View.OnClickListener iot = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        ccx();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dnF = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bX(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.iot)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.boy = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.evt = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.evt.setLayoutManager(new LinearLayoutManager(this));
        this.ioo = new h(getActivity());
        this.ioo.U(this.mOnItemClickListener);
        this.ioo.d(this.cmy);
        this.evt.setAdapter(this.ioo);
        this.ion = new TextView(getActivity());
        this.ion.setLayoutParams(new RecyclerView.LayoutParams(-1, l.g(getActivity(), R.dimen.tbds182)));
        this.ion.setGravity(17);
        this.ion.setText(R.string.list_has_no_more);
        this.ion.setTextSize(0, l.g(getActivity(), R.dimen.tbds33));
    }

    private void ccx() {
        if (com.baidu.adp.lib.util.j.jQ()) {
            loadData();
            return;
        }
        this.evt.setVisibility(8);
        if (this.doz == null) {
            this.doz = new com.baidu.tbadk.m.h(getActivity(), this.evo);
        }
        this.doz.kK(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.doz.qN(getString(R.string.neterror));
        this.doz.attachView(this.boy, true);
        this.doz.atI();
        this.doz.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ioo != null) {
            this.ioo.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aku();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.iop == null) {
            this.iop = new i();
            this.iop.a(this.ior);
        }
        this.iop.aXH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(boolean z) {
        if (z) {
            if (this.evt != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.evt.removeHeaderView(this.mNoDataView);
                this.evt.addHeaderView(this.mNoDataView);
            }
        } else if (this.evt != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.evt.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM(int i) {
        if (l.g(getActivity(), R.dimen.tbds177) * i >= l.ah(getActivity()) - this.mNavigationBar.getHeight()) {
            this.evt.removeFooterView(this.ion);
            this.evt.addFooterView(this.ion);
            return;
        }
        this.evt.removeFooterView(this.ion);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnF.onChangeSkinType(getPageContext(), i);
        if (this.doz != null) {
            this.doz.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.k(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ion != null) {
            am.k(this.ion, R.color.cp_bg_line_d);
            am.j(this.ion, R.color.cp_cont_d);
        }
        am.l(this.evt, R.color.cp_bg_line_d);
    }
}
