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
    protected TbPageContext eIc;
    private NoNetworkView gjn;
    public PbListView gjo;
    private com.baidu.tbadk.k.g gso;
    private PluginErrorTipView ijD;
    private float jia;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private b mbO;
    private ImageView mbP;
    private a mbQ;
    private LinearLayout mbR;
    protected FrameLayout mbS;
    private NoNetworkView mbT;
    protected RelativeLayout mbU;
    private com.baidu.tieba.personPolymeric.view.k mbV;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes24.dex */
    public interface b {
        void dy(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jia = 360.0f;
        this.mbQ = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eIc = tbPageContext;
            this.mRootView = view;
            this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.ijD = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mbR = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mbV = new com.baidu.tieba.personPolymeric.view.k(this.eIc, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mbV.a(PersonStatus.GUEST_DEFAULT);
            this.mbS = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mbT = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mbU = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gjo = new PbListView(this.eIc.getPageActivity());
            this.gjo.getView();
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.gjo.setHeight(l.getDimens(this.eIc.getPageActivity(), R.dimen.ds140));
            this.gjo.setDividerLineHeight(l.getDimens(this.eIc.getPageActivity(), R.dimen.ds12));
            this.gjo.setLineVisible();
            this.gjo.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes24.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mbX = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mbY;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dR("obj_locate", "3"));
                this.mbX.isP = 10;
                this.mbX.isQ = new Bundle();
                this.mbX.isQ.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mbY != null) {
                    this.mbY.a(view, this.mbX);
                }
            }
        }
    }

    public void vS(boolean z) {
        this.mbU.setVisibility(8);
        int dimensionPixelSize = this.eIc.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eIc.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dS(null, this.eIc.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cIC() {
        if (this.mbS != null) {
            if (this.mbP != null) {
                this.mbP.setVisibility(8);
            }
            this.mbR.setVisibility(0);
            int dimensionPixelSize = this.eIc.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eIc.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eIc.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eIc.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eIc.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eIc.getPageActivity(), this.mbS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eIc.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eIc.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.eIc.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eIc, i);
            }
            if (this.mbT != null) {
                this.mbT.onChangeSkinType(this.eIc, i);
            }
            if (this.mbV != null) {
                this.mbV.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mbO = bVar;
    }

    public void Wk() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mbS);
            this.refreshView = null;
        }
    }

    public void D(boolean z, int i) {
        if (this.gso == null) {
            if (i < 0) {
                this.gso = new com.baidu.tbadk.k.g(this.eIc.getContext());
            } else {
                this.gso = new com.baidu.tbadk.k.g(this.eIc.getContext(), i);
            }
            this.gso.onChangeSkinType();
        }
        this.gso.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mRootView);
            this.gso = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void vT(boolean z) {
        if (z) {
            dvl();
        }
    }

    public void He(int i) {
        this.mbU.setVisibility(i);
    }

    public void aQ(String str, boolean z) {
        if (!cmK()) {
            this.mbR.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.eIc.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.Wk();
                            f.this.vT(true);
                            if (f.this.mbO != null) {
                                f.this.mbO.dy(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.rE(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mbS, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mbP != null) {
                this.mbP.setVisibility(8);
            }
        }
    }

    public boolean cmK() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void bPW() {
    }

    public void fn(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dvl() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mbP == null) {
                this.mbP = new ImageView(this.eIc.getPageActivity());
                this.mbP.setImageResource(R.drawable.icon_nichengjun);
                this.mbP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eIc.getPageActivity(), null, com.baidu.tieba.pb.c.dhU(), true)));
                    }
                });
            }
            if (this.mbP.getParent() != null) {
                ((ViewGroup) this.mbP.getParent()).removeView(this.mbP);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eIc.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eIc.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mbP, layoutParams);
            }
        } else if (this.mbP != null && this.mbP.getParent() != null && this.mbP.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mbP);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cET() {
    }

    public void doRefresh() {
    }
}
