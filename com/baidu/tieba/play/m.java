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
    private int beQ;
    private int hhp;
    private View hhv;
    private f hhx;
    private com.baidu.adp.widget.ListView.o iwe;
    private com.baidu.adp.base.e mContext;
    private int hhq = 0;
    private String hhs = null;
    private int hht = 0;
    private boolean hhw = false;
    private boolean bEY = true;
    private a hhz = new a();
    private final CustomMessageListener bUR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bup();
                if (m.this.bEY && m.this.bEY) {
                    m.this.c(m.this.hhy.ccD(), m.this.hhy.ccE(), m.this.hhy.ccF(), m.this.hhy.ccG());
                }
            }
        }
    };
    private final CustomMessageListener iwf = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(m.this.hhz);
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(m.this.iwg);
                    if (m.this.hhv != null && (m.this.hhv.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hhv.getTag()).getPlayUrl())) {
                            ((f) m.this.hhv.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.iwe.getListView().getChildCount()) {
                            View childAt = m.this.iwe.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hhv = childAt;
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
    private b iwg = new b(this);
    private s hhy = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hhp = 0;
        this.beQ = 0;
        this.mContext = eVar;
        this.hhp = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.iwe = oVar;
        this.beQ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.bUR);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bUR != null) {
                this.bUR.setTag(bdUniqueId);
            }
            if (this.iwf != null) {
                this.iwf.setSelfListener(true);
                this.iwf.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bUR);
            MessageManager.getInstance().registerListener(this.iwf);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hhy.l(i, i2, z);
        if (this.iwe != null && this.iwe.getListView().getChildCount() != 0 && this.iwe.getContentViewsCount() != 0) {
            if (this.hhx != null && !cj(this.hhx.getVideoContainer())) {
                this.hhx.stopPlay();
            }
            if (this.hhv != null && (this.hhv.getTag() instanceof f) && this.hhw) {
                if (cj(((f) this.hhv.getTag()).getVideoContainer())) {
                    h(i3, this.hhv);
                    return;
                }
                this.hhv = null;
            }
            int contentViewsCount = this.iwe.getContentViewsCount() + this.iwe.getHeaderViewsCount() + this.iwe.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.iwe.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.iwe.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.iwe.getListView().getChildAt(i8);
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
                        View childAt3 = this.iwe.getListView().getChildAt(i6);
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
                    View childAt4 = this.iwe.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.hhv != null && (this.hhv.getTag() instanceof f)) {
                    ((f) this.hhv.getTag()).stopPlay();
                }
            }
        }
    }

    private void h(int i, View view) {
        if (view != null) {
            if (this.hhv != null && this.hhv != view && (this.hhv.getTag() instanceof f)) {
                ((f) this.hhv.getTag()).stopPlay();
            }
            this.hhv = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bEY && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bIo();
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
            ((e) view.getTag()).bIp();
        }
    }

    public boolean cj(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hhp - this.hhq && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void ck(View view) {
        if (view != null && !cj(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hhz);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwg);
        bIR();
    }

    public void vq(int i) {
        this.hht = i;
    }

    public void bIR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwe.getListView().getChildCount()) {
                View childAt = this.iwe.getListView().getChildAt(i2);
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
        this.hhs = str;
    }

    public void bIU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwe.getListView().getChildCount()) {
                View childAt = this.iwe.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        vq(fVar.getCurrentPosition());
                        yV(fVar.getPlayUrl());
                        this.hhv = childAt;
                        this.hhw = fVar.isPlaying();
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

    public void bIV() {
        if (this.bEY) {
            if (this.hhv != null && (this.hhv.getTag() instanceof f)) {
                f fVar = (f) this.hhv.getTag();
                if (this.hhw) {
                    fVar.startPlay();
                }
                if (this.hhv.getTag() instanceof e) {
                    ((e) this.hhv.getTag()).bIq();
                }
            }
            this.hhv = null;
        }
    }

    public void bup() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hhz);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iwe.getListView().getChildCount()) {
                View childAt = this.iwe.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iwg);
        this.iwg.vh(i);
        this.iwg.vi(i2);
        this.iwg.jU(z);
        this.iwg.mW(z2);
        this.hhy.mW(z2);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iwg, 500L);
    }

    public void mY(boolean z) {
        this.bEY = z;
    }

    public void xF(int i) {
        this.hhq = i;
    }

    public View cck() {
        return this.hhv;
    }
}
