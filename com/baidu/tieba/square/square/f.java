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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes10.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> dPv;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j lBy = null;
    private SquareModel lBz = null;
    private boolean lBA = false;
    private boolean lBB = false;
    private long hcE = -1;
    private final SquareModel.a lBC = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.lBy.B(true, "");
            f.this.hideLoadingView(f.this.lBy.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.lBy.c(f.this.lBz.dgP());
                f.this.lBA = true;
                f.this.lBy.hideNoDataView();
                f.this.bUu();
            }
            if (f.this.lBB) {
                f.this.lBB = false;
                f.this.uB(true);
                if (!f.this.lBA) {
                    f.this.lBy.hideNoDataView();
                    f.this.showLoadingView(f.this.lBy.getRootView());
                }
            } else {
                if (f.this.hcE > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.hcE, f.this.lBz.bSv() - f.this.hcE, f.this.lBz.bSt(), f.this.lBz.bSu(), currentTimeMillis - f.this.lBz.bSs());
                    f.this.hcE = -1L;
                }
                if (!f.this.lBA) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.lBy.ym(R.string.no_data_text);
                    } else {
                        f.this.lBy.ym(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.lBy.dgS();
                if (!f.this.lBA) {
                    f.this.bUt();
                    return;
                }
                return;
            }
            f.this.dPv.showToast(str);
            f.this.lBy.dgT();
        }
    };
    private final NoNetworkView.a flL = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.uB(true);
            }
        }
    };
    private final View.OnKeyListener lBD = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c ecS = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.uB(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dPv = getPageContext();
        this.hcE = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.lBy = new j(getPageContext(), this.mRootView, this.lBD);
        this.lBy.setListPullRefreshListener(this.ecS);
        this.mNavigationBar = (NavigationBar) this.dPv.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.dPv.getString(R.string.ba_square));
    }

    private void initData() {
        this.lBz = new SquareModel(getPageContext());
        this.lBz.a(this.lBC);
        this.lBB = true;
        uB(this.lBB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUt() {
        this.lBy.c(this.flL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUu() {
        this.lBy.d(this.flL);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            uB(true);
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
        if (this.lBy != null) {
            this.lBy.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.lBz != null) {
            this.lBz.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lBz != null) {
            boolean z5 = this.lBz.dgP() == null || this.lBz.dgP().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lBB = false;
                z3 = true;
                z2 = false;
            }
            if (this.lBB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lBz.dgQ();
                } else {
                    this.lBz.dgR();
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
