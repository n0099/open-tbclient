package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes5.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> mContext;
    private View mRootView;
    private h iBK = null;
    private SquareModel iBL = null;
    private boolean iBM = false;
    private boolean iBN = false;
    private long eCx = -1;
    private final SquareModel.a iBO = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.iBK.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.iBK.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.iBK.c(SquareFragment.this.iBL.cdh());
                SquareFragment.this.iBM = true;
                SquareFragment.this.iBK.hideNoDataView();
                SquareFragment.this.aYm();
            }
            if (SquareFragment.this.iBN) {
                SquareFragment.this.iBN = false;
                SquareFragment.this.pQ(true);
                if (!SquareFragment.this.iBM) {
                    SquareFragment.this.iBK.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.iBK.getRootView());
                }
            } else {
                if (SquareFragment.this.eCx > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eCx, SquareFragment.this.iBL.aWS() - SquareFragment.this.eCx, SquareFragment.this.iBL.aWQ(), SquareFragment.this.iBL.aWR(), currentTimeMillis - SquareFragment.this.iBL.aWP());
                    SquareFragment.this.eCx = -1L;
                }
                if (!SquareFragment.this.iBM) {
                    if (j.kY()) {
                        SquareFragment.this.iBK.nQ(d.j.no_data_text);
                    } else {
                        SquareFragment.this.iBK.nQ(d.j.game_index_no_network_text);
                    }
                }
            }
            if (!j.kY()) {
                SquareFragment.this.iBK.cdk();
                if (!SquareFragment.this.iBM) {
                    SquareFragment.this.aYl();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.iBK.cdl();
        }
    };
    private final NoNetworkView.a emz = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                SquareFragment.this.pQ(true);
            }
        }
    };
    private final View.OnKeyListener iBP = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c bRJ = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            SquareFragment.this.pQ(true);
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.h.square_fragment_view, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getPageContext();
        this.eCx = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        pQ(this.iBN);
    }

    private void initUI() {
        this.iBK = new h(this.mContext, getUniqueId(), this.mRootView, this.iBP);
        this.iBK.setListPullRefreshListener(this.bRJ);
    }

    private void initData() {
        this.iBL = new SquareModel(this.mContext);
        this.iBL.a(this.iBO);
        this.iBN = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYl() {
        this.iBK.d(this.emz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYm() {
        this.iBK.e(this.emz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            pQ(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        anw();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iBK != null) {
            this.iBK.onChangeSkinType(i);
        }
    }

    private void anw() {
        this.iBL.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iBL != null) {
            boolean z5 = this.iBL.cdh() == null || this.iBL.cdh().isEmpty();
            boolean z6 = z;
            if (j.kY()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iBN = false;
                z3 = true;
                z2 = false;
            }
            if (this.iBN) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                anw();
                if (z4) {
                    this.iBL.cdi();
                } else {
                    this.iBL.cdj();
                }
            }
        }
    }
}
