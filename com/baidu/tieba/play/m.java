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
    private int bKj;
    private int dpz;
    private ListView ejI;
    private View ejM;
    private f ejO;
    private com.baidu.adp.base.e mContext;
    private int ejH = 0;
    private String ejJ = null;
    private int ejK = 0;
    private boolean ejN = false;
    private boolean bHE = true;
    private a ejQ = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.avl();
                if (m.this.bHE && m.this.bHE) {
                    m.this.a(m.this.ejP.bju(), m.this.ejP.bjv(), m.this.ejP.bjw(), m.this.ejP.bjx());
                }
            }
        }
    };
    private b fOC = new b(this);
    private r ejP = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bKj = 0;
        this.dpz = 0;
        this.mContext = eVar;
        this.bKj = com.baidu.adp.lib.util.l.ae(this.mContext.getPageActivity());
        this.ejI = listView;
        this.dpz = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.ejP.i(i, i2, z);
        if (this.ejI != null && this.ejI.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.ejI instanceof BdListView ? ((BdListView) this.ejI).getWrappedAdapter() : this.ejI.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.ejO != null && !aP(this.ejO.getVideoContainer())) {
                    this.ejO.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.ejI.getHeaderViewsCount() + this.ejI.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.ejI.getChildCount(); i5++) {
                        View childAt = this.ejI.getChildAt(z2 ? i5 : (this.ejI.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aP(fVar.getVideoContainer())) {
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
                        if (i6 >= this.ejI.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.ejI.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aP(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.ejI.getChildCount()) {
                            View childAt3 = this.ejI.getChildAt(i4);
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
                    while (i4 < this.ejI.getChildCount()) {
                        View childAt4 = this.ejI.getChildAt(z ? (this.ejI.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aP(fVar3.getVideoContainer())) {
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
            this.ejM = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bHE && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aHa();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aHb();
        }
    }

    public boolean aP(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.ejH && measuredHeight < this.bKj;
        }
        return false;
    }

    public void aQ(View view) {
        if (view != null && !aP(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejQ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOC);
        aHF();
    }

    public void oo(int i) {
        this.ejK = i;
    }

    public void aHF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ejI.getChildCount()) {
                View childAt = this.ejI.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nQ(String str) {
        this.ejJ = str;
    }

    public void aHI() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ejI.getChildCount()) {
                View childAt = this.ejI.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oo(fVar.getCurrentPosition());
                        nQ(fVar.getPlayUrl());
                        this.ejM = childAt;
                        this.ejN = fVar.isPlaying();
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

    public void aHJ() {
        if (this.bHE) {
            if (this.ejM != null && (this.ejM.getTag() instanceof f)) {
                f fVar = (f) this.ejM.getTag();
                if (this.ejN) {
                    fVar.startPlay();
                }
                if (this.ejM.getTag() instanceof e) {
                    ((e) this.ejM.getTag()).aHc();
                }
            }
            this.ejM = null;
        }
    }

    public void avl() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ejQ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOC);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ejI.getChildCount()) {
                View childAt = this.ejI.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fOC);
        this.fOC.og(i);
        this.fOC.oh(i2);
        this.fOC.eX(z);
        this.fOC.hG(z2);
        this.ejP.hG(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fOC, 500L);
    }

    public void hI(boolean z) {
        this.bHE = z;
    }
}
