package com.baidu.tieba.play;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int cyX;
    private View eXa;
    private f eXc;
    private int ecO;
    private com.baidu.adp.widget.ListView.k gCB;
    private com.baidu.adp.base.e mContext;
    private int eWV = 0;
    private String eWX = null;
    private int eWY = 0;
    private boolean eXb = false;
    private boolean cwu = true;
    private a eXe = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aCw();
                if (m.this.cwu && m.this.cwu) {
                    m.this.c(m.this.eXd.bra(), m.this.eXd.brb(), m.this.eXd.brc(), m.this.eXd.brd());
                }
            }
        }
    };
    private b gCC = new b(this);
    private s eXd = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.k kVar) {
        this.cyX = 0;
        this.ecO = 0;
        this.mContext = eVar;
        this.cyX = com.baidu.adp.lib.util.l.aq(this.mContext.getPageActivity());
        this.gCB = kVar;
        this.ecO = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eXd.l(i, i2, z);
        if (this.gCB != null && this.gCB.getListView().getChildCount() != 0 && this.gCB.getContentViewsCount() != 0) {
            if (this.eXc != null && !ce(this.eXc.getVideoContainer())) {
                this.eXc.stopPlay();
            }
            int contentViewsCount = this.gCB.getContentViewsCount() + this.gCB.getHeaderViewsCount() + this.gCB.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.gCB.getListView().getChildCount(); i5++) {
                    View childAt = this.gCB.getListView().getChildAt(z2 ? i5 : (this.gCB.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && ce(fVar.getVideoContainer())) {
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
                    if (i6 >= this.gCB.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.gCB.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && ce(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.gCB.getListView().getChildCount()) {
                        View childAt3 = this.gCB.getListView().getChildAt(i4);
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
                while (i4 < this.gCB.getListView().getChildCount()) {
                    View childAt4 = this.gCB.getListView().getChildAt(z ? (this.gCB.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && ce(fVar3.getVideoContainer())) {
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

    private void f(int i, View view) {
        if (view != null) {
            this.eXa = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cwu && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aOj();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aOk();
        }
    }

    public boolean ce(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.eWV && measuredHeight < this.cyX;
        }
        return false;
    }

    public void cf(View view) {
        if (view != null && !ce(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gCC);
        aOO();
    }

    public void rn(int i) {
        this.eWY = i;
    }

    public void aOO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCB.getListView().getChildCount()) {
                View childAt = this.gCB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nZ(String str) {
        this.eWX = str;
    }

    public void aOR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCB.getListView().getChildCount()) {
                View childAt = this.gCB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rn(fVar.getCurrentPosition());
                        nZ(fVar.getPlayUrl());
                        this.eXa = childAt;
                        this.eXb = fVar.isPlaying();
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

    public void aOS() {
        if (this.cwu) {
            if (this.eXa != null && (this.eXa.getTag() instanceof f)) {
                f fVar = (f) this.eXa.getTag();
                if (this.eXb) {
                    fVar.startPlay();
                }
                if (this.eXa.getTag() instanceof e) {
                    ((e) this.eXa.getTag()).aOl();
                }
            }
            this.eXa = null;
        }
    }

    public void aCw() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eXe);
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gCC);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCB.getListView().getChildCount()) {
                View childAt = this.gCB.getListView().getChildAt(i2);
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

    public void c(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.gCC);
        this.gCC.rf(i);
        this.gCC.rg(i2);
        this.gCC.fE(z);
        this.gCC.ig(z2);
        this.eXd.ig(z2);
        com.baidu.adp.lib.g.e.nr().postDelayed(this.gCC, 500L);
    }

    public void ii(boolean z) {
        this.cwu = z;
    }
}
