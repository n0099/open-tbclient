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
/* loaded from: classes22.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> eGu;
    private View mRootView;
    private j mTv = null;
    private SquareModel mTw = null;
    private boolean mTx = false;
    private boolean mTy = false;
    private long ikF = -1;
    private final SquareModel.a mTz = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.mTv.F(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.mTv.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.mTv.c(SquareFragment.this.mTw.dIG());
                SquareFragment.this.mTx = true;
                SquareFragment.this.mTv.hideNoDataView();
                SquareFragment.this.cuh();
            }
            if (SquareFragment.this.mTy) {
                SquareFragment.this.mTy = false;
                SquareFragment.this.xq(true);
                if (!SquareFragment.this.mTx) {
                    SquareFragment.this.mTv.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.mTv.getRootView());
                }
            } else {
                if (SquareFragment.this.ikF > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.ikF, SquareFragment.this.mTw.crZ() - SquareFragment.this.ikF, SquareFragment.this.mTw.crX(), SquareFragment.this.mTw.crY(), currentTimeMillis - SquareFragment.this.mTw.crW());
                    SquareFragment.this.ikF = -1L;
                }
                if (!SquareFragment.this.mTx) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.mTv.Do(R.string.no_data_text);
                    } else {
                        SquareFragment.this.mTv.Do(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.mTv.dIJ();
                if (!SquareFragment.this.mTx) {
                    SquareFragment.this.cug();
                    return;
                }
                return;
            }
            SquareFragment.this.eGu.showToast(str);
            SquareFragment.this.mTv.dIK();
        }
    };
    private final NoNetworkView.a ghn = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xq(true);
            }
        }
    };
    private final View.OnKeyListener mTA = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c eUM = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.xq(true);
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
        this.eGu = getPageContext();
        this.ikF = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xq(this.mTy);
    }

    private void initUI() {
        this.mTv = new j(this.eGu, getUniqueId(), this.mRootView, this.mTA);
        this.mTv.setListPullRefreshListener(this.eUM);
    }

    private void initData() {
        this.mTw = new SquareModel(this.eGu);
        this.mTw.a(this.mTz);
        this.mTy = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cug() {
        this.mTv.c(this.ghn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuh() {
        this.mTv.d(this.ghn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xq(true);
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
        if (this.mTv != null) {
            this.mTv.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.mTw.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mTw != null) {
            boolean z5 = this.mTw.dIG() == null || this.mTw.dIG().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mTy = false;
                z3 = true;
                z2 = false;
            }
            if (this.mTy) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mTw.dIH();
                } else {
                    this.mTw.dII();
                }
            }
        }
    }
}
