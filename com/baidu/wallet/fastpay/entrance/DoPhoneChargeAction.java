package com.baidu.wallet.fastpay.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.fastpay.ui.ChargeActivity;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class DoPhoneChargeAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_DATAS_KEY = "eventData";
    public transient /* synthetic */ FieldHolder $fh;
    public LoginBackListenerProxy a;

    public DoPhoneChargeAction() {
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
            HashMap hashMap2 = new HashMap();
            if (context == null || hashMap == null) {
                if (routerCallback != null) {
                    hashMap2.put("desc", "params_invalid");
                    routerCallback.onResult(3, hashMap2);
                    return;
                }
                return;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) hashMap.get("withAnim"));
            String str = (String) hashMap.get("extra");
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(str.trim()).optJSONArray(EVENT_DATAS_KEY);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.optString(i2));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            a(context, parseBoolean, arrayList);
            if (routerCallback != null) {
                hashMap2.put("value", "success");
                routerCallback.onResult(0, hashMap2);
            }
        }
    }

    private void a(Context context, boolean z, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, Boolean.valueOf(z), arrayList}) == null) {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            } else if (LocalRouter.getInstance(context).isProviderExisted("fastpay")) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(EVENT_DATAS_KEY, arrayList);
                intent.putExtras(bundle);
                intent.setClass(context, ChargeActivity.class);
                if (context instanceof Activity) {
                    LogUtil.d("DoPhoneChargeAction", "context is activity!");
                } else {
                    intent.setFlags(268435456);
                }
                this.a = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, intent, z) { // from class: com.baidu.wallet.fastpay.entrance.DoPhoneChargeAction.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Intent f53054b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f53055c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ DoPhoneChargeAction f53056d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, intent, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f53056d = this;
                        this.a = context;
                        this.f53054b = intent;
                        this.f53055c = z;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            if (i2 == 603) {
                                WalletLoginHelper.getInstance().onlyLogin(this.f53056d.a);
                                return;
                            }
                            this.a.startActivity(this.f53054b);
                            Context context2 = this.a;
                            if (context2 instanceof Activity) {
                                if (this.f53055c) {
                                    BaiduWalletUtils.startActivityAnim(context2);
                                } else {
                                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                                }
                            }
                            this.f53056d.a = null;
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                            this.a.startActivity(this.f53054b);
                            Context context2 = this.a;
                            if (context2 instanceof Activity) {
                                if (this.f53055c) {
                                    BaiduWalletUtils.startActivityAnim(context2);
                                } else {
                                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                                }
                            }
                            this.f53056d.a = null;
                        }
                    }
                });
                WalletLoginHelper.getInstance().verifyPassLogin(true, this.a);
            }
        }
    }
}
