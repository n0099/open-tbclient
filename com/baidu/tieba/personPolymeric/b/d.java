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
    private com.baidu.tbadk.m.g dhX;
    private NoNetworkView dlW;
    public PbListView dlX;
    private PluginErrorTipView eRV;
    protected BdPersonListView iiQ;
    private b iiR;
    private ImageView iiS;
    protected PersonExpandImageView iiT;
    protected View iiU;
    private ContinuousAnimationView iiV;
    protected NavigationBar iiX;
    protected RelativeLayout iiY;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private Rect rect;
    private com.baidu.tbadk.m.h refreshView;
    private float fLQ = 360.0f;
    private a iiW = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.iiT);
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
            this.iiQ = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.eRV = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.iiX = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.iiY = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dlX = new PbListView(this.mContext.getPageActivity());
            this.dlX.getView();
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlX.iN(R.color.cp_cont_e);
            this.dlX.iO(R.color.cp_bg_line_d);
            this.dlX.setHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds140));
            this.dlX.iL(l.g(this.mContext.getPageActivity(), R.dimen.ds12));
            this.dlX.aju();
            this.dlX.iK(R.color.cp_bg_line_e);
            this.iiQ.setNextPage(this.dlX);
            this.iiT = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.iiT.setInitHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.iiU = view.findViewById(R.id.view_top_background_cover);
            this.iiU.setVisibility(8);
            this.iiQ.setOuterExpandView(this.iiT);
            this.iiV = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.iiW.ijb = gVar;
            view.setOnClickListener(this.iiW);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b ija = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g ijb;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new am("c12502").bT("obj_locate", "3"));
            this.ija.eXv = 10;
            this.ija.ayy = new Bundle();
            this.ija.ayy.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.ijb != null) {
                this.ijb.a(view, this.ija);
            }
        }
    }

    public void pw(boolean z) {
        this.iiY.setVisibility(8);
        this.iiX.setVisibility(0);
        this.iiX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.iiX.setCenterTextTitle(this.mContext.getString(R.string.ta_homepage));
        } else {
            this.iiX.setCenterTextTitle(this.mContext.getString(R.string.my_homepage));
        }
        this.iiX.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bW(null, this.mContext.getString(R.string.user_to_anti)), null);
        }
        al.j(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bsL() {
        if (this.mRootView != null) {
            this.iiQ.setVisibility(8);
            if (this.iiS != null) {
                this.iiS.setVisibility(8);
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
            this.iiX.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            if (this.iiQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.iiQ.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dlW.onChangeSkinType(this.mContext, i);
            this.eRV.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.iiR = bVar;
    }

    public void aHH() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.dhX == null) {
            if (i < 0) {
                this.dhX = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.dhX = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.dhX.onChangeSkinType();
        }
        this.dhX.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this.mRootView);
            this.dhX = null;
        }
    }

    public void px(boolean z) {
        if (z) {
            bZM();
        }
    }

    public void yj(int i) {
        this.iiQ.setVisibility(i);
    }

    private int bZL() {
        if (this.rect == null) {
            this.rect = new Rect();
        }
        if (this.iiT == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.iiT.getLocalVisibleRect(this.rect);
        if (this.rect.bottom > 0) {
            return this.rect.bottom + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void aj(String str, boolean z) {
        if (!beD()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG()) {
                            d.this.aHH();
                            d.this.px(true);
                            if (d.this.iiR != null) {
                                d.this.iiR.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kE(bZL());
            this.refreshView.qx(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.asB();
            this.refreshView.onChangeSkinType();
            this.iiQ.setVisibility(8);
            if (this.iiS != null) {
                this.iiS.setVisibility(8);
            }
        }
    }

    public boolean beD() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void ajy() {
        if (this.dlX != null) {
            this.dlX.ajy();
        }
    }

    public void ajz() {
        if (this.dlX != null) {
            this.dlX.ajz();
        }
    }

    public void iF(boolean z) {
        if (this.iiQ != null && this.dlX != null) {
            this.dlX.ajz();
            if (z) {
                this.dlX.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dlX.setText("");
            }
        }
    }

    public void c(boolean z, List<m> list) {
        if (this.iiQ != null && this.dlX != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aIG();
                    return;
                }
            }
            this.dlX.ajz();
            if (z) {
                this.dlX.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dlX.setText("");
            }
        }
    }

    public void aIG() {
        if (this.iiQ != null && this.dlX != null) {
            this.iiQ.setNextPage(null);
            this.dlX.hideEmptyView();
        }
    }

    public void yk(int i) {
        if (i == 0) {
            this.dlX.iO(R.color.cp_bg_line_d);
            this.dlX.iK(R.color.cp_bg_line_e);
            this.dlX.iN(R.color.cp_cont_e);
            this.dlX.aju();
        } else if (i == 1) {
            this.dlX.iO(R.color.cp_bg_line_c);
            this.dlX.iN(R.color.cp_cont_d);
            this.dlX.ajv();
        }
        this.dlX.iP(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dQ(List<m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iiQ.getVisibility() != 0) {
            this.iiQ.setVisibility(0);
        }
        this.iiQ.setData(list);
    }

    public void bZM() {
        if (as.iE()) {
            if (this.iiS == null) {
                this.iiS = new ImageView(this.mContext.getPageActivity());
                this.iiS.setImageResource(R.drawable.icon_nichengjun);
                this.iiS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bPr(), true)));
                    }
                });
            }
            if (this.iiS.getParent() != null) {
                ((ViewGroup) this.iiS.getParent()).removeView(this.iiS);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.iiS, layoutParams);
            }
        } else if (this.iiS != null && this.iiS.getParent() != null && this.iiS.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.iiS);
        }
    }

    public void e(UserData userData) {
        this.iiU.setVisibility(0);
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
                this.iiT.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.iv().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.iiW.userData = userData;
    }

    public void M(float f) {
        if (!this.iiV.isShown()) {
            this.iiV.setVisibility(0);
            this.iiV.setFrame(0);
        }
        this.fLQ = f;
    }

    public void bpD() {
        this.iiV.cancelAnimation();
        this.iiV.setVisibility(8);
    }

    public void nE() {
        if (!this.iiV.isShown()) {
            this.iiV.setVisibility(0);
        }
        this.iiV.bo();
    }
}
