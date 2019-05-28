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
    private int aKP;
    private int hbc;
    private View hbi;
    private f hbk;
    private com.baidu.adp.widget.ListView.o ioY;
    private com.baidu.adp.base.e mContext;
    private int hbd = 0;
    private String hbf = null;
    private int hbg = 0;
    private boolean hbj = false;
    private boolean blR = true;
    private a hbm = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bvR();
                if (m.this.blR && m.this.blR) {
                    m.this.c(m.this.hbl.cbH(), m.this.hbl.cbI(), m.this.hbl.cbJ(), m.this.hbl.cbK());
                }
            }
        }
    };
    private final CustomMessageListener ioZ = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ap.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(m.this.hbm);
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(m.this.ipa);
                    if (m.this.hbi != null && (m.this.hbi.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hbi.getTag()).getPlayUrl())) {
                            ((f) m.this.hbi.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.ioY.getListView().getChildCount()) {
                            View childAt = m.this.ioY.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hbi = childAt;
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
    private b ipa = new b(this);
    private s hbl = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hbc = 0;
        this.aKP = 0;
        this.mContext = eVar;
        this.hbc = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.ioY = oVar;
        this.aKP = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.ioZ != null) {
                this.ioZ.setSelfListener(true);
                this.ioZ.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.ioZ);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hbl.k(i, i2, z);
        if (this.ioY != null && this.ioY.getListView().getChildCount() != 0 && this.ioY.getContentViewsCount() != 0) {
            if (this.hbk != null && !ci(this.hbk.getVideoContainer())) {
                this.hbk.stopPlay();
            }
            if (this.hbi != null && (this.hbi.getTag() instanceof f) && this.hbj) {
                if (ci(((f) this.hbi.getTag()).getVideoContainer())) {
                    h(i3, this.hbi);
                    this.hbi = null;
                    return;
                }
                this.hbi = null;
            }
            int contentViewsCount = this.ioY.getContentViewsCount() + this.ioY.getHeaderViewsCount() + this.ioY.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.ioY.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.ioY.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && ci(fVar.getVideoContainer())) {
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
                    View childAt2 = this.ioY.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && ci(fVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.ioY.getListView().getChildAt(i6);
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
                    View childAt4 = this.ioY.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (i6 == 0 && (fVar3.isFullScreen() || ci(fVar3.getVideoContainer()))) {
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
            this.hbi = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.blR && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bHX();
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
            ((e) view.getTag()).bHY();
        }
    }

    public boolean ci(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hbc - this.hbd && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cj(View view) {
        if (view != null && !ci(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hbm);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipa);
        bIB();
    }

    public void wd(int i) {
        this.hbg = i;
    }

    public void bIB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioY.getListView().getChildCount()) {
                View childAt = this.ioY.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zq(String str) {
        this.hbf = str;
    }

    public void bIE() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioY.getListView().getChildCount()) {
                View childAt = this.ioY.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        wd(fVar.getCurrentPosition());
                        zq(fVar.getPlayUrl());
                        this.hbi = childAt;
                        this.hbj = fVar.isPlaying();
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

    public void bIF() {
        if (this.blR) {
            if (this.hbi != null && (this.hbi.getTag() instanceof f)) {
                f fVar = (f) this.hbi.getTag();
                if (this.hbj) {
                    fVar.startPlay();
                }
                if (this.hbi.getTag() instanceof e) {
                    ((e) this.hbi.getTag()).bHZ();
                }
            }
            this.hbi = null;
        }
    }

    public void bvR() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hbm);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipa);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioY.getListView().getChildCount()) {
                View childAt = this.ioY.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipa);
        this.ipa.vV(i);
        this.ipa.vW(i2);
        this.ipa.jT(z);
        this.ipa.mQ(z2);
        this.hbl.mQ(z2);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.ipa, 500L);
    }

    public void mS(boolean z) {
        this.blR = z;
    }

    public void yr(int i) {
        this.hbd = i;
    }

    public View cbn() {
        return this.hbi;
    }
}
