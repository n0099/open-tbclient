package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.dimen.TbDimenUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.R;
import com.baidu.tieba.a79;
import com.baidu.tieba.ew4;
import com.baidu.tieba.g89;
import com.baidu.tieba.gw4;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.pw4;
import com.baidu.tieba.py4;
import com.baidu.tieba.q89;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w69;
import com.baidu.tieba.yi;
import com.baidu.tieba.z69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NewWriteActivity extends BaseFragmentActivity implements w69, VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public ScrollView c;
    public LinearLayout d;
    public LinearLayout e;
    public GestureDetector f;
    public VoiceManager g;
    @Nullable
    public View h;
    @Nullable
    public View i;
    @Nullable
    public g89 j;
    @Nullable
    public z69 k;
    public boolean l;
    public final CustomMessageListener m;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.ce5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "a094" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NewWriteActivity newWriteActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.k != null) {
                    this.a.k.j();
                }
                this.a.setResult(100);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public b(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.k != null) {
                    this.a.k.C();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public c(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k != null) {
                    this.a.k.s();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921756));
                }
                this.a.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public d(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.S0("6");
            this.a.h.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public e(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i.setVisibility(8);
                gw4.r("writeVirtualGuide");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public f(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.S0("5");
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public g(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i.setVisibility(8);
                gw4.r("writeVirtualGuide");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteActivity a;

        public h(NewWriteActivity newWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteActivity;
        }

        public /* synthetic */ h(NewWriteActivity newWriteActivity, a aVar) {
            this(newWriteActivity);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.a.k != null) {
                    this.a.k.A();
                }
                yi.z(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    public NewWriteActivity() {
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
        this.m = new a(this, 2921622);
    }

    @Override // com.baidu.tieba.w69
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            U0();
        }
    }

    @Override // com.baidu.tieba.w69
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.scrollTo(0, this.d.getHeight());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.l) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.l) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View view2 = this.i;
            if (view2 != null && view2.getVisibility() == 0) {
                this.i.setVisibility(8);
                gw4.r("writeVirtualGuide");
                return;
            }
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onDestroy();
            }
            x();
            s0().onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onPause();
            }
            s0().onPause(getPageContext());
            yi.z(this, getCurrentFocus());
            gw4.n(ew4.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onResume();
            }
            s0().onResume(getPageContext());
            gw4.o(this, ew4.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onStart();
            }
            s0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onStop();
            }
            s0().onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.g == null) {
                this.g = new VoiceManager();
            }
            return this.g;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w69
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            s0().stopPlay();
        }
    }

    @Override // com.baidu.tieba.w69
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this, 3000);
            bdTopToast.h(false);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.f.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onChangeSkinType(i);
            }
            View view2 = this.h;
            if (view2 != null && view2.getVisibility() == 0) {
                U0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.b(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onNewIntent(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onSaveInstanceState(bundle);
            }
            s0().onSaveInstanceState(this);
            super.onSaveInstanceState(bundle);
        }
    }

    public final void S0(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 4) {
                    str2 = "&skin=dart";
                } else if (skinType == 1) {
                    str2 = "&skin=night";
                } else {
                    str2 = "";
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{a79.a + str2 + ("&from=" + str)});
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2);
            }
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || py4.k().h("key_virtual_image_setting_guide_has_show", false)) {
            return;
        }
        py4.k().u("key_virtual_image_setting_guide_has_show", true);
        ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092655)).inflate();
        View findViewById = findViewById(R.id.obfuscated_res_0x7f092654);
        this.i = findViewById;
        findViewById.setVisibility(0);
        this.i.setOnClickListener(new e(this));
        gw4.m("writeVirtualGuide");
        pw4 d2 = pw4.d(this.i);
        d2.e(R.string.A_X05);
        d2.f(R.color.CAM_X0611);
        pw4 d3 = pw4.d(this.i.findViewById(R.id.obfuscated_res_0x7f092651));
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0201);
        ((GifView) this.i.findViewById(R.id.obfuscated_res_0x7f092650)).setGifRaw(R.raw.obfuscated_res_0x7f110076);
        View findViewById2 = this.i.findViewById(R.id.obfuscated_res_0x7f09264e);
        if (this.k instanceof q89) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams.setMarginStart(TbDimenUtil.dp2px(getApplicationContext(), 100.0f));
            layoutParams.setMargins(0, TbDimenUtil.dp2px(getApplicationContext(), 20.0f), 0, TbDimenUtil.dp2px(getApplicationContext(), 8.0f));
            findViewById2.setLayoutParams(layoutParams);
        }
        pw4 d4 = pw4.d(findViewById2);
        d4.n(R.string.J_X07);
        d4.f(R.color.CAM_X0205);
        ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
        pw4.d((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092652)).v(R.color.CAM_X0105);
        pw4.d((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09264f)).v(R.color.CAM_X0105);
        TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09264c);
        if (profileVirtualImageInfo != null && profileVirtualImageInfo.getIsSetVirtualImage() == 1) {
            textView.setVisibility(8);
        } else {
            pw4 d5 = pw4.d(textView);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0304);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0304);
            d5.j(R.string.A_X07);
            textView.setOnClickListener(new f(this));
        }
        this.i.postDelayed(new g(this), 4000L);
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.h == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092649)).inflate();
                this.h = findViewById(R.id.obfuscated_res_0x7f092648);
            }
            this.h.setVisibility(0);
            pw4 d2 = pw4.d(this.h);
            d2.e(R.string.A_X05);
            d2.f(R.color.CAM_X0611);
            pw4 d3 = pw4.d(this.h.findViewById(R.id.obfuscated_res_0x7f092647));
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0201);
            TextView textView = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f092645);
            pw4 d4 = pw4.d(textView);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X07);
            d4.v(R.color.CAM_X0105);
            d4.n(R.string.J_X07);
            d4.l(R.dimen.L_X02);
            d4.k(R.color.CAM_X0105);
            d4.j(R.string.A_X07);
            textView.setOnClickListener(new c(this));
            TextView textView2 = (TextView) this.h.findViewById(R.id.obfuscated_res_0x7f092644);
            pw4 d5 = pw4.d(textView2);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X07);
            d5.v(R.color.CAM_X0304);
            d5.n(R.string.J_X07);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0304);
            d5.j(R.string.A_X07);
            textView2.setOnClickListener(new d(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            z69 z69Var = this.k;
            if (z69Var != null) {
                z69Var.onActivityResult(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            if (bundle != null) {
                this.l = bundle.getBoolean(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC);
            } else if (getIntent() != null) {
                this.l = getIntent().getBooleanExtra(WriteActivityConfig.KEY_POST_LOCAL_CHANNEL_DYNAMIC, false);
            }
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setContentView(R.layout.obfuscated_res_0x7f0d005e);
            this.a = findViewById(R.id.obfuscated_res_0x7f0917cc);
            this.b = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092613);
            this.c = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092710);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0922d0);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.c.setOnTouchListener(new b(this));
            g89 g89Var = new g89(getPageContext(), this.b, this.d, this.e, this);
            this.j = g89Var;
            z69 b2 = g89Var.b(bundle);
            this.k = b2;
            if (b2 != null) {
                b2.onCreate(bundle);
            }
            this.f = new GestureDetector(getPageContext().getPageActivity(), new h(this, null));
            registerListener(this.m);
            s0().onCreate(getPageContext());
            T0();
        }
    }

    @Override // com.baidu.tieba.w69
    public void v0(int i, boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("type", i);
        g89 g89Var = this.j;
        if (g89Var != null) {
            this.k = g89Var.a(i, z);
        }
        z69 z69Var = this.k;
        if (z69Var != null) {
            z69Var.onCreate(null);
            this.k.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }
}
