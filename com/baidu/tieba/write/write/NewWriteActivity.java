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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bs6;
import com.baidu.tieba.cwa;
import com.baidu.tieba.dwa;
import com.baidu.tieba.h55;
import com.baidu.tieba.jxa;
import com.baidu.tieba.oua;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.zva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
/* loaded from: classes8.dex */
public class NewWriteActivity extends BaseFragmentActivity implements zva, VoiceManager.i {
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
    public oua i;
    @Nullable
    public jxa j;
    @Nullable
    public cwa k;
    public boolean l;
    public boolean m;
    public final CustomMessageListener n;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView g1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
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
                cwa cwaVar = this.a.k;
                if (cwaVar != null) {
                    cwaVar.j();
                }
                this.a.setResult(100);
                this.a.x();
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
                cwa cwaVar = this.a.k;
                if (cwaVar != null) {
                    cwaVar.C();
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
                cwa cwaVar = this.a.k;
                if (cwaVar != null) {
                    cwaVar.s();
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
                this.a.t1("6");
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
                cwa cwaVar = this.a.k;
                if (cwaVar != null) {
                    cwaVar.A();
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

    @Override // com.baidu.tieba.zva
    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z0().stopPlay();
        }
    }

    @Override // com.baidu.tieba.zva
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            v1();
        }
    }

    @Override // com.baidu.tieba.zva
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
        cwa cwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            oua ouaVar = this.i;
            if ((ouaVar == null || !ouaVar.d()) && (cwaVar = this.k) != null) {
                P0(cwaVar.onBackPressed());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onDestroy();
            }
            M();
            z0().onDestory(getPageContext());
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
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onPause();
                this.k.h();
            }
            z0().onPause();
            BdUtilHelper.hideSoftKeyPad(this, getCurrentFocus());
            YunDialogManager.onHidden(h55.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onResume();
            }
            z0().onResume(getPageContext());
            YunDialogManager.onShow(this, h55.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onStart();
            }
            z0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onStop();
            }
            z0().onStop(getPageContext());
        }
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            oua ouaVar = this.i;
            if (ouaVar != null && ouaVar.a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zva
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m = true;
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager z0() {
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

    @Override // com.baidu.tieba.zva
    public void P0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
            setResult(100);
            finish();
        }
    }

    @Override // com.baidu.tieba.zva
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
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
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onChangeSkinType(i);
            }
            View view2 = this.h;
            if (view2 != null && view2.getVisibility() == 0) {
                v1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.d(z);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onNewIntent(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onSaveInstanceState(bundle);
            }
            z0().onSaveInstanceState(this);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tieba.zva
    public void Q0(int i, boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra("type", i);
        jxa jxaVar = this.j;
        if (jxaVar != null) {
            this.k = jxaVar.a(i, z);
        }
        cwa cwaVar = this.k;
        if (cwaVar != null) {
            cwaVar.onCreate(null);
            this.k.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            cwa cwaVar = this.k;
            if (cwaVar != null) {
                cwaVar.onActivityResult(i, i2, intent);
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
            this.a = findViewById(R.id.obfuscated_res_0x7f091a32);
            this.b = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.c = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092a5b);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090795);
            this.e = (LinearLayout) findViewById(R.id.tool_view);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.c.setOnTouchListener(new b(this));
            jxa jxaVar = new jxa(getPageContext(), this.b, this.d, this.e, this);
            this.j = jxaVar;
            cwa b2 = jxaVar.b(bundle);
            this.k = b2;
            if (b2 != null) {
                b2.onCreate(bundle);
            }
            this.f = new GestureDetector(getPageContext().getPageActivity(), new e(this, null));
            registerListener(this.n);
            z0().onCreate(getPageContext());
            oua ouaVar = new oua(this);
            this.i = ouaVar;
            ouaVar.e();
        }
    }

    public void t1(String str) {
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
                urlManager.dealOneLink(pageContext, new String[]{dwa.a + str2 + ("&from=" + str)});
            } catch (Exception e2) {
                BdLog.e("openPageByUrl fail:" + e2);
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.h == null) {
                ((ViewStub) findViewById(R.id.obfuscated_res_0x7f092987)).inflate();
                this.h = findViewById(R.id.obfuscated_res_0x7f092986);
            }
            this.h.setVisibility(0);
            EMManager.from(this.h).setAlpha(R.string.A_X05).setBackGroundColor(R.color.CAM_X0611);
            EMManager.from(this.h.findViewById(R.id.obfuscated_res_0x7f092985)).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            TextView textView = (TextView) this.h.findViewById(R.id.virtual_image_setting_confirm_cancel_btn);
            EMManager.from(textView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0105).setBorderAlpha(R.string.A_X07);
            textView.setOnClickListener(new c(this));
            TextView textView2 = (TextView) this.h.findViewById(R.id.virtual_image_setting_confirm_btn);
            EMManager.from(textView2).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0304).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0304).setBorderAlpha(R.string.A_X07);
            textView2.setOnClickListener(new d(this));
            View findViewById = this.h.findViewById(R.id.obfuscated_res_0x7f092989);
            if (findViewById instanceof ImageView) {
                Glide.with(findViewById).load(bs6.b("icon_mask_post_virtual_image_pb.webp", "icon_mask_post_virtual_image_pb")).into((ImageView) findViewById);
            }
        }
    }
}
