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
    private TbPageContext<?> ehG;
    private View mRootView;
    private j mko = null;
    private SquareModel mkp = null;
    private boolean mkq = false;
    private boolean mkr = false;
    private long hCy = -1;
    private final SquareModel.a mks = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.mko.C(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.mko.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.mko.c(SquareFragment.this.mkp.dzu());
                SquareFragment.this.mkq = true;
                SquareFragment.this.mko.hideNoDataView();
                SquareFragment.this.cly();
            }
            if (SquareFragment.this.mkr) {
                SquareFragment.this.mkr = false;
                SquareFragment.this.wf(true);
                if (!SquareFragment.this.mkq) {
                    SquareFragment.this.mko.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.mko.getRootView());
                }
            } else {
                if (SquareFragment.this.hCy > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.hCy, SquareFragment.this.mkp.cjs() - SquareFragment.this.hCy, SquareFragment.this.mkp.cjq(), SquareFragment.this.mkp.cjr(), currentTimeMillis - SquareFragment.this.mkp.cjp());
                    SquareFragment.this.hCy = -1L;
                }
                if (!SquareFragment.this.mkq) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.mko.BE(R.string.no_data_text);
                    } else {
                        SquareFragment.this.mko.BE(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.mko.dzx();
                if (!SquareFragment.this.mkq) {
                    SquareFragment.this.clx();
                    return;
                }
                return;
            }
            SquareFragment.this.ehG.showToast(str);
            SquareFragment.this.mko.dzy();
        }
    };
    private final NoNetworkView.a fFF = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.wf(true);
            }
        }
    };
    private final View.OnKeyListener mkt = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c evf = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.wf(true);
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
        this.ehG = getPageContext();
        this.hCy = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        wf(this.mkr);
    }

    private void initUI() {
        this.mko = new j(this.ehG, getUniqueId(), this.mRootView, this.mkt);
        this.mko.setListPullRefreshListener(this.evf);
    }

    private void initData() {
        this.mkp = new SquareModel(this.ehG);
        this.mkp.a(this.mks);
        this.mkr = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        this.mko.c(this.fFF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cly() {
        this.mko.d(this.fFF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            wf(true);
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
        if (this.mko != null) {
            this.mko.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.mkp.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mkp != null) {
            boolean z5 = this.mkp.dzu() == null || this.mkp.dzu().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.mkr = false;
                z3 = true;
                z2 = false;
            }
            if (this.mkr) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.mkp.dzv();
                } else {
                    this.mkp.dzw();
                }
            }
        }
    }
}
