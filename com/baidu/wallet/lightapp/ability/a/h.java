package com.baidu.wallet.lightapp.ability.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityDeviceInfoModel;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "getDeviceInfo" : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            LogUtil.d("getDeviceInfo", str);
            NativeAbilityDeviceInfoModel nativeAbilityDeviceInfoModel = new NativeAbilityDeviceInfoModel(0);
            try {
                nativeAbilityDeviceInfoModel.cnt.data.BAIDUCUID = DeviceId.getCUID(activity);
            } catch (Exception unused) {
            }
            nativeAbilityDeviceInfoModel.cnt.data.cuid = PhoneUtils.getCUID(activity);
            NativeAbilityDeviceInfoModel.DeviceInfo deviceInfo = nativeAbilityDeviceInfoModel.cnt.data;
            deviceInfo.os = "Android";
            deviceInfo.brand = Build.BRAND;
            deviceInfo.version = Build.VERSION.RELEASE;
            deviceInfo.model = Build.MODEL;
            deviceInfo.ip = PhoneUtils.getIpInfo();
            String applicationName = PhoneUtils.getApplicationName(activity);
            String appVersionName = PhoneUtils.getAppVersionName(activity);
            NativeAbilityDeviceInfoModel.DeviceInfo deviceInfo2 = nativeAbilityDeviceInfoModel.cnt.data;
            deviceInfo2.appversioncode = PhoneUtils.getAppVersionCode(activity) + "";
            deviceInfo2.appversionname = appVersionName;
            deviceInfo2.name = applicationName;
            deviceInfo2.ua = BussinessUtils.getUA(activity);
            nativeAbilityDeviceInfoModel.cnt.data.networktype = "" + NetworkUtils.getNetworkType(activity);
            Bundle a = com.baidu.wallet.lightapp.ability.b.a.a().a(activity, JsonUtils.toJson(nativeAbilityDeviceInfoModel.cnt.data));
            nativeAbilityDeviceInfoModel.cnt.aesdata = a.getString("aesContent");
            nativeAbilityDeviceInfoModel.cnt.aeskey = a.getString("aesKey");
            nativeAbilityDeviceInfoModel.cnt.data = null;
            String json = nativeAbilityDeviceInfoModel.toJson();
            iLightappInvokerCallback.onResult(0, json);
            LogUtil.d("getDeviceInfo result = ", json);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            arrayList.add(Base64Utils.encodeToString(json.getBytes()));
        }
    }
}
