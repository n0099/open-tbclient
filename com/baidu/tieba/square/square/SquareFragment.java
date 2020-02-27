package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes10.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> cVg;
    private View mRootView;
    private j kcn = null;
    private SquareModel kco = null;
    private boolean kcp = false;
    private boolean kcq = false;
    private long fVe = -1;
    private final SquareModel.a kcr = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kcn.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kcn.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kcn.c(SquareFragment.this.kco.cJQ());
                SquareFragment.this.kcp = true;
                SquareFragment.this.kcn.hideNoDataView();
                SquareFragment.this.bAt();
            }
            if (SquareFragment.this.kcq) {
                SquareFragment.this.kcq = false;
                SquareFragment.this.sG(true);
                if (!SquareFragment.this.kcp) {
                    SquareFragment.this.kcn.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kcn.getRootView());
                }
            } else {
                if (SquareFragment.this.fVe > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fVe, SquareFragment.this.kco.byN() - SquareFragment.this.fVe, SquareFragment.this.kco.byL(), SquareFragment.this.kco.byM(), currentTimeMillis - SquareFragment.this.kco.byK());
                    SquareFragment.this.fVe = -1L;
                }
                if (!SquareFragment.this.kcp) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kcn.wo(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kcn.wo(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kcn.cJT();
                if (!SquareFragment.this.kcp) {
                    SquareFragment.this.bAs();
                    return;
                }
                return;
            }
            SquareFragment.this.cVg.showToast(str);
            SquareFragment.this.kcn.cJU();
        }
    };
    private final NoNetworkView.a fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.sG(true);
            }
        }
    };
    private final View.OnKeyListener kcs = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dgH = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.sG(true);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cVg = getPageContext();
        this.fVe = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        sG(this.kcq);
    }

    private void initUI() {
        this.kcn = new j(this.cVg, getUniqueId(), this.mRootView, this.kcs);
        this.kcn.setListPullRefreshListener(this.dgH);
    }

    private void initData() {
        this.kco = new SquareModel(this.cVg);
        this.kco.a(this.kcr);
        this.kcq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAs() {
        this.kcn.c(this.fYJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAt() {
        this.kcn.d(this.fYJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sG(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        cancelAllAsyncTask();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kcn != null) {
            this.kcn.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kco.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kco != null) {
            boolean z5 = this.kco.cJQ() == null || this.kco.cJQ().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kcq = false;
                z3 = true;
                z2 = false;
            }
            if (this.kcq) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kco.cJR();
                } else {
                    this.kco.cJS();
                }
            }
        }
    }
}
