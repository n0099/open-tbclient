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
import com.baidu.wallet.core.StatusCode;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ThirdPartyLoginUtil f25985a;
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
            f25985a = new ThirdPartyLoginUtil();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f25985a : (ThirdPartyLoginUtil) invokeV.objValue;
    }

    public boolean checkThirdPartyLogin(Activity activity, int i2, String str, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        InterceptResult invokeLILL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048576, this, activity, i2, str, thirdPartyLoginListener)) == null) {
            switch (i2) {
                case StatusCode.ERROR_TURIST_LOGIN_NEED_AUTH /* 5093 */:
                case StatusCode.ERROR_THIRD_LOGIN_NEED_AUTH /* 5095 */:
                    i3 = 3;
                    break;
                case StatusCode.ERROR_TURIST_LOGIN_NEED_BIND /* 5094 */:
                case StatusCode.ERROR_THIRD_LOGIN_NEED_BIND /* 5096 */:
                    i3 = 2;
                    break;
                case StatusCode.ERROR_TURIST_LOGIN /* 5097 */:
                    i3 = 1;
                    break;
                case 5098:
                default:
                    i3 = -1;
                    break;
                case StatusCode.ERROR_NOT_PASS_LOGIN /* 5099 */:
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f25976a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Activity f25977b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f25978c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f25979d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ThirdPartyLoginUtil f25980e;

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
                    this.f25980e = this;
                    this.f25976a = i3;
                    this.f25977b = activity;
                    this.f25978c = thirdPartyLoginListener;
                    this.f25979d = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        int i4 = this.f25976a;
                        if (i4 == 0) {
                            this.f25980e.startLogin(this.f25977b, this.f25978c);
                        } else if (i4 == 1) {
                            this.f25980e.startTuristNormalize(this.f25977b, this.f25978c);
                        } else if (i4 == 2) {
                            this.f25980e.startBindPhone(this.f25977b, this.f25978c);
                        } else if (i4 == 3) {
                            this.f25980e.startPassSMSAuth(this.f25977b, this.f25978c);
                        }
                        try {
                            this.f25979d.dismiss();
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            promptDialog.setNegativeBtn(ResUtils.getString(activity, NEGATIVE_STRS[i3]), new View.OnClickListener(this, promptDialog, thirdPartyLoginListener, activity) { // from class: com.baidu.wallet.passport.ThirdPartyLoginUtil.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f25981a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f25982b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Activity f25983c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ ThirdPartyLoginUtil f25984d;

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
                    this.f25984d = this;
                    this.f25981a = promptDialog;
                    this.f25982b = thirdPartyLoginListener;
                    this.f25983c = activity;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        try {
                            this.f25981a.dismiss();
                        } catch (Throwable unused) {
                        }
                        WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = this.f25982b;
                        if (thirdPartyLoginListener2 != null) {
                            thirdPartyLoginListener2.onCallFail(0, null);
                        }
                        this.f25983c.finish();
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f25974a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ThirdPartyLoginUtil f25975b;

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
                    this.f25975b = this;
                    this.f25974a = thirdPartyLoginListener;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f25975b.loginBackListener);
                            return;
                        }
                        WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = this.f25974a;
                        if (thirdPartyLoginListener2 != null) {
                            thirdPartyLoginListener2.onCallFail(0, null);
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (thirdPartyLoginListener2 = this.f25974a) == null) {
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
