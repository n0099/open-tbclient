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
    private h jbY = null;
    private SquareModel jbZ = null;
    private boolean jca = false;
    private boolean jcb = false;
    private long eXw = -1;
    private final SquareModel.a jcc = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareActivity.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareActivity.this.jbY.y(true, "");
            SquareActivity.this.hideLoadingView(SquareActivity.this.jbY.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareActivity.this.jbY.c(SquareActivity.this.jbZ.coy());
                SquareActivity.this.jca = true;
                SquareActivity.this.jbY.hideNoDataView();
                SquareActivity.this.bhT();
            }
            if (SquareActivity.this.jcb) {
                SquareActivity.this.jcb = false;
                SquareActivity.this.qW(true);
                if (!SquareActivity.this.jca) {
                    SquareActivity.this.jbY.hideNoDataView();
                    SquareActivity.this.showLoadingView(SquareActivity.this.jbY.getRootView());
                }
            } else {
                if (SquareActivity.this.eXw > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareActivity.this.eXw, SquareActivity.this.jbZ.bgp() - SquareActivity.this.eXw, SquareActivity.this.jbZ.bgn(), SquareActivity.this.jbZ.bgo(), currentTimeMillis - SquareActivity.this.jbZ.bgm());
                    SquareActivity.this.eXw = -1L;
                }
                if (!SquareActivity.this.jca) {
                    if (j.kc()) {
                        SquareActivity.this.jbY.oX(R.string.no_data_text);
                    } else {
                        SquareActivity.this.jbY.oX(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.kc()) {
                SquareActivity.this.jbY.coB();
                if (!SquareActivity.this.jca) {
                    SquareActivity.this.bhS();
                    return;
                }
                return;
            }
            SquareActivity.this.mContext.showToast(str);
            SquareActivity.this.jbY.coC();
        }
    };
    private final NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                SquareActivity.this.qW(true);
            }
        }
    };
    private final View.OnKeyListener jcd = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareActivity.4
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
    private final h.c caJ = new h.c() { // from class: com.baidu.tieba.square.square.SquareActivity.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            SquareActivity.this.qW(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext();
        this.eXw = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.jbY = new h(getPageContext(), this.mRootView, this.jcd);
        this.jbY.setListPullRefreshListener(this.caJ);
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
        this.jbZ = new SquareModel(getPageContext());
        this.jbZ.a(this.jcc);
        this.jcb = true;
        qW(this.jcb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhS() {
        this.jbY.d(this.eHo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhT() {
        this.jbY.e(this.eHo);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qW(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        atI();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jbY != null) {
            this.jbY.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void atI() {
        if (this.jbZ != null) {
            this.jbZ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jbZ != null) {
            boolean z5 = this.jbZ.coy() == null || this.jbZ.coy().isEmpty();
            boolean z6 = z;
            if (j.kc()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jcb = false;
                z3 = true;
                z2 = false;
            }
            if (this.jcb) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                atI();
                if (z4) {
                    this.jbZ.coz();
                } else {
                    this.jbZ.coA();
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
            com.baidu.tbadk.core.f.b.o(getActivity(), 1);
        } else {
            com.baidu.tbadk.core.f.b.o(getActivity(), 2);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void oE() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void oF() {
        setSwipeBackEnabled(false);
    }
}
