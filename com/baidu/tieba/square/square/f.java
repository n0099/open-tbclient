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
/* loaded from: classes17.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> dVN;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j lIP = null;
    private SquareModel lIQ = null;
    private boolean lIR = false;
    private boolean lIS = false;
    private long hio = -1;
    private final SquareModel.a lIT = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.lIP.B(true, "");
            f.this.hideLoadingView(f.this.lIP.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.lIP.c(f.this.lIQ.djZ());
                f.this.lIR = true;
                f.this.lIP.hideNoDataView();
                f.this.bXO();
            }
            if (f.this.lIS) {
                f.this.lIS = false;
                f.this.vf(true);
                if (!f.this.lIR) {
                    f.this.lIP.hideNoDataView();
                    f.this.showLoadingView(f.this.lIP.getRootView());
                }
            } else {
                if (f.this.hio > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.hio, f.this.lIQ.bVN() - f.this.hio, f.this.lIQ.bVL(), f.this.lIQ.bVM(), currentTimeMillis - f.this.lIQ.bVK());
                    f.this.hio = -1L;
                }
                if (!f.this.lIR) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.lIP.yK(R.string.no_data_text);
                    } else {
                        f.this.lIP.yK(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.lIP.dkc();
                if (!f.this.lIR) {
                    f.this.bXN();
                    return;
                }
                return;
            }
            f.this.dVN.showToast(str);
            f.this.lIP.dkd();
        }
    };
    private final NoNetworkView.a fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.vf(true);
            }
        }
    };
    private final View.OnKeyListener lIU = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c ejc = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.vf(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dVN = getPageContext();
        this.hio = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.lIP = new j(getPageContext(), this.mRootView, this.lIU);
        this.lIP.setListPullRefreshListener(this.ejc);
        this.mNavigationBar = (NavigationBar) this.dVN.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.dVN.getString(R.string.ba_square));
    }

    private void initData() {
        this.lIQ = new SquareModel(getPageContext());
        this.lIQ.a(this.lIT);
        this.lIS = true;
        vf(this.lIS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXN() {
        this.lIP.c(this.fqT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        this.lIP.d(this.fqT);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            vf(true);
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
        if (this.lIP != null) {
            this.lIP.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.lIQ != null) {
            this.lIQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vf(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lIQ != null) {
            boolean z5 = this.lIQ.djZ() == null || this.lIQ.djZ().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lIS = false;
                z3 = true;
                z2 = false;
            }
            if (this.lIS) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lIQ.dka();
                } else {
                    this.lIQ.dkb();
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
