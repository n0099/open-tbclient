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
    private int boE;
    private int cJh;
    private ListView dGL;
    private View dGP;
    private u dGR;
    private com.baidu.adp.base.g mContext;
    private int dGK = 0;
    private String dGM = null;
    private int dGN = 0;
    private boolean dGQ = false;
    private boolean dGT = true;
    private a dGU = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b flv = new b(this);
    private at dGS = new at();

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.boE = 0;
        this.cJh = 0;
        this.mContext = gVar;
        this.boE = com.baidu.adp.lib.util.k.ag(this.mContext.getPageActivity());
        this.dGL = listView;
        this.cJh = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.dGS.i(i, i2, z);
        if (this.dGL != null && this.dGL.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dGL instanceof BdListView ? ((BdListView) this.dGL).getWrappedAdapter() : this.dGL.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dGR != null && !aK(this.dGR.getVideoContainer())) {
                    this.dGR.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dGL.getHeaderViewsCount() + this.dGL.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dGL.getChildCount(); i5++) {
                        View childAt = this.dGL.getChildAt(z2 ? i5 : (this.dGL.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof u) {
                            u uVar = (u) childAt.getTag();
                            if (!z3 && aK(uVar.getVideoContainer())) {
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
                        if (i6 >= this.dGL.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dGL.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aK(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dGL.getChildCount()) {
                            View childAt3 = this.dGL.getChildAt(i4);
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
                    while (i4 < this.dGL.getChildCount()) {
                        View childAt4 = this.dGL.getChildAt(z ? (this.dGL.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof u) {
                            u uVar3 = (u) childAt4.getTag();
                            if (!z5 && aK(uVar3.getVideoContainer())) {
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
            this.dGP = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dGT && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).aAS();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).aAT();
        }
    }

    public boolean aK(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dGK && measuredHeight < this.boE;
        }
        return false;
    }

    public void aL(View view) {
        if (view != null && !aK(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dGU);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.flv);
        aBz();
    }

    public void nd(int i) {
        this.dGN = i;
    }

    public void aBz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dGL.getChildCount()) {
                View childAt = this.dGL.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void mK(String str) {
        this.dGM = str;
    }

    public void aBC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dGL.getChildCount()) {
                View childAt = this.dGL.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        nd(uVar.getCurrentPosition());
                        mK(uVar.getPlayUrl());
                        this.dGP = childAt;
                        this.dGQ = uVar.isPlaying();
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

    public void aBD() {
        if (this.dGT) {
            if (this.dGP != null && (this.dGP.getTag() instanceof u)) {
                u uVar = (u) this.dGP.getTag();
                if (this.dGQ) {
                    uVar.startPlay();
                }
                if (this.dGP.getTag() instanceof t) {
                    ((t) this.dGP.getTag()).aAU();
                }
            }
            this.dGP = null;
        }
    }

    public void aog() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.dGU);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.flv);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dGL.getChildCount()) {
                View childAt = this.dGL.getChildAt(i2);
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
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.flv);
        this.flv.mV(i);
        this.flv.mW(i2);
        this.flv.ez(z);
        this.flv.he(z2);
        this.dGS.he(z2);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.flv, 500L);
    }

    public void hg(boolean z) {
        this.dGT = z;
    }
}
