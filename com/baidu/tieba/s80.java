package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class s80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s80() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static IMPushPb.Action b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.NEWCONNECTION).setNewConnection(IMPushPb.NewConnection.newBuilder().setAliasId(601110L).setConnectErrorCode(jSONObject.optString("con_err_code", "")).setTokenBegin(jSONObject.optLong("token_begin", 0L)).setTokenEnd(jSONObject.optLong("token_end", 0L)).setDnsBegin(jSONObject.optLong("dns_begin", 0L)).setDnsEnd(jSONObject.optLong("dns_end", 0L)).setSocketBegin(jSONObject.optLong("socket_begin", 0L)).setSocketEnd(jSONObject.optLong("socket_end", 0L)).setLcpLoginBegin(jSONObject.optLong("login_begin", 0L)).setLcpLoginEnd(jSONObject.optLong("login_end", 0L)).setConnectSource(jSONObject.optString("source", "")).setConnectState(jSONObject.optLong("connect_state", -1L)).setEndTime(jSONObject.optLong("flow_end_time", 0L)).setStartTime(jSONObject.optLong("flow_start_time", 0L)).setRetry(jSONObject.optInt("retry_cout", 0)).setExt(jSONObject.toString()).setNetInfo(d(jSONObject)).build()).build();
        }
        return (IMPushPb.Action) invokeL.objValue;
    }

    public static IMPushPb.Action f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            IMPushPb.LcpNetInfo d = d(jSONObject);
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("event_list"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    arrayList.add(IMPushPb.Event_timestamp.newBuilder().setEvent(jSONObject2.optString("event")).setTimestampMs(jSONObject2.optLong("timestamp_ms")).build());
                }
            } catch (Exception e) {
                z90.c("TrackPbGenerator", "generateRequestNew eventListArr exception", e);
            }
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.NEWREQUEST).setNewRequest(IMPushPb.NewRequest.newBuilder().setAliasId(601111L).setRequestId(jSONObject.optLong(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID)).setServiceId(jSONObject.optString("service_id")).setMethodId(jSONObject.optString("method_id")).setErrorCode(jSONObject.optLong("error_code")).setErrorMsg(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG)).setRequestTime(jSONObject.optLong("request_time")).setResponseTime(jSONObject.optLong("response_time")).setReqBodyLength(jSONObject.optLong("request_body_size")).setRespBodyLength(jSONObject.optLong("response_body_size")).addAllEventList(arrayList).setExt(jSONObject.optString("ext")).setNetInfo(d).build()).build();
        }
        return (IMPushPb.Action) invokeL.objValue;
    }

    public static IMPushPb.LcpNetInfo d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            return IMPushPb.LcpNetInfo.newBuilder().setDomain(jSONObject.optString("domain", "")).setIp(jSONObject.optString("ip", "")).setPort(jSONObject.optString(ClientCookie.PORT_ATTR, "")).setProtocol(jSONObject.optString(ProbeTB.PROTOCOL, "")).setServerInfo(jSONObject.optString("server_info", "")).build();
        }
        return (IMPushPb.LcpNetInfo) invokeL.objValue;
    }

    public static IMPushPb.Action e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.PINGRESUlLT).setPingInfo(IMPushPb.PingInfo.newBuilder().setAliasId(601112L).setRequestId(jSONObject.optLong(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, 0L)).setPingTimes(jSONObject.optLong("ping_times", 0L)).setPingTarget(jSONObject.optString("ping_target", "")).setPingRequestSize(jSONObject.optLong("ping_request_size", 0L)).setOriginalPingResult(jSONObject.optString("original_ping_result", "")).setStartTimeMs(jSONObject.optLong("start_time_ms", 0L)).setEndTimeMs(jSONObject.optLong("end_time_ms", 0L)).build()).build();
        }
        return (IMPushPb.Action) invokeL.objValue;
    }

    public static IMPushPb.Action g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, jSONObject)) == null) {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue == 601111) {
                return f(jSONObject);
            }
            if (intValue == 601110) {
                return b(jSONObject);
            }
            if (intValue == 601112) {
                return e(jSONObject);
            }
            return b(jSONObject);
        }
        return (IMPushPb.Action) invokeLL.objValue;
    }

    public final List<String> a(String str, List<u80> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !TextUtils.isEmpty(str) && list.size() > 0) {
                for (u80 u80Var : list) {
                    if (u80Var != null) {
                        String a = u80Var.a();
                        if (!TextUtils.isEmpty(a) && a.length() > 0) {
                            arrayList.add(a);
                        }
                    }
                }
                if (y90.a) {
                    z90.a("TrackPbGenerator", "flow upload detal list:" + arrayList.toString());
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public byte[] c(Context context, String str, List<u80> list, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, list, i)) == null) {
            list.addAll(l90.j(context).g(str, i));
            List<String> a = a(str, list);
            if (a != null) {
                try {
                    if (a.size() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        if (a.size() > 0) {
                            for (String str2 : a) {
                                copyOnWriteArrayList.add(g(str, new JSONObject(str2)));
                            }
                        }
                        return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, aa0.e(context))).setSdkName("lcp").setSdkVersion(3460016L).addAllActions(copyOnWriteArrayList).build().toByteArray();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (byte[]) invokeLLLI.objValue;
    }
}
