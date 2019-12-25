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
/* loaded from: classes7.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> cQU;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j jXG = null;
    private SquareModel jXH = null;
    private boolean jXI = false;
    private boolean jXJ = false;
    private long fPB = -1;
    private final SquareModel.a jXK = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.jXG.y(true, "");
            f.this.hideLoadingView(f.this.jXG.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.jXG.c(f.this.jXH.cHg());
                f.this.jXI = true;
                f.this.jXG.hideNoDataView();
                f.this.bxP();
            }
            if (f.this.jXJ) {
                f.this.jXJ = false;
                f.this.sq(true);
                if (!f.this.jXI) {
                    f.this.jXG.hideNoDataView();
                    f.this.showLoadingView(f.this.jXG.getRootView());
                }
            } else {
                if (f.this.fPB > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.fPB, f.this.jXH.bwg() - f.this.fPB, f.this.jXH.bwe(), f.this.jXH.bwf(), currentTimeMillis - f.this.jXH.bwd());
                    f.this.fPB = -1L;
                }
                if (!f.this.jXI) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.jXG.wd(R.string.no_data_text);
                    } else {
                        f.this.jXG.wd(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.jXG.cHj();
                if (!f.this.jXI) {
                    f.this.bxO();
                    return;
                }
                return;
            }
            f.this.cQU.showToast(str);
            f.this.jXG.cHk();
        }
    };
    private final NoNetworkView.a fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.sq(true);
            }
        }
    };
    private final View.OnKeyListener jXL = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final g.c dcr = new g.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            f.this.sq(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cQU = getPageContext();
        this.fPB = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.jXG = new j(getPageContext(), this.mRootView, this.jXL);
        this.jXG.setListPullRefreshListener(this.dcr);
        this.mNavigationBar = (NavigationBar) this.cQU.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.cQU.getString(R.string.ba_square));
    }

    private void initData() {
        this.jXH = new SquareModel(getPageContext());
        this.jXH.a(this.jXK);
        this.jXJ = true;
        sq(this.jXJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxO() {
        this.jXG.c(this.fTz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxP() {
        this.jXG.d(this.fTz);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sq(true);
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
        if (this.jXG != null) {
            this.jXG.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.jXH != null) {
            this.jXH.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jXH != null) {
            boolean z5 = this.jXH.cHg() == null || this.jXH.cHg().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jXJ = false;
                z3 = true;
                z2 = false;
            }
            if (this.jXJ) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.jXH.cHh();
                } else {
                    this.jXH.cHi();
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
