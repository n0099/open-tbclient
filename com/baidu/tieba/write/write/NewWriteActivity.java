package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bfa;
import com.baidu.tieba.d85;
import com.baidu.tieba.fya;
import com.baidu.tieba.kva;
import com.baidu.tieba.l65;
import com.baidu.tieba.m65;
import com.baidu.tieba.uu6;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vwa;
import com.baidu.tieba.yi;
import com.baidu.tieba.ywa;
import com.baidu.tieba.zwa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
/* loaded from: classes8.dex */
public class NewWriteActivity extends BaseFragmentActivity implements vwa, VoiceManager.j {
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
    public kva i;
    @Nullable
    public fya j;
    @Nullable
    public ywa k;
    public boolean l;
    public boolean m;
    public final CustomMessageListener n;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tieba.gt5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "a094" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
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
                ywa ywaVar = this.a.k;
                if (ywaVar != null) {
                    ywaVar.j();
                }
                this.a.setResult(100);
                this.a.y();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                ywa ywaVar = this.a.k;
                if (ywaVar != null) {
                    ywaVar.C();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
                ywa ywaVar = this.a.k;
                if (ywaVar != null) {
                    ywaVar.s();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921756));
                }
                this.a.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u1("6");
                this.a.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
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

        public /* synthetic */ e(NewWriteActivity newWriteActivity, a aVar) {
            this(newWriteActivity);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                ywa ywaVar = this.a.k;
                if (ywaVar != null) {
                    ywaVar.A();
                }
                yi.A(this.a.getActivity(), this.a.getCurrentFocus());
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
        this.n = new a(this, 2921622);
    }

    @Override // com.baidu.tieba.vwa
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            y0().stopPlay();
        }
    }

    @Override // com.baidu.tieba.vwa
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            w1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.l) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tieba.vwa
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.scrollTo(0, this.d.getHeight());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.l) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ywa ywaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            kva kvaVar = this.i;
            if ((kvaVar == null || !kvaVar.d()) && (ywaVar = this.k) != null) {
                R0(ywaVar.onBackPressed());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onDestroy();
            }
            M();
            y0().onDestory(getPageContext());
            if (!this.m) {
                bfa.h(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onPause();
                this.k.h();
            }
            y0().onPause();
            yi.A(this, getCurrentFocus());
            m65.o(l65.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onResume();
            }
            y0().onResume(getPageContext());
            m65.p(this, l65.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onStart();
            }
            y0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onStop();
            }
            y0().onStop(getPageContext());
        }
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            kva kvaVar = this.i;
            if (kvaVar != null && kvaVar.a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vwa
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m = true;
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.g == null) {
                this.g = new VoiceManager();
            }
            return this.g;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vwa
    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
            setResult(100);
            finish();
        }
    }

    @Override // com.baidu.tieba.vwa
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
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
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onChangeSkinType(i);
            }
            View view2 = this.h;
            if (view2 != null && view2.getVisibility() == 0) {
                w1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.b(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onNewIntent(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onSaveInstanceState(bundle);
            }
            y0().onSaveInstanceState(this);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tieba.vwa
    public void S0(int i, boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("type", i);
        fya fyaVar = this.j;
        if (fyaVar != null) {
            this.k = fyaVar.a(i, z);
        }
        ywa ywaVar = this.k;
        if (ywaVar != null) {
            ywaVar.onCreate(null);
            this.k.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            ywa ywaVar = this.k;
            if (ywaVar != null) {
                ywaVar.onActivityResult(i, i2, intent);
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
            setContentView(R.layout.obfuscated_res_0x7f0d0061);
            this.a = findViewById(R.id.obfuscated_res_0x7f091a18);
            this.b = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092a3b);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090786);
            this.e = (LinearLayout) findViewById(R.id.tool_view);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.c.setOnTouchListener(new b(this));
            fya fyaVar = new fya(getPageContext(), this.b, this.d, this.e, this);
            this.j = fyaVar;
            ywa b2 = fyaVar.b(bundle);
            this.k = b2;
            if (b2 != null) {
                b2.onCreate(bundle);
            }
            this.f = new GestureDetector(getPageContext().getPageActivity(), new e(this, null));
            registerListener(this.n);
            y0().onCreate(getPageContext());
            kva kvaVar = new kva(this);
            this.i = kvaVar;
            kvaVar.e();
        }
    }

    public void u1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            try {
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    str2 = "&skin=dark";
                } else {
                    str2 = "";
                }
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                urlManager.dealOneLink(pageContext, new String[]{zwa.a + str2 + ("&from=" + str)});
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2);
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.h == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092967)).inflate();
                this.h = findViewById(R.id.obfuscated_res_0x7f092966);
            }
            this.h.setVisibility(0);
            d85 d2 = d85.d(this.h);
            d2.e(R.string.A_X05);
            d2.f(R.color.CAM_X0611);
            d85 d3 = d85.d(this.h.findViewById(R.id.obfuscated_res_0x7f092965));
            d3.o(R.string.J_X06);
            d3.f(R.color.CAM_X0201);
            TextView textView = (TextView) this.h.findViewById(R.id.virtual_image_setting_confirm_cancel_btn);
            d85 d4 = d85.d(textView);
            d4.D(R.string.F_X01);
            d4.C(R.dimen.T_X07);
            d4.x(R.color.CAM_X0105);
            d4.o(R.string.J_X07);
            d4.m(R.dimen.L_X02);
            d4.l(R.color.CAM_X0105);
            d4.k(R.string.A_X07);
            textView.setOnClickListener(new c(this));
            TextView textView2 = (TextView) this.h.findViewById(R.id.virtual_image_setting_confirm_btn);
            d85 d5 = d85.d(textView2);
            d5.D(R.string.F_X01);
            d5.C(R.dimen.T_X07);
            d5.x(R.color.CAM_X0304);
            d5.o(R.string.J_X07);
            d5.m(R.dimen.L_X02);
            d5.l(R.color.CAM_X0304);
            d5.k(R.string.A_X07);
            textView2.setOnClickListener(new d(this));
            View findViewById = this.h.findViewById(R.id.obfuscated_res_0x7f092969);
            if (findViewById instanceof ImageView) {
                Glide.with(findViewById).load(uu6.b("icon_mask_post_virtual_image_pb.webp", "icon_mask_post_virtual_image_pb")).into((ImageView) findViewById);
            }
        }
    }
}
