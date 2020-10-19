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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
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
    protected TbPageContext etO;
    private NoNetworkView fTu;
    public PbListView fTv;
    private com.baidu.tbadk.k.g gcx;
    private PluginErrorTipView hRf;
    private float iPH;
    private com.baidu.tieba.personPolymeric.view.k lJA;
    private b lJt;
    private ImageView lJu;
    private a lJv;
    private LinearLayout lJw;
    protected FrameLayout lJx;
    private NoNetworkView lJy;
    protected RelativeLayout lJz;
    protected NoDataView mNoDataView;
    public View mRootView;
    private int mSkinType;
    private com.baidu.tbadk.k.h refreshView;

    /* loaded from: classes24.dex */
    public interface b {
        void dp(View view);
    }

    public f(TbPageContext tbPageContext, View view, boolean z) {
        super(z);
        this.iPH = 360.0f;
        this.lJv = new a();
        this.mSkinType = 3;
        if (tbPageContext != null && view != null) {
            this.etO = tbPageContext;
            this.mRootView = view;
            this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
            this.hRf = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lJw = (LinearLayout) this.mRootView.findViewById(R.id.person_center_anti_container);
            this.lJA = new com.baidu.tieba.personPolymeric.view.k(this.etO, this.mRootView.findViewById(R.id.person_center_anti_navigation_bar), this.mRootView.findViewById(R.id.person_center_anti_status_bar_space), z);
            this.lJA.a(PersonStatus.GUEST_DEFAULT);
            this.lJx = (FrameLayout) this.mRootView.findViewById(R.id.person_center_anti_content);
            this.lJy = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_anti_no_network_view);
            this.lJz = (RelativeLayout) this.mRootView.findViewById(R.id.person_center_noanti_rootview);
            this.fTv = new PbListView(this.etO.getPageActivity());
            this.fTv.getView();
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.fTv.setHeight(l.getDimens(this.etO.getPageActivity(), R.dimen.ds140));
            this.fTv.setDividerLineHeight(l.getDimens(this.etO.getPageActivity(), R.dimen.ds12));
            this.fTv.setLineVisible();
            this.fTv.setLineColorResource(R.color.cp_bg_line_e);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes24.dex */
    public static class a implements View.OnClickListener {
        private com.baidu.tieba.personPolymeric.event.b lJC = new com.baidu.tieba.personPolymeric.event.b();
        public com.baidu.tieba.view.f lJD;
        public UserData userData;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.userData == null || !this.userData.isBaijiahaoUser()) {
                TiebaStatic.log(new aq("c12502").dK("obj_locate", "3"));
                this.lJC.iaq = 10;
                this.lJC.iar = new Bundle();
                this.lJC.iar.putSerializable(UserData.TYPE_USER, this.userData);
                if (this.lJD != null) {
                    this.lJD.a(view, this.lJC);
                }
            }
        }
    }

    public void vs(boolean z) {
        this.lJz.setVisibility(8);
        int dimensionPixelSize = this.etO.getResources().getDimensionPixelSize(R.dimen.ds240);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.etO.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.d.dL(null, this.etO.getString(R.string.user_to_anti)), null);
        }
        ap.setViewTextColor(this.mNoDataView.getSuTextView(), R.color.cp_cont_f);
        this.mNoDataView.onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void cCU() {
        if (this.lJx != null) {
            if (this.lJu != null) {
                this.lJu.setVisibility(8);
            }
            this.lJw.setVisibility(0);
            int dimensionPixelSize = this.etO.getResources().getDimensionPixelSize(R.dimen.ds220);
            int dimensionPixelSize2 = this.etO.getResources().getDimensionPixelSize(R.dimen.ds480);
            int dimensionPixelSize3 = this.etO.getResources().getDimensionPixelSize(R.dimen.ds360);
            int dimensionPixelSize4 = this.etO.getResources().getDimensionPixelSize(R.dimen.ds60);
            int dimensionPixelSize5 = this.etO.getResources().getDimensionPixelSize(R.dimen.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.etO.getPageActivity(), this.lJx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.aW(R.string.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.etO.getString(R.string.unlogin_person_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(f.this.etO.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                    bg.skipToLoginActivity(f.this.etO.getPageActivity());
                }
            }), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.mNoDataView != null) {
                this.mNoDataView.onChangeSkinType(this.etO, i);
            }
            if (this.lJy != null) {
                this.lJy.onChangeSkinType(this.etO, i);
            }
            if (this.lJA != null) {
                this.lJA.onChangeSkinType(i);
            }
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void a(b bVar) {
        this.lJt = bVar;
    }

    public void SK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lJx);
            this.refreshView = null;
        }
    }

    public void D(boolean z, int i) {
        if (this.gcx == null) {
            if (i < 0) {
                this.gcx = new com.baidu.tbadk.k.g(this.etO.getContext());
            } else {
                this.gcx = new com.baidu.tbadk.k.g(this.etO.getContext(), i);
            }
            this.gcx.onChangeSkinType();
        }
        this.gcx.attachView(this.mRootView, z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, false));
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this.mRootView);
            this.gcx = null;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, true));
    }

    public void vt(boolean z) {
        if (z) {
            dpC();
        }
    }

    public void Gy(int i) {
        this.lJz.setVisibility(i);
    }

    public void aO(String str, boolean z) {
        if (!chb()) {
            this.lJw.setVisibility(0);
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.etO.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            f.this.SK();
                            f.this.vt(true);
                            if (f.this.lJt != null) {
                                f.this.lJt.dp(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.rj(R.drawable.new_pic_emotion_08);
            this.refreshView.attachView(this.lJx, z);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
            if (this.lJu != null) {
                this.lJu.setVisibility(8);
            }
        }
    }

    public boolean chb() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void h(boolean z, List<q> list) {
    }

    public void bKU() {
    }

    public void eW(List<q> list) {
        if (y.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void dpC() {
        if (NickNameActivitySwitch.isOn()) {
            if (this.lJu == null) {
                this.lJu = new ImageView(this.etO.getPageActivity());
                this.lJu.setImageResource(R.drawable.icon_nichengjun);
                this.lJu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(f.this.etO.getPageActivity(), null, com.baidu.tieba.pb.c.dck(), true)));
                    }
                });
            }
            if (this.lJu.getParent() != null) {
                ((ViewGroup) this.lJu.getParent()).removeView(this.lJu);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.topMargin = l.getDimens(this.etO.getPageActivity(), R.dimen.ds504);
            layoutParams.rightMargin = l.getDimens(this.etO.getPageActivity(), R.dimen.ds26);
            if (this.mRootView instanceof RelativeLayout) {
                ((RelativeLayout) this.mRootView).addView(this.lJu, layoutParams);
            }
        } else if (this.lJu != null && this.lJu.getParent() != null && this.lJu.getParent() == this.mRootView) {
            ((RelativeLayout) this.mRootView).removeView(this.lJu);
        }
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
    }

    public void czl() {
    }

    public void doRefresh() {
    }
}
