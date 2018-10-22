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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.e;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tbadk.k.f bFV;
    private NoNetworkView bJX;
    public PbListView bJY;
    private PluginErrorTipView dgD;
    protected BdPersonListView goh;
    private b goi;
    private ImageView goj;
    protected PersonExpandImageView gok;
    protected View gol;
    private ImageView gom;
    protected NavigationBar goo;
    protected RelativeLayout gop;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float dVe = 360.0f;
    private a gon = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gok);
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
        void bG(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
            this.goh = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.dgD = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.goo = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.gop = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bJY = new PbListView(this.mContext.getPageActivity());
            this.bJY.getView();
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bJY.dU(e.d.cp_cont_e);
            this.bJY.dV(e.d.cp_bg_line_d);
            this.bJY.setHeight(l.h(this.mContext.getPageActivity(), e.C0175e.ds140));
            this.bJY.dS(l.h(this.mContext.getPageActivity(), e.C0175e.ds12));
            this.bJY.DK();
            this.bJY.dR(e.d.cp_bg_line_e);
            this.goh.setNextPage(this.bJY);
            this.gok = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.gok.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds496));
            this.gol = view.findViewById(e.g.view_top_background_cover);
            this.gol.setVisibility(8);
            this.goh.setOuterExpandView(this.gok);
            this.gom = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.gon.gos = gVar;
            view.setOnClickListener(this.gon);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fHG;
        private com.baidu.tieba.personPolymeric.event.b gor = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g gos;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").ax("obj_locate", "3"));
            this.gor.djg = 10;
            this.gor.djh = new Bundle();
            this.gor.djh.putSerializable(UserData.TYPE_USER, this.fHG);
            if (this.gos != null) {
                this.gos.a(view, this.gor);
            }
        }
    }

    public void lT(boolean z) {
        this.gop.setVisibility(8);
        this.goo.setVisibility(0);
        this.goo.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.goo.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.goo.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.goo.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aA(null, this.mContext.getString(e.j.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), e.d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aIM() {
        if (this.mRootView != null) {
            this.goh.setVisibility(8);
            if (this.goj != null) {
                this.goj.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bG(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bH(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(e.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bH(d.this.mContext.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.mContext, i);
            }
            al.i(this.mRootView, e.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.goo.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)));
            if (this.goh.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.goh.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bJX.onChangeSkinType(this.mContext, i);
            this.dgD.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.goi = bVar;
    }

    public void ZI() {
        if (this.refreshView != null) {
            this.refreshView.ad(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bFV == null) {
            if (i < 0) {
                this.bFV = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bFV = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bFV.onChangeSkinType();
        }
        this.bFV.c(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bFV != null) {
            this.bFV.ad(this.mRootView);
            this.bFV = null;
        }
    }

    public void lU(boolean z) {
        if (z) {
            boJ();
        }
    }

    public void ss(int i) {
        this.goh.setVisibility(i);
    }

    public void M(String str, boolean z) {
        if (!aIL()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM()) {
                            d.this.ZI();
                            d.this.lU(true);
                            if (d.this.goi != null) {
                                d.this.goi.bG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fB(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds280));
            this.refreshView.hU(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.My();
            this.refreshView.onChangeSkinType();
            this.goh.setVisibility(8);
            if (this.goj != null) {
                this.goj.setVisibility(8);
            }
        }
    }

    public boolean aIL() {
        if (this.refreshView != null) {
            return this.refreshView.Mq();
        }
        return false;
    }

    public void DO() {
        if (this.bJY != null) {
            this.bJY.DO();
        }
    }

    public void DP() {
        if (this.bJY != null) {
            this.bJY.DP();
        }
    }

    public void fr(boolean z) {
        if (this.goh != null && this.bJY != null) {
            this.bJY.DP();
            if (z) {
                this.bJY.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bJY.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.goh != null && this.bJY != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    ZL();
                    return;
                }
            }
            this.bJY.DP();
            if (z) {
                this.bJY.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bJY.setText("");
            }
        }
    }

    public void ZL() {
        if (this.goh != null && this.bJY != null) {
            this.goh.setNextPage(null);
            this.bJY.hideEmptyView();
        }
    }

    public void st(int i) {
        if (i == 0) {
            this.bJY.dV(e.d.cp_bg_line_d);
            this.bJY.dR(e.d.cp_bg_line_e);
            this.bJY.dU(e.d.cp_cont_e);
            this.bJY.DK();
        } else if (i == 1) {
            this.bJY.dV(e.d.cp_bg_line_c);
            this.bJY.dU(e.d.cp_cont_d);
            this.bJY.DL();
        }
        this.bJY.dW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dr(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.J(list)) {
            list = new ArrayList<>();
        }
        if (this.goh.getVisibility() != 0) {
            this.goh.setVisibility(0);
        }
        this.goh.setData(list);
    }

    public void boJ() {
        if (com.baidu.tbadk.p.am.jL()) {
            if (this.goj == null) {
                this.goj = new ImageView(this.mContext.getPageActivity());
                this.goj.setImageResource(e.f.icon_nichengjun);
                this.goj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.beD(), true)));
                    }
                });
            }
            if (this.goj.getParent() != null) {
                ((ViewGroup) this.goj.getParent()).removeView(this.goj);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0175e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0175e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.goj, layoutParams);
            }
        } else if (this.goj != null && this.goj.getParent() != null && this.goj.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.goj);
        }
    }

    public void f(UserData userData) {
        this.gol.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Me().fy(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gok.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jC().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gon.fHG = userData;
    }

    public void M(float f) {
        if (!this.gom.isShown()) {
            this.gom.setVisibility(0);
            this.gom.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dVe, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gom.startAnimation(rotateAnimation);
        this.dVe = f;
    }

    public void aFG() {
        this.gom.clearAnimation();
        this.gom.setImageDrawable(null);
        this.gom.setVisibility(8);
    }

    public void oE() {
        if (!this.gom.isShown()) {
            this.gom.setVisibility(0);
            this.gom.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.gom.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
