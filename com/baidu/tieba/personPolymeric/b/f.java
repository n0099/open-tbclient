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
/* loaded from: classes8.dex */
public class f extends e {
    protected TbPageContext eXu;
    private NoNetworkView gCe;
    public PbListView gCf;
    private com.baidu.tbadk.l.g gLj;
    private PluginErrorTipView iHz;
    private float jIL;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private b mvB;
    private ImageView mvC;
    private a mvD;
    private LinearLayout mvE;
    protected FrameLayout mvF;
    private NoNetworkView mvG;
    protected RelativeLayout mvH;
    private com.baidu.tieba.personPolymeric.view.k mvI;
    private com.baidu.tbadk.l.h refreshView;

    /* loaded from: classes8.dex */
    public interface b {
        void dX(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jIL = 360.0f;
        this.mvD = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eXu = tbPageContext;
            this.mRootView = view;
            this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.iHz = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mvE = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mvI = new com.baidu.tieba.personPolymeric.view.k(this.eXu, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mvI.a(PersonStatus.GUEST_DEFAULT);
            this.mvF = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mvG = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mvH = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gCf = new PbListView(this.eXu.getPageActivity());
            this.gCf.getView();
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gCf.setHeight(l.getDimens(this.eXu.getPageActivity(), R.dimen.ds140));
            this.gCf.setDividerLineHeight(l.getDimens(this.eXu.getPageActivity(), R.dimen.ds12));
            this.gCf.setLineVisible();
            this.gCf.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mvK = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mvL;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dX("obj_locate", "3"));
                this.mvK.iQJ = 10;
                this.mvK.iQK = new Bundle();
                this.mvK.iQK.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mvL != null) {
                    this.mvL.a(view, this.mvK);
                }
            }
        }
    }

    public void wA(boolean z) {
        this.mvH.setVisibility(8);
        int dimensionPixelSize = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eXu.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dY(null, this.eXu.getString(R.string.user_to_anti)), null);
        }
        ao.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cQD() {
        if (this.mvF != null) {
            if (this.mvC != null) {
                this.mvC.setVisibility(8);
            }
            this.mvE.setVisibility(0);
            int dimensionPixelSize = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eXu.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eXu.getPageActivity(), this.mvF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aX(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eXu.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eXu.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.eXu.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eXu, i);
            }
            if (this.mvG != null) {
                this.mvG.onChangeSkinType(this.eXu, i);
            }
            if (this.mvI != null) {
                this.mvI.onChangeSkinType(i);
            }
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mvB = bVar;
    }

    public void Zi() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mvF);
            this.refreshView = null;
        }
    }

    public void C(boolean z, int i) {
        if (this.gLj == null) {
            if (i < 0) {
                this.gLj = new com.baidu.tbadk.l.g(this.eXu.getContext());
            } else {
                this.gLj = new com.baidu.tbadk.l.g(this.eXu.getContext(), i);
            }
            this.gLj.onChangeSkinType();
        }
        this.gLj.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this.mRootView);
            this.gLj = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void wB(boolean z) {
        if (z) {
            dzT();
        }
    }

    public void In(int i) {
        this.mvH.setVisibility(i);
    }

    public void aR(String str, boolean z) {
        if (!ctt()) {
            this.mvE.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.eXu.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.Zi();
                            f.this.wB(true);
                            if (f.this.mvB != null) {
                                f.this.mvB.dX(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.sP(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mvF, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mvC != null) {
                this.mvC.setVisibility(8);
            }
        }
    }

    public boolean ctt() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<n> list) {
    }

    public void bVF() {
    }

    public void fz(List<n> list) {
        if (x.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dzT() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mvC == null) {
                this.mvC = new ImageView(this.eXu.getPageActivity());
                this.mvC.setImageResource(R.drawable.icon_nichengjun);
                this.mvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eXu.getPageActivity(), null, com.baidu.tieba.pb.c.dmo(), true)));
                    }
                });
            }
            if (this.mvC.getParent() != null) {
                ((ViewGroup) this.mvC.getParent()).removeView(this.mvC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mvC, layoutParams);
            }
        } else if (this.mvC != null && this.mvC.getParent() != null && this.mvC.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mvC);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cMM() {
    }

    public void doRefresh() {
    }
}
