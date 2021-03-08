package com.baidu.tieba.lego.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
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
/* loaded from: classes8.dex */
public class LegoTabFragment extends BaseFragment {
    private String itemId;
    private long lbN;
    j lcG;
    private a lcW;
    private g lcb;
    private ScrollFragmentTabHost ldt;
    private String ldu;
    private String ldv;
    private h refreshView;
    private String title;
    List<d> ldw = new ArrayList();
    private com.baidu.tieba.lego.d ldl = new com.baidu.tieba.lego.d() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.1
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoTabFragment.this.lcW.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void p(long j, String str) {
            LegoTabFragment.this.lcW.w(j, str);
        }
    };
    private c ldx = new c() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.2
        @Override // com.baidu.tieba.lego.c
        public void o(long j, String str) {
            LegoTabFragment.this.lcW.a(1, j, str, 1, "");
        }

        @Override // com.baidu.tieba.lego.c
        public void a(long j, String str, int i, String str2) {
            LegoTabFragment.this.lcW.a(1, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.c
        public void b(String str, String str2, String str3, List<e> list) {
            LegoTabFragment.this.title = str;
            LegoTabFragment.this.ldu = str2;
            LegoTabFragment.this.ldv = str3;
            LegoTabFragment.this.cyG();
            LegoTabFragment.this.eJ(list);
        }

        @Override // com.baidu.tieba.lego.c
        public void eF(List<d> list) {
            if (LegoTabFragment.this.ldw == null) {
                LegoTabFragment.this.ldw = new ArrayList();
            } else {
                LegoTabFragment.this.ldw.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.ldw.addAll(list);
            }
            LegoTabFragment.this.dbH();
        }

        @Override // com.baidu.tieba.lego.c
        public void cPC() {
            LegoTabFragment.this.dq(LegoTabFragment.this.getView());
        }
    };
    private CustomMessageListener ldy = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB) { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            LegoTabFragment.this.cyG();
            LegoTabFragment.this.dbH();
        }
    };

    public void b(j jVar) {
        this.lcG = jVar;
    }

    public void hg(long j) {
        this.lbN = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyG() {
        if (this.lcG != null) {
            if (!TextUtils.isEmpty(this.ldu) && !TextUtils.isEmpty(this.ldv)) {
                this.lcG.fG(this.ldu, this.ldv);
            } else {
                this.lcG.KP(this.title);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbH() {
        if (this.lcG != null) {
            this.lcG.eG(this.ldw);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lego_tab_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && this.ldt != null && this.ldt.ddi()) {
            this.ldt.q(this.lbN, this.itemId);
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
        this.ldt = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
        this.ldt.setPageUniqueId(getUniqueId());
        this.ldt.a(this.ldl, this.ldx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ldy);
    }

    private void initModel() {
        this.lcW = b.ddj().b(getPageContext(), getUniqueId());
        this.lcW.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.4
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                LegoTabFragment.this.cyG();
                if (z) {
                    LegoTabFragment.this.dq(LegoTabFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || LegoTabFragment.this.ldt.cQa() || (dataRes != null && dataRes.cards != null)) {
                    LegoTabFragment.this.ldt.b(z, j, str, dataRes, z2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoTabFragment.this.dq(LegoTabFragment.this.getView());
                if (LegoTabFragment.this.ldt.cQa()) {
                    LegoTabFragment.this.ldt.c(j, str, str2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
                LegoTabFragment.this.dq(LegoTabFragment.this.getView());
                LegoTabFragment.this.ldt.a(j, str, (DataRes) message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(List<e> list) {
        int i;
        int count = y.getCount(list);
        if (count > 0 && this.ldt != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i = 0;
                    break;
                } else if (list.get(i2).lhU == this.lbN) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.ldt.setFirstPosition(i);
            this.ldt.o(list, i);
            this.ldt.setCurrentTab(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, int i) {
        if (this.lcb == null) {
            if (i < 0) {
                this.lcb = new g(getActivity());
            } else {
                this.lcb = new g(getActivity(), i);
            }
            this.lcb.onChangeSkinType();
        }
        this.lcb.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(View view) {
        if (this.lcb != null) {
            this.lcb.dettachView(view);
            this.lcb = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoTabFragment.this.lcW != null) {
                        LegoTabFragment.this.lcW.a(1, LegoTabFragment.this.lbN, LegoTabFragment.this.itemId, 1, "");
                        LegoTabFragment.this.Xc();
                        LegoTabFragment.this.b(LegoTabFragment.this.getView(), false, LegoTabFragment.this.getResources().getDimensionPixelSize(R.dimen.ds360));
                    }
                }
            });
        }
        this.refreshView.setLayoutMargin(getResources().getDimensionPixelSize(R.dimen.ds160));
        this.refreshView.setSubText(str);
        this.refreshView.attachView(view, z);
        this.refreshView.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ldt != null) {
            this.ldt.onChangeSkinType(i);
        }
    }
}
