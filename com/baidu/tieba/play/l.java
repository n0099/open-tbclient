package com.baidu.tieba.play;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
/* loaded from: classes.dex */
public class l {
    private int bvL;
    private int dcJ;
    private ListView eag;
    private View eak;
    private e eam;
    private com.baidu.adp.base.e mContext;
    private int eaf = 0;
    private String eah = null;
    private int eai = 0;
    private boolean eal = false;
    private boolean eao = true;
    private a eap = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.asu();
                if (l.this.eao && l.this.eao) {
                    l.this.a(l.this.ean.bfT(), l.this.ean.bfU(), l.this.ean.bfV(), l.this.ean.bfW());
                }
            }
        }
    };
    private b fAL = new b(this);
    private q ean = new q();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.bvL = 0;
        this.dcJ = 0;
        this.mContext = eVar;
        this.bvL = com.baidu.adp.lib.util.k.af(this.mContext.getPageActivity());
        this.eag = listView;
        this.dcJ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.mNetworkChangedMessageListener != null) {
                this.mNetworkChangedMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.ean.i(i, i2, z);
        if (this.eag != null && this.eag.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.eag instanceof BdListView ? ((BdListView) this.eag).getWrappedAdapter() : this.eag.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.eam != null && !aY(this.eam.getVideoContainer())) {
                    this.eam.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.eag.getHeaderViewsCount() + this.eag.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.eag.getChildCount(); i5++) {
                        View childAt = this.eag.getChildAt(z2 ? i5 : (this.eag.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof e) {
                            e eVar = (e) childAt.getTag();
                            if (!z3 && aY(eVar.getVideoContainer())) {
                                e(i3, childAt);
                                z3 = true;
                            } else {
                                f(i3, childAt);
                            }
                        }
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= this.eag.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.eag.getChildAt(i6);
                        if (childAt2.getTag() instanceof e) {
                            e eVar2 = (e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && aY(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.eag.getChildCount()) {
                            View childAt3 = this.eag.getChildAt(i4);
                            if (i4 == i6) {
                                e(i3, childAt3);
                            } else {
                                f(i3, childAt3);
                            }
                            i4++;
                        }
                        return;
                    }
                    boolean z5 = false;
                    while (i4 < this.eag.getChildCount()) {
                        View childAt4 = this.eag.getChildAt(z ? (this.eag.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof e) {
                            e eVar3 = (e) childAt4.getTag();
                            if (!z5 && aY(eVar3.getVideoContainer())) {
                                e(i3, childAt4);
                                z4 = true;
                                i4++;
                                z5 = z4;
                            } else {
                                f(i3, childAt4);
                            }
                        }
                        z4 = z5;
                        i4++;
                        z5 = z4;
                    }
                }
            }
        }
    }

    private void e(int i, View view) {
        if (view != null) {
            this.eak = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.eao && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).aFi();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).aFj();
        }
    }

    public boolean aY(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.eaf && measuredHeight < this.bvL;
        }
        return false;
    }

    public void aZ(View view) {
        if (view != null && !aY(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eap);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fAL);
        aFN();
    }

    public void nQ(int i) {
        this.eai = i;
    }

    public void aFN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eag.getChildCount()) {
                View childAt = this.eag.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nH(String str) {
        this.eah = str;
    }

    public void aFQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eag.getChildCount()) {
                View childAt = this.eag.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        nQ(eVar.getCurrentPosition());
                        nH(eVar.getPlayUrl());
                        this.eak = childAt;
                        this.eal = eVar.isPlaying();
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

    public void aFR() {
        if (this.eao) {
            if (this.eak != null && (this.eak.getTag() instanceof e)) {
                e eVar = (e) this.eak.getTag();
                if (this.eal) {
                    eVar.startPlay();
                }
                if (this.eak.getTag() instanceof d) {
                    ((d) this.eak.getTag()).aFk();
                }
            }
            this.eak = null;
        }
    }

    public void asu() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eap);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fAL);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eag.getChildCount()) {
                View childAt = this.eag.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fAL);
        this.fAL.nI(i);
        this.fAL.nJ(i2);
        this.fAL.eQ(z);
        this.fAL.hE(z2);
        this.ean.hE(z2);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.fAL, 500L);
    }

    public void hG(boolean z) {
        this.eao = z;
    }
}
