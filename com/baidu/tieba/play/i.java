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
    private int cPx;
    private int kal;
    private View kar;
    private e kat;
    private s lBs;
    private com.baidu.adp.base.e mContext;
    private int lBr = 0;
    private int kam = 0;
    private String kao = null;
    private int kap = 0;
    private boolean kas = false;
    private boolean mIsShowing = true;
    private a kaw = new a();
    private final CustomMessageListener dWI = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cAY();
                if (i.this.mIsShowing && i.this.mIsShowing) {
                    i.this.a(i.this.kau.dnD(), i.this.kau.dnE(), i.this.kau.dnF(), i.this.kau.dnG());
                }
            }
        }
    };
    private final CustomMessageListener lBt = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(i.this.kaw);
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(i.this.lBu);
                    if (i.this.kar != null && (i.this.kar.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.kar.getTag()).getPlayUrl())) {
                            ((e) i.this.kar.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.lBs.getListView().getChildCount()) {
                            View childAt = i.this.lBs.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.kar = childAt;
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
    private b lBu = new b(this);
    private l kau = new l();

    public i(com.baidu.adp.base.e eVar, s sVar) {
        this.kal = 0;
        this.cPx = 0;
        this.mContext = eVar;
        this.kal = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lBs = sVar;
        this.cPx = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.dWI);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dWI != null) {
                this.dWI.setTag(bdUniqueId);
            }
            if (this.lBt != null) {
                this.lBt.setSelfListener(true);
                this.lBt.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dWI);
            MessageManager.getInstance().registerListener(this.lBt);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6 = 0;
        this.kau.l(i, i2, z);
        if (this.lBs != null && this.lBs.getListView().getChildCount() != 0 && this.lBs.getContentViewsCount() != 0) {
            if (this.kat != null && !cM(this.kat.getVideoContainer())) {
                this.kat.stopPlay();
            }
            if (this.kar != null && (this.kar.getTag() instanceof e) && this.kas) {
                if (cM(((e) this.kar.getTag()).getVideoContainer())) {
                    f(i3, this.kar);
                    this.kas = false;
                    return;
                }
                this.kar = null;
            }
            int contentViewsCount = this.lBs.getContentViewsCount() + this.lBs.getHeaderViewsCount() + this.lBs.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.lBs.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i7 = 0;
                z3 = false;
                while (i7 < childCount) {
                    View childAt = this.lBs.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar = (e) childAt.getTag();
                        if (!z3 && cM(eVar.getVideoContainer())) {
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
                    View childAt2 = this.lBs.getListView().getChildAt(i8);
                    if (childAt2.getTag() instanceof e) {
                        e eVar2 = (e) childAt2.getTag();
                        if (eVar2.isPlayStarted() && cM(eVar2.getVideoContainer())) {
                            i4 = i8;
                            break;
                        }
                    }
                    i8++;
                }
                if (i4 >= 0) {
                    while (i6 < childCount) {
                        View childAt3 = this.lBs.getListView().getChildAt(i6);
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
                    View childAt4 = this.lBs.getListView().getChildAt(z ? (childCount - 1) - i9 : i9);
                    if (childAt4.getTag() instanceof e) {
                        e eVar3 = (e) childAt4.getTag();
                        if (i6 == 0 && (eVar3.isFullScreen() || cM(eVar3.getVideoContainer()))) {
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
                if (i6 == 0 && this.kar != null && (this.kar.getTag() instanceof e)) {
                    ((e) this.kar.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.kar != null && this.kar != view && (this.kar.getTag() instanceof e)) {
                ((e) this.kar.getTag()).stopPlay();
            }
            this.kar = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.mIsShowing && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).cQf();
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
            ((d) view.getTag()).ccU();
        }
    }

    public boolean cM(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.lBr == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.kal - this.kam && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void cN(View view) {
        if (view != null && !cM(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.kaw);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBu);
        cQG();
    }

    public void Da(int i) {
        this.kap = i;
    }

    public void cQG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lBs.getListView().getChildCount()) {
                View childAt = this.lBs.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Mk(String str) {
        this.kao = str;
    }

    public void cQJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lBs.getListView().getChildCount()) {
                View childAt = this.lBs.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Da(eVar.getCurrentPosition());
                        Mk(eVar.getPlayUrl());
                        this.kar = childAt;
                        this.kas = eVar.isPlaying();
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

    public void cQK() {
        if (this.mIsShowing) {
            if (this.kar != null && (this.kar.getTag() instanceof e)) {
                e eVar = (e) this.kar.getTag();
                if (this.kas) {
                    eVar.startPlay();
                    this.kas = false;
                }
                if (this.kar.getTag() instanceof d) {
                    ((d) this.kar.getTag()).cQg();
                }
            }
            this.kar = null;
        }
    }

    public void cAY() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.kaw);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBu);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lBs.getListView().getChildCount()) {
                View childAt = this.lBs.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lBu);
        this.lBu.CR(i);
        this.lBu.CS(i2);
        this.lBu.oA(z);
        this.lBu.rN(z2);
        this.kau.rN(z2);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.lBu, 500L);
    }

    public void rP(boolean z) {
        this.mIsShowing = z;
    }

    public void Gh(int i) {
        this.kam = i;
    }

    public void Gi(int i) {
        this.lBr = i;
    }

    public View dnC() {
        return this.kar;
    }
}
