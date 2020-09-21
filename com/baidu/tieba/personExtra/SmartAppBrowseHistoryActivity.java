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
/* loaded from: classes23.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout dDw;
    private NoNetworkView fHl;
    private com.baidu.tbadk.k.h fIP;
    private BdRecyclerView hjF;
    private TextView lsP;
    private h lsQ;
    private i lsR;
    private j lsS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a lsT = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.uJ(true);
                SmartAppBrowseHistoryActivity.this.FN(0);
            } else if (SmartAppBrowseHistoryActivity.this.lsQ != null) {
                SmartAppBrowseHistoryActivity.this.uJ(y.isEmpty(aVar.dkP()));
                SmartAppBrowseHistoryActivity.this.FN(y.getCount(aVar.dkP()));
                SmartAppBrowseHistoryActivity.this.lsQ.aO(aVar.dkP());
                SmartAppBrowseHistoryActivity.this.lsQ.notifyDataSetChanged();
            }
        }
    };
    private j.a lsU = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void OX(String str) {
            if (SmartAppBrowseHistoryActivity.this.lsQ != null) {
                SmartAppBrowseHistoryActivity.this.lsQ.OY(str);
                if (SmartAppBrowseHistoryActivity.this.lsQ.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.uJ(true);
                }
                SmartAppBrowseHistoryActivity.this.FN(SmartAppBrowseHistoryActivity.this.lsQ.getItemCount());
                SmartAppBrowseHistoryActivity.this.lsQ.notifyDataSetChanged();
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
                        be.bkp().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                aq aqVar = new aq("c13274");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dF("obj_source", "personal_center_list");
                aqVar.u("obj_id", smartApp.swan_app_id.longValue());
                aqVar.dF("obj_name", smartApp.name);
                aqVar.ai("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aqVar);
                if (SmartAppBrowseHistoryActivity.this.lsQ != null) {
                    SmartAppBrowseHistoryActivity.this.lsQ.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.lsS == null) {
                    SmartAppBrowseHistoryActivity.this.lsS = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.lsS.create();
                    SmartAppBrowseHistoryActivity.this.lsS.a(SmartAppBrowseHistoryActivity.this.lsU);
                }
                SmartAppBrowseHistoryActivity.this.lsS.b(smartApp);
                SmartAppBrowseHistoryActivity.this.lsS.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener hjA = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fIP != null) {
                    SmartAppBrowseHistoryActivity.this.fIP.dettachView(SmartAppBrowseHistoryActivity.this.dDw);
                    SmartAppBrowseHistoryActivity.this.fIP = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.hjF.setVisibility(0);
            }
        }
    };
    private View.OnClickListener lsV = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dlH();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fHl = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dG(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.lsV)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dDw = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.hjF = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.hjF.setLayoutManager(new LinearLayoutManager(this));
        this.lsQ = new h(getActivity());
        this.lsQ.setOnItemClickListener(this.mOnItemClickListener);
        this.lsQ.d(this.mOnLongClickListener);
        this.hjF.setAdapter(this.lsQ);
        this.lsP = new TextView(getActivity());
        this.lsP.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.lsP.setGravity(17);
        this.lsP.setText(R.string.list_has_no_more);
        this.lsP.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dlH() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.hjF.setVisibility(8);
        if (this.fIP == null) {
            this.fIP = new com.baidu.tbadk.k.h(getActivity(), this.hjA);
        }
        this.fIP.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fIP.setSubText(getString(R.string.neterror));
        this.fIP.attachView(this.dDw, true);
        this.fIP.showRefreshButton();
        this.fIP.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.lsQ != null) {
            this.lsQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.lsR == null) {
            this.lsR = new i();
            this.lsR.a(this.lsT);
        }
        this.lsR.bvV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ(boolean z) {
        if (z) {
            if (this.hjF != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.hjF.removeHeaderView(this.mNoDataView);
                this.hjF.addHeaderView(this.mNoDataView);
            }
        } else if (this.hjF != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hjF.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.hjF.removeFooterView(this.lsP);
            this.hjF.addFooterView(this.lsP);
            return;
        }
        this.hjF.removeFooterView(this.lsP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fHl.onChangeSkinType(getPageContext(), i);
        if (this.fIP != null) {
            this.fIP.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.lsP != null) {
            ap.setBackgroundResource(this.lsP, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.lsP, (int) R.color.cp_cont_d);
        }
        ap.setBackgroundColor(this.hjF, R.color.cp_bg_line_d);
        if (this.lsQ != null) {
            this.lsQ.notifyDataSetChanged();
        }
    }
}
