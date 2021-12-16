package com.baidu.wallet.home.entrance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.home.WalletNewHomeActivity;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.RouterAction;
import com.baidu.wallet.router.RouterCallback;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class StartWalletHomeAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "StartWalletHomeAction";
    public transient /* synthetic */ FieldHolder $fh;

    public StartWalletHomeAction() {
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

    private void a(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intent intent = new Intent();
            intent.setClass(context, WalletNewHomeActivity.class);
            if (context instanceof Activity) {
                LogUtil.d(BEAN_TAG, "context is activity!");
            } else {
                intent.setFlags(268435456);
            }
            intent.putExtra("pageType", z2 ? HomeCfgBean.PAGE_CREDIT : HomeCfgBean.PAGE_HOME);
            intent.putExtra("with_anim", z);
            WalletLoginHelper.getInstance().verifyPassLogin(true, new LoginBackListenerProxy(context, new ILoginBackListener(this, context, intent, z) { // from class: com.baidu.wallet.home.entrance.StartWalletHomeAction.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Intent f53146b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f53147c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ StartWalletHomeAction f53148d;

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
                    this.f53148d = this;
                    this.a = context;
                    this.f53146b = intent;
                    this.f53147c = z;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Context context2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603 && (context2 = this.a) != null) {
                            GlobalUtils.toast(context2, ResUtils.getString(context2, "wallet_home_login_invalid_dialog_tips"));
                        }
                        this.a.startActivity(this.f53146b);
                        Context context3 = this.a;
                        if (context3 instanceof Activity) {
                            if (this.f53147c) {
                                BaiduWalletUtils.startActivityAnim(context3);
                            } else {
                                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context3);
                            }
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        this.a.startActivity(this.f53146b);
                        Context context2 = this.a;
                        if (context2 instanceof Activity) {
                            if (this.f53147c) {
                                BaiduWalletUtils.startActivityAnim(context2);
                            } else {
                                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                            }
                        }
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || a(context, hashMap, routerCallback)) {
            return;
        }
        a(context, Boolean.parseBoolean((String) hashMap.get("withAnim")), Boolean.parseBoolean((String) hashMap.get("pageType")));
        if (routerCallback != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("desc", "success");
            routerCallback.onResult(0, hashMap2);
        }
    }

    private boolean a(Context context, HashMap hashMap, RouterCallback routerCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, context, hashMap, routerCallback)) == null) {
            if (context == null || hashMap == null || !hashMap.containsKey("withAnim")) {
                if (routerCallback != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("errorMsg", "params-error");
                    routerCallback.onResult(3, hashMap2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
