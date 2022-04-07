package com.baidu.webkit.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import com.baidu.webkit.sdk.dumper.ZwDebug;
/* loaded from: classes4.dex */
public final class DumperService extends Service implements ZeusLogUploader.OnFinishedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALLBACK = "CRASH_CALLBACK";
    public static final String CRASHLOGENCRYPT = "CRASHLOGENCRYPT";
    public static final String ENCRYPTKEY = "ENCRYPTKEY";
    public static final String HTTPS = "HTTPS";
    public static final String LOG = "CRASH_FILE";
    public static final String SIGNAL = "CRASH_SIGNAL";
    public static final String TAG = "DumperService";
    public static final String TIME = "CRASH_TIME";
    public static final String TYPE = "LOG_TYPE";
    public transient /* synthetic */ FieldHolder $fh;
    public String mCallback;
    public String mCrashImei;
    public boolean mCrashLogFailedEncrypt;
    public int mCrashSignal;
    public long mCrashTime;
    public String mEncryptKey;
    public ZeusLogUploader mLogUploader;

    public DumperService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCrashLogFailedEncrypt = true;
        this.mEncryptKey = "";
    }

    private boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) ? (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true : invokeL.booleanValue;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            throw new UnsupportedOperationException("Cannot bind to DumperService.");
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            System.exit(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    @Override // com.baidu.webkit.sdk.dumper.ZeusLogUploader.OnFinishedListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onFinished(String str, int i, String str2) {
        Object obj;
        ZeusLogUploader zeusLogUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, str2) == null) {
            Context applicationContext = getApplicationContext();
            String str3 = this.mCallback;
            if (str3 != null && !str3.isEmpty()) {
                try {
                    obj = Class.forName(this.mCallback).newInstance();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.mCrashLogFailedEncrypt && i == 3 && (zeusLogUploader = this.mLogUploader) != null && zeusLogUploader.encryptUploadFailedFile(str, true) != 6) {
                    str2 = "Failed to encrypt file.";
                }
                if (obj != null) {
                    ((CrashCallback) obj).onCrash(applicationContext, this.mCrashImei, this.mCrashSignal, this.mCrashTime, str, i, str2);
                }
                Log.d(TAG, "DumperService::onFinished  status=" + i + ", msg=" + str2);
                stopSelf();
            }
            obj = null;
            if (this.mCrashLogFailedEncrypt) {
                str2 = "Failed to encrypt file.";
            }
            if (obj != null) {
            }
            Log.d(TAG, "DumperService::onFinished  status=" + i + ", msg=" + str2);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, intent, i, i2)) == null) {
            if (intent == null) {
                stopSelf();
            }
            String stringExtra = intent.getStringExtra("LOG_TYPE");
            String stringExtra2 = intent.getStringExtra("CRASH_FILE");
            boolean booleanExtra = intent.getBooleanExtra("HTTPS", true);
            this.mCrashSignal = intent.getIntExtra("CRASH_SIGNAL", -1);
            this.mCrashTime = intent.getLongExtra("CRASH_TIME", -1L);
            this.mCallback = intent.getStringExtra("CRASH_CALLBACK");
            this.mCrashLogFailedEncrypt = intent.getBooleanExtra("CRASHLOGENCRYPT", true);
            this.mEncryptKey = intent.getStringExtra("ENCRYPTKEY");
            ZeusLogUploader zeusLogUploader = new ZeusLogUploader(stringExtra, null, booleanExtra);
            this.mLogUploader = zeusLogUploader;
            if (zeusLogUploader != null) {
                ZeusLogUploader.setEncryptKey(this.mEncryptKey);
                ZeusLogUploader.setUploadCrashLogFailedEncrypt(this.mCrashLogFailedEncrypt);
            }
            ZwDebug.init(this);
            try {
                this.mCrashImei = ((TelephonyManager) getSystemService("phone")).getDeviceId();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = this.mCrashImei;
            if (str == null) {
                str = "0";
            }
            this.mCrashImei = str;
            if (!isNetworkConnected(getApplicationContext())) {
                onFinished(stringExtra2, 3, "doUpload Failed, Network is not connected.");
                return 3;
            } else if (!booleanExtra) {
                onFinished(stringExtra2, 3, "doUpload Failed, HTTP is never supported!");
                stopSelf();
                return 0;
            } else {
                ZeusLogUploader zeusLogUploader2 = this.mLogUploader;
                if (zeusLogUploader2 != null) {
                    zeusLogUploader2.uploadLogFile(stringExtra2, true, this);
                } else {
                    onFinished(stringExtra2, 3, "doUpload Failed, logUploader is null.");
                }
                return 3;
            }
        }
        return invokeLII.intValue;
    }
}
