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
    private int bKn;
    private int dqE;
    private ListView ekN;
    private View ekR;
    private f ekT;
    private com.baidu.adp.base.e mContext;
    private int ekM = 0;
    private String ekO = null;
    private int ekP = 0;
    private boolean ekS = false;
    private boolean bHI = true;
    private a ekV = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.avu();
                if (m.this.bHI && m.this.bHI) {
                    m.this.a(m.this.ekU.bjC(), m.this.ekU.bjD(), m.this.ekU.bjE(), m.this.ekU.bjF());
                }
            }
        }
    };
    private b fPv = new b(this);
    private r ekU = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bKn = 0;
        this.dqE = 0;
        this.mContext = eVar;
        this.bKn = com.baidu.adp.lib.util.l.ae(this.mContext.getPageActivity());
        this.ekN = listView;
        this.dqE = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.ekU.i(i, i2, z);
        if (this.ekN != null && this.ekN.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.ekN instanceof BdListView ? ((BdListView) this.ekN).getWrappedAdapter() : this.ekN.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.ekT != null && !aS(this.ekT.getVideoContainer())) {
                    this.ekT.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.ekN.getHeaderViewsCount() + this.ekN.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.ekN.getChildCount(); i5++) {
                        View childAt = this.ekN.getChildAt(z2 ? i5 : (this.ekN.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aS(fVar.getVideoContainer())) {
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
                        if (i6 >= this.ekN.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.ekN.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aS(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.ekN.getChildCount()) {
                            View childAt3 = this.ekN.getChildAt(i4);
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
                    while (i4 < this.ekN.getChildCount()) {
                        View childAt4 = this.ekN.getChildAt(z ? (this.ekN.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aS(fVar3.getVideoContainer())) {
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
            this.ekR = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bHI && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aHj();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aHk();
        }
    }

    public boolean aS(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.ekM && measuredHeight < this.bKn;
        }
        return false;
    }

    public void aT(View view) {
        if (view != null && !aS(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ekV);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPv);
        aHO();
    }

    public void ov(int i) {
        this.ekP = i;
    }

    public void aHO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ekN.getChildCount()) {
                View childAt = this.ekN.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nQ(String str) {
        this.ekO = str;
    }

    public void aHR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ekN.getChildCount()) {
                View childAt = this.ekN.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        ov(fVar.getCurrentPosition());
                        nQ(fVar.getPlayUrl());
                        this.ekR = childAt;
                        this.ekS = fVar.isPlaying();
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

    public void aHS() {
        if (this.bHI) {
            if (this.ekR != null && (this.ekR.getTag() instanceof f)) {
                f fVar = (f) this.ekR.getTag();
                if (this.ekS) {
                    fVar.startPlay();
                }
                if (this.ekR.getTag() instanceof e) {
                    ((e) this.ekR.getTag()).aHl();
                }
            }
            this.ekR = null;
        }
    }

    public void avu() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ekV);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPv);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ekN.getChildCount()) {
                View childAt = this.ekN.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPv);
        this.fPv.on(i);
        this.fPv.oo(i2);
        this.fPv.eY(z);
        this.fPv.hH(z2);
        this.ekU.hH(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fPv, 500L);
    }

    public void hJ(boolean z) {
        this.bHI = z;
    }
}
