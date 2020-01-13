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
/* loaded from: classes8.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> cRe;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j kbj = null;
    private SquareModel kbk = null;
    private boolean kbl = false;
    private boolean kbm = false;
    private long fSK = -1;
    private final SquareModel.a kbn = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.kbj.y(true, "");
            f.this.hideLoadingView(f.this.kbj.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.kbj.c(f.this.kbk.cIk());
                f.this.kbl = true;
                f.this.kbj.hideNoDataView();
                f.this.byR();
            }
            if (f.this.kbm) {
                f.this.kbm = false;
                f.this.sC(true);
                if (!f.this.kbl) {
                    f.this.kbj.hideNoDataView();
                    f.this.showLoadingView(f.this.kbj.getRootView());
                }
            } else {
                if (f.this.fSK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.fSK, f.this.kbk.bxi() - f.this.fSK, f.this.kbk.bxg(), f.this.kbk.bxh(), currentTimeMillis - f.this.kbk.bxf());
                    f.this.fSK = -1L;
                }
                if (!f.this.kbl) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.kbj.wi(R.string.no_data_text);
                    } else {
                        f.this.kbj.wi(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.kbj.cIn();
                if (!f.this.kbl) {
                    f.this.byQ();
                    return;
                }
                return;
            }
            f.this.cRe.showToast(str);
            f.this.kbj.cIo();
        }
    };
    private final NoNetworkView.a fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.sC(true);
            }
        }
    };
    private final View.OnKeyListener kbo = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final g.c dcC = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.sC(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cRe = getPageContext();
        this.fSK = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.kbj = new j(getPageContext(), this.mRootView, this.kbo);
        this.kbj.setListPullRefreshListener(this.dcC);
        this.mNavigationBar = (NavigationBar) this.cRe.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.cRe.getString(R.string.ba_square));
    }

    private void initData() {
        this.kbk = new SquareModel(getPageContext());
        this.kbk.a(this.kbn);
        this.kbm = true;
        sC(this.kbm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byQ() {
        this.kbj.c(this.fWI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byR() {
        this.kbj.d(this.fWI);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sC(true);
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
        if (this.kbj != null) {
            this.kbj.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.kbk != null) {
            this.kbk.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kbk != null) {
            boolean z5 = this.kbk.cIk() == null || this.kbk.cIk().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kbm = false;
                z3 = true;
                z2 = false;
            }
            if (this.kbm) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kbk.cIl();
                } else {
                    this.kbk.cIm();
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
