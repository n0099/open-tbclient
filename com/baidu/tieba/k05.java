package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k05 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public a(k05 k05Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k05Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (NotificationManagerCompat.from(this.a).areNotificationsEnabled()) {
                    boolean z = SharedPrefHelper.getInstance().getBoolean("official_push_switch", true);
                    Activity activity = this.a;
                    BrowserHelper.startWebActivity((Context) activity, "", "https://tieba.baidu.com/mo/q/hybrid-main-service/pushSettings?pageType=1&officialPushMsgStatus=" + (z ? 1 : 0), true);
                    return;
                }
                DialogUtil.jumpSystemNotificationSetting(this.a);
            }
        }
    }

    public k05() {
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
        this.a = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null && activity.getClass().getName().equals("com.baidu.sapi2.activity.LoginActivity")) {
            this.a = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && activity != null && activity.getClass().getName().equals("com.baidu.sapi2.activity.LoginActivity") && this.a) {
            this.a = false;
            FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView().findViewById(16908290);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.dip2px(activity, 20.0f), BdUtilHelper.dip2px(activity, 20.0f));
            layoutParams.addRule(11);
            layoutParams.rightMargin = BdUtilHelper.getDimens(activity, R.dimen.tbds42);
            layoutParams.topMargin = BdUtilHelper.getDimens(activity, R.dimen.tbds126) - BdUtilHelper.getStatusBarHeight(activity);
            ImageView imageView = new ImageView(activity);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Drawable drawable = SvgManager.getInstance().getDrawable(R.drawable.icon_login_setting_svg, 1, false);
            ColorStateList colorListByResourceType = SvgManager.SvgResourceStateType.NORMAL_PRESS.getColorListByResourceType(SkinManager.getColor(4, null, R.color.CAM_X0105));
            if (colorListByResourceType != null && drawable != null) {
                drawable = drawable.mutate();
                DrawableCompat.setTintList(drawable, colorListByResourceType);
            }
            imageView.setImageDrawable(drawable);
            RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R.id.obfuscated_res_0x7f092116);
            if (relativeLayout == null) {
                return;
            }
            relativeLayout.addView(imageView);
            imageView.setOnClickListener(new a(this, activity));
        }
    }
}
