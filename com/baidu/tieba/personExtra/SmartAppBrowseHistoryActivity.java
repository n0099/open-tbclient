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
    private FrameLayout dPx;
    private NoNetworkView fTu;
    private com.baidu.tbadk.k.h fVg;
    private BdRecyclerView hyA;
    private TextView lIc;
    private h lId;
    private i lIe;
    private j lIf;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a lIg = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.vq(true);
                SmartAppBrowseHistoryActivity.this.Gt(0);
            } else if (SmartAppBrowseHistoryActivity.this.lId != null) {
                SmartAppBrowseHistoryActivity.this.vq(y.isEmpty(aVar.doz()));
                SmartAppBrowseHistoryActivity.this.Gt(y.getCount(aVar.doz()));
                SmartAppBrowseHistoryActivity.this.lId.aR(aVar.doz());
                SmartAppBrowseHistoryActivity.this.lId.notifyDataSetChanged();
            }
        }
    };
    private j.a lIh = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void PM(String str) {
            if (SmartAppBrowseHistoryActivity.this.lId != null) {
                SmartAppBrowseHistoryActivity.this.lId.PN(str);
                if (SmartAppBrowseHistoryActivity.this.lId.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.vq(true);
                }
                SmartAppBrowseHistoryActivity.this.Gt(SmartAppBrowseHistoryActivity.this.lId.getItemCount());
                SmartAppBrowseHistoryActivity.this.lId.notifyDataSetChanged();
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
                        be.bmY().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                aq aqVar = new aq("c13274");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dK("obj_source", "personal_center_list");
                aqVar.u("obj_id", smartApp.swan_app_id.longValue());
                aqVar.dK("obj_name", smartApp.name);
                aqVar.aj("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aqVar);
                if (SmartAppBrowseHistoryActivity.this.lId != null) {
                    SmartAppBrowseHistoryActivity.this.lId.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.lIf == null) {
                    SmartAppBrowseHistoryActivity.this.lIf = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.lIf.create();
                    SmartAppBrowseHistoryActivity.this.lIf.a(SmartAppBrowseHistoryActivity.this.lIh);
                }
                SmartAppBrowseHistoryActivity.this.lIf.b(smartApp);
                SmartAppBrowseHistoryActivity.this.lIf.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener hyv = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fVg != null) {
                    SmartAppBrowseHistoryActivity.this.fVg.dettachView(SmartAppBrowseHistoryActivity.this.dPx);
                    SmartAppBrowseHistoryActivity.this.fVg = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.hyA.setVisibility(0);
            }
        }
    };
    private View.OnClickListener lIi = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dpr();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fTu = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dL(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.lIi)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dPx = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.hyA = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.hyA.setLayoutManager(new LinearLayoutManager(this));
        this.lId = new h(getActivity());
        this.lId.setOnItemClickListener(this.mOnItemClickListener);
        this.lId.d(this.mOnLongClickListener);
        this.hyA.setAdapter(this.lId);
        this.lIc = new TextView(getActivity());
        this.lIc.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.lIc.setGravity(17);
        this.lIc.setText(R.string.list_has_no_more);
        this.lIc.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dpr() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.hyA.setVisibility(8);
        if (this.fVg == null) {
            this.fVg = new com.baidu.tbadk.k.h(getActivity(), this.hyv);
        }
        this.fVg.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fVg.setSubText(getString(R.string.neterror));
        this.fVg.attachView(this.dPx, true);
        this.fVg.showRefreshButton();
        this.fVg.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.lId != null) {
            this.lId.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bnV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.lIe == null) {
            this.lIe = new i();
            this.lIe.a(this.lIg);
        }
        this.lIe.byF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(boolean z) {
        if (z) {
            if (this.hyA != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.hyA.removeHeaderView(this.mNoDataView);
                this.hyA.addHeaderView(this.mNoDataView);
            }
        } else if (this.hyA != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hyA.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.hyA.removeFooterView(this.lIc);
            this.hyA.addFooterView(this.lIc);
            return;
        }
        this.hyA.removeFooterView(this.lIc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fTu.onChangeSkinType(getPageContext(), i);
        if (this.fVg != null) {
            this.fVg.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.lIc != null) {
            ap.setBackgroundResource(this.lIc, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.lIc, R.color.cp_cont_d);
        }
        ap.setBackgroundColor(this.hyA, R.color.cp_bg_line_d);
        if (this.lId != null) {
            this.lId.notifyDataSetChanged();
        }
    }
}
