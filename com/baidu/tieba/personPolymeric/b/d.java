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
import com.baidu.tbadk.t.as;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonExpandImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private com.baidu.tbadk.m.g dhY;
    private NoNetworkView dlX;
    public PbListView dlY;
    private PluginErrorTipView eRW;
    protected BdPersonListView iiT;
    private b iiU;
    private ImageView iiV;
    protected PersonExpandImageView iiW;
    protected View iiX;
    private ContinuousAnimationView iiY;
    protected NavigationBar ija;
    protected RelativeLayout ijb;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private Rect rect;
    private com.baidu.tbadk.m.h refreshView;
    private float fLR = 360.0f;
    private a iiZ = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.iiW);
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
        void cG(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
            this.iiT = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.eRW = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ija = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.ijb = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dlY = new PbListView(this.mContext.getPageActivity());
            this.dlY.getView();
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlY.iN(R.color.cp_cont_e);
            this.dlY.iO(R.color.cp_bg_line_d);
            this.dlY.setHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds140));
            this.dlY.iL(l.g(this.mContext.getPageActivity(), R.dimen.ds12));
            this.dlY.aju();
            this.dlY.iK(R.color.cp_bg_line_e);
            this.iiT.setNextPage(this.dlY);
            this.iiW = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.iiW.setInitHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.iiX = view.findViewById(R.id.view_top_background_cover);
            this.iiX.setVisibility(8);
            this.iiT.setOuterExpandView(this.iiW);
            this.iiY = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.iiZ.ije = gVar;
            view.setOnClickListener(this.iiZ);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b ijd = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g ije;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").bT("obj_locate", "3"));
            this.ijd.eXw = 10;
            this.ijd.ayy = new Bundle();
            this.ijd.ayy.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.ije != null) {
                this.ije.a(view, this.ijd);
            }
        }
    }

    public void pw(boolean z) {
        this.ijb.setVisibility(8);
        this.ija.setVisibility(0);
        this.ija.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.ija.setCenterTextTitle(this.mContext.getString(R.string.ta_homepage));
        } else {
            this.ija.setCenterTextTitle(this.mContext.getString(R.string.my_homepage));
        }
        this.ija.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bW(null, this.mContext.getString(R.string.user_to_anti)), null);
        }
        al.j(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bsO() {
        if (this.mRootView != null) {
            this.iiT.setVisibility(8);
            if (this.iiV != null) {
                this.iiV.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bc.cC(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cD(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ac(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.cD(d.this.mContext.getPageActivity());
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
            al.k(this.mRootView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.ija.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            if (this.iiT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.iiT.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dlX.onChangeSkinType(this.mContext, i);
            this.eRW.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.iiU = bVar;
    }

    public void aHK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.dhY == null) {
            if (i < 0) {
                this.dhY = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.dhY = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.dhY.onChangeSkinType();
        }
        this.dhY.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this.mRootView);
            this.dhY = null;
        }
    }

    public void px(boolean z) {
        if (z) {
            bZP();
        }
    }

    public void yj(int i) {
        this.iiT.setVisibility(i);
    }

    private int bZO() {
        if (this.rect == null) {
            this.rect = new Rect();
        }
        if (this.iiW == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.iiW.getLocalVisibleRect(this.rect);
        if (this.rect.bottom > 0) {
            return this.rect.bottom + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void aj(String str, boolean z) {
        if (!beG()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG()) {
                            d.this.aHK();
                            d.this.px(true);
                            if (d.this.iiU != null) {
                                d.this.iiU.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kE(bZO());
            this.refreshView.qx(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.asB();
            this.refreshView.onChangeSkinType();
            this.iiT.setVisibility(8);
            if (this.iiV != null) {
                this.iiV.setVisibility(8);
            }
        }
    }

    public boolean beG() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void ajy() {
        if (this.dlY != null) {
            this.dlY.ajy();
        }
    }

    public void ajz() {
        if (this.dlY != null) {
            this.dlY.ajz();
        }
    }

    public void iF(boolean z) {
        if (this.iiT != null && this.dlY != null) {
            this.dlY.ajz();
            if (z) {
                this.dlY.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dlY.setText("");
            }
        }
    }

    public void c(boolean z, List<m> list) {
        if (this.iiT != null && this.dlY != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aIJ();
                    return;
                }
            }
            this.dlY.ajz();
            if (z) {
                this.dlY.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dlY.setText("");
            }
        }
    }

    public void aIJ() {
        if (this.iiT != null && this.dlY != null) {
            this.iiT.setNextPage(null);
            this.dlY.hideEmptyView();
        }
    }

    public void yk(int i) {
        if (i == 0) {
            this.dlY.iO(R.color.cp_bg_line_d);
            this.dlY.iK(R.color.cp_bg_line_e);
            this.dlY.iN(R.color.cp_cont_e);
            this.dlY.aju();
        } else if (i == 1) {
            this.dlY.iO(R.color.cp_bg_line_c);
            this.dlY.iN(R.color.cp_cont_d);
            this.dlY.ajv();
        }
        this.dlY.iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dQ(List<m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iiT.getVisibility() != 0) {
            this.iiT.setVisibility(0);
        }
        this.iiT.setData(list);
    }

    public void bZP() {
        if (as.iE()) {
            if (this.iiV == null) {
                this.iiV = new ImageView(this.mContext.getPageActivity());
                this.iiV.setImageResource(R.drawable.icon_nichengjun);
                this.iiV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bPu(), true)));
                    }
                });
            }
            if (this.iiV.getParent() != null) {
                ((ViewGroup) this.iiV.getParent()).removeView(this.iiV);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.iiV, layoutParams);
            }
        } else if (this.iiV != null && this.iiV.getParent() != null && this.iiV.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.iiV);
        }
    }

    public void e(UserData userData) {
        this.iiX.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.asp().kz(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.iiW.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.iv().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.iiZ.userData = userData;
    }

    public void M(float f) {
        if (!this.iiY.isShown()) {
            this.iiY.setVisibility(0);
            this.iiY.setFrame(0);
        }
        this.fLR = f;
    }

    public void bpG() {
        this.iiY.cancelAnimation();
        this.iiY.setVisibility(8);
    }

    public void nE() {
        if (!this.iiY.isShown()) {
            this.iiY.setVisibility(0);
        }
        this.iiY.bo();
    }
}
