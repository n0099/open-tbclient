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
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.i;
import com.baidu.tieba.personExtra.j;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout bHI;
    private NoNetworkView dwI;
    private com.baidu.tbadk.m.h dxB;
    private BdRecyclerView eFU;
    private TextView ipQ;
    private h ipR;
    private i ipS;
    private j ipT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ipU = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pu(true);
                SmartAppBrowseHistoryActivity.this.xw(0);
            } else if (SmartAppBrowseHistoryActivity.this.ipR != null) {
                SmartAppBrowseHistoryActivity.this.pu(v.isEmpty(aVar.bZQ()));
                SmartAppBrowseHistoryActivity.this.xw(v.getCount(aVar.bZQ()));
                SmartAppBrowseHistoryActivity.this.ipR.aq(aVar.bZQ());
                SmartAppBrowseHistoryActivity.this.ipR.notifyDataSetChanged();
            }
        }
    };
    private j.a ipV = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void BF(String str) {
            if (SmartAppBrowseHistoryActivity.this.ipR != null) {
                SmartAppBrowseHistoryActivity.this.ipR.BG(str);
                if (SmartAppBrowseHistoryActivity.this.ipR.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pu(true);
                }
                SmartAppBrowseHistoryActivity.this.xw(SmartAppBrowseHistoryActivity.this.ipR.getItemCount());
                SmartAppBrowseHistoryActivity.this.ipR.notifyDataSetChanged();
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
                        ba.amQ().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bS("obj_source", "personal_center_list");
                anVar.p("obj_id", smartApp.swan_app_id.longValue());
                anVar.bS("obj_name", smartApp.name);
                anVar.O("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.ipR != null) {
                    SmartAppBrowseHistoryActivity.this.ipR.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ipT == null) {
                    SmartAppBrowseHistoryActivity.this.ipT = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ipT.create();
                    SmartAppBrowseHistoryActivity.this.ipT.a(SmartAppBrowseHistoryActivity.this.ipV);
                }
                SmartAppBrowseHistoryActivity.this.ipT.c(smartApp);
                SmartAppBrowseHistoryActivity.this.ipT.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener eFP = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.dxB != null) {
                    SmartAppBrowseHistoryActivity.this.dxB.dettachView(SmartAppBrowseHistoryActivity.this.bHI);
                    SmartAppBrowseHistoryActivity.this.dxB = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.eFU.setVisibility(0);
            }
        }
    };
    private View.OnClickListener ipW = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tbadk.util.i.isFastDoubleClick() && com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        caE();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dwI = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bU(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.ipW)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.bHI = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.eFU = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.eFU.setLayoutManager(new LinearLayoutManager(this));
        this.ipR = new h(getActivity());
        this.ipR.V(this.mOnItemClickListener);
        this.ipR.d(this.mOnLongClickListener);
        this.eFU.setAdapter(this.ipR);
        this.ipQ = new TextView(getActivity());
        this.ipQ.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.ipQ.setGravity(17);
        this.ipQ.setText(R.string.list_has_no_more);
        this.ipQ.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void caE() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.eFU.setVisibility(8);
        if (this.dxB == null) {
            this.dxB = new com.baidu.tbadk.m.h(getActivity(), this.eFP);
        }
        this.dxB.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.dxB.setSubText(getString(R.string.neterror));
        this.dxB.attachView(this.bHI, true);
        this.dxB.showRefreshButton();
        this.dxB.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ipR != null) {
            this.ipR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.anG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.ipS == null) {
            this.ipS = new i();
            this.ipS.a(this.ipU);
        }
        this.ipS.aNQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (z) {
            if (this.eFU != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.eFU.removeHeaderView(this.mNoDataView);
                this.eFU.addHeaderView(this.mNoDataView);
            }
        } else if (this.eFU != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eFU.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.eFU.removeFooterView(this.ipQ);
            this.eFU.addFooterView(this.ipQ);
            return;
        }
        this.eFU.removeFooterView(this.ipQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dwI.onChangeSkinType(getPageContext(), i);
        if (this.dxB != null) {
            this.dxB.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ipQ != null) {
            am.setBackgroundResource(this.ipQ, R.color.cp_bg_line_d);
            am.setViewTextColor(this.ipQ, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.eFU, R.color.cp_bg_line_d);
        if (this.ipR != null) {
            this.ipR.notifyDataSetChanged();
        }
    }
}
