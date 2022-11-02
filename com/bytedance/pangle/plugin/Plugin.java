package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.b;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import com.bytedance.pangle.util.l;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
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
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    public volatile boolean mInitialized;
    public String mInternalPath;
    public int mInternalVersionCode;
    public volatile int mLifeCycle;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    public String mPackageDir;
    public String mPkgName;
    public Resources mResources;
    public String mSignature;
    public int mVersionCode;
    public HashMap<String, ActivityInfo> pluginActivities;
    public HashMap<String, ProviderInfo> pluginProvider;
    public HashMap<String, ActivityInfo> pluginReceiver;
    public HashMap<String, ServiceInfo> pluginServices;

    public Plugin(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pluginActivities = new HashMap<>();
        this.pluginServices = new HashMap<>();
        this.pluginReceiver = new HashMap<>();
        this.pluginProvider = new HashMap<>();
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mLifeCycle = 1;
        this.installLock = new Object();
        this.initializeLock = new Object();
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        this.mSignature = jSONObject.optString(SocialOperation.GAME_SIGNATURE, "");
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        setupInternalPlugin();
    }

    private void updateToInstalled(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i) == null) {
            this.mVersionCode = i;
            this.mLifeCycle = 2;
        }
    }

    public boolean isVersionInstalled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return l.a().a(this.mPkgName, i);
        }
        return invokeI.booleanValue;
    }

    public void setLifeCycle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mLifeCycle = i;
        }
    }

    private boolean checkValid(File file, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, file, str, i)) == null) {
            if (!TextUtils.equals(this.mPkgName, str)) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
                return false;
            } else if (i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
                if (i < this.mVersionCode && isInstalled()) {
                    String format = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i), Integer.valueOf(this.mVersionCode));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + format);
                    return false;
                } else if (file != null && file.exists()) {
                    if (i == this.mVersionCode && l.a().a.getString("MD5_".concat(String.valueOf(str)), "").equals(e.a(file))) {
                        ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same md5 has already installed.");
                        return false;
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
                    return true;
                } else {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
                    return false;
                }
            } else {
                String format2 = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + format2);
                return false;
            }
        }
        return invokeLLI.booleanValue;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int a = l.a().a(this.mPkgName);
            boolean z3 = false;
            if (a > i2) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a), Integer.valueOf(i2)))));
                return false;
            }
            if (i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && i2 != -1) {
                l a2 = l.a();
                String str = this.mPkgName;
                SharedPreferences sharedPreferences = a2.a;
                int i3 = sharedPreferences.getInt("API_MIN_" + str + "_" + i, 0);
                l a3 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences sharedPreferences2 = a3.a;
                int i4 = Integer.MAX_VALUE;
                int i5 = sharedPreferences2.getInt("API_MAX_" + str2 + "_" + i, Integer.MAX_VALUE);
                if (i5 != 0) {
                    i4 = i5;
                }
                if (i2 < i3 || i2 > i4) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)))));
                    z2 = false;
                }
            }
            if (z2 && z && com.bytedance.pangle.c.b.b(new File(com.bytedance.pangle.c.c.b(this.mPkgName, i)))) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i)))));
            } else {
                z3 = z2;
            }
            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z3);
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    private void deleteIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
            if (l.a().a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
                l a = l.a();
                String str = this.mPkgName;
                SharedPreferences.Editor edit = a.a.edit();
                edit.remove("UNINSTALL__".concat(String.valueOf(str)));
                edit.apply();
                deleteInstalledPlugin();
                ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
            }
        }
    }

    public int getInstalledMaxVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
            }
            File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.plugin.Plugin.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Plugin a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                        if (file != null && file.getName().matches("^version-(\\d+)$")) {
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            int i = -1;
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                    if (parseInt > i && l.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.c.c.b(this.mPkgName, parseInt)).exists()) {
                        i = parseInt;
                    }
                }
            }
            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
            return i;
        }
        return invokeV.intValue;
    }

    private void deleteInstalledPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
            }
            new File(this.mPackageDir).listFiles(new FileFilter(this) { // from class: com.bytedance.pangle.plugin.Plugin.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Plugin a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                        if (file.getName().matches("^version-(\\d+)$")) {
                            l.a().a(this.a.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            f.a(this.mPackageDir);
        }
    }

    private void installInternalPlugin() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) && getVersion() < this.mInternalVersionCode && !TextUtils.isEmpty(this.mInternalPath)) {
            com.bytedance.pangle.c.e.a.execute(new Runnable(this) { // from class: com.bytedance.pangle.plugin.Plugin.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Plugin a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String b = com.bytedance.pangle.c.c.b();
                            File file = new File(b, this.a.mPkgName + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + this.a.mInternalPath + " --> " + file.getAbsolutePath());
                            g.a(Zeus.getAppApplication().getAssets().open(this.a.mInternalPath), new FileOutputStream(file));
                            if (file.exists()) {
                                PluginManager.getInstance().asyncInstall(this.a.mPkgName, file);
                                return;
                            }
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                        } catch (Throwable th) {
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. ", th);
                        }
                    }
                }
            });
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
        }
        return (String) invokeV.objValue;
    }

    private void deleteOtherExpiredVer(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65542, this, i) == null) && com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
            }
            new File(this.mPackageDir).listFiles(new FileFilter(this, "version-".concat(String.valueOf(i))) { // from class: com.bytedance.pangle.plugin.Plugin.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ Plugin b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = r7;
                }

                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                        if (file != null && !this.a.equals(file.getName()) && !"data".equals(file.getName())) {
                            f.a(file.getAbsolutePath());
                            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                            if (file.getName().matches("^version-(\\d+)$")) {
                                l.a().a(this.b.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                            }
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    private void modifyResIfNeed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            if (!TextUtils.equals(l.a().b(this.mPkgName), com.bytedance.pangle.util.b.b(Zeus.getAppApplication()))) {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
                try {
                    b.a(com.bytedance.pangle.c.c.b(this.mPkgName, i), this.mPkgName, i);
                } catch (b.a e) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "modify res failed.", e);
                }
            }
        }
    }

    private void setupInternalPlugin() {
        boolean z;
        String[] list;
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (l.a().a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            if (!TextUtils.isEmpty(this.mInternalPath) && this.mInternalVersionCode != -1) {
                return;
            }
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(ZeusConstants.d)) {
                    if (str.startsWith(this.mPkgName + "_") && (a = j.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = ZeusConstants.d + "/" + str;
                        this.mInternalVersionCode = a;
                        return;
                    }
                }
            } catch (IOException e) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                if (!com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) && this.mLifeCycle < 2 && (a = com.bytedance.pangle.servermanager.b.a()) != null && a.a(this.mPkgName)) {
                    updateToInstalled(a.b(this.mPkgName));
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
                Zeus.getAppApplication();
                sb.append(com.bytedance.pangle.c.d.a());
                ZeusLogger.e(ZeusLogger.TAG_PPM, sb.toString(), this.mPkgName, th);
            }
        }
    }

    public int getApiVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mApiVersionCode;
        }
        return invokeV.intValue;
    }

    public int getInternalVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mInternalVersionCode;
        }
        return invokeV.intValue;
    }

    public int getLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            updateInstallStateFromMainProcess();
            return this.mLifeCycle;
        }
        return invokeV.intValue;
    }

    public String getNativeLibraryDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.mVersionCode;
            if (i > 0) {
                return com.bytedance.pangle.c.c.d(this.mPkgName, i);
            }
            return com.bytedance.pangle.c.c.a(this.mPkgName);
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

    public boolean isInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            updateInstallStateFromMainProcess();
            if (this.mLifeCycle >= 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mLifeCycle == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void init() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
                int i = 0;
                if (!TextUtils.isEmpty(l.a().a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    l a = l.a();
                    String str = this.mPkgName;
                    if (!TextUtils.equals(a.a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a.a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + StringUtil.ARRAY_ELEMENT_SEPARATOR + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    modifyResIfNeed(installedMaxVer);
                    updateToInstalled(installedMaxVer);
                    i = installedMaxVer;
                }
                deleteOtherExpiredVer(i);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                l a2 = l.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a2.a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                l a3 = l.a();
                String str3 = this.mPkgName;
                String string = a3.a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a3.a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                l a4 = l.a();
                String str4 = this.mPkgName;
                String b = com.bytedance.pangle.util.b.b(Zeus.getAppApplication());
                String b2 = a4.b(str4);
                if (!TextUtils.equals(b2, b)) {
                    SharedPreferences.Editor edit3 = a4.a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), b);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b2 + " --> " + b);
                l a5 = l.a();
                String str5 = this.mPkgName;
                int i2 = this.mApiVersionCode;
                int a6 = a5.a(str5);
                if (a6 != i2) {
                    SharedPreferences.Editor edit4 = a5.a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i2);
                    edit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a6 + " --> " + i2);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x015f -> B:31:0x0160). Please submit an issue!!! */
    public boolean install(File file, com.bytedance.pangle.e.a.e eVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, file, eVar)) == null) {
            boolean z2 = false;
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + StringUtil.ARRAY_ELEMENT_SEPARATOR + Thread.currentThread().getName());
                String str = eVar.a;
                int i = eVar.b;
                synchronized (this.installLock) {
                    try {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                        boolean checkValid = checkValid(file, str, i);
                        if (checkValid) {
                            z = b.a(file, str, i);
                            if (z) {
                                try {
                                    String b = e.b(com.bytedance.pangle.c.c.b(this.mPkgName, i));
                                    l a = l.a();
                                    String str2 = this.mPkgName;
                                    SharedPreferences.Editor edit = a.a.edit();
                                    edit.putString("MD5_".concat(String.valueOf(str2)), b);
                                    edit.apply();
                                    l.a().a(this.mPkgName, i, true);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " md5=" + b);
                                    f.a(file);
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = z;
                                }
                            }
                        } else {
                            z = false;
                        }
                        synchronized (this) {
                            if (checkValid) {
                                if (this.mLifeCycle != 3) {
                                    if (z) {
                                        updateToInstalled(i);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                                        ZeusPluginStateListener.postStateChange(this.mPkgName, 6, new Object[0]);
                                    } else {
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                        ZeusPluginStateListener.postStateChange(this.mPkgName, 7, "Internal error.");
                                        f.a(file);
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                                    }
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                                }
                            } else {
                                f.a(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                            }
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                ZeusLogger.e(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th3);
                return z2;
            }
        }
        return invokeLL.booleanValue;
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) {
            l a = l.a();
            String str = this.mPkgName;
            SharedPreferences.Editor edit = a.a.edit();
            edit.putInt("API_MIN_" + str + "_" + i, i2);
            edit.putInt("API_MAX_" + str + "_" + i, i3);
            edit.apply();
        }
    }
}
