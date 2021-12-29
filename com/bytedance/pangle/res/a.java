package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Integer> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f55204b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1192650551, "Lcom/bytedance/pangle/res/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1192650551, "Lcom/bytedance/pangle/res/a;");
                return;
            }
        }
        a = new HashMap();
        List<String> a2 = h.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        for (String str : a2) {
            a.put(str, 0);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.f55204b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    public static AssetManager b(AssetManager assetManager, String str, boolean z) {
        InterceptResult invokeLLZ;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, assetManager, str, z)) == null) {
            String str2 = V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD;
            String str3 = z ? "addAssetPathAsSharedLibrary" : V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD;
            Method accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, str3, String.class);
            if (accessibleMethod == null && z) {
                accessibleMethod = MethodUtils.getAccessibleMethod(AssetManager.class, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class);
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
            } else {
                str2 = str3;
            }
            if (accessibleMethod != null) {
                int i2 = 3;
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 < 0) {
                        break;
                    }
                    try {
                        intValue = ((Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    } catch (Exception e2) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e2);
                    }
                    if (intValue != 0) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                        break;
                    }
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = ".concat(String.valueOf(intValue)));
                    i2 = i3;
                }
            } else {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = ".concat(String.valueOf(z)));
            }
            return assetManager;
        }
        return (AssetManager) invokeLLZ.objValue;
    }

    public static AssetManager c(AssetManager assetManager, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, assetManager, str, z)) == null) {
            int i2 = 3;
            Throwable th = null;
            int i3 = 3;
            while (true) {
                int i4 = i3 - 1;
                if (i3 < 0) {
                    break;
                }
                try {
                    synchronized (assetManager) {
                        int i5 = 0;
                        for (int i6 = 0; i6 < i2; i6++) {
                            if (g.b()) {
                                i5 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else if (Build.VERSION.SDK_INT >= 24 && Build.VERSION.SDK_INT <= 25) {
                                i5 = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                            }
                            if (i5 != 0) {
                                break;
                            }
                        }
                        if (i5 != 0) {
                            Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
                            int length = readField != null ? Array.getLength(readField) : 0;
                            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                            Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
                            for (int i7 = 0; i7 < intValue; i7++) {
                                if (i7 < length) {
                                    Array.set(newInstance, i7, Array.get(readField, i7));
                                } else {
                                    Array.set(newInstance, i7, MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new Object[]{Integer.valueOf(i7)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                                }
                            }
                            FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
                            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i3 = i4;
                    i2 = 3;
                }
            }
            if (th != null) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            return assetManager;
        }
        return (AssetManager) invokeLLZ.objValue;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z) {
        InterceptResult invokeLLZ;
        AssetManager a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, assetManager, str, z)) == null) {
            if (g.a()) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 21 && i2 <= 25) {
                    a2 = c(assetManager, str, z);
                    if (!h.a(a2, str)) {
                        a2 = b(assetManager, str, z);
                    }
                } else {
                    a2 = b(assetManager, str, z);
                }
            } else {
                a2 = a(assetManager, str);
            }
            synchronized (this.f55204b) {
                this.f55204b.put(str, 0);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager, newAssetManager=" + a2 + ", assets=" + h.b(a2));
            return a2;
        }
        return (AssetManager) invokeLLZ.objValue;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        InterceptResult invokeLL;
        AssetManager assetManager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, assetManager, str)) == null) {
            List<String> a2 = h.a(assetManager);
            ArrayList<String> arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (String str2 : a2) {
                if (!a.containsKey(str2) && !this.f55204b.containsKey(str2) && !str2.equals(str)) {
                    arrayList.add(str2);
                }
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets");
            try {
                if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                    assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
                } else {
                    assetManager2 = (AssetManager) AssetManager.class.newInstance();
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
                synchronized (this.f55204b) {
                    for (Map.Entry<String, Integer> entry : this.f55204b.entrySet()) {
                        if (!a.containsKey(entry.getKey())) {
                            sb.append(entry.getKey());
                            b(assetManager2, entry.getKey(), false);
                        }
                    }
                }
                if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                    b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
                }
                sb.append(str);
                b(assetManager2, str, false);
                if (!arrayList.isEmpty()) {
                    for (String str3 : arrayList) {
                        sb.append(str3);
                        b(assetManager2, str3, false);
                    }
                }
                if ((Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 23) && !sb.toString().toLowerCase().contains(AlbumActivityConfig.FROM_WEB_VIEW)) {
                    try {
                        Resources resources = Zeus.getAppApplication().getResources();
                        String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir;
                        if (!TextUtils.isEmpty(str4)) {
                            b(assetManager2, str4, false);
                        }
                    } catch (Exception e2) {
                        ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e2);
                    }
                }
                assetManager = assetManager2;
            } catch (Exception e3) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e3);
                b(assetManager, str, false);
            }
            try {
                MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
            } catch (Exception e4) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e4);
            }
            return assetManager;
        }
        return (AssetManager) invokeLL.objValue;
    }
}
