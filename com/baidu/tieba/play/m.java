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
    private int clu;
    private int iMG;
    private View iMM;
    private f iMO;
    private com.baidu.adp.widget.ListView.o kgj;
    private com.baidu.adp.base.e mContext;
    private int kgi = 0;
    private int iMH = 0;
    private String iMJ = null;
    private int iMK = 0;
    private boolean iMN = false;
    private boolean mIsShowing = true;
    private a iMQ = new a();
    private final CustomMessageListener dkW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bZe();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.iMP.cKc(), m.this.iMP.cKd(), m.this.iMP.cKe(), m.this.iMP.cKf());
                }
            }
        }
    };
    private final CustomMessageListener kgk = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(m.this.iMQ);
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(m.this.kgl);
                    if (m.this.iMM != null && (m.this.iMM.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.iMM.getTag()).getPlayUrl())) {
                            ((f) m.this.iMM.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.kgj.getListView().getChildCount()) {
                            View childAt = m.this.kgj.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.iMM = childAt;
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
    private b kgl = new b(this);
    private r iMP = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.iMG = 0;
        this.clu = 0;
        this.mContext = eVar;
        this.iMG = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.kgj = oVar;
        this.clu = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dkW);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dkW != null) {
                this.dkW.setTag(bdUniqueId);
            }
            if (this.kgk != null) {
                this.kgk.setSelfListener(true);
                this.kgk.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dkW);
            MessageManager.getInstance().registerListener(this.kgk);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.iMP.n(i, i2, z);
        if (this.kgj != null && this.kgj.getListView().getChildCount() != 0 && this.kgj.getContentViewsCount() != 0) {
            if (this.iMO != null && !cs(this.iMO.getVideoContainer())) {
                this.iMO.stopPlay();
            }
            if (this.iMM != null && (this.iMM.getTag() instanceof f) && this.iMN) {
                if (cs(((f) this.iMM.getTag()).getVideoContainer())) {
                    f(i3, this.iMM);
                    this.iMN = false;
                    return;
                }
                this.iMM = null;
            }
            int contentViewsCount = this.kgj.getContentViewsCount() + this.kgj.getHeaderViewsCount() + this.kgj.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.kgj.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.kgj.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.kgj.getListView().getChildAt(i8);
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
                        View childAt3 = this.kgj.getListView().getChildAt(i6);
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
                    View childAt4 = this.kgj.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.iMM != null && (this.iMM.getTag() instanceof f)) {
                    ((f) this.iMM.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.iMM != null && this.iMM != view && (this.iMM.getTag() instanceof f)) {
                ((f) this.iMM.getTag()).stopPlay();
            }
            this.iMM = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).cnh();
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
            ((e) view.getTag()).cni();
        }
    }

    public boolean cs(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.kgi == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.iMG - this.iMH && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void ct(View view) {
        if (view != null && !cs(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iMQ);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgl);
        cnJ();
    }

    public void yl(int i) {
        this.iMK = i;
    }

    public void cnJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kgj.getListView().getChildCount()) {
                View childAt = this.kgj.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void FP(String str) {
        this.iMJ = str;
    }

    public void cnM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kgj.getListView().getChildCount()) {
                View childAt = this.kgj.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        yl(fVar.getCurrentPosition());
                        FP(fVar.getPlayUrl());
                        this.iMM = childAt;
                        this.iMN = fVar.isPlaying();
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

    public void cnN() {
        if (this.mIsShowing) {
            if (this.iMM != null && (this.iMM.getTag() instanceof f)) {
                f fVar = (f) this.iMM.getTag();
                if (this.iMN) {
                    fVar.startPlay();
                    this.iMN = false;
                }
                if (this.iMM.getTag() instanceof e) {
                    ((e) this.iMM.getTag()).cnj();
                }
            }
            this.iMM = null;
        }
    }

    public void bZe() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.iMQ);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgl);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kgj.getListView().getChildCount()) {
                View childAt = this.kgj.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kgl);
        this.kgl.yc(i);
        this.kgl.yd(i2);
        this.kgl.mD(z);
        this.kgl.pJ(z2);
        this.iMP.pJ(z2);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.kgl, 500L);
    }

    public void pL(boolean z) {
        this.mIsShowing = z;
    }

    public void AY(int i) {
        this.iMH = i;
    }

    public void AZ(int i) {
        this.kgi = i;
    }

    public View cJF() {
        return this.iMM;
    }
}
