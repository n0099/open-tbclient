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
    private FrameLayout cwv;
    private NoNetworkView eli;
    private com.baidu.tbadk.k.h emJ;
    private BdRecyclerView fCM;
    private TextView jlS;
    private h jlT;
    private i jlU;
    private j jlV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jlW = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.rn(true);
                SmartAppBrowseHistoryActivity.this.zT(0);
            } else if (SmartAppBrowseHistoryActivity.this.jlT != null) {
                SmartAppBrowseHistoryActivity.this.rn(v.isEmpty(aVar.cvM()));
                SmartAppBrowseHistoryActivity.this.zT(v.getCount(aVar.cvM()));
                SmartAppBrowseHistoryActivity.this.jlT.av(aVar.cvM());
                SmartAppBrowseHistoryActivity.this.jlT.notifyDataSetChanged();
            }
        }
    };
    private j.a jlX = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void GP(String str) {
            if (SmartAppBrowseHistoryActivity.this.jlT != null) {
                SmartAppBrowseHistoryActivity.this.jlT.GQ(str);
                if (SmartAppBrowseHistoryActivity.this.jlT.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.rn(true);
                }
                SmartAppBrowseHistoryActivity.this.zT(SmartAppBrowseHistoryActivity.this.jlT.getItemCount());
                SmartAppBrowseHistoryActivity.this.jlT.notifyDataSetChanged();
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
                        ba.aGG().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cy("obj_source", "personal_center_list");
                anVar.s("obj_id", smartApp.swan_app_id.longValue());
                anVar.cy("obj_name", smartApp.name);
                anVar.X("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.jlT != null) {
                    SmartAppBrowseHistoryActivity.this.jlT.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jlV == null) {
                    SmartAppBrowseHistoryActivity.this.jlV = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jlV.create();
                    SmartAppBrowseHistoryActivity.this.jlV.a(SmartAppBrowseHistoryActivity.this.jlX);
                }
                SmartAppBrowseHistoryActivity.this.jlV.c(smartApp);
                SmartAppBrowseHistoryActivity.this.jlV.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener fCH = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.emJ != null) {
                    SmartAppBrowseHistoryActivity.this.emJ.dettachView(SmartAppBrowseHistoryActivity.this.cwv);
                    SmartAppBrowseHistoryActivity.this.emJ = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.fCM.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jlY = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cwD();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eli = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cA(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jlY)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.cwv = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.fCM = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.fCM.setLayoutManager(new LinearLayoutManager(this));
        this.jlT = new h(getActivity());
        this.jlT.V(this.mOnItemClickListener);
        this.jlT.c(this.mOnLongClickListener);
        this.fCM.setAdapter(this.jlT);
        this.jlS = new TextView(getActivity());
        this.jlS.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jlS.setGravity(17);
        this.jlS.setText(R.string.list_has_no_more);
        this.jlS.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cwD() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.fCM.setVisibility(8);
        if (this.emJ == null) {
            this.emJ = new com.baidu.tbadk.k.h(getActivity(), this.fCH);
        }
        this.emJ.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.emJ.setSubText(getString(R.string.neterror));
        this.emJ.attachView(this.cwv, true);
        this.emJ.showRefreshButton();
        this.emJ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jlT != null) {
            this.jlT.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aHB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jlU == null) {
            this.jlU = new i();
            this.jlU.a(this.jlW);
        }
        this.jlU.bhT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(boolean z) {
        if (z) {
            if (this.fCM != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fCM.removeHeaderView(this.mNoDataView);
                this.fCM.addHeaderView(this.mNoDataView);
            }
        } else if (this.fCM != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fCM.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.fCM.removeFooterView(this.jlS);
            this.fCM.addFooterView(this.jlS);
            return;
        }
        this.fCM.removeFooterView(this.jlS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eli.onChangeSkinType(getPageContext(), i);
        if (this.emJ != null) {
            this.emJ.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jlS != null) {
            am.setBackgroundResource(this.jlS, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jlS, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.fCM, R.color.cp_bg_line_d);
        if (this.jlT != null) {
            this.jlT.notifyDataSetChanged();
        }
    }
}
