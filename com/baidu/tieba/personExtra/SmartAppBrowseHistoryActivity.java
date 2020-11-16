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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes23.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout ecd;
    private NoNetworkView giU;
    private com.baidu.tbadk.k.h gkG;
    private BdRecyclerView hRt;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView maP;
    private h maQ;
    private i maR;
    private j maS;
    private i.a maT = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.vT(true);
                SmartAppBrowseHistoryActivity.this.Hx(0);
            } else if (SmartAppBrowseHistoryActivity.this.maQ != null) {
                SmartAppBrowseHistoryActivity.this.vT(y.isEmpty(aVar.dtI()));
                SmartAppBrowseHistoryActivity.this.Hx(y.getCount(aVar.dtI()));
                SmartAppBrowseHistoryActivity.this.maQ.bi(aVar.dtI());
                SmartAppBrowseHistoryActivity.this.maQ.notifyDataSetChanged();
            }
        }
    };
    private j.a maU = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void PW(String str) {
            if (SmartAppBrowseHistoryActivity.this.maQ != null) {
                SmartAppBrowseHistoryActivity.this.maQ.PX(str);
                if (SmartAppBrowseHistoryActivity.this.maQ.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.vT(true);
                }
                SmartAppBrowseHistoryActivity.this.Hx(SmartAppBrowseHistoryActivity.this.maQ.getItemCount());
                SmartAppBrowseHistoryActivity.this.maQ.notifyDataSetChanged();
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
                    if (!au.isEmpty(smartApp.h5_url)) {
                        bf.bqF().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                ar arVar = new ar("c13274");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("obj_source", "personal_center_list");
                arVar.w("obj_id", smartApp.swan_app_id.longValue());
                arVar.dR("obj_name", smartApp.name);
                arVar.ak("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(arVar);
                if (SmartAppBrowseHistoryActivity.this.maQ != null) {
                    SmartAppBrowseHistoryActivity.this.maQ.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.maS == null) {
                    SmartAppBrowseHistoryActivity.this.maS = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.maS.create();
                    SmartAppBrowseHistoryActivity.this.maS.a(SmartAppBrowseHistoryActivity.this.maU);
                }
                SmartAppBrowseHistoryActivity.this.maS.b(smartApp);
                SmartAppBrowseHistoryActivity.this.maS.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener hRo = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gkG != null) {
                    SmartAppBrowseHistoryActivity.this.gkG.dettachView(SmartAppBrowseHistoryActivity.this.ecd);
                    SmartAppBrowseHistoryActivity.this.gkG = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.hRt.setVisibility(0);
            }
        }
    };
    private View.OnClickListener maV = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        duA();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.giU = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dS(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.maV)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.ecd = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.hRt = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.hRt.setLayoutManager(new LinearLayoutManager(this));
        this.maQ = new h(getActivity());
        this.maQ.setOnItemClickListener(this.mOnItemClickListener);
        this.maQ.d(this.mOnLongClickListener);
        this.hRt.setAdapter(this.maQ);
        this.maP = new TextView(getActivity());
        this.maP.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.maP.setGravity(17);
        this.maP.setText(R.string.list_has_no_more);
        this.maP.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void duA() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.hRt.setVisibility(8);
        if (this.gkG == null) {
            this.gkG = new com.baidu.tbadk.k.h(getActivity(), this.hRo);
        }
        this.gkG.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gkG.setSubText(getString(R.string.neterror));
        this.gkG.attachView(this.ecd, true);
        this.gkG.showRefreshButton();
        this.gkG.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.maQ != null) {
            this.maQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.brC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.maR == null) {
            this.maR = new i();
            this.maR.a(this.maT);
        }
        this.maR.bCq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT(boolean z) {
        if (z) {
            if (this.hRt != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.hRt.removeHeaderView(this.mNoDataView);
                this.hRt.addHeaderView(this.mNoDataView);
            }
        } else if (this.hRt != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.hRt.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hx(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.hRt.removeFooterView(this.maP);
            this.hRt.addFooterView(this.maP);
            return;
        }
        this.hRt.removeFooterView(this.maP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.giU.onChangeSkinType(getPageContext(), i);
        if (this.gkG != null) {
            this.gkG.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.maP != null) {
            ap.setBackgroundResource(this.maP, R.color.CAM_X0201);
            ap.setViewTextColor(this.maP, R.color.CAM_X0109);
        }
        ap.setBackgroundColor(this.hRt, R.color.CAM_X0201);
        if (this.maQ != null) {
            this.maQ.notifyDataSetChanged();
        }
    }
}
