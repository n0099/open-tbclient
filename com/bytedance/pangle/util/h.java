package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1401945170, "Lcom/bytedance/pangle/util/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1401945170, "Lcom/bytedance/pangle/util/h;");
        }
    }

    public static List<String> a() {
        AssetManager assetManager;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                assetManager = (AssetManager) AssetManager.class.newInstance();
            } catch (Exception e2) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e2);
                assetManager = null;
            }
            return a(assetManager);
        }
        return (List) invokeV.objValue;
    }

    public static String b(AssetManager assetManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, assetManager)) == null) {
            List<String> a2 = a(assetManager);
            StringBuilder sb = new StringBuilder(PreferencesUtil.LEFT_MOUNT);
            if (a2.size() > 0) {
                for (String str : a2) {
                    sb.append(str);
                    sb.append(" , ");
                }
                sb.delete(sb.lastIndexOf(" , "), sb.length());
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> a(AssetManager assetManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, assetManager)) == null) {
            ArrayList arrayList = new ArrayList();
            if (assetManager == null) {
                return arrayList;
            }
            try {
                if (g.d()) {
                    Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                    if (objArr != null && objArr.length > 0) {
                        for (Object obj : objArr) {
                            arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                        }
                    }
                } else {
                    int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                    int i2 = 0;
                    while (i2 < intValue) {
                        i2++;
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "GetAssetsPaths error. ", th);
                th.printStackTrace();
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            if (g.b()) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    arrayList.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", "string", "android")), 0).getApplicationInfo().sourceDir);
                } catch (Exception e2) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e2);
                }
            } else if (g.c()) {
                try {
                    Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                    if (Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                        z = true;
                    }
                    if (z) {
                        Collections.addAll(arrayList, a(((Context) invokeStaticMethod).getApplicationInfo()));
                    } else {
                        arrayList.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                    }
                } catch (Exception e3) {
                    ZeusLogger.e(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e3);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static boolean a(AssetManager assetManager, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, assetManager, str)) == null) {
            try {
                if (g.d()) {
                    Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                    if (objArr != null && objArr.length > 0) {
                        for (Object obj : objArr) {
                            if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                                return true;
                            }
                        }
                    }
                } else {
                    int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                    int i2 = 0;
                    while (i2 < intValue) {
                        i2++;
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i2)), str)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @RequiresApi(api = 21)
    public static String[] a(ApplicationInfo applicationInfo) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, applicationInfo)) == null) {
            try {
                strArr = (String[]) com.bytedance.pangle.a.b.a.a(ApplicationInfo.class, "resourceDirs").get(applicationInfo);
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th);
                strArr = new String[0];
            }
            String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
            ArrayList arrayList = new ArrayList(10);
            String str = applicationInfo.sourceDir;
            if (str != null) {
                arrayList.add(str);
            }
            for (int i2 = 0; i2 < 3; i2++) {
                String[] strArr3 = strArr2[i2];
                if (strArr3 != null) {
                    arrayList.addAll(Arrays.asList(strArr3));
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }
}
