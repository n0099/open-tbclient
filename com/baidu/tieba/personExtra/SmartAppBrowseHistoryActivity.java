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
    private FrameLayout dgJ;
    private NoNetworkView fci;
    private com.baidu.tbadk.k.h fdL;
    private BdRecyclerView gxs;
    private TextView kqV;
    private h kqW;
    private i kqX;
    private j kqY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a kqZ = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.sV(true);
                SmartAppBrowseHistoryActivity.this.Bp(0);
            } else if (SmartAppBrowseHistoryActivity.this.kqW != null) {
                SmartAppBrowseHistoryActivity.this.sV(v.isEmpty(aVar.cOe()));
                SmartAppBrowseHistoryActivity.this.Bp(v.getCount(aVar.cOe()));
                SmartAppBrowseHistoryActivity.this.kqW.az(aVar.cOe());
                SmartAppBrowseHistoryActivity.this.kqW.notifyDataSetChanged();
            }
        }
    };
    private j.a kra = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Kn(String str) {
            if (SmartAppBrowseHistoryActivity.this.kqW != null) {
                SmartAppBrowseHistoryActivity.this.kqW.Ko(str);
                if (SmartAppBrowseHistoryActivity.this.kqW.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.sV(true);
                }
                SmartAppBrowseHistoryActivity.this.Bp(SmartAppBrowseHistoryActivity.this.kqW.getItemCount());
                SmartAppBrowseHistoryActivity.this.kqW.notifyDataSetChanged();
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
                        ba.aVa().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.dh("obj_source", "personal_center_list");
                anVar.s("obj_id", smartApp.swan_app_id.longValue());
                anVar.dh("obj_name", smartApp.name);
                anVar.ag("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.kqW != null) {
                    SmartAppBrowseHistoryActivity.this.kqW.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.kqY == null) {
                    SmartAppBrowseHistoryActivity.this.kqY = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.kqY.create();
                    SmartAppBrowseHistoryActivity.this.kqY.a(SmartAppBrowseHistoryActivity.this.kra);
                }
                SmartAppBrowseHistoryActivity.this.kqY.b(smartApp);
                SmartAppBrowseHistoryActivity.this.kqY.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gxn = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fdL != null) {
                    SmartAppBrowseHistoryActivity.this.fdL.dettachView(SmartAppBrowseHistoryActivity.this.dgJ);
                    SmartAppBrowseHistoryActivity.this.fdL = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.gxs.setVisibility(0);
            }
        }
    };
    private View.OnClickListener krb = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cOV();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fci = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dj(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.krb)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dgJ = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.gxs = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.gxs.setLayoutManager(new LinearLayoutManager(this));
        this.kqW = new h(getActivity());
        this.kqW.W(this.mOnItemClickListener);
        this.kqW.d(this.mOnLongClickListener);
        this.gxs.setAdapter(this.kqW);
        this.kqV = new TextView(getActivity());
        this.kqV.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.kqV.setGravity(17);
        this.kqV.setText(R.string.list_has_no_more);
        this.kqV.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cOV() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.gxs.setVisibility(8);
        if (this.fdL == null) {
            this.fdL = new com.baidu.tbadk.k.h(getActivity(), this.gxn);
        }
        this.fdL.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fdL.setSubText(getString(R.string.neterror));
        this.fdL.attachView(this.dgJ, true);
        this.fdL.showRefreshButton();
        this.fdL.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.kqW != null) {
            this.kqW.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aWa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.kqX == null) {
            this.kqX = new i();
            this.kqX.a(this.kqZ);
        }
        this.kqX.btb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(boolean z) {
        if (z) {
            if (this.gxs != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gxs.removeHeaderView(this.mNoDataView);
                this.gxs.addHeaderView(this.mNoDataView);
            }
        } else if (this.gxs != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxs.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bp(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.gxs.removeFooterView(this.kqV);
            this.gxs.addFooterView(this.kqV);
            return;
        }
        this.gxs.removeFooterView(this.kqV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fci.onChangeSkinType(getPageContext(), i);
        if (this.fdL != null) {
            this.fdL.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kqV != null) {
            am.setBackgroundResource(this.kqV, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kqV, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.gxs, R.color.cp_bg_line_d);
        if (this.kqW != null) {
            this.kqW.notifyDataSetChanged();
        }
    }
}
