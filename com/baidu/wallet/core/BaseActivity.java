package com.baidu.wallet.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Application;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statusbar.ImmersiveKeyboardAdjust;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.LoadingDialog;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.PromptImageDialog;
import com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class BaseActivity extends SDKBaseActivity implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DIALOG_GOTO_APP_DETAIL = 52;
    public static final int DIALOG_IMAGE_TIP = 2;
    public static final int DIALOG_NO_NETWORK = 11;
    public static final int DIALOG_PP_SET_PAYPWD = 25;
    public static final int DIALOG_PROMPT = 3;
    public static final int DIALOG_SELECT_PAYMENT = 32;
    public static final int DIALOG_WAIT_S0 = 0;
    public static final int DIALOG_WAIT_S1 = -1;
    public static final int DIALOG_WAIT_S2 = -2;
    public static final String TAG = "BaseActivity";
    public static final String WITH_ANIM = "with_anim";
    public static LinkedList<BaseActivity> mActivityStack;
    public static int mLiveActivityNum;
    public static float sNocompatDensity;
    public static float sNocompatScaleDensity;
    public transient /* synthetic */ FieldHolder $fh;
    public int defaultLenth;
    public boolean isSupportUIAdapatation;
    public boolean isTranslucentOrFloating;
    public boolean isWidthLimitedMode;
    public View mContent;
    public String mDialogMsg;
    public int mFlag;
    public boolean mIsActivityInForeground;
    public boolean mIsMultiWindowAvailable;
    public boolean mIsShowMultiWindowTips;
    public ImmersiveKeyboardAdjust mKeyboardAdjust;
    public String mMultiWindowTipsID;
    public View mNightModeView;
    public SafeScrollView mSafeScrollView;
    public long mTimeVal;
    public boolean mWindowNightMode;
    public b myOrientoinListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1712680755, "Lcom/baidu/wallet/core/BaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1712680755, "Lcom/baidu/wallet/core/BaseActivity;");
                return;
            }
        }
        mActivityStack = new LinkedList<>();
        mLiveActivityNum = 0;
    }

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDialogMsg = "";
        this.mIsShowMultiWindowTips = false;
        this.mIsMultiWindowAvailable = true;
        this.mMultiWindowTipsID = "wallet_base_multi_window_tips";
        this.mSafeScrollView = null;
        this.mIsActivityInForeground = false;
        this.mNightModeView = null;
        this.mWindowNightMode = true;
        this.isWidthLimitedMode = true;
        this.defaultLenth = 375;
        this.isSupportUIAdapatation = false;
        this.isTranslucentOrFloating = false;
        this.mFlag = 0;
    }

    public static void addLiveActivityNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            mLiveActivityNum++;
        }
    }

    public static synchronized void addToTask(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                mActivityStack.remove(baseActivity);
                mActivityStack.add(baseActivity);
            }
        }
    }

    public static synchronized void clearTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (BaseActivity.class) {
                Iterator<BaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    it.next().finish();
                }
            }
        }
    }

    public static synchronized void clearTaskExcept(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                Iterator<BaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    BaseActivity next = it.next();
                    if (next != baseActivity) {
                        next.finish();
                    }
                }
            }
        }
    }

    public static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                LogUtil.d("BaseActivity", "clearTasksTopOf. stack size = " + mActivityStack.size());
                for (int size = mActivityStack.size() + (-1); size > 0; size--) {
                    BaseActivity baseActivity2 = mActivityStack.get(size);
                    if (baseActivity2 == baseActivity) {
                        break;
                    }
                    baseActivity2.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksWithActivityName(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, cls) == null) {
            synchronized (BaseActivity.class) {
                for (int size = mActivityStack.size() - 1; size > 0; size--) {
                    BaseActivity baseActivity = mActivityStack.get(size);
                    if (baseActivity.getClass().equals(cls)) {
                        break;
                    }
                    baseActivity.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            synchronized (BaseActivity.class) {
                LogUtil.methodTrace("BaseActivity");
                LogUtil.d("BaseActivity", "clearTasksWithFlag. stack size = " + mActivityStack.size());
                Iterator<BaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    BaseActivity next = it.next();
                    if ((next.mFlag & i2) != 0) {
                        next.finish();
                        next.overridePendingTransition(0, 0);
                    }
                }
            }
        }
    }

    private void convertFromTranslucent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(getActivity(), new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    private void convertToTranslucent() {
        Object obj;
        Class<?> cls;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
                int length = declaredClasses.length;
                int i2 = 0;
                while (true) {
                    obj = null;
                    if (i2 >= length) {
                        cls = null;
                        break;
                    }
                    cls = declaredClasses[i2];
                    if (cls.getSimpleName().equals("TranslucentConversionListener")) {
                        break;
                    }
                    i2++;
                }
                if (cls != null) {
                    obj2 = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler(this) { // from class: com.baidu.wallet.core.BaseActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ BaseActivity f60515a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f60515a = this;
                        }

                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj3, Method method, Object[] objArr) throws Throwable {
                            InterceptResult invokeLLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj3, method, objArr)) == null) {
                                return null;
                            }
                            return invokeLLL.objValue;
                        }
                    });
                } else {
                    obj2 = null;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
                        declaredMethod.setAccessible(true);
                        obj = declaredMethod.invoke(this, new Object[0]);
                    } catch (Exception unused) {
                    }
                    Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(getActivity(), obj2, obj);
                    return;
                }
                Method declaredMethod3 = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(getActivity(), obj2);
            } catch (Throwable unused2) {
            }
        }
    }

    public static void decLiveActivityNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            mLiveActivityNum--;
        }
    }

    public static BaseActivity getTopActivity() throws Throwable {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? mActivityStack.getLast() : (BaseActivity) invokeV.objValue;
    }

    public static boolean isAppInForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? mLiveActivityNum > 0 : invokeV.booleanValue;
    }

    private boolean isBaiduappPlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isTranslucentOrFloating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$styleable");
                Field declaredField = cls.getDeclaredField("Window");
                declaredField.setAccessible(true);
                TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) declaredField.get(null));
                Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
                declaredField3.setAccessible(true);
                Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
                declaredField4.setAccessible(true);
                return obtainStyledAttributes.getBoolean(((Integer) declaredField4.get(null)).intValue(), false) || obtainStyledAttributes.getBoolean(((Integer) declaredField2.get(null)).intValue(), false) || (!obtainStyledAttributes.hasValue(((Integer) declaredField2.get(null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get(null)).intValue(), false));
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static synchronized void removeFromTask(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                mActivityStack.remove(baseActivity);
            }
        }
    }

    public static void setCustomDensity(@NonNull Application application, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{application, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
            if (sNocompatDensity == 0.0f) {
                sNocompatDensity = displayMetrics.density;
                sNocompatScaleDensity = displayMetrics.scaledDensity;
                application.registerComponentCallbacks(new ComponentCallbacks(application) { // from class: com.baidu.wallet.core.BaseActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Application f60524a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {application};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60524a = application;
                    }

                    @Override // android.content.ComponentCallbacks
                    public void onConfigurationChanged(Configuration configuration) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, configuration) == null) || configuration == null || configuration.fontScale <= 0.0f) {
                            return;
                        }
                        float unused = BaseActivity.sNocompatScaleDensity = this.f60524a.getResources().getDisplayMetrics().scaledDensity;
                    }

                    @Override // android.content.ComponentCallbacks
                    public void onLowMemory() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }
                });
            }
            if (z) {
                i3 = displayMetrics.widthPixels;
            } else {
                i3 = displayMetrics.heightPixels;
            }
            float f2 = i3 / i2;
            displayMetrics.density = f2;
            displayMetrics.scaledDensity = (sNocompatScaleDensity / sNocompatDensity) * f2;
            displayMetrics.densityDpi = (int) (160.0f * f2);
        }
    }

    @TargetApi(24)
    private void showMultiWindowTips() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.mIsShowMultiWindowTips) {
                GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.mMultiWindowTipsID), -1, 1);
            }
            if (this.mIsMultiWindowAvailable) {
                return;
            }
            finish();
        }
    }

    public void cancleRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void closeNightMode() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && isWindowNightMode() && this.mNightModeView != null) {
            getWindowManager().removeViewImmediate(this.mNightModeView);
            this.mNightModeView = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
            try {
                z = getIntent().getBooleanExtra("with_anim", true);
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                BaiduWalletUtils.finishActivityAnim(getActivity());
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
            }
        }
    }

    public void finishWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.finish();
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getActivity() : (Activity) invokeV.objValue;
    }

    public ArrayList<String> getHandlerFailureData(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, str)) == null) {
            String str3 = "";
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                str2 = String.valueOf(i2);
                try {
                    str3 = String.valueOf(i3);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str2 = "";
            }
            arrayList.add(str2);
            arrayList.add(str3);
            arrayList.add(str);
            return arrayList;
        }
        return (ArrayList) invokeIIL.objValue;
    }

    public boolean isActivityInForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIsActivityInForeground : invokeV.booleanValue;
    }

    public boolean isStatusbarTextColorBlack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mWindowNightMode : invokeV.booleanValue;
    }

    public void keyBoardAdjustDetach() {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ImmersiveKeyboardAdjust immersiveKeyboardAdjust = this.mKeyboardAdjust;
            if (immersiveKeyboardAdjust != null && (view = this.mContent) != null) {
                immersiveKeyboardAdjust.detachActivity(view);
            }
            this.mKeyboardAdjust = null;
            this.mContent = null;
        }
    }

    public boolean needKeyboardAdjust() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onAttachedToWindow();
            if (BaiduWalletUtils.isNightMode()) {
                startNightMode();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException unused) {
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
            if (getIntent().getBooleanExtra("with_anim", true)) {
                BaiduWalletUtils.finishActivityAnim(getActivity());
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
            }
        }
    }

    public void onBackPressedForWalletApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException unused) {
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        }
    }

    public void onBackPressedWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            try {
                super.onBackPressed();
            } catch (IllegalStateException unused) {
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
            overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ActivityInfo activityInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            this.mTimeVal = System.currentTimeMillis();
            if (getApplicationInfo().targetSdkVersion > 26 && Build.VERSION.SDK_INT == 26) {
                boolean isTranslucentOrFloating = isTranslucentOrFloating();
                this.isTranslucentOrFloating = isTranslucentOrFloating;
                if (isTranslucentOrFloating) {
                    convertFromTranslucent();
                }
            }
            try {
                if (!isBaiduappPlugin()) {
                    setRequestedOrientation(1);
                }
            } catch (Exception unused) {
            }
            if (getApplicationInfo().targetSdkVersion > 26 && Build.VERSION.SDK_INT == 26) {
                if ("iqiyi".equals(BeanConstants.CHANNEL_ID)) {
                    try {
                        Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                        declaredField.setAccessible(true);
                        if (declaredField != null) {
                            activityInfo = (ActivityInfo) declaredField.get(getActivity());
                        }
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (NoSuchFieldException e3) {
                        e3.printStackTrace();
                    }
                    activityInfo = null;
                } else {
                    try {
                        activityInfo = getPackageManager().getActivityInfo(getComponentName(), 0);
                    } catch (PackageManager.NameNotFoundException e4) {
                        e4.printStackTrace();
                    }
                }
                if (activityInfo != null) {
                    int themeResource = activityInfo.getThemeResource();
                    if (themeResource == ResUtils.style(getActivity(), "EbpayThemeActivitTranslucent")) {
                        setTheme(ResUtils.style(getActivity(), "EbpayThemeActivitTranslucentForSystem26"));
                        convertToTranslucent();
                    } else if (themeResource == ResUtils.style(getActivity(), "EbpayThemeActivityWelcome.Dialog")) {
                        setTheme(ResUtils.style(getActivity(), "EbpayThemeActivityWelcomeDialogForSystem26"));
                        convertToTranslucent();
                    } else if (themeResource == ResUtils.style(getActivity(), "EbpayThemeActivityWelcome")) {
                        setTheme(ResUtils.style(getActivity(), "EbpayThemeActivityWelcomeForSystem26"));
                        convertToTranslucent();
                    } else if (themeResource == ResUtils.style(getActivity(), "CameraMist")) {
                        setTheme(ResUtils.style(getActivity(), "CameraMistForSystem26"));
                        convertToTranslucent();
                    } else if (themeResource == ResUtils.style(getActivity(), "Theme.LBSPaySDK_Transparent")) {
                        setTheme(ResUtils.style(getActivity(), "Theme.LBSPaySDK_Transparent_For_System_26"));
                        convertToTranslucent();
                    } else if (this.isTranslucentOrFloating) {
                        convertToTranslucent();
                    }
                }
            }
            super.onCreate(bundle);
            LogUtil.e("debug_msg", "onCreate-----" + getClass().getName(), null);
            addToTask(this);
            if (Build.VERSION.SDK_INT >= 27) {
                if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {
                    b bVar = new b(getActivity());
                    this.myOrientoinListener = bVar;
                    bVar.enable();
                }
            }
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("saveInfo");
                bundle2.setClassLoader(getClassLoader());
                Serializable serializable = bundle2.getSerializable("cashdeskcommondata");
                if (serializable != null && (serializable instanceof NetworkBean.SessionCache)) {
                    NetworkBean.SessionCache.sync((NetworkBean.SessionCache) serializable);
                }
            }
            setImmersiveStatusBar(getActivity());
            if (this.isSupportUIAdapatation) {
                setCustomDensity(getApplication(), this.isWidthLimitedMode, this.defaultLenth);
            }
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            LogUtil.d("BaseActivity", "onCreateDialog. id = " + i2);
            if (i2 == -2 || i2 == -1 || i2 == 0) {
                return new LoadingDialog(this);
            }
            if (i2 != 2) {
                return new PromptDialog(getActivity());
            }
            return new PromptImageDialog(getActivity());
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            keyBoardAdjustDetach();
            closeNightMode();
            super.onDestroy();
            removeFromTask(this);
            if (Build.VERSION.SDK_INT < 27 || (bVar = this.myOrientoinListener) == null) {
                return;
            }
            bVar.a();
            this.myOrientoinListener = null;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, keyEvent)) == null) {
            if (i2 == 82 && keyEvent.isLongPress()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        super.onMultiWindowModeChanged(z);
        SafeScrollView safeScrollView = this.mSafeScrollView;
        if (safeScrollView != null) {
            safeScrollView.dismissKeyBoard();
        }
        if (z && isActivityInForeground()) {
            if (this.mIsShowMultiWindowTips) {
                GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.mMultiWindowTipsID), -1, 1);
            }
            if (this.mIsMultiWindowAvailable) {
                return;
            }
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            decLiveActivityNum();
            this.mIsActivityInForeground = false;
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "out"));
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, dialog) == null) {
            LogUtil.d("BaseActivity", "onPrepareDialog. id = " + i2);
            if (i2 == -2) {
                LoadingDialog loadingDialog = (LoadingDialog) dialog;
                loadingDialog.setCancelable(true);
                loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.wallet.core.BaseActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f60517a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60517a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.f60517a.cancleRequest();
                        }
                    }
                }, loadingDialog));
            } else if (i2 == -1) {
                LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
                loadingDialog2.setCancelable(true);
                loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.wallet.core.BaseActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f60516a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60516a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.f60516a.onBackPressed();
                        }
                    }
                }, loadingDialog2));
            } else if (i2 == 0) {
                ((LoadingDialog) dialog).setCancelable(false);
            } else if (i2 == 3) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.hideNegativeButton();
            } else if (i2 == 11) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(getString(ResUtils.string(getActivity(), "ebpay_no_network")));
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.core.BaseActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f60518a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60518a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f60518a, 11);
                        }
                    }
                });
                promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_setting"), new View.OnClickListener(this) { // from class: com.baidu.wallet.core.BaseActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f60519a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60519a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f60519a, 11);
                            try {
                                this.f60519a.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                            } catch (Exception e2) {
                                LogUtil.e("BaseActivity", "onPrepareDialog. DIALOG_NO_NETWORK. onClick", e2);
                            }
                        }
                    }
                });
            } else if (i2 != 52) {
                super.onPrepareDialog(i2, dialog);
            } else {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.setCanceledOnTouchOutside(false);
                promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_confirm"), new View.OnClickListener(this, promptDialog3) { // from class: com.baidu.wallet.core.BaseActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f60520a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f60521b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60521b = this;
                        this.f60520a = promptDialog3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f60520a.dismiss();
                            try {
                                ApplicationInfo applicationInfo = PhoneUtils.getApplicationInfo(this.f60521b.getActivity());
                                PhoneUtils.showInstalledAppOrDetails(this.f60521b.getActivity(), applicationInfo != null ? applicationInfo.packageName : "");
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
                promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_cancel"), new View.OnClickListener(this, promptDialog3) { // from class: com.baidu.wallet.core.BaseActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f60522a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BaseActivity f60523b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60523b = this;
                        this.f60522a = promptDialog3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f60522a.dismiss();
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            addLiveActivityNum();
            this.mIsActivityInForeground = true;
            showMultiWindowTips();
            if (0 != this.mTimeVal) {
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "in", String.valueOf(System.currentTimeMillis() - this.mTimeVal)));
                this.mTimeVal = 0L;
                return;
            }
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "in", String.valueOf(0)));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            Bundle bundle2 = new Bundle();
            NetworkBean.SessionCache sessionCache = NetworkBean.SessionCache.getInstance();
            if (sessionCache != null) {
                bundle2.putSerializable("cashdeskcommondata", sessionCache);
                bundle.putBundle("saveInfo", bundle2);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
        }
    }

    public void setImmersiveStatusBar(Activity activity) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, activity) == null) || (i2 = Build.VERSION.SDK_INT) < 19) {
            return;
        }
        if (i2 >= 21) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(ResUtils.getColor(getActivity(), "ebpay_transparent"));
        } else {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags = 67108864 | attributes.flags;
            window2.setAttributes(attributes);
        }
        this.mContent = findViewById(16908290);
        ImmersiveKeyboardAdjust immersiveKeyboardAdjust = new ImmersiveKeyboardAdjust();
        this.mKeyboardAdjust = immersiveKeyboardAdjust;
        if (immersiveKeyboardAdjust == null || this.mContent == null || !needKeyboardAdjust()) {
            return;
        }
        this.mKeyboardAdjust.attachActivity(this.mContent);
    }

    public void setIsMultiWindowAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || z == this.mIsMultiWindowAvailable) {
            return;
        }
        this.mIsMultiWindowAvailable = z;
    }

    public void setIsShowMultiWindowTips(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || z == this.mIsShowMultiWindowTips) {
            return;
        }
        this.mIsShowMultiWindowTips = z;
    }

    public void setMultiWindowTipsId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.mMultiWindowTipsID = str;
        }
    }

    public void setSafeScrollView(SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, safeScrollView) == null) {
            this.mSafeScrollView = safeScrollView;
        }
    }

    public void setUIAdaptationMode(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            this.isWidthLimitedMode = z2;
            this.defaultLenth = i2;
            this.isSupportUIAdapatation = z;
        }
    }

    public void setWindowNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.mWindowNightMode = z;
        }
    }

    public void showBaseDialog(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i2, str) == null) {
            this.mDialogMsg = str;
            WalletGlobalUtils.safeShowDialog(this, i2, str);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, intent) == null) {
            startActivityForResult(intent, -1);
        }
    }

    public void startActivityForResult(Class<?> cls, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, cls, i2) == null) {
            startActivityForResult(new Intent(this, cls), i2);
        }
    }

    public void startActivityForResultWithoutAnim(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, intent, i2) == null) {
            super.startActivityForResult(intent, i2);
        }
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, bundle, cls) == null) {
            startActivityWithExtras(bundle, cls, true);
        }
    }

    public void startActivityWithoutAnim(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, intent) == null) {
            super.startActivityForResult(intent, -1);
        }
    }

    public void startNightMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (isWindowNightMode()) {
                if (this.mNightModeView != null) {
                    return;
                }
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, getBottomBarType() == SDKBaseActivity.BottomBarType.NONE ? -1 : DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(DxmApplicationContextImpl.getApplicationContext(this), 42.0f), 1002, 24, -2);
                LogUtil.d("baseActivity", "this.displayMetrics.density = " + getResources().getDisplayMetrics().density + " \n applicationCon.density = " + DxmApplicationContextImpl.getApplicationContext(this).getResources().getDisplayMetrics().density);
                LogUtil.d("baseActivity", "height = " + DisplayUtils.getDisplayHeight(this) + " \n bottomBarh = " + DisplayUtils.dip2px(this, 42.0f));
                layoutParams.gravity = 48;
                View view = new View(this);
                this.mNightModeView = view;
                view.setBackgroundColor(ResUtils.getColor(this, "ebpay_black_transparent"));
                getWindowManager().addView(this.mNightModeView, layoutParams);
                return;
            }
            View findViewById = findViewById(ResUtils.id(DxmApplicationContextImpl.getApplicationContext(this), "night_mode_view"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ResUtils.getColor(this, "ebpay_black_transparent"));
            }
        }
    }

    public void startActivity(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, cls) == null) {
            startActivityForResult(new Intent(getActivity(), cls), -1);
        }
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048616, this, bundle, cls, z) == null) {
            if (bundle == null) {
                bundle = getIntent().getExtras();
            }
            Intent intent = new Intent(getActivity(), cls);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (z) {
                startActivity(intent);
            } else {
                startActivityWithoutAnim(intent);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, intent, i2) == null) {
            super.startActivityForResult(intent, i2);
            BaiduWalletUtils.startActivityAnim(getActivity());
        }
    }
}
