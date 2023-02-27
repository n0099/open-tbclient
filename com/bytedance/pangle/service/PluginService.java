package com.bytedance.pangle.service;

import android.app.Service;
import android.content.ComponentName;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
/* loaded from: classes7.dex */
public abstract class PluginService extends Service implements a {
    public static final String TAG = "PluginService";

    public Object createActivityManagerProxy() {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new InvocationHandler() { // from class: com.bytedance.pangle.service.PluginService.1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                char c;
                String name = method.getName();
                int hashCode = name.hashCode();
                if (hashCode != 39551382) {
                    if (hashCode != 690954390) {
                        if (hashCode == 1930712422 && name.equals("stopServiceToken")) {
                            c = 0;
                        }
                        c = 65535;
                    } else {
                        if (name.equals("getForegroundServiceType")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (name.equals("setServiceForeground")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c != 0) {
                    if (c != 2) {
                        return null;
                    }
                    return 0;
                }
                com.bytedance.pangle.service.a.a b = com.bytedance.pangle.service.a.a.b();
                PluginService pluginService = PluginService.this;
                return Boolean.valueOf(b.a(new ComponentName(pluginService, pluginService.getClass().getName())));
            }
        });
    }

    @Override // com.bytedance.pangle.service.a
    public void attach(Plugin plugin) {
        boolean z;
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName));
        try {
            FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());
            FieldUtils.writeField(this, "mClassName", getClass().getName());
            FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());
            if (getApplicationInfo().targetSdkVersion < 5) {
                z = true;
            } else {
                z = false;
            }
            FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(z));
        } catch (Exception e) {
            ZeusLogger.e(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
        }
    }
}
