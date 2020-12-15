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
/* loaded from: classes24.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout eje;
    private NoNetworkView grf;
    private com.baidu.tbadk.l.h gsR;
    private BdRecyclerView icp;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView moX;
    private h moY;
    private i moZ;
    private j mpa;
    private i.a mpb = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.wx(true);
                SmartAppBrowseHistoryActivity.this.Io(0);
            } else if (SmartAppBrowseHistoryActivity.this.moY != null) {
                SmartAppBrowseHistoryActivity.this.wx(y.isEmpty(aVar.dzb()));
                SmartAppBrowseHistoryActivity.this.Io(y.getCount(aVar.dzb()));
                SmartAppBrowseHistoryActivity.this.moY.bl(aVar.dzb());
                SmartAppBrowseHistoryActivity.this.moY.notifyDataSetChanged();
            }
        }
    };
    private j.a mpc = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Rf(String str) {
            if (SmartAppBrowseHistoryActivity.this.moY != null) {
                SmartAppBrowseHistoryActivity.this.moY.Rg(str);
                if (SmartAppBrowseHistoryActivity.this.moY.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.wx(true);
                }
                SmartAppBrowseHistoryActivity.this.Io(SmartAppBrowseHistoryActivity.this.moY.getItemCount());
                SmartAppBrowseHistoryActivity.this.moY.notifyDataSetChanged();
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
                        bf.bua().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                ar arVar = new ar("c13274");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dY("obj_source", "personal_center_list");
                arVar.w("obj_id", smartApp.swan_app_id.longValue());
                arVar.dY("obj_name", smartApp.name);
                arVar.al("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(arVar);
                if (SmartAppBrowseHistoryActivity.this.moY != null) {
                    SmartAppBrowseHistoryActivity.this.moY.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.mpa == null) {
                    SmartAppBrowseHistoryActivity.this.mpa = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.mpa.create();
                    SmartAppBrowseHistoryActivity.this.mpa.a(SmartAppBrowseHistoryActivity.this.mpc);
                }
                SmartAppBrowseHistoryActivity.this.mpa.b(smartApp);
                SmartAppBrowseHistoryActivity.this.mpa.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener ick = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gsR != null) {
                    SmartAppBrowseHistoryActivity.this.gsR.dettachView(SmartAppBrowseHistoryActivity.this.eje);
                    SmartAppBrowseHistoryActivity.this.gsR = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.icp.setVisibility(0);
            }
        }
    };
    private View.OnClickListener mpd = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dzT();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.grf = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dZ(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.mpd)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.eje = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.icp = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.icp.setLayoutManager(new LinearLayoutManager(this));
        this.moY = new h(getActivity());
        this.moY.setOnItemClickListener(this.mOnItemClickListener);
        this.moY.d(this.mOnLongClickListener);
        this.icp.setAdapter(this.moY);
        this.moX = new TextView(getActivity());
        this.moX.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.moX.setGravity(17);
        this.moX.setText(R.string.list_has_no_more);
        this.moX.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dzT() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.icp.setVisibility(8);
        if (this.gsR == null) {
            this.gsR = new com.baidu.tbadk.l.h(getActivity(), this.ick);
        }
        this.gsR.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gsR.setSubText(getString(R.string.neterror));
        this.gsR.attachView(this.eje, true);
        this.gsR.showRefreshButton();
        this.gsR.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.moY != null) {
            this.moY.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bvb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.moZ == null) {
            this.moZ = new i();
            this.moZ.a(this.mpb);
        }
        this.moZ.bFR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(boolean z) {
        if (z) {
            if (this.icp != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.icp.removeHeaderView(this.mNoDataView);
                this.icp.addHeaderView(this.mNoDataView);
            }
        } else if (this.icp != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.icp.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.icp.removeFooterView(this.moX);
            this.icp.addFooterView(this.moX);
            return;
        }
        this.icp.removeFooterView(this.moX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.grf.onChangeSkinType(getPageContext(), i);
        if (this.gsR != null) {
            this.gsR.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.moX != null) {
            ap.setBackgroundResource(this.moX, R.color.CAM_X0201);
            ap.setViewTextColor(this.moX, (int) R.color.CAM_X0109);
        }
        ap.setBackgroundColor(this.icp, R.color.CAM_X0201);
        if (this.moY != null) {
            this.moY.notifyDataSetChanged();
        }
    }
}
