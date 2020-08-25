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
/* loaded from: classes17.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> efn;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j may = null;
    private SquareModel maz = null;
    private boolean maA = false;
    private boolean maB = false;
    private long hvn = -1;
    private final SquareModel.a maC = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.may.C(true, "");
            f.this.hideLoadingView(f.this.may.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.may.c(f.this.maz.dvw());
                f.this.maA = true;
                f.this.may.hideNoDataView();
                f.this.cik();
            }
            if (f.this.maB) {
                f.this.maB = false;
                f.this.vU(true);
                if (!f.this.maA) {
                    f.this.may.hideNoDataView();
                    f.this.showLoadingView(f.this.may.getRootView());
                }
            } else {
                if (f.this.hvn > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.hvn, f.this.maz.cga() - f.this.hvn, f.this.maz.cfY(), f.this.maz.cfZ(), currentTimeMillis - f.this.maz.cfX());
                    f.this.hvn = -1L;
                }
                if (!f.this.maA) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.may.Bd(R.string.no_data_text);
                    } else {
                        f.this.may.Bd(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.may.dvz();
                if (!f.this.maA) {
                    f.this.cij();
                    return;
                }
                return;
            }
            f.this.efn.showToast(str);
            f.this.may.dvA();
        }
    };
    private final NoNetworkView.a fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.vU(true);
            }
        }
    };
    private final View.OnKeyListener maD = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c esW = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.vU(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.efn = getPageContext();
        this.hvn = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.may = new j(getPageContext(), this.mRootView, this.maD);
        this.may.setListPullRefreshListener(this.esW);
        this.mNavigationBar = (NavigationBar) this.efn.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.efn.getString(R.string.ba_square));
    }

    private void initData() {
        this.maz = new SquareModel(getPageContext());
        this.maz.a(this.maC);
        this.maB = true;
        vU(this.maB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cij() {
        this.may.c(this.fCp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cik() {
        this.may.d(this.fCp);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            vU(true);
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
        if (this.may != null) {
            this.may.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.maz != null) {
            this.maz.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.maz != null) {
            boolean z5 = this.maz.dvw() == null || this.maz.dvw().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.maB = false;
                z3 = true;
                z2 = false;
            }
            if (this.maB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.maz.dvx();
                } else {
                    this.maz.dvy();
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
