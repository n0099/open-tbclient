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
/* loaded from: classes7.dex */
public class f extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> eWx;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private j nuK = null;
    private SquareModel nuL = null;
    private boolean nuM = false;
    private boolean nuN = false;
    private long iKN = -1;
    private final SquareModel.a nuO = new SquareModel.a() { // from class: com.baidu.tieba.square.square.f.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            f.this.nuK.N(true, "");
            f.this.hideLoadingView(f.this.nuK.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                f.this.nuK.c(f.this.nuL.dMz());
                f.this.nuM = true;
                f.this.nuK.hideNoDataView();
                f.this.cyX();
            }
            if (f.this.nuN) {
                f.this.nuN = false;
                f.this.yl(true);
                if (!f.this.nuM) {
                    f.this.nuK.hideNoDataView();
                    f.this.showLoadingView(f.this.nuK.getRootView());
                }
            } else {
                if (f.this.iKN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - f.this.iKN, f.this.nuL.cwQ() - f.this.iKN, f.this.nuL.cwO(), f.this.nuL.cwP(), currentTimeMillis - f.this.nuL.cwN());
                    f.this.iKN = -1L;
                }
                if (!f.this.nuM) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        f.this.nuK.Db(R.string.no_data_text);
                    } else {
                        f.this.nuK.Db(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                f.this.nuK.dMC();
                if (!f.this.nuM) {
                    f.this.cyW();
                    return;
                }
                return;
            }
            f.this.eWx.showToast(str);
            f.this.nuK.dMD();
        }
    };
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.f.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                f.this.yl(true);
            }
        }
    };
    private final View.OnKeyListener nuP = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.f.4
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
    private final f.c fkY = new f.c() { // from class: com.baidu.tieba.square.square.f.5
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            f.this.yl(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eWx = getPageContext();
        this.iKN = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.nuK = new j(getPageContext(), this.mRootView, this.nuP);
        this.nuK.setListPullRefreshListener(this.fkY);
        this.mNavigationBar = (NavigationBar) this.eWx.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.eWx.getString(R.string.ba_square));
    }

    private void initData() {
        this.nuL = new SquareModel(getPageContext());
        this.nuL.a(this.nuO);
        this.nuN = true;
        yl(this.nuN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyW() {
        this.nuK.c(this.gzW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyX() {
        this.nuK.d(this.gzW);
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
        if (this.nuK != null) {
            this.nuK.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.nuL != null) {
            this.nuL.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        boolean z2 = false;
        if (this.nuL != null) {
            boolean z3 = this.nuL.dMz() == null || this.nuL.dMz().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nuN = false;
                z3 = true;
                z4 = false;
            }
            if (this.nuN) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nuL.dMA();
                } else {
                    this.nuL.dMB();
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
