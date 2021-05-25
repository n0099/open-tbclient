package com.baidu.wallet.api;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.statistics.StatSettings;
import com.baidu.wallet.base.statistics.SyncHttpImpl;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.PollOfflineCacheSwitch;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class BaiduWalletDelegate implements IWalletBaseFacade {

    /* renamed from: b  reason: collision with root package name */
    public static final String f23030b = "BaiduWalletDelegate";

    /* renamed from: a  reason: collision with root package name */
    public ISecurityListener f23031a;

    /* renamed from: c  reason: collision with root package name */
    public Context f23032c;

    /* renamed from: d  reason: collision with root package name */
    public Domain f23033d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23034e;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final BaiduWalletDelegate f23051a = new BaiduWalletDelegate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        long syncTime = OtpTokenUtils.syncTime(OtpTokenUtils.getmSyncWithServerTime(context));
        String str = f23030b;
        LogUtil.d(str, "sync server time: detatime is " + syncTime);
        OtpTokenUtils.setmSyncWithServerTime(context, syncTime);
    }

    private void d(Context context) {
        if (this.f23034e) {
            return;
        }
        this.f23034e = true;
        PayStatisticsUtil.initStatisticsModule(context, StatSettings.getInstance(context));
    }

    public static final BaiduWalletDelegate getInstance() {
        return a.f23051a;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void callQRCodeScanner(Context context, final IWalletQRScannerCallback iWalletQRScannerCallback) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanresult"), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.2
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
                int i3 = 2;
                String str = "";
                String str2 = "失败";
                if (i2 == 0 && hashMap != null) {
                    String str3 = (String) hashMap.get("value");
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = "成功";
                        str = str3;
                        i3 = 0;
                    }
                    i3 = -1;
                } else if (i2 == 5) {
                    str2 = "扫码模块不存在";
                    i3 = 1;
                } else {
                    if (i2 == 1 && hashMap != null) {
                        int intValue = ((Integer) hashMap.get(RouterCallback.KEY_ERROR_CODE)).intValue();
                        String str4 = (String) hashMap.get("errorMsg");
                        if (intValue == 2 && TextUtils.equals(str4, "camera_permission_denied")) {
                            str2 = "没有访问相机的权限";
                        } else if (intValue == 0) {
                            i3 = 3;
                            str2 = "用户取消";
                        }
                    }
                    i3 = -1;
                }
                IWalletQRScannerCallback iWalletQRScannerCallback2 = iWalletQRScannerCallback;
                if (iWalletQRScannerCallback2 != null) {
                    iWalletQRScannerCallback2.onResult(i3, str2, str);
                }
            }
        });
        BaiduWalletServiceController.getInstance().gotoWalletService(context, "32768", "");
    }

    public Pair<Integer, Object> checkSecurityEvn() {
        ISecurityListener iSecurityListener = this.f23031a;
        if (iSecurityListener != null) {
            return iSecurityListener.onCheck();
        }
        return null;
    }

    public void doBusCardChargeNFC(Context context, Parcelable parcelable) {
        if (Build.VERSION.SDK_INT <= 9) {
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_low_sdkversion_tip"));
            return;
        }
        BaiduWalletServiceController.getInstance().accessBusCardChargeNFC(context, parcelable);
        d(context);
    }

    public Context getAppContext() {
        return this.f23032c;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public String getBindUrl(String str) {
        return SdkInitResponse.getInstance().getLoginUrl(str);
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void gotoWalletService(Context context, String str, String str2) {
        BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2, true);
    }

    public void initLangBrige(IWalletListener iWalletListener) {
        LocalRouter.getInstance(this.f23032c).route(this.f23032c, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_init").data("wallet_listener", iWalletListener), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.11
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context) {
        initWallet(context, BeanConstants.CHANNEL_ID_SIMPLIFY);
    }

    public void invokeHostNative(String str, String str2) {
        if (WalletLoginHelper.getInstance() == null || !(WalletLoginHelper.getInstance() instanceof IWalletInvokeHostListener) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ((IWalletInvokeHostListener) WalletLoginHelper.getInstance()).invokeHostNative(Long.parseLong(str), str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void logout(Context context) {
        WalletLoginHelper.getInstance().logout();
        if (context != null) {
            AccountManager.getInstance(context.getApplicationContext()).logout();
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", str).data("title", null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.7
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    public void removeH5LifeCycleCb(Context context, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (context == null) {
            return;
        }
        LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_removeLifeCycleCb").data("lifeCycleCb", activityLifecycleCallbacks).data("activty", context), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.3
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void setDebugOn(Context context, boolean z) {
        if (z) {
            DebugConfig.getInstance(context).changeQA();
        } else {
            DebugConfig.getInstance(context).changeOnline();
        }
        StatSettings statSettings = StatSettings.getInstance(context);
        if (statSettings != null) {
            statSettings.setReleaseVesionFlag(!z);
        }
    }

    public void setPassDomain(Domain domain) {
        this.f23033d = domain;
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public boolean startWallet(Context context) {
        DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
        return BaiduWalletServiceController.getInstance().startWallet(context, true, false);
    }

    public BaiduWalletDelegate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (this.f23033d == null) {
            this.f23033d = Domain.DOMAIN_ONLINE;
            String environment = DebugConfig.getInstance(context).getEnvironment();
            boolean z = true;
            if ("QA".equalsIgnoreCase(environment)) {
                this.f23033d = Domain.DOMAIN_QA;
            } else if ("RD".equalsIgnoreCase(environment)) {
                this.f23033d = Domain.DOMAIN_QA;
            } else {
                z = false;
            }
            SapiConfiguration.Builder initialShareStrategy = new SapiConfiguration.Builder(context).setProductLineInfo("bdwalletsdk", "1", "3s9y80v8ipz8huoh9k06hurn2lia5eez").setRuntimeEnvironment(this.f23033d).setSocialBindType(BindType.EXPLICIT).initialShareStrategy(LoginShareStrategy.DISABLED);
            Switch r1 = Switch.ON;
            SapiAccountManager.getInstance().init(initialShareStrategy.smsLoginConfig(new SapiConfiguration.SmsLoginConfig(r1, r1, r1)).configurableViewLayout(Switch.ON).setSupportFaceLogin(false).sofireSdkConfig("600000", "69a0826db896e8c99e5d7bf63a14de3d", 600000).debug(z).build());
        }
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(context);
            b(context);
            initWallet(null, context, str);
            initLangBrige(null);
            return;
        }
        throw new IllegalArgumentException("The channel number can not be empty.");
    }

    private void a(final Context context) {
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.1
            public void onReceiveShare() {
                BaiduWalletDelegate.this.b(context);
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", str).data("title", null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.8
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        if (!TextUtils.isEmpty(str)) {
            this.f23031a = iSecurityListener;
            initWallet(iWalletListener, context, str);
            return;
        }
        throw new IllegalArgumentException("The channel number can not be empty.");
    }

    public void openH5Module(Context context, String str, String str2, boolean z, boolean z2) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", str).data("title", str2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.9
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    @Override // com.baidu.wallet.api.IWalletBaseFacade
    public void initWallet(IWalletListener iWalletListener, final Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The channel number can not be empty.");
        }
        if (context == null) {
            return;
        }
        if (iWalletListener != null) {
            initLangBrige(iWalletListener);
        }
        WalletLoginHelper.getInstance().init(context, iWalletListener);
        BeanConstants.CHANNEL_ID = str;
        String str2 = "BaiduWallet-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
        BeanConstants.SDK_VERSION = str2;
        ChannelUtils.initBussinessParams(str2, false);
        DXMSdkSAUtils.initSensorStat(context);
        PassUtil.registerPassNormalize(new PassUtil.IPassNormalize() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.4
            @Override // com.baidu.wallet.core.utils.PassUtil.IPassNormalize
            public boolean onNormalize(Context context2, int i2, Map<String, String> map) {
                LogUtil.logd("onNormalize ");
                WalletLoginHelper.getInstance().onLoginChanaged(context2, map);
                return false;
            }
        });
        if (DebugConfig.getInstance().isOnline()) {
            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY, ""));
            if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_ONLINE, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                com.baidu.apollon.heartbeat.a.c().a(true);
            }
        } else {
            DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY, ""));
            if (((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CHANGE_SWITCH_NAME_QA, BeanConstants.DOMAIN_CHANGE_SWITCH_KEY, Boolean.FALSE)).booleanValue()) {
                com.baidu.apollon.heartbeat.a.c().a(true);
            }
        }
        MessageQueue messageQueue = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            messageQueue = Looper.myQueue();
        } else if (Build.VERSION.SDK_INT >= 23) {
            messageQueue = Looper.getMainLooper().getQueue();
        } else {
            try {
                Field declaredField = Looper.class.getDeclaredField("mQueue");
                declaredField.setAccessible(true);
                messageQueue = (MessageQueue) declaredField.get(Looper.getMainLooper());
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
        }
        if (messageQueue != null) {
            messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.5
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    LocalRouter.getInstance(context.getApplicationContext()).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_initWebView"), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.5.1
                        @Override // com.baidu.wallet.router.RouterCallback
                        public void onResult(int i2, HashMap hashMap) {
                            LogUtil.d(BaiduWalletDelegate.f23030b, "webview init finish");
                        }
                    });
                    return false;
                }
            });
        }
        new Thread(new Runnable() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.6
            @Override // java.lang.Runnable
            public void run() {
                if (SafePay.getInstance().prepareCompleted()) {
                    PayStatisticsUtil.initStatisticsModule(context.getApplicationContext(), StatSettings.getInstance(context.getApplicationContext()));
                    PayStatisticsUtil.setHttpImpl(new SyncHttpImpl());
                    BdWalletUtils.loadDeviceFP(context.getApplicationContext());
                    BaiduWalletDelegate.this.c(context);
                }
            }
        }, "walletInit").start();
        this.f23032c = context.getApplicationContext();
        PollOfflineCacheSwitch.getInstance().registerListener();
        ActLifecycleCbs.a().a((Application) context.getApplicationContext());
    }

    public void openH5Module(Context context, Bundle bundle) {
        if (bundle == null || !bundle.containsKey("url") || TextUtils.isEmpty(bundle.getString("url"))) {
            return;
        }
        String string = bundle.getString("url");
        String string2 = bundle.containsKey("title") ? bundle.getString("title") : null;
        boolean z = bundle.containsKey("withAnim") ? bundle.getBoolean("withAnim") : true;
        boolean z2 = bundle.containsKey("show_share") ? bundle.getBoolean("show_share") : true;
        bundle.remove("url");
        bundle.remove("title");
        bundle.remove("withAnim");
        bundle.remove("show_share");
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_start").data("url", string).data("title", string2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)).data("bundle", bundle), new RouterCallback() { // from class: com.baidu.wallet.api.BaiduWalletDelegate.10
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    public void openH5Module(Context context, String str) {
        openH5Module(context, str, true);
    }
}
