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
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.alipay.sdk.widget.j;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.statusbar.ImmersiveKeyboardAdjust;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.statistics.StatSettings;
import com.baidu.wallet.base.statistics.SyncHttpImpl;
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
/* loaded from: classes5.dex */
public class BaseActivity extends SDKBaseActivity implements NoProguard {
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
    public static final String TOA_BEGIN = "TOA_BeginToAdapt";
    public static final String TOA_EXCEPTION = "TOA_Exception";
    public static final String TOA_TARGET = "TOA_InTranslucentActivity";
    public static final String WITH_ANIM = "with_anim";
    public static LinkedList<BaseActivity> mActivityStack = new LinkedList<>();
    public static int mLiveActivityNum = 0;
    public static float sNocompatDensity;
    public static float sNocompatScaleDensity;
    public View mContent;
    public ImmersiveKeyboardAdjust mKeyboardAdjust;
    public long mTimeVal;
    public b myOrientoinListener;
    public PayStatisticsUtil payStatisticsUtil;
    public String mDialogMsg = "";
    public boolean mIsShowMultiWindowTips = false;
    public boolean mIsMultiWindowAvailable = true;
    public String mMultiWindowTipsID = "wallet_base_multi_window_tips";
    public SafeScrollView mSafeScrollView = null;
    public boolean mIsActivityInForeground = false;
    public View mNightModeView = null;
    public boolean mWindowNightMode = true;
    public boolean isWidthLimitedMode = true;
    public int defaultLenth = 375;
    public boolean isSupportUIAdapatation = false;
    public boolean isTranslucentOrFloating = false;
    public int mFlag = 0;

    public static void addLiveActivityNum() {
        mLiveActivityNum++;
    }

