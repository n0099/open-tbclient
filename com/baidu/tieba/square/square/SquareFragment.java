package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes5.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> mContext;
    private View mRootView;
    private h iUA = null;
    private SquareModel iUB = null;
    private boolean iUC = false;
    private boolean iUD = false;
    private long eSm = -1;
    private final SquareModel.a iUE = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.iUA.x(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.iUA.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.iUA.c(SquareFragment.this.iUB.cln());
                SquareFragment.this.iUC = true;
                SquareFragment.this.iUA.hideNoDataView();
                SquareFragment.this.bfJ();
            }
            if (SquareFragment.this.iUD) {
                SquareFragment.this.iUD = false;
                SquareFragment.this.qF(true);
                if (!SquareFragment.this.iUC) {
                    SquareFragment.this.iUA.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.iUA.getRootView());
                }
            } else {
                if (SquareFragment.this.eSm > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eSm, SquareFragment.this.iUB.bej() - SquareFragment.this.eSm, SquareFragment.this.iUB.beh(), SquareFragment.this.iUB.bei(), currentTimeMillis - SquareFragment.this.iUB.beg());
                    SquareFragment.this.eSm = -1L;
                }
                if (!SquareFragment.this.iUC) {
                    if (j.jS()) {
                        SquareFragment.this.iUA.oH(R.string.no_data_text);
                    } else {
                        SquareFragment.this.iUA.oH(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.jS()) {
                SquareFragment.this.iUA.clq();
                if (!SquareFragment.this.iUC) {
                    SquareFragment.this.bfI();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.iUA.clr();
        }
    };
    private final NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                SquareFragment.this.qF(true);
            }
        }
    };
    private final View.OnKeyListener iUF = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c bZA = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            SquareFragment.this.qF(true);
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getPageContext();
        this.eSm = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qF(this.iUD);
    }

    private void initUI() {
        this.iUA = new h(this.mContext, getUniqueId(), this.mRootView, this.iUF);
        this.iUA.setListPullRefreshListener(this.bZA);
    }

    private void initData() {
        this.iUB = new SquareModel(this.mContext);
        this.iUB.a(this.iUE);
        this.iUD = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfI() {
        this.iUA.d(this.eCl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfJ() {
        this.iUA.e(this.eCl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qF(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        asz();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iUA != null) {
            this.iUA.onChangeSkinType(i);
        }
    }

    private void asz() {
        this.iUB.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iUB != null) {
            boolean z5 = this.iUB.cln() == null || this.iUB.cln().isEmpty();
            boolean z6 = z;
            if (j.jS()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iUD = false;
                z3 = true;
                z2 = false;
            }
            if (this.iUD) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                asz();
                if (z4) {
                    this.iUB.clo();
                } else {
                    this.iUB.clp();
                }
            }
        }
    }
}
