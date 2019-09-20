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
    private h jet = null;
    private SquareModel jeu = null;
    private boolean jev = false;
    private boolean jew = false;
    private long eZc = -1;
    private final SquareModel.a jex = new SquareModel.a() { // from class: com.baidu.tieba.square.square.SquareFragment.1
        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, f fVar) {
            SquareFragment.this.jet.y(true, "");
            SquareFragment.this.hideLoadingView(SquareFragment.this.jet.getRootView());
            if (z && fVar != null && !fVar.isEmpty()) {
                SquareFragment.this.jet.c(SquareFragment.this.jeu.cpl());
                SquareFragment.this.jev = true;
                SquareFragment.this.jet.hideNoDataView();
                SquareFragment.this.biE();
            }
            if (SquareFragment.this.jew) {
                SquareFragment.this.jew = false;
                SquareFragment.this.qZ(true);
                if (!SquareFragment.this.jev) {
                    SquareFragment.this.jet.hideNoDataView();
                    SquareFragment.this.showLoadingView(SquareFragment.this.jet.getRootView());
                }
            } else {
                if (SquareFragment.this.eZc > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page("op_square_enter", currentTimeMillis - SquareFragment.this.eZc, SquareFragment.this.jeu.bgV() - SquareFragment.this.eZc, SquareFragment.this.jeu.bgT(), SquareFragment.this.jeu.bgU(), currentTimeMillis - SquareFragment.this.jeu.bgS());
                    SquareFragment.this.eZc = -1L;
                }
                if (!SquareFragment.this.jev) {
                    if (j.kc()) {
                        SquareFragment.this.jet.pb(R.string.no_data_text);
                    } else {
                        SquareFragment.this.jet.pb(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.kc()) {
                SquareFragment.this.jet.cpo();
                if (!SquareFragment.this.jev) {
                    SquareFragment.this.biD();
                    return;
                }
                return;
            }
            SquareFragment.this.mContext.showToast(str);
            SquareFragment.this.jet.cpp();
        }
    };
    private final NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.square.square.SquareFragment.2
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z) {
                SquareFragment.this.qZ(true);
            }
        }
    };
    private final View.OnKeyListener jey = new View.OnKeyListener() { // from class: com.baidu.tieba.square.square.SquareFragment.3
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
    private final h.c cbC = new h.c() { // from class: com.baidu.tieba.square.square.SquareFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            SquareFragment.this.qZ(true);
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
        this.eZc = System.currentTimeMillis();
        initUI();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        qZ(this.jew);
    }

    private void initUI() {
        this.jet = new h(this.mContext, getUniqueId(), this.mRootView, this.jey);
        this.jet.setListPullRefreshListener(this.cbC);
    }

    private void initData() {
        this.jeu = new SquareModel(this.mContext);
        this.jeu.a(this.jex);
        this.jew = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biD() {
        this.jet.d(this.eIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biE() {
        this.jet.e(this.eIX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (needRefresh) {
            qZ(true);
            needRefresh = false;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        atU();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jet != null) {
            this.jet.onChangeSkinType(i);
        }
    }

    private void atU() {
        this.jeu.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qZ(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.jeu != null) {
            boolean z5 = this.jeu.cpl() == null || this.jeu.cpl().isEmpty();
            boolean z6 = z;
            if (j.kc()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.jew = false;
                z3 = true;
                z2 = false;
            }
            if (this.jew) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                atU();
                if (z4) {
                    this.jeu.cpm();
                } else {
                    this.jeu.cpn();
                }
            }
        }
    }
}
