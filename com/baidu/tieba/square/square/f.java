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
    private TbPageContext<Object> eXu;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j nnb = null;
    private SquareModel nnc = null;
    private boolean nnd = false;
    private boolean nne = false;
    private long iHN = -1;
    private final SquareModel.a nnf = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.nnb.F(true, "");
            f.this.hideLoadingView(f.this.nnb.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.nnb.c(f.this.nnc.dNQ());
                f.this.nnd = true;
                f.this.nnb.hideNoDataView();
                f.this.cBr();
            }
            if (f.this.nne) {
                f.this.nne = false;
                f.this.xW(true);
                if (!f.this.nnd) {
                    f.this.nnb.hideNoDataView();
                    f.this.showLoadingView(f.this.nnb.getRootView());
                }
            } else {
                if (f.this.iHN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.iHN, f.this.nnc.czj() - f.this.iHN, f.this.nnc.czh(), f.this.nnc.czi(), currentTimeMillis - f.this.nnc.czg());
                    f.this.iHN = -1L;
                }
                if (!f.this.nnd) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.nnb.En(R.string.no_data_text);
                    } else {
                        f.this.nnb.En(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.nnb.dNT();
                if (!f.this.nnd) {
                    f.this.cBq();
                    return;
                }
                return;
            }
            f.this.eXu.showToast(str);
            f.this.nnb.dNU();
        }
    };
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.xW(true);
            }
        }
    };
    private final View.OnKeyListener nng = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c flR = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.xW(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXu = getPageContext();
        this.iHN = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.nnb = new j(getPageContext(), this.mRootView, this.nng);
        this.nnb.setListPullRefreshListener(this.flR);
        this.mNavigationBar = (NavigationBar) this.eXu.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eXu.getString(R.string.ba_square));
    }

    private void initData() {
        this.nnc = new SquareModel(getPageContext());
        this.nnc.a(this.nnf);
        this.nne = true;
        xW(this.nne);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBq() {
        this.nnb.c(this.gzW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBr() {
        this.nnb.d(this.gzW);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xW(true);
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
        if (this.nnb != null) {
            this.nnb.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.nnc != null) {
            this.nnc.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xW(boolean z) {
        boolean z2 = false;
        if (this.nnc != null) {
            boolean z3 = this.nnc.dNQ() == null || this.nnc.dNQ().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nne = false;
                z3 = true;
                z4 = false;
            }
            if (this.nne) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nnc.dNR();
                } else {
                    this.nnc.dNS();
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
