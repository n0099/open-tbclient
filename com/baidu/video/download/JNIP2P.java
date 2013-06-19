package com.baidu.video.download;

import android.util.Log;
/* loaded from: classes.dex */
public class JNIP2P {
    private static JNIP2P instance = new JNIP2P();

    public native int netAppIDInit(String str);

    public native int netCreate(JNITaskCreateParam jNITaskCreateParam);

    public native int netDelete(long j);

    public native int netDeleteFile(String str, String str2, long j);

    public native int netFileExist(String str, String str2, long j);

    public native int netGetBlockInfo(long j, JNITaskBuffer jNITaskBuffer, long j2);

    public native int netGetRedirectUrl(long j, JNITaskInfo jNITaskInfo);

    public native int netInit(String str, Object obj);

    public native int netInitV2(String str);

    public native int netParseURL(String str, JNITaskInfo jNITaskInfo);

    public native int netQueryTaskInfo(long j, JNITaskInfo jNITaskInfo);

    public native int netQuit();

    public native int netSetDeviceID(String str);

    public native int netSetLogLevel(int i);

    public native int netSetMediaTime(long j, int i);

    public native int netSetNetworkStatus(boolean z);

    public native int netSetPlaying(long j, boolean z);

    public native int netSetSpeedLimit(int i);

    public native int netStart(long j);

    public native int netStatReport(String str, String str2, String str3, String str4, String str5);

    public native int netStop(long j);

    /* loaded from: classes.dex */
    public class TASK_STATUS_CODE {
        public static final int TSC_COMPLETE = 5;
        public static final int TSC_CONNECT = 3;
        public static final int TSC_DOWNLOAD = 4;
        public static final int TSC_ERROR = 1;
        public static final int TSC_NOITEM = 0;
        public static final int TSC_PAUSE = 2;
        public static final int TSC_QUEUE = 6;

        public TASK_STATUS_CODE() {
        }
    }

    /* loaded from: classes.dex */
    public class TASK_FAIL_CODE {
        public static final int TFC_ALREADY_EXIST = 5;
        public static final int TFC_DISK_SPACE = 2;
        public static final int TFC_FILE_ERROR = 3;
        public static final int TFC_FORBIDDEN = 8;
        public static final int TFC_NOERROR = 0;
        public static final int TFC_NOT_SUPPORT = 6;
        public static final int TFC_RENAME_FAIL = 7;
        public static final int TFC_SOURCE_FAIL = 4;
        public static final int TFC_TIME_OUT = 1;

        public TASK_FAIL_CODE() {
        }
    }

    /* loaded from: classes.dex */
    public class APIErrorCode {
        public static final int API_ERROR_BUFFER = -5;
        public static final int API_ERROR_CREATE_FAIL = -7;
        public static final int API_ERROR_HANDLE = -2;
        public static final int API_ERROR_LINK = -4;
        public static final int API_ERROR_NOT_FOUND = -6;
        public static final int API_ERROR_PARAM = -1;
        public static final int API_ERROR_SHUTDOWN = -8;
        public static final int API_ERROR_UNKONWN = -3;
        public static final int API_SUCCESS = 0;

        public APIErrorCode() {
        }
    }

    /* loaded from: classes.dex */
    class LogWrapper {
        private boolean isVerbose;
        private String message;

        public LogWrapper(String str) {
            this(str, false);
        }

        public LogWrapper(String str, boolean z) {
            this.message = "";
            this.isVerbose = false;
            this.message = str;
            this.isVerbose = z;
            log(true);
        }

        public void release() {
            log(false);
        }

        private void log(boolean z) {
            if (this.isVerbose) {
                Log.v(":download", String.valueOf(this.message) + (z ? " start" : " end"));
            } else {
                Log.d(":download", String.valueOf(this.message) + (z ? " start" : " end"));
            }
        }
    }

    static {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("p2p-jni");
    }

    public static JNIP2P getInstance() {
        return instance;
    }

    private JNIP2P() {
    }

    public int appIDInit(String str) {
        LogWrapper logWrapper = new LogWrapper("netAppIDInit");
        try {
            return netAppIDInit(str);
        } finally {
            logWrapper.release();
        }
    }

    public int init(String str, Object obj) {
        LogWrapper logWrapper = new LogWrapper("netInit");
        try {
            return netInit(str, obj);
        } finally {
            logWrapper.release();
        }
    }

