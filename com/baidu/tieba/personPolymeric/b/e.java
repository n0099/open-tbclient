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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
    protected TbPageContext dPv;
    private NoNetworkView fns;
    public PbListView fnt;
    private com.baidu.tbadk.k.g fwo;
    private float hZf;
    private PluginErrorTipView hcq;
    private b kMg;
    private ImageView kMh;
    private a kMi;
    private LinearLayout kMj;
    protected FrameLayout kMk;
    private NoNetworkView kMl;
    protected RelativeLayout kMm;
    private k kMn;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes11.dex */
    public interface b {
        void cT(View view);
    }

    public e(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.hZf = 360.0f;
        this.kMi = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.dPv = tbPageContext;
            this.mRootView = view;
            this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.hcq = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.kMj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.kMn = new k(this.dPv, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.kMn.a(PersonStatus.GUEST_DEFAULT);
            this.kMk = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.kMl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.kMm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fnt = new PbListView(this.dPv.getPageActivity());
            this.fnt.getView();
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fnt.setHeight(l.getDimens(this.dPv.getPageActivity(), R.dimen.ds140));
            this.fnt.setDividerLineHeight(l.getDimens(this.dPv.getPageActivity(), R.dimen.ds12));
            this.fnt.setLineVisible();
            this.fnt.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b kMp = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f kMq;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ao("c12502").dk("obj_locate", "3"));
                this.kMp.hlK = 10;
                this.kMp.hlL = new Bundle();
                this.kMp.hlL.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.kMq != null) {
                    this.kMq.a(view, this.kMp);
                }
            }
        }
    }

    public void tl(boolean z) {
        this.kMm.setVisibility(8);
        int dimensionPixelSize = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dPv.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dm(null, this.dPv.getString(R.string.user_to_anti)), null);
        }
        an.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void chT() {
        if (this.kMk != null) {
            if (this.kMh != null) {
                this.kMh.setVisibility(8);
            }
            this.kMj.setVisibility(0);
            int dimensionPixelSize = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.dPv.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.dPv.getPageActivity(), this.kMk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aO(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dPv.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.dPv.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    be.skipToLoginActivity(e.this.dPv.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.dPv, i);
            }
            if (this.kMl != null) {
                this.kMl.onChangeSkinType(this.dPv, i);
            }
            if (this.kMn != null) {
                this.kMn.onChangeSkinType(i);
            }
            an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.kMg = bVar;
    }

    public void btN() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.kMk);
            this.refreshView = null;
        }
    }

    public void A(boolean z, int i) {
        if (this.fwo == null) {
            if (i < 0) {
                this.fwo = new com.baidu.tbadk.k.g(this.dPv.getContext());
            } else {
                this.fwo = new com.baidu.tbadk.k.g(this.dPv.getContext(), i);
            }
            this.fwo.onChangeSkinType();
        }
        this.fwo.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.mRootView);
            this.fwo = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void tm(boolean z) {
        if (z) {
            cTu();
        }
    }

    public void Cw(int i) {
        this.kMm.setVisibility(i);
    }

    public void aI(String str, boolean z) {
        if (!bSR()) {
            this.kMj.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.dPv.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.btN();
                            e.this.tm(true);
                            if (e.this.kMg != null) {
                                e.this.kMg.cT(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.nR(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.kMk, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.kMh != null) {
                this.kMh.setVisibility(8);
            }
        }
    }

    public boolean bSR() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void buK() {
    }

    public void ex(List<q> list) {
        if (w.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cTu() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.kMh == null) {
                this.kMh = new ImageView(this.dPv.getPageActivity());
                this.kMh.setImageResource(R.drawable.icon_nichengjun);
                this.kMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.dPv.getPageActivity(), null, com.baidu.tieba.pb.c.cGx(), true)));
                    }
                });
            }
            if (this.kMh.getParent() != null) {
                ((ViewGroup) this.kMh.getParent()).removeView(this.kMh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.dPv.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.dPv.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.kMh, layoutParams);
            }
        } else if (this.kMh != null && this.kMh.getParent() != null && this.kMh.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.kMh);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void ceu() {
    }

    public void doRefresh() {
    }
}
