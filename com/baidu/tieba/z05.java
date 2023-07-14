package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
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
/* loaded from: classes8.dex */
public class z05 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gz6 a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, activity, bundle) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(z05 z05Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z05Var, Boolean.valueOf(z)};
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
                BdTokenController.J().M(this.a);
            }
        }
    }

    public z05() {
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
        this.a = new gz6();
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, activity) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (v85.a().d() && !SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    v85.a().k(true);
                    return;
                } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                    return;
                }
            }
            v85.a().h(name);
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (v85.a().d() && !SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    v85.a().l(true);
                    return;
                } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                    return;
                }
            }
            v85.a().g(name);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            d(activity, Lifecycle.Event.ON_PAUSE);
            c(activity, Lifecycle.Event.ON_PAUSE);
            boolean z = false;
            if (activity.isFinishing()) {
                g65.i();
                if (((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) || activity.getClass().getName().equals("com.baidu.tieba.UpdateDialog")) {
                    z = true;
                }
                m65.m(z);
            } else {
                m65.m(false);
            }
            TbadkCoreApplication.getInst().setCurGlobalActivity(null);
            this.a.a(activity);
        }
    }

    public final void c(@Nullable Activity activity, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, event) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (Lifecycle.Event.ON_START.equals(event)) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                TbadkCoreApplication.getInst().notifyPageCountDelta(1, name);
            } else {
                e(1, name);
            }
        } else if (Lifecycle.Event.ON_STOP.equals(event)) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                TbadkCoreApplication.getInst().notifyPageCountDelta(-1, name);
            } else {
                e(-1, name);
            }
        }
    }

    public final void d(@Nullable Activity activity, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, activity, event) == null) && activity != null && !BaseActivity.class.isAssignableFrom(activity.getClass()) && !BaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                y45 y45Var = new y45();
                y45Var.a = TbadkCoreApplication.getInst();
                y45Var.b = activity;
                y45Var.c = event;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921698, y45Var));
                return;
            }
            ThirdPartyActivityLifecycleEvent thirdPartyActivityLifecycleEvent = new ThirdPartyActivityLifecycleEvent();
            thirdPartyActivityLifecycleEvent.event = event;
            wq5.i(thirdPartyActivityLifecycleEvent);
        }
    }

    public final void e(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            Intent intent = new Intent("com.tieba.baidu.pagecount");
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra("countDelta", i);
            intent.putExtra("activityClassName", str);
            TbadkCoreApplication.getInst().sendBroadcast(intent);
        }
    }

    public final void f(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, activity) != null) || activity == null || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        if (activity.getClass().getName().equals(yi.z())) {
            CurrentPageTypeHelper.PageType pageType = CurrentPageTypeHelper.PageType.OTHER;
            if (TBWebViewActivity.class.isAssignableFrom(activity.getClass())) {
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
            wq5.i(new CurrentPageTypeEvent(pageType));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (activity != null && currentActivity != null && nq5.b().h(activity) && !nq5.b().h(currentActivity)) {
                nq5.b().o();
                if (!nq5.b().g(currentActivity.getClass().getName())) {
                    nq5.b().l(false);
                }
            }
            if (wg5.i() != null && activity == wg5.i().getActivity()) {
                wg5.i().m();
            }
            if (wg5.k() != null && activity == wg5.k().getActivity()) {
                wg5.l();
            }
            if (jf5.b() != null && activity == jf5.b().getActivity()) {
                jf5.b().t();
            }
            d(activity, Lifecycle.Event.ON_DESTROY);
            c(activity, Lifecycle.Event.ON_DESTROY);
            if (activity instanceof TbPageContextSupport) {
                TbPageContext pageContext = ((TbPageContextSupport) activity).getPageContext();
                lu6.b().unregister(pageContext);
                BdUniqueId uniqueId = pageContext.getUniqueId();
                if (uniqueId != null) {
                    lu6.a(uniqueId);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, activity, bundle) != null) || activity == null) {
            return;
        }
        aa5.q().w(activity);
        if (aa5.q().v(activity)) {
            return;
        }
        String name = activity.getClass().getName();
        if (!SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && !m65.l(activity) && ((!"com.baidu.tieba.pb.pb.main.PbActivity".equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name)) || !u85.a().a)) {
            bc.b().f();
        }
        if (nq5.b().e(name)) {
            nq5.b().a();
        } else if (nq5.b().h(activity)) {
            nq5.b().c();
            if (nq5.b().g(name)) {
                nq5.b().l(true);
            }
        } else if (nq5.b().f(name)) {
            nq5.b().o();
            if (!nq5.b().g(name)) {
                nq5.b().l(false);
            } else {
                nq5.b().l(true);
            }
        }
        u85.a().e(activity);
        d(activity, Lifecycle.Event.ON_CREATE);
        c(activity, Lifecycle.Event.ON_CREATE);
        g65.i();
        m65.m(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            if (activity != null) {
                if (!activity.getClass().getSimpleName().equals("LogoActivity")) {
                    bc.b().a("BdTokenController", new a(this, UtilHelper.isActivityStartFromScheme(activity)));
                }
                String name = activity.getClass().getName();
                if (nq5.b().e(name)) {
                    nq5.b().a();
                } else if (nq5.b().h(activity)) {
                    nq5.b().c();
                    if (nq5.b().g(name)) {
                        nq5.b().l(true);
                    }
                }
            }
            f(activity);
            b(activity);
            a(activity);
            d(activity, Lifecycle.Event.ON_RESUME);
            c(activity, Lifecycle.Event.ON_RESUME);
            TbadkCoreApplication.getInst().setCurGlobalActivity(activity);
            this.a.b(activity);
            if (!TbadkCoreApplication.getInst().isMainProcess(false) && activity != null && activity.getClass().getName().equals("com.bdgame.assist.SplashActivity")) {
                Intent intent = new Intent("com.tieba.baidu.notifyprocess");
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra("message", false);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            d(activity, Lifecycle.Event.ON_START);
            c(activity, Lifecycle.Event.ON_START);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
            aa5.q().x(activity);
            d(activity, Lifecycle.Event.ON_STOP);
            c(activity, Lifecycle.Event.ON_STOP);
        }
    }
}
