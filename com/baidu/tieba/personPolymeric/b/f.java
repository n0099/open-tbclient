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
/* loaded from: classes23.dex */
public class f extends e {
    protected TbPageContext ehG;
    private NoNetworkView fHl;
    public PbListView fHm;
    private com.baidu.tbadk.k.g fQf;
    private PluginErrorTipView hCk;
    private float iAP;
    private b luh;
    private ImageView lui;
    private a luj;
    private LinearLayout luk;
    protected FrameLayout lul;
    private NoNetworkView lum;
    protected RelativeLayout lun;
    private com.baidu.tieba.personPolymeric.view.k luo;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes23.dex */
    public interface b {
        void dl(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.iAP = 360.0f;
        this.luj = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.ehG = tbPageContext;
            this.mRootView = view;
            this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.hCk = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.luk = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.luo = new com.baidu.tieba.personPolymeric.view.k(this.ehG, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.luo.a(PersonStatus.GUEST_DEFAULT);
            this.lul = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.lum = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.lun = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fHm = new PbListView(this.ehG.getPageActivity());
            this.fHm.getView();
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fHm.setHeight(l.getDimens(this.ehG.getPageActivity(), R.dimen.ds140));
            this.fHm.setDividerLineHeight(l.getDimens(this.ehG.getPageActivity(), R.dimen.ds12));
            this.fHm.setLineVisible();
            this.fHm.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes23.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b luq = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f lur;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dF("obj_locate", "3"));
                this.luq.hLv = 10;
                this.luq.hLw = new Bundle();
                this.luq.hLw.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.lur != null) {
                    this.lur.a(view, this.luq);
                }
            }
        }
    }

    public void uL(boolean z) {
        this.lun.setVisibility(8);
        int dimensionPixelSize = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ehG.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dG(null, this.ehG.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void czx() {
        if (this.lul != null) {
            if (this.lui != null) {
                this.lui.setVisibility(8);
            }
            this.luk.setVisibility(0);
            int dimensionPixelSize = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.ehG.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.ehG.getPageActivity(), this.lul, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ehG.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.ehG.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.ehG.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.ehG, i);
            }
            if (this.lum != null) {
                this.lum.onChangeSkinType(this.ehG, i);
            }
            if (this.luo != null) {
                this.luo.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.luh = bVar;
    }

    public void bHn() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lul);
            this.refreshView = null;
        }
    }

    public void A(boolean z, int i) {
        if (this.fQf == null) {
            if (i < 0) {
                this.fQf = new com.baidu.tbadk.k.g(this.ehG.getContext());
            } else {
                this.fQf = new com.baidu.tbadk.k.g(this.ehG.getContext(), i);
            }
            this.fQf.onChangeSkinType();
        }
        this.fQf.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this.mRootView);
            this.fQf = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void uM(boolean z) {
        if (z) {
            dlS();
        }
    }

    public void FS(int i) {
        this.lun.setVisibility(i);
    }

    public void aK(String str, boolean z) {
        if (!cdF()) {
            this.luk.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.ehG.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.bHn();
                            f.this.uM(true);
                            if (f.this.luh != null) {
                                f.this.luh.dl(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.qL(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.lul, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.lui != null) {
                this.lui.setVisibility(8);
            }
        }
    }

    public boolean cdF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<q> list) {
    }

    public void bIk() {
    }

    public void eT(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dlS() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.lui == null) {
                this.lui = new ImageView(this.ehG.getPageActivity());
                this.lui.setImageResource(R.drawable.icon_nichengjun);
                this.lui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.ehG.getPageActivity(), null, com.baidu.tieba.pb.c.cYB(), true)));
                    }
                });
            }
            if (this.lui.getParent() != null) {
                ((ViewGroup) this.lui.getParent()).removeView(this.lui);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.ehG.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.ehG.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.lui, layoutParams);
            }
        } else if (this.lui != null && this.lui.getParent() != null && this.lui.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.lui);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cvO() {
    }

    public void doRefresh() {
    }
}
