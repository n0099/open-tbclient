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
    private int bMs;
    private int iaV;
    private View ibb;
    private f ibd;
    private com.baidu.adp.widget.ListView.o juA;
    private com.baidu.adp.base.e mContext;
    private int juz = 0;
    private int iaW = 0;
    private String iaY = null;
    private int iaZ = 0;
    private boolean ibc = false;
    private boolean mIsShowing = true;
    private a ibf = new a();
    private final CustomMessageListener cLy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bOp();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.ibe.czf(), m.this.ibe.czg(), m.this.ibe.czh(), m.this.ibe.czi());
                }
            }
        }
    };
    private final CustomMessageListener juB = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.ibf);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.juC);
                    if (m.this.ibb != null && (m.this.ibb.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.ibb.getTag()).getPlayUrl())) {
                            ((f) m.this.ibb.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.juA.getListView().getChildCount()) {
                            View childAt = m.this.juA.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.ibb = childAt;
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
    private b juC = new b(this);
    private r ibe = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.iaV = 0;
        this.bMs = 0;
        this.mContext = eVar;
        this.iaV = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.juA = oVar;
        this.bMs = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.cLy);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cLy != null) {
                this.cLy.setTag(bdUniqueId);
            }
            if (this.juB != null) {
                this.juB.setSelfListener(true);
                this.juB.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cLy);
            MessageManager.getInstance().registerListener(this.juB);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.ibe.n(i, i2, z);
        if (this.juA != null && this.juA.getListView().getChildCount() != 0 && this.juA.getContentViewsCount() != 0) {
            if (this.ibd != null && !ck(this.ibd.getVideoContainer())) {
                this.ibd.stopPlay();
            }
            if (this.ibb != null && (this.ibb.getTag() instanceof f) && this.ibc) {
                if (ck(((f) this.ibb.getTag()).getVideoContainer())) {
                    f(i3, this.ibb);
                    this.ibc = false;
                    return;
                }
                this.ibb = null;
            }
            int contentViewsCount = this.juA.getContentViewsCount() + this.juA.getHeaderViewsCount() + this.juA.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.juA.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.juA.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && ck(fVar.getVideoContainer())) {
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
                    View childAt2 = this.juA.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && ck(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.juA.getListView().getChildAt(i6);
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
                    View childAt4 = this.juA.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || ck(fVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.ibb != null && (this.ibb.getTag() instanceof f)) {
                    ((f) this.ibb.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.ibb != null && this.ibb != view && (this.ibb.getTag() instanceof f)) {
                ((f) this.ibb.getTag()).stopPlay();
            }
            this.ibb = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).cco();
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
            ((e) view.getTag()).ccp();
        }
    }

    public boolean ck(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.juz == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.iaV - this.iaW && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cl(View view) {
        if (view != null && !ck(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibf);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juC);
        ccQ();
    }

    public void xD(int i) {
        this.iaZ = i;
    }

    public void ccQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juA.getListView().getChildCount()) {
                View childAt = this.juA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ed(String str) {
        this.iaY = str;
    }

    public void ccT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juA.getListView().getChildCount()) {
                View childAt = this.juA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        xD(fVar.getCurrentPosition());
                        Ed(fVar.getPlayUrl());
                        this.ibb = childAt;
                        this.ibc = fVar.isPlaying();
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

    public void ccU() {
        if (this.mIsShowing) {
            if (this.ibb != null && (this.ibb.getTag() instanceof f)) {
                f fVar = (f) this.ibb.getTag();
                if (this.ibc) {
                    fVar.startPlay();
                    this.ibc = false;
                }
                if (this.ibb.getTag() instanceof e) {
                    ((e) this.ibb.getTag()).ccq();
                }
            }
            this.ibb = null;
        }
    }

    public void bOp() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibf);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juC);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juA.getListView().getChildCount()) {
                View childAt = this.juA.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juC);
        this.juC.xu(i);
        this.juC.xv(i2);
        this.juC.lu(z);
        this.juC.oz(z2);
        this.ibe.oz(z2);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juC, 500L);
    }

    public void oB(boolean z) {
        this.mIsShowing = z;
    }

    public void Aq(int i) {
        this.iaW = i;
    }

    public void Ar(int i) {
        this.juz = i;
    }

    public View cyI() {
        return this.ibb;
    }
}
