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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a05;
import com.baidu.tieba.a0b;
import com.baidu.tieba.fp6;
import com.baidu.tieba.l1b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.v2b;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
/* loaded from: classes8.dex */
public class NewWriteActivity extends BaseFragmentActivity implements l1b, VoiceManager.j {
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
    public a0b i;
    @Nullable
    public v2b j;
    @Nullable
    public o1b k;
    public boolean l;
    public boolean m;
    public final CustomMessageListener n;

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "a094" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView v1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
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
                o1b o1bVar = this.a.k;
                if (o1bVar != null) {
                    o1bVar.b();
                }
                this.a.setResult(100);
                this.a.s();
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
                o1b o1bVar = this.a.k;
                if (o1bVar != null) {
                    o1bVar.B();
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
                o1b o1bVar = this.a.k;
                if (o1bVar != null) {
                    o1bVar.s();
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
                this.a.q1("6");
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
                o1b o1bVar = this.a.k;
                if (o1bVar != null) {
                    o1bVar.A();
                }
                BdUtilHelper.hideSoftKeyPad(this.a.getActivity(), this.a.getCurrentFocus());
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

    @Override // com.baidu.tieba.l1b
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            O0().stopPlay();
        }
    }

    @Override // com.baidu.tieba.l1b
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            s1();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.g == null) {
                this.g = new VoiceManager();
            }
            return this.g;
        }
        return (VoiceManager) invokeV.objValue;
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

    @Override // com.baidu.tieba.l1b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.scrollTo(0, this.d.getHeight());
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        o1b o1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            a0b a0bVar = this.i;
            if ((a0bVar == null || !a0bVar.d()) && (o1bVar = this.k) != null) {
                L0(o1bVar.onBackPressed());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onDestroy();
            }
            E();
            O0().onDestory(getPageContext());
            if (!this.m) {
                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onPause();
                this.k.i();
            }
            O0().onPause();
            BdUtilHelper.hideSoftKeyPad(this, getCurrentFocus());
            YunDialogManager.onHidden(a05.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onResume();
            }
            O0().onResume(getPageContext());
            YunDialogManager.onShow(this, a05.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onStart();
            }
            O0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onStop();
            }
            O0().onStop(getPageContext());
        }
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            a0b a0bVar = this.i;
            if (a0bVar != null && a0bVar.a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l1b
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.m = true;
            finish();
        }
    }

    @Override // com.baidu.tieba.l1b
    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
            setResult(100);
            finish();
        }
    }

    @Override // com.baidu.tieba.l1b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            new BdTopToast(this, 3000).setIcon(false).setContent(str).show((ViewGroup) this.a);
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
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onChangeSkinType(i);
            }
            View view2 = this.h;
            if (view2 != null && view2.getVisibility() == 0) {
                s1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.d(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onNewIntent(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onSaveInstanceState(bundle);
            }
            O0().onSaveInstanceState(this);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tieba.l1b
    public void M0(int i, boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("type", i);
        v2b v2bVar = this.j;
        if (v2bVar != null) {
            this.k = v2bVar.a(i, z);
        }
        o1b o1bVar = this.k;
        if (o1bVar != null) {
            o1bVar.onCreate(null);
            this.k.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            o1b o1bVar = this.k;
            if (o1bVar != null) {
                o1bVar.onActivityResult(i, i2, intent);
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
            this.a = findViewById(R.id.obfuscated_res_0x7f091a84);
            this.b = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092a7e);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0907a1);
            this.e = (LinearLayout) findViewById(R.id.tool_view);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.c.setOnTouchListener(new b(this));
            v2b v2bVar = new v2b(getPageContext(), this.b, this.d, this.e, this);
            this.j = v2bVar;
            o1b b2 = v2bVar.b(bundle);
            this.k = b2;
            if (b2 != null) {
                b2.onCreate(bundle);
            }
            this.f = new GestureDetector(getPageContext().getPageActivity(), new e(this, null));
            registerListener(this.n);
            O0().onCreate(getPageContext());
            a0b a0bVar = new a0b(this);
            this.i = a0bVar;
            a0bVar.e();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_source", "old_write"));
        }
    }

    public void q1(String str) {
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
                urlManager.dealOneLink(pageContext, new String[]{p1b.a + str2 + ("&from=" + str)});
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2);
            }
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.h == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0929ab)).inflate();
                this.h = findViewById(R.id.obfuscated_res_0x7f0929aa);
            }
            this.h.setVisibility(0);
            EMManager.from(this.h).setAlpha(R.string.A_X05).setBackGroundColor(R.color.CAM_X0611);
            EMManager.from(this.h.findViewById(R.id.obfuscated_res_0x7f0929a9)).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            TextView textView = (TextView) this.h.findViewById(R.id.virtual_image_setting_confirm_cancel_btn);
            EMManager.from(textView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0105).setBorderAlpha(R.string.A_X07);
            textView.setOnClickListener(new c(this));
            TextView textView2 = (TextView) this.h.findViewById(R.id.virtual_image_setting_confirm_btn);
            EMManager.from(textView2).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0304).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0304).setBorderAlpha(R.string.A_X07);
            textView2.setOnClickListener(new d(this));
            View findViewById = this.h.findViewById(R.id.obfuscated_res_0x7f0929ad);
            if (findViewById instanceof ImageView) {
                Glide.with(findViewById).load(fp6.b("icon_mask_post_virtual_image_pb.webp", "icon_mask_post_virtual_image_pb")).into((ImageView) findViewById);
            }
        }
    }
}
