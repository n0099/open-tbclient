package com.bytedance.pangle.transform;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
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
import com.bytedance.pangle.activity.GeneratePluginActivity;
import com.bytedance.pangle.activity.GeneratePluginAppCompatActivity;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.pangle.wrapper.PluginFragmentActivityWrapper;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
@Keep
/* loaded from: classes6.dex */
public class ZeusTransformUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PluginContextUtils";
    public static HashMap<String, WeakReference<Context>> contextCache;
    public static Class fragmentClazz;
    public static boolean hasEnsure;
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
                return (Activity) wrapperContext((Activity) MethodUtils.invokeMethod(obj, "getActivity", new Object[0]), str);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
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
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void ensureFragmentActivity() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || hasEnsure) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            ensureFragmentActivity();
            Class cls2 = fragmentClazz;
            return cls2 != null && cls == cls2;
        }
        return invokeL.booleanValue;
    }

    public static Class forName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) ? Zeus.getPlugin(str2).mClassLoader.loadClass(str) : (Class) invokeLL.objValue;
    }

    public static Activity getActivity(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, obj, str)) == null) ? _getActivity(obj, str) : (Activity) invokeLL.objValue;
    }

    public static Context getContext(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
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
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Context) invokeLL.objValue;
    }

    public static int getIdentifier(Object obj, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65545, null, obj, str, str2, str3, str4)) == null) {
            if (obj instanceof Resources) {
                Resources resources = (Resources) obj;
                if (!TextUtils.equals("android", str3)) {
                    str3 = str4;
                }
                return resources.getIdentifier(str, str2, str3);
            }
            try {
                return ((Integer) MethodUtils.invokeMethod(obj, "getIdentifier", str, str2, str3)).intValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeLLLLL.intValue;
    }

    public static Resources getResources(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, obj, str)) == null) {
            try {
                Resources resources = (Resources) MethodUtils.invokeMethod(obj, "getResources", new Object[0]);
                return (resources == null || (resources instanceof PluginResources)) ? resources : PluginManager.getInstance().getPlugin(str).mResources;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Resources) invokeLL.objValue;
    }

    public static Context getWrapperFromCache(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, obj, str)) == null) {
            HashMap<String, WeakReference<Context>> hashMap = contextCache;
            WeakReference<Context> weakReference = hashMap.get(str + System.identityHashCode(obj));
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (Context) invokeLL.objValue;
    }

    public static boolean hasWrapper(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            while (context != null) {
                if ((context instanceof PluginContext) || (context instanceof PluginActivityWrapper) || (context instanceof PluginFragmentActivityWrapper) || (context instanceof PluginApplicationWrapper) || (context.getResources() instanceof PluginResources)) {
                    return true;
                }
                if (!(context instanceof ContextWrapper)) {
                    return false;
                }
                try {
                    context = (Context) FieldUtils.readField(context, "mBase");
                } catch (Throwable unused) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{layoutInflater, Integer.valueOf(i), viewGroup, Boolean.valueOf(z), str})) == null) {
            Context context = layoutInflater.getContext();
            if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
                layoutInflater = (LayoutInflater) wrapperContext(context, str).getSystemService("layout_inflater");
            }
            return layoutInflater.inflate(i, viewGroup, z);
        }
        return (View) invokeCommon.objValue;
    }

    public static boolean instanceOf(Object obj, Class cls) {
        InterceptResult invokeLL;
        Object readField;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, obj, cls)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, obj)) == null) {
            ensureFragmentActivity();
            Class cls = fragmentClazz;
            if (cls == null) {
                return false;
            }
            return cls.isInstance(obj);
        }
        return invokeL.booleanValue;
    }

    public static Object preCheckCast(Object obj, Class cls, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, obj, cls, str)) == null) {
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65558, null, obj, pluginBroadcastReceiver, intentFilter, str)) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static void registerZeusActivityStub(String str, String[] strArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, str, strArr, str2) == null) {
            ComponentManager.registerActivity(str2, str, strArr);
        }
    }

    public static void requestPermissions(Object obj, String[] strArr, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65562, null, obj, strArr, i, str) == null) {
            if (obj instanceof IPluginActivity) {
                ((IPluginActivity) obj)._requestPermissions(strArr, i);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "requestPermissions", strArr, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void setResult(Object obj, int i, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65563, null, obj, i, intent, str) == null) {
            if (obj instanceof Activity) {
                try {
                    Object readField = FieldUtils.readField(obj, "mProxyActivity");
                    if (readField != null) {
                        MethodUtils.invokeMethod(readField, "setResult", Integer.valueOf(i), intent);
                        return;
                    }
                } catch (Exception unused) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "Cant find mProxyActivity, obj = ".concat(String.valueOf(obj)));
                }
            }
            try {
                MethodUtils.invokeMethod(obj, "setResult", Integer.valueOf(i), intent);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void startActivity(Object obj, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65566, null, obj, intent, str) == null) {
            if (obj instanceof Context) {
                ComponentManager.startActivity((Context) obj, intent, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, WBConstants.SHARE_START_ACTIVITY, intent);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65568, null, obj, intent, i, str) == null) {
            if (obj instanceof Activity) {
                ComponentManager.startActivityForResult((Activity) obj, intent, i, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", intent, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static ComponentName startService(Object obj, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65569, null, obj, intent, str)) == null) {
            if (obj instanceof Context) {
                return ServiceManagerNative.getInstance().startServiceNative((Context) obj, intent, str);
            }
            try {
                return (ComponentName) MethodUtils.invokeMethod(obj, "startService", intent);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (ComponentName) invokeLLL.objValue;
    }

    public static boolean stopService(Object obj, Intent intent, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, obj, intent, str)) == null) {
            if (obj instanceof Context) {
                return ServiceManagerNative.getInstance().stopServiceNative((Context) obj, intent, str);
            }
            try {
                return ((Boolean) MethodUtils.invokeMethod(obj, "stopService", intent)).booleanValue();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void unbindService(Object obj, ServiceConnection serviceConnection, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65571, null, obj, serviceConnection, str) == null) {
            if (obj instanceof Context) {
                ServiceManagerNative.getInstance().unbindServiceNative(serviceConnection);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "unbindService", serviceConnection);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void unregisterReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65572, null, obj, pluginBroadcastReceiver, str) == null) {
            if (obj instanceof Context) {
                ComponentManager.unregisterReceiver((Context) obj, pluginBroadcastReceiver);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "unregisterReceiver", pluginBroadcastReceiver);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static Context wrapperContext(Object obj, String str) {
        InterceptResult invokeLL;
        Context pluginContext;
        Application application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, obj, str)) == null) {
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
            if (hasWrapper(context)) {
                return context;
            }
            if (instanceOfFragmentActivity(obj)) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                try {
                    try {
                        pluginContext = new PluginFragmentActivityWrapper((Activity) obj, new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), false));
                    } catch (Throwable unused) {
                        return context;
                    }
                } catch (Throwable unused2) {
                    pluginContext = (Context) MethodUtils.invokeConstructor(PluginFragmentActivityWrapper.class, new Object[]{obj, new PluginContext((Context) obj, PluginManager.getInstance().getPlugin(str), false)}, new Class[]{fragmentClazz, PluginContext.class});
                }
            } else if (obj instanceof Activity) {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                pluginContext = new PluginActivityWrapper((Activity) obj, new PluginContext(context, PluginManager.getInstance().getPlugin(str), false));
            } else if (obj instanceof Application) {
                pluginContext = new PluginApplicationWrapper((Application) obj, new PluginContext(context, PluginManager.getInstance().getPlugin(str), true));
            } else {
                pluginContext = new PluginContext(context, PluginManager.getInstance().getPlugin(str), false);
            }
            if (pluginContext != null) {
                HashMap<String, WeakReference<Context>> hashMap = contextCache;
                hashMap.put(str + System.identityHashCode(obj), new WeakReference<>(pluginContext));
            }
            return pluginContext;
        }
        return (Context) invokeLL.objValue;
    }

    public static Activity wrapperContext2Activity(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, obj, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, obj, str)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, obj, str)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65577, null, obj, cls, str)) == null) {
            if (!(obj instanceof GeneratePluginActivity) && !(obj instanceof GeneratePluginAppCompatActivity) && (obj instanceof Context)) {
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
        if (interceptable == null || interceptable.invokeLLLL(65565, null, obj, intent, bundle, str) == null) {
            if (obj instanceof Context) {
                ComponentManager.startActivity((Context) obj, intent, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, WBConstants.SHARE_START_ACTIVITY, new Object[]{intent, bundle}, new Class[]{Intent.class, Bundle.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static void startActivityForResult(Object obj, Intent intent, int i, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{obj, intent, Integer.valueOf(i), bundle, str}) == null) {
            if (obj instanceof Activity) {
                ComponentManager.startActivityForResult((Activity) obj, intent, i, bundle, str);
                return;
            }
            try {
                MethodUtils.invokeMethod(obj, "startActivityForResult", new Object[]{intent, Integer.valueOf(i), bundle}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, String str) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65550, null, layoutInflater, i, viewGroup, str)) == null) {
            return inflate(layoutInflater, i, viewGroup, viewGroup != null, str);
        }
        return (View) invokeLILL.objValue;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{obj, pluginBroadcastReceiver, intentFilter, str, handler, str2})) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[4 params]");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, str2);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Intent) invokeCommon.objValue;
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, layoutInflater, xmlPullParser, viewGroup, str)) == null) {
            return inflate(layoutInflater, xmlPullParser, viewGroup, viewGroup != null, str);
        }
        return (View) invokeLLLL.objValue;
    }

    public static void setResult(Object obj, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65564, null, obj, i, str) == null) {
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
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{layoutInflater, xmlPullParser, viewGroup, Boolean.valueOf(z), str})) == null) {
            Context context = layoutInflater.getContext();
            if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
                layoutInflater = (LayoutInflater) wrapperContext(context, str).getSystemService("layout_inflater");
            }
            return layoutInflater.inflate(xmlPullParser, viewGroup, z);
        }
        return (View) invokeCommon.objValue;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{obj, pluginBroadcastReceiver, intentFilter, Integer.valueOf(i), str})) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[3 params]");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, i, str);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Intent) invokeCommon.objValue;
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup, String str) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65549, null, context, i, viewGroup, str)) == null) {
            if (!(context instanceof PluginContext) && !(context instanceof PluginActivityWrapper) && !(context instanceof PluginFragmentActivityWrapper) && !(context instanceof PluginApplicationWrapper)) {
                context = wrapperContext(context, str);
            }
            return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, viewGroup);
        }
        return (View) invokeLILL.objValue;
    }

    public static Intent registerReceiver(Object obj, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{obj, pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i), str2})) == null) {
            if (obj instanceof Context) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "ZeusTransformUtils-registerReceiver-execute[5 params]");
                return ComponentManager.registerReceiver((Context) obj, pluginBroadcastReceiver, intentFilter, str, handler, i, str2);
            }
            try {
                return (Intent) MethodUtils.invokeMethod(obj, "registerReceiver", pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Intent) invokeCommon.objValue;
    }
}
