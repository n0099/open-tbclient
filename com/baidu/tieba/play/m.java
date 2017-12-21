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
    private int bKr;
    private int dqI;
    private ListView ekR;
    private View ekV;
    private f ekX;
    private com.baidu.adp.base.e mContext;
    private int ekQ = 0;
    private String ekS = null;
    private int ekT = 0;
    private boolean ekW = false;
    private boolean bHM = true;
    private a ekZ = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.avu();
                if (m.this.bHM && m.this.bHM) {
                    m.this.a(m.this.ekY.bjC(), m.this.ekY.bjD(), m.this.ekY.bjE(), m.this.ekY.bjF());
                }
            }
        }
    };
    private b fPA = new b(this);
    private r ekY = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bKr = 0;
        this.dqI = 0;
        this.mContext = eVar;
        this.bKr = com.baidu.adp.lib.util.l.ae(this.mContext.getPageActivity());
        this.ekR = listView;
        this.dqI = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.ekY.i(i, i2, z);
        if (this.ekR != null && this.ekR.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.ekR instanceof BdListView ? ((BdListView) this.ekR).getWrappedAdapter() : this.ekR.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.ekX != null && !aT(this.ekX.getVideoContainer())) {
                    this.ekX.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.ekR.getHeaderViewsCount() + this.ekR.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.ekR.getChildCount(); i5++) {
                        View childAt = this.ekR.getChildAt(z2 ? i5 : (this.ekR.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aT(fVar.getVideoContainer())) {
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
                        if (i6 >= this.ekR.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.ekR.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aT(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.ekR.getChildCount()) {
                            View childAt3 = this.ekR.getChildAt(i4);
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
                    while (i4 < this.ekR.getChildCount()) {
                        View childAt4 = this.ekR.getChildAt(z ? (this.ekR.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aT(fVar3.getVideoContainer())) {
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
            this.ekV = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bHM && !fVar.isPlayStarted()) {
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

    public boolean aT(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.ekQ && measuredHeight < this.bKr;
        }
        return false;
    }

    public void aU(View view) {
        if (view != null && !aT(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ekZ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPA);
        aHO();
    }

    public void ov(int i) {
        this.ekT = i;
    }

    public void aHO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ekR.getChildCount()) {
                View childAt = this.ekR.getChildAt(i2);
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
        this.ekS = str;
    }

    public void aHR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ekR.getChildCount()) {
                View childAt = this.ekR.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        ov(fVar.getCurrentPosition());
                        nQ(fVar.getPlayUrl());
                        this.ekV = childAt;
                        this.ekW = fVar.isPlaying();
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
        if (this.bHM) {
            if (this.ekV != null && (this.ekV.getTag() instanceof f)) {
                f fVar = (f) this.ekV.getTag();
                if (this.ekW) {
                    fVar.startPlay();
                }
                if (this.ekV.getTag() instanceof e) {
                    ((e) this.ekV.getTag()).aHl();
                }
            }
            this.ekV = null;
        }
    }

    public void avu() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ekZ);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPA);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ekR.getChildCount()) {
                View childAt = this.ekR.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fPA);
        this.fPA.on(i);
        this.fPA.oo(i2);
        this.fPA.eY(z);
        this.fPA.hH(z2);
        this.ekY.hH(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fPA, 500L);
    }

    public void hJ(boolean z) {
        this.bHM = z;
    }
}
