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
    private h iBZ = null;
    private SquareModel iCa = null;
    private boolean iCb = false;
    private boolean iCc = false;
    private long eCL = -1;
    private final SquareModel.a iCd = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.iBZ.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.iBZ.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.iBZ.c(SquareFragment.this.iCa.cdl());
                SquareFragment.this.iCb = true;
                SquareFragment.this.iBZ.hideNoDataView();
                SquareFragment.this.aYp();
            }
            if (SquareFragment.this.iCc) {
                SquareFragment.this.iCc = false;
                SquareFragment.this.pQ(true);
                if (!SquareFragment.this.iCb) {
                    SquareFragment.this.iBZ.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.iBZ.getRootView());
                }
            } else {
                if (SquareFragment.this.eCL > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eCL, SquareFragment.this.iCa.aWU() - SquareFragment.this.eCL, SquareFragment.this.iCa.aWS(), SquareFragment.this.iCa.aWT(), currentTimeMillis - SquareFragment.this.iCa.aWR());
                    SquareFragment.this.eCL = -1L;
                }
                if (!SquareFragment.this.iCb) {
                    if (j.kY()) {
                        SquareFragment.this.iBZ.nS(d.j.no_data_text);
                    } else {
                        SquareFragment.this.iBZ.nS(d.j.game_index_no_network_text);
                    }
                }
            }
            if (!j.kY()) {
                SquareFragment.this.iBZ.cdo();
                if (!SquareFragment.this.iCb) {
                    SquareFragment.this.aYo();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.iBZ.cdp();
        }
    };
    private final NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                SquareFragment.this.pQ(true);
            }
        }
    };
    private final View.OnKeyListener iCe = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c bRG = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.eCL = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        pQ(this.iCc);
    }

    private void initUI() {
        this.iBZ = new h(this.mContext, getUniqueId(), this.mRootView, this.iCe);
        this.iBZ.setListPullRefreshListener(this.bRG);
    }

    private void initData() {
        this.iCa = new SquareModel(this.mContext);
        this.iCa.a(this.iCd);
        this.iCc = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYo() {
        this.iBZ.d(this.emM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYp() {
        this.iBZ.e(this.emM);
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
        anz();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iBZ != null) {
            this.iBZ.onChangeSkinType(i);
        }
    }

    private void anz() {
        this.iCa.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pQ(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iCa != null) {
            boolean z5 = this.iCa.cdl() == null || this.iCa.cdl().isEmpty();
            boolean z6 = z;
            if (j.kY()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iCc = false;
                z3 = true;
                z2 = false;
            }
            if (this.iCc) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                anz();
                if (z4) {
                    this.iCa.cdm();
                } else {
                    this.iCa.cdn();
                }
            }
        }
    }
}
