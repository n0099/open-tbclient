package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class k implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public Handler f25409a;

    /* renamed from: b  reason: collision with root package name */
    public PayBaseBeanActivity f25410b;

    /* renamed from: c  reason: collision with root package name */
    public LoginBackListenerProxy f25411c;

    public k(PayBaseBeanActivity payBaseBeanActivity) {
        this.f25410b = payBaseBeanActivity;
    }

    private Handler f() {
        if (this.f25409a == null) {
            this.f25409a = new Handler(this.f25410b.getMainLooper());
        }
        return this.f25409a;
    }

    public abstract void a();

    public abstract void a(int i2, Dialog dialog);

    public abstract void a(int i2, Object obj, String str);

    public abstract void a(PrecashierCreateOrderResponse precashierCreateOrderResponse);

    public abstract void a(String str);

    public abstract boolean a(Bundle bundle);

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    public abstract void e();

    public void g() {
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        f().post(new Runnable() { // from class: com.baidu.wallet.paysdk.presenter.k.2
            @Override // java.lang.Runnable
            public void run() {
                k.this.a(i2, i3, str);
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        f().post(new Runnable() { // from class: com.baidu.wallet.paysdk.presenter.k.1
            @Override // java.lang.Runnable
            public void run() {
                k.this.a(i2, obj, str);
            }
        });
    }

    public void a(int i2, int i3, String str) {
        if (i3 != 100035 && i3 != 100036) {
            if (i3 == 5003) {
                AccountManager.getInstance(this.f25410b).logout();
                WalletLoginHelper.getInstance().logout(false);
                if (WalletLoginHelper.getInstance().isInnerPassLogin()) {
                    GlobalUtils.toast(this.f25410b, str);
                    this.f25411c = new LoginBackListenerProxy(this.f25410b, new ILoginBackListener() { // from class: com.baidu.wallet.paysdk.presenter.k.4
                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onFail(int i4, String str2) {
                            if (i4 == 603) {
                                WalletLoginHelper.getInstance().onlyLogin(k.this.f25411c);
                            }
                        }

                        @Override // com.baidu.wallet.api.ILoginBackListener
                        public void onSuccess(int i4, String str2) {
                            k.this.c();
                        }
                    });
                    WalletLoginHelper.getInstance().login(this.f25411c);
                    return;
                }
                WalletLoginHelper.getInstance().handlerWalletError(5003);
            } else if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.f25410b.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener() { // from class: com.baidu.wallet.paysdk.presenter.k.5
                @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                public void onCallFail(int i4, String str2) {
                    PayCallBackManager.callBackClientCancel(k.this.f25410b.getActivity(), "WelcomeBaseActivity.onPrepareDialog().1");
                    k.this.f25410b.finish();
                }

                @Override // com.baidu.wallet.api.WalletApiExtListener.ThirdPartyLoginListener
                public void onCallSuccess(int i4, String str2) {
                    k.this.c();
                }
            })) {
                return;
            }
            GlobalUtils.toast(this.f25410b, str);
            e();
            return;
        }
        PassUtil.passNormalized(this.f25410b, str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize() { // from class: com.baidu.wallet.paysdk.presenter.k.3
            @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
            public boolean onNormalize(Context context, int i4, Map<String, String> map) {
                if (super.onNormalize(context, i4, map)) {
                    k.this.c();
                    return false;
                }
                k.this.e();
                return false;
            }
        });
    }

    public void a(int i2, int i3, String str, Object obj) {
        a(i2, i3, str);
    }
}
