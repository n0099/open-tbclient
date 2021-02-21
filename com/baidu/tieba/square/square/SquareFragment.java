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
    private TbPageContext<?> eUY;
    private View mRootView;
    private j nsF = null;
    private SquareModel nsG = null;
    private boolean nsH = false;
    private boolean nsI = false;
    private long iJe = -1;
    private final SquareModel.a nsJ = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nsF.N(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nsF.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nsF.c(SquareFragment.this.nsG.dMr());
                SquareFragment.this.nsH = true;
                SquareFragment.this.nsF.hideNoDataView();
                SquareFragment.this.cyR();
            }
            if (SquareFragment.this.nsI) {
                SquareFragment.this.nsI = false;
                SquareFragment.this.yl(true);
                if (!SquareFragment.this.nsH) {
                    SquareFragment.this.nsF.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nsF.getRootView());
                }
            } else {
                if (SquareFragment.this.iJe > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.iJe, SquareFragment.this.nsG.cwK() - SquareFragment.this.iJe, SquareFragment.this.nsG.cwI(), SquareFragment.this.nsG.cwJ(), currentTimeMillis - SquareFragment.this.nsG.cwH());
                    SquareFragment.this.iJe = -1L;
                }
                if (!SquareFragment.this.nsH) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nsF.CY(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nsF.CY(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nsF.dMu();
                if (!SquareFragment.this.nsH) {
                    SquareFragment.this.cyQ();
                    return;
                }
                return;
            }
            SquareFragment.this.eUY.showToast(str);
            SquareFragment.this.nsF.dMv();
        }
    };
    private final NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.yl(true);
            }
        }
    };
    private final View.OnKeyListener nsK = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c fjz = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.yl(true);
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
        this.eUY = getPageContext();
        this.iJe = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        yl(this.nsI);
    }

    private void initUI() {
        this.nsF = new j(this.eUY, getUniqueId(), this.mRootView, this.nsK);
        this.nsF.setListPullRefreshListener(this.fjz);
    }

    private void initData() {
        this.nsG = new SquareModel(this.eUY);
        this.nsG.a(this.nsJ);
        this.nsI = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyQ() {
        this.nsF.c(this.gyn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyR() {
        this.nsF.d(this.gyn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            yl(true);
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
        if (this.nsF != null) {
            this.nsF.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.nsG.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        boolean z2 = false;
        if (this.nsG != null) {
            boolean z3 = this.nsG.dMr() == null || this.nsG.dMr().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nsI = false;
                z3 = true;
                z4 = false;
            }
            if (this.nsI) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nsG.dMs();
                } else {
                    this.nsG.dMt();
                }
            }
        }
    }
}
