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
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.view.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends d {
    protected TbPageContext duK;
    private NoNetworkView ePq;
    public PbListView ePr;
    private com.baidu.tbadk.k.g eYg;
    private PluginErrorTipView gAN;
    private float hwt;
    private b jZk;
    private ImageView jZl;
    private a jZm;
    private LinearLayout jZn;
    protected FrameLayout jZo;
    private NoNetworkView jZp;
    protected RelativeLayout jZq;
    private k jZr;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes11.dex */
    public interface b {
        void cR(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.hwt = 360.0f;
        this.jZm = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.duK = tbPageContext;
            this.mRootView = view;
            this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.gAN = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jZn = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jZr = new k(this.duK, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jZr.a(PersonStatus.GUEST_DEFAULT);
            this.jZo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jZp = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jZq = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.ePr = new PbListView(this.duK.getPageActivity());
            this.ePr.getView();
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ePr.setHeight(l.getDimens(this.duK.getPageActivity(), R.dimen.ds140));
            this.ePr.setDividerLineHeight(l.getDimens(this.duK.getPageActivity(), R.dimen.ds12));
            this.ePr.setLineVisible();
            this.ePr.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jZt = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f jZu;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").cI("obj_locate", "3"));
                this.jZt.gKB = 10;
                this.jZt.gKC = new Bundle();
                this.jZt.gKC.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jZu != null) {
                    this.jZu.a(view, this.jZt);
                }
            }
        }
    }

    public void sz(boolean z) {
        this.jZq.setVisibility(8);
        int dimensionPixelSize = this.duK.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.duK.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cK(null, this.duK.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bXQ() {
        if (this.jZo != null) {
            if (this.jZl != null) {
                this.jZl.setVisibility(8);
            }
            this.jZn.setVisibility(0);
            int dimensionPixelSize = this.duK.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.duK.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.duK.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.duK.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.duK.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.duK.getPageActivity(), this.jZo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aI(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.duK.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.duK.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.duK.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.duK, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.duK, i);
            }
            if (this.jZp != null) {
                this.jZp.onChangeSkinType(this.duK, i);
            }
            if (this.jZr != null) {
                this.jZr.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jZk = bVar;
    }

    public void blr() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jZo);
            this.refreshView = null;
        }
    }

    public void v(boolean z, int i) {
        if (this.eYg == null) {
            if (i < 0) {
                this.eYg = new com.baidu.tbadk.k.g(this.duK.getContext());
            } else {
                this.eYg = new com.baidu.tbadk.k.g(this.duK.getContext(), i);
            }
            this.eYg.onChangeSkinType();
        }
        this.eYg.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this.mRootView);
            this.eYg = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void sA(boolean z) {
        if (z) {
            cHO();
        }
    }

    public void AH(int i) {
        this.jZq.setVisibility(i);
    }

    public void at(String str, boolean z) {
        if (!bJt()) {
            this.jZn.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.duK.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.blr();
                            e.this.sA(true);
                            if (e.this.jZk != null) {
                                e.this.jZk.cR(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mS(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jZo, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jZl != null) {
                this.jZl.setVisibility(8);
            }
        }
    }

    public boolean bJt() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bmo() {
    }

    public void eb(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cHO() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jZl == null) {
                this.jZl = new ImageView(this.duK.getPageActivity());
                this.jZl.setImageResource(R.drawable.icon_nichengjun);
                this.jZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.duK.getPageActivity(), null, com.baidu.tieba.pb.c.cvb(), true)));
                    }
                });
            }
            if (this.jZl.getParent() != null) {
                ((ViewGroup) this.jZl.getParent()).removeView(this.jZl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.duK.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.duK.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jZl, layoutParams);
            }
        } else if (this.jZl != null && this.jZl.getParent() != null && this.jZl.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jZl);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bUx() {
    }

    public void doRefresh() {
    }
}
