package com.baidu.webkit.sdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LoadErrorCode {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APK_FILE_NOT_EXIST = 1009;
    public static final String COLON = ":";
    public static final int CREATE_PATH_FAIL = 1016;
    public static final int DELETE_SAVING_CLASS_FAIL = 1018;
    public static final int DOWNLOAD_CANCEL_IN_DOWNLOAD_HELPER = 1026;
    public static final int DOWNLOAD_FAIL_IN_DOWNLOAD_HELPER = 1025;
    public static final int ENGINE_MANAGER_INSTALL_WRONG_URL = 1024;
    public static final int ENGINE_MANAGER_IS_INSTALLING = 1023;
    public static final int GET_INTERN_PACKAGEINFO_FAIL = 2;
    public static final int GET_PACKAGEINFO_FAIL = 1;
    public static final int GET_PROVIDER_BACKUP_FAIL = 5;
    public static final int GET_PROVIDER_FAIL = 4;
    public static final int GET_PROVIDER_NO_EXCEPTION = 6;
    public static final int GET_SHARED_PACKAGEINFO_FAIL = 3;
    public static final int MSG_CHECK_REVERT_ZEUS = 519;
    public static final int MSG_ENABLE_BLACK_LIST = 515;
    public static final int MSG_ERROR_NATIVE_LIB_DIR = 508;
    public static final int MSG_EXPAND_LIB_DIR_FAIL = 509;
    public static final int MSG_FORCE_USING_SYS_WEBVIEW = 511;
    public static final int MSG_REMOVE_UNUSED_FILES_ERROR = 517;
    public static final int MSG_RESET_ZEUS_ERROR = 516;
    public static final int MSG_SDK_JAR_DISMATCH = 521;
    public static final int MSG_SDK_LIB_DISMATCH = 522;
    public static final int MSG_SDK_ZEUS_DISMATCH = 500;
    public static final int MSG_STATISTICS_INTERN_ERROR = 514;
    public static final int MSG_SZ_CHECK_TIMESTAMP_FAIL = 506;
    public static final int MSG_SZ_JNI_ERROR = 512;
    public static final int MSG_SZ_LOCK_FAIL1 = 503;
    public static final int MSG_SZ_LOCK_FAIL2 = 504;
    public static final int MSG_SZ_NO_LIB_DIRECTORY = 507;
    public static final int MSG_SZ_PREPARE_FAIL1 = 501;
    public static final int MSG_SZ_PREPARE_FAIL2 = 502;
    public static final int MSG_SZ_PREPARE_FAIL3 = 518;
    public static final int MSG_SZ_UNLOCK_FAIL = 505;
    public static final int MSG_USE_SYS_UNDER_ANDROID5 = 520;
    public static final int MSG_WEBKIT_MANAGER_IS_NULL = 523;
    public static final int MSG_ZEUS_DISABLED_BY_CLOUD = 510;
    public static final int MSG_ZEUS_NOT_EXIST = 513;
    public static final int NONE = 0;
    public static final int NOT_VALUEABLE_CLIENT = 1005;
    public static final int NOT_VALUEABLE_CONTEXT = 1002;
    public static final int NOT_VALUEABLE_DOWNLOAD_PATH1 = 1006;
    public static final int NOT_VALUEABLE_DOWNLOAD_PATH2 = 1007;
    public static final int NOT_VALUEABLE_URL = 1004;
    public static final int NOT_WIFI = 1001;
    public static final int NO_USER_PRIVACY = 1000;
    public static final int NULL_ENGINE_MANAGER_INSTALL_LISTENER = 1021;
    public static final int NULL_ENGINE_MANAGER_INSTALL_URL = 1022;
    public static final int NULL_ZEUS_FILE = 1014;
    public static final int NULL_ZEUS_FILE_PATH = 1013;
    public static final int NULL_ZEUS_MANEGER_OR_CONTEXT = 1012;
    public static final int REMOVE_SO_FILE_FAIL = 1015;
    public static final int RETRY_INSTALL_ZEUS_MORE_THAN_MAX = 1020;
    public static final int RETRY_INSTALL_ZEUS_NULL_PATH = 1019;
    public static final int START_DOWNLOAD_FAIL = 1008;
    public static final int T7_VERSION_NOT_MATCH = 1003;
    public static final String TAG = "LoadErrorCode";
    public static final String TOKEN_NEXT = " -> ";
    public static final String TOKEN_NONE = "none";
    public static final int UNZIP_DOWNLOAD_FILE_FAIL = 1017;
    public static final int UNZIP_LZMA_ERROR = 100;
    public static final int UNZIP_LZMA_WRITE_BACK_FAIL = 101;
    public static final int UNZIP_TASK_FAILED = 103;
    public static final int UNZIP_TASK_TIMEOUT = 102;
    public static final int WRONG_FILE_LENGTH = 1010;
    public static final int WRONG_FILE_MD5 = 1011;
    public static LoadErrorCode mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile StringBuilder mDetails;
    public volatile JSONArray mDownloadInfo;
    public volatile int mErrorCode;

    /* loaded from: classes4.dex */
    public static class Statistics {
        public static /* synthetic */ Interceptable $ic = null;
        public static final boolean DEBUG = true;
        public static final String KEY_ERROR_CNT = "error_cnt";
        public static final String KEY_ERROR_CODE = "error_code";
        public static final String KEY_ERROR_REASON = "error_reason";
        public static final String KEY_T7_ERROR_LIST = "t7_error_list";
        public static final String KEY_T7_STRAT_CNT = "t7_start_cnt";
        public static final String RECORD_FILE_NAME;
        public static final String RECORD_RELATIVE_PATH;
        public static final String TAG = "LoadErrorStatistics";
        public static volatile StringBuilder mInfo;
        public static volatile List<ErrorItem> sBkupList;
        public static volatile List<ErrorItem> sErrorList;
        public static volatile boolean sIsInited;
        public static volatile boolean sIsUploading;
        public static volatile File sRecordFile;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class ErrorItem {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mCount;
            public String mDetails;
            public int mEngineType;
            public int mErrorCode;

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public ErrorItem(int i, int i2, String str) {
                this(i, i2, str, 1);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            public ErrorItem(int i, int i2, String str, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.mEngineType = i;
                this.mErrorCode = i2;
                this.mDetails = str;
                this.mCount = i3;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1116831729, "Lcom/baidu/webkit/sdk/LoadErrorCode$Statistics;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1116831729, "Lcom/baidu/webkit/sdk/LoadErrorCode$Statistics;");
                    return;
                }
            }
            RECORD_RELATIVE_PATH = "/zeus/statistics/".replace((char) WebvttCueParser.CHAR_SLASH, File.separatorChar);
            RECORD_FILE_NAME = "/load_error.json".replace((char) WebvttCueParser.CHAR_SLASH, File.separatorChar);
        }

        public Statistics() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0036 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0038 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0048 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0010 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0010 */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean JSONToFile(JSONObject jSONObject) {
            InterceptResult invokeL;
            byte[] bytes;
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
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
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int length = bytes.length;
                    fileOutputStream.write(bytes, 0, length);
                    fileOutputStream.flush();
                    z = true;
                    fileOutputStream.close();
                    fileOutputStream2 = length;
                } catch (Exception e3) {
                    e = e3;
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
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
                if (!z) {
                    sRecordFile.delete();
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public static boolean JSONToList(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                boolean z = false;
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(KEY_T7_ERROR_LIST);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        sErrorList.add(new ErrorItem(1, jSONObject2.getInt("error_code"), jSONObject2.getString(KEY_ERROR_REASON), jSONObject2.getInt(KEY_ERROR_CNT)));
                    }
                    z = true;
                } catch (Exception e) {
                    addInfo(e.getMessage());
                    e.printStackTrace();
                }
                if (!z) {
                    sRecordFile.delete();
                    sErrorList.clear();
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public static void addBkupList(ErrorItem errorItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, errorItem) == null) {
                if (sBkupList == null) {
                    sBkupList = new LinkedList();
                }
                sBkupList.add(errorItem);
            }
        }

        public static synchronized void addInfo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
                synchronized (Statistics.class) {
                    if (mInfo == null) {
                        mInfo = new StringBuilder();
                    }
                    if (mInfo.length() > 0) {
                        mInfo.append(LoadErrorCode.TOKEN_NEXT.concat(String.valueOf(str)));
                    } else {
                        mInfo.append(str);
                    }
                }
            }
        }

        public static void cleanBkupList() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65542, null) == null) || sBkupList == null) {
                return;
            }
            for (ErrorItem errorItem : sBkupList) {
                record(errorItem);
            }
            sBkupList = null;
        }

        public static synchronized void destroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, null) == null) {
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
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0060 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r0v6 */
        public static JSONObject fileToJSON() {
            InterceptResult invokeV;
            JSONObject jSONObject;
            Exception e;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(65544, null)) != null) {
                return (JSONObject) invokeV.objValue;
            }
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
                                Log.d(TAG, "readJSON ".concat(String.valueOf(jSONObject)));
                                jSONObject2 = jSONObject;
                            } catch (Exception e2) {
                                e = e2;
                                addInfo(e.getMessage());
                                e.printStackTrace();
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
                    } catch (Exception e3) {
                        jSONObject = null;
                        e = e3;
                    }
                } catch (Exception e4) {
                    jSONObject = null;
                    e = e4;
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
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
                    } catch (JSONException e) {
                        return e.getMessage();
                    }
                }
            }
            return (String) invokeV.objValue;
        }

        public static synchronized void init(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
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
        }

        public static JSONObject listToJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
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
                    e.printStackTrace();
                    addInfo(e.getMessage());
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }

        public static String map(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                byte[] bytes = jSONObject.toString().getBytes();
                for (int i = 0; i < bytes.length; i++) {
                    byte b = bytes[i];
                    if (b == 34) {
                        bytes[i] = Cea608Decoder.CTRL_END_OF_CAPTION;
                    } else if (b == 91) {
                        bytes[i] = 60;
                    } else if (b == 93) {
                        bytes[i] = 62;
                    } else if (b == 123) {
                        bytes[i] = 40;
                    } else if (b == 125) {
                        bytes[i] = Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING;
                    }
                }
                return new String(bytes);
            }
            return (String) invokeL.objValue;
        }

        public static synchronized void record() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65549, null) == null) {
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
        }

        public static void record(ErrorItem errorItem) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65550, null, errorItem) == null) && errorItem.mEngineType == 1 && errorItem.mErrorCode != 0) {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65551, null) == null) {
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
    }

    public LoadErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mErrorCode = i;
        this.mDetails = new StringBuilder();
        this.mDownloadInfo = new JSONArray();
    }

    public LoadErrorCode(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mErrorCode = i;
        this.mDetails = new StringBuilder(str);
        this.mDownloadInfo = new JSONArray();
    }

    public static synchronized LoadErrorCode getInstance() {
        InterceptResult invokeV;
        LoadErrorCode loadErrorCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (LoadErrorCode.class) {
                if (mInstance == null) {
                    mInstance = new LoadErrorCode(0);
                }
                loadErrorCode = mInstance;
            }
            return loadErrorCode;
        }
        return (LoadErrorCode) invokeV.objValue;
    }

    public static Throwable getRootCause(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            if (th != null) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
            }
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static String getRootMessage(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            Throwable rootCause = getRootCause(th);
            return rootCause == null ? "" : rootCause.toString();
        }
        return (String) invokeL.objValue;
    }

    public synchronized void addDownloadInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            synchronized (this) {
                addDownloadInfo(String.valueOf(i));
            }
        }
    }

    public synchronized void addDownloadInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                if (this.mDownloadInfo == null) {
                    this.mDownloadInfo = new JSONArray();
                }
                this.mDownloadInfo.put(str);
            }
        }
    }

    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.mErrorCode = 0;
                this.mDetails = null;
                this.mDownloadInfo = null;
            }
        }
    }

    public synchronized JSONArray getDownloadInfo() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.mDownloadInfo == null || this.mDownloadInfo.length() <= 0) {
                    addDownloadInfo(0);
                }
                jSONArray = this.mDownloadInfo;
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public synchronized int getEngineType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public synchronized int getInt() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                i = this.mErrorCode;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized String getString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.mDetails != null && this.mDetails.length() > 0) {
                    return this.mDetails.toString();
                }
                return "none";
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized void set(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            synchronized (this) {
                if (this.mErrorCode == 0) {
                    this.mErrorCode = i;
                }
            }
        }
    }

    public synchronized void set(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            synchronized (this) {
                set(i);
                trace(str);
            }
        }
    }

    public synchronized void trace(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            synchronized (this) {
                trace(String.valueOf(i));
            }
        }
    }

    public synchronized void trace(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
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
    }
}
