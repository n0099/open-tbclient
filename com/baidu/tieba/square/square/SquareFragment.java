package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private TbPageContext<?> cfl;
    private View mRootView;
    private h jek = null;
    private SquareModel jel = null;
    private boolean jem = false;
    private boolean jen = false;
    private long fbN = -1;
    private final SquareModel.a jeo = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.jek.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.jek.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.jek.c(SquareFragment.this.jel.cnc());
                SquareFragment.this.jem = true;
                SquareFragment.this.jek.hideNoDataView();
                SquareFragment.this.bgw();
            }
            if (SquareFragment.this.jen) {
                SquareFragment.this.jen = false;
                SquareFragment.this.qI(true);
                if (!SquareFragment.this.jem) {
                    SquareFragment.this.jek.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.jek.getRootView());
                }
            } else {
                if (SquareFragment.this.fbN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.fbN, SquareFragment.this.jel.beO() - SquareFragment.this.fbN, SquareFragment.this.jel.beM(), SquareFragment.this.jel.beN(), currentTimeMillis - SquareFragment.this.jel.beL());
                    SquareFragment.this.fbN = -1L;
                }
                if (!SquareFragment.this.jem) {
                    if (j.isNetWorkAvailable()) {
                        SquareFragment.this.jek.uc(R.string.no_data_text);
                    } else {
                        SquareFragment.this.jek.uc(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.isNetWorkAvailable()) {
                SquareFragment.this.jek.cnf();
                if (!SquareFragment.this.jem) {
                    SquareFragment.this.bgv();
                    return;
                }
                return;
            }
            SquareFragment.this.cfl.showToast(str);
            SquareFragment.this.jek.cng();
        }
    };
    private final NoNetworkView.a eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.qI(true);
            }
        }
    };
    private final View.OnKeyListener jep = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c cpS = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.qI(true);
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
        this.cfl = getPageContext();
        this.fbN = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qI(this.jen);
    }

    private void initUI() {
        this.jek = new h(this.cfl, getUniqueId(), this.mRootView, this.jep);
        this.jek.setListPullRefreshListener(this.cpS);
    }

    private void initData() {
        this.jel = new SquareModel(this.cfl);
        this.jel.a(this.jeo);
        this.jen = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgv() {
        this.jek.d(this.eRC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgw() {
        this.jek.e(this.eRC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qI(true);
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
        if (this.jek != null) {
            this.jek.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.jel.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jel != null) {
            boolean z5 = this.jel.cnc() == null || this.jel.cnc().isEmpty();
            boolean z6 = z;
            if (j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jen = false;
                z3 = true;
                z2 = false;
            }
            if (this.jen) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.jel.cnd();
                } else {
                    this.jel.cne();
                }
            }
        }
    }
}
