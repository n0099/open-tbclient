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
    private int buX;
    private ListView dZm;
    private View dZq;
    private e dZs;
    private int dbO;
    private com.baidu.adp.base.e mContext;
    private int dZl = 0;
    private String dZn = null;
    private int dZo = 0;
    private boolean dZr = false;
    private boolean dZu = true;
    private a dZv = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.asj();
                if (l.this.dZu && l.this.dZu) {
                    l.this.a(l.this.dZt.bfI(), l.this.dZt.bfJ(), l.this.dZt.bfK(), l.this.dZt.bfL());
                }
            }
        }
    };
    private b fzS = new b(this);
    private q dZt = new q();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.buX = 0;
        this.dbO = 0;
        this.mContext = eVar;
        this.buX = com.baidu.adp.lib.util.k.ae(this.mContext.getPageActivity());
        this.dZm = listView;
        this.dbO = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.dZt.i(i, i2, z);
        if (this.dZm != null && this.dZm.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dZm instanceof BdListView ? ((BdListView) this.dZm).getWrappedAdapter() : this.dZm.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dZs != null && !aY(this.dZs.getVideoContainer())) {
                    this.dZs.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dZm.getHeaderViewsCount() + this.dZm.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dZm.getChildCount(); i5++) {
                        View childAt = this.dZm.getChildAt(z2 ? i5 : (this.dZm.getChildCount() - 1) - i5);
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
                        if (i6 >= this.dZm.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dZm.getChildAt(i6);
                        if (childAt2.getTag() instanceof e) {
                            e eVar2 = (e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && aY(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dZm.getChildCount()) {
                            View childAt3 = this.dZm.getChildAt(i4);
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
                    while (i4 < this.dZm.getChildCount()) {
                        View childAt4 = this.dZm.getChildAt(z ? (this.dZm.getChildCount() - 1) - i4 : i4);
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
            this.dZq = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.dZu && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).aEX();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).aEY();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dZl && measuredHeight < this.buX;
        }
        return false;
    }

    public void aZ(View view) {
        if (view != null && !aY(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dZv);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fzS);
        aFC();
    }

    public void nO(int i) {
        this.dZo = i;
    }

    public void aFC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dZm.getChildCount()) {
                View childAt = this.dZm.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nF(String str) {
        this.dZn = str;
    }

    public void aFF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dZm.getChildCount()) {
                View childAt = this.dZm.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        nO(eVar.getCurrentPosition());
                        nF(eVar.getPlayUrl());
                        this.dZq = childAt;
                        this.dZr = eVar.isPlaying();
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

    public void aFG() {
        if (this.dZu) {
            if (this.dZq != null && (this.dZq.getTag() instanceof e)) {
                e eVar = (e) this.dZq.getTag();
                if (this.dZr) {
                    eVar.startPlay();
                }
                if (this.dZq.getTag() instanceof d) {
                    ((d) this.dZq.getTag()).aEZ();
                }
            }
            this.dZq = null;
        }
    }

    public void asj() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.dZv);
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fzS);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dZm.getChildCount()) {
                View childAt = this.dZm.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fzS);
        this.fzS.nG(i);
        this.fzS.nH(i2);
        this.fzS.eP(z);
        this.fzS.hD(z2);
        this.dZt.hD(z2);
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.fzS, 500L);
    }

    public void hF(boolean z) {
        this.dZu = z;
    }
}
