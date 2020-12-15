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
    private j nhw = null;
    private SquareModel nhx = null;
    private boolean nhy = false;
    private boolean nhz = false;
    private long ivA = -1;
    private final SquareModel.a nhA = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, h hVar) {
            SquareFragment.this.nhw.F(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.nhw.getRootView());
            if (z && hVar != null && !hVar.isEmpty()) {
                SquareFragment.this.nhw.c(SquareFragment.this.nhx.dNX());
                SquareFragment.this.nhy = true;
                SquareFragment.this.nhw.hideNoDataView();
                SquareFragment.this.cyx();
            }
            if (SquareFragment.this.nhz) {
                SquareFragment.this.nhz = false;
                SquareFragment.this.xU(true);
                if (!SquareFragment.this.nhy) {
                    SquareFragment.this.nhw.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.nhw.getRootView());
                }
            } else {
                if (SquareFragment.this.ivA > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaInitialize.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.ivA, SquareFragment.this.nhx.cwp() - SquareFragment.this.ivA, SquareFragment.this.nhx.cwn(), SquareFragment.this.nhx.cwo(), currentTimeMillis - SquareFragment.this.nhx.cwm());
                    SquareFragment.this.ivA = -1L;
                }
                if (!SquareFragment.this.nhy) {
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        SquareFragment.this.nhw.Ed(R.string.no_data_text);
                    } else {
                        SquareFragment.this.nhw.Ed(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                SquareFragment.this.nhw.dOa();
                if (!SquareFragment.this.nhy) {
                    SquareFragment.this.cyw();
                    return;
                }
                return;
            }
            SquareFragment.this.eNx.showToast(str);
            SquareFragment.this.nhw.dOb();
        }
    };
    private final NoNetworkView.a gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SquareFragment.this.xU(true);
            }
        }
    };
    private final View.OnKeyListener nhB = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
        this.ivA = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        xU(this.nhz);
    }

    private void initUI() {
        this.nhw = new j(this.eNx, getUniqueId(), this.mRootView, this.nhB);
        this.nhw.setListPullRefreshListener(this.fci);
    }

    private void initData() {
        this.nhx = new SquareModel(this.eNx);
        this.nhx.a(this.nhA);
        this.nhz = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyw() {
        this.nhw.c(this.gpz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyx() {
        this.nhw.d(this.gpz);
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
        if (this.nhw != null) {
            this.nhw.onChangeSkinType(i);
        }
    }

    private void cancelAllAsyncTask() {
        this.nhx.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.nhx != null) {
            boolean z5 = this.nhx.dNX() == null || this.nhx.dNX().isEmpty();
            boolean z6 = z;
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.nhz = false;
                z3 = true;
                z2 = false;
            }
            if (this.nhz) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                cancelAllAsyncTask();
                if (z4) {
                    this.nhx.dNY();
                } else {
                    this.nhx.dNZ();
                }
            }
        }
    }
}
