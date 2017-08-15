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
    protected TbPageContext acr;
    private PluginErrorTipView bZb;
    private NoNetworkView ber;
    public PbListView bes;
    private com.baidu.tbadk.k.f bfY;
    protected BdPersonListView fkB;
    protected LinearLayout fkC;
    private a fkD;
    private ImageView fkE;
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
            this.acr = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
            this.fkB = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.fkC = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
            this.ber = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.bZb = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.bes = new PbListView(this.acr.getPageActivity());
            this.bes.lk();
            this.bes.setTextColor(ai.getColor(d.e.cp_cont_d));
            this.bes.m10do(d.e.cp_bg_line_c);
            this.fkB.setNextPage(this.bes);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aYM() {
        if (this.mRootView != null) {
            this.fkB.setVisibility(8);
            if (this.fkC != null) {
                this.fkC.setVisibility(8);
            }
            if (this.fkE != null) {
                this.fkE.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.acr.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    aw.aM(c.this.acr.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.acr.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    aw.aN(c.this.acr.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.acr.getResources().getDimensionPixelSize(d.f.ds320);
            int dimensionPixelSize2 = this.acr.getResources().getDimensionPixelSize(d.f.ds480);
            int dimensionPixelSize3 = this.acr.getResources().getDimensionPixelSize(d.f.ds360);
            int dimensionPixelSize4 = this.acr.getResources().getDimensionPixelSize(d.f.ds60);
            int dimensionPixelSize5 = this.acr.getResources().getDimensionPixelSize(d.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.acr.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.acr.getString(d.l.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.acr.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    aw.aN(c.this.acr.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.acr, i);
        }
        ai.j(this.fkC, d.g.item_person_header_attention_bg_selector);
        ai.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ai.cT(d.g.s_navbar_bg)));
        if (this.fkB.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fkB.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.ber.onChangeSkinType(this.acr, i);
        this.bZb.onChangeSkinType(this.acr, i);
    }

    public void a(a aVar) {
        this.fkD = aVar;
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
                this.bfY = new com.baidu.tbadk.k.f(this.acr.getContext());
            } else {
                this.bfY = new com.baidu.tbadk.k.f(this.acr.getContext(), i);
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

    public void kp(boolean z) {
        if (z) {
            this.fkB.smoothScrollToPosition(0);
            aYN();
        }
    }

    public void kB(int i) {
        this.fkB.setVisibility(i);
    }

    public void L(String str, boolean z) {
        if (!aoy()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.acr.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.i.hf()) {
                            c.this.Nq();
                            c.this.kp(true);
                            if (c.this.fkD != null) {
                                c.this.fkD.T(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.eZ(this.acr.getResources().getDimensionPixelSize(d.f.ds280));
            this.refreshView.gv(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.ET();
            this.refreshView.onChangeSkinType();
            this.fkB.setVisibility(8);
            if (this.fkE != null) {
                this.fkE.setVisibility(8);
            }
        }
    }

    public boolean aoy() {
        if (this.refreshView != null) {
            return this.refreshView.EK();
        }
        return false;
    }

    public void wW() {
        if (this.bes != null) {
            this.bes.wW();
        }
    }

    public void wX() {
        if (this.bes != null) {
            this.bes.wX();
        }
    }

    public void dN(boolean z) {
        if (this.fkB != null && this.bes != null) {
            this.bes.wX();
            if (z) {
                this.bes.setText(this.acr.getString(d.l.list_no_more));
            } else {
                this.bes.setText("");
            }
        }
    }

    public void Yc() {
        if (this.fkB != null && this.bes != null) {
            this.fkB.setNextPage(null);
            this.bes.xa();
        }
    }

    public void cK(List<com.baidu.adp.widget.ListView.f> list) {
        if (u.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fkB.getVisibility() != 0) {
            this.fkB.setVisibility(0);
        }
        this.fkB.setData(list);
    }

    public void aYN() {
        if (ab.ge()) {
            if (this.fkE == null) {
                this.fkE = new ImageView(this.acr.getPageActivity());
                this.fkE.setImageResource(d.g.icon_nichengjun);
                this.fkE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(c.this.acr.getPageActivity(), null, com.baidu.tieba.pb.d.aPr(), true)));
                    }
                });
            }
            if (this.fkE.getParent() != null) {
                ((ViewGroup) this.fkE.getParent()).removeView(this.fkE);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k.g(this.acr.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = k.g(this.acr.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fkE, layoutParams);
            }
        } else if (this.fkE != null && this.fkE.getParent() != null && this.fkE.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fkE);
        }
    }
}
