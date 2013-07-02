package com.baidu.zeus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import com.baidu.zeus.CacheManager;
import com.baidu.zeus.CookieManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class WebViewDatabase {
    private static final String CACHE_CONTENTDISPOSITION_COL = "contentdisposition";
    private static final String CACHE_CONTENTLENGTH_COL = "contentlength";
    private static final String CACHE_CROSSDOMAIN_COL = "crossdomain";
    private static final String CACHE_DATABASE_FILE = "webviewCache_baidu.db";
    private static final int CACHE_DATABASE_VERSION = 4;
    private static final String CACHE_ENCODING_COL = "encoding";
    private static final String CACHE_ETAG_COL = "etag";
    private static final String CACHE_EXPIRES_COL = "expires";
    private static final String CACHE_EXPIRES_STRING_COL = "expiresstring";
    private static final String CACHE_FILE_PATH_COL = "filepath";
    private static final String CACHE_HTTP_STATUS_COL = "httpstatus";
    private static final String CACHE_LAST_MODIFY_COL = "lastmodify";
    private static final String CACHE_LOCATION_COL = "location";
    private static final String CACHE_MIMETYPE_COL = "mimetype";
    private static final String CACHE_URL_COL = "url";
    private static final String COOKIES_DOMAIN_COL = "domain";
    private static final String COOKIES_EXPIRES_COL = "expires";
    private static final String COOKIES_NAME_COL = "name";
    private static final String COOKIES_PATH_COL = "path";
    private static final String COOKIES_SECURE_COL = "secure";
    private static final String COOKIES_VALUE_COL = "value";
    private static final String DATABASE_FILE = "webview_baidu.db";
    private static final int DATABASE_VERSION = 11;
    private static final String FORMDATA_NAME_COL = "name";
    private static final String FORMDATA_URLID_COL = "urlid";
    private static final String FORMDATA_VALUE_COL = "value";
    private static final String FORMURL_URL_COL = "url";
    private static final String HTTPAUTH_HOST_COL = "host";
    private static final String HTTPAUTH_PASSWORD_COL = "password";
    private static final String HTTPAUTH_REALM_COL = "realm";
    private static final String HTTPAUTH_USERNAME_COL = "username";
    protected static final String LOGTAG = "webviewdatabase";
    private static final String PASSWORD_HOST_COL = "host";
    private static final String PASSWORD_PASSWORD_COL = "password";
    private static final String PASSWORD_USERNAME_COL = "username";
    private static final int TABLE_COOKIES_ID = 0;
    private static final int TABLE_FORMDATA_ID = 3;
    private static final int TABLE_FORMURL_ID = 2;
    private static final int TABLE_HTTPAUTH_ID = 4;
    private static final int TABLE_PASSWORD_ID = 1;
    private static int mCacheContentDispositionColIndex;
    private static int mCacheContentLengthColIndex;
    private static int mCacheCrossDomainColIndex;
    private static int mCacheETagColIndex;
    private static int mCacheEncodingColIndex;
    private static int mCacheExpiresColIndex;
    private static int mCacheExpiresStringColIndex;
    private static int mCacheFilePathColIndex;
    private static int mCacheHttpStatusColIndex;
    private static DatabaseUtils.InsertHelper mCacheInserter;
    private static int mCacheLastModifyColIndex;
    private static int mCacheLocationColIndex;
    private static int mCacheMimeTypeColIndex;
    private static int mCacheTransactionRefcount;
    private static int mCacheUrlColIndex;
    private static WebViewDatabase mInstance = null;
    private static SQLiteDatabase mDatabase = null;
    private static SQLiteDatabase mCacheDatabase = null;
    private static final String[] mTableNames = {"cookies", "password", "formurl", "formdata", "httpauth"};
    private static final String ID_COL = "_id";
    private static final String[] ID_PROJECTION = {ID_COL};
    private static ArrayList mCacheDataList = new ArrayList();
    private final Object mCookieLock = new Object();
    private final Object mPasswordLock = new Object();
    private final Object mFormLock = new Object();
    private final Object mHttpAuthLock = new Object();
    private final Object mInsetCacheLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CacheDataForInsert {
        CacheManager.CacheResult c;
        String url;

        private CacheDataForInsert() {
        }
    }

    private WebViewDatabase() {
    }

    public static synchronized WebViewDatabase getInstance(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (mInstance == null) {
                mInstance = new WebViewDatabase();
                try {
                    mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
                } catch (SQLiteException e) {
                    if (context.deleteDatabase(DATABASE_FILE)) {
                        mDatabase = context.openOrCreateDatabase(DATABASE_FILE, 0, null);
                    }
                }
                if (mDatabase != null && mDatabase.getVersion() != 11) {
                    mDatabase.beginTransaction();
                    upgradeDatabase();
                    mDatabase.setTransactionSuccessful();
                    mDatabase.endTransaction();
                }
                if (mDatabase != null) {
                    mDatabase.setLockingEnabled(false);
                }
                try {
                    mCacheDatabase = context.openOrCreateDatabase(CACHE_DATABASE_FILE, 0, null);
                } catch (SQLiteException e2) {
                    if (context.deleteDatabase(CACHE_DATABASE_FILE)) {
                        mCacheDatabase = context.openOrCreateDatabase(CACHE_DATABASE_FILE, 0, null);
                    }
                }
                if (mCacheDatabase != null && mCacheDatabase.getVersion() != 4) {
                    mCacheDatabase.beginTransaction();
                    upgradeCacheDatabase();
                    bootstrapCacheDatabase();
                    mCacheDatabase.setTransactionSuccessful();
                    mCacheDatabase.endTransaction();
                    CacheManager.removeAllCacheFiles();
                }
                if (mCacheDatabase != null) {
                    mCacheDatabase.execSQL("PRAGMA read_uncommitted = true;");
                    mCacheDatabase.setLockingEnabled(false);
                    mCacheInserter = new DatabaseUtils.InsertHelper(mCacheDatabase, "cache");
                    mCacheUrlColIndex = mCacheInserter.getColumnIndex("url");
                    mCacheFilePathColIndex = mCacheInserter.getColumnIndex(CACHE_FILE_PATH_COL);
                    mCacheLastModifyColIndex = mCacheInserter.getColumnIndex(CACHE_LAST_MODIFY_COL);
                    mCacheETagColIndex = mCacheInserter.getColumnIndex("etag");
                    mCacheExpiresColIndex = mCacheInserter.getColumnIndex(Headers.EXPIRES);
                    mCacheExpiresStringColIndex = mCacheInserter.getColumnIndex(CACHE_EXPIRES_STRING_COL);
                    mCacheMimeTypeColIndex = mCacheInserter.getColumnIndex(CACHE_MIMETYPE_COL);
                    mCacheEncodingColIndex = mCacheInserter.getColumnIndex(CACHE_ENCODING_COL);
                    mCacheHttpStatusColIndex = mCacheInserter.getColumnIndex(CACHE_HTTP_STATUS_COL);
                    mCacheLocationColIndex = mCacheInserter.getColumnIndex("location");
                    mCacheContentLengthColIndex = mCacheInserter.getColumnIndex(CACHE_CONTENTLENGTH_COL);
                    mCacheContentDispositionColIndex = mCacheInserter.getColumnIndex(CACHE_CONTENTDISPOSITION_COL);
                }
            }
            webViewDatabase = mInstance;
        }
        return webViewDatabase;
    }

    private static void upgradeDatabase() {
        int version = mDatabase.getVersion();
        if (version != 0) {
            Log.i(LOGTAG, "Upgrading database from version " + version + " to 11, which will destroy old data");
        }
        if (8 == version) {
        }
        if (9 == version) {
        }
        boolean z = 10 == version;
        mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[0]);
        mDatabase.execSQL("DROP TABLE IF EXISTS cache");
        mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[2]);
        mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[3]);
        mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[4]);
        if (!z) {
            mDatabase.execSQL("DROP TABLE IF EXISTS " + mTableNames[1]);
        } else {
            copyPasswordData();
        }
        mDatabase.setVersion(11);
        mDatabase.execSQL("CREATE TABLE " + mTableNames[0] + " (" + ID_COL + " INTEGER PRIMARY KEY, name TEXT, value TEXT, " + COOKIES_DOMAIN_COL + " TEXT, " + COOKIES_PATH_COL + " TEXT, " + Headers.EXPIRES + " INTEGER, " + COOKIES_SECURE_COL + " INTEGER);");
        mDatabase.execSQL("CREATE INDEX cookiesIndex ON " + mTableNames[0] + " (path)");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[2] + " (" + ID_COL + " INTEGER PRIMARY KEY, url TEXT);");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[3] + " (" + ID_COL + " INTEGER PRIMARY KEY, " + FORMDATA_URLID_COL + " INTEGER, name TEXT, value TEXT, UNIQUE (" + FORMDATA_URLID_COL + ", name, value) ON CONFLICT IGNORE);");
        mDatabase.execSQL("CREATE TABLE " + mTableNames[4] + " (" + ID_COL + " INTEGER PRIMARY KEY, host TEXT, " + HTTPAUTH_REALM_COL + " TEXT, username TEXT, password TEXT, UNIQUE (host, " + HTTPAUTH_REALM_COL + ") ON CONFLICT REPLACE);");
        if (!z) {
            mDatabase.execSQL("CREATE TABLE " + mTableNames[1] + " (" + ID_COL + " INTEGER PRIMARY KEY, host TEXT, username TEXT, password TEXT, UNIQUE (host, username) ON CONFLICT REPLACE);");
        }
    }

    private static void upgradeCacheDatabase() {
        int version = mCacheDatabase.getVersion();
        if (version != 0) {
            Log.i(LOGTAG, "Upgrading cache database from version " + version + " to 11, which will destroy all old data");
        }
        mCacheDatabase.execSQL("DROP TABLE IF EXISTS cache");
        mCacheDatabase.setVersion(4);
    }

    private static void bootstrapCacheDatabase() {
        if (mCacheDatabase != null) {
            mCacheDatabase.execSQL("CREATE TABLE cache (_id INTEGER PRIMARY KEY, url TEXT, filepath TEXT, lastmodify TEXT, etag TEXT, expires INTEGER, expiresstring TEXT, mimetype TEXT, encoding TEXT,httpstatus INTEGER, location TEXT, contentlength INTEGER, contentdisposition TEXT,  UNIQUE (url) ON CONFLICT REPLACE);");
            mCacheDatabase.execSQL("CREATE INDEX cacheUrlIndex ON cache (url)");
        }
    }

    private boolean hasEntries(int i) {
        Cursor cursor;
        boolean z;
        Cursor cursor2 = null;
        try {
            if (mDatabase == null) {
                return false;
            }
            try {
                cursor = mDatabase.query(mTableNames[i], ID_PROJECTION, null, null, null, null, null);
                try {
                    z = cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (IllegalStateException e) {
                    e = e;
                    Log.e(LOGTAG, "hasEntries", e);
                    if (cursor != null) {
                        cursor.close();
                        z = false;
                    } else {
                        z = false;
                    }
                    return z;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00e0 */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7 A[Catch: all -> 0x00d3, TRY_ENTER, TryCatch #1 {, blocks: (B:11:0x0011, B:26:0x00b7, B:27:0x00ba, B:34:0x00cf, B:42:0x00dc, B:43:0x00df), top: B:49:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc A[Catch: all -> 0x00d3, TRY_ENTER, TryCatch #1 {, blocks: (B:11:0x0011, B:26:0x00b7, B:27:0x00ba, B:34:0x00cf, B:42:0x00dc, B:43:0x00df), top: B:49:0x0011 }] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList getCookiesForDomain(String str) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        if (str == null || mDatabase == null) {
            return arrayList;
        }
        synchronized (this.mCookieLock) {
            ?? r1 = COOKIES_SECURE_COL;
            try {
                try {
                    cursor = mDatabase.query(mTableNames[0], new String[]{ID_COL, COOKIES_DOMAIN_COL, COOKIES_PATH_COL, "name", "value", Headers.EXPIRES, COOKIES_SECURE_COL}, "(domain GLOB '*' || ?)", new String[]{str}, null, null, null);
                    try {
                    } catch (IllegalStateException e) {
                        e = e;
                        Log.e(LOGTAG, "getCookiesForDomain", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        r1.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                if (r1 != 0) {
                }
                throw th;
            }
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(COOKIES_DOMAIN_COL);
                int columnIndex2 = cursor.getColumnIndex(COOKIES_PATH_COL);
                int columnIndex3 = cursor.getColumnIndex("name");
                int columnIndex4 = cursor.getColumnIndex("value");
                int columnIndex5 = cursor.getColumnIndex(Headers.EXPIRES);
                int columnIndex6 = cursor.getColumnIndex(COOKIES_SECURE_COL);
                do {
                    CookieManager.Cookie cookie = new CookieManager.Cookie();
                    cookie.domain = cursor.getString(columnIndex);
                    cookie.path = cursor.getString(columnIndex2);
                    cookie.name = cursor.getString(columnIndex3);
                    cookie.value = cursor.getString(columnIndex4);
                    if (cursor.isNull(columnIndex5)) {
                        cookie.expires = -1L;
                    } else {
                        cookie.expires = cursor.getLong(columnIndex5);
                    }
                    cookie.secure = cursor.getShort(columnIndex6) != 0;
                    cookie.mode = (byte) 1;
                    arrayList.add(cookie);
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteCookies(String str, String str2, String str3) {
        if (str != null && mDatabase != null) {
            synchronized (this.mCookieLock) {
                mDatabase.delete(mTableNames[0], "(domain == ?) AND (path == ?) AND (name == ?)", new String[]{str, str2, str3});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCookie(CookieManager.Cookie cookie) {
        if (cookie.domain != null && cookie.path != null && cookie.name != null && mDatabase != null) {
            synchronized (this.mCookieLock) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COOKIES_DOMAIN_COL, cookie.domain);
                contentValues.put(COOKIES_PATH_COL, cookie.path);
                contentValues.put("name", cookie.name);
                contentValues.put("value", cookie.value);
                if (cookie.expires != -1) {
                    contentValues.put(Headers.EXPIRES, Long.valueOf(cookie.expires));
                }
                contentValues.put(COOKIES_SECURE_COL, Boolean.valueOf(cookie.secure));
                mDatabase.insert(mTableNames[0], null, contentValues);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCookies() {
        boolean hasEntries;
        synchronized (this.mCookieLock) {
            hasEntries = hasEntries(0);
        }
        return hasEntries;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearCookies() {
        if (mDatabase != null) {
            synchronized (this.mCookieLock) {
                mDatabase.delete(mTableNames[0], null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearSessionCookies() {
        if (mDatabase != null) {
            synchronized (this.mCookieLock) {
                mDatabase.delete(mTableNames[0], "expires ISNULL", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearExpiredCookies(long j) {
        if (mDatabase != null) {
            synchronized (this.mCookieLock) {
                mDatabase.delete(mTableNames[0], "expires <= ?", new String[]{Long.toString(j)});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean startCacheTransaction() {
        int i = mCacheTransactionRefcount + 1;
        mCacheTransactionRefcount = i;
        if (i == 1) {
            if (!Thread.currentThread().equals(WebViewWorker.getHandler().getLooper().getThread())) {
                Log.w(LOGTAG, "startCacheTransaction should be called from WebViewWorkerThread instead of from " + Thread.currentThread().getName());
            }
            mCacheDatabase.beginTransaction();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean endCacheTransaction() {
        int i = mCacheTransactionRefcount - 1;
        mCacheTransactionRefcount = i;
        if (i == 0) {
            if (!Thread.currentThread().equals(WebViewWorker.getHandler().getLooper().getThread())) {
                Log.w(LOGTAG, "endCacheTransaction should be called from WebViewWorkerThread instead of from " + Thread.currentThread().getName());
            }
            try {
                mCacheDatabase.setTransactionSuccessful();
                mCacheDatabase.endTransaction();
                return true;
            } catch (Throwable th) {
                mCacheDatabase.endTransaction();
                throw th;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CacheManager.CacheResult getCache(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (str == null || mCacheDatabase == null) {
            return null;
        }
        try {
            try {
                cursor = mCacheDatabase.rawQuery("SELECT filepath, lastmodify, etag, expires, expiresstring, mimetype, encoding, httpstatus, location, contentlength, contentdisposition FROM cache WHERE url = ?", new String[]{str});
                try {
                } catch (IllegalStateException e) {
                    e = e;
                    Log.e(LOGTAG, "getCache", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (IllegalStateException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        if (!cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        CacheManager.CacheResult cacheResult = new CacheManager.CacheResult();
        cacheResult.localPath = cursor.getString(0);
        cacheResult.lastModified = cursor.getString(1);
        cacheResult.etag = cursor.getString(2);
        cacheResult.expires = cursor.getLong(3);
        cacheResult.expiresString = cursor.getString(4);
        cacheResult.mimeType = cursor.getString(5);
        cacheResult.encoding = cursor.getString(6);
        cacheResult.httpStatusCode = cursor.getInt(7);
        cacheResult.location = cursor.getString(8);
        cacheResult.contentLength = cursor.getLong(9);
        cacheResult.contentdisposition = cursor.getString(10);
        if (cursor != null) {
            cursor.close();
            return cacheResult;
        }
        return cacheResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCache(String str) {
        if (str != null && mCacheDatabase != null) {
            mCacheDatabase.execSQL("DELETE FROM cache WHERE url = ?", new String[]{str});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCache(String str, CacheManager.CacheResult cacheResult) {
        if (str != null && mCacheDatabase != null) {
            synchronized (this.mInsetCacheLock) {
                CacheDataForInsert cacheDataForInsert = new CacheDataForInsert();
                cacheDataForInsert.url = str;
                cacheDataForInsert.c = cacheResult;
                mCacheDataList.add(cacheDataForInsert);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertCacheDateList() {
        synchronized (this.mInsetCacheLock) {
            int size = mCacheDataList.size();
            if (size >= 1) {
                mCacheDatabase.beginTransaction();
                for (int i = size - 1; i >= 0; i--) {
                    try {
                        CacheDataForInsert cacheDataForInsert = (CacheDataForInsert) mCacheDataList.get(i);
                        mCacheInserter.prepareForInsert();
                        mCacheInserter.bind(mCacheUrlColIndex, cacheDataForInsert.url);
                        mCacheInserter.bind(mCacheFilePathColIndex, cacheDataForInsert.c.localPath);
                        mCacheInserter.bind(mCacheLastModifyColIndex, cacheDataForInsert.c.lastModified);
                        mCacheInserter.bind(mCacheETagColIndex, cacheDataForInsert.c.etag);
                        mCacheInserter.bind(mCacheExpiresColIndex, cacheDataForInsert.c.expires);
                        mCacheInserter.bind(mCacheExpiresStringColIndex, cacheDataForInsert.c.expiresString);
                        mCacheInserter.bind(mCacheMimeTypeColIndex, cacheDataForInsert.c.mimeType);
                        mCacheInserter.bind(mCacheEncodingColIndex, cacheDataForInsert.c.encoding);
                        mCacheInserter.bind(mCacheHttpStatusColIndex, cacheDataForInsert.c.httpStatusCode);
                        mCacheInserter.bind(mCacheLocationColIndex, cacheDataForInsert.c.location);
                        mCacheInserter.bind(mCacheContentLengthColIndex, cacheDataForInsert.c.contentLength);
                        mCacheInserter.bind(mCacheContentDispositionColIndex, cacheDataForInsert.c.contentdisposition);
                        mCacheInserter.execute();
                        mCacheDataList.remove(i);
                    } catch (SQLiteException e) {
                        mCacheDatabase.endTransaction();
                    }
                }
                mCacheDatabase.setTransactionSuccessful();
                mCacheDatabase.endTransaction();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheManager.CacheResult getCacheResult(String str) {
        int size = mCacheDataList.size();
        if (size < 1) {
            return null;
        }
        for (int i = size - 1; i >= 0; i--) {
            CacheDataForInsert cacheDataForInsert = (CacheDataForInsert) mCacheDataList.get(i);
            if (str.equals(cacheDataForInsert.url)) {
                return cacheDataForInsert.c;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearCache() {
        if (mCacheDatabase != null) {
            mCacheDatabase.delete("cache", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasCache() {
        Cursor cursor;
        boolean z;
        if (mCacheDatabase == null) {
            return false;
        }
        try {
            cursor = mCacheDatabase.query("cache", ID_PROJECTION, null, null, null, null, null);
            try {
                try {
                    z = cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (IllegalStateException e) {
                    e = e;
                    Log.e(LOGTAG, "hasCache", e);
                    if (cursor != null) {
                        cursor.close();
                        z = false;
                    } else {
                        z = false;
                    }
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (IllegalStateException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCacheTotalSize() {
        Cursor cursor = null;
        long j = 0;
        try {
            try {
                cursor = mCacheDatabase.rawQuery("SELECT SUM(contentlength) as sum FROM cache", null);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
            } catch (IllegalStateException e) {
                Log.e(LOGTAG, "getCacheTotalSize", e);
                if (cursor != null) {
                    cursor.close();
                }
            }
            return j;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List trimCache(long j) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList(100);
        Cursor cursor2 = null;
        try {
            cursor = mCacheDatabase.rawQuery("SELECT contentlength, filepath FROM cache ORDER BY expires ASC", null);
        } catch (IllegalStateException e) {
            e = e;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (cursor.moveToFirst()) {
                StringBuilder sb = new StringBuilder(1620);
                sb.append("DELETE FROM cache WHERE filepath IN (?");
                for (int i = 1; i < 100; i++) {
                    sb.append(", ?");
                }
                sb.append(")");
                SQLiteStatement sQLiteStatement = null;
                try {
                    sQLiteStatement = mCacheDatabase.compileStatement(sb.toString());
                    int i2 = 1;
                    long j2 = j;
                    do {
                        long j3 = cursor.getLong(0);
                        if (j3 != 0) {
                            long j4 = j2 - j3;
                            String string = cursor.getString(1);
                            sQLiteStatement.bindString(i2, string);
                            arrayList.add(string);
                            int i3 = i2 + 1;
                            if (i2 == 100) {
                                sQLiteStatement.execute();
                                sQLiteStatement.clearBindings();
                                i2 = 1;
                                j2 = j4;
                            } else {
                                i2 = i3;
                                j2 = j4;
                            }
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } while (j2 > 0);
                    if (i2 > 1) {
                        sQLiteStatement.execute();
                    }
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                } catch (IllegalStateException e2) {
                    Log.e(LOGTAG, "trimCache SQLiteStatement", e2);
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (IllegalStateException e3) {
            e = e3;
            cursor2 = cursor;
            try {
                Log.e(LOGTAG, "trimCache Cursor", e);
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List getAllCacheFileNames() {
        Cursor cursor;
        IllegalStateException illegalStateException;
        ArrayList arrayList;
        Cursor cursor2 = null;
        try {
            cursor = mCacheDatabase.rawQuery("SELECT filepath FROM cache", null);
        } catch (IllegalStateException e) {
            illegalStateException = e;
            arrayList = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e2) {
                arrayList = null;
                cursor2 = cursor;
                illegalStateException = e2;
            }
            if (cursor.moveToFirst()) {
                ArrayList arrayList2 = new ArrayList(cursor.getCount());
                do {
                    try {
                        arrayList2.add(cursor.getString(0));
                    } catch (IllegalStateException e3) {
                        cursor2 = cursor;
                        illegalStateException = e3;
                        arrayList = arrayList2;
                        try {
                            Log.e(LOGTAG, "getAllCacheFileNames", illegalStateException);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            return arrayList;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                } while (cursor.moveToNext());
                arrayList = arrayList2;
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        }
        arrayList = null;
        if (cursor != null) {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList allImageCachePaths() {
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = mCacheDatabase.rawQuery("SELECT filepath FROM cache WHERE mimetype like 'image/%'", null);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            do {
                arrayList.add(rawQuery.getString(0));
            } while (rawQuery.moveToNext());
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList;
        }
        if (rawQuery != null && !rawQuery.isClosed()) {
            rawQuery.close();
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [955=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00b7 */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088 A[Catch: all -> 0x009c, TRY_ENTER, TryCatch #3 {, blocks: (B:9:0x0022, B:17:0x0088, B:19:0x008d, B:20:0x0099, B:33:0x00b3, B:34:0x00b6, B:29:0x00aa), top: B:41:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008d A[Catch: all -> 0x009c, TryCatch #3 {, blocks: (B:9:0x0022, B:17:0x0088, B:19:0x008d, B:20:0x0099, B:33:0x00b3, B:34:0x00b6, B:29:0x00aa), top: B:41:0x0022 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setUsernamePassword(String str, String str2, String str3) {
        ContentValues contentValues;
        Cursor cursor;
        boolean z;
        int columnIndex;
        if (str == null || mDatabase == null) {
            return;
        }
        ?? r1 = "password";
        String[] strArr = {ID_COL, "username", "password"};
        synchronized (this.mPasswordLock) {
            try {
                String ZeusMartine = PlumCore.ZeusMartine(str2);
                String ZeusMartine2 = PlumCore.ZeusMartine(str3);
                contentValues = new ContentValues();
                contentValues.put("host", str);
                contentValues.put("username", ZeusMartine);
                contentValues.put("password", ZeusMartine2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                cursor = mDatabase.query(mTableNames[1], strArr, "(host == ?)", new String[]{str}, null, null, null);
            } catch (IllegalStateException e) {
                e = e;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
            if (cursor != null) {
                try {
                    columnIndex = cursor.getColumnIndex(ID_COL);
                    cursor.getColumnIndex("username");
                    cursor.getColumnIndex("password");
                } catch (IllegalStateException e2) {
                    e = e2;
                    Log.e(LOGTAG, "getUsernamePassword", e);
                    if (cursor != null) {
                        cursor.close();
                        z = false;
                    } else {
                        z = false;
                    }
                    if (!z) {
                    }
                }
                if (cursor.moveToFirst()) {
                    mDatabase.update(mTableNames[1], contentValues, "_id = ?", new String[]{Integer.toString(cursor.getInt(columnIndex))});
                    z = true;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (!z) {
                        mDatabase.insert(mTableNames[1], "host", contentValues);
                    }
                }
            }
            z = false;
            if (cursor != null) {
            }
            if (!z) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:18:0x006b, B:19:0x006e, B:28:0x007e, B:32:0x0087, B:33:0x008a), top: B:44:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] getUsernamePassword(String str) {
        Cursor cursor;
        String[] strArr;
        String[] strArr2;
        Cursor cursor2 = null;
        if (str == null || mDatabase == null) {
            return null;
        }
        String[] strArr3 = {"username", "password"};
        synchronized (this.mPasswordLock) {
            try {
                cursor = mDatabase.query(mTableNames[1], strArr3, "(host == ?)", new String[]{str}, null, null, null);
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            String[] strArr4 = new String[2];
                            try {
                                strArr4[0] = cursor.getString(cursor.getColumnIndex("username"));
                                strArr4[0] = PlumCore.ZeusMartine2(strArr4[0]);
                                strArr4[1] = cursor.getString(cursor.getColumnIndex("password"));
                                strArr4[1] = PlumCore.ZeusMartine2(strArr4[1]);
                                strArr2 = strArr4;
                            } catch (IllegalStateException e) {
                                e = e;
                                strArr = strArr4;
                                cursor2 = cursor;
                                try {
                                    Log.e(LOGTAG, "getUsernamePassword", e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                        strArr2 = strArr;
                                    } else {
                                        strArr2 = strArr;
                                    }
                                    return strArr2;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = cursor2;
                                    if (cursor != null) {
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            strArr2 = null;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (IllegalStateException e2) {
                        e = e2;
                        strArr = null;
                        cursor2 = cursor;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e3) {
                e = e3;
                strArr = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
        return strArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void copyPasswordData() {
        Cursor cursor;
        if (mDatabase != null) {
            try {
                cursor = mDatabase.query(mTableNames[1], new String[]{ID_COL, "username", "password"}, null, null, null, null, null);
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            int columnIndex = cursor.getColumnIndex(ID_COL);
                            int columnIndex2 = cursor.getColumnIndex("username");
                            int columnIndex3 = cursor.getColumnIndex("password");
                            do {
                                int i = cursor.getInt(columnIndex);
                                String string = cursor.getString(columnIndex2);
                                String string2 = cursor.getString(columnIndex3);
                                ContentValues contentValues = new ContentValues();
                                String ZeusMartine = PlumCore.ZeusMartine(string);
                                String ZeusMartine2 = PlumCore.ZeusMartine(string2);
                                String[] strArr = {Integer.toString(i)};
                                contentValues.put("username", ZeusMartine);
                                contentValues.put("password", ZeusMartine2);
                                mDatabase.update(mTableNames[1], contentValues, "_id = ?", strArr);
                            } while (cursor.moveToNext());
                            if (cursor == null) {
                                cursor.close();
                            }
                        } else if (cursor == null) {
                        }
                    } catch (IllegalStateException e) {
                        e = e;
                        Log.e(LOGTAG, "copyPasswordData", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    public boolean hasUsernamePassword() {
        boolean hasEntries;
        synchronized (this.mPasswordLock) {
            hasEntries = hasEntries(1);
        }
        return hasEntries;
    }

    public void clearUsernamePassword() {
        if (mDatabase != null) {
            synchronized (this.mPasswordLock) {
                mDatabase.delete(mTableNames[1], null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && mDatabase != null) {
            synchronized (this.mHttpAuthLock) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("host", str);
                contentValues.put(HTTPAUTH_REALM_COL, str2);
                contentValues.put("username", str3);
                contentValues.put("password", str4);
                mDatabase.insert(mTableNames[4], "host", contentValues);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        String[] strArr;
        String[] strArr2;
        Cursor query;
        Cursor cursor = null;
        if (str == null || str2 == null || mDatabase == null) {
            return null;
        }
        String[] strArr3 = {"username", "password"};
        synchronized (this.mHttpAuthLock) {
            try {
                try {
                    query = mDatabase.query(mTableNames[4], strArr3, "(host == ?) AND (realm == ?)", new String[]{str, str2}, null, null, null);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IllegalStateException e) {
                e = e;
                strArr = null;
            }
            try {
                try {
                    if (query.moveToFirst()) {
                        String[] strArr4 = new String[2];
                        try {
                            strArr4[0] = query.getString(query.getColumnIndex("username"));
                            strArr4[1] = query.getString(query.getColumnIndex("password"));
                            strArr2 = strArr4;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            strArr = strArr4;
                            cursor = query;
                            Log.e(LOGTAG, "getHttpAuthUsernamePassword", e);
                            if (cursor != null) {
                                cursor.close();
                                strArr2 = strArr;
                            } else {
                                strArr2 = strArr;
                            }
                            return strArr2;
                        }
                    } else {
                        strArr2 = null;
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    strArr = null;
                    cursor = query;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return strArr2;
    }

    public boolean hasHttpAuthUsernamePassword() {
        boolean hasEntries;
        synchronized (this.mHttpAuthLock) {
            hasEntries = hasEntries(4);
        }
        return hasEntries;
    }

    public void clearHttpAuthUsernamePassword() {
        if (mDatabase != null) {
            synchronized (this.mHttpAuthLock) {
                mDatabase.delete(mTableNames[4], null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[Catch: all -> 0x0089, TryCatch #3 {, blocks: (B:16:0x003b, B:19:0x0045, B:20:0x005b, B:22:0x0061, B:38:0x00bb, B:36:0x00b7, B:37:0x00ba, B:32:0x00ae), top: B:47:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setFormData(String str, HashMap hashMap) {
        Cursor cursor;
        long j;
        long insert;
        Cursor cursor2 = null;
        if (str != null && hashMap != null && mDatabase != null) {
            synchronized (this.mFormLock) {
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    cursor = mDatabase.query(mTableNames[2], ID_PROJECTION, "(url == ?)", new String[]{str}, null, null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            insert = cursor.getLong(cursor.getColumnIndex(ID_COL));
                        } else {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("url", str);
                            insert = mDatabase.insert(mTableNames[2], null, contentValues);
                        }
                        if (cursor != null) {
                            cursor.close();
                            j = insert;
                        } else {
                            j = insert;
                        }
                    } catch (IllegalStateException e) {
                        e = e;
                        Log.e(LOGTAG, "setFormData", e);
                        if (cursor != null) {
                            cursor.close();
                            j = -1;
                        } else {
                            j = -1;
                        }
                        if (j >= 0) {
                        }
                    }
                } catch (IllegalStateException e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        cursor2.close();
                    }
                    throw th;
                }
                if (j >= 0) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(FORMDATA_URLID_COL, Long.valueOf(j));
                    for (Map.Entry entry : hashMap.entrySet()) {
                        contentValues2.put("name", (String) entry.getKey());
                        contentValues2.put("value", (String) entry.getValue());
                        mDatabase.insert(mTableNames[3], null, contentValues2);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1263=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.String[] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.lang.String */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[Catch: IllegalStateException -> 0x009e, all -> 0x00b7, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IllegalStateException -> 0x009e, all -> 0x00b7, blocks: (B:12:0x002f, B:14:0x0035, B:22:0x0084, B:43:0x00b3, B:44:0x00b6, B:31:0x009a), top: B:67:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089 A[Catch: all -> 0x00ad, TRY_ENTER, TryCatch #7 {, blocks: (B:24:0x0089, B:25:0x008c, B:37:0x00a9, B:48:0x00bb, B:49:0x00be), top: B:63:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList getFormData(String str, String str2) {
        String str3;
        Cursor query;
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        if (str == null || str2 == null || mDatabase == null) {
            return arrayList;
        }
        synchronized (this.mFormLock) {
            try {
                try {
                    SQLiteDatabase sQLiteDatabase = mDatabase;
                    str3 = mTableNames[2];
                    query = sQLiteDatabase.query(str3, ID_PROJECTION, "(url == ?)", new String[]{str}, null, null, null);
                } catch (IllegalStateException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (query.moveToFirst()) {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = str3;
                    }
                    try {
                        cursor = mDatabase.query(mTableNames[3], new String[]{ID_COL, "value"}, "(urlid == ?) AND (name == ?)", new String[]{Long.toString(query.getLong(query.getColumnIndex(ID_COL))), str2}, null, null, null);
                        try {
                            if (cursor.moveToFirst()) {
                                int columnIndex = cursor.getColumnIndex("value");
                                do {
                                    arrayList.add(cursor.getString(columnIndex));
                                } while (cursor.moveToNext());
                                if (cursor != null) {
                                    cursor.close();
                                }
                            } else if (cursor != null) {
                            }
                        } catch (IllegalStateException e2) {
                            e = e2;
                            Log.e(LOGTAG, "getFormData dataCursor", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (query != null) {
                            }
                            return arrayList;
                        }
                    } catch (IllegalStateException e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (IllegalStateException e4) {
                e = e4;
                cursor2 = query;
                Log.e(LOGTAG, "getFormData cursor", e);
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayList;
            } catch (Throwable th4) {
                th = th4;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public boolean hasFormData() {
        boolean hasEntries;
        synchronized (this.mFormLock) {
            hasEntries = hasEntries(2);
        }
        return hasEntries;
    }

    public void clearFormData() {
        if (mDatabase != null) {
            synchronized (this.mFormLock) {
                mDatabase.delete(mTableNames[2], null, null);
                mDatabase.delete(mTableNames[3], null, null);
            }
        }
    }
}
