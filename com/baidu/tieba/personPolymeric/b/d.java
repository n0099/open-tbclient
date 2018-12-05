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
    private com.baidu.tbadk.k.f bKv;
    private NoNetworkView bOx;
    public PbListView bOy;
    private PluginErrorTipView doq;
    protected View gwA;
    private ImageView gwB;
    protected NavigationBar gwD;
    protected RelativeLayout gwE;
    protected BdPersonListView gww;
    private b gwx;
    private ImageView gwy;
    protected PersonExpandImageView gwz;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float ecO = 360.0f;
    private a gwC = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gwz);
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
            this.gww = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.doq = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gwD = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.gwE = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bOy = new PbListView(this.mContext.getPageActivity());
            this.bOy.getView();
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOy.ew(e.d.cp_cont_e);
            this.bOy.ex(e.d.cp_bg_line_d);
            this.bOy.setHeight(l.h(this.mContext.getPageActivity(), e.C0210e.ds140));
            this.bOy.eu(l.h(this.mContext.getPageActivity(), e.C0210e.ds12));
            this.bOy.EY();
            this.bOy.et(e.d.cp_bg_line_e);
            this.gww.setNextPage(this.bOy);
            this.gwz = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.gwz.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds496));
            this.gwA = view.findViewById(e.g.view_top_background_cover);
            this.gwA.setVisibility(8);
            this.gww.setOuterExpandView(this.gwz);
            this.gwB = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.gwC.gwH = gVar;
            view.setOnClickListener(this.gwC);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fPU;
        private com.baidu.tieba.personPolymeric.event.b gwG = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g gwH;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").aA("obj_locate", "3"));
            this.gwG.dqN = 10;
            this.gwG.dqO = new Bundle();
            this.gwG.dqO.putSerializable(UserData.TYPE_USER, this.fPU);
            if (this.gwH != null) {
                this.gwH.a(view, this.gwG);
            }
        }
    }

    public void mh(boolean z) {
        this.gwE.setVisibility(8);
        this.gwD.setVisibility(0);
        this.gwD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.gwD.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.gwD.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.gwD.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aD(null, this.mContext.getString(e.j.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), e.d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aKb() {
        if (this.mRootView != null) {
            this.gww.setVisibility(8);
            if (this.gwy != null) {
                this.gwy.setVisibility(8);
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
            this.gwD.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
            if (this.gww.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.gww.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bOx.onChangeSkinType(this.mContext, i);
            this.doq.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.gwx = bVar;
    }

    public void aaY() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void i(boolean z, int i) {
        if (this.bKv == null) {
            if (i < 0) {
                this.bKv = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bKv = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bKv.onChangeSkinType();
        }
        this.bKv.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bKv != null) {
            this.bKv.dettachView(this.mRootView);
            this.bKv = null;
        }
    }

    public void mi(boolean z) {
        if (z) {
            bpX();
        }
    }

    public void tf(int i) {
        this.gww.setVisibility(i);
    }

    public void O(String str, boolean z) {
        if (!aKa()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            d.this.aaY();
                            d.this.mi(true);
                            if (d.this.gwx != null) {
                                d.this.gwx.bI(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.gd(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds280));
            this.refreshView.in(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.NL();
            this.refreshView.onChangeSkinType();
            this.gww.setVisibility(8);
            if (this.gwy != null) {
                this.gwy.setVisibility(8);
            }
        }
    }

    public boolean aKa() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void Fc() {
        if (this.bOy != null) {
            this.bOy.Fc();
        }
    }

    public void Fd() {
        if (this.bOy != null) {
            this.bOy.Fd();
        }
    }

    public void fD(boolean z) {
        if (this.gww != null && this.bOy != null) {
            this.bOy.Fd();
            if (z) {
                this.bOy.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bOy.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.gww != null && this.bOy != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    abb();
                    return;
                }
            }
            this.bOy.Fd();
            if (z) {
                this.bOy.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bOy.setText("");
            }
        }
    }

    public void abb() {
        if (this.gww != null && this.bOy != null) {
            this.gww.setNextPage(null);
            this.bOy.hideEmptyView();
        }
    }

    public void tg(int i) {
        if (i == 0) {
            this.bOy.ex(e.d.cp_bg_line_d);
            this.bOy.et(e.d.cp_bg_line_e);
            this.bOy.ew(e.d.cp_cont_e);
            this.bOy.EY();
        } else if (i == 1) {
            this.bOy.ex(e.d.cp_bg_line_c);
            this.bOy.ew(e.d.cp_cont_d);
            this.bOy.EZ();
        }
        this.bOy.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dt(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gww.getVisibility() != 0) {
            this.gww.setVisibility(0);
        }
        this.gww.setData(list);
    }

    public void bpX() {
        if (an.jJ()) {
            if (this.gwy == null) {
                this.gwy = new ImageView(this.mContext.getPageActivity());
                this.gwy.setImageResource(e.f.icon_nichengjun);
                this.gwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bfT(), true)));
                    }
                });
            }
            if (this.gwy.getParent() != null) {
                ((ViewGroup) this.gwy.getParent()).removeView(this.gwy);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gwy, layoutParams);
            }
        } else if (this.gwy != null && this.gwy.getParent() != null && this.gwy.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gwy);
        }
    }

    public void f(UserData userData) {
        this.gwA.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Nu().ga(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gwz.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jA().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gwC.fPU = userData;
    }

    public void M(float f) {
        if (!this.gwB.isShown()) {
            this.gwB.setVisibility(0);
            this.gwB.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ecO, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gwB.startAnimation(rotateAnimation);
        this.ecO = f;
    }

    public void aGO() {
        this.gwB.clearAnimation();
        this.gwB.setImageDrawable(null);
        this.gwB.setVisibility(8);
    }

    public void oB() {
        if (!this.gwB.isShown()) {
            this.gwB.setVisibility(0);
            this.gwB.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.gwB.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
