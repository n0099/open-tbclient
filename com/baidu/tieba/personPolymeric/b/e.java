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
    protected TbPageContext cVv;
    private NoNetworkView elL;
    public PbListView elM;
    private com.baidu.tbadk.k.g euG;
    private PluginErrorTipView fVN;
    private float gMT;
    private b joS;
    private ImageView joT;
    private a joU;
    private LinearLayout joV;
    protected FrameLayout joW;
    private NoNetworkView joX;
    protected RelativeLayout joY;
    private k joZ;
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
        this.gMT = 360.0f;
        this.joU = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.cVv = tbPageContext;
            this.mRootView = view;
            this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.fVN = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.joV = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.joZ = new k(this.cVv, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.joZ.a(PersonStatus.GUEST_DEFAULT);
            this.joW = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.joX = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.joY = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.elM = new PbListView(this.cVv.getPageActivity());
            this.elM.getView();
            this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.elM.setHeight(l.getDimens(this.cVv.getPageActivity(), R.dimen.ds140));
            this.elM.setDividerLineHeight(l.getDimens(this.cVv.getPageActivity(), R.dimen.ds12));
            this.elM.setLineVisible();
            this.elM.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes11.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b jpb = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.e jpc;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new an("c12502").cx("obj_locate", "3"));
                this.jpb.gbm = 10;
                this.jpb.gbn = new Bundle();
                this.jpb.gbn.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.jpc != null) {
                    this.jpc.a(view, this.jpb);
                }
            }
        }
    }

    public void rv(boolean z) {
        this.joY.setVisibility(8);
        int dimensionPixelSize = this.cVv.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cVv.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.cz(null, this.cVv.getString(R.string.user_to_anti)), null);
        }
        am.setViewTextColor(this.mNoDataView.getSuTextView(), (int) R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void bNq() {
        if (this.joW != null) {
            if (this.joT != null) {
                this.joT.setVisibility(8);
            }
            this.joV.setVisibility(0);
            int dimensionPixelSize = this.cVv.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.cVv.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.cVv.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.cVv.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.cVv.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.cVv.getPageActivity(), this.joW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aE(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cVv.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(e.this.cVv.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bc.skipToLoginActivity(e.this.cVv.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.cVv, i);
            }
            if (this.joX != null) {
                this.joX.onChangeSkinType(this.cVv, i);
            }
            if (this.joZ != null) {
                this.joZ.onChangeSkinType(i);
            }
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.joS = bVar;
    }

    public void bcC() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.joW);
            this.refreshView = null;
        }
    }

    public void u(boolean z, int i) {
        if (this.euG == null) {
            if (i < 0) {
                this.euG = new com.baidu.tbadk.k.g(this.cVv.getContext());
            } else {
                this.euG = new com.baidu.tbadk.k.g(this.cVv.getContext(), i);
            }
            this.euG.onChangeSkinType();
        }
        this.euG.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.euG != null) {
            this.euG.dettachView(this.mRootView);
            this.euG = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void rw(boolean z) {
        if (z) {
            cxf();
        }
    }

    public void Ag(int i) {
        this.joY.setVisibility(i);
    }

    public void an(String str, boolean z) {
        if (!bzs()) {
            this.joV.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.cVv.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            e.this.bcC();
                            e.this.rw(true);
                            if (e.this.joS != null) {
                                e.this.joS.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.mH(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.joW, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.joT != null) {
                this.joT.setVisibility(8);
            }
        }
    }

    public boolean bzs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void e(boolean z, List<m> list) {
    }

    public void bdz() {
    }

    public void dQ(List<m> list) {
        if (v.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void cxf() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.joT == null) {
                this.joT = new ImageView(this.cVv.getPageActivity());
                this.joT.setImageResource(R.drawable.icon_nichengjun);
                this.joT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.e.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(e.this.cVv.getPageActivity(), null, com.baidu.tieba.pb.c.cky(), true)));
                    }
                });
            }
            if (this.joT.getParent() != null) {
                ((ViewGroup) this.joT.getParent()).removeView(this.joT);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.cVv.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.cVv.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.joT, layoutParams);
            }
        } else if (this.joT != null && this.joT.getParent() != null && this.joT.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.joT);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void bKb() {
    }

    public void doRefresh() {
    }
}
