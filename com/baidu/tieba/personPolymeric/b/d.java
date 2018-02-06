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
    protected TbPageContext aRR;
    private com.baidu.tbadk.j.f bXm;
    private NoNetworkView cbj;
    public PbListView cbk;
    private PluginErrorTipView dpv;
    protected BdPersonListView gnU;
    private b gnV;
    private ImageView gnW;
    protected PersonExpandImageView gnX;
    protected View gnY;
    private ImageView gnZ;
    protected NavigationBar mNavigationBar;
    protected com.baidu.tbadk.core.view.h mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.j.g refreshView;
    private float dUW = 360.0f;
    private a goa = new a();
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gnX);
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
            this.aRR = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.gnU = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.dpv = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.cbk = new PbListView(this.aRR.getPageActivity());
            this.cbk.getView();
            this.cbk.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            this.cbk.gv(d.C0140d.cp_cont_e);
            this.cbk.gw(d.C0140d.cp_bg_line_d);
            this.cbk.setHeight(l.t(this.aRR.getPageActivity(), d.e.ds140));
            this.cbk.gt(l.t(this.aRR.getPageActivity(), d.e.ds12));
            this.cbk.Ec();
            this.cbk.gs(d.C0140d.cp_bg_line_e);
            this.gnU.setNextPage(this.cbk);
            this.gnX = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.gnX.setInitHeight(this.aRR.getResources().getDimensionPixelSize(d.e.tbds496));
            this.gnY = view.findViewById(d.g.view_top_background_cover);
            this.gnY.setVisibility(8);
            this.gnU.setOuterExpandView(this.gnX);
            this.gnZ = (ImageView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.i iVar) {
        if (view != null && iVar != null) {
            this.goa.goe = iVar;
            view.setOnClickListener(this.goa);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fHl;
        private com.baidu.tieba.personPolymeric.event.b goc = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.i goe;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new ak("c12502").ab("obj_locate", "3"));
            this.goc.drx = 10;
            this.goc.dry = new Bundle();
            this.goc.dry.putSerializable(UserData.TYPE_USER, this.fHl);
            if (this.goe != null) {
                this.goe.a(view, this.goc);
            }
        }
    }

    public void aCh() {
        if (this.mRootView != null) {
            this.gnU.setVisibility(8);
            if (this.gnW != null) {
                this.gnW.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRR.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    ay.aY(d.this.aRR.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRR.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    ay.aZ(d.this.aRR.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.aRR.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.aRR.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.aRR.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.aRR.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.aRR.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aRR.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aB(d.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aRR.getString(d.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.aRR.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    ay.aZ(d.this.aRR.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aRR, i);
        }
        aj.s(this.mRootView, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        if (this.gnU.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gnU.getAdapter().notifyDataSetChanged();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        this.cbj.onChangeSkinType(this.aRR, i);
        this.dpv.onChangeSkinType(this.aRR, i);
    }

    public void a(b bVar) {
        this.gnV = bVar;
    }

    public void XN() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
        }
    }

    public void k(boolean z, int i) {
        if (this.bXm == null) {
            if (i < 0) {
                this.bXm = new com.baidu.tbadk.j.f(this.aRR.getContext());
            } else {
                this.bXm = new com.baidu.tbadk.j.f(this.aRR.getContext(), i);
            }
            this.bXm.onChangeSkinType();
        }
        this.bXm.j(this.mRootView, z);
    }

    public void VV() {
        if (this.bXm != null) {
            this.bXm.bk(this.mRootView);
            this.bXm = null;
        }
    }

    public void lz(boolean z) {
        if (z) {
            bjY();
        }
    }

    public void tK(int i) {
        this.gnU.setVisibility(i);
    }

    public void I(String str, boolean z) {
        if (!aCg()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.aRR.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.ox()) {
                            d.this.XN();
                            d.this.lz(true);
                            if (d.this.gnV != null) {
                                d.this.gnV.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ib(this.aRR.getResources().getDimensionPixelSize(d.e.ds280));
            this.refreshView.gW(str);
            this.refreshView.j(this.mRootView, z);
            this.refreshView.MR();
            this.refreshView.onChangeSkinType();
            this.gnU.setVisibility(8);
            if (this.gnW != null) {
                this.gnW.setVisibility(8);
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
        if (this.cbk != null) {
            this.cbk.Eg();
        }
    }

    public void Eh() {
        if (this.cbk != null) {
            this.cbk.Eh();
        }
    }

    public void eX(boolean z) {
        if (this.gnU != null && this.cbk != null) {
            this.cbk.Eh();
            if (z) {
                this.cbk.setText(this.aRR.getString(d.j.list_no_more));
            } else {
                this.cbk.setText("");
            }
        }
    }

    public void b(boolean z, List<com.baidu.adp.widget.ListView.i> list) {
        if (this.gnU != null && this.cbk != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    XQ();
                    return;
                }
            }
            this.cbk.Eh();
            if (z) {
                this.cbk.setText(this.aRR.getString(d.j.list_no_more));
            } else {
                this.cbk.setText("");
            }
        }
    }

    public void XQ() {
        if (this.gnU != null && this.cbk != null) {
            this.gnU.setNextPage(null);
            this.cbk.Ej();
        }
    }

    public void tL(int i) {
        if (i == 0) {
            this.cbk.gw(d.C0140d.cp_bg_line_d);
            this.cbk.gs(d.C0140d.cp_bg_line_e);
            this.cbk.gv(d.C0140d.cp_cont_e);
            this.cbk.Ec();
        } else if (i == 1) {
            this.cbk.gw(d.C0140d.cp_bg_line_c);
            this.cbk.gv(d.C0140d.cp_cont_d);
            this.cbk.Ed();
        }
        this.cbk.gx(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dc(List<com.baidu.adp.widget.ListView.i> list) {
        if (v.E(list)) {
            list = new ArrayList<>();
        }
        if (this.gnU.getVisibility() != 0) {
            this.gnU.setVisibility(0);
        }
        this.gnU.setData(list);
    }

    public void bjY() {
        if (af.nv()) {
            if (this.gnW == null) {
                this.gnW = new ImageView(this.aRR.getPageActivity());
                this.gnW.setImageResource(d.f.icon_nichengjun);
                this.gnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.aRR.getPageActivity(), null, com.baidu.tieba.pb.c.bab(), true)));
                    }
                });
            }
            if (this.gnW.getParent() != null) {
                ((ViewGroup) this.gnW.getParent()).removeView(this.gnW);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.t(this.aRR.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.t(this.aRR.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gnW, layoutParams);
            }
        } else if (this.gnW != null && this.gnW.getParent() != null && this.gnW.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gnW);
        }
    }

    public void f(UserData userData) {
        this.gnY.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Mx().hY(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.aRR.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.aRR.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gnX.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.nm().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.goa.fHl = userData;
    }

    public void O(float f) {
        if (!this.gnZ.isShown()) {
            this.gnZ.setVisibility(0);
            this.gnZ.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dUW, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gnZ.startAnimation(rotateAnimation);
        this.dUW = f;
    }

    public void azT() {
        this.gnZ.clearAnimation();
        this.gnZ.setImageDrawable(null);
        this.gnZ.setVisibility(8);
    }

    public void sr() {
        if (!this.gnZ.isShown()) {
            this.gnZ.setVisibility(0);
            this.gnZ.setImageDrawable(this.aRR.getResources().getDrawable(d.f.icon_pop_refresh));
        }
        this.gnZ.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.user_info_center_head_rotate));
    }
}
