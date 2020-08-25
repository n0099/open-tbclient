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
    private TbPageContext<?> efn;
    private View mRootView;
    private j may = null;
    private SquareModel maz = null;
    private boolean maA = false;
    private boolean maB = false;
    private long hvn = -1;
    private final SquareModel.a maC = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.may.C(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.may.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.may.c(SquareFragment.this.maz.dvw());
                SquareFragment.this.maA = true;
                SquareFragment.this.may.hideNoDataView();
                SquareFragment.this.cik();
            }
            if (SquareFragment.this.maB) {
                SquareFragment.this.maB = false;
                SquareFragment.this.vU(true);
                if (!SquareFragment.this.maA) {
                    SquareFragment.this.may.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.may.getRootView());
                }
            } else {
                if (SquareFragment.this.hvn > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.hvn, SquareFragment.this.maz.cga() - SquareFragment.this.hvn, SquareFragment.this.maz.cfY(), SquareFragment.this.maz.cfZ(), currentTimeMillis - SquareFragment.this.maz.cfX());
                    SquareFragment.this.hvn = -1L;
                }
                if (!SquareFragment.this.maA) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.may.Bd(R.string.no_data_text);
                    } else {
                        SquareFragment.this.may.Bd(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.may.dvz();
                if (!SquareFragment.this.maA) {
                    SquareFragment.this.cij();
                    return;
                }
                return;
            }
            SquareFragment.this.efn.showToast(str);
            SquareFragment.this.may.dvA();
        }
    };
    private final NoNetworkView.a fCp = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.vU(true);
            }
        }
    };
    private final View.OnKeyListener maD = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c esW = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.vU(true);
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
        this.efn = getPageContext();
        this.hvn = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        vU(this.maB);
    }

    private void initUI() {
        this.may = new j(this.efn, getUniqueId(), this.mRootView, this.maD);
        this.may.setListPullRefreshListener(this.esW);
    }

    private void initData() {
        this.maz = new SquareModel(this.efn);
        this.maz.a(this.maC);
        this.maB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cij() {
        this.may.c(this.fCp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cik() {
        this.may.d(this.fCp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            vU(true);
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
        if (this.may != null) {
            this.may.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.maz.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.maz != null) {
            boolean z5 = this.maz.dvw() == null || this.maz.dvw().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.maB = false;
                z3 = true;
                z2 = false;
            }
            if (this.maB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.maz.dvx();
                } else {
                    this.maz.dvy();
                }
            }
        }
    }
}
