package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.j;
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
import com.baidu.tieba.personExtra.h;
import com.baidu.tieba.personExtra.i;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout erd;
    private NoNetworkView gCe;
    private com.baidu.tbadk.l.h gDQ;
    private BdRecyclerView irL;
    private TextView mAV;
    private SmartAppBrowseHistoryAdapter mAW;
    private h mAX;
    private i mAY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h.a mAZ = new h.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.h.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.wL(true);
                SmartAppBrowseHistoryActivity.this.GW(0);
            } else if (SmartAppBrowseHistoryActivity.this.mAW != null) {
                SmartAppBrowseHistoryActivity.this.wL(y.isEmpty(aVar.dxy()));
                SmartAppBrowseHistoryActivity.this.GW(y.getCount(aVar.dxy()));
                SmartAppBrowseHistoryActivity.this.mAW.bn(aVar.dxy());
                SmartAppBrowseHistoryActivity.this.mAW.notifyDataSetChanged();
            }
        }
    };
    private i.a mBa = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.i.a
        public void QB(String str) {
            if (SmartAppBrowseHistoryActivity.this.mAW != null) {
                SmartAppBrowseHistoryActivity.this.mAW.QC(str);
                if (SmartAppBrowseHistoryActivity.this.mAW.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.wL(true);
                }
                SmartAppBrowseHistoryActivity.this.GW(SmartAppBrowseHistoryActivity.this.mAW.getItemCount());
                SmartAppBrowseHistoryActivity.this.mAW.notifyDataSetChanged();
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
                        bf.bsY().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                ar arVar = new ar("c13274");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("obj_source", "personal_center_list");
                arVar.v("obj_id", smartApp.swan_app_id.longValue());
                arVar.dR("obj_name", smartApp.name);
                arVar.aq("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(arVar);
                if (SmartAppBrowseHistoryActivity.this.mAW != null) {
                    SmartAppBrowseHistoryActivity.this.mAW.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.mAY == null) {
                    SmartAppBrowseHistoryActivity.this.mAY = new i(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.mAY.create();
                    SmartAppBrowseHistoryActivity.this.mAY.a(SmartAppBrowseHistoryActivity.this.mBa);
                }
                SmartAppBrowseHistoryActivity.this.mAY.b(smartApp);
                SmartAppBrowseHistoryActivity.this.mAY.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener irG = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gDQ != null) {
                    SmartAppBrowseHistoryActivity.this.gDQ.dettachView(SmartAppBrowseHistoryActivity.this.erd);
                    SmartAppBrowseHistoryActivity.this.gDQ = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.irL.setVisibility(0);
            }
        }
    };
    private View.OnClickListener mBb = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!l.isFastDoubleClick() && j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        dyq();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dS(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.mBb)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.erd = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.irL = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.irL.setLayoutManager(new LinearLayoutManager(this));
        this.mAW = new SmartAppBrowseHistoryAdapter(getActivity());
        this.mAW.setOnItemClickListener(this.mOnItemClickListener);
        this.mAW.d(this.mOnLongClickListener);
        this.irL.setAdapter(this.mAW);
        this.mAV = new TextView(getActivity());
        this.mAV.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.mAV.setGravity(17);
        this.mAV.setText(R.string.list_has_no_more);
        this.mAV.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dyq() {
        if (j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.irL.setVisibility(8);
        if (this.gDQ == null) {
            this.gDQ = new com.baidu.tbadk.l.h(getActivity(), this.irG);
        }
        this.gDQ.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gDQ.setSubText(getString(R.string.neterror));
        this.gDQ.attachView(this.erd, true);
        this.gDQ.showRefreshButton();
        this.gDQ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.mAW != null) {
            this.mAW.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bua();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mAX == null) {
            this.mAX = new h();
            this.mAX.a(this.mAZ);
        }
        this.mAX.bER();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(boolean z) {
        if (z) {
            if (this.irL != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.irL.removeHeaderView(this.mNoDataView);
                this.irL.addHeaderView(this.mNoDataView);
            }
        } else if (this.irL != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.irL.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.irL.removeFooterView(this.mAV);
            this.irL.addFooterView(this.mAV);
            return;
        }
        this.irL.removeFooterView(this.mAV);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gCe.onChangeSkinType(getPageContext(), i);
        if (this.gDQ != null) {
            this.gDQ.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.mAV != null) {
            ap.setBackgroundResource(this.mAV, R.color.CAM_X0201);
            ap.setViewTextColor(this.mAV, R.color.CAM_X0109);
        }
        ap.setBackgroundColor(this.irL, R.color.CAM_X0201);
        if (this.mAW != null) {
            this.mAW.notifyDataSetChanged();
        }
    }
}
