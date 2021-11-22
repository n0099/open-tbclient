package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes11.dex */
public class Plugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    public static final String TAG = "Plugin";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object initializeLock;
    public final Object installLock;
    public int mApiVersionCode;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public Handler mHandler;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    public volatile boolean mInitialized;
    public volatile int mLifeCycle;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public String mPackageDir;
    public String mPkgName;
    public Resources mResources;
    public int mVersionCode;
    public HashMap<String, ActivityInfo> pluginActivities;
    public HashMap<String, ProviderInfo> pluginProvider;
    public HashMap<String, ActivityInfo> pluginReceiver;
    public HashMap<String, ServiceInfo> pluginServices;

    public Plugin(JSONObject jSONObject, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pluginActivities = new HashMap<>();
        this.pluginServices = new HashMap<>();
        this.pluginReceiver = new HashMap<>();
        this.pluginProvider = new HashMap<>();
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.installLock = new Object();
        this.initializeLock = new Object();
        try {
            this.mHandler = handler;
            this.mPkgName = jSONObject.getString("packageName");
            this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
            this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
            this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        } catch (JSONException e2) {
            throw e2;
        }
    }

    private boolean checkValid(File file, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, file, str, i2)) == null) {
            if (!TextUtils.equals(this.mPkgName, str)) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
                return false;
            } else if (i2 >= this.mMinVersionCode && i2 <= this.mMaxVersionCode) {
                if (i2 < this.mVersionCode && isInstalled()) {
                    String format = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i2), Integer.valueOf(this.mVersionCode));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + format);
                    return false;
                } else if (file != null && file.exists()) {
                    if (i2 == this.mVersionCode && k.a().f62427a.getString("MD5_".concat(String.valueOf(str)), "").equals(e.a(file))) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same md5 has already installed.");
                        return false;
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i2 + " true");
                    return true;
                } else {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
                    return false;
                }
            } else {
                String format2 = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i2), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + format2);
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    private boolean checkVersionValid(int i2, int i3, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            int a2 = k.a().a(this.mPkgName);
            boolean z2 = false;
            if (a2 > i3) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a2), Integer.valueOf(i3)))));
                return false;
            }
            boolean z3 = i2 >= 0 && i2 >= this.mMinVersionCode && i2 <= this.mMaxVersionCode;
            if (z3 && i3 != -1) {
                k a3 = k.a();
                String str = this.mPkgName;
                SharedPreferences sharedPreferences = a3.f62427a;
                int i4 = sharedPreferences.getInt("API_MIN_" + str + "_" + i2, 0);
                k a4 = k.a();
                String str2 = this.mPkgName;
                SharedPreferences sharedPreferences2 = a4.f62427a;
                int i5 = sharedPreferences2.getInt("API_MAX_" + str2 + "_" + i2, Integer.MAX_VALUE);
                if (i5 == 0) {
                    i5 = Integer.MAX_VALUE;
                }
                if (i3 < i4 || i3 > i5) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)))));
                    z3 = false;
                }
            }
            if (z3 && j != -1) {
                k a5 = k.a();
                String str3 = this.mPkgName;
                SharedPreferences sharedPreferences3 = a5.f62427a;
                int i6 = sharedPreferences3.getInt("HOST_MIN_" + str3 + "_" + i2, 0);
                k a6 = k.a();
                String str4 = this.mPkgName;
                SharedPreferences sharedPreferences4 = a6.f62427a;
                int i7 = sharedPreferences4.getInt("HOST_MAX_" + str4 + "_" + i2, Integer.MAX_VALUE);
                int i8 = i7 != 0 ? i7 : Integer.MAX_VALUE;
                if (j < i6 || j > i8) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with host[ver_code=%s], hostCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Long.valueOf(j), Integer.valueOf(i6), Integer.valueOf(i8)))));
                    z3 = false;
                }
            }
            if (z3 && z && com.bytedance.pangle.helper.b.b(new File(PluginDirHelper.getSourceFile(this.mPkgName, i2)))) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i2)))));
            } else {
                z2 = z3;
            }
            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    private void deleteIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && com.bytedance.pangle.helper.c.b(Zeus.getAppApplication())) {
            if (k.a().f62427a.getBoolean("DELETED__".concat(String.valueOf(this.mPkgName)), false)) {
                k a2 = k.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a2.f62427a.edit();
                edit.remove("DELETED__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    private void deleteInstalledPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = PluginDirHelper.getPackageDir(this.mPkgName);
            }
            new File(this.mPackageDir).listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.plugin.Plugin.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Plugin f62349a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62349a = this;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                        if (file.getName().matches("^version-(\\d+)$")) {
                            k.a().a(this.f62349a.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            f.a(this.mPackageDir);
        }
    }

    private void deleteOtherExpiredVer(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) && com.bytedance.pangle.helper.c.b(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = PluginDirHelper.getPackageDir(this.mPkgName);
            }
            new File(this.mPackageDir).listFiles(new FileFilter(this, PluginDirHelper.VERSION_PREFIX.concat(String.valueOf(i2))) { // from class: com.bytedance.pangle.plugin.Plugin.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62350a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Plugin f62351b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62351b = this;
                    this.f62350a = r7;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                        if (file != null && !this.f62350a.equals(file.getName()) && !"data".equals(file.getName())) {
                            f.a(file.getAbsolutePath());
                            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                            if (file.getName().matches("^version-(\\d+)$")) {
                                k.a().a(this.f62351b.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                            }
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    private int getInstalledMaxVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = PluginDirHelper.getPackageDir(this.mPkgName);
            }
            File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.plugin.Plugin.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Plugin f62348a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62348a = this;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? file != null && file.getName().matches("^version-(\\d+)$") : invokeL.booleanValue;
                }
            });
            int i2 = -1;
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                    if (parseInt > i2 && k.a().a(this.mPkgName, parseInt) && new File(PluginDirHelper.getSourceFile(this.mPkgName, parseInt)).exists()) {
                        i2 = parseInt;
                    }
                }
            }
            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i2);
            return i2;
        }
        return invokeV.intValue;
    }

    private void postPluginInstalled(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, str, z) == null) {
            this.mHandler.post(new Runnable(this, str, z) { // from class: com.bytedance.pangle.plugin.Plugin.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f62352a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f62353b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Plugin f62354c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62354c = this;
                    this.f62352a = str;
                    this.f62353b = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List<ZeusPluginStateListener> list;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (list = i.a().f62338c) == null || list.size() <= 0) {
                        return;
                    }
                    for (ZeusPluginStateListener zeusPluginStateListener : list) {
                        zeusPluginStateListener.onPluginInstallResult(this.f62352a, this.f62353b);
                    }
                }
            });
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.d a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            try {
                if (com.bytedance.pangle.helper.c.b(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a2 = com.bytedance.pangle.servermanager.b.a()) == null || !a2.a(this.mPkgName)) {
                    return;
                }
                updateToInstalled(a2.b(this.mPkgName));
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + com.bytedance.pangle.helper.c.a(Zeus.getAppApplication()), this.mPkgName, th);
            }
        }
    }

    private void updateToInstalled(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            this.mVersionCode = i2;
            this.mLifeCycle = 2;
        }
    }

    public void clearOffline() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k.a().c(this.mPkgName);
        }
    }

    public int getApiVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mApiVersionCode : invokeV.intValue;
    }

    public int getLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            updateInstallStateFromMainProcess();
            return this.mLifeCycle;
        }
        return invokeV.intValue;
    }

    public String getNativeLibraryDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.mVersionCode;
            if (i2 > 0) {
                return PluginDirHelper.getNativeLibraryDir(this.mPkgName, i2);
            }
            return PluginDirHelper.getPackageDir(this.mPkgName);
        }
        return (String) invokeV.objValue;
    }

    public String getPackageVersionDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.mVersionCode;
            if (i2 > 0) {
                return PluginDirHelper.getPackageVersionDir(this.mPkgName, i2);
            }
            return PluginDirHelper.getPackageDir(this.mPkgName);
        }
        return (String) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            updateInstallStateFromMainProcess();
            return this.mVersionCode;
        }
        return invokeV.intValue;
    }

    public void init() {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.helper.c.b(Zeus.getAppApplication())) {
                int i2 = 0;
                if (!TextUtils.isEmpty(k.a().f62427a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    k a2 = k.a();
                    String str = this.mPkgName;
                    boolean z2 = !TextUtils.equals(a2.f62427a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a2.f62427a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + StringUtil.ARRAY_ELEMENT_SEPARATOR + Zeus.getHostAbi() + ", result=" + z2);
                    z = z2;
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, i.a().f62337b.getHostVersionCode(), z)) {
                    updateToInstalled(installedMaxVer);
                    i2 = installedMaxVer;
                }
                deleteOtherExpiredVer(i2);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                k a3 = k.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a3.f62427a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                k a4 = k.a();
                String str3 = this.mPkgName;
                String string = a4.f62427a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a4.f62427a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                k a5 = k.a();
                String str4 = this.mPkgName;
                int i3 = this.mApiVersionCode;
                int a6 = a5.a(str4);
                if (a6 != i3) {
                    SharedPreferences.Editor edit3 = a5.f62427a.edit();
                    edit3.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str4)), i3);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a6 + " --> " + i3);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    public boolean install(File file, com.bytedance.pangle.e.a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, file, eVar)) == null) {
            boolean z = false;
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + StringUtil.ARRAY_ELEMENT_SEPARATOR + Thread.currentThread().getName());
                String str = eVar.f62278a;
                int i2 = eVar.f62279b;
                synchronized (this.installLock) {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str, i2);
                    if (checkValid && (z = b.a(file, str, i2))) {
                        String a2 = e.a(PluginDirHelper.getSourceFile(this.mPkgName, i2));
                        k a3 = k.a();
                        String str2 = this.mPkgName;
                        SharedPreferences.Editor edit = a3.f62427a.edit();
                        edit.putString("MD5_".concat(String.valueOf(str2)), a2);
                        edit.apply();
                        k.a().a(this.mPkgName, i2, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i2 + " md5=" + a2);
                        f.a(file);
                    }
                    synchronized (this) {
                        if (checkValid) {
                            if (this.mLifeCycle == 3) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i2);
                            } else if (z) {
                                updateToInstalled(i2);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i2);
                                postPluginInstalled(this.mPkgName, z);
                            } else {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i2);
                                postPluginInstalled(this.mPkgName, z);
                                f.a(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i2);
                            }
                        } else {
                            f.a(file);
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i2);
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public boolean isHostModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            updateInstallStateFromMainProcess();
            return this.mLifeCycle >= 2;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mLifeCycle == 3 : invokeV.booleanValue;
    }

    public boolean isOffline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? k.a().d(this.mPkgName) : invokeV.booleanValue;
    }

    public boolean isVersionInstalled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? k.a().a(this.mPkgName, i2) : invokeI.booleanValue;
    }

    public void markOffline() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            k.a().b(this.mPkgName);
        }
    }

    public void setApiCompatVersion(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) {
            k a2 = k.a();
            String str = this.mPkgName;
            SharedPreferences.Editor edit = a2.f62427a.edit();
            edit.putInt("API_MIN_" + str + "_" + i2, i3);
            edit.putInt("API_MAX_" + str + "_" + i2, i4);
            edit.apply();
        }
    }

    public void setHostCompatVersion(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048591, this, i2, i3, i4) == null) {
            k a2 = k.a();
            String str = this.mPkgName;
            SharedPreferences.Editor edit = a2.f62427a.edit();
            edit.putInt("HOST_MIN_" + str + "_" + i2, i3);
            edit.putInt("HOST_MAX_" + str + "_" + i2, i4);
            edit.apply();
        }
    }

    public void setLifeCycle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mLifeCycle = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
