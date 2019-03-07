package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int aIR;
    private int gJR;
    private View gJX;
    private f gJZ;
    private com.baidu.adp.widget.ListView.o hWB;
    private com.baidu.adp.base.e mContext;
    private int gJS = 0;
    private String gJU = null;
    private int gJV = 0;
    private boolean gJY = false;
    private boolean bjS = true;
    private a gKb = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.boo();
                if (m.this.bjS && m.this.bjS) {
                    m.this.c(m.this.gKa.bTE(), m.this.gKa.bTF(), m.this.gKa.bTG(), m.this.gKa.bTH());
                }
            }
        }
    };
    private final CustomMessageListener hWC = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ap.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(m.this.gKb);
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(m.this.hWD);
                    if (m.this.gJX != null && (m.this.gJX.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.gJX.getTag()).getPlayUrl())) {
                            ((f) m.this.gJX.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.hWB.getListView().getChildCount()) {
                            View childAt = m.this.hWB.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.gJX = childAt;
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
    private b hWD = new b(this);
    private s gKa = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.gJR = 0;
        this.aIR = 0;
        this.mContext = eVar;
        this.gJR = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.hWB = oVar;
        this.aIR = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.hWC != null) {
                this.hWC.setSelfListener(true);
                this.hWC.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.hWC);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.gKa.i(i, i2, z);
        if (this.hWB != null && this.hWB.getListView().getChildCount() != 0 && this.hWB.getContentViewsCount() != 0) {
            if (this.gJZ != null && !ca(this.gJZ.getVideoContainer())) {
                this.gJZ.stopPlay();
            }
            if (this.gJX != null && (this.gJX.getTag() instanceof f) && this.gJY) {
                if (ca(((f) this.gJX.getTag()).getVideoContainer())) {
                    h(i3, this.gJX);
                    this.gJX = null;
                    return;
                }
                this.gJX = null;
            }
            int contentViewsCount = this.hWB.getContentViewsCount() + this.hWB.getHeaderViewsCount() + this.hWB.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.hWB.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.hWB.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && ca(fVar.getVideoContainer())) {
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
                    View childAt2 = this.hWB.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && ca(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.hWB.getListView().getChildAt(i6);
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
                    View childAt4 = this.hWB.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || ca(fVar3.getVideoContainer()))) {
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
            this.gJX = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bjS && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bAn();
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
            ((e) view.getTag()).bAo();
        }
    }

    public boolean ca(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.gJR - this.gJS && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cb(View view) {
        if (view != null && !ca(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKb);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWD);
        bAR();
    }

    public void va(int i) {
        this.gJV = i;
    }

    public void bAR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWB.getListView().getChildCount()) {
                View childAt = this.hWB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void yc(String str) {
        this.gJU = str;
    }

    public void bAU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWB.getListView().getChildCount()) {
                View childAt = this.hWB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        va(fVar.getCurrentPosition());
                        yc(fVar.getPlayUrl());
                        this.gJX = childAt;
                        this.gJY = fVar.isPlaying();
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

    public void bAV() {
        if (this.bjS) {
            if (this.gJX != null && (this.gJX.getTag() instanceof f)) {
                f fVar = (f) this.gJX.getTag();
                if (this.gJY) {
                    fVar.startPlay();
                }
                if (this.gJX.getTag() instanceof e) {
                    ((e) this.gJX.getTag()).bAp();
                }
            }
            this.gJX = null;
        }
    }

    public void boo() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKb);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWD);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWB.getListView().getChildCount()) {
                View childAt = this.hWB.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWD);
        this.hWD.uS(i);
        this.hWD.uT(i2);
        this.hWD.jj(z);
        this.hWD.mb(z2);
        this.gKa.mb(z2);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hWD, 500L);
    }

    public void md(boolean z) {
        this.bjS = z;
    }

    public void xo(int i) {
        this.gJS = i;
    }

    public View bTk() {
        return this.gJX;
    }
}
