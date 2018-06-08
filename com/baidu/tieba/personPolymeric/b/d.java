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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.o.ah;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.tbadk.j.f bpl;
    private NoNetworkView btu;
    public PbListView btv;
    private PluginErrorTipView cRP;
    protected BdPersonListView fUU;
    private b fUV;
    private ImageView fUW;
    protected PersonExpandImageView fUX;
    protected View fUY;
    private ImageView fUZ;
    protected NavigationBar fVb;
    protected RelativeLayout fVc;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dAh = 360.0f;
    private a fVa = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.fUX);
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
        void bp(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.fUU = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.cRP = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fVb = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.fVc = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.btv = new PbListView(this.mContext.getPageActivity());
            this.btv.getView();
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            this.btv.dw(d.C0141d.cp_cont_e);
            this.btv.dx(d.C0141d.cp_bg_line_d);
            this.btv.setHeight(l.e(this.mContext.getPageActivity(), d.e.ds140));
            this.btv.dv(l.e(this.mContext.getPageActivity(), d.e.ds12));
            this.btv.An();
            this.btv.du(d.C0141d.cp_bg_line_e);
            this.fUU.setNextPage(this.btv);
            this.fUX = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.fUX.setInitHeight(this.mContext.getResources().getDimensionPixelSize(d.e.tbds496));
            this.fUY = view.findViewById(d.g.view_top_background_cover);
            this.fUY.setVisibility(8);
            this.fUU.setOuterExpandView(this.fUX);
            this.fUZ = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.fVa.fVf = gVar;
            view.setOnClickListener(this.fVa);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b fVe = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g fVf;
        public UserData fov;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").ah("obj_locate", "3"));
            this.fVe.cUr = 10;
            this.fVe.cUs = new Bundle();
            this.fVe.cUs.putSerializable(UserData.TYPE_USER, this.fov);
            if (this.fVf != null) {
                this.fVf.a(view, this.fVe);
            }
        }
    }

    public void lk(boolean z) {
        this.fVc.setVisibility(8);
        this.fVb.setVisibility(0);
        this.fVb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.fVb.setCenterTextTitle(this.mContext.getString(d.k.ta_homepage));
        } else {
            this.fVb.setCenterTextTitle(this.mContext.getString(d.k.my_homepage));
        }
        this.fVb.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aj(null, this.mContext.getString(d.k.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), d.C0141d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aBW() {
        if (this.mRootView != null) {
            this.fUU.setVisibility(8);
            if (this.fUW != null) {
                this.fUW.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ba.aS(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ba.aT(d.this.mContext.getPageActivity());
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
                    ba.aT(d.this.mContext.getPageActivity());
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
            al.i(this.mRootView, d.C0141d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.fVb.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.cR(d.f.s_navbar_bg)));
            if (this.fUU.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.fUU.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.btu.onChangeSkinType(this.mContext, i);
            this.cRP.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.fUV = bVar;
    }

    public void TI() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
        }
    }

    public void g(boolean z, int i) {
        if (this.bpl == null) {
            if (i < 0) {
                this.bpl = new com.baidu.tbadk.j.f(this.mContext.getContext());
            } else {
                this.bpl = new com.baidu.tbadk.j.f(this.mContext.getContext(), i);
            }
            this.bpl.onChangeSkinType();
        }
        this.bpl.d(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bpl != null) {
            this.bpl.P(this.mRootView);
            this.bpl = null;
        }
    }

    public void ll(boolean z) {
        if (z) {
            bkb();
        }
    }

    public void rs(int i) {
        this.fUU.setVisibility(i);
    }

    public void E(String str, boolean z) {
        if (!aBV()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.jr()) {
                            d.this.TI();
                            d.this.ll(true);
                            if (d.this.fUV != null) {
                                d.this.fUV.bp(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ff(this.mContext.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.setSubText(str);
            this.refreshView.d(this.mRootView, z);
            this.refreshView.IX();
            this.refreshView.onChangeSkinType();
            this.fUU.setVisibility(8);
            if (this.fUW != null) {
                this.fUW.setVisibility(8);
            }
        }
    }

    public boolean aBV() {
        if (this.refreshView != null) {
            return this.refreshView.IP();
        }
        return false;
    }

    public void Ar() {
        if (this.btv != null) {
            this.btv.Ar();
        }
    }

    public void As() {
        if (this.btv != null) {
            this.btv.As();
        }
    }

    public void eH(boolean z) {
        if (this.fUU != null && this.btv != null) {
            this.btv.As();
            if (z) {
                this.btv.setText(this.mContext.getString(d.k.list_no_more));
            } else {
                this.btv.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.fUU != null && this.btv != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    TL();
                    return;
                }
            }
            this.btv.As();
            if (z) {
                this.btv.setText(this.mContext.getString(d.k.list_no_more));
            } else {
                this.btv.setText("");
            }
        }
    }

    public void TL() {
        if (this.fUU != null && this.btv != null) {
            this.fUU.setNextPage(null);
            this.btv.Av();
        }
    }

    public void rt(int i) {
        if (i == 0) {
            this.btv.dx(d.C0141d.cp_bg_line_d);
            this.btv.du(d.C0141d.cp_bg_line_e);
            this.btv.dw(d.C0141d.cp_cont_e);
            this.btv.An();
        } else if (i == 1) {
            this.btv.dx(d.C0141d.cp_bg_line_c);
            this.btv.dw(d.C0141d.cp_cont_d);
            this.btv.Ao();
        }
        this.btv.dy(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dc(List<com.baidu.adp.widget.ListView.h> list) {
        if (w.z(list)) {
            list = new ArrayList<>();
        }
        if (this.fUU.getVisibility() != 0) {
            this.fUU.setVisibility(0);
        }
        this.fUU.setData(list);
    }

    public void bkb() {
        if (ah.ip()) {
            if (this.fUW == null) {
                this.fUW = new ImageView(this.mContext.getPageActivity());
                this.fUW.setImageResource(d.f.icon_nichengjun);
                this.fUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.aZW(), true)));
                    }
                });
            }
            if (this.fUW.getParent() != null) {
                ((ViewGroup) this.fUW.getParent()).removeView(this.fUW);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.e(this.mContext.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.e(this.mContext.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.fUW, layoutParams);
            }
        } else if (this.fUW != null && this.fUW.getParent() != null && this.fUW.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.fUW);
        }
    }

    public void f(UserData userData) {
        this.fUY.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.ID().fc(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fUX.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.ig().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.fVa.fov = userData;
    }

    public void M(float f) {
        if (!this.fUZ.isShown()) {
            this.fUZ.setVisibility(0);
            this.fUZ.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dAh, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.fUZ.startAnimation(rotateAnimation);
        this.dAh = f;
    }

    public void ayU() {
        this.fUZ.clearAnimation();
        this.fUZ.setImageDrawable(null);
        this.fUZ.setVisibility(8);
    }

    public void nl() {
        if (!this.fUZ.isShown()) {
            this.fUZ.setVisibility(0);
            this.fUZ.setImageDrawable(this.mContext.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.fUZ.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
