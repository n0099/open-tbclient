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
    private int cfL;
    private int dWK;
    private View eST;
    private f eSV;
    private com.baidu.adp.widget.ListView.j gfo;
    private com.baidu.adp.base.e mContext;
    private int eSO = 0;
    private String eSQ = null;
    private int eSR = 0;
    private boolean eSU = false;
    private boolean cdm = true;
    private a eSX = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aFA();
                if (m.this.cdm && m.this.cdm) {
                    m.this.b(m.this.eSW.bkF(), m.this.eSW.bkG(), m.this.eSW.bkH(), m.this.eSW.bkI());
                }
            }
        }
    };
    private b gfp = new b(this);
    private r eSW = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.cfL = 0;
        this.dWK = 0;
        this.mContext = eVar;
        this.cfL = com.baidu.adp.lib.util.l.aj(this.mContext.getPageActivity());
        this.gfo = jVar;
        this.dWK = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eSW.h(i, i2, z);
        if (this.gfo != null && this.gfo.getListView().getChildCount() != 0 && this.gfo.getContentViewsCount() != 0) {
            if (this.eSV != null && !aS(this.eSV.getVideoContainer())) {
                this.eSV.stopPlay();
            }
            if (this.eST != null && (this.eST.getTag() instanceof f) && this.eSU) {
                if (aS(((f) this.eST.getTag()).getVideoContainer())) {
                    d(i3, this.eST);
                    this.eST = null;
                    return;
                }
                this.eST = null;
            }
            int contentViewsCount = this.gfo.getContentViewsCount() + this.gfo.getHeaderViewsCount() + this.gfo.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gfo.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gfo.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aS(fVar.getVideoContainer())) {
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
                    View childAt2 = this.gfo.getListView().getChildAt(i8);
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
                        View childAt3 = this.gfo.getListView().getChildAt(i6);
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
                    View childAt4 = this.gfo.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && aS(fVar3.getVideoContainer())) {
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
            this.eST = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cdm && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aRG();
            }
        }
    }

    private void e(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aRH();
        }
    }

    public boolean aS(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.eSO && measuredHeight < this.cfL;
    }

    public void aT(View view) {
        if (view != null && !aS(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eSX);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gfp);
        aSk();
    }

    public void pn(int i) {
        this.eSR = i;
    }

    public void aSk() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gfo.getListView().getChildCount()) {
                View childAt = this.gfo.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void pv(String str) {
        this.eSQ = str;
    }

    public void aSn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gfo.getListView().getChildCount()) {
                View childAt = this.gfo.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        pn(fVar.getCurrentPosition());
                        pv(fVar.getPlayUrl());
                        this.eST = childAt;
                        this.eSU = fVar.isPlaying();
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

    public void aSo() {
        if (this.cdm) {
            if (this.eST != null && (this.eST.getTag() instanceof f)) {
                f fVar = (f) this.eST.getTag();
                if (this.eSU) {
                    fVar.startPlay();
                }
                if (this.eST.getTag() instanceof e) {
                    ((e) this.eST.getTag()).aRI();
                }
            }
            this.eST = null;
        }
    }

    public void aFA() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.eSX);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gfp);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gfo.getListView().getChildCount()) {
                View childAt = this.gfo.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gfp);
        this.gfp.pf(i);
        this.gfp.pg(i2);
        this.gfp.fK(z);
        this.gfp.iu(z2);
        this.eSW.iu(z2);
        com.baidu.adp.lib.g.e.in().postDelayed(this.gfp, 500L);
    }

    public void iw(boolean z) {
        this.cdm = z;
    }
}
