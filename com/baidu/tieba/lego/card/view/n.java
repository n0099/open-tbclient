package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.util.BdListViewHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class n {
    private int dAw;
    private int lgS;
    private ListView lgU;
    private View lgY;
    private com.baidu.tieba.play.e lha;
    private com.baidu.adp.base.f mContext;
    private int lgT = 0;
    private String lgV = null;
    private int lgW = 0;
    private Map<String, Integer> lgX = new HashMap();
    private boolean lgZ = false;
    private boolean eoF = true;
    private com.baidu.tieba.play.a lhc = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.lego.card.view.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                n.this.cQI();
                if (n.this.eoF && n.this.eoF) {
                    n.this.b(n.this.lhb.dAl(), n.this.lhb.dAm(), n.this.lhb.dAn(), n.this.lhb.dAo());
                }
            }
        }
    };
    private b lhd = new b(this);
    private com.baidu.tieba.play.l lhb = new com.baidu.tieba.play.l();

    public n(com.baidu.adp.base.f fVar, ListView listView) {
        this.lgS = 0;
        this.dAw = 0;
        this.mContext = fVar;
        this.lgS = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lgU = listView;
        this.dAw = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.lhb.m(i, i2, z);
        if (this.lgU != null && this.lgU.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.lgU instanceof BdListView ? ((BdListView) this.lgU).getWrappedAdapter() : this.lgU.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.lha != null && !ds(this.lha.getVideoContainer())) {
                    this.lha.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.lgU.getHeaderViewsCount() + this.lgU.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i4 = 0; i4 < this.lgU.getChildCount(); i4++) {
                        View childAt = this.lgU.getChildAt(z2 ? i4 : (this.lgU.getChildCount() - 1) - i4);
                        if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                            if (!z3 && ds(eVar.getVideoContainer())) {
                                f(i3, childAt);
                                z3 = true;
                            } else {
                                if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
                                    bB(eVar.getPlayUrl(), eVar.getCurrentPosition());
                                }
                                g(i3, childAt);
                            }
                        }
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= this.lgU.getChildCount()) {
                            i5 = -1;
                            break;
                        }
                        View childAt2 = this.lgU.getChildAt(i5);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar2 = (com.baidu.tieba.play.e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && ds(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i5++;
                    }
                    if (i5 >= 0) {
                        for (int i6 = 0; i6 < this.lgU.getChildCount(); i6++) {
                            View childAt3 = this.lgU.getChildAt(i6);
                            if (i6 == i5) {
                                f(i3, childAt3);
                            } else {
                                if (childAt3.getTag() instanceof com.baidu.tieba.play.e) {
                                    com.baidu.tieba.play.e eVar3 = (com.baidu.tieba.play.e) childAt3.getTag();
                                    if (!TextUtils.isEmpty(eVar3.getPlayUrl()) && eVar3.getCurrentPosition() > 0) {
                                        bB(eVar3.getPlayUrl(), eVar3.getCurrentPosition());
                                    }
                                }
                                g(i3, childAt3);
                            }
                        }
                        return;
                    }
                    int i7 = 0;
                    boolean z5 = false;
                    while (i7 < this.lgU.getChildCount()) {
                        View childAt4 = this.lgU.getChildAt(z ? (this.lgU.getChildCount() - 1) - i7 : i7);
                        if (childAt4.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar4 = (com.baidu.tieba.play.e) childAt4.getTag();
                            if (!z5 && ds(eVar4.getVideoContainer())) {
                                f(i3, childAt4);
                                z4 = true;
                                i7++;
                                z5 = z4;
                            } else {
                                if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                                    bB(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
                                }
                                g(i3, childAt4);
                            }
                        }
                        z4 = z5;
                        i7++;
                        z5 = z4;
                    }
                }
            }
        }
    }

    private void f(int i, View view) {
        if (view != null) {
            this.lgY = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
                if (this.eoF && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
                ((com.baidu.tieba.play.d) view.getTag()).dcn();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
            ((com.baidu.tieba.play.d) view.getTag()).cqc();
        }
    }

    public boolean ds(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.lgT && measuredHeight < this.lgS;
        }
        return false;
    }

    public void dt(View view) {
        if (view != null && !ds(view) && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
            if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
                bB(eVar.getPlayUrl(), eVar.getCurrentPosition());
            }
            eVar.stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhd);
        dcP();
    }

    public void Ei(int i) {
        this.lgW = i;
    }

    public void dcP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lgU.getChildCount()) {
                View childAt = this.lgU.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String dcQ() {
        return this.lgV;
    }

    public void NO(String str) {
        this.lgV = str;
    }

    public int dcR() {
        return this.lgW;
    }

    public int NP(String str) {
        if (this.lgX.containsKey(str)) {
            return this.lgX.get(str).intValue();
        }
        return 0;
    }

    public void bB(String str, int i) {
        if (this.lgX.containsKey(str)) {
            if (this.lgX.get(str).intValue() != 0) {
                this.lgX.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.lgX.put(str, Integer.valueOf(i));
    }

    public void NQ(String str) {
        if (this.lgX.containsKey(str)) {
            this.lgX.put(str, 0);
        }
    }

    public void dcS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lgU.getChildCount()) {
                View childAt = this.lgU.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ei(eVar.getCurrentPosition());
                        NO(eVar.getPlayUrl());
                        this.lgY = childAt;
                        this.lgZ = eVar.isPlaying();
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

    public void dcT() {
        if (this.eoF) {
            if (this.lgY != null && (this.lgY.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) this.lgY.getTag();
                if (this.lgZ) {
                    eVar.startPlay();
                }
                if (this.lgY.getTag() instanceof com.baidu.tieba.play.d) {
                    ((com.baidu.tieba.play.d) this.lgY.getTag()).dco();
                }
            }
            this.lgY = null;
        }
    }

    public void cQI() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhd);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lgU.getChildCount()) {
                View childAt = this.lgU.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lhd);
        this.lhd.DZ(i);
        this.lhd.Ea(i2);
        this.lhd.qK(z);
        this.lhd.tK(z2);
        this.lhb.tK(z2);
        com.baidu.adp.lib.f.e.mA().post(this.lhd);
    }

    public void tN(boolean z) {
        this.eoF = z;
    }
}
