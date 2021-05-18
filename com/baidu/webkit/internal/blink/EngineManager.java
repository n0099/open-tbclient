package com.baidu.webkit.internal.blink;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
/* loaded from: classes5.dex */
public class EngineManager implements INoProGuard {
    public static final String DIFF_FILE_SUBFIX = ".diff";
    public static final String LOG_TAG = "webkitUpdate";
    public static final int MAX_ZEUS_INSTALL_RETRY_CNT = 3;
    public static final String PATCH_FOLDER = "/baidu/zeus/patch/";
    public static final int RET_FAILED = 2;
    public static final int RET_OK = 0;
    public static final int RET_RUNNING = 1;
    public static final String TAG = "EngineManager";
    public static String ZEUS_INSTALL_APP_RESTART = "zeusInstallAppRestart";
    public static String ZEUS_INSTALL_FINISH = "zeusInstallFinish";
    public static String ZEUS_INSTALL_PATH = "zeusFile";
    public static String ZEUS_INSTALL_RETRY_CNT = "zeusInstallRetryCnt";
    public static String ZEUS_INSTALL_START = "zeusInstallStart";
    public static String ZEUS_PREFER = "zeusPreference";
    public static EngineManager sInstance;
    public SharedPreferences.Editor mEditor;
    public boolean mInstallSyncSuccess;
    public boolean mIsInstalling;
    public final Object mLockObject = new Object();
    public SharedPreferences mSp;

    private a createInstaller(String str, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        if (str.startsWith("file://")) {
            return new b(str, this, webkitInstallListener);
        }
        return null;
    }

    private SharedPreferences.Editor getEditor() {
        if (this.mEditor == null) {
            this.mEditor = getSp().edit();
        }
        return this.mEditor;
    }

    public static EngineManager getInstance() {
        synchronized (TAG) {
            if (sInstance == null) {
                sInstance = new EngineManager();
            }
        }
        return sInstance;
    }

    private SharedPreferences getSp() {
        if (this.mSp == null) {
            Context context = WebKitFactory.getContext();
            String str = ZEUS_PREFER;
            WebKitFactory.getContext();
            this.mSp = context.getSharedPreferences(str, 0);
        }
        return this.mSp;
    }

    private void install(String str, WebKitFactory.WebkitInstallListener webkitInstallListener, boolean z) {
        if (webkitInstallListener == null) {
            return;
        }
        if (str == null) {
            webkitInstallListener.onInstallFinish(13, null);
        } else if (tryChangeZeusEngine(webkitInstallListener) == 1) {
        } else {
            if (!str.startsWith("file://")) {
                webkitInstallListener.onInstallFinish(13, null);
                return;
            }
            b bVar = new b(str, this, webkitInstallListener);
            if (z) {
                bVar.a();
            } else {
                bVar.b();
            }
        }
    }

