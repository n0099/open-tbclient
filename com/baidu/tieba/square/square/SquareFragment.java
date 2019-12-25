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
/* loaded from: classes7.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> cQU;
    private View mRootView;
    private j jXG = null;
    private SquareModel jXH = null;
    private boolean jXI = false;
    private boolean jXJ = false;
    private long fPB = -1;
    private final SquareModel.a jXK = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.jXG.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.jXG.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.jXG.c(SquareFragment.this.jXH.cHg());
                SquareFragment.this.jXI = true;
                SquareFragment.this.jXG.hideNoDataView();
                SquareFragment.this.bxP();
            }
            if (SquareFragment.this.jXJ) {
                SquareFragment.this.jXJ = false;
                SquareFragment.this.sq(true);
                if (!SquareFragment.this.jXI) {
                    SquareFragment.this.jXG.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.jXG.getRootView());
                }
            } else {
                if (SquareFragment.this.fPB > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fPB, SquareFragment.this.jXH.bwg() - SquareFragment.this.fPB, SquareFragment.this.jXH.bwe(), SquareFragment.this.jXH.bwf(), currentTimeMillis - SquareFragment.this.jXH.bwd());
                    SquareFragment.this.fPB = -1L;
                }
                if (!SquareFragment.this.jXI) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.jXG.wd(R.string.no_data_text);
                    } else {
                        SquareFragment.this.jXG.wd(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.jXG.cHj();
                if (!SquareFragment.this.jXI) {
                    SquareFragment.this.bxO();
                    return;
                }
                return;
            }
            SquareFragment.this.cQU.showToast(str);
            SquareFragment.this.jXG.cHk();
        }
    };
    private final NoNetworkView.a fTz = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.sq(true);
            }
        }
    };
    private final View.OnKeyListener jXL = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dcr = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.sq(true);
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
        this.cQU = getPageContext();
        this.fPB = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        sq(this.jXJ);
    }

    private void initUI() {
        this.jXG = new j(this.cQU, getUniqueId(), this.mRootView, this.jXL);
        this.jXG.setListPullRefreshListener(this.dcr);
    }

    private void initData() {
        this.jXH = new SquareModel(this.cQU);
        this.jXH.a(this.jXK);
        this.jXJ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxO() {
        this.jXG.c(this.fTz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxP() {
        this.jXG.d(this.fTz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sq(true);
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
        if (this.jXG != null) {
            this.jXG.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.jXH.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jXH != null) {
            boolean z5 = this.jXH.cHg() == null || this.jXH.cHg().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jXJ = false;
                z3 = true;
                z2 = false;
            }
            if (this.jXJ) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.jXH.cHh();
                } else {
                    this.jXH.cHi();
                }
            }
        }
    }
}
