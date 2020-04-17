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
    private TbPageContext<?> duG;
    private View mRootView;
    private j kNX = null;
    private SquareModel kNY = null;
    private boolean kNZ = false;
    private boolean kOa = false;
    private long gAV = -1;
    private final SquareModel.a kOb = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kNX.z(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kNX.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kNX.c(SquareFragment.this.kNY.cVj());
                SquareFragment.this.kNZ = true;
                SquareFragment.this.kNX.hideNoDataView();
                SquareFragment.this.bLc();
            }
            if (SquareFragment.this.kOa) {
                SquareFragment.this.kOa = false;
                SquareFragment.this.tO(true);
                if (!SquareFragment.this.kNZ) {
                    SquareFragment.this.kNX.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kNX.getRootView());
                }
            } else {
                if (SquareFragment.this.gAV > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.gAV, SquareFragment.this.kNY.bIY() - SquareFragment.this.gAV, SquareFragment.this.kNY.bIW(), SquareFragment.this.kNY.bIX(), currentTimeMillis - SquareFragment.this.kNY.bIV());
                    SquareFragment.this.gAV = -1L;
                }
                if (!SquareFragment.this.kNZ) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kNX.wU(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kNX.wU(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kNX.cVm();
                if (!SquareFragment.this.kNZ) {
                    SquareFragment.this.bLb();
                    return;
                }
                return;
            }
            SquareFragment.this.duG.showToast(str);
            SquareFragment.this.kNX.cVn();
        }
    };
    private final NoNetworkView.a gGl = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.tO(true);
            }
        }
    };
    private final View.OnKeyListener kOc = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dHd = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.tO(true);
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
        this.duG = getPageContext();
        this.gAV = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        tO(this.kOa);
    }

    private void initUI() {
        this.kNX = new j(this.duG, getUniqueId(), this.mRootView, this.kOc);
        this.kNX.setListPullRefreshListener(this.dHd);
    }

    private void initData() {
        this.kNY = new SquareModel(this.duG);
        this.kNY.a(this.kOb);
        this.kOa = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLb() {
        this.kNX.c(this.gGl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLc() {
        this.kNX.d(this.gGl);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            tO(true);
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
        if (this.kNX != null) {
            this.kNX.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kNY.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kNY != null) {
            boolean z5 = this.kNY.cVj() == null || this.kNY.cVj().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kOa = false;
                z3 = true;
                z2 = false;
            }
            if (this.kOa) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kNY.cVk();
                } else {
                    this.kNY.cVl();
                }
            }
        }
    }
}
