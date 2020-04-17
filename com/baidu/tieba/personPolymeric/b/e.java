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
    protected TbPageContext duG;
    private NoNetworkView ePl;
    public PbListView ePm;
    private com.baidu.tbadk.k.g eYb;
    private PluginErrorTipView gAH;
    private float hwn;
    private b jZg;
    private ImageView jZh;
    private a jZi;
    private LinearLayout jZj;
    protected FrameLayout jZk;
    private NoNetworkView jZl;
    protected RelativeLayout jZm;
    private k jZn;
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
        this.hwn = 360.0f;
        this.jZi = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.duG = tbPageContext;
            this.mRootView = view;
            this.ePl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.gAH = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jZj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jZn = new k(this.duG, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jZn.a(PersonStatus.GUEST_DEFAULT);
            this.jZk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jZl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jZm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.ePm = new PbListView(this.duG.getPageActivity());
            this.ePm.getView();
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ePm.setHeight(l.getDimens(this.duG.getPageActivity(), R.dimen.ds140));
            this.ePm.setDividerLineHeight(l.getDimens(this.duG.getPageActivity(), R.dimen.ds12));
            this.ePm.setLineVisible();
            this.ePm.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jZp = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f jZq;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").cI("obj_locate", "3"));
                this.jZp.gKv = 10;
                this.jZp.gKw = new Bundle();
                this.jZp.gKw.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jZq != null) {
                    this.jZq.a(view, this.jZp);
                }
            }
        }
    }

    public void sz(boolean z) {
        this.jZm.setVisibility(8);
        int dimensionPixelSize = this.duG.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.duG.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cK(null, this.duG.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bXR() {
        if (this.jZk != null) {
            if (this.jZh != null) {
                this.jZh.setVisibility(8);
            }
            this.jZj.setVisibility(0);
            int dimensionPixelSize = this.duG.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.duG.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.duG.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.duG.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.duG.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.duG.getPageActivity(), this.jZk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aI(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.duG.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.duG.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.duG.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.duG, i);
            }
            if (this.jZl != null) {
                this.jZl.onChangeSkinType(this.duG, i);
            }
            if (this.jZn != null) {
                this.jZn.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jZg = bVar;
    }

    public void blt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jZk);
            this.refreshView = null;
        }
    }

    public void v(boolean z, int i) {
        if (this.eYb == null) {
            if (i < 0) {
                this.eYb = new com.baidu.tbadk.k.g(this.duG.getContext());
            } else {
                this.eYb = new com.baidu.tbadk.k.g(this.duG.getContext(), i);
            }
            this.eYb.onChangeSkinType();
        }
        this.eYb.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this.mRootView);
            this.eYb = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void sA(boolean z) {
        if (z) {
            cHQ();
        }
    }

    public void AH(int i) {
        this.jZm.setVisibility(i);
    }

    public void at(String str, boolean z) {
        if (!bJu()) {
            this.jZj.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.duG.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.blt();
                            e.this.sA(true);
                            if (e.this.jZg != null) {
                                e.this.jZg.cR(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mS(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jZk, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jZh != null) {
                this.jZh.setVisibility(8);
            }
        }
    }

    public boolean bJu() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bmq() {
    }

    public void eb(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cHQ() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jZh == null) {
                this.jZh = new ImageView(this.duG.getPageActivity());
                this.jZh.setImageResource(R.drawable.icon_nichengjun);
                this.jZh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.duG.getPageActivity(), null, com.baidu.tieba.pb.c.cvd(), true)));
                    }
                });
            }
            if (this.jZh.getParent() != null) {
                ((ViewGroup) this.jZh.getParent()).removeView(this.jZh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.duG.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.duG.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jZh, layoutParams);
            }
        } else if (this.jZh != null && this.jZh.getParent() != null && this.jZh.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jZh);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bUy() {
    }

    public void doRefresh() {
    }
}
