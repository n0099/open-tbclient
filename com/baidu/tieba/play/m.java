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
    private int czs;
    private View eYV;
    private f eYX;
    private int eeu;
    private com.baidu.adp.widget.ListView.k gsd;
    private com.baidu.adp.base.e mContext;
    private int eYQ = 0;
    private String eYS = null;
    private int eYT = 0;
    private boolean eYW = false;
    private boolean cwQ = true;
    private a eYZ = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aCG();
                if (m.this.cwQ && m.this.cwQ) {
                    m.this.c(m.this.eYY.bku(), m.this.eYY.bkv(), m.this.eYY.bkw(), m.this.eYY.bkx());
                }
            }
        }
    };
    private b gse = new b(this);
    private s eYY = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.k kVar) {
        this.czs = 0;
        this.eeu = 0;
        this.mContext = eVar;
        this.czs = com.baidu.adp.lib.util.l.aq(this.mContext.getPageActivity());
        this.gsd = kVar;
        this.eeu = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eYY.j(i, i2, z);
        if (this.gsd != null && this.gsd.getListView().getChildCount() != 0 && this.gsd.getContentViewsCount() != 0) {
            if (this.eYX != null && !cg(this.eYX.getVideoContainer())) {
                this.eYX.stopPlay();
            }
            int contentViewsCount = this.gsd.getContentViewsCount() + this.gsd.getHeaderViewsCount() + this.gsd.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.gsd.getListView().getChildCount(); i5++) {
                    View childAt = this.gsd.getListView().getChildAt(z2 ? i5 : (this.gsd.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cg(fVar.getVideoContainer())) {
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
                    if (i6 >= this.gsd.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.gsd.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cg(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.gsd.getListView().getChildCount()) {
                        View childAt3 = this.gsd.getListView().getChildAt(i4);
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
                while (i4 < this.gsd.getListView().getChildCount()) {
                    View childAt4 = this.gsd.getListView().getChildAt(z ? (this.gsd.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && cg(fVar3.getVideoContainer())) {
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
            this.eYV = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cwQ && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aOt();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aOu();
        }
    }

    public boolean cg(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.eYQ && measuredHeight < this.czs;
        }
        return false;
    }

    public void ch(View view) {
        if (view != null && !cg(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eYZ);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gse);
        aOY();
    }

    public void rg(int i) {
        this.eYT = i;
    }

    public void aOY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gsd.getListView().getChildCount()) {
                View childAt = this.gsd.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ok(String str) {
        this.eYS = str;
    }

    public void aPb() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gsd.getListView().getChildCount()) {
                View childAt = this.gsd.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rg(fVar.getCurrentPosition());
                        ok(fVar.getPlayUrl());
                        this.eYV = childAt;
                        this.eYW = fVar.isPlaying();
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

    public void aPc() {
        if (this.cwQ) {
            if (this.eYV != null && (this.eYV.getTag() instanceof f)) {
                f fVar = (f) this.eYV.getTag();
                if (this.eYW) {
                    fVar.startPlay();
                }
                if (this.eYV.getTag() instanceof e) {
                    ((e) this.eYV.getTag()).aOv();
                }
            }
            this.eYV = null;
        }
    }

    public void aCG() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eYZ);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gse);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gsd.getListView().getChildCount()) {
                View childAt = this.gsd.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gse);
        this.gse.qY(i);
        this.gse.qZ(i2);
        this.gse.fK(z);
        this.gse.il(z2);
        this.eYY.il(z2);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gse, 500L);
    }

    public void in(boolean z) {
        this.cwQ = z;
    }
}
