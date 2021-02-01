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
/* loaded from: classes4.dex */
public class ZeusWebViewPreloadClass {
    private static final String CLOUD_SETTINGS_KEY = "preload_webview_class";
    private static final int CLOUD_SETTINGS_VALUE_CLOSE = 0;
    private static final int CLOUD_SETTINGS_VALUE_DEFAULT = 1;
    private static final int CLOUD_SETTINGS_VALUE_OPEN = 1;
    private static final String LOG_TAG = "ZeusWebViewPreloadClass";
    private static final String SAVING_CLASSES_FILE_NAME = "zeus_class_saving_file";
    private static final String ZEUS_FILE_DIR = "zeus";
    private static volatile ZeusWebViewPreloadClass sInstance;
    private volatile boolean mStartFlushClassesData;
    private boolean mSwitchEnabled;
    private CopyOnWriteArrayList<String> mZeusClassLoadList;
    private Object mSavingClassesFileLock = new Object();
    private volatile boolean mIsWebkitNeedUnzipSO = true;
    private volatile boolean mIsFirstCheckUpdateFile = true;
    private volatile boolean mIsNeedUpdateSavingClassFile = true;

    private ZeusWebViewPreloadClass() {
    }

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
        boolean z = false;
        String savingClassesFilePath = getSavingClassesFilePath();
        if (savingClassesFilePath == null) {
            Log.i(LOG_TAG, "isSavingClassesFileExist path=null");
        } else {
            try {
                if (new File(savingClassesFilePath).exists()) {
                    Log.i(LOG_TAG, "isSavingClassesFileExist path exist: " + savingClassesFilePath);
                    z = true;
                } else {
                    Log.i(LOG_TAG, "isSavingClassesFileExist path not exist: " + savingClassesFilePath);
                }
            } catch (Exception e) {
                Log.i(LOG_TAG, "isSavingClassesFileExist path: " + savingClassesFilePath + ", hit error=" + e.getMessage());
            }
        }
        return z;
    }

    private synchronized void syncSwitchValuesAtFirstCheck() {
        boolean z = false;
        synchronized (this) {
            if (this.mIsFirstCheckUpdateFile) {
                this.mSwitchEnabled = isCloudSettingsEnabled() && isAbTestEnabled() && WebViewFactory.isMainAppProcess();
                if (this.mIsWebkitNeedUnzipSO || !isSavingClassesFileExist()) {
                    z = true;
                }
                this.mIsNeedUpdateSavingClassFile = z;
                Log.i(LOG_TAG, "syncSwitchValuesAtFirstCheck mSwitchEnabled=" + this.mSwitchEnabled + ", mIsWebkitNeedUnzipSO=" + this.mIsWebkitNeedUnzipSO + ", isSavingClassesFileExist()=" + isSavingClassesFileExist());
                this.mIsFirstCheckUpdateFile = false;
            }
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
                        Log.i(LOG_TAG, "deleteSavingClassesFile path exist: " + savingClassesFilePath);
                        file.delete();
                    }
                } catch (Exception e) {
                    Log.i(LOG_TAG, "deleteSavingClassesFile path: " + savingClassesFilePath + ", hit error=" + e.getMessage());
                }
            }
        }
    }

    public void destroy() {
        if (this.mZeusClassLoadList != null) {
            this.mZeusClassLoadList.clear();
            this.mZeusClassLoadList = null;
        }
    }

    public void flushLoadClassesToFile() {
        if (this.mStartFlushClassesData || !isNeedUpdateSavingClassFile() || !isPreloadClassEnabled() || this.mZeusClassLoadList == null || this.mZeusClassLoadList.size() <= 0) {
            return;
        }
        this.mStartFlushClassesData = true;
        ZeusThreadPoolUtil.execute(new Runnable() { // from class: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.1
            /* JADX WARN: Removed duplicated region for block: B:52:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                BufferedWriter bufferedWriter;
                File file;
                BufferedWriter bufferedWriter2 = null;
                synchronized (ZeusWebViewPreloadClass.this.mSavingClassesFileLock) {
                    String savingClassesFilePath = ZeusWebViewPreloadClass.this.getSavingClassesFilePath();
                    if (savingClassesFilePath == null) {
                        return;
                    }
                    try {
                        try {
                            file = new File(savingClassesFilePath);
                            try {
                                if (file.exists()) {
                                    file.delete();
                                }
                                file.createNewFile();
                                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                            } catch (IOException e) {
                                e = e;
                                bufferedWriter = null;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedWriter = null;
                            file = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        ZeusWebViewPreloadClass.this.destroy();
                        throw th;
                    }
                    try {
                        try {
                            Iterator it = ZeusWebViewPreloadClass.this.mZeusClassLoadList.iterator();
                            while (it.hasNext()) {
                                bufferedWriter.write((String) it.next());
                                bufferedWriter.newLine();
                            }
                            bufferedWriter.flush();
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            ZeusWebViewPreloadClass.this.destroy();
                        } catch (IOException e5) {
                            e = e5;
                            if (file != null) {
                                file.delete();
                            }
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            ZeusWebViewPreloadClass.this.destroy();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                        }
                        ZeusWebViewPreloadClass.this.destroy();
                        throw th;
                    }
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
            /* JADX WARN: Not initialized variable reg: 3, insn: 0x0083: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:57:0x0083 */
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader;
                File file;
                BufferedReader bufferedReader2;
                BufferedReader bufferedReader3 = null;
                synchronized (ZeusWebViewPreloadClass.this.mSavingClassesFileLock) {
                    String savingClassesFilePath = ZeusWebViewPreloadClass.this.getSavingClassesFilePath();
                    try {
                        if (savingClassesFilePath == null) {
                            return;
                        }
                        try {
                            try {
                                file = new File(savingClassesFilePath);
                                try {
                                    if (file.exists()) {
                                        bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                                        while (true) {
                                            try {
                                                String readLine = bufferedReader2.readLine();
                                                if (readLine == null) {
                                                    break;
                                                } else if (classLoader != null) {
                                                    classLoader.loadClass(readLine);
                                                }
                                            } catch (IOException e) {
                                                e = e;
                                                if (file != null) {
                                                    file.delete();
                                                }
                                                e.printStackTrace();
                                                if (bufferedReader2 != null) {
                                                    try {
                                                        bufferedReader2.close();
                                                    } catch (IOException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                            } catch (ClassNotFoundException e3) {
                                                e = e3;
                                                if (file != null) {
                                                    file.delete();
                                                }
                                                e.printStackTrace();
                                                if (bufferedReader2 != null) {
                                                    try {
                                                        bufferedReader2.close();
                                                    } catch (IOException e4) {
                                                        e4.printStackTrace();
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        bufferedReader2 = null;
                                    }
                                    if (bufferedReader2 != null) {
                                        try {
                                            bufferedReader2.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                } catch (IOException e6) {
                                    e = e6;
                                    bufferedReader2 = null;
                                } catch (ClassNotFoundException e7) {
                                    e = e7;
                                    bufferedReader2 = null;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedReader3 != null) {
                                    try {
                                        bufferedReader3.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            file = null;
                            bufferedReader2 = null;
                        } catch (ClassNotFoundException e10) {
                            e = e10;
                            file = null;
                            bufferedReader2 = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader3 = bufferedReader;
                    }
                }
            }
        });
    }

    public void setIsWebkitNeedUnzipSO(boolean z) {
        this.mIsWebkitNeedUnzipSO = z;
    }
}
