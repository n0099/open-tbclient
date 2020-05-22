package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int cwY;
    private int jbH;
    private View jbN;
    private f jbP;
    private com.baidu.adp.widget.ListView.q kxZ;
    private com.baidu.adp.base.e mContext;
    private int kxY = 0;
    private int jbI = 0;
    private String jbK = null;
    private int jbL = 0;
    private boolean jbO = false;
    private boolean mIsShowing = true;
    private a jbR = new a();
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.cfz();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.jbQ.cRb(), m.this.jbQ.cRc(), m.this.jbQ.cRd(), m.this.jbQ.cRe());
                }
            }
        }
    };
    private final CustomMessageListener kya = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(m.this.jbR);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(m.this.kyb);
                    if (m.this.jbN != null && (m.this.jbN.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.jbN.getTag()).getPlayUrl())) {
                            ((f) m.this.jbN.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.kxZ.getListView().getChildCount()) {
                            View childAt = m.this.kxZ.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.jbN = childAt;
                                return;
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    private b kyb = new b(this);
    private r jbQ = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.q qVar) {
        this.jbH = 0;
        this.cwY = 0;
        this.mContext = eVar;
        this.jbH = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.kxZ = qVar;
        this.cwY = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dyW);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dyW != null) {
                this.dyW.setTag(bdUniqueId);
            }
            if (this.kya != null) {
                this.kya.setSelfListener(true);
                this.kya.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dyW);
            MessageManager.getInstance().registerListener(this.kya);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.jbQ.n(i, i2, z);
        if (this.kxZ != null && this.kxZ.getListView().getChildCount() != 0 && this.kxZ.getContentViewsCount() != 0) {
            if (this.jbP != null && !cs(this.jbP.getVideoContainer())) {
                this.jbP.stopPlay();
            }
            if (this.jbN != null && (this.jbN.getTag() instanceof f) && this.jbO) {
                if (cs(((f) this.jbN.getTag()).getVideoContainer())) {
                    f(i3, this.jbN);
                    this.jbO = false;
                    return;
                }
                this.jbN = null;
            }
            int contentViewsCount = this.kxZ.getContentViewsCount() + this.kxZ.getHeaderViewsCount() + this.kxZ.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.kxZ.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.kxZ.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cs(fVar.getVideoContainer())) {
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
                    View childAt2 = this.kxZ.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cs(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.kxZ.getListView().getChildAt(i6);
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
                    View childAt4 = this.kxZ.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cs(fVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.jbN != null && (this.jbN.getTag() instanceof f)) {
                    ((f) this.jbN.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.jbN != null && this.jbN != view && (this.jbN.getTag() instanceof f)) {
                ((f) this.jbN.getTag()).stopPlay();
            }
            this.jbN = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).ctJ();
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
            ((e) view.getTag()).ctK();
        }
    }

    public boolean cs(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.kxY == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.jbH - this.jbI && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void ct(View view) {
        if (view != null && !cs(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbR);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyb);
        cul();
    }

    public void yT(int i) {
        this.jbL = i;
    }

    public void cul() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kxZ.getListView().getChildCount()) {
                View childAt = this.kxZ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Hy(String str) {
        this.jbK = str;
    }

    public void cuo() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kxZ.getListView().getChildCount()) {
                View childAt = this.kxZ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        yT(fVar.getCurrentPosition());
                        Hy(fVar.getPlayUrl());
                        this.jbN = childAt;
                        this.jbO = fVar.isPlaying();
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

    public void cup() {
        if (this.mIsShowing) {
            if (this.jbN != null && (this.jbN.getTag() instanceof f)) {
                f fVar = (f) this.jbN.getTag();
                if (this.jbO) {
                    fVar.startPlay();
                    this.jbO = false;
                }
                if (this.jbN.getTag() instanceof e) {
                    ((e) this.jbN.getTag()).ctL();
                }
            }
            this.jbN = null;
        }
    }

    public void cfz() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jbR);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyb);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kxZ.getListView().getChildCount()) {
                View childAt = this.kxZ.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kyb);
        this.kyb.yK(i);
        this.kyb.yL(i2);
        this.kyb.mY(z);
        this.kyb.qg(z2);
        this.jbQ.qg(z2);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kyb, 500L);
    }

    public void qi(boolean z) {
        this.mIsShowing = z;
    }

    public void BI(int i) {
        this.jbI = i;
    }

    public void BJ(int i) {
        this.kxY = i;
    }

    public View cQE() {
        return this.jbN;
    }
}
