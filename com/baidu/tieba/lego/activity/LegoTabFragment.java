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
    private long gEF;
    private g gET;
    private a gFP;
    j gFy;
    private ScrollFragmentTabHost gGn;
    private String gGo;
    private String gGp;
    private String itemId;
    private h refreshView;
    private String title;
    List<d> gGq = new ArrayList();
    private com.baidu.tieba.lego.d gGf = new com.baidu.tieba.lego.d() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.1
        @Override // com.baidu.tieba.lego.d
        public void a(int i, long j, String str, String str2) {
            LegoTabFragment.this.gFP.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void i(long j, String str) {
            LegoTabFragment.this.gFP.p(j, str);
        }
    };
    private c gGr = new c() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.2
        @Override // com.baidu.tieba.lego.c
        public void h(long j, String str) {
            LegoTabFragment.this.gFP.a(1, j, str, 1, "");
        }

        @Override // com.baidu.tieba.lego.c
        public void a(long j, String str, int i, String str2) {
            LegoTabFragment.this.gFP.a(1, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.c
        public void b(String str, String str2, String str3, List<e> list) {
            LegoTabFragment.this.title = str;
            LegoTabFragment.this.gGo = str2;
            LegoTabFragment.this.gGp = str3;
            LegoTabFragment.this.aXX();
            LegoTabFragment.this.di(list);
        }

        @Override // com.baidu.tieba.lego.c
        public void de(List<d> list) {
            if (LegoTabFragment.this.gGq == null) {
                LegoTabFragment.this.gGq = new ArrayList();
            } else {
                LegoTabFragment.this.gGq.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.gGq.addAll(list);
            }
            LegoTabFragment.this.bzG();
        }

        @Override // com.baidu.tieba.lego.c
        public void blR() {
            LegoTabFragment.this.bY(LegoTabFragment.this.getView());
        }
    };
    private CustomMessageListener gGs = new CustomMessageListener(2016449) { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            LegoTabFragment.this.aXX();
            LegoTabFragment.this.bzG();
        }
    };

    public void b(j jVar) {
        this.gFy = jVar;
    }

    public void dp(long j) {
        this.gEF = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXX() {
        if (this.gFy != null) {
            if (!TextUtils.isEmpty(this.gGo) && !TextUtils.isEmpty(this.gGp)) {
                this.gFy.dj(this.gGo, this.gGp);
            } else {
                this.gFy.xR(this.title);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzG() {
        if (this.gFy != null) {
            this.gFy.df(this.gGq);
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
        if (isPrimary() && this.gGn != null && this.gGn.bBk()) {
            this.gGn.j(this.gEF, this.itemId);
            a(getView(), false, getResources().getDimensionPixelSize(d.e.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        fb();
        this.gGn = (ScrollFragmentTabHost) getView().findViewById(d.g.lego_tab_host);
        this.gGn.setPageUniqueId(getUniqueId());
        this.gGn.a(this.gGf, this.gGr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.gGs);
    }

    private void fb() {
        this.gFP = b.bBl().b(getPageContext(), getUniqueId());
        this.gFP.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.4
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                LegoTabFragment.this.aXX();
                if (z) {
                    LegoTabFragment.this.bY(LegoTabFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || LegoTabFragment.this.gGn.bmf() || (dataRes != null && dataRes.cards != null)) {
                    LegoTabFragment.this.gGn.b(z, j, str, dataRes, z2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(d.j.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoTabFragment.this.bY(LegoTabFragment.this.getView());
                if (LegoTabFragment.this.gGn.bmf()) {
                    LegoTabFragment.this.gGn.c(j, str, str2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(d.j.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
                LegoTabFragment.this.bY(LegoTabFragment.this.getView());
                LegoTabFragment.this.gGn.a(j, str, (DataRes) message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(List<e> list) {
        int i;
        int S = v.S(list);
        if (S > 0 && this.gGn != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= S) {
                    i = 0;
                    break;
                } else if (list.get(i2).gKV == this.gEF) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.gGn.setFirstPosition(i);
            this.gGn.m(list, i);
            this.gGn.setCurrentTab(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.gET == null) {
            if (i < 0) {
                this.gET = new g(getActivity());
            } else {
                this.gET = new g(getActivity(), i);
            }
            this.gET.onChangeSkinType();
        }
        this.gET.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(View view) {
        if (this.gET != null) {
            this.gET.dettachView(view);
            this.gET = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoTabFragment.this.gFP != null) {
                        LegoTabFragment.this.gFP.a(1, LegoTabFragment.this.gEF, LegoTabFragment.this.itemId, 1, "");
                        LegoTabFragment.this.aBt();
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
    public void aBt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gGn != null) {
            this.gGn.onChangeSkinType(i);
        }
    }
}
