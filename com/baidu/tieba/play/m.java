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
    private int cwY;
    private View jcA;
    private f jcC;
    private int jcu;
    private com.baidu.adp.widget.ListView.q kzf;
    private com.baidu.adp.base.e mContext;
    private int kze = 0;
    private int jcv = 0;
    private String jcx = null;
    private int jcy = 0;
    private boolean jcB = false;
    private boolean mIsShowing = true;
    private a jcE = new a();
    private final CustomMessageListener dyW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.cfI();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.a(m.this.jcD.cRr(), m.this.jcD.cRs(), m.this.jcD.cRt(), m.this.jcD.cRu());
                }
            }
        }
    };
    private final CustomMessageListener kzg = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(m.this.jcE);
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(m.this.kzh);
                    if (m.this.jcA != null && (m.this.jcA.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.jcA.getTag()).getPlayUrl())) {
                            ((f) m.this.jcA.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.kzf.getListView().getChildCount()) {
                            View childAt = m.this.kzf.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.jcA = childAt;
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
    private b kzh = new b(this);
    private r jcD = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.q qVar) {
        this.jcu = 0;
        this.cwY = 0;
        this.mContext = eVar;
        this.jcu = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.kzf = qVar;
        this.cwY = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dyW);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dyW != null) {
                this.dyW.setTag(bdUniqueId);
            }
            if (this.kzg != null) {
                this.kzg.setSelfListener(true);
                this.kzg.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dyW);
            MessageManager.getInstance().registerListener(this.kzg);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.jcD.n(i, i2, z);
        if (this.kzf != null && this.kzf.getListView().getChildCount() != 0 && this.kzf.getContentViewsCount() != 0) {
            if (this.jcC != null && !cs(this.jcC.getVideoContainer())) {
                this.jcC.stopPlay();
            }
            if (this.jcA != null && (this.jcA.getTag() instanceof f) && this.jcB) {
                if (cs(((f) this.jcA.getTag()).getVideoContainer())) {
                    f(i3, this.jcA);
                    this.jcB = false;
                    return;
                }
                this.jcA = null;
            }
            int contentViewsCount = this.kzf.getContentViewsCount() + this.kzf.getHeaderViewsCount() + this.kzf.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.kzf.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.kzf.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cs(fVar.getVideoContainer())) {
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
                    View childAt2 = this.kzf.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cs(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.kzf.getListView().getChildAt(i6);
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
                    View childAt4 = this.kzf.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cs(fVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.jcA != null && (this.jcA.getTag() instanceof f)) {
                    ((f) this.jcA.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.jcA != null && this.jcA != view && (this.jcA.getTag() instanceof f)) {
                ((f) this.jcA.getTag()).stopPlay();
            }
            this.jcA = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).ctS();
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
            ((e) view.getTag()).ctT();
        }
    }

    public boolean cs(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.kze == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.jcu - this.jcv && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void ct(View view) {
        if (view != null && !cs(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jcE);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzh);
        cuu();
    }

    public void yV(int i) {
        this.jcy = i;
    }

    public void cuu() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kzf.getListView().getChildCount()) {
                View childAt = this.kzf.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Hy(String str) {
        this.jcx = str;
    }

    public void cux() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kzf.getListView().getChildCount()) {
                View childAt = this.kzf.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        yV(fVar.getCurrentPosition());
                        Hy(fVar.getPlayUrl());
                        this.jcA = childAt;
                        this.jcB = fVar.isPlaying();
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

    public void cuy() {
        if (this.mIsShowing) {
            if (this.jcA != null && (this.jcA.getTag() instanceof f)) {
                f fVar = (f) this.jcA.getTag();
                if (this.jcB) {
                    fVar.startPlay();
                    this.jcB = false;
                }
                if (this.jcA.getTag() instanceof e) {
                    ((e) this.jcA.getTag()).ctU();
                }
            }
            this.jcA = null;
        }
    }

    public void cfI() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jcE);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzh);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kzf.getListView().getChildCount()) {
                View childAt = this.kzf.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kzh);
        this.kzh.yM(i);
        this.kzh.yN(i2);
        this.kzh.mY(z);
        this.kzh.qg(z2);
        this.jcD.qg(z2);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kzh, 500L);
    }

    public void qi(boolean z) {
        this.mIsShowing = z;
    }

    public void BK(int i) {
        this.jcv = i;
    }

    public void BL(int i) {
        this.kze = i;
    }

    public View cQU() {
        return this.jcA;
    }
}
