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
import com.baidu.tbadk.p.ac;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import com.baidu.tieba.personPolymeric.view.PersonTabView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    protected TbPageContext abI;
    private com.baidu.tbadk.k.f bed;
    private NoNetworkView bgD;
    public PbListView bgE;
    private PluginErrorTipView ckc;
    protected BdPersonListView fni;
    private b fnj;
    private ImageView fnk;
    protected PersonExpandImageView fnl;
    protected View fnm;
    private ImageView fnn;
    protected PersonTabView fnp;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.f mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float cQJ = 360.0f;
    private a fno = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fnl);
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
        void bu(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.abI = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fni = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.bgD = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.ckc = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.bgE = new PbListView(this.abI.getPageActivity());
            this.bgE.getView();
            this.bgE.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
            this.bgE.dx(d.C0080d.cp_cont_e);
            this.bgE.dy(d.C0080d.cp_bg_line_d);
            this.bgE.setHeight(l.f(this.abI.getPageActivity(), d.e.ds140));
            this.bgE.dv(l.f(this.abI.getPageActivity(), d.e.ds12));
            this.bgE.wp();
            this.bgE.du(d.C0080d.cp_bg_line_e);
            this.fni.setNextPage(this.bgE);
            this.fnl = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fnl.setInitHeight(this.abI.getResources().getDimensionPixelSize(d.e.ds400));
            this.fnm = view.findViewById(d.g.view_top_background_cover);
            this.fnm.setVisibility(8);
            this.fni.setOuterExpandView(this.fnl);
            this.fnn = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            this.fnp = (PersonTabView) this.mRootView.findViewById(d.g.person_center_sticky_person_buttom_header);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.h hVar) {
        if (view != null && hVar != null) {
            this.fno.fns = hVar;
            view.setOnClickListener(this.fno);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public UserData eGm;
        private com.baidu.tieba.personPolymeric.event.a fnr = new com.baidu.tieba.personPolymeric.event.a();
        public com.baidu.tieba.view.h fns;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
            this.fnr.cmb = 10;
            this.fnr.cmc = new Bundle();
            this.fnr.cmc.putSerializable(UserData.TYPE_USER, this.eGm);
            if (this.fns != null) {
                this.fns.a(view, this.fnr);
            }
        }
    }

    public void arj() {
        if (this.mRootView != null) {
            this.fni.setVisibility(8);
            if (this.fnp != null) {
                this.fnp.setVisibility(8);
            }
            if (this.fnk != null) {
                this.fnk.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abI.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ax.aR(d.this.abI.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abI.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ax.aS(d.this.abI.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.abI.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.abI.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.abI.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.abI.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.abI.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.abI.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.abI.getString(d.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.abI.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ax.aS(d.this.abI.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.abI, i);
        }
        aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cS(d.f.s_navbar_bg)));
        if (this.fni.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fni.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bgD.onChangeSkinType(this.abI, i);
        this.ckc.onChangeSkinType(this.abI, i);
    }

    public void a(b bVar) {
        this.fnj = bVar;
    }

    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bed == null) {
            if (i < 0) {
                this.bed = new com.baidu.tbadk.k.f(this.abI.getContext());
            } else {
                this.bed = new com.baidu.tbadk.k.f(this.abI.getContext(), i);
            }
            this.bed.onChangeSkinType();
        }
        this.bed.c(this.mRootView, z);
    }

    public void MZ() {
        if (this.bed != null) {
            this.bed.O(this.mRootView);
            this.bed = null;
        }
    }

    public void kd(boolean z) {
        if (z) {
            aZA();
        }
    }

    public void qC(int i) {
        this.fni.setVisibility(i);
    }

    public void H(String str, boolean z) {
        if (!ari()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.abI.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.gV()) {
                            d.this.Oc();
                            d.this.kd(true);
                            if (d.this.fnj != null) {
                                d.this.fnj.bu(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fk(this.abI.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.gy(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.EC();
            this.refreshView.onChangeSkinType();
            this.fni.setVisibility(8);
            if (this.fnk != null) {
                this.fnk.setVisibility(8);
            }
        }
    }

    public boolean ari() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    public void wt() {
        if (this.bgE != null) {
            this.bgE.wt();
        }
    }

    public void wu() {
        if (this.bgE != null) {
            this.bgE.wu();
        }
    }

    public void dI(boolean z) {
        if (this.fni != null && this.bgE != null) {
            this.bgE.wu();
            if (z) {
                this.bgE.setText(this.abI.getString(d.j.list_no_more));
            } else {
                this.bgE.setText("");
            }
        }
    }

    public void a(boolean z, List<com.baidu.adp.widget.ListView.f> list) {
        if (this.fni != null && this.bgE != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    abc();
                    return;
                } else if ((list.get(i) instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                    abc();
                    return;
                }
            }
            this.bgE.wu();
            if (z) {
                this.bgE.setText(this.abI.getString(d.j.list_no_more));
            } else {
                this.bgE.setText("");
            }
        }
    }

    public void abc() {
        if (this.fni != null && this.bgE != null) {
            this.fni.setNextPage(null);
            this.bgE.wx();
        }
    }

    public void qD(int i) {
        if (i == 0) {
            this.bgE.dy(d.C0080d.cp_bg_line_d);
            this.bgE.du(d.C0080d.cp_bg_line_e);
            this.bgE.dx(d.C0080d.cp_cont_e);
            this.bgE.wp();
        } else if (i == 1) {
            this.bgE.dy(d.C0080d.cp_bg_line_c);
            this.bgE.dx(d.C0080d.cp_cont_d);
            this.bgE.wq();
        }
        this.bgE.dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cF(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fni.getVisibility() != 0) {
            this.fni.setVisibility(0);
        }
        this.fni.setData(list);
    }

    public void aZA() {
        if (ac.fS()) {
            if (this.fnk == null) {
                this.fnk = new ImageView(this.abI.getPageActivity());
                this.fnk.setImageResource(d.f.icon_nichengjun);
                this.fnk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(d.this.abI.getPageActivity(), null, com.baidu.tieba.pb.c.aPq(), true)));
                    }
                });
            }
            if (this.fnk.getParent() != null) {
                ((ViewGroup) this.fnk.getParent()).removeView(this.fnk);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.f(this.abI.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.f(this.abI.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fnk, layoutParams);
            }
        } else if (this.fnk != null && this.fnk.getParent() != null && this.fnk.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fnk);
        }
    }

    public void e(UserData userData) {
        this.fnm.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Eg().fi(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.abI.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.abI.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fnl.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fJ().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fno.eGm = userData;
    }

    public void u(float f) {
        if (!this.fnn.isShown()) {
            this.fnn.setVisibility(0);
            this.fnn.setImageDrawable(this.abI.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cQJ, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fnn.startAnimation(rotateAnimation);
        this.cQJ = f;
    }

    public void aoi() {
        this.fnn.clearAnimation();
        this.fnn.setImageDrawable(null);
        this.fnn.setVisibility(8);
    }

    public void kU() {
        if (!this.fnn.isShown()) {
            this.fnn.setVisibility(0);
            this.fnn.setImageDrawable(this.abI.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fnn.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
