package com.baidu.tieba.play;

import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.p;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private int dyV;
    private int leQ;
    private View leW;
    private e leY;
    private com.baidu.adp.base.f mContext;
    private p mHG;
    private int mHF = 0;
    private int leR = 0;
    private String leT = null;
    private int leU = 0;
    private boolean leX = false;
    private boolean enb = true;
    private a lfa = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cQB();
                if (i.this.enb && i.this.enb) {
                    i.this.b(i.this.leZ.dAd(), i.this.leZ.dAe(), i.this.leZ.dAf(), i.this.leZ.dAg());
                }
            }
        }
    };
    private final CustomMessageListener mHH = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!au.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(i.this.lfa);
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(i.this.mHI);
                    if (i.this.leW != null && (i.this.leW.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.leW.getTag()).getPlayUrl())) {
                            ((e) i.this.leW.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mHG.getListView().getChildCount()) {
                            View childAt = i.this.mHG.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.leW = childAt;
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
    private b mHI = new b(this);
    private l leZ = new l();

    public i(com.baidu.adp.base.f fVar, p pVar) {
        this.leQ = 0;
        this.dyV = 0;
        this.mContext = fVar;
        this.leQ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mHG = pVar;
        this.dyV = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mHH != null) {
                this.mHH.setSelfListener(true);
                this.mHH.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mHH);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        this.leZ.m(i, i2, z);
        if (this.mHG != null && this.mHG.getListView().getChildCount() != 0 && this.mHG.getContentViewsCount() != 0) {
            if (this.leY != null && !ds(this.leY.getVideoContainer())) {
                this.leY.stopPlay();
            }
            if (this.leW != null && (this.leW.getTag() instanceof e) && this.leX) {
                if (ds(((e) this.leW.getTag()).getVideoContainer())) {
                    f(i3, this.leW);
                    this.leX = false;
                    return;
                }
                this.leW = null;
            }
            int contentViewsCount = this.mHG.getContentViewsCount() + this.mHG.getHeaderViewsCount() + this.mHG.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mHG.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i5 = 0;
                z3 = false;
                while (i5 < childCount) {
                    View childAt = this.mHG.getListView().getChildAt(z2 ? i5 : (childCount - 1) - i5);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && ds(eVar.getVideoContainer())) {
                            f(i3, childAt);
                            z4 = true;
                            i5++;
                            z3 = z4;
                        } else {
                            g(i3, childAt);
                        }
                    }
                    z4 = z3;
                    i5++;
                    z3 = z4;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                int i6 = 0;
                while (true) {
                    if (i6 >= childCount) {
                        i4 = -1;
                        break;
                    }
                    View childAt2 = this.mHG.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && ds(eVar2.getVideoContainer())) {
                            i4 = i6;
                            break;
                        }
                    }
                    i6++;
                }
                if (i4 >= 0) {
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt3 = this.mHG.getListView().getChildAt(i7);
                        if (i7 != i4) {
                            g(i3, childAt3);
                        } else {
                            f(i3, childAt3);
                        }
                    }
                    return;
                }
                int i8 = 0;
                boolean z6 = false;
                while (i8 < childCount) {
                    View childAt4 = this.mHG.getListView().getChildAt(z ? (childCount - 1) - i8 : i8);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (!z6 && (eVar3.isFullScreen() || ds(eVar3.getVideoContainer()))) {
                            f(i3, childAt4);
                            z5 = true;
                            i8++;
                            z6 = z5;
                        } else {
                            g(i3, childAt4);
                        }
                    }
                    z5 = z6;
                    i8++;
                    z6 = z5;
                }
                if (!z6 && this.leW != null && (this.leW.getTag() instanceof e)) {
                    ((e) this.leW.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.leW != null && this.leW != view && (this.leW.getTag() instanceof e)) {
                ((e) this.leW.getTag()).stopPlay();
            }
            this.leW = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.enb && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).dce();
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
            ((d) view.getTag()).cpW();
        }
    }

    public boolean ds(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mHF == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.leQ - this.leR && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dt(View view) {
        if (view != null && !ds(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfa);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHI);
        dcG();
    }

    public void Ef(int i) {
        this.leU = i;
    }

    public void dcG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHG.getListView().getChildCount()) {
                View childAt = this.mHG.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void NI(String str) {
        this.leT = str;
    }

    public void dcJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHG.getListView().getChildCount()) {
                View childAt = this.mHG.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ef(eVar.getCurrentPosition());
                        NI(eVar.getPlayUrl());
                        this.leW = childAt;
                        this.leX = eVar.isPlaying();
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

    public void dcK() {
        if (this.enb) {
            if (this.leW != null && (this.leW.getTag() instanceof e)) {
                e eVar = (e) this.leW.getTag();
                if (this.leX) {
                    eVar.startPlay();
                    this.leX = false;
                }
                if (this.leW.getTag() instanceof d) {
                    ((d) this.leW.getTag()).dcf();
                }
            }
            this.leW = null;
        }
    }

    public void cQB() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfa);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHI);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHG.getListView().getChildCount()) {
                View childAt = this.mHG.getListView().getChildAt(i2);
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

    public void b(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHI);
        this.mHI.DW(i);
        this.mHI.DX(i2);
        this.mHI.qK(z);
        this.mHI.tK(z2);
        this.leZ.tK(z2);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mHI, 500L);
    }

    public void tN(boolean z) {
        this.enb = z;
    }

    public void Hn(int i) {
        this.leR = i;
    }

    public void Ho(int i) {
        this.mHF = i;
    }

    public View dAc() {
        return this.leW;
    }
}
