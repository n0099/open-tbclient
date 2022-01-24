package com.baidu.wallet.api;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.passport.LoginImpl;
import com.baidu.wallet.passport.PassLoginUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public class WalletLoginHelper implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;
    public static final int OTHRE = 0;
    public static final int SDK_AFTER_LOGIN = 6;
    public static final int SDK_LANGBRIDGE_ENTRANCE_FLAG = 1;
    public static final int SDK_SCANCODE_ENTRANCE_FLAG = 2;
    public static final int SDK_START_SYNC_STATUS_FLAG = 4;
    public static final int SDK_START_VERIFY_LOGINSTATUS_FLAG = 5;
    public static final int SDK_SYNC_STATUS_FLAG = 3;

    /* renamed from: c  reason: collision with root package name */
    public static WalletLoginHelper f50442c;
    public transient /* synthetic */ FieldHolder $fh;
    public WalletApiExtListener.LoginstatuSyncListener a;

    /* renamed from: b  reason: collision with root package name */
    public final String f50443b;

    /* renamed from: d  reason: collision with root package name */
    public IWalletLoginListener f50444d;

    /* renamed from: e  reason: collision with root package name */
    public Context f50445e;

    /* renamed from: f  reason: collision with root package name */
    public IWalletListener f50446f;

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final WalletLoginHelper a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-890760931, "Lcom/baidu/wallet/api/WalletLoginHelper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-890760931, "Lcom/baidu/wallet/api/WalletLoginHelper$a;");
                    return;
                }
            }
            a = new WalletLoginHelper();
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

    public static final WalletLoginHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.a : (WalletLoginHelper) invokeV.objValue;
    }

    public void clearOpenBduss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            logout(false);
        }
    }

    public void configPass(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            Domain domain = Domain.DOMAIN_ONLINE;
            String environment = DebugConfig.getInstance(context).getEnvironment();
            boolean z = true;
            if ("QA".equalsIgnoreCase(environment)) {
                domain = Domain.DOMAIN_QA;
            } else if ("RD".equalsIgnoreCase(environment)) {
                domain = Domain.DOMAIN_QA;
            } else {
                z = false;
            }
            SapiConfiguration.Builder initialShareStrategy = new SapiConfiguration.Builder(context).setProductLineInfo("bdwalletsdk", "1", "3s9y80v8ipz8huoh9k06hurn2lia5eez").setRuntimeEnvironment(domain).setSocialBindType(BindType.EXPLICIT).initialShareStrategy(LoginShareStrategy.DISABLED);
            Switch r1 = Switch.ON;
            SapiAccountManager.getInstance().init(initialShareStrategy.smsLoginConfig(new SapiConfiguration.SmsLoginConfig(r1, r1, r1)).configurableViewLayout(Switch.ON).setSupportFaceLogin(false).sofireSdkConfig("600000", "69a0826db896e8c99e5d7bf63a14de3d", 600000).debug(z).build());
        }
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), str, clsArr}) == null) {
            objArr[i3] = a(i2);
            new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak(this) { // from class: com.baidu.wallet.api.WalletLoginHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletLoginHelper a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
                public void onFailure(int i4, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str2) == null) {
                        LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i4 + " , " + str2);
                    }
                }
            }, clsArr);
        }
    }

    public int getBdussState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SapiAccountManager.getInstance().getAccountService().getBdussState() : invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public Map<String, String> getLoginData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return Collections.emptyMap();
            }
            return iWalletLoginListener.getLoginData(str);
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public String getLoginStoken(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginStoken(str);
            }
            return iWalletLoginListener.getLoginStoken(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public String getLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)}) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener, i2);
            } else {
                iWalletLoginListener.getOpenBduss(z, iLoginBackListener, i2);
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getOpenLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginOpenToken();
            }
            return iWalletLoginListener.getOpenLoginToken();
        }
        return (String) invokeV.objValue;
    }

    public String getPassUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Map<String, String> loginData = getLoginData();
            if (loginData != null) {
                return loginData.get("pass_uid");
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getPassUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Map<String, String> loginData = getLoginData();
            if (loginData != null) {
                return loginData.get("pass_user_name");
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public WalletApiExtListener.LoginstatuSyncListener getSyncLoginListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a : (WalletApiExtListener.LoginstatuSyncListener) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "walletapp".equals(BeanConstants.CHANNEL_ID) ? "baiduwalletapp" : "bdwalletsdk" : (String) invokeV.objValue;
    }

    public String getUnionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            try {
                Map<String, String> loginData = getLoginData();
                if (loginData != null) {
                    return loginData.get("pass_union_id");
                }
                return null;
            } catch (Exception e2) {
                LogUtil.d("Sensor", e2.getMessage());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void handlerWalletError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            DXMSdkSAUtils.onEvent("#handlerWalletError");
            onHandleWalletError(i2);
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.handlerWalletError(i2);
            }
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, iWalletListener) == null) {
            this.f50446f = iWalletListener;
            this.f50444d = new LoginImpl(context);
            PassLoginUtil.getInstance().init();
            this.f50445e = DxmApplicationContextImpl.getApplicationContext(context);
        }
    }

    public boolean isInnerPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().isLogin();
            }
            return iWalletLoginListener.isLogin();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().isPassLogin();
            }
            return iWalletLoginListener.isPassLogin();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            } else if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f50444d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener);
                }
            } else {
                IWalletListener iWalletListener = this.f50446f;
                if (iWalletListener != null) {
                    iWalletListener.login(iLoginBackListener);
                } else if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            }
        }
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            PassLoginUtil.getInstance().logout();
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onHandleWalletError(int i2) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || (loginstatuSyncListener = this.a) == null) {
            return;
        }
        loginstatuSyncListener.onHandleWalletError(i2);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void onLoginChanaged(Context context, Map<String, String> map) {
        IWalletLoginListener iWalletLoginListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, context, map) == null) || (iWalletLoginListener = this.f50444d) == null) {
            return;
        }
        iWalletLoginListener.onLoginChanaged(context, map);
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, context) == null) || (loginstatuSyncListener = this.a) == null) {
            return;
        }
        loginstatuSyncListener.onWebViewLogout(context);
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, iLoginBackListener, str) == null) {
            clearOpenBduss();
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f50444d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener, str);
                    return;
                }
                return;
            }
            IWalletListener iWalletListener = this.f50446f;
            if (iWalletListener == null) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            } else if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        }
    }

    public void registerGlobalCallback(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, context) == null) {
            SapiAccountManager.setGlobalCallback(new GlobalCallback(this, context) { // from class: com.baidu.wallet.api.WalletLoginHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ WalletLoginHelper f50449b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f50449b = this;
                    this.a = context;
                }

                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onLoginStatusChange() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtil.d(this.f50449b.f50443b, "loginstate change");
                    }
                }

                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onLogoutSuccess(SapiAccount sapiAccount) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount) == null) {
                        super.onLogoutSuccess(sapiAccount);
                        LogUtil.d(this.f50449b.f50443b, "logout success");
                    }
                }

                @Override // com.baidu.sapi2.callback.GlobalCallback
                public void onNeedInitPassSdk() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.f50449b.configPass(this.a);
                    }
                }
            });
        }
    }

    public void setIntervalDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j2) == null) {
            PassLoginUtil.getInstance().setIntervalDuration(j2);
        }
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, loginstatuSyncListener) == null) {
            this.a = loginstatuSyncListener;
        }
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            PassLoginUtil.getInstance().setErrorCodeSwitchFlag(z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (this.f50445e == null) {
                return false;
            }
            DXMSdkSAUtils.onEvent("#startPage");
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f50444d;
                if (iWalletLoginListener != null && !iWalletLoginListener.startPage(str)) {
                    BaiduWalletDelegate.getInstance().openH5Module(this.f50445e, str, true);
                }
            } else {
                IWalletListener iWalletListener = this.f50446f;
                if (iWalletListener != null) {
                    if (!iWalletListener.startPage(str)) {
                        BaiduWalletDelegate.getInstance().openH5Module(this.f50445e, str, true);
                    }
                } else {
                    LogUtil.d(this.f50443b, "mWalletListener is null");
                    Context context = this.f50445e;
                    GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_load_fail"));
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void syncH5LoginStatus(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, context, str) == null) {
            int bdussState = getBdussState();
            String str2 = this.f50443b;
            LogUtil.d(str2, "syncH5login bdussState = " + bdussState);
            if (bdussState == 2 || bdussState == 4) {
                syncLoginStatus(context, "", new WalletApiExtListener.SyncLoginStatusCb(this, str, bdussState) { // from class: com.baidu.wallet.api.WalletLoginHelper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ int f50447b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ WalletLoginHelper f50448c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(bdussState)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f50448c = this;
                        this.a = str;
                        this.f50447b = bdussState;
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.SyncLoginStatusCb
                    public void onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult syncResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, syncResult) == null) {
                            String str3 = this.f50448c.f50443b;
                            LogUtil.d(str3, "syncH5logoin onResult code = " + syncResult);
                            DXMSdkSAUtils.onEventWithValues("DXMSyncH5LoginState", Arrays.asList(String.valueOf(syncResult.getVal()), this.a, String.valueOf(this.f50447b)));
                            if (syncResult == WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS) {
                                WalletLoginHelper.getInstance().getOpenBduss(false, null, 3);
                                com.dxmpay.wallet.api.WalletLoginHelper.getInstance().getOpenBduss(false, null);
                            }
                        }
                    }
                });
            } else if (bdussState == 3) {
                String str3 = this.f50443b;
                LogUtil.d(str3, "syncH5login = " + bdussState + " ; invoke logout");
                DXMSdkSAUtils.onEventWithValues("#invokePassLogout", Arrays.asList(String.valueOf(str)));
                onWebViewLogout(context);
                logout();
                AccountManager.getInstance(context).logout();
                com.dxmpay.wallet.api.WalletLoginHelper.getInstance().logout(false);
            }
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048615, this, context, str, syncLoginStatusCb) == null) || (loginstatuSyncListener = this.a) == null) {
            return;
        }
        loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                getOpenBduss(true, iLoginBackListener, 5);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        }
    }

    public WalletLoginHelper() {
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
        this.f50443b = WalletLoginHelper.class.getSimpleName();
    }

    private PASSMethodCallTransfer.ParamsWap a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            PASSMethodCallTransfer.ParamsWap paramsWap = new PASSMethodCallTransfer.ParamsWap();
            paramsWap.param = "";
            HashMap hashMap = new HashMap();
            paramsWap.attributes = hashMap;
            if (i2 == 26) {
                hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
            } else if (i2 == 27) {
                hashMap.put(PASSMethodCallTransfer.ParamsWap.BDUSS, "bduss");
            } else {
                hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
            }
            return paramsWap;
        }
        return (PASSMethodCallTransfer.ParamsWap) invokeI.objValue;
    }

    public void logout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            PassLoginUtil.getInstance().logout(z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public Map<String, String> getLoginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return Collections.emptyMap();
            }
            return iWalletLoginListener.getLoginData(getTpl());
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getLoginStoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f50444d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginStoken(getTpl());
            }
            return iWalletLoginListener.getLoginStoken(getTpl());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, iLoginBackListener) == null) {
            getOpenBduss(z, iLoginBackListener, 0);
        }
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, clsArr}) == null) {
            if (i2 == 28) {
                objArr[i3] = a(26);
                objArr[i4] = a(27);
            }
            new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak(this) { // from class: com.baidu.wallet.api.WalletLoginHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WalletLoginHelper a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
                public void onFailure(int i5, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i5, str2) == null) {
                        LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i5 + " , " + str2);
                    }
                }
            }, clsArr);
        }
    }

    public void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048617, this, z, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                getOpenBduss(z, iLoginBackListener, 5);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "未登录");
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener2
    public void login(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, iLoginBackListener, str) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            } else if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f50444d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener, str);
                }
            } else {
                IWalletListener iWalletListener = this.f50446f;
                if (iWalletListener == null) {
                    if (iLoginBackListener != null) {
                        iLoginBackListener.onFail(-1, "");
                    }
                } else if (iWalletListener instanceof IWalletListener2) {
                    ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
                } else {
                    iWalletListener.login(iLoginBackListener);
                }
            }
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f50444d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener);
                    return;
                }
                return;
            }
            IWalletListener iWalletListener = this.f50446f;
            if (iWalletListener == null) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            } else if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        }
    }
}
