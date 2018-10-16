package com.baidu.webkit.sdk;

import android.content.Context;
import com.a.a.a.a.a.a.a;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LoadErrorCode {
    public static final String COLON = ":";
    public static final int GET_INTERN_PACKAGEINFO_FAIL = 2;
    public static final int GET_PACKAGEINFO_FAIL = 1;
    public static final int GET_PROVIDER_BACKUP_FAIL = 5;
    public static final int GET_PROVIDER_FAIL = 4;
    public static final int GET_PROVIDER_NO_EXCEPTION = 6;
    public static final int GET_SHARED_PACKAGEINFO_FAIL = 3;
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
    private static final String TAG = "LoadErrorCode";
    private static final String TOKEN_NEXT = " -> ";
    private static final String TOKEN_NONE = "none";
    public static final int UNZIP_LZMA_ERROR = 100;
    public static final int UNZIP_LZMA_WRITE_BACK_FAIL = 101;
    public static final int UNZIP_TASK_FAILED = 103;
    public static final int UNZIP_TASK_TIMEOUT = 102;
    private static LoadErrorCode mInstance = null;
    private volatile StringBuilder mDetails;
    private volatile int mErrorCode;

    /* loaded from: classes2.dex */
    public static class Statistics {
        private static final boolean DEBUG = true;
        private static final String KEY_ERROR_CNT = "error_cnt";
        private static final String KEY_ERROR_CODE = "error_code";
        private static final String KEY_ERROR_REASON = "error_reason";
        private static final String KEY_T7_ERROR_LIST = "t7_error_list";
        private static final String KEY_T7_STRAT_CNT = "t7_start_cnt";
        private static final String TAG = "LoadErrorStatistics";
        private static volatile StringBuilder mInfo;
        private static volatile List<ErrorItem> sBkupList;
        private static volatile List<ErrorItem> sErrorList;
        private static volatile File sRecordFile;
        private static final String RECORD_RELATIVE_PATH = "/zeus/statistics/".replace('/', File.separatorChar);
        private static final String RECORD_FILE_NAME = "/load_error.json".replace('/', File.separatorChar);
        private static volatile boolean sIsInited = false;
        private static volatile boolean sIsUploading = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
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

        /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static boolean JSONToFile(JSONObject jSONObject) {
            FileOutputStream fileOutputStream;
            boolean z;
            sRecordFile.delete();
            try {
                sRecordFile.createNewFile();
            } catch (Exception e) {
            }
            try {
                byte[] bytes = jSONObject.toString().getBytes();
                fileOutputStream = new FileOutputStream(sRecordFile);
                try {
                    try {
                        fileOutputStream.write(bytes, 0, bytes.length);
                        fileOutputStream.flush();
                        z = true;
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            a.a(e2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        addInfo(e.getMessage());
                        a.a(e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                z = false;
                            } catch (Exception e4) {
                                a.a(e4);
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                            a.a(e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                }
                throw th;
            }
            if (!z) {
                sRecordFile.delete();
            }
            return z;
        }

        private static boolean JSONToList(JSONObject jSONObject) {
            boolean z = true;
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(KEY_T7_ERROR_LIST);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sErrorList.add(new ErrorItem(1, jSONObject2.getInt("error_code"), jSONObject2.getString(KEY_ERROR_REASON), jSONObject2.getInt(KEY_ERROR_CNT)));
                }
            } catch (Exception e) {
                addInfo(e.getMessage());
                a.a(e);
                z = false;
            }
            if (!z) {
                sRecordFile.delete();
                sErrorList.clear();
            }
            return z;
        }

        private static void addBkupList(ErrorItem errorItem) {
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
                if (mInfo.length() > 0) {
                    mInfo.append(LoadErrorCode.TOKEN_NEXT + str);
                } else {
                    mInfo.append(str);
                }
            }
        }

        private static void cleanBkupList() {
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

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0064 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:3:0x0007 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: org.json.JSONObject */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v9 */
        private static JSONObject fileToJSON() {
            FileInputStream fileInputStream;
            JSONObject jSONObject = 0;
            jSONObject = 0;
            jSONObject = 0;
            jSONObject = 0;
            try {
                if (sRecordFile.exists()) {
                    try {
                        fileInputStream = new FileInputStream(sRecordFile);
                        try {
                            int available = fileInputStream.available();
                            if (available > 0) {
                                byte[] bArr = new byte[available];
                                fileInputStream.read(bArr);
                                JSONObject jSONObject2 = new JSONObject(new String(bArr));
                                try {
                                    Log.d(TAG, "readJSON " + jSONObject2);
                                    jSONObject = jSONObject2;
                                } catch (Exception e) {
                                    jSONObject = jSONObject2;
                                    e = e;
                                    addInfo(e.getMessage());
                                    a.a(e);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    return jSONObject;
                                }
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                jSONObject.close();
                            } catch (IOException e6) {
                            }
                        }
                        throw th;
                    }
                }
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
            if (r0.isEmpty() == false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static synchronized String getString() {
            String message;
            synchronized (Statistics.class) {
                if (sIsInited) {
                    if (sIsUploading) {
                        cleanBkupList();
                    }
                    sIsUploading = true;
                    message = map(listToJSON());
                    if (message != null) {
                        message = message.trim();
                    }
                    if (message != null) {
                    }
                } else {
                    Log.e(TAG, "[ERROR]getString before init");
                }
                StringBuilder sb = new StringBuilder(mInfo == null ? "" : mInfo);
                sb.append(LoadErrorCode.TOKEN_NEXT).append(String.valueOf(sIsInited));
                sb.append(LoadErrorCode.TOKEN_NEXT).append(String.valueOf(sIsUploading));
                sb.append(LoadErrorCode.TOKEN_NEXT).append(String.valueOf(LoadErrorCode.getInstance().getInt()));
                sb.append(LoadErrorCode.TOKEN_NEXT).append(LoadErrorCode.getInstance().getString());
                mInfo = null;
                if (sb.length() >= 512) {
                    sb.substring(0, 511);
                }
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("error_code", LoadErrorCode.MSG_STATISTICS_INTERN_ERROR);
                    jSONObject.put(KEY_ERROR_REASON, sb.toString());
                    jSONObject.put(KEY_ERROR_CNT, 1);
                    jSONArray.put(jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(KEY_T7_ERROR_LIST, jSONArray);
                    message = jSONObject2.toString();
                } catch (JSONException e) {
                    message = e.getMessage();
                }
            }
            return message;
        }

        public static synchronized void init(Context context) {
            synchronized (Statistics.class) {
                addInfo(AiAppsRouteMessage.TYPE_INIT);
                if (context == null) {
                    Log.e(TAG, "[ERROR]init ctx null");
                } else if (!sIsInited) {
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

        private static JSONObject listToJSON() {
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
            } catch (JSONException e) {
                a.a(e);
                addInfo(e.getMessage());
                return null;
            }
        }

        private static String map(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            byte[] bytes = jSONObject.toString().getBytes();
            for (int i = 0; i < bytes.length; i++) {
                switch (bytes[i]) {
                    case 34:
                        bytes[i] = 47;
                        break;
                    case 91:
                        bytes[i] = 60;
                        break;
                    case 93:
                        bytes[i] = 62;
                        break;
                    case 123:
                        bytes[i] = 40;
                        break;
                    case 125:
                        bytes[i] = 41;
                        break;
                }
            }
            return new String(bytes);
        }

        public static synchronized void record() {
            synchronized (Statistics.class) {
                addInfo("record");
                LoadErrorCode loadErrorCode = LoadErrorCode.getInstance();
                if (!sIsInited) {
                    Log.e(TAG, "[ERROR]record before init");
                } else if (loadErrorCode == null) {
                    Log.e(TAG, "[ERORR]record error code null");
                } else {
                    int engineType = loadErrorCode.getEngineType();
                    if (engineType == 1) {
                        ErrorItem errorItem = new ErrorItem(engineType, loadErrorCode.getInt(), loadErrorCode.getString());
                        if (sIsUploading) {
                            addBkupList(errorItem);
                        } else {
                            record(errorItem);
                        }
                    }
                }
            }
        }

        private static void record(ErrorItem errorItem) {
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
                if (sIsInited) {
                    sRecordFile.delete();
                    sErrorList.clear();
                    sIsUploading = false;
                    cleanBkupList();
                } else {
                    Log.e(TAG, "[ERROR]reset before init");
                }
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
        return (this.mDetails == null || this.mDetails.length() <= 0) ? TOKEN_NONE : this.mDetails.toString();
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
        } else {
            if (this.mDetails.length() > 0) {
                this.mDetails.append(TOKEN_NEXT);
            }
            this.mDetails.append(str);
        }
    }
}
