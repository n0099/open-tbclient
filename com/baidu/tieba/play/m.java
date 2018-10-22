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
    private int cug;
    private View fhW;
    private f fhY;
    private com.baidu.adp.widget.ListView.j guj;
    private com.baidu.adp.base.e mContext;
    private int mHeaderHeight;
    private int fhR = 0;
    private String fhT = null;
    private int fhU = 0;
    private boolean fhX = false;
    private boolean mIsShowing = true;
    private a fia = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aLh();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.fhZ.bqA(), m.this.fhZ.bqB(), m.this.fhZ.bqC(), m.this.fhZ.bqD());
                }
            }
        }
    };
    private b guk = new b(this);
    private s fhZ = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.cug = 0;
        this.mHeaderHeight = 0;
        this.mContext = eVar;
        this.cug = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.guj = jVar;
        this.mHeaderHeight = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.fhZ.h(i, i2, z);
        if (this.guj != null && this.guj.getListView().getChildCount() != 0 && this.guj.getContentViewsCount() != 0) {
            if (this.fhY != null && !bg(this.fhY.getVideoContainer())) {
                this.fhY.stopPlay();
            }
            if (this.fhW != null && (this.fhW.getTag() instanceof f) && this.fhX) {
                if (bg(((f) this.fhW.getTag()).getVideoContainer())) {
                    d(i3, this.fhW);
                    this.fhW = null;
                    return;
                }
                this.fhW = null;
            }
            int contentViewsCount = this.guj.getContentViewsCount() + this.guj.getHeaderViewsCount() + this.guj.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.guj.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.guj.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.guj.getListView().getChildAt(i8);
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
                        View childAt3 = this.guj.getListView().getChildAt(i6);
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
                    View childAt4 = this.guj.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
            this.fhW = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aXh();
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
            ((e) view.getTag()).aXi();
        }
    }

    public boolean bg(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.fhR && measuredHeight < this.cug;
    }

    public void bh(View view) {
        if (view != null && !bg(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fia);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.guk);
        aXL();
    }

    public void qp(int i) {
        this.fhU = i;
    }

    public void aXL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.guj.getListView().getChildCount()) {
                View childAt = this.guj.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void qC(String str) {
        this.fhT = str;
    }

    public void aXO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.guj.getListView().getChildCount()) {
                View childAt = this.guj.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        qp(fVar.getCurrentPosition());
                        qC(fVar.getPlayUrl());
                        this.fhW = childAt;
                        this.fhX = fVar.isPlaying();
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

    public void aXP() {
        if (this.mIsShowing) {
            if (this.fhW != null && (this.fhW.getTag() instanceof f)) {
                f fVar = (f) this.fhW.getTag();
                if (this.fhX) {
                    fVar.startPlay();
                }
                if (this.fhW.getTag() instanceof e) {
                    ((e) this.fhW.getTag()).aXj();
                }
            }
            this.fhW = null;
        }
    }

    public void aLh() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fia);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.guk);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.guj.getListView().getChildCount()) {
                View childAt = this.guj.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.guk);
        this.guk.qh(i);
        this.guk.qi(i2);
        this.guk.gt(z);
        this.guk.jk(z2);
        this.fhZ.jk(z2);
        com.baidu.adp.lib.g.e.jI().postDelayed(this.guk, 500L);
    }

    public void jm(boolean z) {
        this.mIsShowing = z;
    }
}
