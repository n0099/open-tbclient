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
    private int cut;
    private View fjr;
    private f fjt;
    private com.baidu.adp.widget.ListView.j gvJ;
    private com.baidu.adp.base.e mContext;
    private int mHeaderHeight;
    private int fjm = 0;
    private String fjo = null;
    private int fjp = 0;
    private boolean fjs = false;
    private boolean mIsShowing = true;
    private a fjv = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aKF();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.fju.bpW(), m.this.fju.bpX(), m.this.fju.bpY(), m.this.fju.bpZ());
                }
            }
        }
    };
    private b gvK = new b(this);
    private s fju = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.cut = 0;
        this.mHeaderHeight = 0;
        this.mContext = eVar;
        this.cut = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gvJ = jVar;
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
        this.fju.i(i, i2, z);
        if (this.gvJ != null && this.gvJ.getListView().getChildCount() != 0 && this.gvJ.getContentViewsCount() != 0) {
            if (this.fjt != null && !bi(this.fjt.getVideoContainer())) {
                this.fjt.stopPlay();
            }
            if (this.fjr != null && (this.fjr.getTag() instanceof f) && this.fjs) {
                if (bi(((f) this.fjr.getTag()).getVideoContainer())) {
                    e(i3, this.fjr);
                    this.fjr = null;
                    return;
                }
                this.fjr = null;
            }
            int contentViewsCount = this.gvJ.getContentViewsCount() + this.gvJ.getHeaderViewsCount() + this.gvJ.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gvJ.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gvJ.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && bi(fVar.getVideoContainer())) {
                            e(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            f(i3, childAt);
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
                    View childAt2 = this.gvJ.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && bi(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.gvJ.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            f(i3, childAt3);
                        } else {
                            e(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.gvJ.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && bi(fVar3.getVideoContainer())) {
                            e(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            f(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
            }
        }
    }

    private void e(int i, View view) {
        if (view != null) {
            this.fjr = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aWE();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            f fVar = (f) view.getTag();
            if (fVar.isPlaying()) {
                fVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aWF();
        }
    }

    public boolean bi(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.fjm && measuredHeight < this.cut;
    }

    public void bj(View view) {
        if (view != null && !bi(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fjv);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvK);
        aXi();
    }

    public void qI(int i) {
        this.fjp = i;
    }

    public void aXi() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gvJ.getListView().getChildCount()) {
                View childAt = this.gvJ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void qD(String str) {
        this.fjo = str;
    }

    public void aXl() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gvJ.getListView().getChildCount()) {
                View childAt = this.gvJ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        qI(fVar.getCurrentPosition());
                        qD(fVar.getPlayUrl());
                        this.fjr = childAt;
                        this.fjs = fVar.isPlaying();
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

    public void aXm() {
        if (this.mIsShowing) {
            if (this.fjr != null && (this.fjr.getTag() instanceof f)) {
                f fVar = (f) this.fjr.getTag();
                if (this.fjs) {
                    fVar.startPlay();
                }
                if (this.fjr.getTag() instanceof e) {
                    ((e) this.fjr.getTag()).aWG();
                }
            }
            this.fjr = null;
        }
    }

    public void aKF() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fjv);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvK);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gvJ.getListView().getChildCount()) {
                View childAt = this.gvJ.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gvK);
        this.gvK.qA(i);
        this.gvK.qB(i2);
        this.gvK.gD(z);
        this.gvK.ju(z2);
        this.fju.ju(z2);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gvK, 500L);
    }

    public void jw(boolean z) {
        this.mIsShowing = z;
    }
}
