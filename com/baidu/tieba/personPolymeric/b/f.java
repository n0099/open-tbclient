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
/* loaded from: classes7.dex */
public class f extends e {
    protected TbPageContext eWx;
    private NoNetworkView gCe;
    public PbListView gCf;
    private com.baidu.tbadk.l.g gLk;
    private PluginErrorTipView iKz;
    private float jLG;
    private b mCn;
    private ImageView mCo;
    private a mCp;
    private LinearLayout mCq;
    protected FrameLayout mCr;
    private NoNetworkView mCs;
    protected RelativeLayout mCt;
    private com.baidu.tieba.personPolymeric.view.k mCu;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.l.h refreshView;

    /* loaded from: classes7.dex */
    public interface b {
        void dV(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jLG = 360.0f;
        this.mCp = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eWx = tbPageContext;
            this.mRootView = view;
            this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.iKz = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mCq = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mCu = new com.baidu.tieba.personPolymeric.view.k(this.eWx, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mCu.a(PersonStatus.GUEST_DEFAULT);
            this.mCr = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mCs = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mCt = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gCf = new PbListView(this.eWx.getPageActivity());
            this.gCf.getView();
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gCf.setHeight(l.getDimens(this.eWx.getPageActivity(), R.dimen.ds140));
            this.gCf.setDividerLineHeight(l.getDimens(this.eWx.getPageActivity(), R.dimen.ds12));
            this.gCf.setLineVisible();
            this.gCf.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mCx = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mCy;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ar("c12502").dR("obj_locate", "3"));
                this.mCx.iTH = 10;
                this.mCx.iTI = new Bundle();
                this.mCx.iTI.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mCy != null) {
                    this.mCy.a(view, this.mCx);
                }
            }
        }
    }

    public void wN(boolean z) {
        this.mCt.setVisibility(8);
        int dimensionPixelSize = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eWx.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dS(null, this.eWx.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cOX() {
        if (this.mCr != null) {
            if (this.mCo != null) {
                this.mCo.setVisibility(8);
            }
            this.mCq.setVisibility(0);
            int dimensionPixelSize = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eWx.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eWx.getPageActivity(), this.mCr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aU(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eWx.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eWx.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(f.this.eWx.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eWx, i);
            }
            if (this.mCs != null) {
                this.mCs.onChangeSkinType(this.eWx, i);
            }
            if (this.mCu != null) {
                this.mCu.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mCn = bVar;
    }

    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mCr);
            this.refreshView = null;
        }
    }

    public void C(boolean z, int i) {
        if (this.gLk == null) {
            if (i < 0) {
                this.gLk = new com.baidu.tbadk.l.g(this.eWx.getContext());
            } else {
                this.gLk = new com.baidu.tbadk.l.g(this.eWx.getContext(), i);
            }
            this.gLk.onChangeSkinType();
        }
        this.gLk.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this.mRootView);
            this.gLk = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void wO(boolean z) {
        if (z) {
            dyB();
        }
    }

    public void Hb(int i) {
        this.mCt.setVisibility(i);
    }

    public void aQ(String str, boolean z) {
        if (!cqZ()) {
            this.mCq.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.eWx.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.Xc();
                            f.this.wO(true);
                            if (f.this.mCn != null) {
                                f.this.mCn.dV(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.rp(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mCr, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mCo != null) {
                this.mCo.setVisibility(8);
            }
        }
    }

    public boolean cqZ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void i(boolean z, List<n> list) {
    }

    public void bSE() {
    }

    public void fx(List<n> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dyB() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mCo == null) {
                this.mCo = new ImageView(this.eWx.getPageActivity());
                this.mCo.setImageResource(R.drawable.icon_nichengjun);
                this.mCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eWx.getPageActivity(), null, com.baidu.tieba.pb.c.dkZ(), true)));
                    }
                });
            }
            if (this.mCo.getParent() != null) {
                ((ViewGroup) this.mCo.getParent()).removeView(this.mCo);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mCo, layoutParams);
            }
        } else if (this.mCo != null && this.mCo.getParent() != null && this.mCo.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mCo);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cKv() {
    }

    public void doRefresh() {
    }
}
