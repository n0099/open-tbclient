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
/* loaded from: classes23.dex */
public class SquareFragment extends BaseFragment {
    public static boolean needRefresh = false;
    private TbPageContext<?> eNx;
    private View mRootView;
    private j nhu = null;
    private SquareModel nhv = null;
    private boolean nhw = false;
    private boolean nhx = false;
    private long ivy = -1;
    private final SquareModel.a nhy = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nhu.F(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nhu.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nhu.c(SquareFragment.this.nhv.dNW());
                SquareFragment.this.nhw = true;
                SquareFragment.this.nhu.hideNoDataView();
                SquareFragment.this.cyw();
            }
            if (SquareFragment.this.nhx) {
                SquareFragment.this.nhx = false;
                SquareFragment.this.xU(true);
                if (!SquareFragment.this.nhw) {
                    SquareFragment.this.nhu.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nhu.getRootView());
                }
            } else {
                if (SquareFragment.this.ivy > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.ivy, SquareFragment.this.nhv.cwo() - SquareFragment.this.ivy, SquareFragment.this.nhv.cwm(), SquareFragment.this.nhv.cwn(), currentTimeMillis - SquareFragment.this.nhv.cwl());
                    SquareFragment.this.ivy = -1L;
                }
                if (!SquareFragment.this.nhw) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nhu.Ed(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nhu.Ed(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nhu.dNZ();
                if (!SquareFragment.this.nhw) {
                    SquareFragment.this.cyv();
                    return;
                }
                return;
            }
            SquareFragment.this.eNx.showToast(str);
            SquareFragment.this.nhu.dOa();
        }
    };
    private final NoNetworkView.a gpx = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xU(true);
            }
        }
    };
    private final View.OnKeyListener nhz = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final f.c fci = new f.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.xU(true);
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eNx = getPageContext();
        this.ivy = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xU(this.nhx);
    }

    private void initUI() {
        this.nhu = new j(this.eNx, getUniqueId(), this.mRootView, this.nhz);
        this.nhu.setListPullRefreshListener(this.fci);
    }

    private void initData() {
        this.nhv = new SquareModel(this.eNx);
        this.nhv.a(this.nhy);
        this.nhx = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyv() {
        this.nhu.c(this.gpx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyw() {
        this.nhu.d(this.gpx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            xU(true);
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
        if (this.nhu != null) {
            this.nhu.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.nhv.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.nhv != null) {
            boolean z5 = this.nhv.dNW() == null || this.nhv.dNW().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.nhx = false;
                z3 = true;
                z2 = false;
            }
            if (this.nhx) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.nhv.dNX();
                } else {
                    this.nhv.dNY();
                }
            }
        }
    }
}
