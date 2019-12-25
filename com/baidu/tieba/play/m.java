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
    private int bHC;
    private int hVr;
    private View hVx;
    private f hVz;
    private com.baidu.adp.widget.ListView.o jqe;
    private com.baidu.adp.base.e mContext;
    private int hVs = 0;
    private String hVu = null;
    private int hVv = 0;
    private boolean hVy = false;
    private boolean mIsShowing = true;
    private a hVB = new a();
    private final CustomMessageListener cHi = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bLD();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.hVA.cwA(), m.this.hVA.cwB(), m.this.hVA.cwC(), m.this.hVA.cwD());
                }
            }
        }
    };
    private final CustomMessageListener jqf = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(m.this.hVB);
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(m.this.jqg);
                    if (m.this.hVx != null && (m.this.hVx.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hVx.getTag()).getPlayUrl())) {
                            ((f) m.this.hVx.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.jqe.getListView().getChildCount()) {
                            View childAt = m.this.jqe.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hVx = childAt;
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
    private b jqg = new b(this);
    private r hVA = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hVr = 0;
        this.bHC = 0;
        this.mContext = eVar;
        this.hVr = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.jqe = oVar;
        this.bHC = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.cHi);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cHi != null) {
                this.cHi.setTag(bdUniqueId);
            }
            if (this.jqf != null) {
                this.jqf.setSelfListener(true);
                this.jqf.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cHi);
            MessageManager.getInstance().registerListener(this.jqf);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hVA.n(i, i2, z);
        if (this.jqe != null && this.jqe.getListView().getChildCount() != 0 && this.jqe.getContentViewsCount() != 0) {
            if (this.hVz != null && !cf(this.hVz.getVideoContainer())) {
                this.hVz.stopPlay();
            }
            if (this.hVx != null && (this.hVx.getTag() instanceof f) && this.hVy) {
                if (cf(((f) this.hVx.getTag()).getVideoContainer())) {
                    f(i3, this.hVx);
                    return;
                }
                this.hVx = null;
            }
            int contentViewsCount = this.jqe.getContentViewsCount() + this.jqe.getHeaderViewsCount() + this.jqe.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.jqe.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.jqe.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cf(fVar.getVideoContainer())) {
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
                    View childAt2 = this.jqe.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cf(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.jqe.getListView().getChildAt(i6);
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
                    View childAt4 = this.jqe.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cf(fVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.hVx != null && (this.hVx.getTag() instanceof f)) {
                    ((f) this.hVx.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.hVx != null && this.hVx != view && (this.hVx.getTag() instanceof f)) {
                ((f) this.hVx.getTag()).stopPlay();
            }
            this.hVx = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bZC();
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
            ((e) view.getTag()).bZD();
        }
    }

    public boolean cf(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hVr - this.hVs && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cg(View view) {
        if (view != null && !cf(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hVB);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqg);
        cae();
    }

    public void xs(int i) {
        this.hVv = i;
    }

    public void cae() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jqe.getListView().getChildCount()) {
                View childAt = this.jqe.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void DD(String str) {
        this.hVu = str;
    }

    public void cah() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jqe.getListView().getChildCount()) {
                View childAt = this.jqe.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        xs(fVar.getCurrentPosition());
                        DD(fVar.getPlayUrl());
                        this.hVx = childAt;
                        this.hVy = fVar.isPlaying();
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

    public void cai() {
        if (this.mIsShowing) {
            if (this.hVx != null && (this.hVx.getTag() instanceof f)) {
                f fVar = (f) this.hVx.getTag();
                if (this.hVy) {
                    fVar.startPlay();
                }
                if (this.hVx.getTag() instanceof e) {
                    ((e) this.hVx.getTag()).bZE();
                }
            }
            this.hVx = null;
        }
    }

    public void bLD() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.hVB);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jqe.getListView().getChildCount()) {
                View childAt = this.jqe.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jqg);
        this.jqg.xj(i);
        this.jqg.xk(i2);
        this.jqg.lg(z);
        this.jqg.ol(z2);
        this.hVA.ol(z2);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jqg, 500L);
    }

    public void on(boolean z) {
        this.mIsShowing = z;
    }

    public void Ac(int i) {
        this.hVs = i;
    }

    public View cwe() {
        return this.hVx;
    }
}
