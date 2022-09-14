package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tp4 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(tp4 tp4Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tp4Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fl4.D().G(this.a);
            }
        }
    }

    public tp4() {
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

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, activity) == null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!nv4.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || SpeedStats.PUSH_ACTIVITY.equals(name) || "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            return;
        }
        if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                nv4.a().k(true);
                return;
            } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                return;
            }
        }
        nv4.a().h(name);
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (!nv4.a().d() || SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) || SpeedStats.PUSH_ACTIVITY.equals(name) || "com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            return;
        }
        if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                nv4.a().l(true);
                return;
            } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                return;
            }
        }
        nv4.a().g(name);
    }

    public final void c(@Nullable Activity activity, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, event) == null) || activity == null || BaseActivity.class.isAssignableFrom(activity.getClass()) || BaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
            return;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            nt4 nt4Var = new nt4();
            nt4Var.a = TbadkCoreApplication.getInst();
            nt4Var.b = activity;
            nt4Var.c = event;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921698, nt4Var));
            return;
        }
        ThirdPartyActivityLifecycleEvent thirdPartyActivityLifecycleEvent = new ThirdPartyActivityLifecycleEvent();
        thirdPartyActivityLifecycleEvent.event = event;
        aa5.i(thirdPartyActivityLifecycleEvent);
    }

    public final void d(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && activity != null && PermissionUtil.isAgreePrivacyPolicy()) {
            if (activity.getClass().getName().equals(ej.w())) {
                CurrentPageTypeHelper.PageType pageType = CurrentPageTypeHelper.PageType.OTHER;
                if (TbWebViewActivity.class.isAssignableFrom(activity.getClass())) {
                    pageType = CurrentPageTypeHelper.PageType.WEB;
                } else if (activity.getClass().getName().contains("SwanAppActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.SMART_APP;
                } else if (activity.getClass().getName().contains("FlutterPageActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.FLUTTER;
                } else if (activity.getClass().getName().contains("NewSquareSearchActivity")) {
                    pageType = CurrentPageTypeHelper.PageType.NATIVE_WEB;
                } else if (BaseActivity.class.isAssignableFrom(activity.getClass()) || BaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
                    pageType = CurrentPageTypeHelper.PageType.NATIVE;
                }
                aa5.i(new CurrentPageTypeEvent(pageType));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) || activity == null) {
            return;
        }
        yw4.q().w(activity);
        if (yw4.q().v(activity)) {
            return;
        }
        String name = activity.getClass().getName();
        if (!SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && ((!"com.baidu.tieba.pb.pb.main.PbActivity".equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name)) || !mv4.a().a)) {
            gc.b().e();
        }
        if (s95.b().e(name)) {
            s95.b().a();
        } else if (s95.b().h(activity)) {
            s95.b().c();
            if (s95.b().g(name)) {
                s95.b().l(true);
            }
        } else if (s95.b().f(name)) {
            s95.b().o();
            if (!s95.b().g(name)) {
                s95.b().l(false);
            } else {
                s95.b().l(true);
            }
        }
        mv4.a().e(activity);
        c(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (activity != null && currentActivity != null && s95.b().h(activity) && !s95.b().h(currentActivity)) {
                s95.b().o();
                if (!s95.b().g(currentActivity.getClass().getName())) {
                    s95.b().l(false);
                }
            }
            if (t25.c() != null && activity == t25.c().getActivity()) {
                t25.c().m();
            }
            if (t15.b() != null && activity == t15.b().getActivity()) {
                t15.b().t();
            }
            c(activity, Lifecycle.Event.ON_DESTROY);
            qu4.e(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            c(activity, Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            if (activity != null) {
                if (!activity.getClass().getSimpleName().equals("LogoActivity")) {
                    gc.b().a("BdTokenController", new a(this, UtilHelper.isActivityStartFromScheme(activity)));
                }
                String name = activity.getClass().getName();
                if (s95.b().e(name)) {
                    s95.b().a();
                } else if (s95.b().h(activity)) {
                    s95.b().c();
                    if (s95.b().g(name)) {
                        s95.b().l(true);
                    }
                }
            }
            d(activity);
            b(activity);
            a(activity);
            c(activity, Lifecycle.Event.ON_RESUME);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            c(activity, Lifecycle.Event.ON_START);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
            yw4.q().x(activity);
            c(activity, Lifecycle.Event.ON_STOP);
        }
    }
}
