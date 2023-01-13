package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWorkState;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ComplianceParmasHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.switchs.EncSigNewSwitch;
import com.baidu.tbadk.switchs.NetDeleteSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import com.fun.ad.sdk.FunAdSdk;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class tg5 extends jb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg5(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(HttpMessage httpMessage) {
        String currentBduss;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, httpMessage) == null) && (currentBduss = TbadkCoreApplication.getCurrentBduss()) != null) {
            httpMessage.addParam(HttpRequest.BDUSS, currentBduss);
            String a = rr4.a(TbadkCoreApplication.getCurrentAccountInfo());
            if (!StringUtils.isNull(a)) {
                httpMessage.addParam("stoken", a);
            }
        }
    }

    public final void b(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        String f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpMessage, tbHttpMessageTask) == null) {
            httpMessage.addParam(HttpRequest.CLIENT_TYPE, "2");
            if (!TbadkCoreApplication.getInst().isOfficial()) {
                httpMessage.addParam("apid", TbConfig.SW_APID);
            }
            httpMessage.addParam("_client_version", TbConfig.getVersion());
            if (TbadkCoreApplication.getInst().getImei() != null) {
                httpMessage.addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            }
            String clientId = TbadkCoreApplication.getClientId();
            if (clientId != null) {
                httpMessage.addParam(HttpRequest.CLIENT_ID, clientId);
            }
            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                httpMessage.addParam(HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
            }
            String from = TbadkCoreApplication.getFrom();
            if (from != null && from.length() > 0) {
                httpMessage.addParam("from", from);
            }
            httpMessage.addParam("net_type", String.valueOf(BdNetTypeUtil.netType()));
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            if (!TextUtils.isEmpty(lastCachedOid)) {
                httpMessage.addParam("oaid", lastCachedOid);
            }
            int i = 1;
            if (tbHttpMessageTask.isNeedTbs()) {
                if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                    f = TbadkCoreApplication.getInst().getTbs();
                } else {
                    f = yc5.f();
                }
                httpMessage.addParam(HttpRequest.TBS, f);
            }
            httpMessage.addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            httpMessage.addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            httpMessage.addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            httpMessage.addParam(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            httpMessage.addParam("timestamp", Long.toString(System.currentTimeMillis()));
            httpMessage.addParam("model", bj.g());
            httpMessage.addParam(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            httpMessage.addParam("baiduid", TbSingleton.getInstance().getBaiduIdForAnti());
            httpMessage.addParam(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
            if (ComplianceParmasHelper.isNeedChange(tbHttpMessageTask.getUrl())) {
                httpMessage.addParam(ComplianceParmasHelper.getRenameKey("mac"), ComplianceParmasHelper.getBase64Value(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst())));
                httpMessage.addParam(ComplianceParmasHelper.getRenameKey(HttpRequest.ANDROID_ID), ComplianceParmasHelper.getBase64Value(TbadkCoreApplication.getInst().getAndroidId()));
                httpMessage.addParam(ComplianceParmasHelper.getRenameKey(HttpRequest.PHONE_IMEI), ComplianceParmasHelper.getBase64Value(TbadkCoreApplication.getInst().getImei()));
            } else {
                httpMessage.addParam("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst()));
                httpMessage.addParam(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
                httpMessage.addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            }
            httpMessage.addParam("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            httpMessage.addParam("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            httpMessage.addParam("naws_game_ver", TbadkCoreApplication.getInst().getNaws_game_ver());
            httpMessage.addParam("active_timestamp", TbSingleton.getInstance().getActiveTimeStamp());
            httpMessage.addParam("first_install_time", TbSingleton.getInstance().getAppFirstInstallTime());
            httpMessage.addParam(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, TbSingleton.getInstance().getAppLastUpdateTime());
            httpMessage.addParam("event_day", TbSingleton.getInstance().getData());
            if (!PermissionUtil.isAgreePrivacyPolicy()) {
                i = 2;
            }
            httpMessage.addParam("cmode", i);
            httpMessage.addParam("is_teenager", "0");
            httpMessage.addParam("start_type", qx4.f);
            httpMessage.addParam("start_scheme", qx4.e());
            httpMessage.addParam("extra", cz4.l().r("key_sync_extra_field", ""));
            httpMessage.addParam("device_score", String.valueOf(ScheduleStrategy.getDeviceScore()));
            httpMessage.addParam("personalized_rec_switch", String.valueOf(TbSingleton.getInstance().getPersonalizedRecSwitch()));
        }
    }

    public final void c(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpMessage) == null) {
            if (u15.b().d()) {
                httpMessage.addCookie("pub_env", String.valueOf(u15.b().c()));
            }
            if (TbSingleton.getInstance().isVisitPreviewServer()) {
                httpMessage.addCookie("pub_env", TbSingleton.getInstance().getPubEnvValue());
            }
            if (1 == BdNetTypeUtil.netType()) {
                if (TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                    httpMessage.addCookie("ka", "open");
                }
            } else if (TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1) {
                httpMessage.addCookie("ka", "open");
            }
            httpMessage.addCookie("TBBRAND", bj.g());
            httpMessage.addCookie("CUID", TbadkCoreApplication.getInst().getCuid());
            httpMessage.addCookie("BAIDUID", TbSingleton.getInstance().getBaiduIdForAnti());
            httpMessage.addCookie("BAIDUZID", TbadkCoreApplication.getInst().getZid());
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                httpMessage.addCookie("BAIDUCUID", new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
            }
            if (httpMessage.getCmd() == 1003510 || httpMessage.getCmd() == 1003533) {
                httpMessage.addCookie(HttpRequest.BDUSS, TbadkCoreApplication.getCurrentBduss());
            }
        }
    }

    public final void d(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, httpMessage) == null) {
            StringBuffer stringBuffer = new StringBuffer(1024);
            List<Map.Entry<String, Object>> encodeInBackGround = httpMessage.encodeInBackGround();
            for (int i = 0; encodeInBackGround != null && i < encodeInBackGround.size(); i++) {
                Map.Entry<String, Object> entry = encodeInBackGround.get(i);
                if (entry != null) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if ((value instanceof String) && !"sign".equals(key)) {
                        stringBuffer.append(key + "=");
                        stringBuffer.append(value);
                    }
                }
            }
            stringBuffer.append("tiebaclient!!!");
            httpMessage.addParam("sign", gj.c(stringBuffer.toString()));
            if (httpMessage.getHeaders() != null && "1".equals(httpMessage.getHeaders().get("needSig")) && EncSigNewSwitch.isOn()) {
                httpMessage.addParam(FunAdSdk.PLATFORM_SIG, StringU.b(stringBuffer.toString()));
            }
            httpMessage.getHeaders().remove("needSig");
        }
    }

    public final void e(HttpMessage httpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, httpMessage) == null) {
            NetWorkState.StatisticsData delStatisticsData = NetWorkState.delStatisticsData();
            if (delStatisticsData != null) {
                httpMessage.addParam("stTime", String.valueOf(delStatisticsData.mTime));
                httpMessage.addParam("stSize", String.valueOf(delStatisticsData.mSize));
                httpMessage.addParam("stTimesNum", String.valueOf(delStatisticsData.mTimesNum));
                httpMessage.addParam("stMode", String.valueOf(delStatisticsData.mMode));
                httpMessage.addParam("stMethod", String.valueOf(delStatisticsData.mMethod));
            }
            int errorNumsAndSet = NetWorkState.getErrorNumsAndSet(0);
            if (errorNumsAndSet == 0 && delStatisticsData != null) {
                errorNumsAndSet = delStatisticsData.mTimesNum;
            }
            httpMessage.addParam("stErrorNums", String.valueOf(errorNumsAndSet));
        }
    }

    public final void f(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, httpMessage, tbHttpMessageTask) == null) {
            if ((tbHttpMessageTask.isNeedGzip() && !tbHttpMessageTask.isBDImage()) || tbHttpMessageTask.isFromCDN()) {
                httpMessage.addHeader("Accept-Encoding", "gzip");
            } else {
                httpMessage.addHeader("Accept-Encoding", "");
            }
            httpMessage.addHeader(BOSTokenRequest.CHARSET, "UTF-8");
            String userAgent = httpMessage.getUserAgent();
            if (TextUtils.isEmpty(userAgent)) {
                httpMessage.addHeader("User-Agent", rl5.b());
            } else {
                httpMessage.addHeader("User-Agent", userAgent);
            }
            if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                httpMessage.addHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
            }
            int netType = BdNetTypeUtil.netType();
            if (!NetDeleteSwitch.isOn()) {
                httpMessage.addHeader("net", String.valueOf(netType));
            }
            boolean z = false;
            if (1 != netType ? TbadkCoreApplication.getInst().getKeepaliveNonWifi() == 1 : TbadkCoreApplication.getInst().getKeepaliveWifi() == 1) {
                z = true;
            }
            if (z) {
                httpMessage.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                httpMessage.addHeader(HTTP.CONN_DIRECTIVE, "close");
            }
            httpMessage.addHeader("client_logid", String.valueOf(httpMessage.getClientLogID()));
            httpMessage.addHeader("cuid", TbadkCoreApplication.getInst().getCuid());
            httpMessage.addHeader("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            httpMessage.addHeader("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            httpMessage.addHeader(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
        }
    }

    public final void g(HttpMessage httpMessage, TbHttpMessageTask tbHttpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, httpMessage, tbHttpMessageTask) == null) {
            if (tbHttpMessageTask.isFromCDN()) {
                httpMessage.removeAllParams();
                return;
            }
            if (tbHttpMessageTask.isUseCurrentBDUSS()) {
                a(httpMessage);
            }
            if (tbHttpMessageTask.isNeedAddCommenParam()) {
                b(httpMessage, tbHttpMessageTask);
                c(httpMessage);
            } else if (tbHttpMessageTask.isIsNeedCookie()) {
                c(httpMessage);
            }
            if (tbHttpMessageTask.isNeedAddStatisticsParam()) {
                e(httpMessage);
            }
            if (tbHttpMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST && tbHttpMessageTask.isBaiduServer()) {
                d(httpMessage);
            }
        }
    }

    /* renamed from: process  reason: avoid collision after fix types in other method */
    public HttpMessage process2(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, httpMessage, httpMessageTask)) == null) {
            if (httpMessageTask != null && (httpMessageTask instanceof TbHttpMessageTask)) {
                TbHttpMessageTask tbHttpMessageTask = (TbHttpMessageTask) httpMessageTask;
                g(httpMessage, tbHttpMessageTask);
                f(httpMessage, tbHttpMessageTask);
            }
            return httpMessage;
        }
        return (HttpMessage) invokeLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // com.baidu.tieba.lb
    public /* bridge */ /* synthetic */ HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        process2(httpMessage2, httpMessageTask);
        return httpMessage2;
    }
}
