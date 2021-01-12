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
import com.baidu.tbadk.core.util.x;
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
    private g kRI;
    private long kRu;
    private a kSC;
    private ScrollFragmentTabHost kSZ;
    j kSm;
    private String kTa;
    private String kTb;
    private h refreshView;
    private String title;
    List<d> kTc = new ArrayList();
    private com.baidu.tieba.lego.d kSR = new com.baidu.tieba.lego.d() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.1
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoTabFragment.this.kSC.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void o(long j, String str) {
            LegoTabFragment.this.kSC.v(j, str);
        }
    };
    private c kTd = new c() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.2
        @Override // com.baidu.tieba.lego.c
        public void n(long j, String str) {
            LegoTabFragment.this.kSC.a(1, j, str, 1, "");
        }

        @Override // com.baidu.tieba.lego.c
        public void a(long j, String str, int i, String str2) {
            LegoTabFragment.this.kSC.a(1, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.c
        public void b(String str, String str2, String str3, List<e> list) {
            LegoTabFragment.this.title = str;
            LegoTabFragment.this.kTa = str2;
            LegoTabFragment.this.kTb = str3;
            LegoTabFragment.this.cxi();
            LegoTabFragment.this.eL(list);
        }

        @Override // com.baidu.tieba.lego.c
        public void eH(List<d> list) {
            if (LegoTabFragment.this.kTc == null) {
                LegoTabFragment.this.kTc = new ArrayList();
            } else {
                LegoTabFragment.this.kTc.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.kTc.addAll(list);
            }
            LegoTabFragment.this.cZt();
        }

        @Override // com.baidu.tieba.lego.c
        public void cNs() {
            LegoTabFragment.this.ds(LegoTabFragment.this.getView());
        }
    };
    private CustomMessageListener kTe = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB) { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            LegoTabFragment.this.cxi();
            LegoTabFragment.this.cZt();
        }
    };

    public void b(j jVar) {
        this.kSm = jVar;
    }

    public void hb(long j) {
        this.kRu = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxi() {
        if (this.kSm != null) {
            if (!TextUtils.isEmpty(this.kTa) && !TextUtils.isEmpty(this.kTb)) {
                this.kSm.fG(this.kTa, this.kTb);
            } else {
                this.kSm.JU(this.title);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZt() {
        if (this.kSm != null) {
            this.kSm.eI(this.kTc);
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
        if (isPrimary() && this.kSZ != null && this.kSZ.daU()) {
            this.kSZ.p(this.kRu, this.itemId);
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
        this.kSZ = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
        this.kSZ.setPageUniqueId(getUniqueId());
        this.kSZ.a(this.kSR, this.kTd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.kTe);
    }

    private void initModel() {
        this.kSC = b.daV().b(getPageContext(), getUniqueId());
        this.kSC.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.4
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                LegoTabFragment.this.cxi();
                if (z) {
                    LegoTabFragment.this.ds(LegoTabFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || LegoTabFragment.this.kSZ.cNP() || (dataRes != null && dataRes.cards != null)) {
                    LegoTabFragment.this.kSZ.b(z, j, str, dataRes, z2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoTabFragment.this.ds(LegoTabFragment.this.getView());
                if (LegoTabFragment.this.kSZ.cNP()) {
                    LegoTabFragment.this.kSZ.c(j, str, str2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
                LegoTabFragment.this.ds(LegoTabFragment.this.getView());
                LegoTabFragment.this.kSZ.a(j, str, (DataRes) message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(List<e> list) {
        int i;
        int count = x.getCount(list);
        if (count > 0 && this.kSZ != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i = 0;
                    break;
                } else if (list.get(i2).kXA == this.kRu) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.kSZ.setFirstPosition(i);
            this.kSZ.o(list, i);
            this.kSZ.setCurrentTab(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, int i) {
        if (this.kRI == null) {
            if (i < 0) {
                this.kRI = new g(getActivity());
            } else {
                this.kRI = new g(getActivity(), i);
            }
            this.kRI.onChangeSkinType();
        }
        this.kRI.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
        if (this.kRI != null) {
            this.kRI.dettachView(view);
            this.kRI = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoTabFragment.this.kSC != null) {
                        LegoTabFragment.this.kSC.a(1, LegoTabFragment.this.kRu, LegoTabFragment.this.itemId, 1, "");
                        LegoTabFragment.this.Vq();
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
    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kSZ != null) {
            this.kSZ.onChangeSkinType(i);
        }
    }
}
