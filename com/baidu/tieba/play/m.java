package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int aLV;
    private int hkc;
    private View hki;
    private f hkk;
    private com.baidu.adp.widget.ListView.o iyt;
    private com.baidu.adp.base.e mContext;
    private int hkd = 0;
    private String hkf = null;
    private int hkg = 0;
    private boolean hkj = false;
    private boolean bnd = true;
    private a hkm = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bxn();
                if (m.this.bnd && m.this.bnd) {
                    m.this.c(m.this.hkl.cfE(), m.this.hkl.cfF(), m.this.hkl.cfG(), m.this.hkl.cfH());
                }
            }
        }
    };
    private final CustomMessageListener iyu = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!aq.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(m.this.hkm);
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(m.this.iyv);
                    if (m.this.hki != null && (m.this.hki.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hki.getTag()).getPlayUrl())) {
                            ((f) m.this.hki.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.iyt.getListView().getChildCount()) {
                            View childAt = m.this.iyt.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hki = childAt;
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
    private b iyv = new b(this);
    private s hkl = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hkc = 0;
        this.aLV = 0;
        this.mContext = eVar;
        this.hkc = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.iyt = oVar;
        this.aLV = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.iyu != null) {
                this.iyu.setSelfListener(true);
                this.iyu.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.iyu);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hkl.m(i, i2, z);
        if (this.iyt != null && this.iyt.getListView().getChildCount() != 0 && this.iyt.getContentViewsCount() != 0) {
            if (this.hkk != null && !cm(this.hkk.getVideoContainer())) {
                this.hkk.stopPlay();
            }
            if (this.hki != null && (this.hki.getTag() instanceof f) && this.hkj) {
                if (cm(((f) this.hki.getTag()).getVideoContainer())) {
                    h(i3, this.hki);
                    return;
                }
                this.hki = null;
            }
            int contentViewsCount = this.iyt.getContentViewsCount() + this.iyt.getHeaderViewsCount() + this.iyt.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.iyt.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.iyt.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cm(fVar.getVideoContainer())) {
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
                    View childAt2 = this.iyt.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cm(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.iyt.getListView().getChildAt(i6);
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
                    View childAt4 = this.iyt.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || cm(fVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.hki != null && (this.hki.getTag() instanceof f)) {
                    ((f) this.hki.getTag()).stopPlay();
                }
            }
        }
    }

    private void h(int i, View view) {
        if (view != null) {
            if (this.hki != null && this.hki != view && (this.hki.getTag() instanceof f)) {
                ((f) this.hki.getTag()).stopPlay();
            }
            this.hki = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.bnd && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bLG();
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
            ((e) view.getTag()).bLH();
        }
    }

    public boolean cm(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hkc - this.hkd && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cn(View view) {
        if (view != null && !cm(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hkm);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyv);
        bMk();
    }

    public void wL(int i) {
        this.hkg = i;
    }

    public void bMk() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iyt.getListView().getChildCount()) {
                View childAt = this.iyt.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void AD(String str) {
        this.hkf = str;
    }

    public void bMn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iyt.getListView().getChildCount()) {
                View childAt = this.iyt.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        wL(fVar.getCurrentPosition());
                        AD(fVar.getPlayUrl());
                        this.hki = childAt;
                        this.hkj = fVar.isPlaying();
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

    public void bMo() {
        if (this.bnd) {
            if (this.hki != null && (this.hki.getTag() instanceof f)) {
                f fVar = (f) this.hki.getTag();
                if (this.hkj) {
                    fVar.startPlay();
                }
                if (this.hki.getTag() instanceof e) {
                    ((e) this.hki.getTag()).bLI();
                }
            }
            this.hki = null;
        }
    }

    public void bxn() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hkm);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyv);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.iyt.getListView().getChildCount()) {
                View childAt = this.iyt.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iyv);
        this.iyv.wC(i);
        this.iyv.wD(i2);
        this.iyv.kg(z);
        this.iyv.ni(z2);
        this.hkl.ni(z2);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iyv, 500L);
    }

    public void nk(boolean z) {
        this.bnd = z;
    }

    public void zb(int i) {
        this.hkd = i;
    }

    public View cfk() {
        return this.hki;
    }
}
