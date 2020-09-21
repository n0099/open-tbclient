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
/* loaded from: classes22.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> ehG;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j mko = null;
    private SquareModel mkp = null;
    private boolean mkq = false;
    private boolean mkr = false;
    private long hCy = -1;
    private final SquareModel.a mks = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.mko.C(true, "");
            f.this.hideLoadingView(f.this.mko.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.mko.c(f.this.mkp.dzu());
                f.this.mkq = true;
                f.this.mko.hideNoDataView();
                f.this.cly();
            }
            if (f.this.mkr) {
                f.this.mkr = false;
                f.this.wf(true);
                if (!f.this.mkq) {
                    f.this.mko.hideNoDataView();
                    f.this.showLoadingView(f.this.mko.getRootView());
                }
            } else {
                if (f.this.hCy > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.hCy, f.this.mkp.cjs() - f.this.hCy, f.this.mkp.cjq(), f.this.mkp.cjr(), currentTimeMillis - f.this.mkp.cjp());
                    f.this.hCy = -1L;
                }
                if (!f.this.mkq) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.mko.BE(R.string.no_data_text);
                    } else {
                        f.this.mko.BE(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.mko.dzx();
                if (!f.this.mkq) {
                    f.this.clx();
                    return;
                }
                return;
            }
            f.this.ehG.showToast(str);
            f.this.mko.dzy();
        }
    };
    private final NoNetworkView.a fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.wf(true);
            }
        }
    };
    private final View.OnKeyListener mkt = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c evf = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.wf(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ehG = getPageContext();
        this.hCy = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.mko = new j(getPageContext(), this.mRootView, this.mkt);
        this.mko.setListPullRefreshListener(this.evf);
        this.mNavigationBar = (NavigationBar) this.ehG.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.ehG.getString(R.string.ba_square));
    }

    private void initData() {
        this.mkp = new SquareModel(getPageContext());
        this.mkp.a(this.mks);
        this.mkr = true;
        wf(this.mkr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        this.mko.c(this.fFF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        this.mko.d(this.fFF);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            wf(true);
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
        if (this.mko != null) {
            this.mko.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.mkp != null) {
            this.mkp.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mkp != null) {
            boolean z5 = this.mkp.dzu() == null || this.mkp.dzu().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mkr = false;
                z3 = true;
                z2 = false;
            }
            if (this.mkr) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mkp.dzv();
                } else {
                    this.mkp.dzw();
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
            com.baidu.tbadk.core.e.b.r(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.r(getActivity(), 2);
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
