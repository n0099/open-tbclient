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
    private com.baidu.tbadk.m.g cXm;
    private NoNetworkView dbm;
    public PbListView dbn;
    private PluginErrorTipView eCu;
    protected BdPersonListView hQr;
    private b hQs;
    private ImageView hQt;
    protected PersonExpandImageView hQu;
    protected View hQv;
    private ContinuousAnimationView hQw;
    protected NavigationBar hQy;
    protected RelativeLayout hQz;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private Rect rect;
    private com.baidu.tbadk.m.h refreshView;
    private float fvn = 360.0f;
    private a hQx = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.hQu);
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
            this.hQr = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
            this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
            this.eCu = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
            this.hQy = (NavigationBar) this.mRootView.findViewById(d.g.person_center_anti_navigation_bar);
            this.hQz = (RelativeLayout) this.mRootView.findViewById(d.g.person_center_noanti_rootview);
            this.dbn = new PbListView(this.mContext.getPageActivity());
            this.dbn.getView();
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.dbn.ia(d.C0277d.cp_cont_e);
            this.dbn.ib(d.C0277d.cp_bg_line_d);
            this.dbn.setHeight(l.h(this.mContext.getPageActivity(), d.e.ds140));
            this.dbn.hY(l.h(this.mContext.getPageActivity(), d.e.ds12));
            this.dbn.aey();
            this.dbn.hX(d.C0277d.cp_bg_line_e);
            this.hQr.setNextPage(this.dbn);
            this.hQu = (PersonExpandImageView) this.mRootView.findViewById(d.g.person_polymeric_header_expand_img);
            this.hQu.setInitHeight(this.mContext.getResources().getDimensionPixelSize(d.e.tbds496));
            this.hQv = view.findViewById(d.g.view_top_background_cover);
            this.hQv.setVisibility(8);
            this.hQr.setOuterExpandView(this.hQu);
            this.hQw = (ContinuousAnimationView) this.mRootView.findViewById(d.g.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.hQx.hQC = gVar;
            view.setOnClickListener(this.hQx);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b hQB = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g hQC;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").bJ("obj_locate", "3"));
            this.hQB.eHy = 10;
            this.hQB.eHz = new Bundle();
            this.hQB.eHz.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.hQC != null) {
                this.hQC.a(view, this.hQB);
            }
        }
    }

    public void oH(boolean z) {
        this.hQz.setVisibility(8);
        this.hQy.setVisibility(0);
        this.hQy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.hQy.setCenterTextTitle(this.mContext.getString(d.j.ta_homepage));
        } else {
            this.hQy.setCenterTextTitle(this.mContext.getString(d.j.my_homepage));
        }
        this.hQy.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bM(null, this.mContext.getString(d.j.user_to_anti)), null);
        }
        al.j(this.mNoDataView.getSuTextView(), d.C0277d.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bls() {
        if (this.mRootView != null) {
            this.hQr.setVisibility(8);
            if (this.hQt != null) {
                this.hQt.setVisibility(8);
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
            this.hQy.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
            if (this.hQr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.hQr.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dbm.onChangeSkinType(this.mContext, i);
            this.eCu.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.hQs = bVar;
    }

    public void aBt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.cXm == null) {
            if (i < 0) {
                this.cXm = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.cXm = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.cXm.onChangeSkinType();
        }
        this.cXm.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this.mRootView);
            this.cXm = null;
        }
    }

    public void oI(boolean z) {
        if (z) {
            bRP();
        }
    }

    public void xf(int i) {
        this.hQr.setVisibility(i);
    }

    private int bRO() {
        if (this.rect == null) {
            this.rect = new Rect();
        }
        if (this.hQu == null) {
            return l.h(TbadkCoreApplication.getInst(), d.e.ds280);
        }
        this.hQu.getLocalVisibleRect(this.rect);
        if (this.rect.bottom > 0) {
            return this.rect.bottom + l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
        }
        return l.h(TbadkCoreApplication.getInst(), d.e.ds280);
    }

    public void ah(String str, boolean z) {
        if (!aXr()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM()) {
                            d.this.aBt();
                            d.this.oI(true);
                            if (d.this.hQs != null) {
                                d.this.hQs.cy(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.jR(bRO());
            this.refreshView.po(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.anB();
            this.refreshView.onChangeSkinType();
            this.hQr.setVisibility(8);
            if (this.hQt != null) {
                this.hQt.setVisibility(8);
            }
        }
    }

    public boolean aXr() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void aeC() {
        if (this.dbn != null) {
            this.dbn.aeC();
        }
    }

    public void aeD() {
        if (this.dbn != null) {
            this.dbn.aeD();
        }
    }

    public void ia(boolean z) {
        if (this.hQr != null && this.dbn != null) {
            this.dbn.aeD();
            if (z) {
                this.dbn.setText(this.mContext.getString(d.j.list_no_more));
            } else {
                this.dbn.setText("");
            }
        }
    }

    public void c(boolean z, List<m> list) {
        if (this.hQr != null && this.dbn != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aCw();
                    return;
                }
            }
            this.dbn.aeD();
            if (z) {
                this.dbn.setText(this.mContext.getString(d.j.list_no_more));
            } else {
                this.dbn.setText("");
            }
        }
    }

    public void aCw() {
        if (this.hQr != null && this.dbn != null) {
            this.hQr.setNextPage(null);
            this.dbn.hideEmptyView();
        }
    }

    public void xg(int i) {
        if (i == 0) {
            this.dbn.ib(d.C0277d.cp_bg_line_d);
            this.dbn.hX(d.C0277d.cp_bg_line_e);
            this.dbn.ia(d.C0277d.cp_cont_e);
            this.dbn.aey();
        } else if (i == 1) {
            this.dbn.ib(d.C0277d.cp_bg_line_c);
            this.dbn.ia(d.C0277d.cp_cont_d);
            this.dbn.aez();
        }
        this.dbn.ic(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dJ(List<m> list) {
        if (v.T(list)) {
            list = new ArrayList<>();
        }
        if (this.hQr.getVisibility() != 0) {
            this.hQr.setVisibility(0);
        }
        this.hQr.setData(list);
    }

    public void bRP() {
        if (ao.jK()) {
            if (this.hQt == null) {
                this.hQt = new ImageView(this.mContext.getPageActivity());
                this.hQt.setImageResource(d.f.icon_nichengjun);
                this.hQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bHK(), true)));
                    }
                });
            }
            if (this.hQt.getParent() != null) {
                ((ViewGroup) this.hQt.getParent()).removeView(this.hQt);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.h(this.mContext.getPageActivity(), d.e.ds504);
            layoutParams.rightMargin = l.h(this.mContext.getPageActivity(), d.e.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.hQt, layoutParams);
            }
        } else if (this.hQt != null && this.hQt.getParent() != null && this.hQt.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.hQt);
        }
    }

    public void e(UserData userData) {
        this.hQv.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.anp().jM(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), d.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.hQu.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.jB().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.hQx.userData = userData;
    }

    public void M(float f) {
        if (!this.hQw.isShown()) {
            this.hQw.setVisibility(0);
            this.hQw.setFrame(0);
        }
        this.fvn = f;
    }

    public void bip() {
        this.hQw.cancelAnimation();
        this.hQw.setVisibility(8);
    }

    public void oK() {
        if (!this.hQw.isShown()) {
            this.hQw.setVisibility(0);
        }
        this.hQw.cu();
    }
}
