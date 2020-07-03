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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
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
    private FrameLayout dlv;
    private NoNetworkView fns;
    private com.baidu.tbadk.k.h foV;
    private BdRecyclerView gKg;
    private TextView kKT;
    private h kKU;
    private i kKV;
    private j kKW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a kKX = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.tj(true);
                SmartAppBrowseHistoryActivity.this.Cr(0);
            } else if (SmartAppBrowseHistoryActivity.this.kKU != null) {
                SmartAppBrowseHistoryActivity.this.tj(w.isEmpty(aVar.cSv()));
                SmartAppBrowseHistoryActivity.this.Cr(w.getCount(aVar.cSv()));
                SmartAppBrowseHistoryActivity.this.kKU.aD(aVar.cSv());
                SmartAppBrowseHistoryActivity.this.kKU.notifyDataSetChanged();
            }
        }
    };
    private j.a kKY = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void KO(String str) {
            if (SmartAppBrowseHistoryActivity.this.kKU != null) {
                SmartAppBrowseHistoryActivity.this.kKU.KP(str);
                if (SmartAppBrowseHistoryActivity.this.kKU.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.tj(true);
                }
                SmartAppBrowseHistoryActivity.this.Cr(SmartAppBrowseHistoryActivity.this.kKU.getItemCount());
                SmartAppBrowseHistoryActivity.this.kKU.notifyDataSetChanged();
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
                    if (!ar.isEmpty(smartApp.h5_url)) {
                        bc.aWU().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                ao aoVar = new ao("c13274");
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                aoVar.dk("obj_source", "personal_center_list");
                aoVar.s("obj_id", smartApp.swan_app_id.longValue());
                aoVar.dk("obj_name", smartApp.name);
                aoVar.ag("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aoVar);
                if (SmartAppBrowseHistoryActivity.this.kKU != null) {
                    SmartAppBrowseHistoryActivity.this.kKU.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.kKW == null) {
                    SmartAppBrowseHistoryActivity.this.kKW = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.kKW.create();
                    SmartAppBrowseHistoryActivity.this.kKW.a(SmartAppBrowseHistoryActivity.this.kKY);
                }
                SmartAppBrowseHistoryActivity.this.kKW.b(smartApp);
                SmartAppBrowseHistoryActivity.this.kKW.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gKb = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.foV != null) {
                    SmartAppBrowseHistoryActivity.this.foV.dettachView(SmartAppBrowseHistoryActivity.this.dlv);
                    SmartAppBrowseHistoryActivity.this.foV = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.gKg.setVisibility(0);
            }
        }
    };
    private View.OnClickListener kKZ = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cTm();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fns = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dm(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.kKZ)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dlv = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.gKg = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.gKg.setLayoutManager(new LinearLayoutManager(this));
        this.kKU = new h(getActivity());
        this.kKU.setOnItemClickListener(this.mOnItemClickListener);
        this.kKU.d(this.mOnLongClickListener);
        this.gKg.setAdapter(this.kKU);
        this.kKT = new TextView(getActivity());
        this.kKT.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.kKT.setGravity(17);
        this.kKT.setText(R.string.list_has_no_more);
        this.kKT.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cTm() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.gKg.setVisibility(8);
        if (this.foV == null) {
            this.foV = new com.baidu.tbadk.k.h(getActivity(), this.gKb);
        }
        this.foV.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.foV.setSubText(getString(R.string.neterror));
        this.foV.attachView(this.dlv, true);
        this.foV.showRefreshButton();
        this.foV.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.kKU != null) {
            this.kKU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aXU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.kKV == null) {
            this.kKV = new i();
            this.kKV.a(this.kKX);
        }
        this.kKV.bis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(boolean z) {
        if (z) {
            if (this.gKg != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gKg.removeHeaderView(this.mNoDataView);
                this.gKg.addHeaderView(this.mNoDataView);
            }
        } else if (this.gKg != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gKg.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.gKg.removeFooterView(this.kKT);
            this.gKg.addFooterView(this.kKT);
            return;
        }
        this.gKg.removeFooterView(this.kKT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fns.onChangeSkinType(getPageContext(), i);
        if (this.foV != null) {
            this.foV.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            an.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kKT != null) {
            an.setBackgroundResource(this.kKT, R.color.cp_bg_line_d);
            an.setViewTextColor(this.kKT, (int) R.color.cp_cont_d);
        }
        an.setBackgroundColor(this.gKg, R.color.cp_bg_line_d);
        if (this.kKU != null) {
            this.kKU.notifyDataSetChanged();
        }
    }
}
