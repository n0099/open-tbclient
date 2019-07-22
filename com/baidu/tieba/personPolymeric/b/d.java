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
import com.baidu.tbadk.core.util.bd;
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
    private Rect cxc;
    private com.baidu.tbadk.m.g djG;
    private NoNetworkView dnF;
    public PbListView dnG;
    private PluginErrorTipView eWW;
    protected BdPersonListView ipm;
    private b ipn;
    private ImageView ipo;
    protected PersonExpandImageView ipp;
    protected View ipq;
    private ContinuousAnimationView ipr;
    protected NavigationBar ipt;
    protected RelativeLayout ipu;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private float fQR = 360.0f;
    private a ips = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.ipp);
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
        void cJ(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.mContext = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
            this.ipm = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.eWW = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ipt = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.ipu = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dnG = new PbListView(this.mContext.getPageActivity());
            this.dnG.getView();
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnG.iT(R.color.cp_cont_e);
            this.dnG.iU(R.color.cp_bg_line_d);
            this.dnG.setHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds140));
            this.dnG.iR(l.g(this.mContext.getPageActivity(), R.dimen.ds12));
            this.dnG.akz();
            this.dnG.iQ(R.color.cp_bg_line_e);
            this.ipm.setNextPage(this.dnG);
            this.ipp = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.ipp.setInitHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.ipq = view.findViewById(R.id.view_top_background_cover);
            this.ipq.setVisibility(8);
            this.ipm.setOuterExpandView(this.ipp);
            this.ipr = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.ips.ipx = gVar;
            view.setOnClickListener(this.ips);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b ipw = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g ipx;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").bT("obj_locate", "3"));
            this.ipw.fcx = 10;
            this.ipw.azf = new Bundle();
            this.ipw.azf.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.ipx != null) {
                this.ipx.a(view, this.ipw);
            }
        }
    }

    public void pL(boolean z) {
        this.ipu.setVisibility(8);
        this.ipt.setVisibility(0);
        this.ipt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.ipt.setCenterTextTitle(this.mContext.getString(R.string.ta_homepage));
        } else {
            this.ipt.setCenterTextTitle(this.mContext.getString(R.string.my_homepage));
        }
        this.ipt.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bX(null, this.mContext.getString(R.string.user_to_anti)), null);
        }
        am.j(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void buR() {
        if (this.mRootView != null) {
            this.ipm.setVisibility(8);
            if (this.ipo != null) {
                this.ipo.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bd.cD(d.this.mContext.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.mContext.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bd.cE(d.this.mContext.getPageActivity());
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
                    bd.cE(d.this.mContext.getPageActivity());
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
            this.ipt.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            if (this.ipm.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.ipm.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dnF.onChangeSkinType(this.mContext, i);
            this.eWW.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.ipn = bVar;
    }

    public void aJh() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.djG == null) {
            if (i < 0) {
                this.djG = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.djG = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.djG.onChangeSkinType();
        }
        this.djG.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this.mRootView);
            this.djG = null;
        }
    }

    public void pM(boolean z) {
        if (z) {
            ccF();
        }
    }

    public void yO(int i) {
        this.ipm.setVisibility(i);
    }

    private int ccE() {
        if (this.cxc == null) {
            this.cxc = new Rect();
        }
        if (this.ipp == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.ipp.getLocalVisibleRect(this.cxc);
        if (this.cxc.bottom > 0) {
            return this.cxc.bottom + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void an(String str, boolean z) {
        if (!bgJ()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ()) {
                            d.this.aJh();
                            d.this.pM(true);
                            if (d.this.ipn != null) {
                                d.this.ipn.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kK(ccE());
            this.refreshView.qN(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.atI();
            this.refreshView.onChangeSkinType();
            this.ipm.setVisibility(8);
            if (this.ipo != null) {
                this.ipo.setVisibility(8);
            }
        }
    }

    public boolean bgJ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void akD() {
        if (this.dnG != null) {
            this.dnG.akD();
        }
    }

    public void akE() {
        if (this.dnG != null) {
            this.dnG.akE();
        }
    }

    public void iO(boolean z) {
        if (this.ipm != null && this.dnG != null) {
            this.dnG.akE();
            if (z) {
                this.dnG.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dnG.setText("");
            }
        }
    }

    public void b(boolean z, List<m> list) {
        if (this.ipm != null && this.dnG != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aKk();
                    return;
                }
            }
            this.dnG.akE();
            if (z) {
                this.dnG.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dnG.setText("");
            }
        }
    }

    public void aKk() {
        if (this.ipm != null && this.dnG != null) {
            this.ipm.setNextPage(null);
            this.dnG.hideEmptyView();
        }
    }

    public void yP(int i) {
        if (i == 0) {
            this.dnG.iU(R.color.cp_bg_line_d);
            this.dnG.iQ(R.color.cp_bg_line_e);
            this.dnG.iT(R.color.cp_cont_e);
            this.dnG.akz();
        } else if (i == 1) {
            this.dnG.iU(R.color.cp_bg_line_c);
            this.dnG.iT(R.color.cp_cont_d);
            this.dnG.akA();
        }
        this.dnG.iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dS(List<m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.ipm.getVisibility() != 0) {
            this.ipm.setVisibility(0);
        }
        this.ipm.setData(list);
    }

    public void ccF() {
        if (as.iN()) {
            if (this.ipo == null) {
                this.ipo = new ImageView(this.mContext.getPageActivity());
                this.ipo.setImageResource(R.drawable.icon_nichengjun);
                this.ipo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bSg(), true)));
                    }
                });
            }
            if (this.ipo.getParent() != null) {
                ((ViewGroup) this.ipo.getParent()).removeView(this.ipo);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.ipo, layoutParams);
            }
        } else if (this.ipo != null && this.ipo.getParent() != null && this.ipo.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.ipo);
        }
    }

    public void e(UserData userData) {
        this.ipq.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.atw().kF(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.ipp.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.iE().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.ips.userData = userData;
    }

    public void M(float f) {
        if (!this.ipr.isShown()) {
            this.ipr.setVisibility(0);
            this.ipr.setFrame(0);
        }
        this.fQR = f;
    }

    public void brJ() {
        this.ipr.cancelAnimation();
        this.ipr.setVisibility(8);
    }

    public void nX() {
        if (!this.ipr.isShown()) {
            this.ipr.setVisibility(0);
        }
        this.ipr.br();
    }
}
