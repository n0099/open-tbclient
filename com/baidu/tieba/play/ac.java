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
    private int bjK;
    private int cuT;
    private ListView dsG;
    private View dsK;
    private u dsM;
    private com.baidu.adp.base.g mContext;
    private int dsF = 0;
    private String dsH = null;
    private int dsI = 0;
    private boolean dsL = false;
    private boolean dsO = true;
    private a dsP = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new ad(this, 2000994);
    private b eSu = new b(this);
    private as dsN = new as();

    public ac(com.baidu.adp.base.g gVar, ListView listView) {
        this.bjK = 0;
        this.cuT = 0;
        this.mContext = gVar;
        this.bjK = com.baidu.adp.lib.util.k.ag(this.mContext.getPageActivity());
        this.dsG = listView;
        this.cuT = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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

    public void qu(int i) {
        this.bjK = i;
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.dsN.h(i, i2, z);
        if (this.dsG != null && this.dsG.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dsG instanceof BdListView ? ((BdListView) this.dsG).getWrappedAdapter() : this.dsG.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dsM != null && !aI(this.dsM.getVideoContainer())) {
                    this.dsM.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dsG.getHeaderViewsCount() + this.dsG.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dsG.getChildCount(); i5++) {
                        View childAt = this.dsG.getChildAt(z2 ? i5 : (this.dsG.getChildCount() - 1) - i5);
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
                        if (i6 >= this.dsG.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dsG.getChildAt(i6);
                        if (childAt2.getTag() instanceof u) {
                            u uVar2 = (u) childAt2.getTag();
                            if (uVar2.isPlayStarted() && aI(uVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dsG.getChildCount()) {
                            View childAt3 = this.dsG.getChildAt(i4);
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
                    while (i4 < this.dsG.getChildCount()) {
                        View childAt4 = this.dsG.getChildAt(z ? (this.dsG.getChildCount() - 1) - i4 : i4);
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
            this.dsK = view;
            if (i == 1 && (view.getTag() instanceof u)) {
                u uVar = (u) view.getTag();
                if (this.dsO && !uVar.isPlayStarted()) {
                    uVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof t)) {
                ((t) view.getTag()).awa();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof t)) {
            ((t) view.getTag()).awb();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dsF && measuredHeight < this.bjK;
        }
        return false;
    }

    public void aJ(View view) {
        if (view != null && !aI(view) && (view.getTag() instanceof u)) {
            ((u) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dsP);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eSu);
        awH();
    }

    public void mx(int i) {
        this.dsI = i;
    }

    public void awH() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dsG.getChildCount()) {
                View childAt = this.dsG.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    ((u) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void lD(String str) {
        this.dsH = str;
    }

    public void awK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dsG.getChildCount()) {
                View childAt = this.dsG.getChildAt(i2);
                if (childAt.getTag() instanceof u) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isPlayStarted()) {
                        mx(uVar.getCurrentPosition());
                        lD(uVar.getPlayUrl());
                        this.dsK = childAt;
                        this.dsL = uVar.isPlaying();
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

    public void awL() {
        if (this.dsO) {
            if (this.dsK != null && (this.dsK.getTag() instanceof u)) {
                u uVar = (u) this.dsK.getTag();
                if (this.dsL) {
                    uVar.startPlay();
                }
                if (this.dsK.getTag() instanceof t) {
                    ((t) this.dsK.getTag()).awc();
                }
            }
            this.dsK = null;
        }
    }

    public void ajv() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.dsP);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eSu);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dsG.getChildCount()) {
                View childAt = this.dsG.getChildAt(i2);
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
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eSu);
        this.eSu.mp(i);
        this.eSu.mq(i2);
        this.eSu.dR(z);
        this.eSu.gx(z2);
        this.dsN.gx(z2);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.eSu, 500L);
    }

    public void gz(boolean z) {
        this.dsO = z;
    }

    public void qv(int i) {
        this.dsF = i;
    }
}
