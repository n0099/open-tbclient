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
    protected TbPageContext cVh;
    private NoNetworkView eli;
    public PbListView elj;
    private com.baidu.tbadk.k.g etX;
    private PluginErrorTipView fUR;
    private float gLC;
    private b jnh;
    private ImageView jni;
    private a jnj;
    private LinearLayout jnk;
    protected FrameLayout jnl;
    private NoNetworkView jnm;
    protected RelativeLayout jnn;
    private k jno;
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
        this.gLC = 360.0f;
        this.jnj = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.cVh = tbPageContext;
            this.mRootView = view;
            this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fUR = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jnk = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jno = new k(this.cVh, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jno.a(PersonStatus.GUEST_DEFAULT);
            this.jnl = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jnm = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jnn = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.elj = new PbListView(this.cVh.getPageActivity());
            this.elj.getView();
            this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elj.setHeight(l.getDimens(this.cVh.getPageActivity(), R.dimen.ds140));
            this.elj.setDividerLineHeight(l.getDimens(this.cVh.getPageActivity(), R.dimen.ds12));
            this.elj.setLineVisible();
            this.elj.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jnq = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.e jnr;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").cy("obj_locate", "3"));
                this.jnq.gar = 10;
                this.jnq.gas = new Bundle();
                this.jnq.gas.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jnr != null) {
                    this.jnr.a(view, this.jnq);
                }
            }
        }
    }

    public void rp(boolean z) {
        this.jnn.setVisibility(8);
        int dimensionPixelSize = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVh.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cA(null, this.cVh.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bNb() {
        if (this.jnl != null) {
            if (this.jni != null) {
                this.jni.setVisibility(8);
            }
            this.jnk.setVisibility(0);
            int dimensionPixelSize = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cVh.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cVh.getPageActivity(), this.jnl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cVh.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.cVh.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.cVh.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cVh, i);
            }
            if (this.jnm != null) {
                this.jnm.onChangeSkinType(this.cVh, i);
            }
            if (this.jno != null) {
                this.jno.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jnh = bVar;
    }

    public void bcx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jnl);
            this.refreshView = null;
        }
    }

    public void u(boolean z, int i) {
        if (this.etX == null) {
            if (i < 0) {
                this.etX = new com.baidu.tbadk.k.g(this.cVh.getContext());
            } else {
                this.etX = new com.baidu.tbadk.k.g(this.cVh.getContext(), i);
            }
            this.etX.onChangeSkinType();
        }
        this.etX.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this.mRootView);
            this.etX = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void rq(boolean z) {
        if (z) {
            cwL();
        }
    }

    public void zY(int i) {
        this.jnn.setVisibility(i);
    }

    public void an(String str, boolean z) {
        if (!bzl()) {
            this.jnk.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.cVh.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bcx();
                            e.this.rq(true);
                            if (e.this.jnh != null) {
                                e.this.jnh.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mF(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jnl, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jni != null) {
                this.jni.setVisibility(8);
            }
        }
    }

    public boolean bzl() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bdt() {
    }

    public void dQ(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cwL() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jni == null) {
                this.jni = new ImageView(this.cVh.getPageActivity());
                this.jni.setImageResource(R.drawable.icon_nichengjun);
                this.jni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.cVh.getPageActivity(), null, com.baidu.tieba.pb.c.ckd(), true)));
                    }
                });
            }
            if (this.jni.getParent() != null) {
                ((ViewGroup) this.jni.getParent()).removeView(this.jni);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cVh.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cVh.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jni, layoutParams);
            }
        } else if (this.jni != null && this.jni.getParent() != null && this.jni.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jni);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bJN() {
    }

    public void doRefresh() {
    }
}
