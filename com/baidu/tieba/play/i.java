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
    private int dbC;
    private int kpA;
    private View kpG;
    private e kpI;
    private s lQH;
    private com.baidu.adp.base.e mContext;
    private int lQG = 0;
    private int kpB = 0;
    private String kpD = null;
    private int kpE = 0;
    private boolean kpH = false;
    private boolean mIsShowing = true;
    private a kpK = new a();
    private final CustomMessageListener eiK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cEF();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kpJ.dro(), i.this.kpJ.drp(), i.this.kpJ.drq(), i.this.kpJ.drr());
                }
            }
        }
    };
    private final CustomMessageListener lQI = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.kpK);
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(i.this.lQJ);
                    if (i.this.kpG != null && (i.this.kpG.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kpG.getTag()).getPlayUrl())) {
                            ((e) i.this.kpG.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.lQH.getListView().getChildCount()) {
                            View childAt = i.this.lQH.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kpG = childAt;
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
    private b lQJ = new b(this);
    private l kpJ = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kpA = 0;
        this.dbC = 0;
        this.mContext = eVar;
        this.kpA = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lQH = sVar;
        this.dbC = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.eiK);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.eiK != null) {
                this.eiK.setTag(bdUniqueId);
            }
            if (this.lQI != null) {
                this.lQI.setSelfListener(true);
                this.lQI.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eiK);
            MessageManager.getInstance().registerListener(this.lQI);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kpJ.l(i, i2, z);
        if (this.lQH != null && this.lQH.getListView().getChildCount() != 0 && this.lQH.getContentViewsCount() != 0) {
            if (this.kpI != null && !cQ(this.kpI.getVideoContainer())) {
                this.kpI.stopPlay();
            }
            if (this.kpG != null && (this.kpG.getTag() instanceof e) && this.kpH) {
                if (cQ(((e) this.kpG.getTag()).getVideoContainer())) {
                    f(i3, this.kpG);
                    this.kpH = false;
                    return;
                }
                this.kpG = null;
            }
            int contentViewsCount = this.lQH.getContentViewsCount() + this.lQH.getHeaderViewsCount() + this.lQH.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.lQH.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.lQH.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && cQ(eVar.getVideoContainer())) {
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
                    View childAt2 = this.lQH.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && cQ(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.lQH.getListView().getChildAt(i6);
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
                    View childAt4 = this.lQH.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || cQ(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.kpG != null && (this.kpG.getTag() instanceof e)) {
                    ((e) this.kpG.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kpG != null && this.kpG != view && (this.kpG.getTag() instanceof e)) {
                ((e) this.kpG.getTag()).stopPlay();
            }
            this.kpG = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cTP();
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
            ((d) view.getTag()).cgq();
        }
    }

    public boolean cQ(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.lQG == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kpA - this.kpB && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cR(View view) {
        if (view != null && !cQ(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kpK);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQJ);
        cUq();
    }

    public void DG(int i) {
        this.kpE = i;
    }

    public void cUq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lQH.getListView().getChildCount()) {
                View childAt = this.lQH.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void MZ(String str) {
        this.kpD = str;
    }

    public void cUt() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lQH.getListView().getChildCount()) {
                View childAt = this.lQH.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        DG(eVar.getCurrentPosition());
                        MZ(eVar.getPlayUrl());
                        this.kpG = childAt;
                        this.kpH = eVar.isPlaying();
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

    public void cUu() {
        if (this.mIsShowing) {
            if (this.kpG != null && (this.kpG.getTag() instanceof e)) {
                e eVar = (e) this.kpG.getTag();
                if (this.kpH) {
                    eVar.startPlay();
                    this.kpH = false;
                }
                if (this.kpG.getTag() instanceof d) {
                    ((d) this.kpG.getTag()).cTQ();
                }
            }
            this.kpG = null;
        }
    }

    public void cEF() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kpK);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQJ);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lQH.getListView().getChildCount()) {
                View childAt = this.lQH.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lQJ);
        this.lQJ.Dx(i);
        this.lQJ.Dy(i2);
        this.lQJ.pf(z);
        this.lQJ.su(z2);
        this.kpJ.su(z2);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.lQJ, 500L);
    }

    public void sw(boolean z) {
        this.mIsShowing = z;
    }

    public void GN(int i) {
        this.kpB = i;
    }

    public void GO(int i) {
        this.lQG = i;
    }

    public View drn() {
        return this.kpG;
    }
}
