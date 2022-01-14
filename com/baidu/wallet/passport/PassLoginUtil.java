package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
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
import com.baidu.wallet.base.widget.LoadingActivity;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.MainHandler;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public class PassLoginUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOGIN_STATUS_ERROR_CODE = 603;
    public static final String a = "PassLoginUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final long f51821b = 300;

    /* renamed from: c  reason: collision with root package name */
    public static final long f51822c = 7000;

    /* renamed from: d  reason: collision with root package name */
    public static final int f51823d = 601;

    /* renamed from: e  reason: collision with root package name */
    public static final int f51824e = 602;

    /* renamed from: f  reason: collision with root package name */
    public static final int f51825f = 604;

    /* renamed from: g  reason: collision with root package name */
    public static final int f51826g = 605;

    /* renamed from: h  reason: collision with root package name */
    public static final int f51827h = -201;

    /* renamed from: i  reason: collision with root package name */
    public static final int f51828i = -202;

    /* renamed from: j  reason: collision with root package name */
    public static final int f51829j = -203;
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

    /* loaded from: classes13.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final PassLoginUtil a;
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
            a = new PassLoginUtil();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? a.a : (PassLoginUtil) invokeV.objValue;
    }

    public synchronized Map<String, String> getLoginData(Context context, String str) {
        InterceptResult invokeLL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            synchronized (this) {
                hashMap = new HashMap();
                if (isLogin()) {
                    if (!TextUtils.isEmpty(this.r.uid)) {
                        hashMap.put("pass_uid", this.r.uid);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                str2 = isLogin() ? this.r.tplStokenMap.get(str) : null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    MainHandler.getInstance().post(new Runnable(this, z, iLoginBackListener, i2) { // from class: com.baidu.wallet.passport.PassLoginUtil.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ boolean a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ ILoginBackListener f51830b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f51831c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ PassLoginUtil f51832d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f51832d = this;
                            this.a = z;
                            this.f51830b = iLoginBackListener;
                            this.f51831c = i2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f51832d.a(this.a, this.f51830b, this.f51831c);
                            }
                        }
                    });
                } else {
                    a(z, iLoginBackListener, i2);
                }
            }
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public synchronized boolean isLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? SapiAccountManager.getInstance().isLogin() : invokeV.booleanValue;
    }

    public synchronized void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                SapiAccountManager.getInstance().logout();
                com.baidu.wallet.passport.a.a().b();
                a();
            }
        }
    }

    public synchronized void setErrorCodeSwitchFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            synchronized (this) {
                this.w = z;
            }
        }
    }

    public synchronized void setIntervalDuration(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
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
        if ((interceptable == null || interceptable.invokeZL(65548, this, z, iLoginBackListener) == null) && z) {
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
            CountDownTimer countDownTimer = new CountDownTimer(this, j2, j2, z, iLoginBackListener) { // from class: com.baidu.wallet.passport.PassLoginUtil.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ILoginBackListener f51835b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PassLoginUtil f51836c;

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
                    this.f51836c = this;
                    this.a = z;
                    this.f51835b = iLoginBackListener;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f51836c.setIntervalDuration(-1L);
                        if (this.f51836c.r == null && this.a) {
                            ILoginBackListener iLoginBackListener2 = this.f51835b;
                            if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                                this.f51836c.a(((LoginBackListenerProxy) iLoginBackListener2).getContext());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.u = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            LoadingActivity.exitLoading();
        }
    }

    public synchronized void logout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            synchronized (this) {
                if (z) {
                    SapiAccountManager.getInstance().logout();
                }
                com.baidu.wallet.passport.a.a().b();
                a();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)}) == null) {
            b();
            a();
            b(z, iLoginBackListener, i2);
        }
    }

    private void b(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Boolean.valueOf(z), iLoginBackListener, Integer.valueOf(i2)}) == null) {
            a(z, iLoginBackListener);
            b(z, iLoginBackListener);
            GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
            getOpenBdussDTO.clientId = "fHUnn02XwCrywmmdUtCdK6eC";
            getOpenBdussDTO.targetTplList.add(WalletLoginHelper.getInstance().getTpl());
            DXMSdkSAUtils.onEventStart("DXMGetOpenbduss");
            SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback(this, i2, iLoginBackListener, z) { // from class: com.baidu.wallet.passport.PassLoginUtil.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ILoginBackListener f51837b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f51838c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PassLoginUtil f51839d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), iLoginBackListener, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f51839d = this;
                    this.a = i2;
                    this.f51837b = iLoginBackListener;
                    this.f51838c = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(OpenBdussResult openBdussResult) {
                    ILoginBackListener iLoginBackListener2;
                    Map<String, String> map;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, openBdussResult) == null) {
                        DXMSdkSAUtils.onEventEndWithValues("DXMGetOpenbduss", openBdussResult != null ? openBdussResult.getResultCode() : BannerFocusImageViewGroup.f50773f, Arrays.asList(String.valueOf(this.a), String.valueOf(this.f51839d.isPassLogin()), String.valueOf(this.f51839d.isLogin())));
                        this.f51839d.b();
                        this.f51839d.d();
                        this.f51839d.setIntervalDuration(-1L);
                        if (openBdussResult != null) {
                            if (this.f51839d.u) {
                                this.f51839d.c();
                                return;
                            }
                            this.f51839d.r = openBdussResult;
                            ILoginBackListener iLoginBackListener3 = this.f51837b;
                            Context context = null;
                            if (iLoginBackListener3 instanceof LoginBackListenerProxy) {
                                context = ((LoginBackListenerProxy) iLoginBackListener3).getContext();
                                iLoginBackListener2 = ((LoginBackListenerProxy) this.f51837b).getLoginBackListener();
                            } else {
                                iLoginBackListener2 = null;
                            }
                            if (!TextUtils.isEmpty(openBdussResult.openBduss) && !TextUtils.isEmpty(openBdussResult.unionid) && (map = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                                com.baidu.wallet.passport.a.a().a(openBdussResult.openBduss);
                                if (iLoginBackListener2 != null) {
                                    this.f51839d.setErrorCodeSwitchFlag(true);
                                    iLoginBackListener2.onSuccess(2, openBdussResult.openBduss);
                                }
                            } else if (context == null || iLoginBackListener2 == null) {
                            } else {
                                if (this.f51838c && this.f51839d.w) {
                                    GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                }
                                this.f51839d.setErrorCodeSwitchFlag(true);
                                DXMSdkSAUtils.onEvent("DXMGetOpenbdussSuccessNoUserInfo");
                                iLoginBackListener2.onFail(602, openBdussResult.getResultMsg());
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
                        this.f51839d.b();
                        this.f51839d.d();
                        this.f51839d.setIntervalDuration(-1L);
                        if (openBdussResult != null) {
                            DXMSdkSAUtils.onEventEndWithValues("DXMGetOpenbduss", openBdussResult.getResultCode(), Arrays.asList(String.valueOf(this.a), String.valueOf(this.f51839d.isPassLogin()), String.valueOf(this.f51839d.isLogin())));
                            if (this.f51839d.u) {
                                this.f51839d.c();
                                return;
                            }
                            this.f51839d.logout(false);
                            ILoginBackListener iLoginBackListener2 = this.f51837b;
                            if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                                Context context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                                ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.f51837b).getLoginBackListener();
                                if (loginBackListener != null) {
                                    if (openBdussResult.getResultCode() != 2 && openBdussResult.getResultCode() != 6 && openBdussResult.getResultCode() != -901) {
                                        if (openBdussResult.getResultCode() == -203) {
                                            if (context != null && this.f51838c && this.f51839d.w) {
                                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_ssl_error"));
                                            }
                                            this.f51839d.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(605, openBdussResult.getResultMsg());
                                            return;
                                        } else if (openBdussResult.getResultCode() != -201 && openBdussResult.getResultCode() != -202) {
                                            if (openBdussResult.getResultCode() != 3 && openBdussResult.getResultCode() != 4 && openBdussResult.getResultCode() != 7) {
                                                if (openBdussResult.getResultCode() == 1) {
                                                    if (context != null && this.f51838c && this.f51839d.w) {
                                                        this.f51839d.setErrorCodeSwitchFlag(true);
                                                        try {
                                                            PassLoginDialogUtil.getInstance().showLoginTipDialog(context, this.f51837b, 604, openBdussResult.getResultMsg());
                                                            return;
                                                        } catch (Exception e2) {
                                                            LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                                                            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                                            loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                            return;
                                                        }
                                                    }
                                                    this.f51839d.setErrorCodeSwitchFlag(true);
                                                    loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                    return;
                                                }
                                                if (context != null && this.f51838c && this.f51839d.w) {
                                                    GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                                }
                                                this.f51839d.setErrorCodeSwitchFlag(true);
                                                loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                                return;
                                            }
                                            if (context != null && this.f51838c && this.f51839d.w) {
                                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                            }
                                            this.f51839d.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                            return;
                                        } else {
                                            if (context != null && this.f51838c && this.f51839d.w) {
                                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                                            }
                                            this.f51839d.setErrorCodeSwitchFlag(true);
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
                        LogUtil.d(PassLoginUtil.a, "Get Open BDUSS : onFinish");
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        LogUtil.d(PassLoginUtil.a, "Get Open BDUSS : onStart");
                    }
                }
            });
        }
    }

    private void a(boolean z, ILoginBackListener iLoginBackListener) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65544, this, z, iLoginBackListener) == null) && z) {
            c();
            boolean z2 = iLoginBackListener instanceof LoginBackListenerProxy;
            long j2 = f51822c;
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
            CountDownTimer countDownTimer = new CountDownTimer(this, j3, j3, iLoginBackListener, z) { // from class: com.baidu.wallet.passport.PassLoginUtil.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ILoginBackListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f51833b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ PassLoginUtil f51834c;

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
                    this.f51834c = this;
                    this.a = iLoginBackListener;
                    this.f51833b = z;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f51834c.d();
                        this.f51834c.setIntervalDuration(-1L);
                        ILoginBackListener iLoginBackListener2 = this.a;
                        if ((iLoginBackListener2 instanceof LoginBackListenerProxy) && this.f51833b) {
                            Context context2 = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                            ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.a).getLoginBackListener();
                            if (loginBackListener != null) {
                                if (context2 != null && this.f51834c.w) {
                                    GlobalUtils.toast(context2, ResUtils.getString(context2, "wallet_base_open_bduss_network_error"));
                                }
                                this.f51834c.setErrorCodeSwitchFlag(true);
                                this.f51834c.u = true;
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
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
        intent.addFlags(268435456);
        DxmApplicationContextImpl.getApplicationContext(context).startActivity(intent);
    }
}
