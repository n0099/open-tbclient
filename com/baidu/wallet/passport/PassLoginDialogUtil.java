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
/* loaded from: classes5.dex */
public class PassLoginDialogUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PassLoginDialogUtil f25954a;
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
            f25954a = new PassLoginDialogUtil();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f25954a : (PassLoginDialogUtil) invokeV.objValue;
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
                    public final /* synthetic */ PromptDialog f25946a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ILoginBackListener f25947b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ int f25948c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f25949d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ PassLoginDialogUtil f25950e;

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
                        this.f25950e = this;
                        this.f25946a = promptDialog;
                        this.f25947b = iLoginBackListener;
                        this.f25948c = i2;
                        this.f25949d = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            try {
                                this.f25946a.dismiss();
                            } catch (Exception e2) {
                                LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                            }
                            ILoginBackListener iLoginBackListener2 = this.f25947b;
                            if (!(iLoginBackListener2 instanceof LoginBackListenerProxy) || ((LoginBackListenerProxy) iLoginBackListener2).getLoginBackListener() == null) {
                                return;
                            }
                            ((LoginBackListenerProxy) this.f25947b).getLoginBackListener().onFail(this.f25948c, this.f25949d);
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.getString(context, "wallet_base_open_bduss_system_error_login"), new View.OnClickListener(this, promptDialog, iLoginBackListener) { // from class: com.baidu.wallet.passport.PassLoginDialogUtil.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f25951a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ILoginBackListener f25952b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ PassLoginDialogUtil f25953c;

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
                        this.f25953c = this;
                        this.f25951a = promptDialog;
                        this.f25952b = iLoginBackListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            try {
                                this.f25951a.dismiss();
                            } catch (Exception e2) {
                                LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                            }
                            WalletLoginHelper.getInstance().onlyLogin(this.f25952b);
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
