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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes7.dex */
public class f extends e {
    protected TbPageContext eSJ;
    private com.baidu.tbadk.l.g gGD;
    private NoNetworkView gxx;
    public PbListView gxy;
    private PluginErrorTipView iCS;
    private float jEf;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private b mqV;
    private ImageView mqW;
    private a mqX;
    private LinearLayout mqY;
    protected FrameLayout mqZ;
    private NoNetworkView mra;
    protected RelativeLayout mrb;
    private com.baidu.tieba.personPolymeric.view.k mrc;
    private com.baidu.tbadk.l.h refreshView;

    /* loaded from: classes7.dex */
    public interface b {
        void dX(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jEf = 360.0f;
        this.mqX = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eSJ = tbPageContext;
            this.mRootView = view;
            this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.iCS = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mqY = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mrc = new com.baidu.tieba.personPolymeric.view.k(this.eSJ, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mrc.a(PersonStatus.GUEST_DEFAULT);
            this.mqZ = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mra = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mrb = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gxy = new PbListView(this.eSJ.getPageActivity());
            this.gxy.getView();
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gxy.setHeight(l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds140));
            this.gxy.setDividerLineHeight(l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds12));
            this.gxy.setLineVisible();
            this.gxy.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mre = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mrf;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dW("obj_locate", "3"));
                this.mre.iMc = 10;
                this.mre.iMd = new Bundle();
                this.mre.iMd.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mrf != null) {
                    this.mrf.a(view, this.mre);
                }
            }
        }
    }

    public void ww(boolean z) {
        this.mrb.setVisibility(8);
        int dimensionPixelSize = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eSJ.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dX(null, this.eSJ.getString(R.string.user_to_anti)), null);
        }
        ao.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cMM() {
        if (this.mqZ != null) {
            if (this.mqW != null) {
                this.mqW.setVisibility(8);
            }
            this.mqY.setVisibility(0);
            int dimensionPixelSize = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eSJ.getPageActivity(), this.mqZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eSJ.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eSJ.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.eSJ.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eSJ, i);
            }
            if (this.mra != null) {
                this.mra.onChangeSkinType(this.eSJ, i);
            }
            if (this.mrc != null) {
                this.mrc.onChangeSkinType(i);
            }
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mqV = bVar;
    }

    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mqZ);
            this.refreshView = null;
        }
    }

    public void C(boolean z, int i) {
        if (this.gGD == null) {
            if (i < 0) {
                this.gGD = new com.baidu.tbadk.l.g(this.eSJ.getContext());
            } else {
                this.gGD = new com.baidu.tbadk.l.g(this.eSJ.getContext(), i);
            }
            this.gGD.onChangeSkinType();
        }
        this.gGD.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this.mRootView);
            this.gGD = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void wx(boolean z) {
        if (z) {
            dwc();
        }
    }

    public void GG(int i) {
        this.mrb.setVisibility(i);
    }

    public void aR(String str, boolean z) {
        if (!cpC()) {
            this.mqY.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.eSJ.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.Vq();
                            f.this.wx(true);
                            if (f.this.mqV != null) {
                                f.this.mqV.dX(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.rj(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mqZ, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mqW != null) {
                this.mqW.setVisibility(8);
            }
        }
    }

    public boolean cpC() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<n> list) {
    }

    public void bRO() {
    }

    public void fz(List<n> list) {
        if (x.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dwc() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mqW == null) {
                this.mqW = new ImageView(this.eSJ.getPageActivity());
                this.mqW.setImageResource(R.drawable.icon_nichengjun);
                this.mqW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eSJ.getPageActivity(), null, com.baidu.tieba.pb.c.dix(), true)));
                    }
                });
            }
            if (this.mqW.getParent() != null) {
                ((ViewGroup) this.mqW.getParent()).removeView(this.mqW);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mqW, layoutParams);
            }
        } else if (this.mqW != null && this.mqW.getParent() != null && this.mqW.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mqW);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cIV() {
    }

    public void doRefresh() {
    }
}
