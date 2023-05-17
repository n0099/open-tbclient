package com.baidu.webkit.internal;

import android.webkit.ValueCallback;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class ApisInteractWithMario implements INoProGuard {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "ApisInteractWithMario";
    public static final ArrayList<Runnable> mPenddingOps = new ArrayList<>();
    public static ApisInteractWithMario sInstance;

    public static void addOnCronetThreadInitializedListener(final ValueCallback<Long> valueCallback) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new Runnable() { // from class: com.baidu.webkit.internal.ApisInteractWithMario.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApisInteractWithMario.addOnCronetThreadInitializedListener(valueCallback);
                    }
                });
            }
            return;
        }
        ApisInteractWithMario impl = getImpl();
        if (impl != null) {
            impl.addOnCronetThreadInitializedListenerImpl(valueCallback);
        } else {
            Log.e(TAG, "Not implemented!");
        }
    }

    public static void clearCrashKey(final String str) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new Runnable() { // from class: com.baidu.webkit.internal.ApisInteractWithMario.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApisInteractWithMario.clearCrashKey(str);
                    }
                });
            }
            return;
        }
        ApisInteractWithMario impl = getImpl();
        if (impl != null) {
            impl.clearCrashKeyImpl(str);
        } else {
            Log.e(TAG, "Not implemented!");
        }
    }

    public static ApisInteractWithMario getImpl() {
        WebViewFactoryProvider provider;
        if (sInstance == null && (provider = WebViewFactory.getProvider()) != null) {
            Object apisInteractWithMario = provider.getApisInteractWithMario();
            if (apisInteractWithMario instanceof ApisInteractWithMario) {
                sInstance = (ApisInteractWithMario) apisInteractWithMario;
            }
        }
        return sInstance;
    }

    public static void initialize() {
        synchronized (mPenddingOps) {
            Iterator<Runnable> it = mPenddingOps.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            mPenddingOps.clear();
        }
    }

    public static void setCrashKeyValue(final String str, final String str2) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new Runnable() { // from class: com.baidu.webkit.internal.ApisInteractWithMario.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApisInteractWithMario.setCrashKeyValue(str, str2);
                    }
                });
            }
            return;
        }
        ApisInteractWithMario impl = getImpl();
        if (impl != null) {
            impl.setCrashKeyValueImpl(str, str2);
        } else {
            Log.e(TAG, "Not implemented!");
        }
    }

    public static void setMessageChannalFunctoinTable(final long j) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new Runnable() { // from class: com.baidu.webkit.internal.ApisInteractWithMario.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApisInteractWithMario.setMessageChannalFunctoinTable(j);
                    }
                });
            }
            return;
        }
        ApisInteractWithMario impl = getImpl();
        if (impl != null) {
            impl.setMessageChannalFunctoinTableImpl(j);
        } else {
            Log.e(TAG, "Not implemented!");
        }
    }

    public abstract void addOnCronetThreadInitializedListenerImpl(ValueCallback<Long> valueCallback);

    public abstract void clearCrashKeyImpl(String str);

    public abstract void setCrashKeyValueImpl(String str, String str2);

    public abstract void setMessageChannalFunctoinTableImpl(long j);
}
