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
/* loaded from: classes9.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout css;
    private NoNetworkView ehd;
    private com.baidu.tbadk.k.h eiA;
    private BdRecyclerView fAm;
    private TextView jkX;
    private h jkY;
    private i jkZ;
    private j jla;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jlb = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.rj(true);
                SmartAppBrowseHistoryActivity.this.zM(0);
            } else if (SmartAppBrowseHistoryActivity.this.jkY != null) {
                SmartAppBrowseHistoryActivity.this.rj(v.isEmpty(aVar.cur()));
                SmartAppBrowseHistoryActivity.this.zM(v.getCount(aVar.cur()));
                SmartAppBrowseHistoryActivity.this.jkY.av(aVar.cur());
                SmartAppBrowseHistoryActivity.this.jkY.notifyDataSetChanged();
            }
        }
    };
    private j.a jlc = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void GB(String str) {
            if (SmartAppBrowseHistoryActivity.this.jkY != null) {
                SmartAppBrowseHistoryActivity.this.jkY.GC(str);
                if (SmartAppBrowseHistoryActivity.this.jkY.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.rj(true);
                }
                SmartAppBrowseHistoryActivity.this.zM(SmartAppBrowseHistoryActivity.this.jkY.getItemCount());
                SmartAppBrowseHistoryActivity.this.jkY.notifyDataSetChanged();
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
                        ba.aEt().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
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
                if (SmartAppBrowseHistoryActivity.this.jkY != null) {
                    SmartAppBrowseHistoryActivity.this.jkY.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jla == null) {
                    SmartAppBrowseHistoryActivity.this.jla = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jla.create();
                    SmartAppBrowseHistoryActivity.this.jla.a(SmartAppBrowseHistoryActivity.this.jlc);
                }
                SmartAppBrowseHistoryActivity.this.jla.c(smartApp);
                SmartAppBrowseHistoryActivity.this.jla.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener fAh = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.eiA != null) {
                    SmartAppBrowseHistoryActivity.this.eiA.dettachView(SmartAppBrowseHistoryActivity.this.css);
                    SmartAppBrowseHistoryActivity.this.eiA = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.fAm.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jld = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cvi();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ehd = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cr(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jld)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.css = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.fAm = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.fAm.setLayoutManager(new LinearLayoutManager(this));
        this.jkY = new h(getActivity());
        this.jkY.V(this.mOnItemClickListener);
        this.jkY.c(this.mOnLongClickListener);
        this.fAm.setAdapter(this.jkY);
        this.jkX = new TextView(getActivity());
        this.jkX.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jkX.setGravity(17);
        this.jkX.setText(R.string.list_has_no_more);
        this.jkX.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cvi() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.fAm.setVisibility(8);
        if (this.eiA == null) {
            this.eiA = new com.baidu.tbadk.k.h(getActivity(), this.fAh);
        }
        this.eiA.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.eiA.setSubText(getString(R.string.neterror));
        this.eiA.attachView(this.css, true);
        this.eiA.showRefreshButton();
        this.eiA.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jkY != null) {
            this.jkY.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aFn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jkZ == null) {
            this.jkZ = new i();
            this.jkZ.a(this.jlb);
        }
        this.jkZ.bfI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj(boolean z) {
        if (z) {
            if (this.fAm != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fAm.removeHeaderView(this.mNoDataView);
                this.fAm.addHeaderView(this.mNoDataView);
            }
        } else if (this.fAm != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fAm.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.fAm.removeFooterView(this.jkX);
            this.fAm.addFooterView(this.jkX);
            return;
        }
        this.fAm.removeFooterView(this.jkX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ehd.onChangeSkinType(getPageContext(), i);
        if (this.eiA != null) {
            this.eiA.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jkX != null) {
            am.setBackgroundResource(this.jkX, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jkX, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.fAm, R.color.cp_bg_line_d);
        if (this.jkY != null) {
            this.jkY.notifyDataSetChanged();
        }
    }
}
