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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private Rect cyf;
    private com.baidu.tbadk.m.g dly;
    private NoNetworkView dpy;
    public PbListView dpz;
    private PluginErrorTipView eYM;
    protected BdPersonListView isp;
    private b isq;
    private ImageView isr;
    protected PersonExpandImageView iss;
    protected View ist;
    private ContinuousAnimationView isu;
    protected NavigationBar isw;
    protected RelativeLayout isx;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private float fTw = 360.0f;
    private a isv = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.iss);
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
        void cL(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
            this.isp = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.eYM = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.isw = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.isx = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dpz = new PbListView(this.mContext.getPageActivity());
            this.dpz.getView();
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dpz.iW(R.color.cp_cont_e);
            this.dpz.iX(R.color.cp_bg_line_d);
            this.dpz.setHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds140));
            this.dpz.iU(l.g(this.mContext.getPageActivity(), R.dimen.ds12));
            this.dpz.akN();
            this.dpz.iT(R.color.cp_bg_line_e);
            this.isp.setNextPage(this.dpz);
            this.iss = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.iss.setInitHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.ist = view.findViewById(R.id.view_top_background_cover);
            this.ist.setVisibility(8);
            this.isp.setOuterExpandView(this.iss);
            this.isu = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.isv.isA = gVar;
            view.setOnClickListener(this.isv);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public com.baidu.tieba.view.g isA;
        private com.baidu.tieba.personPolymeric.event.b isz = new com.baidu.tieba.personPolymeric.event.b();
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").bT("obj_locate", "3"));
            this.isz.feK = 10;
            this.isz.azD = new Bundle();
            this.isz.azD.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.isA != null) {
                this.isA.a(view, this.isz);
            }
        }
    }

    public void pP(boolean z) {
        this.isx.setVisibility(8);
        this.isw.setVisibility(0);
        this.isw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.isw.setCenterTextTitle(this.mContext.getString(R.string.ta_homepage));
        } else {
            this.isw.setCenterTextTitle(this.mContext.getString(R.string.my_homepage));
        }
        this.isw.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bX(null, this.mContext.getString(R.string.user_to_anti)), null);
        }
        am.j(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bvS() {
        if (this.mRootView != null) {
            this.isp.setVisibility(8);
            if (this.isr != null) {
                this.isr.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bc.cD(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.cE(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds320);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.af(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.mContext.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.cE(d.this.mContext.getPageActivity());
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
            am.k(this.mRootView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.isw.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            if (this.isp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.isp.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dpy.onChangeSkinType(this.mContext, i);
            this.eYM.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.isq = bVar;
    }

    public void aJN() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.dly == null) {
            if (i < 0) {
                this.dly = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.dly = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.dly.onChangeSkinType();
        }
        this.dly.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this.mRootView);
            this.dly = null;
        }
    }

    public void pQ(boolean z) {
        if (z) {
            cdL();
        }
    }

    public void yT(int i) {
        this.isp.setVisibility(i);
    }

    private int cdK() {
        if (this.cyf == null) {
            this.cyf = new Rect();
        }
        if (this.iss == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.iss.getLocalVisibleRect(this.cyf);
        if (this.cyf.bottom > 0) {
            return this.cyf.bottom + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void an(String str, boolean z) {
        if (!bhs()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ()) {
                            d.this.aJN();
                            d.this.pQ(true);
                            if (d.this.isq != null) {
                                d.this.isq.cL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kO(cdK());
            this.refreshView.qY(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.atW();
            this.refreshView.onChangeSkinType();
            this.isp.setVisibility(8);
            if (this.isr != null) {
                this.isr.setVisibility(8);
            }
        }
    }

    public boolean bhs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void akR() {
        if (this.dpz != null) {
            this.dpz.akR();
        }
    }

    public void akS() {
        if (this.dpz != null) {
            this.dpz.akS();
        }
    }

    public void iR(boolean z) {
        if (this.isp != null && this.dpz != null) {
            this.dpz.akS();
            if (z) {
                this.dpz.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dpz.setText("");
            }
        }
    }

    public void b(boolean z, List<m> list) {
        if (this.isp != null && this.dpz != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aKQ();
                    return;
                }
            }
            this.dpz.akS();
            if (z) {
                this.dpz.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dpz.setText("");
            }
        }
    }

    public void aKQ() {
        if (this.isp != null && this.dpz != null) {
            this.isp.setNextPage(null);
            this.dpz.hideEmptyView();
        }
    }

    public void yU(int i) {
        if (i == 0) {
            this.dpz.iX(R.color.cp_bg_line_d);
            this.dpz.iT(R.color.cp_bg_line_e);
            this.dpz.iW(R.color.cp_cont_e);
            this.dpz.akN();
        } else if (i == 1) {
            this.dpz.iX(R.color.cp_bg_line_c);
            this.dpz.iW(R.color.cp_cont_d);
            this.dpz.akO();
        }
        this.dpz.iY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dR(List<m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.isp.getVisibility() != 0) {
            this.isp.setVisibility(0);
        }
        this.isp.setData(list);
    }

    public void cdL() {
        if (as.iN()) {
            if (this.isr == null) {
                this.isr = new ImageView(this.mContext.getPageActivity());
                this.isr.setImageResource(R.drawable.icon_nichengjun);
                this.isr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bTh(), true)));
                    }
                });
            }
            if (this.isr.getParent() != null) {
                ((ViewGroup) this.isr.getParent()).removeView(this.isr);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.isr, layoutParams);
            }
        } else if (this.isr != null && this.isr.getParent() != null && this.isr.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.isr);
        }
    }

    public void e(UserData userData) {
        this.ist.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.atK().kJ(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.iss.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.iE().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.isv.userData = userData;
    }

    public void M(float f) {
        if (!this.isu.isShown()) {
            this.isu.setVisibility(0);
            this.isu.setFrame(0);
        }
        this.fTw = f;
    }

    public void bsJ() {
        this.isu.cancelAnimation();
        this.isu.setVisibility(8);
    }

    public void nX() {
        if (!this.isu.isShown()) {
            this.isu.setVisibility(0);
        }
        this.isu.br();
    }
}
