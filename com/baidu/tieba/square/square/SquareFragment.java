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
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
/* loaded from: classes5.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> mContext;
    private View mRootView;
    private h jbY = null;
    private SquareModel jbZ = null;
    private boolean jca = false;
    private boolean jcb = false;
    private long eXw = -1;
    private final SquareModel.a jcc = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.jbY.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.jbY.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.jbY.c(SquareFragment.this.jbZ.coy());
                SquareFragment.this.jca = true;
                SquareFragment.this.jbY.hideNoDataView();
                SquareFragment.this.bhT();
            }
            if (SquareFragment.this.jcb) {
                SquareFragment.this.jcb = false;
                SquareFragment.this.qW(true);
                if (!SquareFragment.this.jca) {
                    SquareFragment.this.jbY.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.jbY.getRootView());
                }
            } else {
                if (SquareFragment.this.eXw > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eXw, SquareFragment.this.jbZ.bgp() - SquareFragment.this.eXw, SquareFragment.this.jbZ.bgn(), SquareFragment.this.jbZ.bgo(), currentTimeMillis - SquareFragment.this.jbZ.bgm());
                    SquareFragment.this.eXw = -1L;
                }
                if (!SquareFragment.this.jca) {
                    if (j.kc()) {
                        SquareFragment.this.jbY.oX(R.string.no_data_text);
                    } else {
                        SquareFragment.this.jbY.oX(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.kc()) {
                SquareFragment.this.jbY.coB();
                if (!SquareFragment.this.jca) {
                    SquareFragment.this.bhS();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.jbY.coC();
        }
    };
    private final NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                SquareFragment.this.qW(true);
            }
        }
    };
    private final View.OnKeyListener jcd = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c caJ = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            SquareFragment.this.qW(true);
        }
    };

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getPageContext();
        this.eXw = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qW(this.jcb);
    }

    private void initUI() {
        this.jbY = new h(this.mContext, getUniqueId(), this.mRootView, this.jcd);
        this.jbY.setListPullRefreshListener(this.caJ);
    }

    private void initData() {
        this.jbZ = new SquareModel(this.mContext);
        this.jbZ.a(this.jcc);
        this.jcb = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhS() {
        this.jbY.d(this.eHo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhT() {
        this.jbY.e(this.eHo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qW(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        atI();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jbY != null) {
            this.jbY.onChangeSkinType(i);
        }
    }

    private void atI() {
        this.jbZ.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qW(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jbZ != null) {
            boolean z5 = this.jbZ.coy() == null || this.jbZ.coy().isEmpty();
            boolean z6 = z;
            if (j.kc()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jcb = false;
                z3 = true;
                z2 = false;
            }
            if (this.jcb) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                atI();
                if (z4) {
                    this.jbZ.coz();
                } else {
                    this.jbZ.coA();
                }
            }
        }
    }
}
