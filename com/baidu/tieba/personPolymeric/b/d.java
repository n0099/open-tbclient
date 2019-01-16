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
    private com.baidu.tbadk.k.f bLl;
    private NoNetworkView bPl;
    public PbListView bPm;
    private PluginErrorTipView drP;
    protected BdPersonListView gAr;
    private b gAs;
    private ImageView gAt;
    protected PersonExpandImageView gAu;
    protected View gAv;
    private ImageView gAw;
    protected NavigationBar gAy;
    protected RelativeLayout gAz;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float egl = 360.0f;
    private a gAx = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gAu);
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
        void bL(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
            this.gAr = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.drP = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gAy = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.gAz = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bPm = new PbListView(this.mContext.getPageActivity());
            this.bPm.getView();
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPm.ew(e.d.cp_cont_e);
            this.bPm.ex(e.d.cp_bg_line_d);
            this.bPm.setHeight(l.h(this.mContext.getPageActivity(), e.C0210e.ds140));
            this.bPm.eu(l.h(this.mContext.getPageActivity(), e.C0210e.ds12));
            this.bPm.Fl();
            this.bPm.et(e.d.cp_bg_line_e);
            this.gAr.setNextPage(this.bPm);
            this.gAu = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.gAu.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds496));
            this.gAv = view.findViewById(e.g.view_top_background_cover);
            this.gAv.setVisibility(8);
            this.gAr.setOuterExpandView(this.gAu);
            this.gAw = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.gAx.gAC = gVar;
            view.setOnClickListener(this.gAx);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fTJ;
        private com.baidu.tieba.personPolymeric.event.b gAB = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g gAC;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").aB("obj_locate", "3"));
            this.gAB.duk = 10;
            this.gAB.dul = new Bundle();
            this.gAB.dul.putSerializable(UserData.TYPE_USER, this.fTJ);
            if (this.gAC != null) {
                this.gAC.a(view, this.gAB);
            }
        }
    }

    public void mk(boolean z) {
        this.gAz.setVisibility(8);
        this.gAy.setVisibility(0);
        this.gAy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.gAy.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.gAy.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.gAy.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aE(null, this.mContext.getString(e.j.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), e.d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aLo() {
        if (this.mRootView != null) {
            this.gAr.setVisibility(8);
            if (this.gAt != null) {
                this.gAt.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bH(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bI(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, e.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.G(e.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(e.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    ba.bI(d.this.mContext.getPageActivity());
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
            this.gAy.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
            if (this.gAr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.gAr.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bPl.onChangeSkinType(this.mContext, i);
            this.drP.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.gAs = bVar;
    }

    public void abx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void i(boolean z, int i) {
        if (this.bLl == null) {
            if (i < 0) {
                this.bLl = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bLl = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bLl.onChangeSkinType();
        }
        this.bLl.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bLl != null) {
            this.bLl.dettachView(this.mRootView);
            this.bLl = null;
        }
    }

    public void ml(boolean z) {
        if (z) {
            brr();
        }
    }

    public void tw(int i) {
        this.gAr.setVisibility(i);
    }

    public void N(String str, boolean z) {
        if (!aLn()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            d.this.abx();
                            d.this.ml(true);
                            if (d.this.gAs != null) {
                                d.this.gAs.bL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ge(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds280));
            this.refreshView.iC(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.Od();
            this.refreshView.onChangeSkinType();
            this.gAr.setVisibility(8);
            if (this.gAt != null) {
                this.gAt.setVisibility(8);
            }
        }
    }

    public boolean aLn() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void Fp() {
        if (this.bPm != null) {
            this.bPm.Fp();
        }
    }

    public void Fq() {
        if (this.bPm != null) {
            this.bPm.Fq();
        }
    }

    public void fI(boolean z) {
        if (this.gAr != null && this.bPm != null) {
            this.bPm.Fq();
            if (z) {
                this.bPm.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bPm.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.gAr != null && this.bPm != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    abA();
                    return;
                }
            }
            this.bPm.Fq();
            if (z) {
                this.bPm.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bPm.setText("");
            }
        }
    }

    public void abA() {
        if (this.gAr != null && this.bPm != null) {
            this.gAr.setNextPage(null);
            this.bPm.hideEmptyView();
        }
    }

    public void tx(int i) {
        if (i == 0) {
            this.bPm.ex(e.d.cp_bg_line_d);
            this.bPm.et(e.d.cp_bg_line_e);
            this.bPm.ew(e.d.cp_cont_e);
            this.bPm.Fl();
        } else if (i == 1) {
            this.bPm.ex(e.d.cp_bg_line_c);
            this.bPm.ew(e.d.cp_cont_d);
            this.bPm.Fm();
        }
        this.bPm.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gAr.getVisibility() != 0) {
            this.gAr.setVisibility(0);
        }
        this.gAr.setData(list);
    }

    public void brr() {
        if (an.jJ()) {
            if (this.gAt == null) {
                this.gAt = new ImageView(this.mContext.getPageActivity());
                this.gAt.setImageResource(e.f.icon_nichengjun);
                this.gAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bhi(), true)));
                    }
                });
            }
            if (this.gAt.getParent() != null) {
                ((ViewGroup) this.gAt.getParent()).removeView(this.gAt);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gAt, layoutParams);
            }
        } else if (this.gAt != null && this.gAt.getParent() != null && this.gAt.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gAt);
        }
    }

    public void f(UserData userData) {
        this.gAv.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.NM().gb(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gAu.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jA().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gAx.fTJ = userData;
    }

    public void M(float f) {
        if (!this.gAw.isShown()) {
            this.gAw.setVisibility(0);
            this.gAw.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.egl, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gAw.startAnimation(rotateAnimation);
        this.egl = f;
    }

    public void aIa() {
        this.gAw.clearAnimation();
        this.gAw.setImageDrawable(null);
        this.gAw.setVisibility(8);
    }

    public void oF() {
        if (!this.gAw.isShown()) {
            this.gAw.setVisibility(0);
            this.gAw.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.gAw.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
