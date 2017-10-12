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
public class m {
    private int bxv;
    private int cYY;
    private ListView dWo;
    private View dWs;
    private f dWu;
    private com.baidu.adp.base.e mContext;
    private int dWn = 0;
    private String dWp = null;
    private int dWq = 0;
    private boolean dWt = false;
    private boolean dWw = true;
    private a dWx = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                m.this.ard();
                if (m.this.dWw && m.this.dWw) {
                    m.this.a(m.this.dWv.bev(), m.this.dWv.bew(), m.this.dWv.bex(), m.this.dWv.bey());
                }
            }
        }
    };
    private b fwY = new b(this);
    private r dWv = new r();

    public m(com.baidu.adp.base.e eVar, ListView listView) {
        this.bxv = 0;
        this.cYY = 0;
        this.mContext = eVar;
        this.bxv = com.baidu.adp.lib.util.l.af(this.mContext.getPageActivity());
        this.dWo = listView;
        this.cYY = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.dWv.i(i, i2, z);
        if (this.dWo != null && this.dWo.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dWo instanceof BdListView ? ((BdListView) this.dWo).getWrappedAdapter() : this.dWo.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dWu != null && !aT(this.dWu.getVideoContainer())) {
                    this.dWu.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dWo.getHeaderViewsCount() + this.dWo.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dWo.getChildCount(); i5++) {
                        View childAt = this.dWo.getChildAt(z2 ? i5 : (this.dWo.getChildCount() - 1) - i5);
                        if (childAt.getTag() instanceof f) {
                            f fVar = (f) childAt.getTag();
                            if (!z3 && aT(fVar.getVideoContainer())) {
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
                        if (i6 >= this.dWo.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dWo.getChildAt(i6);
                        if (childAt2.getTag() instanceof f) {
                            f fVar2 = (f) childAt2.getTag();
                            if (fVar2.isPlayStarted() && aT(fVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dWo.getChildCount()) {
                            View childAt3 = this.dWo.getChildAt(i4);
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
                    while (i4 < this.dWo.getChildCount()) {
                        View childAt4 = this.dWo.getChildAt(z ? (this.dWo.getChildCount() - 1) - i4 : i4);
                        if (childAt4.getTag() instanceof f) {
                            f fVar3 = (f) childAt4.getTag();
                            if (!z5 && aT(fVar3.getVideoContainer())) {
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
            this.dWs = view;
            if (i == 1 && (view.getTag() instanceof f)) {
                f fVar = (f) view.getTag();
                if (this.dWw && !fVar.isPlayStarted()) {
                    fVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof e)) {
                ((e) view.getTag()).aDY();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).aDZ();
        }
    }

    public boolean aT(View view) {
        int measuredHeight;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dWn && measuredHeight < this.bxv;
        }
        return false;
    }

    public void aU(View view) {
        if (view != null && !aT(view) && (view.getTag() instanceof f)) {
            ((f) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dWx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwY);
        aED();
    }

    public void nM(int i) {
        this.dWq = i;
    }

    public void aED() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dWo.getChildCount()) {
                View childAt = this.dWo.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    ((f) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void nl(String str) {
        this.dWp = str;
    }

    public void aEG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dWo.getChildCount()) {
                View childAt = this.dWo.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
                    if (fVar.isPlayStarted()) {
                        nM(fVar.getCurrentPosition());
                        nl(fVar.getPlayUrl());
                        this.dWs = childAt;
                        this.dWt = fVar.isPlaying();
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

    public void aEH() {
        if (this.dWw) {
            if (this.dWs != null && (this.dWs.getTag() instanceof f)) {
                f fVar = (f) this.dWs.getTag();
                if (this.dWt) {
                    fVar.startPlay();
                }
                if (this.dWs.getTag() instanceof e) {
                    ((e) this.dWs.getTag()).aEa();
                }
            }
            this.dWs = null;
        }
    }

    public void ard() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dWx);
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwY);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dWo.getChildCount()) {
                View childAt = this.dWo.getChildAt(i2);
                if (childAt.getTag() instanceof f) {
                    f fVar = (f) childAt.getTag();
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

    public void a(int i, int i2, boolean z, boolean z2) {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.fwY);
        this.fwY.nE(i);
        this.fwY.nF(i2);
        this.fwY.eG(z);
        this.fwY.hr(z2);
        this.dWv.hr(z2);
        com.baidu.adp.lib.g.e.fP().postDelayed(this.fwY, 500L);
    }

    public void ht(boolean z) {
        this.dWw = z;
    }
}
