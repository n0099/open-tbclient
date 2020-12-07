package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private int dvt;
    private View kVE;
    private e kVG;
    private int kVy;
    private com.baidu.adp.base.e mContext;
    private s mxB;
    private int mxA = 0;
    private int kVz = 0;
    private String kVB = null;
    private int kVC = 0;
    private boolean kVF = false;
    private boolean mIsShowing = true;
    private a kVI = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cPh();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kVH.dBP(), i.this.kVH.dBQ(), i.this.kVH.dBR(), i.this.kVH.dBS());
                }
            }
        }
    };
    private final CustomMessageListener mxC = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!au.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.kVI);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.mxD);
                    if (i.this.kVE != null && (i.this.kVE.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kVE.getTag()).getPlayUrl())) {
                            ((e) i.this.kVE.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mxB.getListView().getChildCount()) {
                            View childAt = i.this.mxB.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kVE = childAt;
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
    private b mxD = new b(this);
    private l kVH = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kVy = 0;
        this.dvt = 0;
        this.mContext = eVar;
        this.kVy = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mxB = sVar;
        this.dvt = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mxC != null) {
                this.mxC.setSelfListener(true);
                this.mxC.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mxC);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kVH.l(i, i2, z);
        if (this.mxB != null && this.mxB.getListView().getChildCount() != 0 && this.mxB.getContentViewsCount() != 0) {
            if (this.kVG != null && !dk(this.kVG.getVideoContainer())) {
                this.kVG.stopPlay();
            }
            if (this.kVE != null && (this.kVE.getTag() instanceof e) && this.kVF) {
                if (dk(((e) this.kVE.getTag()).getVideoContainer())) {
                    f(i3, this.kVE);
                    this.kVF = false;
                    return;
                }
                this.kVE = null;
            }
            int contentViewsCount = this.mxB.getContentViewsCount() + this.mxB.getHeaderViewsCount() + this.mxB.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mxB.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.mxB.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && dk(eVar.getVideoContainer())) {
                            f(i3, childAt);
                            z4 = true;
                            i7++;
                            z3 = z4;
                        } else {
                            g(i3, childAt);
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
                    View childAt2 = this.mxB.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && dk(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.mxB.getListView().getChildAt(i6);
                        if (i6 != i4) {
                            g(i3, childAt3);
                        } else {
                            f(i3, childAt3);
                        }
                        i6++;
                    }
                    return;
                }
                int i9 = 0;
                while (i9 < childCount) {
                    View childAt4 = this.mxB.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || dk(eVar3.getVideoContainer()))) {
                            f(i3, childAt4);
                            i5 = 1;
                            i9++;
                            i6 = i5;
                        } else {
                            g(i3, childAt4);
                        }
                    }
                    i5 = i6;
                    i9++;
                    i6 = i5;
                }
                if (i6 == 0 && this.kVE != null && (this.kVE.getTag() instanceof e)) {
                    ((e) this.kVE.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kVE != null && this.kVE != view && (this.kVE.getTag() instanceof e)) {
                ((e) this.kVE.getTag()).stopPlay();
            }
            this.kVE = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).dee();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (eVar.isPlaying()) {
                eVar.stopPlay();
            }
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).cpH();
        }
    }

    public boolean dk(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mxA == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kVy - this.kVz && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dl(View view) {
        if (view != null && !dk(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kVI);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxD);
        deG();
    }

    public void Fz(int i) {
        this.kVC = i;
    }

    public void deG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mxB.getListView().getChildCount()) {
                View childAt = this.mxB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Ot(String str) {
        this.kVB = str;
    }

    public void deJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mxB.getListView().getChildCount()) {
                View childAt = this.mxB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Fz(eVar.getCurrentPosition());
                        Ot(eVar.getPlayUrl());
                        this.kVE = childAt;
                        this.kVF = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void deK() {
        if (this.mIsShowing) {
            if (this.kVE != null && (this.kVE.getTag() instanceof e)) {
                e eVar = (e) this.kVE.getTag();
                if (this.kVF) {
                    eVar.startPlay();
                    this.kVF = false;
                }
                if (this.kVE.getTag() instanceof d) {
                    ((d) this.kVE.getTag()).def();
                }
            }
            this.kVE = null;
        }
    }

    public void cPh() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kVI);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxD);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mxB.getListView().getChildCount()) {
                View childAt = this.mxB.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        eVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxD);
        this.mxD.Fq(i);
        this.mxD.Fr(i2);
        this.mxD.qg(z);
        this.mxD.tA(z2);
        this.kVH.tA(z2);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mxD, 500L);
    }

    public void tC(boolean z) {
        this.mIsShowing = z;
    }

    public void II(int i) {
        this.kVz = i;
    }

    public void IJ(int i) {
        this.mxA = i;
    }

    public View dBO() {
        return this.kVE;
    }
}
