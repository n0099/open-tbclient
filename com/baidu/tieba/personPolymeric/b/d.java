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
    private com.baidu.tbadk.k.f bem;
    private NoNetworkView bgM;
    public PbListView bgN;
    private PluginErrorTipView ckt;
    protected BdPersonListView fnF;
    private b fnG;
    private ImageView fnH;
    protected PersonExpandImageView fnI;
    protected View fnJ;
    private ImageView fnK;
    protected PersonTabView fnM;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.f mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float cRd = 360.0f;
    private a fnL = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fnI);
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
        void bv(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.abI = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fnF = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.bgM = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.ckt = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.bgN = new PbListView(this.abI.getPageActivity());
            this.bgN.getView();
            this.bgN.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
            this.bgN.dw(d.C0080d.cp_cont_e);
            this.bgN.dx(d.C0080d.cp_bg_line_d);
            this.bgN.setHeight(l.f(this.abI.getPageActivity(), d.e.ds140));
            this.bgN.du(l.f(this.abI.getPageActivity(), d.e.ds12));
            this.bgN.wp();
            this.bgN.dt(d.C0080d.cp_bg_line_e);
            this.fnF.setNextPage(this.bgN);
            this.fnI = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fnI.setInitHeight(this.abI.getResources().getDimensionPixelSize(d.e.ds400));
            this.fnJ = view.findViewById(d.g.view_top_background_cover);
            this.fnJ.setVisibility(8);
            this.fnF.setOuterExpandView(this.fnI);
            this.fnK = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            this.fnM = (PersonTabView) this.mRootView.findViewById(d.g.person_center_sticky_person_buttom_header);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.h hVar) {
        if (view != null && hVar != null) {
            this.fnL.fnP = hVar;
            view.setOnClickListener(this.fnL);
        }
    }

    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public UserData eGG;
        private com.baidu.tieba.personPolymeric.event.a fnO = new com.baidu.tieba.personPolymeric.event.a();
        public com.baidu.tieba.view.h fnP;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ac("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
            this.fnO.cmv = 10;
            this.fnO.cmw = new Bundle();
            this.fnO.cmw.putSerializable(UserData.TYPE_USER, this.eGG);
            if (this.fnP != null) {
                this.fnP.a(view, this.fnO);
            }
        }
    }

    public void arz() {
        if (this.mRootView != null) {
            this.fnF.setVisibility(8);
            if (this.fnM != null) {
                this.fnM.setVisibility(8);
            }
            if (this.fnH != null) {
                this.fnH.setVisibility(8);
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
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cR(d.f.s_navbar_bg)));
        if (this.fnF.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.fnF.getAdapter()).notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.bgM.onChangeSkinType(this.abI, i);
        this.ckt.onChangeSkinType(this.abI, i);
    }

    public void a(b bVar) {
        this.fnG = bVar;
    }

    public void On() {
        if (this.refreshView != null) {
            this.refreshView.O(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bem == null) {
            if (i < 0) {
                this.bem = new com.baidu.tbadk.k.f(this.abI.getContext());
            } else {
                this.bem = new com.baidu.tbadk.k.f(this.abI.getContext(), i);
            }
            this.bem.onChangeSkinType();
        }
        this.bem.c(this.mRootView, z);
    }

    public void Nk() {
        if (this.bem != null) {
            this.bem.O(this.mRootView);
            this.bem = null;
        }
    }

    public void kj(boolean z) {
        if (z) {
            aZI();
        }
    }

    public void qD(int i) {
        this.fnF.setVisibility(i);
    }

    public void H(String str, boolean z) {
        if (!ary()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.abI.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.gV()) {
                            d.this.On();
                            d.this.kj(true);
                            if (d.this.fnG != null) {
                                d.this.fnG.bv(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fj(this.abI.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.gz(str);
            this.refreshView.c(this.mRootView, z);
            this.refreshView.EO();
            this.refreshView.onChangeSkinType();
            this.fnF.setVisibility(8);
            if (this.fnH != null) {
                this.fnH.setVisibility(8);
            }
        }
    }

    public boolean ary() {
        if (this.refreshView != null) {
            return this.refreshView.EG();
        }
        return false;
    }

    public void wt() {
        if (this.bgN != null) {
            this.bgN.wt();
        }
    }

    public void wu() {
        if (this.bgN != null) {
            this.bgN.wu();
        }
    }

    public void dN(boolean z) {
        if (this.fnF != null && this.bgN != null) {
            this.bgN.wu();
            if (z) {
                this.bgN.setText(this.abI.getString(d.j.list_no_more));
            } else {
                this.bgN.setText("");
            }
        }
    }

    public void a(boolean z, List<com.baidu.adp.widget.ListView.f> list) {
        if (this.fnF != null && this.bgN != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    abo();
                    return;
                } else if ((list.get(i) instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                    abo();
                    return;
                }
            }
            this.bgN.wu();
            if (z) {
                this.bgN.setText(this.abI.getString(d.j.list_no_more));
            } else {
                this.bgN.setText("");
            }
        }
    }

    public void abo() {
        if (this.fnF != null && this.bgN != null) {
            this.fnF.setNextPage(null);
            this.bgN.wx();
        }
    }

    public void qE(int i) {
        if (i == 0) {
            this.bgN.dx(d.C0080d.cp_bg_line_d);
            this.bgN.dt(d.C0080d.cp_bg_line_e);
            this.bgN.dw(d.C0080d.cp_cont_e);
            this.bgN.wp();
        } else if (i == 1) {
            this.bgN.dx(d.C0080d.cp_bg_line_c);
            this.bgN.dw(d.C0080d.cp_cont_d);
            this.bgN.wq();
        }
        this.bgN.dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void cG(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fnF.getVisibility() != 0) {
            this.fnF.setVisibility(0);
        }
        this.fnF.setData(list);
    }

    public void aZI() {
        if (ac.fS()) {
            if (this.fnH == null) {
                this.fnH = new ImageView(this.abI.getPageActivity());
                this.fnH.setImageResource(d.f.icon_nichengjun);
                this.fnH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(d.this.abI.getPageActivity(), null, com.baidu.tieba.pb.c.aPy(), true)));
                    }
                });
            }
            if (this.fnH.getParent() != null) {
                ((ViewGroup) this.fnH.getParent()).removeView(this.fnH);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.f(this.abI.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.f(this.abI.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fnH, layoutParams);
            }
        } else if (this.fnH != null && this.fnH.getParent() != null && this.fnH.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fnH);
        }
    }

    public void e(UserData userData) {
        this.fnJ.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Es().fh(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.abI.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.abI.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fnI.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fJ().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fnL.eGG = userData;
    }

    public void u(float f) {
        if (!this.fnK.isShown()) {
            this.fnK.setVisibility(0);
            this.fnK.setImageDrawable(this.abI.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cRd, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fnK.startAnimation(rotateAnimation);
        this.cRd = f;
    }

    public void aox() {
        this.fnK.clearAnimation();
        this.fnK.setImageDrawable(null);
        this.fnK.setVisibility(8);
    }

    public void kU() {
        if (!this.fnK.isShown()) {
            this.fnK.setVisibility(0);
            this.fnK.setImageDrawable(this.abI.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fnK.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
