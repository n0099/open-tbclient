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
/* loaded from: classes9.dex */
public class e extends d {
    protected TbPageContext cRe;
    private NoNetworkView ehd;
    public PbListView ehe;
    private com.baidu.tbadk.k.g epL;
    private PluginErrorTipView fSv;
    private float gJB;
    private b jmg;
    private ImageView jmh;
    private a jmi;
    private LinearLayout jmj;
    protected FrameLayout jmk;
    private NoNetworkView jml;
    protected RelativeLayout jmm;
    private k jmn;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes9.dex */
    public interface b {
        void cI(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.gJB = 360.0f;
        this.jmi = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.cRe = tbPageContext;
            this.mRootView = view;
            this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fSv = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jmj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jmn = new k(this.cRe, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jmn.a(PersonStatus.GUEST_DEFAULT);
            this.jmk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jml = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jmm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.ehe = new PbListView(this.cRe.getPageActivity());
            this.ehe.getView();
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.ehe.setHeight(l.getDimens(this.cRe.getPageActivity(), R.dimen.ds140));
            this.ehe.setDividerLineHeight(l.getDimens(this.cRe.getPageActivity(), R.dimen.ds12));
            this.ehe.setLineVisible();
            this.ehe.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jmq = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.e jmr;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || this.userData.getBaijiahaoInfo() == null) {
                TiebaStatic.log(new an("c12502").cp("obj_locate", "3"));
                this.jmq.fYp = 10;
                this.jmq.fYq = new Bundle();
                this.jmq.fYq.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jmr != null) {
                    this.jmr.a(view, this.jmq);
                }
            }
        }
    }

    public void rl(boolean z) {
        this.jmm.setVisibility(8);
        int dimensionPixelSize = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cRe.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cr(null, this.cRe.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bLw() {
        if (this.jmk != null) {
            if (this.jmh != null) {
                this.jmh.setVisibility(8);
            }
            this.jmj.setVisibility(0);
            int dimensionPixelSize = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cRe.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cRe.getPageActivity(), this.jmk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cRe.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.cRe.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.cRe.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cRe, i);
            }
            if (this.jml != null) {
                this.jml.onChangeSkinType(this.cRe, i);
            }
            if (this.jmn != null) {
                this.jmn.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jmg = bVar;
    }

    public void baf() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jmk);
            this.refreshView = null;
        }
    }

    public void t(boolean z, int i) {
        if (this.epL == null) {
            if (i < 0) {
                this.epL = new com.baidu.tbadk.k.g(this.cRe.getContext());
            } else {
                this.epL = new com.baidu.tbadk.k.g(this.cRe.getContext(), i);
            }
            this.epL.onChangeSkinType();
        }
        this.epL.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.epL != null) {
            this.epL.dettachView(this.mRootView);
            this.epL = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void rm(boolean z) {
        if (z) {
            cvo();
        }
    }

    public void zR(int i) {
        this.jmm.setVisibility(i);
    }

    public void an(String str, boolean z) {
        if (!bxH()) {
            this.jmj.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.cRe.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.baf();
                            e.this.rm(true);
                            if (e.this.jmg != null) {
                                e.this.jmg.cI(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mo(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jmk, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jmh != null) {
                this.jmh.setVisibility(8);
            }
        }
    }

    public boolean bxH() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bbc() {
    }

    public void dU(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cvo() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jmh == null) {
                this.jmh = new ImageView(this.cRe.getPageActivity());
                this.jmh.setImageResource(R.drawable.icon_nichengjun);
                this.jmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.cRe.getPageActivity(), null, com.baidu.tieba.pb.d.cix(), true)));
                    }
                });
            }
            if (this.jmh.getParent() != null) {
                ((ViewGroup) this.jmh.getParent()).removeView(this.jmh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cRe.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cRe.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jmh, layoutParams);
            }
        } else if (this.jmh != null && this.jmh.getParent() != null && this.jmh.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jmh);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bIj() {
    }

    public void doRefresh() {
    }
}
