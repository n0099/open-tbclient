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
    private int haZ;
    private View hbf;
    private f hbh;
    private com.baidu.adp.widget.ListView.o ioV;
    private com.baidu.adp.base.e mContext;
    private int hba = 0;
    private String hbc = null;
    private int hbd = 0;
    private boolean hbg = false;
    private boolean blR = true;
    private a hbj = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.bvO();
                if (m.this.blR && m.this.blR) {
                    m.this.c(m.this.hbi.cbE(), m.this.hbi.cbF(), m.this.hbi.cbG(), m.this.hbi.cbH());
                }
            }
        }
    };
    private final CustomMessageListener ioW = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.m.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!ap.isEmpty(str)) {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(m.this.hbj);
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(m.this.ioX);
                    if (m.this.hbf != null && (m.this.hbf.getTag() instanceof f)) {
                        if (!str.equals(((f) m.this.hbf.getTag()).getPlayUrl())) {
                            ((f) m.this.hbf.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < m.this.ioV.getListView().getChildCount()) {
                            View childAt = m.this.ioV.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof f) && str.equals(((f) childAt.getTag()).getPlayUrl())) {
                                m.this.hbf = childAt;
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
    private b ioX = new b(this);
    private s hbi = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.o oVar) {
        this.haZ = 0;
        this.aKP = 0;
        this.mContext = eVar;
        this.haZ = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.ioV = oVar;
        this.aKP = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.ioW != null) {
                this.ioW.setSelfListener(true);
                this.ioW.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.ioW);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.hbi.k(i, i2, z);
        if (this.ioV != null && this.ioV.getListView().getChildCount() != 0 && this.ioV.getContentViewsCount() != 0) {
            if (this.hbh != null && !ci(this.hbh.getVideoContainer())) {
                this.hbh.stopPlay();
            }
            if (this.hbf != null && (this.hbf.getTag() instanceof f) && this.hbg) {
                if (ci(((f) this.hbf.getTag()).getVideoContainer())) {
                    h(i3, this.hbf);
                    this.hbf = null;
                    return;
                }
                this.hbf = null;
            }
            int contentViewsCount = this.ioV.getContentViewsCount() + this.ioV.getHeaderViewsCount() + this.ioV.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.ioV.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.ioV.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.ioV.getListView().getChildAt(i8);
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
                        View childAt3 = this.ioV.getListView().getChildAt(i6);
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
                    View childAt4 = this.ioV.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
            this.hbf = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.blR && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).bHU();
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
            ((e) view.getTag()).bHV();
        }
    }

    public boolean ci(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.top >= 0 && rect.bottom <= this.haZ - this.hba && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cj(View view) {
        if (view != null && !ci(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hbj);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioX);
        bIy();
    }

    public void wd(int i) {
        this.hbd = i;
    }

    public void bIy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioV.getListView().getChildCount()) {
                View childAt = this.ioV.getListView().getChildAt(i2);
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
        this.hbc = str;
    }

    public void bIB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioV.getListView().getChildCount()) {
                View childAt = this.ioV.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        wd(fVar.getCurrentPosition());
                        zq(fVar.getPlayUrl());
                        this.hbf = childAt;
                        this.hbg = fVar.isPlaying();
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

    public void bIC() {
        if (this.blR) {
            if (this.hbf != null && (this.hbf.getTag() instanceof f)) {
                f fVar = (f) this.hbf.getTag();
                if (this.hbg) {
                    fVar.startPlay();
                }
                if (this.hbf.getTag() instanceof e) {
                    ((e) this.hbf.getTag()).bHW();
                }
            }
            this.hbf = null;
        }
    }

    public void bvO() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hbj);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioX);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioV.getListView().getChildCount()) {
                View childAt = this.ioV.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ioX);
        this.ioX.vV(i);
        this.ioX.vW(i2);
        this.ioX.jT(z);
        this.ioX.mQ(z2);
        this.hbi.mQ(z2);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.ioX, 500L);
    }

    public void mS(boolean z) {
        this.blR = z;
    }

    public void yr(int i) {
        this.hba = i;
    }

    public View cbk() {
        return this.hbf;
    }
}
