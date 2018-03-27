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
    protected TbPageContext aRI;
    private com.baidu.tbadk.j.f bXd;
    private NoNetworkView cba;
    public PbListView cbb;
    private PluginErrorTipView dpm;
    protected BdPersonListView gnZ;
    private b goa;
    private ImageView gob;
    protected PersonExpandImageView goc;
    protected View goe;
    private ImageView gof;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.h mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dUP = 360.0f;
    private a gog = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.goc);
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
            this.aRI = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.gnZ = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.dpm = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.cbb = new PbListView(this.aRI.getPageActivity());
            this.cbb.getView();
            this.cbb.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.cbb.gv(d.C0141d.cp_cont_e);
            this.cbb.gw(d.C0141d.cp_bg_line_d);
            this.cbb.setHeight(l.t(this.aRI.getPageActivity(), d.e.ds140));
            this.cbb.gt(l.t(this.aRI.getPageActivity(), d.e.ds12));
            this.cbb.Ec();
            this.cbb.gs(d.C0141d.cp_bg_line_e);
            this.gnZ.setNextPage(this.cbb);
            this.goc = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.goc.setInitHeight(this.aRI.getResources().getDimensionPixelSize(d.e.tbds496));
            this.goe = view.findViewById(d.g.view_top_background_cover);
            this.goe.setVisibility(8);
            this.gnZ.setOuterExpandView(this.goc);
            this.gof = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.i iVar) {
        if (view != null && iVar != null) {
            this.gog.goj = iVar;
            view.setOnClickListener(this.gog);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fHq;
        private com.baidu.tieba.personPolymeric.event.b goi = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.i goj;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ab("obj_locate", "3"));
            this.goi.dro = 10;
            this.goi.drp = new Bundle();
            this.goi.drp.putSerializable(UserData.TYPE_USER, this.fHq);
            if (this.goj != null) {
                this.goj.a(view, this.goi);
            }
        }
    }

    public void aCh() {
        if (this.mRootView != null) {
            this.gnZ.setVisibility(8);
            if (this.gob != null) {
                this.gob.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRI.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ay.aY(d.this.aRI.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRI.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ay.aZ(d.this.aRI.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aRI.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.aRI.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.aRI.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.aRI.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.aRI.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aRI.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aRI.getString(d.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRI.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ay.aZ(d.this.aRI.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRI, i);
        }
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        if (this.gnZ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gnZ.getAdapter().notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.cba.onChangeSkinType(this.aRI, i);
        this.dpm.onChangeSkinType(this.aRI, i);
    }

    public void a(b bVar) {
        this.goa = bVar;
    }

    public void XN() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
        }
    }

    public void k(boolean z, int i) {
        if (this.bXd == null) {
            if (i < 0) {
                this.bXd = new com.baidu.tbadk.j.f(this.aRI.getContext());
            } else {
                this.bXd = new com.baidu.tbadk.j.f(this.aRI.getContext(), i);
            }
            this.bXd.onChangeSkinType();
        }
        this.bXd.j(this.mRootView, z);
    }

    public void VV() {
        if (this.bXd != null) {
            this.bXd.bk(this.mRootView);
            this.bXd = null;
        }
    }

    public void lE(boolean z) {
        if (z) {
            bjY();
        }
    }

    public void tL(int i) {
        this.gnZ.setVisibility(i);
    }

    public void H(String str, boolean z) {
        if (!aCg()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.aRI.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.ox()) {
                            d.this.XN();
                            d.this.lE(true);
                            if (d.this.goa != null) {
                                d.this.goa.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ib(this.aRI.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.gW(str);
            this.refreshView.j(this.mRootView, z);
            this.refreshView.MR();
            this.refreshView.onChangeSkinType();
            this.gnZ.setVisibility(8);
            if (this.gob != null) {
                this.gob.setVisibility(8);
            }
        }
    }

    public boolean aCg() {
        if (this.refreshView != null) {
            return this.refreshView.MJ();
        }
        return false;
    }

    public void Eg() {
        if (this.cbb != null) {
            this.cbb.Eg();
        }
    }

    public void Eh() {
        if (this.cbb != null) {
            this.cbb.Eh();
        }
    }

    public void eX(boolean z) {
        if (this.gnZ != null && this.cbb != null) {
            this.cbb.Eh();
            if (z) {
                this.cbb.setText(this.aRI.getString(d.j.list_no_more));
            } else {
                this.cbb.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.i> list) {
        if (this.gnZ != null && this.cbb != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    XQ();
                    return;
                }
            }
            this.cbb.Eh();
            if (z) {
                this.cbb.setText(this.aRI.getString(d.j.list_no_more));
            } else {
                this.cbb.setText("");
            }
        }
    }

    public void XQ() {
        if (this.gnZ != null && this.cbb != null) {
            this.gnZ.setNextPage(null);
            this.cbb.Ej();
        }
    }

    public void tM(int i) {
        if (i == 0) {
            this.cbb.gw(d.C0141d.cp_bg_line_d);
            this.cbb.gs(d.C0141d.cp_bg_line_e);
            this.cbb.gv(d.C0141d.cp_cont_e);
            this.cbb.Ec();
        } else if (i == 1) {
            this.cbb.gw(d.C0141d.cp_bg_line_c);
            this.cbb.gv(d.C0141d.cp_cont_d);
            this.cbb.Ed();
        }
        this.cbb.gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dc(List<com.baidu.adp.widget.ListView.i> list) {
        if (v.E(list)) {
            list = new ArrayList<>();
        }
        if (this.gnZ.getVisibility() != 0) {
            this.gnZ.setVisibility(0);
        }
        this.gnZ.setData(list);
    }

    public void bjY() {
        if (af.nv()) {
            if (this.gob == null) {
                this.gob = new ImageView(this.aRI.getPageActivity());
                this.gob.setImageResource(d.f.icon_nichengjun);
                this.gob.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.aRI.getPageActivity(), null, com.baidu.tieba.pb.c.bab(), true)));
                    }
                });
            }
            if (this.gob.getParent() != null) {
                ((ViewGroup) this.gob.getParent()).removeView(this.gob);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.t(this.aRI.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.t(this.aRI.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gob, layoutParams);
            }
        } else if (this.gob != null && this.gob.getParent() != null && this.gob.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gob);
        }
    }

    public void f(UserData userData) {
        this.goe.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Mx().hY(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.aRI.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.aRI.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.goc.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.nm().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gog.fHq = userData;
    }

    public void O(float f) {
        if (!this.gof.isShown()) {
            this.gof.setVisibility(0);
            this.gof.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dUP, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gof.startAnimation(rotateAnimation);
        this.dUP = f;
    }

    public void azU() {
        this.gof.clearAnimation();
        this.gof.setImageDrawable(null);
        this.gof.setVisibility(8);
    }

    public void sr() {
        if (!this.gof.isShown()) {
            this.gof.setVisibility(0);
            this.gof.setImageDrawable(this.aRI.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.gof.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.aRI.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
