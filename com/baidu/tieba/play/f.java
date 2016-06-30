package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.view.at;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class f {
    private boolean eDA;
    private View eDB;
    private d eDD;
    private i eDE;
    private ListView eDw;
    private int eDz;
    private com.baidu.adp.base.h mContext;
    private int mScreenHeight;
    private int doz = 0;
    private String eDx = null;
    private int eDy = 0;
    private boolean eDC = false;
    private a eDF = new a();
    private AbsListView.RecyclerListener eDG = new g(this);
    private final CustomMessageListener Dd = new h(this, 2000994);
    private b eDH = new b(this);

    public f(com.baidu.adp.base.h hVar, ListView listView) {
        this.mScreenHeight = 0;
        this.eDz = 0;
        this.eDA = true;
        this.mContext = hVar;
        this.mScreenHeight = com.baidu.adp.lib.util.k.B(this.mContext.getPageActivity());
        this.eDw = listView;
        this.eDw.setRecyclerListener(this.eDG);
        this.eDz = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eDE = new i();
        hVar.registerListener(this.Dd);
        this.eDA = at.vG().vM() ? false : true;
    }

    public void a(d dVar) {
        this.eDD = dVar;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.eDE.b(i, i2, z, i3);
        if (this.eDw != null && this.eDw.getChildCount() != 0 && this.eDw.getAdapter() != null && this.eDw.getAdapter().getCount() != 0) {
            if (this.eDD != null && !bl(this.eDD.getVideoContainer())) {
                this.eDD.stopPlay();
            }
            int count = this.eDw.getAdapter().getCount() + this.eDw.getHeaderViewsCount() + this.eDw.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == count + (-1) ? false : false;
            }
            if (i == 0 || i2 == count - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.eDw.getChildCount(); i5++) {
                    View childAt = this.eDw.getChildAt(z2 ? i5 : (this.eDw.getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof d) {
                        d dVar = (d) childAt.getTag();
                        if (!z3 && bl(dVar.getVideoContainer())) {
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
                for (int i6 = 0; i6 < this.eDw.getChildCount(); i6++) {
                    View childAt2 = this.eDw.getChildAt(i6);
                    if (childAt2.getTag() instanceof d) {
                        d dVar2 = (d) childAt2.getTag();
                        if (z5) {
                            g(i3, childAt2);
                        }
                        if (dVar2.IB() && bl(dVar2.getVideoContainer())) {
                            f(i3, childAt2);
                            z5 = true;
                        }
                    }
                }
                if (!z5) {
                    boolean z6 = false;
                    while (i4 < this.eDw.getChildCount()) {
                        View childAt3 = this.eDw.getChildAt(z ? (this.eDw.getChildCount() - 1) - i4 : i4);
                        if (childAt3.getTag() instanceof d) {
                            d dVar3 = (d) childAt3.getTag();
                            if (!z6 && bl(dVar3.getVideoContainer())) {
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
                if (aTv()) {
                    ((d) view.getTag()).IA();
                    return;
                }
                com.baidu.adp.lib.h.h.dM().removeCallbacks(this.eDF);
                this.eDF.bk(view);
                com.baidu.adp.lib.h.h.dM().postDelayed(this.eDF, 800L);
            } else if (i == 2 && (view.getTag() instanceof c)) {
                ((c) view.getTag()).Ia();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof c)) {
            ((c) view.getTag()).Ib();
        }
    }

    public boolean bl(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.doz && measuredHeight < this.mScreenHeight;
    }

    public void px(int i) {
        if (this.eDw != null) {
            this.eDw.smoothScrollToPositionFromTop(this.eDw.getHeaderViewsCount() + i + 1, this.eDz, 1000);
        }
    }

    public void py(int i) {
        if (this.eDw != null) {
            this.eDw.smoothScrollToPositionFromTop(this.eDw.getHeaderViewsCount() + i, this.eDz, 1000);
        }
    }

    public void destroy() {
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.eDF);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.eDH);
    }

    public String aTt() {
        return this.eDx;
    }

    public void oO(String str) {
        this.eDx = str;
    }

    public int aTu() {
        return this.eDy;
    }

    public void pz(int i) {
        this.eDy = i;
    }

    private boolean aTv() {
        return this.eDA;
    }

    public void aTw() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eDw.getChildCount()) {
                View childAt = this.eDw.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.IB()) {
                        pz(dVar.getCurrentPosition());
                        oO(dVar.getPlayUrl());
                        this.eDB = childAt;
                        this.eDC = dVar.isPlaying();
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

    public void aTx() {
        if (this.eDB != null && (this.eDB.getTag() instanceof d)) {
            d dVar = (d) this.eDB.getTag();
            if (this.eDC) {
                dVar.IA();
            }
            if (this.eDB.getTag() instanceof c) {
                ((c) this.eDB.getTag()).Ic();
            }
        }
        this.eDB = null;
    }

    public void aTy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eDw.getChildCount()) {
                View childAt = this.eDw.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.IB()) {
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
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.eDH);
        this.eDH.pv(i);
        this.eDH.pw(i2);
        this.eDH.dr(z);
        this.eDH.jz(z2);
        com.baidu.adp.lib.h.h.dM().postDelayed(this.eDH, 500L);
    }
}
