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
    private int fsV;
    private View ftb;
    private f ftd;
    private com.baidu.adp.widget.ListView.j gFq;
    private com.baidu.adp.base.e mContext;
    private int mHeaderHeight;
    private int fsW = 0;
    private String fsY = null;
    private int fsZ = 0;
    private boolean ftc = false;
    private boolean mIsShowing = true;
    private a ftf = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aNk();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.fte.bsA(), m.this.fte.bsB(), m.this.fte.bsC(), m.this.fte.bsD());
                }
            }
        }
    };
    private b gFr = new b(this);
    private s fte = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.fsV = 0;
        this.mHeaderHeight = 0;
        this.mContext = eVar;
        this.fsV = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gFq = jVar;
        this.mHeaderHeight = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.fte.i(i, i2, z);
        if (this.gFq != null && this.gFq.getListView().getChildCount() != 0 && this.gFq.getContentViewsCount() != 0) {
            if (this.ftd != null && !bl(this.ftd.getVideoContainer())) {
                this.ftd.stopPlay();
            }
            if (this.ftb != null && (this.ftb.getTag() instanceof f) && this.ftc) {
                if (bl(((f) this.ftb.getTag()).getVideoContainer())) {
                    f(i3, this.ftb);
                    this.ftb = null;
                    return;
                }
                this.ftb = null;
            }
            int contentViewsCount = this.gFq.getContentViewsCount() + this.gFq.getHeaderViewsCount() + this.gFq.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gFq.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gFq.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && bl(fVar.getVideoContainer())) {
                            f(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            g(i3, childAt);
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
                    View childAt2 = this.gFq.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && bl(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.gFq.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            g(i3, childAt3);
                        } else {
                            f(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.gFq.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && bl(fVar3.getVideoContainer())) {
                            f(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            g(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            this.ftb = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aZj();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            f fVar = (f) view.getTag();
            if (fVar.isPlaying()) {
                fVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aZk();
        }
    }

    public boolean bl(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.fsW && measuredHeight < this.fsV;
    }

    public void bm(View view) {
        if (view != null && !bl(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ftf);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gFr);
        aZN();
    }

    public void rp(int i) {
        this.fsZ = i;
    }

    public void aZN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gFq.getListView().getChildCount()) {
                View childAt = this.gFq.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ri(String str) {
        this.fsY = str;
    }

    public void aZQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gFq.getListView().getChildCount()) {
                View childAt = this.gFq.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rp(fVar.getCurrentPosition());
                        ri(fVar.getPlayUrl());
                        this.ftb = childAt;
                        this.ftc = fVar.isPlaying();
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

    public void aZR() {
        if (this.mIsShowing) {
            if (this.ftb != null && (this.ftb.getTag() instanceof f)) {
                f fVar = (f) this.ftb.getTag();
                if (this.ftc) {
                    fVar.startPlay();
                }
                if (this.ftb.getTag() instanceof e) {
                    ((e) this.ftb.getTag()).aZl();
                }
            }
            this.ftb = null;
        }
    }

    public void aNk() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ftf);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gFr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gFq.getListView().getChildCount()) {
                View childAt = this.gFq.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gFr);
        this.gFr.rh(i);
        this.gFr.ri(i2);
        this.gFr.gH(z);
        this.gFr.jA(z2);
        this.fte.jA(z2);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gFr, 500L);
    }

    public void jC(boolean z) {
        this.mIsShowing = z;
    }
}
