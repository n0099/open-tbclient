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
    private h iUy = null;
    private SquareModel iUz = null;
    private boolean iUA = false;
    private boolean iUB = false;
    private long eSl = -1;
    private final SquareModel.a iUC = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.iUy.x(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.iUy.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.iUy.c(SquareFragment.this.iUz.cll());
                SquareFragment.this.iUA = true;
                SquareFragment.this.iUy.hideNoDataView();
                SquareFragment.this.bfG();
            }
            if (SquareFragment.this.iUB) {
                SquareFragment.this.iUB = false;
                SquareFragment.this.qF(true);
                if (!SquareFragment.this.iUA) {
                    SquareFragment.this.iUy.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.iUy.getRootView());
                }
            } else {
                if (SquareFragment.this.eSl > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eSl, SquareFragment.this.iUz.beg() - SquareFragment.this.eSl, SquareFragment.this.iUz.bee(), SquareFragment.this.iUz.bef(), currentTimeMillis - SquareFragment.this.iUz.bed());
                    SquareFragment.this.eSl = -1L;
                }
                if (!SquareFragment.this.iUA) {
                    if (j.jS()) {
                        SquareFragment.this.iUy.oH(R.string.no_data_text);
                    } else {
                        SquareFragment.this.iUy.oH(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.jS()) {
                SquareFragment.this.iUy.clo();
                if (!SquareFragment.this.iUA) {
                    SquareFragment.this.bfF();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.iUy.clp();
        }
    };
    private final NoNetworkView.a eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                SquareFragment.this.qF(true);
            }
        }
    };
    private final View.OnKeyListener iUD = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c bZA = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            SquareFragment.this.qF(true);
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
        this.eSl = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qF(this.iUB);
    }

    private void initUI() {
        this.iUy = new h(this.mContext, getUniqueId(), this.mRootView, this.iUD);
        this.iUy.setListPullRefreshListener(this.bZA);
    }

    private void initData() {
        this.iUz = new SquareModel(this.mContext);
        this.iUz.a(this.iUC);
        this.iUB = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfF() {
        this.iUy.d(this.eCk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        this.iUy.e(this.eCk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qF(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        asz();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iUy != null) {
            this.iUy.onChangeSkinType(i);
        }
    }

    private void asz() {
        this.iUz.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.iUz != null) {
            boolean z5 = this.iUz.cll() == null || this.iUz.cll().isEmpty();
            boolean z6 = z;
            if (j.jS()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.iUB = false;
                z3 = true;
                z2 = false;
            }
            if (this.iUB) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                asz();
                if (z4) {
                    this.iUz.clm();
                } else {
                    this.iUz.cln();
                }
            }
        }
    }
}
