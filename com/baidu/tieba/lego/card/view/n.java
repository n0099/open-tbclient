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
    private int leC;
    private ListView leE;
    private View leI;
    private com.baidu.tieba.play.e leK;
    private com.baidu.adp.base.f mContext;
    private int leD = 0;
    private String leF = null;
    private int leG = 0;
    private Map<String, Integer> leH = new HashMap();
    private boolean leJ = false;
    private boolean enb = true;
    private com.baidu.tieba.play.a leM = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.lego.card.view.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                n.this.cQu();
                if (n.this.enb && n.this.enb) {
                    n.this.b(n.this.leL.dzW(), n.this.leL.dzX(), n.this.leL.dzY(), n.this.leL.dzZ());
                }
            }
        }
    };
    private b leN = new b(this);
    private com.baidu.tieba.play.l leL = new com.baidu.tieba.play.l();

    public n(com.baidu.adp.base.f fVar, ListView listView) {
        this.leC = 0;
        this.dyV = 0;
        this.mContext = fVar;
        this.leC = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.leE = listView;
        this.dyV = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.leL.m(i, i2, z);
        if (this.leE != null && this.leE.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.leE instanceof BdListView ? ((BdListView) this.leE).getWrappedAdapter() : this.leE.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.leK != null && !ds(this.leK.getVideoContainer())) {
                    this.leK.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.leE.getHeaderViewsCount() + this.leE.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i4 = 0; i4 < this.leE.getChildCount(); i4++) {
                        View childAt = this.leE.getChildAt(z2 ? i4 : (this.leE.getChildCount() - 1) - i4);
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
                        if (i5 >= this.leE.getChildCount()) {
                            i5 = -1;
                            break;
                        }
                        View childAt2 = this.leE.getChildAt(i5);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar2 = (com.baidu.tieba.play.e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && ds(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i5++;
                    }
                    if (i5 >= 0) {
                        for (int i6 = 0; i6 < this.leE.getChildCount(); i6++) {
                            View childAt3 = this.leE.getChildAt(i6);
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
                    while (i7 < this.leE.getChildCount()) {
                        View childAt4 = this.leE.getChildAt(z ? (this.leE.getChildCount() - 1) - i7 : i7);
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
            this.leI = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
                if (this.enb && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
                ((com.baidu.tieba.play.d) view.getTag()).dbX();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
            ((com.baidu.tieba.play.d) view.getTag()).cpP();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.leD && measuredHeight < this.leC;
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leM);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leN);
        dcz();
    }

    public void Ef(int i) {
        this.leG = i;
    }

    public void dcz() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.leE.getChildCount()) {
                View childAt = this.leE.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String dcA() {
        return this.leF;
    }

    public void NH(String str) {
        this.leF = str;
    }

    public int dcB() {
        return this.leG;
    }

    public int NI(String str) {
        if (this.leH.containsKey(str)) {
            return this.leH.get(str).intValue();
        }
        return 0;
    }

    public void bB(String str, int i) {
        if (this.leH.containsKey(str)) {
            if (this.leH.get(str).intValue() != 0) {
                this.leH.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.leH.put(str, Integer.valueOf(i));
    }

    public void NJ(String str) {
        if (this.leH.containsKey(str)) {
            this.leH.put(str, 0);
        }
    }

    public void dcC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.leE.getChildCount()) {
                View childAt = this.leE.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        Ef(eVar.getCurrentPosition());
                        NH(eVar.getPlayUrl());
                        this.leI = childAt;
                        this.leJ = eVar.isPlaying();
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

    public void dcD() {
        if (this.enb) {
            if (this.leI != null && (this.leI.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) this.leI.getTag();
                if (this.leJ) {
                    eVar.startPlay();
                }
                if (this.leI.getTag() instanceof com.baidu.tieba.play.d) {
                    ((com.baidu.tieba.play.d) this.leI.getTag()).dbY();
                }
            }
            this.leI = null;
        }
    }

    public void cQu() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leM);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leN);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.leE.getChildCount()) {
                View childAt = this.leE.getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.leN);
        this.leN.DW(i);
        this.leN.DX(i2);
        this.leN.qK(z);
        this.leN.tK(z2);
        this.leL.tK(z2);
        com.baidu.adp.lib.f.e.mA().post(this.leN);
    }

    public void tN(boolean z) {
        this.enb = z;
    }
}
