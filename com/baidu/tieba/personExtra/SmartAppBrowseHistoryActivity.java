package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.i;
import com.baidu.tieba.personExtra.j;
import tbclient.SmartApp;
/* loaded from: classes24.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout edL;
    private NoNetworkView gjn;
    private com.baidu.tbadk.k.h gkZ;
    private BdRecyclerView hQT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private j maA;
    private TextView maw;
    private h may;
    private i maz;
    private i.a maB = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.vQ(true);
                SmartAppBrowseHistoryActivity.this.GZ(0);
            } else if (SmartAppBrowseHistoryActivity.this.may != null) {
                SmartAppBrowseHistoryActivity.this.vQ(y.isEmpty(aVar.dui()));
                SmartAppBrowseHistoryActivity.this.GZ(y.getCount(aVar.dui()));
                SmartAppBrowseHistoryActivity.this.may.bi(aVar.dui());
                SmartAppBrowseHistoryActivity.this.may.notifyDataSetChanged();
            }
        }
    };
    private j.a maC = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void QB(String str) {
            if (SmartAppBrowseHistoryActivity.this.may != null) {
                SmartAppBrowseHistoryActivity.this.may.QC(str);
                if (SmartAppBrowseHistoryActivity.this.may.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.vQ(true);
                }
                SmartAppBrowseHistoryActivity.this.GZ(SmartAppBrowseHistoryActivity.this.may.getItemCount());
                SmartAppBrowseHistoryActivity.this.may.notifyDataSetChanged();
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
                    if (!at.isEmpty(smartApp.h5_url)) {
                        be.brr().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                aq aqVar = new aq("c13274");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dR("obj_source", "personal_center_list");
                aqVar.w("obj_id", smartApp.swan_app_id.longValue());
                aqVar.dR("obj_name", smartApp.name);
                aqVar.al("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aqVar);
                if (SmartAppBrowseHistoryActivity.this.may != null) {
                    SmartAppBrowseHistoryActivity.this.may.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.maA == null) {
                    SmartAppBrowseHistoryActivity.this.maA = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.maA.create();
                    SmartAppBrowseHistoryActivity.this.maA.a(SmartAppBrowseHistoryActivity.this.maC);
                }
                SmartAppBrowseHistoryActivity.this.maA.b(smartApp);
                SmartAppBrowseHistoryActivity.this.maA.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener hQO = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gkZ != null) {
                    SmartAppBrowseHistoryActivity.this.gkZ.dettachView(SmartAppBrowseHistoryActivity.this.edL);
                    SmartAppBrowseHistoryActivity.this.gkZ = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.hQT.setVisibility(0);
            }
        }
    };
    private View.OnClickListener maD = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick() && com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        dva();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjn = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dS(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.maD)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.edL = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.hQT = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.hQT.setLayoutManager(new LinearLayoutManager(this));
        this.may = new h(getActivity());
        this.may.setOnItemClickListener(this.mOnItemClickListener);
        this.may.d(this.mOnLongClickListener);
        this.hQT.setAdapter(this.may);
        this.maw = new TextView(getActivity());
        this.maw.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.maw.setGravity(17);
        this.maw.setText(R.string.list_has_no_more);
        this.maw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dva() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.hQT.setVisibility(8);
        if (this.gkZ == null) {
            this.gkZ = new com.baidu.tbadk.k.h(getActivity(), this.hQO);
        }
        this.gkZ.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gkZ.setSubText(getString(R.string.neterror));
        this.gkZ.attachView(this.edL, true);
        this.gkZ.showRefreshButton();
        this.gkZ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.may != null) {
            this.may.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.maz == null) {
            this.maz = new i();
            this.maz.a(this.maB);
        }
        this.maz.bCX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(boolean z) {
        if (z) {
            if (this.hQT != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.hQT.removeHeaderView(this.mNoDataView);
                this.hQT.addHeaderView(this.mNoDataView);
            }
        } else if (this.hQT != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hQT.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.hQT.removeFooterView(this.maw);
            this.hQT.addFooterView(this.maw);
            return;
        }
        this.hQT.removeFooterView(this.maw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjn.onChangeSkinType(getPageContext(), i);
        if (this.gkZ != null) {
            this.gkZ.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.maw != null) {
            ap.setBackgroundResource(this.maw, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.maw, (int) R.color.cp_cont_d);
        }
        ap.setBackgroundColor(this.hQT, R.color.cp_bg_line_d);
        if (this.may != null) {
            this.may.notifyDataSetChanged();
        }
    }
}
