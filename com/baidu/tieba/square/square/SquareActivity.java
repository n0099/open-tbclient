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
    private h jet = null;
    private SquareModel jeu = null;
    private boolean jev = false;
    private boolean jew = false;
    private long eZc = -1;
    private final SquareModel.a jex = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareActivity.2
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareActivity.this.jet.y(true, "");
            SquareActivity.this.hideLoadingView(SquareActivity.this.jet.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareActivity.this.jet.c(SquareActivity.this.jeu.cpl());
                SquareActivity.this.jev = true;
                SquareActivity.this.jet.hideNoDataView();
                SquareActivity.this.biE();
            }
            if (SquareActivity.this.jew) {
                SquareActivity.this.jew = false;
                SquareActivity.this.qZ(true);
                if (!SquareActivity.this.jev) {
                    SquareActivity.this.jet.hideNoDataView();
                    SquareActivity.this.showLoadingView(SquareActivity.this.jet.getRootView());
                }
            } else {
                if (SquareActivity.this.eZc > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareActivity.this.eZc, SquareActivity.this.jeu.bgV() - SquareActivity.this.eZc, SquareActivity.this.jeu.bgT(), SquareActivity.this.jeu.bgU(), currentTimeMillis - SquareActivity.this.jeu.bgS());
                    SquareActivity.this.eZc = -1L;
                }
                if (!SquareActivity.this.jev) {
                    if (j.kc()) {
                        SquareActivity.this.jet.pb(R.string.no_data_text);
                    } else {
                        SquareActivity.this.jet.pb(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.kc()) {
                SquareActivity.this.jet.cpo();
                if (!SquareActivity.this.jev) {
                    SquareActivity.this.biD();
                    return;
                }
                return;
            }
            SquareActivity.this.mContext.showToast(str);
            SquareActivity.this.jet.cpp();
        }
    };
    private final NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z) {
                SquareActivity.this.qZ(true);
            }
        }
    };
    private final View.OnKeyListener jey = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareActivity.4
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
    private final h.c cbC = new h.c() { // from class: com.baidu.tieba.square.square.SquareActivity.5
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            SquareActivity.this.qZ(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getPageContext();
        this.eZc = System.currentTimeMillis();
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.mRootView);
        initUI();
        initData();
    }

    private void initUI() {
        this.jet = new h(getPageContext(), this.mRootView, this.jey);
        this.jet.setListPullRefreshListener(this.cbC);
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
        this.jeu = new SquareModel(getPageContext());
        this.jeu.a(this.jex);
        this.jew = true;
        qZ(this.jew);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biD() {
        this.jet.d(this.eIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biE() {
        this.jet.e(this.eIX);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qZ(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        atU();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jet != null) {
            this.jet.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    private void atU() {
        if (this.jeu != null) {
            this.jeu.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qZ(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jeu != null) {
            boolean z5 = this.jeu.cpl() == null || this.jeu.cpl().isEmpty();
            boolean z6 = z;
            if (j.kc()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jew = false;
                z3 = true;
                z2 = false;
            }
            if (this.jew) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                atU();
                if (z4) {
                    this.jeu.cpm();
                } else {
                    this.jeu.cpn();
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
    public void oF() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void oG() {
        setSwipeBackEnabled(false);
    }
}
