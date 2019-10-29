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
    private Rect apc;
    protected TbPageContext cfl;
    private com.baidu.tbadk.m.g dEq;
    private NoNetworkView dwI;
    public PbListView dwJ;
    private PluginErrorTipView fbx;
    protected BdPersonListView iqP;
    private b iqQ;
    private ImageView iqR;
    protected PersonExpandImageView iqS;
    protected View iqT;
    private ContinuousAnimationView iqU;
    protected NavigationBar iqW;
    protected RelativeLayout iqX;
    protected NavigationBar mNavigationBar;
    protected NoDataView mNoDataView;
    public View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private float fSP = 360.0f;
    private a iqV = new a();
    private int mSkinType = 3;
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cit = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.b.d.6
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.drawImageTo(d.this.iqS);
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
            this.cfl = tbPageContext;
            this.mRootView = view;
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
            this.iqP = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
            this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fbx = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.iqW = (NavigationBar) this.mRootView.findViewById(R.id.person_center_anti_navigation_bar);
            this.iqX = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.dwJ = new PbListView(this.cfl.getPageActivity());
            this.dwJ.getView();
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dwJ.setHeight(l.getDimens(this.cfl.getPageActivity(), R.dimen.ds140));
            this.dwJ.setDividerLineHeight(l.getDimens(this.cfl.getPageActivity(), R.dimen.ds12));
            this.dwJ.setLineVisible();
            this.dwJ.setLineColorResource(R.color.cp_bg_line_e);
            this.iqP.setNextPage(this.dwJ);
            this.iqS = (PersonExpandImageView) this.mRootView.findViewById(R.id.person_polymeric_header_expand_img);
            this.iqS.setInitHeight(this.cfl.getResources().getDimensionPixelSize(R.dimen.tbds496));
            this.iqT = view.findViewById(R.id.view_top_background_cover);
            this.iqT.setVisibility(8);
            this.iqP.setOuterExpandView(this.iqS);
            this.iqU = (ContinuousAnimationView) this.mRootView.findViewById(R.id.person_polymeric_header_refresh_image);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void a(View view, com.baidu.tieba.view.g gVar) {
        if (view != null && gVar != null) {
            this.iqV.ira = gVar;
            view.setOnClickListener(this.iqV);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b iqZ = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.g ira;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new an("c12502").bS("obj_locate", "3"));
            this.iqZ.fhu = 10;
            this.iqZ.aSR = new Bundle();
            this.iqZ.aSR.putSerializable(UserData.TYPE_USER, this.userData);
            if (this.ira != null) {
                this.ira.a(view, this.iqZ);
            }
        }
    }

    public void px(boolean z) {
        this.iqX.setVisibility(8);
        this.iqW.setVisibility(0);
        this.iqW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (!z) {
            this.iqW.setCenterTextTitle(this.cfl.getString(R.string.ta_homepage));
        } else {
            this.iqW.setCenterTextTitle(this.cfl.getString(R.string.my_homepage));
        }
        this.iqW.showBottomLine();
        int dimensionPixelSize = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cfl.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.bU(null, this.cfl.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bsX() {
        if (this.mRootView != null) {
            this.iqP.setVisibility(8);
            if (this.iqR != null) {
                this.iqR.setVisibility(8);
            }
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.switchNaviBarStatus(false);
            this.mNavigationBar.setRegisterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.cfl.getPageActivity(), "notlogin_3", "click", 1, new Object[0]);
                    bc.skipToRegisterActivity(d.this.cfl.getPageActivity());
                }
            });
            this.mNavigationBar.setLoginClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.cfl.getPageActivity(), "notlogin_4", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.cfl.getPageActivity());
                }
            });
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds320);
            int dimensionPixelSize2 = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cfl.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aj(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cfl.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(d.this.cfl.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(d.this.cfl.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cfl, i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(null, i);
            this.iqW.onChangeSkinType(null, i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            if (this.iqP.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.iqP.getAdapter().notifyDataSetChanged();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.dwI.onChangeSkinType(this.cfl, i);
            this.fbx.onChangeSkinType(this.cfl, i);
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.iqQ = bVar;
    }

    public void aJo() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
        }
    }

    public void p(boolean z, int i) {
        if (this.dEq == null) {
            if (i < 0) {
                this.dEq = new com.baidu.tbadk.m.g(this.cfl.getContext());
            } else {
                this.dEq = new com.baidu.tbadk.m.g(this.cfl.getContext(), i);
            }
            this.dEq.onChangeSkinType();
        }
        this.dEq.attachView(this.mRootView, z);
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this.mRootView);
            this.dEq = null;
        }
    }

    public void py(boolean z) {
        if (z) {
            caM();
        }
    }

    public void xy(int i) {
        this.iqP.setVisibility(i);
    }

    private int caL() {
        if (this.apc == null) {
            this.apc = new Rect();
        }
        if (this.iqS == null) {
            return l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280);
        }
        this.iqS.getLocalVisibleRect(this.apc);
        if (this.apc.bottom > 0) {
            return this.apc.bottom + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        }
        return l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds280);
    }

    public void aj(String str, boolean z) {
        if (!bfm()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.m.h(this.cfl.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            d.this.aJo();
                            d.this.py(true);
                            if (d.this.iqQ != null) {
                                d.this.iqQ.cH(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(caL());
            this.refreshView.setSubText(str);
            this.refreshView.attachView(this.mRootView, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            this.iqP.setVisibility(8);
            if (this.iqR != null) {
                this.iqR.setVisibility(8);
            }
        }
    }

    public boolean bfm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void startLoadData() {
        if (this.dwJ != null) {
            this.dwJ.startLoadData();
        }
    }

    public void endLoadData() {
        if (this.dwJ != null) {
            this.dwJ.endLoadData();
        }
    }

    public void iU(boolean z) {
        if (this.iqP != null && this.dwJ != null) {
            this.dwJ.endLoadData();
            if (z) {
                this.dwJ.setText(this.cfl.getString(R.string.list_no_more));
            } else {
                this.dwJ.setText("");
            }
        }
    }

    public void e(boolean z, List<m> list) {
        if (this.iqP != null && this.dwJ != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                    aKk();
                    return;
                }
            }
            this.dwJ.endLoadData();
            if (z) {
                this.dwJ.setText(this.cfl.getString(R.string.list_no_more));
            } else {
                this.dwJ.setText("");
            }
        }
    }

    public void aKk() {
        if (this.iqP != null && this.dwJ != null) {
            this.iqP.setNextPage(null);
            this.dwJ.hideEmptyView();
        }
    }

    public void xz(int i) {
        if (i == 0) {
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.dwJ.setLineColorResource(R.color.cp_bg_line_e);
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dwJ.setLineVisible();
        } else if (i == 1) {
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_d);
            this.dwJ.setLineGone();
        }
        this.dwJ.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    public void ee(List<m> list) {
        if (v.isEmpty(list)) {
            list = new ArrayList<>();
        }
        if (this.iqP.getVisibility() != 0) {
            this.iqP.setVisibility(0);
        }
        this.iqP.setData(list);
    }

    public void caM() {
        if (as.isOn()) {
            if (this.iqR == null) {
                this.iqR = new ImageView(this.cfl.getPageActivity());
                this.iqR.setImageResource(R.drawable.icon_nichengjun);
                this.iqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.d.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(d.this.cfl.getPageActivity(), null, com.baidu.tieba.pb.c.bQg(), true)));
                    }
                });
            }
            if (this.iqR.getParent() != null) {
                ((ViewGroup) this.iqR.getParent()).removeView(this.iqR);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cfl.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cfl.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.iqR, layoutParams);
            }
        } else if (this.iqR != null && this.iqR.getParent() != null && this.iqR.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.iqR);
        }
    }

    public void d(UserData userData) {
        this.iqT.setVisibility(0);
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.avu().freePicCache(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.cfl.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.cfl.getPageActivity().getApplicationContext(), R.drawable.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.iqS.setImageBitmap(logoBitmap);
            }
        } else {
            com.baidu.adp.lib.f.c.fT().a(bg_pic, 10, this.cit, 0, 0, null, new Object[0]);
        }
        this.iqV.userData = userData;
    }

    public void controllTheStaticProgress(float f) {
        if (!this.iqU.isShown()) {
            this.iqU.setVisibility(0);
            this.iqU.setFrame(0);
        }
        this.fSP = f;
    }

    public void bpN() {
        this.iqU.cancelAnimation();
        this.iqU.setVisibility(8);
    }

    public void doRefresh() {
        if (!this.iqU.isShown()) {
            this.iqU.setVisibility(0);
        }
        this.iqU.playAnimation();
    }
}
