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
    private int cyl;
    private View fqi;
    private f fqk;
    private com.baidu.adp.widget.ListView.j gCz;
    private com.baidu.adp.base.e mContext;
    private int mHeaderHeight;
    private int fqd = 0;
    private String fqf = null;
    private int fqg = 0;
    private boolean fqj = false;
    private boolean mIsShowing = true;
    private a fqm = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aMx();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.fql.brP(), m.this.fql.brQ(), m.this.fql.brR(), m.this.fql.brS());
                }
            }
        }
    };
    private b gCA = new b(this);
    private s fql = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.cyl = 0;
        this.mHeaderHeight = 0;
        this.mContext = eVar;
        this.cyl = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gCz = jVar;
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
        this.fql.i(i, i2, z);
        if (this.gCz != null && this.gCz.getListView().getChildCount() != 0 && this.gCz.getContentViewsCount() != 0) {
            if (this.fqk != null && !bi(this.fqk.getVideoContainer())) {
                this.fqk.stopPlay();
            }
            if (this.fqi != null && (this.fqi.getTag() instanceof f) && this.fqj) {
                if (bi(((f) this.fqi.getTag()).getVideoContainer())) {
                    f(i3, this.fqi);
                    this.fqi = null;
                    return;
                }
                this.fqi = null;
            }
            int contentViewsCount = this.gCz.getContentViewsCount() + this.gCz.getHeaderViewsCount() + this.gCz.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.gCz.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.gCz.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && bi(fVar.getVideoContainer())) {
                            f(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            g(i3, childAt);
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
                    View childAt2 = this.gCz.getListView().getChildAt(i8);
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
                        View childAt3 = this.gCz.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            g(i3, childAt3);
                        } else {
                            f(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.gCz.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && bi(fVar3.getVideoContainer())) {
                            f(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            g(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            this.fqi = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aYw();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            f fVar = (f) view.getTag();
            if (fVar.isPlaying()) {
                fVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aYx();
        }
    }

    public boolean bi(View view) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2);
        return measuredHeight > this.fqd && measuredHeight < this.cyl;
    }

    public void bj(View view) {
        if (view != null && !bi(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fqm);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCA);
        aZa();
    }

    public void rc(int i) {
        this.fqg = i;
    }

    public void aZa() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCz.getListView().getChildCount()) {
                View childAt = this.gCz.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void rf(String str) {
        this.fqf = str;
    }

    public void aZd() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCz.getListView().getChildCount()) {
                View childAt = this.gCz.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rc(fVar.getCurrentPosition());
                        rf(fVar.getPlayUrl());
                        this.fqi = childAt;
                        this.fqj = fVar.isPlaying();
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

    public void aZe() {
        if (this.mIsShowing) {
            if (this.fqi != null && (this.fqi.getTag() instanceof f)) {
                f fVar = (f) this.fqi.getTag();
                if (this.fqj) {
                    fVar.startPlay();
                }
                if (this.fqi.getTag() instanceof e) {
                    ((e) this.fqi.getTag()).aYy();
                }
            }
            this.fqi = null;
        }
    }

    public void aMx() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fqm);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCA);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gCz.getListView().getChildCount()) {
                View childAt = this.gCz.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gCA);
        this.gCA.qU(i);
        this.gCA.qV(i2);
        this.gCA.gE(z);
        this.gCA.jx(z2);
        this.fql.jx(z2);
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gCA, 500L);
    }

    public void jz(boolean z) {
        this.mIsShowing = z;
    }
}
