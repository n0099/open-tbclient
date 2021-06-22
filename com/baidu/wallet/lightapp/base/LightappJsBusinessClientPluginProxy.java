package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class LightappJsBusinessClientPluginProxy implements NoProguard, ILightappInvoker {

    /* renamed from: a  reason: collision with root package name */
    public static String f24631a = ";";

    /* renamed from: b  reason: collision with root package name */
    public String f24632b = LightappJsBusinessClientPluginProxy.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public Context f24633c;

    /* renamed from: d  reason: collision with root package name */
    public Method f24634d;

    /* renamed from: e  reason: collision with root package name */
    public Object f24635e;

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f24636f;

    public LightappJsBusinessClientPluginProxy(Context context) {
        this.f24633c = context;
        try {
            Class<?> cls = Class.forName("com.baidu.apollon.xplugin.XPluginInvoker");
            this.f24635e = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Class<?> cls2 = Class.forName("com.baidu.apollon.xplugin.XPluginServiceCallback");
            this.f24636f = cls2;
            this.f24634d = cls.getMethod("invokePluginService", Context.class, String.class, String.class, String[].class, cls2);
        } catch (Exception e2) {
            throw new RuntimeException("plugin interface failde", e2);
        }
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        final HashSet hashSet = new HashSet();
        try {
            this.f24634d.invoke(this.f24635e, this.f24633c, "com.baidu.wallet.plugin", "getMethodList", null, Proxy.newProxyInstance(LightappJsBusinessClientPluginProxy.class.getClassLoader(), new Class[]{this.f24636f}, new a(new ILightappInvokerCallback() { // from class: com.baidu.wallet.lightapp.base.LightappJsBusinessClientPluginProxy.1
                @Override // com.baidu.wallet.api.ILightappInvokerCallback
                public void onResult(int i2, String str) {
                    String[] split;
                    if (TextUtils.isEmpty(str) || (split = str.split(LightappJsBusinessClientPluginProxy.f24631a)) == null || split.length <= 0) {
                        return;
                    }
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            hashSet.add(str2);
                        }
                    }
                }
            })));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashSet;
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        try {
            this.f24634d.invoke(this.f24635e, context, "com.baidu.wallet.plugin", "lightappInvoke", new String[]{str}, Proxy.newProxyInstance(LightappJsBusinessClientPluginProxy.class.getClassLoader(), new Class[]{this.f24636f}, new a(iLightappInvokerCallback)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements NoProguard, InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        public ILightappInvokerCallback f24640b;

        public a(ILightappInvokerCallback iLightappInvokerCallback) {
            this.f24640b = iLightappInvokerCallback;
        }

        public void a(String str, String str2) {
            int i2;
            try {
                i2 = Integer.parseInt(str);
            } catch (Throwable unused) {
                i2 = 1;
            }
            ILightappInvokerCallback iLightappInvokerCallback = this.f24640b;
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(i2, str2);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if ("onCallbackSuccess".equals(name)) {
                a((String) objArr[0], (String) objArr[1]);
                return null;
            } else if ("onCallbackFailed".equals(name)) {
                a((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                return null;
            } else {
                return null;
            }
        }

        public void a(String str, int i2, String str2) {
            int i3;
            try {
                i3 = Integer.parseInt(str);
            } catch (Throwable unused) {
                i3 = 1;
            }
            ILightappInvokerCallback iLightappInvokerCallback = this.f24640b;
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(i3, str2);
            }
        }
    }
}
