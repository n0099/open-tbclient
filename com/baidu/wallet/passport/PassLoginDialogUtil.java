package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes8.dex */
public class PassLoginDialogUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PassLoginDialogUtil f62249a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1325733809, "Lcom/baidu/wallet/passport/PassLoginDialogUtil$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1325733809, "Lcom/baidu/wallet/passport/PassLoginDialogUtil$a;");
                    return;
                }
            }
            f62249a = new PassLoginDialogUtil();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static PassLoginDialogUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f62249a : (PassLoginDialogUtil) invokeV.objValue;
    }

    public void showLoginTipDialog(Context context, ILoginBackListener iLoginBackListener, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, context, iLoginBackListener, i2, str) == null) {
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                PromptDialog promptDialog = new PromptDialog(context);
                promptDialog.setMessage(ResUtils.getString(context, "wallet_base_open_bduss_system_error"));
                promptDialog.setNegativeBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_retry"), new View.OnClickListener(this, promptDialog, iLoginBackListener, i2, str) { // from class: com.baidu.wallet.passport.PassLoginDialogUtil.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f62241a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ILoginBackListener f62242b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f62243c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f62244d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ PassLoginDialogUtil f62245e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog, iLoginBackListener, Integer.valueOf(i2), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62245e = this;
                        this.f62241a = promptDialog;
                        this.f62242b = iLoginBackListener;
                        this.f62243c = i2;
                        this.f62244d = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            try {
                                this.f62241a.dismiss();
                            } catch (Exception e2) {
                                LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                            }
                            ILoginBackListener iLoginBackListener2 = this.f62242b;
                            if (!(iLoginBackListener2 instanceof LoginBackListenerProxy) || ((LoginBackListenerProxy) iLoginBackListener2).getLoginBackListener() == null) {
                                return;
                            }
                            ((LoginBackListenerProxy) this.f62242b).getLoginBackListener().onFail(this.f62243c, this.f62244d);
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_login"), new View.OnClickListener(this, promptDialog, iLoginBackListener) { // from class: com.baidu.wallet.passport.PassLoginDialogUtil.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f62246a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ILoginBackListener f62247b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ PassLoginDialogUtil f62248c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog, iLoginBackListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62248c = this;
                        this.f62246a = promptDialog;
                        this.f62247b = iLoginBackListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            try {
                                this.f62246a.dismiss();
                            } catch (Exception e2) {
                                LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                            }
                            WalletLoginHelper.getInstance().onlyLogin(this.f62247b);
                        }
                    }
                });
                promptDialog.show();
                return;
            }
            if (context != null) {
                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
            }
            if (iLoginBackListener instanceof LoginBackListenerProxy) {
                LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
                if (loginBackListenerProxy.getLoginBackListener() != null) {
                    loginBackListenerProxy.getLoginBackListener().onFail(i2, str);
                }
            }
        }
    }

    public PassLoginDialogUtil() {
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
