package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.RefreshRateManager;
import com.baidu.tbadk.core.util.SensorGyroscopeManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes6.dex */
public class ky4 implements sl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sl6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        rl6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.sl6
    public /* synthetic */ void onDestroy() {
        rl6.b(this);
    }

    public ky4() {
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
        tl6.a().d(webView, "deviceRefreshRate", hashMap);
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                li.a(new JSONObject(str).optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.sl6
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

    public wy9 d(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, str, str2)) == null) {
            int d = (int) (tg.d(str, 0.0f) * 1000000.0f);
            if (TextUtils.equals(str2, "1")) {
                SensorGyroscopeManager.getSensor().start(d);
            } else {
                SensorGyroscopeManager.getSensor().stop();
            }
            return new wy9();
        }
        return (wy9) invokeLLL.objValue;
    }

    public wy9 e(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            wy9 wy9Var = new wy9();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", hashMap.get(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_Y));
                jSONObject.put("y", hashMap.get(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_X));
                jSONObject.put("z", hashMap.get(CommonTbJsBridge.SENSOR_GYROSCOPE_EVENT_Z));
                wy9Var.o(jSONObject.toString());
                return wy9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return wy9Var;
            }
        }
        return (wy9) invokeLL.objValue;
    }

    public wy9 f(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            wy9 wy9Var = new wy9();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("refreshRate", hashMap.get(CommonTbJsBridge.DEVICE_DISPLAY_REFRESH));
                wy9Var.o(jSONObject.toString());
                return wy9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return wy9Var;
            }
        }
        return (wy9) invokeLL.objValue;
    }

    public wy9 g(final WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                RefreshRateManager.getInstance().start();
                kl6.a().c(new Runnable() { // from class: com.baidu.tieba.dy4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ky4.l(webView);
                        }
                    }
                });
            } else {
                RefreshRateManager.getInstance().stop();
            }
            return new wy9();
        }
        return (wy9) invokeLL.objValue;
    }

    public wy9 h(WebView webView) {
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
        wy9 wy9Var;
        String clientId;
        String version;
        String str13;
        String str14;
        Object obj;
        String cuid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, webView)) == null) {
            String str15 = "model";
            wy9 wy9Var2 = new wy9();
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
            String g = xi.g();
            sb2.append("model=");
            sb2.append(xi.g());
            String str16 = Build.BRAND;
            sb2.append("brand=");
            sb2.append(str16);
            sb2.append("platform=");
            sb2.append("Android");
            String packageName = TbadkCoreApplication.getInst().getPackageName();
            sb2.append("pkgName=");
            sb2.append(packageName);
            String str17 = "" + BdNetTypeUtil.netType();
            sb2.append("network=");
            sb2.append(str17);
            String str18 = "" + BdNetTypeUtil.curOperatorType();
            sb2.append("carrier=");
            sb2.append(str18);
            String devicesManufacturer = DeviceInfoUtil.getDevicesManufacturer();
            sb2.append("manufacturer=");
            sb2.append(devicesManufacturer);
            String str19 = Build.HARDWARE;
            sb2.append("hardware=");
            sb2.append(str19);
            String str20 = Build.BOARD;
            sb2.append("board=");
            sb2.append(str20);
            if (DeviceInfoUtil.isSupportGyroScope(TbadkCoreApplication.getInst())) {
                str2 = str20;
                str3 = "1";
            } else {
                str2 = str20;
                str3 = "0";
            }
            sb2.append("imu=");
            sb2.append(str3);
            String str21 = str3;
            String cuid2 = TbadkCoreApplication.getInst().getCuid();
            sb2.append("cuid=");
            sb2.append(cuid2);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            sb2.append("shoubaiCuid=");
            sb2.append(cuidGalaxy2);
            sb2.append("clientType=");
            sb2.append("2");
            String version2 = TbConfig.getVersion();
            sb2.append("clientVersion=");
            sb2.append(version2);
            String zid = TbadkCoreApplication.getInst().getZid();
            sb2.append("zId=");
            sb2.append(zid);
            String hdid = TbadkCoreApplication.getInst().getHdid();
            sb2.append("hdid=");
            sb2.append(hdid);
            String localMacAddress = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
            sb2.append("mac=");
            sb2.append(localMacAddress);
            String clientIP = UtilHelper.getClientIP();
            sb2.append("ip=");
            sb2.append(clientIP);
            String str22 = str;
            long currentTimeMillis = System.currentTimeMillis();
            sb2.append("ts=");
            sb2.append(currentTimeMillis);
            String baiduIdForAnti = TbSingleton.getInstance().getBaiduIdForAnti();
            sb2.append("baiduId=");
            sb2.append(baiduIdForAnti);
            JSONObject jSONObject = new JSONObject();
            try {
                clientId = TbadkCoreApplication.getClientId();
                str8 = baiduIdForAnti;
                try {
                    version = TbConfig.getVersion();
                    str5 = clientIP;
                } catch (JSONException e) {
                    e = e;
                    str4 = "clientType";
                    str5 = clientIP;
                }
            } catch (JSONException e2) {
                e = e2;
                str4 = "clientType";
                str5 = clientIP;
                sb = sb2;
                str6 = imei;
                str7 = androidId;
                str8 = baiduIdForAnti;
            }
            try {
                try {
                    try {
                        String k = xi.k();
                        str7 = androidId;
                        try {
                            String l = Long.toString(System.currentTimeMillis());
                            str6 = imei;
                            try {
                                String valueOf = String.valueOf(TbSingleton.getInstance().getActiveTimeStamp());
                                sb = sb2;
                                try {
                                    str13 = Build.BRAND;
                                    if (PermissionUtil.isAgreePrivacyPolicy()) {
                                        str14 = "zId";
                                        obj = "1";
                                    } else {
                                        str14 = "zId";
                                        obj = "2";
                                    }
                                    try {
                                        try {
                                            cuid = TbadkCoreApplication.getInst().getCuid();
                                        } catch (JSONException e3) {
                                            e = e3;
                                            str4 = "clientType";
                                            str12 = "cuid";
                                            str11 = str14;
                                        }
                                    } catch (JSONException e4) {
                                        e = e4;
                                        str4 = "clientType";
                                        str12 = "cuid";
                                        str9 = "mac";
                                        str10 = "shoubaiCuid";
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                    str4 = "clientType";
                                    str9 = "mac";
                                    str10 = "shoubaiCuid";
                                    str11 = "zId";
                                    str12 = "cuid";
                                    e.printStackTrace();
                                    StringBuilder sb3 = sb;
                                    sb3.append("tiebaclient!!!");
                                    String c = cj.c(sb3.toString());
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("imei", str6);
                                    jSONObject2.put("androidId", str7);
                                    jSONObject2.put(BaseStatisContent.IMSI, str22);
                                    jSONObject2.put(str15, g);
                                    jSONObject2.put("brand", str16);
                                    jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                    jSONObject2.put("pkgName", packageName);
                                    jSONObject2.put("network", str17);
                                    jSONObject2.put("carrier", str18);
                                    jSONObject2.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                    jSONObject2.put(HttpConstants.HTTP_HARDWARE, str19);
                                    jSONObject2.put(HttpConstants.HTTP_BOARD, str2);
                                    jSONObject2.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                    jSONObject2.put(str12, cuid2);
                                    jSONObject2.put(str10, cuidGalaxy2);
                                    jSONObject2.put(str4, "2");
                                    jSONObject2.put("clientVersion", version2);
                                    jSONObject2.put(str11, zid);
                                    jSONObject2.put("hdid", hdid);
                                    jSONObject2.put(str9, localMacAddress);
                                    jSONObject2.put("ip", str5);
                                    jSONObject2.put("ts", currentTimeMillis);
                                    jSONObject2.put("baiduId", str8);
                                    jSONObject2.put("publicParams", jSONObject);
                                    jSONObject2.put("sign", c);
                                    wy9Var = wy9Var2;
                                    wy9Var.o(jSONObject2.toString());
                                    return wy9Var;
                                }
                                try {
                                    String valueOf2 = String.valueOf(ScheduleStrategy.getDeviceScore());
                                    try {
                                        String data = TbSingleton.getInstance().getData();
                                        String framework_ver = TbadkCoreApplication.getInst().getFramework_ver();
                                        String naws_game_ver = TbadkCoreApplication.getInst().getNaws_game_ver();
                                        int i = a85.f;
                                        String e6 = a85.e();
                                        String from = TbadkCoreApplication.getFrom();
                                        String legoLibVersion = TbConfig.getLegoLibVersion();
                                        String localMacAddress2 = PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst());
                                        String g2 = xi.g();
                                        String valueOf3 = String.valueOf(BdNetTypeUtil.netType());
                                        int personalizedRecSwitch = TbSingleton.getInstance().getPersonalizedRecSwitch();
                                        String valueOf4 = String.valueOf(n05.c().e());
                                        String sampleId = TbSingleton.getInstance().getSampleId();
                                        String valueOf5 = String.valueOf(vi.l(TbadkCoreApplication.getInst().getApp()));
                                        String valueOf6 = String.valueOf(vi.j(TbadkCoreApplication.getInst().getApp()));
                                        try {
                                            String valueOf7 = String.valueOf(Double.valueOf(vi.i(webView.getContext())));
                                            String cuidGalaxy22 = TbadkCoreApplication.getInst().getCuidGalaxy2();
                                            String sdk_ver = TbadkCoreApplication.getInst().getSdk_ver();
                                            String a = r05.a(TbadkCoreApplication.getCurrentAccountInfo());
                                            String subappType = TbConfig.getSubappType();
                                            String tbs = TbadkCoreApplication.getInst().getTbs();
                                            String b = zx5.b();
                                            String zid2 = TbadkCoreApplication.getInst().getZid();
                                            jSONObject.put("clientType", "2");
                                            str4 = "clientType";
                                            try {
                                                jSONObject.put("clientId", clientId);
                                                jSONObject.put("clientVersion", version);
                                                jSONObject.put("osVersion", k);
                                                jSONObject.put(PmsConstant.Statistic.Key.REV_TIMESTAMP, l);
                                                jSONObject.put("activeTimestamp", valueOf);
                                                jSONObject.put("brand", str13);
                                                jSONObject.put("cmode", obj);
                                                str12 = "cuid";
                                                try {
                                                    jSONObject.put(str12, cuid);
                                                    jSONObject.put("deviceScore", valueOf2);
                                                    jSONObject.put("everyDay", data);
                                                    jSONObject.put("frameworkVer", framework_ver);
                                                    jSONObject.put("nawsGameVer", naws_game_ver);
                                                    jSONObject.put(Config.START_TYPE, i);
                                                    jSONObject.put("startScheme", e6);
                                                    jSONObject.put("from", from);
                                                    jSONObject.put("legoLibVersion", legoLibVersion);
                                                    str9 = "mac";
                                                    try {
                                                        jSONObject.put(str9, localMacAddress2);
                                                        str15 = "model";
                                                    } catch (JSONException e7) {
                                                        e = e7;
                                                        str11 = str14;
                                                        str15 = "model";
                                                    }
                                                    try {
                                                        jSONObject.put(str15, g2);
                                                        jSONObject.put("netType", valueOf3);
                                                        jSONObject.put("personalizedRecSwitch", personalizedRecSwitch);
                                                        jSONObject.put("qType", valueOf4);
                                                        jSONObject.put("sampleId", sampleId);
                                                        jSONObject.put("scrW", valueOf5);
                                                        jSONObject.put("scrH", valueOf6);
                                                        jSONObject.put("scrDip", valueOf7);
                                                        str10 = "shoubaiCuid";
                                                        try {
                                                            jSONObject.put(str10, cuidGalaxy22);
                                                            jSONObject.put("sdkVer", sdk_ver);
                                                            jSONObject.put("stoken", a);
                                                            jSONObject.put("subappType", subappType);
                                                            jSONObject.put("tbs", tbs);
                                                            jSONObject.put(TTDownloadField.TT_USERAGENT, b);
                                                            str11 = str14;
                                                            try {
                                                                jSONObject.put(str11, zid2);
                                                            } catch (JSONException e8) {
                                                                e = e8;
                                                                e.printStackTrace();
                                                                StringBuilder sb32 = sb;
                                                                sb32.append("tiebaclient!!!");
                                                                String c2 = cj.c(sb32.toString());
                                                                JSONObject jSONObject22 = new JSONObject();
                                                                jSONObject22.put("imei", str6);
                                                                jSONObject22.put("androidId", str7);
                                                                jSONObject22.put(BaseStatisContent.IMSI, str22);
                                                                jSONObject22.put(str15, g);
                                                                jSONObject22.put("brand", str16);
                                                                jSONObject22.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                                jSONObject22.put("pkgName", packageName);
                                                                jSONObject22.put("network", str17);
                                                                jSONObject22.put("carrier", str18);
                                                                jSONObject22.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                                jSONObject22.put(HttpConstants.HTTP_HARDWARE, str19);
                                                                jSONObject22.put(HttpConstants.HTTP_BOARD, str2);
                                                                jSONObject22.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                                                jSONObject22.put(str12, cuid2);
                                                                jSONObject22.put(str10, cuidGalaxy2);
                                                                jSONObject22.put(str4, "2");
                                                                jSONObject22.put("clientVersion", version2);
                                                                jSONObject22.put(str11, zid);
                                                                jSONObject22.put("hdid", hdid);
                                                                jSONObject22.put(str9, localMacAddress);
                                                                jSONObject22.put("ip", str5);
                                                                jSONObject22.put("ts", currentTimeMillis);
                                                                jSONObject22.put("baiduId", str8);
                                                                jSONObject22.put("publicParams", jSONObject);
                                                                jSONObject22.put("sign", c2);
                                                                wy9Var = wy9Var2;
                                                                wy9Var.o(jSONObject22.toString());
                                                                return wy9Var;
                                                            }
                                                        } catch (JSONException e9) {
                                                            e = e9;
                                                            str11 = str14;
                                                            e.printStackTrace();
                                                            StringBuilder sb322 = sb;
                                                            sb322.append("tiebaclient!!!");
                                                            String c22 = cj.c(sb322.toString());
                                                            JSONObject jSONObject222 = new JSONObject();
                                                            jSONObject222.put("imei", str6);
                                                            jSONObject222.put("androidId", str7);
                                                            jSONObject222.put(BaseStatisContent.IMSI, str22);
                                                            jSONObject222.put(str15, g);
                                                            jSONObject222.put("brand", str16);
                                                            jSONObject222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                            jSONObject222.put("pkgName", packageName);
                                                            jSONObject222.put("network", str17);
                                                            jSONObject222.put("carrier", str18);
                                                            jSONObject222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                            jSONObject222.put(HttpConstants.HTTP_HARDWARE, str19);
                                                            jSONObject222.put(HttpConstants.HTTP_BOARD, str2);
                                                            jSONObject222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                                            jSONObject222.put(str12, cuid2);
                                                            jSONObject222.put(str10, cuidGalaxy2);
                                                            jSONObject222.put(str4, "2");
                                                            jSONObject222.put("clientVersion", version2);
                                                            jSONObject222.put(str11, zid);
                                                            jSONObject222.put("hdid", hdid);
                                                            jSONObject222.put(str9, localMacAddress);
                                                            jSONObject222.put("ip", str5);
                                                            jSONObject222.put("ts", currentTimeMillis);
                                                            jSONObject222.put("baiduId", str8);
                                                            jSONObject222.put("publicParams", jSONObject);
                                                            jSONObject222.put("sign", c22);
                                                            wy9Var = wy9Var2;
                                                            wy9Var.o(jSONObject222.toString());
                                                            return wy9Var;
                                                        }
                                                    } catch (JSONException e10) {
                                                        e = e10;
                                                        str11 = str14;
                                                        str10 = "shoubaiCuid";
                                                        e.printStackTrace();
                                                        StringBuilder sb3222 = sb;
                                                        sb3222.append("tiebaclient!!!");
                                                        String c222 = cj.c(sb3222.toString());
                                                        JSONObject jSONObject2222 = new JSONObject();
                                                        jSONObject2222.put("imei", str6);
                                                        jSONObject2222.put("androidId", str7);
                                                        jSONObject2222.put(BaseStatisContent.IMSI, str22);
                                                        jSONObject2222.put(str15, g);
                                                        jSONObject2222.put("brand", str16);
                                                        jSONObject2222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                        jSONObject2222.put("pkgName", packageName);
                                                        jSONObject2222.put("network", str17);
                                                        jSONObject2222.put("carrier", str18);
                                                        jSONObject2222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                        jSONObject2222.put(HttpConstants.HTTP_HARDWARE, str19);
                                                        jSONObject2222.put(HttpConstants.HTTP_BOARD, str2);
                                                        jSONObject2222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                                        jSONObject2222.put(str12, cuid2);
                                                        jSONObject2222.put(str10, cuidGalaxy2);
                                                        jSONObject2222.put(str4, "2");
                                                        jSONObject2222.put("clientVersion", version2);
                                                        jSONObject2222.put(str11, zid);
                                                        jSONObject2222.put("hdid", hdid);
                                                        jSONObject2222.put(str9, localMacAddress);
                                                        jSONObject2222.put("ip", str5);
                                                        jSONObject2222.put("ts", currentTimeMillis);
                                                        jSONObject2222.put("baiduId", str8);
                                                        jSONObject2222.put("publicParams", jSONObject);
                                                        jSONObject2222.put("sign", c222);
                                                        wy9Var = wy9Var2;
                                                        wy9Var.o(jSONObject2222.toString());
                                                        return wy9Var;
                                                    }
                                                } catch (JSONException e11) {
                                                    e = e11;
                                                    str11 = str14;
                                                    str15 = "model";
                                                    str10 = "shoubaiCuid";
                                                    str9 = "mac";
                                                    e.printStackTrace();
                                                    StringBuilder sb32222 = sb;
                                                    sb32222.append("tiebaclient!!!");
                                                    String c2222 = cj.c(sb32222.toString());
                                                    JSONObject jSONObject22222 = new JSONObject();
                                                    jSONObject22222.put("imei", str6);
                                                    jSONObject22222.put("androidId", str7);
                                                    jSONObject22222.put(BaseStatisContent.IMSI, str22);
                                                    jSONObject22222.put(str15, g);
                                                    jSONObject22222.put("brand", str16);
                                                    jSONObject22222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                    jSONObject22222.put("pkgName", packageName);
                                                    jSONObject22222.put("network", str17);
                                                    jSONObject22222.put("carrier", str18);
                                                    jSONObject22222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                    jSONObject22222.put(HttpConstants.HTTP_HARDWARE, str19);
                                                    jSONObject22222.put(HttpConstants.HTTP_BOARD, str2);
                                                    jSONObject22222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                                    jSONObject22222.put(str12, cuid2);
                                                    jSONObject22222.put(str10, cuidGalaxy2);
                                                    jSONObject22222.put(str4, "2");
                                                    jSONObject22222.put("clientVersion", version2);
                                                    jSONObject22222.put(str11, zid);
                                                    jSONObject22222.put("hdid", hdid);
                                                    jSONObject22222.put(str9, localMacAddress);
                                                    jSONObject22222.put("ip", str5);
                                                    jSONObject22222.put("ts", currentTimeMillis);
                                                    jSONObject22222.put("baiduId", str8);
                                                    jSONObject22222.put("publicParams", jSONObject);
                                                    jSONObject22222.put("sign", c2222);
                                                    wy9Var = wy9Var2;
                                                    wy9Var.o(jSONObject22222.toString());
                                                    return wy9Var;
                                                }
                                            } catch (JSONException e12) {
                                                e = e12;
                                                str11 = str14;
                                                str15 = "model";
                                                str10 = "shoubaiCuid";
                                                str9 = "mac";
                                                str12 = "cuid";
                                                e.printStackTrace();
                                                StringBuilder sb322222 = sb;
                                                sb322222.append("tiebaclient!!!");
                                                String c22222 = cj.c(sb322222.toString());
                                                JSONObject jSONObject222222 = new JSONObject();
                                                jSONObject222222.put("imei", str6);
                                                jSONObject222222.put("androidId", str7);
                                                jSONObject222222.put(BaseStatisContent.IMSI, str22);
                                                jSONObject222222.put(str15, g);
                                                jSONObject222222.put("brand", str16);
                                                jSONObject222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                                jSONObject222222.put("pkgName", packageName);
                                                jSONObject222222.put("network", str17);
                                                jSONObject222222.put("carrier", str18);
                                                jSONObject222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                                jSONObject222222.put(HttpConstants.HTTP_HARDWARE, str19);
                                                jSONObject222222.put(HttpConstants.HTTP_BOARD, str2);
                                                jSONObject222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                                jSONObject222222.put(str12, cuid2);
                                                jSONObject222222.put(str10, cuidGalaxy2);
                                                jSONObject222222.put(str4, "2");
                                                jSONObject222222.put("clientVersion", version2);
                                                jSONObject222222.put(str11, zid);
                                                jSONObject222222.put("hdid", hdid);
                                                jSONObject222222.put(str9, localMacAddress);
                                                jSONObject222222.put("ip", str5);
                                                jSONObject222222.put("ts", currentTimeMillis);
                                                jSONObject222222.put("baiduId", str8);
                                                jSONObject222222.put("publicParams", jSONObject);
                                                jSONObject222222.put("sign", c22222);
                                                wy9Var = wy9Var2;
                                                wy9Var.o(jSONObject222222.toString());
                                                return wy9Var;
                                            }
                                        } catch (JSONException e13) {
                                            e = e13;
                                            str4 = "clientType";
                                        }
                                    } catch (JSONException e14) {
                                        e = e14;
                                        str4 = "clientType";
                                        str12 = "cuid";
                                    }
                                } catch (JSONException e15) {
                                    e = e15;
                                    str4 = "clientType";
                                    str12 = "cuid";
                                    str11 = str14;
                                    str15 = "model";
                                    str9 = "mac";
                                    str10 = "shoubaiCuid";
                                    e.printStackTrace();
                                    StringBuilder sb3222222 = sb;
                                    sb3222222.append("tiebaclient!!!");
                                    String c222222 = cj.c(sb3222222.toString());
                                    JSONObject jSONObject2222222 = new JSONObject();
                                    jSONObject2222222.put("imei", str6);
                                    jSONObject2222222.put("androidId", str7);
                                    jSONObject2222222.put(BaseStatisContent.IMSI, str22);
                                    jSONObject2222222.put(str15, g);
                                    jSONObject2222222.put("brand", str16);
                                    jSONObject2222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                                    jSONObject2222222.put("pkgName", packageName);
                                    jSONObject2222222.put("network", str17);
                                    jSONObject2222222.put("carrier", str18);
                                    jSONObject2222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                                    jSONObject2222222.put(HttpConstants.HTTP_HARDWARE, str19);
                                    jSONObject2222222.put(HttpConstants.HTTP_BOARD, str2);
                                    jSONObject2222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                                    jSONObject2222222.put(str12, cuid2);
                                    jSONObject2222222.put(str10, cuidGalaxy2);
                                    jSONObject2222222.put(str4, "2");
                                    jSONObject2222222.put("clientVersion", version2);
                                    jSONObject2222222.put(str11, zid);
                                    jSONObject2222222.put("hdid", hdid);
                                    jSONObject2222222.put(str9, localMacAddress);
                                    jSONObject2222222.put("ip", str5);
                                    jSONObject2222222.put("ts", currentTimeMillis);
                                    jSONObject2222222.put("baiduId", str8);
                                    jSONObject2222222.put("publicParams", jSONObject);
                                    jSONObject2222222.put("sign", c222222);
                                    wy9Var = wy9Var2;
                                    wy9Var.o(jSONObject2222222.toString());
                                    return wy9Var;
                                }
                            } catch (JSONException e16) {
                                e = e16;
                                str4 = "clientType";
                                sb = sb2;
                            }
                        } catch (JSONException e17) {
                            e = e17;
                            str4 = "clientType";
                            sb = sb2;
                            str6 = imei;
                        }
                    } catch (JSONException e18) {
                        e = e18;
                        str4 = "clientType";
                        sb = sb2;
                        str6 = imei;
                        str7 = androidId;
                        str9 = "mac";
                        str10 = "shoubaiCuid";
                        str11 = "zId";
                        str12 = "cuid";
                        e.printStackTrace();
                        StringBuilder sb32222222 = sb;
                        sb32222222.append("tiebaclient!!!");
                        String c2222222 = cj.c(sb32222222.toString());
                        JSONObject jSONObject22222222 = new JSONObject();
                        jSONObject22222222.put("imei", str6);
                        jSONObject22222222.put("androidId", str7);
                        jSONObject22222222.put(BaseStatisContent.IMSI, str22);
                        jSONObject22222222.put(str15, g);
                        jSONObject22222222.put("brand", str16);
                        jSONObject22222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                        jSONObject22222222.put("pkgName", packageName);
                        jSONObject22222222.put("network", str17);
                        jSONObject22222222.put("carrier", str18);
                        jSONObject22222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                        jSONObject22222222.put(HttpConstants.HTTP_HARDWARE, str19);
                        jSONObject22222222.put(HttpConstants.HTTP_BOARD, str2);
                        jSONObject22222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                        jSONObject22222222.put(str12, cuid2);
                        jSONObject22222222.put(str10, cuidGalaxy2);
                        jSONObject22222222.put(str4, "2");
                        jSONObject22222222.put("clientVersion", version2);
                        jSONObject22222222.put(str11, zid);
                        jSONObject22222222.put("hdid", hdid);
                        jSONObject22222222.put(str9, localMacAddress);
                        jSONObject22222222.put("ip", str5);
                        jSONObject22222222.put("ts", currentTimeMillis);
                        jSONObject22222222.put("baiduId", str8);
                        jSONObject22222222.put("publicParams", jSONObject);
                        jSONObject22222222.put("sign", c2222222);
                        wy9Var = wy9Var2;
                        wy9Var.o(jSONObject22222222.toString());
                        return wy9Var;
                    }
                    wy9Var.o(jSONObject22222222.toString());
                    return wy9Var;
                } catch (JSONException e19) {
                    e = e19;
                    BdLog.e(e);
                    wy9Var.o("");
                    return wy9Var;
                }
                JSONObject jSONObject222222222 = new JSONObject();
                jSONObject222222222.put("imei", str6);
                jSONObject222222222.put("androidId", str7);
                jSONObject222222222.put(BaseStatisContent.IMSI, str22);
                jSONObject222222222.put(str15, g);
                jSONObject222222222.put("brand", str16);
                jSONObject222222222.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "Android");
                jSONObject222222222.put("pkgName", packageName);
                jSONObject222222222.put("network", str17);
                jSONObject222222222.put("carrier", str18);
                jSONObject222222222.put(HttpConstants.HTTP_MANUFACTURER, devicesManufacturer);
                jSONObject222222222.put(HttpConstants.HTTP_HARDWARE, str19);
                jSONObject222222222.put(HttpConstants.HTTP_BOARD, str2);
                jSONObject222222222.put(ARPScriptEnvironment.KEY_DATA_PIP_IMU, str21);
                jSONObject222222222.put(str12, cuid2);
                jSONObject222222222.put(str10, cuidGalaxy2);
                jSONObject222222222.put(str4, "2");
                jSONObject222222222.put("clientVersion", version2);
                jSONObject222222222.put(str11, zid);
                jSONObject222222222.put("hdid", hdid);
                jSONObject222222222.put(str9, localMacAddress);
                jSONObject222222222.put("ip", str5);
                jSONObject222222222.put("ts", currentTimeMillis);
                jSONObject222222222.put("baiduId", str8);
                jSONObject222222222.put("publicParams", jSONObject);
                jSONObject222222222.put("sign", c2222222);
                wy9Var = wy9Var2;
            } catch (JSONException e20) {
                e = e20;
                wy9Var = wy9Var2;
            }
            StringBuilder sb322222222 = sb;
            sb322222222.append("tiebaclient!!!");
            String c22222222 = cj.c(sb322222222.toString());
        } else {
            return (wy9) invokeL.objValue;
        }
    }

    public wy9 i(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView)) == null) {
            wy9 wy9Var = new wy9();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("hdid", TbadkCoreApplication.getInst().getHdid());
                wy9Var.o(jSONObject.toString());
                return wy9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return wy9Var;
            }
        }
        return (wy9) invokeL.objValue;
    }

    public wy9 k(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, webView)) == null) {
            wy9 wy9Var = new wy9();
            String zid = TbadkCoreApplication.getInst().getZid();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("zid", zid);
                wy9Var.o(jSONObject.toString());
                return wy9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                return wy9Var;
            }
        }
        return (wy9) invokeL.objValue;
    }

    public wy9 j(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, webView)) == null) {
            wy9 wy9Var = new wy9();
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
            String c = cj.c(sb.toString());
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
                wy9Var.o(jSONObject.toString());
                return wy9Var;
            } catch (JSONException e) {
                BdLog.e(e);
                wy9Var.o("");
                return wy9Var;
            }
        }
        return (wy9) invokeL.objValue;
    }

    public wy9 m(WebView webView, int i, String str, String str2, String str3, String str4, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{webView, Integer.valueOf(i), str, str2, str3, str4, Integer.valueOf(i2)})) == null) {
            wy9 wy9Var = new wy9();
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                builder.can_post = Integer.valueOf(i);
                builder.block_info = str;
                builder.ahead_info = str2;
                builder.ahead_url = str3;
                builder.ok_info = str4;
                builder.ahead_type = Integer.valueOf(i2);
                BlockPopInfo build = builder.build(false);
                m5a.h(build);
                m5a.g(build);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return wy9Var;
        }
        return (wy9) invokeCommon.objValue;
    }
}
