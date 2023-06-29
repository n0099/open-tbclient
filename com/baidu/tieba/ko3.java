package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ko3 implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public SlideHelper a;
    public WeakReference<SwanAppActivity> b;
    public rh3 c;
    public BroadcastReceiver d;

    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ko3 this$0;

        public a(ko3 ko3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = ko3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && "android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if ((PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_HOME_KEY.equals(stringExtra) || stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) && this.this$0.a != null) {
                    this.this$0.a.closePane();
                    this.this$0.a.setCanSlide(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ ko3 b;

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public b(ko3 ko3Var, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ko3Var, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ko3Var;
            this.a = swanAppActivity;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.q0(3);
                this.b.k();
                this.a.overridePendingTransition(0, 0);
                q23.e().g();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view2, float f) {
            View maskView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view2, f) == null) && (maskView = this.b.a.getMaskView()) != null) {
                maskView.setAlpha(1.0f - f);
                if (this.a.a0()) {
                    this.a.R().t0();
                }
                if (f == 0.0f) {
                    maskView.setBackgroundColor(Color.parseColor("#40000000"));
                }
                if (f == 1.0f) {
                    maskView.setBackgroundColor(0);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919770, "Lcom/baidu/tieba/ko3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919770, "Lcom/baidu/tieba/ko3;");
                return;
            }
        }
        e = ms1.a;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || swanAppActivity.getResources().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.closePane();
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && jv2.M().a()) {
            this.c.c(8);
        }
    }

    public void o() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        swanAppActivity.registerReceiver(this.d, intentFilter);
    }

    public void p() {
        WeakReference<SwanAppActivity> weakReference;
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (weakReference = this.b) == null || (swanAppActivity = weakReference.get()) == null) {
            return;
        }
        swanAppActivity.unregisterReceiver(this.d);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.b.get() == null) {
            return;
        }
        this.a.setCanSlide(d());
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && uw2.c(true).booleanValue()) {
            this.c.c(0);
        }
    }

    public ko3(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.b = new WeakReference<>(swanAppActivity);
        this.a = new SlideHelper();
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.a.setCanSlide(z);
        }
    }

    public void f() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (swanAppActivity = this.b.get()) != null && !swanAppActivity.isDestroyed()) {
            this.a.attachSlideView(swanAppActivity, swanAppActivity.findViewById(16908290), new SlidingPaneLayout.LayoutParams(-1, -1));
            this.a.attachActivity(swanAppActivity);
            this.a.setEnableReleaseWhenNoTranslucent(false);
            this.a.setFadeColor(0);
            this.a.setSlideInterceptor(this);
            this.a.setSlideListener(new b(this, swanAppActivity));
            iy1 h = h();
            if (h != null) {
                this.a.setRegionFactor(h.z());
            }
        }
    }

    public final iy1 h() {
        InterceptResult invokeV;
        lb2 Y;
        ib2 m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || (Y = swanAppActivity.Y()) == null || (m = Y.m()) == null || !(m instanceof kb2)) {
                return null;
            }
            return ((kb2) m).q3();
        }
        return (iy1) invokeV.objValue;
    }

    public void n() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        rh3 x = swanAppActivity.x();
        this.c = x;
        if (x == null) {
            return;
        }
        if (uw2.c(false).booleanValue()) {
            this.c.c(0);
        }
        f();
    }

    public void s() {
        SwanAppActivity swanAppActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (swanAppActivity = this.b.get()) == null) {
            return;
        }
        zw2.a T2 = swanAppActivity.T();
        if ((T2 != null && "1230000000000000".equals(T2.T())) || swanAppActivity.S() == 1) {
            this.a.setCanSlide(false);
        } else {
            this.a.setCanSlide(d());
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.baidu.tieba.jy1] */
    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        lb2 Y;
        iy1 h;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity == null || !swanAppActivity.a0() || (Y = swanAppActivity.Y()) == null || (h = h()) == null) {
                return false;
            }
            ly1 j = h.j();
            if (j != null && j.r() != 0 && j.r().canGoBack()) {
                z = true;
            } else {
                z = false;
            }
            if (Y.k() > 1 || !h.isSlidable(motionEvent) || z || !m()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppActivity swanAppActivity = this.b.get();
            if (swanAppActivity != null && !swanAppActivity.isDestroyed() && swanAppActivity.a0()) {
                kb2 o = swanAppActivity.Y().o();
                if (o != null) {
                    rc3 I1 = o.I1();
                    if (I1 == null) {
                        return true;
                    }
                    if (I1.l || I1.m) {
                        ch3 ch3Var = a43.g(true).get("scope_disable_swipe_back");
                        if (ch3Var == null || ch3Var.d) {
                            return false;
                        }
                        SlideHelper slideHelper = this.a;
                        if (slideHelper != null) {
                            slideHelper.setRegionFactor(0.1d);
                        }
                    }
                    return true;
                } else if (e) {
                    Log.d("SwanActivitySlideHelper", "topFragment = null; return false");
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
