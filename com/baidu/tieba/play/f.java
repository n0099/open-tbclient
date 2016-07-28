package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.view.at;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class f {
    private ListView ePe;
    private int ePh;
    private boolean ePi;
    private View ePj;
    private d ePl;
    private i ePm;
    private com.baidu.adp.base.h mContext;
    private int mScreenHeight;
    private int drI = 0;
    private String ePf = null;
    private int ePg = 0;
    private boolean ePk = false;
    private boolean ePn = true;
    private a ePo = new a();
    private AbsListView.RecyclerListener ePp = new g(this);
    private final CustomMessageListener DE = new h(this, 2000994);
    private b ePq = new b(this);

    public f(com.baidu.adp.base.h hVar, ListView listView) {
        this.mScreenHeight = 0;
        this.ePh = 0;
        this.ePi = true;
        this.mContext = hVar;
        this.mScreenHeight = com.baidu.adp.lib.util.k.B(this.mContext.getPageActivity());
        this.ePe = listView;
        this.ePe.setRecyclerListener(this.ePp);
        this.ePh = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ePm = new i();
        hVar.registerListener(this.DE);
        this.ePi = at.vG().vM() ? false : true;
    }

    public void a(d dVar) {
        this.ePl = dVar;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.ePm.b(i, i2, z, i3);
        if (this.ePe != null && this.ePe.getChildCount() != 0 && this.ePe.getAdapter() != null && this.ePe.getAdapter().getCount() != 0) {
            if (this.ePl != null && !bk(this.ePl.getVideoContainer())) {
                this.ePl.stopPlay();
            }
            int count = this.ePe.getAdapter().getCount() + this.ePe.getHeaderViewsCount() + this.ePe.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == count + (-1) ? false : false;
            }
            if (i == 0 || i2 == count - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.ePe.getChildCount(); i5++) {
                    View childAt = this.ePe.getChildAt(z2 ? i5 : (this.ePe.getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof d) {
                        d dVar = (d) childAt.getTag();
                        if (!z3 && bk(dVar.getVideoContainer())) {
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
                boolean z5 = false;
                for (int i6 = 0; i6 < this.ePe.getChildCount(); i6++) {
                    View childAt2 = this.ePe.getChildAt(i6);
                    if (childAt2.getTag() instanceof d) {
                        d dVar2 = (d) childAt2.getTag();
                        if (z5) {
                            g(i3, childAt2);
                        }
                        if (dVar2.IA() && bk(dVar2.getVideoContainer())) {
                            f(i3, childAt2);
                            z5 = true;
                        }
                    }
                }
                if (!z5) {
                    boolean z6 = false;
                    while (i4 < this.ePe.getChildCount()) {
                        View childAt3 = this.ePe.getChildAt(z ? (this.ePe.getChildCount() - 1) - i4 : i4);
                        if (childAt3.getTag() instanceof d) {
                            d dVar3 = (d) childAt3.getTag();
                            if (!z6 && bk(dVar3.getVideoContainer())) {
                                f(i3, childAt3);
                                z4 = true;
                                i4++;
                                z6 = z4;
                            } else {
                                g(i3, childAt3);
                            }
                        }
                        z4 = z6;
                        i4++;
                        z6 = z4;
                    }
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (i == 1 && (view.getTag() instanceof d)) {
                if (aWy()) {
                    d dVar = (d) view.getTag();
                    if (this.ePn) {
                        dVar.Iz();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ePo);
                this.ePo.bj(view);
                com.baidu.adp.lib.h.h.dL().postDelayed(this.ePo, 800L);
            } else if (i == 2 && (view.getTag() instanceof c)) {
                ((c) view.getTag()).HY();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof c)) {
            ((c) view.getTag()).HZ();
        }
    }

    public boolean bk(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.drI && measuredHeight < this.mScreenHeight;
        }
        return false;
    }

    public void pN(int i) {
        if (this.ePe != null) {
            this.ePe.smoothScrollToPositionFromTop(this.ePe.getHeaderViewsCount() + i + 1, this.ePh, 1000);
        }
    }

    public void pO(int i) {
        if (this.ePe != null) {
            this.ePe.smoothScrollToPositionFromTop(this.ePe.getHeaderViewsCount() + i, this.ePh, 1000);
        }
    }

    public void destroy() {
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ePo);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ePq);
    }

    public String aWw() {
        return this.ePf;
    }

    public void pz(String str) {
        this.ePf = str;
    }

    public int aWx() {
        return this.ePg;
    }

    public void pP(int i) {
        this.ePg = i;
    }

    private boolean aWy() {
        return this.ePi;
    }

    public void aWz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ePe.getChildCount()) {
                View childAt = this.ePe.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.IA()) {
                        pP(dVar.getCurrentPosition());
                        pz(dVar.getPlayUrl());
                        this.ePj = childAt;
                        this.ePk = dVar.isPlaying();
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

    public void aWA() {
        if (this.ePj != null && (this.ePj.getTag() instanceof d)) {
            d dVar = (d) this.ePj.getTag();
            if (this.ePk) {
                dVar.Iz();
            }
            if (this.ePj.getTag() instanceof c) {
                ((c) this.ePj.getTag()).Ia();
            }
        }
        this.ePj = null;
    }

    public void aWB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ePe.getChildCount()) {
                View childAt = this.ePe.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.IA()) {
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
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.ePq);
        this.ePq.pL(i);
        this.ePq.pM(i2);
        this.ePq.m20do(z);
        this.ePq.jF(z2);
        com.baidu.adp.lib.h.h.dL().postDelayed(this.ePq, 500L);
    }

    public void jG(boolean z) {
        this.ePn = z;
    }
}
