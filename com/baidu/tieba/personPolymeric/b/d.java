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
    protected TbPageContext abz;
    private NoNetworkView bga;
    public PbListView bgb;
    private com.baidu.tbadk.j.f bhL;
    private PluginErrorTipView ccS;
    protected BdPersonListView ffh;
    private b ffi;
    private ImageView ffj;
    protected PersonExpandImageView ffk;
    protected View ffl;
    private ImageView ffm;
    protected PersonTabView ffo;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.f mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float cHK = 360.0f;
    private a ffn = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aLs = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.ffk);
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
            this.abz = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
            this.ffh = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
            this.bga = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
            this.ccS = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
            this.bgb = new PbListView(this.abz.getPageActivity());
            this.bgb.getView();
            this.bgb.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.bgb.dx(d.e.cp_cont_e);
            this.bgb.dy(d.e.cp_bg_line_d);
            this.bgb.setHeight(l.f(this.abz.getPageActivity(), d.f.ds140));
            this.bgb.dv(l.f(this.abz.getPageActivity(), d.f.ds12));
            this.bgb.wp();
            this.bgb.du(d.e.cp_bg_line_e);
            this.ffh.setNextPage(this.bgb);
            this.ffk = (PersonExpandImageView) this.mRootView.findViewById(d.h.person_polymeric_header_expand_img);
            this.ffk.setInitHeight(this.abz.getResources().getDimensionPixelSize(d.f.ds400));
            this.ffl = view.findViewById(d.h.view_top_background_cover);
            this.ffl.setVisibility(8);
            this.ffh.setOuterExpandView(this.ffk);
            this.ffm = (ImageView) this.mRootView.findViewById(d.h.person_polymeric_header_refresh_image);
            this.ffo = (PersonTabView) this.mRootView.findViewById(d.h.person_center_sticky_person_buttom_header);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.ffn.ffr = gVar;
            view.setOnClickListener(this.ffn);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public UserData eyy;
        private com.baidu.tieba.personPolymeric.event.a ffq = new com.baidu.tieba.personPolymeric.event.a();
        public com.baidu.tieba.view.g ffr;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ad("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
            this.ffq.ceU = 10;
            this.ffq.ceV = new Bundle();
            this.ffq.ceV.putSerializable(UserData.TYPE_USER, this.eyy);
            if (this.ffr != null) {
                this.ffr.a(view, this.ffq);
            }
        }
    }

    public void aoP() {
        if (this.mRootView != null) {
            this.ffh.setVisibility(8);
            if (this.ffo != null) {
                this.ffo.setVisibility(8);
            }
            if (this.ffj != null) {
                this.ffj.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abz.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aS(d.this.abz.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abz.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aT(d.this.abz.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.abz.getResources().getDimensionPixelSize(d.f.ds320);
            int dimensionPixelSize2 = this.abz.getResources().getDimensionPixelSize(d.f.ds480);
            int dimensionPixelSize3 = this.abz.getResources().getDimensionPixelSize(d.f.ds360);
            int dimensionPixelSize4 = this.abz.getResources().getDimensionPixelSize(d.f.ds60);
            int dimensionPixelSize5 = this.abz.getResources().getDimensionPixelSize(d.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.abz.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.abz.getString(d.l.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abz.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ax.aT(d.this.abz.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.abz, i);
        }
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cS(d.g.s_navbar_bg)));
        if (this.ffh.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.ffh.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bga.onChangeSkinType(this.abz, i);
        this.ccS.onChangeSkinType(this.abz, i);
    }

    public void a(b bVar) {
        this.ffi = bVar;
    }

    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bhL == null) {
            if (i < 0) {
                this.bhL = new com.baidu.tbadk.j.f(this.abz.getContext());
            } else {
                this.bhL = new com.baidu.tbadk.j.f(this.abz.getContext(), i);
            }
            this.bhL.onChangeSkinType();
        }
        this.bhL.c(this.mRootView, z);
    }

    public void NZ() {
        if (this.bhL != null) {
            this.bhL.O(this.mRootView);
            this.bhL = null;
        }
    }

    public void kk(boolean z) {
        if (z) {
            aWD();
        }
    }

    public void qn(int i) {
        this.ffh.setVisibility(i);
    }

    public void J(String str, boolean z) {
        if (!aoO()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.abz.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.gV()) {
                            d.this.Oc();
                            d.this.kk(true);
                            if (d.this.ffi != null) {
                                d.this.ffi.br(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fk(this.abz.getResources().getDimensionPixelSize(d.f.ds280));
            this.refreshView.gr(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.Ew();
            this.refreshView.onChangeSkinType();
            this.ffh.setVisibility(8);
            if (this.ffj != null) {
                this.ffj.setVisibility(8);
            }
        }
    }

    public boolean aoO() {
        if (this.refreshView != null) {
            return this.refreshView.En();
        }
        return false;
    }

    public void wt() {
        if (this.bgb != null) {
            this.bgb.wt();
        }
    }

    public void wu() {
        if (this.bgb != null) {
            this.bgb.wu();
        }
    }

    public void dK(boolean z) {
        if (this.ffh != null && this.bgb != null) {
            this.bgb.wu();
            if (z) {
                this.bgb.setText(this.abz.getString(d.l.list_no_more));
            } else {
                this.bgb.setText("");
            }
        }
    }

    public void a(boolean z, List<com.baidu.adp.widget.ListView.f> list) {
        if (this.ffh != null && this.bgb != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    YW();
                    return;
                } else if ((list.get(i) instanceof k) && size <= 1) {
                    YW();
                    return;
                }
            }
            this.bgb.wu();
            if (z) {
                this.bgb.setText(this.abz.getString(d.l.list_no_more));
            } else {
                this.bgb.setText("");
            }
        }
    }

    public void YW() {
        if (this.ffh != null && this.bgb != null) {
            this.ffh.setNextPage(null);
            this.bgb.wx();
        }
    }

    public void qo(int i) {
        if (i == 0) {
            this.bgb.dy(d.e.cp_bg_line_d);
            this.bgb.du(d.e.cp_bg_line_e);
            this.bgb.dx(d.e.cp_cont_e);
            this.bgb.wp();
        } else if (i == 1) {
            this.bgb.dy(d.e.cp_bg_line_c);
            this.bgb.dx(d.e.cp_cont_d);
            this.bgb.wq();
        }
        this.bgb.dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cE(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list)) {
            list = new ArrayList<>();
        }
        if (this.ffh.getVisibility() != 0) {
            this.ffh.setVisibility(0);
        }
        this.ffh.setData(list);
    }

    public void aWD() {
        if (ac.fS()) {
            if (this.ffj == null) {
                this.ffj = new ImageView(this.abz.getPageActivity());
                this.ffj.setImageResource(d.g.icon_nichengjun);
                this.ffj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(d.this.abz.getPageActivity(), null, com.baidu.tieba.pb.c.aMD(), true)));
                    }
                });
            }
            if (this.ffj.getParent() != null) {
                ((ViewGroup) this.ffj.getParent()).removeView(this.ffj);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.f(this.abz.getPageActivity(), d.f.ds504);
            layoutParams.rightMargin = l.f(this.abz.getPageActivity(), d.f.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.ffj, layoutParams);
            }
        } else if (this.ffj != null && this.ffj.getParent() != null && this.ffj.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.ffj);
        }
    }

    public void d(UserData userData) {
        this.ffl.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.DZ().fi(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.abz.getPageActivity().getApplicationContext(), d.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.abz.getPageActivity().getApplicationContext(), d.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.ffk.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fJ().a(bg_pic, 10, this.aLs, 0, 0, null, new Object[0]);
        }
        this.ffn.eyy = userData;
    }

    public void v(float f) {
        if (!this.ffm.isShown()) {
            this.ffm.setVisibility(0);
            this.ffm.setImageDrawable(this.abz.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cHK, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.ffm.startAnimation(rotateAnimation);
        this.cHK = f;
    }

    public void alC() {
        this.ffm.clearAnimation();
        this.ffm.setImageDrawable(null);
        this.ffm.setVisibility(8);
    }

    public void la() {
        if (!this.ffm.isShown()) {
            this.ffm.setVisibility(0);
            this.ffm.setImageDrawable(this.abz.getResources().getDrawable(d.g.icon_pop_refresh));
        }
        this.ffm.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.abz.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
