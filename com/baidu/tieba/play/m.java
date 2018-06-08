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
    private int cbW;
    private int dPE;
    private View eLm;
    private f eLo;
    private com.baidu.adp.widget.ListView.j gaP;
    private com.baidu.adp.base.e mContext;
    private int eLh = 0;
    private String eLj = null;
    private int eLk = 0;
    private boolean eLn = false;
    private boolean mIsShowing = true;
    private a eLq = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aDT();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.eLp.blL(), m.this.eLp.blM(), m.this.eLp.blN(), m.this.eLp.blO());
                }
            }
        }
    };
    private b gaQ = new b(this);
    private r eLp = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.cbW = 0;
        this.dPE = 0;
        this.mContext = eVar;
        this.cbW = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
        this.gaP = jVar;
        this.dPE = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eLp.h(i, i2, z);
        if (this.gaP != null && this.gaP.getListView().getChildCount() != 0 && this.gaP.getContentViewsCount() != 0) {
            if (this.eLo != null && !aO(this.eLo.getVideoContainer())) {
                this.eLo.stopPlay();
            }
            int contentViewsCount = this.gaP.getContentViewsCount() + this.gaP.getHeaderViewsCount() + this.gaP.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gaP.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gaP.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aO(fVar.getVideoContainer())) {
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
                    View childAt2 = this.gaP.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && aO(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.gaP.getListView().getChildAt(i6);
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
                    View childAt4 = this.gaP.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && aO(fVar3.getVideoContainer())) {
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
            this.eLm = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aQc();
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

    public boolean aO(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.eLh && measuredHeight < this.cbW;
    }

    public void aP(View view) {
        if (view != null && !aO(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eLq);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaQ);
        aQG();
    }

    public void oR(int i) {
        this.eLk = i;
    }

    public void aQG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gaP.getListView().getChildCount()) {
                View childAt = this.gaP.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void pr(String str) {
        this.eLj = str;
    }

    public void aQJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gaP.getListView().getChildCount()) {
                View childAt = this.gaP.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oR(fVar.getCurrentPosition());
                        pr(fVar.getPlayUrl());
                        this.eLm = childAt;
                        this.eLn = fVar.isPlaying();
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

    public void aQK() {
        if (this.mIsShowing) {
            if (this.eLm != null && (this.eLm.getTag() instanceof f)) {
                f fVar = (f) this.eLm.getTag();
                if (this.eLn) {
                    fVar.startPlay();
                }
                if (this.eLm.getTag() instanceof e) {
                    ((e) this.eLm.getTag()).aQd();
                }
            }
            this.eLm = null;
        }
    }

    public void aDT() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.eLq);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaQ);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gaP.getListView().getChildCount()) {
                View childAt = this.gaP.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gaQ);
        this.gaQ.oJ(i);
        this.gaQ.oK(i2);
        this.gaQ.fE(z);
        this.gaQ.ih(z2);
        this.eLp.ih(z2);
        com.baidu.adp.lib.g.e.im().postDelayed(this.gaQ, 500L);
    }

    public void ij(boolean z) {
        this.mIsShowing = z;
    }
}
