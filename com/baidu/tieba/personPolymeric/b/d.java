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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private Rect aoK;
    protected TbPageContext ceu;
    private com.baidu.tbadk.m.g dDz;
    private NoNetworkView dvR;
    public PbListView dvS;
    private PluginErrorTipView faG;
    protected BdPersonListView ipY;
    private b ipZ;
    private ImageView iqa;
    protected PersonExpandImageView iqb;
    protected View iqc;
    private ContinuousAnimationView iqd;
    protected NavigationBar iqf;
    protected RelativeLayout iqg;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private float fRY = 360.0f;
    private a iqe = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> chB = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.drawImageTo(d.this.iqb);
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
        void cH(View view);
    }

    public d(TbPageContext tbPageContext, View view) {
        if (tbPageContext != null && view != null) {
            this.ceu = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
            this.ipY = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.faG = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.iqf = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.iqg = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dvS = new PbListView(this.ceu.getPageActivity());
            this.dvS.getView();
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dvS.setHeight(l.getDimens(this.ceu.getPageActivity(), R.dimen.ds140));
            this.dvS.setDividerLineHeight(l.getDimens(this.ceu.getPageActivity(), R.dimen.ds12));
            this.dvS.setLineVisible();
            this.dvS.setLineColorResource(R.color.cp_bg_line_e);
            this.ipY.setNextPage(this.dvS);
            this.iqb = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.iqb.setInitHeight(this.ceu.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.iqc = view.findViewById(R.id.view_top_background_cover);
            this.iqc.setVisibility(8);
            this.ipY.setOuterExpandView(this.iqb);
            this.iqd = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.iqe.iqj = gVar;
            view.setOnClickListener(this.iqe);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b iqi = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g iqj;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").bS("obj_locate", "3"));
            this.iqi.fgD = 10;
            this.iqi.aSz = new Bundle();
            this.iqi.aSz.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.iqj != null) {
                this.iqj.a(view, this.iqi);
            }
        }
    }

    public void px(boolean z) {
        this.iqg.setVisibility(8);
        this.iqf.setVisibility(0);
        this.iqf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.iqf.setCenterTextTitle(this.ceu.getString(R.string.ta_homepage));
        } else {
            this.iqf.setCenterTextTitle(this.ceu.getString(R.string.my_homepage));
        }
        this.iqf.showBottomLine();
        int dimensionPixelSize = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ceu.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bU(null, this.ceu.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bsV() {
        if (this.mRootView != null) {
            this.ipY.setVisibility(8);
            if (this.iqa != null) {
                this.iqa.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ceu.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bc.skipToRegisterActivity(d.this.ceu.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ceu.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.ceu.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds320);
            int dimensionPixelSize2 = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.ceu.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.ah(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ceu.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.ceu.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.ceu.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ceu, i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.iqf.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            if (this.ipY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.ipY.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dvR.onChangeSkinType(this.ceu, i);
            this.faG.onChangeSkinType(this.ceu, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.ipZ = bVar;
    }

    public void aJm() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void p(boolean z, int i) {
        if (this.dDz == null) {
            if (i < 0) {
                this.dDz = new com.baidu.tbadk.m.g(this.ceu.getContext());
            } else {
                this.dDz = new com.baidu.tbadk.m.g(this.ceu.getContext(), i);
            }
            this.dDz.onChangeSkinType();
        }
        this.dDz.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this.mRootView);
            this.dDz = null;
        }
    }

    public void py(boolean z) {
        if (z) {
            caK();
        }
    }

    public void xx(int i) {
        this.ipY.setVisibility(i);
    }

    private int caJ() {
        if (this.aoK == null) {
            this.aoK = new Rect();
        }
        if (this.iqb == null) {
            return l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.iqb.getLocalVisibleRect(this.aoK);
        if (this.aoK.bottom > 0) {
            return this.aoK.bottom + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void aj(String str, boolean z) {
        if (!bfk()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.ceu.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            d.this.aJm();
                            d.this.py(true);
                            if (d.this.ipZ != null) {
                                d.this.ipZ.cH(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(caJ());
            this.refreshView.setSubText(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            this.ipY.setVisibility(8);
            if (this.iqa != null) {
                this.iqa.setVisibility(8);
            }
        }
    }

    public boolean bfk() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void startLoadData() {
        if (this.dvS != null) {
            this.dvS.startLoadData();
        }
    }

    public void endLoadData() {
        if (this.dvS != null) {
            this.dvS.endLoadData();
        }
    }

    public void iU(boolean z) {
        if (this.ipY != null && this.dvS != null) {
            this.dvS.endLoadData();
            if (z) {
                this.dvS.setText(this.ceu.getString(R.string.list_no_more));
            } else {
                this.dvS.setText("");
            }
        }
    }

    public void e(boolean z, List<m> list) {
        if (this.ipY != null && this.dvS != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aKi();
                    return;
                }
            }
            this.dvS.endLoadData();
            if (z) {
                this.dvS.setText(this.ceu.getString(R.string.list_no_more));
            } else {
                this.dvS.setText("");
            }
        }
    }

    public void aKi() {
        if (this.ipY != null && this.dvS != null) {
            this.ipY.setNextPage(null);
            this.dvS.hideEmptyView();
        }
    }

    public void xy(int i) {
        if (i == 0) {
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dvS.setLineColorResource(R.color.cp_bg_line_e);
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.setLineVisible();
        } else if (i == 1) {
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_d);
            this.dvS.setLineGone();
        }
        this.dvS.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ee(List<m> list) {
        if (v.isEmpty(list)) {
            list = new ArrayList<>();
        }
        if (this.ipY.getVisibility() != 0) {
            this.ipY.setVisibility(0);
        }
        this.ipY.setData(list);
    }

    public void caK() {
        if (as.isOn()) {
            if (this.iqa == null) {
                this.iqa = new ImageView(this.ceu.getPageActivity());
                this.iqa.setImageResource(R.drawable.icon_nichengjun);
                this.iqa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(d.this.ceu.getPageActivity(), null, com.baidu.tieba.pb.c.bQe(), true)));
                    }
                });
            }
            if (this.iqa.getParent() != null) {
                ((ViewGroup) this.iqa.getParent()).removeView(this.iqa);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.ceu.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.ceu.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.iqa, layoutParams);
            }
        } else if (this.iqa != null && this.iqa.getParent() != null && this.iqa.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.iqa);
        }
    }

    public void d(UserData userData) {
        this.iqc.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.avs().freePicCache(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.ceu.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.ceu.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.iqb.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fT().a(bg_pic, 10, this.chB, 0, 0, null, new Object[0]);
        }
        this.iqe.userData = userData;
    }

    public void controllTheStaticProgress(float f) {
        if (!this.iqd.isShown()) {
            this.iqd.setVisibility(0);
            this.iqd.setFrame(0);
        }
        this.fRY = f;
    }

    public void bpL() {
        this.iqd.cancelAnimation();
        this.iqd.setVisibility(8);
    }

    public void doRefresh() {
        if (!this.iqd.isShown()) {
            this.iqd.setVisibility(0);
        }
        this.iqd.playAnimation();
    }
}
