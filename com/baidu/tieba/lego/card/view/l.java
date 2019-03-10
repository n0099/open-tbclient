package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.play.s;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class l {
    private int aIR;
    private int gJS;
    private ListView gJU;
    private View gJY;
    private com.baidu.tieba.play.f gKa;
    private com.baidu.adp.base.e mContext;
    private int gJT = 0;
    private String gJV = null;
    private int gJW = 0;
    private Map<String, Integer> gJX = new HashMap();
    private boolean gJZ = false;
    private boolean bjS = true;
    private com.baidu.tieba.play.a gKc = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.lego.card.view.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.bop();
                if (l.this.bjS && l.this.bjS) {
                    l.this.c(l.this.gKb.bTF(), l.this.gKb.bTG(), l.this.gKb.bTH(), l.this.gKb.bTI());
                }
            }
        }
    };
    private b gKd = new b(this);
    private s gKb = new s();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.gJS = 0;
        this.aIR = 0;
        this.mContext = eVar;
        this.gJS = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gJU = listView;
        this.aIR = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.gKb.i(i, i2, z);
        if (this.gJU != null && this.gJU.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.gJU instanceof BdListView ? ((BdListView) this.gJU).getWrappedAdapter() : this.gJU.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.gKa != null && !ca(this.gKa.getVideoContainer())) {
                    this.gKa.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.gJU.getHeaderViewsCount() + this.gJU.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.gJU.getChildCount(); i5++) {
                        View childAt = this.gJU.getChildAt(z2 ? i5 : (this.gJU.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof com.baidu.tieba.play.f) {
                            com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) childAt.getTag();
                            if (!z3 && ca(fVar.getVideoContainer())) {
                                h(i3, childAt);
                                z3 = true;
                            } else {
                                if (!TextUtils.isEmpty(fVar.getPlayUrl()) && fVar.getCurrentPosition() > 0) {
                                    bc(fVar.getPlayUrl(), fVar.getCurrentPosition());
                                }
                                i(i3, childAt);
                            }
                        }
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= this.gJU.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.gJU.getChildAt(i6);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.f) {
                            com.baidu.tieba.play.f fVar2 = (com.baidu.tieba.play.f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && ca(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.gJU.getChildCount()) {
                            View childAt3 = this.gJU.getChildAt(i4);
                            if (i4 == i6) {
                                h(i3, childAt3);
                            } else {
                                if (childAt3.getTag() instanceof com.baidu.tieba.play.f) {
                                    com.baidu.tieba.play.f fVar3 = (com.baidu.tieba.play.f) childAt3.getTag();
                                    if (!TextUtils.isEmpty(fVar3.getPlayUrl()) && fVar3.getCurrentPosition() > 0) {
                                        bc(fVar3.getPlayUrl(), fVar3.getCurrentPosition());
                                    }
                                }
                                i(i3, childAt3);
                            }
                            i4++;
                        }
                        return;
                    }
                    boolean z5 = false;
                    while (i4 < this.gJU.getChildCount()) {
                        View childAt4 = this.gJU.getChildAt(z ? (this.gJU.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof com.baidu.tieba.play.f) {
                            com.baidu.tieba.play.f fVar4 = (com.baidu.tieba.play.f) childAt4.getTag();
                            if (!z5 && ca(fVar4.getVideoContainer())) {
                                h(i3, childAt4);
                                z4 = true;
                                i4++;
                                z5 = z4;
                            } else {
                                if (!TextUtils.isEmpty(fVar4.getPlayUrl()) && fVar4.getCurrentPosition() > 0) {
                                    bc(fVar4.getPlayUrl(), fVar4.getCurrentPosition());
                                }
                                i(i3, childAt4);
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

    private void h(int i, View view) {
        if (view != null) {
            this.gJY = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.f)) {
                com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) view.getTag();
                if (this.bjS && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                ((com.baidu.tieba.play.e) view.getTag()).bAo();
            }
        }
    }

    private void i(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.f)) {
            ((com.baidu.tieba.play.f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).bAp();
        }
    }

    public boolean ca(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.gJT && measuredHeight < this.gJS;
        }
        return false;
    }

    public void cb(View view) {
        if (view != null && !ca(view) && (view.getTag() instanceof com.baidu.tieba.play.f)) {
            com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) view.getTag();
            if (!TextUtils.isEmpty(fVar.getPlayUrl()) && fVar.getCurrentPosition() > 0) {
                bc(fVar.getPlayUrl(), fVar.getCurrentPosition());
            }
            fVar.stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKc);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKd);
        bAS();
    }

    public void va(int i) {
        this.gJW = i;
    }

    public void bAS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gJU.getChildCount()) {
                View childAt = this.gJU.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.f) {
                    ((com.baidu.tieba.play.f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String bAT() {
        return this.gJV;
    }

    public void yd(String str) {
        this.gJV = str;
    }

    public int bAU() {
        return this.gJW;
    }

    public int ye(String str) {
        if (this.gJX.containsKey(str)) {
            return this.gJX.get(str).intValue();
        }
        return 0;
    }

    public void bc(String str, int i) {
        if (this.gJX.containsKey(str)) {
            if (this.gJX.get(str).intValue() != 0) {
                this.gJX.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.gJX.put(str, Integer.valueOf(i));
    }

    public void yf(String str) {
        if (this.gJX.containsKey(str)) {
            this.gJX.put(str, 0);
        }
    }

    public void bAV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gJU.getChildCount()) {
                View childAt = this.gJU.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.f) {
                    com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        va(fVar.getCurrentPosition());
                        yd(fVar.getPlayUrl());
                        this.gJY = childAt;
                        this.gJZ = fVar.isPlaying();
                        fVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void bAW() {
        if (this.bjS) {
            if (this.gJY != null && (this.gJY.getTag() instanceof com.baidu.tieba.play.f)) {
                com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) this.gJY.getTag();
                if (this.gJZ) {
                    fVar.startPlay();
                }
                if (this.gJY.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) this.gJY.getTag()).bAq();
                }
            }
            this.gJY = null;
        }
    }

    public void bop() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKc);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKd);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gJU.getChildCount()) {
                View childAt = this.gJU.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.f) {
                    com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        fVar.stopPlay();
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void c(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKd);
        this.gKd.uS(i);
        this.gKd.uT(i2);
        this.gKd.jj(z);
        this.gKd.mb(z2);
        this.gKb.mb(z2);
        com.baidu.adp.lib.g.e.jH().post(this.gKd);
    }

    public void md(boolean z) {
        this.bjS = z;
    }
}
