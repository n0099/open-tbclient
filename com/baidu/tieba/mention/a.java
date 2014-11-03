package com.baidu.tieba.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class a extends BaseFragment implements com.baidu.adp.widget.ListView.f {
    private com.baidu.tbadk.core.view.y Yg;
    private com.baidu.tbadk.core.view.o ahX;
    private NoNetworkView aoS;
    private com.baidu.tbadk.core.view.d ayo;
    private LinearLayout bnl;
    private c bnj = null;
    private BdListView bnk = null;
    private boolean bnm = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.at_me_activity, viewGroup, false);
        this.Yg = new com.baidu.tbadk.core.view.y(getActivity());
        this.Yg.a(this);
        this.bnk = (BdListView) inflate.findViewById(com.baidu.tieba.v.atme_lv);
        this.bnk.setDividerHeight(0);
        this.bnk.setPullRefresh(this.Yg);
        this.bnl = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.bodyNotLogin);
        this.bnj = new c(this, 2, new b(this));
        this.bnj.t(this.bnk);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.mention_layout_atme);
        this.bnj.d(relativeLayout);
        this.ahX = NoDataViewFactory.a(getActivity(), relativeLayout, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.mention_atme_nodata), null);
        this.bnj.a(this.ahX);
        this.bnj.gO("c/u/feed/atme");
        this.bnj.init();
        this.aoS = (NoNetworkView) inflate.findViewById(com.baidu.tieba.v.view_no_network_at);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ahX != null) {
                this.ahX.onChangeSkinType(i);
            }
            if (this.Yg != null) {
                this.Yg.bM(i);
            }
            if (this.ayo != null) {
                this.ayo.bG(i);
            }
            if (this.bnj != null) {
                this.bnj.SQ();
            }
            if (this.aoS != null) {
                this.aoS.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.ahX.onActivityStop();
        if (this.ayo != null) {
            this.ayo.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ahX.nv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
            this.bnk.setVisibility(0);
            this.bnl.setVisibility(8);
            if (this.bnm) {
                this.bnm = false;
                SK();
            }
            this.bnj.SO();
        } else {
            this.ahX.setVisibility(8);
            SL();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void SK() {
        if (this.bnj == null) {
            this.bnm = true;
            return;
        }
        this.bnm = false;
        if (TbadkApplication.isLogin()) {
            this.bnk.setVisibility(0);
            this.bnl.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgAtme() > 0) {
                this.bnj.setUpdateType(2);
            } else {
                this.bnj.setUpdateType(1);
            }
            this.bnj.show();
            this.bnj.SO();
            return;
        }
        SL();
    }

    private void SL() {
        if (this.ayo == null) {
            this.ayo = new com.baidu.tbadk.core.view.d(getActivity(), getString(com.baidu.tieba.y.login_msg_tab), getString(com.baidu.tieba.y.login_msg_form), 3);
            this.bnl.addView(this.ayo.getView());
            this.ayo.bG(TbadkApplication.m251getInst().getSkinType());
        } else {
            ((ViewGroup) this.ayo.getView().getParent()).removeAllViews();
            this.bnl.addView(this.ayo.getView());
            this.ayo.bG(TbadkApplication.m251getInst().getSkinType());
        }
        this.bnk.setVisibility(8);
        this.bnl.setVisibility(0);
    }

    public void refresh() {
        this.bnj.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (!z) {
            refresh();
        }
    }
}
