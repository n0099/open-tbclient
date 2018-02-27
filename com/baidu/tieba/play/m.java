package com.baidu.tieba.play;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class m {
    private int cDa;
    private int eiu;
    private View fdO;
    private f fdQ;
    private com.baidu.adp.widget.ListView.k gty;
    private com.baidu.adp.base.e mContext;
    private int fdJ = 0;
    private String fdL = null;
    private int fdM = 0;
    private boolean fdP = false;
    private boolean cAy = true;
    private a fdS = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aDZ();
                if (m.this.cAy && m.this.cAy) {
                    m.this.d(m.this.fdR.blG(), m.this.fdR.blH(), m.this.fdR.blI(), m.this.fdR.blJ());
                }
            }
        }
    };
    private b gtz = new b(this);
    private s fdR = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.k kVar) {
        this.cDa = 0;
        this.eiu = 0;
        this.mContext = eVar;
        this.cDa = com.baidu.adp.lib.util.l.aq(this.mContext.getPageActivity());
        this.gty = kVar;
        this.eiu = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.fdR.k(i, i2, z);
        if (this.gty != null && this.gty.getListView().getChildCount() != 0 && this.gty.getContentViewsCount() != 0) {
            if (this.fdQ != null && !cf(this.fdQ.getVideoContainer())) {
                this.fdQ.stopPlay();
            }
            int contentViewsCount = this.gty.getContentViewsCount() + this.gty.getHeaderViewsCount() + this.gty.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.gty.getListView().getChildCount(); i5++) {
                    View childAt = this.gty.getListView().getChildAt(z2 ? i5 : (this.gty.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && cf(fVar.getVideoContainer())) {
                            d(i3, childAt);
                            z3 = true;
                        } else {
                            e(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.gty.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.gty.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cf(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.gty.getListView().getChildCount()) {
                        View childAt3 = this.gty.getListView().getChildAt(i4);
                        if (i4 == i6) {
                            d(i3, childAt3);
                        } else {
                            e(i3, childAt3);
                        }
                        i4++;
                    }
                    return;
                }
                boolean z5 = false;
                while (i4 < this.gty.getListView().getChildCount()) {
                    View childAt4 = this.gty.getListView().getChildAt(z ? (this.gty.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && cf(fVar3.getVideoContainer())) {
                            d(i3, childAt4);
                            z4 = true;
                            i4++;
                            z5 = z4;
                        } else {
                            e(i3, childAt4);
                        }
                    }
                    z4 = z5;
                    i4++;
                    z5 = z4;
                }
            }
        }
    }

    private void d(int i, View view) {
        if (view != null) {
            this.fdO = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cAy && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aQf();
            }
        }
    }

    private void e(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aQg();
        }
    }

    public boolean cf(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.fdJ && measuredHeight < this.cDa;
        }
        return false;
    }

    public void cg(View view) {
        if (view != null && !cf(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fdS);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtz);
        aQK();
    }

    public void rl(int i) {
        this.fdM = i;
    }

    public void aQK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gty.getListView().getChildCount()) {
                View childAt = this.gty.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ow(String str) {
        this.fdL = str;
    }

    public void aQN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gty.getListView().getChildCount()) {
                View childAt = this.gty.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rl(fVar.getCurrentPosition());
                        ow(fVar.getPlayUrl());
                        this.fdO = childAt;
                        this.fdP = fVar.isPlaying();
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

    public void aQO() {
        if (this.cAy) {
            if (this.fdO != null && (this.fdO.getTag() instanceof f)) {
                f fVar = (f) this.fdO.getTag();
                if (this.fdP) {
                    fVar.startPlay();
                }
                if (this.fdO.getTag() instanceof e) {
                    ((e) this.fdO.getTag()).aQh();
                }
            }
            this.fdO = null;
        }
    }

    public void aDZ() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fdS);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtz);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gty.getListView().getChildCount()) {
                View childAt = this.gty.getListView().getChildAt(i2);
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

    public void d(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtz);
        this.gtz.rd(i);
        this.gtz.re(i2);
        this.gtz.fT(z);
        this.gtz.ix(z2);
        this.fdR.ix(z2);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gtz, 500L);
    }

    public void iz(boolean z) {
        this.cAy = z;
    }
}
