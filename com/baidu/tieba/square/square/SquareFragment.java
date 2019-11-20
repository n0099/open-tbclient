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
    private TbPageContext<?> ceu;
    private View mRootView;
    private h jdt = null;
    private SquareModel jdu = null;
    private boolean jdv = false;
    private boolean jdw = false;
    private long faW = -1;
    private final SquareModel.a jdx = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.jdt.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.jdt.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.jdt.c(SquareFragment.this.jdu.cna());
                SquareFragment.this.jdv = true;
                SquareFragment.this.jdt.hideNoDataView();
                SquareFragment.this.bgu();
            }
            if (SquareFragment.this.jdw) {
                SquareFragment.this.jdw = false;
                SquareFragment.this.qI(true);
                if (!SquareFragment.this.jdv) {
                    SquareFragment.this.jdt.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.jdt.getRootView());
                }
            } else {
                if (SquareFragment.this.faW > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.faW, SquareFragment.this.jdu.beM() - SquareFragment.this.faW, SquareFragment.this.jdu.beK(), SquareFragment.this.jdu.beL(), currentTimeMillis - SquareFragment.this.jdu.beJ());
                    SquareFragment.this.faW = -1L;
                }
                if (!SquareFragment.this.jdv) {
                    if (j.isNetWorkAvailable()) {
                        SquareFragment.this.jdt.ub(R.string.no_data_text);
                    } else {
                        SquareFragment.this.jdt.ub(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.isNetWorkAvailable()) {
                SquareFragment.this.jdt.cnd();
                if (!SquareFragment.this.jdv) {
                    SquareFragment.this.bgt();
                    return;
                }
                return;
            }
            SquareFragment.this.ceu.showToast(str);
            SquareFragment.this.jdt.cne();
        }
    };
    private final NoNetworkView.a eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.qI(true);
            }
        }
    };
    private final View.OnKeyListener jdy = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c cpa = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.ceu = getPageContext();
        this.faW = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qI(this.jdw);
    }

    private void initUI() {
        this.jdt = new h(this.ceu, getUniqueId(), this.mRootView, this.jdy);
        this.jdt.setListPullRefreshListener(this.cpa);
    }

    private void initData() {
        this.jdu = new SquareModel(this.ceu);
        this.jdu.a(this.jdx);
        this.jdw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgt() {
        this.jdt.d(this.eQL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgu() {
        this.jdt.e(this.eQL);
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
        if (this.jdt != null) {
            this.jdt.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.jdu.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jdu != null) {
            boolean z5 = this.jdu.cna() == null || this.jdu.cna().isEmpty();
            boolean z6 = z;
            if (j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jdw = false;
                z3 = true;
                z2 = false;
            }
            if (this.jdw) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.jdu.cnb();
                } else {
                    this.jdu.cnc();
                }
            }
        }
    }
}
