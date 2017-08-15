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
    private int buk;
    private int cVl;
    private ListView dSB;
    private View dSF;
    private e dSH;
    private com.baidu.adp.base.e mContext;
    private int dSA = 0;
    private String dSC = null;
    private int dSD = 0;
    private boolean dSG = false;
    private boolean dSJ = true;
    private a dSK = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.aqF();
                if (l.this.dSJ && l.this.dSJ) {
                    l.this.a(l.this.dSI.bgx(), l.this.dSI.bgy(), l.this.dSI.bgz(), l.this.dSI.bgA());
                }
            }
        }
    };
    private b fBo = new b(this);
    private q dSI = new q();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.buk = 0;
        this.cVl = 0;
        this.mContext = eVar;
        this.buk = com.baidu.adp.lib.util.k.ah(this.mContext.getPageActivity());
        this.dSB = listView;
        this.cVl = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.dSI.i(i, i2, z);
        if (this.dSB != null && this.dSB.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dSB instanceof BdListView ? ((BdListView) this.dSB).getWrappedAdapter() : this.dSB.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dSH != null && !aR(this.dSH.getVideoContainer())) {
                    this.dSH.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dSB.getHeaderViewsCount() + this.dSB.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dSB.getChildCount(); i5++) {
                        View childAt = this.dSB.getChildAt(z2 ? i5 : (this.dSB.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof e) {
                            e eVar = (e) childAt.getTag();
                            if (!z3 && aR(eVar.getVideoContainer())) {
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
                        if (i6 >= this.dSB.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dSB.getChildAt(i6);
                        if (childAt2.getTag() instanceof e) {
                            e eVar2 = (e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && aR(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dSB.getChildCount()) {
                            View childAt3 = this.dSB.getChildAt(i4);
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
                    while (i4 < this.dSB.getChildCount()) {
                        View childAt4 = this.dSB.getChildAt(z ? (this.dSB.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof e) {
                            e eVar3 = (e) childAt4.getTag();
                            if (!z5 && aR(eVar3.getVideoContainer())) {
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
            this.dSF = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.dSJ && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).aDn();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).aDo();
        }
    }

    public boolean aR(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dSA && measuredHeight < this.buk;
        }
        return false;
    }

    public void aS(View view) {
        if (view != null && !aR(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dSK);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBo);
        aDU();
    }

    public void nv(int i) {
        this.dSD = i;
    }

    public void aDU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dSB.getChildCount()) {
                View childAt = this.dSB.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ni(String str) {
        this.dSC = str;
    }

    public void aDX() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dSB.getChildCount()) {
                View childAt = this.dSB.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        nv(eVar.getCurrentPosition());
                        ni(eVar.getPlayUrl());
                        this.dSF = childAt;
                        this.dSG = eVar.isPlaying();
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

    public void aDY() {
        if (this.dSJ) {
            if (this.dSF != null && (this.dSF.getTag() instanceof e)) {
                e eVar = (e) this.dSF.getTag();
                if (this.dSG) {
                    eVar.startPlay();
                }
                if (this.dSF.getTag() instanceof d) {
                    ((d) this.dSF.getTag()).aDp();
                }
            }
            this.dSF = null;
        }
    }

    public void aqF() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dSK);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBo);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dSB.getChildCount()) {
                View childAt = this.dSB.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fBo);
        this.fBo.nn(i);
        this.fBo.no(i2);
        this.fBo.eM(z);
        this.fBo.hv(z2);
        this.dSI.hv(z2);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.fBo, 500L);
    }

    public void hx(boolean z) {
        this.dSJ = z;
    }
}
