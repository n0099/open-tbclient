package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    public final synchronized boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                Plugin plugin = PluginManager.getInstance().getPlugin(str);
                if (plugin == null) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
                    return false;
                } else if (!plugin.isInstalled()) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                    return false;
                } else if (plugin.isLoaded()) {
                    return true;
                } else {
                    com.bytedance.pangle.log.c a = com.bytedance.pangle.log.c.a(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                    a(com.bytedance.pangle.b.b.g, b.a.w, plugin.mPkgName, plugin.getVersion(), -1L, null);
                    StringBuilder sb = new StringBuilder();
                    boolean a2 = a(str, plugin, sb);
                    a.b("loadPluginInternal:".concat(String.valueOf(a2)));
                    if (a2) {
                        plugin.setLifeCycle(3);
                        a(com.bytedance.pangle.b.b.h, b.a.x, plugin.mPkgName, plugin.getVersion(), a.a(), sb.toString());
                    } else {
                        sb.append("plugin:");
                        sb.append(plugin.mPkgName);
                        sb.append(" versionCode:");
                        sb.append(plugin.getVersion());
                        sb.append("load failed;");
                        a(com.bytedance.pangle.b.b.h, b.a.y, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                    }
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                    if (plugin.isLoaded()) {
                        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
                        return true;
                    }
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean a(String str, Plugin plugin, StringBuilder sb) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, plugin, sb)) == null) {
            synchronized (c.class) {
                try {
                    com.bytedance.pangle.log.c a = com.bytedance.pangle.log.c.a(ZeusLogger.TAG_LOAD, "PluginLoader", "load:".concat(String.valueOf(str)));
                    if (plugin == null) {
                        sb.append("loadPluginInternal, plugin == null;");
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!", str);
                        return false;
                    } else if (!plugin.isInstalled()) {
                        sb.append("loadPluginInternal, !plugin.isInstalled();");
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!", str);
                        return false;
                    } else {
                        long a2 = a.a("isInstalled");
                        if (a2 > 20 || a2 < 0) {
                            sb.append("isInstall cost:");
                            sb.append(a2);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        String sourceFile = PluginDirHelper.getSourceFile(plugin.mPkgName, plugin.getVersion());
                        if (!new File(sourceFile).exists()) {
                            sb.append("loadPluginInternal, sourceApk not exist;");
                            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!", str);
                            return false;
                        }
                        long a3 = a.a("getSourceFile");
                        if (a3 > 20 || a3 < 0) {
                            sb.append("getSourceFile cost:");
                            sb.append(a3);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        File file = new File(PluginDirHelper.getNativeLibraryDir(plugin.mPkgName, plugin.getVersion()));
                        long a4 = a.a("getNativeLibraryDir");
                        if (a4 > 20 || a4 < 0) {
                            sb.append("getNativeLibraryDir cost:");
                            sb.append(a4);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        File file2 = new File(file.getParentFile(), "dalvik-cache");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        long a5 = a.a("dalvikCacheDir");
                        if (a5 > 20 || a5 < 0) {
                            sb.append("dalvikCacheDirTime cost:");
                            sb.append(a5);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        plugin.mClassLoader = new PluginClassLoader(sourceFile, file2.getPath(), file.getAbsolutePath(), null);
                        long a6 = a.a("classloader");
                        if (a6 > 20 || a6 < 0) {
                            sb.append("classloader cost:");
                            sb.append(a6);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(sourceFile, 15);
                        long a7 = a.a("getPackageInfo");
                        if (a7 > 20 || a7 < 0) {
                            sb.append("getPackageInfo cost:");
                            sb.append(a7);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
                        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
                        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
                        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
                        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
                        plugin.mHostApplicationInfoHookSomeField.sourceDir = sourceFile;
                        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
                            packageArchiveInfo.applicationInfo.sourceDir = sourceFile;
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
                            packageArchiveInfo.applicationInfo.publicSourceDir = sourceFile;
                        }
                        long a8 = a.a("setApplication");
                        if (a8 > 20 || a8 < 0) {
                            sb.append("setApplication cost:");
                            sb.append(a8);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo));
                        long a9 = a.a("makeResources");
                        if (a9 > 20 || a9 < 0) {
                            sb.append("makeResources cost:");
                            sb.append(a9);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks(plugin) { // from class: com.bytedance.pangle.plugin.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Plugin a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {plugin};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = plugin;
                            }

                            @Override // android.content.ComponentCallbacks
                            public final void onConfigurationChanged(Configuration configuration) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, configuration) == null) {
                                    this.a.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
                                }
                            }

                            @Override // android.content.ComponentCallbacks
                            public final void onLowMemory() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                }
                            }
                        });
                        ActivityInfo[] activityInfoArr = packageArchiveInfo.activities;
                        if (activityInfoArr != null) {
                            for (ActivityInfo activityInfo : activityInfoArr) {
                                if (!TextUtils.isEmpty(activityInfo.processName) && activityInfo.processName.contains(":")) {
                                    activityInfo.processName = activityInfo.processName.split(":")[1];
                                    plugin.pluginActivities.put(activityInfo.name, activityInfo);
                                }
                                activityInfo.processName = "main";
                                plugin.pluginActivities.put(activityInfo.name, activityInfo);
                            }
                        }
                        ServiceInfo[] serviceInfoArr = packageArchiveInfo.services;
                        if (serviceInfoArr != null) {
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(":")) {
                                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                                    plugin.pluginServices.put(serviceInfo.name, serviceInfo);
                                }
                                serviceInfo.processName = "main";
                                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
                            }
                        }
                        long a10 = a.a("resolveActivityServices");
                        if (a10 > 20 || a10 < 0) {
                            sb.append("resolveActivityServices cost:");
                            sb.append(a10);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        ActivityInfo[] activityInfoArr2 = packageArchiveInfo.receivers;
                        if (activityInfoArr2 != null) {
                            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(":")) {
                                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                                    plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
                                }
                                activityInfo2.processName = "main";
                                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
                            }
                        }
                        long a11 = a.a("resolveReceiver");
                        if (a11 > 20 || a11 < 0) {
                            sb.append("resolveReceiver cost:");
                            sb.append(a11);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        ProviderInfo[] providerInfoArr = packageArchiveInfo.providers;
                        if (providerInfoArr != null) {
                            for (ProviderInfo providerInfo : providerInfoArr) {
                                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                    providerInfo.processName = providerInfo.processName.split(":")[1];
                                    plugin.pluginProvider.put(providerInfo.name, providerInfo);
                                }
                                providerInfo.processName = "main";
                                plugin.pluginProvider.put(providerInfo.name, providerInfo);
                            }
                        }
                        long a12 = a.a("resolveProvider");
                        if (a12 > 20 || a12 < 0) {
                            sb.append("resolveProvider cost:");
                            sb.append(a12);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        if (plugin.pluginProvider != null && plugin.pluginProvider.size() > 0) {
                            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
                        }
                        long a13 = a.a("installProvider");
                        if (a13 > 20 || a13 < 0) {
                            sb.append("installProvider cost:");
                            sb.append(a13);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        if (!TextUtils.isEmpty(packageArchiveInfo.applicationInfo.className)) {
                            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageArchiveInfo.applicationInfo.className).newInstance();
                            plugin.mApplication = zeusApplication;
                            zeusApplication.attach(plugin, Zeus.getAppApplication());
                        }
                        long a14 = a.a("makeApplication");
                        if (a14 > 20 || a14 < 0) {
                            sb.append("makeApplication cost:");
                            sb.append(a14);
                            sb.append(ParamableElem.DIVIDE_PARAM);
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    sb.append("loadPluginInternal ");
                    sb.append(th.getMessage());
                    sb.append(ParamableElem.DIVIDE_PARAM);
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", str, th);
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void a(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), Long.valueOf(j), str3}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("status_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i)));
                jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.d.a(str2));
                jSONObject.putOpt("version_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i2)));
                jSONObject3.putOpt("duration", com.bytedance.pangle.log.d.a(Long.valueOf(j)));
                jSONObject2.putOpt("message", com.bytedance.pangle.log.d.a(str3));
                jSONObject2.putOpt("timestamp", com.bytedance.pangle.log.d.a(Long.valueOf(System.currentTimeMillis())));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
        }
    }
}
