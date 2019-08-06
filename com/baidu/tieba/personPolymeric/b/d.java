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
    private Rect cxj;
    private com.baidu.tbadk.m.g djN;
    private NoNetworkView dnM;
    public PbListView dnN;
    private PluginErrorTipView eXg;
    protected BdPersonListView iqq;
    private b iqr;
    private ImageView iqs;
    protected PersonExpandImageView iqt;
    protected View iqu;
    private ContinuousAnimationView iqv;
    protected NavigationBar iqx;
    protected RelativeLayout iqy;
    protected TbPageContext mContext;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private float fRF = 360.0f;
    private a iqw = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(d.this.iqt);
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
            this.iqq = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.eXg = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.iqx = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.iqy = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dnN = new PbListView(this.mContext.getPageActivity());
            this.dnN.getView();
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dnN.iT(R.color.cp_cont_e);
            this.dnN.iU(R.color.cp_bg_line_d);
            this.dnN.setHeight(l.g(this.mContext.getPageActivity(), R.dimen.ds140));
            this.dnN.iR(l.g(this.mContext.getPageActivity(), R.dimen.ds12));
            this.dnN.akB();
            this.dnN.iQ(R.color.cp_bg_line_e);
            this.iqq.setNextPage(this.dnN);
            this.iqt = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.iqt.setInitHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.iqu = view.findViewById(R.id.view_top_background_cover);
            this.iqu.setVisibility(8);
            this.iqq.setOuterExpandView(this.iqt);
            this.iqv = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.iqw.iqB = gVar;
            view.setOnClickListener(this.iqw);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b iqA = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g iqB;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").bT("obj_locate", "3"));
            this.iqA.fcX = 10;
            this.iqA.azf = new Bundle();
            this.iqA.azf.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.iqB != null) {
                this.iqB.a(view, this.iqA);
            }
        }
    }

    public void pM(boolean z) {
        this.iqy.setVisibility(8);
        this.iqx.setVisibility(0);
        this.iqx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.iqx.setCenterTextTitle(this.mContext.getString(R.string.ta_homepage));
        } else {
            this.iqx.setCenterTextTitle(this.mContext.getString(R.string.my_homepage));
        }
        this.iqx.showBottomLine();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mContext.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bX(null, this.mContext.getString(R.string.user_to_anti)), null);
        }
        am.j(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bve() {
        if (this.mRootView != null) {
            this.iqq.setVisibility(8);
            if (this.iqs != null) {
                this.iqs.setVisibility(8);
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
            this.iqx.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            if (this.iqq.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.iqq.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dnM.onChangeSkinType(this.mContext, i);
            this.eXg.onChangeSkinType(this.mContext, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.iqr = bVar;
    }

    public void aJj() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void o(boolean z, int i) {
        if (this.djN == null) {
            if (i < 0) {
                this.djN = new com.baidu.tbadk.m.g(this.mContext.getContext());
            } else {
                this.djN = new com.baidu.tbadk.m.g(this.mContext.getContext(), i);
            }
            this.djN.onChangeSkinType();
        }
        this.djN.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this.mRootView);
            this.djN = null;
        }
    }

    public void pN(boolean z) {
        if (z) {
            ccX();
        }
    }

    public void yQ(int i) {
        this.iqq.setVisibility(i);
    }

    private int ccW() {
        if (this.cxj == null) {
            this.cxj = new Rect();
        }
        if (this.iqt == null) {
            return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.iqt.getLocalVisibleRect(this.cxj);
        if (this.cxj.bottom > 0) {
            return this.cxj.bottom + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.g(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void an(String str, boolean z) {
        if (!bgM()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.mContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ()) {
                            d.this.aJj();
                            d.this.pN(true);
                            if (d.this.iqr != null) {
                                d.this.iqr.cL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kL(ccW());
            this.refreshView.qN(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.atK();
            this.refreshView.onChangeSkinType();
            this.iqq.setVisibility(8);
            if (this.iqs != null) {
                this.iqs.setVisibility(8);
            }
        }
    }

    public boolean bgM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void akF() {
        if (this.dnN != null) {
            this.dnN.akF();
        }
    }

    public void akG() {
        if (this.dnN != null) {
            this.dnN.akG();
        }
    }

    public void iO(boolean z) {
        if (this.iqq != null && this.dnN != null) {
            this.dnN.akG();
            if (z) {
                this.dnN.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dnN.setText("");
            }
        }
    }

    public void b(boolean z, List<m> list) {
        if (this.iqq != null && this.dnN != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aKm();
                    return;
                }
            }
            this.dnN.akG();
            if (z) {
                this.dnN.setText(this.mContext.getString(R.string.list_no_more));
            } else {
                this.dnN.setText("");
            }
        }
    }

    public void aKm() {
        if (this.iqq != null && this.dnN != null) {
            this.iqq.setNextPage(null);
            this.dnN.hideEmptyView();
        }
    }

    public void yR(int i) {
        if (i == 0) {
            this.dnN.iU(R.color.cp_bg_line_d);
            this.dnN.iQ(R.color.cp_bg_line_e);
            this.dnN.iT(R.color.cp_cont_e);
            this.dnN.akB();
        } else if (i == 1) {
            this.dnN.iU(R.color.cp_bg_line_c);
            this.dnN.iT(R.color.cp_cont_d);
            this.dnN.akC();
        }
        this.dnN.iV(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dR(List<m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iqq.getVisibility() != 0) {
            this.iqq.setVisibility(0);
        }
        this.iqq.setData(list);
    }

    public void ccX() {
        if (as.iN()) {
            if (this.iqs == null) {
                this.iqs = new ImageView(this.mContext.getPageActivity());
                this.iqs.setImageResource(R.drawable.icon_nichengjun);
                this.iqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(d.this.mContext.getPageActivity(), null, com.baidu.tieba.pb.c.bSu(), true)));
                    }
                });
            }
            if (this.iqs.getParent() != null) {
                ((ViewGroup) this.iqs.getParent()).removeView(this.iqs);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.g(this.mContext.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.iqs, layoutParams);
            }
        } else if (this.iqs != null && this.iqs.getParent() != null && this.iqs.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.iqs);
        }
    }

    public void e(UserData userData) {
        this.iqu.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.aty().kG(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.iqt.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.iE().a(bg_pic, 10, this.mCallback, 0, 0, null, new Object[0]);
        }
        this.iqw.userData = userData;
    }

    public void M(float f) {
        if (!this.iqv.isShown()) {
            this.iqv.setVisibility(0);
            this.iqv.setFrame(0);
        }
        this.fRF = f;
    }

    public void brW() {
        this.iqv.cancelAnimation();
        this.iqv.setVisibility(8);
    }

    public void nX() {
        if (!this.iqv.isShown()) {
            this.iqv.setVisibility(0);
        }
        this.iqv.br();
    }
}
