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
    protected TbPageContext cVi;
    private NoNetworkView elv;
    public PbListView elw;
    private com.baidu.tbadk.k.g euk;
    private PluginErrorTipView fVe;
    private float gLO;
    private k jnA;
    private b jnt;
    private ImageView jnu;
    private a jnv;
    private LinearLayout jnw;
    protected FrameLayout jnx;
    private NoNetworkView jny;
    protected RelativeLayout jnz;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes11.dex */
    public interface b {
        void cJ(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.gLO = 360.0f;
        this.jnv = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.cVi = tbPageContext;
            this.mRootView = view;
            this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fVe = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jnw = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jnA = new k(this.cVi, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jnA.a(PersonStatus.GUEST_DEFAULT);
            this.jnx = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jny = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jnz = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.elw = new PbListView(this.cVi.getPageActivity());
            this.elw.getView();
            this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elw.setHeight(l.getDimens(this.cVi.getPageActivity(), R.dimen.ds140));
            this.elw.setDividerLineHeight(l.getDimens(this.cVi.getPageActivity(), R.dimen.ds12));
            this.elw.setLineVisible();
            this.elw.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jnC = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.e jnD;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").cy("obj_locate", "3"));
                this.jnC.gaE = 10;
                this.jnC.gaF = new Bundle();
                this.jnC.gaF.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jnD != null) {
                    this.jnD.a(view, this.jnC);
                }
            }
        }
    }

    public void rp(boolean z) {
        this.jnz.setVisibility(8);
        int dimensionPixelSize = this.cVi.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVi.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cA(null, this.cVi.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bNc() {
        if (this.jnx != null) {
            if (this.jnu != null) {
                this.jnu.setVisibility(8);
            }
            this.jnw.setVisibility(0);
            int dimensionPixelSize = this.cVi.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.cVi.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cVi.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cVi.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cVi.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cVi.getPageActivity(), this.jnx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cVi.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.cVi.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.cVi.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cVi, i);
            }
            if (this.jny != null) {
                this.jny.onChangeSkinType(this.cVi, i);
            }
            if (this.jnA != null) {
                this.jnA.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jnt = bVar;
    }

    public void bcy() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jnx);
            this.refreshView = null;
        }
    }

    public void u(boolean z, int i) {
        if (this.euk == null) {
            if (i < 0) {
                this.euk = new com.baidu.tbadk.k.g(this.cVi.getContext());
            } else {
                this.euk = new com.baidu.tbadk.k.g(this.cVi.getContext(), i);
            }
            this.euk.onChangeSkinType();
        }
        this.euk.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.euk != null) {
            this.euk.dettachView(this.mRootView);
            this.euk = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void rq(boolean z) {
        if (z) {
            cwM();
        }
    }

    public void zY(int i) {
        this.jnz.setVisibility(i);
    }

    public void an(String str, boolean z) {
        if (!bzm()) {
            this.jnw.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.cVi.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bcy();
                            e.this.rq(true);
                            if (e.this.jnt != null) {
                                e.this.jnt.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mF(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jnx, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jnu != null) {
                this.jnu.setVisibility(8);
            }
        }
    }

    public boolean bzm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bdu() {
    }

    public void dQ(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cwM() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jnu == null) {
                this.jnu = new ImageView(this.cVi.getPageActivity());
                this.jnu.setImageResource(R.drawable.icon_nichengjun);
                this.jnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.cVi.getPageActivity(), null, com.baidu.tieba.pb.c.cke(), true)));
                    }
                });
            }
            if (this.jnu.getParent() != null) {
                ((ViewGroup) this.jnu.getParent()).removeView(this.jnu);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cVi.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cVi.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jnu, layoutParams);
            }
        } else if (this.jnu != null && this.jnu.getParent() != null && this.jnu.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jnu);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bJO() {
    }

    public void doRefresh() {
    }
}
