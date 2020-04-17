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
    private FrameLayout cVD;
    private NoNetworkView ePl;
    private com.baidu.tbadk.k.h eQN;
    private BdRecyclerView gil;
    private TextView jXS;
    private h jXT;
    private i jXU;
    private j jXV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jXW = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.sx(true);
                SmartAppBrowseHistoryActivity.this.AC(0);
            } else if (SmartAppBrowseHistoryActivity.this.jXT != null) {
                SmartAppBrowseHistoryActivity.this.sx(v.isEmpty(aVar.cGR()));
                SmartAppBrowseHistoryActivity.this.AC(v.getCount(aVar.cGR()));
                SmartAppBrowseHistoryActivity.this.jXT.aE(aVar.cGR());
                SmartAppBrowseHistoryActivity.this.jXT.notifyDataSetChanged();
            }
        }
    };
    private j.a jXX = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Ix(String str) {
            if (SmartAppBrowseHistoryActivity.this.jXT != null) {
                SmartAppBrowseHistoryActivity.this.jXT.Iy(str);
                if (SmartAppBrowseHistoryActivity.this.jXT.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.sx(true);
                }
                SmartAppBrowseHistoryActivity.this.AC(SmartAppBrowseHistoryActivity.this.jXT.getItemCount());
                SmartAppBrowseHistoryActivity.this.jXT.notifyDataSetChanged();
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
                        ba.aOY().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
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
                if (SmartAppBrowseHistoryActivity.this.jXT != null) {
                    SmartAppBrowseHistoryActivity.this.jXT.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jXV == null) {
                    SmartAppBrowseHistoryActivity.this.jXV = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jXV.create();
                    SmartAppBrowseHistoryActivity.this.jXV.a(SmartAppBrowseHistoryActivity.this.jXX);
                }
                SmartAppBrowseHistoryActivity.this.jXV.b(smartApp);
                SmartAppBrowseHistoryActivity.this.jXV.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gig = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.eQN != null) {
                    SmartAppBrowseHistoryActivity.this.eQN.dettachView(SmartAppBrowseHistoryActivity.this.cVD);
                    SmartAppBrowseHistoryActivity.this.eQN = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.gil.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jXY = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cHI();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ePl = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jXY)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.cVD = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.gil = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.gil.setLayoutManager(new LinearLayoutManager(this));
        this.jXT = new h(getActivity());
        this.jXT.W(this.mOnItemClickListener);
        this.jXT.d(this.mOnLongClickListener);
        this.gil.setAdapter(this.jXT);
        this.jXS = new TextView(getActivity());
        this.jXS.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jXS.setGravity(17);
        this.jXS.setText(R.string.list_has_no_more);
        this.jXS.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cHI() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.gil.setVisibility(8);
        if (this.eQN == null) {
            this.eQN = new com.baidu.tbadk.k.h(getActivity(), this.gig);
        }
        this.eQN.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.eQN.setSubText(getString(R.string.neterror));
        this.eQN.attachView(this.cVD, true);
        this.eQN.showRefreshButton();
        this.eQN.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jXT != null) {
            this.jXT.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aPY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jXU == null) {
            this.jXU = new i();
            this.jXU.a(this.jXW);
        }
        this.jXU.bnj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx(boolean z) {
        if (z) {
            if (this.gil != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gil.removeHeaderView(this.mNoDataView);
                this.gil.addHeaderView(this.mNoDataView);
            }
        } else if (this.gil != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gil.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.gil.removeFooterView(this.jXS);
            this.gil.addFooterView(this.jXS);
            return;
        }
        this.gil.removeFooterView(this.jXS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ePl.onChangeSkinType(getPageContext(), i);
        if (this.eQN != null) {
            this.eQN.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jXS != null) {
            am.setBackgroundResource(this.jXS, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jXS, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.gil, R.color.cp_bg_line_d);
        if (this.jXT != null) {
            this.jXT.notifyDataSetChanged();
        }
    }
}
