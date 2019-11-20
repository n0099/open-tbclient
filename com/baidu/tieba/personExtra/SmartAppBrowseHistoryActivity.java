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
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.i;
import com.baidu.tieba.personExtra.j;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout bGR;
    private NoNetworkView dvR;
    private com.baidu.tbadk.m.h dwK;
    private BdRecyclerView eFd;
    private TextView ioZ;
    private h ipa;
    private i ipb;
    private j ipc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a ipd = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.pu(true);
                SmartAppBrowseHistoryActivity.this.xv(0);
            } else if (SmartAppBrowseHistoryActivity.this.ipa != null) {
                SmartAppBrowseHistoryActivity.this.pu(v.isEmpty(aVar.bZO()));
                SmartAppBrowseHistoryActivity.this.xv(v.getCount(aVar.bZO()));
                SmartAppBrowseHistoryActivity.this.ipa.aq(aVar.bZO());
                SmartAppBrowseHistoryActivity.this.ipa.notifyDataSetChanged();
            }
        }
    };
    private j.a ipe = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void BF(String str) {
            if (SmartAppBrowseHistoryActivity.this.ipa != null) {
                SmartAppBrowseHistoryActivity.this.ipa.BG(str);
                if (SmartAppBrowseHistoryActivity.this.ipa.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.pu(true);
                }
                SmartAppBrowseHistoryActivity.this.xv(SmartAppBrowseHistoryActivity.this.ipa.getItemCount());
                SmartAppBrowseHistoryActivity.this.ipa.notifyDataSetChanged();
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
                        ba.amO().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bS("obj_source", "personal_center_list");
                anVar.p("obj_id", smartApp.swan_app_id.longValue());
                anVar.bS("obj_name", smartApp.name);
                anVar.O("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.ipa != null) {
                    SmartAppBrowseHistoryActivity.this.ipa.b(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.ipc == null) {
                    SmartAppBrowseHistoryActivity.this.ipc = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.ipc.create();
                    SmartAppBrowseHistoryActivity.this.ipc.a(SmartAppBrowseHistoryActivity.this.ipe);
                }
                SmartAppBrowseHistoryActivity.this.ipc.c(smartApp);
                SmartAppBrowseHistoryActivity.this.ipc.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener eEY = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.dwK != null) {
                    SmartAppBrowseHistoryActivity.this.dwK.dettachView(SmartAppBrowseHistoryActivity.this.bGR);
                    SmartAppBrowseHistoryActivity.this.dwK = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.eFd.setVisibility(0);
            }
        }
    };
    private View.OnClickListener ipf = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.tbadk.util.i.isFastDoubleClick() && com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        caC();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dvR = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.bU(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.ipf)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.bGR = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.eFd = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.eFd.setLayoutManager(new LinearLayoutManager(this));
        this.ipa = new h(getActivity());
        this.ipa.V(this.mOnItemClickListener);
        this.ipa.d(this.mOnLongClickListener);
        this.eFd.setAdapter(this.ipa);
        this.ioZ = new TextView(getActivity());
        this.ioZ.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.ioZ.setGravity(17);
        this.ioZ.setText(R.string.list_has_no_more);
        this.ioZ.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void caC() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.eFd.setVisibility(8);
        if (this.dwK == null) {
            this.dwK = new com.baidu.tbadk.m.h(getActivity(), this.eEY);
        }
        this.dwK.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.dwK.setSubText(getString(R.string.neterror));
        this.dwK.attachView(this.bGR, true);
        this.dwK.showRefreshButton();
        this.dwK.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.ipa != null) {
            this.ipa.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.anE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.ipb == null) {
            this.ipb = new i();
            this.ipb.a(this.ipd);
        }
        this.ipb.aNO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (z) {
            if (this.eFd != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.eFd.removeHeaderView(this.mNoDataView);
                this.eFd.addHeaderView(this.mNoDataView);
            }
        } else if (this.eFd != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.eFd.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.eFd.removeFooterView(this.ioZ);
            this.eFd.addFooterView(this.ioZ);
            return;
        }
        this.eFd.removeFooterView(this.ioZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvR.onChangeSkinType(getPageContext(), i);
        if (this.dwK != null) {
            this.dwK.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.ioZ != null) {
            am.setBackgroundResource(this.ioZ, R.color.cp_bg_line_d);
            am.setViewTextColor(this.ioZ, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.eFd, R.color.cp_bg_line_d);
        if (this.ipa != null) {
            this.ipa.notifyDataSetChanged();
        }
    }
}
