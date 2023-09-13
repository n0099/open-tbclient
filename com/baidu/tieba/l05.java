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
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l05 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hz6 a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, bundle) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(l05 l05Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l05Var, Boolean.valueOf(z)};
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
                BdTokenController.E().H(this.a);
            }
        }
    }

    public l05() {
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
        this.a = new hz6();
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, activity) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (e85.a().d() && !SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    e85.a().k(true);
                    return;
                } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                    return;
                }
            }
            e85.a().h(name);
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (e85.a().d() && !SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    e85.a().l(true);
                    return;
                } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                    return;
                }
            }
            e85.a().g(name);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            c(activity, Lifecycle.Event.ON_PAUSE);
            boolean z = false;
            if (activity.isFinishing()) {
                o55.i();
                if (((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) || activity.getClass().getName().equals("com.baidu.tieba.UpdateDialog")) {
                    z = true;
                }
                YunDialogManager.markIsBackFromYunDialog(z);
            } else {
                YunDialogManager.markIsBackFromYunDialog(false);
            }
            TbadkCoreApplication.getInst().setCurGlobalActivity(null);
            this.a.a(activity);
        }
    }

    public final void c(@Nullable Activity activity, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, event) == null) && activity != null && !BaseActivity.class.isAssignableFrom(activity.getClass()) && !BaseFragmentActivity.class.isAssignableFrom(activity.getClass()) && TbadkCoreApplication.getInst().isMainProcess(false)) {
            g45 g45Var = new g45();
            g45Var.a = TbadkCoreApplication.getInst();
            g45Var.b = activity;
            g45Var.c = event;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921698, g45Var));
        }
    }

    public final void d(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, activity) != null) || activity == null || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        if (activity.getClass().getName().equals(BdUtilHelper.getTopActivityName())) {
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
            MutiProcessManager.publishEvent(new CurrentPageTypeEvent(pageType));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (activity != null && currentActivity != null && cq5.b().h(activity) && !cq5.b().h(currentActivity)) {
                cq5.b().o();
                if (!cq5.b().g(currentActivity.getClass().getName())) {
                    cq5.b().l(false);
                }
            }
            if (eg5.i() != null && activity == eg5.i().getActivity()) {
                eg5.i().n();
            }
            if (eg5.k() != null && activity == eg5.k().getActivity()) {
                eg5.l();
            }
            if (ne5.b() != null && activity == ne5.b().getActivity()) {
                ne5.b().t();
            }
            c(activity, Lifecycle.Event.ON_DESTROY);
            z66.L().K(activity);
            if (activity instanceof TbPageContextSupport) {
                TbPageContext pageContext = ((TbPageContextSupport) activity).getPageContext();
                hu6.b().unregister(pageContext);
                BdUniqueId uniqueId = pageContext.getUniqueId();
                if (uniqueId != null) {
                    hu6.a(uniqueId);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, activity, bundle) != null) || activity == null) {
            return;
        }
        i95.q().w(activity);
        if (i95.q().v(activity)) {
            return;
        }
        String name = activity.getClass().getName();
        if (!SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && !YunDialogManager.isYunDialogActivity(activity) && ((!"com.baidu.tieba.pb.pb.main.PbActivity".equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name)) || !d85.a().a)) {
            IdleHandlerManager.getInstance().runIdleTaskImmediately();
        }
        if (cq5.b().e(name)) {
            cq5.b().a();
        } else if (cq5.b().h(activity)) {
            cq5.b().c();
            if (cq5.b().g(name)) {
                cq5.b().l(true);
            }
        } else if (cq5.b().f(name)) {
            cq5.b().o();
            if (!cq5.b().g(name)) {
                cq5.b().l(false);
            } else {
                cq5.b().l(true);
            }
        }
        d85.a().e(activity);
        c(activity, Lifecycle.Event.ON_CREATE);
        o55.i();
        YunDialogManager.markIsBackFromYunDialog(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            if (activity != null) {
                if (!activity.getClass().getSimpleName().equals("LogoActivity")) {
                    IdleHandlerManager.getInstance().addOrRunTask("BdTokenController", new a(this, UtilHelper.isActivityStartFromScheme(activity)));
                }
                String name = activity.getClass().getName();
                if (cq5.b().e(name)) {
                    cq5.b().a();
                } else if (cq5.b().h(activity)) {
                    cq5.b().c();
                    if (cq5.b().g(name)) {
                        cq5.b().l(true);
                    }
                }
            }
            d(activity);
            b(activity);
            a(activity);
            c(activity, Lifecycle.Event.ON_RESUME);
            z66.L().d0(activity);
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
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            c(activity, Lifecycle.Event.ON_START);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
            i95.q().x(activity);
            c(activity, Lifecycle.Event.ON_STOP);
        }
    }
}
