package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes8.dex */
public final class c {
    public static c d;
    public final Map<String, a> a = new ConcurrentHashMap();
    public final Map<PluginBroadcastReceiver, BroadcastReceiver> b = new ConcurrentHashMap();
    public final Set<Integer> c = new CopyOnWriteArraySet();

    public static c a() {
        if (d == null) {
            synchronized (com.bytedance.pangle.service.a.a.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public String a;
        public final Set<PluginBroadcastReceiver> b = new CopyOnWriteArraySet();

        public final void a(Context context, Intent intent) {
            String str;
            Set<PluginBroadcastReceiver> set = this.b;
            if (set != null && set.size() > 0) {
                for (PluginBroadcastReceiver pluginBroadcastReceiver : this.b) {
                    if (pluginBroadcastReceiver != null) {
                        try {
                            pluginBroadcastReceiver.onReceive(context, intent);
                        } catch (Throwable th) {
                            if (intent != null) {
                                str = intent.getAction();
                            } else {
                                str = "";
                            }
                            ZeusLogger.e(ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + str + "[exception]:", th);
                        }
                    }
                }
            }
        }

        public final void a(PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                ZeusLogger.i(ZeusLogger.TAG_RECEIVER, "plugin-receiver:" + pluginBroadcastReceiver.getClass().getSimpleName() + ",action=" + this.a + "[注册完成]");
                this.b.add(pluginBroadcastReceiver);
            }
        }
    }

    public final void a(Context context, Intent intent) {
        a value;
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            Map<String, a> map = this.a;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, a> entry : this.a.entrySet()) {
                    if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                        ZeusLogger.d(ZeusLogger.TAG_RECEIVER, "action[" + action + "] match success ！ invoke onReceiver");
                        value.a(context, intent);
                    }
                }
            }
        }
    }

    public final void a(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter != null && intentFilter.actionsIterator() != null) {
            Iterator<String> actionsIterator = intentFilter.actionsIterator();
            while (actionsIterator.hasNext()) {
                String next = actionsIterator.next();
                if (next != null) {
                    a aVar = this.a.get(next);
                    if (aVar != null) {
                        aVar.a(pluginBroadcastReceiver);
                    } else {
                        a aVar2 = new a();
                        aVar2.a = next;
                        aVar2.a(pluginBroadcastReceiver);
                        this.a.put(next, aVar2);
                    }
                }
            }
        }
    }
}
