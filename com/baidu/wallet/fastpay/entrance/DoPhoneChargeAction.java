package com.baidu.wallet.fastpay.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.fastpay.ui.ChargeActivity;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class DoPhoneChargeAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LoginBackListenerProxy f24977a;

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
            a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")));
            if (routerCallback != null) {
                hashMap2.put("value", "success");
                routerCallback.onResult(0, hashMap2);
            }
        }
    }

    private void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, context, z) == null) {
            if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            } else if (LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY)) {
                Intent intent = new Intent();
                intent.setClass(context, ChargeActivity.class);
                if (context instanceof Activity) {
                    LogUtil.d("DoPhoneChargeAction", "context is activity!");
                } else {
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                this.f24977a = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, intent, z) { // from class: com.baidu.wallet.fastpay.entrance.DoPhoneChargeAction.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f24978a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Intent f24979b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f24980c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ DoPhoneChargeAction f24981d;

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
                        this.f24981d = this;
                        this.f24978a = context;
                        this.f24979b = intent;
                        this.f24980c = z;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            if (i2 == 603) {
                                WalletLoginHelper.getInstance().onlyLogin(this.f24981d.f24977a);
                                return;
                            }
                            this.f24978a.startActivity(this.f24979b);
                            Context context2 = this.f24978a;
                            if (context2 instanceof Activity) {
                                if (this.f24980c) {
                                    BaiduWalletUtils.startActivityAnim(context2);
                                } else {
                                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                                }
                            }
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                            this.f24978a.startActivity(this.f24979b);
                            Context context2 = this.f24978a;
                            if (context2 instanceof Activity) {
                                if (this.f24980c) {
                                    BaiduWalletUtils.startActivityAnim(context2);
                                } else {
                                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                                }
                            }
                        }
                    }
                });
                WalletLoginHelper.getInstance().verifyPassLogin(true, this.f24977a);
            }
        }
    }
}
