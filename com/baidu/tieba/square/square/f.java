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
    private TbPageContext<Object> cVh;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j kcp = null;
    private SquareModel kcq = null;
    private boolean kcr = false;
    private boolean kcs = false;
    private long fVg = -1;
    private final SquareModel.a kct = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.kcp.y(true, "");
            f.this.hideLoadingView(f.this.kcp.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.kcp.c(f.this.kcq.cJS());
                f.this.kcr = true;
                f.this.kcp.hideNoDataView();
                f.this.bAv();
            }
            if (f.this.kcs) {
                f.this.kcs = false;
                f.this.sG(true);
                if (!f.this.kcr) {
                    f.this.kcp.hideNoDataView();
                    f.this.showLoadingView(f.this.kcp.getRootView());
                }
            } else {
                if (f.this.fVg > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.fVg, f.this.kcq.byP() - f.this.fVg, f.this.kcq.byN(), f.this.kcq.byO(), currentTimeMillis - f.this.kcq.byM());
                    f.this.fVg = -1L;
                }
                if (!f.this.kcr) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.kcp.wo(R.string.no_data_text);
                    } else {
                        f.this.kcp.wo(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.kcp.cJV();
                if (!f.this.kcr) {
                    f.this.bAu();
                    return;
                }
                return;
            }
            f.this.cVh.showToast(str);
            f.this.kcp.cJW();
        }
    };
    private final NoNetworkView.a fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.sG(true);
            }
        }
    };
    private final View.OnKeyListener kcu = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final g.c dgI = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.sG(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cVh = getPageContext();
        this.fVg = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.kcp = new j(getPageContext(), this.mRootView, this.kcu);
        this.kcp.setListPullRefreshListener(this.dgI);
        this.mNavigationBar = (NavigationBar) this.cVh.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.cVh.getString(R.string.ba_square));
    }

    private void initData() {
        this.kcq = new SquareModel(getPageContext());
        this.kcq.a(this.kct);
        this.kcs = true;
        sG(this.kcs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        this.kcp.c(this.fYL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAv() {
        this.kcp.d(this.fYL);
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
        if (this.kcp != null) {
            this.kcp.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.kcq != null) {
            this.kcq.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kcq != null) {
            boolean z5 = this.kcq.cJS() == null || this.kcq.cJS().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kcs = false;
                z3 = true;
                z2 = false;
            }
            if (this.kcs) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kcq.cJT();
                } else {
                    this.kcq.cJU();
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
