package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.CommonUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.action.track.Connection;
import com.baidu.android.imsdk.upload.action.track.Request;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class w80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w80() {
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

    public static IMPushPb.LcpNetInfo d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            return IMPushPb.LcpNetInfo.newBuilder().setDomain(jSONObject.optString("domain", "")).setIp(jSONObject.optString("ip", "")).setPort(jSONObject.optString(ClientCookie.PORT_ATTR, "")).setProtocol(jSONObject.optString(ProbeTB.PROTOCOL, "")).build();
        }
        return (IMPushPb.LcpNetInfo) invokeL.objValue;
    }

    public static IMPushPb.Action e(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str3, Long.valueOf(j4)})) == null) {
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.REQUEST).setRequest(IMPushPb.Request.newBuilder().setMethod(str).setRequestId(str2).setTimestamp(j).setResponseTime(j2).setErrorCode(j3).setExt(str3).setAliasId(j4).build()).build();
        }
        return (IMPushPb.Action) invokeCommon.objValue;
    }

    public static IMPushPb.Action h(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), str2, Long.valueOf(j5)})) == null) {
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(j).setStopTime(j2).setReason(str).setRetryTime(j3).setRetryCount(j4).setExt(str2).setAliasId(j5).build()).build();
        }
        return (IMPushPb.Action) invokeCommon.objValue;
    }

    public static IMPushPb.Action f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            return IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.NEWREQUEST).setNewRequest(IMPushPb.NewRequest.newBuilder().setAliasId(601111L).setRequestId(jSONObject.optLong(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID)).setServiceId(jSONObject.optString("service_id")).setMethodId(jSONObject.optString("method_id")).setErrorCode(jSONObject.optLong("error_code")).setErrorMsg(jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG)).setRequestTime(jSONObject.optLong("request_time")).setResponseTime(jSONObject.optLong("response_time")).setExt(jSONObject.optString("ext")).setNetInfo(d(jSONObject)).build()).build();
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
            return b(jSONObject);
        }
        return (IMPushPb.Action) invokeLL.objValue;
    }

    public static void i(Context context, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, connection) == null) {
            try {
                HashSet hashSet = new HashSet(x80.b(context));
                hashSet.add(Base64.encodeToString(h(connection.startTime, connection.stopTime, connection.reason, connection.retryTime, connection.retryCount, connection.ext, connection.aliasId).toByteArray(), 0));
                x80.k(context, hashSet);
            } catch (Exception e) {
                aa0.c("TrackPbGenerator", "putIMConnectionToActions :", e);
            }
        }
    }

    public static void j(Context context, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, request) == null) {
            try {
                HashSet hashSet = new HashSet(x80.d(context));
                hashSet.add(Base64.encodeToString(e(request.method, request.requestId, request.timestamp, request.responseTime, request.errorCode, request.ext, request.aliasId).toByteArray(), 0));
                x80.o(context, hashSet);
            } catch (Exception e) {
                aa0.c("TrackPbGenerator", "putIMRequestToActions :", e);
            }
        }
    }

    public final List<String> a(String str, List<y80> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !TextUtils.isEmpty(str) && list.size() > 0) {
                aa0.a("TrackPbGenerator", "flow upload details list");
                for (y80 y80Var : list) {
                    if (y80Var != null) {
                        String a = y80Var.a();
                        if (!TextUtils.isEmpty(a) && a.length() > 0) {
                            arrayList.add(a);
                        }
                    }
                }
                aa0.a("TrackPbGenerator", "flow upload detal list:" + arrayList.toString());
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public byte[] c(Context context, String str, List<y80> list, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, list, i)) == null) {
            list.addAll(m90.j(context).g(str, i));
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
                        return IMPushPb.PushImClient.newBuilder().setCommon(CommonUtils.getIMCommon(context, ba0.e(context))).setSdkName("lcp").setSdkVersion(2310016L).addAllActions(copyOnWriteArrayList).build().toByteArray();
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
