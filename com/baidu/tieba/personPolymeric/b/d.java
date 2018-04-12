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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.o.af;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    protected TbPageContext adf;
    private com.baidu.tbadk.j.f bha;
    private NoNetworkView bla;
    public PbListView blb;
    private PluginErrorTipView cHC;
    protected View fIA;
    private ImageView fIB;
    protected NavigationBar fID;
    protected RelativeLayout fIE;
    protected BdPersonListView fIw;
    private b fIx;
    private ImageView fIy;
    protected PersonExpandImageView fIz;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dpP = 360.0f;
    private a fIC = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fIz);
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

    /* loaded from: classes3.dex */
    public interface b {
        void bm(View view2);
    }

    public d(TbPageContext tbPageContext, View view2) {
        if (tbPageContext != null && view2 != null) {
            this.adf = tbPageContext;
            this.mRootView = view2;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fIw = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.cHC = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fID = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.fIE = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.blb = new PbListView(this.adf.getPageActivity());
            this.blb.getView();
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blb.du(d.C0126d.cp_cont_e);
            this.blb.dv(d.C0126d.cp_bg_line_d);
            this.blb.setHeight(l.e(this.adf.getPageActivity(), d.e.ds140));
            this.blb.dt(l.e(this.adf.getPageActivity(), d.e.ds12));
            this.blb.wN();
            this.blb.ds(d.C0126d.cp_bg_line_e);
            this.fIw.setNextPage(this.blb);
            this.fIz = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fIz.setInitHeight(this.adf.getResources().getDimensionPixelSize(d.e.tbds496));
            this.fIA = view2.findViewById(d.g.view_top_background_cover);
            this.fIA.setVisibility(8);
            this.fIw.setOuterExpandView(this.fIz);
            this.fIB = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view2, com.baidu.tieba.view.g gVar) {
        if (view2 != null && gVar != null) {
            this.fIC.fIH = gVar;
            view2.setOnClickListener(this.fIC);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b fIG = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g fIH;
        public UserData fbV;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TiebaStatic.log(new al("c12502").ac("obj_locate", "3"));
            this.fIG.cKf = 10;
            this.fIG.cKg = new Bundle();
            this.fIG.cKg.putSerializable(UserData.TYPE_USER, this.fbV);
            if (this.fIH != null) {
                this.fIH.a(view2, this.fIG);
            }
        }
    }

    public void ld(boolean z) {
        this.fIE.setVisibility(8);
        this.fID.setVisibility(0);
        this.fID.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.fID.setCenterTextTitle(this.adf.getString(d.k.ta_homepage));
        } else {
            this.fID.setCenterTextTitle(this.adf.getString(d.k.my_homepage));
        }
        this.fID.showBottomLine();
        int dimensionPixelSize = this.adf.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.adf.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.af(null, this.adf.getString(d.k.user_to_anti)), null);
        }
        ak.h(this.mNoDataView.getSuTextView(), d.C0126d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.adf, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void axf() {
        if (this.mRootView != null) {
            this.fIw.setVisibility(8);
            if (this.fIy != null) {
                this.fIy.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(d.this.adf.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    az.aI(d.this.adf.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(d.this.adf.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    az.aJ(d.this.adf.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.adf.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.adf.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.adf.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.adf.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.adf.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.adf.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.k.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.adf.getString(d.k.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(d.this.adf.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    az.aJ(d.this.adf.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.adf, i);
            }
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.fID.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)));
            if (this.fIw.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.fIw.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bla.onChangeSkinType(this.adf, i);
            this.cHC.onChangeSkinType(this.adf, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.fIx = bVar;
    }

    public void Qn() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bha == null) {
            if (i < 0) {
                this.bha = new com.baidu.tbadk.j.f(this.adf.getContext());
            } else {
                this.bha = new com.baidu.tbadk.j.f(this.adf.getContext(), i);
            }
            this.bha.onChangeSkinType();
        }
        this.bha.d(this.mRootView, z);
    }

    public void Ou() {
        if (this.bha != null) {
            this.bha.P(this.mRootView);
            this.bha = null;
        }
    }

    public void le(boolean z) {
        if (z) {
            bfb();
        }
    }

    public void ri(int i) {
        this.fIw.setVisibility(i);
    }

    public void E(String str, boolean z) {
        if (!axe()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.adf.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (com.baidu.adp.lib.util.j.gD()) {
                            d.this.Qn();
                            d.this.le(true);
                            if (d.this.fIx != null) {
                                d.this.fIx.bm(view2);
                            }
                        }
                    }
                });
            }
            this.refreshView.fb(this.adf.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.setSubText(str);
            this.refreshView.d(this.mRootView, z);
            this.refreshView.Fu();
            this.refreshView.onChangeSkinType();
            this.fIw.setVisibility(8);
            if (this.fIy != null) {
                this.fIy.setVisibility(8);
            }
        }
    }

    public boolean axe() {
        if (this.refreshView != null) {
            return this.refreshView.Fm();
        }
        return false;
    }

    public void wR() {
        if (this.blb != null) {
            this.blb.wR();
        }
    }

    public void wS() {
        if (this.blb != null) {
            this.blb.wS();
        }
    }

    public void eC(boolean z) {
        if (this.fIw != null && this.blb != null) {
            this.blb.wS();
            if (z) {
                this.blb.setText(this.adf.getString(d.k.list_no_more));
            } else {
                this.blb.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.fIw != null && this.blb != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    Qq();
                    return;
                }
            }
            this.blb.wS();
            if (z) {
                this.blb.setText(this.adf.getString(d.k.list_no_more));
            } else {
                this.blb.setText("");
            }
        }
    }

    public void Qq() {
        if (this.fIw != null && this.blb != null) {
            this.fIw.setNextPage(null);
            this.blb.wV();
        }
    }

    public void rj(int i) {
        if (i == 0) {
            this.blb.dv(d.C0126d.cp_bg_line_d);
            this.blb.ds(d.C0126d.cp_bg_line_e);
            this.blb.du(d.C0126d.cp_cont_e);
            this.blb.wN();
        } else if (i == 1) {
            this.blb.dv(d.C0126d.cp_bg_line_c);
            this.blb.du(d.C0126d.cp_cont_d);
            this.blb.wO();
        }
        this.blb.dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cU(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.w(list)) {
            list = new ArrayList<>();
        }
        if (this.fIw.getVisibility() != 0) {
            this.fIw.setVisibility(0);
        }
        this.fIw.setData(list);
    }

    public void bfb() {
        if (af.fz()) {
            if (this.fIy == null) {
                this.fIy = new ImageView(this.adf.getPageActivity());
                this.fIy.setImageResource(d.f.icon_nichengjun);
                this.fIy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.adf.getPageActivity(), null, com.baidu.tieba.pb.c.aVa(), true)));
                    }
                });
            }
            if (this.fIy.getParent() != null) {
                ((ViewGroup) this.fIy.getParent()).removeView(this.fIy);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.e(this.adf.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.e(this.adf.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fIy, layoutParams);
            }
        } else if (this.fIy != null && this.fIy.getParent() != null && this.fIy.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fIy);
        }
    }

    public void f(UserData userData) {
        this.fIA.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Fa().eY(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.adf.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.adf.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fIz.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fp().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fIC.fbV = userData;
    }

    public void C(float f) {
        if (!this.fIB.isShown()) {
            this.fIB.setVisibility(0);
            this.fIB.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dpP, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fIB.startAnimation(rotateAnimation);
        this.dpP = f;
    }

    public void auL() {
        this.fIB.clearAnimation();
        this.fIB.setImageDrawable(null);
        this.fIB.setVisibility(8);
    }

    public void ky() {
        if (!this.fIB.isShown()) {
            this.fIB.setVisibility(0);
            this.fIB.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fIB.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
