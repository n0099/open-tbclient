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
    private int dke;
    private int kBX;
    private View kCd;
    private e kCf;
    private com.baidu.adp.base.e mContext;
    private s mdf;
    private int mde = 0;
    private int kBY = 0;
    private String kCa = null;
    private int kCb = 0;
    private boolean kCe = false;
    private boolean mIsShowing = true;
    private a kCh = new a();
    private final CustomMessageListener eri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cHM();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kCg.duv(), i.this.kCg.duw(), i.this.kCg.dux(), i.this.kCg.duy());
                }
            }
        }
    };
    private final CustomMessageListener mdg = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.kCh);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.mdh);
                    if (i.this.kCd != null && (i.this.kCd.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kCd.getTag()).getPlayUrl())) {
                            ((e) i.this.kCd.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mdf.getListView().getChildCount()) {
                            View childAt = i.this.mdf.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kCd = childAt;
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
    private b mdh = new b(this);
    private l kCg = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kBX = 0;
        this.dke = 0;
        this.mContext = eVar;
        this.kBX = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mdf = sVar;
        this.dke = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.eri);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.eri != null) {
                this.eri.setTag(bdUniqueId);
            }
            if (this.mdg != null) {
                this.mdg.setSelfListener(true);
                this.mdg.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eri);
            MessageManager.getInstance().registerListener(this.mdg);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kCg.l(i, i2, z);
        if (this.mdf != null && this.mdf.getListView().getChildCount() != 0 && this.mdf.getContentViewsCount() != 0) {
            if (this.kCf != null && !cU(this.kCf.getVideoContainer())) {
                this.kCf.stopPlay();
            }
            if (this.kCd != null && (this.kCd.getTag() instanceof e) && this.kCe) {
                if (cU(((e) this.kCd.getTag()).getVideoContainer())) {
                    f(i3, this.kCd);
                    this.kCe = false;
                    return;
                }
                this.kCd = null;
            }
            int contentViewsCount = this.mdf.getContentViewsCount() + this.mdf.getHeaderViewsCount() + this.mdf.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mdf.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.mdf.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && cU(eVar.getVideoContainer())) {
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
                    View childAt2 = this.mdf.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && cU(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.mdf.getListView().getChildAt(i6);
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
                    View childAt4 = this.mdf.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || cU(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.kCd != null && (this.kCd.getTag() instanceof e)) {
                    ((e) this.kCd.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kCd != null && this.kCd != view && (this.kCd.getTag() instanceof e)) {
                ((e) this.kCd.getTag()).stopPlay();
            }
            this.kCd = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cWW();
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
            ((d) view.getTag()).cjx();
        }
    }

    public boolean cU(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mde == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kBX - this.kBY && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cV(View view) {
        if (view != null && !cU(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kCh);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdh);
        cXx();
    }

    public void DZ(int i) {
        this.kCb = i;
    }

    public void cXx() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mdf.getListView().getChildCount()) {
                View childAt = this.mdf.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Nx(String str) {
        this.kCa = str;
    }

    public void cXA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mdf.getListView().getChildCount()) {
                View childAt = this.mdf.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        DZ(eVar.getCurrentPosition());
                        Nx(eVar.getPlayUrl());
                        this.kCd = childAt;
                        this.kCe = eVar.isPlaying();
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

    public void cXB() {
        if (this.mIsShowing) {
            if (this.kCd != null && (this.kCd.getTag() instanceof e)) {
                e eVar = (e) this.kCd.getTag();
                if (this.kCe) {
                    eVar.startPlay();
                    this.kCe = false;
                }
                if (this.kCd.getTag() instanceof d) {
                    ((d) this.kCd.getTag()).cWX();
                }
            }
            this.kCd = null;
        }
    }

    public void cHM() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kCh);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdh);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mdf.getListView().getChildCount()) {
                View childAt = this.mdf.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mdh);
        this.mdh.DQ(i);
        this.mdh.DR(i2);
        this.mdh.px(z);
        this.mdh.sM(z2);
        this.kCg.sM(z2);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mdh, 500L);
    }

    public void sO(boolean z) {
        this.mIsShowing = z;
    }

    public void Hg(int i) {
        this.kBY = i;
    }

    public void Hh(int i) {
        this.mde = i;
    }

    public View duu() {
        return this.kCd;
    }
}
