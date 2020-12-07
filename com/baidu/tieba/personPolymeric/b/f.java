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
    private com.baidu.tbadk.l.g gAe;
    private NoNetworkView grd;
    public PbListView gre;
    private PluginErrorTipView ivk;
    private float jwo;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private b mqm;
    private ImageView mqn;
    private a mqo;
    private LinearLayout mqp;
    protected FrameLayout mqq;
    private NoNetworkView mqr;
    protected RelativeLayout mqs;
    private com.baidu.tieba.personPolymeric.view.k mqt;
    private com.baidu.tbadk.l.h refreshView;

    /* loaded from: classes24.dex */
    public interface b {
        void dN(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jwo = 360.0f;
        this.mqo = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eNx = tbPageContext;
            this.mRootView = view;
            this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.ivk = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mqp = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mqt = new com.baidu.tieba.personPolymeric.view.k(this.eNx, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mqt.a(PersonStatus.GUEST_DEFAULT);
            this.mqq = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mqr = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mqs = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gre = new PbListView(this.eNx.getPageActivity());
            this.gre.getView();
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gre.setHeight(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds140));
            this.gre.setDividerLineHeight(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds12));
            this.gre.setLineVisible();
            this.gre.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes24.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mqv = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mqw;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ar("c12502").dY("obj_locate", "3"));
                this.mqv.iEv = 10;
                this.mqv.iEw = new Bundle();
                this.mqv.iEw.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mqw != null) {
                    this.mqw.a(view, this.mqv);
                }
            }
        }
    }

    public void wz(boolean z) {
        this.mqs.setVisibility(8);
        int dimensionPixelSize = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eNx.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dZ(null, this.eNx.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cNw() {
        if (this.mqq != null) {
            if (this.mqn != null) {
                this.mqn.setVisibility(8);
            }
            this.mqp.setVisibility(0);
            int dimensionPixelSize = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eNx.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eNx.getPageActivity(), this.mqq, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aZ(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eNx.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
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
            if (this.mqr != null) {
                this.mqr.onChangeSkinType(this.eNx, i);
            }
            if (this.mqt != null) {
                this.mqt.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mqm = bVar;
    }

    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mqq);
            this.refreshView = null;
        }
    }

    public void D(boolean z, int i) {
        if (this.gAe == null) {
            if (i < 0) {
                this.gAe = new com.baidu.tbadk.l.g(this.eNx.getContext());
            } else {
                this.gAe = new com.baidu.tbadk.l.g(this.eNx.getContext(), i);
            }
            this.gAe.onChangeSkinType();
        }
        this.gAe.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this.mRootView);
            this.gAe = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void wA(boolean z) {
        if (z) {
            dAd();
        }
    }

    public void It(int i) {
        this.mqs.setVisibility(i);
    }

    public void aR(String str, boolean z) {
        if (!cqz()) {
            this.mqp.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.eNx.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.Yb();
                            f.this.wA(true);
                            if (f.this.mqm != null) {
                                f.this.mqm.dN(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.sD(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mqq, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mqn != null) {
                this.mqn.setVisibility(8);
            }
        }
    }

    public boolean cqz() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void bTa() {
    }

    public void fz(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dAd() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mqn == null) {
                this.mqn = new ImageView(this.eNx.getPageActivity());
                this.mqn.setImageResource(R.drawable.icon_nichengjun);
                this.mqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eNx.getPageActivity(), null, com.baidu.tieba.pb.c.dmD(), true)));
                    }
                });
            }
            if (this.mqn.getParent() != null) {
                ((ViewGroup) this.mqn.getParent()).removeView(this.mqn);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mqn, layoutParams);
            }
        } else if (this.mqn != null && this.mqn.getParent() != null && this.mqn.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mqn);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cJL() {
    }

    public void doRefresh() {
    }
}
