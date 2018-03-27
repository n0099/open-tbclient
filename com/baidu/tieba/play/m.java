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
    private int cDd;
    private int eiK;
    private View fec;
    private f fee;
    private com.baidu.adp.widget.ListView.k gtO;
    private com.baidu.adp.base.e mContext;
    private int fdX = 0;
    private String fdZ = null;
    private int fea = 0;
    private boolean fed = false;
    private boolean cAB = true;
    private a feg = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aEa();
                if (m.this.cAB && m.this.cAB) {
                    m.this.d(m.this.fef.blH(), m.this.fef.blI(), m.this.fef.blJ(), m.this.fef.blK());
                }
            }
        }
    };
    private b gtP = new b(this);
    private s fef = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.k kVar) {
        this.cDd = 0;
        this.eiK = 0;
        this.mContext = eVar;
        this.cDd = com.baidu.adp.lib.util.l.aq(this.mContext.getPageActivity());
        this.gtO = kVar;
        this.eiK = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.fef.k(i, i2, z);
        if (this.gtO != null && this.gtO.getListView().getChildCount() != 0 && this.gtO.getContentViewsCount() != 0) {
            if (this.fee != null && !cf(this.fee.getVideoContainer())) {
                this.fee.stopPlay();
            }
            int contentViewsCount = this.gtO.getContentViewsCount() + this.gtO.getHeaderViewsCount() + this.gtO.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.gtO.getListView().getChildCount(); i5++) {
                    View childAt = this.gtO.getListView().getChildAt(z2 ? i5 : (this.gtO.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cf(fVar.getVideoContainer())) {
                            d(i3, childAt);
                            z3 = true;
                        } else {
                            e(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.gtO.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.gtO.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cf(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.gtO.getListView().getChildCount()) {
                        View childAt3 = this.gtO.getListView().getChildAt(i4);
                        if (i4 == i6) {
                            d(i3, childAt3);
                        } else {
                            e(i3, childAt3);
                        }
                        i4++;
                    }
                    return;
                }
                boolean z5 = false;
                while (i4 < this.gtO.getListView().getChildCount()) {
                    View childAt4 = this.gtO.getListView().getChildAt(z ? (this.gtO.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && cf(fVar3.getVideoContainer())) {
                            d(i3, childAt4);
                            z4 = true;
                            i4++;
                            z5 = z4;
                        } else {
                            e(i3, childAt4);
                        }
                    }
                    z4 = z5;
                    i4++;
                    z5 = z4;
                }
            }
        }
    }

    private void d(int i, View view) {
        if (view != null) {
            this.fec = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cAB && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aQg();
            }
        }
    }

    private void e(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aQh();
        }
    }

    public boolean cf(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.fdX && measuredHeight < this.cDd;
        }
        return false;
    }

    public void cg(View view) {
        if (view != null && !cf(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.feg);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtP);
        aQL();
    }

    public void rl(int i) {
        this.fea = i;
    }

    public void aQL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gtO.getListView().getChildCount()) {
                View childAt = this.gtO.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ow(String str) {
        this.fdZ = str;
    }

    public void aQO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gtO.getListView().getChildCount()) {
                View childAt = this.gtO.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rl(fVar.getCurrentPosition());
                        ow(fVar.getPlayUrl());
                        this.fec = childAt;
                        this.fed = fVar.isPlaying();
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

    public void aQP() {
        if (this.cAB) {
            if (this.fec != null && (this.fec.getTag() instanceof f)) {
                f fVar = (f) this.fec.getTag();
                if (this.fed) {
                    fVar.startPlay();
                }
                if (this.fec.getTag() instanceof e) {
                    ((e) this.fec.getTag()).aQi();
                }
            }
            this.fec = null;
        }
    }

    public void aEa() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.feg);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtP);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gtO.getListView().getChildCount()) {
                View childAt = this.gtO.getListView().getChildAt(i2);
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

    public void d(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtP);
        this.gtP.rd(i);
        this.gtP.re(i2);
        this.gtP.fT(z);
        this.gtP.iC(z2);
        this.fef.iC(z2);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gtP, 500L);
    }

    public void iE(boolean z) {
        this.cAB = z;
    }
}
