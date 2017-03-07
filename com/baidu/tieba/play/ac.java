package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class ac {
    private int bhi;
    private ListView dzF;
    private int dzJ;
    private View dzK;
    private u dzM;
    private com.baidu.adp.base.g mContext;
    private int dzE = 0;
    private String dzG = null;
    private int dzH = 0;
    private boolean dzL = false;
    private boolean dzO = true;
    private a dzP = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b eWf = new b(this);
    private as dzN = new as();

    public void a(u uVar) {
        this.dzM = uVar;
    }

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.bhi = 0;
        this.dzJ = 0;
        this.mContext = gVar;
        this.bhi = com.baidu.adp.lib.util.k.ah(this.mContext.getPageActivity());
        this.dzF = listView;
        this.dzJ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        gVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void qy(int i) {
        this.bhi = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dzN.g(i, i2, z);
        if (this.dzF != null && this.dzF.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dzF instanceof BdListView ? ((BdListView) this.dzF).getWrappedAdapter() : this.dzF.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dzM != null && !aO(this.dzM.getVideoContainer())) {
                    this.dzM.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dzF.getHeaderViewsCount() + this.dzF.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dzF.getChildCount(); i5++) {
                        View childAt = this.dzF.getChildAt(z2 ? i5 : (this.dzF.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof u) {
                            u uVar = (u) childAt.getTag();
                            if (!z3 && aO(uVar.getVideoContainer())) {
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
                        if (i6 >= this.dzF.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dzF.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aO(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dzF.getChildCount()) {
                            View childAt3 = this.dzF.getChildAt(i4);
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
                    while (i4 < this.dzF.getChildCount()) {
                        View childAt4 = this.dzF.getChildAt(z ? (this.dzF.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof u) {
                            u uVar3 = (u) childAt4.getTag();
                            if (!z5 && aO(uVar3.getVideoContainer())) {
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
            this.dzK = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dzO && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).ayt();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).ayu();
        }
    }

    public boolean aO(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dzE && measuredHeight < this.bhi;
        }
        return false;
    }

    public void aP(View view) {
        if (view != null && !aO(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dzP);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.eWf);
        azf();
    }

    public void mz(int i) {
        this.dzH = i;
    }

    public void azf() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dzF.getChildCount()) {
                View childAt = this.dzF.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void lv(String str) {
        this.dzG = str;
    }

    public void azi() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dzF.getChildCount()) {
                View childAt = this.dzF.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        mz(uVar.getCurrentPosition());
                        lv(uVar.getPlayUrl());
                        this.dzK = childAt;
                        this.dzL = uVar.isPlaying();
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

    public void azj() {
        if (this.dzO) {
            if (this.dzK != null && (this.dzK.getTag() instanceof u)) {
                u uVar = (u) this.dzK.getTag();
                if (this.dzL) {
                    uVar.startPlay();
                }
                if (this.dzK.getTag() instanceof t) {
                    ((t) this.dzK.getTag()).ayv();
                }
            }
            this.dzK = null;
        }
    }

    public void alL() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.dzP);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.eWf);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dzF.getChildCount()) {
                View childAt = this.dzF.getChildAt(i2);
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
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.eWf);
        this.eWf.mx(i);
        this.eWf.my(i2);
        this.eWf.dI(z);
        this.eWf.gM(z2);
        this.dzN.gM(z2);
        com.baidu.adp.lib.g.h.fM().postDelayed(this.eWf, 500L);
    }

    public void gP(boolean z) {
        this.dzO = z;
    }

    public void qz(int i) {
        this.dzE = i;
    }
}
