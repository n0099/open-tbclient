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
    private int bTi;
    private int dDq;
    private View eyN;
    private f eyP;
    private com.baidu.adp.widget.ListView.j fOA;
    private com.baidu.adp.base.e mContext;
    private int eyI = 0;
    private String eyK = null;
    private int eyL = 0;
    private boolean eyO = false;
    private boolean mIsShowing = true;
    private a eyR = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aza();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.eyQ.bgN(), m.this.eyQ.bgO(), m.this.eyQ.bgP(), m.this.eyQ.bgQ());
                }
            }
        }
    };
    private b fOB = new b(this);
    private r eyQ = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.bTi = 0;
        this.dDq = 0;
        this.mContext = eVar;
        this.bTi = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.fOA = jVar;
        this.dDq = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eyQ.h(i, i2, z);
        if (this.fOA != null && this.fOA.getListView().getChildCount() != 0 && this.fOA.getContentViewsCount() != 0) {
            if (this.eyP != null && !aL(this.eyP.getVideoContainer())) {
                this.eyP.stopPlay();
            }
            int contentViewsCount = this.fOA.getContentViewsCount() + this.fOA.getHeaderViewsCount() + this.fOA.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.fOA.getListView().getChildCount(); i5++) {
                    View childAt = this.fOA.getListView().getChildAt(z2 ? i5 : (this.fOA.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aL(fVar.getVideoContainer())) {
                            d(i3, childAt);
                            z3 = true;
                        } else {
                            e(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.fOA.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.fOA.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && aL(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.fOA.getListView().getChildCount()) {
                        View childAt3 = this.fOA.getListView().getChildAt(i4);
                        if (i4 == i6) {
                            d(i3, childAt3);
                        } else {
                            e(i3, childAt3);
                        }
                        i4++;
                    }
                    return;
                }
                boolean z5 = false;
                while (i4 < this.fOA.getListView().getChildCount()) {
                    View childAt4 = this.fOA.getListView().getChildAt(z ? (this.fOA.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && aL(fVar3.getVideoContainer())) {
                            d(i3, childAt4);
                            z4 = true;
                            i4++;
                            z5 = z4;
                        } else {
                            e(i3, childAt4);
                        }
                    }
                    z4 = z5;
                    i4++;
                    z5 = z4;
                }
            }
        }
    }

    private void d(int i, View view2) {
        if (view2 != null) {
            this.eyN = view2;
            if (i == 1 && (view2.getTag() instanceof f)) {
                f fVar = (f) view2.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view2.getTag() instanceof e)) {
                ((e) view2.getTag()).aLg();
            }
        }
    }

    private void e(int i, View view2) {
        if (i == 1 && (view2.getTag() instanceof f)) {
            ((f) view2.getTag()).stopPlay();
        } else if (i == 2 && (view2.getTag() instanceof e)) {
            ((e) view2.getTag()).hideAll();
        }
    }

    public boolean aL(View view2) {
        int measuredHeight;
        if (view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
            return view2 != null && (measuredHeight = iArr[1] + (view2.getMeasuredHeight() / 2)) > this.eyI && measuredHeight < this.bTi;
        }
        return false;
    }

    public void aM(View view2) {
        if (view2 != null && !aL(view2) && (view2.getTag() instanceof f)) {
            ((f) view2.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyR);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOB);
        aLK();
    }

    public void oH(int i) {
        this.eyL = i;
    }

    public void aLK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOA.getListView().getChildCount()) {
                View childAt = this.fOA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void oA(String str) {
        this.eyK = str;
    }

    public void aLN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOA.getListView().getChildCount()) {
                View childAt = this.fOA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oH(fVar.getCurrentPosition());
                        oA(fVar.getPlayUrl());
                        this.eyN = childAt;
                        this.eyO = fVar.isPlaying();
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

    public void aLO() {
        if (this.mIsShowing) {
            if (this.eyN != null && (this.eyN.getTag() instanceof f)) {
                f fVar = (f) this.eyN.getTag();
                if (this.eyO) {
                    fVar.startPlay();
                }
                if (this.eyN.getTag() instanceof e) {
                    ((e) this.eyN.getTag()).aLh();
                }
            }
            this.eyN = null;
        }
    }

    public void aza() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyR);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOB);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOA.getListView().getChildCount()) {
                View childAt = this.fOA.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOB);
        this.fOB.oz(i);
        this.fOB.oA(i2);
        this.fOB.fy(z);
        this.fOB.ia(z2);
        this.eyQ.ia(z2);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fOB, 500L);
    }

    public void ic(boolean z) {
        this.mIsShowing = z;
    }
}
