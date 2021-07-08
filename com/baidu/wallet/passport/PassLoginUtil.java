package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.LoadingActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class PassLoginUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOGIN_STATUS_ERROR_CODE = 603;

    /* renamed from: a  reason: collision with root package name */
    public static final String f25797a = "PassLoginUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final long f25798b = 300;

    /* renamed from: c  reason: collision with root package name */
    public static final long f25799c = 7000;

    /* renamed from: d  reason: collision with root package name */
    public static final int f25800d = 601;

    /* renamed from: e  reason: collision with root package name */
    public static final int f25801e = 602;

    /* renamed from: f  reason: collision with root package name */
    public static final int f25802f = 604;

    /* renamed from: g  reason: collision with root package name */
    public static final int f25803g = 605;

    /* renamed from: h  reason: collision with root package name */
    public static final int f25804h = -201;

    /* renamed from: i  reason: collision with root package name */
    public static final int f25805i = -202;
    public static final int j = -203;
    public static final int k = -901;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 6;
    public static final int q = 7;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile OpenBdussResult r;
    public CountDownTimer s;
    public CountDownTimer t;
    public boolean u;
    public long v;
    public boolean w;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final PassLoginUtil f25815a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1398157273, "Lcom/baidu/wallet/passport/PassLoginUtil$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1398157273, "Lcom/baidu/wallet/passport/PassLoginUtil$a;");
                    return;
                }
            }
            f25815a = new PassLoginUtil();
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

    public static PassLoginUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a.f25815a : (PassLoginUtil) invokeV.objValue;
    }

    public void clearOpenBduss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.r = null;
        }
    }

    public synchronized Map<String, String> getLoginData(Context context, String str) {
        InterceptResult invokeLL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            synchronized (this) {
                hashMap = new HashMap();
                if (isLogin()) {
                    if (!TextUtils.isEmpty(this.r.uid)) {
                        hashMap.put("pass_uid", this.r.uid);
                    }
                    if (!TextUtils.isEmpty(this.r.bduss)) {
                        hashMap.put("pass_bduss", this.r.bduss);
                    }
                    if (!TextUtils.isEmpty(this.r.displayname)) {
                        hashMap.put("pass_user_name", this.r.displayname);
                    }
                    if (!TextUtils.isEmpty(this.r.openBduss)) {
                        hashMap.put("pass_open_bduss", this.r.openBduss);
                    }
                    if (!TextUtils.isEmpty(this.r.unionid)) {
                        hashMap.put("pass_union_id", this.r.unionid);
                    }
                    if (this.r.tplStokenMap != null && !TextUtils.isEmpty(this.r.tplStokenMap.get(str))) {
                        hashMap.put("pass_stoken", this.r.tplStokenMap.get(str));
                    }
                    hashMap.put(IWalletLoginListener.KEY_LOGIN_TYPE, "0");
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public synchronized String getLoginOpenToken() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                str = isLogin() ? this.r.openBduss : "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getLoginStoken(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                str2 = isLogin() ? this.r.tplStokenMap.get(str) : null;
                if (isPassLogin() && TextUtils.isEmpty(str2)) {
                    DXMSdkSAUtils.onEvent(StatServiceEvent.STOKEN_EMPTY);
                    PayStatisticsUtil.onEvent(StatServiceEvent.STOKEN_EMPTY);
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public synchronized String getLoginToken() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                str = "";
                if (isPassLogin() && this.r != null && !TextUtils.isEmpty(this.r.bduss)) {
                    str = this.r.bduss;
                }
                if (isPassLogin() && TextUtils.isEmpty(str)) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.BDUSS_EMPTY);
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z, iLoginBackListener) == null) {
            synchronized (this) {
                a();
                clearOpenBduss();
                c(z, iLoginBackListener);
            }
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public synchronized boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                boolean z = false;
                if (SapiAccountManager.getInstance().isLogin()) {
                    if (this.r != null && !TextUtils.isEmpty(this.r.openBduss) && !TextUtils.isEmpty(this.r.unionid) && this.r.tplStokenMap != null) {
                        if (!TextUtils.isEmpty(this.r.tplStokenMap.get(WalletLoginHelper.getInstance().getTpl()))) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isPassLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? SapiAccountManager.getInstance().isLogin() : invokeV.booleanValue;
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SapiAccountManager.getInstance().logout();
            com.baidu.wallet.passport.a.a().b();
            clearOpenBduss();
        }
    }

    public synchronized void setErrorCodeSwitchFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            synchronized (this) {
                this.w = z;
            }
        }
    }

    public synchronized void setIntervalDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            synchronized (this) {
                this.v = j2;
            }
        }
    }

    public PassLoginUtil() {
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
        this.u = false;
        this.v = -1L;
        this.w = true;
    }

    private void b(boolean z, ILoginBackListener iLoginBackListener) {
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65546, this, z, iLoginBackListener) == null) && z) {
            long j3 = this.v;
            long j4 = 300;
            if (j3 < 0) {
                if (!TextUtils.isEmpty(SdkInitResponse.getInstance().needShowLoadingInterval)) {
                    try {
                        long parseLong = Long.parseLong(SdkInitResponse.getInstance().needShowLoadingInterval);
                        if (parseLong >= 0) {
                            j4 = parseLong;
                        }
                    } catch (Exception e2) {
                        LogUtil.d(e2.getMessage());
                    }
                }
                j2 = j4;
            } else {
                j2 = j3;
            }
            CountDownTimer countDownTimer = new CountDownTimer(this, j2, j2, z, iLoginBackListener) { // from class: com.baidu.wallet.passport.PassLoginUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f25809a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ILoginBackListener f25810b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PassLoginUtil f25811c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(j2, j2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, Long.valueOf(j2), Long.valueOf(j2), Boolean.valueOf(z), iLoginBackListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25811c = this;
                    this.f25809a = z;
                    this.f25810b = iLoginBackListener;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25811c.setIntervalDuration(-1L);
                        if (this.f25811c.r == null && this.f25809a) {
                            ILoginBackListener iLoginBackListener2 = this.f25810b;
                            if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                                this.f25811c.a(((LoginBackListenerProxy) iLoginBackListener2).getContext());
                            }
                        }
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j5) == null) {
                    }
                }
            };
            this.s = countDownTimer;
            countDownTimer.start();
        }
    }

    private void c(boolean z, ILoginBackListener iLoginBackListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65550, this, z, iLoginBackListener) == null) {
            a(z, iLoginBackListener);
            b(z, iLoginBackListener);
            GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
            getOpenBdussDTO.clientId = "fHUnn02XwCrywmmdUtCdK6eC";
            getOpenBdussDTO.targetTplList.add(WalletLoginHelper.getInstance().getTpl());
            DXMSdkSAUtils.onEventStart(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING);
            PayStatisticsUtil.onEventStart(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING);
            SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback(this, iLoginBackListener, z) { // from class: com.baidu.wallet.passport.PassLoginUtil.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILoginBackListener f25812a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f25813b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PassLoginUtil f25814c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLoginBackListener, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25814c = this;
                    this.f25812a = iLoginBackListener;
                    this.f25813b = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(OpenBdussResult openBdussResult) {
                    Map<String, String> map;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, openBdussResult) == null) {
                        this.f25814c.a();
                        this.f25814c.c();
                        this.f25814c.setIntervalDuration(-1L);
                        if (openBdussResult != null) {
                            DXMSdkSAUtils.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                            PayStatisticsUtil.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                            if (this.f25814c.u) {
                                this.f25814c.b();
                                return;
                            }
                            this.f25814c.r = openBdussResult;
                            ILoginBackListener iLoginBackListener2 = this.f25812a;
                            if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                                Context context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                                ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f25812a).getLoginBackListener();
                                if (!TextUtils.isEmpty(openBdussResult.openBduss) && !TextUtils.isEmpty(openBdussResult.unionid) && (map = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                                    com.baidu.wallet.passport.a.a().a(openBdussResult.openBduss);
                                    if (loginBackListener != null) {
                                        this.f25814c.setErrorCodeSwitchFlag(true);
                                        loginBackListener.onSuccess(2, openBdussResult.openBduss);
                                    }
                                } else if (context == null || loginBackListener == null) {
                                } else {
                                    if (this.f25813b && this.f25814c.w) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                    }
                                    this.f25814c.setErrorCodeSwitchFlag(true);
                                    DXMSdkSAUtils.onEvent(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_SUCCESS_NO_INFO);
                                    PayStatisticsUtil.onEvent(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_SUCCESS_NO_INFO);
                                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                }
                            }
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(OpenBdussResult openBdussResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openBdussResult) == null) {
                        this.f25814c.a();
                        this.f25814c.c();
                        this.f25814c.setIntervalDuration(-1L);
                        if (openBdussResult != null) {
                            DXMSdkSAUtils.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                            PayStatisticsUtil.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                            if (this.f25814c.u) {
                                this.f25814c.b();
                                return;
                            }
                            this.f25814c.logout(false);
                            ILoginBackListener iLoginBackListener2 = this.f25812a;
                            if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                                Context context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                                ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f25812a).getLoginBackListener();
                                if (loginBackListener != null) {
                                    if (openBdussResult.getResultCode() != 2 && openBdussResult.getResultCode() != 6 && openBdussResult.getResultCode() != -901) {
                                        if (openBdussResult.getResultCode() == -203) {
                                            if (context != null && this.f25813b && this.f25814c.w) {
                                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_ssl_error"));
                                            }
                                            this.f25814c.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(605, openBdussResult.getResultMsg());
                                            return;
                                        } else if (openBdussResult.getResultCode() != -201 && openBdussResult.getResultCode() != -202) {
                                            if (openBdussResult.getResultCode() != 3 && openBdussResult.getResultCode() != 4 && openBdussResult.getResultCode() != 7) {
                                                if (openBdussResult.getResultCode() == 1) {
                                                    if (context != null && this.f25813b && this.f25814c.w) {
                                                        this.f25814c.setErrorCodeSwitchFlag(true);
                                                        try {
                                                            PassLoginDialogUtil.getInstance().showLoginTipDialog(context, this.f25812a, 604, openBdussResult.getResultMsg());
                                                            return;
                                                        } catch (Exception e2) {
                                                            LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                                                            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                                            loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                            return;
                                                        }
                                                    }
                                                    this.f25814c.setErrorCodeSwitchFlag(true);
                                                    loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                    return;
                                                }
                                                if (context != null && this.f25813b && this.f25814c.w) {
                                                    GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                                }
                                                this.f25814c.setErrorCodeSwitchFlag(true);
                                                loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                                return;
                                            }
                                            if (context != null && this.f25813b && this.f25814c.w) {
                                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                            }
                                            this.f25814c.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                            return;
                                        } else {
                                            if (context != null && this.f25813b && this.f25814c.w) {
                                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                                            }
                                            this.f25814c.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(601, openBdussResult.getResultMsg());
                                            return;
                                        }
                                    }
                                    loginBackListener.onFail(603, openBdussResult.getResultMsg());
                                }
                            }
                        }
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        LogUtil.d(PassLoginUtil.f25797a, "Get Open BDUSS : onFinish");
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        LogUtil.d(PassLoginUtil.f25797a, "Get Open BDUSS : onStart");
                    }
                }
            });
        }
    }

    public void logout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                SapiAccountManager.getInstance().logout();
            }
            com.baidu.wallet.passport.a.a().b();
            clearOpenBduss();
        }
    }

    private void a(boolean z, ILoginBackListener iLoginBackListener) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65543, this, z, iLoginBackListener) == null) && z) {
            b();
            boolean z2 = iLoginBackListener instanceof LoginBackListenerProxy;
            long j2 = f25799c;
            if (z2 && (context = ((LoginBackListenerProxy) iLoginBackListener).getContext()) != null && !TextUtils.isEmpty(SdkInitResponse.getInstance().getLoadingDurationInterval(context))) {
                try {
                    long parseLong = Long.parseLong(SdkInitResponse.getInstance().getLoadingDurationInterval(context));
                    if (parseLong >= 0) {
                        j2 = parseLong;
                    }
                } catch (Exception e2) {
                    LogUtil.d(e2.getMessage());
                }
            }
            long j3 = j2;
            CountDownTimer countDownTimer = new CountDownTimer(this, j3, j3, iLoginBackListener, z) { // from class: com.baidu.wallet.passport.PassLoginUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ILoginBackListener f25806a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f25807b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PassLoginUtil f25808c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(j3, j3);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, Long.valueOf(j3), Long.valueOf(j3), iLoginBackListener, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25808c = this;
                    this.f25806a = iLoginBackListener;
                    this.f25807b = z;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f25808c.c();
                        this.f25808c.setIntervalDuration(-1L);
                        ILoginBackListener iLoginBackListener2 = this.f25806a;
                        if ((iLoginBackListener2 instanceof LoginBackListenerProxy) && this.f25807b) {
                            Context context2 = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                            ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f25806a).getLoginBackListener();
                            if (loginBackListener != null) {
                                if (context2 != null && this.f25808c.w) {
                                    GlobalUtils.toast(context2, ResUtils.getString(context2, "wallet_base_open_bduss_network_error"));
                                }
                                this.f25808c.setErrorCodeSwitchFlag(true);
                                this.f25808c.u = true;
                                loginBackListener.onFail(601, context2 != null ? ResUtils.getString(context2, "wallet_base_open_bduss_network_error") : "");
                            }
                        }
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j4) == null) {
                    }
                }
            };
            this.t = countDownTimer;
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.u = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            LoadingActivity.exitLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            CountDownTimer countDownTimer = this.s;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.s = null;
            }
            CountDownTimer countDownTimer2 = this.t;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
                this.t = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) || context == null) {
            return;
        }
        Intent intent = new Intent(context, LoadingActivity.class);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
            return;
        }
        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.getApplicationContext().startActivity(intent);
    }
}
