package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.bytedance.pangle.ApkVerifier;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusParam;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.helper.PluginDirHelper;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginProvider;
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
/* loaded from: classes3.dex */
public class f {

    /* renamed from: f  reason: collision with root package name */
    public static volatile DexClassLoader f53449f;

    /* renamed from: h  reason: collision with root package name */
    public String f53451h;
    public static final String a = "next" + File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f53445b = File.separator + "conf";

    /* renamed from: c  reason: collision with root package name */
    public static final CountDownLatch f53446c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, TTPluginListener> f53447d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, Handler> f53448e = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public static volatile f f53450g = null;

    /* loaded from: classes3.dex */
    public static class a {
        public static final c a = new c();
    }

    /* loaded from: classes3.dex */
    public static final class b implements TTAdEvent {
        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            if (i2 == 1) {
                d a = f.a(bundle.getString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME));
                if (a != null && !TextUtils.isEmpty(a.mPackageName)) {
                    boolean z = bundle.getBoolean("success");
                    TTPluginListener tTPluginListener = (TTPluginListener) f.f53447d.get(a.mPackageName);
                    if (z) {
                        com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin update received: " + a.mPackageName);
                        if (!a.isRevert) {
                            if (f.b(a, tTPluginListener)) {
                                bundle.putBoolean("installed", true);
                                return;
                            }
                            return;
                        }
                        Zeus.unInstallPlugin(a.mPackageName);
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

    public f(Context context) {
        e.a(context);
        c(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        AssetManager assets = context.getAssets();
        try {
            String a2 = com.bytedance.sdk.openadsdk.api.plugin.b.a(PluginConstants.getSign());
            File f2 = f(context);
            File file = new File(f2, (a2 + "-4022-4022") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
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

    public static List<PluginDownloadBean> e(Context context) {
        File[] listFiles = g(context).listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str != null && str.endsWith(".conf");
            }
        });
        if (listFiles != null && listFiles.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (File file : listFiles) {
                d a2 = a(c(file));
                if (a2 != null && a2.f53440b.exists()) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static File f(Context context) {
        return new File(h(context), a);
    }

    public static File g(Context context) {
        return new File(h(context), f53445b);
    }

    public static File h(Context context) {
        return new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle");
    }

    private void c(final Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZeusParam build = new ZeusParam.Builder().autoFetch(true).closeDefaultReport(true).reporter(new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.3
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    e.a(str, jSONObject);
                }
            }).verifyWith(new ApkVerifier() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.2
                @Override // com.bytedance.pangle.ApkVerifier
                public boolean verify(File file) {
                    d b2 = f.b(file);
                    if (b2 != null) {
                        return a.a.a(b2.a, file);
                    }
                    return a.a.a(f.this.f53451h, file);
                }
            }).pluginProvider(new PluginProvider() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
                @Override // com.bytedance.pangle.plugin.PluginProvider
                public File provideBuiltInPlugin() {
                    if (Zeus.isPluginInstalled("com.byted.pangle")) {
                        return null;
                    }
                    return f.this.d(context);
                }

                @Override // com.bytedance.pangle.plugin.PluginProvider
                public List<PluginDownloadBean> providePluginConfig() {
                    return f.e(context);
                }

                @Override // com.bytedance.pangle.plugin.PluginProvider
                public boolean useLocalPlugin() {
                    return true;
                }
            }).withCheckPermission(false).build();
            PluginDirHelper.setPluginDir(f(context));
            Zeus.init((Application) context, build);
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginInstallResult(String str, boolean z) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Plugin install result: [" + str + "]," + z);
                    if ("com.byted.pangle".equals(str)) {
                        if (z && Zeus.loadPlugin(str)) {
                            DexClassLoader unused = f.f53449f = Zeus.getPlugin(str).mClassLoader;
                        }
                        f.f53446c.countDown();
                        return;
                    }
                    f.b(z, str, (TTPluginListener) f.f53447d.get(str));
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Unexpected error for init zeus.", th);
            e.a(4, th.getMessage(), System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public static d b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        File file2 = new File(g(TTAppContextHolder.getContext()), b(file.getName()) + ".conf");
        if (file2.exists()) {
            return a(c(file2));
        }
        return null;
    }

    public static f a(Context context) {
        if (f53450g == null) {
            synchronized (f.class) {
                if (f53450g == null) {
                    f53450g = new f(context);
                }
            }
        }
        return f53450g;
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(".");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public static boolean b(d dVar, TTPluginListener tTPluginListener) {
        File file;
        if (dVar != null && (file = dVar.f53440b) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(file.getAbsolutePath());
            b(syncInstallPlugin, dVar.mPackageName, tTPluginListener);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.b.d.c("TTPluginManager", "plugin config is null");
        return false;
    }

    public DexClassLoader a() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                f53446c.await(60000L, TimeUnit.MILLISECONDS);
            }
            if (!Zeus.isPluginLoaded("com.byted.pangle") && Zeus.loadPlugin("com.byted.pangle")) {
                f53449f = Zeus.getPlugin("com.byted.pangle").mClassLoader;
            }
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Unexpected error for load plugin.", e2);
            e.a(3, e2.getMessage(), System.currentTimeMillis() - currentTimeMillis);
        }
        return f53449f;
    }

    public static void b(boolean z, String str, TTPluginListener tTPluginListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", sb.toString());
        Handler handler = f53448e.get(str);
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
        f53447d.remove(str);
        f53448e.remove(str);
    }

    public static String c(File file) {
        FileReader fileReader;
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

    private File a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Selected plugin with empty sign");
            return null;
        }
        this.f53451h = str;
        return file;
    }

    public Bundle a(String str, Bundle bundle) {
        Plugin plugin2;
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

    public void a(final TTPluginListener tTPluginListener) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.b.d.a("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
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
        f53447d.put(packageName, tTPluginListener);
        f53448e.put(packageName, handler);
    }

    public static d a(String str) {
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

    public static d a(JSONObject jSONObject) {
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
        dVar.a = jSONObject.optString("sign");
        dVar.isRevert = jSONObject.optBoolean("is_revert");
        dVar.f53440b = new File(jSONObject.optString("plugin_file"));
        return dVar;
    }

    public static boolean a(InputStream inputStream, File file) {
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

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Plugin plugin2, TTPluginListener tTPluginListener) {
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

    public static String a(int i2) {
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
}
