package com.baidu.wallet.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.core.utils.ReflectUtils;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import java.lang.reflect.Proxy;
import java.util.Map;
/* loaded from: classes5.dex */
public final class BaiduWallet implements IWalletFacade {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final IWalletFacade f23448a = (IWalletFacade) Proxy.newProxyInstance(BaiduWallet.class.getClassLoader(), new Class[]{IWalletFacade.class}, new WalletFacadeAOP(new BaiduWallet()));
    }

    private void a(Application application) {
        DxmPay.getInstance().initWallet(application);
        Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.fastpay.entrance.FastPayProvider");
        if (providerObject != null && (providerObject instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY, (RouterProvider) providerObject);
        }
        Object providerObject2 = ReflectUtils.getProviderObject("com.baidu.wallet.qrcodescanner.entrance.QrcodeScannerProvider");
        if (providerObject2 != null && (providerObject2 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER, (RouterProvider) providerObject2);
        }
        Object providerObject3 = ReflectUtils.getProviderObject("com.baidu.wallet.home.entrance.EnterWalletHomeProvider");
        if (providerObject3 != null && (providerObject3 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME, (RouterProvider) providerObject3);
        }
        Object providerObject4 = ReflectUtils.getProviderObject("com.baidu.wallet.personal.entrance.PersonalProvider");
        if (providerObject4 != null && (providerObject4 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL, (RouterProvider) providerObject4);
        }
        Object providerObject5 = ReflectUtils.getProviderObject("com.baidu.wallet.lightapp.entrance.LangbrigeProvider");
        if (providerObject5 == null || !(providerObject5 instanceof RouterProvider)) {
            return;
        }
        LocalRouter.getInstance(application).registerProvider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE, (RouterProvider) providerObject5);
    }

    public static IWalletFacade getInstance() {
        return a.f23448a;
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void accessWalletEntry(Context context, String str) {
        BaiduPayDelegate.getInstance().accessWalletEntry(context, str);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback) {
        BaiduWalletDelegate.getInstance().callQRCodeScanner(context, iWalletQRScannerCallback);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void changePayMethod(Activity activity, String str, @NonNull IPrecashierCallback iPrecashierCallback) {
        BaiduPayDelegate.getInstance().changePayMethod(activity, str, iPrecashierCallback);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        BaiduPayDelegate.getInstance().checkPwd(context, checkCallBack);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        BaiduPayDelegate.getInstance().doBind(context, bindBack, map);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doBindCardIndependent(Context context, BindBack bindBack, String str) {
        BaiduPayDelegate.getInstance().doBindCardIndependent(context, bindBack, str);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        BaiduPayDelegate.getInstance().doCheckPwd(context, map, checkCallBack);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack) {
        BaiduPayDelegate.getInstance().doPay(context, str, payCallBack);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        BaiduPayDelegate.getInstance().doRNAuth(context, map, rNAuthCallBack);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public String getBindUrl(String str) {
        return BaiduWalletDelegate.getInstance().getBindUrl(str);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void getPayMethod(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        BaiduPayDelegate.getInstance().getPayMethod(context, str, iPrecashierCallback);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        return BaiduPayDelegate.getInstance().getWalletOuterInterface(context, iWalletOuterInterfaceListener);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void gotoWalletService(Context context, String str, String str2) {
        BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(context);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void logout(Context context) {
        BaiduWalletDelegate.getInstance().logout(context);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z) {
        BaiduWalletDelegate.getInstance().openH5Module(context, str, z);
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void preOrderPay(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        BaiduPayDelegate.getInstance().preOrderPay(context, str, iPrecashierCallback);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void setDebugOn(Context context, boolean z) {
        BaiduWalletDelegate.getInstance().setDebugOn(context, z);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public boolean startWallet(Context context) {
        return BaiduWalletDelegate.getInstance().startWallet(context);
    }

    public BaiduWallet() {
    }

    @Override // com.baidu.wallet.api.IWalletPayFacade
    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        BaiduPayDelegate.getInstance().doPay(context, str, payCallBack, map);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        BaiduWalletDelegate.getInstance().openH5Module(context, str, z, bundle);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context, String str) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(context, str);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str, iSecurityListener);
    }
}
