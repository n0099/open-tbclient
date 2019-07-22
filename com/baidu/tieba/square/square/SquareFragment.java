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
    private h jaU = null;
    private SquareModel jaV = null;
    private boolean jaW = false;
    private boolean jaX = false;
    private long eXm = -1;
    private final SquareModel.a jaY = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.jaU.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.jaU.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.jaU.c(SquareFragment.this.jaV.cog());
                SquareFragment.this.jaW = true;
                SquareFragment.this.jaU.hideNoDataView();
                SquareFragment.this.bhM();
            }
            if (SquareFragment.this.jaX) {
                SquareFragment.this.jaX = false;
                SquareFragment.this.qV(true);
                if (!SquareFragment.this.jaW) {
                    SquareFragment.this.jaU.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.jaU.getRootView());
                }
            } else {
                if (SquareFragment.this.eXm > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eXm, SquareFragment.this.jaV.bgm() - SquareFragment.this.eXm, SquareFragment.this.jaV.bgk(), SquareFragment.this.jaV.bgl(), currentTimeMillis - SquareFragment.this.jaV.bgj());
                    SquareFragment.this.eXm = -1L;
                }
                if (!SquareFragment.this.jaW) {
                    if (j.kc()) {
                        SquareFragment.this.jaU.oW(R.string.no_data_text);
                    } else {
                        SquareFragment.this.jaU.oW(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.kc()) {
                SquareFragment.this.jaU.coj();
                if (!SquareFragment.this.jaW) {
                    SquareFragment.this.bhL();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.jaU.cok();
        }
    };
    private final NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                SquareFragment.this.qV(true);
            }
        }
    };
    private final View.OnKeyListener jaZ = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c caD = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            SquareFragment.this.qV(true);
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
        this.eXm = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qV(this.jaX);
    }

    private void initUI() {
        this.jaU = new h(this.mContext, getUniqueId(), this.mRootView, this.jaZ);
        this.jaU.setListPullRefreshListener(this.caD);
    }

    private void initData() {
        this.jaV = new SquareModel(this.mContext);
        this.jaV.a(this.jaY);
        this.jaX = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhL() {
        this.jaU.d(this.eHh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhM() {
        this.jaU.e(this.eHh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qV(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        atG();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jaU != null) {
            this.jaU.onChangeSkinType(i);
        }
    }

    private void atG() {
        this.jaV.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jaV != null) {
            boolean z5 = this.jaV.cog() == null || this.jaV.cog().isEmpty();
            boolean z6 = z;
            if (j.kc()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jaX = false;
                z3 = true;
                z2 = false;
            }
            if (this.jaX) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                atG();
                if (z4) {
                    this.jaV.coh();
                } else {
                    this.jaV.coi();
                }
            }
        }
    }
}
