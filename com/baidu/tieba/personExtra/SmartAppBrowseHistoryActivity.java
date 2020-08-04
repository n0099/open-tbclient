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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.i;
import com.baidu.tieba.personExtra.j;
import tbclient.SmartApp;
/* loaded from: classes18.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout drp;
    private NoNetworkView fsB;
    private com.baidu.tbadk.k.h fug;
    private BdRecyclerView gPM;
    private TextView kTW;
    private h kTX;
    private i kTY;
    private j kTZ;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a kUa = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.tP(true);
                SmartAppBrowseHistoryActivity.this.CR(0);
            } else if (SmartAppBrowseHistoryActivity.this.kTX != null) {
                SmartAppBrowseHistoryActivity.this.tP(x.isEmpty(aVar.cWm()));
                SmartAppBrowseHistoryActivity.this.CR(x.getCount(aVar.cWm()));
                SmartAppBrowseHistoryActivity.this.kTX.aK(aVar.cWm());
                SmartAppBrowseHistoryActivity.this.kTX.notifyDataSetChanged();
            }
        }
    };
    private j.a kUb = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void LC(String str) {
            if (SmartAppBrowseHistoryActivity.this.kTX != null) {
                SmartAppBrowseHistoryActivity.this.kTX.LD(str);
                if (SmartAppBrowseHistoryActivity.this.kTX.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.tP(true);
                }
                SmartAppBrowseHistoryActivity.this.CR(SmartAppBrowseHistoryActivity.this.kTX.getItemCount());
                SmartAppBrowseHistoryActivity.this.kTX.notifyDataSetChanged();
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
                    if (!as.isEmpty(smartApp.h5_url)) {
                        bd.baV().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                ap apVar = new ap("c13274");
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.dn("obj_source", "personal_center_list");
                apVar.t("obj_id", smartApp.swan_app_id.longValue());
                apVar.dn("obj_name", smartApp.name);
                apVar.ah("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(apVar);
                if (SmartAppBrowseHistoryActivity.this.kTX != null) {
                    SmartAppBrowseHistoryActivity.this.kTX.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.kTZ == null) {
                    SmartAppBrowseHistoryActivity.this.kTZ = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.kTZ.create();
                    SmartAppBrowseHistoryActivity.this.kTZ.a(SmartAppBrowseHistoryActivity.this.kUb);
                }
                SmartAppBrowseHistoryActivity.this.kTZ.b(smartApp);
                SmartAppBrowseHistoryActivity.this.kTZ.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gPH = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fug != null) {
                    SmartAppBrowseHistoryActivity.this.fug.dettachView(SmartAppBrowseHistoryActivity.this.drp);
                    SmartAppBrowseHistoryActivity.this.fug = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.gPM.setVisibility(0);
            }
        }
    };
    private View.OnClickListener kUc = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cXd();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fsB = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.m31do(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.kUc)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.drp = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.gPM = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.gPM.setLayoutManager(new LinearLayoutManager(this));
        this.kTX = new h(getActivity());
        this.kTX.setOnItemClickListener(this.mOnItemClickListener);
        this.kTX.d(this.mOnLongClickListener);
        this.gPM.setAdapter(this.kTX);
        this.kTW = new TextView(getActivity());
        this.kTW.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.kTW.setGravity(17);
        this.kTW.setText(R.string.list_has_no_more);
        this.kTW.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cXd() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.gPM.setVisibility(8);
        if (this.fug == null) {
            this.fug = new com.baidu.tbadk.k.h(getActivity(), this.gPH);
        }
        this.fug.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fug.setSubText(getString(R.string.neterror));
        this.fug.attachView(this.drp, true);
        this.fug.showRefreshButton();
        this.fug.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.kTX != null) {
            this.kTX.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bbU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.kTY == null) {
            this.kTY = new i();
            this.kTY.a(this.kUa);
        }
        this.kTY.bmd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(boolean z) {
        if (z) {
            if (this.gPM != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gPM.removeHeaderView(this.mNoDataView);
                this.gPM.addHeaderView(this.mNoDataView);
            }
        } else if (this.gPM != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gPM.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.gPM.removeFooterView(this.kTW);
            this.gPM.addFooterView(this.kTW);
            return;
        }
        this.gPM.removeFooterView(this.kTW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fsB.onChangeSkinType(getPageContext(), i);
        if (this.fug != null) {
            this.fug.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ao.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kTW != null) {
            ao.setBackgroundResource(this.kTW, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.kTW, R.color.cp_cont_d);
        }
        ao.setBackgroundColor(this.gPM, R.color.cp_bg_line_d);
        if (this.kTX != null) {
            this.kTX.notifyDataSetChanged();
        }
    }
}
