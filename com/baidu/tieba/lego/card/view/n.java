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
/* loaded from: classes9.dex */
public class n {
    private int dyV;
    private int leQ;
    private ListView leS;
    private View leW;
    private com.baidu.tieba.play.e leY;
    private com.baidu.adp.base.f mContext;
    private int leR = 0;
    private String leT = null;
    private int leU = 0;
    private Map<String, Integer> leV = new HashMap();
    private boolean leX = false;
    private boolean enb = true;
    private com.baidu.tieba.play.a lfa = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.lego.card.view.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                n.this.cQB();
                if (n.this.enb && n.this.enb) {
                    n.this.b(n.this.leZ.dAd(), n.this.leZ.dAe(), n.this.leZ.dAf(), n.this.leZ.dAg());
                }
            }
        }
    };
    private b lfb = new b(this);
    private com.baidu.tieba.play.l leZ = new com.baidu.tieba.play.l();

    public n(com.baidu.adp.base.f fVar, ListView listView) {
        this.leQ = 0;
        this.dyV = 0;
        this.mContext = fVar;
        this.leQ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.leS = listView;
        this.dyV = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.leZ.m(i, i2, z);
        if (this.leS != null && this.leS.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.leS instanceof BdListView ? ((BdListView) this.leS).getWrappedAdapter() : this.leS.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.leY != null && !ds(this.leY.getVideoContainer())) {
                    this.leY.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.leS.getHeaderViewsCount() + this.leS.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i4 = 0; i4 < this.leS.getChildCount(); i4++) {
                        View childAt = this.leS.getChildAt(z2 ? i4 : (this.leS.getChildCount() - 1) - i4);
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
                        if (i5 >= this.leS.getChildCount()) {
                            i5 = -1;
                            break;
                        }
                        View childAt2 = this.leS.getChildAt(i5);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar2 = (com.baidu.tieba.play.e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && ds(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i5++;
                    }
                    if (i5 >= 0) {
                        for (int i6 = 0; i6 < this.leS.getChildCount(); i6++) {
                            View childAt3 = this.leS.getChildAt(i6);
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
                    while (i7 < this.leS.getChildCount()) {
                        View childAt4 = this.leS.getChildAt(z ? (this.leS.getChildCount() - 1) - i7 : i7);
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
            this.leW = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
                if (this.enb && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
                ((com.baidu.tieba.play.d) view.getTag()).dce();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
            ((com.baidu.tieba.play.d) view.getTag()).cpW();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.leR && measuredHeight < this.leQ;
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfa);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfb);
        dcG();
    }

    public void Ef(int i) {
        this.leU = i;
    }

    public void dcG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.leS.getChildCount()) {
                View childAt = this.leS.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String dcH() {
        return this.leT;
    }

    public void NI(String str) {
        this.leT = str;
    }

    public int dcI() {
        return this.leU;
    }

    public int NJ(String str) {
        if (this.leV.containsKey(str)) {
            return this.leV.get(str).intValue();
        }
        return 0;
    }

    public void bB(String str, int i) {
        if (this.leV.containsKey(str)) {
            if (this.leV.get(str).intValue() != 0) {
                this.leV.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.leV.put(str, Integer.valueOf(i));
    }

    public void NK(String str) {
        if (this.leV.containsKey(str)) {
            this.leV.put(str, 0);
        }
    }

    public void dcJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.leS.getChildCount()) {
                View childAt = this.leS.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ef(eVar.getCurrentPosition());
                        NI(eVar.getPlayUrl());
                        this.leW = childAt;
                        this.leX = eVar.isPlaying();
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

    public void dcK() {
        if (this.enb) {
            if (this.leW != null && (this.leW.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) this.leW.getTag();
                if (this.leX) {
                    eVar.startPlay();
                }
                if (this.leW.getTag() instanceof com.baidu.tieba.play.d) {
                    ((com.baidu.tieba.play.d) this.leW.getTag()).dcf();
                }
            }
            this.leW = null;
        }
    }

    public void cQB() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfa);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfb);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.leS.getChildCount()) {
                View childAt = this.leS.getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lfb);
        this.lfb.DW(i);
        this.lfb.DX(i2);
        this.lfb.qK(z);
        this.lfb.tK(z2);
        this.leZ.tK(z2);
        com.baidu.adp.lib.f.e.mA().post(this.lfb);
    }

    public void tN(boolean z) {
        this.enb = z;
    }
}
