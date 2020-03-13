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
    private int bMt;
    private int ibh;
    private View ibn;
    private f ibp;
    private com.baidu.adp.widget.ListView.o juM;
    private com.baidu.adp.base.e mContext;
    private int juL = 0;
    private int ibi = 0;
    private String ibk = null;
    private int ibl = 0;
    private boolean ibo = false;
    private boolean mIsShowing = true;
    private a ibr = new a();
    private final CustomMessageListener cLz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bOq();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.ibq.czg(), m.this.ibq.czh(), m.this.ibq.czi(), m.this.ibq.czj());
                }
            }
        }
    };
    private final CustomMessageListener juN = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.ibr);
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(m.this.juO);
                    if (m.this.ibn != null && (m.this.ibn.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.ibn.getTag()).getPlayUrl())) {
                            ((f) m.this.ibn.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.juM.getListView().getChildCount()) {
                            View childAt = m.this.juM.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.ibn = childAt;
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
    private b juO = new b(this);
    private r ibq = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.ibh = 0;
        this.bMt = 0;
        this.mContext = eVar;
        this.ibh = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.juM = oVar;
        this.bMt = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.cLz);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cLz != null) {
                this.cLz.setTag(bdUniqueId);
            }
            if (this.juN != null) {
                this.juN.setSelfListener(true);
                this.juN.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cLz);
            MessageManager.getInstance().registerListener(this.juN);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.ibq.n(i, i2, z);
        if (this.juM != null && this.juM.getListView().getChildCount() != 0 && this.juM.getContentViewsCount() != 0) {
            if (this.ibp != null && !ck(this.ibp.getVideoContainer())) {
                this.ibp.stopPlay();
            }
            if (this.ibn != null && (this.ibn.getTag() instanceof f) && this.ibo) {
                if (ck(((f) this.ibn.getTag()).getVideoContainer())) {
                    f(i3, this.ibn);
                    this.ibo = false;
                    return;
                }
                this.ibn = null;
            }
            int contentViewsCount = this.juM.getContentViewsCount() + this.juM.getHeaderViewsCount() + this.juM.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.juM.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.juM.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.juM.getListView().getChildAt(i8);
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
                        View childAt3 = this.juM.getListView().getChildAt(i6);
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
                    View childAt4 = this.juM.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.ibn != null && (this.ibn.getTag() instanceof f)) {
                    ((f) this.ibn.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.ibn != null && this.ibn != view && (this.ibn.getTag() instanceof f)) {
                ((f) this.ibn.getTag()).stopPlay();
            }
            this.ibn = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).ccp();
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
            ((e) view.getTag()).ccq();
        }
    }

    public boolean ck(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.juL == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.ibh - this.ibi && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cl(View view) {
        if (view != null && !ck(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibr);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juO);
        ccR();
    }

    public void xD(int i) {
        this.ibl = i;
    }

    public void ccR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juM.getListView().getChildCount()) {
                View childAt = this.juM.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ee(String str) {
        this.ibk = str;
    }

    public void ccU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juM.getListView().getChildCount()) {
                View childAt = this.juM.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        xD(fVar.getCurrentPosition());
                        Ee(fVar.getPlayUrl());
                        this.ibn = childAt;
                        this.ibo = fVar.isPlaying();
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

    public void ccV() {
        if (this.mIsShowing) {
            if (this.ibn != null && (this.ibn.getTag() instanceof f)) {
                f fVar = (f) this.ibn.getTag();
                if (this.ibo) {
                    fVar.startPlay();
                    this.ibo = false;
                }
                if (this.ibn.getTag() instanceof e) {
                    ((e) this.ibn.getTag()).ccr();
                }
            }
            this.ibn = null;
        }
    }

    public void bOq() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ibr);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juO);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.juM.getListView().getChildCount()) {
                View childAt = this.juM.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.juO);
        this.juO.xu(i);
        this.juO.xv(i2);
        this.juO.lu(z);
        this.juO.oz(z2);
        this.ibq.oz(z2);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.juO, 500L);
    }

    public void oB(boolean z) {
        this.mIsShowing = z;
    }

    public void Aq(int i) {
        this.ibi = i;
    }

    public void Ar(int i) {
        this.juL = i;
    }

    public View cyJ() {
        return this.ibn;
    }
}
