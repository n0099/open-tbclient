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
    private com.baidu.tbadk.k.f bKy;
    private NoNetworkView bOA;
    public PbListView bOB;
    private PluginErrorTipView drg;
    protected BdPersonListView gzn;
    private b gzo;
    private ImageView gzp;
    protected PersonExpandImageView gzq;
    protected View gzr;
    private ImageView gzs;
    protected NavigationBar gzu;
    protected RelativeLayout gzv;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.k.g refreshView;
    private float efF = 360.0f;
    private a gzt = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.gzq);
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
            this.gzn = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
            this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
            this.drg = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gzu = (NavigationBar) this.mRootView.findViewById(e.g.person_center_anti_navigation_bar);
            this.gzv = (RelativeLayout) this.mRootView.findViewById(e.g.person_center_noanti_rootview);
            this.bOB = new PbListView(this.mContext.getPageActivity());
            this.bOB.getView();
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
            this.bOB.ew(e.d.cp_cont_e);
            this.bOB.ex(e.d.cp_bg_line_d);
            this.bOB.setHeight(l.h(this.mContext.getPageActivity(), e.C0210e.ds140));
            this.bOB.eu(l.h(this.mContext.getPageActivity(), e.C0210e.ds12));
            this.bOB.EY();
            this.bOB.et(e.d.cp_bg_line_e);
            this.gzn.setNextPage(this.bOB);
            this.gzq = (PersonExpandImageView) this.mRootView.findViewById(e.g.person_polymeric_header_expand_img);
            this.gzq.setInitHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds496));
            this.gzr = view.findViewById(e.g.view_top_background_cover);
            this.gzr.setVisibility(8);
            this.gzn.setOuterExpandView(this.gzq);
            this.gzs = (ImageView) this.mRootView.findViewById(e.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.gzt.gzy = gVar;
            view.setOnClickListener(this.gzt);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public UserData fSM;
        private com.baidu.tieba.personPolymeric.event.b gzx = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g gzy;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").aA("obj_locate", "3"));
            this.gzx.dtB = 10;
            this.gzx.dtC = new Bundle();
            this.gzx.dtC.putSerializable(UserData.TYPE_USER, this.fSM);
            if (this.gzy != null) {
                this.gzy.a(view, this.gzx);
            }
        }
    }

    public void mk(boolean z) {
        this.gzv.setVisibility(8);
        this.gzu.setVisibility(0);
        this.gzu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.gzu.setCenterTextTitle(this.mContext.getString(e.j.ta_homepage));
        } else {
            this.gzu.setCenterTextTitle(this.mContext.getString(e.j.my_homepage));
        }
        this.gzu.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.aD(null, this.mContext.getString(e.j.user_to_anti)), null);
        }
        al.h(this.mNoDataView.getSuTextView(), e.d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void aKQ() {
        if (this.mRootView != null) {
            this.gzn.setVisibility(8);
            if (this.gzp != null) {
                this.gzp.setVisibility(8);
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
            this.gzu.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
            if (this.gzn.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.gzn.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.bOA.onChangeSkinType(this.mContext, i);
            this.drg.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.gzo = bVar;
    }

    public void aba() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void i(boolean z, int i) {
        if (this.bKy == null) {
            if (i < 0) {
                this.bKy = new com.baidu.tbadk.k.f(this.mContext.getContext());
            } else {
                this.bKy = new com.baidu.tbadk.k.f(this.mContext.getContext(), i);
            }
            this.bKy.onChangeSkinType();
        }
        this.bKy.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.bKy != null) {
            this.bKy.dettachView(this.mRootView);
            this.bKy = null;
        }
    }

    public void ml(boolean z) {
        if (z) {
            bqI();
        }
    }

    public void ts(int i) {
        this.gzn.setVisibility(i);
    }

    public void O(String str, boolean z) {
        if (!aKP()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            d.this.aba();
                            d.this.ml(true);
                            if (d.this.gzo != null) {
                                d.this.gzo.bL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ge(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds280));
            this.refreshView.io(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.NM();
            this.refreshView.onChangeSkinType();
            this.gzn.setVisibility(8);
            if (this.gzp != null) {
                this.gzp.setVisibility(8);
            }
        }
    }

    public boolean aKP() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void Fc() {
        if (this.bOB != null) {
            this.bOB.Fc();
        }
    }

    public void Fd() {
        if (this.bOB != null) {
            this.bOB.Fd();
        }
    }

    public void fF(boolean z) {
        if (this.gzn != null && this.bOB != null) {
            this.bOB.Fd();
            if (z) {
                this.bOB.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bOB.setText("");
            }
        }
    }

    public void c(boolean z, List<com.baidu.adp.widget.ListView.h> list) {
        if (this.gzn != null && this.bOB != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    abd();
                    return;
                }
            }
            this.bOB.Fd();
            if (z) {
                this.bOB.setText(this.mContext.getString(e.j.list_no_more));
            } else {
                this.bOB.setText("");
            }
        }
    }

    public void abd() {
        if (this.gzn != null && this.bOB != null) {
            this.gzn.setNextPage(null);
            this.bOB.hideEmptyView();
        }
    }

    public void tt(int i) {
        if (i == 0) {
            this.bOB.ex(e.d.cp_bg_line_d);
            this.bOB.et(e.d.cp_bg_line_e);
            this.bOB.ew(e.d.cp_cont_e);
            this.bOB.EY();
        } else if (i == 1) {
            this.bOB.ex(e.d.cp_bg_line_c);
            this.bOB.ew(e.d.cp_cont_d);
            this.bOB.EZ();
        }
        this.bOB.ey(TbadkCoreApplication.getInst().getSkinType());
    }

    public void du(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gzn.getVisibility() != 0) {
            this.gzn.setVisibility(0);
        }
        this.gzn.setData(list);
    }

    public void bqI() {
        if (an.jJ()) {
            if (this.gzp == null) {
                this.gzp = new ImageView(this.mContext.getPageActivity());
                this.gzp.setImageResource(e.f.icon_nichengjun);
                this.gzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bgE(), true)));
                    }
                });
            }
            if (this.gzp.getParent() != null) {
                ((ViewGroup) this.gzp.getParent()).removeView(this.gzp);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), e.C0210e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.gzp, layoutParams);
            }
        } else if (this.gzp != null && this.gzp.getParent() != null && this.gzp.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.gzp);
        }
    }

    public void f(UserData userData) {
        this.gzr.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Nv().gb(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), e.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gzq.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jA().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.gzt.fSM = userData;
    }

    public void M(float f) {
        if (!this.gzs.isShown()) {
            this.gzs.setVisibility(0);
            this.gzs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.efF, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.gzs.startAnimation(rotateAnimation);
        this.efF = f;
    }

    public void aHD() {
        this.gzs.clearAnimation();
        this.gzs.setImageDrawable(null);
        this.gzs.setVisibility(8);
    }

    public void oB() {
        if (!this.gzs.isShown()) {
            this.gzs.setVisibility(0);
            this.gzs.setImageDrawable(this.mContext.getResources().getDrawable(e.f.icon_pop_refresh));
        }
        this.gzs.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.user_info_center_head_rotate));
    }
}
