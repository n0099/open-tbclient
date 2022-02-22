package com.bytedance.pangle.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatViewInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b bVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bVar, bundle) == null) {
            if (!Zeus.hasInit()) {
                bVar.zeusSuperOnCreate(bundle);
                bVar.finish();
                return;
            }
            Intent intent = bVar.getIntent();
            String pluginPkgName = bVar.getPluginPkgName();
            Plugin plugin2 = bVar.getPlugin();
            intent.setExtrasClassLoader(plugin2.mClassLoader);
            String stringExtra = intent.getStringExtra("targetPlugin");
            if (plugin2.isLoaded() && !TextUtils.isEmpty(stringExtra)) {
                ActivityInfo activityInfo = plugin2.pluginActivities.get(stringExtra);
                if (activityInfo != null) {
                    try {
                        IPluginActivity iPluginActivity = (IPluginActivity) plugin2.mClassLoader.loadClass(stringExtra).newInstance();
                        FieldUtils.writeField(iPluginActivity, "mApplication", bVar.getApplication());
                        bVar.setTargetActivity(iPluginActivity);
                        iPluginActivity.setPluginProxyActivity(bVar, plugin2);
                        bVar.zeusSuperSetTheme(activityInfo.theme);
                        iPluginActivity.attachBaseContext(bVar.getBaseContext());
                        iPluginActivity.onCreate(bundle);
                        return;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
                throw new RuntimeException("Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            }
            try {
                bVar.zeusSuperOnCreate(bundle);
                ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                bVar.finish();
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public static void a(b bVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, context) == null) {
            if (!Zeus.hasInit()) {
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
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void a(Activity activity, View view) {
        Object readField;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, activity, view) == null) || view == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new a(activity, view.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
                }
            }
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            e2.printStackTrace();
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(activity, viewGroup.getChildAt(i2));
            i2++;
        }
    }
}
