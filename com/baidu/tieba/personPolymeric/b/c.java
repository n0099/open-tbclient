package com.baidu.tieba.personPolymeric.b;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.p.ab;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    protected TbPageContext aaS;
    private PluginErrorTipView bXj;
    private NoNetworkView bdg;
    public PbListView bdh;
    private com.baidu.tbadk.k.f beN;
    protected BdPersonListView fhu;
    protected LinearLayout fhv;
    private a fhw;
    private ImageView fhx;
    protected NavigationBar mNavigationBar;
    protected j mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void T(View view);
    }

    public c(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.aaS = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
            this.fhu = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.fhv = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
            this.bdg = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.bXj = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.bdh = new PbListView(this.aaS.getPageActivity());
            this.bdh.la();
            this.bdh.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.bdh.dm(d.e.cp_bg_line_c);
            this.fhu.setNextPage(this.bdh);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aXU() {
        if (this.mRootView != null) {
            this.fhu.setVisibility(8);
            if (this.fhv != null) {
                this.fhv.setVisibility(8);
            }
            if (this.fhx != null) {
                this.fhx.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aaS.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    aw.aL(c.this.aaS.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aaS.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aM(c.this.aaS.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aaS.getResources().getDimensionPixelSize(d.f.ds320);
            int dimensionPixelSize2 = this.aaS.getResources().getDimensionPixelSize(d.f.ds480);
            int dimensionPixelSize3 = this.aaS.getResources().getDimensionPixelSize(d.f.ds360);
            int dimensionPixelSize4 = this.aaS.getResources().getDimensionPixelSize(d.f.ds60);
            int dimensionPixelSize5 = this.aaS.getResources().getDimensionPixelSize(d.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aaS.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aaS.getString(d.l.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aaS.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    aw.aM(c.this.aaS.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aaS, i);
        }
        ai.j(this.fhv, d.g.item_person_header_attention_bg_selector);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cR(d.g.s_navbar_bg)));
        if (this.fhu.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fhu.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bdg.onChangeSkinType(this.aaS, i);
        this.bXj.onChangeSkinType(this.aaS, i);
    }

    public void a(a aVar) {
        this.fhw = aVar;
    }

    public void Nl() {
        if (this.refreshView != null) {
            this.refreshView.I(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.beN == null) {
            if (i < 0) {
                this.beN = new com.baidu.tbadk.k.f(this.aaS.getContext());
            } else {
                this.beN = new com.baidu.tbadk.k.f(this.aaS.getContext(), i);
            }
            this.beN.onChangeSkinType();
        }
        this.beN.c(this.mRootView, z);
    }

    public void Ni() {
        if (this.beN != null) {
            this.beN.I(this.mRootView);
            this.beN = null;
        }
    }

    public void km(boolean z) {
        if (z) {
            this.fhu.smoothScrollToPosition(0);
            aXV();
        }
    }

    public void kr(int i) {
        this.fhu.setVisibility(i);
    }

    public void L(String str, boolean z) {
        if (!anF()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.aaS.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.i.gV()) {
                            c.this.Nl();
                            c.this.km(true);
                            if (c.this.fhw != null) {
                                c.this.fhw.T(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.eX(this.aaS.getResources().getDimensionPixelSize(d.f.ds280));
            this.refreshView.gq(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.EL();
            this.refreshView.onChangeSkinType();
            this.fhu.setVisibility(8);
            if (this.fhx != null) {
                this.fhx.setVisibility(8);
            }
        }
    }

    public boolean anF() {
        if (this.refreshView != null) {
            return this.refreshView.EC();
        }
        return false;
    }

    public void wN() {
        if (this.bdh != null) {
            this.bdh.wN();
        }
    }

    public void wO() {
        if (this.bdh != null) {
            this.bdh.wO();
        }
    }

    public void dM(boolean z) {
        if (this.fhu != null && this.bdh != null) {
            this.bdh.wO();
            if (z) {
                this.bdh.setText(this.aaS.getString(d.l.list_no_more));
            } else {
                this.bdh.setText("");
            }
        }
    }

    public void XC() {
        if (this.fhu != null && this.bdh != null) {
            this.fhu.setNextPage(null);
            this.bdh.wR();
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.f> list) {
        if (u.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fhu.getVisibility() != 0) {
            this.fhu.setVisibility(0);
        }
        this.fhu.setData(list);
    }

    public void aXV() {
        if (ab.fS()) {
            if (this.fhx == null) {
                this.fhx = new ImageView(this.aaS.getPageActivity());
                this.fhx.setImageResource(d.g.icon_nichengjun);
                this.fhx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(c.this.aaS.getPageActivity(), null, com.baidu.tieba.pb.d.aOz(), true)));
                    }
                });
            }
            if (this.fhx.getParent() != null) {
                ((ViewGroup) this.fhx.getParent()).removeView(this.fhx);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k.g(this.aaS.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = k.g(this.aaS.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fhx, layoutParams);
            }
        } else if (this.fhx != null && this.fhx.getParent() != null && this.fhx.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fhx);
        }
    }
}
