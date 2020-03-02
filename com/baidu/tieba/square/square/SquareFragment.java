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
    private TbPageContext<?> cVh;
    private View mRootView;
    private j kcp = null;
    private SquareModel kcq = null;
    private boolean kcr = false;
    private boolean kcs = false;
    private long fVg = -1;
    private final SquareModel.a kct = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kcp.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kcp.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kcp.c(SquareFragment.this.kcq.cJS());
                SquareFragment.this.kcr = true;
                SquareFragment.this.kcp.hideNoDataView();
                SquareFragment.this.bAv();
            }
            if (SquareFragment.this.kcs) {
                SquareFragment.this.kcs = false;
                SquareFragment.this.sG(true);
                if (!SquareFragment.this.kcr) {
                    SquareFragment.this.kcp.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kcp.getRootView());
                }
            } else {
                if (SquareFragment.this.fVg > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fVg, SquareFragment.this.kcq.byP() - SquareFragment.this.fVg, SquareFragment.this.kcq.byN(), SquareFragment.this.kcq.byO(), currentTimeMillis - SquareFragment.this.kcq.byM());
                    SquareFragment.this.fVg = -1L;
                }
                if (!SquareFragment.this.kcr) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kcp.wo(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kcp.wo(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kcp.cJV();
                if (!SquareFragment.this.kcr) {
                    SquareFragment.this.bAu();
                    return;
                }
                return;
            }
            SquareFragment.this.cVh.showToast(str);
            SquareFragment.this.kcp.cJW();
        }
    };
    private final NoNetworkView.a fYL = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.sG(true);
            }
        }
    };
    private final View.OnKeyListener kcu = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dgI = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.cVh = getPageContext();
        this.fVg = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        sG(this.kcs);
    }

    private void initUI() {
        this.kcp = new j(this.cVh, getUniqueId(), this.mRootView, this.kcu);
        this.kcp.setListPullRefreshListener(this.dgI);
    }

    private void initData() {
        this.kcq = new SquareModel(this.cVh);
        this.kcq.a(this.kct);
        this.kcs = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        this.kcp.c(this.fYL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAv() {
        this.kcp.d(this.fYL);
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
        if (this.kcp != null) {
            this.kcp.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kcq.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kcq != null) {
            boolean z5 = this.kcq.cJS() == null || this.kcq.cJS().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kcs = false;
                z3 = true;
                z2 = false;
            }
            if (this.kcs) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kcq.cJT();
                } else {
                    this.kcq.cJU();
                }
            }
        }
    }
}
