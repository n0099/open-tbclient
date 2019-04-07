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
    private h iBJ = null;
    private SquareModel iBK = null;
    private boolean iBL = false;
    private boolean iBM = false;
    private long eCw = -1;
    private final SquareModel.a iBN = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.iBJ.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.iBJ.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.iBJ.c(SquareFragment.this.iBK.cdh());
                SquareFragment.this.iBL = true;
                SquareFragment.this.iBJ.hideNoDataView();
                SquareFragment.this.aYm();
            }
            if (SquareFragment.this.iBM) {
                SquareFragment.this.iBM = false;
                SquareFragment.this.pQ(true);
                if (!SquareFragment.this.iBL) {
                    SquareFragment.this.iBJ.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.iBJ.getRootView());
                }
            } else {
                if (SquareFragment.this.eCw > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eCw, SquareFragment.this.iBK.aWS() - SquareFragment.this.eCw, SquareFragment.this.iBK.aWQ(), SquareFragment.this.iBK.aWR(), currentTimeMillis - SquareFragment.this.iBK.aWP());
                    SquareFragment.this.eCw = -1L;
                }
                if (!SquareFragment.this.iBL) {
                    if (j.kY()) {
                        SquareFragment.this.iBJ.nQ(d.j.no_data_text);
                    } else {
                        SquareFragment.this.iBJ.nQ(d.j.game_index_no_network_text);
                    }
                }
            }
            if (!j.kY()) {
                SquareFragment.this.iBJ.cdk();
                if (!SquareFragment.this.iBL) {
                    SquareFragment.this.aYl();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.iBJ.cdl();
        }
    };
    private final NoNetworkView.a emy = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                SquareFragment.this.pQ(true);
            }
        }
    };
    private final View.OnKeyListener iBO = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c bRI = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.eCw = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        pQ(this.iBM);
    }

    private void initUI() {
        this.iBJ = new h(this.mContext, getUniqueId(), this.mRootView, this.iBO);
        this.iBJ.setListPullRefreshListener(this.bRI);
    }

    private void initData() {
        this.iBK = new SquareModel(this.mContext);
        this.iBK.a(this.iBN);
        this.iBM = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYl() {
        this.iBJ.d(this.emy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYm() {
        this.iBJ.e(this.emy);
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
        if (this.iBJ != null) {
            this.iBJ.onChangeSkinType(i);
        }
    }

    private void anw() {
        this.iBK.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iBK != null) {
            boolean z5 = this.iBK.cdh() == null || this.iBK.cdh().isEmpty();
            boolean z6 = z;
            if (j.kY()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iBM = false;
                z3 = true;
                z2 = false;
            }
            if (this.iBM) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                anw();
                if (z4) {
                    this.iBK.cdi();
                } else {
                    this.iBK.cdj();
                }
            }
        }
    }
}
