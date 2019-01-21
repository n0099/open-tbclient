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
    private com.baidu.tbadk.k.f bLm;
    private NoNetworkView bPm;
    public PbListView bPn;
    private PluginErrorTipView drQ;
    protected RelativeLayout gAA;
    protected BdPersonListView gAs;
    private b gAt;
    private ImageView gAu;
    protected PersonExpandImageView gAv;
    protected View gAw;
    private ImageView gAx;
    protected NavigationBar gAz;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float egm = 360.0f;
    private a gAy = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gAv);
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
            this.gAs = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.drQ = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gAz = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.gAA = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bPn = new PbListView(this.mContext.getPageActivity());
            this.bPn.getView();
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bPn.ew(e.d.cp_cont_e);
            this.bPn.ex(e.d.cp_bg_line_d);
            this.bPn.setHeight(l.h(this.mContext.getPageActivity(), e.C0210e.ds140));
            this.bPn.eu(l.h(this.mContext.getPageActivity(), e.C0210e.ds12));
            this.bPn.Fl();
            this.bPn.et(e.d.cp_bg_line_e);
            this.gAs.setNextPage(this.bPn);
            this.gAv = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.gAv.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds496));
            this.gAw = view.findViewById(e.g.view_top_background_cover);
            this.gAw.setVisibility(8);
            this.gAs.setOuterExpandView(this.gAv);
            this.gAx = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.gAy.gAD = gVar;
            view.setOnClickListener(this.gAy);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fTK;
        private com.baidu.tieba.personPolymeric.event.b gAC = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g gAD;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").aB("obj_locate", "3"));
            this.gAC.dul = 10;
            this.gAC.dum = new Bundle();
            this.gAC.dum.putSerializable(UserData.TYPE_USER, this.fTK);
            if (this.gAD != null) {
                this.gAD.a(view, this.gAC);
            }
        }
    }

    public void mk(boolean z) {
        this.gAA.setVisibility(8);
        this.gAz.setVisibility(0);
        this.gAz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.gAz.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.gAz.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.gAz.showBottomLine();
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
            this.gAs.setVisibility(8);
            if (this.gAu != null) {
                this.gAu.setVisibility(8);
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
            this.gAz.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
            if (this.gAs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.gAs.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bPm.onChangeSkinType(this.mContext, i);
            this.drQ.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.gAt = bVar;
    }

    public void abx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void i(boolean z, int i) {
        if (this.bLm == null) {
            if (i < 0) {
                this.bLm = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bLm = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bLm.onChangeSkinType();
        }
        this.bLm.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bLm != null) {
            this.bLm.dettachView(this.mRootView);
            this.bLm = null;
        }
    }

    public void ml(boolean z) {
        if (z) {
            brr();
        }
    }

    public void tw(int i) {
        this.gAs.setVisibility(i);
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
                            if (d.this.gAt != null) {
                                d.this.gAt.bL(view);
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
            this.gAs.setVisibility(8);
            if (this.gAu != null) {
                this.gAu.setVisibility(8);
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
        if (this.bPn != null) {
            this.bPn.Fp();
        }
    }

    public void Fq() {
        if (this.bPn != null) {
            this.bPn.Fq();
        }
    }

    public void fI(boolean z) {
        if (this.gAs != null && this.bPn != null) {
            this.bPn.Fq();
            if (z) {
                this.bPn.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bPn.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.gAs != null && this.bPn != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    abA();
                    return;
                }
            }
            this.bPn.Fq();
            if (z) {
                this.bPn.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bPn.setText("");
            }
        }
    }

    public void abA() {
        if (this.gAs != null && this.bPn != null) {
            this.gAs.setNextPage(null);
            this.bPn.hideEmptyView();
        }
    }

    public void tx(int i) {
        if (i == 0) {
            this.bPn.ex(e.d.cp_bg_line_d);
            this.bPn.et(e.d.cp_bg_line_e);
            this.bPn.ew(e.d.cp_cont_e);
            this.bPn.Fl();
        } else if (i == 1) {
            this.bPn.ex(e.d.cp_bg_line_c);
            this.bPn.ew(e.d.cp_cont_d);
            this.bPn.Fm();
        }
        this.bPn.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gAs.getVisibility() != 0) {
            this.gAs.setVisibility(0);
        }
        this.gAs.setData(list);
    }

    public void brr() {
        if (an.jJ()) {
            if (this.gAu == null) {
                this.gAu = new ImageView(this.mContext.getPageActivity());
                this.gAu.setImageResource(e.f.icon_nichengjun);
                this.gAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bhi(), true)));
                    }
                });
            }
            if (this.gAu.getParent() != null) {
                ((ViewGroup) this.gAu.getParent()).removeView(this.gAu);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gAu, layoutParams);
            }
        } else if (this.gAu != null && this.gAu.getParent() != null && this.gAu.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gAu);
        }
    }

    public void f(UserData userData) {
        this.gAw.setVisibility(0);
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
                this.gAv.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jA().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gAy.fTK = userData;
    }

    public void M(float f) {
        if (!this.gAx.isShown()) {
            this.gAx.setVisibility(0);
            this.gAx.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.egm, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gAx.startAnimation(rotateAnimation);
        this.egm = f;
    }

    public void aIa() {
        this.gAx.clearAnimation();
        this.gAx.setImageDrawable(null);
        this.gAx.setVisibility(8);
    }

    public void oF() {
        if (!this.gAx.isShown()) {
            this.gAx.setVisibility(0);
            this.gAx.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.gAx.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
