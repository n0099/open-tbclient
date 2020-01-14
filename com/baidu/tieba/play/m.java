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
    private int bIm;
    private int hYV;
    private View hZb;
    private f hZd;
    private com.baidu.adp.widget.ListView.o jtK;
    private com.baidu.adp.base.e mContext;
    private int hYW = 0;
    private String hYY = null;
    private int hYZ = 0;
    private boolean hZc = false;
    private boolean mIsShowing = true;
    private a hZf = new a();
    private final CustomMessageListener cHu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bML();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.hZe.cxJ(), m.this.hZe.cxK(), m.this.hZe.cxL(), m.this.hZe.cxM());
                }
            }
        }
    };
    private final CustomMessageListener jtL = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.hZf);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.jtM);
                    if (m.this.hZb != null && (m.this.hZb.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hZb.getTag()).getPlayUrl())) {
                            ((f) m.this.hZb.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.jtK.getListView().getChildCount()) {
                            View childAt = m.this.jtK.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hZb = childAt;
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
    private b jtM = new b(this);
    private r hZe = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hYV = 0;
        this.bIm = 0;
        this.mContext = eVar;
        this.hYV = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.jtK = oVar;
        this.bIm = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.cHu);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cHu != null) {
                this.cHu.setTag(bdUniqueId);
            }
            if (this.jtL != null) {
                this.jtL.setSelfListener(true);
                this.jtL.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cHu);
            MessageManager.getInstance().registerListener(this.jtL);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hZe.n(i, i2, z);
        if (this.jtK != null && this.jtK.getListView().getChildCount() != 0 && this.jtK.getContentViewsCount() != 0) {
            if (this.hZd != null && !ck(this.hZd.getVideoContainer())) {
                this.hZd.stopPlay();
            }
            if (this.hZb != null && (this.hZb.getTag() instanceof f) && this.hZc) {
                if (ck(((f) this.hZb.getTag()).getVideoContainer())) {
                    f(i3, this.hZb);
                    return;
                }
                this.hZb = null;
            }
            int contentViewsCount = this.jtK.getContentViewsCount() + this.jtK.getHeaderViewsCount() + this.jtK.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.jtK.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.jtK.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.jtK.getListView().getChildAt(i8);
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
                        View childAt3 = this.jtK.getListView().getChildAt(i6);
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
                    View childAt4 = this.jtK.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.hZb != null && (this.hZb.getTag() instanceof f)) {
                    ((f) this.hZb.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.hZb != null && this.hZb != view && (this.hZb.getTag() instanceof f)) {
                ((f) this.hZb.getTag()).stopPlay();
            }
            this.hZb = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).caL();
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
            ((e) view.getTag()).caM();
        }
    }

    public boolean ck(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hYV - this.hYW && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cl(View view) {
        if (view != null && !ck(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZf);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jtM);
        cbn();
    }

    public void xx(int i) {
        this.hYZ = i;
    }

    public void cbn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jtK.getListView().getChildCount()) {
                View childAt = this.jtK.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void DN(String str) {
        this.hYY = str;
    }

    public void cbq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jtK.getListView().getChildCount()) {
                View childAt = this.jtK.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        xx(fVar.getCurrentPosition());
                        DN(fVar.getPlayUrl());
                        this.hZb = childAt;
                        this.hZc = fVar.isPlaying();
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

    public void cbr() {
        if (this.mIsShowing) {
            if (this.hZb != null && (this.hZb.getTag() instanceof f)) {
                f fVar = (f) this.hZb.getTag();
                if (this.hZc) {
                    fVar.startPlay();
                }
                if (this.hZb.getTag() instanceof e) {
                    ((e) this.hZb.getTag()).caN();
                }
            }
            this.hZb = null;
        }
    }

    public void bML() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hZf);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jtM);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jtK.getListView().getChildCount()) {
                View childAt = this.jtK.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jtM);
        this.jtM.xo(i);
        this.jtM.xp(i2);
        this.jtM.lr(z);
        this.jtM.ox(z2);
        this.hZe.ox(z2);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jtM, 500L);
    }

    public void oz(boolean z) {
        this.mIsShowing = z;
    }

    public void Ah(int i) {
        this.hYW = i;
    }

    public View cxn() {
        return this.hZb;
    }
}
