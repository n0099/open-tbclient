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
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@JNINamespace
/* loaded from: classes.dex */
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static boolean meE;
    private Context mContext;
    private long mNativePtr;
    private b meF;
    private Delegate meG;
    private final Looper mLooper = Looper.myLooper();
    private final Handler mHandler = new Handler(this.mLooper);

    /* loaded from: classes.dex */
    public interface Delegate {
        void dqQ();
    }

    @NativeClassQualifiedName
    private native void nativeProxySettingsChanged(long j);

    @NativeClassQualifiedName
    private native void nativeProxySettingsChangedTo(long j, String str, int i, String str2, String[] strArr);

    static {
        $assertionsDisabled = !ProxyChangeListener.class.desiredAssertionStatus();
        meE = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;
        public final String[] meH;

        public a(String str, int i, String str2, String[] strArr) {
            this.mHost = str;
            this.mPort = i;
            this.mPacUrl = str2;
            this.meH = strArr;
        }
    }

    private ProxyChangeListener(Context context) {
        this.mContext = context;
    }

    @CalledByNative
    public static ProxyChangeListener create(Context context) {
        return new ProxyChangeListener(context);
    }

    @CalledByNative
    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    @CalledByNative
    public void start(long j) {
        assertOnThread();
        if (!$assertionsDisabled && this.mNativePtr != 0) {
            throw new AssertionError();
        }
        this.mNativePtr = j;
        registerReceiver();
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0L;
        unregisterReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.runOnThread(new Runnable() { // from class: com.baidu.turbonet.net.ProxyChangeListener.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ProxyChangeListener.this.a(b.this, b.this.extractNewProxy(intent));
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a extractNewProxy(Intent intent) {
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
                    strArr = ((String) declaredMethod3.invoke(obj, new Object[0])).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    strArr = (String[]) declaredMethod3.invoke(obj, new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                    String str4 = (String) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                    if (!TextUtils.isEmpty(str4)) {
                        return new a(str3, intValue, str4, strArr);
                    }
                } else if (Build.VERSION.SDK_INT >= 21) {
                    Uri uri = (Uri) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                    if (!Uri.EMPTY.equals(uri)) {
                        return new a(str3, intValue, uri.toString(), strArr);
                    }
                }
                return new a(str3, intValue, null, strArr);
            } catch (ClassNotFoundException e) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e2);
                return null;
            } catch (NoSuchMethodException e3) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e3);
                return null;
            } catch (NullPointerException e4) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.e("ProxyChangeListener", "Using no proxy configuration due to exception:" + e5);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, a aVar) {
        if (meE && bVar == this.meF) {
            if (this.meG != null) {
                this.meG.dqQ();
            }
            if (this.mNativePtr != 0) {
                if (aVar != null) {
                    nativeProxySettingsChangedTo(this.mNativePtr, aVar.mHost, aVar.mPort, aVar.mPacUrl, aVar.meH);
                } else {
                    nativeProxySettingsChanged(this.mNativePtr);
                }
            }
        }
    }

    private void registerReceiver() {
        if (this.meF == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PROXY_CHANGE");
            this.meF = new b();
            this.mContext.getApplicationContext().registerReceiver(this.meF, intentFilter);
        }
    }

    private void unregisterReceiver() {
        if (this.meF != null) {
            this.mContext.unregisterReceiver(this.meF);
            this.meF = null;
        }
    }

    private boolean onThread() {
        return this.mLooper == Looper.myLooper();
    }

    private void assertOnThread() {
        if (!onThread()) {
            throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }
}