    public int initV2(String str) {
        LogWrapper logWrapper = new LogWrapper("netInitV2");
        try {
            return netInitV2(str);
        } finally {
            logWrapper.release();
        }
    }

    public int uninit() {
        LogWrapper logWrapper = new LogWrapper("netQuit");
        try {
            return netQuit();
        } finally {
            logWrapper.release();
        }
    }

    public int create(JNITaskCreateParam jNITaskCreateParam) {
        LogWrapper logWrapper = new LogWrapper("create");
        try {
            return netCreate(jNITaskCreateParam);
        } finally {
            logWrapper.release();
        }
    }

    public int start(long j) {
        LogWrapper logWrapper = new LogWrapper("netStart");
        try {
            return netStart(j);
        } finally {
            logWrapper.release();
        }
    }

    public int stop(long j) {
        LogWrapper logWrapper = new LogWrapper("netStop");
        try {
            return netStop(j);
        } finally {
            logWrapper.release();
        }
    }

    public int delete(long j) {
        LogWrapper logWrapper = new LogWrapper("netDelete");
        try {
            return netDelete(j);
        } finally {
            logWrapper.release();
        }
    }

    public int query(long j, JNITaskInfo jNITaskInfo) {
        LogWrapper logWrapper = new LogWrapper("netQueryTaskInfo", true);
        try {
            return netQueryTaskInfo(j, jNITaskInfo);
        } finally {
            logWrapper.release();
        }
    }

    public int parseUrl(String str, JNITaskInfo jNITaskInfo) {
        LogWrapper logWrapper = new LogWrapper("netParseURL");
        try {
            return netParseURL(str, jNITaskInfo);
        } finally {
            logWrapper.release();
        }
    }

    public int deleteFile(String str, String str2, long j) {
        LogWrapper logWrapper = new LogWrapper("netDeleteFile");
        try {
            return netDeleteFile(str, str2, j);
        } finally {
            logWrapper.release();
        }
    }

    public int isFileExist(String str, String str2, long j) {
        LogWrapper logWrapper = new LogWrapper("netFileExist");
        try {
            return netFileExist(str, str2, j);
        } finally {
            logWrapper.release();
        }
    }

    public int setSpeedLimit(int i) {
        LogWrapper logWrapper = new LogWrapper("netSetSpeedLimit", true);
        try {
            return netSetSpeedLimit(i);
        } finally {
            logWrapper.release();
        }
    }

    public int getBlock(long j, JNITaskBuffer jNITaskBuffer) {
        LogWrapper logWrapper = new LogWrapper("netGetBlockInfo", true);
        try {
            return netGetBlockInfo(j, jNITaskBuffer, (long) JNITaskBuffer.BufferSize);
        } finally {
            logWrapper.release();
        }
    }

    public int setLogLevel(int i) {
        LogWrapper logWrapper = new LogWrapper("netSetLogLevel", true);
        try {
            return netSetLogLevel(i);
        } finally {
            logWrapper.release();
        }
    }

    public int setPlaying(long j, boolean z) {
        LogWrapper logWrapper = new LogWrapper("netSetPlaying");
        try {
            return netSetPlaying(j, z);
        } finally {
            logWrapper.release();
        }
    }

    public int setDeviceId(String str) {
        LogWrapper logWrapper = new LogWrapper("setDeviceId");
        try {
            return netSetDeviceID(str);
        } finally {
            logWrapper.release();
        }
    }

    public int setMediaTime(long j, int i) {
        LogWrapper logWrapper = new LogWrapper("setMediaTime");
        try {
            return netSetMediaTime(j, i);
        } finally {
            logWrapper.release();
        }
    }

    public int getRedirectUrl(long j, JNITaskInfo jNITaskInfo) {
        LogWrapper logWrapper = new LogWrapper("getRedirectUrl");
        try {
            return netGetRedirectUrl(j, jNITaskInfo);
        } finally {
            logWrapper.release();
        }
    }

    public int statReport(String str, String str2, String str3, String str4) {
        LogWrapper logWrapper = new LogWrapper("statReport");
        try {
            return netStatReport("bdp_adr", str, str3, str2, str4);
        } finally {
            logWrapper.release();
        }
    }
}
