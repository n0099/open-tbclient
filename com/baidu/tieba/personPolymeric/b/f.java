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
/* loaded from: classes8.dex */
public class f extends e {
    protected TbPageContext eUY;
    private NoNetworkView gAv;
    public PbListView gAw;
    private com.baidu.tbadk.l.g gJB;
    private PluginErrorTipView iIQ;
    private float jJX;
    private b mAk;
    private ImageView mAl;
    private a mAm;
    private LinearLayout mAn;
    protected FrameLayout mAo;
    private NoNetworkView mAp;
    protected RelativeLayout mAq;
    private com.baidu.tieba.personPolymeric.view.k mAr;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.l.h refreshView;

    /* loaded from: classes8.dex */
    public interface b {
        void dV(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.jJX = 360.0f;
        this.mAm = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.eUY = tbPageContext;
            this.mRootView = view;
            this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.iIQ = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mAn = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.mAr = new com.baidu.tieba.personPolymeric.view.k(this.eUY, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.mAr.a(PersonStatus.GUEST_DEFAULT);
            this.mAo = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.mAp = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.mAq = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.gAw = new PbListView(this.eUY.getPageActivity());
            this.gAw.getView();
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.gAw.setHeight(l.getDimens(this.eUY.getPageActivity(), R.dimen.ds140));
            this.gAw.setDividerLineHeight(l.getDimens(this.eUY.getPageActivity(), R.dimen.ds12));
            this.gAw.setLineVisible();
            this.gAw.setLineColorResource(R.color.CAM_X0205);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b mAt = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f mAu;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new ar("c12502").dR("obj_locate", "3"));
                this.mAt.iRY = 10;
                this.mAt.iRZ = new Bundle();
                this.mAt.iRZ.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.mAu != null) {
                    this.mAu.a(view, this.mAt);
                }
            }
        }
    }

    public void wN(boolean z) {
        this.mAq.setVisibility(8);
        int dimensionPixelSize = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eUY.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dS(null, this.eUY.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.CAM_X0106);
        this.mNoDataView.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cOQ() {
        if (this.mAo != null) {
            if (this.mAl != null) {
                this.mAl.setVisibility(8);
            }
            this.mAn.setVisibility(0);
            int dimensionPixelSize = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.eUY.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.eUY.getPageActivity(), this.mAo, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aU(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eUY.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.eUY.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bh.skipToLoginActivity(f.this.eUY.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.eUY, i);
            }
            if (this.mAp != null) {
                this.mAp.onChangeSkinType(this.eUY, i);
            }
            if (this.mAr != null) {
                this.mAr.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.mAk = bVar;
    }

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mAo);
            this.refreshView = null;
        }
    }

    public void C(boolean z, int i) {
        if (this.gJB == null) {
            if (i < 0) {
                this.gJB = new com.baidu.tbadk.l.g(this.eUY.getContext());
            } else {
                this.gJB = new com.baidu.tbadk.l.g(this.eUY.getContext(), i);
            }
            this.gJB.onChangeSkinType();
        }
        this.gJB.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
            this.gJB = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void wO(boolean z) {
        if (z) {
            dys();
        }
    }

    public void GY(int i) {
        this.mAq.setVisibility(i);
    }

    public void aQ(String str, boolean z) {
        if (!cqT()) {
            this.mAn.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.eUY.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.WZ();
                            f.this.wO(true);
                            if (f.this.mAk != null) {
                                f.this.mAk.dV(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ro(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.mAo, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.mAl != null) {
                this.mAl.setVisibility(8);
            }
        }
    }

    public boolean cqT() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<n> list) {
    }

    public void bSy() {
    }

    public void fx(List<n> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dys() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.mAl == null) {
                this.mAl = new ImageView(this.eUY.getPageActivity());
                this.mAl.setImageResource(R.drawable.icon_nichengjun);
                this.mAl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.eUY.getPageActivity(), null, com.baidu.tieba.pb.c.dkQ(), true)));
                    }
                });
            }
            if (this.mAl.getParent() != null) {
                ((ViewGroup) this.mAl.getParent()).removeView(this.mAl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.mAl, layoutParams);
            }
        } else if (this.mAl != null && this.mAl.getParent() != null && this.mAl.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.mAl);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void cKp() {
    }

    public void doRefresh() {
    }
}
