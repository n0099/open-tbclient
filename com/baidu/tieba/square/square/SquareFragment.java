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
/* loaded from: classes23.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> eIc;
    private View mRootView;
    private j mSy = null;
    private SquareModel mSz = null;
    private boolean mSA = false;
    private boolean mSB = false;
    private long ijR = -1;
    private final SquareModel.a mSD = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.mSy.E(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.mSy.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.mSy.c(SquareFragment.this.mSz.dIP());
                SquareFragment.this.mSA = true;
                SquareFragment.this.mSy.hideNoDataView();
                SquareFragment.this.cuE();
            }
            if (SquareFragment.this.mSB) {
                SquareFragment.this.mSB = false;
                SquareFragment.this.xm(true);
                if (!SquareFragment.this.mSA) {
                    SquareFragment.this.mSy.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.mSy.getRootView());
                }
            } else {
                if (SquareFragment.this.ijR > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.ijR, SquareFragment.this.mSz.csw() - SquareFragment.this.ijR, SquareFragment.this.mSz.csu(), SquareFragment.this.mSz.csv(), currentTimeMillis - SquareFragment.this.mSz.cst());
                    SquareFragment.this.ijR = -1L;
                }
                if (!SquareFragment.this.mSA) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.mSy.CQ(R.string.no_data_text);
                    } else {
                        SquareFragment.this.mSy.CQ(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.mSy.dIS();
                if (!SquareFragment.this.mSA) {
                    SquareFragment.this.cuD();
                    return;
                }
                return;
            }
            SquareFragment.this.eIc.showToast(str);
            SquareFragment.this.mSy.dIT();
        }
    };
    private final NoNetworkView.a ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xm(true);
            }
        }
    };
    private final View.OnKeyListener mSE = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c eVA = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.xm(true);
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
        this.eIc = getPageContext();
        this.ijR = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xm(this.mSB);
    }

    private void initUI() {
        this.mSy = new j(this.eIc, getUniqueId(), this.mRootView, this.mSE);
        this.mSy.setListPullRefreshListener(this.eVA);
    }

    private void initData() {
        this.mSz = new SquareModel(this.eIc);
        this.mSz.a(this.mSD);
        this.mSB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuD() {
        this.mSy.c(this.ghG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuE() {
        this.mSy.d(this.ghG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xm(true);
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
        if (this.mSy != null) {
            this.mSy.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.mSz.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mSz != null) {
            boolean z5 = this.mSz.dIP() == null || this.mSz.dIP().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mSB = false;
                z3 = true;
                z2 = false;
            }
            if (this.mSB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mSz.dIQ();
                } else {
                    this.mSz.dIR();
                }
            }
        }
    }
}
