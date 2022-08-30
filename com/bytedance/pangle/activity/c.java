package com.bytedance.pangle.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b bVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, bundle) == null) {
            if (!Zeus.hasInit()) {
                Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
                bVar.zeusSuperOnCreate(null);
                bVar.finish();
                return;
            }
            Intent intent = bVar.getIntent();
            String pluginPkgName = bVar.getPluginPkgName();
            Plugin plugin = bVar.getPlugin();
            intent.setExtrasClassLoader(plugin.mClassLoader);
            String stringExtra = intent.getStringExtra("targetPlugin");
            if (plugin.isLoaded() && !TextUtils.isEmpty(stringExtra)) {
                ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
                if (activityInfo == null) {
                    ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
                    bVar.zeusSuperOnCreate(null);
                    bVar.finish();
                }
                try {
                    IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
                    FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
                    bVar.setTargetActivity(iPluginActivity);
                    iPluginActivity.setPluginProxyActivity(bVar, plugin);
                    bVar.zeusSuperSetTheme(activityInfo.theme);
                    TypedArray obtainStyledAttributes = ((Activity) bVar).getTheme().obtainStyledAttributes(new int[]{16842840});
                    if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                        a((Activity) bVar);
                    }
                    obtainStyledAttributes.recycle();
                    iPluginActivity.attachBaseContext(bVar.getBaseContext());
                    try {
                        if (((Activity) bVar).getRequestedOrientation() != activityInfo.screenOrientation) {
                            ((Activity) bVar).setRequestedOrientation(activityInfo.screenOrientation);
                        }
                    } catch (IllegalStateException unused) {
                    }
                    iPluginActivity.onCreate(bundle);
                    return;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                bVar.zeusSuperOnCreate(null);
                ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                bVar.finish();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void a(b bVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bVar, context) == null) {
            if (!Zeus.hasInit()) {
                Log.e(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
                bVar.zeusSuperAttachBaseContext(context);
                return;
            }
            String pluginPkgName = bVar.getPluginPkgName();
            boolean loadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
            try {
                bVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
                if (loadPlugin) {
                    bVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                } else {
                    bVar.zeusSuperAttachBaseContext(context);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void a(Activity activity, View view2) {
        Object readField;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, activity, view2) == null) || view2 == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view2, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view2.setOnClickListener(new a(activity, view2.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
                }
            }
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view2)));
            e.printStackTrace();
        }
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view2;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    public static Class a() {
        InterceptResult invokeV;
        Class<?>[] declaredClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            return cls;
        }
        return (Class) invokeV.objValue;
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            try {
                MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", a(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
            } catch (Throwable unused) {
            }
        }
    }
}
