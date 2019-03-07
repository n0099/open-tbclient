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
    private int gJR;
    private ListView gJT;
    private View gJX;
    private com.baidu.tieba.play.f gJZ;
    private com.baidu.adp.base.e mContext;
    private int gJS = 0;
    private String gJU = null;
    private int gJV = 0;
    private Map<String, Integer> gJW = new HashMap();
    private boolean gJY = false;
    private boolean bjS = true;
    private com.baidu.tieba.play.a gKb = new com.baidu.tieba.play.a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.lego.card.view.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.boo();
                if (l.this.bjS && l.this.bjS) {
                    l.this.c(l.this.gKa.bTE(), l.this.gKa.bTF(), l.this.gKa.bTG(), l.this.gKa.bTH());
                }
            }
        }
    };
    private b gKc = new b(this);
    private s gKa = new s();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.gJR = 0;
        this.aIR = 0;
        this.mContext = eVar;
        this.gJR = com.baidu.adp.lib.util.l.aQ(this.mContext.getPageActivity());
        this.gJT = listView;
        this.aIR = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        eVar.registerListener(this.mNetworkChangedMessageListener);
    }

    public void a(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4 = 0;
        this.gKa.i(i, i2, z);
        if (this.gJT != null && this.gJT.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.gJT instanceof BdListView ? ((BdListView) this.gJT).getWrappedAdapter() : this.gJT.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.gJZ != null && !ca(this.gJZ.getVideoContainer())) {
                    this.gJZ.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.gJT.getHeaderViewsCount() + this.gJT.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.gJT.getChildCount(); i5++) {
                        View childAt = this.gJT.getChildAt(z2 ? i5 : (this.gJT.getChildCount() - 1) - i5);
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
                        if (i6 >= this.gJT.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.gJT.getChildAt(i6);
                        if (childAt2.getTag() instanceof com.baidu.tieba.play.f) {
                            com.baidu.tieba.play.f fVar2 = (com.baidu.tieba.play.f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && ca(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.gJT.getChildCount()) {
                            View childAt3 = this.gJT.getChildAt(i4);
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
                    while (i4 < this.gJT.getChildCount()) {
                        View childAt4 = this.gJT.getChildAt(z ? (this.gJT.getChildCount() - 1) - i4 : i4);
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
            this.gJX = view;
            if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.f)) {
                com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) view.getTag();
                if (this.bjS && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
                ((com.baidu.tieba.play.e) view.getTag()).bAn();
            }
        }
    }

    private void i(int i, View view) {
        if (i == 1 && (view.getTag() instanceof com.baidu.tieba.play.f)) {
            ((com.baidu.tieba.play.f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof com.baidu.tieba.play.e)) {
            ((com.baidu.tieba.play.e) view.getTag()).bAo();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.gJS && measuredHeight < this.gJR;
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKb);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKc);
        bAR();
    }

    public void va(int i) {
        this.gJV = i;
    }

    public void bAR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gJT.getChildCount()) {
                View childAt = this.gJT.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.f) {
                    ((com.baidu.tieba.play.f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public String bAS() {
        return this.gJU;
    }

    public void yc(String str) {
        this.gJU = str;
    }

    public int bAT() {
        return this.gJV;
    }

    public int yd(String str) {
        if (this.gJW.containsKey(str)) {
            return this.gJW.get(str).intValue();
        }
        return 0;
    }

    public void bc(String str, int i) {
        if (this.gJW.containsKey(str)) {
            if (this.gJW.get(str).intValue() != 0) {
                this.gJW.put(str, Integer.valueOf(i));
                return;
            }
            return;
        }
        this.gJW.put(str, Integer.valueOf(i));
    }

    public void ye(String str) {
        if (this.gJW.containsKey(str)) {
            this.gJW.put(str, 0);
        }
    }

    public void bAU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gJT.getChildCount()) {
                View childAt = this.gJT.getChildAt(i2);
                if (childAt.getTag() instanceof com.baidu.tieba.play.f) {
                    com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        va(fVar.getCurrentPosition());
                        yc(fVar.getPlayUrl());
                        this.gJX = childAt;
                        this.gJY = fVar.isPlaying();
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

    public void bAV() {
        if (this.bjS) {
            if (this.gJX != null && (this.gJX.getTag() instanceof com.baidu.tieba.play.f)) {
                com.baidu.tieba.play.f fVar = (com.baidu.tieba.play.f) this.gJX.getTag();
                if (this.gJY) {
                    fVar.startPlay();
                }
                if (this.gJX.getTag() instanceof com.baidu.tieba.play.e) {
                    ((com.baidu.tieba.play.e) this.gJX.getTag()).bAp();
                }
            }
            this.gJX = null;
        }
    }

    public void boo() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKb);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKc);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.gJT.getChildCount()) {
                View childAt = this.gJT.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.gKc);
        this.gKc.uS(i);
        this.gKc.uT(i2);
        this.gKc.jj(z);
        this.gKc.mb(z2);
        this.gKa.mb(z2);
        com.baidu.adp.lib.g.e.jH().post(this.gKc);
    }

    public void md(boolean z) {
        this.bjS = z;
    }
}
