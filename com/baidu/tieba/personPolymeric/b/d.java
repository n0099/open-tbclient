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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
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
    protected TbPageContext aRG;
    private com.baidu.tbadk.j.f bXa;
    private NoNetworkView caX;
    public PbListView caY;
    private PluginErrorTipView dpj;
    protected BdPersonListView gnJ;
    private b gnK;
    private ImageView gnL;
    protected PersonExpandImageView gnM;
    protected View gnN;
    private ImageView gnO;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.h mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dUK = 360.0f;
    private a gnP = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gnM);
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
        void cG(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.aRG = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.gnJ = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.dpj = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.caY = new PbListView(this.aRG.getPageActivity());
            this.caY.getView();
            this.caY.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.caY.gv(d.C0141d.cp_cont_e);
            this.caY.gw(d.C0141d.cp_bg_line_d);
            this.caY.setHeight(l.t(this.aRG.getPageActivity(), d.e.ds140));
            this.caY.gt(l.t(this.aRG.getPageActivity(), d.e.ds12));
            this.caY.Eb();
            this.caY.gs(d.C0141d.cp_bg_line_e);
            this.gnJ.setNextPage(this.caY);
            this.gnM = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.gnM.setInitHeight(this.aRG.getResources().getDimensionPixelSize(d.e.tbds496));
            this.gnN = view.findViewById(d.g.view_top_background_cover);
            this.gnN.setVisibility(8);
            this.gnJ.setOuterExpandView(this.gnM);
            this.gnO = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.i iVar) {
        if (view != null && iVar != null) {
            this.gnP.gnS = iVar;
            view.setOnClickListener(this.gnP);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fHa;
        private com.baidu.tieba.personPolymeric.event.b gnR = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.i gnS;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ab("obj_locate", "3"));
            this.gnR.drl = 10;
            this.gnR.drm = new Bundle();
            this.gnR.drm.putSerializable(UserData.TYPE_USER, this.fHa);
            if (this.gnS != null) {
                this.gnS.a(view, this.gnR);
            }
        }
    }

    public void aCg() {
        if (this.mRootView != null) {
            this.gnJ.setVisibility(8);
            if (this.gnL != null) {
                this.gnL.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRG.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ay.aY(d.this.aRG.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRG.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ay.aZ(d.this.aRG.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aRG.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.aRG.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.aRG.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.aRG.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.aRG.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aRG.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aRG.getString(d.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRG.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ay.aZ(d.this.aRG.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRG, i);
        }
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        if (this.gnJ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gnJ.getAdapter().notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.caX.onChangeSkinType(this.aRG, i);
        this.dpj.onChangeSkinType(this.aRG, i);
    }

    public void a(b bVar) {
        this.gnK = bVar;
    }

    public void XM() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
        }
    }

    public void k(boolean z, int i) {
        if (this.bXa == null) {
            if (i < 0) {
                this.bXa = new com.baidu.tbadk.j.f(this.aRG.getContext());
            } else {
                this.bXa = new com.baidu.tbadk.j.f(this.aRG.getContext(), i);
            }
            this.bXa.onChangeSkinType();
        }
        this.bXa.j(this.mRootView, z);
    }

    public void VU() {
        if (this.bXa != null) {
            this.bXa.bk(this.mRootView);
            this.bXa = null;
        }
    }

    public void lz(boolean z) {
        if (z) {
            bjX();
        }
    }

    public void tL(int i) {
        this.gnJ.setVisibility(i);
    }

    public void H(String str, boolean z) {
        if (!aCf()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.aRG.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.ox()) {
                            d.this.XM();
                            d.this.lz(true);
                            if (d.this.gnK != null) {
                                d.this.gnK.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ib(this.aRG.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.gW(str);
            this.refreshView.j(this.mRootView, z);
            this.refreshView.MQ();
            this.refreshView.onChangeSkinType();
            this.gnJ.setVisibility(8);
            if (this.gnL != null) {
                this.gnL.setVisibility(8);
            }
        }
    }

    public boolean aCf() {
        if (this.refreshView != null) {
            return this.refreshView.MI();
        }
        return false;
    }

    public void Ef() {
        if (this.caY != null) {
            this.caY.Ef();
        }
    }

    public void Eg() {
        if (this.caY != null) {
            this.caY.Eg();
        }
    }

    public void eX(boolean z) {
        if (this.gnJ != null && this.caY != null) {
            this.caY.Eg();
            if (z) {
                this.caY.setText(this.aRG.getString(d.j.list_no_more));
            } else {
                this.caY.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.i> list) {
        if (this.gnJ != null && this.caY != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    XP();
                    return;
                }
            }
            this.caY.Eg();
            if (z) {
                this.caY.setText(this.aRG.getString(d.j.list_no_more));
            } else {
                this.caY.setText("");
            }
        }
    }

    public void XP() {
        if (this.gnJ != null && this.caY != null) {
            this.gnJ.setNextPage(null);
            this.caY.Ei();
        }
    }

    public void tM(int i) {
        if (i == 0) {
            this.caY.gw(d.C0141d.cp_bg_line_d);
            this.caY.gs(d.C0141d.cp_bg_line_e);
            this.caY.gv(d.C0141d.cp_cont_e);
            this.caY.Eb();
        } else if (i == 1) {
            this.caY.gw(d.C0141d.cp_bg_line_c);
            this.caY.gv(d.C0141d.cp_cont_d);
            this.caY.Ec();
        }
        this.caY.gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dc(List<com.baidu.adp.widget.ListView.i> list) {
        if (v.E(list)) {
            list = new ArrayList<>();
        }
        if (this.gnJ.getVisibility() != 0) {
            this.gnJ.setVisibility(0);
        }
        this.gnJ.setData(list);
    }

    public void bjX() {
        if (af.nv()) {
            if (this.gnL == null) {
                this.gnL = new ImageView(this.aRG.getPageActivity());
                this.gnL.setImageResource(d.f.icon_nichengjun);
                this.gnL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.aRG.getPageActivity(), null, com.baidu.tieba.pb.c.baa(), true)));
                    }
                });
            }
            if (this.gnL.getParent() != null) {
                ((ViewGroup) this.gnL.getParent()).removeView(this.gnL);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.t(this.aRG.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.t(this.aRG.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gnL, layoutParams);
            }
        } else if (this.gnL != null && this.gnL.getParent() != null && this.gnL.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gnL);
        }
    }

    public void f(UserData userData) {
        this.gnN.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Mw().hY(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.aRG.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.aRG.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gnM.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.nm().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gnP.fHa = userData;
    }

    public void O(float f) {
        if (!this.gnO.isShown()) {
            this.gnO.setVisibility(0);
            this.gnO.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dUK, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gnO.startAnimation(rotateAnimation);
        this.dUK = f;
    }

    public void azS() {
        this.gnO.clearAnimation();
        this.gnO.setImageDrawable(null);
        this.gnO.setVisibility(8);
    }

    public void sr() {
        if (!this.gnO.isShown()) {
            this.gnO.setVisibility(0);
            this.gnO.setImageDrawable(this.aRG.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.gnO.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.aRG.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
