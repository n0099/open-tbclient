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
    private com.baidu.tbadk.core.view.y Yc;
    private com.baidu.tbadk.core.view.o ahO;
    private NoNetworkView aoJ;
    private com.baidu.tbadk.core.view.d ayf;
    private LinearLayout bmX;
    private c bmV = null;
    private BdListView bmW = null;
    private boolean bmY = false;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.at_me_activity, viewGroup, false);
        this.Yc = new com.baidu.tbadk.core.view.y(getActivity());
        this.Yc.a(this);
        this.bmW = (BdListView) inflate.findViewById(com.baidu.tieba.v.atme_lv);
        this.bmW.setDividerHeight(0);
        this.bmW.setPullRefresh(this.Yc);
        this.bmX = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.bodyNotLogin);
        this.bmV = new c(this, 2, new b(this));
        this.bmV.t(this.bmW);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.mention_layout_atme);
        this.bmV.d(relativeLayout);
        this.ahO = NoDataViewFactory.a(getActivity(), relativeLayout, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, (int) getResources().getDimension(com.baidu.tieba.t.ds80)), com.baidu.tbadk.core.view.s.bL(com.baidu.tieba.y.mention_atme_nodata), null);
        this.bmV.a(this.ahO);
        this.bmV.gO("c/u/feed/atme");
        this.bmV.init();
        this.aoJ = (NoNetworkView) inflate.findViewById(com.baidu.tieba.v.view_no_network_at);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ahO != null) {
                this.ahO.onChangeSkinType(i);
            }
            if (this.Yc != null) {
                this.Yc.bM(i);
            }
            if (this.ayf != null) {
                this.ayf.bG(i);
            }
            if (this.bmV != null) {
                this.bmV.SN();
            }
            if (this.aoJ != null) {
                this.aoJ.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.ahO.onActivityStop();
        if (this.ayf != null) {
            this.ayf.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.ahO.nv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (TbadkApplication.isLogin()) {
            this.bmW.setVisibility(0);
            this.bmX.setVisibility(8);
            if (this.bmY) {
                this.bmY = false;
                SH();
            }
            this.bmV.SL();
        } else {
            this.ahO.setVisibility(8);
            SI();
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void SH() {
        if (this.bmV == null) {
            this.bmY = true;
            return;
        }
        this.bmY = false;
        if (TbadkApplication.isLogin()) {
            this.bmW.setVisibility(0);
            this.bmX.setVisibility(8);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgAtme() > 0) {
                this.bmV.setUpdateType(2);
            } else {
                this.bmV.setUpdateType(1);
            }
            this.bmV.show();
            this.bmV.SL();
            return;
        }
        SI();
    }

    private void SI() {
        if (this.ayf == null) {
            this.ayf = new com.baidu.tbadk.core.view.d(getActivity(), getString(com.baidu.tieba.y.login_msg_tab), getString(com.baidu.tieba.y.login_msg_form), 3);
            this.bmX.addView(this.ayf.getView());
            this.ayf.bG(TbadkApplication.m251getInst().getSkinType());
        } else {
            ((ViewGroup) this.ayf.getView().getParent()).removeAllViews();
            this.bmX.addView(this.ayf.getView());
            this.ayf.bG(TbadkApplication.m251getInst().getSkinType());
        }
        this.bmW.setVisibility(8);
        this.bmX.setVisibility(0);
    }

    public void refresh() {
        this.bmV.refresh();
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (!z) {
            refresh();
        }
    }
}