    private void removeDownloadZeus(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                Log.e(LOG_TAG, "removeDownloadZeus zeus download file res = ".concat(String.valueOf(file.delete())));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void resetPref() {
        try {
            getEditor().putBoolean(ZEUS_INSTALL_START, false);
            getEditor().putBoolean(ZEUS_INSTALL_FINISH, false);
            getEditor().commit();
            boolean z = getSp().getBoolean(ZEUS_INSTALL_START, false);
            boolean z2 = getSp().getBoolean(ZEUS_INSTALL_FINISH, false);
            boolean z3 = getSp().getBoolean(ZEUS_INSTALL_APP_RESTART, false);
            Log.i(LOG_TAG, "after clear = " + z + " finish = " + z2 + " restart = " + z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String resetRetryInstallZeusSp(boolean z) {
        String retryInstallZeusPath;
        try {
            synchronized (this.mLockObject) {
                Log.i(LOG_TAG, "resetRetryInstallZeusSp ");
                retryInstallZeusPath = getRetryInstallZeusPath();
                getEditor().remove(ZEUS_INSTALL_PATH);
                getEditor().remove(ZEUS_INSTALL_RETRY_CNT);
                if (z) {
                    getEditor().commit();
                }
            }
            return retryInstallZeusPath;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private void setInstallFinish(boolean z) {
        try {
            synchronized (this.mLockObject) {
                Log.i(LOG_TAG, "setInstallFinish = ".concat(String.valueOf(z)));
                getEditor().putBoolean(ZEUS_INSTALL_APP_RESTART, z);
                getEditor().putBoolean(ZEUS_INSTALL_FINISH, z);
                String resetRetryInstallZeusSp = resetRetryInstallZeusSp(false);
                getEditor().commit();
                removeDownloadZeus(resetRetryInstallZeusSp);
            }
            Log.i(LOG_TAG, "setInstallFinish apply = ".concat(String.valueOf(getSp().getBoolean(ZEUS_INSTALL_FINISH, false))));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void setInstallStart(String str) {
        try {
            synchronized (this.mLockObject) {
                this.mInstallSyncSuccess = false;
                Log.i(LOG_TAG, " setInstall start ");
                getEditor().putBoolean(ZEUS_INSTALL_START, true);
                String retryInstallZeusPath = getRetryInstallZeusPath();
                if (!TextUtils.isEmpty(retryInstallZeusPath)) {
                    getEditor().putInt(ZEUS_INSTALL_RETRY_CNT, getSp().getInt(ZEUS_INSTALL_RETRY_CNT, 0) + 1);
                }
                getEditor().putString(ZEUS_INSTALL_PATH, str);
                getEditor().commit();
                Log.i(LOG_TAG, " setInstall oldPath = ".concat(String.valueOf(retryInstallZeusPath)));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private int tryChangeZeusEngine(WebKitFactory.WebkitInstallListener webkitInstallListener) {
        if (this.mIsInstalling) {
            webkitInstallListener.onInstallFinish(8, null);
            return 1;
        }
        this.mIsInstalling = true;
        resetPref();
        return 0;
    }

    public synchronized boolean available() {
        return WebViewFactory.hasProvider();
    }

    public boolean checkRetryInstallZeus() {
        try {
            return getSp().getInt(ZEUS_INSTALL_RETRY_CNT, 0) < 3;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public String getRetryInstallZeusPath() {
        try {
            return getSp().getString(ZEUS_INSTALL_PATH, "");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized void installAsync(String str, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        install(str, webkitInstallListener, false);
    }

    public synchronized boolean installSync(String str, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        install(str, webkitInstallListener, true);
        return this.mInstallSyncSuccess;
    }

    public boolean isInstallBreak() {
        try {
            boolean z = getSp().getBoolean(ZEUS_INSTALL_START, false);
            boolean z2 = getSp().getBoolean(ZEUS_INSTALL_FINISH, false);
            if (z && !z2) {
                Log.i(LOG_TAG, " install is break ");
                return true;
            } else if (z || !z2) {
                return false;
            } else {
                Log.i(LOG_TAG, " install is break ");
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isInstalled() {
        try {
            boolean z = getSp().getBoolean(ZEUS_INSTALL_FINISH, false);
            Log.i(LOG_TAG, " isInstalled = ".concat(String.valueOf(z)));
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isNeedKillProcess() {
        boolean z;
        try {
            synchronized (this.mLockObject) {
                z = getSp().getBoolean(ZEUS_INSTALL_APP_RESTART, false);
                Log.i(LOG_TAG, "setNeedKillProcess = ".concat(String.valueOf(z)));
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void onInstallFinish(boolean z) {
        Log.i(LOG_TAG, " onInstallFinish");
        synchronized (this.mLockObject) {
            this.mIsInstalling = false;
            this.mInstallSyncSuccess = z;
            setInstallFinish(z);
        }
        WebKitFactory.unLockUpdateZeus();
    }

    public void onInstallStart(String str) {
        WebKitFactory.lockUpdateZeus();
        setInstallStart(str);
        Log.i(LOG_TAG, " onInstallStart");
    }

    public synchronized void removeOldStatisticsFiles(Context context) {
        if (context == null) {
            return;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            new File(filesDir, "zeus/statistics/error.log").delete();
        }
    }

    public synchronized void removeUnusedFiles(Context context) {
        if (context == null) {
            return;
        }
        String[] strArr = {"zeus/libs/com.baidu.zeus2.dex", "zeus/libs/com.baidu.zeus2.jar", "zeus/libs/libbaiduwebviewchromium.so", "pagecache.log"};
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            for (int i2 = 0; i2 < 4; i2++) {
                new File(filesDir, strArr[i2]).delete();
            }
        }
    }

    public void resetRetryInstallZeus() {
        Log.i(LOG_TAG, " resetRetryInstallZeus");
        removeDownloadZeus(resetRetryInstallZeusSp(true));
    }

    public void resetZeus() {
        try {
            String downloadLibPath = UtilsBlink.getDownloadLibPath(WebKitFactory.getContext());
            for (String str : GlobalConstants.LIB_ZEUS_SO) {
                String str2 = downloadLibPath + str;
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                    Log.i(LOG_TAG, "delete update so ".concat(String.valueOf(str2)));
                }
            }
            resetPref();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setNeedKillProcess(boolean z) {
        try {
            synchronized (this.mLockObject) {
                Log.i(LOG_TAG, "setNeedKillProcess = ".concat(String.valueOf(z)));
                getEditor().putBoolean(ZEUS_INSTALL_APP_RESTART, z);
                getEditor().commit();
            }
            Log.i(LOG_TAG, "setNeedKillProcess after apply = ".concat(String.valueOf(getSp().getBoolean(ZEUS_INSTALL_APP_RESTART, false))));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
