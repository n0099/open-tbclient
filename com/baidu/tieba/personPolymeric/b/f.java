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
/* loaded from: classes23.dex */
public class f extends e {
    protected TbPageContext eGu;
    private NoNetworkView giU;
    public PbListView giV;
    private com.baidu.tbadk.k.g grV;
    private PluginErrorTipView ikr;
    private float jiM;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private b mcg;
    private ImageView mch;
    private a mci;
    private LinearLayout mcj;
    protected FrameLayout mck;
    private NoNetworkView mcl;
    protected RelativeLayout mcm;
    private com.baidu.tieba.personPolymeric.view.k mcn;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes23.dex */
    public interface b {
        void dC(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jiM = 360.0f;
        this.mci = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eGu = tbPageContext;
            this.mRootView = view;
            this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.ikr = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mcj = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mcn = new com.baidu.tieba.personPolymeric.view.k(this.eGu, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mcn.a(PersonStatus.GUEST_DEFAULT);
            this.mck = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mcl = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mcm = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.giV = new PbListView(this.eGu.getPageActivity());
            this.giV.getView();
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.giV.setHeight(l.getDimens(this.eGu.getPageActivity(), R.dimen.ds140));
            this.giV.setDividerLineHeight(l.getDimens(this.eGu.getPageActivity(), R.dimen.ds12));
            this.giV.setLineVisible();
            this.giV.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes23.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mcp = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mcq;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ar("c12502").dR("obj_locate", "3"));
                this.mcp.itD = 10;
                this.mcp.itE = new Bundle();
                this.mcp.itE.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mcq != null) {
                    this.mcq.a(view, this.mcp);
                }
            }
        }
    }

    public void vV(boolean z) {
        this.mcm.setVisibility(8);
        int dimensionPixelSize = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eGu.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dS(null, this.eGu.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cIh() {
        if (this.mck != null) {
            if (this.mch != null) {
                this.mch.setVisibility(8);
            }
            this.mcj.setVisibility(0);
            int dimensionPixelSize = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eGu.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eGu.getPageActivity(), this.mck, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eGu.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eGu.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(f.this.eGu.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eGu, i);
            }
            if (this.mcl != null) {
                this.mcl.onChangeSkinType(this.eGu, i);
            }
            if (this.mcn != null) {
                this.mcn.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mcg = bVar;
    }

    public void VB() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mck);
            this.refreshView = null;
        }
    }

    public void D(boolean z, int i) {
        if (this.grV == null) {
            if (i < 0) {
                this.grV = new com.baidu.tbadk.k.g(this.eGu.getContext());
            } else {
                this.grV = new com.baidu.tbadk.k.g(this.eGu.getContext(), i);
            }
            this.grV.onChangeSkinType();
        }
        this.grV.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this.mRootView);
            this.grV = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void vW(boolean z) {
        if (z) {
            duL();
        }
    }

    public void HC(int i) {
        this.mcm.setVisibility(i);
    }

    public void aQ(String str, boolean z) {
        if (!cmm()) {
            this.mcj.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.eGu.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.VB();
                            f.this.vW(true);
                            if (f.this.mcg != null) {
                                f.this.mcg.dC(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.sc(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mck, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mch != null) {
                this.mch.setVisibility(8);
            }
        }
    }

    public boolean cmm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void g(boolean z, List<q> list) {
    }

    public void bPp() {
    }

    public void fn(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void duL() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mch == null) {
                this.mch = new ImageView(this.eGu.getPageActivity());
                this.mch.setImageResource(R.drawable.icon_nichengjun);
                this.mch.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eGu.getPageActivity(), null, com.baidu.tieba.pb.c.dhr(), true)));
                    }
                });
            }
            if (this.mch.getParent() != null) {
                ((ViewGroup) this.mch.getParent()).removeView(this.mch);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mch, layoutParams);
            }
        } else if (this.mch != null && this.mch.getParent() != null && this.mch.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mch);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cEy() {
    }

    public void doRefresh() {
    }
}
