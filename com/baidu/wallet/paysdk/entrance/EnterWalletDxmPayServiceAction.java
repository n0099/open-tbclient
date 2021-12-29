package com.baidu.wallet.paysdk.entrance;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
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
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
import com.qq.e.comm.constants.Constants;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class EnterWalletDxmPayServiceAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
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
                return;
            }
        }
        BdWalletUtils.putFunctionNameList(EnterDxmPayServiceAction.DXM_GET_SECURITY_CENTER_DATA, EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA, EnterDxmPayServiceAction.DXM_OPEN_BIOMETRICS, EnterDxmPayServiceAction.DXM_CLOSE_BIOMETRICS, EnterDxmPayServiceAction.DXM_GET_BIOMETRICS_STATUS, EnterDxmPayServiceAction.DXM_CHECK_BIOMETRICS);
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
                        if (!EnterDxmPayServiceAction.DXM_GET_SECURITY_CENTER_DATA.equals(optString) && !EnterDxmPayServiceAction.DXM_GET_PAY_SETTING_DATA.equals(optString)) {
                            if (EnterDxmPayServiceAction.DXM_OPEN_BIOMETRICS.equals(optString)) {
                                BaiduPayDelegate.getInstance().openFingerprintPay((Activity) context, new c(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ String a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ RouterCallback f54046b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ EnterWalletDxmPayServiceAction f54047c;

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
                                        this.f54047c = this;
                                        this.a = optString;
                                        this.f54046b = routerCallback;
                                    }

                                    @Override // com.baidu.wallet.paysdk.fingerprint.c
                                    public void a(int i2, String str2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                            this.f54047c.a(this.a, i2, str2, this.f54046b);
                                        }
                                    }
                                });
                            } else if (EnterDxmPayServiceAction.DXM_CLOSE_BIOMETRICS.equals(optString)) {
                                BaiduPayDelegate.getInstance().closeFingerprintPay((Activity) context, new c(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ String a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ RouterCallback f54048b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ EnterWalletDxmPayServiceAction f54049c;

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
                                        this.f54049c = this;
                                        this.a = optString;
                                        this.f54048b = routerCallback;
                                    }

                                    @Override // com.baidu.wallet.paysdk.fingerprint.c
                                    public void a(int i2, String str2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                            this.f54049c.a(this.a, i2, str2, this.f54048b);
                                        }
                                    }
                                });
                            } else if (EnterDxmPayServiceAction.DXM_GET_BIOMETRICS_STATUS.equals(optString)) {
                                BaiduPayDelegate.getInstance().getBiometricsStatus(context, new c(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ String a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ RouterCallback f54050b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ EnterWalletDxmPayServiceAction f54051c;

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
                                        this.f54051c = this;
                                        this.a = optString;
                                        this.f54050b = routerCallback;
                                    }

                                    @Override // com.baidu.wallet.paysdk.fingerprint.c
                                    public void a(int i2, String str2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                            if (i2 == 0) {
                                                this.f54051c.c(this.a, i2, str2, this.f54050b);
                                            } else {
                                                this.f54051c.a(i2, str2, this.f54050b);
                                            }
                                        }
                                    }
                                });
                            } else if (EnterDxmPayServiceAction.CHECK_PWD_FOR_H5.equals(optString)) {
                                BaiduPayServiceController.getInstance().gotoCheckPwdFromH5(context, optString2, routerCallback);
                            } else if (EnterDxmPayServiceAction.DXM_CHECK_BIOMETRICS.equals(optString)) {
                                DxmCheckFingerprint.getInstance().startCherkFingerprint(context, optString2, routerCallback);
                            } else {
                                a(10004, optString + "功能未实现", routerCallback);
                            }
                        }
                        BaiduPayDelegate.getInstance().getSecurityCenterOrPaySettingData(optString, context, new a(this, optString, routerCallback) { // from class: com.baidu.wallet.paysdk.entrance.EnterWalletDxmPayServiceAction.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ String a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ RouterCallback f54044b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ EnterWalletDxmPayServiceAction f54045c;

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
                                this.f54045c = this;
                                this.a = optString;
                                this.f54044b = routerCallback;
                            }

                            @Override // com.baidu.wallet.paysdk.securitycenter.a
                            public void a(int i2, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                    this.f54045c.b(this.a, i2, str2, this.f54044b);
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
        if (interceptable == null || interceptable.invokeLILL(65541, this, str, i2, str2, routerCallback) == null) {
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
