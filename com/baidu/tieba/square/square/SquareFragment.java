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
    private TbPageContext<?> cVi;
    private View mRootView;
    private j kcB = null;
    private SquareModel kcC = null;
    private boolean kcD = false;
    private boolean kcE = false;
    private long fVt = -1;
    private final SquareModel.a kcF = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kcB.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kcB.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kcB.c(SquareFragment.this.kcC.cJT());
                SquareFragment.this.kcD = true;
                SquareFragment.this.kcB.hideNoDataView();
                SquareFragment.this.bAw();
            }
            if (SquareFragment.this.kcE) {
                SquareFragment.this.kcE = false;
                SquareFragment.this.sG(true);
                if (!SquareFragment.this.kcD) {
                    SquareFragment.this.kcB.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kcB.getRootView());
                }
            } else {
                if (SquareFragment.this.fVt > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fVt, SquareFragment.this.kcC.byQ() - SquareFragment.this.fVt, SquareFragment.this.kcC.byO(), SquareFragment.this.kcC.byP(), currentTimeMillis - SquareFragment.this.kcC.byN());
                    SquareFragment.this.fVt = -1L;
                }
                if (!SquareFragment.this.kcD) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kcB.wo(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kcB.wo(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kcB.cJW();
                if (!SquareFragment.this.kcD) {
                    SquareFragment.this.bAv();
                    return;
                }
                return;
            }
            SquareFragment.this.cVi.showToast(str);
            SquareFragment.this.kcB.cJX();
        }
    };
    private final NoNetworkView.a fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.sG(true);
            }
        }
    };
    private final View.OnKeyListener kcG = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dgV = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.cVi = getPageContext();
        this.fVt = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        sG(this.kcE);
    }

    private void initUI() {
        this.kcB = new j(this.cVi, getUniqueId(), this.mRootView, this.kcG);
        this.kcB.setListPullRefreshListener(this.dgV);
    }

    private void initData() {
        this.kcC = new SquareModel(this.cVi);
        this.kcC.a(this.kcF);
        this.kcE = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAv() {
        this.kcB.c(this.fYY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAw() {
        this.kcB.d(this.fYY);
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
        if (this.kcB != null) {
            this.kcB.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kcC.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kcC != null) {
            boolean z5 = this.kcC.cJT() == null || this.kcC.cJT().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kcE = false;
                z3 = true;
                z2 = false;
            }
            if (this.kcE) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kcC.cJU();
                } else {
                    this.kcC.cJV();
                }
            }
        }
    }
}
