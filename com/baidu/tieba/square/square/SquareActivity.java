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
import com.baidu.tieba.d;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes5.dex */
public class SquareActivity extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean needRefresh = false;
    private TbPageContext<Object> mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private h iBZ = null;
    private SquareModel iCa = null;
    private boolean iCb = false;
    private boolean iCc = false;
    private long eCL = -1;
    private final SquareModel.a iCd = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareActivity.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareActivity.this.iBZ.y(true, "");
            SquareActivity.this.hideLoadingView(SquareActivity.this.iBZ.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareActivity.this.iBZ.c(SquareActivity.this.iCa.cdl());
                SquareActivity.this.iCb = true;
                SquareActivity.this.iBZ.hideNoDataView();
                SquareActivity.this.aYp();
            }
            if (SquareActivity.this.iCc) {
                SquareActivity.this.iCc = false;
                SquareActivity.this.pQ(true);
                if (!SquareActivity.this.iCb) {
                    SquareActivity.this.iBZ.hideNoDataView();
                    SquareActivity.this.showLoadingView(SquareActivity.this.iBZ.getRootView());
                }
            } else {
                if (SquareActivity.this.eCL > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareActivity.this.eCL, SquareActivity.this.iCa.aWU() - SquareActivity.this.eCL, SquareActivity.this.iCa.aWS(), SquareActivity.this.iCa.aWT(), currentTimeMillis - SquareActivity.this.iCa.aWR());
                    SquareActivity.this.eCL = -1L;
                }
                if (!SquareActivity.this.iCb) {
                    if (j.kY()) {
                        SquareActivity.this.iBZ.nS(d.j.no_data_text);
                    } else {
                        SquareActivity.this.iBZ.nS(d.j.game_index_no_network_text);
                    }
                }
            }
            if (!j.kY()) {
                SquareActivity.this.iBZ.cdo();
                if (!SquareActivity.this.iCb) {
                    SquareActivity.this.aYo();
                    return;
                }
                return;
            }
            SquareActivity.this.mContext.showToast(str);
            SquareActivity.this.iBZ.cdp();
        }
    };
    private final NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                SquareActivity.this.pQ(true);
            }
        }
    };
    private final View.OnKeyListener iCe = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareActivity.4
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
    private final h.c bRG = new h.c() { // from class: com.baidu.tieba.square.square.SquareActivity.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            SquareActivity.this.pQ(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext();
        this.eCL = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.iBZ = new h(getPageContext(), this.mRootView, this.iCe);
        this.iBZ.setListPullRefreshListener(this.bRG);
        this.mNavigationBar = (NavigationBar) this.mContext.getPageActivity().findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.square.square.SquareActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SquareActivity.this.closeActivity();
            }
        });
        this.mNavigationBar.setTitleText(this.mContext.getString(d.j.ba_square));
    }

    private void initData() {
        this.iCa = new SquareModel(getPageContext());
        this.iCa.a(this.iCd);
        this.iCc = true;
        pQ(this.iCc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYo() {
        this.iBZ.d(this.emM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYp() {
        this.iBZ.e(this.emM);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            pQ(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        anz();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iBZ != null) {
            this.iBZ.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void anz() {
        if (this.iCa != null) {
            this.iCa.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iCa != null) {
            boolean z5 = this.iCa.cdl() == null || this.iCa.cdl().isEmpty();
            boolean z6 = z;
            if (j.kY()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iCc = false;
                z3 = true;
                z2 = false;
            }
            if (this.iCc) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                anz();
                if (z4) {
                    this.iCa.cdm();
                } else {
                    this.iCa.cdn();
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
    public void po() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void pp() {
        setSwipeBackEnabled(false);
    }
}
