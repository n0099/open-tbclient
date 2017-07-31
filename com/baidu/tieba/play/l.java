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
    private int btV;
    private int cTm;
    private ListView dQF;
    private View dQJ;
    private e dQL;
    private com.baidu.adp.base.e mContext;
    private int dQE = 0;
    private String dQG = null;
    private int dQH = 0;
    private boolean dQK = false;
    private boolean dQN = true;
    private a dQO = new a();
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.play.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                l.this.apY();
                if (l.this.dQN && l.this.dQN) {
                    l.this.a(l.this.dQM.bfR(), l.this.dQM.bfS(), l.this.dQM.bfT(), l.this.dQM.bfU());
                }
            }
        }
    };
    private b fzv = new b(this);
    private q dQM = new q();

    public l(com.baidu.adp.base.e eVar, ListView listView) {
        this.btV = 0;
        this.cTm = 0;
        this.mContext = eVar;
        this.btV = com.baidu.adp.lib.util.k.ah(this.mContext.getPageActivity());
        this.dQF = listView;
        this.cTm = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
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
        this.dQM.i(i, i2, z);
        if (this.dQF != null && this.dQF.getChildCount() != 0) {
            ListAdapter wrappedAdapter = this.dQF instanceof BdListView ? ((BdListView) this.dQF).getWrappedAdapter() : this.dQF.getAdapter();
            if (wrappedAdapter != null && wrappedAdapter.getCount() != 0) {
                if (this.dQL != null && !aP(this.dQL.getVideoContainer())) {
                    this.dQL.stopPlay();
                }
                int count = wrappedAdapter.getCount() + this.dQF.getHeaderViewsCount() + this.dQF.getFooterViewsCount();
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = i2 == count + (-1) ? false : false;
                }
                if (i == 0 || i2 == count - 1) {
                    z3 = false;
                    for (int i5 = 0; i5 < this.dQF.getChildCount(); i5++) {
                        View childAt = this.dQF.getChildAt(z2 ? i5 : (this.dQF.getChildCount() - 1) - i5);
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
                        if (i6 >= this.dQF.getChildCount()) {
                            i6 = -1;
                            break;
                        }
                        View childAt2 = this.dQF.getChildAt(i6);
                        if (childAt2.getTag() instanceof e) {
                            e eVar2 = (e) childAt2.getTag();
                            if (eVar2.isPlayStarted() && aP(eVar2.getVideoContainer())) {
                                break;
                            }
                        }
                        i6++;
                    }
                    if (i6 >= 0) {
                        while (i4 < this.dQF.getChildCount()) {
                            View childAt3 = this.dQF.getChildAt(i4);
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
                    while (i4 < this.dQF.getChildCount()) {
                        View childAt4 = this.dQF.getChildAt(z ? (this.dQF.getChildCount() - 1) - i4 : i4);
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
            this.dQJ = view;
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (this.dQN && !eVar.isPlayStarted()) {
                    eVar.startPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).aCG();
            }
        }
    }

    private void f(int i, View view) {
        if (i == 1 && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        } else if (i == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).aCH();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.dQE && measuredHeight < this.btV;
        }
        return false;
    }

    public void aQ(View view) {
        if (view != null && !aP(view) && (view.getTag() instanceof e)) {
            ((e) view.getTag()).stopPlay();
        }
    }

    public void destroy() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dQO);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fzv);
        aDn();
    }

    public void nl(int i) {
        this.dQH = i;
    }

    public void aDn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dQF.getChildCount()) {
                View childAt = this.dQF.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ne(String str) {
        this.dQG = str;
    }

    public void aDq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dQF.getChildCount()) {
                View childAt = this.dQF.getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        nl(eVar.getCurrentPosition());
                        ne(eVar.getPlayUrl());
                        this.dQJ = childAt;
                        this.dQK = eVar.isPlaying();
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

    public void aDr() {
        if (this.dQN) {
            if (this.dQJ != null && (this.dQJ.getTag() instanceof e)) {
                e eVar = (e) this.dQJ.getTag();
                if (this.dQK) {
                    eVar.startPlay();
                }
                if (this.dQJ.getTag() instanceof d) {
                    ((d) this.dQJ.getTag()).aCI();
                }
            }
            this.dQJ = null;
        }
    }

    public void apY() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.dQO);
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fzv);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dQF.getChildCount()) {
                View childAt = this.dQF.getChildAt(i2);
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
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.fzv);
        this.fzv.nd(i);
        this.fzv.ne(i2);
        this.fzv.eK(z);
        this.fzv.hs(z2);
        this.dQM.hs(z2);
        com.baidu.adp.lib.g.e.ga().postDelayed(this.fzv, 500L);
    }

    public void hu(boolean z) {
        this.dQN = z;
    }
}
