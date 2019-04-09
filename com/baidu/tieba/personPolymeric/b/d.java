package com.baidu.tieba.personPolymeric.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.s.ao;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tbadk.m.g cXq;
    private NoNetworkView dbr;
    public PbListView dbs;
    private PluginErrorTipView eCg;
    protected BdPersonListView hQe;
    private b hQf;
    private ImageView hQg;
    protected PersonExpandImageView hQh;
    protected View hQi;
    private ContinuousAnimationView hQj;
    protected NavigationBar hQl;
    protected RelativeLayout hQm;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private Rect rect;
    private com.baidu.tbadk.m.h refreshView;
    private float fuZ = 360.0f;
    private a hQk = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.hQh);
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

    /* loaded from: classes6.dex */
    public interface b {
        void cy(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
            this.hQe = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.eCg = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.hQl = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.hQm = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.dbs = new PbListView(this.mContext.getPageActivity());
            this.dbs.getView();
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbs.hZ(d.C0277d.cp_cont_e);
            this.dbs.ia(d.C0277d.cp_bg_line_d);
            this.dbs.setHeight(l.h(this.mContext.getPageActivity(), d.e.ds140));
            this.dbs.hX(l.h(this.mContext.getPageActivity(), d.e.ds12));
            this.dbs.aev();
            this.dbs.hW(d.C0277d.cp_bg_line_e);
            this.hQe.setNextPage(this.dbs);
            this.hQh = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.hQh.setInitHeight(this.mContext.getResources().getDimensionPixelSize(d.e.tbds496));
            this.hQi = view.findViewById(d.g.view_top_background_cover);
            this.hQi.setVisibility(8);
            this.hQe.setOuterExpandView(this.hQh);
            this.hQj = (ContinuousAnimationView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.hQk.hQp = gVar;
            view.setOnClickListener(this.hQk);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b hQo = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g hQp;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").bJ("obj_locate", "3"));
            this.hQo.eHl = 10;
            this.hQo.eHm = new Bundle();
            this.hQo.eHm.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.hQp != null) {
                this.hQp.a(view, this.hQo);
            }
        }
    }

    public void oH(boolean z) {
        this.hQm.setVisibility(8);
        this.hQl.setVisibility(0);
        this.hQl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.hQl.setCenterTextTitle(this.mContext.getString(d.j.ta_homepage));
        } else {
            this.hQl.setCenterTextTitle(this.mContext.getString(d.j.my_homepage));
        }
        this.hQl.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bM(null, this.mContext.getString(d.j.user_to_anti)), null);
        }
        al.j(this.mNoDataView.getSuTextView(), d.C0277d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void blp() {
        if (this.mRootView != null) {
            this.hQe.setVisibility(8);
            if (this.hQg != null) {
                this.hQg.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bc.cX(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cY(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(d.e.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(d.e.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(d.e.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(d.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(d.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(d.j.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.cY(d.this.mContext.getPageActivity());
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
            al.k(this.mRootView, d.C0277d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.hQl.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
            if (this.hQe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.hQe.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dbr.onChangeSkinType(this.mContext, i);
            this.eCg.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.hQf = bVar;
    }

    public void aBq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.cXq == null) {
            if (i < 0) {
                this.cXq = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.cXq = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.cXq.onChangeSkinType();
        }
        this.cXq.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this.mRootView);
            this.cXq = null;
        }
    }

    public void oI(boolean z) {
        if (z) {
            bRL();
        }
    }

    public void xb(int i) {
        this.hQe.setVisibility(i);
    }

    private int bRK() {
        if (this.rect == null) {
            this.rect = new Rect();
        }
        if (this.hQh == null) {
            return l.h(TbadkCoreApplication.getInst(), d.e.ds280);
        }
        this.hQh.getLocalVisibleRect(this.rect);
        if (this.rect.bottom > 0) {
            return this.rect.bottom + l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
        }
        return l.h(TbadkCoreApplication.getInst(), d.e.ds280);
    }

    public void ah(String str, boolean z) {
        if (!aXp()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM()) {
                            d.this.aBq();
                            d.this.oI(true);
                            if (d.this.hQf != null) {
                                d.this.hQf.cy(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.jQ(bRK());
            this.refreshView.pp(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.any();
            this.refreshView.onChangeSkinType();
            this.hQe.setVisibility(8);
            if (this.hQg != null) {
                this.hQg.setVisibility(8);
            }
        }
    }

    public boolean aXp() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void aez() {
        if (this.dbs != null) {
            this.dbs.aez();
        }
    }

    public void aeA() {
        if (this.dbs != null) {
            this.dbs.aeA();
        }
    }

    public void ia(boolean z) {
        if (this.hQe != null && this.dbs != null) {
            this.dbs.aeA();
            if (z) {
                this.dbs.setText(this.mContext.getString(d.j.list_no_more));
            } else {
                this.dbs.setText("");
            }
        }
    }

    public void c(boolean z, List<m> list) {
        if (this.hQe != null && this.dbs != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aCt();
                    return;
                }
            }
            this.dbs.aeA();
            if (z) {
                this.dbs.setText(this.mContext.getString(d.j.list_no_more));
            } else {
                this.dbs.setText("");
            }
        }
    }

    public void aCt() {
        if (this.hQe != null && this.dbs != null) {
            this.hQe.setNextPage(null);
            this.dbs.hideEmptyView();
        }
    }

    public void xc(int i) {
        if (i == 0) {
            this.dbs.ia(d.C0277d.cp_bg_line_d);
            this.dbs.hW(d.C0277d.cp_bg_line_e);
            this.dbs.hZ(d.C0277d.cp_cont_e);
            this.dbs.aev();
        } else if (i == 1) {
            this.dbs.ia(d.C0277d.cp_bg_line_c);
            this.dbs.hZ(d.C0277d.cp_cont_d);
            this.dbs.aew();
        }
        this.dbs.ib(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dG(List<m> list) {
        if (v.T(list)) {
            list = new ArrayList<>();
        }
        if (this.hQe.getVisibility() != 0) {
            this.hQe.setVisibility(0);
        }
        this.hQe.setData(list);
    }

    public void bRL() {
        if (ao.jK()) {
            if (this.hQg == null) {
                this.hQg = new ImageView(this.mContext.getPageActivity());
                this.hQg.setImageResource(d.f.icon_nichengjun);
                this.hQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bHH(), true)));
                    }
                });
            }
            if (this.hQg.getParent() != null) {
                ((ViewGroup) this.hQg.getParent()).removeView(this.hQg);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.hQg, layoutParams);
            }
        } else if (this.hQg != null && this.hQg.getParent() != null && this.hQg.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.hQg);
        }
    }

    public void e(UserData userData) {
        this.hQi.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.anm().jL(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.hQh.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jB().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.hQk.userData = userData;
    }

    public void M(float f) {
        if (!this.hQj.isShown()) {
            this.hQj.setVisibility(0);
            this.hQj.setFrame(0);
        }
        this.fuZ = f;
    }

    public void bin() {
        this.hQj.cancelAnimation();
        this.hQj.setVisibility(8);
    }

    public void oK() {
        if (!this.hQj.isShown()) {
            this.hQj.setVisibility(0);
        }
        this.hQj.cu();
    }
}
