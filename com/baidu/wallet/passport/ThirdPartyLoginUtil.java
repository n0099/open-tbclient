package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes2.dex */
public class ThirdPartyLoginUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] NEGATIVE_STRS;
    public static final String[] POSITIVE_STRS;
    public static final int THIRD_PARTH_BINDPHONE = 2;
    public static final int THIRD_PARTH_LOGIN = 0;
    public static final int THIRD_PARTH_NORMALIZE = 1;
    public static final int THIRD_PARTH_NOT = -1;
    public static final int THIRD_PARTH_PASSAUTH = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginBackListenerProxy loginBackListener;
    public WalletApiExtListener.ThirdPartyLoginInterface mTPLImpl;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static ThirdPartyLoginUtil a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-108504889, "Lcom/baidu/wallet/passport/ThirdPartyLoginUtil$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-108504889, "Lcom/baidu/wallet/passport/ThirdPartyLoginUtil$a;");
                    return;
                }
            }
            a = new ThirdPartyLoginUtil();
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1260446684, "Lcom/baidu/wallet/passport/ThirdPartyLoginUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1260446684, "Lcom/baidu/wallet/passport/ThirdPartyLoginUtil;");
                return;
            }
        }
        POSITIVE_STRS = new String[]{"bd_wallet_base_third_login_positive", "bd_wallet_base_third_login_normalize", "bd_wallet_base_third_login_bindphone", "bd_wallet_base_third_login_passauth"};
        NEGATIVE_STRS = new String[]{"bd_wallet_base_third_login_negative", "bd_wallet_base_third_login_giveup", "bd_wallet_base_third_login_giveup", "bd_wallet_base_third_login_giveup"};
    }

    public ThirdPartyLoginUtil() {
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

    public static ThirdPartyLoginUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (ThirdPartyLoginUtil) invokeV.objValue;
    }

    public boolean checkThirdPartyLogin(Activity activity, int i2, String str, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        InterceptResult invokeLILL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, activity, i2, str, thirdPartyLoginListener)) == null) {
            switch (i2) {
                case 5093:
                case 5095:
                    i3 = 3;
                    break;
                case 5094:
                case 5096:
                    i3 = 2;
                    break;
                case 5097:
                    i3 = 1;
                    break;
                case 5098:
                default:
                    i3 = -1;
                    break;
                case 5099:
                    i3 = 0;
                    break;
            }
            if (i3 == -1) {
                return false;
            }
            PromptDialog promptDialog = new PromptDialog(activity);
            if (i3 == 0) {
                promptDialog.setTitleText(ResUtils.getString(activity, "bd_wallet_base_third_login_title"));
            } else {
                promptDialog.hideTitle();
            }
            promptDialog.setMessage(str);
            promptDialog.setPositiveBtn(ResUtils.getString(activity, POSITIVE_STRS[i3]), new View.OnClickListener(this, i3, activity, thirdPartyLoginListener, promptDialog) { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Activity f52053b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f52054c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f52055d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ThirdPartyLoginUtil f52056e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i3), activity, thirdPartyLoginListener, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52056e = this;
                    this.a = i3;
                    this.f52053b = activity;
                    this.f52054c = thirdPartyLoginListener;
                    this.f52055d = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        int i4 = this.a;
                        if (i4 == 0) {
                            this.f52056e.startLogin(this.f52053b, this.f52054c);
                        } else if (i4 == 1) {
                            this.f52056e.startTuristNormalize(this.f52053b, this.f52054c);
                        } else if (i4 == 2) {
                            this.f52056e.startBindPhone(this.f52053b, this.f52054c);
                        } else if (i4 == 3) {
                            this.f52056e.startPassSMSAuth(this.f52053b, this.f52054c);
                        }
                        try {
                            this.f52055d.dismiss();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            promptDialog.setNegativeBtn(ResUtils.getString(activity, NEGATIVE_STRS[i3]), new View.OnClickListener(this, promptDialog, thirdPartyLoginListener, activity) { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PromptDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f52057b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Activity f52058c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ ThirdPartyLoginUtil f52059d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, promptDialog, thirdPartyLoginListener, activity};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52059d = this;
                    this.a = promptDialog;
                    this.f52057b = thirdPartyLoginListener;
                    this.f52058c = activity;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        try {
                            this.a.dismiss();
                        } catch (Throwable unused) {
                        }
                        WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = this.f52057b;
                        if (thirdPartyLoginListener2 != null) {
                            thirdPartyLoginListener2.onCallFail(0, null);
                        }
                        this.f52058c.finish();
                    }
                }
            });
            try {
                promptDialog.show();
            } catch (Throwable unused) {
            }
            return true;
        }
        return invokeLILL.booleanValue;
    }

    public void setThirdPartyLoginImpl(WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, thirdPartyLoginInterface) == null) {
            this.mTPLImpl = thirdPartyLoginInterface;
        }
    }

    public void startBindPhone(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, thirdPartyLoginListener) == null) {
            WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
            if (thirdPartyLoginInterface != null) {
                thirdPartyLoginInterface.callBindPhone(activity, thirdPartyLoginListener);
            } else {
                thirdPartyLoginListener.onCallFail(0, null);
            }
        }
    }

    public void startLogin(Context context, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, thirdPartyLoginListener) == null) {
            this.loginBackListener = new LoginBackListenerProxy(context, new ILoginBackListener(this, thirdPartyLoginListener) { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ThirdPartyLoginUtil f52052b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, thirdPartyLoginListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52052b = this;
                    this.a = thirdPartyLoginListener;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f52052b.loginBackListener);
                            return;
                        }
                        WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = this.a;
                        if (thirdPartyLoginListener2 != null) {
                            thirdPartyLoginListener2.onCallFail(0, null);
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (thirdPartyLoginListener2 = this.a) == null) {
                        return;
                    }
                    thirdPartyLoginListener2.onCallSuccess(0, null);
                }
            });
            WalletLoginHelper.getInstance().login(this.loginBackListener);
        }
    }

    public void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, thirdPartyLoginListener) == null) {
            PassSMSAuthProxyActivity.startPassSMSAuth(activity, thirdPartyLoginListener);
        }
    }

    public void startTuristNormalize(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, thirdPartyLoginListener) == null) {
            WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
            if (thirdPartyLoginInterface != null) {
                thirdPartyLoginInterface.callTuristNormalize(activity, thirdPartyLoginListener);
            } else {
                thirdPartyLoginListener.onCallFail(0, null);
            }
        }
    }
}
