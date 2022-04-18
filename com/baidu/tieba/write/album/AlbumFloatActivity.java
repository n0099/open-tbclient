package com.baidu.tieba.write.album;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h95;
import com.repackage.rz8;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AlbumFloatActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rz8 albumView;
    public ViewGroup mRootView;

    public AlbumFloatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void dealSchema() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || getIntent() == null) {
            return;
        }
        String dataString = getIntent().getDataString();
        if (TextUtils.isEmpty(dataString) || !dataString.contains("/jumpToVideo")) {
            return;
        }
        if (requestPermission()) {
            finish();
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            Uri parse = Uri.parse(dataString);
            for (String str : parse.getQueryParameterNames()) {
                hashMap.put(str, parse.getQueryParameter(str));
            }
        } catch (Exception unused) {
        }
        String str2 = hashMap.containsKey("videoTopicID") ? (String) hashMap.get("videoTopicID") : "";
        String str3 = hashMap.containsKey("videoTopic") ? (String) hashMap.get("videoTopic") : "";
        String str4 = hashMap.containsKey("isVideo") ? (String) hashMap.get("isVideo") : "";
        getIntent().putExtra("topicId", str2);
        getIntent().putExtra("topic", str3);
        getIntent().putExtra("is_video_topic", str4);
        getIntent().putExtra(IntentConfig.KEY_CAN_SELECT_VIDEO, true);
        getIntent().putExtra(AlbumFloatActivityConfig.CAN_CHANGE_BAR_NAME, true);
        getIntent().putExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
        getIntent().putExtra(IntentConfig.KEY_CAN_SELECT_ONLY_VIDEO, true);
        getIntent().putExtra(IntentConfig.KEY_CAN_EDIT_IMAGE, false);
        getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
        getIntent().putExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
        getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, true);
        getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, true);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEMA_OPEN_WORKPUBLISH);
        statisticItem.param("topic_id", str2);
        statisticItem.param("obj_name", str3);
        statisticItem.param("obj_type", str4);
        TiebaStatic.log(statisticItem);
    }

    private boolean requestPermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public h95 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            if (this.albumView == null) {
                rz8 rz8Var = new rz8(this, null, linearLayout.getId(), R.id.obfuscated_res_0x7f091add);
                this.albumView = rz8Var;
                rz8Var.O(navigationBar);
            }
            return this.albumView;
        }
        return (h95) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                this.albumView.I(intent);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        rz8 rz8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || (rz8Var = this.albumView) == null) {
            return;
        }
        rz8Var.onClick(view2);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            dealSchema();
            super.onCreate(bundle);
            this.mRootView = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091dd2);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            rz8 rz8Var = this.albumView;
            if (rz8Var != null) {
                rz8Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (i == 4) {
                this.albumView.B();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            rz8 rz8Var = this.albumView;
            if (rz8Var != null) {
                rz8Var.C();
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            rz8 rz8Var = this.albumView;
            if (rz8Var != null) {
                rz8Var.D(i, strArr, iArr);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            rz8 rz8Var = this.albumView;
            if (rz8Var != null) {
                rz8Var.onResume();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            rz8 rz8Var = this.albumView;
            if (rz8Var != null) {
                rz8Var.F();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            rz8 rz8Var = this.albumView;
            if (rz8Var != null) {
                rz8Var.G();
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String string = getResources().getString(i);
            BdTopToast bdTopToast = new BdTopToast(this, 3000);
            bdTopToast.i(false);
            bdTopToast.h(string);
            bdTopToast.j(this.mRootView);
        }
    }
}
