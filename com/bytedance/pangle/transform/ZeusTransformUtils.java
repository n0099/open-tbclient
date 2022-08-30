package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.GenerateProxyActivity;
import com.bytedance.pangle.activity.GenerateProxyAppCompatActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.service.PluginIntentService;
import com.bytedance.pangle.service.PluginService;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
@Keep
/* loaded from: classes7.dex */
public class ZeusTransformUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginContextUtils";
    public static HashMap<String, WeakReference<Context>> contextCache;
    public static Class fragmentClazz;
    public static boolean hasEnsure;
    public static HashMap<String, Constructor<View>> sConstructorMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(595738492, "Lcom/bytedance/pangle/transform/ZeusTransformUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(595738492, "Lcom/bytedance/pangle/transform/ZeusTransformUtils;");
                return;
            }
        }
        contextCache = new HashMap<>();
        hasEnsure = false;
        sConstructorMap = null;
    }

    public ZeusTransformUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Activity _getActivity(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, str)) == null) {
            try {
                Activity activity = (Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]);
                Activity activity2 = (Activity) wrapperContext(activity, str);
                if (activity2 instanceof GenerateProxyActivity) {
                    return ((GenerateProxyActivity) activity2).mTargetActivity;
                }
                if (activity2 instanceof GenerateProxyAppCompatActivity) {
                    return ((GenerateProxyAppCompatActivity) activity2).mTargetActivity;
                }
                return (Activity) wrapperContext(activity, str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (Activity) invokeLL.objValue;
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{obj, intent, serviceConnection, Integer.valueOf(i), str})) == null) {
            if (obj instanceof Context) {
                return ServiceManagerNative.getInstance().bindServiceNative((Context) obj, intent, serviceConnection, i, str);
            }
            try {
                return ((Boolean) MethodUtils.invokeMethod(obj, "bindService", new Object[]{intent, serviceConnection, Integer.valueOf(i)}, new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE})).booleanValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void clearConstructorCache() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || Build.VERSION.SDK_INT > 23) {
            return;
        }
        try {
            if (sConstructorMap == null) {
                sConstructorMap = (HashMap) FieldUtils.readStaticField(LayoutInflater.class, "sConstructorMap");
            }
            for (String str : new HashSet(sConstructorMap.keySet())) {
                if (!str.startsWith("android.view.") && !str.startsWith("android.widget.") && !str.startsWith("android.webkit.") && str.contains(".")) {
                    sConstructorMap.remove(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void ensureFragmentActivity() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || hasEnsure) {
            return;
        }
        try {
            try {
                fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fragmentClazz = Zeus.class.getClassLoader().loadClass("androidx.fragment.app.FragmentActivity");
        }
        hasEnsure = true;
    }

    public static boolean equalsFragmentActivity(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            ensureFragmentActivity();
            Class cls2 = fragmentClazz;
            return cls2 != null && cls == cls2;
        }
        return invokeL.booleanValue;
    }

    public static Class forName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? Zeus.getPlugin(str2).mClassLoader.loadClass(str) : (Class) invokeLL.objValue;
    }

    public static Activity getActivity(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) ? _getActivity(obj, str) : (Activity) invokeLL.objValue;
    }

    public static String getAssetPaths(AssetManager assetManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, assetManager)) == null) {
            StringBuilder sb = new StringBuilder();
            if (assetManager == null) {
                return "";
            }
            try {
            } catch (Throwable th) {
                ZeusLogger.e(ZeusLogger.TAG_RESOURCES, "GetAssetsPaths error. ", th);
                th.printStackTrace();
            }
            if (Build.VERSION.SDK_INT < 28 && (Build.VERSION.SDK_INT != 27 || Build.VERSION.PREVIEW_SDK_INT <= 0)) {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i = 0;
                while (i < intValue) {
                    i++;
                    String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i));
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                    }
                }
                return sb.toString();
            }
            Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
            if (objArr != null && objArr.length > 0) {
                for (Object obj : objArr) {
                    sb.append((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Context getContext(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, str)) == null) {
            try {
                Context context = (Context) MethodUtils.invokeMethod(obj, "getContext", new Object[0]);
                if (instanceOfFragmentActivity(context)) {
                    return wrapperContext(context, str);
                }
                if (context instanceof Activity) {
                    return wrapperContext(context, str);
                }
                if (context instanceof Application) {
                    return wrapperContext(context, str);
                }
                return context instanceof PluginContext ? context : wrapperContext(context, str);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (Context) invokeLL.objValue;
    }

    public static Context getContextIfNeedWrap(Context context, Context context2, String str) {
        Object readField;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, context2, str)) == null) {
            while (context2 != null) {
                if (context2 instanceof IPluginActivity) {
                    if (TextUtils.equals(((IPluginActivity) context2).getPluginPkgName(), str)) {
                        return null;
                    }
                    return context;
                } else if (context2 instanceof PluginContext) {
                    PluginContext pluginContext = (PluginContext) context2;
                    if (TextUtils.equals(pluginContext.mPlugin.mPkgName, str)) {
                        return null;
                    }
                    return pluginContext.mOriginContext;
                } else if (context2 instanceof PluginActivityWrapper) {
                    PluginActivityWrapper pluginActivityWrapper = (PluginActivityWrapper) context2;
                    if (TextUtils.equals(pluginActivityWrapper.pluginContext.mPlugin.mPkgName, str)) {
                        return null;
                    }
                    return pluginActivityWrapper.mOriginActivity;
                } else if (context2 instanceof PluginFragmentActivityWrapper) {
                    if (TextUtils.equals(((PluginFragmentActivityWrapper) context2).pluginContext.mPlugin.mPkgName, str)) {
                        return null;
                    }
                    try {
                        try {
                            readField = ((PluginFragmentActivityWrapper) context2).getOriginActivity();
                        } catch (Throwable unused) {
                            readField = FieldUtils.readField(context2, "mOriginActivity");
                        }
                        return (Context) readField;
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } else if (context2 instanceof PluginApplicationWrapper) {
                    PluginApplicationWrapper pluginApplicationWrapper = (PluginApplicationWrapper) context2;
                    if (TextUtils.equals(pluginApplicationWrapper.mPluginContext.mPlugin.mPkgName, str)) {
                        return null;
                    }
                    return pluginApplicationWrapper.mOriginApplication;
                } else if (context2.getResources() instanceof PluginResources) {
                    PluginResources pluginResources = (PluginResources) context2.getResources();
                    try {
                        String str2 = (String) FieldUtils.readField(pluginResources, "pluginPkg");
                        if (TextUtils.isEmpty(str2)) {
                            String assetPaths = getAssetPaths(pluginResources.getAssets());
                            if (!assetPaths.contains("/" + str + "/version")) {
                                return context;
                            }
                        } else if (!TextUtils.equals(str2, str)) {
                            return context;
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    return null;
                } else if (!(context2 instanceof ContextWrapper)) {
                    return context;
                } else {
                    try {
                        context2 = (Context) FieldUtils.readField(context2, "mBase");
                    } catch (Throwable unused2) {
                        context2 = ((ContextWrapper) context2).getBaseContext();
                    }
                }
            }
            return null;
        }
        return (Context) invokeLLL.objValue;
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, obj, str, str2, str3, str4)) == null) {
            if (obj instanceof Resources) {
                Resources resources = (Resources) obj;
                if (!TextUtils.equals("android", str3)) {
                    str3 = str4;
                }
                return resources.getIdentifier(str, str2, str3);
            }
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return invokeLLLLL.intValue;
    }

    public static Resources getResources(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, obj, str)) == null) {
            try {
                Resources resources = (Resources) MethodUtils.invokeMethod(obj, "getResources", new Object[0]);
                if (resources == null) {
                    return null;
                }
                if (resources instanceof PluginResources) {
                    String str2 = (String) FieldUtils.readField(resources, "pluginPkg");
                    if (TextUtils.isEmpty(str2)) {
                        String assetPaths = getAssetPaths(resources.getAssets());
                        if (assetPaths.contains("/" + str + "/version")) {
                            return resources;
                        }
                    } else if (TextUtils.equals(str2, str)) {
                        return resources;
                    }
                }
                return PluginManager.getInstance().getPlugin(str).mResources;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (Resources) invokeLL.objValue;
    }

    public static Context getWrapperFromCache(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, obj, str)) == null) {
            HashMap<String, WeakReference<Context>> hashMap = contextCache;
            WeakReference<Context> weakReference = hashMap.get(str + System.identityHashCode(obj));
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Context) invokeLL.objValue;
    }

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{layoutInflater, Integer.valueOf(i), viewGroup, Boolean.valueOf(z), str})) == null) {
            Context context = layoutInflater.getContext();
            if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
                layoutInflater = (LayoutInflater) wrapperContext(context, str).getSystemService("layout_inflater");
            }
            clearConstructorCache();
            View inflate = layoutInflater.inflate(i, viewGroup, z);
            clearConstructorCache();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static boolean instanceOf(Object obj, Class cls) {
        InterceptResult invokeLL;
        Object readField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, obj, cls)) == null) {
            if (obj instanceof PluginContext) {
                return cls.isInstance(((PluginContext) obj).mOriginContext);
            }
            if (obj instanceof PluginActivityWrapper) {
                return cls.isInstance(((PluginActivityWrapper) obj).mOriginActivity);
            }
            if (obj instanceof PluginFragmentActivityWrapper) {
                try {
                    try {
                        readField = ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                } catch (Throwable unused) {
                    readField = FieldUtils.readField(obj, "mOriginActivity");
                }
                return cls.isInstance(readField);
            } else if (obj instanceof PluginApplicationWrapper) {
                return cls.isInstance(((PluginApplicationWrapper) obj).mOriginApplication);
            } else {
                return cls.isInstance(obj);
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean instanceOfFragmentActivity(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, obj)) == null) {
            ensureFragmentActivity();
            Class cls = fragmentClazz;
            if (cls == null) {
                return false;
            }
            return cls.isInstance(obj);
        }
        return invokeL.booleanValue;
    }

    public static int mapRes(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65558, null, i, str, str2)) == null) {
            if (i < 2130706432) {
                return i;
            }
            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2, str, Zeus.getAppApplication().getPackageName());
            if (identifier == 0) {
                identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.replace("_", "."), str, Zeus.getAppApplication().getPackageName());
            }
            if (identifier == 0) {
                ZeusLogger.d(ZeusLogger.TAG_RESOURCES, "Cant find res, resName = " + str2 + ", pluginResId = " + i);
            }
            return identifier;
        }
        return invokeILL.intValue;
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, obj, cls, str)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Context) {
                boolean z = !cls.isInstance(obj);
                if (equalsFragmentActivity(cls)) {
                    return wrapperContext2FragmentActivity(obj, str);
                }
                if (cls == Activity.class) {
                    return wrapperContext2Activity(obj, str);
                }
                if (cls == Application.class) {
                    return wrapperContext2Application(obj, str);
                }
                if ((obj instanceof PluginContext) && z) {
                    return ((PluginContext) obj).mOriginContext;
                }
                if ((obj instanceof PluginFragmentActivityWrapper) && z) {
                    try {
                        try {
                            return ((PluginFragmentActivityWrapper) obj).getOriginActivity();
                        } catch (Throwable th) {
                            throw new RuntimeException(th);
                        }
                    } catch (Throwable unused) {
                        return FieldUtils.readField(obj, "mOriginActivity");
                    }
                } else if ((obj instanceof PluginActivityWrapper) && z) {
                    return ((PluginActivityWrapper) obj).mOriginActivity;
                } else {
                    return ((obj instanceof PluginApplicationWrapper) && z) ? ((PluginApplicationWrapper) obj).mOriginApplication : obj;
                }
            }
            return obj;
        }
        return invokeLLL.objValue;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65561, null, obj, pluginBroadcastReceiver, intentFilter, str)) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65564, null, str, strArr, str2) == null) {
            ComponentManager.registerActivity(str2, str, strArr);
        }
    }

    public static void requestPermissions(Object obj, String[] strArr, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65565, null, obj, strArr, i, str) == null) {
            if (obj instanceof IPluginActivity) {
                ((IPluginActivity) obj)._requestPermissions(strArr, i);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "requestPermissions", strArr, Integer.valueOf(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setResult(Object obj, int i, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65566, null, obj, i, intent, str) == null) {
            if (obj instanceof Activity) {
                try {
                    Object readField = FieldUtils.readField(obj, "mProxyActivity");
                    if (readField == null) {
                        readField = FieldUtils.readField(obj, "mOriginActivity");
                    }
                    if (readField != null) {
                        MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i), intent);
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            try {
                MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i), intent);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, obj, intent, str) == null) {
            startActivity(obj, intent, null, str);
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65571, null, obj, intent, i, str) == null) {
            startActivityForResult(obj, intent, i, null, str);
        }
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65572, null, obj, intent, str)) == null) {
            if (obj instanceof Context) {
                return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
            }
            try {
                return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (ComponentName) invokeLLL.objValue;
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65573, null, obj, intent, str)) == null) {
            if (obj instanceof Context) {
                return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
            }
            try {
                return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65574, null, obj, serviceConnection, str) == null) {
            if (obj instanceof Context) {
                ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65575, null, obj, pluginBroadcastReceiver, str) == null) {
            if (obj instanceof Context) {
                ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Context wrapperContext(Object obj, String str) {
        InterceptResult invokeLL;
        Context pluginContext;
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, obj, str)) == null) {
            if (Zeus.getAppApplication() == null && (application = (Application) ((Context) obj).getApplicationContext()) != null) {
                Zeus.setAppContext(application);
            }
            if (obj == null) {
                return null;
            }
            Context wrapperFromCache = getWrapperFromCache(obj, str);
            if (wrapperFromCache != null) {
                return wrapperFromCache;
            }
            Context context = (Context) obj;
            Context contextIfNeedWrap = getContextIfNeedWrap(context, context, str);
            if (contextIfNeedWrap == null) {
                return context;
            }
            if (instanceOfFragmentActivity(contextIfNeedWrap)) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                try {
                    try {
                        pluginContext = new PluginFragmentActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
                    } catch (Throwable unused) {
                        pluginContext = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
                    }
                } catch (Throwable unused2) {
                    return contextIfNeedWrap;
                }
            } else if (contextIfNeedWrap instanceof Activity) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                pluginContext = new PluginActivityWrapper((Activity) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false));
            } else if (contextIfNeedWrap instanceof Application) {
                pluginContext = new PluginApplicationWrapper((Application) contextIfNeedWrap, new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), true));
            } else {
                pluginContext = new PluginContext(contextIfNeedWrap, PluginManager.getInstance().getPlugin(str), false);
            }
            if (pluginContext != null) {
                HashMap<String, WeakReference<Context>> hashMap = contextCache;
                hashMap.put(str + System.identityHashCode(contextIfNeedWrap), new WeakReference<>(pluginContext));
            }
            return pluginContext;
        }
        return (Context) invokeLL.objValue;
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, obj, str)) == null) {
            while (obj != null) {
                Context wrapperContext = wrapperContext(obj, str);
                if (wrapperContext instanceof Activity) {
                    return (Activity) wrapperContext;
                }
                if (wrapperContext instanceof PluginContext) {
                    obj = ((PluginContext) wrapperContext).mOriginContext;
                } else {
                    throw new RuntimeException("强转失败");
                }
            }
            return null;
        }
        return (Activity) invokeLL.objValue;
    }

    public static Application wrapperContext2Application(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, obj, str)) == null) {
            while (obj != null) {
                Context wrapperContext = wrapperContext(obj, str);
                if (wrapperContext instanceof Application) {
                    return (Application) wrapperContext;
                }
                if (wrapperContext instanceof PluginContext) {
                    obj = ((PluginContext) wrapperContext).mOriginContext;
                } else {
                    throw new RuntimeException("强转失败");
                }
            }
            return null;
        }
        return (Application) invokeLL.objValue;
    }

    public static Object wrapperContext2FragmentActivity(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, obj, str)) == null) {
            while (obj != null) {
                Context wrapperContext = wrapperContext(obj, str);
                if (instanceOfFragmentActivity(wrapperContext)) {
                    return wrapperContext;
                }
                if (wrapperContext instanceof PluginContext) {
                    obj = ((PluginContext) wrapperContext).mOriginContext;
                } else {
                    throw new RuntimeException("强转失败");
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object wrapperContextForParams(Object obj, Class cls, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65580, null, obj, cls, str)) == null) {
            if (!(obj instanceof PluginService) && !(obj instanceof PluginIntentService) && (obj instanceof Context)) {
                Context wrapperContext = wrapperContext(obj, str);
                if (cls.isInstance(wrapperContext(obj, str))) {
                    return wrapperContext;
                }
            }
            return obj;
        }
        return invokeLLL.objValue;
    }

    public static void startActivity(Object obj, Intent intent, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, obj, intent, bundle, str) == null) {
            try {
                ComponentManager.startActivity(obj, intent, bundle, str);
            } catch (Throwable th) {
                if (obj instanceof Context) {
                    ComponentManager.startActivity((Context) obj, intent, bundle, str);
                    return;
                }
                try {
                    MethodUtils.invokeMethod(obj, WBConstants.SHARE_START_ACTIVITY, new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
                } catch (Throwable th2) {
                    th2.addSuppressed(th);
                    throw new RuntimeException(th2);
                }
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{obj, intent, Integer.valueOf(i), bundle, str}) == null) {
            try {
                ComponentManager.startActivityForResult(obj, intent, i, bundle, str);
            } catch (Throwable th) {
                if (obj instanceof Activity) {
                    ComponentManager.startActivityForResult((Activity) obj, intent, i, bundle, str);
                    return;
                }
                try {
                    MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
                } catch (Throwable th2) {
                    th2.addSuppressed(th);
                    throw new RuntimeException(th2);
                }
            }
        }
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{obj, pluginBroadcastReceiver, intentFilter, str, handler, str2})) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (Intent) invokeCommon.objValue;
    }

    public static void setResult(Object obj, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65567, null, obj, i, str) == null) {
            if (obj instanceof Activity) {
                try {
                    Object readField = FieldUtils.readField(obj, "mProxyActivity");
                    if (readField != null) {
                        MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i));
                        return;
                    }
                } catch (Exception unused) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
                }
            }
            try {
                MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, String str) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65552, null, layoutInflater, i, viewGroup, str)) == null) {
            return inflate(layoutInflater, i, viewGroup, viewGroup != null, str);
        }
        return (View) invokeLILL.objValue;
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65554, null, layoutInflater, xmlPullParser, viewGroup, str)) == null) {
            return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
        }
        return (View) invokeLLLL.objValue;
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{layoutInflater, xmlPullParser, viewGroup, Boolean.valueOf(z), str})) == null) {
            Context context = layoutInflater.getContext();
            if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
                layoutInflater = (LayoutInflater) wrapperContext(context, str).getSystemService("layout_inflater");
            }
            clearConstructorCache();
            View inflate = layoutInflater.inflate(xmlPullParser, viewGroup, z);
            clearConstructorCache();
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{obj, pluginBroadcastReceiver, intentFilter, Integer.valueOf(i), str})) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i, str);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{obj, pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i), str2})) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i, str2);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (Intent) invokeCommon.objValue;
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup, String str) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65551, null, context, i, viewGroup, str)) == null) {
            if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
                context = wrapperContext(context, str);
            }
            clearConstructorCache();
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, viewGroup);
            clearConstructorCache();
            return inflate;
        }
        return (View) invokeLILL.objValue;
    }
}
