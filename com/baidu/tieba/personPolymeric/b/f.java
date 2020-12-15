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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes24.dex */
public class f extends e {
    protected TbPageContext eNx;
    private com.baidu.tbadk.l.g gAg;
    private NoNetworkView grf;
    public PbListView grg;
    private PluginErrorTipView ivm;
    private float jwq;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private b mqo;
    private ImageView mqp;
    private a mqq;
    private LinearLayout mqr;
    protected FrameLayout mqs;
    private NoNetworkView mqt;
    protected RelativeLayout mqu;
    private com.baidu.tieba.personPolymeric.view.k mqv;
    private com.baidu.tbadk.l.h refreshView;

    /* loaded from: classes24.dex */
    public interface b {
        void dN(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jwq = 360.0f;
        this.mqq = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eNx = tbPageContext;
            this.mRootView = view;
            this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.ivm = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mqr = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mqv = new com.baidu.tieba.personPolymeric.view.k(this.eNx, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mqv.a(PersonStatus.GUEST_DEFAULT);
            this.mqs = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mqt = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mqu = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.grg = new PbListView(this.eNx.getPageActivity());
            this.grg.getView();
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.grg.setHeight(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds140));
            this.grg.setDividerLineHeight(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds12));
            this.grg.setLineVisible();
            this.grg.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes24.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mqx = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mqy;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ar("c12502").dY("obj_locate", "3"));
                this.mqx.iEx = 10;
                this.mqx.iEy = new Bundle();
                this.mqx.iEy.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mqy != null) {
                    this.mqy.a(view, this.mqx);
                }
            }
        }
    }

    public void wz(boolean z) {
        this.mqu.setVisibility(8);
        int dimensionPixelSize = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eNx.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dZ(null, this.eNx.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cNx() {
        if (this.mqs != null) {
            if (this.mqp != null) {
                this.mqp.setVisibility(8);
            }
            this.mqr.setVisibility(0);
            int dimensionPixelSize = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eNx.getPageActivity(), this.mqs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aZ(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eNx.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eNx.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(f.this.eNx.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eNx, i);
            }
            if (this.mqt != null) {
                this.mqt.onChangeSkinType(this.eNx, i);
            }
            if (this.mqv != null) {
                this.mqv.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mqo = bVar;
    }

    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mqs);
            this.refreshView = null;
        }
    }

    public void D(boolean z, int i) {
        if (this.gAg == null) {
            if (i < 0) {
                this.gAg = new com.baidu.tbadk.l.g(this.eNx.getContext());
            } else {
                this.gAg = new com.baidu.tbadk.l.g(this.eNx.getContext(), i);
            }
            this.gAg.onChangeSkinType();
        }
        this.gAg.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this.mRootView);
            this.gAg = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void wA(boolean z) {
        if (z) {
            dAe();
        }
    }

    public void It(int i) {
        this.mqu.setVisibility(i);
    }

    public void aR(String str, boolean z) {
        if (!cqA()) {
            this.mqr.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.eNx.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.Yb();
                            f.this.wA(true);
                            if (f.this.mqo != null) {
                                f.this.mqo.dN(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.sD(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mqs, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mqp != null) {
                this.mqp.setVisibility(8);
            }
        }
    }

    public boolean cqA() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void bTb() {
    }

    public void fz(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dAe() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mqp == null) {
                this.mqp = new ImageView(this.eNx.getPageActivity());
                this.mqp.setImageResource(R.drawable.icon_nichengjun);
                this.mqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eNx.getPageActivity(), null, com.baidu.tieba.pb.c.dmE(), true)));
                    }
                });
            }
            if (this.mqp.getParent() != null) {
                ((ViewGroup) this.mqp.getParent()).removeView(this.mqp);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mqp, layoutParams);
            }
        } else if (this.mqp != null && this.mqp.getParent() != null && this.mqp.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mqp);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cJM() {
    }

    public void doRefresh() {
    }
}
