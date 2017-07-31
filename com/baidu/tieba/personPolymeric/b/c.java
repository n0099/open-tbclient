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
    protected TbPageContext acp;
    private PluginErrorTipView bYp;
    private NoNetworkView beq;
    public PbListView ber;
    private com.baidu.tbadk.k.f bfY;
    protected BdPersonListView fiI;
    protected LinearLayout fiJ;
    private a fiK;
    private ImageView fiL;
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
            this.acp = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
            this.fiI = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.fiJ = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
            this.beq = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.bYp = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.ber = new PbListView(this.acp.getPageActivity());
            this.ber.lk();
            this.ber.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.ber.m10do(d.e.cp_bg_line_c);
            this.fiI.setNextPage(this.ber);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aYf() {
        if (this.mRootView != null) {
            this.fiI.setVisibility(8);
            if (this.fiJ != null) {
                this.fiJ.setVisibility(8);
            }
            if (this.fiL != null) {
                this.fiL.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.acp.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    aw.aM(c.this.acp.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.acp.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aN(c.this.acp.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.acp.getResources().getDimensionPixelSize(d.f.ds320);
            int dimensionPixelSize2 = this.acp.getResources().getDimensionPixelSize(d.f.ds480);
            int dimensionPixelSize3 = this.acp.getResources().getDimensionPixelSize(d.f.ds360);
            int dimensionPixelSize4 = this.acp.getResources().getDimensionPixelSize(d.f.ds60);
            int dimensionPixelSize5 = this.acp.getResources().getDimensionPixelSize(d.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.acp.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.acp.getString(d.l.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.acp.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    aw.aN(c.this.acp.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.acp, i);
        }
        ai.j(this.fiJ, d.g.item_person_header_attention_bg_selector);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
        if (this.fiI.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fiI.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.beq.onChangeSkinType(this.acp, i);
        this.bYp.onChangeSkinType(this.acp, i);
    }

    public void a(a aVar) {
        this.fiK = aVar;
    }

    public void Nq() {
        if (this.refreshView != null) {
            this.refreshView.I(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bfY == null) {
            if (i < 0) {
                this.bfY = new com.baidu.tbadk.k.f(this.acp.getContext());
            } else {
                this.bfY = new com.baidu.tbadk.k.f(this.acp.getContext(), i);
            }
            this.bfY.onChangeSkinType();
        }
        this.bfY.c(this.mRootView, z);
    }

    public void Nn() {
        if (this.bfY != null) {
            this.bfY.I(this.mRootView);
            this.bfY = null;
        }
    }

    public void km(boolean z) {
        if (z) {
            this.fiI.smoothScrollToPosition(0);
            aYg();
        }
    }

    public void kr(int i) {
        this.fiI.setVisibility(i);
    }

    public void K(String str, boolean z) {
        if (!anR()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.acp.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.i.hf()) {
                            c.this.Nq();
                            c.this.km(true);
                            if (c.this.fiK != null) {
                                c.this.fiK.T(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.eZ(this.acp.getResources().getDimensionPixelSize(d.f.ds280));
            this.refreshView.gv(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.ET();
            this.refreshView.onChangeSkinType();
            this.fiI.setVisibility(8);
            if (this.fiL != null) {
                this.fiL.setVisibility(8);
            }
        }
    }

    public boolean anR() {
        if (this.refreshView != null) {
            return this.refreshView.EK();
        }
        return false;
    }

    public void wW() {
        if (this.ber != null) {
            this.ber.wW();
        }
    }

    public void wX() {
        if (this.ber != null) {
            this.ber.wX();
        }
    }

    public void dM(boolean z) {
        if (this.fiI != null && this.ber != null) {
            this.ber.wX();
            if (z) {
                this.ber.setText(this.acp.getString(d.l.list_no_more));
            } else {
                this.ber.setText("");
            }
        }
    }

    public void XH() {
        if (this.fiI != null && this.ber != null) {
            this.fiI.setNextPage(null);
            this.ber.xa();
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.f> list) {
        if (u.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fiI.getVisibility() != 0) {
            this.fiI.setVisibility(0);
        }
        this.fiI.setData(list);
    }

    public void aYg() {
        if (ab.ge()) {
            if (this.fiL == null) {
                this.fiL = new ImageView(this.acp.getPageActivity());
                this.fiL.setImageResource(d.g.icon_nichengjun);
                this.fiL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(c.this.acp.getPageActivity(), null, com.baidu.tieba.pb.c.aOK(), true)));
                    }
                });
            }
            if (this.fiL.getParent() != null) {
                ((ViewGroup) this.fiL.getParent()).removeView(this.fiL);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k.g(this.acp.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = k.g(this.acp.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fiL, layoutParams);
            }
        } else if (this.fiL != null && this.fiL.getParent() != null && this.fiL.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fiL);
        }
    }
}
