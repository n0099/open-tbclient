package com.baidu.tieba.immessagecenter.chatgroup.grouppage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tieba.R;
import com.baidu.tieba.kw5;
import com.baidu.tieba.mn5;
import com.baidu.tieba.tg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes6.dex */
public class GroupChatActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public String c;
    public GroupChatFragment d;
    public tg5 e;

    public GroupChatActivity() {
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
        this.a = -1;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Resources resources = super.getResources();
            if (resources != null) {
                TbDimenManager tbDimenManager = TbDimenManager.getInstance();
                tbDimenManager.setDensity(resources.getDisplayMetrics(), tbDimenManager.getDefaultDensity(), tbDimenManager.getDefaultDensityDpi());
            }
            return resources;
        }
        return (Resources) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921771, this.e));
        }
    }

    public GroupChatFragment t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (GroupChatFragment) invokeV.objValue;
    }

    public static void u1(@NonNull Context context, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            mn5.b().h(context, "SCENE_GROUP_CHAT", Collections.singletonList(Long.valueOf(j)));
            Intent intent = new Intent(context, GroupChatActivity.class);
            intent.putExtra("roomId", j);
            intent.putExtra("requestCode", i);
            intent.putExtra(IntentConfig.BACK_SCHEME, str);
            context.startActivity(intent);
        }
    }

    public static void v1(@NonNull Context context, long j, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str, str2}) == null) {
            mn5.b().h(context, "SCENE_GROUP_CHAT", Collections.singletonList(Long.valueOf(j)));
            Intent intent = new Intent(context, GroupChatActivity.class);
            intent.putExtra("roomId", j);
            intent.putExtra("requestCode", i);
            intent.putExtra("source", str);
            intent.putExtra(IntentConfig.BACK_SCHEME, str2);
            context.startActivity(intent);
        }
    }

    public static void w1(@NonNull Context context, String str, long j, int i, String str2, @Nullable Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, Long.valueOf(j), Integer.valueOf(i), str2, bundle, Boolean.valueOf(z)}) == null) {
            mn5.b().h(context, "SCENE_GROUP_CHAT", Collections.singletonList(Long.valueOf(j)));
            Intent intent = new Intent(context, GroupChatActivity.class);
            intent.putExtra("roomId", j);
            intent.putExtra("requestCode", i);
            if (bundle != null) {
                intent.putExtra("chat_bot_ability", bundle.getSerializable("ability"));
            }
            intent.putExtra("show_chat_list_after_finish", z);
            if ("essentialNews".equals(str)) {
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(IntentConfig.BACK_SCHEME, str2);
            context.startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    ((BaseFragment) fragment).onActivityFinish();
                }
            }
            if (!TextUtils.isEmpty(this.c)) {
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{Uri.decode(this.c)});
                this.c = "";
            } else if (TbadkCoreApplication.getInst().getMainActivity() == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    fragment.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundColor(this.b, R.color.CAM_X0202);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof BaseFragment) {
                ((BaseFragment) fragment).onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d003d);
            this.b = findViewById(R.id.obfuscated_res_0x7f090c0f);
            if (bundle == null) {
                this.d = new GroupChatFragment();
                Intent intent = getIntent();
                if (intent != null) {
                    this.d.setArguments(intent.getExtras());
                }
                kw5.a(getSupportFragmentManager(), R.id.obfuscated_res_0x7f090c0f, this.d);
            }
            if (getIntent() != null) {
                this.c = getIntent().getStringExtra(IntentConfig.BACK_SCHEME);
                if (getIntent().getBooleanExtra("show_chat_list_after_finish", false)) {
                    this.e = new tg5(getIntent().getLongExtra("roomId", 0L), true);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).onKeyDown(i, keyEvent)) {
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            if (this.d != null && intent != null) {
                intent.putExtra("is_new_intent", true);
                this.d.setArguments(intent.getExtras());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    fragment.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        }
    }
}
