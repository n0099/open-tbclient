package com.baidu.tieba;

import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes7.dex */
public class xt4 implements se6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.se6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        re6.a(this, webView, str, jSONObject);
    }

    public xt4() {
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

    @Override // com.baidu.tieba.se6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.GET_ZID.equals(str2)) {
                jsPromptResult.confirm(g(webView).a());
                return true;
            } else if ("getSupplementInfo".equals(str2)) {
                jsPromptResult.confirm(f(webView).a());
                return true;
            } else if (CommonTbJsBridge.GET_DEVICE_INFO.equals(str2)) {
                jsPromptResult.confirm(d(webView).a());
                return true;
            } else if (UegTbJsBridge.METHOD_SET_BLOCK_POP_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    h(webView, jSONObject.optInt("can_post"), jSONObject.optString("block_info"), jSONObject.optString("ahead_info"), jSONObject.optString("ahead_url"), jSONObject.optString("ok_info"), jSONObject.optInt("ahead_type"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                return true;
            } else if (UegTbJsBridge.METHOD_COPY_TO_CLIPBOARD.equals(str2)) {
                c(str3);
                jsPromptResult.confirm("1");
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                yh.a(new JSONObject(str).optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public sm9 d(WebView webView) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            sm9 sm9Var = new sm9();
            StringBuilder sb = new StringBuilder(1024);
            String imei = TbadkCoreApplication.getInst().getImei();
            sb.append("imei=");
            sb.append(imei);
            String androidId = TbadkCoreApplication.getInst().getAndroidId();
            sb.append("androidId=");
            sb.append(androidId);
            String iMsi = TbadkCoreApplication.getInst().getIMsi();
            if (iMsi == null) {
                iMsi = "";
            }
            sb.append("imsi=");
            sb.append(iMsi);
            String g = ki.g();
            sb.append("model=");
            sb.append(ki.g());
            String str2 = Build.BRAND;
            sb.append("brand=");
            sb.append(str2);
            sb.append("platform=");
            sb.append("Android");
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            sb.append("pkgName=");
            sb.append(packageName);
            String str3 = "" + BdNetTypeUtil.netType();
            sb.append("network=");
            sb.append(str3);
            String str4 = "" + BdNetTypeUtil.curOperatorType();
            sb.append("carrier=");
            sb.append(str4);
            String devicesManufacturer = DeviceInfoUtil.getDevicesManufacturer();
            sb.append("manufacturer=");
            sb.append(devicesManufacturer);
            String str5 = Build.HARDWARE;
            sb.append("hardware=");
            sb.append(str5);
            String str6 = Build.BOARD;
            sb.append("board=");
            sb.append(str6);
            if (DeviceInfoUtil.isSupportGyroScope(TbadkCoreApplication.getInst())) {
                str = "1";
            } else {
                str = "0";
            }
            sb.append("imu=");
            sb.append(str);
            sb.append("tiebaclient!!!");
            String c = pi.c(sb.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("imei", imei);
                    jSONObject.put("androidId", androidId);
                    jSONObject.put(BaseStatisContent.IMSI, iMsi);
                    jSONObject.put("model", g);
                    jSONObject.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, str2);
                    jSONObject.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                    jSONObject.put("pkgName", packageName);
                    jSONObject.put("network", str3);
                    jSONObject.put("carrier", str4);
                    jSONObject.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                    jSONObject.put(HttpConstants.HTTP_HARDWARE, str5);
                    jSONObject.put(HttpConstants.HTTP_BOARD, str6);
                    jSONObject.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str);
                    jSONObject.put("sign", c);
                    sm9Var = sm9Var;
                    sm9Var.o(jSONObject.toString());
                    return sm9Var;
                } catch (JSONException e) {
                    e = e;
                    sm9Var = sm9Var;
                    BdLog.e(e);
                    sm9Var.o("");
                    return sm9Var;
                }
            } catch (JSONException e2) {
                e = e2;
            }
        } else {
            return (sm9) invokeL.objValue;
        }
    }

    public sm9 e(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, webView)) == null) {
            sm9 sm9Var = new sm9();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("hdid", TbadkCoreApplication.getInst().getHdid());
                sm9Var.o(jSONObject.toString());
                return sm9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return sm9Var;
            }
        }
        return (sm9) invokeL.objValue;
    }

    public sm9 g(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, webView)) == null) {
            sm9 sm9Var = new sm9();
            String zid = TbadkCoreApplication.getInst().getZid();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("zid", zid);
                sm9Var.o(jSONObject.toString());
                return sm9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return sm9Var;
            }
        }
        return (sm9) invokeL.objValue;
    }

    public sm9 f(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, webView)) == null) {
            sm9 sm9Var = new sm9();
            StringBuilder sb = new StringBuilder(1024);
            String imei = TbadkCoreApplication.getInst().getImei();
            sb.append("imei=");
            sb.append(imei);
            String cuid = TbadkCoreApplication.getInst().getCuid();
            sb.append("cuid=");
            sb.append(cuid);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            sb.append("shoubai_cuid=");
            sb.append(cuidGalaxy2);
            String str = Build.BRAND;
            sb.append("brand=");
            sb.append(str);
            sb.append("client_type=");
            sb.append("Android");
            String version = TbConfig.getVersion();
            sb.append("client_version=");
            sb.append(version);
            String zid = TbadkCoreApplication.getInst().getZid();
            sb.append("zid=");
            sb.append(zid);
            sb.append("tiebaclient!!!");
            String c = pi.c(sb.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", imei);
                jSONObject.put("cuid", cuid);
                jSONObject.put("shoubai_cuid", cuidGalaxy2);
                jSONObject.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, str);
                jSONObject.put("client_type", "Android");
                jSONObject.put("client_version", version);
                jSONObject.put("zid", zid);
                jSONObject.put("sign", c);
                sm9Var.o(jSONObject.toString());
                return sm9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                sm9Var.o("");
                return sm9Var;
            }
        }
        return (sm9) invokeL.objValue;
    }

    public sm9 h(WebView webView, int i, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{webView, Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            sm9 sm9Var = new sm9();
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                builder.can_post = Integer.valueOf(i);
                builder.block_info = str;
                builder.ahead_info = str2;
                builder.ahead_url = str3;
                builder.ok_info = str4;
                builder.ahead_type = Integer.valueOf(i2);
                BlockPopInfo build = builder.build(false);
                ct9.h(build);
                ct9.g(build);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sm9Var;
        }
        return (sm9) invokeCommon.objValue;
    }
}
