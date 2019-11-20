package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes5.dex */
public class SquareActivity extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> ceu;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private h jdt = null;
    private SquareModel jdu = null;
    private boolean jdv = false;
    private boolean jdw = false;
    private long faW = -1;
    private final SquareModel.a jdx = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareActivity.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareActivity.this.jdt.y(true, "");
            SquareActivity.this.hideLoadingView(SquareActivity.this.jdt.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareActivity.this.jdt.c(SquareActivity.this.jdu.cna());
                SquareActivity.this.jdv = true;
                SquareActivity.this.jdt.hideNoDataView();
                SquareActivity.this.bgu();
            }
            if (SquareActivity.this.jdw) {
                SquareActivity.this.jdw = false;
                SquareActivity.this.qI(true);
                if (!SquareActivity.this.jdv) {
                    SquareActivity.this.jdt.hideNoDataView();
                    SquareActivity.this.showLoadingView(SquareActivity.this.jdt.getRootView());
                }
            } else {
                if (SquareActivity.this.faW > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareActivity.this.faW, SquareActivity.this.jdu.beM() - SquareActivity.this.faW, SquareActivity.this.jdu.beK(), SquareActivity.this.jdu.beL(), currentTimeMillis - SquareActivity.this.jdu.beJ());
                    SquareActivity.this.faW = -1L;
                }
                if (!SquareActivity.this.jdv) {
                    if (j.isNetWorkAvailable()) {
                        SquareActivity.this.jdt.ub(R.string.no_data_text);
                    } else {
                        SquareActivity.this.jdt.ub(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.isNetWorkAvailable()) {
                SquareActivity.this.jdt.cnd();
                if (!SquareActivity.this.jdv) {
                    SquareActivity.this.bgt();
                    return;
                }
                return;
            }
            SquareActivity.this.ceu.showToast(str);
            SquareActivity.this.jdt.cne();
        }
    };
    private final NoNetworkView.a eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareActivity.this.qI(true);
            }
        }
    };
    private final View.OnKeyListener jdy = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareActivity.4
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
    private final h.c cpa = new h.c() { // from class: com.baidu.tieba.square.square.SquareActivity.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            SquareActivity.this.qI(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ceu = getPageContext();
        this.faW = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.jdt = new h(getPageContext(), this.mRootView, this.jdy);
        this.jdt.setListPullRefreshListener(this.cpa);
        this.mNavigationBar = (NavigationBar) this.ceu.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.SquareActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareActivity.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.ceu.getString(R.string.ba_square));
    }

    private void initData() {
        this.jdu = new SquareModel(getPageContext());
        this.jdu.a(this.jdx);
        this.jdw = true;
        qI(this.jdw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgt() {
        this.jdt.d(this.eQL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgu() {
        this.jdt.e(this.eQL);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qI(true);
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
        if (this.jdt != null) {
            this.jdt.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void cancelAllAsyncTask() {
        if (this.jdu != null) {
            this.jdu.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jdu != null) {
            boolean z5 = this.jdu.cna() == null || this.jdu.cna().isEmpty();
            boolean z6 = z;
            if (j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jdw = false;
                z3 = true;
                z2 = false;
            }
            if (this.jdw) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.jdu.cnb();
                } else {
                    this.jdu.cnc();
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
            com.baidu.tbadk.core.f.b.m(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.f.b.m(getActivity(), 2);
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
