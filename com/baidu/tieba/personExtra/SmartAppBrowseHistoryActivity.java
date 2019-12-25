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
/* loaded from: classes8.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout csh;
    private NoNetworkView egT;
    private com.baidu.tbadk.k.h ehM;
    private BdRecyclerView fxb;
    private TextView jhq;
    private h jhr;
    private i jhs;
    private j jht;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jhu = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.qW(true);
                SmartAppBrowseHistoryActivity.this.zH(0);
            } else if (SmartAppBrowseHistoryActivity.this.jhr != null) {
                SmartAppBrowseHistoryActivity.this.qW(v.isEmpty(aVar.cti()));
                SmartAppBrowseHistoryActivity.this.zH(v.getCount(aVar.cti()));
                SmartAppBrowseHistoryActivity.this.jhr.aw(aVar.cti());
                SmartAppBrowseHistoryActivity.this.jhr.notifyDataSetChanged();
            }
        }
    };
    private j.a jhv = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Gr(String str) {
            if (SmartAppBrowseHistoryActivity.this.jhr != null) {
                SmartAppBrowseHistoryActivity.this.jhr.Gs(str);
                if (SmartAppBrowseHistoryActivity.this.jhr.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.qW(true);
                }
                SmartAppBrowseHistoryActivity.this.zH(SmartAppBrowseHistoryActivity.this.jhr.getItemCount());
                SmartAppBrowseHistoryActivity.this.jhr.notifyDataSetChanged();
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
                        ba.aEa().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cp("obj_source", "personal_center_list");
                anVar.s("obj_id", smartApp.swan_app_id.longValue());
                anVar.cp("obj_name", smartApp.name);
                anVar.Z("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.jhr != null) {
                    SmartAppBrowseHistoryActivity.this.jhr.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jht == null) {
                    SmartAppBrowseHistoryActivity.this.jht = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jht.create();
                    SmartAppBrowseHistoryActivity.this.jht.a(SmartAppBrowseHistoryActivity.this.jhv);
                }
                SmartAppBrowseHistoryActivity.this.jht.c(smartApp);
                SmartAppBrowseHistoryActivity.this.jht.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener fwW = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.ehM != null) {
                    SmartAppBrowseHistoryActivity.this.ehM.dettachView(SmartAppBrowseHistoryActivity.this.csh);
                    SmartAppBrowseHistoryActivity.this.ehM = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.fxb.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jhw = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        ctZ();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.egT = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cr(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jhw)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.csh = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.fxb = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.fxb.setLayoutManager(new LinearLayoutManager(this));
        this.jhr = new h(getActivity());
        this.jhr.W(this.mOnItemClickListener);
        this.jhr.c(this.mOnLongClickListener);
        this.fxb.setAdapter(this.jhr);
        this.jhq = new TextView(getActivity());
        this.jhq.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jhq.setGravity(17);
        this.jhq.setText(R.string.list_has_no_more);
        this.jhq.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void ctZ() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.fxb.setVisibility(8);
        if (this.ehM == null) {
            this.ehM = new com.baidu.tbadk.k.h(getActivity(), this.fwW);
        }
        this.ehM.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.ehM.setSubText(getString(R.string.neterror));
        this.ehM.attachView(this.csh, true);
        this.ehM.showRefreshButton();
        this.ehM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jhr != null) {
            this.jhr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aEU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jhs == null) {
            this.jhs = new i();
            this.jhs.a(this.jhu);
        }
        this.jhs.bfk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(boolean z) {
        if (z) {
            if (this.fxb != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fxb.removeHeaderView(this.mNoDataView);
                this.fxb.addHeaderView(this.mNoDataView);
            }
        } else if (this.fxb != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fxb.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zH(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.fxb.removeFooterView(this.jhq);
            this.fxb.addFooterView(this.jhq);
            return;
        }
        this.fxb.removeFooterView(this.jhq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.egT.onChangeSkinType(getPageContext(), i);
        if (this.ehM != null) {
            this.ehM.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jhq != null) {
            am.setBackgroundResource(this.jhq, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jhq, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.fxb, R.color.cp_bg_line_d);
        if (this.jhr != null) {
            this.jhr.notifyDataSetChanged();
        }
    }
}
