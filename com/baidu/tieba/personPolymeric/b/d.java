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
    private NoNetworkView bBq;
    public PbListView bBr;
    private com.baidu.tbadk.k.f bxm;
    private PluginErrorTipView cYn;
    protected BdPersonListView ggF;
    private b ggG;
    private ImageView ggH;
    protected PersonExpandImageView ggI;
    protected View ggJ;
    private ImageView ggK;
    protected NavigationBar ggM;
    protected RelativeLayout ggN;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float dNi = 360.0f;
    private a ggL = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.ggI);
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
            this.ggF = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.cYn = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.ggM = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.ggN = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bBr = new PbListView(this.mContext.getPageActivity());
            this.bBr.getView();
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bBr.dK(e.d.cp_cont_e);
            this.bBr.dL(e.d.cp_bg_line_d);
            this.bBr.setHeight(l.h(this.mContext.getPageActivity(), e.C0141e.ds140));
            this.bBr.dI(l.h(this.mContext.getPageActivity(), e.C0141e.ds12));
            this.bBr.BE();
            this.bBr.dH(e.d.cp_bg_line_e);
            this.ggF.setNextPage(this.bBr);
            this.ggI = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.ggI.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds496));
            this.ggJ = view.findViewById(e.g.view_top_background_cover);
            this.ggJ.setVisibility(8);
            this.ggF.setOuterExpandView(this.ggI);
            this.ggK = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.ggL.ggQ = gVar;
            view.setOnClickListener(this.ggL);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fAd;
        private com.baidu.tieba.personPolymeric.event.b ggP = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g ggQ;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").al("obj_locate", "3"));
            this.ggP.daV = 10;
            this.ggP.daW = new Bundle();
            this.ggP.daW.putSerializable(UserData.TYPE_USER, this.fAd);
            if (this.ggQ != null) {
                this.ggQ.a(view, this.ggP);
            }
        }
    }

    public void lC(boolean z) {
        this.ggN.setVisibility(8);
        this.ggM.setVisibility(0);
        this.ggM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.ggM.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.ggM.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.ggM.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.ao(null, this.mContext.getString(e.j.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), e.d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aFu() {
        if (this.mRootView != null) {
            this.ggF.setVisibility(8);
            if (this.ggH != null) {
                this.ggH.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ba.by(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ba.bz(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.F(e.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(e.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ba.bz(d.this.mContext.getPageActivity());
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
            this.ggM.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)));
            if (this.ggF.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.ggF.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bBq.onChangeSkinType(this.mContext, i);
            this.cYn.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.ggG = bVar;
    }

    public void Wa() {
        if (this.refreshView != null) {
            this.refreshView.ad(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bxm == null) {
            if (i < 0) {
                this.bxm = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bxm = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bxm.onChangeSkinType();
        }
        this.bxm.c(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bxm != null) {
            this.bxm.ad(this.mRootView);
            this.bxm = null;
        }
    }

    public void lD(boolean z) {
        if (z) {
            bly();
        }
    }

    public void rV(int i) {
        this.ggF.setVisibility(i);
    }

    public void F(String str, boolean z) {
        if (!aFt()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ky()) {
                            d.this.Wa();
                            d.this.lD(true);
                            if (d.this.ggG != null) {
                                d.this.ggG.bG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fs(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds280));
            this.refreshView.hG(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.KA();
            this.refreshView.onChangeSkinType();
            this.ggF.setVisibility(8);
            if (this.ggH != null) {
                this.ggH.setVisibility(8);
            }
        }
    }

    public boolean aFt() {
        if (this.refreshView != null) {
            return this.refreshView.Ks();
        }
        return false;
    }

    public void BI() {
        if (this.bBr != null) {
            this.bBr.BI();
        }
    }

    public void BJ() {
        if (this.bBr != null) {
            this.bBr.BJ();
        }
    }

    public void eZ(boolean z) {
        if (this.ggF != null && this.bBr != null) {
            this.bBr.BJ();
            if (z) {
                this.bBr.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bBr.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.ggF != null && this.bBr != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    Wd();
                    return;
                }
            }
            this.bBr.BJ();
            if (z) {
                this.bBr.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bBr.setText("");
            }
        }
    }

    public void Wd() {
        if (this.ggF != null && this.bBr != null) {
            this.ggF.setNextPage(null);
            this.bBr.hideEmptyView();
        }
    }

    public void rW(int i) {
        if (i == 0) {
            this.bBr.dL(e.d.cp_bg_line_d);
            this.bBr.dH(e.d.cp_bg_line_e);
            this.bBr.dK(e.d.cp_cont_e);
            this.bBr.BE();
        } else if (i == 1) {
            this.bBr.dL(e.d.cp_bg_line_c);
            this.bBr.dK(e.d.cp_cont_d);
            this.bBr.BF();
        }
        this.bBr.dM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dd(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.z(list)) {
            list = new ArrayList<>();
        }
        if (this.ggF.getVisibility() != 0) {
            this.ggF.setVisibility(0);
        }
        this.ggF.setData(list);
    }

    public void bly() {
        if (com.baidu.tbadk.p.am.jw()) {
            if (this.ggH == null) {
                this.ggH = new ImageView(this.mContext.getPageActivity());
                this.ggH.setImageResource(e.f.icon_nichengjun);
                this.ggH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bbr(), true)));
                    }
                });
            }
            if (this.ggH.getParent() != null) {
                ((ViewGroup) this.ggH.getParent()).removeView(this.ggH);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0141e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0141e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.ggH, layoutParams);
            }
        } else if (this.ggH != null && this.ggH.getParent() != null && this.ggH.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.ggH);
        }
    }

    public void f(UserData userData) {
        this.ggJ.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Kg().fp(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.ggI.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jn().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.ggL.fAd = userData;
    }

    public void M(float f) {
        if (!this.ggK.isShown()) {
            this.ggK.setVisibility(0);
            this.ggK.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dNi, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.ggK.startAnimation(rotateAnimation);
        this.dNi = f;
    }

    public void aCn() {
        this.ggK.clearAnimation();
        this.ggK.setImageDrawable(null);
        this.ggK.setVisibility(8);
    }

    public void ot() {
        if (!this.ggK.isShown()) {
            this.ggK.setVisibility(0);
            this.ggK.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.ggK.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
