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
    private j nsF = null;
    private SquareModel nsG = null;
    private boolean nsH = false;
    private boolean nsI = false;
    private long iJe = -1;
    private final SquareModel.a nsJ = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.nsF.N(true, "");
            f.this.hideLoadingView(f.this.nsF.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.nsF.c(f.this.nsG.dMr());
                f.this.nsH = true;
                f.this.nsF.hideNoDataView();
                f.this.cyR();
            }
            if (f.this.nsI) {
                f.this.nsI = false;
                f.this.yl(true);
                if (!f.this.nsH) {
                    f.this.nsF.hideNoDataView();
                    f.this.showLoadingView(f.this.nsF.getRootView());
                }
            } else {
                if (f.this.iJe > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.iJe, f.this.nsG.cwK() - f.this.iJe, f.this.nsG.cwI(), f.this.nsG.cwJ(), currentTimeMillis - f.this.nsG.cwH());
                    f.this.iJe = -1L;
                }
                if (!f.this.nsH) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.nsF.CY(R.string.no_data_text);
                    } else {
                        f.this.nsF.CY(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.nsF.dMu();
                if (!f.this.nsH) {
                    f.this.cyQ();
                    return;
                }
                return;
            }
            f.this.eUY.showToast(str);
            f.this.nsF.dMv();
        }
    };
    private final NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.yl(true);
            }
        }
    };
    private final View.OnKeyListener nsK = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
        this.iJe = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.nsF = new j(getPageContext(), this.mRootView, this.nsK);
        this.nsF.setListPullRefreshListener(this.fjz);
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
        this.nsG = new SquareModel(getPageContext());
        this.nsG.a(this.nsJ);
        this.nsI = true;
        yl(this.nsI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyQ() {
        this.nsF.c(this.gyn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyR() {
        this.nsF.d(this.gyn);
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
        if (this.nsF != null) {
            this.nsF.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.nsG != null) {
            this.nsG.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        boolean z2 = false;
        if (this.nsG != null) {
            boolean z3 = this.nsG.dMr() == null || this.nsG.dMr().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nsI = false;
                z3 = true;
                z4 = false;
            }
            if (this.nsI) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nsG.dMs();
                } else {
                    this.nsG.dMt();
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
