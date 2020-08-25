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
    private FrameLayout dBr;
    private NoNetworkView fDV;
    private com.baidu.tbadk.k.h fFz;
    private BdRecyclerView hcC;
    private TextView ljM;
    private h ljN;
    private i ljO;
    private j ljP;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ljQ = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.uz(true);
                SmartAppBrowseHistoryActivity.this.Fm(0);
            } else if (SmartAppBrowseHistoryActivity.this.ljN != null) {
                SmartAppBrowseHistoryActivity.this.uz(y.isEmpty(aVar.dhj()));
                SmartAppBrowseHistoryActivity.this.Fm(y.getCount(aVar.dhj()));
                SmartAppBrowseHistoryActivity.this.ljN.aK(aVar.dhj());
                SmartAppBrowseHistoryActivity.this.ljN.notifyDataSetChanged();
            }
        }
    };
    private j.a ljR = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Ov(String str) {
            if (SmartAppBrowseHistoryActivity.this.ljN != null) {
                SmartAppBrowseHistoryActivity.this.ljN.Ow(str);
                if (SmartAppBrowseHistoryActivity.this.ljN.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.uz(true);
                }
                SmartAppBrowseHistoryActivity.this.Fm(SmartAppBrowseHistoryActivity.this.ljN.getItemCount());
                SmartAppBrowseHistoryActivity.this.ljN.notifyDataSetChanged();
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
                if (SmartAppBrowseHistoryActivity.this.ljN != null) {
                    SmartAppBrowseHistoryActivity.this.ljN.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ljP == null) {
                    SmartAppBrowseHistoryActivity.this.ljP = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ljP.create();
                    SmartAppBrowseHistoryActivity.this.ljP.a(SmartAppBrowseHistoryActivity.this.ljR);
                }
                SmartAppBrowseHistoryActivity.this.ljP.b(smartApp);
                SmartAppBrowseHistoryActivity.this.ljP.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener hcx = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fFz != null) {
                    SmartAppBrowseHistoryActivity.this.fFz.dettachView(SmartAppBrowseHistoryActivity.this.dBr);
                    SmartAppBrowseHistoryActivity.this.fFz = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.hcC.setVisibility(0);
            }
        }
    };
    private View.OnClickListener ljS = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dib();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fDV = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dE(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.ljS)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dBr = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.hcC = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.hcC.setLayoutManager(new LinearLayoutManager(this));
        this.ljN = new h(getActivity());
        this.ljN.setOnItemClickListener(this.mOnItemClickListener);
        this.ljN.d(this.mOnLongClickListener);
        this.hcC.setAdapter(this.ljN);
        this.ljM = new TextView(getActivity());
        this.ljM.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.ljM.setGravity(17);
        this.ljM.setText(R.string.list_has_no_more);
        this.ljM.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dib() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.hcC.setVisibility(8);
        if (this.fFz == null) {
            this.fFz = new com.baidu.tbadk.k.h(getActivity(), this.hcx);
        }
        this.fFz.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fFz.setSubText(getString(R.string.neterror));
        this.fFz.attachView(this.dBr, true);
        this.fFz.showRefreshButton();
        this.fFz.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ljN != null) {
            this.ljN.notifyDataSetChanged();
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
        if (this.ljO == null) {
            this.ljO = new i();
            this.ljO.a(this.ljQ);
        }
        this.ljO.buQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(boolean z) {
        if (z) {
            if (this.hcC != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.hcC.removeHeaderView(this.mNoDataView);
                this.hcC.addHeaderView(this.mNoDataView);
            }
        } else if (this.hcC != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hcC.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.hcC.removeFooterView(this.ljM);
            this.hcC.addFooterView(this.ljM);
            return;
        }
        this.hcC.removeFooterView(this.ljM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fDV.onChangeSkinType(getPageContext(), i);
        if (this.fFz != null) {
            this.fFz.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ljM != null) {
            ap.setBackgroundResource(this.ljM, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.ljM, R.color.cp_cont_d);
        }
        ap.setBackgroundColor(this.hcC, R.color.cp_bg_line_d);
        if (this.ljN != null) {
            this.ljN.notifyDataSetChanged();
        }
    }
}
