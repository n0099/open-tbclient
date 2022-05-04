package com.baidu.tieba.setting.officialAccountPush;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.ve8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OfficialAccountPushActivity extends BaseActivity<OfficialAccountPushActivity> implements BdSwitchView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCEPT_MSG = 0;
    public static final int MASK_TYPE = 6;
    public static final int UNACCEPT_MSG = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<OfficialAccountPushInfo> list;
    public ve8 mAdapter;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (!mi.z() && ListUtils.isEmpty(this.list)) {
                showNoNetWorkView();
            } else if (ListUtils.isEmpty(this.list)) {
                showNoData();
            } else {
                ve8 ve8Var = this.mAdapter;
                if (ve8Var == null) {
                    ve8 ve8Var2 = new ve8(getPageContext());
                    this.mAdapter = ve8Var2;
                    ve8Var2.a(this.list);
                    this.mList.setAdapter((ListAdapter) this.mAdapter);
                    this.mAdapter.b(this);
                    return;
                }
                ve8Var.a(this.list);
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mRootView = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0915df);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_CENTER, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f0ca2));
            this.mList = (BdListView) findViewById(R.id.obfuscated_res_0x7f09126d);
            NoDataView a = NoDataViewFactory.a(this, this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07023f)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2f), null);
            this.mNoDataView = a;
            a.setVisibility(0);
            this.mNetworkView = (NoNetworkView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091590);
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

    private void updateSwitchStatus(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || this.list == null || this.mAdapter == null) {
            return;
        }
        if (!mi.z()) {
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).uid == j) {
                if (z) {
                    this.list.get(i).is_on = 1;
                } else {
                    this.list.get(i).is_on = 0;
                }
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view2, BdSwitchView.SwitchState switchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
            boolean z = BdSwitchView.SwitchState.ON == switchState;
            OfficialAccountPushInfo officialAccountPushInfo = (OfficialAccountPushInfo) view2.getTag();
            if (officialAccountPushInfo == null) {
                return;
            }
            switchSingleMask(z, officialAccountPushInfo.uid);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0205, i);
            this.mNoDataView.f(getPageContext(), i);
            this.mNetworkView.c(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0631);
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
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c2f));
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void showNoNetWorkView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mList.setVisibility(8);
            this.mNoDataView.setVisibility(0);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0f69));
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        }
    }

    public void switchSingleMask(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
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
}
