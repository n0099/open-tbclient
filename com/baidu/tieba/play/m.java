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
    private int bME;
    private int icH;
    private View icN;
    private f icP;
    private com.baidu.adp.widget.ListView.o jwl;
    private com.baidu.adp.base.e mContext;
    private int jwk = 0;
    private int icI = 0;
    private String icK = null;
    private int icL = 0;
    private boolean icO = false;
    private boolean mIsShowing = true;
    private a icR = new a();
    private final CustomMessageListener cLK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bOE();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.icQ.czz(), m.this.icQ.czA(), m.this.icQ.czB(), m.this.icQ.czC());
                }
            }
        }
    };
    private final CustomMessageListener jwm = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.icR);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.jwn);
                    if (m.this.icN != null && (m.this.icN.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.icN.getTag()).getPlayUrl())) {
                            ((f) m.this.icN.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.jwl.getListView().getChildCount()) {
                            View childAt = m.this.jwl.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.icN = childAt;
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
    private b jwn = new b(this);
    private r icQ = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.icH = 0;
        this.bME = 0;
        this.mContext = eVar;
        this.icH = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.jwl = oVar;
        this.bME = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.cLK);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cLK != null) {
                this.cLK.setTag(bdUniqueId);
            }
            if (this.jwm != null) {
                this.jwm.setSelfListener(true);
                this.jwm.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cLK);
            MessageManager.getInstance().registerListener(this.jwm);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.icQ.n(i, i2, z);
        if (this.jwl != null && this.jwl.getListView().getChildCount() != 0 && this.jwl.getContentViewsCount() != 0) {
            if (this.icP != null && !ck(this.icP.getVideoContainer())) {
                this.icP.stopPlay();
            }
            if (this.icN != null && (this.icN.getTag() instanceof f) && this.icO) {
                if (ck(((f) this.icN.getTag()).getVideoContainer())) {
                    f(i3, this.icN);
                    this.icO = false;
                    return;
                }
                this.icN = null;
            }
            int contentViewsCount = this.jwl.getContentViewsCount() + this.jwl.getHeaderViewsCount() + this.jwl.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.jwl.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.jwl.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.jwl.getListView().getChildAt(i8);
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
                        View childAt3 = this.jwl.getListView().getChildAt(i6);
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
                    View childAt4 = this.jwl.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.icN != null && (this.icN.getTag() instanceof f)) {
                    ((f) this.icN.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.icN != null && this.icN != view && (this.icN.getTag() instanceof f)) {
                ((f) this.icN.getTag()).stopPlay();
            }
            this.icN = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).ccI();
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
            ((e) view.getTag()).ccJ();
        }
    }

    public boolean ck(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.jwk == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.icH - this.icI && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cl(View view) {
        if (view != null && !ck(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.icR);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwn);
        cdk();
    }

    public void xL(int i) {
        this.icL = i;
    }

    public void cdk() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jwl.getListView().getChildCount()) {
                View childAt = this.jwl.getListView().getChildAt(i2);
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
        this.icK = str;
    }

    public void cdn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jwl.getListView().getChildCount()) {
                View childAt = this.jwl.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        xL(fVar.getCurrentPosition());
                        Ed(fVar.getPlayUrl());
                        this.icN = childAt;
                        this.icO = fVar.isPlaying();
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

    public void cdo() {
        if (this.mIsShowing) {
            if (this.icN != null && (this.icN.getTag() instanceof f)) {
                f fVar = (f) this.icN.getTag();
                if (this.icO) {
                    fVar.startPlay();
                    this.icO = false;
                }
                if (this.icN.getTag() instanceof e) {
                    ((e) this.icN.getTag()).ccK();
                }
            }
            this.icN = null;
        }
    }

    public void bOE() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.icR);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwn);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jwl.getListView().getChildCount()) {
                View childAt = this.jwl.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jwn);
        this.jwn.xC(i);
        this.jwn.xD(i2);
        this.jwn.lA(z);
        this.jwn.oF(z2);
        this.icQ.oF(z2);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jwn, 500L);
    }

    public void oH(boolean z) {
        this.mIsShowing = z;
    }

    public void Ay(int i) {
        this.icI = i;
    }

    public void Az(int i) {
        this.jwk = i;
    }

    public View czc() {
        return this.icN;
    }
}
