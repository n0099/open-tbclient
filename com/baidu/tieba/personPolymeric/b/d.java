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
import com.baidu.tbadk.p.an;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.e;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tbadk.k.f bGG;
    private NoNetworkView bKI;
    public PbListView bKJ;
    private PluginErrorTipView dhI;
    protected BdPersonListView gpG;
    private b gpH;
    private ImageView gpI;
    protected PersonExpandImageView gpJ;
    protected View gpK;
    private ImageView gpL;
    protected NavigationBar gpN;
    protected RelativeLayout gpO;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float dWk = 360.0f;
    private a gpM = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gpJ);
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
        void bI(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
            this.gpG = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.dhI = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gpN = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.gpO = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bKJ = new PbListView(this.mContext.getPageActivity());
            this.bKJ.getView();
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bKJ.ei(e.d.cp_cont_e);
            this.bKJ.ej(e.d.cp_bg_line_d);
            this.bKJ.setHeight(l.h(this.mContext.getPageActivity(), e.C0200e.ds140));
            this.bKJ.eg(l.h(this.mContext.getPageActivity(), e.C0200e.ds12));
            this.bKJ.DU();
            this.bKJ.ef(e.d.cp_bg_line_e);
            this.gpG.setNextPage(this.bKJ);
            this.gpJ = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.gpJ.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds496));
            this.gpK = view.findViewById(e.g.view_top_background_cover);
            this.gpK.setVisibility(8);
            this.gpG.setOuterExpandView(this.gpJ);
            this.gpL = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.gpM.gpR = gVar;
            view.setOnClickListener(this.gpM);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fJe;
        private com.baidu.tieba.personPolymeric.event.b gpQ = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g gpR;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").ax("obj_locate", "3"));
            this.gpQ.dkl = 10;
            this.gpQ.dkm = new Bundle();
            this.gpQ.dkm.putSerializable(UserData.TYPE_USER, this.fJe);
            if (this.gpR != null) {
                this.gpR.a(view, this.gpQ);
            }
        }
    }

    public void me(boolean z) {
        this.gpO.setVisibility(8);
        this.gpN.setVisibility(0);
        this.gpN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.gpN.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.gpN.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.gpN.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aA(null, this.mContext.getString(e.j.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), e.d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aIk() {
        if (this.mRootView != null) {
            this.gpG.setVisibility(8);
            if (this.gpI != null) {
                this.gpI.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bE(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bF(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(e.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bF(d.this.mContext.getPageActivity());
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
            this.gpN.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dB(e.f.s_navbar_bg)));
            if (this.gpG.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.gpG.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bKI.onChangeSkinType(this.mContext, i);
            this.dhI.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.gpH = bVar;
    }

    public void ZS() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void h(boolean z, int i) {
        if (this.bGG == null) {
            if (i < 0) {
                this.bGG = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bGG = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bGG.onChangeSkinType();
        }
        this.bGG.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bGG != null) {
            this.bGG.dettachView(this.mRootView);
            this.bGG = null;
        }
    }

    public void mf(boolean z) {
        if (z) {
            boe();
        }
    }

    public void sL(int i) {
        this.gpG.setVisibility(i);
    }

    public void M(String str, boolean z) {
        if (!aIj()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            d.this.ZS();
                            d.this.mf(true);
                            if (d.this.gpH != null) {
                                d.this.gpH.bI(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fP(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds280));
            this.refreshView.hV(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.MH();
            this.refreshView.onChangeSkinType();
            this.gpG.setVisibility(8);
            if (this.gpI != null) {
                this.gpI.setVisibility(8);
            }
        }
    }

    public boolean aIj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void DY() {
        if (this.bKJ != null) {
            this.bKJ.DY();
        }
    }

    public void DZ() {
        if (this.bKJ != null) {
            this.bKJ.DZ();
        }
    }

    public void fC(boolean z) {
        if (this.gpG != null && this.bKJ != null) {
            this.bKJ.DZ();
            if (z) {
                this.bKJ.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bKJ.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.gpG != null && this.bKJ != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    ZV();
                    return;
                }
            }
            this.bKJ.DZ();
            if (z) {
                this.bKJ.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bKJ.setText("");
            }
        }
    }

    public void ZV() {
        if (this.gpG != null && this.bKJ != null) {
            this.gpG.setNextPage(null);
            this.bKJ.hideEmptyView();
        }
    }

    public void sM(int i) {
        if (i == 0) {
            this.bKJ.ej(e.d.cp_bg_line_d);
            this.bKJ.ef(e.d.cp_bg_line_e);
            this.bKJ.ei(e.d.cp_cont_e);
            this.bKJ.DU();
        } else if (i == 1) {
            this.bKJ.ej(e.d.cp_bg_line_c);
            this.bKJ.ei(e.d.cp_cont_d);
            this.bKJ.DV();
        }
        this.bKJ.ek(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dp(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gpG.getVisibility() != 0) {
            this.gpG.setVisibility(0);
        }
        this.gpG.setData(list);
    }

    public void boe() {
        if (an.jJ()) {
            if (this.gpI == null) {
                this.gpI = new ImageView(this.mContext.getPageActivity());
                this.gpI.setImageResource(e.f.icon_nichengjun);
                this.gpI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bec(), true)));
                    }
                });
            }
            if (this.gpI.getParent() != null) {
                ((ViewGroup) this.gpI.getParent()).removeView(this.gpI);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0200e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0200e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gpI, layoutParams);
            }
        } else if (this.gpI != null && this.gpI.getParent() != null && this.gpI.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gpI);
        }
    }

    public void f(UserData userData) {
        this.gpK.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Mq().fM(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gpJ.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jA().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gpM.fJe = userData;
    }

    public void M(float f) {
        if (!this.gpL.isShown()) {
            this.gpL.setVisibility(0);
            this.gpL.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dWk, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gpL.startAnimation(rotateAnimation);
        this.dWk = f;
    }

    public void aFc() {
        this.gpL.clearAnimation();
        this.gpL.setImageDrawable(null);
        this.gpL.setVisibility(8);
    }

    public void oC() {
        if (!this.gpL.isShown()) {
            this.gpL.setVisibility(0);
            this.gpL.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.gpL.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
