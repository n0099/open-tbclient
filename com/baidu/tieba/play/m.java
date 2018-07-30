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
    private int cfO;
    private int dWN;
    private View eSY;
    private f eTa;
    private com.baidu.adp.widget.ListView.j gfp;
    private com.baidu.adp.base.e mContext;
    private int eST = 0;
    private String eSV = null;
    private int eSW = 0;
    private boolean eSZ = false;
    private boolean cdo = true;
    private a eTc = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aFD();
                if (m.this.cdo && m.this.cdo) {
                    m.this.b(m.this.eTb.bkI(), m.this.eTb.bkJ(), m.this.eTb.bkK(), m.this.eTb.bkL());
                }
            }
        }
    };
    private b gfq = new b(this);
    private r eTb = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.cfO = 0;
        this.dWN = 0;
        this.mContext = eVar;
        this.cfO = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
        this.gfp = jVar;
        this.dWN = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        int i4;
        int i5;
        int i6 = 0;
        this.eTb.h(i, i2, z);
        if (this.gfp != null && this.gfp.getListView().getChildCount() != 0 && this.gfp.getContentViewsCount() != 0) {
            if (this.eTa != null && !aS(this.eTa.getVideoContainer())) {
                this.eTa.stopPlay();
            }
            if (this.eSY != null && (this.eSY.getTag() instanceof f) && this.eSZ) {
                if (aS(((f) this.eSY.getTag()).getVideoContainer())) {
                    c(i3, this.eSY);
                    this.eSY = null;
                    return;
                }
                this.eSY = null;
            }
            int contentViewsCount = this.gfp.getContentViewsCount() + this.gfp.getHeaderViewsCount() + this.gfp.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gfp.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gfp.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aS(fVar.getVideoContainer())) {
                            c(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            d(i3, childAt);
                        }
                    }
                    z4 = z3;
                    i7++;
                    z3 = z4;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i8 = 0;
                while (true) {
                    if (i8 >= childCount) {
                        i4 = -1;
                        break;
                    }
                    View childAt2 = this.gfp.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && aS(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.gfp.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            d(i3, childAt3);
                        } else {
                            c(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.gfp.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && aS(fVar3.getVideoContainer())) {
                            c(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            d(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
            }
        }
    }

    private void c(int i, View view) {
        if (view != null) {
            this.eSY = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cdo && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aRJ();
            }
        }
    }

    private void d(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aRK();
        }
    }

    public boolean aS(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.eST && measuredHeight < this.cfO;
    }

    public void aT(View view) {
        if (view != null && !aS(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eTc);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gfq);
        aSn();
    }

    public void pn(int i) {
        this.eSW = i;
    }

    public void aSn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gfp.getListView().getChildCount()) {
                View childAt = this.gfp.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void pt(String str) {
        this.eSV = str;
    }

    public void aSq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gfp.getListView().getChildCount()) {
                View childAt = this.gfp.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        pn(fVar.getCurrentPosition());
                        pt(fVar.getPlayUrl());
                        this.eSY = childAt;
                        this.eSZ = fVar.isPlaying();
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

    public void aSr() {
        if (this.cdo) {
            if (this.eSY != null && (this.eSY.getTag() instanceof f)) {
                f fVar = (f) this.eSY.getTag();
                if (this.eSZ) {
                    fVar.startPlay();
                }
                if (this.eSY.getTag() instanceof e) {
                    ((e) this.eSY.getTag()).aRL();
                }
            }
            this.eSY = null;
        }
    }

    public void aFD() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eTc);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gfq);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gfp.getListView().getChildCount()) {
                View childAt = this.gfp.getListView().getChildAt(i2);
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

    public void b(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gfq);
        this.gfq.pf(i);
        this.gfq.pg(i2);
        this.gfq.fK(z);
        this.gfq.iu(z2);
        this.eTb.iu(z2);
        com.baidu.adp.lib.g.e.in().postDelayed(this.gfq, 500L);
    }

    public void iw(boolean z) {
        this.cdo = z;
    }
}
