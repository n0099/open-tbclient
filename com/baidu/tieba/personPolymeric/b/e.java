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
    private NoNetworkView fbX;
    public PbListView fbY;
    private com.baidu.tbadk.k.g fkQ;
    private PluginErrorTipView gPw;
    private float hLg;
    private b krd;
    private ImageView kre;
    private a krf;
    private LinearLayout krg;
    protected FrameLayout krh;
    private NoNetworkView kri;
    protected RelativeLayout krj;
    private k krk;
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
        this.hLg = 360.0f;
        this.krf = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.dIF = tbPageContext;
            this.mRootView = view;
            this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.gPw = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.krg = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.krk = new k(this.dIF, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.krk.a(PersonStatus.GUEST_DEFAULT);
            this.krh = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.kri = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.krj = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fbY = new PbListView(this.dIF.getPageActivity());
            this.fbY.getView();
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
            this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fbY.setHeight(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds140));
            this.fbY.setDividerLineHeight(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds12));
            this.fbY.setLineVisible();
            this.fbY.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b krm = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f krn;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").dh("obj_locate", "3"));
                this.krm.gZn = 10;
                this.krm.gZo = new Bundle();
                this.krm.gZo.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.krn != null) {
                    this.krn.a(view, this.krm);
                }
            }
        }
    }

    public void sX(boolean z) {
        this.krj.setVisibility(8);
        int dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dIF.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dj(null, this.dIF.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ceo() {
        if (this.krh != null) {
            if (this.kre != null) {
                this.kre.setVisibility(8);
            }
            this.krg.setVisibility(0);
            int dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.dIF.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.dIF.getPageActivity(), this.krh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aL(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dIF.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
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
            if (this.kri != null) {
                this.kri.onChangeSkinType(this.dIF, i);
            }
            if (this.krk != null) {
                this.krk.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.krd = bVar;
    }

    public void bqO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.krh);
            this.refreshView = null;
        }
    }

    public void y(boolean z, int i) {
        if (this.fkQ == null) {
            if (i < 0) {
                this.fkQ = new com.baidu.tbadk.k.g(this.dIF.getContext());
            } else {
                this.fkQ = new com.baidu.tbadk.k.g(this.dIF.getContext(), i);
            }
            this.fkQ.onChangeSkinType();
        }
        this.fkQ.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.mRootView);
            this.fkQ = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void sY(boolean z) {
        if (z) {
            cON();
        }
    }

    public void Bs(int i) {
        this.krj.setVisibility(i);
    }

    public void aG(String str, boolean z) {
        if (!bPM()) {
            this.krg.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.dIF.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bqO();
                            e.this.sY(true);
                            if (e.this.krd != null) {
                                e.this.krd.cS(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.nu(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.krh, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.kre != null) {
                this.kre.setVisibility(8);
            }
        }
    }

    public boolean bPM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void f(boolean z, List<o> list) {
    }

    public void brM() {
    }

    public void eh(List<o> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cON() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.kre == null) {
                this.kre = new ImageView(this.dIF.getPageActivity());
                this.kre.setImageResource(R.drawable.icon_nichengjun);
                this.kre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.dIF.getPageActivity(), null, com.baidu.tieba.pb.c.cBR(), true)));
                    }
                });
            }
            if (this.kre.getParent() != null) {
                ((ViewGroup) this.kre.getParent()).removeView(this.kre);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.dIF.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.dIF.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.kre, layoutParams);
            }
        } else if (this.kre != null && this.kre.getParent() != null && this.kre.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.kre);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void caU() {
    }

    public void doRefresh() {
    }
}
