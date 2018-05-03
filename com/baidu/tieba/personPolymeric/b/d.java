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
    private PluginErrorTipView cHz;
    protected NavigationBar fIA;
    protected RelativeLayout fIB;
    protected BdPersonListView fIt;
    private b fIu;
    private ImageView fIv;
    protected PersonExpandImageView fIw;
    protected View fIx;
    private ImageView fIy;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dpM = 360.0f;
    private a fIz = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fIw);
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
            this.fIt = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.cHz = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fIA = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.fIB = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.blb = new PbListView(this.adf.getPageActivity());
            this.blb.getView();
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blb.dt(d.C0126d.cp_cont_e);
            this.blb.du(d.C0126d.cp_bg_line_d);
            this.blb.setHeight(l.e(this.adf.getPageActivity(), d.e.ds140));
            this.blb.ds(l.e(this.adf.getPageActivity(), d.e.ds12));
            this.blb.wN();
            this.blb.dr(d.C0126d.cp_bg_line_e);
            this.fIt.setNextPage(this.blb);
            this.fIw = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fIw.setInitHeight(this.adf.getResources().getDimensionPixelSize(d.e.tbds496));
            this.fIx = view2.findViewById(d.g.view_top_background_cover);
            this.fIx.setVisibility(8);
            this.fIt.setOuterExpandView(this.fIw);
            this.fIy = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view2, com.baidu.tieba.view.g gVar) {
        if (view2 != null && gVar != null) {
            this.fIz.fIE = gVar;
            view2.setOnClickListener(this.fIz);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b fID = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g fIE;
        public UserData fbS;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TiebaStatic.log(new al("c12502").ac("obj_locate", "3"));
            this.fID.cKc = 10;
            this.fID.cKd = new Bundle();
            this.fID.cKd.putSerializable(UserData.TYPE_USER, this.fbS);
            if (this.fIE != null) {
                this.fIE.a(view2, this.fID);
            }
        }
    }

    public void ld(boolean z) {
        this.fIB.setVisibility(8);
        this.fIA.setVisibility(0);
        this.fIA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.fIA.setCenterTextTitle(this.adf.getString(d.k.ta_homepage));
        } else {
            this.fIA.setCenterTextTitle(this.adf.getString(d.k.my_homepage));
        }
        this.fIA.showBottomLine();
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
            this.fIt.setVisibility(8);
            if (this.fIv != null) {
                this.fIv.setVisibility(8);
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
            this.fIA.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cO(d.f.s_navbar_bg)));
            if (this.fIt.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.fIt.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bla.onChangeSkinType(this.adf, i);
            this.cHz.onChangeSkinType(this.adf, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.fIu = bVar;
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

    public void rh(int i) {
        this.fIt.setVisibility(i);
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
                            if (d.this.fIu != null) {
                                d.this.fIu.bm(view2);
                            }
                        }
                    }
                });
            }
            this.refreshView.fa(this.adf.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.setSubText(str);
            this.refreshView.d(this.mRootView, z);
            this.refreshView.Fu();
            this.refreshView.onChangeSkinType();
            this.fIt.setVisibility(8);
            if (this.fIv != null) {
                this.fIv.setVisibility(8);
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
        if (this.fIt != null && this.blb != null) {
            this.blb.wS();
            if (z) {
                this.blb.setText(this.adf.getString(d.k.list_no_more));
            } else {
                this.blb.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.fIt != null && this.blb != null) {
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
        if (this.fIt != null && this.blb != null) {
            this.fIt.setNextPage(null);
            this.blb.wV();
        }
    }

    public void ri(int i) {
        if (i == 0) {
            this.blb.du(d.C0126d.cp_bg_line_d);
            this.blb.dr(d.C0126d.cp_bg_line_e);
            this.blb.dt(d.C0126d.cp_cont_e);
            this.blb.wN();
        } else if (i == 1) {
            this.blb.du(d.C0126d.cp_bg_line_c);
            this.blb.dt(d.C0126d.cp_cont_d);
            this.blb.wO();
        }
        this.blb.dv(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cU(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.w(list)) {
            list = new ArrayList<>();
        }
        if (this.fIt.getVisibility() != 0) {
            this.fIt.setVisibility(0);
        }
        this.fIt.setData(list);
    }

    public void bfb() {
        if (af.fz()) {
            if (this.fIv == null) {
                this.fIv = new ImageView(this.adf.getPageActivity());
                this.fIv.setImageResource(d.f.icon_nichengjun);
                this.fIv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.adf.getPageActivity(), null, com.baidu.tieba.pb.c.aVa(), true)));
                    }
                });
            }
            if (this.fIv.getParent() != null) {
                ((ViewGroup) this.fIv.getParent()).removeView(this.fIv);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.e(this.adf.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.e(this.adf.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fIv, layoutParams);
            }
        } else if (this.fIv != null && this.fIv.getParent() != null && this.fIv.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fIv);
        }
    }

    public void f(UserData userData) {
        this.fIx.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Fa().eX(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.adf.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.adf.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fIw.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fp().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fIz.fbS = userData;
    }

    public void C(float f) {
        if (!this.fIy.isShown()) {
            this.fIy.setVisibility(0);
            this.fIy.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dpM, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fIy.startAnimation(rotateAnimation);
        this.dpM = f;
    }

    public void auL() {
        this.fIy.clearAnimation();
        this.fIy.setImageDrawable(null);
        this.fIy.setVisibility(8);
    }

    public void ky() {
        if (!this.fIy.isShown()) {
            this.fIy.setVisibility(0);
            this.fIy.setImageDrawable(this.adf.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fIy.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
