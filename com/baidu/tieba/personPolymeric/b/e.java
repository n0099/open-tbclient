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
/* loaded from: classes8.dex */
public class e extends d {
    protected TbPageContext cQU;
    private NoNetworkView egT;
    public PbListView egU;
    private com.baidu.tbadk.k.g eoy;
    private PluginErrorTipView fPm;
    private float gGm;
    private b jiF;
    private ImageView jiG;
    private a jiH;
    private LinearLayout jiI;
    protected FrameLayout jiJ;
    private NoNetworkView jiK;
    protected RelativeLayout jiL;
    private k jiM;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes8.dex */
    public interface b {
        void cD(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.gGm = 360.0f;
        this.jiH = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.cQU = tbPageContext;
            this.mRootView = view;
            this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fPm = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jiI = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jiM = new k(this.cQU, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jiM.a(PersonStatus.GUEST_DEFAULT);
            this.jiJ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jiK = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jiL = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.egU = new PbListView(this.cQU.getPageActivity());
            this.egU.getView();
            this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
            this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
            this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.egU.setHeight(l.getDimens(this.cQU.getPageActivity(), R.dimen.ds140));
            this.egU.setDividerLineHeight(l.getDimens(this.cQU.getPageActivity(), R.dimen.ds12));
            this.egU.setLineVisible();
            this.egU.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jiO = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.e jiP;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || this.userData.getBaijiahaoInfo() == null) {
                TiebaStatic.log(new an("c12502").cp("obj_locate", "3"));
                this.jiO.fVg = 10;
                this.jiO.fVh = new Bundle();
                this.jiO.fVh.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jiP != null) {
                    this.jiP.a(view, this.jiO);
                }
            }
        }
    }

    public void qY(boolean z) {
        this.jiL.setVisibility(8);
        int dimensionPixelSize = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cQU.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cr(null, this.cQU.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bKr() {
        if (this.jiJ != null) {
            if (this.jiG != null) {
                this.jiG.setVisibility(8);
            }
            this.jiI.setVisibility(0);
            int dimensionPixelSize = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cQU.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cQU.getPageActivity(), this.jiJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aA(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cQU.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.cQU.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.cQU.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cQU, i);
            }
            if (this.jiK != null) {
                this.jiK.onChangeSkinType(this.cQU, i);
            }
            if (this.jiM != null) {
                this.jiM.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jiF = bVar;
    }

    public void aZK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jiJ);
            this.refreshView = null;
        }
    }

    public void s(boolean z, int i) {
        if (this.eoy == null) {
            if (i < 0) {
                this.eoy = new com.baidu.tbadk.k.g(this.cQU.getContext());
            } else {
                this.eoy = new com.baidu.tbadk.k.g(this.cQU.getContext(), i);
            }
            this.eoy.onChangeSkinType();
        }
        this.eoy.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this.mRootView);
            this.eoy = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void qZ(boolean z) {
        if (z) {
            cuh();
        }
    }

    public void zM(int i) {
        this.jiL.setVisibility(i);
    }

    public void an(String str, boolean z) {
        if (!bwF()) {
            this.jiI.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.cQU.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.aZK();
                            e.this.qZ(true);
                            if (e.this.jiF != null) {
                                e.this.jiF.cD(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mo(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jiJ, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jiG != null) {
                this.jiG.setVisibility(8);
            }
        }
    }

    public boolean bwF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void baH() {
    }

    public void dU(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cuh() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jiG == null) {
                this.jiG = new ImageView(this.cQU.getPageActivity());
                this.jiG.setImageResource(R.drawable.icon_nichengjun);
                this.jiG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.cQU.getPageActivity(), null, com.baidu.tieba.pb.d.chp(), true)));
                    }
                });
            }
            if (this.jiG.getParent() != null) {
                ((ViewGroup) this.jiG.getParent()).removeView(this.jiG);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cQU.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cQU.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jiG, layoutParams);
            }
        } else if (this.jiG != null && this.jiG.getParent() != null && this.jiG.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jiG);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bHh() {
    }

    public void doRefresh() {
    }
}
