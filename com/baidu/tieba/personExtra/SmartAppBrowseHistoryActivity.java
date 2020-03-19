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
    private FrameLayout cwH;
    private NoNetworkView elL;
    private com.baidu.tbadk.k.h eno;
    private BdRecyclerView fDH;
    private TextView jnE;
    private h jnF;
    private i jnG;
    private j jnH;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a jnI = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.rt(true);
                SmartAppBrowseHistoryActivity.this.Ab(0);
            } else if (SmartAppBrowseHistoryActivity.this.jnF != null) {
                SmartAppBrowseHistoryActivity.this.rt(v.isEmpty(aVar.cwg()));
                SmartAppBrowseHistoryActivity.this.Ab(v.getCount(aVar.cwg()));
                SmartAppBrowseHistoryActivity.this.jnF.av(aVar.cwg());
                SmartAppBrowseHistoryActivity.this.jnF.notifyDataSetChanged();
            }
        }
    };
    private j.a jnJ = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void GQ(String str) {
            if (SmartAppBrowseHistoryActivity.this.jnF != null) {
                SmartAppBrowseHistoryActivity.this.jnF.GR(str);
                if (SmartAppBrowseHistoryActivity.this.jnF.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.rt(true);
                }
                SmartAppBrowseHistoryActivity.this.Ab(SmartAppBrowseHistoryActivity.this.jnF.getItemCount());
                SmartAppBrowseHistoryActivity.this.jnF.notifyDataSetChanged();
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
                        ba.aGK().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.cx("obj_source", "personal_center_list");
                anVar.s("obj_id", smartApp.swan_app_id.longValue());
                anVar.cx("obj_name", smartApp.name);
                anVar.X("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.jnF != null) {
                    SmartAppBrowseHistoryActivity.this.jnF.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.jnH == null) {
                    SmartAppBrowseHistoryActivity.this.jnH = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.jnH.create();
                    SmartAppBrowseHistoryActivity.this.jnH.a(SmartAppBrowseHistoryActivity.this.jnJ);
                }
                SmartAppBrowseHistoryActivity.this.jnH.c(smartApp);
                SmartAppBrowseHistoryActivity.this.jnH.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener fDC = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.eno != null) {
                    SmartAppBrowseHistoryActivity.this.eno.dettachView(SmartAppBrowseHistoryActivity.this.cwH);
                    SmartAppBrowseHistoryActivity.this.eno = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.fDH.setVisibility(0);
            }
        }
    };
    private View.OnClickListener jnK = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cwX();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.elL = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cz(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.jnK)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.cwH = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.fDH = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.fDH.setLayoutManager(new LinearLayoutManager(this));
        this.jnF = new h(getActivity());
        this.jnF.V(this.mOnItemClickListener);
        this.jnF.c(this.mOnLongClickListener);
        this.fDH.setAdapter(this.jnF);
        this.jnE = new TextView(getActivity());
        this.jnE.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.jnE.setGravity(17);
        this.jnE.setText(R.string.list_has_no_more);
        this.jnE.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cwX() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.fDH.setVisibility(8);
        if (this.eno == null) {
            this.eno = new com.baidu.tbadk.k.h(getActivity(), this.fDC);
        }
        this.eno.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.eno.setSubText(getString(R.string.neterror));
        this.eno.attachView(this.cwH, true);
        this.eno.showRefreshButton();
        this.eno.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.jnF != null) {
            this.jnF.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aHG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.jnG == null) {
            this.jnG = new i();
            this.jnG.a(this.jnI);
        }
        this.jnG.bhZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(boolean z) {
        if (z) {
            if (this.fDH != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.fDH.removeHeaderView(this.mNoDataView);
                this.fDH.addHeaderView(this.mNoDataView);
            }
        } else if (this.fDH != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.fDH.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.fDH.removeFooterView(this.jnE);
            this.fDH.addFooterView(this.jnE);
            return;
        }
        this.fDH.removeFooterView(this.jnE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.elL.onChangeSkinType(getPageContext(), i);
        if (this.eno != null) {
            this.eno.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.jnE != null) {
            am.setBackgroundResource(this.jnE, R.color.cp_bg_line_d);
            am.setViewTextColor(this.jnE, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.fDH, R.color.cp_bg_line_d);
        if (this.jnF != null) {
            this.jnF.notifyDataSetChanged();
        }
    }
}
