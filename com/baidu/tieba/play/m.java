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
    private int hbd;
    private View hbj;
    private f hbl;
    private com.baidu.adp.widget.ListView.o ioZ;
    private com.baidu.adp.base.e mContext;
    private int hbe = 0;
    private String hbg = null;
    private int hbh = 0;
    private boolean hbk = false;
    private boolean blR = true;
    private a hbn = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bvS();
                if (m.this.blR && m.this.blR) {
                    m.this.c(m.this.hbm.cbI(), m.this.hbm.cbJ(), m.this.hbm.cbK(), m.this.hbm.cbL());
                }
            }
        }
    };
    private final CustomMessageListener ipa = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ap.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(m.this.hbn);
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(m.this.ipb);
                    if (m.this.hbj != null && (m.this.hbj.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hbj.getTag()).getPlayUrl())) {
                            ((f) m.this.hbj.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.ioZ.getListView().getChildCount()) {
                            View childAt = m.this.ioZ.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hbj = childAt;
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
    private b ipb = new b(this);
    private s hbm = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.hbd = 0;
        this.aKP = 0;
        this.mContext = eVar;
        this.hbd = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.ioZ = oVar;
        this.aKP = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.ipa != null) {
                this.ipa.setSelfListener(true);
                this.ipa.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.ipa);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hbm.k(i, i2, z);
        if (this.ioZ != null && this.ioZ.getListView().getChildCount() != 0 && this.ioZ.getContentViewsCount() != 0) {
            if (this.hbl != null && !ci(this.hbl.getVideoContainer())) {
                this.hbl.stopPlay();
            }
            if (this.hbj != null && (this.hbj.getTag() instanceof f) && this.hbk) {
                if (ci(((f) this.hbj.getTag()).getVideoContainer())) {
                    h(i3, this.hbj);
                    this.hbj = null;
                    return;
                }
                this.hbj = null;
            }
            int contentViewsCount = this.ioZ.getContentViewsCount() + this.ioZ.getHeaderViewsCount() + this.ioZ.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.ioZ.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.ioZ.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.ioZ.getListView().getChildAt(i8);
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
                        View childAt3 = this.ioZ.getListView().getChildAt(i6);
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
                    View childAt4 = this.ioZ.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
            this.hbj = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.blR && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bHY();
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
            ((e) view.getTag()).bHZ();
        }
    }

    public boolean ci(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.hbd - this.hbe && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cj(View view) {
        if (view != null && !ci(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hbn);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipb);
        bIC();
    }

    public void wd(int i) {
        this.hbh = i;
    }

    public void bIC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioZ.getListView().getChildCount()) {
                View childAt = this.ioZ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zs(String str) {
        this.hbg = str;
    }

    public void bIF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioZ.getListView().getChildCount()) {
                View childAt = this.ioZ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        wd(fVar.getCurrentPosition());
                        zs(fVar.getPlayUrl());
                        this.hbj = childAt;
                        this.hbk = fVar.isPlaying();
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

    public void bIG() {
        if (this.blR) {
            if (this.hbj != null && (this.hbj.getTag() instanceof f)) {
                f fVar = (f) this.hbj.getTag();
                if (this.hbk) {
                    fVar.startPlay();
                }
                if (this.hbj.getTag() instanceof e) {
                    ((e) this.hbj.getTag()).bIa();
                }
            }
            this.hbj = null;
        }
    }

    public void bvS() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hbn);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipb);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioZ.getListView().getChildCount()) {
                View childAt = this.ioZ.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ipb);
        this.ipb.vV(i);
        this.ipb.vW(i2);
        this.ipb.jT(z);
        this.ipb.mR(z2);
        this.hbm.mR(z2);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.ipb, 500L);
    }

    public void mT(boolean z) {
        this.blR = z;
    }

    public void yr(int i) {
        this.hbe = i;
    }

    public View cbo() {
        return this.hbj;
    }
}
