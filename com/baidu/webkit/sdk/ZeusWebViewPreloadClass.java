package com.baidu.webkit.sdk;

import android.text.TextUtils;
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
/* loaded from: classes8.dex */
public class ZeusWebViewPreloadClass {
    public static final String CLOUD_SETTINGS_KEY = "preload_webview_class";
    public static final int CLOUD_SETTINGS_VALUE_CLOSE = 0;
    public static final int CLOUD_SETTINGS_VALUE_DEFAULT = 1;
    public static final int CLOUD_SETTINGS_VALUE_OPEN = 1;
    public static final String LOG_TAG = "ZeusWebViewPreloadClass";
    public static final String SAVING_CLASSES_FILE_NAME = "zeus_class_saving_file";
    public static final String ZEUS_FILE_DIR = "zeus";
    public static volatile ZeusWebViewPreloadClass sInstance;
    public volatile boolean mStartFlushClassesData;
    public boolean mSwitchEnabled;
    public CopyOnWriteArrayList<String> mZeusClassLoadList;
    public Object mSavingClassesFileLock = new Object();
    public volatile boolean mIsWebkitNeedUnzipSO = true;
    public volatile boolean mIsFirstCheckUpdateFile = true;
    public volatile boolean mIsNeedUpdateSavingClassFile = true;

