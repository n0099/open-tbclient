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
    private TbPageContext<?> duK;
    private View mRootView;
    private j kOb = null;
    private SquareModel kOc = null;
    private boolean kOd = false;
    private boolean kOe = false;
    private long gBb = -1;
    private final SquareModel.a kOf = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kOb.z(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kOb.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kOb.c(SquareFragment.this.kOc.cVh());
                SquareFragment.this.kOd = true;
                SquareFragment.this.kOb.hideNoDataView();
                SquareFragment.this.bLb();
            }
            if (SquareFragment.this.kOe) {
                SquareFragment.this.kOe = false;
                SquareFragment.this.tO(true);
                if (!SquareFragment.this.kOd) {
                    SquareFragment.this.kOb.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kOb.getRootView());
                }
            } else {
                if (SquareFragment.this.gBb > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.gBb, SquareFragment.this.kOc.bIX() - SquareFragment.this.gBb, SquareFragment.this.kOc.bIV(), SquareFragment.this.kOc.bIW(), currentTimeMillis - SquareFragment.this.kOc.bIU());
                    SquareFragment.this.gBb = -1L;
                }
                if (!SquareFragment.this.kOd) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kOb.wU(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kOb.wU(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kOb.cVk();
                if (!SquareFragment.this.kOd) {
                    SquareFragment.this.bLa();
                    return;
                }
                return;
            }
            SquareFragment.this.duK.showToast(str);
            SquareFragment.this.kOb.cVl();
        }
    };
    private final NoNetworkView.a gGr = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.tO(true);
            }
        }
    };
    private final View.OnKeyListener kOg = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dHh = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.duK = getPageContext();
        this.gBb = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        tO(this.kOe);
    }

    private void initUI() {
        this.kOb = new j(this.duK, getUniqueId(), this.mRootView, this.kOg);
        this.kOb.setListPullRefreshListener(this.dHh);
    }

    private void initData() {
        this.kOc = new SquareModel(this.duK);
        this.kOc.a(this.kOf);
        this.kOe = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLa() {
        this.kOb.c(this.gGr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLb() {
        this.kOb.d(this.gGr);
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
        if (this.kOb != null) {
            this.kOb.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kOc.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kOc != null) {
            boolean z5 = this.kOc.cVh() == null || this.kOc.cVh().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kOe = false;
                z3 = true;
                z2 = false;
            }
            if (this.kOe) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kOc.cVi();
                } else {
                    this.kOc.cVj();
                }
            }
        }
    }
}
