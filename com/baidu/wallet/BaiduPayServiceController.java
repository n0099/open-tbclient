package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.CheckCallBack;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.PwdManagerActivity;
import com.baidu.wallet.paysdk.ui.SecurityCenterActivity;
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaiduPayServiceController {

    /* renamed from: a  reason: collision with root package name */
    public ILightappInvokerCallback f22996a;

    /* renamed from: b  reason: collision with root package name */
    public LoginBackListenerProxy f22997b;

    /* renamed from: com.baidu.wallet.BaiduPayServiceController$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements IBeanResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f23001a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f23002b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f23003c;

        public AnonymousClass2(Context context, boolean z) {
            this.f23002b = context;
            this.f23003c = z;
            this.f23001a = new Handler(this.f23002b.getMainLooper());
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            WalletGlobalUtils.DismissLoadingDialog();
            if (i3 == 100035 || i3 == 100036) {
                PassUtil.passNormalized(this.f23002b, str, i3 == 100036 ? 2 : 1, new PassUtil.PassNormalize() { // from class: com.baidu.wallet.BaiduPayServiceController.2.2
                    @Override // com.baidu.wallet.core.utils.PassUtil.PassNormalize, com.baidu.wallet.core.utils.PassUtil.IPassNormalize
                    public boolean onNormalize(final Context context, int i4, Map<String, String> map) {
                        if (super.onNormalize(context, i4, map)) {
                            AnonymousClass2.this.f23001a.post(new Runnable() { // from class: com.baidu.wallet.BaiduPayServiceController.2.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BaiduPayServiceController.this.a(context);
                                }
                            });
                            return false;
                        }
                        return false;
                    }
                });
            }
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            UserData.UserModel userModel;
            WalletGlobalUtils.DismissLoadingDialog();
            DirectPayContentResponse directPayContentResponse = (DirectPayContentResponse) obj;
            if (directPayContentResponse != null && (userModel = directPayContentResponse.user) != null && userModel.hasMobilePwd()) {
                Intent intent = new Intent(this.f23002b, PwdManagerActivity.class);
                if (!(this.f23002b instanceof Activity)) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                intent.putExtra("with_anim", this.f23003c);
                this.f23002b.startActivity(intent);
                Context context = this.f23002b;
                if (context instanceof Activity) {
                    if (this.f23003c) {
                        BaiduWalletUtils.startActivityAnim(context);
                        return;
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                        return;
                    }
                }
                return;
            }
            PasswordController.getPassWordInstance().setPasswdByUser(this.f23002b, new BaiduPay.IBindCardCallback() { // from class: com.baidu.wallet.BaiduPayServiceController.2.1
                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeFailed(String str2) {
                }

                @Override // com.baidu.wallet.paysdk.api.BaiduPay.IBindCardCallback
                public void onChangeSucceed(String str2) {
                    AnonymousClass2.this.f23001a.post(new Runnable() { // from class: com.baidu.wallet.BaiduPayServiceController.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            BaiduPayServiceController.this.a(anonymousClass2.f23002b);
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BaiduPayServiceController f23014a = new BaiduPayServiceController();
    }

    private void c(final Context context, final boolean z) {
        if (context != null) {
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                return;
            }
            this.f22997b = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.BaiduPayServiceController.1
                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(BaiduPayServiceController.this.f22997b);
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    BaiduPayServiceController.this.d(context, z);
                }
            });
            WalletLoginHelper.getInstance().login(this.f22997b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, boolean z) {
        WalletGlobalUtils.showLoadingDialog(context);
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean(context, 6, "BaiduPayServiceController");
        userInfoBean.setResponseCallback(e(context, z));
        userInfoBean.execBean();
    }

    private IBeanResponseCallback e(Context context, boolean z) {
        return new AnonymousClass2(context, z);
    }

    private void f(final Context context, final boolean z) {
        this.f22997b = new LoginBackListenerProxy(context, new ILoginBackListener() { // from class: com.baidu.wallet.BaiduPayServiceController.3
            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduPayServiceController.this.f22997b);
                } else {
                    BaiduPayServiceController.this.g(context, z);
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                BaiduPayServiceController.this.g(context, z);
            }
        });
        WalletLoginHelper.getInstance().verifyPassLogin(this.f22997b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, boolean z) {
        Intent intent = new Intent(context, SecurityCenterActivity.class);
        boolean z2 = context instanceof Activity;
        if (z2) {
            LogUtil.d("BaiduPayServiceController", "context is activity!");
        } else {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra("with_anim", z);
        context.startActivity(intent);
        if (z2) {
            if (z) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    public static BaiduPayServiceController getInstance() {
        return a.f23014a;
    }

    public void doScanCode(Context context) {
        doScanCode(context, false, null, null);
    }

    public void gotoWalletService(Context context, String str, String str2) {
        gotoWalletService(context, str, str2, true);
    }

    public BaiduPayServiceController() {
        this.f22996a = null;
    }

    public void doScanCode(Context context, boolean z, String str) {
        doScanCode(context, z, null, str);
    }

    public void gotoWalletService(Context context, long j, String str) {
        gotoWalletService(context, j, str, true);
    }

    private void b(Context context, String str, boolean z) {
        String transactionRecordsUrl = SdkInitResponse.getInstance().getTransactionRecordsUrl(context);
        if (TextUtils.isEmpty(transactionRecordsUrl)) {
            transactionRecordsUrl = BeanConstants.TRANSACTION_RECORDS_URL;
        }
        StringBuilder sb = new StringBuilder(transactionRecordsUrl);
        if (!TextUtils.isEmpty(str)) {
            try {
                int i2 = new JSONObject(str).getInt(Constants.ORDERTYPE_FLAG);
                sb.append("?");
                sb.append(Constants.ORDERTYPE_FLAG);
                sb.append("=");
                sb.append(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        BaiduWalletDelegate.getInstance().openH5Module(context, sb.toString(), false);
    }

    public void doScanCode(Context context, boolean z, String str, String str2) {
        String payCodeUrl = SdkInitResponse.getInstance().getPayCodeUrl(context);
        if (TextUtils.isEmpty(payCodeUrl)) {
            payCodeUrl = BeanConstants.API_WALLET_SCANCODE;
        }
        BaiduWalletDelegate.getInstance().openH5Module(context, payCodeUrl, false);
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            this.f22996a = iLightappInvokerCallback;
            gotoWalletService(context, str, str2, true);
        }
    }

    private void a(Context context, String str, boolean z) {
        String balanceHomeUrl = SdkInitResponse.getInstance().getBalanceHomeUrl(context);
        if (TextUtils.isEmpty(balanceHomeUrl)) {
            balanceHomeUrl = BeanConstants.API_WALLET_BALANCE_HOME_PATH;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                StringBuilder sb = new StringBuilder(balanceHomeUrl);
                sb.append("?");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    sb.append(next);
                    sb.append("=");
                    sb.append(optString);
                    sb.append("&");
                }
                if (sb.length() > 0) {
                    balanceHomeUrl = sb.substring(0, sb.length() - 1);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
        baiduWalletDelegate.openH5Module(context, balanceHomeUrl + "#", "", z, false);
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

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        if (context == null || j < 0) {
            return;
        }
        if (j == 4) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_MYBANKINFO);
            a(context, z, str);
        } else if (j == 16) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_TRANSRECORD);
            b(context, str, z);
        } else if (j == 8) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_SECURITYCENTER);
            f(context, z);
        } else if (j == 128) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_O2OPARSER);
            a(context, str);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PAY_SET) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_PAYSET);
            a(context, z);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_SET) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_API_PWDSET);
            b(context, z);
        } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_PWD_CHECK) {
            b(context, str);
        } else if (j == 512) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_SCANQRCODE);
            doScanCode(context, false, str);
        } else if (j == 32) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_BALANCEINFO);
            a(context, str, z);
        } else if (j == 8192) {
            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_CASHBACK);
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_service_offline_tips"));
        } else {
            GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_not_include_tips"));
        }
    }

    private void b(Context context, boolean z) {
        c(context, z);
    }

    private void b(Context context, String str) {
        BaiduPayDelegate.getInstance().checkPwdFromH5(context, str, new CheckCallBack() { // from class: com.baidu.wallet.BaiduPayServiceController.4
            @Override // com.baidu.wallet.api.CheckCallBack
            public void onCheckResult(int i2, String str2) {
                if (BaiduPayServiceController.this.f22996a != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("{\"result\":");
                    sb.append(i2 == 0 ? 0 : 1);
                    sb.append(",\"cnt\":{");
                    if (i2 == 0) {
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("\"content\":\"");
                            sb.append(str2);
                            sb.append("\"");
                        }
                        sb.append("}}");
                    } else {
                        sb.append("\"errCode\":");
                        sb.append(i2);
                        sb.append(",\"des\":\"");
                        sb.append(str2);
                        sb.append("\"}}");
                    }
                    BaiduPayServiceController.this.f22996a.onResult(i2 != 0 ? 1 : 0, sb.toString());
                    BaiduPayServiceController.this.f22996a = null;
                }
            }
        });
    }

    private void a(Context context, boolean z, String str) {
        Intent intent = new Intent();
        intent.setClass(context, BankCardListActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(Constants.BDL_KEY_BANKINFO_EXTRA, str);
        }
        BaiduWalletServiceController.loginFirst(context, intent, z);
    }

    private void a(Context context, boolean z) {
        if (!NetworkUtils.isNetworkAvailable(context)) {
            GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            return;
        }
        Intent intent = new Intent(context, PaySettingActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        BaiduWalletServiceController.loginFirst(context, intent, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        c(context, true);
    }

    private void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            BaiduWalletUtils.invokeHostLightapp(context, str);
            return;
        }
        GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_o2o_error"));
    }
}
