package com.baidu.webkit.internal.blink;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.File;
/* loaded from: classes7.dex */
public class EngineManager implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor mEditor;
    public boolean mInstallSyncSuccess;
    public boolean mIsInstalling;
    public final Object mLockObject;
    public SharedPreferences mSp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(994655126, "Lcom/baidu/webkit/internal/blink/EngineManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(994655126, "Lcom/baidu/webkit/internal/blink/EngineManager;");
        }
    }

    public EngineManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLockObject = new Object();
    }

    private a createInstaller(String str, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, webkitInstallListener)) == null) {
            if (str.startsWith("file://")) {
                return new b(str, this, webkitInstallListener);
            }
            return null;
        }
        return (a) invokeLL.objValue;
    }

    private SharedPreferences.Editor getEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.mEditor == null) {
                this.mEditor = getSp().edit();
            }
            return this.mEditor;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public static EngineManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (TAG) {
                if (sInstance == null) {
                    sInstance = new EngineManager();
                }
            }
            return sInstance;
        }
        return (EngineManager) invokeV.objValue;
    }

    private SharedPreferences getSp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (this.mSp == null) {
                Context context = WebKitFactory.getContext();
                String str = ZEUS_PREFER;
                WebKitFactory.getContext();
                this.mSp = context.getSharedPreferences(str, 0);
            }
            return this.mSp;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    private void install(String str, WebKitFactory.WebkitInstallListener webkitInstallListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, this, str, webkitInstallListener, z) == null) {
            if (webkitInstallListener == null) {
                LoadErrorCode.getInstance().addDownloadInfo(1021);
            } else if (str == null) {
                LoadErrorCode.getInstance().addDownloadInfo(1022);
                webkitInstallListener.onInstallFinish(13, null);
            } else if (tryChangeZeusEngine(webkitInstallListener) == 1) {
                LoadErrorCode.getInstance().addDownloadInfo(1023);
            } else if (!str.startsWith("file://")) {
                LoadErrorCode.getInstance().addDownloadInfo(1024);
                webkitInstallListener.onInstallFinish(13, null);
            } else {
                b bVar = new b(str, this, webkitInstallListener);
                if (z) {
                    bVar.a();
                } else {
                    bVar.b();
                }
            }
        }
    }

    private void removeDownloadZeus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
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
    }

    private void resetPref() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
    }

    private String resetRetryInstallZeusSp(boolean z) {
        String retryInstallZeusPath;
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
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
        return (String) invokeZ.objValue;
    }

    private void setInstallFinish(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
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
    }

    private void setInstallStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
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
    }

    private int tryChangeZeusEngine(WebKitFactory.WebkitInstallListener webkitInstallListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, webkitInstallListener)) == null) {
            if (this.mIsInstalling) {
                webkitInstallListener.onInstallFinish(8, null);
                return 1;
            }
            this.mIsInstalling = true;
            resetPref();
            return 0;
        }
        return invokeL.intValue;
    }

    public synchronized boolean available() {
        InterceptResult invokeV;
        boolean hasProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                hasProvider = WebViewFactory.hasProvider();
            }
            return hasProvider;
        }
        return invokeV.booleanValue;
    }

    public boolean checkRetryInstallZeus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return getSp().getInt(ZEUS_INSTALL_RETRY_CNT, 0) < 3;
            } catch (Throwable th) {
                th.printStackTrace();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public String getRetryInstallZeusPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return getSp().getString(ZEUS_INSTALL_PATH, "");
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void installAsync(String str, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, webkitInstallListener) == null) {
            synchronized (this) {
                install(str, webkitInstallListener, false);
            }
        }
    }

    public synchronized boolean installSync(String str, WebKitFactory.WebkitInstallListener webkitInstallListener) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, webkitInstallListener)) == null) {
            synchronized (this) {
                install(str, webkitInstallListener, true);
                z = this.mInstallSyncSuccess;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public boolean isInstallBreak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                boolean z = getSp().getBoolean(ZEUS_INSTALL_FINISH, false);
                Log.i(LOG_TAG, " isInstalled = ".concat(String.valueOf(z)));
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedKillProcess() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public void onInstallFinish(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            Log.i(LOG_TAG, " onInstallFinish");
            synchronized (this.mLockObject) {
                this.mIsInstalling = false;
                this.mInstallSyncSuccess = z;
                setInstallFinish(z);
            }
            WebKitFactory.unLockUpdateZeus();
        }
    }

    public void onInstallStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            WebKitFactory.lockUpdateZeus();
            setInstallStart(str);
            Log.i(LOG_TAG, " onInstallStart");
        }
    }

    public synchronized void removeOldStatisticsFiles(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            synchronized (this) {
                if (context == null) {
                    LoadErrorCode.getInstance().trace(517);
                    return;
                }
                File filesDir = context.getFilesDir();
                if (filesDir != null) {
                    new File(filesDir, "zeus/statistics/error.log").delete();
                }
            }
        }
    }

    public synchronized void removeUnusedFiles(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            synchronized (this) {
                if (context == null) {
                    LoadErrorCode.getInstance().trace(517);
                    return;
                }
                String[] strArr = {"zeus/libs/com.baidu.zeus2.dex", "zeus/libs/com.baidu.zeus2.jar", "zeus/libs/libbaiduwebviewchromium.so", "pagecache.log"};
                File filesDir = context.getFilesDir();
                if (filesDir != null) {
                    for (int i = 0; i < 4; i++) {
                        new File(filesDir, strArr[i]).delete();
                    }
                }
            }
        }
    }

    public void resetRetryInstallZeus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Log.i(LOG_TAG, " resetRetryInstallZeus");
            removeDownloadZeus(resetRetryInstallZeusSp(true));
        }
    }

    public void resetZeus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
                LoadErrorCode.getInstance().trace("516:" + th.toString());
                th.printStackTrace();
            }
        }
    }

    public void setNeedKillProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
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
}
