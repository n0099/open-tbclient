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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes18.dex */
public class e extends d {
    protected TbPageContext dVN;
    private com.baidu.tbadk.k.g fBv;
    private NoNetworkView fsB;
    public PbListView fsC;
    private PluginErrorTipView hhZ;
    private float ifh;
    private b kVg;
    private ImageView kVh;
    private a kVi;
    private LinearLayout kVj;
    protected FrameLayout kVk;
    private NoNetworkView kVl;
    protected RelativeLayout kVm;
    private k kVn;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes18.dex */
    public interface b {
        void cZ(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.ifh = 360.0f;
        this.kVi = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.dVN = tbPageContext;
            this.mRootView = view;
            this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.hhZ = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.kVj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.kVn = new k(this.dVN, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.kVn.a(PersonStatus.GUEST_DEFAULT);
            this.kVk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.kVl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.kVm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fsC = new PbListView(this.dVN.getPageActivity());
            this.fsC.getView();
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fsC.setHeight(l.getDimens(this.dVN.getPageActivity(), R.dimen.ds140));
            this.fsC.setDividerLineHeight(l.getDimens(this.dVN.getPageActivity(), R.dimen.ds12));
            this.fsC.setLineVisible();
            this.fsC.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes18.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b kVp = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f kVq;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ap("c12502").dn("obj_locate", "3"));
                this.kVp.hrw = 10;
                this.kVp.hrx = new Bundle();
                this.kVp.hrx.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.kVq != null) {
                    this.kVq.a(view, this.kVp);
                }
            }
        }
    }

    public void tR(boolean z) {
        this.kVm.setVisibility(8);
        int dimensionPixelSize = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dVN.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.m31do(null, this.dVN.getString(R.string.user_to_anti)), null);
        }
        ao.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void clt() {
        if (this.kVk != null) {
            if (this.kVh != null) {
                this.kVh.setVisibility(8);
            }
            this.kVj.setVisibility(0);
            int dimensionPixelSize = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.dVN.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.dVN.getPageActivity(), this.kVk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aP(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dVN.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.dVN.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bf.skipToLoginActivity(e.this.dVN.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dVN, i);
            }
            if (this.kVl != null) {
                this.kVl.onChangeSkinType(this.dVN, i);
            }
            if (this.kVn != null) {
                this.kVn.onChangeSkinType(i);
            }
            ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.kVg = bVar;
    }

    public void bwX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.kVk);
            this.refreshView = null;
        }
    }

    public void A(boolean z, int i) {
        if (this.fBv == null) {
            if (i < 0) {
                this.fBv = new com.baidu.tbadk.k.g(this.dVN.getContext());
            } else {
                this.fBv = new com.baidu.tbadk.k.g(this.dVN.getContext(), i);
            }
            this.fBv.onChangeSkinType();
        }
        this.fBv.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.mRootView);
            this.fBv = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void tS(boolean z) {
        if (z) {
            cXl();
        }
    }

    public void CW(int i) {
        this.kVm.setVisibility(i);
    }

    public void aG(String str, boolean z) {
        if (!bWj()) {
            this.kVj.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.dVN.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bwX();
                            e.this.tS(true);
                            if (e.this.kVg != null) {
                                e.this.kVg.cZ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.oj(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.kVk, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.kVh != null) {
                this.kVh.setVisibility(8);
            }
        }
    }

    public boolean bWj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void bxU() {
    }

    public void eD(List<q> list) {
        if (x.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cXl() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.kVh == null) {
                this.kVh = new ImageView(this.dVN.getPageActivity());
                this.kVh.setImageResource(R.drawable.icon_nichengjun);
                this.kVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.dVN.getPageActivity(), null, com.baidu.tieba.pb.c.cKh(), true)));
                    }
                });
            }
            if (this.kVh.getParent() != null) {
                ((ViewGroup) this.kVh.getParent()).removeView(this.kVh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.kVh, layoutParams);
            }
        } else if (this.kVh != null && this.kVh.getParent() != null && this.kVh.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.kVh);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void chU() {
    }

    public void doRefresh() {
    }
}
