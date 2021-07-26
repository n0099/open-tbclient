package com.baidu.wallet.statistics.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.BasicStoreToolsWrapper;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.duxiaoman.dxmpay.statistics.StatConfigEntity;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatConfig implements NoProguard, d.d.a.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public StatConfigEntity f27480a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27481b;

    /* renamed from: com.baidu.wallet.statistics.impl.StatConfig$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static StatConfig f27482a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1004804163, "Lcom/baidu/wallet/statistics/impl/StatConfig$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1004804163, "Lcom/baidu/wallet/statistics/impl/StatConfig$a;");
                    return;
                }
            }
            f27482a = new StatConfig(null);
        }
    }

    public /* synthetic */ StatConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static StatConfig getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            a.f27482a.setContext(context);
            return a.f27482a;
        }
        return (StatConfig) invokeL.objValue;
    }

    @Override // d.d.a.a.b.b
    public int get3GSendingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StatConfigEntity statConfigEntity = this.f27480a;
            if (statConfigEntity == null) {
                return 5;
            }
            return statConfigEntity.mobile_net;
        }
        return invokeV.intValue;
    }

    @Override // d.d.a.a.b.a
    public String getAppVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? String.valueOf(PhoneUtils.getAppVersionCode(this.f27481b)) : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getAppVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PhoneUtils.getAppVersionName(this.f27481b) : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BeanConstants.CHANNEL_ID : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getCommonEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "DXMPaySDK" : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getDistinctId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isLogin() && !TextUtils.isEmpty(WalletLoginHelper.getInstance().getUnionId())) {
                return SafePay.getInstance().encryptProxy(WalletLoginHelper.getInstance().getUnionId());
            }
            return SafePay.getInstance().encryptProxy(com.baidu.wallet.statistics.impl.a.a().b(this.f27481b));
        }
        return (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getDistinctIdKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? SafePay.getInstance().getpwProxy() : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.f27481b != null) {
                    com.baidu.wallet.statistics.impl.a a2 = com.baidu.wallet.statistics.impl.a.a();
                    jSONObject.putOpt("ua", a2.c(this.f27481b));
                    jSONObject.putOpt("cu", a2.a(this.f27481b));
                    jSONObject.putOpt("op", a2.d(this.f27481b));
                    jSONObject.put("cu2", a2.b(this.f27481b));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "BaiduWallet" : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? BeanConstants.VERSION_NO : (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.a
    public String getUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return DebugConfig.getInstance().getSenorStatisticsHost() + "/sensors_batch/v2";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.d.a.a.b.b
    public int getWifiSendingInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StatConfigEntity statConfigEntity = this.f27480a;
            if (statConfigEntity == null) {
                return 3;
            }
            return statConfigEntity.wifi;
        }
        return invokeV.intValue;
    }

    @Override // d.d.a.a.b.b
    public boolean isDisabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.d.a.a.b.b
    public boolean isForceToSend(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String[] strArr = {PayStatServiceEvent.STD_PAY_SUCCESS, PayStatServiceEvent.STD_PAY_FAILED, PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, PayStatServiceEvent.PERCASHIER_PAY_FAILED, PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, PayStatServiceEvent.LBS_PAY_RESULT_ERROR, PayStatServiceEvent.LBS_PAY_RESULT_PAYING, PayStatServiceEvent.LBS_PAY_RESULT_CANCEL, PayStatServiceEvent.LBS_PAY_RESULT_SUCCESS, "endLivenessSDK"};
            try {
                Arrays.sort(strArr);
                return Arrays.binarySearch(strArr, str) >= 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.d.a.a.b.b
    public boolean isIgnoreToSend(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.d.a.a.b.a
    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? WalletLoginHelper.getInstance().isLogin() : invokeV.booleanValue;
    }

    @Override // d.d.a.a.b.a
    public void loadStrategy() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (context = this.f27481b) == null) {
            return;
        }
        String statisticsStrategy = BasicStoreToolsWrapper.getStatisticsStrategy(context);
        if (TextUtils.isEmpty(statisticsStrategy)) {
            return;
        }
        try {
            this.f27480a = (StatConfigEntity) JsonUtils.fromJson(new JSONObject(statisticsStrategy).optString("data"), StatConfigEntity.class);
        } catch (Exception e2) {
            LogUtil.errord("Sensor Config", e2.getMessage());
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, context) == null) && this.f27481b == null && context != null) {
            this.f27481b = context.getApplicationContext();
        }
    }

    public StatConfig() {
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
}
