package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ApkVerifier;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginProvider;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f61673a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f61674b;

    /* renamed from: c  reason: collision with root package name */
    public static final CountDownLatch f61675c;

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, TTPluginListener> f61676d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, Handler> f61677e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile DexClassLoader f61678f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f61679g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f61680h;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f61688a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820010410, "Lcom/bytedance/sdk/openadsdk/api/plugin/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(820010410, "Lcom/bytedance/sdk/openadsdk/api/plugin/f$a;");
                    return;
                }
            }
            f61688a = new c();
        }
    }

    /* loaded from: classes11.dex */
    public static final class b implements TTAdEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, bundle) == null) && i2 == 1) {
                d a2 = f.a(bundle.getString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
                if (a2 != null && !TextUtils.isEmpty(a2.mPackageName)) {
                    boolean z = bundle.getBoolean("success");
                    TTPluginListener tTPluginListener = (TTPluginListener) f.f61676d.get(a2.mPackageName);
                    if (z) {
                        com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin update received: " + a2.mPackageName);
                        if (!a2.isRevert) {
                            if (f.b(a2, tTPluginListener)) {
                                bundle.putBoolean("installed", true);
                                return;
                            }
                            return;
                        }
                        Zeus.unInstallPlugin(a2.mPackageName);
                        return;
                    }
                    if (tTPluginListener != null) {
                        tTPluginListener.onPluginListener(1001, null, null, null);
                    }
                    com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin update failed");
                    return;
                }
                com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin update received with invalid config");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462304199, "Lcom/bytedance/sdk/openadsdk/api/plugin/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462304199, "Lcom/bytedance/sdk/openadsdk/api/plugin/f;");
                return;
            }
        }
        f61673a = UnitedSchemeConstants.UNITED_SCHEME_NEXT + File.separator;
        f61674b = File.separator + "conf";
        f61675c = new CountDownLatch(1);
        f61676d = new HashMap<>();
        f61677e = new HashMap<>();
        f61679g = null;
    }

    public f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e.a(context);
        c(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            AssetManager assets = context.getAssets();
            try {
                String a2 = com.bytedance.sdk.openadsdk.api.plugin.b.a(PluginConstants.getSign());
                File f2 = f(context);
                File file = new File(f2, (a2 + "-4011-4011") + ".apk");
                if (a(assets.open(a2), file)) {
                    com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "Select nested");
                    return a(file, PluginConstants.getSign());
                }
                throw new IOException("Select nested failed");
            } catch (Throwable th) {
                if (th instanceof FileNotFoundException) {
                    e.a(1, th.getMessage(), System.currentTimeMillis() - currentTimeMillis);
                    return null;
                }
                e.a(2, th.getMessage(), System.currentTimeMillis() - currentTimeMillis);
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static List<PluginDownloadBean> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            File[] listFiles = g(context).listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str)) == null) ? str != null && str.endsWith(".conf") : invokeLL.booleanValue;
                }
            });
            if (listFiles != null && listFiles.length != 0) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    d a2 = a(c(file));
                    if (a2 != null && a2.f61665b.exists()) {
                        arrayList.add(a2);
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public static File f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) ? new File(h(context), f61673a) : (File) invokeL.objValue;
    }

    public static File g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? new File(h(context), f61674b) : (File) invokeL.objValue;
    }

    public static File h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) ? new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle") : (File) invokeL.objValue;
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                ZeusParam build = new ZeusParam.Builder().autoFetch(true).closeDefaultReport(true).reporter(new IZeusReporter(this) { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f61684a;

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
                        this.f61684a = this;
                    }

                    @Override // com.bytedance.pangle.log.IZeusReporter
                    public void report(String str, JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, jSONObject) == null) {
                            e.a(str, jSONObject);
                        }
                    }
                }).verifyWith(new ApkVerifier(this) { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f61683a;

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
                        this.f61683a = this;
                    }

                    @Override // com.bytedance.pangle.ApkVerifier
                    public boolean verify(File file) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                            d b2 = f.b(file);
                            if (b2 != null) {
                                return a.f61688a.a(b2.f61664a, file);
                            }
                            return a.f61688a.a(this.f61683a.f61680h, file);
                        }
                        return invokeL.booleanValue;
                    }
                }).pluginProvider(new PluginProvider(this, context) { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f61681a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ f f61682b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61682b = this;
                        this.f61681a = context;
                    }

                    @Override // com.bytedance.pangle.plugin.PluginProvider
                    public File provideBuiltInPlugin() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (Zeus.isPluginInstalled(TTAdConstant.BUILT_IN_PLUGIN_NAME)) {
                                return null;
                            }
                            return this.f61682b.d(this.f61681a);
                        }
                        return (File) invokeV.objValue;
                    }

                    @Override // com.bytedance.pangle.plugin.PluginProvider
                    public List<PluginDownloadBean> providePluginConfig() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f.e(this.f61681a) : (List) invokeV.objValue;
                    }

                    @Override // com.bytedance.pangle.plugin.PluginProvider
                    public boolean useLocalPlugin() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                }).withCheckPermission(false).build();
                PluginDirHelper.setPluginDir(f(context));
                Zeus.init((Application) context, build);
                Zeus.registerPluginStateListener(new ZeusPluginStateListener(this) { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ f f61685a;

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
                        this.f61685a = this;
                    }

                    @Override // com.bytedance.pangle.ZeusPluginStateListener
                    public void onPluginInstallResult(String str, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, str, z) == null) {
                            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Plugin install result: [" + str + "]," + z);
                            if (TTAdConstant.BUILT_IN_PLUGIN_NAME.equals(str)) {
                                if (z && Zeus.loadPlugin(str)) {
                                    DexClassLoader unused = f.f61678f = Zeus.getPlugin(str).mClassLoader;
                                }
                                f.f61675c.countDown();
                                return;
                            }
                            f.b(z, str, (TTPluginListener) f.f61676d.get(str));
                        }
                    }
                });
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Unexpected error for init zeus.", th);
                e.a(4, th.getMessage(), System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public static d b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            File file2 = new File(g(TTAppContextHolder.getContext()), b(file.getName()) + ".conf");
            if (file2.exists()) {
                return a(c(file2));
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public static f a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f61679g == null) {
                synchronized (f.class) {
                    if (f61679g == null) {
                        f61679g = new f(context);
                    }
                }
            }
            return f61679g;
        }
        return (f) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (str == null) {
                return "";
            }
            int indexOf = str.indexOf(".");
            return indexOf > 0 ? str.substring(0, indexOf) : str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(d dVar, TTPluginListener tTPluginListener) {
        InterceptResult invokeLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, dVar, tTPluginListener)) == null) {
            if (dVar != null && (file = dVar.f61665b) != null) {
                boolean syncInstallPlugin = Zeus.syncInstallPlugin(file.getAbsolutePath());
                b(syncInstallPlugin, dVar.mPackageName, tTPluginListener);
                return syncInstallPlugin;
            }
            com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin config is null");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public DexClassLoader a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (!Zeus.isPluginInstalled(TTAdConstant.BUILT_IN_PLUGIN_NAME)) {
                    f61675c.await(60000L, TimeUnit.MILLISECONDS);
                }
                if (!Zeus.isPluginLoaded(TTAdConstant.BUILT_IN_PLUGIN_NAME) && Zeus.loadPlugin(TTAdConstant.BUILT_IN_PLUGIN_NAME)) {
                    f61678f = Zeus.getPlugin(TTAdConstant.BUILT_IN_PLUGIN_NAME).mClassLoader;
                }
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Unexpected error for load plugin.", e2);
                e.a(3, e2.getMessage(), System.currentTimeMillis() - currentTimeMillis);
            }
            return f61678f;
        }
        return (DexClassLoader) invokeV.objValue;
    }

    public static void b(boolean z, String str, TTPluginListener tTPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{Boolean.valueOf(z), str, tTPluginListener}) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Install dl plugin ");
            sb.append(str);
            sb.append(z ? " success" : " failed");
            sb.append(", need notify: ");
            sb.append(tTPluginListener != null);
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", sb.toString());
            Handler handler = f61677e.get(str);
            if (tTPluginListener == null || handler == null) {
                return;
            }
            if (z) {
                if (Zeus.loadPlugin(str)) {
                    Plugin plugin2 = Zeus.getPlugin(str);
                    if (plugin2 != null) {
                        a(plugin2, tTPluginListener);
                        handler.removeCallbacksAndMessages(null);
                        tTPluginListener.onPluginListener(1000, plugin2.mClassLoader, plugin2.mResources, null);
                    } else {
                        tTPluginListener.onPluginListener(1001, null, null, null);
                    }
                } else {
                    tTPluginListener.onPluginListener(1001, null, null, null);
                }
            } else {
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
            f61676d.remove(str);
            f61677e.remove(str);
        }
    }

    public static String c(File file) {
        InterceptResult invokeL;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, file)) == null) {
            FileReader fileReader2 = null;
            if (file != null && file.exists()) {
                try {
                    fileReader = new FileReader(file);
                    try {
                        StringBuilder sb = new StringBuilder();
                        char[] cArr = new char[1024];
                        while (true) {
                            int read = fileReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        String sb2 = sb.toString();
                        try {
                            fileReader.close();
                        } catch (IOException unused) {
                        }
                        return sb2;
                    } catch (Exception unused2) {
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused5) {
                    fileReader = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private File a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, file, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Selected plugin with empty sign");
                return null;
            }
            this.f61680h = str;
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public Bundle a(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bundle)) == null) {
            if (Zeus.isPluginInstalled(str) && (plugin2 = Zeus.getPlugin(str)) != null) {
                bundle.putString("plugin_version", a(plugin2.getVersion()));
            }
            g.a(str, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putBundle(str, bundle);
            Bundle bundle3 = new Bundle();
            bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
            return bundle3;
        }
        return (Bundle) invokeLL.objValue;
    }

    public void a(TTPluginListener tTPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTPluginListener) == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable(this, tTPluginListener) { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTPluginListener f61686a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f61687b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, tTPluginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61687b = this;
                    this.f61686a = tTPluginListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Load plugin failed, caused by timeout.");
                        this.f61686a.onPluginListener(1001, null, null, null);
                    }
                }
            }, 180000L);
            String packageName = tTPluginListener.packageName();
            Plugin plugin2 = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
            StringBuilder sb = new StringBuilder();
            sb.append("Find plugin:");
            sb.append(plugin2 != null);
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", sb.toString());
            if (plugin2 != null) {
                a(plugin2, tTPluginListener);
                handler.removeCallbacksAndMessages(null);
                tTPluginListener.onPluginListener(1000, plugin2.mClassLoader, plugin2.mResources, null);
                return;
            }
            f61676d.put(packageName, tTPluginListener);
            f61677e.put(packageName, handler);
        }
    }

    public static d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (JSONException unused) {
                com.bytedance.sdk.openadsdk.api.b.d.d("TTPluginManager", "Invalid plugin info:" + str);
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public static d a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d dVar = new d();
            dVar.mPackageName = jSONObject.optString("package_name");
            dVar.mVersionCode = jSONObject.optInt("version_code");
            dVar.mUrl = jSONObject.optString("download_url");
            dVar.mMd5 = jSONObject.optString(PackageTable.MD5);
            dVar.mApiVersionMin = jSONObject.optInt("min_version");
            dVar.mApiVersionMax = jSONObject.optInt("max_version");
            dVar.f61664a = jSONObject.optString("sign");
            dVar.isRevert = jSONObject.optBoolean("is_revert");
            dVar.f61665b = new File(jSONObject.optString("plugin_file"));
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public static boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, inputStream, file)) == null) {
            if (inputStream == null || file == null) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                a(inputStream);
                                a(fileOutputStream2);
                                return true;
                            }
                        }
                    } catch (Throwable unused) {
                        fileOutputStream = fileOutputStream2;
                        try {
                            com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "copy failed");
                            return false;
                        } finally {
                            a(inputStream);
                            a(fileOutputStream);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static void a(Plugin plugin2, TTPluginListener tTPluginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, plugin2, tTPluginListener) == null) {
            Bundle bundle = new Bundle();
            Bundle config = tTPluginListener.config();
            config.putString("plugin_version", a(plugin2.getVersion()));
            bundle.putBundle(plugin2.mPkgName, config);
            bundle.putInt("action", 0);
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager != null) {
                adManager.getExtra(Bundle.class, bundle);
            }
        }
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            char[] charArray = String.valueOf(i2).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < charArray.length; i3++) {
                sb.append(charArray[i3]);
                if (i3 < charArray.length - 1) {
                    sb.append(".");
                }
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }
}
