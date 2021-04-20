package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.LoadingActivity;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class PassLoginUtil {
    public static final int LOGIN_STATUS_ERROR_CODE = 603;

    /* renamed from: a  reason: collision with root package name */
    public static final String f25011a = "PassLoginUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final long f25012b = 300;

    /* renamed from: c  reason: collision with root package name */
    public static final long f25013c = 7000;

    /* renamed from: d  reason: collision with root package name */
    public static final int f25014d = 601;

    /* renamed from: e  reason: collision with root package name */
    public static final int f25015e = 602;

    /* renamed from: f  reason: collision with root package name */
    public static final int f25016f = 604;

    /* renamed from: g  reason: collision with root package name */
    public static final int f25017g = 605;

    /* renamed from: h  reason: collision with root package name */
    public static final int f25018h = -201;
    public static final int i = -202;
    public static final int j = -203;
    public static final int k = -901;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 6;
    public static final int q = 7;
    public volatile OpenBdussResult r;
    public CountDownTimer s;
    public CountDownTimer t;
    public boolean u;
    public long v;
    public boolean w;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final PassLoginUtil f25028a = new PassLoginUtil();
    }

    public static PassLoginUtil getInstance() {
        return a.f25028a;
    }

    public void clearOpenBduss() {
        this.r = null;
    }

    public synchronized Map<String, String> getLoginData(Context context, String str) {
        HashMap hashMap;
        hashMap = new HashMap();
        if (isLogin()) {
            if (!TextUtils.isEmpty(this.r.uid)) {
                hashMap.put("pass_uid", this.r.uid);
            }
            if (!TextUtils.isEmpty(this.r.bduss)) {
                hashMap.put("pass_bduss", this.r.bduss);
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
        return hashMap;
    }

    public synchronized String getLoginOpenToken() {
        return isLogin() ? this.r.openBduss : "";
    }

    public synchronized String getLoginStoken(String str) {
        String str2;
        str2 = isLogin() ? this.r.tplStokenMap.get(str) : null;
        if (isPassLogin() && TextUtils.isEmpty(str2)) {
            DXMSdkSAUtils.onEvent(StatServiceEvent.STOKEN_EMPTY);
            PayStatisticsUtil.onEvent(StatServiceEvent.STOKEN_EMPTY);
        }
        return str2;
    }

    public synchronized String getLoginToken() {
        String str;
        str = "";
        if (isPassLogin() && this.r != null && !TextUtils.isEmpty(this.r.bduss)) {
            str = this.r.bduss;
        }
        if (isPassLogin() && TextUtils.isEmpty(str)) {
            PayStatisticsUtil.onEvent(StatServiceEvent.BDUSS_EMPTY);
        }
        return str;
    }

    public synchronized void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        a();
        clearOpenBduss();
        c(z, iLoginBackListener);
    }

    public void init() {
    }

    public synchronized boolean isLogin() {
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

    public boolean isPassLogin() {
        return SapiAccountManager.getInstance().isLogin();
    }

    public void logout() {
        SapiAccountManager.getInstance().logout();
        com.baidu.wallet.passport.a.a().b();
        clearOpenBduss();
    }

    public synchronized void setErrorCodeSwitchFlag(boolean z) {
        this.w = z;
    }

    public synchronized void setIntervalDuration(long j2) {
        this.v = j2;
    }

    public PassLoginUtil() {
        this.u = false;
        this.v = -1L;
        this.w = true;
    }

    private void b(final boolean z, final ILoginBackListener iLoginBackListener) {
        long j2;
        if (z) {
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
            CountDownTimer countDownTimer = new CountDownTimer(j2, j2) { // from class: com.baidu.wallet.passport.PassLoginUtil.2
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    PassLoginUtil.this.setIntervalDuration(-1L);
                    if (PassLoginUtil.this.r == null && z) {
                        ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                        if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                            PassLoginUtil.this.a(((LoginBackListenerProxy) iLoginBackListener2).getContext());
                        }
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j5) {
                }
            };
            this.s = countDownTimer;
            countDownTimer.start();
        }
    }

    private void c(final boolean z, final ILoginBackListener iLoginBackListener) {
        a(z, iLoginBackListener);
        b(z, iLoginBackListener);
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = "fHUnn02XwCrywmmdUtCdK6eC";
        getOpenBdussDTO.targetTplList.add(WalletLoginHelper.getInstance().getTpl());
        DXMSdkSAUtils.onEventStart(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING);
        PayStatisticsUtil.onEventStart(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING);
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback() { // from class: com.baidu.wallet.passport.PassLoginUtil.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: a */
            public void onSuccess(OpenBdussResult openBdussResult) {
                Map<String, String> map;
                PassLoginUtil.this.a();
                PassLoginUtil.this.c();
                PassLoginUtil.this.setIntervalDuration(-1L);
                if (openBdussResult != null) {
                    DXMSdkSAUtils.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                    if (PassLoginUtil.this.u) {
                        PassLoginUtil.this.b();
                        return;
                    }
                    PassLoginUtil.this.r = openBdussResult;
                    ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                    if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                        if (!TextUtils.isEmpty(openBdussResult.openBduss) && !TextUtils.isEmpty(openBdussResult.unionid) && (map = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                            com.baidu.wallet.passport.a.a().a(openBdussResult.openBduss);
                            if (loginBackListener != null) {
                                PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                loginBackListener.onSuccess(2, openBdussResult.openBduss);
                            }
                        } else if (context == null || loginBackListener == null) {
                        } else {
                            if (z && PassLoginUtil.this.w) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                            }
                            PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                            DXMSdkSAUtils.onEvent(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_SUCCESS_NO_INFO);
                            PayStatisticsUtil.onEvent(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_SUCCESS_NO_INFO);
                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: b */
            public void onFailure(OpenBdussResult openBdussResult) {
                PassLoginUtil.this.a();
                PassLoginUtil.this.c();
                PassLoginUtil.this.setIntervalDuration(-1L);
                if (openBdussResult != null) {
                    DXMSdkSAUtils.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.KEY_FETCH_OPEN_BDUSS_LOADING, openBdussResult.getResultCode());
                    if (PassLoginUtil.this.u) {
                        PassLoginUtil.this.b();
                        return;
                    }
                    PassLoginUtil.this.logout(false);
                    ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                    if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                        if (loginBackListener != null) {
                            if (openBdussResult.getResultCode() != 2 && openBdussResult.getResultCode() != 6 && openBdussResult.getResultCode() != -901) {
                                if (openBdussResult.getResultCode() == -203) {
                                    if (context != null && z && PassLoginUtil.this.w) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_ssl_error"));
                                    }
                                    PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(605, openBdussResult.getResultMsg());
                                    return;
                                } else if (openBdussResult.getResultCode() != -201 && openBdussResult.getResultCode() != -202) {
                                    if (openBdussResult.getResultCode() != 3 && openBdussResult.getResultCode() != 4 && openBdussResult.getResultCode() != 7) {
                                        if (openBdussResult.getResultCode() == 1) {
                                            if (context != null && z && PassLoginUtil.this.w) {
                                                PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                                try {
                                                    PassLoginDialogUtil.getInstance().showLoginTipDialog(context, iLoginBackListener, 604, openBdussResult.getResultMsg());
                                                    return;
                                                } catch (Exception e2) {
                                                    LogUtil.e("PassLoginDialog", "dialog Exception", e2);
                                                    GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                                    loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                                    return;
                                                }
                                            }
                                            PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                            loginBackListener.onFail(604, openBdussResult.getResultMsg());
                                            return;
                                        }
                                        if (context != null && z && PassLoginUtil.this.w) {
                                            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                        }
                                        PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                        loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                        return;
                                    }
                                    if (context != null && z && PassLoginUtil.this.w) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                    }
                                    PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                                    return;
                                } else {
                                    if (context != null && z && PassLoginUtil.this.w) {
                                        GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                                    }
                                    PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                                    loginBackListener.onFail(601, openBdussResult.getResultMsg());
                                    return;
                                }
                            }
                            loginBackListener.onFail(603, openBdussResult.getResultMsg());
                        }
                    }
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                LogUtil.d(PassLoginUtil.f25011a, "Get Open BDUSS : onFinish");
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                LogUtil.d(PassLoginUtil.f25011a, "Get Open BDUSS : onStart");
            }
        });
    }

    public void logout(boolean z) {
        if (z) {
            SapiAccountManager.getInstance().logout();
        }
        com.baidu.wallet.passport.a.a().b();
        clearOpenBduss();
    }

    private void a(final boolean z, final ILoginBackListener iLoginBackListener) {
        Context context;
        if (z) {
            b();
            boolean z2 = iLoginBackListener instanceof LoginBackListenerProxy;
            long j2 = f25013c;
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
            CountDownTimer countDownTimer = new CountDownTimer(j3, j3) { // from class: com.baidu.wallet.passport.PassLoginUtil.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    PassLoginUtil.this.c();
                    PassLoginUtil.this.setIntervalDuration(-1L);
                    ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                    if ((iLoginBackListener2 instanceof LoginBackListenerProxy) && z) {
                        Context context2 = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                        if (loginBackListener != null) {
                            if (context2 != null && PassLoginUtil.this.w) {
                                GlobalUtils.toast(context2, ResUtils.getString(context2, "wallet_base_open_bduss_network_error"));
                            }
                            PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                            PassLoginUtil.this.u = true;
                            loginBackListener.onFail(601, context2 != null ? ResUtils.getString(context2, "wallet_base_open_bduss_network_error") : "");
                        }
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                }
            };
            this.t = countDownTimer;
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.u = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        LoadingActivity.exitLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, LoadingActivity.class);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.getApplicationContext().startActivity(intent);
        }
    }
}
