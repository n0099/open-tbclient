package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class aa {
    private a aTp;
    private int ffE;
    private ListView ffF;
    private int ffI;
    private View ffJ;
    private s ffL;
    private com.baidu.adp.base.h mContext;
    private int dLa = 0;
    private String ffG = null;
    private int ffH = 0;
    private boolean ffK = false;
    private boolean bWF = true;
    private com.baidu.tieba.play.a ffN = new com.baidu.tieba.play.a();
    private final CustomMessageListener FT = new ab(this, 2000994);
    private b ffO = new b(this);
    private aq ffM = new aq();

    /* loaded from: classes.dex */
    public interface a {
        void r(int i, int i2, int i3);
    }

    public void a(a aVar) {
        this.aTp = aVar;
    }

    public void a(s sVar) {
        this.ffL = sVar;
    }

    public aa(com.baidu.adp.base.h hVar, ListView listView) {
        this.ffE = 0;
        this.ffI = 0;
        this.mContext = hVar;
        this.ffE = com.baidu.adp.lib.util.k.L(this.mContext.getPageActivity());
        this.ffF = listView;
        this.ffI = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        hVar.registerListener(this.FT);
    }

    public void qN(int i) {
        this.ffE = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.ffM.g(i, i2, z);
        if (this.ffF != null && this.ffF.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.ffF instanceof BdListView ? ((BdListView) this.ffF).getWrappedAdapter() : this.ffF.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.ffL != null && !bi(this.ffL.getVideoContainer())) {
                    this.ffL.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.ffF.getHeaderViewsCount() + this.ffF.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.ffF.getChildCount(); i5++) {
                        View childAt = this.ffF.getChildAt(z2 ? i5 : (this.ffF.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof s) {
                            s sVar = (s) childAt.getTag();
                            if (!z3 && bi(sVar.getVideoContainer())) {
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
                        if (i6 >= this.ffF.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.ffF.getChildAt(i6);
                        if (childAt2.getTag() instanceof s) {
                            s sVar2 = (s) childAt2.getTag();
                            if (sVar2.JS() && bi(sVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.ffF.getChildCount()) {
                            View childAt3 = this.ffF.getChildAt(i4);
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
                    while (i4 < this.ffF.getChildCount()) {
                        View childAt4 = this.ffF.getChildAt(z ? (this.ffF.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof s) {
                            s sVar3 = (s) childAt4.getTag();
                            if (!z5 && bi(sVar3.getVideoContainer())) {
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
            this.ffJ = view;
            if (i == 1 && (view.getTag() instanceof s)) {
                s sVar = (s) view.getTag();
                if (this.bWF && !sVar.JS()) {
                    sVar.JT();
                }
            } else if (i == 2 && (view.getTag() instanceof r)) {
                ((r) view.getTag()).Ll();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof s)) {
            ((s) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof r)) {
            ((r) view.getTag()).Lm();
        }
    }

    public boolean bi(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dLa && measuredHeight < this.ffE;
        }
        return false;
    }

    public void bj(View view) {
        if (view != null && !bi(view) && (view.getTag() instanceof s)) {
            ((s) view.getTag()).stopPlay();
        }
    }

    public void qO(int i) {
        if (this.ffF != null) {
            int headerViewsCount = this.ffF.getHeaderViewsCount() + i + 1;
            this.ffF.smoothScrollToPositionFromTop(headerViewsCount, this.ffI, 1000);
            if (this.aTp != null) {
                this.aTp.r(headerViewsCount, this.ffI, 1000);
            }
        }
    }

    public void qP(int i) {
        if (this.ffF != null) {
            int headerViewsCount = this.ffF.getHeaderViewsCount() + i;
            this.ffF.smoothScrollToPositionFromTop(headerViewsCount, this.ffI, 1000);
            if (this.aTp != null) {
                this.aTp.r(headerViewsCount, this.ffI, 1000);
            }
        }
    }

    public void destroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffN);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffO);
        bcJ();
    }

    public void qQ(int i) {
        this.ffH = i;
    }

    public void bcJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ffF.getChildCount()) {
                View childAt = this.ffF.getChildAt(i2);
                if (childAt.getTag() instanceof s) {
                    ((s) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String bcK() {
        return this.ffG;
    }

    public void qJ(String str) {
        this.ffG = str;
    }

    public int bcL() {
        return this.ffH;
    }

    public void bcM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ffF.getChildCount()) {
                View childAt = this.ffF.getChildAt(i2);
                if (childAt.getTag() instanceof s) {
                    s sVar = (s) childAt.getTag();
                    if (sVar.JS()) {
                        qQ(sVar.getCurrentPosition());
                        qJ(sVar.getPlayUrl());
                        this.ffJ = childAt;
                        this.ffK = sVar.isPlaying();
                        sVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bcN() {
        if (this.bWF) {
            if (this.ffJ != null && (this.ffJ.getTag() instanceof s)) {
                s sVar = (s) this.ffJ.getTag();
                if (this.ffK) {
                    sVar.JT();
                }
                if (this.ffJ.getTag() instanceof r) {
                    ((r) this.ffJ.getTag()).Ln();
                }
            }
            this.ffJ = null;
        }
    }

    public void aro() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffN);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffO);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ffF.getChildCount()) {
                View childAt = this.ffF.getChildAt(i2);
                if (childAt.getTag() instanceof s) {
                    s sVar = (s) childAt.getTag();
                    if (sVar.JS()) {
                        sVar.stopPlay();
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.ffO);
        this.ffO.qI(i);
        this.ffO.qJ(i2);
        this.ffO.dU(z);
        this.ffO.kw(z2);
        this.ffM.kw(z2);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.ffO, 500L);
    }

    public void ky(boolean z) {
        this.bWF = z;
    }

    public void qR(int i) {
        this.dLa = i;
    }
}
