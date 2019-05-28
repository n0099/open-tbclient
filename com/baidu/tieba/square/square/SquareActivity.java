package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.SwipeBackLayout;
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
    private TbPageContext<Object> mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private h iUA = null;
    private SquareModel iUB = null;
    private boolean iUC = false;
    private boolean iUD = false;
    private long eSm = -1;
    private final SquareModel.a iUE = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareActivity.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareActivity.this.iUA.x(true, "");
            SquareActivity.this.hideLoadingView(SquareActivity.this.iUA.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareActivity.this.iUA.c(SquareActivity.this.iUB.cln());
                SquareActivity.this.iUC = true;
                SquareActivity.this.iUA.hideNoDataView();
                SquareActivity.this.bfJ();
            }
            if (SquareActivity.this.iUD) {
                SquareActivity.this.iUD = false;
                SquareActivity.this.qF(true);
                if (!SquareActivity.this.iUC) {
                    SquareActivity.this.iUA.hideNoDataView();
                    SquareActivity.this.showLoadingView(SquareActivity.this.iUA.getRootView());
                }
            } else {
                if (SquareActivity.this.eSm > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareActivity.this.eSm, SquareActivity.this.iUB.bej() - SquareActivity.this.eSm, SquareActivity.this.iUB.beh(), SquareActivity.this.iUB.bei(), currentTimeMillis - SquareActivity.this.iUB.beg());
                    SquareActivity.this.eSm = -1L;
                }
                if (!SquareActivity.this.iUC) {
                    if (j.jS()) {
                        SquareActivity.this.iUA.oH(R.string.no_data_text);
                    } else {
                        SquareActivity.this.iUA.oH(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.jS()) {
                SquareActivity.this.iUA.clq();
                if (!SquareActivity.this.iUC) {
                    SquareActivity.this.bfI();
                    return;
                }
                return;
            }
            SquareActivity.this.mContext.showToast(str);
            SquareActivity.this.iUA.clr();
        }
    };
    private final NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                SquareActivity.this.qF(true);
            }
        }
    };
    private final View.OnKeyListener iUF = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareActivity.4
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
    private final h.c bZA = new h.c() { // from class: com.baidu.tieba.square.square.SquareActivity.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            SquareActivity.this.qF(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext();
        this.eSm = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.iUA = new h(getPageContext(), this.mRootView, this.iUF);
        this.iUA.setListPullRefreshListener(this.bZA);
        this.mNavigationBar = (NavigationBar) this.mContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.SquareActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareActivity.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.mContext.getString(R.string.ba_square));
    }

    private void initData() {
        this.iUB = new SquareModel(getPageContext());
        this.iUB.a(this.iUE);
        this.iUD = true;
        qF(this.iUD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfI() {
        this.iUA.d(this.eCl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfJ() {
        this.iUA.e(this.eCl);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qF(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        asz();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iUA != null) {
            this.iUA.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void asz() {
        if (this.iUB != null) {
            this.iUB.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iUB != null) {
            boolean z5 = this.iUB.cln() == null || this.iUB.cln().isEmpty();
            boolean z6 = z;
            if (j.jS()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iUD = false;
                z3 = true;
                z2 = false;
            }
            if (this.iUD) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                asz();
                if (z4) {
                    this.iUB.clo();
                } else {
                    this.iUB.clp();
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
            com.baidu.tbadk.core.e.b.o(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.e.b.o(getActivity(), 2);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void oj() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void ok() {
        setSwipeBackEnabled(false);
    }
}
