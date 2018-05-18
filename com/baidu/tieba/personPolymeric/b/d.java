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
    private com.baidu.tbadk.j.f bhf;
    private NoNetworkView blp;
    public PbListView blq;
    private PluginErrorTipView cII;
    private b fJA;
    private ImageView fJB;
    protected PersonExpandImageView fJC;
    protected View fJD;
    private ImageView fJE;
    protected NavigationBar fJG;
    protected RelativeLayout fJH;
    protected BdPersonListView fJz;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dqU = 360.0f;
    private a fJF = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fJC);
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
            this.mContext = tbPageContext;
            this.mRootView = view2;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fJz = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.cII = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fJG = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.fJH = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.blq = new PbListView(this.mContext.getPageActivity());
            this.blq.getView();
            this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.blq.du(d.C0126d.cp_cont_e);
            this.blq.dv(d.C0126d.cp_bg_line_d);
            this.blq.setHeight(l.e(this.mContext.getPageActivity(), d.e.ds140));
            this.blq.dt(l.e(this.mContext.getPageActivity(), d.e.ds12));
            this.blq.wM();
            this.blq.ds(d.C0126d.cp_bg_line_e);
            this.fJz.setNextPage(this.blq);
            this.fJC = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fJC.setInitHeight(this.mContext.getResources().getDimensionPixelSize(d.e.tbds496));
            this.fJD = view2.findViewById(d.g.view_top_background_cover);
            this.fJD.setVisibility(8);
            this.fJz.setOuterExpandView(this.fJC);
            this.fJE = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view2, com.baidu.tieba.view.g gVar) {
        if (view2 != null && gVar != null) {
            this.fJF.fJK = gVar;
            view2.setOnClickListener(this.fJF);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b fJJ = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g fJK;
        public UserData fcZ;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TiebaStatic.log(new al("c12502").ac("obj_locate", "3"));
            this.fJJ.cLl = 10;
            this.fJJ.cLm = new Bundle();
            this.fJJ.cLm.putSerializable(UserData.TYPE_USER, this.fcZ);
            if (this.fJK != null) {
                this.fJK.a(view2, this.fJJ);
            }
        }
    }

    public void le(boolean z) {
        this.fJH.setVisibility(8);
        this.fJG.setVisibility(0);
        this.fJG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.fJG.setCenterTextTitle(this.mContext.getString(d.k.ta_homepage));
        } else {
            this.fJG.setCenterTextTitle(this.mContext.getString(d.k.my_homepage));
        }
        this.fJG.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.af(null, this.mContext.getString(d.k.user_to_anti)), null);
        }
        ak.h(this.mNoDataView.getSuTextView(), d.C0126d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void axe() {
        if (this.mRootView != null) {
            this.fJz.setVisibility(8);
            if (this.fJB != null) {
                this.fJB.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    az.aI(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    az.aJ(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(d.k.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(d.k.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    az.aJ(d.this.mContext.getPageActivity());
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
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.fJG.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)));
            if (this.fJz.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.fJz.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.blp.onChangeSkinType(this.mContext, i);
            this.cII.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.fJA = bVar;
    }

    public void Qk() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bhf == null) {
            if (i < 0) {
                this.bhf = new com.baidu.tbadk.j.f(this.mContext.getContext());
            } else {
                this.bhf = new com.baidu.tbadk.j.f(this.mContext.getContext(), i);
            }
            this.bhf.onChangeSkinType();
        }
        this.bhf.d(this.mRootView, z);
    }

    public void Os() {
        if (this.bhf != null) {
            this.bhf.P(this.mRootView);
            this.bhf = null;
        }
    }

    public void lf(boolean z) {
        if (z) {
            bfb();
        }
    }

    public void rg(int i) {
        this.fJz.setVisibility(i);
    }

    public void E(String str, boolean z) {
        if (!axd()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (com.baidu.adp.lib.util.j.gD()) {
                            d.this.Qk();
                            d.this.lf(true);
                            if (d.this.fJA != null) {
                                d.this.fJA.bm(view2);
                            }
                        }
                    }
                });
            }
            this.refreshView.fb(this.mContext.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.setSubText(str);
            this.refreshView.d(this.mRootView, z);
            this.refreshView.Fs();
            this.refreshView.onChangeSkinType();
            this.fJz.setVisibility(8);
            if (this.fJB != null) {
                this.fJB.setVisibility(8);
            }
        }
    }

    public boolean axd() {
        if (this.refreshView != null) {
            return this.refreshView.Fk();
        }
        return false;
    }

    public void wQ() {
        if (this.blq != null) {
            this.blq.wQ();
        }
    }

    public void wR() {
        if (this.blq != null) {
            this.blq.wR();
        }
    }

    public void eD(boolean z) {
        if (this.fJz != null && this.blq != null) {
            this.blq.wR();
            if (z) {
                this.blq.setText(this.mContext.getString(d.k.list_no_more));
            } else {
                this.blq.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.fJz != null && this.blq != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    Qn();
                    return;
                }
            }
            this.blq.wR();
            if (z) {
                this.blq.setText(this.mContext.getString(d.k.list_no_more));
            } else {
                this.blq.setText("");
            }
        }
    }

    public void Qn() {
        if (this.fJz != null && this.blq != null) {
            this.fJz.setNextPage(null);
            this.blq.wU();
        }
    }

    public void rh(int i) {
        if (i == 0) {
            this.blq.dv(d.C0126d.cp_bg_line_d);
            this.blq.ds(d.C0126d.cp_bg_line_e);
            this.blq.du(d.C0126d.cp_cont_e);
            this.blq.wM();
        } else if (i == 1) {
            this.blq.dv(d.C0126d.cp_bg_line_c);
            this.blq.du(d.C0126d.cp_cont_d);
            this.blq.wN();
        }
        this.blq.dw(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cX(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.w(list)) {
            list = new ArrayList<>();
        }
        if (this.fJz.getVisibility() != 0) {
            this.fJz.setVisibility(0);
        }
        this.fJz.setData(list);
    }

    public void bfb() {
        if (af.fz()) {
            if (this.fJB == null) {
                this.fJB = new ImageView(this.mContext.getPageActivity());
                this.fJB.setImageResource(d.f.icon_nichengjun);
                this.fJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.aVa(), true)));
                    }
                });
            }
            if (this.fJB.getParent() != null) {
                ((ViewGroup) this.fJB.getParent()).removeView(this.fJB);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.e(this.mContext.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.e(this.mContext.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fJB, layoutParams);
            }
        } else if (this.fJB != null && this.fJB.getParent() != null && this.fJB.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fJB);
        }
    }

    public void f(UserData userData) {
        this.fJD.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.EY().eY(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fJC.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fp().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fJF.fcZ = userData;
    }

    public void C(float f) {
        if (!this.fJE.isShown()) {
            this.fJE.setVisibility(0);
            this.fJE.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dqU, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fJE.startAnimation(rotateAnimation);
        this.dqU = f;
    }

    public void auK() {
        this.fJE.clearAnimation();
        this.fJE.setImageDrawable(null);
        this.fJE.setVisibility(8);
    }

    public void kx() {
        if (!this.fJE.isShown()) {
            this.fJE.setVisibility(0);
            this.fJE.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fJE.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
