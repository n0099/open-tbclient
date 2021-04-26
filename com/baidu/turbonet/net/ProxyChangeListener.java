package com.baidu.turbonet.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@JNINamespace
/* loaded from: classes5.dex */
public class ProxyChangeListener {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f23191g = true;

    /* renamed from: a  reason: collision with root package name */
    public final Looper f23192a = Looper.myLooper();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f23193b = new Handler(this.f23192a);

    /* renamed from: c  reason: collision with root package name */
    public long f23194c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23195d;

    /* renamed from: e  reason: collision with root package name */
    public c f23196e;

    /* renamed from: f  reason: collision with root package name */
    public Delegate f23197f;

    /* loaded from: classes5.dex */
    public interface Delegate {
        void a();
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f23198a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23199b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23200c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f23201d;

        public b(String str, int i2, String str2, String[] strArr) {
            this.f23198a = str;
            this.f23199b = i2;
            this.f23200c = str2;
            this.f23201d = strArr;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BroadcastReceiver {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Intent f23202e;

            public a(Intent intent) {
                this.f23202e = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                ProxyChangeListener.this.e(cVar, cVar.extractNewProxy(this.f23202e));
            }
        }

        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b extractNewProxy(Intent intent) {
            String str;
            String str2;
            String[] strArr;
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    str = "android.net.ProxyProperties";
                    str2 = IMTrack.AckBuilder.PROXY_TYPE;
                } else {
                    str = "android.net.ProxyInfo";
                    str2 = "android.intent.extra.PROXY_INFO";
                }
                Object obj = intent.getExtras().get(str2);
                if (obj == null) {
                    return null;
                }
                Class<?> cls = Class.forName(str);
                Method declaredMethod = cls.getDeclaredMethod("getHost", new Class[0]);
                Method declaredMethod2 = cls.getDeclaredMethod("getPort", new Class[0]);
                Method declaredMethod3 = cls.getDeclaredMethod("getExclusionList", new Class[0]);
                String str3 = (String) declaredMethod.invoke(obj, new Object[0]);
                int intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
                if (Build.VERSION.SDK_INT < 21) {
                    strArr = ((String) declaredMethod3.invoke(obj, new Object[0])).split(",");
                } else {
                    strArr = (String[]) declaredMethod3.invoke(obj, new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                    String str4 = (String) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                    if (!TextUtils.isEmpty(str4)) {
                        return new b(str3, intValue, str4, strArr);
                    }
                } else if (Build.VERSION.SDK_INT >= 21) {
                    Uri uri = (Uri) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                    if (!Uri.EMPTY.equals(uri)) {
                        return new b(str3, intValue, uri.toString(), strArr);
                    }
                }
                return new b(str3, intValue, null, strArr);
            } catch (ClassNotFoundException e2) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e2);
                return null;
            } catch (IllegalAccessException e3) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e4);
                return null;
            } catch (NullPointerException e5) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e5);
                return null;
            } catch (InvocationTargetException e6) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e6);
                return null;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.g(new a(intent));
            }
        }
    }

    public ProxyChangeListener(Context context) {
        this.f23195d = context;
    }

    @CalledByNative
    public static ProxyChangeListener create(Context context) {
        return new ProxyChangeListener(context);
    }

    @CalledByNative
    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    @NativeClassQualifiedName
    private native void nativeProxySettingsChanged(long j);

    @NativeClassQualifiedName
    private native void nativeProxySettingsChangedTo(long j, String str, int i2, String str2, String[] strArr);

    public final void c() {
        if (!d()) {
            throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
        }
    }

    public final boolean d() {
        return this.f23192a == Looper.myLooper();
    }

    public final void e(c cVar, b bVar) {
        if (f23191g && cVar == this.f23196e) {
            Delegate delegate = this.f23197f;
            if (delegate != null) {
                delegate.a();
            }
            long j = this.f23194c;
            if (j == 0) {
                return;
            }
            if (bVar != null) {
                nativeProxySettingsChangedTo(j, bVar.f23198a, bVar.f23199b, bVar.f23200c, bVar.f23201d);
            } else {
                nativeProxySettingsChanged(j);
            }
        }
    }

    public final void f() {
        if (this.f23196e != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        this.f23196e = new c();
        this.f23195d.getApplicationContext().registerReceiver(this.f23196e, intentFilter);
    }

    public final void g(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            this.f23193b.post(runnable);
        }
    }

    public final void h() {
        c cVar = this.f23196e;
        if (cVar == null) {
            return;
        }
        this.f23195d.unregisterReceiver(cVar);
        this.f23196e = null;
    }

    @CalledByNative
    public void start(long j) {
        c();
        this.f23194c = j;
        f();
    }

    @CalledByNative
    public void stop() {
        c();
        this.f23194c = 0L;
        h();
    }
}
