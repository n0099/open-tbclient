package com.baidu.tieba.impersonal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.impersonal.databinding.ActivityPersonalChatBinding;
import com.baidu.tieba.q7a;
import com.baidu.tieba.xo5;
import com.baidu.tieba.yz7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0014J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0018H\u0014J-\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0 2\u0006\u0010!\u001a\u00020\"H\u0016¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/tieba/impersonal/PersonalChatActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "()V", "binding", "Lcom/baidu/tieba/impersonal/databinding/ActivityPersonalChatBinding;", "lastSkinType", "", "closeAnimation", "", "enterExitAnimation", "finish", "getCurrentPageKey", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", "isVisible", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PersonalChatActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ActivityPersonalChatBinding b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1632430455, "Lcom/baidu/tieba/impersonal/PersonalChatActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1632430455, "Lcom/baidu/tieba/impersonal/PersonalChatActivity;");
                return;
            }
        }
        c = new a(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.fk5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a096" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final void a(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intent intent = new Intent(context, PersonalChatActivity.class);
                intent.putExtra("key_sprite_talk_type", str);
                intent.putExtra("key_sprite_talk_prologue", str2);
                context.startActivity(intent);
            }
        }
    }

    public PersonalChatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    baseFragment = (BaseFragment) fragment;
                } else {
                    baseFragment = null;
                }
                if (baseFragment != null) {
                    baseFragment.onActivityFinish();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    baseFragment = (BaseFragment) fragment;
                } else {
                    baseFragment = null;
                }
                if (baseFragment != null) {
                    baseFragment.onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i, permissions, grantResults) == null) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(grantResults, "grantResults");
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    baseFragment = (BaseFragment) fragment;
                } else {
                    baseFragment = null;
                }
                if (baseFragment != null) {
                    baseFragment.onRequestPermissionsResult(i, permissions, grantResults);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
        ActivityPersonalChatBinding activityPersonalChatBinding = this.b;
        if (activityPersonalChatBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPersonalChatBinding = null;
        }
        SkinManager.setBackgroundResource(activityPersonalChatBinding.getRoot(), R.drawable.obfuscated_res_0x7f080473);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof BaseFragment) {
                baseFragment = (BaseFragment) fragment;
            } else {
                baseFragment = null;
            }
            if (baseFragment != null) {
                baseFragment.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            ActivityPersonalChatBinding c2 = ActivityPersonalChatBinding.c(LayoutInflater.from(this));
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(LayoutInflater.from(this))");
            setContentView(c2.getRoot());
            this.b = c2;
            if (bundle == null) {
                PersonalChatFragment personalChatFragment = new PersonalChatFragment();
                personalChatFragment.setArguments(getIntent().getExtras());
                xo5.a(getSupportFragmentManager(), R.id.obfuscated_res_0x7f090681, personalChatFragment);
            }
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            Intent intent = getIntent();
            if (intent != null) {
                str = intent.getStringExtra("key_sprite_talk_type");
            } else {
                str = null;
            }
            if (str == null) {
                str = "0";
            }
            boolean z = false;
            int b = q7a.b(str, 0);
            yz7.b((b == 1 || b == 2) ? true : true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, keyEvent)) == null) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if ((fragment instanceof BaseFragment) && ((BaseFragment) fragment).onKeyDown(i, keyEvent)) {
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof BaseFragment) {
                    baseFragment = (BaseFragment) fragment;
                } else {
                    baseFragment = null;
                }
                if (baseFragment != null) {
                    baseFragment.onKeyboardVisibilityChanged(z);
                }
            }
        }
    }
}
