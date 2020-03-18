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
    private TbPageContext<Object> cVv;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j ked = null;
    private SquareModel kee = null;
    private boolean kef = false;
    private boolean keg = false;
    private long fWb = -1;
    private final SquareModel.a keh = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.ked.y(true, "");
            f.this.hideLoadingView(f.this.ked.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.ked.c(f.this.kee.cKn());
                f.this.kef = true;
                f.this.ked.hideNoDataView();
                f.this.bAC();
            }
            if (f.this.keg) {
                f.this.keg = false;
                f.this.sM(true);
                if (!f.this.kef) {
                    f.this.ked.hideNoDataView();
                    f.this.showLoadingView(f.this.ked.getRootView());
                }
            } else {
                if (f.this.fWb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.fWb, f.this.kee.byW() - f.this.fWb, f.this.kee.byU(), f.this.kee.byV(), currentTimeMillis - f.this.kee.byT());
                    f.this.fWb = -1L;
                }
                if (!f.this.kef) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.ked.ww(R.string.no_data_text);
                    } else {
                        f.this.ked.ww(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.ked.cKq();
                if (!f.this.kef) {
                    f.this.bAB();
                    return;
                }
                return;
            }
            f.this.cVv.showToast(str);
            f.this.ked.cKr();
        }
    };
    private final NoNetworkView.a fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.sM(true);
            }
        }
    };
    private final View.OnKeyListener kei = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final g.c dhi = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.sM(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cVv = getPageContext();
        this.fWb = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.ked = new j(getPageContext(), this.mRootView, this.kei);
        this.ked.setListPullRefreshListener(this.dhi);
        this.mNavigationBar = (NavigationBar) this.cVv.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.cVv.getString(R.string.ba_square));
    }

    private void initData() {
        this.kee = new SquareModel(getPageContext());
        this.kee.a(this.keh);
        this.keg = true;
        sM(this.keg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        this.ked.c(this.fZG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAC() {
        this.ked.d(this.fZG);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sM(true);
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
        if (this.ked != null) {
            this.ked.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.kee != null) {
            this.kee.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kee != null) {
            boolean z5 = this.kee.cKn() == null || this.kee.cKn().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.keg = false;
                z3 = true;
                z2 = false;
            }
            if (this.keg) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kee.cKo();
                } else {
                    this.kee.cKp();
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
