package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.h;
import com.baidu.tieba.personExtra.i;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout ent;
    private NoNetworkView gxx;
    private com.baidu.tbadk.l.h gzj;
    private BdRecyclerView ikg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView mpE;
    private SmartAppBrowseHistoryAdapter mpF;
    private h mpG;
    private i mpH;
    private h.a mpI = new h.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.h.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.wu(true);
                SmartAppBrowseHistoryActivity.this.GB(0);
            } else if (SmartAppBrowseHistoryActivity.this.mpF != null) {
                SmartAppBrowseHistoryActivity.this.wu(x.isEmpty(aVar.duZ()));
                SmartAppBrowseHistoryActivity.this.GB(x.getCount(aVar.duZ()));
                SmartAppBrowseHistoryActivity.this.mpF.bs(aVar.duZ());
                SmartAppBrowseHistoryActivity.this.mpF.notifyDataSetChanged();
            }
        }
    };
    private i.a mpJ = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.i.a
        public void PC(String str) {
            if (SmartAppBrowseHistoryActivity.this.mpF != null) {
                SmartAppBrowseHistoryActivity.this.mpF.PD(str);
                if (SmartAppBrowseHistoryActivity.this.mpF.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.wu(true);
                }
                SmartAppBrowseHistoryActivity.this.GB(SmartAppBrowseHistoryActivity.this.mpF.getItemCount());
                SmartAppBrowseHistoryActivity.this.mpF.notifyDataSetChanged();
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
                        be.bsB().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                aq aqVar = new aq("c13274");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dW("obj_source", "personal_center_list");
                aqVar.w("obj_id", smartApp.swan_app_id.longValue());
                aqVar.dW("obj_name", smartApp.name);
                aqVar.an("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aqVar);
                if (SmartAppBrowseHistoryActivity.this.mpF != null) {
                    SmartAppBrowseHistoryActivity.this.mpF.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.mpH == null) {
                    SmartAppBrowseHistoryActivity.this.mpH = new i(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.mpH.create();
                    SmartAppBrowseHistoryActivity.this.mpH.a(SmartAppBrowseHistoryActivity.this.mpJ);
                }
                SmartAppBrowseHistoryActivity.this.mpH.b(smartApp);
                SmartAppBrowseHistoryActivity.this.mpH.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener ikb = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gzj != null) {
                    SmartAppBrowseHistoryActivity.this.gzj.dettachView(SmartAppBrowseHistoryActivity.this.ent);
                    SmartAppBrowseHistoryActivity.this.gzj = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.ikg.setVisibility(0);
            }
        }
    };
    private View.OnClickListener mpK = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick() && j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        dvR();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxx = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dX(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.mpK)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.ent = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.ikg = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.ikg.setLayoutManager(new LinearLayoutManager(this));
        this.mpF = new SmartAppBrowseHistoryAdapter(getActivity());
        this.mpF.setOnItemClickListener(this.mOnItemClickListener);
        this.mpF.d(this.mOnLongClickListener);
        this.ikg.setAdapter(this.mpF);
        this.mpE = new TextView(getActivity());
        this.mpE.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.mpE.setGravity(17);
        this.mpE.setText(R.string.list_has_no_more);
        this.mpE.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dvR() {
        if (j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.ikg.setVisibility(8);
        if (this.gzj == null) {
            this.gzj = new com.baidu.tbadk.l.h(getActivity(), this.ikb);
        }
        this.gzj.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gzj.setSubText(getString(R.string.neterror));
        this.gzj.attachView(this.ent, true);
        this.gzj.showRefreshButton();
        this.gzj.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.mpF != null) {
            this.mpF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.btD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mpG == null) {
            this.mpG = new h();
            this.mpG.a(this.mpI);
        }
        this.mpG.bEv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(boolean z) {
        if (z) {
            if (this.ikg != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.ikg.removeHeaderView(this.mNoDataView);
                this.ikg.addHeaderView(this.mNoDataView);
            }
        } else if (this.ikg != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ikg.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GB(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.ikg.removeFooterView(this.mpE);
            this.ikg.addFooterView(this.mpE);
            return;
        }
        this.ikg.removeFooterView(this.mpE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gxx.onChangeSkinType(getPageContext(), i);
        if (this.gzj != null) {
            this.gzj.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.mpE != null) {
            ao.setBackgroundResource(this.mpE, R.color.CAM_X0201);
            ao.setViewTextColor(this.mpE, R.color.CAM_X0109);
        }
        ao.setBackgroundColor(this.ikg, R.color.CAM_X0201);
        if (this.mpF != null) {
            this.mpF.notifyDataSetChanged();
        }
    }
}
