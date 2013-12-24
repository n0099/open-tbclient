package com.baidu.zeus;

import android.content.Context;
import android.os.FileUtils;
import android.util.Log;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.zeus.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class CacheManager {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static long CACHE_EXPIRE_TIME = 0;
    private static long CACHE_EXPIRE_TIME_ONDDAY = 0;
    private static long CACHE_EXPIRE_TIME_ONEWEEK = 0;
    static long CACHE_MAX_SIZE = 0;
    private static long CACHE_THRESHOLD = 0;
    private static long CACHE_TRIM_AMOUNT = 0;
    static final String HEADER_KEY_IFMODIFIEDSINCE = "if-modified-since";
    static final String HEADER_KEY_IFNONEMATCH = "if-none-match";
    private static final String LOGTAG = "cache";
    private static final String MANIFEST_MIME = "text/cache-manifest";
    private static final String MAX_AGE = "max-age";
    private static final String NO_CACHE = "no-cache";
    private static final String NO_STORE = "no-store";
    private static final int TRIM_CACHE_INTERVAL = 5;
    private static File mBaseDir;
    private static boolean mClearCacheOnInit;
    private static WebViewDatabase mDataBase;
    private static boolean mDisabled;
    private static int mRefCount;
    private static int mTrimCacheCount;

    private static native CacheResult nativeGetCacheResult(String str);

    static {
        $assertionsDisabled = !CacheManager.class.desiredAssertionStatus();
        CACHE_THRESHOLD = 10485760L;
        CACHE_TRIM_AMOUNT = 2097152L;
        CACHE_MAX_SIZE = (CACHE_THRESHOLD - CACHE_TRIM_AMOUNT) / 2;
        mTrimCacheCount = 0;
        mClearCacheOnInit = false;
        CACHE_EXPIRE_TIME = 259200000L;
        CACHE_EXPIRE_TIME_ONEWEEK = 604800000L;
        CACHE_EXPIRE_TIME_ONDDAY = 86400000L;
    }

    /* loaded from: classes.dex */
    public class CacheResult {
        long contentLength;
        String contentdisposition;
        String crossDomain;
        String encoding;
        String etag;
        long expires;
        String expiresString;
        int httpStatusCode;
        InputStream inStream;
        String lastModified;
        String localPath;
        String location;
        String mimeType;
        File outFile;
        OutputStream outStream;

        public int getHttpStatusCode() {
            return this.httpStatusCode;
        }

        public long getContentLength() {
            return this.contentLength;
        }

        public String getLocalPath() {
            return this.localPath;
        }

        public long getExpires() {
            return this.expires;
        }

        public String getExpiresString() {
            return this.expiresString;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public String getETag() {
            return this.etag;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public String getLocation() {
            return this.location;
        }

        public String getEncoding() {
            return this.encoding;
        }

        public String getContentDisposition() {
            return this.contentdisposition;
        }

        public InputStream getInputStream() {
            return this.inStream;
        }

        public OutputStream getOutputStream() {
            return this.outStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.inStream = inputStream;
        }

        public void setEncoding(String str) {
            this.encoding = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        if (JniUtil.useChromiumHttpStack()) {
            mBaseDir = new File(context.getCacheDir(), "webviewCacheChromiumStaging");
            if (!mBaseDir.exists()) {
                mBaseDir.mkdirs();
            }
            JniUtil.setContext(context);
            return;
        }
        mDataBase = WebViewDatabase.getInstance(context.getApplicationContext());
        mBaseDir = new File(context.getCacheDir(), "webviewCache");
        if (createCacheDirectory() && mClearCacheOnInit) {
            removeAllCacheFiles();
            mClearCacheOnInit = false;
        }
    }

    private static boolean createCacheDirectory() {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            if (mBaseDir.exists()) {
                return false;
            }
            if (!mBaseDir.mkdirs()) {
                Log.w(LOGTAG, "Unable to create webviewCache directory");
                return false;
            }
            FileUtils.setPermissions(mBaseDir.toString(), BdWebErrorView.ERROR_CODE_505, -1, -1);
            WebViewWorker.getHandler().sendEmptyMessage(109);
            return true;
        }
        throw new AssertionError();
    }

    public static File getCacheFileBaseDir() {
        return mBaseDir;
    }

    static void setCacheDisabled(boolean z) {
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        if (z != mDisabled) {
            mDisabled = z;
            if (mDisabled) {
                removeAllCacheFiles();
            }
        }
    }

    public static boolean cacheDisabled() {
        return mDisabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean enableTransaction() {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            int i = mRefCount + 1;
            mRefCount = i;
            if (i == 1) {
                mDataBase.startCacheTransaction();
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean disableTransaction() {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            int i = mRefCount - 1;
            mRefCount = i;
            if (i == 0) {
                mDataBase.endCacheTransaction();
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean startTransaction() {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            return mDataBase.startCacheTransaction();
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean endTransaction() {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            boolean endCacheTransaction = mDataBase.endCacheTransaction();
            int i = mTrimCacheCount + 1;
            mTrimCacheCount = i;
            if (i >= 5) {
                mTrimCacheCount = 0;
                trimCacheIfNeeded();
            }
            return endCacheTransaction;
        }
        throw new AssertionError();
    }

    @Deprecated
    public static boolean startCacheTransaction() {
        return false;
    }

    @Deprecated
    public static boolean endCacheTransaction() {
        return false;
    }

    public static CacheResult getCacheFile(String str, Map<String, String> map) {
        return getCacheFile(str, 0L, map, WebView.PageType.NormalType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CacheResult getCacheFile(String str, long j, Map<String, String> map, WebView.PageType pageType) {
        if (mDisabled || mBaseDir == null) {
            return null;
        }
        if (JniUtil.useChromiumHttpStack()) {
            CacheResult nativeGetCacheResult = nativeGetCacheResult(str);
            if (nativeGetCacheResult != null) {
                try {
                    nativeGetCacheResult.inStream = new FileInputStream(new File(mBaseDir, nativeGetCacheResult.localPath));
                    return nativeGetCacheResult;
                } catch (FileNotFoundException e) {
                    Log.v(LOGTAG, "getCacheFile(): Failed to open file: " + e);
                    return null;
                }
            }
            return null;
        }
        String databaseKey = getDatabaseKey(str, j, pageType);
        CacheResult cacheResult = mDataBase.getCacheResult(databaseKey);
        if (cacheResult == null) {
            cacheResult = mDataBase.getCache(databaseKey);
        }
        if (cacheResult != null) {
            if (cacheResult.contentLength == 0) {
                if (!checkCacheRedirect(cacheResult.httpStatusCode)) {
                    mDataBase.removeCache(databaseKey);
                    return null;
                }
            } else {
                try {
                    cacheResult.inStream = new FileInputStream(new File(mBaseDir, cacheResult.localPath));
                } catch (FileNotFoundException e2) {
                    mDataBase.removeCache(databaseKey);
                    return null;
                }
            }
            if (map != null && cacheResult.expires >= 0 && cacheResult.expires <= System.currentTimeMillis()) {
                if (cacheResult.lastModified == null && cacheResult.etag == null) {
                    return null;
                }
                if (cacheResult.etag != null) {
                    map.put(HEADER_KEY_IFNONEMATCH, cacheResult.etag);
                }
                if (cacheResult.lastModified != null) {
                    map.put(HEADER_KEY_IFMODIFIEDSINCE, cacheResult.lastModified);
                }
            }
            return cacheResult;
        }
        return null;
    }

    public static CacheResult getCacheResult(String str, long j, WebView.PageType pageType) {
        return mDataBase.getCacheResult(getDatabaseKey(str, j, pageType));
    }

    public static CacheResult createCacheFile(String str, int i, Headers headers, String str2, boolean z) {
        if (JniUtil.useChromiumHttpStack()) {
            return null;
        }
        return createCacheFile(str, i, headers, str2, 0L, z, WebView.PageType.NormalType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CacheResult createCacheFile(String str, int i, Headers headers, String str2, long j, boolean z, WebView.PageType pageType) {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            if (z || !mDisabled) {
                String databaseKey = getDatabaseKey(str, j, pageType);
                if (i == 303) {
                    mDataBase.removeCache(databaseKey);
                    return null;
                } else if (checkCacheRedirect(i) && !headers.getSetCookie().isEmpty()) {
                    mDataBase.removeCache(databaseKey);
                    return null;
                } else {
                    CacheResult parseHeaders = parseHeaders(i, headers, str2, pageType);
                    if (parseHeaders == null) {
                        mDataBase.removeCache(databaseKey);
                    } else {
                        setupFiles(databaseKey, parseHeaders);
                        try {
                            parseHeaders.outStream = new FileOutputStream(parseHeaders.outFile);
                        } catch (FileNotFoundException e) {
                            if (!createCacheDirectory()) {
                                return null;
                            }
                            try {
                                parseHeaders.outStream = new FileOutputStream(parseHeaders.outFile);
                            } catch (FileNotFoundException e2) {
                                return null;
                            }
                        }
                        parseHeaders.mimeType = str2;
                        if (pageType == WebView.PageType.DesktopType) {
                            parseHeaders.lastModified = System.currentTimeMillis() + "";
                            parseHeaders.expires = System.currentTimeMillis() + CACHE_EXPIRE_TIME_ONDDAY;
                        }
                    }
                    return parseHeaders;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public static void saveCacheFile(String str, CacheResult cacheResult) {
        saveCacheFile(str, 0L, cacheResult, WebView.PageType.NormalType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveCacheFile(String str, long j, CacheResult cacheResult, WebView.PageType pageType) {
        try {
            cacheResult.outStream.close();
            if (JniUtil.useChromiumHttpStack() && !$assertionsDisabled) {
                throw new AssertionError();
            }
            if (cacheResult.outFile.exists()) {
                boolean checkCacheRedirect = checkCacheRedirect(cacheResult.httpStatusCode);
                if (checkCacheRedirect) {
                    cacheResult.contentLength = 0L;
                    cacheResult.localPath = "";
                }
                if ((checkCacheRedirect || cacheResult.contentLength == 0) && !cacheResult.outFile.delete()) {
                    Log.e(LOGTAG, cacheResult.outFile.getPath() + " delete failed.");
                }
                if (cacheResult.contentLength != 0) {
                    mDataBase.addCache(getDatabaseKey(str, j, pageType), cacheResult);
                }
            }
        } catch (IOException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void insertAfterPageFinish() {
        mDataBase.insertCacheDateList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean cleanupCacheFile(CacheResult cacheResult) {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            try {
                cacheResult.outStream.close();
                return cacheResult.outFile.delete();
            } catch (IOException e) {
                return false;
            }
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean removeAllCacheFiles() {
        if (mBaseDir == null) {
            if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
                throw new AssertionError();
            }
            mClearCacheOnInit = true;
        } else {
            if (!JniUtil.useChromiumHttpStack()) {
                WebViewWorker.getHandler().sendEmptyMessage(109);
            }
            new Thread(new Runnable() { // from class: com.baidu.zeus.CacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    try {
                        String[] list = CacheManager.mBaseDir.list();
                        if (list != null) {
                            for (String str : list) {
                                if (!new File(CacheManager.mBaseDir, str).delete()) {
                                    Log.e(CacheManager.LOGTAG, file.getPath() + " delete failed.");
                                }
                            }
                        }
                    } catch (SecurityException e) {
                    }
                }
            }).start();
        }
        return true;
    }

    public static boolean removeAllImageCache() {
        if (mBaseDir != null) {
            new Thread(new Runnable() { // from class: com.baidu.zeus.CacheManager.2
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    ArrayList<String> allImageCachePaths = CacheManager.mDataBase.allImageCachePaths();
                    int size = allImageCachePaths.size();
                    for (int i = 0; i < size; i++) {
                        if (!new File(CacheManager.mBaseDir, allImageCachePaths.get(i)).delete()) {
                            Log.v(CacheManager.LOGTAG, file.getPath() + " delete failed.");
                        }
                    }
                }
            }).start();
        }
        return true;
    }

    static boolean cacheEmpty() {
        return mDataBase.hasCache();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void trimCacheIfNeeded() {
        String[] list;
        File file;
        File file2;
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        if (mDataBase.getCacheTotalSize() > CACHE_THRESHOLD) {
            List<String> trimCache = mDataBase.trimCache(CACHE_TRIM_AMOUNT);
            int size = trimCache.size();
            for (int i = 0; i < size; i++) {
                if (!new File(mBaseDir, trimCache.get(i)).delete()) {
                    Log.e(LOGTAG, file2.getPath() + " delete failed.");
                }
            }
            final List<String> allCacheFileNames = mDataBase.getAllCacheFileNames();
            if (allCacheFileNames != null && (list = mBaseDir.list(new FilenameFilter() { // from class: com.baidu.zeus.CacheManager.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file3, String str) {
                    return !allCacheFileNames.contains(str);
                }
            })) != null) {
                for (String str : list) {
                    if (!new File(mBaseDir, str).delete()) {
                        Log.e(LOGTAG, file.getPath() + " delete failed.");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearCache() {
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        mDataBase.clearCache();
    }

    private static boolean checkCacheRedirect(int i) {
        return i == 301 || i == 302 || i == 307;
    }

    private static String getDatabaseKey(String str, long j, WebView.PageType pageType) {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            if (j != 0) {
                if (WebView.PageType.DesktopType == pageType) {
                    if (j == -1) {
                        return "A" + str;
                    }
                    if (j == -2) {
                        return "B" + str;
                    }
                }
                return j + str;
            }
            return str;
        }
        throw new AssertionError();
    }

    private static void setupFiles(String str, CacheResult cacheResult) {
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        int hashCode = str.hashCode();
        StringBuffer stringBuffer = new StringBuffer(8);
        appendAsHex(hashCode, stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        File file = new File(mBaseDir, stringBuffer2);
        boolean z = true;
        while (true) {
            if (!file.exists()) {
                break;
            }
            if (z) {
                CacheResult cache = mDataBase.getCache(str);
                if (cache != null && cache.contentLength > 0) {
                    if (stringBuffer2.equals(cache.localPath)) {
                        stringBuffer2 = cache.localPath;
                    } else {
                        stringBuffer2 = cache.localPath;
                        file = new File(mBaseDir, stringBuffer2);
                    }
                } else {
                    z = false;
                }
            }
            StringBuffer stringBuffer3 = new StringBuffer(8);
            hashCode++;
            appendAsHex(hashCode, stringBuffer3);
            stringBuffer2 = stringBuffer3.toString();
            file = new File(mBaseDir, stringBuffer2);
        }
        cacheResult.localPath = stringBuffer2;
        cacheResult.outFile = file;
    }

    private static void appendAsHex(int i, StringBuffer stringBuffer) {
        if (!$assertionsDisabled && JniUtil.useChromiumHttpStack()) {
            throw new AssertionError();
        }
        String hexString = Integer.toHexString(i);
        switch (hexString.length()) {
            case 1:
                stringBuffer.append("0000000");
                break;
            case 2:
                stringBuffer.append("000000");
                break;
            case 3:
                stringBuffer.append("00000");
                break;
            case 4:
                stringBuffer.append("0000");
                break;
            case 5:
                stringBuffer.append("000");
                break;
            case 6:
                stringBuffer.append("00");
                break;
            case 7:
                stringBuffer.append(SocialConstants.FALSE);
                break;
        }
        stringBuffer.append(hexString);
    }

    private static CacheResult parseHeaders(int i, Headers headers, String str, WebView.PageType pageType) {
        if ($assertionsDisabled || !JniUtil.useChromiumHttpStack()) {
            if (headers.getContentLength() <= CACHE_MAX_SIZE && !MANIFEST_MIME.equals(str)) {
                CacheResult cacheResult = new CacheResult();
                cacheResult.httpStatusCode = i;
                String location = headers.getLocation();
                if (location != null) {
                    cacheResult.location = location;
                }
                cacheResult.expires = -1L;
                cacheResult.expiresString = headers.getExpires();
                if (cacheResult.expiresString != null) {
                    try {
                        cacheResult.expires = AndroidHttpClient.parseDate(cacheResult.expiresString);
                    } catch (IllegalArgumentException e) {
                        if ("-1".equals(cacheResult.expiresString) || SocialConstants.FALSE.equals(cacheResult.expiresString)) {
                            cacheResult.expires = 0L;
                        } else {
                            Log.e(LOGTAG, "illegal expires: " + cacheResult.expiresString);
                        }
                    }
                }
                String contentDisposition = headers.getContentDisposition();
                if (contentDisposition != null) {
                    cacheResult.contentdisposition = contentDisposition;
                }
                String xPermittedCrossDomainPolicies = headers.getXPermittedCrossDomainPolicies();
                if (xPermittedCrossDomainPolicies != null) {
                    cacheResult.crossDomain = xPermittedCrossDomainPolicies;
                }
                String lastModified = headers.getLastModified();
                if (lastModified != null && lastModified.length() > 0) {
                    cacheResult.lastModified = lastModified;
                }
                String etag = headers.getEtag();
                if (etag != null && etag.length() > 0) {
                    cacheResult.etag = etag;
                }
                String cacheControl = headers.getCacheControl();
                if (cacheControl != null) {
                    String[] split = cacheControl.toLowerCase().split("[ ,;]");
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (NO_STORE.equals(split[i2])) {
                            return null;
                        }
                        if (NO_CACHE.equals(split[i2])) {
                            cacheResult.expires = 0L;
                        } else if (split[i2].startsWith(MAX_AGE)) {
                            int indexOf = split[i2].indexOf(61);
                            if (indexOf < 0) {
                                indexOf = split[i2].indexOf(58);
                            }
                            if (indexOf > 0) {
                                String substring = split[i2].substring(indexOf + 1);
                                try {
                                    long parseLong = Long.parseLong(substring);
                                    if (parseLong >= 0) {
                                        cacheResult.expires = (parseLong * 1000) + System.currentTimeMillis();
                                    }
                                } catch (NumberFormatException e2) {
                                    if ("1d".equals(substring)) {
                                        cacheResult.expires = System.currentTimeMillis() + 86400000;
                                    } else {
                                        Log.e(LOGTAG, "exception in parseHeaders for max-age:" + split[i2].substring(indexOf + 1));
                                        cacheResult.expires = 0L;
                                    }
                                }
                            }
                        }
                    }
                }
                if (NO_CACHE.equals(headers.getPragma())) {
                    cacheResult.expires = 0L;
                }
                if (cacheResult.expires == -1) {
                    if (cacheResult.httpStatusCode == 301) {
                        cacheResult.expires = Long.MAX_VALUE;
                    } else if (cacheResult.httpStatusCode == 302 || cacheResult.httpStatusCode == 307) {
                        cacheResult.expires = 0L;
                    } else if (cacheResult.lastModified == null) {
                        if (str.startsWith("image/jpeg") || str.startsWith("image/png") || str.startsWith("image/gif") || str.startsWith("image/bmp")) {
                            cacheResult.expires = System.currentTimeMillis() + CACHE_EXPIRE_TIME_ONEWEEK;
                        } else if (pageType != WebView.PageType.DesktopType) {
                            if (!str.startsWith("text/html")) {
                                cacheResult.expires = System.currentTimeMillis() + CACHE_EXPIRE_TIME;
                            } else {
                                cacheResult.expires = 0L;
                            }
                        }
                    } else {
                        long currentTimeMillis = System.currentTimeMillis() + 86400000;
                        try {
                            currentTimeMillis = AndroidHttpClient.parseDate(cacheResult.lastModified);
                        } catch (IllegalArgumentException e3) {
                            Log.e(LOGTAG, "illegal lastModified: " + cacheResult.lastModified);
                        }
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0) {
                            cacheResult.expires = System.currentTimeMillis() + (currentTimeMillis2 / 5);
                        } else {
                            cacheResult.expires = currentTimeMillis;
                        }
                    }
                }
                return cacheResult;
            }
            return null;
        }
        throw new AssertionError();
    }
}
