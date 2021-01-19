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
    private int dwQ;
    private ListView kWA;
    private View kWE;
    private com.baidu.tieba.play.e kWG;
    private int kWy;
    private com.baidu.adp.base.f mContext;
    private int kWz = 0;
    private String kWB = null;
    private int kWC = 0;
    private Map<String, Integer> kWD = new HashMap();
    private boolean kWF = false;
    private boolean ekU = true;
    private com.baidu.tieba.play.a kWI = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.lego.card.view.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                n.this.cOx();
                if (n.this.ekU && n.this.ekU) {
                    n.this.b(n.this.kWH.dxO(), n.this.kWH.dxP(), n.this.kWH.dxQ(), n.this.kWH.dxR());
                }
            }
        }
    };
    private b kWJ = new b(this);
    private com.baidu.tieba.play.l kWH = new com.baidu.tieba.play.l();

    public n(com.baidu.adp.base.f fVar, ListView listView) {
        this.kWy = 0;
        this.dwQ = 0;
        this.mContext = fVar;
        this.kWy = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.kWA = listView;
        this.dwQ = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.kWH.l(i, i2, z);
        if (this.kWA != null && this.kWA.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.kWA instanceof BdListView ? ((BdListView) this.kWA).getWrappedAdapter() : this.kWA.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.kWG != null && !du(this.kWG.getVideoContainer())) {
                    this.kWG.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.kWA.getHeaderViewsCount() + this.kWA.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i4 = 0; i4 < this.kWA.getChildCount(); i4++) {
                        View childAt = this.kWA.getChildAt(z2 ? i4 : (this.kWA.getChildCount() - 1) - i4);
                        if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                            if (!z3 && du(eVar.getVideoContainer())) {
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
                        if (i5 >= this.kWA.getChildCount()) {
                            i5 = -1;
                            break;
                        }
                        View childAt2 = this.kWA.getChildAt(i5);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar2 = (com.baidu.tieba.play.e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && du(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i5++;
                    }
                    if (i5 >= 0) {
                        for (int i6 = 0; i6 < this.kWA.getChildCount(); i6++) {
                            View childAt3 = this.kWA.getChildAt(i6);
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
                    while (i7 < this.kWA.getChildCount()) {
                        View childAt4 = this.kWA.getChildAt(z ? (this.kWA.getChildCount() - 1) - i7 : i7);
                        if (childAt4.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar4 = (com.baidu.tieba.play.e) childAt4.getTag();
                            if (!z5 && du(eVar4.getVideoContainer())) {
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
            this.kWE = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
                if (this.ekU && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
                ((com.baidu.tieba.play.d) view.getTag()).cZZ();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
            ((com.baidu.tieba.play.d) view.getTag()).coK();
        }
    }

    public boolean du(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.kWz && measuredHeight < this.kWy;
        }
        return false;
    }

    public void dv(View view) {
        if (view != null && !du(view) && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
            if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
                bB(eVar.getPlayUrl(), eVar.getCurrentPosition());
            }
            eVar.stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWI);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWJ);
        daB();
    }

    public void DN(int i) {
        this.kWC = i;
    }

    public void daB() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kWA.getChildCount()) {
                View childAt = this.kWA.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String daC() {
        return this.kWB;
    }

    public void MT(String str) {
        this.kWB = str;
    }

    public int daD() {
        return this.kWC;
    }

    public int MU(String str) {
        if (this.kWD.containsKey(str)) {
            return this.kWD.get(str).intValue();
        }
        return 0;
    }

    public void bB(String str, int i) {
        if (this.kWD.containsKey(str)) {
            if (this.kWD.get(str).intValue() != 0) {
                this.kWD.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.kWD.put(str, Integer.valueOf(i));
    }

    public void MV(String str) {
        if (this.kWD.containsKey(str)) {
            this.kWD.put(str, 0);
        }
    }

    public void daE() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kWA.getChildCount()) {
                View childAt = this.kWA.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        DN(eVar.getCurrentPosition());
                        MT(eVar.getPlayUrl());
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
            if (this.kWE != null && (this.kWE.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) this.kWE.getTag();
                if (this.kWF) {
                    eVar.startPlay();
                }
                if (this.kWE.getTag() instanceof com.baidu.tieba.play.d) {
                    ((com.baidu.tieba.play.d) this.kWE.getTag()).daa();
                }
            }
            this.kWE = null;
        }
    }

    public void cOx() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWI);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWJ);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kWA.getChildCount()) {
                View childAt = this.kWA.getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kWJ);
        this.kWJ.DE(i);
        this.kWJ.DF(i2);
        this.kWJ.qA(z);
        this.kWJ.tx(z2);
        this.kWH.tx(z2);
        com.baidu.adp.lib.f.e.mB().post(this.kWJ);
    }

    public void tA(boolean z) {
        this.ekU = z;
    }
}
