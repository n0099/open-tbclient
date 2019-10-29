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
    private int bfj;
    private int hih;
    private View hin;
    private f hip;
    private com.baidu.adp.widget.ListView.o iwV;
    private com.baidu.adp.base.e mContext;
    private int hii = 0;
    private String hik = null;
    private int hil = 0;
    private boolean hio = false;
    private boolean bFP = true;
    private a hir = new a();
    private final CustomMessageListener bVI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bur();
                if (m.this.bFP && m.this.bFP) {
                    m.this.c(m.this.hiq.ccF(), m.this.hiq.ccG(), m.this.hiq.ccH(), m.this.hiq.ccI());
                }
            }
        }
    };
    private final CustomMessageListener iwW = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(m.this.hir);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(m.this.iwX);
                    if (m.this.hin != null && (m.this.hin.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hin.getTag()).getPlayUrl())) {
                            ((f) m.this.hin.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.iwV.getListView().getChildCount()) {
                            View childAt = m.this.iwV.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hin = childAt;
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
    private b iwX = new b(this);
    private s hiq = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hih = 0;
        this.bfj = 0;
        this.mContext = eVar;
        this.hih = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.iwV = oVar;
        this.bfj = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.bVI);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bVI != null) {
                this.bVI.setTag(bdUniqueId);
            }
            if (this.iwW != null) {
                this.iwW.setSelfListener(true);
                this.iwW.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bVI);
            MessageManager.getInstance().registerListener(this.iwW);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hiq.l(i, i2, z);
        if (this.iwV != null && this.iwV.getListView().getChildCount() != 0 && this.iwV.getContentViewsCount() != 0) {
            if (this.hip != null && !cj(this.hip.getVideoContainer())) {
                this.hip.stopPlay();
            }
            if (this.hin != null && (this.hin.getTag() instanceof f) && this.hio) {
                if (cj(((f) this.hin.getTag()).getVideoContainer())) {
                    h(i3, this.hin);
                    return;
                }
                this.hin = null;
            }
            int contentViewsCount = this.iwV.getContentViewsCount() + this.iwV.getHeaderViewsCount() + this.iwV.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.iwV.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.iwV.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cj(fVar.getVideoContainer())) {
                            h(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            i(i3, childAt);
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
                    View childAt2 = this.iwV.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cj(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.iwV.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            i(i3, childAt3);
                        } else {
                            h(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.iwV.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cj(fVar3.getVideoContainer()))) {
                            h(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            i(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
                if (i6 == 0 && this.hin != null && (this.hin.getTag() instanceof f)) {
                    ((f) this.hin.getTag()).stopPlay();
                }
            }
        }
    }

    private void h(int i, View view) {
        if (view != null) {
            if (this.hin != null && this.hin != view && (this.hin.getTag() instanceof f)) {
                ((f) this.hin.getTag()).stopPlay();
            }
            this.hin = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bFP && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bIq();
            }
        }
    }

    private void i(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            f fVar = (f) view.getTag();
            if (fVar.isPlaying()) {
                fVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).bIr();
        }
    }

    public boolean cj(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hih - this.hii && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void ck(View view) {
        if (view != null && !cj(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hir);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwX);
        bIT();
    }

    public void vr(int i) {
        this.hil = i;
    }

    public void bIT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwV.getListView().getChildCount()) {
                View childAt = this.iwV.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void yV(String str) {
        this.hik = str;
    }

    public void bIW() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwV.getListView().getChildCount()) {
                View childAt = this.iwV.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        vr(fVar.getCurrentPosition());
                        yV(fVar.getPlayUrl());
                        this.hin = childAt;
                        this.hio = fVar.isPlaying();
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

    public void bIX() {
        if (this.bFP) {
            if (this.hin != null && (this.hin.getTag() instanceof f)) {
                f fVar = (f) this.hin.getTag();
                if (this.hio) {
                    fVar.startPlay();
                }
                if (this.hin.getTag() instanceof e) {
                    ((e) this.hin.getTag()).bIs();
                }
            }
            this.hin = null;
        }
    }

    public void bur() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hir);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwX);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwV.getListView().getChildCount()) {
                View childAt = this.iwV.getListView().getChildAt(i2);
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

    public void c(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwX);
        this.iwX.vi(i);
        this.iwX.vj(i2);
        this.iwX.jU(z);
        this.iwX.mW(z2);
        this.hiq.mW(z2);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iwX, 500L);
    }

    public void mY(boolean z) {
        this.bFP = z;
    }

    public void xG(int i) {
        this.hii = i;
    }

    public View ccm() {
        return this.hin;
    }
}
