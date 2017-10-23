package com.baidu.tieba.personPolymeric.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.o.ac;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.c.k;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import com.baidu.tieba.personPolymeric.view.PersonTabView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    protected TbPageContext abm;
    private NoNetworkView bfM;
    public PbListView bfN;
    private com.baidu.tbadk.j.f bhx;
    private PluginErrorTipView ccG;
    protected BdPersonListView feS;
    private b feT;
    private ImageView feU;
    protected PersonExpandImageView feV;
    protected View feW;
    private ImageView feX;
    protected PersonTabView feZ;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.f mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float cHy = 360.0f;
    private a feY = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLf = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.feV);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
        }
    };

    /* loaded from: classes.dex */
    public interface b {
        void br(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.abm = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
            this.feS = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.bfM = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.ccG = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.bfN = new PbListView(this.abm.getPageActivity());
            this.bfN.getView();
            this.bfN.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.bfN.dw(d.e.cp_cont_e);
            this.bfN.dx(d.e.cp_bg_line_d);
            this.bfN.setHeight(l.f(this.abm.getPageActivity(), d.f.ds140));
            this.bfN.du(l.f(this.abm.getPageActivity(), d.f.ds12));
            this.bfN.wi();
            this.bfN.dt(d.e.cp_bg_line_e);
            this.feS.setNextPage(this.bfN);
            this.feV = (PersonExpandImageView) this.mRootView.findViewById(d.h.person_polymeric_header_expand_img);
            this.feV.setInitHeight(this.abm.getResources().getDimensionPixelSize(d.f.ds400));
            this.feW = view.findViewById(d.h.view_top_background_cover);
            this.feW.setVisibility(8);
            this.feS.setOuterExpandView(this.feV);
            this.feX = (ImageView) this.mRootView.findViewById(d.h.person_polymeric_header_refresh_image);
            this.feZ = (PersonTabView) this.mRootView.findViewById(d.h.person_center_sticky_person_buttom_header);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.feY.ffc = gVar;
            view.setOnClickListener(this.feY);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public UserData eyj;
        private com.baidu.tieba.personPolymeric.event.a ffb = new com.baidu.tieba.personPolymeric.event.a();
        public com.baidu.tieba.view.g ffc;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
            this.ffb.ceI = 10;
            this.ffb.ceJ = new Bundle();
            this.ffb.ceJ.putSerializable(UserData.TYPE_USER, this.eyj);
            if (this.ffc != null) {
                this.ffc.a(view, this.ffb);
            }
        }
    }

    public void aoK() {
        if (this.mRootView != null) {
            this.feS.setVisibility(8);
            if (this.feZ != null) {
                this.feZ.setVisibility(8);
            }
            if (this.feU != null) {
                this.feU.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abm.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(d.this.abm.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abm.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(d.this.abm.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.abm.getResources().getDimensionPixelSize(d.f.ds320);
            int dimensionPixelSize2 = this.abm.getResources().getDimensionPixelSize(d.f.ds480);
            int dimensionPixelSize3 = this.abm.getResources().getDimensionPixelSize(d.f.ds360);
            int dimensionPixelSize4 = this.abm.getResources().getDimensionPixelSize(d.f.ds60);
            int dimensionPixelSize5 = this.abm.getResources().getDimensionPixelSize(d.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.abm.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.abm.getString(d.l.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abm.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ax.aS(d.this.abm.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.abm, i);
        }
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cR(d.g.s_navbar_bg)));
        if (this.feS.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.feS.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bfM.onChangeSkinType(this.abm, i);
        this.ccG.onChangeSkinType(this.abm, i);
    }

    public void a(b bVar) {
        this.feT = bVar;
    }

    public void NW() {
        if (this.refreshView != null) {
            this.refreshView.O(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bhx == null) {
            if (i < 0) {
                this.bhx = new com.baidu.tbadk.j.f(this.abm.getContext());
            } else {
                this.bhx = new com.baidu.tbadk.j.f(this.abm.getContext(), i);
            }
            this.bhx.onChangeSkinType();
        }
        this.bhx.c(this.mRootView, z);
    }

    public void NT() {
        if (this.bhx != null) {
            this.bhx.O(this.mRootView);
            this.bhx = null;
        }
    }

    public void kj(boolean z) {
        if (z) {
            aWx();
        }
    }

    public void qm(int i) {
        this.feS.setVisibility(i);
    }

    public void J(String str, boolean z) {
        if (!aoJ()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.abm.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.gV()) {
                            d.this.NW();
                            d.this.kj(true);
                            if (d.this.feT != null) {
                                d.this.feT.br(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fj(this.abm.getResources().getDimensionPixelSize(d.f.ds280));
            this.refreshView.gq(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.Eq();
            this.refreshView.onChangeSkinType();
            this.feS.setVisibility(8);
            if (this.feU != null) {
                this.feU.setVisibility(8);
            }
        }
    }

    public boolean aoJ() {
        if (this.refreshView != null) {
            return this.refreshView.Eh();
        }
        return false;
    }

    public void wm() {
        if (this.bfN != null) {
            this.bfN.wm();
        }
    }

    public void wn() {
        if (this.bfN != null) {
            this.bfN.wn();
        }
    }

    public void dJ(boolean z) {
        if (this.feS != null && this.bfN != null) {
            this.bfN.wn();
            if (z) {
                this.bfN.setText(this.abm.getString(d.l.list_no_more));
            } else {
                this.bfN.setText("");
            }
        }
    }

    public void a(boolean z, List<com.baidu.adp.widget.ListView.f> list) {
        if (this.feS != null && this.bfN != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    YS();
                    return;
                } else if ((list.get(i) instanceof k) && size <= 1) {
                    YS();
                    return;
                }
            }
            this.bfN.wn();
            if (z) {
                this.bfN.setText(this.abm.getString(d.l.list_no_more));
            } else {
                this.bfN.setText("");
            }
        }
    }

    public void YS() {
        if (this.feS != null && this.bfN != null) {
            this.feS.setNextPage(null);
            this.bfN.wq();
        }
    }

    public void qn(int i) {
        if (i == 0) {
            this.bfN.dx(d.e.cp_bg_line_d);
            this.bfN.dt(d.e.cp_bg_line_e);
            this.bfN.dw(d.e.cp_cont_e);
            this.bfN.wi();
        } else if (i == 1) {
            this.bfN.dx(d.e.cp_bg_line_c);
            this.bfN.dw(d.e.cp_cont_d);
            this.bfN.wj();
        }
        this.bfN.dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cE(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list)) {
            list = new ArrayList<>();
        }
        if (this.feS.getVisibility() != 0) {
            this.feS.setVisibility(0);
        }
        this.feS.setData(list);
    }

    public void aWx() {
        if (ac.fS()) {
            if (this.feU == null) {
                this.feU = new ImageView(this.abm.getPageActivity());
                this.feU.setImageResource(d.g.icon_nichengjun);
                this.feU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(d.this.abm.getPageActivity(), null, com.baidu.tieba.pb.c.aMy(), true)));
                    }
                });
            }
            if (this.feU.getParent() != null) {
                ((ViewGroup) this.feU.getParent()).removeView(this.feU);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.f(this.abm.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = l.f(this.abm.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.feU, layoutParams);
            }
        } else if (this.feU != null && this.feU.getParent() != null && this.feU.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.feU);
        }
    }

    public void d(UserData userData) {
        this.feW.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.DT().fh(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.abm.getPageActivity().getApplicationContext(), d.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.abm.getPageActivity().getApplicationContext(), d.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.feV.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fJ().a(bg_pic, 10, this.aLf, 0, 0, null, new Object[0]);
        }
        this.feY.eyj = userData;
    }

    public void v(float f) {
        if (!this.feX.isShown()) {
            this.feX.setVisibility(0);
            this.feX.setImageDrawable(this.abm.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cHy, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.feX.startAnimation(rotateAnimation);
        this.cHy = f;
    }

    public void alx() {
        this.feX.clearAnimation();
        this.feX.setImageDrawable(null);
        this.feX.setVisibility(8);
    }

    public void la() {
        if (!this.feX.isShown()) {
            this.feX.setVisibility(0);
            this.feX.setImageDrawable(this.abm.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.feX.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
