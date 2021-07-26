package com.baidu.wallet.base.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity;
import com.baidu.wallet.paysdk.ui.SelectBindCardActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;
/* loaded from: classes5.dex */
public final class PasswordController {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static PasswordController f24168a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public IPwdListener f24169b;

    /* renamed from: c  reason: collision with root package name */
    public IPwdListener f24170c;

    /* renamed from: d  reason: collision with root package name */
    public IPwdListener f24171d;

    /* renamed from: e  reason: collision with root package name */
    public IPwdListener f24172e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduPay.IBindCardCallback f24173f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f24174g;

    /* loaded from: classes5.dex */
    public interface IPwdListener {
        void onFail(int i2, String str);

        void onSucceed(String str);
    }

    public PasswordController() {
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

    public static PasswordController getPassWordInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f24168a == null) {
                f24168a = new PasswordController();
            }
            return f24168a;
        }
        return (PasswordController) invokeV.objValue;
    }

    public static String getSeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new BigInteger(64, new Random()).toString() : (String) invokeV.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwd(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
            if (TextUtils.isEmpty(localDecrypt1)) {
                return null;
            }
            String a2 = a(a(localDecrypt1));
            LogUtil.d("PasswordController", "handlePwd. pwd1 = " + a2);
            String a3 = a(a2 + str2);
            LogUtil.d("PasswordController", "handlePwd. pwd2 = " + a3);
            return SafePay.getInstance().encryptProxy(a3);
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdForPassport(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
            if (TextUtils.isEmpty(localDecrypt1)) {
                return null;
            }
            return SafePay.getInstance().encryptProxy(Md5Utils.toMD5(Md5Utils.toMD5(localDecrypt1)));
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdSimple(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
            if (TextUtils.isEmpty(localDecrypt1)) {
                return null;
            }
            return a(a(localDecrypt1));
        }
        return (String) invokeL.objValue;
    }

    public void checkPwd(Context context, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, iPwdListener) == null) {
            checkPwd(context, null, iPwdListener);
        }
    }

    public void checkPwdFail(int i2, String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (iPwdListener = this.f24169b) == null) {
            return;
        }
        iPwdListener.onFail(i2, str);
    }

    public void checkPwdForSp(Context context, Map<String, String> map, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, map, iPwdListener) == null) {
            this.f24169b = iPwdListener;
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 1;
            pwdRequest.mRequestType = 2;
            pwdRequest.mExtData = map;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdCheckActivity.class);
            intent.putExtra(BeanConstants.CHECK_PWD_FROM_TYPE_KEY, BeanConstants.FROM_CHECK_FOR_SP);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
            BaiduWalletUtils.startActivityAnim(context);
        }
    }

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, str2, iPwdListener) == null) {
            checkPwdFromH5(context, str, str2, iPwdListener, "");
        }
    }

    public void checkPwdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (iPwdListener = this.f24169b) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f24169b = null;
    }

    public void clearBindCardCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24173f = null;
        }
    }

    public void clearCheckPwdListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f24169b = null;
        }
    }

    public void clearEditPwdCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f24171d = null;
        }
    }

    public void clearForgetPasswdCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24172e = null;
        }
    }

    public void clearSetPwdListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f24170c = null;
        }
    }

    public void editPwd(Context context, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, iPwdListener) == null) {
            this.f24171d = iPwdListener;
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 2;
            pwdRequest.mRequestType = 1;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdCheckActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public void editPwdFail(int i2, String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) || (iPwdListener = this.f24171d) == null) {
            return;
        }
        iPwdListener.onFail(i2, str);
    }

    public void editPwdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (iPwdListener = this.f24171d) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f24171d = null;
    }

    public void fogetPasswd(Context context, IPwdListener iPwdListener, String str) {
        BindFastRequest createBindRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, context, iPwdListener, str) == null) {
            StatisticManager.onEvent(StatServiceEvent.FORGET_PWD);
            if (iPwdListener == null) {
                return;
            }
            if (context == null) {
                forgetPasswdFailed();
                return;
            }
            this.f24172e = iPwdListener;
            if (PayDataCache.getInstance().hasBondCards()) {
                if (PayRequestCache.getInstance().isPaying()) {
                    createBindRequest = new BindFastRequest();
                    PayRequestCache.getInstance().addBeanRequestToCache(PayRequestCache.BindCategory.Other.name(), createBindRequest);
                } else {
                    createBindRequest = BindCardEntry.createBindRequest(PayRequestCache.BindCategory.Pwd);
                }
                Intent intent = new Intent(context, SelectBindCardActivity.class);
                createBindRequest.mBindFrom = 4;
                intent.putExtra(Constants.BDL_KEY_FROM, PayRequestCache.BindCategory.Pwd.name());
                if (!BaiduWalletUtils.isActivity(context)) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                context.startActivity(intent);
            } else if (PayRequestCache.getInstance().isPaying()) {
                BindFastRequest bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 3;
                PayRequestCache.getInstance().addBeanRequestToCache(PayRequestCache.BindCategory.Other.name(), bindFastRequest);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.BDL_KEY_FROM, PayRequestCache.BindCategory.Pwd.name());
                BaiduPay.getInstance().launchBindCardActivity(context, null, bundle);
            } else {
                BaiduPay.getInstance().bindCard(context, null, PayRequestCache.BindCategory.Pwd, 3, null, null, null, null, false, null);
            }
        }
    }

    public void forgetPasswdFailed() {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (iPwdListener = this.f24172e) == null) {
            return;
        }
        iPwdListener.onFail(-1, "");
    }

    public void forgetPasswdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (iPwdListener = this.f24172e) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f24172e = null;
    }

    public void setPassByUserFail(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (iBindCardCallback = this.f24173f) == null) {
            return;
        }
        iBindCardCallback.onChangeFailed(str);
    }

    public void setPassByUserSucceed(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (iBindCardCallback = this.f24173f) == null) {
            return;
        }
        iBindCardCallback.onChangeSucceed(null);
        this.f24173f = null;
    }

    public void setPasswdByUser(Context context, BaiduPay.IBindCardCallback iBindCardCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, iBindCardCallback) == null) {
            setPasswdByUser(context, iBindCardCallback, null);
        }
    }

    public void setPwd(Context context, boolean z, IPwdListener iPwdListener, PayRequestCache.BindCategory bindCategory) {
        PwdRequest pwdRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{context, Boolean.valueOf(z), iPwdListener, bindCategory}) == null) {
            if (iPwdListener != null) {
                this.f24170c = iPwdListener;
            }
            BeanRequestBase beanRequestFromCache = PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            if (z && (beanRequestFromCache instanceof PwdRequest)) {
                pwdRequest = (PwdRequest) beanRequestFromCache;
            } else {
                pwdRequest = new PwdRequest();
                pwdRequest.mFrom = 0;
            }
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdSetAndConfirmActivity.class);
            if (bindCategory == null) {
                bindCategory = PayRequestCache.BindCategory.Other;
            }
            intent.putExtra(Constants.BDL_KEY_BINDCATEGORY, bindCategory.getScenario());
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public void setPwdFail(int i2, String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048600, this, i2, str) == null) || (iPwdListener = this.f24170c) == null) {
            return;
        }
        iPwdListener.onFail(i2, str);
    }

    public void setPwdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || (iPwdListener = this.f24170c) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f24170c = null;
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, iPwdListener) == null) {
            checkPwd(context, str, iPwdListener, "");
        }
    }

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, context, str, str2, iPwdListener, str3) == null) {
            this.f24169b = iPwdListener;
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.serviceType = str3;
            pwdRequest.mFrom = 1;
            pwdRequest.mRequestType = 2;
            pwdRequest.fromType = str2;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdCheckActivity.class);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(BeanConstants.CHECK_PWD_FROM_TYPE_KEY, str2);
            }
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra(Constants.HALF_SCREEN_PWD_VERIFY, str);
            context.startActivity(intent);
            BaiduWalletUtils.startActivityAnim(context);
        }
    }

    public void setPasswdByUser(Context context, BaiduPay.IBindCardCallback iBindCardCallback, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, context, iBindCardCallback, bundle) == null) || context == null) {
            return;
        }
        if (PayDataCache.getInstance().hasBondCards()) {
            this.f24173f = iBindCardCallback;
            String string = bundle != null ? bundle.getString(Constants.BDL_KEY_FROM) : null;
            PayRequestCache.BindCategory valueOf = string != null ? PayRequestCache.BindCategory.valueOf(string) : null;
            if (valueOf == null) {
                valueOf = PayRequestCache.BindCategory.Pwd;
            }
            BindFastRequest createBindRequest = BindCardEntry.createBindRequest(valueOf);
            createBindRequest.needSetPwd = true;
            createBindRequest.mBindFrom = 5;
            Intent intent = new Intent(context, SelectBindCardActivity.class);
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (!bundle.containsKey(Constants.BDL_KEY_FROM)) {
                bundle.putString(Constants.BDL_KEY_FROM, PayRequestCache.BindCategory.Pwd.name());
            }
            intent.putExtras(bundle);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
            return;
        }
        BaiduPay.getInstance().bindCard(context, iBindCardCallback, PayRequestCache.BindCategory.Initiative, 1, "", null, bundle, null, false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, IPwdListener iPwdListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, this, context, str, iPwdListener, str2) == null) {
            this.f24169b = iPwdListener;
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.serviceType = str2;
            pwdRequest.mFrom = 1;
            pwdRequest.mRequestType = 2;
            pwdRequest.fromType = str;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdCheckActivity.class);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(BeanConstants.CHECK_PWD_FROM_TYPE_KEY, str);
            }
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
            BaiduWalletUtils.startActivityAnim(context);
        }
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context, str, iPwdListener, str2) == null) {
            this.f24174g = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, iPwdListener, str2) { // from class: com.baidu.wallet.base.controllers.PasswordController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f24175a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f24176b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IPwdListener f24177c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f24178d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PasswordController f24179e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, iPwdListener, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24179e = this;
                    this.f24175a = context;
                    this.f24176b = str;
                    this.f24177c = iPwdListener;
                    this.f24178d = str2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f24179e.f24174g);
                        } else {
                            this.f24179e.checkPwdFail(i2, str3);
                        }
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) {
                        this.f24179e.a(this.f24175a, this.f24176b, this.f24177c, this.f24178d);
                    }
                }
            });
            WalletLoginHelper.getInstance().login(this.f24174g);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String md5 = Md5Utils.toMD5(str);
            return md5 != null ? md5.toUpperCase() : md5;
        }
        return (String) invokeL.objValue;
    }
}
