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
/* loaded from: classes23.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> eIc;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j mSy = null;
    private SquareModel mSz = null;
    private boolean mSA = false;
    private boolean mSB = false;
    private long ijR = -1;
    private final SquareModel.a mSD = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.mSy.E(true, "");
            f.this.hideLoadingView(f.this.mSy.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.mSy.c(f.this.mSz.dIP());
                f.this.mSA = true;
                f.this.mSy.hideNoDataView();
                f.this.cuE();
            }
            if (f.this.mSB) {
                f.this.mSB = false;
                f.this.xm(true);
                if (!f.this.mSA) {
                    f.this.mSy.hideNoDataView();
                    f.this.showLoadingView(f.this.mSy.getRootView());
                }
            } else {
                if (f.this.ijR > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.ijR, f.this.mSz.csw() - f.this.ijR, f.this.mSz.csu(), f.this.mSz.csv(), currentTimeMillis - f.this.mSz.cst());
                    f.this.ijR = -1L;
                }
                if (!f.this.mSA) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.mSy.CQ(R.string.no_data_text);
                    } else {
                        f.this.mSy.CQ(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.mSy.dIS();
                if (!f.this.mSA) {
                    f.this.cuD();
                    return;
                }
                return;
            }
            f.this.eIc.showToast(str);
            f.this.mSy.dIT();
        }
    };
    private final NoNetworkView.a ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.xm(true);
            }
        }
    };
    private final View.OnKeyListener mSE = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c eVA = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.xm(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eIc = getPageContext();
        this.ijR = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.mSy = new j(getPageContext(), this.mRootView, this.mSE);
        this.mSy.setListPullRefreshListener(this.eVA);
        this.mNavigationBar = (NavigationBar) this.eIc.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eIc.getString(R.string.ba_square));
    }

    private void initData() {
        this.mSz = new SquareModel(getPageContext());
        this.mSz.a(this.mSD);
        this.mSB = true;
        xm(this.mSB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuD() {
        this.mSy.c(this.ghG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuE() {
        this.mSy.d(this.ghG);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xm(true);
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
        if (this.mSy != null) {
            this.mSy.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.mSz != null) {
            this.mSz.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mSz != null) {
            boolean z5 = this.mSz.dIP() == null || this.mSz.dIP().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mSB = false;
                z3 = true;
                z2 = false;
            }
            if (this.mSB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mSz.dIQ();
                } else {
                    this.mSz.dIR();
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
