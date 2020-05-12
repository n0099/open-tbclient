package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes10.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> duK;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j kOb = null;
    private SquareModel kOc = null;
    private boolean kOd = false;
    private boolean kOe = false;
    private long gBb = -1;
    private final SquareModel.a kOf = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.kOb.z(true, "");
            f.this.hideLoadingView(f.this.kOb.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.kOb.c(f.this.kOc.cVh());
                f.this.kOd = true;
                f.this.kOb.hideNoDataView();
                f.this.bLb();
            }
            if (f.this.kOe) {
                f.this.kOe = false;
                f.this.tO(true);
                if (!f.this.kOd) {
                    f.this.kOb.hideNoDataView();
                    f.this.showLoadingView(f.this.kOb.getRootView());
                }
            } else {
                if (f.this.gBb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.gBb, f.this.kOc.bIX() - f.this.gBb, f.this.kOc.bIV(), f.this.kOc.bIW(), currentTimeMillis - f.this.kOc.bIU());
                    f.this.gBb = -1L;
                }
                if (!f.this.kOd) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.kOb.wU(R.string.no_data_text);
                    } else {
                        f.this.kOb.wU(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.kOb.cVk();
                if (!f.this.kOd) {
                    f.this.bLa();
                    return;
                }
                return;
            }
            f.this.duK.showToast(str);
            f.this.kOb.cVl();
        }
    };
    private final NoNetworkView.a gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.tO(true);
            }
        }
    };
    private final View.OnKeyListener kOg = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                if (keyEvent.getAction() == 0) {
                    if (i == 21) {
                        if (listView.getSelectedView() == null) {
                            listView.dispatchKeyEvent(new KeyEvent(0, 19));
                            return true;
                        }
                        return false;
                    } else if (i == 22 && listView.getSelectedView() == null) {
                        listView.dispatchKeyEvent(new KeyEvent(0, 20));
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
    };
    private final g.c dHh = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.tO(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duK = getPageContext();
        this.gBb = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.kOb = new j(getPageContext(), this.mRootView, this.kOg);
        this.kOb.setListPullRefreshListener(this.dHh);
        this.mNavigationBar = (NavigationBar) this.duK.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.duK.getString(R.string.ba_square));
    }

    private void initData() {
        this.kOc = new SquareModel(getPageContext());
        this.kOc.a(this.kOf);
        this.kOe = true;
        tO(this.kOe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        this.kOb.c(this.gGr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLb() {
        this.kOb.d(this.gGr);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            tO(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        cancelAllAsyncTask();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kOb != null) {
            this.kOb.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.kOc != null) {
            this.kOc.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kOc != null) {
            boolean z5 = this.kOc.cVh() == null || this.kOc.cVh().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kOe = false;
                z3 = true;
                z2 = false;
            }
            if (this.kOe) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kOc.cVi();
                } else {
                    this.kOc.cVj();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.e.b.q(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.q(getActivity(), 2);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        setSwipeBackEnabled(false);
    }
}
