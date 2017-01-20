package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class ac {
    private int bay;
    private ListView dxh;
    private int dxl;
    private View dxm;
    private u dxo;
    private com.baidu.adp.base.g mContext;
    private int dxg = 0;
    private String dxi = null;
    private int dxj = 0;
    private boolean dxn = false;
    private boolean dxq = true;
    private a dxr = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b eSy = new b(this);
    private as dxp = new as();

    public void a(u uVar) {
        this.dxo = uVar;
    }

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.bay = 0;
        this.dxl = 0;
        this.mContext = gVar;
        this.bay = com.baidu.adp.lib.util.k.J(this.mContext.getPageActivity());
        this.dxh = listView;
        this.dxl = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        gVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void qB(int i) {
        this.bay = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dxp.g(i, i2, z);
        if (this.dxh != null && this.dxh.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dxh instanceof BdListView ? ((BdListView) this.dxh).getWrappedAdapter() : this.dxh.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dxo != null && !aQ(this.dxo.getVideoContainer())) {
                    this.dxo.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dxh.getHeaderViewsCount() + this.dxh.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dxh.getChildCount(); i5++) {
                        View childAt = this.dxh.getChildAt(z2 ? i5 : (this.dxh.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof u) {
                            u uVar = (u) childAt.getTag();
                            if (!z3 && aQ(uVar.getVideoContainer())) {
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
                        if (i6 >= this.dxh.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dxh.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aQ(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dxh.getChildCount()) {
                            View childAt3 = this.dxh.getChildAt(i4);
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
                    while (i4 < this.dxh.getChildCount()) {
                        View childAt4 = this.dxh.getChildAt(z ? (this.dxh.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof u) {
                            u uVar3 = (u) childAt4.getTag();
                            if (!z5 && aQ(uVar3.getVideoContainer())) {
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
            this.dxm = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dxq && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).ayX();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).ayY();
        }
    }

    public boolean aQ(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dxg && measuredHeight < this.bay;
        }
        return false;
    }

    public void aR(View view) {
        if (view != null && !aQ(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dxr);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.eSy);
        azH();
    }

    public void mJ(int i) {
        this.dxj = i;
    }

    public void azH() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dxh.getChildCount()) {
                View childAt = this.dxh.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void lT(String str) {
        this.dxi = str;
    }

    public void azK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dxh.getChildCount()) {
                View childAt = this.dxh.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        mJ(uVar.getCurrentPosition());
                        lT(uVar.getPlayUrl());
                        this.dxm = childAt;
                        this.dxn = uVar.isPlaying();
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

    public void azL() {
        if (this.dxq) {
            if (this.dxm != null && (this.dxm.getTag() instanceof u)) {
                u uVar = (u) this.dxm.getTag();
                if (this.dxn) {
                    uVar.startPlay();
                }
                if (this.dxm.getTag() instanceof t) {
                    ((t) this.dxm.getTag()).ayZ();
                }
            }
            this.dxm = null;
        }
    }

    public void amY() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.dxr);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.eSy);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dxh.getChildCount()) {
                View childAt = this.dxh.getChildAt(i2);
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
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.eSy);
        this.eSy.mH(i);
        this.eSy.mI(i2);
        this.eSy.dI(z);
        this.eSy.gV(z2);
        this.dxp.gV(z2);
        com.baidu.adp.lib.g.h.eE().postDelayed(this.eSy, 500L);
    }

    public void gY(boolean z) {
        this.dxq = z;
    }

    public void qC(int i) {
        this.dxg = i;
    }
}
