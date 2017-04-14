package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class ac {
    private int bhc;
    private ListView dwc;
    private int dwg;
    private View dwh;
    private u dwj;
    private com.baidu.adp.base.g mContext;
    private int dwb = 0;
    private String dwd = null;
    private int dwe = 0;
    private boolean dwi = false;
    private boolean dwl = true;
    private a dwm = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b eUe = new b(this);
    private as dwk = new as();

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.bhc = 0;
        this.dwg = 0;
        this.mContext = gVar;
        this.bhc = com.baidu.adp.lib.util.k.ag(this.mContext.getPageActivity());
        this.dwc = listView;
        this.dwg = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        gVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void qw(int i) {
        this.bhc = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dwk.g(i, i2, z);
        if (this.dwc != null && this.dwc.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dwc instanceof BdListView ? ((BdListView) this.dwc).getWrappedAdapter() : this.dwc.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dwj != null && !aM(this.dwj.getVideoContainer())) {
                    this.dwj.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dwc.getHeaderViewsCount() + this.dwc.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dwc.getChildCount(); i5++) {
                        View childAt = this.dwc.getChildAt(z2 ? i5 : (this.dwc.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof u) {
                            u uVar = (u) childAt.getTag();
                            if (!z3 && aM(uVar.getVideoContainer())) {
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
                        if (i6 >= this.dwc.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dwc.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aM(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dwc.getChildCount()) {
                            View childAt3 = this.dwc.getChildAt(i4);
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
                    while (i4 < this.dwc.getChildCount()) {
                        View childAt4 = this.dwc.getChildAt(z ? (this.dwc.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof u) {
                            u uVar3 = (u) childAt4.getTag();
                            if (!z5 && aM(uVar3.getVideoContainer())) {
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
            this.dwh = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dwl && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).ayc();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).ayd();
        }
    }

    public boolean aM(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dwb && measuredHeight < this.bhc;
        }
        return false;
    }

    public void aN(View view) {
        if (view != null && !aM(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dwm);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eUe);
        ayJ();
    }

    public void mE(int i) {
        this.dwe = i;
    }

    public void ayJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dwc.getChildCount()) {
                View childAt = this.dwc.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ly(String str) {
        this.dwd = str;
    }

    public void ayM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dwc.getChildCount()) {
                View childAt = this.dwc.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        mE(uVar.getCurrentPosition());
                        ly(uVar.getPlayUrl());
                        this.dwh = childAt;
                        this.dwi = uVar.isPlaying();
                        uVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ayN() {
        if (this.dwl) {
            if (this.dwh != null && (this.dwh.getTag() instanceof u)) {
                u uVar = (u) this.dwh.getTag();
                if (this.dwi) {
                    uVar.startPlay();
                }
                if (this.dwh.getTag() instanceof t) {
                    ((t) this.dwh.getTag()).aye();
                }
            }
            this.dwh = null;
        }
    }

    public void alF() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dwm);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eUe);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dwc.getChildCount()) {
                View childAt = this.dwc.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        uVar.stopPlay();
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
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.eUe);
        this.eUe.mw(i);
        this.eUe.mx(i2);
        this.eUe.dK(z);
        this.eUe.gM(z2);
        this.dwk.gM(z2);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.eUe, 500L);
    }

    public void gO(boolean z) {
        this.dwl = z;
    }

    public void qx(int i) {
        this.dwb = i;
    }
}