    public static synchronized void addToTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
            mActivityStack.add(baseActivity);
        }
    }

    public static synchronized void clearTask() {
        synchronized (BaseActivity.class) {
            Iterator<BaseActivity> it = mActivityStack.iterator();
            while (it.hasNext()) {
                it.next().finish();
            }
        }
    }

    public static synchronized void clearTaskExcept(BaseActivity baseActivity) {
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

    public static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
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

    public static synchronized void clearTasksWithActivityName(Class<?> cls) {
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

    public static synchronized void clearTasksWithFlag(int i2) {
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

    private void convertFromTranslucent() {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(getActivity(), new Object[0]);
        } catch (Throwable th) {
            DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(th.toString()));
            PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(th.toString()));
        }
    }

    private void convertToTranslucent() {
        Object obj;
        Class<?> cls;
        Object obj2;
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
                obj2 = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.baidu.wallet.core.BaseActivity.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj3, Method method, Object[] objArr) throws Throwable {
                        return null;
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
                } catch (Exception e2) {
                    DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e2.toString()));
                    PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e2.toString()));
                }
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(getActivity(), obj2, obj);
                return;
            }
            Method declaredMethod3 = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(getActivity(), obj2);
        } catch (Throwable th) {
            DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(th.toString()));
            PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(th.toString()));
        }
    }

    public static void decLiveActivityNum() {
        mLiveActivityNum--;
    }

    public static BaseActivity getTopActivity() throws Throwable {
        return mActivityStack.getLast();
    }

    public static boolean isAppInForeground() {
        return mLiveActivityNum > 0;
    }

    private boolean isBaiduappPlugin() {
        return false;
    }

    private boolean isTranslucentOrFloating() {
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
            DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e2.toString()));
            PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e2.toString()));
            return false;
        }
    }

    public static synchronized void removeFromTask(BaseActivity baseActivity) {
        synchronized (BaseActivity.class) {
            mActivityStack.remove(baseActivity);
        }
    }

    public static void setCustomDensity(@NonNull final Application application, boolean z, int i2) {
        int i3;
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (sNocompatDensity == 0.0f) {
            sNocompatDensity = displayMetrics.density;
            sNocompatScaleDensity = displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() { // from class: com.baidu.wallet.core.BaseActivity.8
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                    if (configuration == null || configuration.fontScale <= 0.0f) {
                        return;
                    }
                    float unused = BaseActivity.sNocompatScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
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

    @TargetApi(24)
    private void showMultiWindowTips() {
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            return;
        }
        if (this.mIsShowMultiWindowTips) {
            GlobalUtils.toast(this, ResUtils.getString(getActivity(), this.mMultiWindowTipsID), -1, 1);
        }
        if (this.mIsMultiWindowAvailable) {
            return;
        }
        finish();
    }

    public void cancleRequest() {
    }

    public void closeNightMode() {
        if (!isWindowNightMode() || this.mNightModeView == null) {
            return;
        }
        getWindowManager().removeViewImmediate(this.mNightModeView);
        this.mNightModeView = null;
    }

    @Override // android.app.Activity
    public void finish() {
        boolean z;
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

    public void finishWithoutAnim() {
        super.finish();
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public Activity getActivity() {
        return super.getActivity();
    }

    public ArrayList<String> getHandlerFailureData(int i2, int i3, String str) {
        String str2;
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

    public boolean isActivityInForeground() {
        return this.mIsActivityInForeground;
    }

    public boolean isStatusbarTextColorBlack() {
        return true;
    }

    public boolean isWindowNightMode() {
        return this.mWindowNightMode;
    }

    public void keyBoardAdjustDetach() {
        View view;
        ImmersiveKeyboardAdjust immersiveKeyboardAdjust = this.mKeyboardAdjust;
        if (immersiveKeyboardAdjust != null && (view = this.mContent) != null) {
            immersiveKeyboardAdjust.detachActivity(view);
        }
        this.mKeyboardAdjust = null;
        this.mContent = null;
    }

    public boolean needKeyboardAdjust() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (BaiduWalletUtils.isNightMode()) {
            startNightMode();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
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

    public void onBackPressedForWalletApp() {
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

    public void onBackPressedWithoutAnim() {
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        ActivityInfo activityInfo;
        this.mTimeVal = System.currentTimeMillis();
        PayStatisticsUtil.initStatisticsModule(this, StatSettings.getInstance(this));
        PayStatisticsUtil.setHttpImpl(new SyncHttpImpl());
        if (getApplicationInfo().targetSdkVersion > 26 && Build.VERSION.SDK_INT == 26) {
            DXMSdkSAUtils.onEvent(TOA_BEGIN);
            PayStatisticsUtil.onEvent(TOA_BEGIN);
            boolean isTranslucentOrFloating = isTranslucentOrFloating();
            this.isTranslucentOrFloating = isTranslucentOrFloating;
            if (isTranslucentOrFloating) {
                DXMSdkSAUtils.onEvent(TOA_TARGET);
                PayStatisticsUtil.onEvent(TOA_TARGET);
                convertFromTranslucent();
            }
        }
        try {
            if (!isBaiduappPlugin()) {
                setRequestedOrientation(1);
            }
        } catch (Exception unused) {
            Log.i("BaseActivity", "setRequestedOrientation throw exception");
            DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList("setRequestedOrientation throw exception"));
            PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList("setRequestedOrientation throw exception"));
        }
        if (getApplicationInfo().targetSdkVersion > 26 && Build.VERSION.SDK_INT == 26) {
            if (BeanConstants.CHANNEL_ID_IQIYI.equals(BeanConstants.CHANNEL_ID)) {
                try {
                    Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                    declaredField.setAccessible(true);
                    if (declaredField != null) {
                        activityInfo = (ActivityInfo) declaredField.get(getActivity());
                    }
                } catch (IllegalAccessException e2) {
                    DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e2.toString()));
                    PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e2.toString()));
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e3.toString()));
                    PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e3.toString()));
                    e3.printStackTrace();
                }
                activityInfo = null;
            } else {
                try {
                    activityInfo = getPackageManager().getActivityInfo(getComponentName(), 0);
                } catch (PackageManager.NameNotFoundException e4) {
                    DXMSdkSAUtils.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e4.toString()));
                    PayStatisticsUtil.onEventWithValues(TOA_EXCEPTION, Arrays.asList(e4.toString()));
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
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "push"));
        PayStatisticsUtil.onPush(getClass().getSimpleName());
        LogUtil.e("debug_msg", "onCreate-----" + getClass().getName(), null);
        addToTask(this);
        if (Build.VERSION.SDK_INT >= 27) {
            if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", 0) == 1) {
                b bVar = new b(getActivity());
                this.myOrientoinListener = bVar;
                bVar.enable();
            }
        }
        if (bundle != null && (serializable = bundle.getSerializable("cashdeskcommondata")) != null && (serializable instanceof NetworkBean.SessionCache)) {
            NetworkBean.SessionCache.sync((NetworkBean.SessionCache) serializable);
        }
        setImmersiveStatusBar(getActivity());
        if (this.isSupportUIAdapatation) {
            setCustomDensity(getApplication(), this.isWidthLimitedMode, this.defaultLenth);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        LogUtil.d("BaseActivity", "onCreateDialog. id = " + i2);
        if (i2 == -2 || i2 == -1 || i2 == 0) {
            return new LoadingDialog(this);
        }
        if (i2 != 2) {
            return new PromptDialog(getActivity());
        }
        return new PromptImageDialog(getActivity());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        b bVar;
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), j.j));
        PayStatisticsUtil.onBack(getClass().getSimpleName());
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        if (Build.VERSION.SDK_INT >= 24) {
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
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        decLiveActivityNum();
        this.mIsActivityInForeground = false;
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "out"));
        PayStatisticsUtil.onOut(getClass().getSimpleName());
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        LogUtil.d("BaseActivity", "onPrepareDialog. id = " + i2);
        if (i2 == -2) {
            LoadingDialog loadingDialog = (LoadingDialog) dialog;
            loadingDialog.setCancelable(true);
            loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.wallet.core.BaseActivity.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    BaseActivity.this.cancleRequest();
                }
            }, loadingDialog));
        } else if (i2 == -1) {
            LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
            loadingDialog2.setCancelable(true);
            loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.wallet.core.BaseActivity.2
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    BaseActivity.this.onBackPressed();
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
            promptDialog2.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BaseActivity.this, 11);
                }
            });
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_setting"), new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BaseActivity.this, 11);
                    try {
                        BaseActivity.this.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                    } catch (Exception e2) {
                        LogUtil.e("BaseActivity", "onPrepareDialog. DIALOG_NO_NETWORK. onClick", e2);
                    }
                }
            });
        } else if (i2 != 52) {
            super.onPrepareDialog(i2, dialog);
        } else {
            final PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    promptDialog3.dismiss();
                    try {
                        ApplicationInfo applicationInfo = PhoneUtils.getApplicationInfo(BaseActivity.this.getActivity());
                        PhoneUtils.showInstalledAppOrDetails(BaseActivity.this.getActivity(), applicationInfo != null ? applicationInfo.packageName : "");
                    } catch (Throwable unused) {
                    }
                }
            });
            promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.core.BaseActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    promptDialog3.dismiss();
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        addLiveActivityNum();
        this.mIsActivityInForeground = true;
        showMultiWindowTips();
        if (0 != this.mTimeVal) {
            long currentTimeMillis = System.currentTimeMillis() - this.mTimeVal;
            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "in", String.valueOf(currentTimeMillis)));
            PayStatisticsUtil.onIn(getClass().getSimpleName(), currentTimeMillis);
            this.mTimeVal = 0L;
            return;
        }
        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.PAGE_STACK, Arrays.asList(getClass().getSimpleName(), "in", String.valueOf(0)));
        PayStatisticsUtil.onIn(getClass().getSimpleName(), 0L);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        NetworkBean.SessionCache sessionCache = NetworkBean.SessionCache.getInstance();
        if (sessionCache != null) {
            bundle.putSerializable("cashdeskcommondata", sessionCache);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    public void setImmersiveStatusBar(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
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
    }

    public void setIsMultiWindowAvailable(boolean z) {
        if (z != this.mIsMultiWindowAvailable) {
            this.mIsMultiWindowAvailable = z;
        }
    }

    public void setIsShowMultiWindowTips(boolean z) {
        if (z != this.mIsShowMultiWindowTips) {
            this.mIsShowMultiWindowTips = z;
        }
    }

    public void setMultiWindowTipsId(String str) {
        this.mMultiWindowTipsID = str;
    }

    public void setSafeScrollView(SafeScrollView safeScrollView) {
        this.mSafeScrollView = safeScrollView;
    }

    public void setUIAdaptationMode(boolean z, boolean z2, int i2) {
        this.isWidthLimitedMode = z2;
        this.defaultLenth = i2;
        this.isSupportUIAdapatation = z;
    }

    public void setWindowNightMode(boolean z) {
        this.mWindowNightMode = z;
    }

    public void showBaseDialog(int i2, String str) {
        this.mDialogMsg = str;
        WalletGlobalUtils.safeShowDialog(this, i2, str);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
    }

    public void startActivityForResult(Class<?> cls, int i2) {
        startActivityForResult(new Intent(this, cls), i2);
    }

    public void startActivityForResultWithoutAnim(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls) {
        startActivityWithExtras(bundle, cls, true);
    }

    public void startActivityWithoutAnim(Intent intent) {
        super.startActivityForResult(intent, -1);
    }

    public void startNightMode() {
        if (isWindowNightMode()) {
            if (this.mNightModeView != null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, getBottomBarType() == SDKBaseActivity.BottomBarType.NONE ? -1 : DisplayUtils.getDisplayHeight(this) - DisplayUtils.dip2px(this, 42.0f), 1002, 24, -2);
            layoutParams.gravity = 48;
            View view = new View(this);
            this.mNightModeView = view;
            view.setBackgroundColor(ResUtils.getColor(this, "ebpay_black_transparent"));
            getWindowManager().addView(this.mNightModeView, layoutParams);
            return;
        }
        View findViewById = findViewById(ResUtils.id(getApplicationContext(), "night_mode_view"));
        if (findViewById != null) {
            findViewById.setBackgroundColor(ResUtils.getColor(this, "ebpay_black_transparent"));
        }
    }

    public void startActivity(Class<?> cls) {
        startActivityForResult(new Intent(getActivity(), cls), -1);
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls, boolean z) {
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
        BaiduWalletUtils.startActivityAnim(getActivity());
    }
}
