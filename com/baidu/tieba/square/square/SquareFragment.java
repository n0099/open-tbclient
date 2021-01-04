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
/* loaded from: classes8.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> eXu;
    private View mRootView;
    private j nnc = null;
    private SquareModel nnd = null;
    private boolean nne = false;
    private boolean nnf = false;
    private long iHN = -1;
    private final SquareModel.a nng = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nnc.F(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nnc.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nnc.c(SquareFragment.this.nnd.dNP());
                SquareFragment.this.nne = true;
                SquareFragment.this.nnc.hideNoDataView();
                SquareFragment.this.cBq();
            }
            if (SquareFragment.this.nnf) {
                SquareFragment.this.nnf = false;
                SquareFragment.this.xW(true);
                if (!SquareFragment.this.nne) {
                    SquareFragment.this.nnc.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nnc.getRootView());
                }
            } else {
                if (SquareFragment.this.iHN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.iHN, SquareFragment.this.nnd.czi() - SquareFragment.this.iHN, SquareFragment.this.nnd.czg(), SquareFragment.this.nnd.czh(), currentTimeMillis - SquareFragment.this.nnd.czf());
                    SquareFragment.this.iHN = -1L;
                }
                if (!SquareFragment.this.nne) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nnc.En(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nnc.En(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nnc.dNS();
                if (!SquareFragment.this.nne) {
                    SquareFragment.this.cBp();
                    return;
                }
                return;
            }
            SquareFragment.this.eXu.showToast(str);
            SquareFragment.this.nnc.dNT();
        }
    };
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xW(true);
            }
        }
    };
    private final View.OnKeyListener nnh = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c flR = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.xW(true);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eXu = getPageContext();
        this.iHN = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xW(this.nnf);
    }

    private void initUI() {
        this.nnc = new j(this.eXu, getUniqueId(), this.mRootView, this.nnh);
        this.nnc.setListPullRefreshListener(this.flR);
    }

    private void initData() {
        this.nnd = new SquareModel(this.eXu);
        this.nnd.a(this.nng);
        this.nnf = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBp() {
        this.nnc.c(this.gzW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBq() {
        this.nnc.d(this.gzW);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xW(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        cancelAllAsyncTask();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nnc != null) {
            this.nnc.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.nnd.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xW(boolean z) {
        boolean z2 = false;
        if (this.nnd != null) {
            boolean z3 = this.nnd.dNP() == null || this.nnd.dNP().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nnf = false;
                z3 = true;
                z4 = false;
            }
            if (this.nnf) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nnd.dNQ();
                } else {
                    this.nnd.dNR();
                }
            }
        }
    }
}
