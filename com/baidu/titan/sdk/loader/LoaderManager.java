package com.baidu.titan.sdk.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.internal.util.Closes;
import com.baidu.titan.sdk.internal.util.Files;
import com.baidu.titan.sdk.pm.PatchClassInfo;
import com.baidu.titan.sdk.pm.PatchInstallInfo;
import com.baidu.titan.sdk.pm.PatchMetaInfo;
import com.baidu.titan.sdk.pm.TitanPaths;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorDelegate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.InterceptableDelegate;
import com.baidu.titan.sdk.stat.LoaderTimeStat;
import com.baidu.titan.sdk.verifier.SignatureVerifier;
import com.baidu.titan.sdk.verifier.SignatureVerifierKITKAT;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class LoaderManager {
    public static final boolean DEBUG = false;
    public static final int LOAD_STATE_ERROR_ASYNC_LOAD = -7;
    public static final int LOAD_STATE_ERROR_HEAD_DAMAGE = -2;
    public static final int LOAD_STATE_ERROR_LOAD_FAIL = -5;
    public static final int LOAD_STATE_ERROR_NOPATCH = -1;
    public static final int LOAD_STATE_ERROR_PATCH_INSTALL = -3;
    public static final int LOAD_STATE_ERROR_SIGNATURE_VERIFY_FAIL = -6;
    public static final int LOAD_STATE_ERROR_VERSION_DISMATCH = -4;
    public static final int LOAD_STATE_SUCCESS = 0;
    public static final String PATCH_LOADER = "com.baidu.titan.patch.PatchLoader";
    public static final String TAG = "LoaderManager";
    public static LoaderManager sInstance;
    public final Context mContext;
    public volatile Future<Integer> mLoadFuture;
    public volatile int mLoadState = -1;
    public PatchInstallInfo mPatchInstallInfo;

    public LoaderManager(Context context) {
        this.mContext = context;
    }

    public String getCurrentApkId(Context context) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(TitanConstant.APKID_ASSETS_PATH)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            Closes.closeQuiet((Reader) bufferedReader);
            return readLine;
        } catch (Exception unused2) {
            Closes.closeQuiet((Reader) bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            Closes.closeQuiet((Reader) bufferedReader2);
            throw th;
        }
    }

    private SignatureVerifier getSignatureVerifier(Context context, PatchInstallInfo patchInstallInfo) {
        if (Build.VERSION.SDK_INT <= 19) {
            return new SignatureVerifierKITKAT(context, patchInstallInfo);
        }
        return new SignatureVerifier(context, patchInstallInfo.getPatchFile());
    }

    public static LoaderManager getInstance() {
        LoaderManager loaderManager;
        synchronized (LoaderManager.class) {
            if (sInstance == null) {
                sInstance = new LoaderManager(TitanIniter.getAppContext());
            }
            loaderManager = sInstance;
        }
        return loaderManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitLoad() {
        if (this.mLoadFuture == null) {
            return;
        }
        synchronized (this) {
            if (this.mLoadFuture != null) {
                try {
                    this.mLoadFuture.get();
                    this.mLoadFuture = null;
                } catch (Exception unused) {
                }
            }
        }
    }

    public String getCurrentApkId() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.mContext.getAssets().open(TitanConstant.APKID_ASSETS_PATH)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            String readLine = bufferedReader.readLine();
            Closes.closeQuiet((Reader) bufferedReader);
            return readLine;
        } catch (Exception unused2) {
            Closes.closeQuiet((Reader) bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            Closes.closeQuiet((Reader) bufferedReader);
            throw th;
        }
    }

    public PatchInstallInfo getCurrentPatchInfo() {
        return this.mPatchInstallInfo;
    }

    public int getLoadState() {
        return this.mLoadState;
    }

    public int load() {
        int loadInternal = loadInternal(false);
        this.mLoadState = loadInternal;
        return loadInternal;
    }

    public int loadInTime() {
        int loadInternal = loadInternal(true);
        this.mLoadState = loadInternal;
        return loadInternal;
    }

    private int loadInternal(boolean z) {
        File headFile = TitanPaths.getHeadFile();
        if (!headFile.exists()) {
            return -1;
        }
        LoaderTimeStat loaderTimeStat = LoaderTimeStat.getInstance();
        long currentTimeMillis = System.currentTimeMillis();
        String fileStringContent = Files.getFileStringContent(headFile);
        long currentTimeMillis2 = System.currentTimeMillis();
        loaderTimeStat.readHeadContent = currentTimeMillis2 - currentTimeMillis;
        LoaderHead createFromJson = LoaderHead.createFromJson(fileStringContent);
        long currentTimeMillis3 = System.currentTimeMillis();
        loaderTimeStat.createLoaderHead = currentTimeMillis3 - currentTimeMillis2;
        if (createFromJson != null && !TextUtils.isEmpty(createFromJson.targetId) && !TextUtils.isEmpty(createFromJson.patchHash)) {
            String currentApkId = getCurrentApkId();
            long currentTimeMillis4 = System.currentTimeMillis();
            loaderTimeStat.getApkId = currentTimeMillis4 - currentTimeMillis3;
            if (!createFromJson.targetId.equals(currentApkId)) {
                return -4;
            }
            File patchDir = TitanPaths.getPatchDir(createFromJson.patchHash);
            long currentTimeMillis5 = System.currentTimeMillis();
            loaderTimeStat.getPatchDir = currentTimeMillis5 - currentTimeMillis4;
            final PatchInstallInfo patchInstallInfo = new PatchInstallInfo(patchDir);
            if (patchInstallInfo.exist() && patchInstallInfo.finished()) {
                System.currentTimeMillis();
                patchInstallInfo.shareLock();
                System.currentTimeMillis();
                loaderTimeStat.lock = System.currentTimeMillis() - currentTimeMillis5;
                this.mPatchInstallInfo = patchInstallInfo;
                PatchMetaInfo createFromPatch = PatchMetaInfo.createFromPatch(patchInstallInfo.getPatchFile());
                if (!z && createFromPatch.bootLoadSyncPolicy != 0) {
                    setInterceptorDelegate(PatchClassInfo.createFromPatch(patchInstallInfo.getPatchFile()));
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    this.mLoadFuture = newSingleThreadExecutor.submit(new Callable<Integer>() { // from class: com.baidu.titan.sdk.loader.LoaderManager.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.util.concurrent.Callable
                        public Integer call() throws Exception {
                            int loadPatch = LoaderManager.this.loadPatch(false, patchInstallInfo);
                            LoaderManager.this.mLoadState = loadPatch;
                            return Integer.valueOf(loadPatch);
                        }
                    });
                    newSingleThreadExecutor.shutdown();
                    return -7;
                }
                return loadPatch(z, patchInstallInfo);
            }
            return -3;
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int loadPatch(boolean z, PatchInstallInfo patchInstallInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        int verifySignature = getSignatureVerifier(this.mContext, this.mPatchInstallInfo).verifySignature();
        long currentTimeMillis2 = System.currentTimeMillis();
        LoaderTimeStat loaderTimeStat = LoaderTimeStat.getInstance();
        loaderTimeStat.verifySignature = System.currentTimeMillis() - currentTimeMillis;
        if (verifySignature != 0) {
            return -6;
        }
        String dexPath = patchInstallInfo.getDexPath();
        long currentTimeMillis3 = System.currentTimeMillis();
        loaderTimeStat.getDexPath = currentTimeMillis3 - currentTimeMillis2;
        try {
            DelegateClassLoader delegateClassLoader = new DelegateClassLoader(dexPath, patchInstallInfo.getDexOptDir().getAbsolutePath(), null, Object.class.getClassLoader(), LoaderManager.class.getClassLoader());
            long currentTimeMillis4 = System.currentTimeMillis();
            loaderTimeStat.newClassLoader = currentTimeMillis4 - currentTimeMillis3;
            long currentTimeMillis5 = System.currentTimeMillis();
            loaderTimeStat.waitVerify = currentTimeMillis5 - currentTimeMillis4;
            Class loadClass = delegateClassLoader.loadClass(PATCH_LOADER);
            long currentTimeMillis6 = System.currentTimeMillis();
            loaderTimeStat.loadLoader = currentTimeMillis6 - currentTimeMillis5;
            BaseLoader baseLoader = (BaseLoader) loadClass.newInstance();
            long currentTimeMillis7 = System.currentTimeMillis();
            loaderTimeStat.newLoader = currentTimeMillis7 - currentTimeMillis6;
            if (z) {
                baseLoader.applyInTime();
            } else {
                baseLoader.apply();
            }
            loaderTimeStat.apply = System.currentTimeMillis() - currentTimeMillis7;
            return 0;
        } catch (Throwable th) {
            Log.e("LoaderManager", "[load] uncatched exception", th);
            return -5;
        }
    }

    private void setInterceptorDelegate(final PatchClassInfo patchClassInfo) {
        ClassClinitInterceptorStorage.$ic = new ClassClinitInterceptorDelegate() { // from class: com.baidu.titan.sdk.loader.LoaderManager.2
            @Override // com.baidu.titan.sdk.runtime.ClassClinitInterceptorDelegate
            public boolean waitLoad(int i, String str) {
                if (patchClassInfo.lazyClassNames.contains(str)) {
                    LoaderManager.this.waitLoad();
                    return false;
                }
                return false;
            }
        };
        Iterator<String> it = patchClassInfo.instantClassNames.iterator();
        while (it.hasNext()) {
            String next = it.next();
            InterceptableDelegate interceptableDelegate = new InterceptableDelegate() { // from class: com.baidu.titan.sdk.loader.LoaderManager.3
                @Override // com.baidu.titan.sdk.runtime.InterceptableDelegate
                public boolean waitLoad() {
                    LoaderManager.this.waitLoad();
                    return true;
                }
            };
            try {
                Field declaredField = Class.forName(next).getDeclaredField("$ic");
                declaredField.setAccessible(true);
                declaredField.set(null, interceptableDelegate);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
    }
}
