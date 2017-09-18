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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.p.ac;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    protected TbPageContext aby;
    private NoNetworkView bem;
    public PbListView ben;
    private com.baidu.tbadk.k.f bfY;
    private PluginErrorTipView ccR;
    protected BdPersonListView fjP;
    protected LinearLayout fjQ;
    private a fjR;
    private ImageView fjS;
    protected NavigationBar mNavigationBar;
    protected j mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void aa(View view);
    }

    public c(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.aby = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
            this.fjP = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.fjQ = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
            this.bem = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.ccR = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.ben = new PbListView(this.aby.getPageActivity());
            this.ben.lb();
            this.ben.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.ben.dp(d.e.cp_bg_line_c);
            this.fjP.setNextPage(this.ben);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aYe() {
        if (this.mRootView != null) {
            this.fjP.setVisibility(8);
            if (this.fjQ != null) {
                this.fjQ.setVisibility(8);
            }
            if (this.fjS != null) {
                this.fjS.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aby.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aS(c.this.aby.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aby.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aT(c.this.aby.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aby.getResources().getDimensionPixelSize(d.f.ds320);
            int dimensionPixelSize2 = this.aby.getResources().getDimensionPixelSize(d.f.ds480);
            int dimensionPixelSize3 = this.aby.getResources().getDimensionPixelSize(d.f.ds360);
            int dimensionPixelSize4 = this.aby.getResources().getDimensionPixelSize(d.f.ds60);
            int dimensionPixelSize5 = this.aby.getResources().getDimensionPixelSize(d.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aby.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.A(d.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aby.getString(d.l.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aby.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ax.aT(c.this.aby.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aby, i);
        }
        aj.j(this.fjQ, d.g.item_person_header_attention_bg_selector);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cU(d.g.s_navbar_bg)));
        if (this.fjP.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fjP.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bem.onChangeSkinType(this.aby, i);
        this.ccR.onChangeSkinType(this.aby, i);
    }

    public void a(a aVar) {
        this.fjR = aVar;
    }

    public void NH() {
        if (this.refreshView != null) {
            this.refreshView.N(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bfY == null) {
            if (i < 0) {
                this.bfY = new com.baidu.tbadk.k.f(this.aby.getContext());
            } else {
                this.bfY = new com.baidu.tbadk.k.f(this.aby.getContext(), i);
            }
            this.bfY.onChangeSkinType();
        }
        this.bfY.c(this.mRootView, z);
    }

    public void NE() {
        if (this.bfY != null) {
            this.bfY.N(this.mRootView);
            this.bfY = null;
        }
    }

    public void kr(boolean z) {
        if (z) {
            this.fjP.smoothScrollToPosition(0);
            aYf();
        }
    }

    public void kR(int i) {
        this.fjP.setVisibility(i);
    }

    public void M(String str, boolean z) {
        if (!aql()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.aby.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.i.gW()) {
                            c.this.NH();
                            c.this.kr(true);
                            if (c.this.fjR != null) {
                                c.this.fjR.aa(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.eZ(this.aby.getResources().getDimensionPixelSize(d.f.ds280));
            this.refreshView.gv(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.ER();
            this.refreshView.onChangeSkinType();
            this.fjP.setVisibility(8);
            if (this.fjS != null) {
                this.fjS.setVisibility(8);
            }
        }
    }

    public boolean aql() {
        if (this.refreshView != null) {
            return this.refreshView.EI();
        }
        return false;
    }

    public void wV() {
        if (this.ben != null) {
            this.ben.wV();
        }
    }

    public void wW() {
        if (this.ben != null) {
            this.ben.wW();
        }
    }

    public void dR(boolean z) {
        if (this.fjP != null && this.ben != null) {
            this.ben.wW();
            if (z) {
                this.ben.setText(this.aby.getString(d.l.list_no_more));
            } else {
                this.ben.setText("");
            }
        }
    }

    public void Zn() {
        if (this.fjP != null && this.ben != null) {
            this.fjP.setNextPage(null);
            this.ben.wY();
        }
    }

    public void cI(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fjP.getVisibility() != 0) {
            this.fjP.setVisibility(0);
        }
        this.fjP.setData(list);
    }

    public void aYf() {
        if (ac.fT()) {
            if (this.fjS == null) {
                this.fjS = new ImageView(this.aby.getPageActivity());
                this.fjS.setImageResource(d.g.icon_nichengjun);
                this.fjS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(c.this.aby.getPageActivity(), null, com.baidu.tieba.pb.d.aOJ(), true)));
                    }
                });
            }
            if (this.fjS.getParent() != null) {
                ((ViewGroup) this.fjS.getParent()).removeView(this.fjS);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k.f(this.aby.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = k.f(this.aby.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fjS, layoutParams);
            }
        } else if (this.fjS != null && this.fjS.getParent() != null && this.fjS.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fjS);
        }
    }
}
