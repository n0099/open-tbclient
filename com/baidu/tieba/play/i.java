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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class i {
    private int dpZ;
    private int kHR;
    private View kHX;
    private e kHZ;
    private com.baidu.adp.base.e mContext;
    private s mje;
    private int mjd = 0;
    private int kHS = 0;
    private String kHU = null;
    private int kHV = 0;
    private boolean kHY = false;
    private boolean mIsShowing = true;
    private a kIb = new a();
    private final CustomMessageListener exb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cKn();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kIa.dwX(), i.this.kIa.dwY(), i.this.kIa.dwZ(), i.this.kIa.dxa());
                }
            }
        }
    };
    private final CustomMessageListener mjf = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.kIb);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.mjg);
                    if (i.this.kHX != null && (i.this.kHX.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kHX.getTag()).getPlayUrl())) {
                            ((e) i.this.kHX.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mje.getListView().getChildCount()) {
                            View childAt = i.this.mje.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kHX = childAt;
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
    private b mjg = new b(this);
    private l kIa = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kHR = 0;
        this.dpZ = 0;
        this.mContext = eVar;
        this.kHR = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mje = sVar;
        this.dpZ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.exb);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.exb != null) {
                this.exb.setTag(bdUniqueId);
            }
            if (this.mjf != null) {
                this.mjf.setSelfListener(true);
                this.mjf.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.exb);
            MessageManager.getInstance().registerListener(this.mjf);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kIa.l(i, i2, z);
        if (this.mje != null && this.mje.getListView().getChildCount() != 0 && this.mje.getContentViewsCount() != 0) {
            if (this.kHZ != null && !cZ(this.kHZ.getVideoContainer())) {
                this.kHZ.stopPlay();
            }
            if (this.kHX != null && (this.kHX.getTag() instanceof e) && this.kHY) {
                if (cZ(((e) this.kHX.getTag()).getVideoContainer())) {
                    f(i3, this.kHX);
                    this.kHY = false;
                    return;
                }
                this.kHX = null;
            }
            int contentViewsCount = this.mje.getContentViewsCount() + this.mje.getHeaderViewsCount() + this.mje.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mje.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.mje.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && cZ(eVar.getVideoContainer())) {
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
                    View childAt2 = this.mje.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && cZ(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.mje.getListView().getChildAt(i6);
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
                    View childAt4 = this.mje.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || cZ(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.kHX != null && (this.kHX.getTag() instanceof e)) {
                    ((e) this.kHX.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kHX != null && this.kHX != view && (this.kHX.getTag() instanceof e)) {
                ((e) this.kHX.getTag()).stopPlay();
            }
            this.kHX = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cZx();
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
            ((d) view.getTag()).clZ();
        }
    }

    public boolean cZ(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mjd == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kHR - this.kHS && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void da(View view) {
        if (view != null && !cZ(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kIb);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjg);
        cZY();
    }

    public void Em(int i) {
        this.kHV = i;
    }

    public void cZY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mje.getListView().getChildCount()) {
                View childAt = this.mje.getListView().getChildAt(i2);
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
        this.kHU = str;
    }

    public void dab() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mje.getListView().getChildCount()) {
                View childAt = this.mje.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Em(eVar.getCurrentPosition());
                        NO(eVar.getPlayUrl());
                        this.kHX = childAt;
                        this.kHY = eVar.isPlaying();
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

    public void dac() {
        if (this.mIsShowing) {
            if (this.kHX != null && (this.kHX.getTag() instanceof e)) {
                e eVar = (e) this.kHX.getTag();
                if (this.kHY) {
                    eVar.startPlay();
                    this.kHY = false;
                }
                if (this.kHX.getTag() instanceof d) {
                    ((d) this.kHX.getTag()).cZy();
                }
            }
            this.kHX = null;
        }
    }

    public void cKn() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kIb);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mje.getListView().getChildCount()) {
                View childAt = this.mje.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjg);
        this.mjg.Ed(i);
        this.mjg.Ee(i2);
        this.mjg.pG(z);
        this.mjg.sV(z2);
        this.kIa.sV(z2);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mjg, 500L);
    }

    public void sX(boolean z) {
        this.mIsShowing = z;
    }

    public void Ht(int i) {
        this.kHS = i;
    }

    public void Hu(int i) {
        this.mjd = i;
    }

    public View dwW() {
        return this.kHX;
    }
}
