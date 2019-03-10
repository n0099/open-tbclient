package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.c;
import com.baidu.tieba.lego.c.d;
import com.baidu.tieba.lego.c.e;
import com.baidu.tieba.lego.d.b;
import com.baidu.tieba.lego.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.lego.j;
import com.baidu.tieba.lego.model.a;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class LegoTabFragment extends BaseFragment {
    private long gEG;
    private g gEU;
    private a gFQ;
    j gFz;
    private ScrollFragmentTabHost gGo;
    private String gGp;
    private String gGq;
    private String itemId;
    private h refreshView;
    private String title;
    List<d> gGr = new ArrayList();
    private com.baidu.tieba.lego.d gGg = new com.baidu.tieba.lego.d() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.1
        @Override // com.baidu.tieba.lego.d
        public void a(int i, long j, String str, String str2) {
            LegoTabFragment.this.gFQ.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void i(long j, String str) {
            LegoTabFragment.this.gFQ.p(j, str);
        }
    };
    private c gGs = new c() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.2
        @Override // com.baidu.tieba.lego.c
        public void h(long j, String str) {
            LegoTabFragment.this.gFQ.a(1, j, str, 1, "");
        }

        @Override // com.baidu.tieba.lego.c
        public void a(long j, String str, int i, String str2) {
            LegoTabFragment.this.gFQ.a(1, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.c
        public void b(String str, String str2, String str3, List<e> list) {
            LegoTabFragment.this.title = str;
            LegoTabFragment.this.gGp = str2;
            LegoTabFragment.this.gGq = str3;
            LegoTabFragment.this.aXY();
            LegoTabFragment.this.di(list);
        }

        @Override // com.baidu.tieba.lego.c
        public void de(List<d> list) {
            if (LegoTabFragment.this.gGr == null) {
                LegoTabFragment.this.gGr = new ArrayList();
            } else {
                LegoTabFragment.this.gGr.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.gGr.addAll(list);
            }
            LegoTabFragment.this.bzH();
        }

        @Override // com.baidu.tieba.lego.c
        public void blS() {
            LegoTabFragment.this.bY(LegoTabFragment.this.getView());
        }
    };
    private CustomMessageListener gGt = new CustomMessageListener(2016449) { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            LegoTabFragment.this.aXY();
            LegoTabFragment.this.bzH();
        }
    };

    public void b(j jVar) {
        this.gFz = jVar;
    }

    public void dp(long j) {
        this.gEG = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXY() {
        if (this.gFz != null) {
            if (!TextUtils.isEmpty(this.gGp) && !TextUtils.isEmpty(this.gGq)) {
                this.gFz.dj(this.gGp, this.gGq);
            } else {
                this.gFz.xS(this.title);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzH() {
        if (this.gFz != null) {
            this.gFz.df(this.gGr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.lego_tab_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && this.gGo != null && this.gGo.bBl()) {
            this.gGo.j(this.gEG, this.itemId);
            a(getView(), false, getResources().getDimensionPixelSize(d.e.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
        this.gGo = (ScrollFragmentTabHost) getView().findViewById(d.g.lego_tab_host);
        this.gGo.setPageUniqueId(getUniqueId());
        this.gGo.a(this.gGg, this.gGs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gGt);
    }

    private void fb() {
        this.gFQ = b.bBm().b(getPageContext(), getUniqueId());
        this.gFQ.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.4
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                LegoTabFragment.this.aXY();
                if (z) {
                    LegoTabFragment.this.bY(LegoTabFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || LegoTabFragment.this.gGo.bmg() || (dataRes != null && dataRes.cards != null)) {
                    LegoTabFragment.this.gGo.b(z, j, str, dataRes, z2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(d.j.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoTabFragment.this.bY(LegoTabFragment.this.getView());
                if (LegoTabFragment.this.gGo.bmg()) {
                    LegoTabFragment.this.gGo.c(j, str, str2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(d.j.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
                LegoTabFragment.this.bY(LegoTabFragment.this.getView());
                LegoTabFragment.this.gGo.a(j, str, (DataRes) message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(List<e> list) {
        int i;
        int S = v.S(list);
        if (S > 0 && this.gGo != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= S) {
                    i = 0;
                    break;
                } else if (list.get(i2).gKW == this.gEG) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.gGo.setFirstPosition(i);
            this.gGo.m(list, i);
            this.gGo.setCurrentTab(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.gEU == null) {
            if (i < 0) {
                this.gEU = new g(getActivity());
            } else {
                this.gEU = new g(getActivity(), i);
            }
            this.gEU.onChangeSkinType();
        }
        this.gEU.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(View view) {
        if (this.gEU != null) {
            this.gEU.dettachView(view);
            this.gEU = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoTabFragment.this.gFQ != null) {
                        LegoTabFragment.this.gFQ.a(1, LegoTabFragment.this.gEG, LegoTabFragment.this.itemId, 1, "");
                        LegoTabFragment.this.aBu();
                        LegoTabFragment.this.a(LegoTabFragment.this.getView(), false, LegoTabFragment.this.getResources().getDimensionPixelSize(d.e.ds360));
                    }
                }
            });
        }
        this.refreshView.jR(getResources().getDimensionPixelSize(d.e.ds160));
        this.refreshView.po(str);
        this.refreshView.attachView(view, z);
        this.refreshView.anC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGo != null) {
            this.gGo.onChangeSkinType(i);
        }
    }
}
