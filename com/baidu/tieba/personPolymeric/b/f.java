package com.baidu.tieba.personPolymeric.b;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class f extends e {
    protected TbPageContext efn;
    private NoNetworkView fDV;
    public PbListView fDW;
    private com.baidu.tbadk.k.g fMN;
    private PluginErrorTipView huZ;
    private float itn;
    private b lkZ;
    private ImageView lla;
    private a llb;
    private LinearLayout llc;
    protected FrameLayout lld;
    private NoNetworkView lle;
    protected RelativeLayout llf;
    private com.baidu.tieba.personPolymeric.view.k llg;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes18.dex */
    public interface b {
        void dd(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.itn = 360.0f;
        this.llb = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.efn = tbPageContext;
            this.mRootView = view;
            this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.huZ = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.llc = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.llg = new com.baidu.tieba.personPolymeric.view.k(this.efn, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.llg.a(PersonStatus.GUEST_DEFAULT);
            this.lld = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.lle = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.llf = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fDW = new PbListView(this.efn.getPageActivity());
            this.fDW.getView();
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fDW.setHeight(l.getDimens(this.efn.getPageActivity(), R.dimen.ds140));
            this.fDW.setDividerLineHeight(l.getDimens(this.efn.getPageActivity(), R.dimen.ds12));
            this.fDW.setLineVisible();
            this.fDW.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes18.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b lli = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f llj;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dD("obj_locate", "3"));
                this.lli.hEn = 10;
                this.lli.hEo = new Bundle();
                this.lli.hEo.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.llj != null) {
                    this.llj.a(view, this.lli);
                }
            }
        }
    }

    public void uB(boolean z) {
        this.llf.setVisibility(8);
        int dimensionPixelSize = this.efn.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.efn.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dE(null, this.efn.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cwc() {
        if (this.lld != null) {
            if (this.lla != null) {
                this.lla.setVisibility(8);
            }
            this.llc.setVisibility(0);
            int dimensionPixelSize = this.efn.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.efn.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.efn.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.efn.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.efn.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.efn.getPageActivity(), this.lld, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.efn.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.efn.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.efn.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.efn, i);
            }
            if (this.lle != null) {
                this.lle.onChangeSkinType(this.efn, i);
            }
            if (this.llg != null) {
                this.llg.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.lkZ = bVar;
    }

    public void bFW() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lld);
            this.refreshView = null;
        }
    }

    public void A(boolean z, int i) {
        if (this.fMN == null) {
            if (i < 0) {
                this.fMN = new com.baidu.tbadk.k.g(this.efn.getContext());
            } else {
                this.fMN = new com.baidu.tbadk.k.g(this.efn.getContext(), i);
            }
            this.fMN.onChangeSkinType();
        }
        this.fMN.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this.mRootView);
            this.fMN = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void uC(boolean z) {
        if (z) {
            dik();
        }
    }

    public void Fr(int i) {
        this.llf.setVisibility(i);
    }

    public void aK(String str, boolean z) {
        if (!cgw()) {
            this.llc.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.efn.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.bFW();
                            f.this.uC(true);
                            if (f.this.lkZ != null) {
                                f.this.lkZ.dd(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.qu(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.lld, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.lla != null) {
                this.lla.setVisibility(8);
            }
        }
    }

    public boolean cgw() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<q> list) {
    }

    public void bGT() {
    }

    public void eL(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dik() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.lla == null) {
                this.lla = new ImageView(this.efn.getPageActivity());
                this.lla.setImageResource(R.drawable.icon_nichengjun);
                this.lla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.efn.getPageActivity(), null, com.baidu.tieba.pb.c.cUV(), true)));
                    }
                });
            }
            if (this.lla.getParent() != null) {
                ((ViewGroup) this.lla.getParent()).removeView(this.lla);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.efn.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.efn.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.lla, layoutParams);
            }
        } else if (this.lla != null && this.lla.getParent() != null && this.lla.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.lla);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void csy() {
    }

    public void doRefresh() {
    }
}
