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
/* loaded from: classes2.dex */
public class i {
    private int cNt;
    private int jRD;
    private View jRJ;
    private e jRL;
    private s lsp;
    private com.baidu.adp.base.e mContext;
    private int lso = 0;
    private int jRE = 0;
    private String jRG = null;
    private int jRH = 0;
    private boolean jRK = false;
    private boolean mIsShowing = true;
    private a jRN = new a();
    private final CustomMessageListener dUu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cxp();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.jRM.djU(), i.this.jRM.djV(), i.this.jRM.djW(), i.this.jRM.djX());
                }
            }
        }
    };
    private final CustomMessageListener lsq = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(i.this.jRN);
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(i.this.lsr);
                    if (i.this.jRJ != null && (i.this.jRJ.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.jRJ.getTag()).getPlayUrl())) {
                            ((e) i.this.jRJ.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.lsp.getListView().getChildCount()) {
                            View childAt = i.this.lsp.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.jRJ = childAt;
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
    private b lsr = new b(this);
    private l jRM = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.jRD = 0;
        this.cNt = 0;
        this.mContext = eVar;
        this.jRD = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lsp = sVar;
        this.cNt = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dUu);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dUu != null) {
                this.dUu.setTag(bdUniqueId);
            }
            if (this.lsq != null) {
                this.lsq.setSelfListener(true);
                this.lsq.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dUu);
            MessageManager.getInstance().registerListener(this.lsq);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.jRM.l(i, i2, z);
        if (this.lsp != null && this.lsp.getListView().getChildCount() != 0 && this.lsp.getContentViewsCount() != 0) {
            if (this.jRL != null && !cD(this.jRL.getVideoContainer())) {
                this.jRL.stopPlay();
            }
            if (this.jRJ != null && (this.jRJ.getTag() instanceof e) && this.jRK) {
                if (cD(((e) this.jRJ.getTag()).getVideoContainer())) {
                    f(i3, this.jRJ);
                    this.jRK = false;
                    return;
                }
                this.jRJ = null;
            }
            int contentViewsCount = this.lsp.getContentViewsCount() + this.lsp.getHeaderViewsCount() + this.lsp.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.lsp.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.lsp.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.lsp.getListView().getChildAt(i8);
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
                        View childAt3 = this.lsp.getListView().getChildAt(i6);
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
                    View childAt4 = this.lsp.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.jRJ != null && (this.jRJ.getTag() instanceof e)) {
                    ((e) this.jRJ.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.jRJ != null && this.jRJ != view && (this.jRJ.getTag() instanceof e)) {
                ((e) this.jRJ.getTag()).stopPlay();
            }
            this.jRJ = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cMy();
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
            ((d) view.getTag()).cMz();
        }
    }

    public boolean cD(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.lso == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.jRD - this.jRE && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cE(View view) {
        if (view != null && !cD(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jRN);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsr);
        cNa();
    }

    public void Cz(int i) {
        this.jRH = i;
    }

    public void cNa() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lsp.getListView().getChildCount()) {
                View childAt = this.lsp.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void LH(String str) {
        this.jRG = str;
    }

    public void cNd() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lsp.getListView().getChildCount()) {
                View childAt = this.lsp.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Cz(eVar.getCurrentPosition());
                        LH(eVar.getPlayUrl());
                        this.jRJ = childAt;
                        this.jRK = eVar.isPlaying();
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

    public void cNe() {
        if (this.mIsShowing) {
            if (this.jRJ != null && (this.jRJ.getTag() instanceof e)) {
                e eVar = (e) this.jRJ.getTag();
                if (this.jRK) {
                    eVar.startPlay();
                    this.jRK = false;
                }
                if (this.jRJ.getTag() instanceof d) {
                    ((d) this.jRJ.getTag()).cMA();
                }
            }
            this.jRJ = null;
        }
    }

    public void cxp() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jRN);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lsp.getListView().getChildCount()) {
                View childAt = this.lsp.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lsr);
        this.lsr.Cq(i);
        this.lsr.Cr(i2);
        this.lsr.os(z);
        this.lsr.rD(z2);
        this.jRM.rD(z2);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.lsr, 500L);
    }

    public void rF(boolean z) {
        this.mIsShowing = z;
    }

    public void FG(int i) {
        this.jRE = i;
    }

    public void FH(int i) {
        this.lso = i;
    }

    public View djT() {
        return this.jRJ;
    }
}
