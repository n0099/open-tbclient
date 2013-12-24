package com.baidu.zeus;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.SystemProperties;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PluginManager {
    private static final String LOGTAG = "PluginManager";
    public static final String PLUGIN_ACTION = "android.webkit.PLUGIN";
    public static final String PLUGIN_PERMISSION = "android.webkit.permission.PLUGIN";
    private static final String PLUGIN_SYSTEM_LIB = "/system/lib/plugins/";
    private static final String PLUGIN_TYPE = "type";
    private static final String TYPE_NATIVE = "native";
    private final Context mContext;
    private ArrayList<PackageInfo> mPackageInfoCache = new ArrayList<>();
    private static PluginManager mInstance = null;
    private static final String SIGNATURE_1 = "308204c5308203ada003020102020900d7cb412f75f4887e300d06092a864886f70d010105050030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564301e170d3039313030313030323331345a170d3337303231363030323331345a30819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f726174656430820120300d06092a864886f70d01010105000382010d0030820108028201010099724f3e05bbd78843794f357776e04b340e13cb1c9ccb3044865180d7d8fec8166c5bbd876da8b80aa71eb6ba3d4d3455c9a8de162d24a25c4c1cd04c9523affd06a279fc8f0d018f242486bdbb2dbfbf6fcb21ed567879091928b876f7ccebc7bccef157366ebe74e33ae1d7e9373091adab8327482154afc0693a549522f8c796dd84d16e24bb221f5dbb809ca56dd2b6e799c5fa06b6d9c5c09ada54ea4c5db1523a9794ed22a3889e5e05b29f8ee0a8d61efe07ae28f65dece2ff7edc5b1416d7c7aad7f0d35e8f4a4b964dbf50ae9aa6d620157770d974131b3e7e3abd6d163d65758e2f0822db9c88598b9db6263d963d13942c91fc5efe34fc1e06e3020103a382010630820102301d0603551d0e041604145af418e419a639e1657db960996364a37ef20d403081d20603551d230481ca3081c780145af418e419a639e1657db960996364a37ef20d40a181a3a481a030819d310b3009060355040613025553311330110603550408130a43616c69666f726e69613111300f0603550407130853616e204a6f736531233021060355040a131a41646f62652053797374656d7320496e636f72706f7261746564311c301a060355040b1313496e666f726d6174696f6e2053797374656d73312330210603550403131a41646f62652053797374656d7320496e636f72706f7261746564820900d7cb412f75f4887e300c0603551d13040530030101ff300d06092a864886f70d0101050500038201010076c2a11fe303359689c2ebc7b2c398eff8c3f9ad545cdbac75df63bf7b5395b6988d1842d6aa1556d595b5692e08224d667a4c9c438f05e74906c53dd8016dde7004068866f01846365efd146e9bfaa48c9ecf657f87b97c757da11f225c4a24177bf2d7188e6cce2a70a1e8a841a14471eb51457398b8a0addd8b6c8c1538ca8f1e40b4d8b960009ea22c188d28924813d2c0b4a4d334b7cf05507e1fcf0a06fe946c7ffc435e173af6fc3e3400643710acc806f830a14788291d46f2feed9fb5c70423ca747ed1572d752894ac1f19f93989766308579393fabb43649aa8806a313b1ab9a50922a44c2467b9062037f2da0d484d9ffd8fe628eeea629ba637";
    private static final Signature[] SIGNATURES = {new Signature(SIGNATURE_1)};

    private PluginManager(Context context) {
        this.mContext = context;
    }

    public static synchronized PluginManager getInstance(Context context) {
        PluginManager pluginManager;
        synchronized (PluginManager.class) {
            if (mInstance == null) {
                if (context == null) {
                    throw new IllegalStateException("First call to PluginManager need a valid context.");
                }
                mInstance = new PluginManager(context.getApplicationContext());
            }
            pluginManager = mInstance;
        }
        return pluginManager;
    }

    public void refreshPlugins(boolean z) {
        BrowserFrame.sJavaBridge.obtainMessage(100, Boolean.valueOf(z)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getPluginDirectories() {
        String[] strArr;
        Signature[] signatureArr;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent(PLUGIN_ACTION), 132);
        synchronized (this.mPackageInfoCache) {
            this.mPackageInfoCache.clear();
            int i = 0;
            while (i < 2) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo == null) {
                        Log.w(LOGTAG, "Ignore bad plugin");
                    } else {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(serviceInfo.packageName, 4160);
                            if (packageInfo != null) {
                                String str = i == 1 ? PLUGIN_SYSTEM_LIB + packageInfo.packageName : packageInfo.applicationInfo.dataDir + "/lib";
                                if (!arrayList.contains(str) && (strArr = packageInfo.requestedPermissions) != null) {
                                    boolean z = false;
                                    int length = strArr.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            if (!PLUGIN_PERMISSION.equals(strArr[i2])) {
                                                i2++;
                                            } else {
                                                z = true;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    if (z && (signatureArr = packageInfo.signatures) != null) {
                                        if (SystemProperties.getBoolean("ro.secure", false)) {
                                            boolean z2 = false;
                                            for (Signature signature : signatureArr) {
                                                int i3 = 0;
                                                while (true) {
                                                    if (i3 < SIGNATURES.length) {
                                                        if (!SIGNATURES[i3].equals(signature)) {
                                                            i3++;
                                                        } else {
                                                            z2 = true;
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            }
                                            if (z2) {
                                            }
                                        }
                                        if (serviceInfo.metaData == null) {
                                            Log.e(LOGTAG, "The plugin '" + serviceInfo.name + "' has no type defined");
                                        } else {
                                            String string = serviceInfo.metaData.getString(PLUGIN_TYPE);
                                            if (!TYPE_NATIVE.equals(string)) {
                                                Log.e(LOGTAG, "Unrecognized plugin type: " + string);
                                            } else {
                                                try {
                                                    try {
                                                        getPluginClass(serviceInfo.packageName, serviceInfo.name);
                                                        this.mPackageInfoCache.add(packageInfo);
                                                        arrayList.add(str);
                                                    } catch (ClassNotFoundException e) {
                                                        Log.e(LOGTAG, "Can't find plugin's class: " + serviceInfo.name);
                                                    }
                                                } catch (PackageManager.NameNotFoundException e2) {
                                                    Log.e(LOGTAG, "Can't find plugin: " + serviceInfo.packageName);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException e3) {
                            Log.w(LOGTAG, "Can't find plugin: " + serviceInfo.packageName);
                        }
                    }
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001a A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:10:0x000e, B:11:0x0014, B:13:0x001a, B:15:0x002a, B:17:0x0032, B:18:0x0034, B:23:0x0039), top: B:25:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getPluginsAPKName(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        synchronized (this.mPackageInfoCache) {
            Iterator<PackageInfo> it = this.mPackageInfoCache.iterator();
            while (it.hasNext()) {
                PackageInfo next = it.next();
                if (str.startsWith(next.applicationInfo.dataDir) || str.startsWith("/system/lib")) {
                    return next.packageName;
                }
                while (it.hasNext()) {
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getPluginSharedDataDirectory() {
        return this.mContext.getDir("plugins", 0).getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> getPluginClass(String str, String str2) {
        return this.mContext.createPackageContext(str, 3).getClassLoader().loadClass(str2);
    }
}
