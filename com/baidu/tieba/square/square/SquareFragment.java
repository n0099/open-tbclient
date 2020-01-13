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
/* loaded from: classes8.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> cRe;
    private View mRootView;
    private j kbj = null;
    private SquareModel kbk = null;
    private boolean kbl = false;
    private boolean kbm = false;
    private long fSK = -1;
    private final SquareModel.a kbn = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kbj.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kbj.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kbj.c(SquareFragment.this.kbk.cIk());
                SquareFragment.this.kbl = true;
                SquareFragment.this.kbj.hideNoDataView();
                SquareFragment.this.byR();
            }
            if (SquareFragment.this.kbm) {
                SquareFragment.this.kbm = false;
                SquareFragment.this.sC(true);
                if (!SquareFragment.this.kbl) {
                    SquareFragment.this.kbj.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kbj.getRootView());
                }
            } else {
                if (SquareFragment.this.fSK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fSK, SquareFragment.this.kbk.bxi() - SquareFragment.this.fSK, SquareFragment.this.kbk.bxg(), SquareFragment.this.kbk.bxh(), currentTimeMillis - SquareFragment.this.kbk.bxf());
                    SquareFragment.this.fSK = -1L;
                }
                if (!SquareFragment.this.kbl) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kbj.wi(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kbj.wi(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kbj.cIn();
                if (!SquareFragment.this.kbl) {
                    SquareFragment.this.byQ();
                    return;
                }
                return;
            }
            SquareFragment.this.cRe.showToast(str);
            SquareFragment.this.kbj.cIo();
        }
    };
    private final NoNetworkView.a fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.sC(true);
            }
        }
    };
    private final View.OnKeyListener kbo = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final g.c dcC = new g.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.sC(true);
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
        this.cRe = getPageContext();
        this.fSK = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        sC(this.kbm);
    }

    private void initUI() {
        this.kbj = new j(this.cRe, getUniqueId(), this.mRootView, this.kbo);
        this.kbj.setListPullRefreshListener(this.dcC);
    }

    private void initData() {
        this.kbk = new SquareModel(this.cRe);
        this.kbk.a(this.kbn);
        this.kbm = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byQ() {
        this.kbj.c(this.fWI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byR() {
        this.kbj.d(this.fWI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            sC(true);
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
        if (this.kbj != null) {
            this.kbj.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kbk.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kbk != null) {
            boolean z5 = this.kbk.cIk() == null || this.kbk.cIk().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kbm = false;
                z3 = true;
                z2 = false;
            }
            if (this.kbm) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kbk.cIl();
                } else {
                    this.kbk.cIm();
                }
            }
        }
    }
}
