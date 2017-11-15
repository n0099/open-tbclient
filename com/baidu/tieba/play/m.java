package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int bCj;
    private int dhz;
    private ListView edR;
    private View edV;
    private f edX;
    private com.baidu.adp.base.e mContext;
    private int edQ = 0;
    private String edS = null;
    private int edT = 0;
    private boolean edW = false;
    private boolean bzI = true;
    private a edZ = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.atL();
                if (m.this.bzI && m.this.bzI) {
                    m.this.a(m.this.edY.bhK(), m.this.edY.bhL(), m.this.edY.bhM(), m.this.edY.bhN());
                }
            }
        }
    };
    private b fFR = new b(this);
    private r edY = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bCj = 0;
        this.dhz = 0;
        this.mContext = eVar;
        this.bCj = com.baidu.adp.lib.util.l.ae(this.mContext.getPageActivity());
        this.edR = listView;
        this.dhz = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
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
        this.edY.i(i, i2, z);
        if (this.edR != null && this.edR.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.edR instanceof BdListView ? ((BdListView) this.edR).getWrappedAdapter() : this.edR.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.edX != null && !aY(this.edX.getVideoContainer())) {
                    this.edX.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.edR.getHeaderViewsCount() + this.edR.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.edR.getChildCount(); i5++) {
                        View childAt = this.edR.getChildAt(z2 ? i5 : (this.edR.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aY(fVar.getVideoContainer())) {
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
                        if (i6 >= this.edR.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.edR.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aY(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.edR.getChildCount()) {
                            View childAt3 = this.edR.getChildAt(i4);
                            if (i4 == i6) {
                                f(i3, childAt3);
                            } else {
                                g(i3, childAt3);
                            }
                            i4++;
                        }
                        return;
                    }
                    boolean z5 = false;
                    while (i4 < this.edR.getChildCount()) {
                        View childAt4 = this.edR.getChildAt(z ? (this.edR.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aY(fVar3.getVideoContainer())) {
                                f(i3, childAt4);
                                z4 = true;
                                i4++;
                                z5 = z4;
                            } else {
                                g(i3, childAt4);
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

    private void f(int i, View view) {
        if (view != null) {
            this.edV = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bzI && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aGs();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aGt();
        }
    }

    public boolean aY(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.edQ && measuredHeight < this.bCj;
        }
        return false;
    }

    public void aZ(View view) {
        if (view != null && !aY(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.edZ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFR);
        aGX();
    }

    public void od(int i) {
        this.edT = i;
    }

    public void aGX() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.edR.getChildCount()) {
                View childAt = this.edR.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nH(String str) {
        this.edS = str;
    }

    public void aHa() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.edR.getChildCount()) {
                View childAt = this.edR.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        od(fVar.getCurrentPosition());
                        nH(fVar.getPlayUrl());
                        this.edV = childAt;
                        this.edW = fVar.isPlaying();
                        fVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void aHb() {
        if (this.bzI) {
            if (this.edV != null && (this.edV.getTag() instanceof f)) {
                f fVar = (f) this.edV.getTag();
                if (this.edW) {
                    fVar.startPlay();
                }
                if (this.edV.getTag() instanceof e) {
                    ((e) this.edV.getTag()).aGu();
                }
            }
            this.edV = null;
        }
    }

    public void atL() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.edZ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFR);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.edR.getChildCount()) {
                View childAt = this.edR.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        fVar.stopPlay();
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFR);
        this.fFR.nV(i);
        this.fFR.nW(i2);
        this.fFR.eG(z);
        this.fFR.hs(z2);
        this.edY.hs(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fFR, 500L);
    }

    public void hu(boolean z) {
        this.bzI = z;
    }
}
