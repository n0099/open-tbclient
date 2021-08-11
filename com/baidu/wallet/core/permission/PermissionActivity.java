package com.baidu.wallet.core.permission;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class PermissionActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PERMISSION_REQUEST_CODE = 64;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRequireCheck;
    public String key;
    public String[] permission;

    public PermissionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void permissionsDenied(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
            PermissionListener fetchListener = PermissionsUtil.fetchListener(this.key);
            if (fetchListener != null) {
                fetchListener.permissionDenied(list);
            }
            overridePendingTransition(0, 0);
            finish();
        }
    }

    private void permissionsGranted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PermissionListener fetchListener = PermissionsUtil.fetchListener(this.key);
            if (fetchListener != null) {
                fetchListener.permissionGranted(Arrays.asList(this.permission));
            }
            finish();
        }
    }

    private void requestPermissions(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, strArr) == null) || PermissionManager.checkCallingOrSelfPermission(getActivity(), strArr, 64)) {
            return;
        }
        permissionsDenied(new ArrayList(Arrays.asList(strArr)));
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public boolean isSlidingEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            if (getIntent() != null && getIntent().hasExtra("permission")) {
                this.isRequireCheck = true;
                this.permission = getIntent().getStringArrayExtra("permission");
                this.key = getIntent().getStringExtra("key");
                return;
            }
            finish();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PermissionsUtil.fetchListener(this.key);
            super.onDestroy();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i2, strArr, iArr) == null) && i2 == 64) {
            if (PermissionsUtil.isGranted(iArr) && PermissionsUtil.hasPermission(this, strArr)) {
                permissionsGranted();
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (!PermissionsUtil.hasPermission(getActivity(), strArr[i3])) {
                    arrayList.add(strArr[i3]);
                }
            }
            permissionsDenied(arrayList);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            if (this.isRequireCheck) {
                if (PermissionsUtil.hasPermission(this, this.permission)) {
                    permissionsGranted();
                    return;
                }
                requestPermissions(this.permission);
                this.isRequireCheck = false;
                return;
            }
            this.isRequireCheck = true;
        }
    }
}
