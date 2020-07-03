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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes10.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> dPv;
    private View mRootView;
    private j lBy = null;
    private SquareModel lBz = null;
    private boolean lBA = false;
    private boolean lBB = false;
    private long hcE = -1;
    private final SquareModel.a lBC = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.lBy.B(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.lBy.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.lBy.c(SquareFragment.this.lBz.dgP());
                SquareFragment.this.lBA = true;
                SquareFragment.this.lBy.hideNoDataView();
                SquareFragment.this.bUu();
            }
            if (SquareFragment.this.lBB) {
                SquareFragment.this.lBB = false;
                SquareFragment.this.uB(true);
                if (!SquareFragment.this.lBA) {
                    SquareFragment.this.lBy.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.lBy.getRootView());
                }
            } else {
                if (SquareFragment.this.hcE > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.hcE, SquareFragment.this.lBz.bSv() - SquareFragment.this.hcE, SquareFragment.this.lBz.bSt(), SquareFragment.this.lBz.bSu(), currentTimeMillis - SquareFragment.this.lBz.bSs());
                    SquareFragment.this.hcE = -1L;
                }
                if (!SquareFragment.this.lBA) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.lBy.ym(R.string.no_data_text);
                    } else {
                        SquareFragment.this.lBy.ym(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.lBy.dgS();
                if (!SquareFragment.this.lBA) {
                    SquareFragment.this.bUt();
                    return;
                }
                return;
            }
            SquareFragment.this.dPv.showToast(str);
            SquareFragment.this.lBy.dgT();
        }
    };
    private final NoNetworkView.a flL = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.uB(true);
            }
        }
    };
    private final View.OnKeyListener lBD = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c ecS = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.uB(true);
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
        this.dPv = getPageContext();
        this.hcE = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        uB(this.lBB);
    }

    private void initUI() {
        this.lBy = new j(this.dPv, getUniqueId(), this.mRootView, this.lBD);
        this.lBy.setListPullRefreshListener(this.ecS);
    }

    private void initData() {
        this.lBz = new SquareModel(this.dPv);
        this.lBz.a(this.lBC);
        this.lBB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUt() {
        this.lBy.c(this.flL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUu() {
        this.lBy.d(this.flL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            uB(true);
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
        if (this.lBy != null) {
            this.lBy.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.lBz.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lBz != null) {
            boolean z5 = this.lBz.dgP() == null || this.lBz.dgP().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lBB = false;
                z3 = true;
                z2 = false;
            }
            if (this.lBB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lBz.dgQ();
                } else {
                    this.lBz.dgR();
                }
            }
        }
    }
}
