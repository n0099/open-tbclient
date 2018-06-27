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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.o.ai;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tbadk.j.f bqL;
    private NoNetworkView buT;
    public PbListView buU;
    private PluginErrorTipView cPN;
    protected BdPersonListView fYW;
    private b fYX;
    private ImageView fYY;
    protected PersonExpandImageView fYZ;
    protected View fZa;
    private ImageView fZb;
    protected NavigationBar fZd;
    protected RelativeLayout fZe;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dDt = 360.0f;
    private a fZc = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fYZ);
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
        void bq(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fYW = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.cPN = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fZd = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.fZe = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.buU = new PbListView(this.mContext.getPageActivity());
            this.buU.getView();
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            this.buU.dx(d.C0142d.cp_cont_e);
            this.buU.dy(d.C0142d.cp_bg_line_d);
            this.buU.setHeight(l.e(this.mContext.getPageActivity(), d.e.ds140));
            this.buU.dw(l.e(this.mContext.getPageActivity(), d.e.ds12));
            this.buU.AD();
            this.buU.dv(d.C0142d.cp_bg_line_e);
            this.fYW.setNextPage(this.buU);
            this.fYZ = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fYZ.setInitHeight(this.mContext.getResources().getDimensionPixelSize(d.e.tbds496));
            this.fZa = view.findViewById(d.g.view_top_background_cover);
            this.fZa.setVisibility(8);
            this.fYW.setOuterExpandView(this.fYZ);
            this.fZb = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.fZc.fZh = gVar;
            view.setOnClickListener(this.fZc);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b fZg = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g fZh;
        public UserData fso;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").ah("obj_locate", "3"));
            this.fZg.cSt = 10;
            this.fZg.cSu = new Bundle();
            this.fZg.cSu.putSerializable(UserData.TYPE_USER, this.fso);
            if (this.fZh != null) {
                this.fZh.a(view, this.fZg);
            }
        }
    }

    public void lu(boolean z) {
        this.fZe.setVisibility(8);
        this.fZd.setVisibility(0);
        this.fZd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.fZd.setCenterTextTitle(this.mContext.getString(d.k.ta_homepage));
        } else {
            this.fZd.setCenterTextTitle(this.mContext.getString(d.k.my_homepage));
        }
        this.fZd.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aj(null, this.mContext.getString(d.k.user_to_anti)), null);
        }
        am.h(this.mNoDataView.getSuTextView(), d.C0142d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aCC() {
        if (this.mRootView != null) {
            this.fYW.setVisibility(8);
            if (this.fYY != null) {
                this.fYY.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bb.aS(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bb.aT(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(d.k.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(d.k.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bb.aT(d.this.mContext.getPageActivity());
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
            am.i(this.mRootView, d.C0142d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.fZd.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)));
            if (this.fYW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.fYW.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.buT.onChangeSkinType(this.mContext, i);
            this.cPN.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.fYX = bVar;
    }

    public void Uc() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bqL == null) {
            if (i < 0) {
                this.bqL = new com.baidu.tbadk.j.f(this.mContext.getContext());
            } else {
                this.bqL = new com.baidu.tbadk.j.f(this.mContext.getContext(), i);
            }
            this.bqL.onChangeSkinType();
        }
        this.bqL.d(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bqL != null) {
            this.bqL.Q(this.mRootView);
            this.bqL = null;
        }
    }

    public void lv(boolean z) {
        if (z) {
            bkG();
        }
    }

    public void rB(int i) {
        this.fYW.setVisibility(i);
    }

    public void F(String str, boolean z) {
        if (!aCB()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jr()) {
                            d.this.Uc();
                            d.this.lv(true);
                            if (d.this.fYX != null) {
                                d.this.fYX.bq(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fg(this.mContext.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.setSubText(str);
            this.refreshView.d(this.mRootView, z);
            this.refreshView.Jp();
            this.refreshView.onChangeSkinType();
            this.fYW.setVisibility(8);
            if (this.fYY != null) {
                this.fYY.setVisibility(8);
            }
        }
    }

    public boolean aCB() {
        if (this.refreshView != null) {
            return this.refreshView.Jh();
        }
        return false;
    }

    public void AH() {
        if (this.buU != null) {
            this.buU.AH();
        }
    }

    public void AI() {
        if (this.buU != null) {
            this.buU.AI();
        }
    }

    public void eH(boolean z) {
        if (this.fYW != null && this.buU != null) {
            this.buU.AI();
            if (z) {
                this.buU.setText(this.mContext.getString(d.k.list_no_more));
            } else {
                this.buU.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.fYW != null && this.buU != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    Uf();
                    return;
                }
            }
            this.buU.AI();
            if (z) {
                this.buU.setText(this.mContext.getString(d.k.list_no_more));
            } else {
                this.buU.setText("");
            }
        }
    }

    public void Uf() {
        if (this.fYW != null && this.buU != null) {
            this.fYW.setNextPage(null);
            this.buU.AM();
        }
    }

    public void rC(int i) {
        if (i == 0) {
            this.buU.dy(d.C0142d.cp_bg_line_d);
            this.buU.dv(d.C0142d.cp_bg_line_e);
            this.buU.dx(d.C0142d.cp_cont_e);
            this.buU.AD();
        } else if (i == 1) {
            this.buU.dy(d.C0142d.cp_bg_line_c);
            this.buU.dx(d.C0142d.cp_cont_d);
            this.buU.AE();
        }
        this.buU.dz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dg(List<com.baidu.adp.widget.ListView.h> list) {
        if (w.A(list)) {
            list = new ArrayList<>();
        }
        if (this.fYW.getVisibility() != 0) {
            this.fYW.setVisibility(0);
        }
        this.fYW.setData(list);
    }

    public void bkG() {
        if (ai.ip()) {
            if (this.fYY == null) {
                this.fYY = new ImageView(this.mContext.getPageActivity());
                this.fYY.setImageResource(d.f.icon_nichengjun);
                this.fYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.baD(), true)));
                    }
                });
            }
            if (this.fYY.getParent() != null) {
                ((ViewGroup) this.fYY.getParent()).removeView(this.fYY);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.e(this.mContext.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.e(this.mContext.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fYY, layoutParams);
            }
        } else if (this.fYY != null && this.fYY.getParent() != null && this.fYY.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fYY);
        }
    }

    public void f(UserData userData) {
        this.fZa.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.IV().fd(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fYZ.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.ig().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fZc.fso = userData;
    }

    public void M(float f) {
        if (!this.fZb.isShown()) {
            this.fZb.setVisibility(0);
            this.fZb.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dDt, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fZb.startAnimation(rotateAnimation);
        this.dDt = f;
    }

    public void azA() {
        this.fZb.clearAnimation();
        this.fZb.setImageDrawable(null);
        this.fZb.setVisibility(8);
    }

    public void nl() {
        if (!this.fZb.isShown()) {
            this.fZb.setVisibility(0);
            this.fZb.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fZb.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
