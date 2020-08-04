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
/* loaded from: classes17.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> dVN;
    private View mRootView;
    private j lIP = null;
    private SquareModel lIQ = null;
    private boolean lIR = false;
    private boolean lIS = false;
    private long hio = -1;
    private final SquareModel.a lIT = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.lIP.B(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.lIP.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.lIP.c(SquareFragment.this.lIQ.djZ());
                SquareFragment.this.lIR = true;
                SquareFragment.this.lIP.hideNoDataView();
                SquareFragment.this.bXO();
            }
            if (SquareFragment.this.lIS) {
                SquareFragment.this.lIS = false;
                SquareFragment.this.vf(true);
                if (!SquareFragment.this.lIR) {
                    SquareFragment.this.lIP.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.lIP.getRootView());
                }
            } else {
                if (SquareFragment.this.hio > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.hio, SquareFragment.this.lIQ.bVN() - SquareFragment.this.hio, SquareFragment.this.lIQ.bVL(), SquareFragment.this.lIQ.bVM(), currentTimeMillis - SquareFragment.this.lIQ.bVK());
                    SquareFragment.this.hio = -1L;
                }
                if (!SquareFragment.this.lIR) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.lIP.yK(R.string.no_data_text);
                    } else {
                        SquareFragment.this.lIP.yK(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.lIP.dkc();
                if (!SquareFragment.this.lIR) {
                    SquareFragment.this.bXN();
                    return;
                }
                return;
            }
            SquareFragment.this.dVN.showToast(str);
            SquareFragment.this.lIP.dkd();
        }
    };
    private final NoNetworkView.a fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.vf(true);
            }
        }
    };
    private final View.OnKeyListener lIU = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c ejc = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.vf(true);
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
        this.dVN = getPageContext();
        this.hio = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        vf(this.lIS);
    }

    private void initUI() {
        this.lIP = new j(this.dVN, getUniqueId(), this.mRootView, this.lIU);
        this.lIP.setListPullRefreshListener(this.ejc);
    }

    private void initData() {
        this.lIQ = new SquareModel(this.dVN);
        this.lIQ.a(this.lIT);
        this.lIS = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXN() {
        this.lIP.c(this.fqT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        this.lIP.d(this.fqT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            vf(true);
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
        if (this.lIP != null) {
            this.lIP.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.lIQ.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vf(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lIQ != null) {
            boolean z5 = this.lIQ.djZ() == null || this.lIQ.djZ().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lIS = false;
                z3 = true;
                z2 = false;
            }
            if (this.lIS) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lIQ.dka();
                } else {
                    this.lIQ.dkb();
                }
            }
        }
    }
}
