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
/* loaded from: classes8.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout epC;
    private NoNetworkView gAv;
    private com.baidu.tbadk.l.h gCh;
    private BdRecyclerView iqc;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView myT;
    private SmartAppBrowseHistoryAdapter myU;
    private h myV;
    private i myW;
    private h.a myX = new h.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.h.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.wL(true);
                SmartAppBrowseHistoryActivity.this.GT(0);
            } else if (SmartAppBrowseHistoryActivity.this.myU != null) {
                SmartAppBrowseHistoryActivity.this.wL(y.isEmpty(aVar.dxp()));
                SmartAppBrowseHistoryActivity.this.GT(y.getCount(aVar.dxp()));
                SmartAppBrowseHistoryActivity.this.myU.bn(aVar.dxp());
                SmartAppBrowseHistoryActivity.this.myU.notifyDataSetChanged();
            }
        }
    };
    private i.a myY = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.i.a
        public void Qv(String str) {
            if (SmartAppBrowseHistoryActivity.this.myU != null) {
                SmartAppBrowseHistoryActivity.this.myU.Qw(str);
                if (SmartAppBrowseHistoryActivity.this.myU.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.wL(true);
                }
                SmartAppBrowseHistoryActivity.this.GT(SmartAppBrowseHistoryActivity.this.myU.getItemCount());
                SmartAppBrowseHistoryActivity.this.myU.notifyDataSetChanged();
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
                        bf.bsV().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                ar arVar = new ar("c13274");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.dR("obj_source", "personal_center_list");
                arVar.v("obj_id", smartApp.swan_app_id.longValue());
                arVar.dR("obj_name", smartApp.name);
                arVar.ap("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(arVar);
                if (SmartAppBrowseHistoryActivity.this.myU != null) {
                    SmartAppBrowseHistoryActivity.this.myU.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.myW == null) {
                    SmartAppBrowseHistoryActivity.this.myW = new i(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.myW.create();
                    SmartAppBrowseHistoryActivity.this.myW.a(SmartAppBrowseHistoryActivity.this.myY);
                }
                SmartAppBrowseHistoryActivity.this.myW.b(smartApp);
                SmartAppBrowseHistoryActivity.this.myW.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener ipX = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gCh != null) {
                    SmartAppBrowseHistoryActivity.this.gCh.dettachView(SmartAppBrowseHistoryActivity.this.epC);
                    SmartAppBrowseHistoryActivity.this.gCh = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.iqc.setVisibility(0);
            }
        }
    };
    private View.OnClickListener myZ = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
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
        dyh();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAv = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dS(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.myZ)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.epC = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.iqc = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.iqc.setLayoutManager(new LinearLayoutManager(this));
        this.myU = new SmartAppBrowseHistoryAdapter(getActivity());
        this.myU.setOnItemClickListener(this.mOnItemClickListener);
        this.myU.d(this.mOnLongClickListener);
        this.iqc.setAdapter(this.myU);
        this.myT = new TextView(getActivity());
        this.myT.setLayoutParams(new RecyclerView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds182)));
        this.myT.setGravity(17);
        this.myT.setText(R.string.list_has_no_more);
        this.myT.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dyh() {
        if (j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.iqc.setVisibility(8);
        if (this.gCh == null) {
            this.gCh = new com.baidu.tbadk.l.h(getActivity(), this.ipX);
        }
        this.gCh.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gCh.setSubText(getString(R.string.neterror));
        this.gCh.attachView(this.epC, true);
        this.gCh.showRefreshButton();
        this.gCh.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.myU != null) {
            this.myU.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.myV == null) {
            this.myV = new h();
            this.myV.a(this.myX);
        }
        this.myV.bEN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(boolean z) {
        if (z) {
            if (this.iqc != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.iqc.removeHeaderView(this.mNoDataView);
                this.iqc.addHeaderView(this.mNoDataView);
            }
        } else if (this.iqc != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.iqc.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT(int i) {
        if (com.baidu.adp.lib.util.l.getDimens(getActivity(), R.dimen.tbds177) * i >= com.baidu.adp.lib.util.l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.iqc.removeFooterView(this.myT);
            this.iqc.addFooterView(this.myT);
            return;
        }
        this.iqc.removeFooterView(this.myT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gAv.onChangeSkinType(getPageContext(), i);
        if (this.gCh != null) {
            this.gCh.onChangeSkinType();
        }
        if (this.mNoDataView != null) {
            ap.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.myT != null) {
            ap.setBackgroundResource(this.myT, R.color.CAM_X0201);
            ap.setViewTextColor(this.myT, R.color.CAM_X0109);
        }
        ap.setBackgroundColor(this.iqc, R.color.CAM_X0201);
        if (this.myU != null) {
            this.myU.notifyDataSetChanged();
        }
    }
}
