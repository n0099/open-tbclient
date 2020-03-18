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
    private TbPageContext<?> cVv;
    private View mRootView;
    private j ked = null;
    private SquareModel kee = null;
    private boolean kef = false;
    private boolean keg = false;
    private long fWb = -1;
    private final SquareModel.a keh = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.ked.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.ked.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.ked.c(SquareFragment.this.kee.cKn());
                SquareFragment.this.kef = true;
                SquareFragment.this.ked.hideNoDataView();
                SquareFragment.this.bAC();
            }
            if (SquareFragment.this.keg) {
                SquareFragment.this.keg = false;
                SquareFragment.this.sM(true);
                if (!SquareFragment.this.kef) {
                    SquareFragment.this.ked.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.ked.getRootView());
                }
            } else {
                if (SquareFragment.this.fWb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fWb, SquareFragment.this.kee.byW() - SquareFragment.this.fWb, SquareFragment.this.kee.byU(), SquareFragment.this.kee.byV(), currentTimeMillis - SquareFragment.this.kee.byT());
                    SquareFragment.this.fWb = -1L;
                }
                if (!SquareFragment.this.kef) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.ked.ww(R.string.no_data_text);
                    } else {
                        SquareFragment.this.ked.ww(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.ked.cKq();
                if (!SquareFragment.this.kef) {
                    SquareFragment.this.bAB();
                    return;
                }
                return;
            }
            SquareFragment.this.cVv.showToast(str);
            SquareFragment.this.ked.cKr();
        }
    };
    private final NoNetworkView.a fZG = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.sM(true);
            }
        }
    };
    private final View.OnKeyListener kei = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dhi = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.sM(true);
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
        this.cVv = getPageContext();
        this.fWb = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        sM(this.keg);
    }

    private void initUI() {
        this.ked = new j(this.cVv, getUniqueId(), this.mRootView, this.kei);
        this.ked.setListPullRefreshListener(this.dhi);
    }

    private void initData() {
        this.kee = new SquareModel(this.cVv);
        this.kee.a(this.keh);
        this.keg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        this.ked.c(this.fZG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAC() {
        this.ked.d(this.fZG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sM(true);
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
        if (this.ked != null) {
            this.ked.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kee.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kee != null) {
            boolean z5 = this.kee.cKn() == null || this.kee.cKn().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.keg = false;
                z3 = true;
                z2 = false;
            }
            if (this.keg) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kee.cKo();
                } else {
                    this.kee.cKp();
                }
            }
        }
    }
}
