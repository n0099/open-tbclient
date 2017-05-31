package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class ac {
    private int bkR;
    private int cBl;
    private ListView dxY;
    private View dyc;
    private u dye;
    private com.baidu.adp.base.g mContext;
    private int dxX = 0;
    private String dxZ = null;
    private int dya = 0;
    private boolean dyd = false;
    private boolean dyg = true;
    private a dyh = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b fbf = new b(this);
    private at dyf = new at();

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.bkR = 0;
        this.cBl = 0;
        this.mContext = gVar;
        this.bkR = com.baidu.adp.lib.util.k.ag(this.mContext.getPageActivity());
        this.dxY = listView;
        this.cBl = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        gVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dyf.h(i, i2, z);
        if (this.dxY != null && this.dxY.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dxY instanceof BdListView ? ((BdListView) this.dxY).getWrappedAdapter() : this.dxY.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dye != null && !aI(this.dye.getVideoContainer())) {
                    this.dye.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dxY.getHeaderViewsCount() + this.dxY.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dxY.getChildCount(); i5++) {
                        View childAt = this.dxY.getChildAt(z2 ? i5 : (this.dxY.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof u) {
                            u uVar = (u) childAt.getTag();
                            if (!z3 && aI(uVar.getVideoContainer())) {
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
                        if (i6 >= this.dxY.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dxY.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aI(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dxY.getChildCount()) {
                            View childAt3 = this.dxY.getChildAt(i4);
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
                    while (i4 < this.dxY.getChildCount()) {
                        View childAt4 = this.dxY.getChildAt(z ? (this.dxY.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof u) {
                            u uVar3 = (u) childAt4.getTag();
                            if (!z5 && aI(uVar3.getVideoContainer())) {
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
            this.dyc = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dyg && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).awU();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).TD();
        }
    }

    public boolean aI(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dxX && measuredHeight < this.bkR;
        }
        return false;
    }

    public void aJ(View view) {
        if (view != null && !aI(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dyh);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fbf);
        axA();
    }

    public void mR(int i) {
        this.dya = i;
    }

    public void axA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dxY.getChildCount()) {
                View childAt = this.dxY.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void lN(String str) {
        this.dxZ = str;
    }

    public void axD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dxY.getChildCount()) {
                View childAt = this.dxY.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        mR(uVar.getCurrentPosition());
                        lN(uVar.getPlayUrl());
                        this.dyc = childAt;
                        this.dyd = uVar.isPlaying();
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

    public void axE() {
        if (this.dyg) {
            if (this.dyc != null && (this.dyc.getTag() instanceof u)) {
                u uVar = (u) this.dyc.getTag();
                if (this.dyd) {
                    uVar.startPlay();
                }
                if (this.dyc.getTag() instanceof t) {
                    ((t) this.dyc.getTag()).awV();
                }
            }
            this.dyc = null;
        }
    }

    public void akv() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dyh);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fbf);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dxY.getChildCount()) {
                View childAt = this.dxY.getChildAt(i2);
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
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.fbf);
        this.fbf.mJ(i);
        this.fbf.mK(i2);
        this.fbf.eh(z);
        this.fbf.gK(z2);
        this.dyf.gK(z2);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.fbf, 500L);
    }

    public void gM(boolean z) {
        this.dyg = z;
    }
}
