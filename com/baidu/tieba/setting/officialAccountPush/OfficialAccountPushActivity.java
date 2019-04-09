package com.baidu.tieba.setting.officialAccountPush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.a {
    private BdListView fsx = null;
    private a iul = null;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.official_account_push_activity);
        aDz();
        awj();
        awi();
    }

    private void awi() {
        if (!j.kY() && v.T(this.list)) {
            caI();
        } else if (v.T(this.list)) {
            bhq();
        } else if (this.iul == null) {
            this.iul = new a(getPageContext());
            this.iul.setData(this.list);
            this.fsx.setAdapter((ListAdapter) this.iul);
            this.iul.setSwitchStateChangeListener(this);
        } else {
            this.iul.setData(this.list);
            this.iul.notifyDataSetChanged();
        }
    }

    private void awj() {
        this.mRootView = (ViewGroup) findViewById(d.g.official_account_push_container);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_CENTER, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(d.j.offical_account_push_msg));
        this.fsx = (BdListView) findViewById(d.g.list);
        this.mNoDataView = NoDataViewFactory.a(this, this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds120)), NoDataViewFactory.d.hT(d.j.no_data_text), null);
        this.mNoDataView.setVisibility(0);
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(d.g.no_network);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.f(this.mRootView, d.C0277d.cp_bg_line_e, i);
        this.mNoDataView.onChangeSkinType(getPageContext(), i);
        this.mNetworkView.onChangeSkinType(getPageContext(), i);
    }

    private void aDz() {
        Intent intent = getIntent();
        if (intent != null) {
            this.list = intent.getParcelableArrayListExtra(OfficialAccountPushActivityConfig.OFFICIAL_LIST);
        }
    }

    public void bhq() {
        this.fsx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.no_data_text));
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    public void caI() {
        this.fsx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(d.j.refresh_view_title_text));
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) view.getTag();
        if (officialAccountPushInfo != null) {
            c(z, officialAccountPushInfo.uid);
        }
    }

    public void c(boolean z, long j) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(6);
        requestUpdateMaskInfoMessage.setG_id(j);
        if (z) {
            requestUpdateMaskInfoMessage.setIsMask(0);
        } else {
            requestUpdateMaskInfoMessage.setIsMask(1);
        }
        requestUpdateMaskInfoMessage.setCallFrom(5);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        d(z, j);
    }

    private void d(boolean z, long j) {
        if (this.list != null && this.iul != null) {
            if (!j.kY()) {
                this.iul.notifyDataSetChanged();
                return;
            }
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).uid == j) {
                    if (z) {
                        this.list.get(i).iuo = 1;
                    } else {
                        this.list.get(i).iuo = 0;
                    }
                }
            }
            this.iul.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
