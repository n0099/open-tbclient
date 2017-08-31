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
    private NoNetworkView bep;
    public PbListView beq;
    private com.baidu.tbadk.k.f bgb;
    private PluginErrorTipView cbZ;
    protected BdPersonListView fiW;
    protected LinearLayout fiX;
    private a fiY;
    private ImageView fiZ;
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
            this.fiW = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.fiX = (LinearLayout) this.mRootView.findViewById(d.h.person_center_blank_view);
            this.bep = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.cbZ = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.beq = new PbListView(this.aby.getPageActivity());
            this.beq.lb();
            this.beq.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.beq.dp(d.e.cp_bg_line_c);
            this.fiW.setNextPage(this.beq);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void aXT() {
        if (this.mRootView != null) {
            this.fiW.setVisibility(8);
            if (this.fiX != null) {
                this.fiX.setVisibility(8);
            }
            if (this.fiZ != null) {
                this.fiZ.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aby.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(c.this.aby.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(c.this.aby.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(c.this.aby.getPageActivity());
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
                    ax.aS(c.this.aby.getPageActivity());
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
        aj.j(this.fiX, d.g.item_person_header_attention_bg_selector);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cU(d.g.s_navbar_bg)));
        if (this.fiW.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fiW.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bep.onChangeSkinType(this.aby, i);
        this.cbZ.onChangeSkinType(this.aby, i);
    }

    public void a(a aVar) {
        this.fiY = aVar;
    }

    public void NG() {
        if (this.refreshView != null) {
            this.refreshView.N(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bgb == null) {
            if (i < 0) {
                this.bgb = new com.baidu.tbadk.k.f(this.aby.getContext());
            } else {
                this.bgb = new com.baidu.tbadk.k.f(this.aby.getContext(), i);
            }
            this.bgb.onChangeSkinType();
        }
        this.bgb.c(this.mRootView, z);
    }

    public void ND() {
        if (this.bgb != null) {
            this.bgb.N(this.mRootView);
            this.bgb = null;
        }
    }

    public void kq(boolean z) {
        if (z) {
            this.fiW.smoothScrollToPosition(0);
            aXU();
        }
    }

    public void kP(int i) {
        this.fiW.setVisibility(i);
    }

    public void M(String str, boolean z) {
        if (!aqa()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.aby.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.i.gW()) {
                            c.this.NG();
                            c.this.kq(true);
                            if (c.this.fiY != null) {
                                c.this.fiY.aa(view);
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
            this.fiW.setVisibility(8);
            if (this.fiZ != null) {
                this.fiZ.setVisibility(8);
            }
        }
    }

    public boolean aqa() {
        if (this.refreshView != null) {
            return this.refreshView.EI();
        }
        return false;
    }

    public void wV() {
        if (this.beq != null) {
            this.beq.wV();
        }
    }

    public void wW() {
        if (this.beq != null) {
            this.beq.wW();
        }
    }

    public void dQ(boolean z) {
        if (this.fiW != null && this.beq != null) {
            this.beq.wW();
            if (z) {
                this.beq.setText(this.aby.getString(d.l.list_no_more));
            } else {
                this.beq.setText("");
            }
        }
    }

    public void Zc() {
        if (this.fiW != null && this.beq != null) {
            this.fiW.setNextPage(null);
            this.beq.wY();
        }
    }

    public void cH(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fiW.getVisibility() != 0) {
            this.fiW.setVisibility(0);
        }
        this.fiW.setData(list);
    }

    public void aXU() {
        if (ac.fT()) {
            if (this.fiZ == null) {
                this.fiZ = new ImageView(this.aby.getPageActivity());
                this.fiZ.setImageResource(d.g.icon_nichengjun);
                this.fiZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.c.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(c.this.aby.getPageActivity(), null, com.baidu.tieba.pb.d.aOy(), true)));
                    }
                });
            }
            if (this.fiZ.getParent() != null) {
                ((ViewGroup) this.fiZ.getParent()).removeView(this.fiZ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = k.g(this.aby.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = k.g(this.aby.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fiZ, layoutParams);
            }
        } else if (this.fiZ != null && this.fiZ.getParent() != null && this.fiZ.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fiZ);
        }
    }
}
