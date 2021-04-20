package com.baidu.wallet.base.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.Md5Utils;
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

    /* renamed from: a  reason: collision with root package name */
    public static PasswordController f23273a;

    /* renamed from: b  reason: collision with root package name */
    public IPwdListener f23274b;

    /* renamed from: c  reason: collision with root package name */
    public IPwdListener f23275c;

    /* renamed from: d  reason: collision with root package name */
    public IPwdListener f23276d;

    /* renamed from: e  reason: collision with root package name */
    public IPwdListener f23277e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduPay.IBindCardCallback f23278f;

    /* renamed from: g  reason: collision with root package name */
    public LoginBackListenerProxy f23279g;

    /* loaded from: classes5.dex */
    public interface IPwdListener {
        void onFail(int i, String str);

        void onSucceed(String str);
    }

    public static PasswordController getPassWordInstance() {
        if (f23273a == null) {
            f23273a = new PasswordController();
        }
        return f23273a;
    }

    public static String getSeed() {
        return new BigInteger(64, new Random()).toString();
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwd(String str, String str2) {
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

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdForPassport(String str) {
        String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
        if (TextUtils.isEmpty(localDecrypt1)) {
            return null;
        }
        return SafePay.getInstance().encryptProxy(Md5Utils.toMD5(Md5Utils.toMD5(localDecrypt1)));
    }

    @SuppressLint({"DefaultLocale"})
    public static String handlePwdSimple(String str) {
        String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
        if (TextUtils.isEmpty(localDecrypt1)) {
            return null;
        }
        return a(a(localDecrypt1));
    }

    public void checkPwd(Context context, IPwdListener iPwdListener) {
        checkPwd(context, null, iPwdListener);
    }

    public void checkPwdFail(int i, String str) {
        IPwdListener iPwdListener = this.f23274b;
        if (iPwdListener != null) {
            iPwdListener.onFail(i, str);
        }
    }

    public void checkPwdForSp(Context context, Map<String, String> map, IPwdListener iPwdListener) {
        this.f23274b = iPwdListener;
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

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener) {
        checkPwdFromH5(context, str, str2, iPwdListener, "");
    }

    public void checkPwdSucceed(String str) {
        IPwdListener iPwdListener = this.f23274b;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.f23274b = null;
        }
    }

    public void clearBindCardCallback() {
        this.f23278f = null;
    }

    public void clearCheckPwdListener() {
        this.f23274b = null;
    }

    public void clearEditPwdCallBack() {
        this.f23276d = null;
    }

    public void clearForgetPasswdCallback() {
        this.f23277e = null;
    }

    public void clearSetPwdListener() {
        this.f23275c = null;
    }

    public void editPwd(Context context, IPwdListener iPwdListener) {
        this.f23276d = iPwdListener;
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

    public void editPwdFail(int i, String str) {
        IPwdListener iPwdListener = this.f23276d;
        if (iPwdListener != null) {
            iPwdListener.onFail(i, str);
        }
    }

    public void editPwdSucceed(String str) {
        IPwdListener iPwdListener = this.f23276d;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.f23276d = null;
        }
    }

    public void fogetPasswd(Context context, IPwdListener iPwdListener, String str) {
        BindFastRequest createBindRequest;
        StatisticManager.onEvent(StatServiceEvent.FORGET_PWD);
        if (iPwdListener == null) {
            return;
        }
        if (context == null) {
            forgetPasswdFailed();
            return;
        }
        this.f23277e = iPwdListener;
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

    public void forgetPasswdFailed() {
        IPwdListener iPwdListener = this.f23277e;
        if (iPwdListener != null) {
            iPwdListener.onFail(-1, "");
        }
    }

    public void forgetPasswdSucceed(String str) {
        IPwdListener iPwdListener = this.f23277e;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.f23277e = null;
        }
    }

    public void setPassByUserFail(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback = this.f23278f;
        if (iBindCardCallback != null) {
            iBindCardCallback.onChangeFailed(str);
        }
    }

    public void setPassByUserSucceed(String str) {
        BaiduPay.IBindCardCallback iBindCardCallback = this.f23278f;
        if (iBindCardCallback != null) {
            iBindCardCallback.onChangeSucceed(null);
            this.f23278f = null;
        }
    }

    public void setPasswdByUser(Context context, BaiduPay.IBindCardCallback iBindCardCallback) {
        setPasswdByUser(context, iBindCardCallback, null);
    }

    public void setPwd(Context context, boolean z, IPwdListener iPwdListener, PayRequestCache.BindCategory bindCategory) {
        PwdRequest pwdRequest;
        if (iPwdListener != null) {
            this.f23275c = iPwdListener;
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

    public void setPwdFail(int i, String str) {
        IPwdListener iPwdListener = this.f23275c;
        if (iPwdListener != null) {
            iPwdListener.onFail(i, str);
        }
    }

    public void setPwdSucceed(String str) {
        IPwdListener iPwdListener = this.f23275c;
        if (iPwdListener != null) {
            iPwdListener.onSucceed(str);
            this.f23275c = null;
        }
    }

    public void checkPwd(Context context, String str, IPwdListener iPwdListener) {
        checkPwd(context, str, iPwdListener, "");
    }

    public void checkPwdFromH5(Context context, String str, String str2, IPwdListener iPwdListener, String str3) {
        this.f23274b = iPwdListener;
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

    public void setPasswdByUser(Context context, BaiduPay.IBindCardCallback iBindCardCallback, Bundle bundle) {
        if (context == null) {
            return;
        }
        if (PayDataCache.getInstance().hasBondCards()) {
            this.f23278f = iBindCardCallback;
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
        this.f23274b = iPwdListener;
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

    public void checkPwd(final Context context, final String str, final IPwdListener iPwdListener, final String str2) {
        this.f23279g = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.base.controllers.PasswordController.1
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str3) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(PasswordController.this.f23279g);
                } else {
                    PasswordController.this.checkPwdFail(i, str3);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str3) {
                PasswordController.this.a(context, str, iPwdListener, str2);
            }
        });
        WalletLoginHelper.getInstance().login(this.f23279g);
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(String str) {
        String md5 = Md5Utils.toMD5(str);
        return md5 != null ? md5.toUpperCase() : md5;
    }
}
