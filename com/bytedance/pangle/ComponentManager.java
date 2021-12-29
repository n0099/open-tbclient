package com.bytedance.pangle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.bytedance.pangle.receiver.c;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class ComponentManager {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> stubString2PluginPkgName;
    public static HashMap<String, String> target2StubActivity;
    public static HashMap<String, String> targetString2PluginPkgName;
    public static HashMap<String, String> targetString2StubActivity;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1914266109, "Lcom/bytedance/pangle/ComponentManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1914266109, "Lcom/bytedance/pangle/ComponentManager;");
                return;
            }
        }
        target2StubActivity = new HashMap<>();
        targetString2StubActivity = new HashMap<>();
        targetString2PluginPkgName = new HashMap<>();
        stubString2PluginPkgName = new HashMap<>();
    }

    public ComponentManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void registerActivity(String str, String str2, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, strArr) == null) || strArr == null) {
            return;
        }
        for (String str3 : strArr) {
            String str4 = targetString2PluginPkgName.get(str3);
            if (str4 != null && TextUtils.equals(str4, str)) {
                throw new RuntimeException(String.format("%s is repeated in %s and %s", str3, str, str4));
            }
            target2StubActivity.put(str3, str2);
            targetString2StubActivity.put(str3, str2);
            targetString2PluginPkgName.put(str3, str);
            stubString2PluginPkgName.put(str2, str);
        }
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, pluginBroadcastReceiver, intentFilter, str)) == null) {
            Zeus.loadPlugin(str);
            if (pluginBroadcastReceiver != null) {
                com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
                if (pluginBroadcastReceiver != null && intentFilter != null && intentFilter.actionsIterator() != null) {
                    com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
                    Intent registerReceiver = context.registerReceiver(aVar, intentFilter);
                    a.f55201b.put(pluginBroadcastReceiver, aVar);
                    a.a(intentFilter, pluginBroadcastReceiver);
                    return registerReceiver;
                }
            }
            return null;
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static void startActivity(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, intent, str) == null) {
            startActivity(context, intent, null, str);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, activity, intent, i2, str) == null) {
            startActivityForResult(activity, intent, i2, null, str);
        }
    }

    public static void unregisterReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver) {
        boolean remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, context, pluginBroadcastReceiver) == null) || pluginBroadcastReceiver == null) {
            return;
        }
        com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
        for (Map.Entry<String, c.a> entry : a.a.entrySet()) {
            c.a value = entry.getValue();
            if (value != null && pluginBroadcastReceiver != null) {
                try {
                    if (value.f55203b.size() > 0 && (remove = value.f55203b.remove(pluginBroadcastReceiver))) {
                        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "unregisterReceiver->[移除Action]:" + value.a + ",receiver.hashCode()=" + pluginBroadcastReceiver.hashCode() + ",是否成功，success:" + remove);
                    }
                } catch (Throwable th) {
                    ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-plugin-receiver->action:" + value.a + "[exception]:", th);
                }
            }
            BroadcastReceiver broadcastReceiver = a.f55201b.get(pluginBroadcastReceiver);
            if (broadcastReceiver != null) {
                try {
                    a.f55202c.remove(Integer.valueOf(broadcastReceiver.hashCode()));
                    a.f55201b.remove(pluginBroadcastReceiver);
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable th2) {
                    ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "unregisterReceiver-移除系统注册的广播发生异常:", th2);
                }
            }
        }
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, intent, bundle, str) == null) {
            if (context instanceof PluginContext) {
                context = ((PluginContext) context).mOriginContext;
            }
            if (intent.getComponent() != null) {
                String className = intent.getComponent().getClassName();
                Zeus.loadPlugin(str);
                String str2 = targetString2StubActivity.get(className);
                if (!TextUtils.isEmpty(str2)) {
                    intent.setComponent(new ComponentName(context, str2));
                    intent.putExtra("targetPlugin", className);
                }
                context.startActivity(intent, bundle);
                return;
            }
            try {
                context.startActivity(intent, bundle);
            } catch (Throwable th) {
                throw new RuntimeException("隐式意图 todo", th);
            }
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{activity, intent, Integer.valueOf(i2), bundle, str}) == null) {
            if (intent.getComponent() != null) {
                String className = intent.getComponent().getClassName();
                Zeus.loadPlugin(str);
                String str2 = targetString2StubActivity.get(className);
                if (!TextUtils.isEmpty(str2)) {
                    intent.setComponent(new ComponentName(activity, str2));
                    intent.putExtra("targetPlugin", className);
                }
                activity.startActivityForResult(intent, i2, bundle);
                return;
            }
            try {
                activity.startActivityForResult(intent, i2, bundle);
            } catch (Throwable th) {
                throw new RuntimeException("隐式意图 todo", th);
            }
        }
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, pluginBroadcastReceiver, intentFilter, str, handler, str2})) == null) {
            Zeus.loadPlugin(str2);
            if (pluginBroadcastReceiver != null) {
                com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
                if (pluginBroadcastReceiver != null && intentFilter != null && intentFilter.actionsIterator() != null) {
                    com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
                    Intent registerReceiver = context.registerReceiver(aVar, intentFilter, str, handler);
                    a.f55201b.put(pluginBroadcastReceiver, aVar);
                    if (handler != null) {
                        a.f55202c.add(Integer.valueOf(aVar.hashCode()));
                    }
                    a.a(intentFilter, pluginBroadcastReceiver);
                    return registerReceiver;
                }
            }
            return null;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, int i2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, pluginBroadcastReceiver, intentFilter, Integer.valueOf(i2), str})) == null) {
            Zeus.loadPlugin(str);
            if (pluginBroadcastReceiver != null) {
                com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
                if (pluginBroadcastReceiver != null && intentFilter != null && intentFilter.actionsIterator() != null && Build.VERSION.SDK_INT >= 26) {
                    com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
                    Intent registerReceiver = context.registerReceiver(aVar, intentFilter, i2);
                    a.f55201b.put(pluginBroadcastReceiver, aVar);
                    a.a(intentFilter, pluginBroadcastReceiver);
                    return registerReceiver;
                }
            }
            return null;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Intent registerReceiver(Context context, PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, pluginBroadcastReceiver, intentFilter, str, handler, Integer.valueOf(i2), str2})) == null) {
            Zeus.loadPlugin(str2);
            if (pluginBroadcastReceiver != null) {
                com.bytedance.pangle.receiver.c a = com.bytedance.pangle.receiver.c.a();
                if (pluginBroadcastReceiver != null && intentFilter != null && intentFilter.actionsIterator() != null && Build.VERSION.SDK_INT >= 26) {
                    com.bytedance.pangle.receiver.a aVar = new com.bytedance.pangle.receiver.a();
                    Intent registerReceiver = context.registerReceiver(aVar, intentFilter, str, handler, i2);
                    a.f55201b.put(pluginBroadcastReceiver, aVar);
                    if (handler != null) {
                        a.f55202c.add(Integer.valueOf(aVar.hashCode()));
                    }
                    a.a(intentFilter, pluginBroadcastReceiver);
                    return registerReceiver;
                }
            }
            return null;
        }
        return (Intent) invokeCommon.objValue;
    }
}
