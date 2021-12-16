package com.baidu.webkit.sdk;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class ZeusWebViewPreloadClass {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLOUD_SETTINGS_KEY = "preload_webview_class";
    public static final int CLOUD_SETTINGS_VALUE_CLOSE = 0;
    public static final int CLOUD_SETTINGS_VALUE_DEFAULT = 1;
    public static final int CLOUD_SETTINGS_VALUE_OPEN = 1;
    public static final String LOG_TAG = "ZeusWebViewPreloadClass";
    public static final String SAVING_CLASSES_FILE_NAME = "zeus_class_saving_file";
    public static final String ZEUS_FILE_DIR = "zeus";
    public static volatile ZeusWebViewPreloadClass sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean mIsFirstCheckUpdateFile;
    public volatile boolean mIsNeedUpdateSavingClassFile;
    public volatile boolean mIsWebkitNeedUnzipSO;
    public Object mSavingClassesFileLock;
    public volatile boolean mStartFlushClassesData;
    public boolean mSwitchEnabled;
    public CopyOnWriteArrayList<String> mZeusClassLoadList;

    public ZeusWebViewPreloadClass() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSavingClassesFileLock = new Object();
        this.mIsWebkitNeedUnzipSO = true;
        this.mIsFirstCheckUpdateFile = true;
        this.mIsNeedUpdateSavingClassFile = true;
    }

    public static ZeusWebViewPreloadClass getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sInstance == null) {
                synchronized (ZeusWebViewPreloadClass.class) {
                    if (sInstance == null) {
                        sInstance = new ZeusWebViewPreloadClass();
                    }
                }
            }
            return sInstance;
        }
        return (ZeusWebViewPreloadClass) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSavingClassesFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (WebViewFactory.getContext() != null) {
                return WebViewFactory.getContext().getFilesDir().getAbsolutePath() + File.separator + ZEUS_FILE_DIR + File.separator + SAVING_CLASSES_FILE_NAME;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    private boolean isAbTestEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    private boolean isCloudSettingsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue(CLOUD_SETTINGS_KEY);
            if (TextUtils.isEmpty(GetCloudSettingsValue) || Integer.valueOf(GetCloudSettingsValue).intValue() != 0) {
                return true;
            }
            Log.i(LOG_TAG, "cloud switch off");
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isPreloadClassEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (this.mIsFirstCheckUpdateFile) {
                syncSwitchValuesAtFirstCheck();
            }
            return this.mSwitchEnabled;
        }
        return invokeV.booleanValue;
    }

    private boolean isSavingClassesFileExist() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            String savingClassesFilePath = getSavingClassesFilePath();
            if (savingClassesFilePath == null) {
                str = "isSavingClassesFileExist path=null";
            } else {
                try {
                    if (new File(savingClassesFilePath).exists()) {
                        Log.i(LOG_TAG, "isSavingClassesFileExist path exist: ".concat(String.valueOf(savingClassesFilePath)));
                        return true;
                    }
                    Log.i(LOG_TAG, "isSavingClassesFileExist path not exist: ".concat(String.valueOf(savingClassesFilePath)));
                    return false;
                } catch (Exception e2) {
                    str = "isSavingClassesFileExist path: " + savingClassesFilePath + ", hit error=" + e2.getMessage();
                }
            }
            Log.i(LOG_TAG, str);
            return false;
        }
        return invokeV.booleanValue;
    }

    private synchronized void syncSwitchValuesAtFirstCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this) {
                if (this.mIsFirstCheckUpdateFile) {
                    boolean z = true;
                    this.mSwitchEnabled = isCloudSettingsEnabled() && isAbTestEnabled() && WebViewFactory.isMainAppProcess();
                    if (!this.mIsWebkitNeedUnzipSO && isSavingClassesFileExist()) {
                        z = false;
                    }
                    this.mIsNeedUpdateSavingClassFile = z;
                    Log.i(LOG_TAG, "syncSwitchValuesAtFirstCheck mSwitchEnabled=" + this.mSwitchEnabled + ", mIsWebkitNeedUnzipSO=" + this.mIsWebkitNeedUnzipSO + ", isSavingClassesFileExist()=" + isSavingClassesFileExist());
                    this.mIsFirstCheckUpdateFile = false;
                }
            }
        }
    }

    public void appendLoadClass(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !this.mStartFlushClassesData && isNeedUpdateSavingClassFile() && isPreloadClassEnabled()) {
            if (this.mZeusClassLoadList == null) {
                this.mZeusClassLoadList = new CopyOnWriteArrayList<>();
            }
            this.mZeusClassLoadList.add(str);
        }
    }

    public void deleteSavingClassesFile() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && isPreloadClassEnabled()) {
            synchronized (this.mSavingClassesFileLock) {
                String savingClassesFilePath = getSavingClassesFilePath();
                if (savingClassesFilePath == null) {
                    Log.i(LOG_TAG, "deleteSavingClassesFile path=null");
                    return;
                }
                try {
                    File file = new File(savingClassesFilePath);
                    if (file.exists()) {
                        Log.i(LOG_TAG, "deleteSavingClassesFile path exist: ".concat(String.valueOf(savingClassesFilePath)));
                        file.delete();
                    }
                } catch (Exception e2) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1018);
                    Log.i(LOG_TAG, "deleteSavingClassesFile path: " + savingClassesFilePath + ", hit error=" + e2.getMessage());
                }
            }
        }
    }

    public void destroy() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (copyOnWriteArrayList = this.mZeusClassLoadList) == null) {
            return;
        }
        copyOnWriteArrayList.clear();
        this.mZeusClassLoadList = null;
    }

    public void flushLoadClassesToFile() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mStartFlushClassesData || !isNeedUpdateSavingClassFile() || !isPreloadClassEnabled() || (copyOnWriteArrayList = this.mZeusClassLoadList) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        this.mStartFlushClassesData = true;
        ZeusThreadPoolUtil.execute(new Runnable(this) { // from class: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ZeusWebViewPreloadClass this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX WARN: Removed duplicated region for block: B:73:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                BufferedWriter bufferedWriter;
                ZeusWebViewPreloadClass zeusWebViewPreloadClass;
                File file;
                File file2;
                BufferedWriter bufferedWriter2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0.mSavingClassesFileLock) {
                        String savingClassesFilePath = this.this$0.getSavingClassesFilePath();
                        if (savingClassesFilePath == null) {
                            return;
                        }
                        File file3 = null;
                        BufferedWriter bufferedWriter3 = null;
                        try {
                            try {
                                file = new File(savingClassesFilePath);
                                try {
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    file.createNewFile();
                                    bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                                } catch (IOException e2) {
                                    e = e2;
                                    file2 = file;
                                    bufferedWriter = null;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedWriter = null;
                        }
                        try {
                            Iterator it = this.this$0.mZeusClassLoadList.iterator();
                            while (it.hasNext()) {
                                bufferedWriter2.write((String) it.next());
                                bufferedWriter2.newLine();
                            }
                            bufferedWriter2.flush();
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            zeusWebViewPreloadClass = this.this$0;
                        } catch (IOException e5) {
                            file2 = file;
                            bufferedWriter = bufferedWriter2;
                            e = e5;
                            file3 = file2;
                            if (file3 != null) {
                                try {
                                    file3.delete();
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedWriter3 = bufferedWriter;
                                    if (bufferedWriter3 != null) {
                                        try {
                                            bufferedWriter3.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    this.this$0.destroy();
                                    throw th;
                                }
                            }
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            zeusWebViewPreloadClass = this.this$0;
                            zeusWebViewPreloadClass.destroy();
                        } catch (Throwable th3) {
                            bufferedWriter3 = bufferedWriter2;
                            th = th3;
                            if (bufferedWriter3 != null) {
                            }
                            this.this$0.destroy();
                            throw th;
                        }
                        zeusWebViewPreloadClass.destroy();
                    }
                }
            }
        });
    }

    public boolean getIsWebkitNeedUnzipSO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIsWebkitNeedUnzipSO : invokeV.booleanValue;
    }

    public boolean isNeedUpdateSavingClassFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mIsFirstCheckUpdateFile) {
                syncSwitchValuesAtFirstCheck();
            }
            return this.mIsNeedUpdateSavingClassFile;
        }
        return invokeV.booleanValue;
    }

    public void preloadZeusWebViewClasses(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, classLoader) == null) && classLoader != null && (classLoader instanceof ZeusClassLoader) && !isNeedUpdateSavingClassFile() && isPreloadClassEnabled()) {
            ZeusThreadPoolUtil.execute(new Runnable(this, classLoader) { // from class: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ZeusWebViewPreloadClass this$0;
                public final /* synthetic */ ClassLoader val$zeusClassLoader;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, classLoader};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$zeusClassLoader = classLoader;
                }

                /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x008a */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:73:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r1v8 */
                /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    File file;
                    ClassNotFoundException e2;
                    BufferedReader bufferedReader;
                    IOException e3;
                    Throwable th;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.this$0.mSavingClassesFileLock) {
                            ?? savingClassesFilePath = this.this$0.getSavingClassesFilePath();
                            if (savingClassesFilePath == 0) {
                                return;
                            }
                            BufferedReader bufferedReader2 = null;
                            try {
                                try {
                                    try {
                                        file = new File((String) savingClassesFilePath);
                                        try {
                                            if (file.exists()) {
                                                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                                                while (true) {
                                                    try {
                                                        String readLine = bufferedReader.readLine();
                                                        if (readLine == null) {
                                                            break;
                                                        } else if (this.val$zeusClassLoader != null) {
                                                            this.val$zeusClassLoader.loadClass(readLine);
                                                        }
                                                    } catch (IOException e4) {
                                                        e3 = e4;
                                                        if (file != null) {
                                                            file.delete();
                                                        }
                                                        e3.printStackTrace();
                                                        if (bufferedReader != null) {
                                                            try {
                                                                bufferedReader.close();
                                                            } catch (IOException e5) {
                                                                e = e5;
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    } catch (ClassNotFoundException e6) {
                                                        e2 = e6;
                                                        if (file != null) {
                                                            file.delete();
                                                        }
                                                        e2.printStackTrace();
                                                        if (bufferedReader != null) {
                                                            try {
                                                                bufferedReader.close();
                                                            } catch (IOException e7) {
                                                                e = e7;
                                                                e.printStackTrace();
                                                            }
                                                        }
                                                    }
                                                }
                                                bufferedReader2 = bufferedReader;
                                            }
                                            if (bufferedReader2 != null) {
                                                try {
                                                    bufferedReader2.close();
                                                } catch (IOException e8) {
                                                    e = e8;
                                                    e.printStackTrace();
                                                }
                                            }
                                        } catch (IOException e9) {
                                            e3 = e9;
                                            bufferedReader = null;
                                        } catch (ClassNotFoundException e10) {
                                            e2 = e10;
                                            bufferedReader = null;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (savingClassesFilePath != 0) {
                                            try {
                                                savingClassesFilePath.close();
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    savingClassesFilePath = 0;
                                    if (savingClassesFilePath != 0) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e12) {
                                file = null;
                                e3 = e12;
                                bufferedReader = null;
                            } catch (ClassNotFoundException e13) {
                                file = null;
                                e2 = e13;
                                bufferedReader = null;
                            }
                        }
                    }
                }
            });
        }
    }

    public void setIsWebkitNeedUnzipSO(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIsWebkitNeedUnzipSO = z;
        }
    }
}
