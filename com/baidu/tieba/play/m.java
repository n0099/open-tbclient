package com.baidu.tieba.play;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int czh;
    private View eYA;
    private f eYC;
    private int edZ;
    private com.baidu.adp.widget.ListView.k grI;
    private com.baidu.adp.base.e mContext;
    private int eYv = 0;
    private String eYx = null;
    private int eYy = 0;
    private boolean eYB = false;
    private boolean cwF = true;
    private a eYE = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aCB();
                if (m.this.cwF && m.this.cwF) {
                    m.this.c(m.this.eYD.bkt(), m.this.eYD.bku(), m.this.eYD.bkv(), m.this.eYD.bkw());
                }
            }
        }
    };
    private b grJ = new b(this);
    private s eYD = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.k kVar) {
        this.czh = 0;
        this.edZ = 0;
        this.mContext = eVar;
        this.czh = com.baidu.adp.lib.util.l.aq(this.mContext.getPageActivity());
        this.grI = kVar;
        this.edZ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eYD.j(i, i2, z);
        if (this.grI != null && this.grI.getListView().getChildCount() != 0 && this.grI.getContentViewsCount() != 0) {
            if (this.eYC != null && !cg(this.eYC.getVideoContainer())) {
                this.eYC.stopPlay();
            }
            int contentViewsCount = this.grI.getContentViewsCount() + this.grI.getHeaderViewsCount() + this.grI.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.grI.getListView().getChildCount(); i5++) {
                    View childAt = this.grI.getListView().getChildAt(z2 ? i5 : (this.grI.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cg(fVar.getVideoContainer())) {
                            f(i3, childAt);
                            z3 = true;
                        } else {
                            g(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.grI.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.grI.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cg(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.grI.getListView().getChildCount()) {
                        View childAt3 = this.grI.getListView().getChildAt(i4);
                        if (i4 == i6) {
                            f(i3, childAt3);
                        } else {
                            g(i3, childAt3);
                        }
                        i4++;
                    }
                    return;
                }
                boolean z5 = false;
                while (i4 < this.grI.getListView().getChildCount()) {
                    View childAt4 = this.grI.getListView().getChildAt(z ? (this.grI.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && cg(fVar3.getVideoContainer())) {
                            f(i3, childAt4);
                            z4 = true;
                            i4++;
                            z5 = z4;
                        } else {
                            g(i3, childAt4);
                        }
                    }
                    z4 = z5;
                    i4++;
                    z5 = z4;
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            this.eYA = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cwF && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aOo();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aOp();
        }
    }

    public boolean cg(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.eYv && measuredHeight < this.czh;
        }
        return false;
    }

    public void ch(View view) {
        if (view != null && !cg(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eYE);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.grJ);
        aOT();
    }

    public void rg(int i) {
        this.eYy = i;
    }

    public void aOT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.grI.getListView().getChildCount()) {
                View childAt = this.grI.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void oc(String str) {
        this.eYx = str;
    }

    public void aOW() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.grI.getListView().getChildCount()) {
                View childAt = this.grI.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rg(fVar.getCurrentPosition());
                        oc(fVar.getPlayUrl());
                        this.eYA = childAt;
                        this.eYB = fVar.isPlaying();
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

    public void aOX() {
        if (this.cwF) {
            if (this.eYA != null && (this.eYA.getTag() instanceof f)) {
                f fVar = (f) this.eYA.getTag();
                if (this.eYB) {
                    fVar.startPlay();
                }
                if (this.eYA.getTag() instanceof e) {
                    ((e) this.eYA.getTag()).aOq();
                }
            }
            this.eYA = null;
        }
    }

    public void aCB() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eYE);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.grJ);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.grI.getListView().getChildCount()) {
                View childAt = this.grI.getListView().getChildAt(i2);
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

    public void c(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.grJ);
        this.grJ.qY(i);
        this.grJ.qZ(i2);
        this.grJ.fI(z);
        this.grJ.ij(z2);
        this.eYD.ij(z2);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.grJ, 500L);
    }

    public void il(boolean z) {
        this.cwF = z;
    }
}
