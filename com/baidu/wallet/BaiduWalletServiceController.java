package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaiduWalletServiceController {
    public static final String H5CHECKPWDCB = "H5CheckPwd";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23017b = "BaiduWalletServiceController";

    /* renamed from: c  reason: collision with root package name */
    public static final Object f23018c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static LoginBackListenerProxy f23019d;

    /* renamed from: a  reason: collision with root package name */
    public ILightappInvokerCallback f23020a;

    /* renamed from: e  reason: collision with root package name */
    public long f23021e;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BaiduWalletServiceController f23039a = new BaiduWalletServiceController();
    }

    private boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f23021e;
        LogUtil.logd("timeD=" + j);
        if (0 >= j || j >= 800) {
            this.f23021e = currentTimeMillis;
            return false;
        }
        return true;
    }

    public static BaiduWalletServiceController getInstance() {
        return a.f23039a;
    }

    public static void getOpenBdussFirst(final Context context, final Intent intent, final boolean z, boolean z2) {
        WalletLoginHelper.getInstance().verifyPassLogin(z2, new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.BaiduWalletServiceController.6
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                context.startActivity(intent);
                Context context2 = context;
                if (context2 instanceof Activity) {
                    if (z) {
                        BaiduWalletUtils.startActivityAnim(context2);
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                    }
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                context.startActivity(intent);
                Context context2 = context;
                if (context2 instanceof Activity) {
                    if (z) {
                        BaiduWalletUtils.startActivityAnim(context2);
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                    }
                }
            }
        }));
    }

    public static void loginFirst(final Context context, final Intent intent, final boolean z) {
        if (context instanceof Activity) {
            com.baidu.wallet.core.utils.LogUtil.d(f23017b, "context is activity!");
        } else {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        f23019d = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.BaiduWalletServiceController.1
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i, String str) {
                if (i == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduWalletServiceController.f23019d);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i, String str) {
                intent.putExtra("with_anim", z);
                context.startActivity(intent);
                Context context2 = context;
                if (context2 instanceof Activity) {
                    if (z) {
                        BaiduWalletUtils.startActivityAnim(context2);
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context2);
                    }
                }
            }
        });
        WalletLoginHelper.getInstance().login(f23019d);
    }

    public void accessBusCardChargeNFC(Context context, Parcelable parcelable) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfchome").data("android.nfc.extra.TAG", parcelable), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.5
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                    hashMap2.put("action", "nfchome");
                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                }
            }
        });
    }

    public boolean enterTransConfirm(BaseActivity baseActivity, JSONObject jSONObject, String str) {
        LocalRouter.getInstance(baseActivity).route(baseActivity, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER).action("entertransferconfirm").data("params", jSONObject.toString()).data("url", str), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.3
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_TRNASFER);
                    hashMap2.put("action", "entertransferconfirm");
                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                }
            }
        });
        return true;
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            gotoWalletService(context, Long.parseLong(str), str2, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean startWallet(Context context, boolean z, boolean z2) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME).action("wallethome").data("withAnim", Boolean.toString(z)).data("pageType", Boolean.toString(z2)), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.4
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
                    hashMap2.put("action", "wallethome");
                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                }
            }
        });
        return true;
    }

    public BaiduWalletServiceController() {
        this.f23020a = null;
    }

    private void a(Context context, boolean z) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_FASTPAY).action("doPhoneCharge").data("withAnim", String.valueOf(z)), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.7
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                if (i == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", BaiduWalletServiceProviderMap.PLUGIN_FASTPAY);
                    hashMap2.put("action", "doPhoneCharge");
                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap2.values());
                }
            }
        });
    }

    public void gotoWalletService(Context context, String str, String str2) {
        gotoWalletService(context, str, str2, true);
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            this.f23020a = iLightappInvokerCallback;
            gotoWalletService(context, str, str2, true);
        }
    }

    private void a(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("extra", str);
        hashMap.put("withAnim", Boolean.toString(z));
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL).action("entercoupon").data(hashMap), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.8
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap2) {
                if (i == 5) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_PERSONAL);
                    hashMap3.put("action", "entercoupon");
                    DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                }
            }
        });
    }

    public void gotoWalletService(Context context, long j, String str) {
        gotoWalletService(context, j, str, true);
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        if (context == null || j < 0) {
            return;
        }
        if (b()) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.FAST_DOUBLE_CLICK_GOTO_WALLET_SERVICE);
            PayStatisticsUtil.onEvent(StatServiceEvent.FAST_DOUBLE_CLICK_GOTO_WALLET_SERVICE);
            return;
        }
        WalletLoginHelper.getInstance().clearOpenBduss();
        if (!LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.getInstance().getProviderNameBySerID(j))) {
            HashMap hashMap = new HashMap();
            hashMap.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, Long.toString(j));
            hashMap.put("extra", str);
            hashMap.put("withAnim", Boolean.toString(z));
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("dxmPay").action("gotoWalletService").data(hashMap), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.2
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap2) {
                    if (i == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", "dxmPay");
                        hashMap3.put("action", "gotoWalletService");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    }
                }
            });
        } else if (j == 1) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_PHONEFEECHARGE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_PHONEFEECHARGE);
            a(context, z);
        } else if (j == 64) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_COUPON);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_COUPON);
            a(context, str, z);
        } else if (j == 2) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_SUPERACCOUNTTRANS);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_TRNASFER).action("entertransfer").data("withAnim", Boolean.toString(z)), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.9
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap2) {
                    if (i == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_TRNASFER);
                        hashMap3.put("action", "entertransfer");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    }
                }
            });
        } else if (j == 1024) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_NFCCHARGE);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfchome").data("withAnim", Boolean.toString(z)), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.10
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap2) {
                    if (i == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                        hashMap3.put("action", "nfchome");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    }
                }
            });
        } else if (j == 16384) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_STARTWALLET);
            startWallet(context, z, false);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_START_WALLET_CREDIT);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_START_WALLET_CREDIT);
            startWallet(context, z, true);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_START_WALLET_FINANCE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_START_WALLET_FINANCE);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("tab").action("startWalletFinance").data("withAnim", Boolean.toString(z)), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.11
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap2) {
                    if (i == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", "tab");
                        hashMap3.put("action", "startWalletFinance");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    }
                }
            });
        } else if (j == 32768) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_OWNERSCANCODE);
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_OWNERSCANCODE);
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER).action("qrcodescanner").data("withAnim", Boolean.toString(z)).data("showQrCodeBtns", Boolean.valueOf("showQrCodeBtns".equals(str))), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.12
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap2) {
                    if (i == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_QRCODESCANNER);
                        hashMap3.put("action", "qrcodescanner");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    }
                }
            });
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING) {
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_NFC).action("nfcsetting").data("withAnim", Boolean.toString(z)), new RouterCallback() { // from class: com.baidu.wallet.BaiduWalletServiceController.13
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i, HashMap hashMap2) {
                    if (i == 5) {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("provider", BaiduWalletServiceProviderMap.PLUGIN_NFC);
                        hashMap3.put("action", "nfcsetting");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i, hashMap3.values());
                    }
                }
            });
        }
    }
}
