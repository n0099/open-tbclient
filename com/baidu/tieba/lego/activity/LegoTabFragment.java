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
/* loaded from: classes9.dex */
public class LegoTabFragment extends BaseFragment {
    private String itemId;
    private long kVZ;
    j kWR;
    private g kWn;
    private ScrollFragmentTabHost kXE;
    private String kXF;
    private String kXG;
    private a kXh;
    private h refreshView;
    private String title;
    List<d> kXH = new ArrayList();
    private com.baidu.tieba.lego.d kXw = new com.baidu.tieba.lego.d() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.1
        @Override // com.baidu.tieba.lego.d
        public void c(int i, long j, String str, String str2) {
            LegoTabFragment.this.kXh.a(2, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.d
        public void o(long j, String str) {
            LegoTabFragment.this.kXh.v(j, str);
        }
    };
    private c kXI = new c() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.2
        @Override // com.baidu.tieba.lego.c
        public void n(long j, String str) {
            LegoTabFragment.this.kXh.a(1, j, str, 1, "");
        }

        @Override // com.baidu.tieba.lego.c
        public void a(long j, String str, int i, String str2) {
            LegoTabFragment.this.kXh.a(1, j, str, i, str2);
        }

        @Override // com.baidu.tieba.lego.c
        public void b(String str, String str2, String str3, List<e> list) {
            LegoTabFragment.this.title = str;
            LegoTabFragment.this.kXF = str2;
            LegoTabFragment.this.kXG = str3;
            LegoTabFragment.this.cBa();
            LegoTabFragment.this.eL(list);
        }

        @Override // com.baidu.tieba.lego.c
        public void eH(List<d> list) {
            if (LegoTabFragment.this.kXH == null) {
                LegoTabFragment.this.kXH = new ArrayList();
            } else {
                LegoTabFragment.this.kXH.clear();
            }
            if (list != null && list.size() > 0) {
                LegoTabFragment.this.kXH.addAll(list);
            }
            LegoTabFragment.this.ddl();
        }

        @Override // com.baidu.tieba.lego.c
        public void cRk() {
            LegoTabFragment.this.ds(LegoTabFragment.this.getView());
        }
    };
    private CustomMessageListener kXJ = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_SWITCH_TAB) { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            LegoTabFragment.this.cBa();
            LegoTabFragment.this.ddl();
        }
    };

    public void b(j jVar) {
        this.kWR = jVar;
    }

    public void hb(long j) {
        this.kVZ = j;
    }

    public void setItemId(String str) {
        this.itemId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBa() {
        if (this.kWR != null) {
            if (!TextUtils.isEmpty(this.kXF) && !TextUtils.isEmpty(this.kXG)) {
                this.kWR.fH(this.kXF, this.kXG);
            } else {
                this.kWR.Le(this.title);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddl() {
        if (this.kWR != null) {
            this.kWR.eI(this.kXH);
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
        if (isPrimary() && this.kXE != null && this.kXE.deM()) {
            this.kXE.p(this.kVZ, this.itemId);
            b(getView(), false, getResources().getDimensionPixelSize(R.dimen.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initModel();
        this.kXE = (ScrollFragmentTabHost) getView().findViewById(R.id.lego_tab_host);
        this.kXE.setPageUniqueId(getUniqueId());
        this.kXE.a(this.kXw, this.kXI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.kXJ);
    }

    private void initModel() {
        this.kXh = b.deN().b(getPageContext(), getUniqueId());
        this.kXh.a(new com.baidu.tieba.lego.model.b() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.4
            @Override // com.baidu.tieba.lego.model.b
            public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
                LegoTabFragment.this.cBa();
                if (z) {
                    LegoTabFragment.this.ds(LegoTabFragment.this.getView());
                }
                DataRes dataRes = (DataRes) message;
                if (!z || LegoTabFragment.this.kXE.cRH() || (dataRes != null && dataRes.cards != null)) {
                    LegoTabFragment.this.kXE.b(z, j, str, dataRes, z2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.neterror), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, String str2, int i) {
                LegoTabFragment.this.ds(LegoTabFragment.this.getView());
                if (LegoTabFragment.this.kXE.cRH()) {
                    LegoTabFragment.this.kXE.c(j, str, str2, i);
                } else if (LegoTabFragment.this.getPageContext() != null && LegoTabFragment.this.getPageContext().getResources() != null) {
                    LegoTabFragment.this.showNetRefreshView(LegoTabFragment.this.getView(), LegoTabFragment.this.getPageContext().getResources().getString(R.string.net_error_text, str2, Integer.valueOf(i)), false);
                }
            }

            @Override // com.baidu.tieba.lego.model.b
            public void a(long j, String str, Message message, boolean z) {
                LegoTabFragment.this.ds(LegoTabFragment.this.getView());
                LegoTabFragment.this.kXE.a(j, str, (DataRes) message, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(List<e> list) {
        int i;
        int count = x.getCount(list);
        if (count > 0 && this.kXE != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= count) {
                    i = 0;
                    break;
                } else if (list.get(i2).lcg == this.kVZ) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.kXE.setFirstPosition(i);
            this.kXE.o(list, i);
            this.kXE.setCurrentTab(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, boolean z, int i) {
        if (this.kWn == null) {
            if (i < 0) {
                this.kWn = new g(getActivity());
            } else {
                this.kWn = new g(getActivity(), i);
            }
            this.kWn.onChangeSkinType();
        }
        this.kWn.attachView(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
        if (this.kWn != null) {
            this.kWn.dettachView(view);
            this.kWn = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.lego.activity.LegoTabFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (LegoTabFragment.this.kXh != null) {
                        LegoTabFragment.this.kXh.a(1, LegoTabFragment.this.kVZ, LegoTabFragment.this.itemId, 1, "");
                        LegoTabFragment.this.Zj();
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
    public void Zj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kXE != null) {
            this.kXE.onChangeSkinType(i);
        }
    }
}
