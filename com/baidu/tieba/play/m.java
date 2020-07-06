package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int cBI;
    private int jtE;
    private View jtK;
    private f jtM;
    private com.baidu.adp.widget.ListView.s kTc;
    private com.baidu.adp.base.e mContext;
    private int kTb = 0;
    private int jtF = 0;
    private String jtH = null;
    private int jtI = 0;
    private boolean jtL = false;
    private boolean mIsShowing = true;
    private a jtO = new a();
    private final CustomMessageListener dFp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.cjf();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.jtN.cVJ(), m.this.jtN.cVK(), m.this.jtN.cVL(), m.this.jtN.cVM());
                }
            }
        }
    };
    private final CustomMessageListener kTd = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ar.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(m.this.jtO);
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(m.this.kTe);
                    if (m.this.jtK != null && (m.this.jtK.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.jtK.getTag()).getPlayUrl())) {
                            ((f) m.this.jtK.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.kTc.getListView().getChildCount()) {
                            View childAt = m.this.kTc.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.jtK = childAt;
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
    private b kTe = new b(this);
    private r jtN = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.s sVar) {
        this.jtE = 0;
        this.cBI = 0;
        this.mContext = eVar;
        this.jtE = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.kTc = sVar;
        this.cBI = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dFp);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dFp != null) {
                this.dFp.setTag(bdUniqueId);
            }
            if (this.kTd != null) {
                this.kTd.setSelfListener(true);
                this.kTd.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dFp);
            MessageManager.getInstance().registerListener(this.kTd);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.jtN.n(i, i2, z);
        if (this.kTc != null && this.kTc.getListView().getChildCount() != 0 && this.kTc.getContentViewsCount() != 0) {
            if (this.jtM != null && !ct(this.jtM.getVideoContainer())) {
                this.jtM.stopPlay();
            }
            if (this.jtK != null && (this.jtK.getTag() instanceof f) && this.jtL) {
                if (ct(((f) this.jtK.getTag()).getVideoContainer())) {
                    f(i3, this.jtK);
                    this.jtL = false;
                    return;
                }
                this.jtK = null;
            }
            int contentViewsCount = this.kTc.getContentViewsCount() + this.kTc.getHeaderViewsCount() + this.kTc.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.kTc.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.kTc.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && ct(fVar.getVideoContainer())) {
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
                    View childAt2 = this.kTc.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && ct(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.kTc.getListView().getChildAt(i6);
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
                    View childAt4 = this.kTc.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || ct(fVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.jtK != null && (this.jtK.getTag() instanceof f)) {
                    ((f) this.jtK.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.jtK != null && this.jtK != view && (this.jtK.getTag() instanceof f)) {
                ((f) this.jtK.getTag()).stopPlay();
            }
            this.jtK = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).cxI();
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
            ((e) view.getTag()).cxJ();
        }
    }

    public boolean ct(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.kTb == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.jtE - this.jtF && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cu(View view) {
        if (view != null && !ct(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jtO);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTe);
        cyk();
    }

    public void zH(int i) {
        this.jtI = i;
    }

    public void cyk() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kTc.getListView().getChildCount()) {
                View childAt = this.kTc.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ia(String str) {
        this.jtH = str;
    }

    public void cyn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kTc.getListView().getChildCount()) {
                View childAt = this.kTc.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        zH(fVar.getCurrentPosition());
                        Ia(fVar.getPlayUrl());
                        this.jtK = childAt;
                        this.jtL = fVar.isPlaying();
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

    public void cyo() {
        if (this.mIsShowing) {
            if (this.jtK != null && (this.jtK.getTag() instanceof f)) {
                f fVar = (f) this.jtK.getTag();
                if (this.jtL) {
                    fVar.startPlay();
                    this.jtL = false;
                }
                if (this.jtK.getTag() instanceof e) {
                    ((e) this.jtK.getTag()).cxK();
                }
            }
            this.jtK = null;
        }
    }

    public void cjf() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jtO);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTe);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kTc.getListView().getChildCount()) {
                View childAt = this.kTc.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kTe);
        this.kTe.zy(i);
        this.kTe.zz(i2);
        this.kTe.nj(z);
        this.kTe.qq(z2);
        this.jtN.qq(z2);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.kTe, 500L);
    }

    public void qs(boolean z) {
        this.mIsShowing = z;
    }

    public void CM(int i) {
        this.jtF = i;
    }

    public void CN(int i) {
        this.kTb = i;
    }

    public View cVm() {
        return this.jtK;
    }
}
