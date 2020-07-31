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
    private j lIN = null;
    private SquareModel lIO = null;
    private boolean lIP = false;
    private boolean lIQ = false;
    private long hio = -1;
    private final SquareModel.a lIR = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.lIN.B(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.lIN.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.lIN.c(SquareFragment.this.lIO.djZ());
                SquareFragment.this.lIP = true;
                SquareFragment.this.lIN.hideNoDataView();
                SquareFragment.this.bXO();
            }
            if (SquareFragment.this.lIQ) {
                SquareFragment.this.lIQ = false;
                SquareFragment.this.vf(true);
                if (!SquareFragment.this.lIP) {
                    SquareFragment.this.lIN.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.lIN.getRootView());
                }
            } else {
                if (SquareFragment.this.hio > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.hio, SquareFragment.this.lIO.bVN() - SquareFragment.this.hio, SquareFragment.this.lIO.bVL(), SquareFragment.this.lIO.bVM(), currentTimeMillis - SquareFragment.this.lIO.bVK());
                    SquareFragment.this.hio = -1L;
                }
                if (!SquareFragment.this.lIP) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.lIN.yK(R.string.no_data_text);
                    } else {
                        SquareFragment.this.lIN.yK(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.lIN.dkc();
                if (!SquareFragment.this.lIP) {
                    SquareFragment.this.bXN();
                    return;
                }
                return;
            }
            SquareFragment.this.dVN.showToast(str);
            SquareFragment.this.lIN.dkd();
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
    private final View.OnKeyListener lIS = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
        vf(this.lIQ);
    }

    private void initUI() {
        this.lIN = new j(this.dVN, getUniqueId(), this.mRootView, this.lIS);
        this.lIN.setListPullRefreshListener(this.ejc);
    }

    private void initData() {
        this.lIO = new SquareModel(this.dVN);
        this.lIO.a(this.lIR);
        this.lIQ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXN() {
        this.lIN.c(this.fqT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        this.lIN.d(this.fqT);
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
        if (this.lIN != null) {
            this.lIN.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.lIO.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vf(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lIO != null) {
            boolean z5 = this.lIO.djZ() == null || this.lIO.djZ().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lIQ = false;
                z3 = true;
                z2 = false;
            }
            if (this.lIQ) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lIO.dka();
                } else {
                    this.lIO.dkb();
                }
            }
        }
    }
}
