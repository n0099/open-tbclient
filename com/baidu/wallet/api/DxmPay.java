package com.baidu.wallet.api;

import android.app.Application;
import android.content.Context;
import com.baidu.apollon.armor.SafePay;
import com.baidu.wallet.core.utils.ReflectUtils;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import com.baidu.wallet.statistics.impl.SensorsSyncHttpImpl;
import com.baidu.wallet.statistics.impl.StatConfig;
/* loaded from: classes5.dex */
public class DxmPay {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final DxmPay f23476a = new DxmPay();
    }

    private void a(Application application) {
        Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.paysdk.entrance.DxmPaySDKProvider");
        if (providerObject != null && (providerObject instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider("dxmPay", (RouterProvider) providerObject);
        }
        Object providerObject2 = ReflectUtils.getProviderObject("com.baidu.wallet.bankdetection.entrance.BankCardDetectionProvider");
        if (providerObject2 == null || !(providerObject2 instanceof RouterProvider)) {
            return;
        }
        LocalRouter.getInstance(application).registerProvider("bankdetection", (RouterProvider) providerObject2);
    }

    public static DxmPay getInstance() {
        return a.f23476a;
    }

    public void initWallet(final Context context) {
        a((Application) context.getApplicationContext());
        new Thread(new Runnable() { // from class: com.baidu.wallet.api.DxmPay.1
            @Override // java.lang.Runnable
            public void run() {
                if (SafePay.getInstance().prepareCompleted()) {
                    d.d.a.a.a.g(context.getApplicationContext(), StatConfig.getInstance(context.getApplicationContext()));
                    d.d.a.a.a.x(new SensorsSyncHttpImpl());
                }
            }
        }, "DXMPaySDK").start();
    }

    public DxmPay() {
    }
}
