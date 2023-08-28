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
import com.baidu.tieba.dt5;
import com.baidu.tieba.oxa;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class AlbumFloatActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oxa k;
    public ViewGroup l;

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

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

    public final boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            return permissionJudgePolicy.startRequestPermission(this);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            oxa oxaVar = this.k;
            if (oxaVar != null) {
                oxaVar.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            oxa oxaVar = this.k;
            if (oxaVar != null) {
                oxaVar.onPause();
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            oxa oxaVar = this.k;
            if (oxaVar != null) {
                oxaVar.onResume();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStart();
            oxa oxaVar = this.k;
            if (oxaVar != null) {
                oxaVar.I();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStop();
            oxa oxaVar = this.k;
            if (oxaVar != null) {
                oxaVar.J();
            }
        }
    }

    public final void F1() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getIntent() != null) {
            String dataString = getIntent().getDataString();
            if (!TextUtils.isEmpty(dataString) && dataString.contains("/jumpToVideo")) {
                if (G1()) {
                    finish();
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    Uri parse = Uri.parse(dataString);
                    for (String str3 : parse.getQueryParameterNames()) {
                        hashMap.put(str3, parse.getQueryParameter(str3));
                    }
                } catch (Exception unused) {
                }
                String str4 = "";
                if (!hashMap.containsKey("videoTopicID")) {
                    str = "";
                } else {
                    str = (String) hashMap.get("videoTopicID");
                }
                if (!hashMap.containsKey("videoTopic")) {
                    str2 = "";
                } else {
                    str2 = (String) hashMap.get("videoTopic");
                }
                if (hashMap.containsKey("isVideo")) {
                    str4 = (String) hashMap.get("isVideo");
                }
                getIntent().putExtra("topicId", str);
                getIntent().putExtra("topic", str2);
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
                statisticItem.param("topic_id", str);
                statisticItem.param("obj_name", str2);
                statisticItem.param("obj_type", str4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                this.k.L(intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            oxa oxaVar = this.k;
            if (oxaVar != null) {
                oxaVar.G(i, strArr, iArr);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        oxa oxaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (oxaVar = this.k) != null) {
            oxaVar.onClick(view2);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            F1();
            super.onCreate(bundle);
            this.l = (ViewGroup) findViewById(R.id.suspend_root_view);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            new BdTopToast(this, 3000).setIcon(false).setContent(getResources().getString(i)).show(this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, keyEvent)) == null) {
            if (i == 4) {
                this.k.F();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public dt5 s1(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, linearLayout, navigationBar)) == null) {
            if (this.k == null) {
                oxa oxaVar = new oxa(this, null, linearLayout.getId(), R.id.root_stub);
                this.k = oxaVar;
                oxaVar.R(navigationBar);
            }
            return this.k;
        }
        return (dt5) invokeLL.objValue;
    }
}
