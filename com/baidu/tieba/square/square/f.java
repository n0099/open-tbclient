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
    private TbPageContext<Object> eCn;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j mMz = null;
    private SquareModel mMA = null;
    private boolean mMB = false;
    private boolean mMC = false;
    private long idU = -1;
    private final SquareModel.a mMD = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.mMz.E(true, "");
            f.this.hideLoadingView(f.this.mMz.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.mMz.c(f.this.mMA.dGn());
                f.this.mMB = true;
                f.this.mMz.hideNoDataView();
                f.this.csd();
            }
            if (f.this.mMC) {
                f.this.mMC = false;
                f.this.xd(true);
                if (!f.this.mMB) {
                    f.this.mMz.hideNoDataView();
                    f.this.showLoadingView(f.this.mMz.getRootView());
                }
            } else {
                if (f.this.idU > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.idU, f.this.mMA.cpV() - f.this.idU, f.this.mMA.cpT(), f.this.mMA.cpU(), currentTimeMillis - f.this.mMA.cpS());
                    f.this.idU = -1L;
                }
                if (!f.this.mMB) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.mMz.CD(R.string.no_data_text);
                    } else {
                        f.this.mMz.CD(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.mMz.dGq();
                if (!f.this.mMB) {
                    f.this.csc();
                    return;
                }
                return;
            }
            f.this.eCn.showToast(str);
            f.this.mMz.dGr();
        }
    };
    private final NoNetworkView.a gbR = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.xd(true);
            }
        }
    };
    private final View.OnKeyListener mME = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c ePL = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.xd(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eCn = getPageContext();
        this.idU = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.mMz = new j(getPageContext(), this.mRootView, this.mME);
        this.mMz.setListPullRefreshListener(this.ePL);
        this.mNavigationBar = (NavigationBar) this.eCn.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eCn.getString(R.string.ba_square));
    }

    private void initData() {
        this.mMA = new SquareModel(getPageContext());
        this.mMA.a(this.mMD);
        this.mMC = true;
        xd(this.mMC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        this.mMz.c(this.gbR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csd() {
        this.mMz.d(this.gbR);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xd(true);
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
        if (this.mMz != null) {
            this.mMz.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.mMA != null) {
            this.mMA.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mMA != null) {
            boolean z5 = this.mMA.dGn() == null || this.mMA.dGn().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mMC = false;
                z3 = true;
                z2 = false;
            }
            if (this.mMC) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mMA.dGo();
                } else {
                    this.mMA.dGp();
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
