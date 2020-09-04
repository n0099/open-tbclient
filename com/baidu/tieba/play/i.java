package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private int cNx;
    private int jRJ;
    private View jRP;
    private e jRR;
    private s lsA;
    private com.baidu.adp.base.e mContext;
    private int lsz = 0;
    private int jRK = 0;
    private String jRM = null;
    private int jRN = 0;
    private boolean jRQ = false;
    private boolean mIsShowing = true;
    private a jRT = new a();
    private final CustomMessageListener dUy = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cxq();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.jRS.djX(), i.this.jRS.djY(), i.this.jRS.djZ(), i.this.jRS.dka());
                }
            }
        }
    };
    private final CustomMessageListener lsB = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(i.this.jRT);
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(i.this.lsC);
                    if (i.this.jRP != null && (i.this.jRP.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.jRP.getTag()).getPlayUrl())) {
                            ((e) i.this.jRP.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.lsA.getListView().getChildCount()) {
                            View childAt = i.this.lsA.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.jRP = childAt;
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
    private b lsC = new b(this);
    private l jRS = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.jRJ = 0;
        this.cNx = 0;
        this.mContext = eVar;
        this.jRJ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lsA = sVar;
        this.cNx = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dUy);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dUy != null) {
                this.dUy.setTag(bdUniqueId);
            }
            if (this.lsB != null) {
                this.lsB.setSelfListener(true);
                this.lsB.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dUy);
            MessageManager.getInstance().registerListener(this.lsB);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.jRS.l(i, i2, z);
        if (this.lsA != null && this.lsA.getListView().getChildCount() != 0 && this.lsA.getContentViewsCount() != 0) {
            if (this.jRR != null && !cD(this.jRR.getVideoContainer())) {
                this.jRR.stopPlay();
            }
            if (this.jRP != null && (this.jRP.getTag() instanceof e) && this.jRQ) {
                if (cD(((e) this.jRP.getTag()).getVideoContainer())) {
                    f(i3, this.jRP);
                    this.jRQ = false;
                    return;
                }
                this.jRP = null;
            }
            int contentViewsCount = this.lsA.getContentViewsCount() + this.lsA.getHeaderViewsCount() + this.lsA.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.lsA.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.lsA.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && cD(eVar.getVideoContainer())) {
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
                    View childAt2 = this.lsA.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && cD(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.lsA.getListView().getChildAt(i6);
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
                    View childAt4 = this.lsA.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || cD(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.jRP != null && (this.jRP.getTag() instanceof e)) {
                    ((e) this.jRP.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.jRP != null && this.jRP != view && (this.jRP.getTag() instanceof e)) {
                ((e) this.jRP.getTag()).stopPlay();
            }
            this.jRP = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cMz();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.isPlaying()) {
                eVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).cMA();
        }
    }

    public boolean cD(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.lsz == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.jRJ - this.jRK && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cE(View view) {
        if (view != null && !cD(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jRT);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsC);
        cNb();
    }

    public void Cz(int i) {
        this.jRN = i;
    }

    public void cNb() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lsA.getListView().getChildCount()) {
                View childAt = this.lsA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void LI(String str) {
        this.jRM = str;
    }

    public void cNe() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lsA.getListView().getChildCount()) {
                View childAt = this.lsA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Cz(eVar.getCurrentPosition());
                        LI(eVar.getPlayUrl());
                        this.jRP = childAt;
                        this.jRQ = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cNf() {
        if (this.mIsShowing) {
            if (this.jRP != null && (this.jRP.getTag() instanceof e)) {
                e eVar = (e) this.jRP.getTag();
                if (this.jRQ) {
                    eVar.startPlay();
                    this.jRQ = false;
                }
                if (this.jRP.getTag() instanceof d) {
                    ((d) this.jRP.getTag()).cMB();
                }
            }
            this.jRP = null;
        }
    }

    public void cxq() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jRT);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsC);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lsA.getListView().getChildCount()) {
                View childAt = this.lsA.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        eVar.stopPlay();
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
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsC);
        this.lsC.Cq(i);
        this.lsC.Cr(i2);
        this.lsC.ou(z);
        this.lsC.rF(z2);
        this.jRS.rF(z2);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.lsC, 500L);
    }

    public void rH(boolean z) {
        this.mIsShowing = z;
    }

    public void FG(int i) {
        this.jRK = i;
    }

    public void FH(int i) {
        this.lsz = i;
    }

    public View djW() {
        return this.jRP;
    }
}
