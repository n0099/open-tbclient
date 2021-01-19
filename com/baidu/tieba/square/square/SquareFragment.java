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
/* loaded from: classes7.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> eSJ;
    private View mRootView;
    private j nix = null;
    private SquareModel niy = null;
    private boolean niz = false;
    private boolean niA = false;
    private long iDg = -1;
    private final SquareModel.a niB = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nix.F(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nix.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nix.c(SquareFragment.this.niy.dJY());
                SquareFragment.this.niz = true;
                SquareFragment.this.nix.hideNoDataView();
                SquareFragment.this.cxz();
            }
            if (SquareFragment.this.niA) {
                SquareFragment.this.niA = false;
                SquareFragment.this.xS(true);
                if (!SquareFragment.this.niz) {
                    SquareFragment.this.nix.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nix.getRootView());
                }
            } else {
                if (SquareFragment.this.iDg > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.iDg, SquareFragment.this.niy.cvr() - SquareFragment.this.iDg, SquareFragment.this.niy.cvp(), SquareFragment.this.niy.cvq(), currentTimeMillis - SquareFragment.this.niy.cvo());
                    SquareFragment.this.iDg = -1L;
                }
                if (!SquareFragment.this.niz) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nix.CG(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nix.CG(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nix.dKb();
                if (!SquareFragment.this.niz) {
                    SquareFragment.this.cxy();
                    return;
                }
                return;
            }
            SquareFragment.this.eSJ.showToast(str);
            SquareFragment.this.nix.dKc();
        }
    };
    private final NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xS(true);
            }
        }
    };
    private final View.OnKeyListener niC = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c fhg = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.xS(true);
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
        this.eSJ = getPageContext();
        this.iDg = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xS(this.niA);
    }

    private void initUI() {
        this.nix = new j(this.eSJ, getUniqueId(), this.mRootView, this.niC);
        this.nix.setListPullRefreshListener(this.fhg);
    }

    private void initData() {
        this.niy = new SquareModel(this.eSJ);
        this.niy.a(this.niB);
        this.niA = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxy() {
        this.nix.c(this.gvp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxz() {
        this.nix.d(this.gvp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xS(true);
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
        if (this.nix != null) {
            this.nix.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.niy.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(boolean z) {
        boolean z2 = false;
        if (this.niy != null) {
            boolean z3 = this.niy.dJY() == null || this.niy.dJY().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.niA = false;
                z3 = true;
                z4 = false;
            }
            if (this.niA) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.niy.dJZ();
                } else {
                    this.niy.dKa();
                }
            }
        }
    }
}
