package com.bytedance.sdk.component.net.tnc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.utils.Logger;
import com.bytedance.sdk.component.net.utils.MultiProcessFileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TNCConfigHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TNCConfigHandler";
    public static final Object sLock;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mIsMainProcess;
    public TNCConfig mTNCConfig;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-385473409, "Lcom/bytedance/sdk/component/net/tnc/TNCConfigHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-385473409, "Lcom/bytedance/sdk/component/net/tnc/TNCConfigHandler;");
                return;
            }
        }
        sLock = new Object();
    }

    public TNCConfigHandler(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsMainProcess = true;
        this.mContext = context;
        this.mIsMainProcess = z;
        this.mTNCConfig = new TNCConfig();
    }

    private TNCConfig parseConfigFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONObject)) == null) {
            try {
                TNCConfig tNCConfig = new TNCConfig();
                if (jSONObject.has("local_enable")) {
                    tNCConfig.localEnable = jSONObject.getInt("local_enable") != 0;
                }
                if (jSONObject.has("probe_enable")) {
                    tNCConfig.probeEnable = jSONObject.getInt("probe_enable") != 0;
                }
                if (jSONObject.has("local_host_filter")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                    HashMap hashMap = new HashMap();
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string = jSONArray.getString(i2);
                            if (!TextUtils.isEmpty(string)) {
                                hashMap.put(string, 0);
                            }
                        }
                    }
                    tNCConfig.localHostFilterList = hashMap;
                } else {
                    tNCConfig.localHostFilterList = null;
                }
                if (jSONObject.has("host_replace_map")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                    HashMap hashMap2 = new HashMap();
                    if (jSONObject2.length() > 0) {
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string2 = jSONObject2.getString(next);
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                                hashMap2.put(next, string2);
                            }
                        }
                    }
                    tNCConfig.hostReplaceMap = hashMap2;
                } else {
                    tNCConfig.hostReplaceMap = null;
                }
                tNCConfig.reqToCnt = jSONObject.optInt("req_to_cnt", tNCConfig.reqToCnt);
                tNCConfig.reqToApiCnt = jSONObject.optInt("req_to_api_cnt", tNCConfig.reqToApiCnt);
                tNCConfig.reqToIpCnt = jSONObject.optInt("req_to_ip_cnt", tNCConfig.reqToIpCnt);
                tNCConfig.reqErrCnt = jSONObject.optInt("req_err_cnt", tNCConfig.reqErrCnt);
                tNCConfig.reqErrApiCnt = jSONObject.optInt("req_err_api_cnt", tNCConfig.reqErrApiCnt);
                tNCConfig.reqErrIpCnt = jSONObject.optInt("req_err_ip_cnt", tNCConfig.reqErrIpCnt);
                tNCConfig.updateInterval = jSONObject.optInt("update_interval", tNCConfig.updateInterval);
                tNCConfig.updateRandomRange = jSONObject.optInt("update_random_range", tNCConfig.updateRandomRange);
                tNCConfig.httpCodeBlack = jSONObject.optString("http_code_black", tNCConfig.httpCodeBlack);
                return tNCConfig;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (TNCConfig) invokeL.objValue;
    }

    public TNCConfig getTNCConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTNCConfig : (TNCConfig) invokeV.objValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public void handleConfigChanged(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (!this.mIsMainProcess) {
                Logger.debug(TAG, "handleConfigChanged: no mainProc");
                return;
            }
            TNCManager.getInstance().resetHostReplaceMapFailed();
            try {
                boolean z = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                JSONArray optJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                JSONObject jSONObject2 = null;
                if (TNCManager.getInstance().getURLDispatchEnabled() && z && optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject3 = ((JSONObject) optJSONArray.get(i2)).getJSONObject("param");
                        if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                            arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        jSONObject2 = new JSONObject();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObject4 = (JSONObject) it.next();
                            Iterator<String> keys = jSONObject4.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject2.put(next, jSONObject4.getString(next));
                            }
                        }
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(MultiProcessFileUtils.KEY_TNC_CONFIG);
                if (optJSONObject == null && jSONObject2 == null) {
                    Logger.error(TAG, " tnc host_replace_map config is null");
                } else if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    optJSONObject.put("host_replace_map", jSONObject2);
                } else if (jSONObject2 != null) {
                    optJSONObject.put("host_replace_map", jSONObject2);
                }
                TNCConfig parseConfigFromJson = parseConfigFromJson(optJSONObject);
                StringBuilder sb = new StringBuilder();
                sb.append("handleConfigChanged, newConfig: ");
                sb.append(parseConfigFromJson == null ? StringUtil.NULL_STRING : parseConfigFromJson.toString());
                Logger.debug(TAG, sb.toString());
                if (parseConfigFromJson == null) {
                    synchronized (sLock) {
                        this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", "").apply();
                        MultiProcessFileUtils.saveData(this.mContext, 1, "");
                    }
                    return;
                }
                this.mTNCConfig = parseConfigFromJson;
                String jSONObject5 = optJSONObject.toString();
                synchronized (sLock) {
                    this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", jSONObject5).apply();
                    MultiProcessFileUtils.saveData(this.mContext, 1, jSONObject5);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.mTNCConfig = new TNCConfig();
                    synchronized (sLock) {
                        this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", "").apply();
                        MultiProcessFileUtils.saveData(this.mContext, 1, "");
                    }
                } catch (Throwable th2) {
                    synchronized (sLock) {
                        this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).edit().putString("tnc_config_str", "").apply();
                        MultiProcessFileUtils.saveData(this.mContext, 1, "");
                        throw th2;
                    }
                }
            }
        }
    }

    public void loadLocalConfig() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mIsMainProcess) {
            String string = this.mContext.getSharedPreferences(TNCManager.TNC_SP_NAME, 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                Logger.debug(TAG, "loadLocalConfig: no existed");
                return;
            }
            try {
                TNCConfig parseConfigFromJson = parseConfigFromJson(new JSONObject(string));
                if (parseConfigFromJson != null) {
                    this.mTNCConfig = parseConfigFromJson;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(parseConfigFromJson == null ? StringUtil.NULL_STRING : parseConfigFromJson.toString());
                Logger.debug(TAG, sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.debug(TAG, "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }

    public void loadLocalConfigForOtherProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                String data = MultiProcessFileUtils.getData(this.mContext, 1);
                if (TextUtils.isEmpty(data)) {
                    Logger.debug(TAG, "loadLocalConfigForOtherProcess, data empty");
                    return;
                }
                TNCConfig parseConfigFromJson = parseConfigFromJson(new JSONObject(data));
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfigForOtherProcess, config: ");
                sb.append(parseConfigFromJson == null ? StringUtil.NULL_STRING : parseConfigFromJson.toString());
                Logger.debug(TAG, sb.toString());
                if (parseConfigFromJson != null) {
                    this.mTNCConfig = parseConfigFromJson;
                }
            } catch (Throwable th) {
                Logger.debug(TAG, "loadLocalConfigForOtherProcess, except: " + th.getMessage());
            }
        }
    }
}
