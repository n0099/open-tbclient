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
    private TbPageContext<?> dIF;
    private View mRootView;
    private j lhB = null;
    private SquareModel lhC = null;
    private boolean lhD = false;
    private boolean lhE = false;
    private long gPV = -1;
    private final SquareModel.a lhF = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.lhB.z(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.lhB.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.lhB.c(SquareFragment.this.lhC.dcA());
                SquareFragment.this.lhD = true;
                SquareFragment.this.lhB.hideNoDataView();
                SquareFragment.this.bRy();
            }
            if (SquareFragment.this.lhE) {
                SquareFragment.this.lhE = false;
                SquareFragment.this.um(true);
                if (!SquareFragment.this.lhD) {
                    SquareFragment.this.lhB.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.lhB.getRootView());
                }
            } else {
                if (SquareFragment.this.gPV > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.gPV, SquareFragment.this.lhC.bPs() - SquareFragment.this.gPV, SquareFragment.this.lhC.bPq(), SquareFragment.this.lhC.bPr(), currentTimeMillis - SquareFragment.this.lhC.bPp());
                    SquareFragment.this.gPV = -1L;
                }
                if (!SquareFragment.this.lhD) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.lhB.xC(R.string.no_data_text);
                    } else {
                        SquareFragment.this.lhB.xC(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.lhB.dcD();
                if (!SquareFragment.this.lhD) {
                    SquareFragment.this.bRx();
                    return;
                }
                return;
            }
            SquareFragment.this.dIF.showToast(str);
            SquareFragment.this.lhB.dcE();
        }
    };
    private final NoNetworkView.a faB = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.um(true);
            }
        }
    };
    private final View.OnKeyListener lhG = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c dVt = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.um(true);
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
        this.dIF = getPageContext();
        this.gPV = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        um(this.lhE);
    }

    private void initUI() {
        this.lhB = new j(this.dIF, getUniqueId(), this.mRootView, this.lhG);
        this.lhB.setListPullRefreshListener(this.dVt);
    }

    private void initData() {
        this.lhC = new SquareModel(this.dIF);
        this.lhC.a(this.lhF);
        this.lhE = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        this.lhB.c(this.faB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        this.lhB.d(this.faB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            um(true);
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
        if (this.lhB != null) {
            this.lhB.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.lhC.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lhC != null) {
            boolean z5 = this.lhC.dcA() == null || this.lhC.dcA().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lhE = false;
                z3 = true;
                z2 = false;
            }
            if (this.lhE) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lhC.dcB();
                } else {
                    this.lhC.dcC();
                }
            }
        }
    }
}
