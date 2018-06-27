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
    private int ceh;
    private int dSW;
    private View ePc;
    private f ePe;
    private com.baidu.adp.widget.ListView.j geQ;
    private com.baidu.adp.base.e mContext;
    private int eOX = 0;
    private String eOZ = null;
    private int ePa = 0;
    private boolean ePd = false;
    private boolean mIsShowing = true;
    private a ePg = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aED();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.ePf.bmp(), m.this.ePf.bmq(), m.this.ePf.bmr(), m.this.ePf.bms());
                }
            }
        }
    };
    private b geR = new b(this);
    private r ePf = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.ceh = 0;
        this.dSW = 0;
        this.mContext = eVar;
        this.ceh = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
        this.geQ = jVar;
        this.dSW = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.ePf.h(i, i2, z);
        if (this.geQ != null && this.geQ.getListView().getChildCount() != 0 && this.geQ.getContentViewsCount() != 0) {
            if (this.ePe != null && !aP(this.ePe.getVideoContainer())) {
                this.ePe.stopPlay();
            }
            int contentViewsCount = this.geQ.getContentViewsCount() + this.geQ.getHeaderViewsCount() + this.geQ.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.geQ.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.geQ.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aP(fVar.getVideoContainer())) {
                            d(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            e(i3, childAt);
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
                    View childAt2 = this.geQ.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && aP(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.geQ.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            e(i3, childAt3);
                        } else {
                            d(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.geQ.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && aP(fVar3.getVideoContainer())) {
                            d(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            e(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
            }
        }
    }

    private void d(int i, View view) {
        if (view != null) {
            this.ePc = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aQI();
            }
        }
    }

    private void e(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).hideAll();
        }
    }

    public boolean aP(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.eOX && measuredHeight < this.ceh;
    }

    public void aQ(View view) {
        if (view != null && !aP(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ePg);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.geR);
        aRm();
    }

    public void oY(int i) {
        this.ePa = i;
    }

    public void aRm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.geQ.getListView().getChildCount()) {
                View childAt = this.geQ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ps(String str) {
        this.eOZ = str;
    }

    public void aRp() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.geQ.getListView().getChildCount()) {
                View childAt = this.geQ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oY(fVar.getCurrentPosition());
                        ps(fVar.getPlayUrl());
                        this.ePc = childAt;
                        this.ePd = fVar.isPlaying();
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

    public void aRq() {
        if (this.mIsShowing) {
            if (this.ePc != null && (this.ePc.getTag() instanceof f)) {
                f fVar = (f) this.ePc.getTag();
                if (this.ePd) {
                    fVar.startPlay();
                }
                if (this.ePc.getTag() instanceof e) {
                    ((e) this.ePc.getTag()).aQJ();
                }
            }
            this.ePc = null;
        }
    }

    public void aED() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ePg);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.geR);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.geQ.getListView().getChildCount()) {
                View childAt = this.geQ.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.geR);
        this.geR.oQ(i);
        this.geR.oR(i2);
        this.geR.fI(z);
        this.geR.ir(z2);
        this.ePf.ir(z2);
        com.baidu.adp.lib.g.e.im().postDelayed(this.geR, 500L);
    }

    public void it(boolean z) {
        this.mIsShowing = z;
    }
}
