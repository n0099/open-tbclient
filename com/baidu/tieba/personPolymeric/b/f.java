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
    protected TbPageContext efr;
    private NoNetworkView fDZ;
    public PbListView fEa;
    private com.baidu.tbadk.k.g fMR;
    private PluginErrorTipView hvf;
    private float itt;
    private b llk;
    private ImageView lll;
    private a llm;
    private LinearLayout lln;
    protected FrameLayout llo;
    private NoNetworkView llp;
    protected RelativeLayout llq;
    private com.baidu.tieba.personPolymeric.view.k llr;
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
        this.itt = 360.0f;
        this.llm = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.efr = tbPageContext;
            this.mRootView = view;
            this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.hvf = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lln = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.llr = new com.baidu.tieba.personPolymeric.view.k(this.efr, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.llr.a(PersonStatus.GUEST_DEFAULT);
            this.llo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.llp = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.llq = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fEa = new PbListView(this.efr.getPageActivity());
            this.fEa.getView();
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fEa.setHeight(l.getDimens(this.efr.getPageActivity(), R.dimen.ds140));
            this.fEa.setDividerLineHeight(l.getDimens(this.efr.getPageActivity(), R.dimen.ds12));
            this.fEa.setLineVisible();
            this.fEa.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes18.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b llt = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f llu;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dD("obj_locate", "3"));
                this.llt.hEt = 10;
                this.llt.hEu = new Bundle();
                this.llt.hEu.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.llu != null) {
                    this.llu.a(view, this.llt);
                }
            }
        }
    }

    public void uD(boolean z) {
        this.llq.setVisibility(8);
        int dimensionPixelSize = this.efr.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.efr.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dE(null, this.efr.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cwd() {
        if (this.llo != null) {
            if (this.lll != null) {
                this.lll.setVisibility(8);
            }
            this.lln.setVisibility(0);
            int dimensionPixelSize = this.efr.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.efr.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.efr.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.efr.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.efr.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.efr.getPageActivity(), this.llo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.efr.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.efr.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.efr.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.efr, i);
            }
            if (this.llp != null) {
                this.llp.onChangeSkinType(this.efr, i);
            }
            if (this.llr != null) {
                this.llr.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.llk = bVar;
    }

    public void bFX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.llo);
            this.refreshView = null;
        }
    }

    public void A(boolean z, int i) {
        if (this.fMR == null) {
            if (i < 0) {
                this.fMR = new com.baidu.tbadk.k.g(this.efr.getContext());
            } else {
                this.fMR = new com.baidu.tbadk.k.g(this.efr.getContext(), i);
            }
            this.fMR.onChangeSkinType();
        }
        this.fMR.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this.mRootView);
            this.fMR = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void uE(boolean z) {
        if (z) {
            din();
        }
    }

    public void Fr(int i) {
        this.llq.setVisibility(i);
    }

    public void aK(String str, boolean z) {
        if (!cgx()) {
            this.lln.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.efr.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.bFX();
                            f.this.uE(true);
                            if (f.this.llk != null) {
                                f.this.llk.dd(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.qu(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.llo, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.lll != null) {
                this.lll.setVisibility(8);
            }
        }
    }

    public boolean cgx() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<q> list) {
    }

    public void bGU() {
    }

    public void eL(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void din() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.lll == null) {
                this.lll = new ImageView(this.efr.getPageActivity());
                this.lll.setImageResource(R.drawable.icon_nichengjun);
                this.lll.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.efr.getPageActivity(), null, com.baidu.tieba.pb.c.cUW(), true)));
                    }
                });
            }
            if (this.lll.getParent() != null) {
                ((ViewGroup) this.lll.getParent()).removeView(this.lll);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.efr.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.efr.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.lll, layoutParams);
            }
        } else if (this.lll != null && this.lll.getParent() != null && this.lll.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.lll);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void csz() {
    }

    public void doRefresh() {
    }
}
