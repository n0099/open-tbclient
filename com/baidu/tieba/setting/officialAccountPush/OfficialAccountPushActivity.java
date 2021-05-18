package com.baidu.tieba.setting.officialAccountPush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.k0.v2.d.a;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.b {
    public static final int ACCEPT_MSG = 0;
    public static final int MASK_TYPE = 6;
    public static final int UNACCEPT_MSG = 1;
    public ArrayList<OfficialAccountPushInfo> list;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNetworkView;
    public NoDataView mNoDataView;
    public ViewGroup mRootView;
    public BdListView mList = null;
    public a mAdapter = null;

    private void InitData() {
        if (!j.z() && ListUtils.isEmpty(this.list)) {
            showNoNetWorkView();
        } else if (ListUtils.isEmpty(this.list)) {
            showNoData();
        } else {
            a aVar = this.mAdapter;
            if (aVar == null) {
                a aVar2 = new a(getPageContext());
                this.mAdapter = aVar2;
                aVar2.a(this.list);
                this.mList.setAdapter((ListAdapter) this.mAdapter);
                this.mAdapter.b(this);
                return;
            }
            aVar.a(this.list);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    private void InitUI() {
        this.mRootView = (ViewGroup) findViewById(R.id.official_account_push_container);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_CENTER, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.offical_account_push_msg));
        this.mList = (BdListView) findViewById(R.id.list);
        NoDataView a2 = NoDataViewFactory.a(this, this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120)), NoDataViewFactory.e.a(R.string.no_data_text), null);
        this.mNoDataView = a2;
        a2.setVisibility(0);
        this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.no_network);
    }

    private void dealWithIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            this.list = intent.getParcelableArrayListExtra(OfficialAccountPushActivityConfig.OFFICIAL_LIST);
        }
    }

    private void updateSwitchStatus(boolean z, long j) {
        if (this.list == null || this.mAdapter == null) {
            return;
        }
        if (!j.z()) {
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        for (int i2 = 0; i2 < this.list.size(); i2++) {
            if (this.list.get(i2).uid == j) {
                if (z) {
                    this.list.get(i2).is_on = 1;
                } else {
                    this.list.get(i2).is_on = 0;
                }
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        boolean z = BdSwitchView.SwitchState.ON == switchState;
        OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) view.getTag();
        if (officialAccountPushInfo == null) {
            return;
        }
        switchSingleMask(z, officialAccountPushInfo.uid);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0205, i2);
        this.mNoDataView.f(getPageContext(), i2);
        this.mNetworkView.c(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.official_account_push_activity);
        dealWithIntent();
        InitUI();
        InitData();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void showNoData() {
        this.mList.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.no_data_text));
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void showNoNetWorkView() {
        this.mList.setVisibility(8);
        this.mNoDataView.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
    }

    public void switchSingleMask(boolean z, long j) {
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
        updateSwitchStatus(z, j);
    }
}
