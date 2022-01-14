package com.baidu.wallet.paysdk.fingerprint.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.ui.DxmCheckFingerprintActivity;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RouterCallback a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52012b;

    /* renamed from: com.baidu.wallet.paysdk.fingerprint.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C2013a {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-497420629, "Lcom/baidu/wallet/paysdk/fingerprint/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-497420629, "Lcom/baidu/wallet/paysdk/fingerprint/a/a$a;");
                    return;
                }
            }
            a = new a();
        }
    }

    private int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (WalletFingerprint.getInstance(this.f52012b).isDevicesSupport()) {
                if (WalletFingerprint.getInstance(this.f52012b).hasEnrollFingerprint()) {
                    return !WalletFingerprint.getInstance(this.f52012b).hasOTPToken() ? 3003 : 0;
                }
                return 2111;
            }
            return 2112;
        }
        return invokeV.intValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.a = null;
            this.f52012b = null;
        }
    }

    public a() {
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2013a.a : (a) invokeV.objValue;
    }

    public void a(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, routerCallback) == null) {
            if (context != null && routerCallback != null) {
                this.a = routerCallback;
                this.f52012b = context;
                WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
                WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(context, new ILoginBackListener(this, str) { // from class: com.baidu.wallet.paysdk.fingerprint.a.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f52013b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f52013b = this;
                        this.a = str;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                            this.f52013b.a(5003, str2);
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                            this.f52013b.a(this.a);
                        }
                    }
                }));
                return;
            }
            throw new IllegalArgumentException(a.class.getSimpleName() + " please check params");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        JSONObject jSONObject;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            int b2 = b();
            String str2 = "";
            if (b2 != 0) {
                if (b2 == 2112) {
                    str2 = "设备不支持指纹";
                } else if (b2 == 2111) {
                    str2 = "设备系统设置中没有录入指纹";
                } else if (b2 == 3003) {
                    str2 = "设备支付设置中没有开启指纹";
                }
                a(b2, str2);
                return;
            }
            int i2 = 3;
            int i3 = 0;
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject = new JSONObject(str);
                    optInt = jSONObject.optInt("showSwitchPwd", 0);
                } catch (JSONException e2) {
                    e = e2;
                }
                try {
                    i2 = jSONObject.optInt("checkTimes", 0);
                    str2 = jSONObject.optString("session_id", "");
                    i3 = optInt;
                } catch (JSONException e3) {
                    e = e3;
                    i3 = optInt;
                    e.printStackTrace();
                    a(i3, i2, str2);
                }
            }
            a(i3, i2, str2);
        }
    }

    private void a(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65539, this, i2, i3, str) == null) {
            Intent intent = new Intent(this.f52012b, DxmCheckFingerprintActivity.class);
            intent.putExtra("showSwitchPwd", i2);
            intent.putExtra("checkTimes", i3);
            intent.putExtra("session_id", str);
            this.f52012b.startActivity(intent);
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, StatHelper.collectData(EnterDxmPayServiceAction.DXM_CHECK_BIOMETRICS, i2 + "", str));
            if (this.a != null) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                    jSONObject.put("des", str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
                String assembleResult = EnterDxmPayServiceAction.assembleResult(hashMap, true);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("result", assembleResult);
                this.a.onResult(0, hashMap2);
                c();
            }
        }
    }
}
