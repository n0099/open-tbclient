package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class aa {
    private a aSG;
    private int eIW;
    private ListView eIX;
    private int eJa;
    private View eJb;
    private s eJd;
    private com.baidu.adp.base.h mContext;
    private int dpa = 0;
    private String eIY = null;
    private int eIZ = 0;
    private boolean eJc = false;
    private boolean bCP = true;
    private com.baidu.tieba.play.a eJf = new com.baidu.tieba.play.a();
    private final CustomMessageListener FT = new ab(this, 2000994);
    private b eJg = new b(this);
    private aq eJe = new aq();

    /* loaded from: classes.dex */
    public interface a {
        void r(int i, int i2, int i3);
    }

    public void a(a aVar) {
        this.aSG = aVar;
    }

    public void a(s sVar) {
        this.eJd = sVar;
    }

    public aa(com.baidu.adp.base.h hVar, ListView listView) {
        this.eIW = 0;
        this.eJa = 0;
        this.mContext = hVar;
        this.eIW = com.baidu.adp.lib.util.k.J(this.mContext.getPageActivity());
        this.eIX = listView;
        this.eJa = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        hVar.registerListener(this.FT);
    }

    public void pO(int i) {
        this.eIW = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.eJe.g(i, i2, z);
        if (this.eIX != null && this.eIX.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.eIX instanceof BdListView ? ((BdListView) this.eIX).getWrappedAdapter() : this.eIX.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.eJd != null && !bh(this.eJd.getVideoContainer())) {
                    this.eJd.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.eIX.getHeaderViewsCount() + this.eIX.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.eIX.getChildCount(); i5++) {
                        View childAt = this.eIX.getChildAt(z2 ? i5 : (this.eIX.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof s) {
                            s sVar = (s) childAt.getTag();
                            if (!z3 && bh(sVar.getVideoContainer())) {
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
                        if (i6 >= this.eIX.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.eIX.getChildAt(i6);
                        if (childAt2.getTag() instanceof s) {
                            s sVar2 = (s) childAt2.getTag();
                            if (sVar2.isPlayStarted() && bh(sVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.eIX.getChildCount()) {
                            View childAt3 = this.eIX.getChildAt(i4);
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
                    while (i4 < this.eIX.getChildCount()) {
                        View childAt4 = this.eIX.getChildAt(z ? (this.eIX.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof s) {
                            s sVar3 = (s) childAt4.getTag();
                            if (!z5 && bh(sVar3.getVideoContainer())) {
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
            this.eJb = view;
            if (i == 1 && (view.getTag() instanceof s)) {
                s sVar = (s) view.getTag();
                if (this.bCP && !sVar.isPlayStarted()) {
                    sVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof r)) {
                ((r) view.getTag()).KE();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof s)) {
            ((s) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof r)) {
            ((r) view.getTag()).KF();
        }
    }

    public boolean bh(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dpa && measuredHeight < this.eIW;
        }
        return false;
    }

    public void bi(View view) {
        if (view != null && !bh(view) && (view.getTag() instanceof s)) {
            ((s) view.getTag()).stopPlay();
        }
    }

    public void pP(int i) {
        if (this.eIX != null) {
            int headerViewsCount = this.eIX.getHeaderViewsCount() + i + 1;
            this.eIX.smoothScrollToPositionFromTop(headerViewsCount, this.eJa, 1000);
            if (this.aSG != null) {
                this.aSG.r(headerViewsCount, this.eJa, 1000);
            }
        }
    }

    public void pQ(int i) {
        if (this.eIX != null) {
            int headerViewsCount = this.eIX.getHeaderViewsCount() + i;
            this.eIX.smoothScrollToPositionFromTop(headerViewsCount, this.eJa, 1000);
            if (this.aSG != null) {
                this.aSG.r(headerViewsCount, this.eJa, 1000);
            }
        }
    }

    public void destroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJf);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJg);
        aWq();
    }

    public void pR(int i) {
        this.eIZ = i;
    }

    public void aWq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIX.getChildCount()) {
                View childAt = this.eIX.getChildAt(i2);
                if (childAt.getTag() instanceof s) {
                    ((s) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String aWr() {
        return this.eIY;
    }

    public void pl(String str) {
        this.eIY = str;
    }

    public int aWs() {
        return this.eIZ;
    }

    public void aWt() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIX.getChildCount()) {
                View childAt = this.eIX.getChildAt(i2);
                if (childAt.getTag() instanceof s) {
                    s sVar = (s) childAt.getTag();
                    if (sVar.isPlayStarted()) {
                        pR(sVar.getCurrentPosition());
                        pl(sVar.getPlayUrl());
                        this.eJb = childAt;
                        this.eJc = sVar.isPlaying();
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

    public void aWu() {
        if (this.bCP) {
            if (this.eJb != null && (this.eJb.getTag() instanceof s)) {
                s sVar = (s) this.eJb.getTag();
                if (this.eJc) {
                    sVar.startPlay();
                }
                if (this.eJb.getTag() instanceof r) {
                    ((r) this.eJb.getTag()).KG();
                }
            }
            this.eJb = null;
        }
    }

    public void alQ() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJf);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eIX.getChildCount()) {
                View childAt = this.eIX.getChildAt(i2);
                if (childAt.getTag() instanceof s) {
                    s sVar = (s) childAt.getTag();
                    if (sVar.isPlayStarted()) {
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eJg);
        this.eJg.pJ(i);
        this.eJg.pK(i2);
        this.eJg.dC(z);
        this.eJg.kg(z2);
        this.eJe.kg(z2);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eJg, 500L);
    }

    public void ki(boolean z) {
        this.bCP = z;
    }

    public void pS(int i) {
        this.dpa = i;
    }
}
