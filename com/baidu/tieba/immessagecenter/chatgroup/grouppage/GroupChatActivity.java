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
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dq5;
import com.baidu.tieba.fh5;
import com.baidu.tieba.ob5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
/* loaded from: classes4.dex */
public class GroupChatActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public String c;
    public GroupChatFragment d;
    public ob5 e;

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

    public static void r1(@NonNull Context context, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            fh5.b().h(context, "SCENE_GROUP_CHAT", Collections.singletonList(Long.valueOf(j)));
            Intent intent = new Intent(context, GroupChatActivity.class);
            intent.putExtra("roomId", j);
            intent.putExtra("requestCode", i);
            intent.putExtra(IntentConfig.BACK_SCHEME, str);
            context.startActivity(intent);
        }
    }

    public static void s1(@NonNull Context context, long j, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str, str2}) == null) {
            fh5.b().h(context, "SCENE_GROUP_CHAT", Collections.singletonList(Long.valueOf(j)));
            Intent intent = new Intent(context, GroupChatActivity.class);
            intent.putExtra("roomId", j);
            intent.putExtra("requestCode", i);
            intent.putExtra("source", str);
            intent.putExtra(IntentConfig.BACK_SCHEME, str2);
            context.startActivity(intent);
        }
    }

    public static void t1(@NonNull Context context, long j, int i, String str, String str2, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i), str, str2, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            fh5.b().h(context, "SCENE_GROUP_CHAT", Collections.singletonList(Long.valueOf(j)));
            Intent intent = new Intent(context, GroupChatActivity.class);
            intent.putExtra("roomId", j);
            intent.putExtra("requestCode", i);
            intent.putExtra("chat_bot_uk", str2);
            intent.putExtra("chat_bot_skill_id", j2);
            intent.putExtra("show_chat_list_after_finish", z);
            intent.putExtra(IntentConfig.BACK_SCHEME, str);
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
        SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
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
            setContentView(R.layout.obfuscated_res_0x7f0d003b);
            this.b = findViewById(R.id.obfuscated_res_0x7f090bca);
            if (bundle == null) {
                this.d = new GroupChatFragment();
                Intent intent = getIntent();
                if (intent != null) {
                    this.d.setArguments(intent.getExtras());
                }
                dq5.a(getSupportFragmentManager(), R.id.obfuscated_res_0x7f090bca, this.d);
            }
            if (getIntent() != null) {
                this.c = getIntent().getStringExtra(IntentConfig.BACK_SCHEME);
                if (getIntent().getBooleanExtra("show_chat_list_after_finish", false)) {
                    this.e = new ob5(getIntent().getLongExtra("roomId", 0L), true);
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, strArr, iArr) == null) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof BaseFragment) {
                    fragment.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        }
    }
}
