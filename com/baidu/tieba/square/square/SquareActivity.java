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
    private h jaU = null;
    private SquareModel jaV = null;
    private boolean jaW = false;
    private boolean jaX = false;
    private long eXm = -1;
    private final SquareModel.a jaY = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareActivity.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareActivity.this.jaU.y(true, "");
            SquareActivity.this.hideLoadingView(SquareActivity.this.jaU.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareActivity.this.jaU.c(SquareActivity.this.jaV.cog());
                SquareActivity.this.jaW = true;
                SquareActivity.this.jaU.hideNoDataView();
                SquareActivity.this.bhM();
            }
            if (SquareActivity.this.jaX) {
                SquareActivity.this.jaX = false;
                SquareActivity.this.qV(true);
                if (!SquareActivity.this.jaW) {
                    SquareActivity.this.jaU.hideNoDataView();
                    SquareActivity.this.showLoadingView(SquareActivity.this.jaU.getRootView());
                }
            } else {
                if (SquareActivity.this.eXm > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareActivity.this.eXm, SquareActivity.this.jaV.bgm() - SquareActivity.this.eXm, SquareActivity.this.jaV.bgk(), SquareActivity.this.jaV.bgl(), currentTimeMillis - SquareActivity.this.jaV.bgj());
                    SquareActivity.this.eXm = -1L;
                }
                if (!SquareActivity.this.jaW) {
                    if (j.kc()) {
                        SquareActivity.this.jaU.oW(R.string.no_data_text);
                    } else {
                        SquareActivity.this.jaU.oW(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.kc()) {
                SquareActivity.this.jaU.coj();
                if (!SquareActivity.this.jaW) {
                    SquareActivity.this.bhL();
                    return;
                }
                return;
            }
            SquareActivity.this.mContext.showToast(str);
            SquareActivity.this.jaU.cok();
        }
    };
    private final NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                SquareActivity.this.qV(true);
            }
        }
    };
    private final View.OnKeyListener jaZ = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareActivity.4
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
    private final h.c caD = new h.c() { // from class: com.baidu.tieba.square.square.SquareActivity.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            SquareActivity.this.qV(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext();
        this.eXm = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.jaU = new h(getPageContext(), this.mRootView, this.jaZ);
        this.jaU.setListPullRefreshListener(this.caD);
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
        this.jaV = new SquareModel(getPageContext());
        this.jaV.a(this.jaY);
        this.jaX = true;
        qV(this.jaX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhL() {
        this.jaU.d(this.eHh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhM() {
        this.jaU.e(this.eHh);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qV(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        atG();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jaU != null) {
            this.jaU.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void atG() {
        if (this.jaV != null) {
            this.jaV.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jaV != null) {
            boolean z5 = this.jaV.cog() == null || this.jaV.cog().isEmpty();
            boolean z6 = z;
            if (j.kc()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jaX = false;
                z3 = true;
                z2 = false;
            }
            if (this.jaX) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                atG();
                if (z4) {
                    this.jaV.coh();
                } else {
                    this.jaV.coi();
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
