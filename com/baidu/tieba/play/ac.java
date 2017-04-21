package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class ac {
    private int bjn;
    private ListView dys;
    private int dyw;
    private View dyx;
    private u dyz;
    private com.baidu.adp.base.g mContext;
    private int dyr = 0;
    private String dyt = null;
    private int dyu = 0;
    private boolean dyy = false;
    private boolean dyB = true;
    private a dyC = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b eWu = new b(this);
    private as dyA = new as();

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.bjn = 0;
        this.dyw = 0;
        this.mContext = gVar;
        this.bjn = com.baidu.adp.lib.util.k.ag(this.mContext.getPageActivity());
        this.dys = listView;
        this.dyw = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        gVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void qC(int i) {
        this.bjn = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dyA.g(i, i2, z);
        if (this.dys != null && this.dys.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dys instanceof BdListView ? ((BdListView) this.dys).getWrappedAdapter() : this.dys.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dyz != null && !aM(this.dyz.getVideoContainer())) {
                    this.dyz.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dys.getHeaderViewsCount() + this.dys.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dys.getChildCount(); i5++) {
                        View childAt = this.dys.getChildAt(z2 ? i5 : (this.dys.getChildCount() - 1) - i5);
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
                        if (i6 >= this.dys.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dys.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aM(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dys.getChildCount()) {
                            View childAt3 = this.dys.getChildAt(i4);
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
                    while (i4 < this.dys.getChildCount()) {
                        View childAt4 = this.dys.getChildAt(z ? (this.dys.getChildCount() - 1) - i4 : i4);
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
            this.dyx = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dyB && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).azd();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).aze();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dyr && measuredHeight < this.bjn;
        }
        return false;
    }

    public void aN(View view) {
        if (view != null && !aM(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dyC);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eWu);
        azK();
    }

    public void mK(int i) {
        this.dyu = i;
    }

    public void azK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dys.getChildCount()) {
                View childAt = this.dys.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void lz(String str) {
        this.dyt = str;
    }

    public void azN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dys.getChildCount()) {
                View childAt = this.dys.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        mK(uVar.getCurrentPosition());
                        lz(uVar.getPlayUrl());
                        this.dyx = childAt;
                        this.dyy = uVar.isPlaying();
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

    public void azO() {
        if (this.dyB) {
            if (this.dyx != null && (this.dyx.getTag() instanceof u)) {
                u uVar = (u) this.dyx.getTag();
                if (this.dyy) {
                    uVar.startPlay();
                }
                if (this.dyx.getTag() instanceof t) {
                    ((t) this.dyx.getTag()).azf();
                }
            }
            this.dyx = null;
        }
    }

    public void amG() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dyC);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eWu);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dys.getChildCount()) {
                View childAt = this.dys.getChildAt(i2);
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
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eWu);
        this.eWu.mC(i);
        this.eWu.mD(i2);
        this.eWu.dU(z);
        this.eWu.gW(z2);
        this.dyA.gW(z2);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eWu, 500L);
    }

    public void gY(boolean z) {
        this.dyB = z;
    }

    public void qD(int i) {
        this.dyr = i;
    }
}
