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
/* loaded from: classes7.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> eSJ;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j nix = null;
    private SquareModel niy = null;
    private boolean niz = false;
    private boolean niA = false;
    private long iDg = -1;
    private final SquareModel.a niB = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.nix.F(true, "");
            f.this.hideLoadingView(f.this.nix.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.nix.c(f.this.niy.dJY());
                f.this.niz = true;
                f.this.nix.hideNoDataView();
                f.this.cxz();
            }
            if (f.this.niA) {
                f.this.niA = false;
                f.this.xS(true);
                if (!f.this.niz) {
                    f.this.nix.hideNoDataView();
                    f.this.showLoadingView(f.this.nix.getRootView());
                }
            } else {
                if (f.this.iDg > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.iDg, f.this.niy.cvr() - f.this.iDg, f.this.niy.cvp(), f.this.niy.cvq(), currentTimeMillis - f.this.niy.cvo());
                    f.this.iDg = -1L;
                }
                if (!f.this.niz) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.nix.CH(R.string.no_data_text);
                    } else {
                        f.this.nix.CH(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.nix.dKb();
                if (!f.this.niz) {
                    f.this.cxy();
                    return;
                }
                return;
            }
            f.this.eSJ.showToast(str);
            f.this.nix.dKc();
        }
    };
    private final NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.xS(true);
            }
        }
    };
    private final View.OnKeyListener niC = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c fhg = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.xS(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eSJ = getPageContext();
        this.iDg = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.nix = new j(getPageContext(), this.mRootView, this.niC);
        this.nix.setListPullRefreshListener(this.fhg);
        this.mNavigationBar = (NavigationBar) this.eSJ.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eSJ.getString(R.string.ba_square));
    }

    private void initData() {
        this.niy = new SquareModel(getPageContext());
        this.niy.a(this.niB);
        this.niA = true;
        xS(this.niA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxy() {
        this.nix.c(this.gvp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxz() {
        this.nix.d(this.gvp);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xS(true);
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
        if (this.nix != null) {
            this.nix.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.niy != null) {
            this.niy.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(boolean z) {
        boolean z2 = false;
        if (this.niy != null) {
            boolean z3 = this.niy.dJY() == null || this.niy.dJY().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.niA = false;
                z3 = true;
                z4 = false;
            }
            if (this.niA) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.niy.dJZ();
                } else {
                    this.niy.dKa();
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
            com.baidu.tbadk.core.e.b.B(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.B(getActivity(), 2);
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
