package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int bxj;
    private int cYM;
    private ListView dWa;
    private View dWe;
    private f dWg;
    private com.baidu.adp.base.e mContext;
    private int dVZ = 0;
    private String dWb = null;
    private int dWc = 0;
    private boolean dWf = false;
    private boolean dWi = true;
    private a dWj = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aqY();
                if (m.this.dWi && m.this.dWi) {
                    m.this.a(m.this.dWh.beq(), m.this.dWh.ber(), m.this.dWh.bes(), m.this.dWh.bet());
                }
            }
        }
    };
    private b fwK = new b(this);
    private r dWh = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bxj = 0;
        this.cYM = 0;
        this.mContext = eVar;
        this.bxj = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.dWa = listView;
        this.cYM = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dWh.i(i, i2, z);
        if (this.dWa != null && this.dWa.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dWa instanceof BdListView ? ((BdListView) this.dWa).getWrappedAdapter() : this.dWa.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dWg != null && !aT(this.dWg.getVideoContainer())) {
                    this.dWg.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dWa.getHeaderViewsCount() + this.dWa.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dWa.getChildCount(); i5++) {
                        View childAt = this.dWa.getChildAt(z2 ? i5 : (this.dWa.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aT(fVar.getVideoContainer())) {
                                e(i3, childAt);
                                z3 = true;
                            } else {
                                f(i3, childAt);
                            }
                        }
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= this.dWa.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dWa.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aT(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dWa.getChildCount()) {
                            View childAt3 = this.dWa.getChildAt(i4);
                            if (i4 == i6) {
                                e(i3, childAt3);
                            } else {
                                f(i3, childAt3);
                            }
                            i4++;
                        }
                        return;
                    }
                    boolean z5 = false;
                    while (i4 < this.dWa.getChildCount()) {
                        View childAt4 = this.dWa.getChildAt(z ? (this.dWa.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aT(fVar3.getVideoContainer())) {
                                e(i3, childAt4);
                                z4 = true;
                                i4++;
                                z5 = z4;
                            } else {
                                f(i3, childAt4);
                            }
                        }
                        z4 = z5;
                        i4++;
                        z5 = z4;
                    }
                }
            }
        }
    }

    private void e(int i, View view) {
        if (view != null) {
            this.dWe = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.dWi && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aDT();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aDU();
        }
    }

    public boolean aT(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dVZ && measuredHeight < this.bxj;
        }
        return false;
    }

    public void aU(View view) {
        if (view != null && !aT(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dWj);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwK);
        aEy();
    }

    public void nL(int i) {
        this.dWc = i;
    }

    public void aEy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dWa.getChildCount()) {
                View childAt = this.dWa.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nk(String str) {
        this.dWb = str;
    }

    public void aEB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dWa.getChildCount()) {
                View childAt = this.dWa.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        nL(fVar.getCurrentPosition());
                        nk(fVar.getPlayUrl());
                        this.dWe = childAt;
                        this.dWf = fVar.isPlaying();
                        fVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void aEC() {
        if (this.dWi) {
            if (this.dWe != null && (this.dWe.getTag() instanceof f)) {
                f fVar = (f) this.dWe.getTag();
                if (this.dWf) {
                    fVar.startPlay();
                }
                if (this.dWe.getTag() instanceof e) {
                    ((e) this.dWe.getTag()).aDV();
                }
            }
            this.dWe = null;
        }
    }

    public void aqY() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dWj);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwK);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dWa.getChildCount()) {
                View childAt = this.dWa.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        fVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwK);
        this.fwK.nD(i);
        this.fwK.nE(i2);
        this.fwK.eF(z);
        this.fwK.hq(z2);
        this.dWh.hq(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fwK, 500L);
    }

    public void hs(boolean z) {
        this.dWi = z;
    }
}
