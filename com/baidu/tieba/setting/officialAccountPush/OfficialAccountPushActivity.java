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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.a {
    private BdListView edP = null;
    private a hbJ = null;
    private ArrayList<OfficialAccountPushInfo> list;
    private NavigationBar mNavigationBar;
    private NoNetworkView mNetworkView;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.official_account_push_activity);
        ack();
        VQ();
        VP();
    }

    private void VP() {
        if (!j.kV() && v.I(this.list)) {
            bzm();
        } else if (v.I(this.list)) {
            aGF();
        } else if (this.hbJ == null) {
            this.hbJ = new a(getPageContext());
            this.hbJ.setData(this.list);
            this.edP.setAdapter((ListAdapter) this.hbJ);
            this.hbJ.setSwitchStateChangeListener(this);
        } else {
            this.hbJ.setData(this.list);
            this.hbJ.notifyDataSetChanged();
        }
    }

    private void VQ() {
        this.mRootView = (ViewGroup) findViewById(e.g.official_account_push_container);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_CENTER, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(e.j.offical_account_push_msg));
        this.edP = (BdListView) findViewById(e.g.list);
        this.mNoDataView = NoDataViewFactory.a(this, this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds120)), NoDataViewFactory.d.eq(e.j.no_data_text), null);
        this.mNoDataView.setVisibility(0);
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(e.g.no_network);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.e(this.mRootView, e.d.cp_bg_line_e, i);
        this.mNoDataView.onChangeSkinType(getPageContext(), i);
        this.mNetworkView.onChangeSkinType(getPageContext(), i);
    }

    private void ack() {
        Intent intent = getIntent();
        if (intent != null) {
            this.list = intent.getParcelableArrayListExtra(OfficialAccountPushActivityConfig.OFFICIAL_LIST);
        }
    }

    public void aGF() {
        this.edP.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.no_data_text));
        al.j(this.mRootView, e.d.cp_bg_line_d);
    }

    public void bzm() {
        this.edP.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(e.j.refresh_view_title_text));
        al.j(this.mRootView, e.d.cp_bg_line_d);
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
        if (this.list != null && this.hbJ != null) {
            if (!j.kV()) {
                this.hbJ.notifyDataSetChanged();
                return;
            }
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).uid == j) {
                    if (z) {
                        this.list.get(i).hbM = 1;
                    } else {
                        this.list.get(i).hbM = 0;
                    }
                }
            }
            this.hbJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
