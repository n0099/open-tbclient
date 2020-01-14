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
    private j kbo = null;
    private SquareModel kbp = null;
    private boolean kbq = false;
    private boolean kbr = false;
    private long fSK = -1;
    private final SquareModel.a kbs = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.kbo.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.kbo.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.kbo.c(SquareFragment.this.kbp.cIm());
                SquareFragment.this.kbq = true;
                SquareFragment.this.kbo.hideNoDataView();
                SquareFragment.this.byR();
            }
            if (SquareFragment.this.kbr) {
                SquareFragment.this.kbr = false;
                SquareFragment.this.sC(true);
                if (!SquareFragment.this.kbq) {
                    SquareFragment.this.kbo.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.kbo.getRootView());
                }
            } else {
                if (SquareFragment.this.fSK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fSK, SquareFragment.this.kbp.bxi() - SquareFragment.this.fSK, SquareFragment.this.kbp.bxg(), SquareFragment.this.kbp.bxh(), currentTimeMillis - SquareFragment.this.kbp.bxf());
                    SquareFragment.this.fSK = -1L;
                }
                if (!SquareFragment.this.kbq) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.kbo.wi(R.string.no_data_text);
                    } else {
                        SquareFragment.this.kbo.wi(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.kbo.cIp();
                if (!SquareFragment.this.kbq) {
                    SquareFragment.this.byQ();
                    return;
                }
                return;
            }
            SquareFragment.this.cRe.showToast(str);
            SquareFragment.this.kbo.cIq();
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
    private final View.OnKeyListener kbt = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
        sC(this.kbr);
    }

    private void initUI() {
        this.kbo = new j(this.cRe, getUniqueId(), this.mRootView, this.kbt);
        this.kbo.setListPullRefreshListener(this.dcC);
    }

    private void initData() {
        this.kbp = new SquareModel(this.cRe);
        this.kbp.a(this.kbs);
        this.kbr = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byQ() {
        this.kbo.c(this.fWI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byR() {
        this.kbo.d(this.fWI);
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
        if (this.kbo != null) {
            this.kbo.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.kbp.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.kbp != null) {
            boolean z5 = this.kbp.cIm() == null || this.kbp.cIm().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.kbr = false;
                z3 = true;
                z2 = false;
            }
            if (this.kbr) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.kbp.cIn();
                } else {
                    this.kbp.cIo();
                }
            }
        }
    }
}
