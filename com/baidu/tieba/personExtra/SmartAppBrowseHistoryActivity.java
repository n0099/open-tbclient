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
    private FrameLayout cww;
    private NoNetworkView elv;
    private com.baidu.tbadk.k.h emW;
    private BdRecyclerView fCZ;
    private TextView jme;
    private h jmf;
    private i jmg;
    private j jmh;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jmi = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.rn(true);
                SmartAppBrowseHistoryActivity.this.zT(0);
            } else if (SmartAppBrowseHistoryActivity.this.jmf != null) {
                SmartAppBrowseHistoryActivity.this.rn(v.isEmpty(aVar.cvN()));
                SmartAppBrowseHistoryActivity.this.zT(v.getCount(aVar.cvN()));
                SmartAppBrowseHistoryActivity.this.jmf.av(aVar.cvN());
                SmartAppBrowseHistoryActivity.this.jmf.notifyDataSetChanged();
            }
        }
    };
    private j.a jmj = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void GQ(String str) {
            if (SmartAppBrowseHistoryActivity.this.jmf != null) {
                SmartAppBrowseHistoryActivity.this.jmf.GR(str);
                if (SmartAppBrowseHistoryActivity.this.jmf.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.rn(true);
                }
                SmartAppBrowseHistoryActivity.this.zT(SmartAppBrowseHistoryActivity.this.jmf.getItemCount());
                SmartAppBrowseHistoryActivity.this.jmf.notifyDataSetChanged();
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
                if (SmartAppBrowseHistoryActivity.this.jmf != null) {
                    SmartAppBrowseHistoryActivity.this.jmf.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jmh == null) {
                    SmartAppBrowseHistoryActivity.this.jmh = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jmh.create();
                    SmartAppBrowseHistoryActivity.this.jmh.a(SmartAppBrowseHistoryActivity.this.jmj);
                }
                SmartAppBrowseHistoryActivity.this.jmh.c(smartApp);
                SmartAppBrowseHistoryActivity.this.jmh.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener fCU = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.emW != null) {
                    SmartAppBrowseHistoryActivity.this.emW.dettachView(SmartAppBrowseHistoryActivity.this.cww);
                    SmartAppBrowseHistoryActivity.this.emW = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.fCZ.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jmk = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cwE();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.elv = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cA(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jmk)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.cww = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.fCZ = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.fCZ.setLayoutManager(new LinearLayoutManager(this));
        this.jmf = new h(getActivity());
        this.jmf.V(this.mOnItemClickListener);
        this.jmf.c(this.mOnLongClickListener);
        this.fCZ.setAdapter(this.jmf);
        this.jme = new TextView(getActivity());
        this.jme.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jme.setGravity(17);
        this.jme.setText(R.string.list_has_no_more);
        this.jme.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cwE() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.fCZ.setVisibility(8);
        if (this.emW == null) {
            this.emW = new com.baidu.tbadk.k.h(getActivity(), this.fCU);
        }
        this.emW.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.emW.setSubText(getString(R.string.neterror));
        this.emW.attachView(this.cww, true);
        this.emW.showRefreshButton();
        this.emW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jmf != null) {
            this.jmf.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aHC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jmg == null) {
            this.jmg = new i();
            this.jmg.a(this.jmi);
        }
        this.jmg.bhU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(boolean z) {
        if (z) {
            if (this.fCZ != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fCZ.removeHeaderView(this.mNoDataView);
                this.fCZ.addHeaderView(this.mNoDataView);
            }
        } else if (this.fCZ != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fCZ.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.fCZ.removeFooterView(this.jme);
            this.fCZ.addFooterView(this.jme);
            return;
        }
        this.fCZ.removeFooterView(this.jme);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elv.onChangeSkinType(getPageContext(), i);
        if (this.emW != null) {
            this.emW.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jme != null) {
            am.setBackgroundResource(this.jme, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jme, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.fCZ, R.color.cp_bg_line_d);
        if (this.jmf != null) {
            this.jmf.notifyDataSetChanged();
        }
    }
}
