package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.a.a.a.a.a.a.a;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.dumper.ZwDebug;
import org.chromium.build.BuildHooksAndroid;
/* loaded from: classes2.dex */
public final class DumperService extends Service implements ZeusLogUploader.OnFinishedListener {
    private static final String CALLBACK = "CRASH_CALLBACK";
    private static final String HTTPS = "HTTPS";
    private static final String LOG = "CRASH_FILE";
    private static final String SIGNAL = "CRASH_SIGNAL";
    private static final String TAG = "DumperService";
    private static final String TIME = "CRASH_TIME";
    private static final String TYPE = "LOG_TYPE";
    private String mCallback;
    private int mCrashSignal;
    private long mCrashTime;
    private String mCrashImei = null;
    private ZeusLogUploader mLogUploader = null;

    private boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createConfigurationContext(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 17) {
            return null;
        }
        return !BuildHooksAndroid.isEnabled() ? super.createConfigurationContext(configuration) : BuildHooksAndroid.createConfigurationContext(super.createConfigurationContext(configuration));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets(this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources(this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme(this);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to DumperService.");
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    @Override // com.baidu.webkit.sdk.dumper.ZeusLogUploader.OnFinishedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onFinished(String str, int i, String str2) {
        Object obj;
        Context applicationContext = getApplicationContext();
        if (this.mCallback != null && !this.mCallback.isEmpty()) {
            try {
                obj = Class.forName(this.mCallback).newInstance();
            } catch (Throwable th) {
                a.a(th);
            }
            if (obj != null) {
                ((CrashCallback) obj).onCrash(applicationContext, this.mCrashImei, this.mCrashSignal, this.mCrashTime, str, i, str2);
            }
            Log.d(TAG, "DumperService::onFinished  status=" + i + ", msg=" + str2);
            stopSelf();
        }
        obj = null;
        if (obj != null) {
        }
        Log.d(TAG, "DumperService::onFinished  status=" + i + ", msg=" + str2);
        stopSelf();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf();
        }
        String stringExtra = intent.getStringExtra(TYPE);
        String stringExtra2 = intent.getStringExtra(LOG);
        boolean booleanExtra = intent.getBooleanExtra(HTTPS, true);
        this.mCrashSignal = intent.getIntExtra(SIGNAL, -1);
        this.mCrashTime = intent.getLongExtra(TIME, -1L);
        this.mCallback = intent.getStringExtra(CALLBACK);
        try {
            this.mCrashImei = ((TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        } catch (Exception e) {
            a.a(e);
        }
        this.mCrashImei = this.mCrashImei == null ? "0" : this.mCrashImei;
        if (isNetworkConnected(getApplicationContext())) {
            this.mLogUploader = new ZeusLogUploader(stringExtra, null, booleanExtra);
            ZwDebug.init(this);
            if (this.mLogUploader != null) {
                this.mLogUploader.uploadLogFile(stringExtra2, true, this);
            } else {
                onFinished(stringExtra2, 3, "doUpload Failed, logUploader is null.");
            }
        } else {
            onFinished(stringExtra2, 3, "doUpload Failed, Network is not connected.");
        }
        return 3;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (BuildHooksAndroid.isEnabled()) {
            BuildHooksAndroid.setTheme(this, i);
        } else {
            super.setTheme(i);
        }
    }
}
