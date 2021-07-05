package com.bytedance.sdk.component.net.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.z;
import com.bytedance.sdk.component.net.utils.Logger;
import com.bytedance.sdk.component.net.utils.NetworkUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* loaded from: classes6.dex */
public class TNCManager implements TNCBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_UPDATE_REMOTE = 10000;
    public static final String TAG = "TNCManager";
    public static final long TNC_DATA_VERSION_DEFAULT = 19700101000L;
    public static final int TNC_HOST_REEPLACE_FAIILD_NUM = 3;
    public static final int TNC_PROBE_CMD_GET_DOMAIN = 10000;
    public static final int TNC_PROBE_CMD_TEST = 1000;
    public static final String TNC_PROBE_HEADER = "tnc-cmd";
    public static final String TNC_PROBE_HEADER_SECEPTOR = "@";
    public static final String TNC_SP_NAME = "ttnet_tnc_config";
    public static TNCManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Integer> hostReplaceMapFailed;
    public AppConfig mAppConfig;
    public Context mContext;
    public Handler mHandler;
    public ITTAdNetDepend mITTAdNetDepend;
    public boolean mInited;
    public boolean mIsMainProcess;
    public long mLastDoUpdateTime;
    public HashMap<String, Integer> mReqErrApiMap;
    public HashMap<String, Integer> mReqErrIpMap;
    public int mReqErrorCnt;
    public HashMap<String, Integer> mReqToApiMap;
    public int mReqToCnt;
    public HashMap<String, Integer> mReqToIpMap;
    public TNCConfigHandler mTNCConfigHandler;
    public int mTncProbeCmd;
    public long mTncProbeVersion;
    public boolean mURLDispatchEnabled;

    public TNCManager() {
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
        this.mLastDoUpdateTime = 0L;
        this.mInited = false;
        this.mTncProbeCmd = 0;
        this.mTncProbeVersion = TNC_DATA_VERSION_DEFAULT;
        this.mReqToCnt = 0;
        this.mReqToApiMap = new HashMap<>();
        this.mReqToIpMap = new HashMap<>();
        this.mReqErrorCnt = 0;
        this.mReqErrApiMap = new HashMap<>();
        this.mReqErrIpMap = new HashMap<>();
        this.mIsMainProcess = true;
        this.hostReplaceMapFailed = new HashMap();
        this.mHandler = new Handler(this, Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.net.tnc.TNCManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TNCManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 10000) {
                    this.this$0.doUpdateRemote(message.arg1 != 0);
                }
            }
        };
    }

    private void addTNCHostReplaceNum(String str) {
        Map<String, String> tNCHostReplaceMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || TextUtils.isEmpty(str) || (tNCHostReplaceMap = getTNCHostReplaceMap()) == null || !tNCHostReplaceMap.containsValue(str)) {
            return;
        }
        if (this.hostReplaceMapFailed.get(str) == null) {
            this.hostReplaceMapFailed.put(str, 1);
        } else {
            this.hostReplaceMapFailed.put(str, Integer.valueOf(this.hostReplaceMapFailed.get(str).intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateRemote(boolean z) {
        TNCConfig tNCConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, this, z) == null) || (tNCConfig = getTNCConfig()) == null) {
            return;
        }
        Logger.debug(TAG, "doUpdateRemote, " + z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.mLastDoUpdateTime + (tNCConfig.updateInterval * 1000) > elapsedRealtime) {
            Logger.debug(TAG, "doUpdateRemote, time limit");
            return;
        }
        this.mLastDoUpdateTime = elapsedRealtime;
        AppConfig.getInstance(this.mContext).doRefresh(NetworkUtils.checkWifiAndGPRS(this.mContext));
    }

    private String getConnectionIpStr(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, zVar)) == null) {
            if (zVar == null || zVar.a() == null) {
                return "";
            }
            if (zVar.a().a() != null) {
                try {
                } catch (Exception unused) {
                    return "";
                }
            }
            return InetAddress.getByName(zVar.a().a().getHost()).getHostAddress();
        }
        return (String) invokeL.objValue;
    }

    private String getExceptionStr(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, exc)) == null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString().toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized TNCManager getInstance() {
        InterceptResult invokeV;
        TNCManager tNCManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (TNCManager.class) {
                if (sInstance == null) {
                    sInstance = new TNCManager();
                }
                tNCManager = sInstance;
            }
            return tNCManager;
        }
        return (TNCManager) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleTncProbe(ab abVar, String str) {
        int i2;
        long j;
        TNCConfig tNCConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, this, abVar, str) == null) && abVar != null && this.mIsMainProcess) {
            String a2 = abVar.a(TNC_PROBE_HEADER, null);
            if (TextUtils.isEmpty(a2)) {
                Logger.debug(TAG, "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] split = a2.split(TNC_PROBE_HEADER_SECEPTOR);
            if (split != null && split.length == 2) {
                try {
                    i2 = Integer.parseInt(split[0]);
                } catch (Throwable th) {
                    th = th;
                    i2 = 0;
                }
                try {
                    j = Long.parseLong(split[1]);
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    Logger.debug(TAG, "handleTncProbe, probeProto except, " + str);
                    j = 0L;
                    Logger.debug(TAG, "handleTncProbe, local: " + this.mTncProbeCmd + TNC_PROBE_HEADER_SECEPTOR + this.mTncProbeVersion + " svr: " + i2 + TNC_PROBE_HEADER_SECEPTOR + j + " " + str);
                    if (j > this.mTncProbeVersion) {
                    }
                }
                Logger.debug(TAG, "handleTncProbe, local: " + this.mTncProbeCmd + TNC_PROBE_HEADER_SECEPTOR + this.mTncProbeVersion + " svr: " + i2 + TNC_PROBE_HEADER_SECEPTOR + j + " " + str);
                if (j > this.mTncProbeVersion) {
                    return;
                }
                this.mTncProbeCmd = i2;
                this.mTncProbeVersion = j;
                this.mContext.getSharedPreferences(TNC_SP_NAME, 0).edit().putInt("tnc_probe_cmd", i2).putLong("tnc_probe_version", j).apply();
                if (this.mTncProbeCmd != 10000 || (tNCConfig = getTNCConfig()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i3 = tNCConfig.updateRandomRange;
                long nextInt = i3 > 0 ? random.nextInt(i3) * 1000 : 0L;
                Logger.debug(TAG, "handleTncProbe, updateConfig delay: " + nextInt + " " + str);
                sendUpdateMsg(true, nextInt);
                return;
            }
            Logger.debug(TAG, "handleTncProbe, probeProto err, " + str);
        }
    }

    private boolean isHttpRespCodeInBlack(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            if (i2 < 100 || i2 >= 1000) {
                return true;
            }
            TNCConfig tNCConfig = getTNCConfig();
            if (tNCConfig == null || TextUtils.isEmpty(tNCConfig.httpCodeBlack)) {
                return false;
            }
            String str = tNCConfig.httpCodeBlack;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(i2);
            return str.contains(sb.toString());
        }
        return invokeI.booleanValue;
    }

    private boolean isHttpRespCodeOk(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, this, i2)) == null) ? i2 >= 200 && i2 < 400 : invokeI.booleanValue;
    }

    private boolean isTNCHostFailedOverLimit(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            Map<String, String> tNCHostReplaceMap = getTNCHostReplaceMap();
            if (tNCHostReplaceMap == null) {
                return false;
            }
            String str2 = tNCHostReplaceMap.get(str);
            if (TextUtils.isEmpty(str2) || this.hostReplaceMapFailed.get(str2) == null || this.hostReplaceMapFailed.get(str2).intValue() < 3) {
                return false;
            }
            Logger.debug(TAG, "handleHostMapping, TNC host faild num over limit: " + str);
            return true;
        }
        return invokeL.booleanValue;
    }

    private void loadProbeInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(TNC_SP_NAME, 0);
            this.mTncProbeCmd = sharedPreferences.getInt("tnc_probe_cmd", 0);
            this.mTncProbeVersion = sharedPreferences.getLong("tnc_probe_version", TNC_DATA_VERSION_DEFAULT);
        }
    }

    private void resetTNCControlState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            Logger.debug(TAG, "resetTNCControlState");
            this.mReqToCnt = 0;
            this.mReqToApiMap.clear();
            this.mReqToIpMap.clear();
            this.mReqErrorCnt = 0;
            this.mReqErrApiMap.clear();
            this.mReqErrIpMap.clear();
        }
    }

    private void resetTNCHostReplaceNum(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && !TextUtils.isEmpty(str) && this.hostReplaceMapFailed.containsKey(str)) {
            this.hostReplaceMapFailed.put(str, 0);
        }
    }

    private void sendUpdateMsg(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || this.mHandler.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.mHandler.sendMessageDelayed(obtainMessage, j);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    public AppConfig getAppConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppConfig : (AppConfig) invokeV.objValue;
    }

    public ITTAdNetDepend getITTAdNetDepend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mITTAdNetDepend : (ITTAdNetDepend) invokeV.objValue;
    }

    public TNCConfig getTNCConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TNCConfigHandler tNCConfigHandler = this.mTNCConfigHandler;
            if (tNCConfigHandler != null) {
                return tNCConfigHandler.getTNCConfig();
            }
            return null;
        }
        return (TNCConfig) invokeV.objValue;
    }

    public TNCConfigHandler getTNCConfigHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTNCConfigHandler : (TNCConfigHandler) invokeV.objValue;
    }

    public Map<String, String> getTNCHostReplaceMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TNCConfig tNCConfig = getTNCConfig();
            if (tNCConfig != null) {
                return tNCConfig.hostReplaceMap;
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public boolean getURLDispatchEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mURLDispatchEnabled : invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String handleHostMapping(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
                String str3 = null;
                try {
                    URL url = new URL(str);
                    str2 = url.getProtocol();
                    try {
                        str3 = url.getHost();
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        if (!TextUtils.isEmpty(str2)) {
                            if (!isTNCHostFailedOverLimit(str3)) {
                            }
                        }
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2) && (("http".equals(str2) || "https".equals(str2)) && !TextUtils.isEmpty(str3))) {
                    if (!isTNCHostFailedOverLimit(str3)) {
                        Logger.debug(TAG, "handleHostMapping, TNC host faild num over limit: " + str3);
                        return str;
                    }
                    Map<String, String> tNCHostReplaceMap = getTNCHostReplaceMap();
                    if (tNCHostReplaceMap != null && tNCHostReplaceMap.containsKey(str3)) {
                        String str4 = tNCHostReplaceMap.get(str3);
                        if (TextUtils.isEmpty(str4)) {
                            return str;
                        }
                        Logger.debug(TAG, "handleHostMapping, match, origin: " + str);
                        String str5 = str2 + "://" + str3;
                        String str6 = str2 + "://" + str4;
                        if (str.startsWith(str5)) {
                            str = str.replaceFirst(str5, str6);
                        }
                        Logger.debug(TAG, "handleHostMapping, target: " + str);
                        return str;
                    }
                    Logger.debug(TAG, "handleHostMapping, nomatch: " + str3);
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void handleRequestResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public synchronized void initTnc(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, z) == null) {
            synchronized (this) {
                if (!this.mInited) {
                    this.mContext = context;
                    this.mIsMainProcess = z;
                    this.mTNCConfigHandler = new TNCConfigHandler(context, z);
                    if (z) {
                        loadProbeInfo();
                    }
                    Logger.debug(TAG, "initTnc, isMainProc: " + z + " probeCmd: " + this.mTncProbeCmd + " probeVersion: " + this.mTncProbeVersion);
                    this.mAppConfig = AppConfig.getInstance(this.mContext);
                    this.mInited = true;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.net.tnc.TNCBridge
    public synchronized void onError(z zVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, zVar, exc) == null) {
            synchronized (this) {
                if (zVar != null) {
                    if (zVar.a() != null && exc != null) {
                        if (this.mIsMainProcess) {
                            if (NetworkUtils.checkWifiAndGPRS(this.mContext)) {
                                URL url = null;
                                try {
                                    url = zVar.a().a();
                                } catch (Exception unused) {
                                }
                                if (url == null) {
                                    return;
                                }
                                String protocol = url.getProtocol();
                                String host = url.getHost();
                                String path = url.getPath();
                                String connectionIpStr = getConnectionIpStr(zVar);
                                if ("http".equals(protocol) || "https".equals(protocol)) {
                                    TNCConfig tNCConfig = getTNCConfig();
                                    if (tNCConfig == null) {
                                        return;
                                    }
                                    Logger.debug(TAG, "onError, url matched: " + protocol + "://" + host + "#" + connectionIpStr + "# " + this.mReqToCnt + "#" + this.mReqToApiMap.size() + "#" + this.mReqToIpMap.size() + " " + this.mReqErrorCnt + "#" + this.mReqErrApiMap.size() + "#" + this.mReqErrIpMap.size());
                                    this.mReqToCnt = this.mReqToCnt + 1;
                                    this.mReqToApiMap.put(path, 0);
                                    this.mReqToIpMap.put(connectionIpStr, 0);
                                    if (this.mReqToCnt >= tNCConfig.reqToCnt && this.mReqToApiMap.size() >= tNCConfig.reqToApiCnt && this.mReqToIpMap.size() >= tNCConfig.reqToIpCnt) {
                                        Logger.debug(TAG, "onError, url doUpate: " + protocol + "://" + host + "#" + connectionIpStr);
                                        sendUpdateMsg(false, 0L);
                                        resetTNCControlState();
                                    }
                                    addTNCHostReplaceNum(host);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.net.tnc.TNCBridge
    public synchronized void onResponse(z zVar, ab abVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, zVar, abVar) == null) {
            synchronized (this) {
                if (zVar == null || abVar == null) {
                    return;
                }
                if (this.mIsMainProcess) {
                    if (NetworkUtils.checkWifiAndGPRS(this.mContext)) {
                        URL url = null;
                        try {
                            url = zVar.a().a();
                        } catch (Exception unused) {
                        }
                        if (url == null) {
                            return;
                        }
                        String protocol = url.getProtocol();
                        String host = url.getHost();
                        String path = url.getPath();
                        String connectionIpStr = getConnectionIpStr(zVar);
                        int c2 = abVar.c();
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            if (TextUtils.isEmpty(connectionIpStr)) {
                                return;
                            }
                            Logger.debug(TAG, "onResponse, url: " + protocol + "://" + host + "#" + connectionIpStr + "#" + c2);
                            TNCConfig tNCConfig = getTNCConfig();
                            if (tNCConfig != null && tNCConfig.probeEnable) {
                                handleTncProbe(abVar, host);
                            }
                            if (tNCConfig == null) {
                                return;
                            }
                            Logger.debug(TAG, "onResponse, url matched: " + protocol + "://" + host + "#" + connectionIpStr + "#" + c2 + " " + this.mReqToCnt + "#" + this.mReqToApiMap.size() + "#" + this.mReqToIpMap.size() + " " + this.mReqErrorCnt + "#" + this.mReqErrApiMap.size() + "#" + this.mReqErrIpMap.size());
                            if (c2 > 0) {
                                if (isHttpRespCodeOk(c2)) {
                                    if (this.mReqToCnt > 0 || this.mReqErrorCnt > 0) {
                                        resetTNCControlState();
                                    }
                                    resetTNCHostReplaceNum(host);
                                } else if (!isHttpRespCodeInBlack(c2)) {
                                    this.mReqErrorCnt++;
                                    this.mReqErrApiMap.put(path, 0);
                                    this.mReqErrIpMap.put(connectionIpStr, 0);
                                    if (this.mReqErrorCnt >= tNCConfig.reqErrCnt && this.mReqErrApiMap.size() >= tNCConfig.reqErrApiCnt && this.mReqErrIpMap.size() >= tNCConfig.reqErrIpCnt) {
                                        Logger.debug(TAG, "onResponse, url doUpdate: " + protocol + "://" + host + "#" + connectionIpStr + "#" + c2);
                                        sendUpdateMsg(false, 0L);
                                        resetTNCControlState();
                                    }
                                    addTNCHostReplaceNum(host);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void resetHostReplaceMapFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.hostReplaceMapFailed.clear();
        }
    }

    public void setITTAdNetDepend(ITTAdNetDepend iTTAdNetDepend) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iTTAdNetDepend) == null) {
            this.mITTAdNetDepend = iTTAdNetDepend;
        }
    }

    public void setURLDispatchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mURLDispatchEnabled = z;
        }
    }
}
