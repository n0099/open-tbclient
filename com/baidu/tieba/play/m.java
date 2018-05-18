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
    private int bTU;
    private int dEt;
    private View ezS;
    private f ezU;
    private com.baidu.adp.widget.ListView.j fPD;
    private com.baidu.adp.base.e mContext;
    private int ezN = 0;
    private String ezP = null;
    private int ezQ = 0;
    private boolean ezT = false;
    private boolean mIsShowing = true;
    private a ezW = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.ayY();
                if (m.this.mIsShowing && m.this.mIsShowing) {
                    m.this.b(m.this.ezV.bgN(), m.this.ezV.bgO(), m.this.ezV.bgP(), m.this.ezV.bgQ());
                }
            }
        }
    };
    private b fPE = new b(this);
    private r ezV = new r();

    public m(com.baidu.adp.base.e eVar, com.baidu.adp.widget.ListView.j jVar) {
        this.bTU = 0;
        this.dEt = 0;
        this.mContext = eVar;
        this.bTU = com.baidu.adp.lib.util.l.ah(this.mContext.getPageActivity());
        this.fPD = jVar;
        this.dEt = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.ezV.h(i, i2, z);
        if (this.fPD != null && this.fPD.getListView().getChildCount() != 0 && this.fPD.getContentViewsCount() != 0) {
            if (this.ezU != null && !aL(this.ezU.getVideoContainer())) {
                this.ezU.stopPlay();
            }
            int contentViewsCount = this.fPD.getContentViewsCount() + this.fPD.getHeaderViewsCount() + this.fPD.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i5 = 0; i5 < this.fPD.getListView().getChildCount(); i5++) {
                    View childAt = this.fPD.getListView().getChildAt(z2 ? i5 : (this.fPD.getListView().getChildCount() - 1) - i5);
                    if (childAt.getTag() instanceof f) {
                        f fVar = (f) childAt.getTag();
                        if (!z3 && aL(fVar.getVideoContainer())) {
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
                    if (i6 >= this.fPD.getListView().getChildCount()) {
                        i6 = -1;
                        break;
                    }
                    View childAt2 = this.fPD.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof f) {
                        f fVar2 = (f) childAt2.getTag();
                        if (fVar2.isPlayStarted() && aL(fVar2.getVideoContainer())) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i6 >= 0) {
                    while (i4 < this.fPD.getListView().getChildCount()) {
                        View childAt3 = this.fPD.getListView().getChildAt(i4);
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
                while (i4 < this.fPD.getListView().getChildCount()) {
                    View childAt4 = this.fPD.getListView().getChildAt(z ? (this.fPD.getListView().getChildCount() - 1) - i4 : i4);
                    if (childAt4.getTag() instanceof f) {
                        f fVar3 = (f) childAt4.getTag();
                        if (!z5 && aL(fVar3.getVideoContainer())) {
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

    private void d(int i, View view2) {
        if (view2 != null) {
            this.ezS = view2;
            if (i == 1 && (view2.getTag() instanceof f)) {
                f fVar = (f) view2.getTag();
                if (this.mIsShowing && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view2.getTag() instanceof e)) {
                ((e) view2.getTag()).aLf();
            }
        }
    }

    private void e(int i, View view2) {
        if (i == 1 && (view2.getTag() instanceof f)) {
            ((f) view2.getTag()).stopPlay();
        } else if (i == 2 && (view2.getTag() instanceof e)) {
            ((e) view2.getTag()).hideAll();
        }
    }

    public boolean aL(View view2) {
        int measuredHeight;
        if (view2 == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
            return view2 != null && (measuredHeight = iArr[1] + (view2.getMeasuredHeight() / 2)) > this.ezN && measuredHeight < this.bTU;
        }
        return false;
    }

    public void aM(View view2) {
        if (view2 != null && !aL(view2) && (view2.getTag() instanceof f)) {
            ((f) view2.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ezW);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPE);
        aLJ();
    }

    public void oF(int i) {
        this.ezQ = i;
    }

    public void aLJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fPD.getListView().getChildCount()) {
                View childAt = this.fPD.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void oD(String str) {
        this.ezP = str;
    }

    public void aLM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fPD.getListView().getChildCount()) {
                View childAt = this.fPD.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        oF(fVar.getCurrentPosition());
                        oD(fVar.getPlayUrl());
                        this.ezS = childAt;
                        this.ezT = fVar.isPlaying();
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

    public void aLN() {
        if (this.mIsShowing) {
            if (this.ezS != null && (this.ezS.getTag() instanceof f)) {
                f fVar = (f) this.ezS.getTag();
                if (this.ezT) {
                    fVar.startPlay();
                }
                if (this.ezS.getTag() instanceof e) {
                    ((e) this.ezS.getTag()).aLg();
                }
            }
            this.ezS = null;
        }
    }

    public void ayY() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ezW);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPE);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fPD.getListView().getChildCount()) {
                View childAt = this.fPD.getListView().getChildAt(i2);
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

    public void b(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fPE);
        this.fPE.ox(i);
        this.fPE.oy(i2);
        this.fPE.fz(z);
        this.fPE.ib(z2);
        this.ezV.ib(z2);
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fPE, 500L);
    }

    public void id(boolean z) {
        this.mIsShowing = z;
    }
}
