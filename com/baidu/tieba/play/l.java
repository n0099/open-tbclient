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
    private int bsK;
    private int cRT;
    private ListView dPo;
    private View dPs;
    private e dPu;
    private com.baidu.adp.base.e mContext;
    private int dPn = 0;
    private String dPp = null;
    private int dPq = 0;
    private boolean dPt = false;
    private boolean dPw = true;
    private a dPx = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.apM();
                if (l.this.dPw && l.this.dPw) {
                    l.this.a(l.this.dPv.bfH(), l.this.dPv.bfI(), l.this.dPv.bfJ(), l.this.dPv.bfK());
                }
            }
        }
    };
    private b fyj = new b(this);
    private q dPv = new q();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.bsK = 0;
        this.cRT = 0;
        this.mContext = eVar;
        this.bsK = com.baidu.adp.lib.util.k.ag(this.mContext.getPageActivity());
        this.dPo = listView;
        this.cRT = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.dPv.i(i, i2, z);
        if (this.dPo != null && this.dPo.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dPo instanceof BdListView ? ((BdListView) this.dPo).getWrappedAdapter() : this.dPo.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dPu != null && !aP(this.dPu.getVideoContainer())) {
                    this.dPu.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dPo.getHeaderViewsCount() + this.dPo.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dPo.getChildCount(); i5++) {
                        View childAt = this.dPo.getChildAt(z2 ? i5 : (this.dPo.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof e) {
                            e eVar = (e) childAt.getTag();
                            if (!z3 && aP(eVar.getVideoContainer())) {
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
                        if (i6 >= this.dPo.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dPo.getChildAt(i6);
                        if (childAt2.getTag() instanceof e) {
                            e eVar2 = (e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && aP(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dPo.getChildCount()) {
                            View childAt3 = this.dPo.getChildAt(i4);
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
                    while (i4 < this.dPo.getChildCount()) {
                        View childAt4 = this.dPo.getChildAt(z ? (this.dPo.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof e) {
                            e eVar3 = (e) childAt4.getTag();
                            if (!z5 && aP(eVar3.getVideoContainer())) {
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
            this.dPs = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.dPw && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).aCv();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).aCw();
        }
    }

    public boolean aP(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dPn && measuredHeight < this.bsK;
        }
        return false;
    }

    public void aQ(View view) {
        if (view != null && !aP(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dPx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fyj);
        aDc();
    }

    public void nm(int i) {
        this.dPq = i;
    }

    public void aDc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dPo.getChildCount()) {
                View childAt = this.dPo.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void na(String str) {
        this.dPp = str;
    }

    public void aDf() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dPo.getChildCount()) {
                View childAt = this.dPo.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        nm(eVar.getCurrentPosition());
                        na(eVar.getPlayUrl());
                        this.dPs = childAt;
                        this.dPt = eVar.isPlaying();
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

    public void aDg() {
        if (this.dPw) {
            if (this.dPs != null && (this.dPs.getTag() instanceof e)) {
                e eVar = (e) this.dPs.getTag();
                if (this.dPt) {
                    eVar.startPlay();
                }
                if (this.dPs.getTag() instanceof d) {
                    ((d) this.dPs.getTag()).aCx();
                }
            }
            this.dPs = null;
        }
    }

    public void apM() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dPx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fyj);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dPo.getChildCount()) {
                View childAt = this.dPo.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fyj);
        this.fyj.ne(i);
        this.fyj.nf(i2);
        this.fyj.eK(z);
        this.fyj.hs(z2);
        this.dPv.hs(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fyj, 500L);
    }

    public void hu(boolean z) {
        this.dPw = z;
    }
}
