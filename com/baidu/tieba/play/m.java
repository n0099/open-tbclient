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
    private int bBW;
    private int dhf;
    private ListView edN;
    private View edR;
    private f edT;
    private com.baidu.adp.base.e mContext;
    private int edM = 0;
    private String edO = null;
    private int edP = 0;
    private boolean edS = false;
    private boolean bzw = true;
    private a edV = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.atu();
                if (m.this.bzw && m.this.bzw) {
                    m.this.a(m.this.edU.bhC(), m.this.edU.bhD(), m.this.edU.bhE(), m.this.edU.bhF());
                }
            }
        }
    };
    private b fFu = new b(this);
    private r edU = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bBW = 0;
        this.dhf = 0;
        this.mContext = eVar;
        this.bBW = com.baidu.adp.lib.util.l.ae(this.mContext.getPageActivity());
        this.edN = listView;
        this.dhf = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.edU.i(i, i2, z);
        if (this.edN != null && this.edN.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.edN instanceof BdListView ? ((BdListView) this.edN).getWrappedAdapter() : this.edN.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.edT != null && !aX(this.edT.getVideoContainer())) {
                    this.edT.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.edN.getHeaderViewsCount() + this.edN.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.edN.getChildCount(); i5++) {
                        View childAt = this.edN.getChildAt(z2 ? i5 : (this.edN.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aX(fVar.getVideoContainer())) {
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
                        if (i6 >= this.edN.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.edN.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aX(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.edN.getChildCount()) {
                            View childAt3 = this.edN.getChildAt(i4);
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
                    while (i4 < this.edN.getChildCount()) {
                        View childAt4 = this.edN.getChildAt(z ? (this.edN.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aX(fVar3.getVideoContainer())) {
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
            this.edR = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bzw && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aGo();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aGp();
        }
    }

    public boolean aX(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.edM && measuredHeight < this.bBW;
        }
        return false;
    }

    public void aY(View view) {
        if (view != null && !aX(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.edV);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFu);
        aGT();
    }

    public void oc(int i) {
        this.edP = i;
    }

    public void aGT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.edN.getChildCount()) {
                View childAt = this.edN.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nF(String str) {
        this.edO = str;
    }

    public void aGW() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.edN.getChildCount()) {
                View childAt = this.edN.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oc(fVar.getCurrentPosition());
                        nF(fVar.getPlayUrl());
                        this.edR = childAt;
                        this.edS = fVar.isPlaying();
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

    public void aGX() {
        if (this.bzw) {
            if (this.edR != null && (this.edR.getTag() instanceof f)) {
                f fVar = (f) this.edR.getTag();
                if (this.edS) {
                    fVar.startPlay();
                }
                if (this.edR.getTag() instanceof e) {
                    ((e) this.edR.getTag()).aGq();
                }
            }
            this.edR = null;
        }
    }

    public void atu() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.edV);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFu);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.edN.getChildCount()) {
                View childAt = this.edN.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fFu);
        this.fFu.nU(i);
        this.fFu.nV(i2);
        this.fFu.eB(z);
        this.fFu.hm(z2);
        this.edU.hm(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fFu, 500L);
    }

    public void ho(boolean z) {
        this.bzw = z;
    }
}
