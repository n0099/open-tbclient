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
    private int aIW;
    private int gJF;
    private View gJL;
    private f gJN;
    private com.baidu.adp.widget.ListView.o hWj;
    private com.baidu.adp.base.e mContext;
    private int gJG = 0;
    private String gJI = null;
    private int gJJ = 0;
    private boolean gJM = false;
    private boolean bjX = true;
    private a gJP = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bol();
                if (m.this.bjX && m.this.bjX) {
                    m.this.c(m.this.gJO.bTD(), m.this.gJO.bTE(), m.this.gJO.bTF(), m.this.gJO.bTG());
                }
            }
        }
    };
    private final CustomMessageListener hWk = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ap.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(m.this.gJP);
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(m.this.hWl);
                    if (m.this.gJL != null && (m.this.gJL.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.gJL.getTag()).getPlayUrl())) {
                            ((f) m.this.gJL.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.hWj.getListView().getChildCount()) {
                            View childAt = m.this.hWj.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.gJL = childAt;
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
    private b hWl = new b(this);
    private s gJO = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.gJF = 0;
        this.aIW = 0;
        this.mContext = eVar;
        this.gJF = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.hWj = oVar;
        this.aIW = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.hWk != null) {
                this.hWk.setSelfListener(true);
                this.hWk.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.hWk);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.gJO.i(i, i2, z);
        if (this.hWj != null && this.hWj.getListView().getChildCount() != 0 && this.hWj.getContentViewsCount() != 0) {
            if (this.gJN != null && !ca(this.gJN.getVideoContainer())) {
                this.gJN.stopPlay();
            }
            if (this.gJL != null && (this.gJL.getTag() instanceof f) && this.gJM) {
                if (ca(((f) this.gJL.getTag()).getVideoContainer())) {
                    h(i3, this.gJL);
                    this.gJL = null;
                    return;
                }
                this.gJL = null;
            }
            int contentViewsCount = this.hWj.getContentViewsCount() + this.hWj.getHeaderViewsCount() + this.hWj.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.hWj.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.hWj.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.hWj.getListView().getChildAt(i8);
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
                        View childAt3 = this.hWj.getListView().getChildAt(i6);
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
                    View childAt4 = this.hWj.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
            this.gJL = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bjX && !fVar.isPlayStarted()) {
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
        return rect.top >= 0 && rect.bottom <= this.gJF - this.gJG && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cb(View view) {
        if (view != null && !ca(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gJP);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
        bAO();
    }

    public void uW(int i) {
        this.gJJ = i;
    }

    public void bAO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWj.getListView().getChildCount()) {
                View childAt = this.hWj.getListView().getChildAt(i2);
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
        this.gJI = str;
    }

    public void bAR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWj.getListView().getChildCount()) {
                View childAt = this.hWj.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        uW(fVar.getCurrentPosition());
                        ya(fVar.getPlayUrl());
                        this.gJL = childAt;
                        this.gJM = fVar.isPlaying();
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
        if (this.bjX) {
            if (this.gJL != null && (this.gJL.getTag() instanceof f)) {
                f fVar = (f) this.gJL.getTag();
                if (this.gJM) {
                    fVar.startPlay();
                }
                if (this.gJL.getTag() instanceof e) {
                    ((e) this.gJL.getTag()).bAm();
                }
            }
            this.gJL = null;
        }
    }

    public void bol() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gJP);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hWj.getListView().getChildCount()) {
                View childAt = this.hWj.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hWl);
        this.hWl.uO(i);
        this.hWl.uP(i2);
        this.hWl.jj(z);
        this.hWl.mb(z2);
        this.gJO.mb(z2);
        com.baidu.adp.lib.g.e.jH().postDelayed(this.hWl, 500L);
    }

    public void md(boolean z) {
        this.bjX = z;
    }

    public void xk(int i) {
        this.gJG = i;
    }

    public View bTj() {
        return this.gJL;
    }
}
