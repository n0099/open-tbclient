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
    private TbPageContext<?> eWx;
    private View mRootView;
    private j nuK = null;
    private SquareModel nuL = null;
    private boolean nuM = false;
    private boolean nuN = false;
    private long iKN = -1;
    private final SquareModel.a nuO = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nuK.N(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nuK.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nuK.c(SquareFragment.this.nuL.dMz());
                SquareFragment.this.nuM = true;
                SquareFragment.this.nuK.hideNoDataView();
                SquareFragment.this.cyX();
            }
            if (SquareFragment.this.nuN) {
                SquareFragment.this.nuN = false;
                SquareFragment.this.yl(true);
                if (!SquareFragment.this.nuM) {
                    SquareFragment.this.nuK.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nuK.getRootView());
                }
            } else {
                if (SquareFragment.this.iKN > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.iKN, SquareFragment.this.nuL.cwQ() - SquareFragment.this.iKN, SquareFragment.this.nuL.cwO(), SquareFragment.this.nuL.cwP(), currentTimeMillis - SquareFragment.this.nuL.cwN());
                    SquareFragment.this.iKN = -1L;
                }
                if (!SquareFragment.this.nuM) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nuK.Db(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nuK.Db(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nuK.dMC();
                if (!SquareFragment.this.nuM) {
                    SquareFragment.this.cyW();
                    return;
                }
                return;
            }
            SquareFragment.this.eWx.showToast(str);
            SquareFragment.this.nuK.dMD();
        }
    };
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.yl(true);
            }
        }
    };
    private final View.OnKeyListener nuP = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c fkY = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
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
        this.eWx = getPageContext();
        this.iKN = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        yl(this.nuN);
    }

    private void initUI() {
        this.nuK = new j(this.eWx, getUniqueId(), this.mRootView, this.nuP);
        this.nuK.setListPullRefreshListener(this.fkY);
    }

    private void initData() {
        this.nuL = new SquareModel(this.eWx);
        this.nuL.a(this.nuO);
        this.nuN = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyW() {
        this.nuK.c(this.gzW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyX() {
        this.nuK.d(this.gzW);
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
        if (this.nuK != null) {
            this.nuK.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.nuL.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        boolean z2 = false;
        if (this.nuL != null) {
            boolean z3 = this.nuL.dMz() == null || this.nuL.dMz().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nuN = false;
                z3 = true;
                z4 = false;
            }
            if (this.nuN) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nuL.dMA();
                } else {
                    this.nuL.dMB();
                }
            }
        }
    }
}
