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
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.i;
import com.baidu.tieba.personExtra.j;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout cVI;
    private NoNetworkView ePq;
    private com.baidu.tbadk.k.h eQS;
    private BdRecyclerView gir;
    private TextView jXW;
    private h jXX;
    private i jXY;
    private j jXZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jYa = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.sx(true);
                SmartAppBrowseHistoryActivity.this.AC(0);
            } else if (SmartAppBrowseHistoryActivity.this.jXX != null) {
                SmartAppBrowseHistoryActivity.this.sx(v.isEmpty(aVar.cGO()));
                SmartAppBrowseHistoryActivity.this.AC(v.getCount(aVar.cGO()));
                SmartAppBrowseHistoryActivity.this.jXX.aE(aVar.cGO());
                SmartAppBrowseHistoryActivity.this.jXX.notifyDataSetChanged();
            }
        }
    };
    private j.a jYb = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void IA(String str) {
            if (SmartAppBrowseHistoryActivity.this.jXX != null) {
                SmartAppBrowseHistoryActivity.this.jXX.IB(str);
                if (SmartAppBrowseHistoryActivity.this.jXX.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.sx(true);
                }
                SmartAppBrowseHistoryActivity.this.AC(SmartAppBrowseHistoryActivity.this.jXX.getItemCount());
                SmartAppBrowseHistoryActivity.this.jXX.notifyDataSetChanged();
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
                        ba.aOV().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cI("obj_source", "personal_center_list");
                anVar.t("obj_id", smartApp.swan_app_id.longValue());
                anVar.cI("obj_name", smartApp.name);
                anVar.af("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.jXX != null) {
                    SmartAppBrowseHistoryActivity.this.jXX.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jXZ == null) {
                    SmartAppBrowseHistoryActivity.this.jXZ = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jXZ.create();
                    SmartAppBrowseHistoryActivity.this.jXZ.a(SmartAppBrowseHistoryActivity.this.jYb);
                }
                SmartAppBrowseHistoryActivity.this.jXZ.b(smartApp);
                SmartAppBrowseHistoryActivity.this.jXZ.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gim = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.eQS != null) {
                    SmartAppBrowseHistoryActivity.this.eQS.dettachView(SmartAppBrowseHistoryActivity.this.cVI);
                    SmartAppBrowseHistoryActivity.this.eQS = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.gir.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jYc = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick() && com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        cHF();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ePq = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jYc)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.cVI = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.gir = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.gir.setLayoutManager(new LinearLayoutManager(this));
        this.jXX = new h(getActivity());
        this.jXX.W(this.mOnItemClickListener);
        this.jXX.d(this.mOnLongClickListener);
        this.gir.setAdapter(this.jXX);
        this.jXW = new TextView(getActivity());
        this.jXW.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jXW.setGravity(17);
        this.jXW.setText(R.string.list_has_no_more);
        this.jXW.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cHF() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.gir.setVisibility(8);
        if (this.eQS == null) {
            this.eQS = new com.baidu.tbadk.k.h(getActivity(), this.gim);
        }
        this.eQS.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.eQS.setSubText(getString(R.string.neterror));
        this.eQS.attachView(this.cVI, true);
        this.eQS.showRefreshButton();
        this.eQS.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jXX != null) {
            this.jXX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aPV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jXY == null) {
            this.jXY = new i();
            this.jXY.a(this.jYa);
        }
        this.jXY.bnh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx(boolean z) {
        if (z) {
            if (this.gir != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gir.removeHeaderView(this.mNoDataView);
                this.gir.addHeaderView(this.mNoDataView);
            }
        } else if (this.gir != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gir.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.gir.removeFooterView(this.jXW);
            this.gir.addFooterView(this.jXW);
            return;
        }
        this.gir.removeFooterView(this.jXW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ePq.onChangeSkinType(getPageContext(), i);
        if (this.eQS != null) {
            this.eQS.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jXW != null) {
            am.setBackgroundResource(this.jXW, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jXW, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.gir, R.color.cp_bg_line_d);
        if (this.jXX != null) {
            this.jXX.notifyDataSetChanged();
        }
    }
}
