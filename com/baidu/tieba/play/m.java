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
    private int clB;
    private int eec;
    private View fao;
    private f faq;
    private com.baidu.adp.widget.ListView.j gmG;
    private com.baidu.adp.base.e mContext;
    private int faj = 0;
    private String fal = null;
    private int fam = 0;
    private boolean fap = false;
    private boolean cjc = true;
    private a fas = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aHP();
                if (m.this.cjc && m.this.cjc) {
                    m.this.b(m.this.far.bnl(), m.this.far.bnm(), m.this.far.bnn(), m.this.far.bno());
                }
            }
        }
    };
    private b gmH = new b(this);
    private r far = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.clB = 0;
        this.eec = 0;
        this.mContext = eVar;
        this.clB = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gmG = jVar;
        this.eec = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        int i4;
        int i5;
        int i6 = 0;
        this.far.h(i, i2, z);
        if (this.gmG != null && this.gmG.getListView().getChildCount() != 0 && this.gmG.getContentViewsCount() != 0) {
            if (this.faq != null && !bg(this.faq.getVideoContainer())) {
                this.faq.stopPlay();
            }
            if (this.fao != null && (this.fao.getTag() instanceof f) && this.fap) {
                if (bg(((f) this.fao.getTag()).getVideoContainer())) {
                    d(i3, this.fao);
                    this.fao = null;
                    return;
                }
                this.fao = null;
            }
            int contentViewsCount = this.gmG.getContentViewsCount() + this.gmG.getHeaderViewsCount() + this.gmG.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gmG.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gmG.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && bg(fVar.getVideoContainer())) {
                            d(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            e(i3, childAt);
                        }
                    }
                    z4 = z3;
                    i7++;
                    z3 = z4;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i8 = 0;
                while (true) {
                    if (i8 >= childCount) {
                        i4 = -1;
                        break;
                    }
                    View childAt2 = this.gmG.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && bg(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.gmG.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            e(i3, childAt3);
                        } else {
                            d(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.gmG.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && bg(fVar3.getVideoContainer())) {
                            d(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            e(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
            }
        }
    }

    private void d(int i, View view) {
        if (view != null) {
            this.fao = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cjc && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aTU();
            }
        }
    }

    private void e(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            f fVar = (f) view.getTag();
            if (fVar.isPlaying()) {
                fVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aTV();
        }
    }

    public boolean bg(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.faj && measuredHeight < this.clB;
    }

    public void bh(View view) {
        if (view != null && !bg(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fas);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmH);
        aUy();
    }

    public void pR(int i) {
        this.fam = i;
    }

    public void aUy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gmG.getListView().getChildCount()) {
                View childAt = this.gmG.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void qa(String str) {
        this.fal = str;
    }

    public void aUB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gmG.getListView().getChildCount()) {
                View childAt = this.gmG.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        pR(fVar.getCurrentPosition());
                        qa(fVar.getPlayUrl());
                        this.fao = childAt;
                        this.fap = fVar.isPlaying();
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

    public void aUC() {
        if (this.cjc) {
            if (this.fao != null && (this.fao.getTag() instanceof f)) {
                f fVar = (f) this.fao.getTag();
                if (this.fap) {
                    fVar.startPlay();
                }
                if (this.fao.getTag() instanceof e) {
                    ((e) this.fao.getTag()).aTW();
                }
            }
            this.fao = null;
        }
    }

    public void aHP() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fas);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmH);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gmG.getListView().getChildCount()) {
                View childAt = this.gmG.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmH);
        this.gmH.pJ(i);
        this.gmH.pK(i2);
        this.gmH.gb(z);
        this.gmH.iS(z2);
        this.far.iS(z2);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.gmH, 500L);
    }

    public void iU(boolean z) {
        this.cjc = z;
    }
}
