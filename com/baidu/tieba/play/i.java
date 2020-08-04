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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private int cEv;
    private int jCk;
    private View jCq;
    private e jCs;
    private s lbZ;
    private com.baidu.adp.base.e mContext;
    private int lbY = 0;
    private int jCl = 0;
    private String jCn = null;
    private int jCo = 0;
    private boolean jCr = false;
    private boolean mIsShowing = true;
    private a jCu = new a();
    private final CustomMessageListener dLm = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cmG();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.jCt.cYR(), i.this.jCt.cYS(), i.this.jCt.cYT(), i.this.jCt.cYU());
                }
            }
        }
    };
    private final CustomMessageListener lca = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!as.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(i.this.jCu);
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(i.this.lcb);
                    if (i.this.jCq != null && (i.this.jCq.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.jCq.getTag()).getPlayUrl())) {
                            ((e) i.this.jCq.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.lbZ.getListView().getChildCount()) {
                            View childAt = i.this.lbZ.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.jCq = childAt;
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
    private b lcb = new b(this);
    private l jCt = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.jCk = 0;
        this.cEv = 0;
        this.mContext = eVar;
        this.jCk = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lbZ = sVar;
        this.cEv = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dLm);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dLm != null) {
                this.dLm.setTag(bdUniqueId);
            }
            if (this.lca != null) {
                this.lca.setSelfListener(true);
                this.lca.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dLm);
            MessageManager.getInstance().registerListener(this.lca);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.jCt.m(i, i2, z);
        if (this.lbZ != null && this.lbZ.getListView().getChildCount() != 0 && this.lbZ.getContentViewsCount() != 0) {
            if (this.jCs != null && !cz(this.jCs.getVideoContainer())) {
                this.jCs.stopPlay();
            }
            if (this.jCq != null && (this.jCq.getTag() instanceof e) && this.jCr) {
                if (cz(((e) this.jCq.getTag()).getVideoContainer())) {
                    f(i3, this.jCq);
                    this.jCr = false;
                    return;
                }
                this.jCq = null;
            }
            int contentViewsCount = this.lbZ.getContentViewsCount() + this.lbZ.getHeaderViewsCount() + this.lbZ.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.lbZ.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.lbZ.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && cz(eVar.getVideoContainer())) {
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
                    View childAt2 = this.lbZ.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && cz(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.lbZ.getListView().getChildAt(i6);
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
                    View childAt4 = this.lbZ.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || cz(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.jCq != null && (this.jCq.getTag() instanceof e)) {
                    ((e) this.jCq.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.jCq != null && this.jCq != view && (this.jCq.getTag() instanceof e)) {
                ((e) this.jCq.getTag()).stopPlay();
            }
            this.jCq = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cBG();
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
            ((d) view.getTag()).cBH();
        }
    }

    public boolean cz(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.lbY == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.jCk - this.jCl && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cA(View view) {
        if (view != null && !cz(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jCu);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lcb);
        cCi();
    }

    public void Ag(int i) {
        this.jCo = i;
    }

    public void cCi() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lbZ.getListView().getChildCount()) {
                View childAt = this.lbZ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void IP(String str) {
        this.jCn = str;
    }

    public void cCl() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lbZ.getListView().getChildCount()) {
                View childAt = this.lbZ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ag(eVar.getCurrentPosition());
                        IP(eVar.getPlayUrl());
                        this.jCq = childAt;
                        this.jCr = eVar.isPlaying();
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

    public void cCm() {
        if (this.mIsShowing) {
            if (this.jCq != null && (this.jCq.getTag() instanceof e)) {
                e eVar = (e) this.jCq.getTag();
                if (this.jCr) {
                    eVar.startPlay();
                    this.jCr = false;
                }
                if (this.jCq.getTag() instanceof d) {
                    ((d) this.jCq.getTag()).cBI();
                }
            }
            this.jCq = null;
        }
    }

    public void cmG() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jCu);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lcb);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lbZ.getListView().getChildCount()) {
                View childAt = this.lbZ.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lcb);
        this.lcb.zX(i);
        this.lcb.zY(i2);
        this.lcb.nO(z);
        this.lcb.qX(z2);
        this.jCt.qX(z2);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.lcb, 500L);
    }

    public void qZ(boolean z) {
        this.mIsShowing = z;
    }

    public void Dl(int i) {
        this.jCl = i;
    }

    public void Dm(int i) {
        this.lbY = i;
    }

    public View cYQ() {
        return this.jCq;
    }
}
