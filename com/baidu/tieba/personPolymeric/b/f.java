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
/* loaded from: classes24.dex */
public class f extends e {
    protected TbPageContext eCn;
    private NoNetworkView gdx;
    public PbListView gdy;
    private com.baidu.tbadk.k.g gmB;
    private PluginErrorTipView idG;
    private float jcd;
    private b lVP;
    private ImageView lVQ;
    private a lVR;
    private LinearLayout lVS;
    protected FrameLayout lVT;
    private NoNetworkView lVU;
    protected RelativeLayout lVV;
    private com.baidu.tieba.personPolymeric.view.k lVW;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes24.dex */
    public interface b {
        void dt(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jcd = 360.0f;
        this.lVR = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eCn = tbPageContext;
            this.mRootView = view;
            this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.idG = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lVS = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.lVW = new com.baidu.tieba.personPolymeric.view.k(this.eCn, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.lVW.a(PersonStatus.GUEST_DEFAULT);
            this.lVT = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.lVU = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.lVV = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gdy = new PbListView(this.eCn.getPageActivity());
            this.gdy.getView();
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gdy.setHeight(l.getDimens(this.eCn.getPageActivity(), R.dimen.ds140));
            this.gdy.setDividerLineHeight(l.getDimens(this.eCn.getPageActivity(), R.dimen.ds12));
            this.gdy.setLineVisible();
            this.gdy.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes24.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b lVY = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f lVZ;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dR("obj_locate", "3"));
                this.lVY.imR = 10;
                this.lVY.imS = new Bundle();
                this.lVY.imS.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.lVZ != null) {
                    this.lVZ.a(view, this.lVY);
                }
            }
        }
    }

    public void vJ(boolean z) {
        this.lVV.setVisibility(8);
        int dimensionPixelSize = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eCn.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dS(null, this.eCn.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cGb() {
        if (this.lVT != null) {
            if (this.lVQ != null) {
                this.lVQ.setVisibility(8);
            }
            this.lVS.setVisibility(0);
            int dimensionPixelSize = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eCn.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eCn.getPageActivity(), this.lVT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eCn.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eCn.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.eCn.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eCn, i);
            }
            if (this.lVU != null) {
                this.lVU.onChangeSkinType(this.eCn, i);
            }
            if (this.lVW != null) {
                this.lVW.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.lVP = bVar;
    }

    public void TK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lVT);
            this.refreshView = null;
        }
    }

    public void D(boolean z, int i) {
        if (this.gmB == null) {
            if (i < 0) {
                this.gmB = new com.baidu.tbadk.k.g(this.eCn.getContext());
            } else {
                this.gmB = new com.baidu.tbadk.k.g(this.eCn.getContext(), i);
            }
            this.gmB.onChangeSkinType();
        }
        this.gmB.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this.mRootView);
            this.gmB = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void vK(boolean z) {
        if (z) {
            dsJ();
        }
    }

    public void GR(int i) {
        this.lVV.setVisibility(i);
    }

    public void aQ(String str, boolean z) {
        if (!cki()) {
            this.lVS.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.eCn.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.TK();
                            f.this.vK(true);
                            if (f.this.lVP != null) {
                                f.this.lVP.dt(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ru(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.lVT, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.lVQ != null) {
                this.lVQ.setVisibility(8);
            }
        }
    }

    public boolean cki() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void bNw() {
    }

    public void ff(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dsJ() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.lVQ == null) {
                this.lVQ = new ImageView(this.eCn.getPageActivity());
                this.lVQ.setImageResource(R.drawable.icon_nichengjun);
                this.lVQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eCn.getPageActivity(), null, com.baidu.tieba.pb.c.dfs(), true)));
                    }
                });
            }
            if (this.lVQ.getParent() != null) {
                ((ViewGroup) this.lVQ.getParent()).removeView(this.lVQ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eCn.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eCn.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.lVQ, layoutParams);
            }
        } else if (this.lVQ != null && this.lVQ.getParent() != null && this.lVQ.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.lVQ);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cCs() {
    }

    public void doRefresh() {
    }
}
