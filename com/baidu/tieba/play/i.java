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
    private int dor;
    private int kIg;
    private View kIm;
    private e kIo;
    private com.baidu.adp.base.e mContext;
    private s mjx;
    private int mjw = 0;
    private int kIh = 0;
    private String kIj = null;
    private int kIk = 0;
    private boolean kIn = false;
    private boolean mIsShowing = true;
    private a kIq = new a();
    private final CustomMessageListener evs = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cJS();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kIp.dwx(), i.this.kIp.dwy(), i.this.kIp.dwz(), i.this.kIp.dwA());
                }
            }
        }
    };
    private final CustomMessageListener mjy = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!au.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.kIq);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.mjz);
                    if (i.this.kIm != null && (i.this.kIm.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kIm.getTag()).getPlayUrl())) {
                            ((e) i.this.kIm.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mjx.getListView().getChildCount()) {
                            View childAt = i.this.mjx.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kIm = childAt;
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
    private b mjz = new b(this);
    private l kIp = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kIg = 0;
        this.dor = 0;
        this.mContext = eVar;
        this.kIg = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mjx = sVar;
        this.dor = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.evs);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.evs != null) {
                this.evs.setTag(bdUniqueId);
            }
            if (this.mjy != null) {
                this.mjy.setSelfListener(true);
                this.mjy.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.evs);
            MessageManager.getInstance().registerListener(this.mjy);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kIp.l(i, i2, z);
        if (this.mjx != null && this.mjx.getListView().getChildCount() != 0 && this.mjx.getContentViewsCount() != 0) {
            if (this.kIo != null && !dd(this.kIo.getVideoContainer())) {
                this.kIo.stopPlay();
            }
            if (this.kIm != null && (this.kIm.getTag() instanceof e) && this.kIn) {
                if (dd(((e) this.kIm.getTag()).getVideoContainer())) {
                    f(i3, this.kIm);
                    this.kIn = false;
                    return;
                }
                this.kIm = null;
            }
            int contentViewsCount = this.mjx.getContentViewsCount() + this.mjx.getHeaderViewsCount() + this.mjx.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mjx.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.mjx.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && dd(eVar.getVideoContainer())) {
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
                    View childAt2 = this.mjx.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && dd(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.mjx.getListView().getChildAt(i6);
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
                    View childAt4 = this.mjx.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || dd(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.kIm != null && (this.kIm.getTag() instanceof e)) {
                    ((e) this.kIm.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kIm != null && this.kIm != view && (this.kIm.getTag() instanceof e)) {
                ((e) this.kIm.getTag()).stopPlay();
            }
            this.kIm = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cYT();
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
            ((d) view.getTag()).cls();
        }
    }

    public boolean dd(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mjw == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kIg - this.kIh && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void de(View view) {
        if (view != null && !dd(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kIq);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjz);
        cZv();
    }

    public void EK(int i) {
        this.kIk = i;
    }

    public void cZv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mjx.getListView().getChildCount()) {
                View childAt = this.mjx.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Nm(String str) {
        this.kIj = str;
    }

    public void cZy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mjx.getListView().getChildCount()) {
                View childAt = this.mjx.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        EK(eVar.getCurrentPosition());
                        Nm(eVar.getPlayUrl());
                        this.kIm = childAt;
                        this.kIn = eVar.isPlaying();
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

    public void cZz() {
        if (this.mIsShowing) {
            if (this.kIm != null && (this.kIm.getTag() instanceof e)) {
                e eVar = (e) this.kIm.getTag();
                if (this.kIn) {
                    eVar.startPlay();
                    this.kIn = false;
                }
                if (this.kIm.getTag() instanceof d) {
                    ((d) this.kIm.getTag()).cYU();
                }
            }
            this.kIm = null;
        }
    }

    public void cJS() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kIq);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjz);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mjx.getListView().getChildCount()) {
                View childAt = this.mjx.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mjz);
        this.mjz.EB(i);
        this.mjz.EC(i2);
        this.mjz.pJ(z);
        this.mjz.sY(z2);
        this.kIp.sY(z2);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mjz, 500L);
    }

    public void ta(boolean z) {
        this.mIsShowing = z;
    }

    public void HR(int i) {
        this.kIh = i;
    }

    public void HS(int i) {
        this.mjw = i;
    }

    public View dww() {
        return this.kIm;
    }
}
