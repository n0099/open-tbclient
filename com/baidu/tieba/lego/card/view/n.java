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
    private int dBC;
    private int lbe;
    private ListView lbg;
    private View lbk;
    private com.baidu.tieba.play.e lbm;
    private com.baidu.adp.base.f mContext;
    private int lbf = 0;
    private String lbh = null;
    private int lbi = 0;
    private Map<String, Integer> lbj = new HashMap();
    private boolean lbl = false;
    private boolean epJ = true;
    private com.baidu.tieba.play.a lbo = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.lego.card.view.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                n.this.cSp();
                if (n.this.epJ && n.this.epJ) {
                    n.this.b(n.this.lbn.dBG(), n.this.lbn.dBH(), n.this.lbn.dBI(), n.this.lbn.dBJ());
                }
            }
        }
    };
    private b lbp = new b(this);
    private com.baidu.tieba.play.l lbn = new com.baidu.tieba.play.l();

    public n(com.baidu.adp.base.f fVar, ListView listView) {
        this.lbe = 0;
        this.dBC = 0;
        this.mContext = fVar;
        this.lbe = com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext.getPageActivity());
        this.lbg = listView;
        this.dBC = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        fVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.lbn.l(i, i2, z);
        if (this.lbg != null && this.lbg.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.lbg instanceof BdListView ? ((BdListView) this.lbg).getWrappedAdapter() : this.lbg.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.lbm != null && !du(this.lbm.getVideoContainer())) {
                    this.lbm.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.lbg.getHeaderViewsCount() + this.lbg.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i4 = 0; i4 < this.lbg.getChildCount(); i4++) {
                        View childAt = this.lbg.getChildAt(z2 ? i4 : (this.lbg.getChildCount() - 1) - i4);
                        if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
                            if (!z3 && du(eVar.getVideoContainer())) {
                                f(i3, childAt);
                                z3 = true;
                            } else {
                                if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
                                    bA(eVar.getPlayUrl(), eVar.getCurrentPosition());
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
                        if (i5 >= this.lbg.getChildCount()) {
                            i5 = -1;
                            break;
                        }
                        View childAt2 = this.lbg.getChildAt(i5);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar2 = (com.baidu.tieba.play.e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && du(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i5++;
                    }
                    if (i5 >= 0) {
                        for (int i6 = 0; i6 < this.lbg.getChildCount(); i6++) {
                            View childAt3 = this.lbg.getChildAt(i6);
                            if (i6 == i5) {
                                f(i3, childAt3);
                            } else {
                                if (childAt3.getTag() instanceof com.baidu.tieba.play.e) {
                                    com.baidu.tieba.play.e eVar3 = (com.baidu.tieba.play.e) childAt3.getTag();
                                    if (!TextUtils.isEmpty(eVar3.getPlayUrl()) && eVar3.getCurrentPosition() > 0) {
                                        bA(eVar3.getPlayUrl(), eVar3.getCurrentPosition());
                                    }
                                }
                                g(i3, childAt3);
                            }
                        }
                        return;
                    }
                    int i7 = 0;
                    boolean z5 = false;
                    while (i7 < this.lbg.getChildCount()) {
                        View childAt4 = this.lbg.getChildAt(z ? (this.lbg.getChildCount() - 1) - i7 : i7);
                        if (childAt4.getTag() instanceof com.baidu.tieba.play.e) {
                            com.baidu.tieba.play.e eVar4 = (com.baidu.tieba.play.e) childAt4.getTag();
                            if (!z5 && du(eVar4.getVideoContainer())) {
                                f(i3, childAt4);
                                z4 = true;
                                i7++;
                                z5 = z4;
                            } else {
                                if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                                    bA(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
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
            this.lbk = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
                if (this.epJ && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
                ((com.baidu.tieba.play.d) view.getTag()).ddR();
            }
        }
    }

    private void g(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.d)) {
            ((com.baidu.tieba.play.d) view.getTag()).csC();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.lbf && measuredHeight < this.lbe;
        }
        return false;
    }

    public void dv(View view) {
        if (view != null && !du(view) && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) view.getTag();
            if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
                bA(eVar.getPlayUrl(), eVar.getCurrentPosition());
            }
            eVar.stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbo);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbp);
        det();
    }

    public void Ft(int i) {
        this.lbi = i;
    }

    public void det() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lbg.getChildCount()) {
                View childAt = this.lbg.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String deu() {
        return this.lbh;
    }

    public void Oa(String str) {
        this.lbh = str;
    }

    public int dev() {
        return this.lbi;
    }

    public int Ob(String str) {
        if (this.lbj.containsKey(str)) {
            return this.lbj.get(str).intValue();
        }
        return 0;
    }

    public void bA(String str, int i) {
        if (this.lbj.containsKey(str)) {
            if (this.lbj.get(str).intValue() != 0) {
                this.lbj.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.lbj.put(str, Integer.valueOf(i));
    }

    public void Oc(String str) {
        if (this.lbj.containsKey(str)) {
            this.lbj.put(str, 0);
        }
    }

    public void dew() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lbg.getChildCount()) {
                View childAt = this.lbg.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.e) {
                    com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) childAt.getTag();
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
            if (this.lbk != null && (this.lbk.getTag() instanceof com.baidu.tieba.play.e)) {
                com.baidu.tieba.play.e eVar = (com.baidu.tieba.play.e) this.lbk.getTag();
                if (this.lbl) {
                    eVar.startPlay();
                }
                if (this.lbk.getTag() instanceof com.baidu.tieba.play.d) {
                    ((com.baidu.tieba.play.d) this.lbk.getTag()).ddS();
                }
            }
            this.lbk = null;
        }
    }

    public void cSp() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbo);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbp);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.lbg.getChildCount()) {
                View childAt = this.lbg.getChildAt(i2);
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
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lbp);
        this.lbp.Fk(i);
        this.lbp.Fl(i2);
        this.lbp.qE(z);
        this.lbp.tB(z2);
        this.lbn.tB(z2);
        com.baidu.adp.lib.f.e.mB().post(this.lbp);
    }

    public void tE(boolean z) {
        this.epJ = z;
    }
}
