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
    private FrameLayout cwu;
    private NoNetworkView elh;
    private com.baidu.tbadk.k.h emI;
    private BdRecyclerView fCK;
    private TextView jlQ;
    private h jlR;
    private i jlS;
    private j jlT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jlU = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.rn(true);
                SmartAppBrowseHistoryActivity.this.zT(0);
            } else if (SmartAppBrowseHistoryActivity.this.jlR != null) {
                SmartAppBrowseHistoryActivity.this.rn(v.isEmpty(aVar.cvK()));
                SmartAppBrowseHistoryActivity.this.zT(v.getCount(aVar.cvK()));
                SmartAppBrowseHistoryActivity.this.jlR.av(aVar.cvK());
                SmartAppBrowseHistoryActivity.this.jlR.notifyDataSetChanged();
            }
        }
    };
    private j.a jlV = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void GP(String str) {
            if (SmartAppBrowseHistoryActivity.this.jlR != null) {
                SmartAppBrowseHistoryActivity.this.jlR.GQ(str);
                if (SmartAppBrowseHistoryActivity.this.jlR.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.rn(true);
                }
                SmartAppBrowseHistoryActivity.this.zT(SmartAppBrowseHistoryActivity.this.jlR.getItemCount());
                SmartAppBrowseHistoryActivity.this.jlR.notifyDataSetChanged();
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
                        ba.aGE().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
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
                if (SmartAppBrowseHistoryActivity.this.jlR != null) {
                    SmartAppBrowseHistoryActivity.this.jlR.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jlT == null) {
                    SmartAppBrowseHistoryActivity.this.jlT = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jlT.create();
                    SmartAppBrowseHistoryActivity.this.jlT.a(SmartAppBrowseHistoryActivity.this.jlV);
                }
                SmartAppBrowseHistoryActivity.this.jlT.c(smartApp);
                SmartAppBrowseHistoryActivity.this.jlT.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener fCF = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.emI != null) {
                    SmartAppBrowseHistoryActivity.this.emI.dettachView(SmartAppBrowseHistoryActivity.this.cwu);
                    SmartAppBrowseHistoryActivity.this.emI = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.fCK.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jlW = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cwB();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.elh = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cA(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jlW)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.cwu = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.fCK = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.fCK.setLayoutManager(new LinearLayoutManager(this));
        this.jlR = new h(getActivity());
        this.jlR.V(this.mOnItemClickListener);
        this.jlR.c(this.mOnLongClickListener);
        this.fCK.setAdapter(this.jlR);
        this.jlQ = new TextView(getActivity());
        this.jlQ.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jlQ.setGravity(17);
        this.jlQ.setText(R.string.list_has_no_more);
        this.jlQ.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cwB() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.fCK.setVisibility(8);
        if (this.emI == null) {
            this.emI = new com.baidu.tbadk.k.h(getActivity(), this.fCF);
        }
        this.emI.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.emI.setSubText(getString(R.string.neterror));
        this.emI.attachView(this.cwu, true);
        this.emI.showRefreshButton();
        this.emI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jlR != null) {
            this.jlR.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aHz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jlS == null) {
            this.jlS = new i();
            this.jlS.a(this.jlU);
        }
        this.jlS.bhR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(boolean z) {
        if (z) {
            if (this.fCK != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fCK.removeHeaderView(this.mNoDataView);
                this.fCK.addHeaderView(this.mNoDataView);
            }
        } else if (this.fCK != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fCK.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.fCK.removeFooterView(this.jlQ);
            this.fCK.addFooterView(this.jlQ);
            return;
        }
        this.fCK.removeFooterView(this.jlQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elh.onChangeSkinType(getPageContext(), i);
        if (this.emI != null) {
            this.emI.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jlQ != null) {
            am.setBackgroundResource(this.jlQ, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jlQ, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.fCK, R.color.cp_bg_line_d);
        if (this.jlR != null) {
            this.jlR.notifyDataSetChanged();
        }
    }
}
