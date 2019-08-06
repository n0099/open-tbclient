package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int aLx;
    private int hii;
    private View hio;
    private f hiq;
    private com.baidu.adp.widget.ListView.o iws;
    private com.baidu.adp.base.e mContext;
    private int hij = 0;
    private String hil = null;
    private int him = 0;
    private boolean hip = false;
    private boolean bmF = true;
    private a his = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bwz();
                if (m.this.bmF && m.this.bmF) {
                    m.this.c(m.this.hir.ceQ(), m.this.hir.ceR(), m.this.hir.ceS(), m.this.hir.ceT());
                }
            }
        }
    };
    private final CustomMessageListener iwt = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(m.this.his);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(m.this.iwu);
                    if (m.this.hio != null && (m.this.hio.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hio.getTag()).getPlayUrl())) {
                            ((f) m.this.hio.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.iws.getListView().getChildCount()) {
                            View childAt = m.this.iws.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hio = childAt;
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
    private b iwu = new b(this);
    private s hir = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hii = 0;
        this.aLx = 0;
        this.mContext = eVar;
        this.hii = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.iws = oVar;
        this.aLx = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.iwt != null) {
                this.iwt.setSelfListener(true);
                this.iwt.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.iwt);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hir.l(i, i2, z);
        if (this.iws != null && this.iws.getListView().getChildCount() != 0 && this.iws.getContentViewsCount() != 0) {
            if (this.hiq != null && !cm(this.hiq.getVideoContainer())) {
                this.hiq.stopPlay();
            }
            if (this.hio != null && (this.hio.getTag() instanceof f) && this.hip) {
                if (cm(((f) this.hio.getTag()).getVideoContainer())) {
                    h(i3, this.hio);
                    this.hio = null;
                    return;
                }
                this.hio = null;
            }
            int contentViewsCount = this.iws.getContentViewsCount() + this.iws.getHeaderViewsCount() + this.iws.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.iws.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.iws.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cm(fVar.getVideoContainer())) {
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
                    View childAt2 = this.iws.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cm(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.iws.getListView().getChildAt(i6);
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
                    View childAt4 = this.iws.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cm(fVar3.getVideoContainer()))) {
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
            }
        }
    }

    private void h(int i, View view) {
        if (view != null) {
            this.hio = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bmF && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bKT();
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
            ((e) view.getTag()).bKU();
        }
    }

    public boolean cm(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hii - this.hij && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cn(View view) {
        if (view != null && !cm(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.his);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwu);
        bLx();
    }

    public void wI(int i) {
        this.him = i;
    }

    public void bLx() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iws.getListView().getChildCount()) {
                View childAt = this.iws.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ae(String str) {
        this.hil = str;
    }

    public void bLA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iws.getListView().getChildCount()) {
                View childAt = this.iws.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        wI(fVar.getCurrentPosition());
                        Ae(fVar.getPlayUrl());
                        this.hio = childAt;
                        this.hip = fVar.isPlaying();
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

    public void bLB() {
        if (this.bmF) {
            if (this.hio != null && (this.hio.getTag() instanceof f)) {
                f fVar = (f) this.hio.getTag();
                if (this.hip) {
                    fVar.startPlay();
                }
                if (this.hio.getTag() instanceof e) {
                    ((e) this.hio.getTag()).bKV();
                }
            }
            this.hio = null;
        }
    }

    public void bwz() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.his);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwu);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iws.getListView().getChildCount()) {
                View childAt = this.iws.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iwu);
        this.iwu.wz(i);
        this.iwu.wA(i2);
        this.iwu.kd(z);
        this.iwu.nf(z2);
        this.hir.nf(z2);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iwu, 500L);
    }

    public void nh(boolean z) {
        this.bmF = z;
    }

    public void yY(int i) {
        this.hij = i;
    }

    public View cev() {
        return this.hio;
    }
}
