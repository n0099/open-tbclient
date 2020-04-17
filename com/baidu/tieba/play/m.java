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
    private int clo;
    private int iMC;
    private View iMI;
    private f iMK;
    private com.baidu.adp.widget.ListView.o kgf;
    private com.baidu.adp.base.e mContext;
    private int kge = 0;
    private int iMD = 0;
    private String iMF = null;
    private int iMG = 0;
    private boolean iMJ = false;
    private boolean mIsShowing = true;
    private a iMM = new a();
    private final CustomMessageListener dkS = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bZf();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.iML.cKe(), m.this.iML.cKf(), m.this.iML.cKg(), m.this.iML.cKh());
                }
            }
        }
    };
    private final CustomMessageListener kgg = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(m.this.iMM);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(m.this.kgh);
                    if (m.this.iMI != null && (m.this.iMI.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.iMI.getTag()).getPlayUrl())) {
                            ((f) m.this.iMI.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.kgf.getListView().getChildCount()) {
                            View childAt = m.this.kgf.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.iMI = childAt;
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
    private b kgh = new b(this);
    private r iML = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.iMC = 0;
        this.clo = 0;
        this.mContext = eVar;
        this.iMC = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.kgf = oVar;
        this.clo = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dkS);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dkS != null) {
                this.dkS.setTag(bdUniqueId);
            }
            if (this.kgg != null) {
                this.kgg.setSelfListener(true);
                this.kgg.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dkS);
            MessageManager.getInstance().registerListener(this.kgg);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.iML.n(i, i2, z);
        if (this.kgf != null && this.kgf.getListView().getChildCount() != 0 && this.kgf.getContentViewsCount() != 0) {
            if (this.iMK != null && !cs(this.iMK.getVideoContainer())) {
                this.iMK.stopPlay();
            }
            if (this.iMI != null && (this.iMI.getTag() instanceof f) && this.iMJ) {
                if (cs(((f) this.iMI.getTag()).getVideoContainer())) {
                    f(i3, this.iMI);
                    this.iMJ = false;
                    return;
                }
                this.iMI = null;
            }
            int contentViewsCount = this.kgf.getContentViewsCount() + this.kgf.getHeaderViewsCount() + this.kgf.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.kgf.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.kgf.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.kgf.getListView().getChildAt(i8);
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
                        View childAt3 = this.kgf.getListView().getChildAt(i6);
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
                    View childAt4 = this.kgf.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.iMI != null && (this.iMI.getTag() instanceof f)) {
                    ((f) this.iMI.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.iMI != null && this.iMI != view && (this.iMI.getTag() instanceof f)) {
                ((f) this.iMI.getTag()).stopPlay();
            }
            this.iMI = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).cnj();
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
            ((e) view.getTag()).cnk();
        }
    }

    public boolean cs(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.kge == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.iMC - this.iMD && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void ct(View view) {
        if (view != null && !cs(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iMM);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgh);
        cnL();
    }

    public void yl(int i) {
        this.iMG = i;
    }

    public void cnL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kgf.getListView().getChildCount()) {
                View childAt = this.kgf.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void FM(String str) {
        this.iMF = str;
    }

    public void cnO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kgf.getListView().getChildCount()) {
                View childAt = this.kgf.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        yl(fVar.getCurrentPosition());
                        FM(fVar.getPlayUrl());
                        this.iMI = childAt;
                        this.iMJ = fVar.isPlaying();
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

    public void cnP() {
        if (this.mIsShowing) {
            if (this.iMI != null && (this.iMI.getTag() instanceof f)) {
                f fVar = (f) this.iMI.getTag();
                if (this.iMJ) {
                    fVar.startPlay();
                    this.iMJ = false;
                }
                if (this.iMI.getTag() instanceof e) {
                    ((e) this.iMI.getTag()).cnl();
                }
            }
            this.iMI = null;
        }
    }

    public void bZf() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iMM);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgh);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kgf.getListView().getChildCount()) {
                View childAt = this.kgf.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgh);
        this.kgh.yc(i);
        this.kgh.yd(i2);
        this.kgh.mD(z);
        this.kgh.pJ(z2);
        this.iML.pJ(z2);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.kgh, 500L);
    }

    public void pL(boolean z) {
        this.mIsShowing = z;
    }

    public void AY(int i) {
        this.iMD = i;
    }

    public void AZ(int i) {
        this.kge = i;
    }

    public View cJH() {
        return this.iMI;
    }
}
