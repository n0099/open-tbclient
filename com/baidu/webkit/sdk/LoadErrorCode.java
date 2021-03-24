package com.baidu.webkit.sdk;

import android.content.Context;
import com.baidu.nps.pm.provider.BundleOpProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LoadErrorCode {
    public static final String COLON = ":";
    public static final int GET_INTERN_PACKAGEINFO_FAIL = 2;
    public static final int GET_PACKAGEINFO_FAIL = 1;
    public static final int GET_PROVIDER_BACKUP_FAIL = 5;
    public static final int GET_PROVIDER_FAIL = 4;
    public static final int GET_PROVIDER_NO_EXCEPTION = 6;
    public static final int GET_SHARED_PACKAGEINFO_FAIL = 3;
    public static final int MSG_ENABLE_BLACK_LIST = 515;
    public static final int MSG_ERROR_NATIVE_LIB_DIR = 508;
    public static final int MSG_EXPAND_LIB_DIR_FAIL = 509;
    public static final int MSG_FORCE_USING_SYS_WEBVIEW = 511;
    public static final int MSG_SDK_ZEUS_DISMATCH = 500;
    public static final int MSG_STATISTICS_INTERN_ERROR = 514;
    public static final int MSG_SZ_CHECK_TIMESTAMP_FAIL = 506;
    public static final int MSG_SZ_JNI_ERROR = 512;
    public static final int MSG_SZ_LOCK_FAIL1 = 503;
    public static final int MSG_SZ_LOCK_FAIL2 = 504;
    public static final int MSG_SZ_NO_LIB_DIRECTORY = 507;
    public static final int MSG_SZ_PREPARE_FAIL1 = 501;
    public static final int MSG_SZ_PREPARE_FAIL2 = 502;
    public static final int MSG_SZ_UNLOCK_FAIL = 505;
    public static final int MSG_ZEUS_DISABLED_BY_CLOUD = 510;
    public static final int MSG_ZEUS_NOT_EXIST = 513;
    public static final int NONE = 0;
    public static final String TAG = "LoadErrorCode";
    public static final String TOKEN_NEXT = " -> ";
    public static final String TOKEN_NONE = "none";
    public static final int UNZIP_LZMA_ERROR = 100;
    public static final int UNZIP_LZMA_WRITE_BACK_FAIL = 101;
    public static final int UNZIP_TASK_FAILED = 103;
    public static final int UNZIP_TASK_TIMEOUT = 102;
    public static LoadErrorCode mInstance;
    public volatile StringBuilder mDetails;
    public volatile int mErrorCode;

    /* loaded from: classes5.dex */
    public static class Statistics {
        public static final boolean DEBUG = true;
        public static final String KEY_ERROR_CNT = "error_cnt";
        public static final String KEY_ERROR_CODE = "error_code";
        public static final String KEY_ERROR_REASON = "error_reason";
        public static final String KEY_T7_ERROR_LIST = "t7_error_list";
        public static final String KEY_T7_STRAT_CNT = "t7_start_cnt";
        public static final String TAG = "LoadErrorStatistics";
        public static volatile StringBuilder mInfo;
        public static volatile List<ErrorItem> sBkupList;
        public static volatile List<ErrorItem> sErrorList;
        public static volatile boolean sIsInited;
        public static volatile boolean sIsUploading;
        public static volatile File sRecordFile;
        public static final String RECORD_RELATIVE_PATH = "/zeus/statistics/".replace('/', File.separatorChar);
        public static final String RECORD_FILE_NAME = "/load_error.json".replace('/', File.separatorChar);

        /* loaded from: classes5.dex */
        public static class ErrorItem {
            public int mCount;
            public String mDetails;
            public int mEngineType;
            public int mErrorCode;

            public ErrorItem(int i, int i2, String str) {
                this(i, i2, str, 1);
            }

            public ErrorItem(int i, int i2, String str, int i3) {
                this.mEngineType = i;
                this.mErrorCode = i2;
                this.mDetails = str;
                this.mCount = i3;
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0032 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0034 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:? */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0044 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x000c */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean JSONToFile(JSONObject jSONObject) {
            byte[] bytes;
            FileOutputStream fileOutputStream;
            sRecordFile.delete();
            try {
                sRecordFile.createNewFile();
            } catch (Exception unused) {
            }
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream2 = null;
            fileOutputStream2 = null;
            boolean z = false;
            try {
                try {
                    try {
                        bytes = jSONObject.toString().getBytes();
                        fileOutputStream = new FileOutputStream(sRecordFile);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                int length = bytes.length;
                fileOutputStream.write(bytes, 0, length);
                fileOutputStream.flush();
                z = true;
                fileOutputStream.close();
                fileOutputStream2 = length;
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                addInfo(e.getMessage());
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                    fileOutputStream2 = fileOutputStream2;
                }
                if (!z) {
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            if (!z) {
                sRecordFile.delete();
            }
            return z;
        }

        public static boolean JSONToList(JSONObject jSONObject) {
            boolean z = false;
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(KEY_T7_ERROR_LIST);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sErrorList.add(new ErrorItem(1, jSONObject2.getInt("error_code"), jSONObject2.getString(KEY_ERROR_REASON), jSONObject2.getInt(KEY_ERROR_CNT)));
                }
                z = true;
            } catch (Exception e2) {
                addInfo(e2.getMessage());
                e2.printStackTrace();
            }
            if (!z) {
                sRecordFile.delete();
                sErrorList.clear();
            }
            return z;
        }

        public static void addBkupList(ErrorItem errorItem) {
            if (sBkupList == null) {
                sBkupList = new LinkedList();
            }
            sBkupList.add(errorItem);
        }

        public static synchronized void addInfo(String str) {
            synchronized (Statistics.class) {
                if (mInfo == null) {
                    mInfo = new StringBuilder();
                }
                if (mInfo.length() <= 0) {
                    mInfo.append(str);
                    return;
                }
                StringBuilder sb = mInfo;
                sb.append(LoadErrorCode.TOKEN_NEXT + str);
            }
        }

        public static void cleanBkupList() {
            if (sBkupList == null) {
                return;
            }
            for (ErrorItem errorItem : sBkupList) {
                record(errorItem);
            }
            sBkupList = null;
        }

        public static synchronized void destroy() {
            synchronized (Statistics.class) {
                addInfo("destroy");
                if (sIsInited) {
                    cleanBkupList();
                    JSONToFile(listToJSON());
                    sErrorList.clear();
                    sIsUploading = false;
                    sIsInited = false;
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0060 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r0v4 */
        public static JSONObject fileToJSON() {
            JSONObject jSONObject;
            Exception e2;
            FileInputStream fileInputStream;
            ?? exists = sRecordFile.exists();
            JSONObject jSONObject2 = null;
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(sRecordFile);
                    try {
                        int available = fileInputStream.available();
                        if (available > 0) {
                            byte[] bArr = new byte[available];
                            fileInputStream.read(bArr);
                            jSONObject = new JSONObject(new String(bArr));
                            try {
                                Log.d(TAG, "readJSON " + jSONObject);
                                jSONObject2 = jSONObject;
                            } catch (Exception e3) {
                                e2 = e3;
                                addInfo(e2.getMessage());
                                e2.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                return jSONObject;
                            }
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                            return jSONObject2;
                        }
                    } catch (Exception e4) {
                        jSONObject = null;
                        e2 = e4;
                    }
                } catch (Exception e5) {
                    jSONObject = null;
                    e2 = e5;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    exists = 0;
                    if (exists != 0) {
                        try {
                            exists.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static synchronized String getString() {
            synchronized (Statistics.class) {
                if (sIsInited) {
                    if (sIsUploading) {
                        cleanBkupList();
                    }
                    sIsUploading = true;
                    String map = map(listToJSON());
                    if (map != null) {
                        map = map.trim();
                    }
                    if (map != null && !map.isEmpty()) {
                        return map;
                    }
                } else {
                    Log.e(TAG, "[ERROR]getString before init");
                }
                StringBuilder sb = new StringBuilder(mInfo == null ? "" : mInfo);
                sb.append(LoadErrorCode.TOKEN_NEXT);
                sb.append(String.valueOf(sIsInited));
                sb.append(LoadErrorCode.TOKEN_NEXT);
                sb.append(String.valueOf(sIsUploading));
                sb.append(LoadErrorCode.TOKEN_NEXT);
                sb.append(String.valueOf(LoadErrorCode.getInstance().getInt()));
                sb.append(LoadErrorCode.TOKEN_NEXT);
                sb.append(LoadErrorCode.getInstance().getString());
                mInfo = null;
                if (sb.length() >= 512) {
                    sb.substring(0, 511);
                }
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("error_code", 514);
                    jSONObject.put(KEY_ERROR_REASON, sb.toString());
                    jSONObject.put(KEY_ERROR_CNT, 1);
                    jSONArray.put(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(KEY_T7_ERROR_LIST, jSONArray);
                    return jSONObject2.toString();
                } catch (JSONException e2) {
                    return e2.getMessage();
                }
            }
        }

        public static synchronized void init(Context context) {
            synchronized (Statistics.class) {
                addInfo("init");
                if (context == null) {
                    Log.e(TAG, "[ERROR]init ctx null");
                } else if (sIsInited) {
                } else {
                    sRecordFile = new File(new File(WebViewFactory.getContext().getFilesDir(), RECORD_RELATIVE_PATH), RECORD_FILE_NAME);
                    sErrorList = new LinkedList();
                    JSONObject fileToJSON = fileToJSON();
                    if (fileToJSON != null) {
                        JSONToList(fileToJSON);
                    }
                    sIsInited = true;
                }
            }
        }

        public static JSONObject listToJSON() {
            try {
                JSONArray jSONArray = new JSONArray();
                for (ErrorItem errorItem : sErrorList) {
                    if (errorItem.mErrorCode != 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("error_code", errorItem.mErrorCode);
                        jSONObject.put(KEY_ERROR_REASON, errorItem.mDetails);
                        jSONObject.put(KEY_ERROR_CNT, errorItem.mCount);
                        if (errorItem.mEngineType == 1) {
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(KEY_T7_ERROR_LIST, jSONArray);
                return jSONObject2;
            } catch (JSONException e2) {
                e2.printStackTrace();
                addInfo(e2.getMessage());
                return null;
            }
        }

        public static String map(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            byte[] bytes = jSONObject.toString().getBytes();
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                if (b2 == 34) {
                    bytes[i] = 47;
                } else if (b2 == 91) {
                    bytes[i] = 60;
                } else if (b2 == 93) {
                    bytes[i] = 62;
                } else if (b2 == 123) {
                    bytes[i] = 40;
                } else if (b2 == 125) {
                    bytes[i] = 41;
                }
            }
            return new String(bytes);
        }

        public static synchronized void record() {
            synchronized (Statistics.class) {
                addInfo(BundleOpProvider.METHOD_BUNDLE_RECORD);
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                if (!sIsInited) {
                    Log.e(TAG, "[ERROR]record before init");
                } else if (loadErrorCode == null) {
                    Log.e(TAG, "[ERORR]record error code null");
                } else {
                    int engineType = loadErrorCode.getEngineType();
                    if (engineType != 1) {
                        return;
                    }
                    ErrorItem errorItem = new ErrorItem(engineType, loadErrorCode.getInt(), loadErrorCode.getString());
                    if (sIsUploading) {
                        addBkupList(errorItem);
                    } else {
                        record(errorItem);
                    }
                }
            }
        }

        public static void record(ErrorItem errorItem) {
            if (errorItem.mEngineType == 1 && errorItem.mErrorCode != 0) {
                for (ErrorItem errorItem2 : sErrorList) {
                    if (errorItem2.mEngineType == errorItem.mEngineType && errorItem2.mErrorCode == errorItem.mErrorCode) {
                        errorItem2.mCount++;
                        return;
                    }
                }
                sErrorList.add(errorItem);
            }
        }

        public static synchronized void reset() {
            synchronized (Statistics.class) {
                addInfo("reset");
                if (!sIsInited) {
                    Log.e(TAG, "[ERROR]reset before init");
                    return;
                }
                sRecordFile.delete();
                sErrorList.clear();
                sIsUploading = false;
                cleanBkupList();
            }
        }
    }

    public LoadErrorCode(int i) {
        this.mErrorCode = i;
        this.mDetails = new StringBuilder();
    }

    public LoadErrorCode(int i, String str) {
        this.mErrorCode = i;
        this.mDetails = new StringBuilder(str);
    }

    public static synchronized LoadErrorCode getInstance() {
        LoadErrorCode loadErrorCode;
        synchronized (LoadErrorCode.class) {
            if (mInstance == null) {
                mInstance = new LoadErrorCode(0);
            }
            loadErrorCode = mInstance;
        }
        return loadErrorCode;
    }

    public static Throwable getRootCause(Throwable th) {
        if (th != null) {
            while (th.getCause() != null) {
                th = th.getCause();
            }
        }
        return th;
    }

    public static String getRootMessage(Throwable th) {
        Throwable rootCause = getRootCause(th);
        return rootCause == null ? "" : rootCause.toString();
    }

    public synchronized void clear() {
        this.mErrorCode = 0;
        this.mDetails = null;
    }

    public synchronized int getEngineType() {
        return 1;
    }

    public synchronized int getInt() {
        return this.mErrorCode;
    }

    public synchronized String getString() {
        if (this.mDetails != null && this.mDetails.length() > 0) {
            return this.mDetails.toString();
        }
        return "none";
    }

    public synchronized void set(int i) {
        if (this.mErrorCode == 0) {
            this.mErrorCode = i;
        }
    }

    public synchronized void set(int i, String str) {
        set(i);
        trace(str);
    }

    public synchronized void trace(int i) {
        trace(String.valueOf(i));
    }

    public synchronized void trace(String str) {
        if (this.mDetails == null) {
            this.mDetails = new StringBuilder(str);
            return;
        }
        if (this.mDetails.length() > 0) {
            this.mDetails.append(TOKEN_NEXT);
        }
        this.mDetails.append(str);
    }
}
