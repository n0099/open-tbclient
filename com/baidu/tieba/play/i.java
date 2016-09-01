package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.view.au;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private a aQf;
    private ListView eWm;
    private int eWp;
    private boolean eWq;
    private View eWr;
    private d eWt;
    private l eWu;
    private com.baidu.adp.base.h mContext;
    private int mScreenHeight;
    private int dDu = 0;
    private String eWn = null;
    private int eWo = 0;
    private boolean eWs = false;
    private boolean eWv = true;
    private com.baidu.tieba.play.a eWw = new com.baidu.tieba.play.a();
    private AbsListView.RecyclerListener eWx = new j(this);
    private final CustomMessageListener FQ = new k(this, 2000994);
    private b eWy = new b(this);

    /* loaded from: classes.dex */
    public interface a {
        void q(int i, int i2, int i3);
    }

    public void a(a aVar) {
        this.aQf = aVar;
    }

    public void a(d dVar) {
        this.eWt = dVar;
    }

    public i(com.baidu.adp.base.h hVar, ListView listView) {
        this.mScreenHeight = 0;
        this.eWp = 0;
        this.eWq = true;
        this.mContext = hVar;
        this.mScreenHeight = com.baidu.adp.lib.util.k.L(this.mContext.getPageActivity());
        this.eWm = listView;
        this.eWm.setRecyclerListener(this.eWx);
        this.eWp = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eWu = new l();
        hVar.registerListener(this.FQ);
        this.eWq = au.wK().wQ() ? false : true;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i4 = 0;
        this.eWu.g(i, i2, z);
        if (this.eWm != null && this.eWm.getChildCount() != 0 && this.eWm.getAdapter() != null && this.eWm.getAdapter().getCount() != 0) {
            if (this.eWt != null && !bi(this.eWt.getVideoContainer())) {
                this.eWt.stopPlay();
            }
            int count = this.eWm.getAdapter().getCount() + this.eWm.getHeaderViewsCount() + this.eWm.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == count + (-1) ? false : false;
            }
            if (i == 0 || i2 == count - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.eWm.getChildCount(); i5++) {
                    View childAt = this.eWm.getChildAt(z2 ? i5 : (this.eWm.getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof d) {
                        d dVar = (d) childAt.getTag();
                        if (!z3 && bi(dVar.getVideoContainer())) {
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
                    if (i6 >= this.eWm.getChildCount()) {
                        z4 = false;
                        break;
                    }
                    View childAt2 = this.eWm.getChildAt(i6);
                    if (childAt2.getTag() instanceof d) {
                        d dVar2 = (d) childAt2.getTag();
                        if (dVar2.KA() && bi(dVar2.getVideoContainer())) {
                            z4 = true;
                            break;
                        }
                    }
                    i6++;
                }
                if (z4) {
                    while (i4 < this.eWm.getChildCount()) {
                        View childAt3 = this.eWm.getChildAt(i4);
                        if (childAt3.getTag() instanceof d) {
                            d dVar3 = (d) childAt3.getTag();
                            if (dVar3.KA() && bi(dVar3.getVideoContainer())) {
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
                while (i4 < this.eWm.getChildCount()) {
                    View childAt4 = this.eWm.getChildAt(z ? (this.eWm.getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof d) {
                        d dVar4 = (d) childAt4.getTag();
                        if (!z6 && bi(dVar4.getVideoContainer())) {
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

    private void f(int i, View view) {
        if (view != null) {
            if (i == 1 && (view.getTag() instanceof d)) {
                if (aZO()) {
                    d dVar = (d) view.getTag();
                    if (this.eWv) {
                        dVar.Kz();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eWw);
                this.eWw.bh(view);
                com.baidu.adp.lib.h.h.eG().postDelayed(this.eWw, 800L);
            } else if (i == 2 && (view.getTag() instanceof c)) {
                ((c) view.getTag()).JW();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof c)) {
            ((c) view.getTag()).JX();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dDu && measuredHeight < this.mScreenHeight;
        }
        return false;
    }

    public void qm(int i) {
        if (this.eWm != null) {
            int headerViewsCount = this.eWm.getHeaderViewsCount() + i + 1;
            this.eWm.smoothScrollToPositionFromTop(headerViewsCount, this.eWp, 1000);
            if (this.aQf != null) {
                this.aQf.q(headerViewsCount, this.eWp, 1000);
            }
        }
    }

    public void qn(int i) {
        if (this.eWm != null) {
            int headerViewsCount = this.eWm.getHeaderViewsCount() + i;
            this.eWm.smoothScrollToPositionFromTop(headerViewsCount, this.eWp, 1000);
            if (this.aQf != null) {
                this.aQf.q(headerViewsCount, this.eWp, 1000);
            }
        }
    }

    public void destroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eWw);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eWy);
        aZL();
    }

    public void qo(int i) {
        this.eWo = i;
    }

    public void aZL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eWm.getChildCount()) {
                View childAt = this.eWm.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    ((d) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String aZM() {
        return this.eWn;
    }

    public void qi(String str) {
        this.eWn = str;
    }

    public int aZN() {
        return this.eWo;
    }

    private boolean aZO() {
        return this.eWq;
    }

    public void aZP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eWm.getChildCount()) {
                View childAt = this.eWm.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.KA()) {
                        qo(dVar.getCurrentPosition());
                        qi(dVar.getPlayUrl());
                        this.eWr = childAt;
                        this.eWs = dVar.isPlaying();
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

    public void aZQ() {
        if (this.eWr != null && (this.eWr.getTag() instanceof d)) {
            d dVar = (d) this.eWr.getTag();
            if (this.eWs) {
                dVar.Kz();
            }
            if (this.eWr.getTag() instanceof c) {
                ((c) this.eWr.getTag()).JY();
            }
        }
        this.eWr = null;
    }

    public void aZR() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eWw);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eWy);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eWm.getChildCount()) {
                View childAt = this.eWm.getChildAt(i2);
                if (childAt.getTag() instanceof d) {
                    d dVar = (d) childAt.getTag();
                    if (dVar.KA()) {
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.eWy);
        this.eWy.qk(i);
        this.eWy.ql(i2);
        this.eWy.dM(z);
        this.eWy.jT(z2);
        this.eWu.jT(z2);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.eWy, 500L);
    }

    public void jU(boolean z) {
        this.eWv = z;
    }
}
