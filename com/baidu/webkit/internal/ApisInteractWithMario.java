package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes19.dex */
public abstract class ApisInteractWithMario implements INoProGuard {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String TAG = "ApisInteractWithMario";
    private static final ArrayList<Runnable> mPenddingOps;
    private static ApisInteractWithMario sInstance;

    static {
        $assertionsDisabled = !ApisInteractWithMario.class.desiredAssertionStatus();
        mPenddingOps = new ArrayList<>();
    }

    public static void clearCrashKey(String str) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new c(str));
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

    private static ApisInteractWithMario getImpl() {
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
        if (!$assertionsDisabled && !WebViewFactory.hasProvider()) {
            throw new AssertionError();
        }
        synchronized (mPenddingOps) {
            Iterator<Runnable> it = mPenddingOps.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            mPenddingOps.clear();
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new b(str, str2));
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

    public static void setMessageChannalFunctoinTable(long j) {
        if (!WebViewFactory.hasProvider()) {
            synchronized (mPenddingOps) {
                mPenddingOps.add(new a(j));
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

    protected abstract void clearCrashKeyImpl(String str);

    protected abstract void setCrashKeyValueImpl(String str, String str2);

    protected abstract void setMessageChannalFunctoinTableImpl(long j);
}
