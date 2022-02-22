package com.baidu.wallet.base.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;
/* loaded from: classes13.dex */
public final class PasswordController {
    public static /* synthetic */ Interceptable $ic;
    public static PasswordController a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public IPwdListener f50717b;

    /* renamed from: c  reason: collision with root package name */
    public IPwdListener f50718c;

    /* renamed from: d  reason: collision with root package name */
    public IPwdListener f50719d;

    /* renamed from: e  reason: collision with root package name */
    public IPwdListener f50720e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduPay.IBindCardCallback f50721f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f50722g;

    /* loaded from: classes13.dex */
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a == null) {
                a = new PasswordController();
            }
            return a;
        }
        return (PasswordController) invokeV.objValue;
    }

    public static String getSeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new BigInteger(64, new Random()).toString() : (String) invokeV.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwd(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SecurePay.getInstance().localDecrypt1(str);
            if (TextUtils.isEmpty(localDecrypt1)) {
                return null;
            }
            String a2 = a(a(localDecrypt1));
            String str3 = "handlePwd. pwd1 = " + a2;
            String a3 = a(a2 + str2);
            String str4 = "handlePwd. pwd2 = " + a3;
            return SecurePay.getInstance().encryptProxy(a3);
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdForPassport(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SecurePay.getInstance().localDecrypt1(str);
            if (TextUtils.isEmpty(localDecrypt1)) {
                return null;
            }
            return SecurePay.getInstance().encryptProxy(Md5Utils.toMD5(Md5Utils.toMD5(localDecrypt1)));
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdSimple(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SecurePay.getInstance().localDecrypt1(str);
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
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (iPwdListener = this.f50717b) == null) {
            return;
        }
        iPwdListener.onFail(i2, str);
    }

    public void checkPwdForSp(Context context, Map<String, String> map, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, map, iPwdListener) == null) {
            this.f50717b = iPwdListener;
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 1;
            pwdRequest.mRequestType = 2;
            pwdRequest.mExtData = map;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdCheckActivity.class);
            intent.putExtra(BeanConstants.CHECK_PWD_FROM_TYPE_KEY, BeanConstants.FROM_CHECK_FOR_SP);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (iPwdListener = this.f50717b) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f50717b = null;
    }

    public void clearBindCardCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f50721f = null;
        }
    }

    public void clearCheckPwdListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f50717b = null;
        }
    }

    public void clearEditPwdCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f50719d = null;
        }
    }

    public void clearForgetPasswdCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f50720e = null;
        }
    }

    public void clearSetPwdListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f50718c = null;
        }
    }

    public void editPwd(Context context, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, iPwdListener) == null) {
            this.f50719d = iPwdListener;
            PwdRequest pwdRequest = new PwdRequest();
            pwdRequest.mFrom = 2;
            pwdRequest.mRequestType = 1;
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            Intent intent = new Intent(context, PwdCheckActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void editPwdFail(int i2, String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) || (iPwdListener = this.f50719d) == null) {
            return;
        }
        iPwdListener.onFail(i2, str);
    }

    public void editPwdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (iPwdListener = this.f50719d) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f50719d = null;
    }

    public void forgetPasswdFailed() {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (iPwdListener = this.f50720e) == null) {
            return;
        }
        iPwdListener.onFail(-1, "");
    }

    public void forgetPasswdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (iPwdListener = this.f50720e) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f50720e = null;
    }

    public void setPassByUserFail(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (iBindCardCallback = this.f50721f) == null) {
            return;
        }
        iBindCardCallback.onChangeFailed(str);
    }

    public void setPassByUserSucceed(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (iBindCardCallback = this.f50721f) == null) {
            return;
        }
        iBindCardCallback.onChangeSucceed(null);
        this.f50721f = null;
    }

    public void setPwd(Context context, boolean z, IPwdListener iPwdListener, PayRequestCache.BindCategory bindCategory) {
        PwdRequest pwdRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{context, Boolean.valueOf(z), iPwdListener, bindCategory}) == null) {
            if (iPwdListener != null) {
                this.f50718c = iPwdListener;
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
            intent.putExtra("baidu.wallet.bindcard.category", bindCategory.getScenario());
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void setPwdFail(int i2, String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048597, this, i2, str) == null) || (iPwdListener = this.f50718c) == null) {
            return;
        }
        iPwdListener.onFail(i2, str);
    }

    public void setPwdSucceed(String str) {
        IPwdListener iPwdListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (iPwdListener = this.f50718c) == null) {
            return;
        }
        iPwdListener.onSucceed(str);
        this.f50718c = null;
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, iPwdListener) == null) {
            checkPwd(context, str, iPwdListener, "");
        }
    }

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, context, str, str2, iPwdListener, str3) == null) {
            this.f50717b = iPwdListener;
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
                intent.addFlags(268435456);
            }
            intent.putExtra("half_screen_pwd_verify", str);
            context.startActivity(intent);
            BaiduWalletUtils.startActivityAnim(context);
        }
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, iPwdListener, str2) == null) {
            this.f50722g = new LoginBackListenerProxy(context, new ILoginBackListener(this, context, str, iPwdListener, str2) { // from class: com.baidu.wallet.base.controllers.PasswordController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f50723b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ IPwdListener f50724c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f50725d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ PasswordController f50726e;

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
                    this.f50726e = this;
                    this.a = context;
                    this.f50723b = str;
                    this.f50724c = iPwdListener;
                    this.f50725d = str2;
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(this.f50726e.f50722g);
                            return;
                        }
                        this.f50726e.checkPwdFail(i2, str3);
                        this.f50726e.f50722g = null;
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str3) == null) || this.f50726e.f50722g.getContext() == null) {
                        return;
                    }
                    this.f50726e.a(this.a, this.f50723b, this.f50724c, this.f50725d);
                }
            });
            WalletLoginHelper.getInstance().login(this.f50722g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, IPwdListener iPwdListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, iPwdListener, str2) == null) {
            this.f50717b = iPwdListener;
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
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            BaiduWalletUtils.startActivityAnim(context);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String md5 = Md5Utils.toMD5(str);
            return md5 != null ? md5.toUpperCase() : md5;
        }
        return (String) invokeL.objValue;
    }
}
