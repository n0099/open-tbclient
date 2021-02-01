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
    private j nsf = null;
    private SquareModel nsg = null;
    private boolean nsh = false;
    private boolean nsi = false;
    private long iIQ = -1;
    private final SquareModel.a nsj = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nsf.N(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nsf.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nsf.c(SquareFragment.this.nsg.dMj());
                SquareFragment.this.nsh = true;
                SquareFragment.this.nsf.hideNoDataView();
                SquareFragment.this.cyK();
            }
            if (SquareFragment.this.nsi) {
                SquareFragment.this.nsi = false;
                SquareFragment.this.yl(true);
                if (!SquareFragment.this.nsh) {
                    SquareFragment.this.nsf.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nsf.getRootView());
                }
            } else {
                if (SquareFragment.this.iIQ > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.iIQ, SquareFragment.this.nsg.cwD() - SquareFragment.this.iIQ, SquareFragment.this.nsg.cwB(), SquareFragment.this.nsg.cwC(), currentTimeMillis - SquareFragment.this.nsg.cwA());
                    SquareFragment.this.iIQ = -1L;
                }
                if (!SquareFragment.this.nsh) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nsf.CY(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nsf.CY(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nsf.dMm();
                if (!SquareFragment.this.nsh) {
                    SquareFragment.this.cyJ();
                    return;
                }
                return;
            }
            SquareFragment.this.eUY.showToast(str);
            SquareFragment.this.nsf.dMn();
        }
    };
    private final NoNetworkView.a gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.yl(true);
            }
        }
    };
    private final View.OnKeyListener nsk = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
        this.iIQ = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        yl(this.nsi);
    }

    private void initUI() {
        this.nsf = new j(this.eUY, getUniqueId(), this.mRootView, this.nsk);
        this.nsf.setListPullRefreshListener(this.fjz);
    }

    private void initData() {
        this.nsg = new SquareModel(this.eUY);
        this.nsg.a(this.nsj);
        this.nsi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyJ() {
        this.nsf.c(this.gxZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyK() {
        this.nsf.d(this.gxZ);
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
        if (this.nsf != null) {
            this.nsf.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.nsg.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(boolean z) {
        boolean z2 = false;
        if (this.nsg != null) {
            boolean z3 = this.nsg.dMj() == null || this.nsg.dMj().isEmpty();
            boolean z4 = z;
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.nsi = false;
                z3 = true;
                z4 = false;
            }
            if (this.nsi) {
                z3 = true;
            } else {
                z2 = z4;
            }
            if (z3 || z2) {
                cancelAllAsyncTask();
                if (z2) {
                    this.nsg.dMk();
                } else {
                    this.nsg.dMl();
                }
            }
        }
    }
}
