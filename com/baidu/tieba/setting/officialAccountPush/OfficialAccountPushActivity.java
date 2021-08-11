package com.baidu.tieba.setting.officialAccountPush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.a3.d.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_MSG = 0;
    public static final int MASK_TYPE = 6;
    public static final int UNACCEPT_MSG = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<OfficialAccountPushInfo> list;
    public a mAdapter;
    public BdListView mList;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNetworkView;
    public NoDataView mNoDataView;
    public ViewGroup mRootView;

    public OfficialAccountPushActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mList = null;
        this.mAdapter = null;
    }

    private void InitData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
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
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
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
    }

    private void dealWithIntent() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.list = intent.getParcelableArrayListExtra(OfficialAccountPushActivityConfig.OFFICIAL_LIST);
    }

    private void updateSwitchStatus(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) || this.list == null || this.mAdapter == null) {
            return;
        }
        if (!j.z()) {
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        for (int i2 = 0; i2 < this.list.size(); i2++) {
            if (this.list.get(i2).uid == j2) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
            boolean z = BdSwitchView.SwitchState.ON == switchState;
            OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) view.getTag();
            if (officialAccountPushInfo == null) {
                return;
            }
            switchSingleMask(z, officialAccountPushInfo.uid);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0205, i2);
            this.mNoDataView.onChangeSkinType(getPageContext(), i2);
            this.mNetworkView.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.official_account_push_activity);
            dealWithIntent();
            InitUI();
            InitData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
        }
    }

    public void showNoData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mList.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.no_data_text));
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void showNoNetWorkView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mList.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void switchSingleMask(boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(6);
            requestUpdateMaskInfoMessage.setG_id(j2);
            if (z) {
                requestUpdateMaskInfoMessage.setIsMask(0);
            } else {
                requestUpdateMaskInfoMessage.setIsMask(1);
            }
            requestUpdateMaskInfoMessage.setCallFrom(5);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
            updateSwitchStatus(z, j2);
        }
    }
}
