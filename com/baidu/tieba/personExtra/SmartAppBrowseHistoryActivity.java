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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
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
    private FrameLayout dBv;
    private NoNetworkView fDZ;
    private com.baidu.tbadk.k.h fFD;
    private BdRecyclerView hcG;
    private TextView ljT;
    private h ljU;
    private i ljV;
    private j ljW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ljX = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.uB(true);
                SmartAppBrowseHistoryActivity.this.Fm(0);
            } else if (SmartAppBrowseHistoryActivity.this.ljU != null) {
                SmartAppBrowseHistoryActivity.this.uB(y.isEmpty(aVar.dhk()));
                SmartAppBrowseHistoryActivity.this.Fm(y.getCount(aVar.dhk()));
                SmartAppBrowseHistoryActivity.this.ljU.aK(aVar.dhk());
                SmartAppBrowseHistoryActivity.this.ljU.notifyDataSetChanged();
            }
        }
    };
    private j.a ljY = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Ow(String str) {
            if (SmartAppBrowseHistoryActivity.this.ljU != null) {
                SmartAppBrowseHistoryActivity.this.ljU.Ox(str);
                if (SmartAppBrowseHistoryActivity.this.ljU.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.uB(true);
                }
                SmartAppBrowseHistoryActivity.this.Fm(SmartAppBrowseHistoryActivity.this.ljU.getItemCount());
                SmartAppBrowseHistoryActivity.this.ljU.notifyDataSetChanged();
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
                        be.bju().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                aq aqVar = new aq("c13274");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dD("obj_source", "personal_center_list");
                aqVar.u("obj_id", smartApp.swan_app_id.longValue());
                aqVar.dD("obj_name", smartApp.name);
                aqVar.ai("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aqVar);
                if (SmartAppBrowseHistoryActivity.this.ljU != null) {
                    SmartAppBrowseHistoryActivity.this.ljU.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ljW == null) {
                    SmartAppBrowseHistoryActivity.this.ljW = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ljW.create();
                    SmartAppBrowseHistoryActivity.this.ljW.a(SmartAppBrowseHistoryActivity.this.ljY);
                }
                SmartAppBrowseHistoryActivity.this.ljW.b(smartApp);
                SmartAppBrowseHistoryActivity.this.ljW.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener hcB = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fFD != null) {
                    SmartAppBrowseHistoryActivity.this.fFD.dettachView(SmartAppBrowseHistoryActivity.this.dBv);
                    SmartAppBrowseHistoryActivity.this.fFD = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.hcG.setVisibility(0);
            }
        }
    };
    private View.OnClickListener ljZ = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dic();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fDZ = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dE(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.ljZ)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dBv = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.hcG = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.hcG.setLayoutManager(new LinearLayoutManager(this));
        this.ljU = new h(getActivity());
        this.ljU.setOnItemClickListener(this.mOnItemClickListener);
        this.ljU.d(this.mOnLongClickListener);
        this.hcG.setAdapter(this.ljU);
        this.ljT = new TextView(getActivity());
        this.ljT.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.ljT.setGravity(17);
        this.ljT.setText(R.string.list_has_no_more);
        this.ljT.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dic() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.hcG.setVisibility(8);
        if (this.fFD == null) {
            this.fFD = new com.baidu.tbadk.k.h(getActivity(), this.hcB);
        }
        this.fFD.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fFD.setSubText(getString(R.string.neterror));
        this.fFD.attachView(this.dBv, true);
        this.fFD.showRefreshButton();
        this.fFD.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ljU != null) {
            this.ljU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bkq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.ljV == null) {
            this.ljV = new i();
            this.ljV.a(this.ljX);
        }
        this.ljV.buR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(boolean z) {
        if (z) {
            if (this.hcG != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.hcG.removeHeaderView(this.mNoDataView);
                this.hcG.addHeaderView(this.mNoDataView);
            }
        } else if (this.hcG != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hcG.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.hcG.removeFooterView(this.ljT);
            this.hcG.addFooterView(this.ljT);
            return;
        }
        this.hcG.removeFooterView(this.ljT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fDZ.onChangeSkinType(getPageContext(), i);
        if (this.fFD != null) {
            this.fFD.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ljT != null) {
            ap.setBackgroundResource(this.ljT, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.ljT, (int) R.color.cp_cont_d);
        }
        ap.setBackgroundColor(this.hcG, R.color.cp_bg_line_d);
        if (this.ljU != null) {
            this.ljU.notifyDataSetChanged();
        }
    }
}
