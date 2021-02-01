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
    private int leC;
    private View leI;
    private e leK;
    private com.baidu.adp.base.f mContext;
    private p mHr;
    private int mHq = 0;
    private int leD = 0;
    private String leF = null;
    private int leG = 0;
    private boolean leJ = false;
    private boolean enb = true;
    private a leM = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cQu();
                if (i.this.enb && i.this.enb) {
                    i.this.b(i.this.leL.dzW(), i.this.leL.dzX(), i.this.leL.dzY(), i.this.leL.dzZ());
                }
            }
        }
    };
    private final CustomMessageListener mHs = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!au.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(i.this.leM);
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(i.this.mHt);
                    if (i.this.leI != null && (i.this.leI.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.leI.getTag()).getPlayUrl())) {
                            ((e) i.this.leI.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mHr.getListView().getChildCount()) {
                            View childAt = i.this.mHr.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.leI = childAt;
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
    private b mHt = new b(this);
    private l leL = new l();

    public i(com.baidu.adp.base.f fVar, p pVar) {
        this.leC = 0;
        this.dyV = 0;
        this.mContext = fVar;
        this.leC = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mHr = pVar;
        this.dyV = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mHs != null) {
                this.mHs.setSelfListener(true);
                this.mHs.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mHs);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        this.leL.m(i, i2, z);
        if (this.mHr != null && this.mHr.getListView().getChildCount() != 0 && this.mHr.getContentViewsCount() != 0) {
            if (this.leK != null && !ds(this.leK.getVideoContainer())) {
                this.leK.stopPlay();
            }
            if (this.leI != null && (this.leI.getTag() instanceof e) && this.leJ) {
                if (ds(((e) this.leI.getTag()).getVideoContainer())) {
                    f(i3, this.leI);
                    this.leJ = false;
                    return;
                }
                this.leI = null;
            }
            int contentViewsCount = this.mHr.getContentViewsCount() + this.mHr.getHeaderViewsCount() + this.mHr.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mHr.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i5 = 0;
                z3 = false;
                while (i5 < childCount) {
                    View childAt = this.mHr.getListView().getChildAt(z2 ? i5 : (childCount - 1) - i5);
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
                    View childAt2 = this.mHr.getListView().getChildAt(i6);
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
                        View childAt3 = this.mHr.getListView().getChildAt(i7);
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
                    View childAt4 = this.mHr.getListView().getChildAt(z ? (childCount - 1) - i8 : i8);
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
                if (!z6 && this.leI != null && (this.leI.getTag() instanceof e)) {
                    ((e) this.leI.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.leI != null && this.leI != view && (this.leI.getTag() instanceof e)) {
                ((e) this.leI.getTag()).stopPlay();
            }
            this.leI = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.enb && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).dbX();
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
            ((d) view.getTag()).cpP();
        }
    }

    public boolean ds(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mHq == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.leC - this.leD && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dt(View view) {
        if (view != null && !ds(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leM);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHt);
        dcz();
    }

    public void Ef(int i) {
        this.leG = i;
    }

    public void dcz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHr.getListView().getChildCount()) {
                View childAt = this.mHr.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void NH(String str) {
        this.leF = str;
    }

    public void dcC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHr.getListView().getChildCount()) {
                View childAt = this.mHr.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ef(eVar.getCurrentPosition());
                        NH(eVar.getPlayUrl());
                        this.leI = childAt;
                        this.leJ = eVar.isPlaying();
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

    public void dcD() {
        if (this.enb) {
            if (this.leI != null && (this.leI.getTag() instanceof e)) {
                e eVar = (e) this.leI.getTag();
                if (this.leJ) {
                    eVar.startPlay();
                    this.leJ = false;
                }
                if (this.leI.getTag() instanceof d) {
                    ((d) this.leI.getTag()).dbY();
                }
            }
            this.leI = null;
        }
    }

    public void cQu() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leM);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mHr.getListView().getChildCount()) {
                View childAt = this.mHr.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mHt);
        this.mHt.DW(i);
        this.mHt.DX(i2);
        this.mHt.qK(z);
        this.mHt.tK(z2);
        this.leL.tK(z2);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mHt, 500L);
    }

    public void tN(boolean z) {
        this.enb = z;
    }

    public void Hn(int i) {
        this.leD = i;
    }

    public void Ho(int i) {
        this.mHq = i;
    }

    public View dzV() {
        return this.leI;
    }
}
