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
    private int aIV;
    private int gJE;
    private View gJK;
    private f gJM;
    private com.baidu.adp.widget.ListView.o hWi;
    private com.baidu.adp.base.e mContext;
    private int gJF = 0;
    private String gJH = null;
    private int gJI = 0;
    private boolean gJL = false;
    private boolean bjW = true;
    private a gJO = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bol();
                if (m.this.bjW && m.this.bjW) {
                    m.this.c(m.this.gJN.bTD(), m.this.gJN.bTE(), m.this.gJN.bTF(), m.this.gJN.bTG());
                }
            }
        }
    };
    private final CustomMessageListener hWj = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ap.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(m.this.gJO);
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(m.this.hWk);
                    if (m.this.gJK != null && (m.this.gJK.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.gJK.getTag()).getPlayUrl())) {
                            ((f) m.this.gJK.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.hWi.getListView().getChildCount()) {
                            View childAt = m.this.hWi.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.gJK = childAt;
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
    private b hWk = new b(this);
    private s gJN = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.gJE = 0;
        this.aIV = 0;
        this.mContext = eVar;
        this.gJE = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.hWi = oVar;
        this.aIV = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.hWj != null) {
                this.hWj.setSelfListener(true);
                this.hWj.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.hWj);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.gJN.i(i, i2, z);
        if (this.hWi != null && this.hWi.getListView().getChildCount() != 0 && this.hWi.getContentViewsCount() != 0) {
            if (this.gJM != null && !ca(this.gJM.getVideoContainer())) {
                this.gJM.stopPlay();
            }
            if (this.gJK != null && (this.gJK.getTag() instanceof f) && this.gJL) {
                if (ca(((f) this.gJK.getTag()).getVideoContainer())) {
                    h(i3, this.gJK);
                    this.gJK = null;
                    return;
                }
                this.gJK = null;
            }
            int contentViewsCount = this.hWi.getContentViewsCount() + this.hWi.getHeaderViewsCount() + this.hWi.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.hWi.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.hWi.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.hWi.getListView().getChildAt(i8);
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
                        View childAt3 = this.hWi.getListView().getChildAt(i6);
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
                    View childAt4 = this.hWi.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
            this.gJK = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bjW && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bAk();
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
            ((e) view.getTag()).bAl();
        }
    }

    public boolean ca(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.gJE - this.gJF && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cb(View view) {
        if (view != null && !ca(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gJO);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWk);
        bAO();
    }

    public void uW(int i) {
        this.gJI = i;
    }

    public void bAO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWi.getListView().getChildCount()) {
                View childAt = this.hWi.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ya(String str) {
        this.gJH = str;
    }

    public void bAR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWi.getListView().getChildCount()) {
                View childAt = this.hWi.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        uW(fVar.getCurrentPosition());
                        ya(fVar.getPlayUrl());
                        this.gJK = childAt;
                        this.gJL = fVar.isPlaying();
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

    public void bAS() {
        if (this.bjW) {
            if (this.gJK != null && (this.gJK.getTag() instanceof f)) {
                f fVar = (f) this.gJK.getTag();
                if (this.gJL) {
                    fVar.startPlay();
                }
                if (this.gJK.getTag() instanceof e) {
                    ((e) this.gJK.getTag()).bAm();
                }
            }
            this.gJK = null;
        }
    }

    public void bol() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gJO);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWk);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWi.getListView().getChildCount()) {
                View childAt = this.hWi.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWk);
        this.hWk.uO(i);
        this.hWk.uP(i2);
        this.hWk.jj(z);
        this.hWk.mb(z2);
        this.gJN.mb(z2);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hWk, 500L);
    }

    public void md(boolean z) {
        this.bjW = z;
    }

    public void xk(int i) {
        this.gJF = i;
    }

    public View bTj() {
        return this.gJK;
    }
}
