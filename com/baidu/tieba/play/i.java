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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private int dwQ;
    private View kWE;
    private e kWG;
    private int kWy;
    private com.baidu.adp.base.f mContext;
    private p myl;
    private int myk = 0;
    private int kWz = 0;
    private String kWB = null;
    private int kWC = 0;
    private boolean kWF = false;
    private boolean ekU = true;
    private a kWI = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cOx();
                if (i.this.ekU && i.this.ekU) {
                    i.this.b(i.this.kWH.dxO(), i.this.kWH.dxP(), i.this.kWH.dxQ(), i.this.kWH.dxR());
                }
            }
        }
    };
    private final CustomMessageListener mym = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(i.this.kWI);
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(i.this.myn);
                    if (i.this.kWE != null && (i.this.kWE.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kWE.getTag()).getPlayUrl())) {
                            ((e) i.this.kWE.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.myl.getListView().getChildCount()) {
                            View childAt = i.this.myl.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kWE = childAt;
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
    private b myn = new b(this);
    private l kWH = new l();

    public i(com.baidu.adp.base.f fVar, p pVar) {
        this.kWy = 0;
        this.dwQ = 0;
        this.mContext = fVar;
        this.kWy = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.myl = pVar;
        this.dwQ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mym != null) {
                this.mym.setSelfListener(true);
                this.mym.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mym);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        this.kWH.l(i, i2, z);
        if (this.myl != null && this.myl.getListView().getChildCount() != 0 && this.myl.getContentViewsCount() != 0) {
            if (this.kWG != null && !du(this.kWG.getVideoContainer())) {
                this.kWG.stopPlay();
            }
            if (this.kWE != null && (this.kWE.getTag() instanceof e) && this.kWF) {
                if (du(((e) this.kWE.getTag()).getVideoContainer())) {
                    f(i3, this.kWE);
                    this.kWF = false;
                    return;
                }
                this.kWE = null;
            }
            int contentViewsCount = this.myl.getContentViewsCount() + this.myl.getHeaderViewsCount() + this.myl.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.myl.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i5 = 0;
                z3 = false;
                while (i5 < childCount) {
                    View childAt = this.myl.getListView().getChildAt(z2 ? i5 : (childCount - 1) - i5);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && du(eVar.getVideoContainer())) {
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
                    View childAt2 = this.myl.getListView().getChildAt(i6);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && du(eVar2.getVideoContainer())) {
                            i4 = i6;
                            break;
                        }
                    }
                    i6++;
                }
                if (i4 >= 0) {
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt3 = this.myl.getListView().getChildAt(i7);
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
                    View childAt4 = this.myl.getListView().getChildAt(z ? (childCount - 1) - i8 : i8);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (!z6 && (eVar3.isFullScreen() || du(eVar3.getVideoContainer()))) {
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
                if (!z6 && this.kWE != null && (this.kWE.getTag() instanceof e)) {
                    ((e) this.kWE.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kWE != null && this.kWE != view && (this.kWE.getTag() instanceof e)) {
                ((e) this.kWE.getTag()).stopPlay();
            }
            this.kWE = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.ekU && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cZZ();
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
            ((d) view.getTag()).coK();
        }
    }

    public boolean du(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.myk == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kWy - this.kWz && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dv(View view) {
        if (view != null && !du(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWI);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.myn);
        daB();
    }

    public void DN(int i) {
        this.kWC = i;
    }

    public void daB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.myl.getListView().getChildCount()) {
                View childAt = this.myl.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void MS(String str) {
        this.kWB = str;
    }

    public void daE() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.myl.getListView().getChildCount()) {
                View childAt = this.myl.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        DN(eVar.getCurrentPosition());
                        MS(eVar.getPlayUrl());
                        this.kWE = childAt;
                        this.kWF = eVar.isPlaying();
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

    public void daF() {
        if (this.ekU) {
            if (this.kWE != null && (this.kWE.getTag() instanceof e)) {
                e eVar = (e) this.kWE.getTag();
                if (this.kWF) {
                    eVar.startPlay();
                    this.kWF = false;
                }
                if (this.kWE.getTag() instanceof d) {
                    ((d) this.kWE.getTag()).daa();
                }
            }
            this.kWE = null;
        }
    }

    public void cOx() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWI);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.myn);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.myl.getListView().getChildCount()) {
                View childAt = this.myl.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.myn);
        this.myn.DE(i);
        this.myn.DF(i2);
        this.myn.qA(z);
        this.myn.tx(z2);
        this.kWH.tx(z2);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.myn, 500L);
    }

    public void tA(boolean z) {
        this.ekU = z;
    }

    public void GV(int i) {
        this.kWz = i;
    }

    public void GW(int i) {
        this.myk = i;
    }

    public View dxN() {
        return this.kWE;
    }
}
