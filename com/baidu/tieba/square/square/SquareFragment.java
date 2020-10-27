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
    private TbPageContext<?> eCn;
    private View mRootView;
    private j mMz = null;
    private SquareModel mMA = null;
    private boolean mMB = false;
    private boolean mMC = false;
    private long idU = -1;
    private final SquareModel.a mMD = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.mMz.E(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.mMz.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.mMz.c(SquareFragment.this.mMA.dGn());
                SquareFragment.this.mMB = true;
                SquareFragment.this.mMz.hideNoDataView();
                SquareFragment.this.csd();
            }
            if (SquareFragment.this.mMC) {
                SquareFragment.this.mMC = false;
                SquareFragment.this.xd(true);
                if (!SquareFragment.this.mMB) {
                    SquareFragment.this.mMz.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.mMz.getRootView());
                }
            } else {
                if (SquareFragment.this.idU > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.idU, SquareFragment.this.mMA.cpV() - SquareFragment.this.idU, SquareFragment.this.mMA.cpT(), SquareFragment.this.mMA.cpU(), currentTimeMillis - SquareFragment.this.mMA.cpS());
                    SquareFragment.this.idU = -1L;
                }
                if (!SquareFragment.this.mMB) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.mMz.CD(R.string.no_data_text);
                    } else {
                        SquareFragment.this.mMz.CD(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.mMz.dGq();
                if (!SquareFragment.this.mMB) {
                    SquareFragment.this.csc();
                    return;
                }
                return;
            }
            SquareFragment.this.eCn.showToast(str);
            SquareFragment.this.mMz.dGr();
        }
    };
    private final NoNetworkView.a gbR = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xd(true);
            }
        }
    };
    private final View.OnKeyListener mME = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c ePL = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.xd(true);
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
        this.eCn = getPageContext();
        this.idU = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xd(this.mMC);
    }

    private void initUI() {
        this.mMz = new j(this.eCn, getUniqueId(), this.mRootView, this.mME);
        this.mMz.setListPullRefreshListener(this.ePL);
    }

    private void initData() {
        this.mMA = new SquareModel(this.eCn);
        this.mMA.a(this.mMD);
        this.mMC = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csc() {
        this.mMz.c(this.gbR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csd() {
        this.mMz.d(this.gbR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xd(true);
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
        if (this.mMz != null) {
            this.mMz.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.mMA.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mMA != null) {
            boolean z5 = this.mMA.dGn() == null || this.mMA.dGn().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mMC = false;
                z3 = true;
                z2 = false;
            }
            if (this.mMC) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mMA.dGo();
                } else {
                    this.mMA.dGp();
                }
            }
        }
    }
}
