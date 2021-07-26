package com.baidu.wallet.api;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
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
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.passport.LoginImpl;
import com.baidu.wallet.passport.PassLoginUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class WalletLoginHelper implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;

    /* renamed from: c  reason: collision with root package name */
    public static WalletLoginHelper f24057c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WalletApiExtListener.LoginstatuSyncListener f24058a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24059b;

    /* renamed from: d  reason: collision with root package name */
    public IWalletLoginListener f24060d;

    /* renamed from: e  reason: collision with root package name */
    public Context f24061e;

    /* renamed from: f  reason: collision with root package name */
    public IWalletListener f24062f;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final WalletLoginHelper f24066a;
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
            f24066a = new WalletLoginHelper();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f24066a : (WalletLoginHelper) invokeV.objValue;
    }

    public void clearOpenBduss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            logout(false);
        }
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), str, clsArr}) == null) {
            objArr[i3] = a(i2);
            new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak(this) { // from class: com.baidu.wallet.api.WalletLoginHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletLoginHelper f24063a;

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
                    this.f24063a = this;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? SapiAccountManager.getInstance().getAccountService().getBdussState() : invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public Map<String, String> getLoginData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginStoken(str);
            }
            return iWalletLoginListener.getLoginStoken(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginToken();
            }
            return iWalletLoginListener.getLoginToken();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048586, this, z, iLoginBackListener) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
            if (iWalletLoginListener == null) {
                PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
            } else {
                iWalletLoginListener.getOpenBduss(z, iLoginBackListener);
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getOpenLoginToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f24058a : (WalletApiExtListener.LoginstatuSyncListener) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? BeanConstants.CHANNEL_ID_WALLET_APP.equals(BeanConstants.CHANNEL_ID) ? "baiduwalletapp" : "bdwalletsdk" : (String) invokeV.objValue;
    }

    public String getUnionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_HANDLERWALLETERROR);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_HANDLERWALLETERROR);
            onHandleWalletError(i2);
            IWalletLoginListener iWalletLoginListener = this.f24060d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.handlerWalletError(i2);
            }
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, iWalletListener) == null) {
            this.f24062f = iWalletListener;
            this.f24060d = new LoginImpl(context);
            PassLoginUtil.getInstance().init();
            this.f24061e = context.getApplicationContext();
        }
    }

    public boolean isInnerPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
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
        if (interceptable == null || interceptable.invokeL(1048598, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            } else if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f24060d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener);
                }
            } else {
                IWalletListener iWalletListener = this.f24062f;
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
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            PassLoginUtil.getInstance().logout();
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onHandleWalletError(int i2) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || (loginstatuSyncListener = this.f24058a) == null) {
            return;
        }
        loginstatuSyncListener.onHandleWalletError(i2);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void onLoginChanaged(Context context, Map<String, String> map) {
        IWalletLoginListener iWalletLoginListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, context, map) == null) || (iWalletLoginListener = this.f24060d) == null) {
            return;
        }
        iWalletLoginListener.onLoginChanaged(context, map);
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, context) == null) || (loginstatuSyncListener = this.f24058a) == null) {
            return;
        }
        loginstatuSyncListener.onWebViewLogout(context);
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, iLoginBackListener, str) == null) {
            clearOpenBduss();
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f24060d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener, str);
                    return;
                }
                return;
            }
            IWalletListener iWalletListener = this.f24062f;
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

    public void setIntervalDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            PassLoginUtil.getInstance().setIntervalDuration(j);
        }
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, loginstatuSyncListener) == null) {
            this.f24058a = loginstatuSyncListener;
        }
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            PassLoginUtil.getInstance().setErrorCodeSwitchFlag(z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (this.f24061e == null) {
                return false;
            }
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_STARTPAGE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_STARTPAGE);
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f24060d;
                if (iWalletLoginListener != null && !iWalletLoginListener.startPage(str)) {
                    BaiduWalletDelegate.getInstance().openH5Module(this.f24061e, str, true);
                }
            } else {
                IWalletListener iWalletListener = this.f24062f;
                if (iWalletListener != null) {
                    if (!iWalletListener.startPage(str)) {
                        BaiduWalletDelegate.getInstance().openH5Module(this.f24061e, str, true);
                    }
                } else {
                    LogUtil.d(this.f24059b, "mWalletListener is null");
                    Context context = this.f24061e;
                    GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_load_fail"));
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void syncH5LoginStatus(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, context) == null) {
            int bdussState = SapiAccountManager.getInstance().getAccountService().getBdussState();
            String str = this.f24059b;
            LogUtil.d(str, "syncH5login bdussState = " + bdussState);
            if (bdussState == 2 || bdussState == 4) {
                syncLoginStatus(context, "", new WalletApiExtListener.SyncLoginStatusCb(this) { // from class: com.baidu.wallet.api.WalletLoginHelper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ WalletLoginHelper f24065a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f24065a = this;
                    }

                    @Override // com.baidu.wallet.api.WalletApiExtListener.SyncLoginStatusCb
                    public void onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult syncResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, syncResult) == null) {
                            String str2 = this.f24065a.f24059b;
                            LogUtil.d(str2, "syncH5logoin onResult code = " + syncResult);
                            DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SYNC_H5_LOGINSTATE_RESULT, Arrays.asList(String.valueOf(syncResult.getVal())));
                            PayStatisticsUtil.onEventWithValue(StatServiceEvent.SYNC_H5_LOGINSTATE_RESULT, String.valueOf(syncResult.getVal()));
                            if (syncResult == WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS) {
                                WalletLoginHelper.getInstance().getOpenBduss(false, null);
                            }
                        }
                    }
                });
            } else if (bdussState == 3) {
                String str2 = this.f24059b;
                LogUtil.d(str2, "syncH5login = " + bdussState + " ; invoke logout");
                DXMSdkSAUtils.onEvent(StatServiceEvent.INVOKE_PASS_LOGOUT);
                PayStatisticsUtil.onEvent(StatServiceEvent.INVOKE_PASS_LOGOUT);
                onWebViewLogout(context);
                logout();
                AccountManager.getInstance(context).logout();
            }
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048612, this, context, str, syncLoginStatusCb) == null) || (loginstatuSyncListener = this.f24058a) == null) {
            return;
        }
        loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                getOpenBduss(true, iLoginBackListener);
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
        this.f24059b = WalletLoginHelper.class.getSimpleName();
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
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            PassLoginUtil.getInstance().logout(z);
        }
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public Map<String, String> getLoginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            IWalletLoginListener iWalletLoginListener = this.f24060d;
            if (iWalletLoginListener == null) {
                return PassLoginUtil.getInstance().getLoginStoken(getTpl());
            }
            return iWalletLoginListener.getLoginStoken(getTpl());
        }
        return (String) invokeV.objValue;
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{obj, objArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, clsArr}) == null) {
            if (i2 == 28) {
                objArr[i3] = a(26);
                objArr[i4] = a(27);
            }
            new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak(this) { // from class: com.baidu.wallet.api.WalletLoginHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletLoginHelper f24064a;

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
                    this.f24064a = this;
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
        if (interceptable == null || interceptable.invokeZL(1048614, this, z, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                getOpenBduss(z, iLoginBackListener);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "未登录");
            }
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener2
    public void login(ILoginBackListener iLoginBackListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, iLoginBackListener, str) == null) {
            clearOpenBduss();
            if (isPassLogin()) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            } else if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f24060d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener, str);
                }
            } else {
                IWalletListener iWalletListener = this.f24062f;
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
        if (interceptable == null || interceptable.invokeL(1048605, this, iLoginBackListener) == null) {
            clearOpenBduss();
            if (isInnerPassLogin()) {
                IWalletLoginListener iWalletLoginListener = this.f24060d;
                if (iWalletLoginListener != null) {
                    iWalletLoginListener.login(iLoginBackListener);
                    return;
                }
                return;
            }
            IWalletListener iWalletListener = this.f24062f;
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