    public static ZeusWebViewPreloadClass getInstance() {
        if (sInstance == null) {
            synchronized (ZeusWebViewPreloadClass.class) {
                if (sInstance == null) {
                    sInstance = new ZeusWebViewPreloadClass();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSavingClassesFilePath() {
        if (WebViewFactory.getContext() != null) {
            return WebViewFactory.getContext().getFilesDir().getAbsolutePath() + File.separator + ZEUS_FILE_DIR + File.separator + SAVING_CLASSES_FILE_NAME;
        }
        return null;
    }

    private boolean isAbTestEnabled() {
        return true;
    }

    private boolean isCloudSettingsEnabled() {
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue(CLOUD_SETTINGS_KEY);
        if (TextUtils.isEmpty(GetCloudSettingsValue) || Integer.valueOf(GetCloudSettingsValue).intValue() != 0) {
            return true;
        }
        Log.i(LOG_TAG, "cloud switch off");
        return false;
    }

    private boolean isPreloadClassEnabled() {
        if (this.mIsFirstCheckUpdateFile) {
            syncSwitchValuesAtFirstCheck();
        }
        return this.mSwitchEnabled;
    }

    private boolean isSavingClassesFileExist() {
        String str;
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
            } catch (Exception e) {
                str = "isSavingClassesFileExist path: " + savingClassesFilePath + ", hit error=" + e.getMessage();
            }
        }
        Log.i(LOG_TAG, str);
        return false;
    }

    private synchronized void syncSwitchValuesAtFirstCheck() {
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

    public void appendLoadClass(String str) {
        if (!this.mStartFlushClassesData && isNeedUpdateSavingClassFile() && isPreloadClassEnabled()) {
            if (this.mZeusClassLoadList == null) {
                this.mZeusClassLoadList = new CopyOnWriteArrayList<>();
            }
            this.mZeusClassLoadList.add(str);
        }
    }

    public void deleteSavingClassesFile() {
        if (isPreloadClassEnabled()) {
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
                } catch (Exception e) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1018);
                    Log.i(LOG_TAG, "deleteSavingClassesFile path: " + savingClassesFilePath + ", hit error=" + e.getMessage());
                }
            }
        }
    }

    public void destroy() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.mZeusClassLoadList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.mZeusClassLoadList = null;
        }
    }

    public void flushLoadClassesToFile() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (this.mStartFlushClassesData || !isNeedUpdateSavingClassFile() || !isPreloadClassEnabled() || (copyOnWriteArrayList = this.mZeusClassLoadList) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        this.mStartFlushClassesData = true;
        ZeusThreadPoolUtil.execute(new Runnable() { // from class: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.1
            /* JADX WARN: Removed duplicated region for block: B:68:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                synchronized (ZeusWebViewPreloadClass.this.mSavingClassesFileLock) {
                    String savingClassesFilePath = ZeusWebViewPreloadClass.this.getSavingClassesFilePath();
                    if (savingClassesFilePath == null) {
                        return;
                    }
                    BufferedWriter bufferedWriter3 = null;
                    File file3 = null;
                    try {
                        try {
                            file = new File(savingClassesFilePath);
                            try {
                                if (file.exists()) {
                                    file.delete();
                                }
                                file.createNewFile();
                                bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                            } catch (IOException e) {
                                e = e;
                                file2 = file;
                                bufferedWriter = null;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedWriter = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        Iterator it = ZeusWebViewPreloadClass.this.mZeusClassLoadList.iterator();
                        while (it.hasNext()) {
                            bufferedWriter2.write((String) it.next());
                            bufferedWriter2.newLine();
                        }
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        zeusWebViewPreloadClass = ZeusWebViewPreloadClass.this;
                    } catch (IOException e4) {
                        file2 = file;
                        bufferedWriter = bufferedWriter2;
                        e = e4;
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
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                ZeusWebViewPreloadClass.this.destroy();
                                throw th;
                            }
                        }
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        zeusWebViewPreloadClass = ZeusWebViewPreloadClass.this;
                        zeusWebViewPreloadClass.destroy();
                    } catch (Throwable th3) {
                        bufferedWriter3 = bufferedWriter2;
                        th = th3;
                        if (bufferedWriter3 != null) {
                        }
                        ZeusWebViewPreloadClass.this.destroy();
                        throw th;
                    }
                    zeusWebViewPreloadClass.destroy();
                }
            }
        });
    }

    public boolean getIsWebkitNeedUnzipSO() {
        return this.mIsWebkitNeedUnzipSO;
    }

    public boolean isNeedUpdateSavingClassFile() {
        if (this.mIsFirstCheckUpdateFile) {
            syncSwitchValuesAtFirstCheck();
        }
        return this.mIsNeedUpdateSavingClassFile;
    }

    public void preloadZeusWebViewClasses(final ClassLoader classLoader) {
        if (classLoader == null || !(classLoader instanceof ZeusClassLoader) || isNeedUpdateSavingClassFile() || !isPreloadClassEnabled()) {
            return;
        }
        ZeusThreadPoolUtil.execute(new Runnable() { // from class: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.2
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0086 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:69:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                File file;
                ClassNotFoundException e;
                BufferedReader bufferedReader;
                IOException e2;
                Throwable th;
                synchronized (ZeusWebViewPreloadClass.this.mSavingClassesFileLock) {
                    ?? savingClassesFilePath = ZeusWebViewPreloadClass.this.getSavingClassesFilePath();
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
                                                } else if (classLoader != null) {
                                                    classLoader.loadClass(readLine);
                                                }
                                            } catch (IOException e3) {
                                                e2 = e3;
                                                if (file != null) {
                                                    file.delete();
                                                }
                                                e2.printStackTrace();
                                                if (bufferedReader != null) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (IOException e4) {
                                                        e = e4;
                                                        e.printStackTrace();
                                                    }
                                                }
                                            } catch (ClassNotFoundException e5) {
                                                e = e5;
                                                if (file != null) {
                                                    file.delete();
                                                }
                                                e.printStackTrace();
                                                if (bufferedReader != null) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (IOException e6) {
                                                        e = e6;
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
                                        } catch (IOException e7) {
                                            e = e7;
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (IOException e8) {
                                    e2 = e8;
                                    bufferedReader = null;
                                } catch (ClassNotFoundException e9) {
                                    e = e9;
                                    bufferedReader = null;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (savingClassesFilePath != 0) {
                                    try {
                                        savingClassesFilePath.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
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
                    } catch (IOException e11) {
                        file = null;
                        e2 = e11;
                        bufferedReader = null;
                    } catch (ClassNotFoundException e12) {
                        file = null;
                        e = e12;
                        bufferedReader = null;
                    }
                }
            }
        });
    }

    public void setIsWebkitNeedUnzipSO(boolean z) {
        this.mIsWebkitNeedUnzipSO = z;
    }
}
