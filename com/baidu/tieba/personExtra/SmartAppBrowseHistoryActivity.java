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
    private NoNetworkView grd;
    private com.baidu.tbadk.l.h gsP;
    private BdRecyclerView icn;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView moV;
    private h moW;
    private i moX;
    private j moY;
    private i.a moZ = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.i.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.wx(true);
                SmartAppBrowseHistoryActivity.this.Io(0);
            } else if (SmartAppBrowseHistoryActivity.this.moW != null) {
                SmartAppBrowseHistoryActivity.this.wx(y.isEmpty(aVar.dza()));
                SmartAppBrowseHistoryActivity.this.Io(y.getCount(aVar.dza()));
                SmartAppBrowseHistoryActivity.this.moW.bl(aVar.dza());
                SmartAppBrowseHistoryActivity.this.moW.notifyDataSetChanged();
            }
        }
    };
    private j.a mpa = new j.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.j.a
        public void Rf(String str) {
            if (SmartAppBrowseHistoryActivity.this.moW != null) {
                SmartAppBrowseHistoryActivity.this.moW.Rg(str);
                if (SmartAppBrowseHistoryActivity.this.moW.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.wx(true);
                }
                SmartAppBrowseHistoryActivity.this.Io(SmartAppBrowseHistoryActivity.this.moW.getItemCount());
                SmartAppBrowseHistoryActivity.this.moW.notifyDataSetChanged();
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
                if (SmartAppBrowseHistoryActivity.this.moW != null) {
                    SmartAppBrowseHistoryActivity.this.moW.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.moY == null) {
                    SmartAppBrowseHistoryActivity.this.moY = new j(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.moY.create();
                    SmartAppBrowseHistoryActivity.this.moY.a(SmartAppBrowseHistoryActivity.this.mpa);
                }
                SmartAppBrowseHistoryActivity.this.moY.b(smartApp);
                SmartAppBrowseHistoryActivity.this.moY.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener ici = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gsP != null) {
                    SmartAppBrowseHistoryActivity.this.gsP.dettachView(SmartAppBrowseHistoryActivity.this.eje);
                    SmartAppBrowseHistoryActivity.this.gsP = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.icn.setVisibility(0);
            }
        }
    };
    private View.OnClickListener mpb = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dzS();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.grd = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dZ(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.mpb)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.eje = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.icn = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.icn.setLayoutManager(new LinearLayoutManager(this));
        this.moW = new h(getActivity());
        this.moW.setOnItemClickListener(this.mOnItemClickListener);
        this.moW.d(this.mOnLongClickListener);
        this.icn.setAdapter(this.moW);
        this.moV = new TextView(getActivity());
        this.moV.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.moV.setGravity(17);
        this.moV.setText(R.string.list_has_no_more);
        this.moV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dzS() {
        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.icn.setVisibility(8);
        if (this.gsP == null) {
            this.gsP = new com.baidu.tbadk.l.h(getActivity(), this.ici);
        }
        this.gsP.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gsP.setSubText(getString(R.string.neterror));
        this.gsP.attachView(this.eje, true);
        this.gsP.showRefreshButton();
        this.gsP.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.moW != null) {
            this.moW.notifyDataSetChanged();
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
        if (this.moX == null) {
            this.moX = new i();
            this.moX.a(this.moZ);
        }
        this.moX.bFR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(boolean z) {
        if (z) {
            if (this.icn != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.icn.removeHeaderView(this.mNoDataView);
                this.icn.addHeaderView(this.mNoDataView);
            }
        } else if (this.icn != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.icn.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.icn.removeFooterView(this.moV);
            this.icn.addFooterView(this.moV);
            return;
        }
        this.icn.removeFooterView(this.moV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.grd.onChangeSkinType(getPageContext(), i);
        if (this.gsP != null) {
            this.gsP.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.moV != null) {
            ap.setBackgroundResource(this.moV, R.color.CAM_X0201);
            ap.setViewTextColor(this.moV, (int) R.color.CAM_X0109);
        }
        ap.setBackgroundColor(this.icn, R.color.CAM_X0201);
        if (this.moW != null) {
            this.moW.notifyDataSetChanged();
        }
    }
}
