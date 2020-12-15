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
    private int kVA;
    private View kVG;
    private e kVI;
    private com.baidu.adp.base.e mContext;
    private s mxD;
    private int mxC = 0;
    private int kVB = 0;
    private String kVD = null;
    private int kVE = 0;
    private boolean kVH = false;
    private boolean mIsShowing = true;
    private a kVK = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cPi();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kVJ.dBQ(), i.this.kVJ.dBR(), i.this.kVJ.dBS(), i.this.kVJ.dBT());
                }
            }
        }
    };
    private final CustomMessageListener mxE = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!au.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.kVK);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.mxF);
                    if (i.this.kVG != null && (i.this.kVG.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kVG.getTag()).getPlayUrl())) {
                            ((e) i.this.kVG.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mxD.getListView().getChildCount()) {
                            View childAt = i.this.mxD.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kVG = childAt;
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
    private b mxF = new b(this);
    private l kVJ = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kVA = 0;
        this.dvt = 0;
        this.mContext = eVar;
        this.kVA = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mxD = sVar;
        this.dvt = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mxE != null) {
                this.mxE.setSelfListener(true);
                this.mxE.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mxE);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kVJ.l(i, i2, z);
        if (this.mxD != null && this.mxD.getListView().getChildCount() != 0 && this.mxD.getContentViewsCount() != 0) {
            if (this.kVI != null && !dk(this.kVI.getVideoContainer())) {
                this.kVI.stopPlay();
            }
            if (this.kVG != null && (this.kVG.getTag() instanceof e) && this.kVH) {
                if (dk(((e) this.kVG.getTag()).getVideoContainer())) {
                    f(i3, this.kVG);
                    this.kVH = false;
                    return;
                }
                this.kVG = null;
            }
            int contentViewsCount = this.mxD.getContentViewsCount() + this.mxD.getHeaderViewsCount() + this.mxD.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mxD.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.mxD.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                    View childAt2 = this.mxD.getListView().getChildAt(i8);
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
                        View childAt3 = this.mxD.getListView().getChildAt(i6);
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
                    View childAt4 = this.mxD.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
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
                if (i6 == 0 && this.kVG != null && (this.kVG.getTag() instanceof e)) {
                    ((e) this.kVG.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kVG != null && this.kVG != view && (this.kVG.getTag() instanceof e)) {
                ((e) this.kVG.getTag()).stopPlay();
            }
            this.kVG = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).def();
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
            ((d) view.getTag()).cpI();
        }
    }

    public boolean dk(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mxC == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kVA - this.kVB && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dl(View view) {
        if (view != null && !dk(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kVK);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxF);
        deH();
    }

    public void Fz(int i) {
        this.kVE = i;
    }

    public void deH() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mxD.getListView().getChildCount()) {
                View childAt = this.mxD.getListView().getChildAt(i2);
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
        this.kVD = str;
    }

    public void deK() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mxD.getListView().getChildCount()) {
                View childAt = this.mxD.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Fz(eVar.getCurrentPosition());
                        Ot(eVar.getPlayUrl());
                        this.kVG = childAt;
                        this.kVH = eVar.isPlaying();
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

    public void deL() {
        if (this.mIsShowing) {
            if (this.kVG != null && (this.kVG.getTag() instanceof e)) {
                e eVar = (e) this.kVG.getTag();
                if (this.kVH) {
                    eVar.startPlay();
                    this.kVH = false;
                }
                if (this.kVG.getTag() instanceof d) {
                    ((d) this.kVG.getTag()).deg();
                }
            }
            this.kVG = null;
        }
    }

    public void cPi() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kVK);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxF);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mxD.getListView().getChildCount()) {
                View childAt = this.mxD.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mxF);
        this.mxF.Fq(i);
        this.mxF.Fr(i2);
        this.mxF.qg(z);
        this.mxF.tA(z2);
        this.kVJ.tA(z2);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mxF, 500L);
    }

    public void tC(boolean z) {
        this.mIsShowing = z;
    }

    public void II(int i) {
        this.kVB = i;
    }

    public void IJ(int i) {
        this.mxC = i;
    }

    public View dBP() {
        return this.kVG;
    }
}
