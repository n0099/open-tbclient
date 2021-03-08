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
    private int dAw;
    private int lgS;
    private View lgY;
    private e lha;
    private com.baidu.adp.base.f mContext;
    private p mJN;
    private int mJM = 0;
    private int lgT = 0;
    private String lgV = null;
    private int lgW = 0;
    private boolean lgZ = false;
    private boolean eoF = true;
    private a lhc = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cQI();
                if (i.this.eoF && i.this.eoF) {
                    i.this.b(i.this.lhb.dAl(), i.this.lhb.dAm(), i.this.lhb.dAn(), i.this.lhb.dAo());
                }
            }
        }
    };
    private final CustomMessageListener mJO = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!au.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(i.this.lhc);
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(i.this.mJP);
                    if (i.this.lgY != null && (i.this.lgY.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.lgY.getTag()).getPlayUrl())) {
                            ((e) i.this.lgY.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mJN.getListView().getChildCount()) {
                            View childAt = i.this.mJN.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.lgY = childAt;
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
    private b mJP = new b(this);
    private l lhb = new l();

    public i(com.baidu.adp.base.f fVar, p pVar) {
        this.lgS = 0;
        this.dAw = 0;
        this.mContext = fVar;
        this.lgS = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mJN = pVar;
        this.dAw = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mJO != null) {
                this.mJO.setSelfListener(true);
                this.mJO.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mJO);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        this.lhb.m(i, i2, z);
        if (this.mJN != null && this.mJN.getListView().getChildCount() != 0 && this.mJN.getContentViewsCount() != 0) {
            if (this.lha != null && !ds(this.lha.getVideoContainer())) {
                this.lha.stopPlay();
            }
            if (this.lgY != null && (this.lgY.getTag() instanceof e) && this.lgZ) {
                if (ds(((e) this.lgY.getTag()).getVideoContainer())) {
                    f(i3, this.lgY);
                    this.lgZ = false;
                    return;
                }
                this.lgY = null;
            }
            int contentViewsCount = this.mJN.getContentViewsCount() + this.mJN.getHeaderViewsCount() + this.mJN.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mJN.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i5 = 0;
                z3 = false;
                while (i5 < childCount) {
                    View childAt = this.mJN.getListView().getChildAt(z2 ? i5 : (childCount - 1) - i5);
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
                    View childAt2 = this.mJN.getListView().getChildAt(i6);
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
                        View childAt3 = this.mJN.getListView().getChildAt(i7);
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
                    View childAt4 = this.mJN.getListView().getChildAt(z ? (childCount - 1) - i8 : i8);
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
                if (!z6 && this.lgY != null && (this.lgY.getTag() instanceof e)) {
                    ((e) this.lgY.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.lgY != null && this.lgY != view && (this.lgY.getTag() instanceof e)) {
                ((e) this.lgY.getTag()).stopPlay();
            }
            this.lgY = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.eoF && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).dcn();
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
            ((d) view.getTag()).cqc();
        }
    }

    public boolean ds(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mJM == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.lgS - this.lgT && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dt(View view) {
        if (view != null && !ds(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJP);
        dcP();
    }

    public void Ei(int i) {
        this.lgW = i;
    }

    public void dcP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mJN.getListView().getChildCount()) {
                View childAt = this.mJN.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void NO(String str) {
        this.lgV = str;
    }

    public void dcS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mJN.getListView().getChildCount()) {
                View childAt = this.mJN.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ei(eVar.getCurrentPosition());
                        NO(eVar.getPlayUrl());
                        this.lgY = childAt;
                        this.lgZ = eVar.isPlaying();
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

    public void dcT() {
        if (this.eoF) {
            if (this.lgY != null && (this.lgY.getTag() instanceof e)) {
                e eVar = (e) this.lgY.getTag();
                if (this.lgZ) {
                    eVar.startPlay();
                    this.lgZ = false;
                }
                if (this.lgY.getTag() instanceof d) {
                    ((d) this.lgY.getTag()).dco();
                }
            }
            this.lgY = null;
        }
    }

    public void cQI() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJP);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mJN.getListView().getChildCount()) {
                View childAt = this.mJN.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mJP);
        this.mJP.DZ(i);
        this.mJP.Ea(i2);
        this.mJP.qK(z);
        this.mJP.tK(z2);
        this.lhb.tK(z2);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mJP, 500L);
    }

    public void tN(boolean z) {
        this.eoF = z;
    }

    public void Hq(int i) {
        this.lgT = i;
    }

    public void Hr(int i) {
        this.mJM = i;
    }

    public View dAk() {
        return this.lgY;
    }
}
