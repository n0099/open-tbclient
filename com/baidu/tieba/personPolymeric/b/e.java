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
    protected TbPageContext cVg;
    private NoNetworkView elh;
    public PbListView eli;
    private com.baidu.tbadk.k.g etW;
    private PluginErrorTipView fUP;
    private float gLA;
    private b jnf;
    private ImageView jng;
    private a jnh;
    private LinearLayout jni;
    protected FrameLayout jnj;
    private NoNetworkView jnk;
    protected RelativeLayout jnl;
    private k jnm;
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
        this.gLA = 360.0f;
        this.jnh = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.cVg = tbPageContext;
            this.mRootView = view;
            this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fUP = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jni = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.jnm = new k(this.cVg, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.jnm.a(PersonStatus.GUEST_DEFAULT);
            this.jnj = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.jnk = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.jnl = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.eli = new PbListView(this.cVg.getPageActivity());
            this.eli.getView();
            this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
            this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
            this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.eli.setHeight(l.getDimens(this.cVg.getPageActivity(), R.dimen.ds140));
            this.eli.setDividerLineHeight(l.getDimens(this.cVg.getPageActivity(), R.dimen.ds12));
            this.eli.setLineVisible();
            this.eli.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jno = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.e jnp;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").cy("obj_locate", "3"));
                this.jno.gap = 10;
                this.jno.gaq = new Bundle();
                this.jno.gaq.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jnp != null) {
                    this.jnp.a(view, this.jno);
                }
            }
        }
    }

    public void rp(boolean z) {
        this.jnl.setVisibility(8);
        int dimensionPixelSize = this.cVg.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVg.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cA(null, this.cVg.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bMZ() {
        if (this.jnj != null) {
            if (this.jng != null) {
                this.jng.setVisibility(8);
            }
            this.jni.setVisibility(0);
            int dimensionPixelSize = this.cVg.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.cVg.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cVg.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cVg.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cVg.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cVg.getPageActivity(), this.jnj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cVg.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.cVg.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.cVg.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cVg, i);
            }
            if (this.jnk != null) {
                this.jnk.onChangeSkinType(this.cVg, i);
            }
            if (this.jnm != null) {
                this.jnm.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.jnf = bVar;
    }

    public void bcv() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jnj);
            this.refreshView = null;
        }
    }

    public void u(boolean z, int i) {
        if (this.etW == null) {
            if (i < 0) {
                this.etW = new com.baidu.tbadk.k.g(this.cVg.getContext());
            } else {
                this.etW = new com.baidu.tbadk.k.g(this.cVg.getContext(), i);
            }
            this.etW.onChangeSkinType();
        }
        this.etW.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.etW != null) {
            this.etW.dettachView(this.mRootView);
            this.etW = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void rq(boolean z) {
        if (z) {
            cwJ();
        }
    }

    public void zY(int i) {
        this.jnl.setVisibility(i);
    }

    public void an(String str, boolean z) {
        if (!bzj()) {
            this.jni.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.cVg.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bcv();
                            e.this.rq(true);
                            if (e.this.jnf != null) {
                                e.this.jnf.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mF(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.jnj, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.jng != null) {
                this.jng.setVisibility(8);
            }
        }
    }

    public boolean bzj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bdr() {
    }

    public void dQ(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cwJ() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.jng == null) {
                this.jng = new ImageView(this.cVg.getPageActivity());
                this.jng.setImageResource(R.drawable.icon_nichengjun);
                this.jng.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.cVg.getPageActivity(), null, com.baidu.tieba.pb.c.ckb(), true)));
                    }
                });
            }
            if (this.jng.getParent() != null) {
                ((ViewGroup) this.jng.getParent()).removeView(this.jng);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cVg.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cVg.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.jng, layoutParams);
            }
        } else if (this.jng != null && this.jng.getParent() != null && this.jng.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.jng);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bJL() {
    }

    public void doRefresh() {
    }
}
