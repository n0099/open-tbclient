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
    private j lgs = null;
    private SquareModel lgt = null;
    private boolean lgu = false;
    private boolean lgv = false;
    private long gPK = -1;
    private final SquareModel.a lgw = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.lgs.z(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.lgs.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.lgs.c(SquareFragment.this.lgt.dcl());
                SquareFragment.this.lgu = true;
                SquareFragment.this.lgs.hideNoDataView();
                SquareFragment.this.bRw();
            }
            if (SquareFragment.this.lgv) {
                SquareFragment.this.lgv = false;
                SquareFragment.this.um(true);
                if (!SquareFragment.this.lgu) {
                    SquareFragment.this.lgs.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.lgs.getRootView());
                }
            } else {
                if (SquareFragment.this.gPK > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.gPK, SquareFragment.this.lgt.bPq() - SquareFragment.this.gPK, SquareFragment.this.lgt.bPo(), SquareFragment.this.lgt.bPp(), currentTimeMillis - SquareFragment.this.lgt.bPn());
                    SquareFragment.this.gPK = -1L;
                }
                if (!SquareFragment.this.lgu) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.lgs.xA(R.string.no_data_text);
                    } else {
                        SquareFragment.this.lgs.xA(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.lgs.dco();
                if (!SquareFragment.this.lgu) {
                    SquareFragment.this.bRv();
                    return;
                }
                return;
            }
            SquareFragment.this.dIF.showToast(str);
            SquareFragment.this.lgs.dcp();
        }
    };
    private final NoNetworkView.a faq = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.um(true);
            }
        }
    };
    private final View.OnKeyListener lgx = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
        this.gPK = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        um(this.lgv);
    }

    private void initUI() {
        this.lgs = new j(this.dIF, getUniqueId(), this.mRootView, this.lgx);
        this.lgs.setListPullRefreshListener(this.dVt);
    }

    private void initData() {
        this.lgt = new SquareModel(this.dIF);
        this.lgt.a(this.lgw);
        this.lgv = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRv() {
        this.lgs.c(this.faq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRw() {
        this.lgs.d(this.faq);
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
        if (this.lgs != null) {
            this.lgs.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.lgt.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.lgt != null) {
            boolean z5 = this.lgt.dcl() == null || this.lgt.dcl().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.lgv = false;
                z3 = true;
                z2 = false;
            }
            if (this.lgv) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.lgt.dcm();
                } else {
                    this.lgt.dcn();
                }
            }
        }
    }
}
