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
    private int cDm;
    private int eiG;
    private View fea;
    private f fec;
    private com.baidu.adp.widget.ListView.k gtJ;
    private com.baidu.adp.base.e mContext;
    private int fdV = 0;
    private String fdX = null;
    private int fdY = 0;
    private boolean feb = false;
    private boolean cAK = true;
    private a fee = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.aEa();
                if (m.this.cAK && m.this.cAK) {
                    m.this.d(m.this.fed.blH(), m.this.fed.blI(), m.this.fed.blJ(), m.this.fed.blK());
                }
            }
        }
    };
    private b gtK = new b(this);
    private s fed = new s();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.k kVar) {
        this.cDm = 0;
        this.eiG = 0;
        this.mContext = eVar;
        this.cDm = com.baidu.adp.lib.util.l.aq(this.mContext.getPageActivity());
        this.gtJ = kVar;
        this.eiG = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.fed.k(i, i2, z);
        if (this.gtJ != null && this.gtJ.getListView().getChildCount() != 0 && this.gtJ.getContentViewsCount() != 0) {
            if (this.fec != null && !cf(this.fec.getVideoContainer())) {
                this.fec.stopPlay();
            }
            int contentViewsCount = this.gtJ.getContentViewsCount() + this.gtJ.getHeaderViewsCount() + this.gtJ.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.gtJ.getListView().getChildCount(); i5++) {
                    View childAt = this.gtJ.getListView().getChildAt(z2 ? i5 : (this.gtJ.getListView().getChildCount() - 1) - i5);
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
                    if (i6 >= this.gtJ.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.gtJ.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && cf(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.gtJ.getListView().getChildCount()) {
                        View childAt3 = this.gtJ.getListView().getChildAt(i4);
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
                while (i4 < this.gtJ.getListView().getChildCount()) {
                    View childAt4 = this.gtJ.getListView().getChildAt(z ? (this.gtJ.getListView().getChildCount() - 1) - i4 : i4);
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
            this.fea = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.cAK && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aQg();
            }
        }
    }

    private void e(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aQh();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.fdV && measuredHeight < this.cDm;
        }
        return false;
    }

    public void cg(View view) {
        if (view != null && !cf(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fee);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtK);
        aQL();
    }

    public void rk(int i) {
        this.fdY = i;
    }

    public void aQL() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gtJ.getListView().getChildCount()) {
                View childAt = this.gtJ.getListView().getChildAt(i2);
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
        this.fdX = str;
    }

    public void aQO() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gtJ.getListView().getChildCount()) {
                View childAt = this.gtJ.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        rk(fVar.getCurrentPosition());
                        ow(fVar.getPlayUrl());
                        this.fea = childAt;
                        this.feb = fVar.isPlaying();
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

    public void aQP() {
        if (this.cAK) {
            if (this.fea != null && (this.fea.getTag() instanceof f)) {
                f fVar = (f) this.fea.getTag();
                if (this.feb) {
                    fVar.startPlay();
                }
                if (this.fea.getTag() instanceof e) {
                    ((e) this.fea.getTag()).aQi();
                }
            }
            this.fea = null;
        }
    }

    public void aEa() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fee);
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtK);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gtJ.getListView().getChildCount()) {
                View childAt = this.gtJ.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.gtK);
        this.gtK.rc(i);
        this.gtK.rd(i2);
        this.gtK.fT(z);
        this.gtK.ix(z2);
        this.fed.ix(z2);
        com.baidu.adp.lib.g.e.ns().postDelayed(this.gtK, 500L);
    }

    public void iz(boolean z) {
        this.cAK = z;
    }
}
