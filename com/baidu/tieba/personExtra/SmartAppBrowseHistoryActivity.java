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
    private FrameLayout dgJ;
    private NoNetworkView fbX;
    private com.baidu.tbadk.k.h fdA;
    private BdRecyclerView gxh;
    private TextView kpP;
    private h kpQ;
    private i kpR;
    private j kpS;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private i.a kpT = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.sV(true);
                SmartAppBrowseHistoryActivity.this.Bn(0);
            } else if (SmartAppBrowseHistoryActivity.this.kpQ != null) {
                SmartAppBrowseHistoryActivity.this.sV(v.isEmpty(aVar.cNO()));
                SmartAppBrowseHistoryActivity.this.Bn(v.getCount(aVar.cNO()));
                SmartAppBrowseHistoryActivity.this.kpQ.az(aVar.cNO());
                SmartAppBrowseHistoryActivity.this.kpQ.notifyDataSetChanged();
            }
        }
    };
    private j.a kpU = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Km(String str) {
            if (SmartAppBrowseHistoryActivity.this.kpQ != null) {
                SmartAppBrowseHistoryActivity.this.kpQ.Kn(str);
                if (SmartAppBrowseHistoryActivity.this.kpQ.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.sV(true);
                }
                SmartAppBrowseHistoryActivity.this.Bn(SmartAppBrowseHistoryActivity.this.kpQ.getItemCount());
                SmartAppBrowseHistoryActivity.this.kpQ.notifyDataSetChanged();
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
                        ba.aUZ().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                an anVar = new an("c13274");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.dh("obj_source", "personal_center_list");
                anVar.s("obj_id", smartApp.swan_app_id.longValue());
                anVar.dh("obj_name", smartApp.name);
                anVar.ag("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(anVar);
                if (SmartAppBrowseHistoryActivity.this.kpQ != null) {
                    SmartAppBrowseHistoryActivity.this.kpQ.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.kpS == null) {
                    SmartAppBrowseHistoryActivity.this.kpS = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.kpS.create();
                    SmartAppBrowseHistoryActivity.this.kpS.a(SmartAppBrowseHistoryActivity.this.kpU);
                }
                SmartAppBrowseHistoryActivity.this.kpS.b(smartApp);
                SmartAppBrowseHistoryActivity.this.kpS.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener gxc = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.fdA != null) {
                    SmartAppBrowseHistoryActivity.this.fdA.dettachView(SmartAppBrowseHistoryActivity.this.dgJ);
                    SmartAppBrowseHistoryActivity.this.fdA = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.gxh.setVisibility(0);
            }
        }
    };
    private View.OnClickListener kpV = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        cOF();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fbX = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dj(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.kpV)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.dgJ = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.gxh = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.gxh.setLayoutManager(new LinearLayoutManager(this));
        this.kpQ = new h(getActivity());
        this.kpQ.W(this.mOnItemClickListener);
        this.kpQ.d(this.mOnLongClickListener);
        this.gxh.setAdapter(this.kpQ);
        this.kpP = new TextView(getActivity());
        this.kpP.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.kpP.setGravity(17);
        this.kpP.setText(R.string.list_has_no_more);
        this.kpP.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void cOF() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.gxh.setVisibility(8);
        if (this.fdA == null) {
            this.fdA = new com.baidu.tbadk.k.h(getActivity(), this.gxc);
        }
        this.fdA.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.fdA.setSubText(getString(R.string.neterror));
        this.fdA.attachView(this.dgJ, true);
        this.fdA.showRefreshButton();
        this.fdA.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.kpQ != null) {
            this.kpQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.aVZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.kpR == null) {
            this.kpR = new i();
            this.kpR.a(this.kpT);
        }
        this.kpR.bsZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sV(boolean z) {
        if (z) {
            if (this.gxh != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.gxh.removeHeaderView(this.mNoDataView);
                this.gxh.addHeaderView(this.mNoDataView);
            }
        } else if (this.gxh != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.gxh.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.gxh.removeFooterView(this.kpP);
            this.gxh.addFooterView(this.kpP);
            return;
        }
        this.gxh.removeFooterView(this.kpP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fbX.onChangeSkinType(getPageContext(), i);
        if (this.fdA != null) {
            this.fdA.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.kpP != null) {
            am.setBackgroundResource(this.kpP, R.color.cp_bg_line_d);
            am.setViewTextColor(this.kpP, (int) R.color.cp_cont_d);
        }
        am.setBackgroundColor(this.gxh, R.color.cp_bg_line_d);
        if (this.kpQ != null) {
            this.kpQ.notifyDataSetChanged();
        }
    }
}
