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
    private TbPageContext<Object> cVg;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j kcn = null;
    private SquareModel kco = null;
    private boolean kcp = false;
    private boolean kcq = false;
    private long fVe = -1;
    private final SquareModel.a kcr = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.kcn.y(true, "");
            f.this.hideLoadingView(f.this.kcn.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.kcn.c(f.this.kco.cJQ());
                f.this.kcp = true;
                f.this.kcn.hideNoDataView();
                f.this.bAt();
            }
            if (f.this.kcq) {
                f.this.kcq = false;
                f.this.sG(true);
                if (!f.this.kcp) {
                    f.this.kcn.hideNoDataView();
                    f.this.showLoadingView(f.this.kcn.getRootView());
                }
            } else {
                if (f.this.fVe > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.fVe, f.this.kco.byN() - f.this.fVe, f.this.kco.byL(), f.this.kco.byM(), currentTimeMillis - f.this.kco.byK());
                    f.this.fVe = -1L;
                }
                if (!f.this.kcp) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.kcn.wo(R.string.no_data_text);
                    } else {
                        f.this.kcn.wo(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.kcn.cJT();
                if (!f.this.kcp) {
                    f.this.bAs();
                    return;
                }
                return;
            }
            f.this.cVg.showToast(str);
            f.this.kcn.cJU();
        }
    };
    private final NoNetworkView.a fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.sG(true);
            }
        }
    };
    private final View.OnKeyListener kcs = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final g.c dgH = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.sG(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cVg = getPageContext();
        this.fVe = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.kcn = new j(getPageContext(), this.mRootView, this.kcs);
        this.kcn.setListPullRefreshListener(this.dgH);
        this.mNavigationBar = (NavigationBar) this.cVg.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.cVg.getString(R.string.ba_square));
    }

    private void initData() {
        this.kco = new SquareModel(getPageContext());
        this.kco.a(this.kcr);
        this.kcq = true;
        sG(this.kcq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAs() {
        this.kcn.c(this.fYJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAt() {
        this.kcn.d(this.fYJ);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sG(true);
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
        if (this.kcn != null) {
            this.kcn.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.kco != null) {
            this.kco.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kco != null) {
            boolean z5 = this.kco.cJQ() == null || this.kco.cJQ().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kcq = false;
                z3 = true;
                z2 = false;
            }
            if (this.kcq) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kco.cJR();
                } else {
                    this.kco.cJS();
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
            com.baidu.tbadk.core.e.b.v(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.v(getActivity(), 2);
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
