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
    private int hhp;
    private View hhv;
    private f hhx;
    private com.baidu.adp.widget.ListView.o ivp;
    private com.baidu.adp.base.e mContext;
    private int hhq = 0;
    private String hhs = null;
    private int hht = 0;
    private boolean hhw = false;
    private boolean bmF = true;
    private a hhz = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bwl();
                if (m.this.bmF && m.this.bmF) {
                    m.this.c(m.this.hhy.cey(), m.this.hhy.cez(), m.this.hhy.ceA(), m.this.hhy.ceB());
                }
            }
        }
    };
    private final CustomMessageListener ivq = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(m.this.hhz);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(m.this.ivr);
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
                        if (i2 < m.this.ivp.getListView().getChildCount()) {
                            View childAt = m.this.ivp.getListView().getChildAt(i2);
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
    private b ivr = new b(this);
    private s hhy = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hhp = 0;
        this.aLx = 0;
        this.mContext = eVar;
        this.hhp = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.ivp = oVar;
        this.aLx = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.ivq != null) {
                this.ivq.setSelfListener(true);
                this.ivq.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.ivq);
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
        if (this.ivp != null && this.ivp.getListView().getChildCount() != 0 && this.ivp.getContentViewsCount() != 0) {
            if (this.hhx != null && !cl(this.hhx.getVideoContainer())) {
                this.hhx.stopPlay();
            }
            if (this.hhv != null && (this.hhv.getTag() instanceof f) && this.hhw) {
                if (cl(((f) this.hhv.getTag()).getVideoContainer())) {
                    h(i3, this.hhv);
                    this.hhv = null;
                    return;
                }
                this.hhv = null;
            }
            int contentViewsCount = this.ivp.getContentViewsCount() + this.ivp.getHeaderViewsCount() + this.ivp.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.ivp.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.ivp.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cl(fVar.getVideoContainer())) {
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
                    View childAt2 = this.ivp.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cl(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.ivp.getListView().getChildAt(i6);
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
                    View childAt4 = this.ivp.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cl(fVar3.getVideoContainer()))) {
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
            this.hhv = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bmF && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bKF();
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
            ((e) view.getTag()).bKG();
        }
    }

    public boolean cl(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hhp - this.hhq && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cm(View view) {
        if (view != null && !cl(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hhz);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ivr);
        bLj();
    }

    public void wG(int i) {
        this.hht = i;
    }

    public void bLj() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ivp.getListView().getChildCount()) {
                View childAt = this.ivp.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ad(String str) {
        this.hhs = str;
    }

    public void bLm() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ivp.getListView().getChildCount()) {
                View childAt = this.ivp.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        wG(fVar.getCurrentPosition());
                        Ad(fVar.getPlayUrl());
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

    public void bLn() {
        if (this.bmF) {
            if (this.hhv != null && (this.hhv.getTag() instanceof f)) {
                f fVar = (f) this.hhv.getTag();
                if (this.hhw) {
                    fVar.startPlay();
                }
                if (this.hhv.getTag() instanceof e) {
                    ((e) this.hhv.getTag()).bKH();
                }
            }
            this.hhv = null;
        }
    }

    public void bwl() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hhz);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ivr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ivp.getListView().getChildCount()) {
                View childAt = this.ivp.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ivr);
        this.ivr.wx(i);
        this.ivr.wy(i2);
        this.ivr.kd(z);
        this.ivr.nf(z2);
        this.hhy.nf(z2);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.ivr, 500L);
    }

    public void nh(boolean z) {
        this.bmF = z;
    }

    public void yW(int i) {
        this.hhq = i;
    }

    public View ced() {
        return this.hhv;
    }
}
