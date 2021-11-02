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
import com.baidu.mobads.container.service.PluginLoader;
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
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                Plugin plugin2 = PluginManager.getInstance().getPlugin(str);
                if (plugin2 == null) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
                    return false;
                } else if (!plugin2.isInstalled()) {
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
                    return false;
                } else if (plugin2.isLoaded()) {
                    return true;
                } else {
                    com.bytedance.pangle.log.c a2 = com.bytedance.pangle.log.c.a(ZeusLogger.TAG_LOAD, PluginLoader.TAG, "loadPlugin:".concat(String.valueOf(str)));
                    a(com.bytedance.pangle.b.b.f61249g, b.a.w, plugin2.mPkgName, plugin2.getVersion(), -1L, null);
                    StringBuilder sb = new StringBuilder();
                    boolean a3 = a(str, plugin2, sb);
                    a2.b("loadPluginInternal:".concat(String.valueOf(a3)));
                    if (a3) {
                        plugin2.setLifeCycle(3);
                        a(com.bytedance.pangle.b.b.f61250h, b.a.x, plugin2.mPkgName, plugin2.getVersion(), a2.a(), sb.toString());
                    } else {
                        sb.append("plugin:");
                        sb.append(plugin2.mPkgName);
                        sb.append(" versionCode:");
                        sb.append(plugin2.getVersion());
                        sb.append("load failed;");
                        a(com.bytedance.pangle.b.b.f61250h, b.a.y, plugin2.mPkgName, plugin2.getVersion(), -1L, sb.toString());
                    }
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin2)));
                    if (plugin2.isLoaded()) {
                        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin2.mPkgName);
                        return true;
                    }
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean a(String str, Plugin plugin2, StringBuilder sb) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, plugin2, sb)) == null) {
            synchronized (c.class) {
                try {
                    com.bytedance.pangle.log.c a2 = com.bytedance.pangle.log.c.a(ZeusLogger.TAG_LOAD, PluginLoader.TAG, "load:".concat(String.valueOf(str)));
                    if (plugin2 == null) {
                        sb.append("loadPluginInternal, plugin == null;");
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!", str);
                        return false;
                    } else if (!plugin2.isInstalled()) {
                        sb.append("loadPluginInternal, !plugin.isInstalled();");
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!", str);
                        return false;
                    } else {
                        long a3 = a2.a("isInstalled");
                        if (a3 > 20 || a3 < 0) {
                            sb.append("isInstall cost:");
                            sb.append(a3);
                            sb.append(";");
                        }
                        String sourceFile = PluginDirHelper.getSourceFile(plugin2.mPkgName, plugin2.getVersion());
                        if (!new File(sourceFile).exists()) {
                            sb.append("loadPluginInternal, sourceApk not exist;");
                            ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!", str);
                            return false;
                        }
                        long a4 = a2.a("getSourceFile");
                        if (a4 > 20 || a4 < 0) {
                            sb.append("getSourceFile cost:");
                            sb.append(a4);
                            sb.append(";");
                        }
                        File file = new File(PluginDirHelper.getNativeLibraryDir(plugin2.mPkgName, plugin2.getVersion()));
                        long a5 = a2.a("getNativeLibraryDir");
                        if (a5 > 20 || a5 < 0) {
                            sb.append("getNativeLibraryDir cost:");
                            sb.append(a5);
                            sb.append(";");
                        }
                        File file2 = new File(file.getParentFile(), "dalvik-cache");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        long a6 = a2.a("dalvikCacheDir");
                        if (a6 > 20 || a6 < 0) {
                            sb.append("dalvikCacheDirTime cost:");
                            sb.append(a6);
                            sb.append(";");
                        }
                        plugin2.mClassLoader = new PluginClassLoader(sourceFile, file2.getPath(), file.getAbsolutePath(), null);
                        long a7 = a2.a("classloader");
                        if (a7 > 20 || a7 < 0) {
                            sb.append("classloader cost:");
                            sb.append(a7);
                            sb.append(";");
                        }
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(sourceFile, 15);
                        long a8 = a2.a("getPackageInfo");
                        if (a8 > 20 || a8 < 0) {
                            sb.append("getPackageInfo cost:");
                            sb.append(a8);
                            sb.append(";");
                        }
                        plugin2.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin2.mPkgName);
                        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
                        plugin2.mHostApplicationInfoHookSomeField = applicationInfo;
                        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
                        plugin2.mHostApplicationInfoHookSomeField.dataDir = plugin2.mHostApplication.getDataDir().getAbsolutePath();
                        plugin2.mHostApplicationInfoHookSomeField.sourceDir = sourceFile;
                        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
                            packageArchiveInfo.applicationInfo.sourceDir = sourceFile;
                        }
                        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
                            packageArchiveInfo.applicationInfo.publicSourceDir = sourceFile;
                        }
                        long a9 = a2.a("setApplication");
                        if (a9 > 20 || a9 < 0) {
                            sb.append("setApplication cost:");
                            sb.append(a9);
                            sb.append(";");
                        }
                        plugin2.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo));
                        long a10 = a2.a("makeResources");
                        if (a10 > 20 || a10 < 0) {
                            sb.append("makeResources cost:");
                            sb.append(a10);
                            sb.append(";");
                        }
                        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks(plugin2) { // from class: com.bytedance.pangle.plugin.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Plugin f61459a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {plugin2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61459a = plugin2;
                            }

                            @Override // android.content.ComponentCallbacks
                            public final void onConfigurationChanged(Configuration configuration) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, configuration) == null) {
                                    this.f61459a.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
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
                                    plugin2.pluginActivities.put(activityInfo.name, activityInfo);
                                }
                                activityInfo.processName = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
                                plugin2.pluginActivities.put(activityInfo.name, activityInfo);
                            }
                        }
                        ServiceInfo[] serviceInfoArr = packageArchiveInfo.services;
                        if (serviceInfoArr != null) {
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(":")) {
                                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                                    plugin2.pluginServices.put(serviceInfo.name, serviceInfo);
                                }
                                serviceInfo.processName = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
                                plugin2.pluginServices.put(serviceInfo.name, serviceInfo);
                            }
                        }
                        long a11 = a2.a("resolveActivityServices");
                        if (a11 > 20 || a11 < 0) {
                            sb.append("resolveActivityServices cost:");
                            sb.append(a11);
                            sb.append(";");
                        }
                        ActivityInfo[] activityInfoArr2 = packageArchiveInfo.receivers;
                        if (activityInfoArr2 != null) {
                            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(":")) {
                                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                                    plugin2.pluginReceiver.put(activityInfo2.name, activityInfo2);
                                }
                                activityInfo2.processName = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
                                plugin2.pluginReceiver.put(activityInfo2.name, activityInfo2);
                            }
                        }
                        long a12 = a2.a("resolveReceiver");
                        if (a12 > 20 || a12 < 0) {
                            sb.append("resolveReceiver cost:");
                            sb.append(a12);
                            sb.append(";");
                        }
                        ProviderInfo[] providerInfoArr = packageArchiveInfo.providers;
                        if (providerInfoArr != null) {
                            for (ProviderInfo providerInfo : providerInfoArr) {
                                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                                    providerInfo.processName = providerInfo.processName.split(":")[1];
                                    plugin2.pluginProvider.put(providerInfo.name, providerInfo);
                                }
                                providerInfo.processName = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;
                                plugin2.pluginProvider.put(providerInfo.name, providerInfo);
                            }
                        }
                        long a13 = a2.a("resolveProvider");
                        if (a13 > 20 || a13 < 0) {
                            sb.append("resolveProvider cost:");
                            sb.append(a13);
                            sb.append(";");
                        }
                        if (plugin2.pluginProvider != null && plugin2.pluginProvider.size() > 0) {
                            ContentProviderManager.getInstance().installContentProviders(plugin2.pluginProvider.values(), plugin2);
                        }
                        long a14 = a2.a("installProvider");
                        if (a14 > 20 || a14 < 0) {
                            sb.append("installProvider cost:");
                            sb.append(a14);
                            sb.append(";");
                        }
                        if (!TextUtils.isEmpty(packageArchiveInfo.applicationInfo.className)) {
                            ZeusApplication zeusApplication = (ZeusApplication) plugin2.mClassLoader.loadClass(packageArchiveInfo.applicationInfo.className).newInstance();
                            plugin2.mApplication = zeusApplication;
                            zeusApplication.attach(plugin2, Zeus.getAppApplication());
                        }
                        long a15 = a2.a("makeApplication");
                        if (a15 > 20 || a15 < 0) {
                            sb.append("makeApplication cost:");
                            sb.append(a15);
                            sb.append(";");
                        }
                        return true;
                    }
                } catch (Throwable th) {
                    sb.append("loadPluginInternal ");
                    sb.append(th.getMessage());
                    sb.append(";");
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", str, th);
                    return false;
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void a(String str, int i2, @NonNull String str2, int i3, long j, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Long.valueOf(j), str3}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject.putOpt("status_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i2)));
                jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.d.a(str2));
                jSONObject.putOpt("version_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i3)));
                jSONObject3.putOpt("duration", com.bytedance.pangle.log.d.a(Long.valueOf(j)));
                jSONObject2.putOpt("message", com.bytedance.pangle.log.d.a(str3));
                jSONObject2.putOpt("timestamp", com.bytedance.pangle.log.d.a(Long.valueOf(System.currentTimeMillis())));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.bytedance.pangle.b.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
        }
    }
}
