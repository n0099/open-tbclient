package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.dumper.ZwDebug;
/* loaded from: classes11.dex */
public final class DumperService extends Service implements ZeusLogUploader.OnFinishedListener {
    private static final String CALLBACK = "CRASH_CALLBACK";
    private static final String CRASHLOGENCRYPT = "CRASHLOGENCRYPT";
    private static final String ENCRYPTKEY = "ENCRYPTKEY";
    private static final String HTTPS = "HTTPS";
    private static final String LOG = "CRASH_FILE";
    private static final String SIGNAL = "CRASH_SIGNAL";
    private static final String TAG = "DumperService";
    private static final String TIME = "CRASH_TIME";
    private static final String TYPE = "LOG_TYPE";
    private String mCallback;
    private String mCrashImei;
    private int mCrashSignal;
    private long mCrashTime;
    private ZeusLogUploader mLogUploader;
    private boolean mCrashLogFailedEncrypt = true;
    private String mEncryptKey = "";

    private boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
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

    @Override // com.baidu.webkit.sdk.dumper.ZeusLogUploader.OnFinishedListener
    public final void onFinished(String str, int i, String str2) {
        Context applicationContext = getApplicationContext();
        Object obj = null;
        if (this.mCallback != null && !this.mCallback.isEmpty()) {
            try {
                obj = Class.forName(this.mCallback).newInstance();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        String str3 = (!this.mCrashLogFailedEncrypt || i != 3 || this.mLogUploader == null || this.mLogUploader.encryptUploadFailedFile(str, true) == 6) ? str2 : "Failed to encrypt file.";
        if (obj != null) {
            ((CrashCallback) obj).onCrash(applicationContext, this.mCrashImei, this.mCrashSignal, this.mCrashTime, str, i, str3);
        }
        Log.d(TAG, "DumperService::onFinished  status=" + i + ", msg=" + str3);
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
        this.mCrashLogFailedEncrypt = intent.getBooleanExtra(CRASHLOGENCRYPT, true);
        this.mEncryptKey = intent.getStringExtra(ENCRYPTKEY);
        this.mLogUploader = new ZeusLogUploader(stringExtra, null, booleanExtra);
        if (this.mLogUploader != null) {
            ZeusLogUploader.setEncryptKey(this.mEncryptKey);
            ZeusLogUploader.setUploadCrashLogFailedEncrypt(this.mCrashLogFailedEncrypt);
        }
        ZwDebug.init(this);
        try {
            this.mCrashImei = ((TelephonyManager) getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mCrashImei = this.mCrashImei == null ? "0" : this.mCrashImei;
        if (!isNetworkConnected(getApplicationContext())) {
            onFinished(stringExtra2, 3, "doUpload Failed, Network is not connected.");
            return 3;
        } else if (!booleanExtra) {
            onFinished(stringExtra2, 3, "doUpload Failed, HTTP is never supported!");
            stopSelf();
            return 0;
        } else {
            if (this.mLogUploader != null) {
                this.mLogUploader.uploadLogFile(stringExtra2, true, this);
            } else {
                onFinished(stringExtra2, 3, "doUpload Failed, logUploader is null.");
            }
            return 3;
        }
    }
}
