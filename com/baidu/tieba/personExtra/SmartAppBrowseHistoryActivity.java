package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
import com.baidu.tieba.personExtra.h;
import com.baidu.tieba.personExtra.i;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class SmartAppBrowseHistoryActivity extends BaseActivity {
    private FrameLayout esi;
    private NoNetworkView gCe;
    private com.baidu.tbadk.l.h gDQ;
    private BdRecyclerView ioP;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private TextView muk;
    private SmartAppBrowseHistoryAdapter mul;
    private h mum;
    private i mun;
    private h.a muo = new h.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.1
        @Override // com.baidu.tieba.personExtra.h.a
        public void a(boolean z, a aVar) {
            if (!z || aVar == null) {
                SmartAppBrowseHistoryActivity.this.wy(true);
                SmartAppBrowseHistoryActivity.this.Ii(0);
            } else if (SmartAppBrowseHistoryActivity.this.mul != null) {
                SmartAppBrowseHistoryActivity.this.wy(x.isEmpty(aVar.dyQ()));
                SmartAppBrowseHistoryActivity.this.Ii(x.getCount(aVar.dyQ()));
                SmartAppBrowseHistoryActivity.this.mul.bs(aVar.dyQ());
                SmartAppBrowseHistoryActivity.this.mul.notifyDataSetChanged();
            }
        }
    };
    private i.a mup = new i.a() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.2
        @Override // com.baidu.tieba.personExtra.i.a
        public void QL(String str) {
            if (SmartAppBrowseHistoryActivity.this.mul != null) {
                SmartAppBrowseHistoryActivity.this.mul.QM(str);
                if (SmartAppBrowseHistoryActivity.this.mul.getItemCount() == 0) {
                    SmartAppBrowseHistoryActivity.this.wy(true);
                }
                SmartAppBrowseHistoryActivity.this.Ii(SmartAppBrowseHistoryActivity.this.mul.getItemCount());
                SmartAppBrowseHistoryActivity.this.mul.notifyDataSetChanged();
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
                    if (!at.isEmpty(smartApp.h5_url)) {
                        be.bwu().b(SmartAppBrowseHistoryActivity.this.getPageContext(), new String[]{smartApp.h5_url});
                    } else {
                        return;
                    }
                }
                aq aqVar = new aq("c13274");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.dX("obj_source", "personal_center_list");
                aqVar.w("obj_id", smartApp.swan_app_id.longValue());
                aqVar.dX("obj_name", smartApp.name);
                aqVar.an("obj_param1", smartApp.is_game.intValue());
                TiebaStatic.log(aqVar);
                if (SmartAppBrowseHistoryActivity.this.mul != null) {
                    SmartAppBrowseHistoryActivity.this.mul.a(smartApp);
                }
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view.getTag() instanceof SmartApp) {
                SmartApp smartApp = (SmartApp) view.getTag();
                if (SmartAppBrowseHistoryActivity.this.mun == null) {
                    SmartAppBrowseHistoryActivity.this.mun = new i(SmartAppBrowseHistoryActivity.this.getPageContext());
                    SmartAppBrowseHistoryActivity.this.mun.create();
                    SmartAppBrowseHistoryActivity.this.mun.a(SmartAppBrowseHistoryActivity.this.mup);
                }
                SmartAppBrowseHistoryActivity.this.mun.b(smartApp);
                SmartAppBrowseHistoryActivity.this.mun.show();
                return true;
            }
            return false;
        }
    };
    private View.OnClickListener ioK = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetworkAvailableForImmediately()) {
                if (SmartAppBrowseHistoryActivity.this.gDQ != null) {
                    SmartAppBrowseHistoryActivity.this.gDQ.dettachView(SmartAppBrowseHistoryActivity.this.esi);
                    SmartAppBrowseHistoryActivity.this.gDQ = null;
                }
                SmartAppBrowseHistoryActivity.this.loadData();
                SmartAppBrowseHistoryActivity.this.ioP.setVisibility(0);
            }
        }
    };
    private View.OnClickListener muq = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.SmartAppBrowseHistoryActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!k.isFastDoubleClick() && j.isNetworkAvailableForImmediately()) {
                SmartAppBrowseHistoryActivity.this.loadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        dzI();
    }

    private void initView() {
        setContentView(R.layout.activity_smart_app_browse_history);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar_smart_app_browse_history);
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.history_smart_app));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) findViewById(R.id.smart_app_browse_history_no_network_view);
        this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dY(null, getString(R.string.no_history_now)), NoDataViewFactory.b.a(new NoDataViewFactory.a(getResources().getString(R.string.refresh), this.muq)));
        this.mNoDataView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.esi = (FrameLayout) findViewById(R.id.smart_app_browse_history_list_container);
        this.ioP = (BdRecyclerView) findViewById(R.id.smart_app_browse_history_list);
        this.ioP.setLayoutManager(new LinearLayoutManager(this));
        this.mul = new SmartAppBrowseHistoryAdapter(getActivity());
        this.mul.setOnItemClickListener(this.mOnItemClickListener);
        this.mul.d(this.mOnLongClickListener);
        this.ioP.setAdapter(this.mul);
        this.muk = new TextView(getActivity());
        this.muk.setLayoutParams(new RecyclerView.LayoutParams(-1, l.getDimens(getActivity(), R.dimen.tbds182)));
        this.muk.setGravity(17);
        this.muk.setText(R.string.list_has_no_more);
        this.muk.setTextSize(0, l.getDimens(getActivity(), R.dimen.tbds33));
    }

    private void dzI() {
        if (j.isNetworkAvailableForImmediately()) {
            loadData();
            return;
        }
        this.ioP.setVisibility(8);
        if (this.gDQ == null) {
            this.gDQ = new com.baidu.tbadk.l.h(getActivity(), this.ioK);
        }
        this.gDQ.setLayoutMargin(getActivity().getResources().getDimensionPixelSize(R.dimen.tbds340));
        this.gDQ.setSubText(getString(R.string.neterror));
        this.gDQ.attachView(this.esi, true);
        this.gDQ.showRefreshButton();
        this.gDQ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
        if (this.mul != null) {
            this.mul.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.bxw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.mum == null) {
            this.mum = new h();
            this.mum.a(this.muo);
        }
        this.mum.bIm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy(boolean z) {
        if (z) {
            if (this.ioP != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.ioP.removeHeaderView(this.mNoDataView);
                this.ioP.addHeaderView(this.mNoDataView);
            }
        } else if (this.ioP != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.ioP.removeHeaderView(this.mNoDataView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(int i) {
        if (l.getDimens(getActivity(), R.dimen.tbds177) * i >= l.getEquipmentHeight(getActivity()) - this.mNavigationBar.getHeight()) {
            this.ioP.removeFooterView(this.muk);
            this.ioP.addFooterView(this.muk);
            return;
        }
        this.ioP.removeFooterView(this.muk);
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
            ao.setBackgroundResource(this.mNoDataView, R.color.CAM_X0201);
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        if (this.muk != null) {
            ao.setBackgroundResource(this.muk, R.color.CAM_X0201);
            ao.setViewTextColor(this.muk, R.color.CAM_X0109);
        }
        ao.setBackgroundColor(this.ioP, R.color.CAM_X0201);
        if (this.mul != null) {
            this.mul.notifyDataSetChanged();
        }
    }
}
