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
    private TbPageContext<?> efr;
    private View mRootView;
    private j maN = null;
    private SquareModel maO = null;
    private boolean maP = false;
    private boolean maQ = false;
    private long hvt = -1;
    private final SquareModel.a maR = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.maN.C(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.maN.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.maN.c(SquareFragment.this.maO.dvB());
                SquareFragment.this.maP = true;
                SquareFragment.this.maN.hideNoDataView();
                SquareFragment.this.cil();
            }
            if (SquareFragment.this.maQ) {
                SquareFragment.this.maQ = false;
                SquareFragment.this.vW(true);
                if (!SquareFragment.this.maP) {
                    SquareFragment.this.maN.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.maN.getRootView());
                }
            } else {
                if (SquareFragment.this.hvt > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.hvt, SquareFragment.this.maO.cgb() - SquareFragment.this.hvt, SquareFragment.this.maO.cfZ(), SquareFragment.this.maO.cga(), currentTimeMillis - SquareFragment.this.maO.cfY());
                    SquareFragment.this.hvt = -1L;
                }
                if (!SquareFragment.this.maP) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.maN.Bd(R.string.no_data_text);
                    } else {
                        SquareFragment.this.maN.Bd(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.maN.dvE();
                if (!SquareFragment.this.maP) {
                    SquareFragment.this.cik();
                    return;
                }
                return;
            }
            SquareFragment.this.efr.showToast(str);
            SquareFragment.this.maN.dvF();
        }
    };
    private final NoNetworkView.a fCt = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.vW(true);
            }
        }
    };
    private final View.OnKeyListener maS = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c eta = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.vW(true);
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
        this.efr = getPageContext();
        this.hvt = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        vW(this.maQ);
    }

    private void initUI() {
        this.maN = new j(this.efr, getUniqueId(), this.mRootView, this.maS);
        this.maN.setListPullRefreshListener(this.eta);
    }

    private void initData() {
        this.maO = new SquareModel(this.efr);
        this.maO.a(this.maR);
        this.maQ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cik() {
        this.maN.c(this.fCt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cil() {
        this.maN.d(this.fCt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            vW(true);
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
        if (this.maN != null) {
            this.maN.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.maO.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.maO != null) {
            boolean z5 = this.maO.dvB() == null || this.maO.dvB().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.maQ = false;
                z3 = true;
                z2 = false;
            }
            if (this.maQ) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.maO.dvC();
                } else {
                    this.maO.dvD();
                }
            }
        }
    }
}
