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
    private TbPageContext<Object> duG;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j kNX = null;
    private SquareModel kNY = null;
    private boolean kNZ = false;
    private boolean kOa = false;
    private long gAV = -1;
    private final SquareModel.a kOb = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.kNX.z(true, "");
            f.this.hideLoadingView(f.this.kNX.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.kNX.c(f.this.kNY.cVj());
                f.this.kNZ = true;
                f.this.kNX.hideNoDataView();
                f.this.bLc();
            }
            if (f.this.kOa) {
                f.this.kOa = false;
                f.this.tO(true);
                if (!f.this.kNZ) {
                    f.this.kNX.hideNoDataView();
                    f.this.showLoadingView(f.this.kNX.getRootView());
                }
            } else {
                if (f.this.gAV > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.gAV, f.this.kNY.bIY() - f.this.gAV, f.this.kNY.bIW(), f.this.kNY.bIX(), currentTimeMillis - f.this.kNY.bIV());
                    f.this.gAV = -1L;
                }
                if (!f.this.kNZ) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.kNX.wU(R.string.no_data_text);
                    } else {
                        f.this.kNX.wU(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.kNX.cVm();
                if (!f.this.kNZ) {
                    f.this.bLb();
                    return;
                }
                return;
            }
            f.this.duG.showToast(str);
            f.this.kNX.cVn();
        }
    };
    private final NoNetworkView.a gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.tO(true);
            }
        }
    };
    private final View.OnKeyListener kOc = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final g.c dHd = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.tO(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duG = getPageContext();
        this.gAV = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.kNX = new j(getPageContext(), this.mRootView, this.kOc);
        this.kNX.setListPullRefreshListener(this.dHd);
        this.mNavigationBar = (NavigationBar) this.duG.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.duG.getString(R.string.ba_square));
    }

    private void initData() {
        this.kNY = new SquareModel(getPageContext());
        this.kNY.a(this.kOb);
        this.kOa = true;
        tO(this.kOa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLb() {
        this.kNX.c(this.gGl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLc() {
        this.kNX.d(this.gGl);
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
        if (this.kNX != null) {
            this.kNX.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.kNY != null) {
            this.kNY.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kNY != null) {
            boolean z5 = this.kNY.cVj() == null || this.kNY.cVj().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kOa = false;
                z3 = true;
                z2 = false;
            }
            if (this.kOa) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kNY.cVk();
                } else {
                    this.kNY.cVl();
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
