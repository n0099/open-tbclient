package com.baidu.tieba.impersonal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.security.PermissionStorage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ee8;
import com.baidu.tieba.gs5;
import com.baidu.tieba.impersonal.databinding.ActivityPersonalChatBinding;
import com.baidu.tieba.kna;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\rH\u0014J\u0012\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u000fH\u0014J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020%H\u0014J\b\u0010+\u001a\u00020\u000fH\u0014J-\u0010,\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\r2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130.2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u000fH\u0014J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\"H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/baidu/tieba/impersonal/PersonalChatActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tbadk/core/voice/VoiceManager$IVoiceActivity;", "()V", "_voiceManager", "Lcom/baidu/tbadk/core/voice/VoiceManager;", "get_voiceManager", "()Lcom/baidu/tbadk/core/voice/VoiceManager;", "_voiceManager$delegate", "Lkotlin/Lazy;", "binding", "Lcom/baidu/tieba/impersonal/databinding/ActivityPersonalChatBinding;", "lastSkinType", "", "closeAnimation", "", "enterExitAnimation", "finish", "getCurrentPageKey", "", "getRealView", "", "m", "Lcom/baidu/tbadk/core/data/VoiceData$VoiceModel;", "getVoiceManager", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", "isVisible", MissionEvent.MESSAGE_PAUSE, "onRequestPermissionsResult", PermissionStorage.PermissionItem.TABLE_NAME, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalChatActivity extends BaseFragmentActivity implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Lazy b;

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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.on5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "a096" : (String) invokeV.objValue;
    }

    public Void t1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, voiceModel)) == null) {
            return null;
        }
        return (Void) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
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
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<VoiceManager>(this) { // from class: com.baidu.tieba.impersonal.PersonalChatActivity$_voiceManager$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VoiceManager invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    VoiceManager voiceManager = new VoiceManager();
                    PersonalChatActivity personalChatActivity = this.this$0;
                    VoiceManager.setIsUseMediaPlayer(true);
                    VoiceManager.setIsNeedBlackScreen(false);
                    voiceManager.onCreate(personalChatActivity.getPageContext());
                    voiceManager.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
                    return voiceManager;
                }
                return (VoiceManager) invokeV.objValue;
            }
        });
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            VoiceManager.setIsUseMediaPlayer(false);
            VoiceManager.setIsNeedBlackScreen(true);
            x0().onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            x0().onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            x0().onResume(getPageContext());
            x0().setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    public final VoiceManager u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (VoiceManager) this.b.getValue();
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return u1();
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public /* bridge */ /* synthetic */ VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        return (VoiceManager.i) t1(voiceModel);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, outState) == null) {
            Intrinsics.checkNotNullParameter(outState, "outState");
            super.onSaveInstanceState(outState);
            x0().onSaveInstanceState(this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
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
        if (interceptable == null || interceptable.invokeILL(1048588, this, i, permissions, grantResults) == null) {
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
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.a == i) {
            return;
        }
        this.a = i;
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            ActivityPersonalChatBinding c2 = ActivityPersonalChatBinding.c(LayoutInflater.from(this));
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(LayoutInflater.from(this))");
            setContentView(c2.getRoot());
            if (bundle == null) {
                PersonalChatFragment personalChatFragment = new PersonalChatFragment();
                personalChatFragment.setArguments(getIntent().getExtras());
                gs5.a(getSupportFragmentManager(), R.id.obfuscated_res_0x7f09069f, personalChatFragment);
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
            int b = kna.b(str, 0);
            ee8.b((b == 1 || b == 2) ? true : true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
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
}
