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
/* loaded from: classes8.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> eUY;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j nsf = null;
    private SquareModel nsg = null;
    private boolean nsh = false;
    private boolean nsi = false;
    private long iIQ = -1;
    private final SquareModel.a nsj = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.nsf.N(true, "");
            f.this.hideLoadingView(f.this.nsf.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.nsf.c(f.this.nsg.dMj());
                f.this.nsh = true;
                f.this.nsf.hideNoDataView();
                f.this.cyK();
            }
            if (f.this.nsi) {
                f.this.nsi = false;
                f.this.yl(true);
                if (!f.this.nsh) {
                    f.this.nsf.hideNoDataView();
                    f.this.showLoadingView(f.this.nsf.getRootView());
                }
            } else {
                if (f.this.iIQ > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.iIQ, f.this.nsg.cwD() - f.this.iIQ, f.this.nsg.cwB(), f.this.nsg.cwC(), currentTimeMillis - f.this.nsg.cwA());
                    f.this.iIQ = -1L;
                }
                if (!f.this.nsh) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.nsf.CY(R.string.no_data_text);
                    } else {
                        f.this.nsf.CY(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.nsf.dMm();
                if (!f.this.nsh) {
                    f.this.cyJ();
                    return;
                }
                return;
            }
            f.this.eUY.showToast(str);
            f.this.nsf.dMn();
        }
    };
    private final NoNetworkView.a gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.yl(true);
            }
        }
    };
    private final View.OnKeyListener nsk = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c fjz = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.yl(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eUY = getPageContext();
        this.iIQ = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.nsf = new j(getPageContext(), this.mRootView, this.nsk);
        this.nsf.setListPullRefreshListener(this.fjz);
        this.mNavigationBar = (NavigationBar) this.eUY.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eUY.getString(R.string.ba_square));
    }

    private void initData() {
        this.nsg = new SquareModel(getPageContext());
        this.nsg.a(this.nsj);
        this.nsi = true;
        yl(this.nsi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyJ() {
        this.nsf.c(this.gxZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        this.nsf.d(this.gxZ);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            yl(true);
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
        if (this.nsf != null) {
            this.nsf.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.nsg != null) {
            this.nsg.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        boolean z2 = false;
        if (this.nsg != null) {
            boolean z3 = this.nsg.dMj() == null || this.nsg.dMj().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nsi = false;
                z3 = true;
                z4 = false;
            }
            if (this.nsi) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nsg.dMk();
                } else {
                    this.nsg.dMl();
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
