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
    private TbPageContext<Object> dIF;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j lgs = null;
    private SquareModel lgt = null;
    private boolean lgu = false;
    private boolean lgv = false;
    private long gPK = -1;
    private final SquareModel.a lgw = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.lgs.z(true, "");
            f.this.hideLoadingView(f.this.lgs.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.lgs.c(f.this.lgt.dcl());
                f.this.lgu = true;
                f.this.lgs.hideNoDataView();
                f.this.bRw();
            }
            if (f.this.lgv) {
                f.this.lgv = false;
                f.this.um(true);
                if (!f.this.lgu) {
                    f.this.lgs.hideNoDataView();
                    f.this.showLoadingView(f.this.lgs.getRootView());
                }
            } else {
                if (f.this.gPK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.gPK, f.this.lgt.bPq() - f.this.gPK, f.this.lgt.bPo(), f.this.lgt.bPp(), currentTimeMillis - f.this.lgt.bPn());
                    f.this.gPK = -1L;
                }
                if (!f.this.lgu) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.lgs.xA(R.string.no_data_text);
                    } else {
                        f.this.lgs.xA(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.lgs.dco();
                if (!f.this.lgu) {
                    f.this.bRv();
                    return;
                }
                return;
            }
            f.this.dIF.showToast(str);
            f.this.lgs.dcp();
        }
    };
    private final NoNetworkView.a faq = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.um(true);
            }
        }
    };
    private final View.OnKeyListener lgx = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c dVt = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.um(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dIF = getPageContext();
        this.gPK = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.lgs = new j(getPageContext(), this.mRootView, this.lgx);
        this.lgs.setListPullRefreshListener(this.dVt);
        this.mNavigationBar = (NavigationBar) this.dIF.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.dIF.getString(R.string.ba_square));
    }

    private void initData() {
        this.lgt = new SquareModel(getPageContext());
        this.lgt.a(this.lgw);
        this.lgv = true;
        um(this.lgv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRv() {
        this.lgs.c(this.faq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRw() {
        this.lgs.d(this.faq);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            um(true);
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
        if (this.lgs != null) {
            this.lgs.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.lgt != null) {
            this.lgt.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lgt != null) {
            boolean z5 = this.lgt.dcl() == null || this.lgt.dcl().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lgv = false;
                z3 = true;
                z2 = false;
            }
            if (this.lgv) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lgt.dcm();
                } else {
                    this.lgt.dcn();
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
