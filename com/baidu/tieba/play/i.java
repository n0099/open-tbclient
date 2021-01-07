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
    private int dBC;
    private int lbe;
    private View lbk;
    private e lbm;
    private p mCR;
    private com.baidu.adp.base.f mContext;
    private int mCQ = 0;
    private int lbf = 0;
    private String lbh = null;
    private int lbi = 0;
    private boolean lbl = false;
    private boolean epJ = true;
    private a lbo = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.play.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                i.this.cSp();
                if (i.this.epJ && i.this.epJ) {
                    i.this.b(i.this.lbn.dBG(), i.this.lbn.dBH(), i.this.lbn.dBI(), i.this.lbn.dBJ());
                }
            }
        }
    };
    private final CustomMessageListener mCS = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.play.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!at.isEmpty(str)) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(i.this.lbo);
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(i.this.mCT);
                    if (i.this.lbk != null && (i.this.lbk.getTag() instanceof e)) {
                        if (!str.equals(((e) i.this.lbk.getTag()).getPlayUrl())) {
                            ((e) i.this.lbk.getTag()).stopPlay();
                        } else {
                            return;
                        }
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < i.this.mCR.getListView().getChildCount()) {
                            View childAt = i.this.mCR.getListView().getChildAt(i2);
                            if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                                i.this.lbk = childAt;
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
    private b mCT = new b(this);
    private l lbn = new l();

    public i(com.baidu.adp.base.f fVar, p pVar) {
        this.lbe = 0;
        this.dBC = 0;
        this.mContext = fVar;
        this.lbe = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.mCR = pVar;
        this.dBC = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            if (this.mCS != null) {
                this.mCS.setSelfListener(true);
                this.mCS.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
            MessageManager.getInstance().registerListener(this.mCS);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        this.lbn.l(i, i2, z);
        if (this.mCR != null && this.mCR.getListView().getChildCount() != 0 && this.mCR.getContentViewsCount() != 0) {
            if (this.lbm != null && !du(this.lbm.getVideoContainer())) {
                this.lbm.stopPlay();
            }
            if (this.lbk != null && (this.lbk.getTag() instanceof e) && this.lbl) {
                if (du(((e) this.lbk.getTag()).getVideoContainer())) {
                    f(i3, this.lbk);
                    this.lbl = false;
                    return;
                }
                this.lbk = null;
            }
            int contentViewsCount = this.mCR.getContentViewsCount() + this.mCR.getHeaderViewsCount() + this.mCR.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                z2 = i2 == contentViewsCount + (-1) ? false : false;
            }
            int childCount = this.mCR.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                int i5 = 0;
                z3 = false;
                while (i5 < childCount) {
                    View childAt = this.mCR.getListView().getChildAt(z2 ? i5 : (childCount - 1) - i5);
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
                    View childAt2 = this.mCR.getListView().getChildAt(i6);
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
                        View childAt3 = this.mCR.getListView().getChildAt(i7);
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
                    View childAt4 = this.mCR.getListView().getChildAt(z ? (childCount - 1) - i8 : i8);
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
                if (!z6 && this.lbk != null && (this.lbk.getTag() instanceof e)) {
                    ((e) this.lbk.getTag()).stopPlay();
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            if (this.lbk != null && this.lbk != view && (this.lbk.getTag() instanceof e)) {
                ((e) this.lbk.getTag()).stopPlay();
            }
            this.lbk = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.epJ && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).ddR();
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
            ((d) view.getTag()).csC();
        }
    }

    public boolean du(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (this.mCQ == 1) {
            return rect.top >= 0 && rect.top <= com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity()) / 2 && rect.bottom - rect.top >= view.getMeasuredHeight();
        }
        return rect.top >= 0 && rect.bottom <= this.lbe - this.lbf && rect.bottom - rect.top >= view.getMeasuredHeight();
    }

    public void dv(View view) {
        if (view != null && !du(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbo);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCT);
        det();
    }

    public void Ft(int i) {
        this.lbi = i;
    }

    public void det() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCR.getListView().getChildCount()) {
                View childAt = this.mCR.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void Oa(String str) {
        this.lbh = str;
    }

    public void dew() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCR.getListView().getChildCount()) {
                View childAt = this.mCR.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ft(eVar.getCurrentPosition());
                        Oa(eVar.getPlayUrl());
                        this.lbk = childAt;
                        this.lbl = eVar.isPlaying();
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

    public void dex() {
        if (this.epJ) {
            if (this.lbk != null && (this.lbk.getTag() instanceof e)) {
                e eVar = (e) this.lbk.getTag();
                if (this.lbl) {
                    eVar.startPlay();
                    this.lbl = false;
                }
                if (this.lbk.getTag() instanceof d) {
                    ((d) this.lbk.getTag()).ddS();
                }
            }
            this.lbk = null;
        }
    }

    public void cSp() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbo);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCT);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mCR.getListView().getChildCount()) {
                View childAt = this.mCR.getListView().getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mCT);
        this.mCT.Fk(i);
        this.mCT.Fl(i2);
        this.mCT.qE(z);
        this.mCT.tB(z2);
        this.lbn.tB(z2);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mCT, 500L);
    }

    public void tE(boolean z) {
        this.epJ = z;
    }

    public void IC(int i) {
        this.lbf = i;
    }

    public void ID(int i) {
        this.mCQ = i;
    }

    public View dBF() {
        return this.lbk;
    }
}
