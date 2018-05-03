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
    private int bTe;
    private int dDn;
    private View eyK;
    private f eyM;
    private com.baidu.adp.widget.ListView.j fOx;
    private com.baidu.adp.base.e mContext;
    private int eyF = 0;
    private String eyH = null;
    private int eyI = 0;
    private boolean eyL = false;
    private boolean mIsShowing = true;
    private a eyO = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aza();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.eyN.bgN(), m.this.eyN.bgO(), m.this.eyN.bgP(), m.this.eyN.bgQ());
                }
            }
        }
    };
    private b fOy = new b(this);
    private r eyN = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.bTe = 0;
        this.dDn = 0;
        this.mContext = eVar;
        this.bTe = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.fOx = jVar;
        this.dDn = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.eyN.h(i, i2, z);
        if (this.fOx != null && this.fOx.getListView().getChildCount() != 0 && this.fOx.getContentViewsCount() != 0) {
            if (this.eyM != null && !aL(this.eyM.getVideoContainer())) {
                this.eyM.stopPlay();
            }
            int contentViewsCount = this.fOx.getContentViewsCount() + this.fOx.getHeaderViewsCount() + this.fOx.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.fOx.getListView().getChildCount(); i5++) {
                    View childAt = this.fOx.getListView().getChildAt(z2 ? i5 : (this.fOx.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aL(fVar.getVideoContainer())) {
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
                    if (i6 >= this.fOx.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.fOx.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && aL(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.fOx.getListView().getChildCount()) {
                        View childAt3 = this.fOx.getListView().getChildAt(i4);
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
                while (i4 < this.fOx.getListView().getChildCount()) {
                    View childAt4 = this.fOx.getListView().getChildAt(z ? (this.fOx.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && aL(fVar3.getVideoContainer())) {
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

    private void d(int i, View view2) {
        if (view2 != null) {
            this.eyK = view2;
            if (i == 1 && (view2.getTag() instanceof f)) {
                f fVar = (f) view2.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view2.getTag() instanceof e)) {
                ((e) view2.getTag()).aLg();
            }
        }
    }

    private void e(int i, View view2) {
        if (i == 1 && (view2.getTag() instanceof f)) {
            ((f) view2.getTag()).stopPlay();
        } else if (i == 2 && (view2.getTag() instanceof e)) {
            ((e) view2.getTag()).hideAll();
        }
    }

    public boolean aL(View view2) {
        int measuredHeight;
        if (view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
            return view2 != null && (measuredHeight = iArr[1] + (view2.getMeasuredHeight() / 2)) > this.eyF && measuredHeight < this.bTe;
        }
        return false;
    }

    public void aM(View view2) {
        if (view2 != null && !aL(view2) && (view2.getTag() instanceof f)) {
            ((f) view2.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyO);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOy);
        aLK();
    }

    public void oG(int i) {
        this.eyI = i;
    }

    public void aLK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOx.getListView().getChildCount()) {
                View childAt = this.fOx.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void oA(String str) {
        this.eyH = str;
    }

    public void aLN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOx.getListView().getChildCount()) {
                View childAt = this.fOx.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oG(fVar.getCurrentPosition());
                        oA(fVar.getPlayUrl());
                        this.eyK = childAt;
                        this.eyL = fVar.isPlaying();
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

    public void aLO() {
        if (this.mIsShowing) {
            if (this.eyK != null && (this.eyK.getTag() instanceof f)) {
                f fVar = (f) this.eyK.getTag();
                if (this.eyL) {
                    fVar.startPlay();
                }
                if (this.eyK.getTag() instanceof e) {
                    ((e) this.eyK.getTag()).aLh();
                }
            }
            this.eyK = null;
        }
    }

    public void aza() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.eyO);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOy);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fOx.getListView().getChildCount()) {
                View childAt = this.fOx.getListView().getChildAt(i2);
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

    public void b(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fOy);
        this.fOy.oy(i);
        this.fOy.oz(i2);
        this.fOy.fy(z);
        this.fOy.ia(z2);
        this.eyN.ia(z2);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fOy, 500L);
    }

    public void ic(boolean z) {
        this.mIsShowing = z;
    }
}
