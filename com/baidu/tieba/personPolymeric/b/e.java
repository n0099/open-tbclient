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
import com.baidu.adp.widget.ListView.o;
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
    protected TbPageContext dIF;
    private NoNetworkView fci;
    public PbListView fcj;
    private com.baidu.tbadk.k.g flb;
    private PluginErrorTipView gPH;
    private float hLT;
    private b ksj;
    private ImageView ksk;
    private a ksl;
    private LinearLayout ksm;
    protected FrameLayout ksn;
    private NoNetworkView kso;
    protected RelativeLayout ksp;
    private k ksq;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes11.dex */
    public interface b {
        void cS(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.hLT = 360.0f;
        this.ksl = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.dIF = tbPageContext;
            this.mRootView = view;
            this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.gPH = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.ksm = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.ksq = new k(this.dIF, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.ksq.a(PersonStatus.GUEST_DEFAULT);
            this.ksn = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.kso = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.ksp = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fcj = new PbListView(this.dIF.getPageActivity());
            this.fcj.getView();
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fcj.setHeight(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds140));
            this.fcj.setDividerLineHeight(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds12));
            this.fcj.setLineVisible();
            this.fcj.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b kss = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f kst;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").dh("obj_locate", "3"));
                this.kss.gZy = 10;
                this.kss.gZz = new Bundle();
                this.kss.gZz.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.kst != null) {
                    this.kst.a(view, this.kss);
                }
            }
        }
    }

    public void sX(boolean z) {
        this.ksp.setVisibility(8);
        int dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dIF.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dj(null, this.dIF.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cew() {
        if (this.ksn != null) {
            if (this.ksk != null) {
                this.ksk.setVisibility(8);
            }
            this.ksm.setVisibility(0);
            int dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.dIF.getPageActivity(), this.ksn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aL(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dIF.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.dIF.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.dIF.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dIF, i);
            }
            if (this.kso != null) {
                this.kso.onChangeSkinType(this.dIF, i);
            }
            if (this.ksq != null) {
                this.ksq.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.ksj = bVar;
    }

    public void bqQ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.ksn);
            this.refreshView = null;
        }
    }

    public void y(boolean z, int i) {
        if (this.flb == null) {
            if (i < 0) {
                this.flb = new com.baidu.tbadk.k.g(this.dIF.getContext());
            } else {
                this.flb = new com.baidu.tbadk.k.g(this.dIF.getContext(), i);
            }
            this.flb.onChangeSkinType();
        }
        this.flb.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.mRootView);
            this.flb = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void sY(boolean z) {
        if (z) {
            cPd();
        }
    }

    public void Bu(int i) {
        this.ksp.setVisibility(i);
    }

    public void aG(String str, boolean z) {
        if (!bPO()) {
            this.ksm.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.dIF.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bqQ();
                            e.this.sY(true);
                            if (e.this.ksj != null) {
                                e.this.ksj.cS(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.nw(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.ksn, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.ksk != null) {
                this.ksk.setVisibility(8);
            }
        }
    }

    public boolean bPO() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void f(boolean z, List<o> list) {
    }

    public void brO() {
    }

    public void ej(List<o> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cPd() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.ksk == null) {
                this.ksk = new ImageView(this.dIF.getPageActivity());
                this.ksk.setImageResource(R.drawable.icon_nichengjun);
                this.ksk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.dIF.getPageActivity(), null, com.baidu.tieba.pb.c.cCh(), true)));
                    }
                });
            }
            if (this.ksk.getParent() != null) {
                ((ViewGroup) this.ksk.getParent()).removeView(this.ksk);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.dIF.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.dIF.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.ksk, layoutParams);
            }
        } else if (this.ksk != null && this.ksk.getParent() != null && this.ksk.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.ksk);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cbc() {
    }

    public void doRefresh() {
    }
}
