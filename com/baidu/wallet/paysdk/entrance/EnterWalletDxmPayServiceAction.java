package com.baidu.wallet.paysdk.entrance;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduPayServiceController;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.paysdk.fingerprint.c;
import com.baidu.wallet.paysdk.fingerprint.entrance.DxmCheckFingerprint;
import com.baidu.wallet.paysdk.securitycenter.a;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import com.qq.e.comm.constants.Constants;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class EnterWalletDxmPayServiceAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHECK_BIOMETRICS = "checkBiometrics";
    public static final String GET_PAY_SETTING_DATA = "getPaySettingData";
    public static final String GET_SECURITY_CENTER_DATA = "getSecurityCenterData";
    public transient /* synthetic */ FieldHolder $fh;

    public EnterWalletDxmPayServiceAction() {
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

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) {
            if (context != null && hashMap != null && hashMap.containsKey("options") && (hashMap.get("options") instanceof String)) {
                a(context, (String) hashMap.get("options"), routerCallback);
            } else {
                a(10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2, String str2, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65543, this, str, i2, str2, routerCallback) == null) || routerCallback == null) {
            return;
        }
        if (i2 == 0) {
            c(str, i2, str2, routerCallback);
        } else if (i2 != 10011 && i2 != 10001 && i2 != 10004) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, StatHelper.collectData(str, i2 + "", str2));
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put(Constants.KEYS.RET, i2);
                jSONObject.put("msg", str2);
                jSONObject.put("content", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        } else {
            a(i2, str2, routerCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i2, String str2, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65545, this, str, i2, str2, routerCallback) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, StatHelper.collectData(str, i2 + "", str2));
            HashMap hashMap = new HashMap();
            hashMap.put("data", Base64Utils.encodeToString(str2.getBytes()));
            String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("result", assembleResult);
            routerCallback.onResult(0, hashMap2);
        }
    }

    private void a(Context context, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, context, str, routerCallback) == null) {
            if (routerCallback != null && !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(EnterDxmPayServiceAction.DXM_SERVICE_NAME);
                    String optString2 = jSONObject.optString("serviceExtra");
                    StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_ENTER, StatHelper.collectData(optString, optString2));
                    if (!TextUtils.isEmpty(optString)) {
                        if (!GET_SECURITY_CENTER_DATA.equals(optString) && !GET_PAY_SETTING_DATA.equals(optString)) {
                            if ("openBiometrics".equals(optString)) {
                                BaiduPayDelegate.getInstance().openFingerprintPay((Activity) context, new c(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ String f60605a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ RouterCallback f60606b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ EnterWalletDxmPayServiceAction f60607c;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, optString, routerCallback};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f60607c = this;
                                        this.f60605a = optString;
                                        this.f60606b = routerCallback;
                                    }

                                    @Override // com.baidu.wallet.paysdk.fingerprint.c
                                    public void a(int i2, String str2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                            this.f60607c.a(this.f60605a, i2, str2, this.f60606b);
                                        }
                                    }
                                });
                            } else if ("closeBiometrics".equals(optString)) {
                                BaiduPayDelegate.getInstance().closeFingerprintPay((Activity) context, new c(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ String f60608a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ RouterCallback f60609b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ EnterWalletDxmPayServiceAction f60610c;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, optString, routerCallback};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f60610c = this;
                                        this.f60608a = optString;
                                        this.f60609b = routerCallback;
                                    }

                                    @Override // com.baidu.wallet.paysdk.fingerprint.c
                                    public void a(int i2, String str2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                            this.f60610c.a(this.f60608a, i2, str2, this.f60609b);
                                        }
                                    }
                                });
                            } else if ("getBiometricsStatus".equals(optString)) {
                                BaiduPayDelegate.getInstance().getBiometricsStatus(context, new c(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ String f60611a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ RouterCallback f60612b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ EnterWalletDxmPayServiceAction f60613c;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, optString, routerCallback};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f60613c = this;
                                        this.f60611a = optString;
                                        this.f60612b = routerCallback;
                                    }

                                    @Override // com.baidu.wallet.paysdk.fingerprint.c
                                    public void a(int i2, String str2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                            if (i2 == 0) {
                                                this.f60613c.c(this.f60611a, i2, str2, this.f60612b);
                                            } else {
                                                this.f60613c.a(i2, str2, this.f60612b);
                                            }
                                        }
                                    }
                                });
                            } else if ("getDxmPayUserAgent".equals(optString)) {
                                c(optString, 0, BussinessUtils.getUA(context), routerCallback);
                            } else if (EnterDxmPayServiceAction.CHECK_PWD_FOR_H5.equals(optString)) {
                                BaiduPayServiceController.getInstance().gotoCheckPwdFromH5(context, optString2, routerCallback);
                            } else if (CHECK_BIOMETRICS.equals(optString)) {
                                DxmCheckFingerprint.getInstance().startCherkFingerprint(context, optString2, routerCallback);
                            } else {
                                a(10004, optString + "功能未实现", routerCallback);
                            }
                        }
                        BaiduPayDelegate.getInstance().getSecurityCenterOrPaySettingData(optString, context, new a(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f60602a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ RouterCallback f60603b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ EnterWalletDxmPayServiceAction f60604c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, optString, routerCallback};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f60604c = this;
                                this.f60602a = optString;
                                this.f60603b = routerCallback;
                            }

                            @Override // com.baidu.wallet.paysdk.securitycenter.a
                            public void a(int i2, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                    this.f60604c.b(this.f60602a, i2, str2, this.f60603b);
                                }
                            }
                        });
                    } else {
                        a(10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a(10001, e2.toString(), routerCallback);
                    return;
                }
            }
            a(10001, EnterDxmPayServiceAction.ERR_MSG, routerCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, String str2, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(AdIconUtil.AD_TEXT_ID, this, str, i2, str2, routerCallback) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_RESULT, StatHelper.collectData(str, i2 + "", str2));
            if (routerCallback != null) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                    jSONObject.put("des", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
                String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, true);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("result", assembleResult);
                routerCallback.onResult(0, hashMap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, this, i2, str, routerCallback) == null) {
            StatisticManager.onEventWithValues(StatServiceEvent.PAY_SERVICE_ERROR, StatHelper.collectData(i2 + "", str));
            if (routerCallback != null) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, i2);
                    jSONObject.put("des", str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap.put("data", Base64Utils.encodeToString(jSONObject.toString().getBytes()));
                String assembleResult = BaiduPayDelegate.getInstance().assembleResult(hashMap, false);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("result", assembleResult);
                routerCallback.onResult(1, hashMap2);
            }
        }
    }
}
