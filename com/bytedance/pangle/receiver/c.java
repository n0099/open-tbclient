package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes11.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f61473d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f61474a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> f61475b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<Integer> f61476c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61474a = new ConcurrentHashMap();
        this.f61475b = new ConcurrentHashMap();
        this.f61476c = new CopyOnWriteArraySet();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61473d == null) {
                synchronized (com.bytedance.pangle.service.a.a.class) {
                    if (f61473d == null) {
                        f61473d = new c();
                    }
                }
            }
            return f61473d;
        }
        return (c) invokeV.objValue;
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61477a;

        /* renamed from: b  reason: collision with root package name */
        public final Set<PluginBroadcastReceiver> f61478b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61478b = new CopyOnWriteArraySet();
        }

        public final void a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pluginBroadcastReceiver) == null) || pluginBroadcastReceiver == null) {
                return;
            }
            ZeusLogger.i(ZeusLogger.TAG_RECEIVER, "plugin-receiver:" + pluginBroadcastReceiver.getClass().getSimpleName() + ",action=" + this.f61477a + "[注册完成]");
            this.f61478b.add(pluginBroadcastReceiver);
        }

        public final void a(Context context, Intent intent) {
            Set<PluginBroadcastReceiver> set;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || (set = this.f61478b) == null || set.size() <= 0) {
                return;
            }
            for (PluginBroadcastReceiver pluginBroadcastReceiver : this.f61478b) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (Throwable th) {
                        String action = intent != null ? intent.getAction() : "";
                        ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + action + "[exception]:", th);
                    }
                }
            }
        }
    }

    public final void a(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intentFilter, pluginBroadcastReceiver) == null) || intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        Iterator<String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            String next = actionsIterator.next();
            if (next != null) {
                a aVar = this.f61474a.get(next);
                if (aVar != null) {
                    aVar.a(pluginBroadcastReceiver);
                } else {
                    a aVar2 = new a();
                    aVar2.f61477a = next;
                    aVar2.a(pluginBroadcastReceiver);
                    this.f61474a.put(next, aVar2);
                }
            }
        }
    }

    public final void a(Context context, Intent intent) {
        a value;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        Map<String, a> map = this.f61474a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, a> entry : this.f61474a.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "action[" + action + "] match success ！ invoke onReceiver");
                value.a(context, intent);
            }
        }
    }
}
