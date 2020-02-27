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
    private int bMr;
    private int iaT;
    private View iaZ;
    private f ibb;
    private com.baidu.adp.widget.ListView.o juy;
    private com.baidu.adp.base.e mContext;
    private int jux = 0;
    private int iaU = 0;
    private String iaW = null;
    private int iaX = 0;
    private boolean iba = false;
    private boolean mIsShowing = true;
    private a ibd = new a();
    private final CustomMessageListener cLx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bOn();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.ibc.czd(), m.this.ibc.cze(), m.this.ibc.czf(), m.this.ibc.czg());
                }
            }
        }
    };
    private final CustomMessageListener juz = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.ibd);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.juA);
                    if (m.this.iaZ != null && (m.this.iaZ.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.iaZ.getTag()).getPlayUrl())) {
                            ((f) m.this.iaZ.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.juy.getListView().getChildCount()) {
                            View childAt = m.this.juy.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.iaZ = childAt;
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
    private b juA = new b(this);
    private r ibc = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.iaT = 0;
        this.bMr = 0;
        this.mContext = eVar;
        this.iaT = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.juy = oVar;
        this.bMr = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.cLx);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cLx != null) {
                this.cLx.setTag(bdUniqueId);
            }
            if (this.juz != null) {
                this.juz.setSelfListener(true);
                this.juz.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cLx);
            MessageManager.getInstance().registerListener(this.juz);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.ibc.n(i, i2, z);
        if (this.juy != null && this.juy.getListView().getChildCount() != 0 && this.juy.getContentViewsCount() != 0) {
            if (this.ibb != null && !ck(this.ibb.getVideoContainer())) {
                this.ibb.stopPlay();
            }
            if (this.iaZ != null && (this.iaZ.getTag() instanceof f) && this.iba) {
                if (ck(((f) this.iaZ.getTag()).getVideoContainer())) {
                    f(i3, this.iaZ);
                    this.iba = false;
                    return;
                }
                this.iaZ = null;
            }
            int contentViewsCount = this.juy.getContentViewsCount() + this.juy.getHeaderViewsCount() + this.juy.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.juy.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.juy.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.juy.getListView().getChildAt(i8);
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
                        View childAt3 = this.juy.getListView().getChildAt(i6);
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
                    View childAt4 = this.juy.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.iaZ != null && (this.iaZ.getTag() instanceof f)) {
                    ((f) this.iaZ.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.iaZ != null && this.iaZ != view && (this.iaZ.getTag() instanceof f)) {
                ((f) this.iaZ.getTag()).stopPlay();
            }
            this.iaZ = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).ccm();
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
            ((e) view.getTag()).ccn();
        }
    }

    public boolean ck(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.jux == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.iaT - this.iaU && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cl(View view) {
        if (view != null && !ck(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibd);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
        ccO();
    }

    public void xD(int i) {
        this.iaX = i;
    }

    public void ccO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juy.getListView().getChildCount()) {
                View childAt = this.juy.getListView().getChildAt(i2);
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
        this.iaW = str;
    }

    public void ccR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juy.getListView().getChildCount()) {
                View childAt = this.juy.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        xD(fVar.getCurrentPosition());
                        Ed(fVar.getPlayUrl());
                        this.iaZ = childAt;
                        this.iba = fVar.isPlaying();
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

    public void ccS() {
        if (this.mIsShowing) {
            if (this.iaZ != null && (this.iaZ.getTag() instanceof f)) {
                f fVar = (f) this.iaZ.getTag();
                if (this.iba) {
                    fVar.startPlay();
                    this.iba = false;
                }
                if (this.iaZ.getTag() instanceof e) {
                    ((e) this.iaZ.getTag()).cco();
                }
            }
            this.iaZ = null;
        }
    }

    public void bOn() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibd);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juy.getListView().getChildCount()) {
                View childAt = this.juy.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juA);
        this.juA.xu(i);
        this.juA.xv(i2);
        this.juA.lu(z);
        this.juA.oz(z2);
        this.ibc.oz(z2);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juA, 500L);
    }

    public void oB(boolean z) {
        this.mIsShowing = z;
    }

    public void Aq(int i) {
        this.iaU = i;
    }

    public void Ar(int i) {
        this.jux = i;
    }

    public View cyG() {
        return this.iaZ;
    }
}
