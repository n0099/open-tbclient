package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public static volatile DexClassLoader d;
    public static volatile boolean f;
    public final CountDownLatch g = new CountDownLatch(1);
    public volatile boolean h = false;
    public volatile String i = "none";
    public final Context j;
    public static final String a = UnitedSchemeConstants.UNITED_SCHEME_NEXT + File.separator;
    public static final HashMap<String, TTPluginListener> b = new HashMap<>();
    public static final HashMap<String, Handler> c = new HashMap<>();
    public static volatile e e = null;

    /* loaded from: classes7.dex */
    public static final class a implements IZeusLogger {
        public a() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.a.b(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.a.c(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.a.a(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.a.a(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.a.a(str, str2, th);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements TTAdEvent {
        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i, Bundle bundle) {
            if (i == 1) {
                String string = bundle.getString("config");
                String string2 = bundle.getString("plugin_pkg_name");
                int i2 = bundle.getInt("code");
                if (i2 == 0) {
                    com.bytedance.sdk.openadsdk.api.plugin.b c = e.c(string);
                    if (c != null && !TextUtils.isEmpty(c.mPackageName)) {
                        if (!bundle.getBoolean("success")) {
                            e.b(c.mPackageName, 1004);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin update received: " + c.mPackageName);
                        if (!c.isRevert()) {
                            if (e.b(c)) {
                                bundle.putBoolean("installed", true);
                                return;
                            }
                            return;
                        }
                        Zeus.unInstallPlugin(c.mPackageName);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin update received with invalid config");
                    return;
                }
                e.b(string2, i2);
            }
        }
    }

    public e(Context context) {
        this.j = context.getApplicationContext();
        d.a(context);
        b(context.getApplicationContext());
    }

    public static File c(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle"), a);
    }

    public DexClassLoader b() throws Exception {
        if (this.h) {
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                this.g.await(60000L, TimeUnit.MILLISECONDS);
            }
            boolean z = false;
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                d = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z = true;
            }
            Zeus.installFromDownloadDir();
            if (d == null) {
                if (this.g.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Install wait time out");
                    throw new c(8, "install wait timeout");
                } else if (z) {
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Get null after load");
                    throw new c(9, "Get null after load");
                }
            }
            return d;
        }
        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Zeus init failed.");
        throw new c(4, this.i);
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.b c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.a.e("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    public static e a(Context context) {
        if (e == null) {
            synchronized (e.class) {
                if (e == null) {
                    e = new e(context);
                }
            }
        }
        return e;
    }

    public void a() {
        f = true;
        d.a(new ArrayList());
    }

    public Bundle a(String str, Bundle bundle) {
        String a2 = a(str);
        if (!TextUtils.isEmpty(a2)) {
            bundle.putString("plugin_version", a2);
        }
        f.a(str, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    private void b(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if (e.f) {
                        d.a(str, jSONObject);
                    } else {
                        d.c(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setCloseDefaultReport(true);
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(c(context));
            globalParam.setLogger(new a());
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", str + " state changed, " + i);
                    if (i == 6 || i == 7) {
                        if ("com.byted.pangle".equals(str)) {
                            if (i == 6 && Zeus.loadPlugin(str)) {
                                DexClassLoader unused = e.d = Zeus.getPlugin(str).mClassLoader;
                            }
                            e.this.g.countDown();
                        }
                        e.b(i == 6, str);
                    }
                }
            });
            Zeus.init((Application) context, true);
            this.h = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.a.a("TTPluginManager", "Unexpected error for init zeus.", th);
            this.i = th.getMessage();
        }
    }

    public static final String a(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return a(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void a(final TTPluginListener tTPluginListener) {
        if (!this.h) {
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.e.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, LiveFeedPageSdk.REFRESH_TIME);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", sb.toString());
        if (plugin != null) {
            a(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            return;
        }
        b.put(packageName, tTPluginListener);
        c.put(packageName, handler);
    }

    public static boolean b(com.bytedance.sdk.openadsdk.api.plugin.b bVar) {
        File file;
        if (bVar != null && (file = bVar.b) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(bVar.mPackageName, file.getAbsolutePath());
            b(syncInstallPlugin, bVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin config is null");
        return false;
    }

    public static void b(boolean z, String str) {
        TTPluginListener tTPluginListener = b.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", sb.toString());
        Handler handler = c.get(str);
        if (!z) {
            b(str, 1003);
        } else if (tTPluginListener == null || handler == null) {
            return;
        } else {
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                a(plugin);
                handler.removeCallbacksAndMessages(null);
                tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            } else {
                b(str, 1002);
            }
        }
        b.remove(str);
        c.remove(str);
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.api.plugin.b bVar = new com.bytedance.sdk.openadsdk.api.plugin.b();
        bVar.mPackageName = jSONObject.optString("package_name");
        bVar.mVersionCode = jSONObject.optInt("version_code");
        bVar.mUrl = jSONObject.optString("download_url");
        bVar.mMd5 = jSONObject.optString(PackageTable.MD5);
        bVar.mApiVersionMin = jSONObject.optInt("min_version");
        bVar.mApiVersionMax = jSONObject.optInt("max_version");
        bVar.a = jSONObject.optString("sign");
        bVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        bVar.b = new File(jSONObject.optString("plugin_file"));
        return bVar;
    }

    public static void b(String str, int i) {
        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = b.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public static void a(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString("plugin_version", a(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String a(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void a(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
