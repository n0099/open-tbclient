package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class k {
    private a aRo;
    private int eYr;
    private ListView eYs;
    private int eYv;
    private View eYw;
    private d eYy;
    private x eYz;
    private com.baidu.adp.base.h mContext;
    private int dFn = 0;
    private String eYt = null;
    private int eYu = 0;
    private boolean eYx = false;
    private boolean eYA = true;
    private com.baidu.tieba.play.a eYB = new com.baidu.tieba.play.a();
    private AbsListView.RecyclerListener eYC = new l(this);
    private final CustomMessageListener FQ = new m(this, 2000994);
    private b eYD = new b(this);

    /* loaded from: classes.dex */
    public interface a {
        void s(int i, int i2, int i3);
    }

    public void a(a aVar) {
        this.aRo = aVar;
    }

    public void a(d dVar) {
        this.eYy = dVar;
    }

    public k(com.baidu.adp.base.h hVar, ListView listView) {
        this.eYr = 0;
        this.eYv = 0;
        this.mContext = hVar;
        this.eYr = com.baidu.adp.lib.util.k.L(this.mContext.getPageActivity());
        this.eYs = listView;
        this.eYs.setRecyclerListener(this.eYC);
        this.eYv = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eYz = new x();
        hVar.registerListener(this.FQ);
    }

    public void qx(int i) {
        this.eYr = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i4 = 0;
        this.eYz.g(i, i2, z);
        if (this.eYs != null && this.eYs.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.eYs instanceof BdListView ? ((BdListView) this.eYs).getWrappedAdapter() : this.eYs.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.eYy != null && !bg(this.eYy.getVideoContainer())) {
                    this.eYy.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.eYs.getHeaderViewsCount() + this.eYs.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.eYs.getChildCount(); i5++) {
                        View childAt = this.eYs.getChildAt(z2 ? i5 : (this.eYs.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof d) {
                            d dVar = (d) childAt.getTag();
                            if (!z3 && bg(dVar.getVideoContainer())) {
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
                        if (i6 >= this.eYs.getChildCount()) {
                            z4 = false;
                            break;
                        }
                        View childAt2 = this.eYs.getChildAt(i6);
                        if (childAt2.getTag() instanceof d) {
                            d dVar2 = (d) childAt2.getTag();
                            if (dVar2.Jr() && bg(dVar2.getVideoContainer())) {
                                z4 = true;
                                break;
                            }
                        }
                        i6++;
                    }
                    if (z4) {
                        while (i4 < this.eYs.getChildCount()) {
                            View childAt3 = this.eYs.getChildAt(i4);
                            if (childAt3.getTag() instanceof d) {
                                d dVar3 = (d) childAt3.getTag();
                                if (dVar3.Jr() && bg(dVar3.getVideoContainer())) {
                                    f(i3, childAt3);
                                } else {
                                    g(i3, childAt3);
                                }
                            }
                            i4++;
                        }
                        return;
                    }
                    boolean z6 = false;
                    while (i4 < this.eYs.getChildCount()) {
                        View childAt4 = this.eYs.getChildAt(z ? (this.eYs.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof d) {
                            d dVar4 = (d) childAt4.getTag();
                            if (!z6 && bg(dVar4.getVideoContainer())) {
                                f(i3, childAt4);
                                z5 = true;
                                i4++;
                                z6 = z5;
                            } else {
                                g(i3, childAt4);
                            }
                        }
                        z5 = z6;
                        i4++;
                        z6 = z5;
                    }
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            this.eYw = view;
            if (i == 1 && (view.getTag() instanceof d)) {
                d dVar = (d) view.getTag();
                if (this.eYA && !dVar.Jr()) {
                    dVar.Js();
                }
            } else if (i == 2 && (view.getTag() instanceof c)) {
                ((c) view.getTag()).KI();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof c)) {
            ((c) view.getTag()).KJ();
        }
    }

    public boolean bg(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dFn && measuredHeight < this.eYr;
        }
        return false;
    }

    public void qy(int i) {
        if (this.eYs != null) {
            int headerViewsCount = this.eYs.getHeaderViewsCount() + i + 1;
            this.eYs.smoothScrollToPositionFromTop(headerViewsCount, this.eYv, 1000);
            if (this.aRo != null) {
                this.aRo.s(headerViewsCount, this.eYv, 1000);
            }
        }
    }

    public void qz(int i) {
        if (this.eYs != null) {
            int headerViewsCount = this.eYs.getHeaderViewsCount() + i;
            this.eYs.smoothScrollToPositionFromTop(headerViewsCount, this.eYv, 1000);
            if (this.aRo != null) {
                this.aRo.s(headerViewsCount, this.eYv, 1000);
            }
        }
    }

    public void destroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eYB);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eYD);
        bak();
    }

    public void qA(int i) {
        this.eYu = i;
    }

    public void bak() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eYs.getChildCount()) {
                View childAt = this.eYs.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    ((d) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String bal() {
        return this.eYt;
    }

    public void qu(String str) {
        this.eYt = str;
    }

    public int bam() {
        return this.eYu;
    }

    public void ban() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eYs.getChildCount()) {
                View childAt = this.eYs.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.Jr()) {
                        qA(dVar.getCurrentPosition());
                        qu(dVar.getPlayUrl());
                        this.eYw = childAt;
                        this.eYx = dVar.isPlaying();
                        dVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bao() {
        if (this.eYw != null && (this.eYw.getTag() instanceof d)) {
            d dVar = (d) this.eYw.getTag();
            if (this.eYx) {
                dVar.Js();
            }
            if (this.eYw.getTag() instanceof c) {
                ((c) this.eYw.getTag()).KK();
            }
        }
        this.eYw = null;
    }

    public void bap() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eYB);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eYD);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eYs.getChildCount()) {
                View childAt = this.eYs.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.Jr()) {
                        dVar.stopPlay();
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eYD);
        this.eYD.qv(i);
        this.eYD.qw(i2);
        this.eYD.dN(z);
        this.eYD.jW(z2);
        this.eYz.jW(z2);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eYD, 500L);
    }

    public void jX(boolean z) {
        this.eYA = z;
    }

    public void qB(int i) {
        this.dFn = i;
    }
}
