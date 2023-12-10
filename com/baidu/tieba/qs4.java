package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.growthFunnel.GrowthFunnelHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.RefreshRateManager;
import com.baidu.tbadk.core.util.SensorAccelerometerManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes7.dex */
public class qs4 implements qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void onDestroy() {
        pj6.b(this);
    }

    public qs4() {
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

    public static /* synthetic */ void l(WebView webView) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonTbJsBridge.DEVICE_DISPLAY_REFRESH, Float.valueOf(RefreshRateManager.getInstance().getRefreshRate()));
        rj6.a().d(webView, "deviceRefreshRate", hashMap);
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                AndroidUtils.copyToClipboard(new JSONObject(str).optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.qj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.GET_ZID.equals(str2)) {
                jsPromptResult.confirm(k(webView).a());
                return true;
            } else if ("getSupplementInfo".equals(str2)) {
                jsPromptResult.confirm(j(webView).a());
                return true;
            } else if (CommonTbJsBridge.GET_DEVICE_INFO.equals(str2)) {
                jsPromptResult.confirm(h(webView).a());
                return true;
            } else if (UegTbJsBridge.METHOD_SET_BLOCK_POP_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    m(webView, jSONObject.optInt("can_post"), jSONObject.optString("block_info"), jSONObject.optString("ahead_info"), jSONObject.optString("ahead_url"), jSONObject.optString("ok_info"), jSONObject.optInt("ahead_type"));
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

    public gxa d(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, str, str2)) == null) {
            int i = (int) (JavaTypesHelper.toFloat(str, 0.0f) * 1000000.0f);
            if (TextUtils.equals(str2, "1")) {
                SensorAccelerometerManager.getSensor().start(i);
            } else {
                SensorAccelerometerManager.getSensor().stop();
            }
            gxa gxaVar = new gxa();
            gxaVar.j = true;
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa e(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", hashMap.get(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_Y));
                jSONObject.put("y", hashMap.get(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_X));
                jSONObject.put("z", hashMap.get(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_Z));
                gxaVar.o(jSONObject.toString());
                gxaVar.j = true;
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa f(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("refreshRate", hashMap.get(CommonTbJsBridge.DEVICE_DISPLAY_REFRESH));
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa g(final WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                RefreshRateManager.getInstance().start();
                ij6.a().c(new Runnable() { // from class: com.baidu.tieba.js4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            qs4.l(webView);
                        }
                    }
                });
            } else {
                RefreshRateManager.getInstance().stop();
            }
            return new gxa();
        }
        return (gxa) invokeLL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:3|(1:5)(1:133)|6|(1:8)(1:132)|9|10|11|12|(16:13|14|15|16|17|18|19|20|21|22|23|24|25|26|(1:28)(1:111)|(24:29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52))|(4:(8:53|54|55|56|57|58|59|60)|65|66|67)|61|62|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0512, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0513, code lost:
        r1 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gxa h(WebView webView) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        gxa gxaVar;
        String l;
        String valueOf;
        String str13;
        Object obj;
        String cuid;
        String model;
        String valueOf2;
        int personalizedRecSwitch;
        String valueOf3;
        String sampleId;
        String valueOf4;
        String valueOf5;
        String valueOf6;
        String cuidGalaxy2;
        String sdk_ver;
        String a;
        String subappType;
        String tbs;
        String globalUserAgent;
        String zid;
        String valueOf7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, webView)) == null) {
            String str14 = "model";
            gxa gxaVar2 = new gxa();
            StringBuilder sb2 = new StringBuilder(1024);
            String imei = TbadkCoreApplication.getInst().getImei();
            sb2.append("imei=");
            sb2.append(imei);
            String androidId = TbadkCoreApplication.getInst().getAndroidId();
            sb2.append("androidId=");
            sb2.append(androidId);
            String iMsi = TbadkCoreApplication.getInst().getIMsi();
            if (iMsi == null) {
                str = "";
            } else {
                str = iMsi;
            }
            sb2.append("imsi=");
            sb2.append(str);
            String model2 = DeviceInfoHelper.getModel();
            sb2.append("model=");
            sb2.append(DeviceInfoHelper.getModel());
            String str15 = Build.BRAND;
            sb2.append("brand=");
            sb2.append(str15);
            sb2.append("platform=");
            sb2.append("Android");
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            sb2.append("pkgName=");
            sb2.append(packageName);
            String str16 = "" + BdNetTypeUtil.netType();
            sb2.append("network=");
            sb2.append(str16);
            String str17 = "" + BdNetTypeUtil.curOperatorType();
            sb2.append("carrier=");
            sb2.append(str17);
            String devicesManufacturer = DeviceInfoUtil.getDevicesManufacturer();
            sb2.append("manufacturer=");
            sb2.append(devicesManufacturer);
            String str18 = Build.HARDWARE;
            sb2.append("hardware=");
            sb2.append(str18);
            String str19 = Build.BOARD;
            sb2.append("board=");
            sb2.append(str19);
            if (DeviceInfoUtil.isSupportGyroScope(TbadkCoreApplication.getInst())) {
                str2 = str19;
                str3 = "1";
            } else {
                str2 = str19;
                str3 = "0";
            }
            sb2.append("imu=");
            sb2.append(str3);
            String str20 = str3;
            String cuid2 = TbadkCoreApplication.getInst().getCuid();
            sb2.append("cuid=");
            sb2.append(cuid2);
            String cuidGalaxy22 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            sb2.append("shoubaiCuid=");
            sb2.append(cuidGalaxy22);
            sb2.append("clientType=");
            sb2.append("2");
            String version = TbConfig.getVersion();
            sb2.append("clientVersion=");
            sb2.append(version);
            String zid2 = TbadkCoreApplication.getInst().getZid();
            sb2.append("zId=");
            sb2.append(zid2);
            String hdid = TbadkCoreApplication.getInst().getHdid();
            sb2.append("hdid=");
            sb2.append(hdid);
            String localMacAddress = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            sb2.append("mac=");
            sb2.append(localMacAddress);
            String clientIP = UtilHelper.getClientIP();
            sb2.append("ip=");
            sb2.append(clientIP);
            String str21 = str;
            long currentTimeMillis = System.currentTimeMillis();
            sb2.append("ts=");
            sb2.append(currentTimeMillis);
            String baiduIdForAnti = TbSingleton.getInstance().getBaiduIdForAnti();
            sb2.append("baiduId=");
            sb2.append(baiduIdForAnti);
            JSONObject jSONObject = new JSONObject();
            try {
                String clientId = TbadkCoreApplication.getClientId();
                str8 = baiduIdForAnti;
                try {
                    String version2 = TbConfig.getVersion();
                    str5 = clientIP;
                    try {
                        String osVersion = DeviceInfoHelper.getOsVersion();
                        str7 = androidId;
                        try {
                            l = Long.toString(System.currentTimeMillis());
                            str6 = imei;
                            try {
                                valueOf = String.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
                                sb = sb2;
                            } catch (JSONException e) {
                                e = e;
                                str4 = "clientType";
                                sb = sb2;
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            str4 = "clientType";
                            sb = sb2;
                            str6 = imei;
                        }
                        try {
                            String str22 = Build.BRAND;
                            if (PermissionUtil.isAgreePrivacyPolicy()) {
                                str13 = "zId";
                                obj = "1";
                            } else {
                                str13 = "zId";
                                obj = "2";
                            }
                            try {
                                try {
                                    cuid = TbadkCoreApplication.getInst().getCuid();
                                } catch (JSONException e3) {
                                    e = e3;
                                    str4 = "clientType";
                                    str12 = "cuid";
                                    str11 = str13;
                                }
                                try {
                                    String valueOf8 = String.valueOf(ScheduleStrategy.getDeviceScore());
                                    try {
                                        String data = TbSingleton.getInstance().getData();
                                        String framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
                                        String naws_game_ver = TbadkCoreApplication.getInst().getNaws_game_ver();
                                        int i = GrowthFunnelHelper.realStartType;
                                        String realStartScheme = GrowthFunnelHelper.getRealStartScheme();
                                        String from = TbadkCoreApplication.getFrom();
                                        String legoLibVersion = TbConfig.getLegoLibVersion();
                                        String localMacAddress2 = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
                                        model = DeviceInfoHelper.getModel();
                                        valueOf2 = String.valueOf(BdNetTypeUtil.netType());
                                        personalizedRecSwitch = TbSingleton.getInstance().getPersonalizedRecSwitch();
                                        valueOf3 = String.valueOf(qv4.c().e());
                                        sampleId = TbSingleton.getInstance().getSampleId();
                                        valueOf4 = String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()));
                                        valueOf5 = String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
                                        try {
                                            valueOf6 = String.valueOf(Double.valueOf(BdUtilHelper.getEquipmentDensity(webView.getContext())));
                                            cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
                                            sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
                                            a = tv4.a(TbadkCoreApplication.getCurrentAccountInfo());
                                            subappType = TbConfig.getSubappType();
                                            tbs = TbadkCoreApplication.getInst().getTbs();
                                            globalUserAgent = WebviewHelper.getGlobalUserAgent();
                                            zid = TbadkCoreApplication.getInst().getZid();
                                            valueOf7 = String.valueOf(UtilHelper.getStatusBarHeight());
                                            jSONObject.put("clientType", "2");
                                            str4 = "clientType";
                                            try {
                                                jSONObject.put("clientId", clientId);
                                                jSONObject.put("clientVersion", version2);
                                                jSONObject.put("osVersion", osVersion);
                                                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, l);
                                                jSONObject.put("activeTimestamp", valueOf);
                                                jSONObject.put("brand", str22);
                                                jSONObject.put("cmode", obj);
                                                str12 = "cuid";
                                                try {
                                                    jSONObject.put(str12, cuid);
                                                    jSONObject.put("deviceScore", valueOf8);
                                                    jSONObject.put("everyDay", data);
                                                    jSONObject.put("frameworkVer", framework_ver);
                                                    jSONObject.put("nawsGameVer", naws_game_ver);
                                                    jSONObject.put(Config.START_TYPE, i);
                                                    jSONObject.put("startScheme", realStartScheme);
                                                    jSONObject.put("from", from);
                                                    jSONObject.put("legoLibVersion", legoLibVersion);
                                                    str9 = "mac";
                                                    try {
                                                        jSONObject.put(str9, localMacAddress2);
                                                        str14 = "model";
                                                    } catch (JSONException e4) {
                                                        e = e4;
                                                        str11 = str13;
                                                        str14 = "model";
                                                    }
                                                } catch (JSONException e5) {
                                                    e = e5;
                                                    str11 = str13;
                                                    str14 = "model";
                                                    str10 = "shoubaiCuid";
                                                    str9 = "mac";
                                                    e.printStackTrace();
                                                    StringBuilder sb3 = sb;
                                                    sb3.append("tiebaclient!!!");
                                                    String c = xd.c(sb3.toString());
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put("imei", str6);
                                                    jSONObject2.put("androidId", str7);
                                                    jSONObject2.put(BaseStatisContent.IMSI, str21);
                                                    jSONObject2.put(str14, model2);
                                                    jSONObject2.put("brand", str15);
                                                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                    jSONObject2.put("pkgName", packageName);
                                                    jSONObject2.put("network", str16);
                                                    jSONObject2.put("carrier", str17);
                                                    jSONObject2.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                    jSONObject2.put(HttpConstants.HTTP_HARDWARE, str18);
                                                    jSONObject2.put(HttpConstants.HTTP_BOARD, str2);
                                                    jSONObject2.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                                                    jSONObject2.put(str12, cuid2);
                                                    jSONObject2.put(str10, cuidGalaxy22);
                                                    jSONObject2.put(str4, "2");
                                                    jSONObject2.put("clientVersion", version);
                                                    jSONObject2.put(str11, zid2);
                                                    jSONObject2.put("hdid", hdid);
                                                    jSONObject2.put(str9, localMacAddress);
                                                    jSONObject2.put("ip", str5);
                                                    jSONObject2.put("ts", currentTimeMillis);
                                                    jSONObject2.put("baiduId", str8);
                                                    jSONObject2.put("publicParams", jSONObject);
                                                    jSONObject2.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                                                    jSONObject2.put("sign", c);
                                                    gxaVar = gxaVar2;
                                                    gxaVar.o(jSONObject2.toString());
                                                    return gxaVar;
                                                }
                                            } catch (JSONException e6) {
                                                e = e6;
                                                str11 = str13;
                                                str14 = "model";
                                                str10 = "shoubaiCuid";
                                                str9 = "mac";
                                                str12 = "cuid";
                                                e.printStackTrace();
                                                StringBuilder sb32 = sb;
                                                sb32.append("tiebaclient!!!");
                                                String c2 = xd.c(sb32.toString());
                                                JSONObject jSONObject22 = new JSONObject();
                                                jSONObject22.put("imei", str6);
                                                jSONObject22.put("androidId", str7);
                                                jSONObject22.put(BaseStatisContent.IMSI, str21);
                                                jSONObject22.put(str14, model2);
                                                jSONObject22.put("brand", str15);
                                                jSONObject22.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                jSONObject22.put("pkgName", packageName);
                                                jSONObject22.put("network", str16);
                                                jSONObject22.put("carrier", str17);
                                                jSONObject22.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                jSONObject22.put(HttpConstants.HTTP_HARDWARE, str18);
                                                jSONObject22.put(HttpConstants.HTTP_BOARD, str2);
                                                jSONObject22.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                                                jSONObject22.put(str12, cuid2);
                                                jSONObject22.put(str10, cuidGalaxy22);
                                                jSONObject22.put(str4, "2");
                                                jSONObject22.put("clientVersion", version);
                                                jSONObject22.put(str11, zid2);
                                                jSONObject22.put("hdid", hdid);
                                                jSONObject22.put(str9, localMacAddress);
                                                jSONObject22.put("ip", str5);
                                                jSONObject22.put("ts", currentTimeMillis);
                                                jSONObject22.put("baiduId", str8);
                                                jSONObject22.put("publicParams", jSONObject);
                                                jSONObject22.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                                                jSONObject22.put("sign", c2);
                                                gxaVar = gxaVar2;
                                                gxaVar.o(jSONObject22.toString());
                                                return gxaVar;
                                            }
                                        } catch (JSONException e7) {
                                            e = e7;
                                            str4 = "clientType";
                                        }
                                    } catch (JSONException e8) {
                                        e = e8;
                                        str4 = "clientType";
                                        str12 = "cuid";
                                    }
                                } catch (JSONException e9) {
                                    e = e9;
                                    str4 = "clientType";
                                    str12 = "cuid";
                                    str11 = str13;
                                    str14 = "model";
                                    str9 = "mac";
                                    str10 = "shoubaiCuid";
                                    e.printStackTrace();
                                    StringBuilder sb322 = sb;
                                    sb322.append("tiebaclient!!!");
                                    String c22 = xd.c(sb322.toString());
                                    JSONObject jSONObject222 = new JSONObject();
                                    jSONObject222.put("imei", str6);
                                    jSONObject222.put("androidId", str7);
                                    jSONObject222.put(BaseStatisContent.IMSI, str21);
                                    jSONObject222.put(str14, model2);
                                    jSONObject222.put("brand", str15);
                                    jSONObject222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                    jSONObject222.put("pkgName", packageName);
                                    jSONObject222.put("network", str16);
                                    jSONObject222.put("carrier", str17);
                                    jSONObject222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                    jSONObject222.put(HttpConstants.HTTP_HARDWARE, str18);
                                    jSONObject222.put(HttpConstants.HTTP_BOARD, str2);
                                    jSONObject222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                                    jSONObject222.put(str12, cuid2);
                                    jSONObject222.put(str10, cuidGalaxy22);
                                    jSONObject222.put(str4, "2");
                                    jSONObject222.put("clientVersion", version);
                                    jSONObject222.put(str11, zid2);
                                    jSONObject222.put("hdid", hdid);
                                    jSONObject222.put(str9, localMacAddress);
                                    jSONObject222.put("ip", str5);
                                    jSONObject222.put("ts", currentTimeMillis);
                                    jSONObject222.put("baiduId", str8);
                                    jSONObject222.put("publicParams", jSONObject);
                                    jSONObject222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                                    jSONObject222.put("sign", c22);
                                    gxaVar = gxaVar2;
                                    gxaVar.o(jSONObject222.toString());
                                    return gxaVar;
                                }
                            } catch (JSONException e10) {
                                e = e10;
                                str4 = "clientType";
                                str12 = "cuid";
                                str9 = "mac";
                                str10 = "shoubaiCuid";
                            }
                        } catch (JSONException e11) {
                            e = e11;
                            str4 = "clientType";
                            str9 = "mac";
                            str10 = "shoubaiCuid";
                            str11 = "zId";
                            str12 = "cuid";
                            e.printStackTrace();
                            StringBuilder sb3222 = sb;
                            sb3222.append("tiebaclient!!!");
                            String c222 = xd.c(sb3222.toString());
                            JSONObject jSONObject2222 = new JSONObject();
                            jSONObject2222.put("imei", str6);
                            jSONObject2222.put("androidId", str7);
                            jSONObject2222.put(BaseStatisContent.IMSI, str21);
                            jSONObject2222.put(str14, model2);
                            jSONObject2222.put("brand", str15);
                            jSONObject2222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                            jSONObject2222.put("pkgName", packageName);
                            jSONObject2222.put("network", str16);
                            jSONObject2222.put("carrier", str17);
                            jSONObject2222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                            jSONObject2222.put(HttpConstants.HTTP_HARDWARE, str18);
                            jSONObject2222.put(HttpConstants.HTTP_BOARD, str2);
                            jSONObject2222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                            jSONObject2222.put(str12, cuid2);
                            jSONObject2222.put(str10, cuidGalaxy22);
                            jSONObject2222.put(str4, "2");
                            jSONObject2222.put("clientVersion", version);
                            jSONObject2222.put(str11, zid2);
                            jSONObject2222.put("hdid", hdid);
                            jSONObject2222.put(str9, localMacAddress);
                            jSONObject2222.put("ip", str5);
                            jSONObject2222.put("ts", currentTimeMillis);
                            jSONObject2222.put("baiduId", str8);
                            jSONObject2222.put("publicParams", jSONObject);
                            jSONObject2222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                            jSONObject2222.put("sign", c222);
                            gxaVar = gxaVar2;
                            gxaVar.o(jSONObject2222.toString());
                            return gxaVar;
                        }
                    } catch (JSONException e12) {
                        e = e12;
                        str4 = "clientType";
                        sb = sb2;
                        str6 = imei;
                        str7 = androidId;
                        str9 = "mac";
                        str10 = "shoubaiCuid";
                        str11 = "zId";
                        str12 = "cuid";
                        e.printStackTrace();
                        StringBuilder sb32222 = sb;
                        sb32222.append("tiebaclient!!!");
                        String c2222 = xd.c(sb32222.toString());
                        JSONObject jSONObject22222 = new JSONObject();
                        jSONObject22222.put("imei", str6);
                        jSONObject22222.put("androidId", str7);
                        jSONObject22222.put(BaseStatisContent.IMSI, str21);
                        jSONObject22222.put(str14, model2);
                        jSONObject22222.put("brand", str15);
                        jSONObject22222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                        jSONObject22222.put("pkgName", packageName);
                        jSONObject22222.put("network", str16);
                        jSONObject22222.put("carrier", str17);
                        jSONObject22222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                        jSONObject22222.put(HttpConstants.HTTP_HARDWARE, str18);
                        jSONObject22222.put(HttpConstants.HTTP_BOARD, str2);
                        jSONObject22222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                        jSONObject22222.put(str12, cuid2);
                        jSONObject22222.put(str10, cuidGalaxy22);
                        jSONObject22222.put(str4, "2");
                        jSONObject22222.put("clientVersion", version);
                        jSONObject22222.put(str11, zid2);
                        jSONObject22222.put("hdid", hdid);
                        jSONObject22222.put(str9, localMacAddress);
                        jSONObject22222.put("ip", str5);
                        jSONObject22222.put("ts", currentTimeMillis);
                        jSONObject22222.put("baiduId", str8);
                        jSONObject22222.put("publicParams", jSONObject);
                        jSONObject22222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                        jSONObject22222.put("sign", c2222);
                        gxaVar = gxaVar2;
                        gxaVar.o(jSONObject22222.toString());
                        return gxaVar;
                    }
                } catch (JSONException e13) {
                    e = e13;
                    str4 = "clientType";
                    str5 = clientIP;
                }
            } catch (JSONException e14) {
                e = e14;
                str4 = "clientType";
                str5 = clientIP;
                sb = sb2;
                str6 = imei;
                str7 = androidId;
                str8 = baiduIdForAnti;
            }
            try {
                try {
                    jSONObject.put(str14, model);
                    jSONObject.put("netType", valueOf2);
                    jSONObject.put("personalizedRecSwitch", personalizedRecSwitch);
                    jSONObject.put("qType", valueOf3);
                    jSONObject.put("sampleId", sampleId);
                    jSONObject.put("scrW", valueOf4);
                    jSONObject.put("scrH", valueOf5);
                    jSONObject.put("scrDip", valueOf6);
                    str10 = "shoubaiCuid";
                    try {
                        jSONObject.put(str10, cuidGalaxy2);
                        jSONObject.put("sdkVer", sdk_ver);
                        jSONObject.put("stoken", a);
                        jSONObject.put("subappType", subappType);
                        jSONObject.put("tbs", tbs);
                        jSONObject.put("userAgent", globalUserAgent);
                        str11 = str13;
                        try {
                            jSONObject.put(str11, zid);
                            jSONObject.put("statusBarHeight", valueOf7);
                        } catch (JSONException e15) {
                            e = e15;
                            e.printStackTrace();
                            StringBuilder sb322222 = sb;
                            sb322222.append("tiebaclient!!!");
                            String c22222 = xd.c(sb322222.toString());
                            JSONObject jSONObject222222 = new JSONObject();
                            jSONObject222222.put("imei", str6);
                            jSONObject222222.put("androidId", str7);
                            jSONObject222222.put(BaseStatisContent.IMSI, str21);
                            jSONObject222222.put(str14, model2);
                            jSONObject222222.put("brand", str15);
                            jSONObject222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                            jSONObject222222.put("pkgName", packageName);
                            jSONObject222222.put("network", str16);
                            jSONObject222222.put("carrier", str17);
                            jSONObject222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                            jSONObject222222.put(HttpConstants.HTTP_HARDWARE, str18);
                            jSONObject222222.put(HttpConstants.HTTP_BOARD, str2);
                            jSONObject222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                            jSONObject222222.put(str12, cuid2);
                            jSONObject222222.put(str10, cuidGalaxy22);
                            jSONObject222222.put(str4, "2");
                            jSONObject222222.put("clientVersion", version);
                            jSONObject222222.put(str11, zid2);
                            jSONObject222222.put("hdid", hdid);
                            jSONObject222222.put(str9, localMacAddress);
                            jSONObject222222.put("ip", str5);
                            jSONObject222222.put("ts", currentTimeMillis);
                            jSONObject222222.put("baiduId", str8);
                            jSONObject222222.put("publicParams", jSONObject);
                            jSONObject222222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                            jSONObject222222.put("sign", c22222);
                            gxaVar = gxaVar2;
                            gxaVar.o(jSONObject222222.toString());
                            return gxaVar;
                        }
                    } catch (JSONException e16) {
                        e = e16;
                        str11 = str13;
                        e.printStackTrace();
                        StringBuilder sb3222222 = sb;
                        sb3222222.append("tiebaclient!!!");
                        String c222222 = xd.c(sb3222222.toString());
                        JSONObject jSONObject2222222 = new JSONObject();
                        jSONObject2222222.put("imei", str6);
                        jSONObject2222222.put("androidId", str7);
                        jSONObject2222222.put(BaseStatisContent.IMSI, str21);
                        jSONObject2222222.put(str14, model2);
                        jSONObject2222222.put("brand", str15);
                        jSONObject2222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                        jSONObject2222222.put("pkgName", packageName);
                        jSONObject2222222.put("network", str16);
                        jSONObject2222222.put("carrier", str17);
                        jSONObject2222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                        jSONObject2222222.put(HttpConstants.HTTP_HARDWARE, str18);
                        jSONObject2222222.put(HttpConstants.HTTP_BOARD, str2);
                        jSONObject2222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                        jSONObject2222222.put(str12, cuid2);
                        jSONObject2222222.put(str10, cuidGalaxy22);
                        jSONObject2222222.put(str4, "2");
                        jSONObject2222222.put("clientVersion", version);
                        jSONObject2222222.put(str11, zid2);
                        jSONObject2222222.put("hdid", hdid);
                        jSONObject2222222.put(str9, localMacAddress);
                        jSONObject2222222.put("ip", str5);
                        jSONObject2222222.put("ts", currentTimeMillis);
                        jSONObject2222222.put("baiduId", str8);
                        jSONObject2222222.put("publicParams", jSONObject);
                        jSONObject2222222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                        jSONObject2222222.put("sign", c222222);
                        gxaVar = gxaVar2;
                        gxaVar.o(jSONObject2222222.toString());
                        return gxaVar;
                    }
                } catch (JSONException e17) {
                    e = e17;
                    str11 = str13;
                    str10 = "shoubaiCuid";
                    e.printStackTrace();
                    StringBuilder sb32222222 = sb;
                    sb32222222.append("tiebaclient!!!");
                    String c2222222 = xd.c(sb32222222.toString());
                    JSONObject jSONObject22222222 = new JSONObject();
                    jSONObject22222222.put("imei", str6);
                    jSONObject22222222.put("androidId", str7);
                    jSONObject22222222.put(BaseStatisContent.IMSI, str21);
                    jSONObject22222222.put(str14, model2);
                    jSONObject22222222.put("brand", str15);
                    jSONObject22222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                    jSONObject22222222.put("pkgName", packageName);
                    jSONObject22222222.put("network", str16);
                    jSONObject22222222.put("carrier", str17);
                    jSONObject22222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                    jSONObject22222222.put(HttpConstants.HTTP_HARDWARE, str18);
                    jSONObject22222222.put(HttpConstants.HTTP_BOARD, str2);
                    jSONObject22222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
                    jSONObject22222222.put(str12, cuid2);
                    jSONObject22222222.put(str10, cuidGalaxy22);
                    jSONObject22222222.put(str4, "2");
                    jSONObject22222222.put("clientVersion", version);
                    jSONObject22222222.put(str11, zid2);
                    jSONObject22222222.put("hdid", hdid);
                    jSONObject22222222.put(str9, localMacAddress);
                    jSONObject22222222.put("ip", str5);
                    jSONObject22222222.put("ts", currentTimeMillis);
                    jSONObject22222222.put("baiduId", str8);
                    jSONObject22222222.put("publicParams", jSONObject);
                    jSONObject22222222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
                    jSONObject22222222.put("sign", c2222222);
                    gxaVar = gxaVar2;
                    gxaVar.o(jSONObject22222222.toString());
                    return gxaVar;
                }
                gxaVar.o(jSONObject22222222.toString());
                return gxaVar;
            } catch (JSONException e18) {
                e = e18;
                BdLog.e(e);
                gxaVar.o("");
                return gxaVar;
            }
            StringBuilder sb322222222 = sb;
            sb322222222.append("tiebaclient!!!");
            String c22222222 = xd.c(sb322222222.toString());
            JSONObject jSONObject222222222 = new JSONObject();
            jSONObject222222222.put("imei", str6);
            jSONObject222222222.put("androidId", str7);
            jSONObject222222222.put(BaseStatisContent.IMSI, str21);
            jSONObject222222222.put(str14, model2);
            jSONObject222222222.put("brand", str15);
            jSONObject222222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
            jSONObject222222222.put("pkgName", packageName);
            jSONObject222222222.put("network", str16);
            jSONObject222222222.put("carrier", str17);
            jSONObject222222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
            jSONObject222222222.put(HttpConstants.HTTP_HARDWARE, str18);
            jSONObject222222222.put(HttpConstants.HTTP_BOARD, str2);
            jSONObject222222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str20);
            jSONObject222222222.put(str12, cuid2);
            jSONObject222222222.put(str10, cuidGalaxy22);
            jSONObject222222222.put(str4, "2");
            jSONObject222222222.put("clientVersion", version);
            jSONObject222222222.put(str11, zid2);
            jSONObject222222222.put("hdid", hdid);
            jSONObject222222222.put(str9, localMacAddress);
            jSONObject222222222.put("ip", str5);
            jSONObject222222222.put("ts", currentTimeMillis);
            jSONObject222222222.put("baiduId", str8);
            jSONObject222222222.put("publicParams", jSONObject);
            jSONObject222222222.put("nativeReqParams", NetMessageHelper.getCommonParamsJson(true, true, true));
            jSONObject222222222.put("sign", c22222222);
            gxaVar = gxaVar2;
        } else {
            return (gxa) invokeL.objValue;
        }
    }

    public gxa i(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView)) == null) {
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("hdid", TbadkCoreApplication.getInst().getHdid());
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa k(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, webView)) == null) {
            gxa gxaVar = new gxa();
            String zid = TbadkCoreApplication.getInst().getZid();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("zid", zid);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa j(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, webView)) == null) {
            gxa gxaVar = new gxa();
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
            sb.append("2");
            String version = TbConfig.getVersion();
            sb.append("client_version=");
            sb.append(version);
            String zid = TbadkCoreApplication.getInst().getZid();
            sb.append("zid=");
            sb.append(zid);
            sb.append("tiebaclient!!!");
            String c = xd.c(sb.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", imei);
                jSONObject.put("cuid", cuid);
                jSONObject.put("shoubai_cuid", cuidGalaxy2);
                jSONObject.put("brand", str);
                jSONObject.put("client_type", "2");
                jSONObject.put("client_version", version);
                jSONObject.put("zid", zid);
                jSONObject.put("sign", c);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                gxaVar.o("");
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa m(WebView webView, int i, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{webView, Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            gxa gxaVar = new gxa();
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                builder.can_post = Integer.valueOf(i);
                builder.block_info = str;
                builder.ahead_info = str2;
                builder.ahead_url = str3;
                builder.ok_info = str4;
                builder.ahead_type = Integer.valueOf(i2);
                BlockPopInfo build = builder.build(false);
                u4b.h(build);
                u4b.g(build);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }
}
