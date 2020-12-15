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
    private TbPageContext<Object> eNx;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j nhw = null;
    private SquareModel nhx = null;
    private boolean nhy = false;
    private boolean nhz = false;
    private long ivA = -1;
    private final SquareModel.a nhA = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.nhw.F(true, "");
            f.this.hideLoadingView(f.this.nhw.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.nhw.c(f.this.nhx.dNX());
                f.this.nhy = true;
                f.this.nhw.hideNoDataView();
                f.this.cyx();
            }
            if (f.this.nhz) {
                f.this.nhz = false;
                f.this.xU(true);
                if (!f.this.nhy) {
                    f.this.nhw.hideNoDataView();
                    f.this.showLoadingView(f.this.nhw.getRootView());
                }
            } else {
                if (f.this.ivA > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.ivA, f.this.nhx.cwp() - f.this.ivA, f.this.nhx.cwn(), f.this.nhx.cwo(), currentTimeMillis - f.this.nhx.cwm());
                    f.this.ivA = -1L;
                }
                if (!f.this.nhy) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.nhw.Ed(R.string.no_data_text);
                    } else {
                        f.this.nhw.Ed(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.nhw.dOa();
                if (!f.this.nhy) {
                    f.this.cyw();
                    return;
                }
                return;
            }
            f.this.eNx.showToast(str);
            f.this.nhw.dOb();
        }
    };
    private final NoNetworkView.a gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.xU(true);
            }
        }
    };
    private final View.OnKeyListener nhB = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c fci = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.xU(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eNx = getPageContext();
        this.ivA = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.nhw = new j(getPageContext(), this.mRootView, this.nhB);
        this.nhw.setListPullRefreshListener(this.fci);
        this.mNavigationBar = (NavigationBar) this.eNx.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eNx.getString(R.string.ba_square));
    }

    private void initData() {
        this.nhx = new SquareModel(getPageContext());
        this.nhx.a(this.nhA);
        this.nhz = true;
        xU(this.nhz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyw() {
        this.nhw.c(this.gpz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyx() {
        this.nhw.d(this.gpz);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xU(true);
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
        if (this.nhw != null) {
            this.nhw.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.nhx != null) {
            this.nhx.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.nhx != null) {
            boolean z5 = this.nhx.dNX() == null || this.nhx.dNX().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.nhz = false;
                z3 = true;
                z2 = false;
            }
            if (this.nhz) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.nhx.dNY();
                } else {
                    this.nhx.dNZ();
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
            com.baidu.tbadk.core.e.b.A(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.A(getActivity(), 2);
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
