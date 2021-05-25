package com.baidu.wallet.paysdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.d;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes5.dex */
public class BindCardEntry implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public Handler f25047a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequestCache.BindCategory f25048b;

    /* renamed from: c  reason: collision with root package name */
    public String f25049c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<? extends Context> f25050d;

    /* renamed from: e  reason: collision with root package name */
    public d f25051e;

    /* renamed from: f  reason: collision with root package name */
    public OnReturn f25052f;

    /* renamed from: g  reason: collision with root package name */
    public WelcomeActivity f25053g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25054h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25055i;

    /* loaded from: classes5.dex */
    public interface OnReturn {
        void onFailed(int i2, String str);

        void onResponse(CardAddResponse cardAddResponse);
    }

    /* loaded from: classes5.dex */
    public static class SingletonHolder {
        public static BindCardEntry sInstance = new BindCardEntry();
    }

    public static BindFastRequest createBindRequest(PayRequestCache.BindCategory bindCategory) {
        BindFastRequest bindFastRequest = new BindFastRequest();
        if (bindCategory != null && PayRequestCache.BindCategory.Other != bindCategory) {
            SingletonHolder.sInstance.f25048b = bindCategory;
            PayRequestCache.getInstance().addBeanRequestToCache(bindCategory.name(), bindFastRequest);
            SingletonHolder.sInstance.f25051e.a(bindFastRequest);
            return bindFastRequest;
        }
        throw new IllegalStateException("not support bind card for Paying");
    }

    public static OnReturn createCb4CheckPwdAndBind(final Context context, final BaiduPay.IBindCardCallback iBindCardCallback, final Bundle bundle, final boolean z, final String str) {
        return new OnReturn() { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.3
            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
            public void onFailed(int i2, String str2) {
                BaiduPay.IBindCardCallback iBindCardCallback2 = iBindCardCallback;
                if (iBindCardCallback2 != null) {
                    iBindCardCallback2.onChangeFailed(str2);
                }
                BaiduPay.getInstance().clearBindCallbackExt();
            }

            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
            public void onResponse(CardAddResponse cardAddResponse) {
                UserData.UserModel userModel;
                Activity loadingUi = BindCardEntry.getLoadingUi();
                if (loadingUi != null) {
                    if (z && (userModel = cardAddResponse.user) != null && userModel.hasMobilePwd()) {
                        PasswordController.getPassWordInstance().checkPwd(loadingUi, str, new PasswordController.IPwdListener() { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.3.1
                            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                            public void onFail(int i2, String str2) {
                                String sessionId = StatHelper.getSessionId();
                                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(sessionId, i2 + "", str2));
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                BaiduPay.getInstance().clearBindCallbackExt();
                            }

                            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                            public void onSucceed(String str2) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                Context loadingUi2 = BindCardEntry.getLoadingUi();
                                if (loadingUi2 == null) {
                                    loadingUi2 = context;
                                }
                                BaiduPay baiduPay = BaiduPay.getInstance();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                baiduPay.launchBindCardActivity(loadingUi2, iBindCardCallback, bundle);
                            }
                        });
                        return;
                    }
                    Context loadingUi2 = BindCardEntry.getLoadingUi();
                    if (loadingUi2 == null) {
                        loadingUi2 = context;
                    }
                    BaiduPay.getInstance().launchBindCardActivity(loadingUi2, iBindCardCallback, bundle);
                }
            }
        };
    }

    public static PayRequestCache.BindCategory getBindScenario() {
        return SingletonHolder.sInstance.f25048b;
    }

    public static Activity getLoadingUi() {
        if (SingletonHolder.sInstance.f25053g == null) {
            return null;
        }
        return SingletonHolder.sInstance.f25053g.getActivity();
    }

    public static void init(Context context) {
        if (context instanceof Activity) {
            SingletonHolder.sInstance.f25050d = new WeakReference<>(context);
        } else if (!(context instanceof BaseActivity)) {
            SingletonHolder.sInstance.f25050d = null;
        } else {
            Activity activity = ((BaseActivity) context).getActivity();
            SingletonHolder.sInstance.f25050d = new WeakReference<>(activity);
        }
        EventBus.getInstance().register(SingletonHolder.sInstance, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        SingletonHolder.sInstance.f25051e.setResponseCallback(SingletonHolder.sInstance);
    }

    public static void innerRun() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(SingletonHolder.sInstance.f25049c)) {
            sb.append(SingletonHolder.sInstance.f25049c);
            sb.setCharAt(sb.length() - 1, ',');
        } else {
            sb.append(StringUtil.ARRAY_START);
        }
        sb.append("request_type:");
        if (SingletonHolder.sInstance.f25048b != null) {
            sb.append(SingletonHolder.sInstance.f25048b.getScenario());
        } else {
            sb.append(PayRequestCache.BindCategory.Initiative.getScenario());
        }
        sb.append("}");
        SingletonHolder.sInstance.f25051e.a(sb.toString());
        SingletonHolder.sInstance.f25051e.execBean();
    }

    public static void run() {
        Activity activity;
        Context context = SingletonHolder.sInstance.f25050d != null ? SingletonHolder.sInstance.f25050d.get() : null;
        if (context == null) {
            return;
        }
        if (SingletonHolder.sInstance.f25051e.a() != null) {
            Intent intent = new Intent(context, WelcomeActivity.class);
            intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 4);
            if (BaiduWalletUtils.isActivity(context)) {
                if (context instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) context;
                    baseActivity.startActivityWithoutAnim(intent);
                    activity = baseActivity.getActivity();
                } else {
                    context.startActivity(intent);
                    activity = (Activity) context;
                }
                BaiduWalletUtils.overridePendingTransitionNoAnim(activity);
                return;
            }
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.getApplicationContext().startActivity(intent);
            return;
        }
        throw new RuntimeException("should call createBindRequest() before running");
    }

    public static void setCallback(OnReturn onReturn) {
        SingletonHolder.sInstance.f25052f = onReturn;
    }

    public static void setExtrParam(String str) {
        SingletonHolder.sInstance.f25049c = str;
    }

    public static void setLoadingUi(WelcomeActivity welcomeActivity) {
        SingletonHolder.sInstance.f25053g = welcomeActivity;
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        CardAddResponse.updateContent(null);
        if (SingletonHolder.sInstance.f25048b == PayRequestCache.BindCategory.Initiative) {
            String b2 = b();
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, StatHelper.collectData(b2, "cardAdd is failed"));
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(b2, i3 + "", str));
        }
        if (this.f25052f != null) {
            this.f25047a.obtainMessage(2, i3, 0, str).sendToTarget();
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        CardAddErrorContent cardAddErrorContent;
        CardAddResponse.updateContent(null);
        if (i3 != 16254 || obj == null || !(obj instanceof CardAddErrorContent) || SingletonHolder.sInstance.f25053g == null) {
            SingletonHolder.sInstance.f25047a.obtainMessage(2, i3, 0, str).sendToTarget();
            return;
        }
        if (TextUtils.isEmpty(((CardAddErrorContent) obj).goto_url)) {
            SingletonHolder.sInstance.f25047a.obtainMessage(2, i3, 0, str).sendToTarget();
            return;
        }
        StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_ENTER);
        H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback() { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.2
            @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                pop();
                if (!SingletonHolder.sInstance.f25054h) {
                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
                    BindCardEntry.this.f25055i = false;
                    SingletonHolder.sInstance.f25047a.obtainMessage(2, -1, 0, "").sendToTarget();
                }
                SingletonHolder.sInstance.f25054h = false;
            }
        };
        h5LifeCycleCallback.push();
        EventBus.getInstance().register(SingletonHolder.sInstance, BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT, 0, EventBus.ThreadMode.MainThread);
        Bundle bundle = new Bundle();
        bundle.putBoolean("with_anim", false);
        bundle.putBoolean("show_share", false);
        bundle.putString("url", cardAddErrorContent.goto_url + "?is_from_sdk=1");
        bundle.putParcelable("lifecycleLsnr", h5LifeCycleCallback);
        BaiduWalletDelegate.getInstance().openH5Module(SingletonHolder.sInstance.f25053g, bundle);
        SingletonHolder.sInstance.f25053g.finishWithoutAnim();
        SingletonHolder.sInstance.f25053g = null;
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        CardAddResponse.updateContent(obj);
        if (SingletonHolder.sInstance.f25048b == PayRequestCache.BindCategory.Initiative) {
            String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(NetworkBean.BizType.BindCard);
            StatHelper.cacheSessionId(sessionId);
            StatisticManager.onEventWithValue(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, sessionId);
        }
        if (this.f25052f != null) {
            this.f25047a.sendEmptyMessage(0);
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null) {
            return;
        }
        if (event.mEventKey.equals("ev_bean_execut_err_content")) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
                return;
            }
        }
        if (!BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT.equals(event.mEventKey) || SingletonHolder.sInstance.f25050d == null || SingletonHolder.sInstance.f25050d.get() == null) {
            return;
        }
        if (event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("confirm_result") && 1 == jSONObject.getInt("confirm_result")) {
                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_AGREE);
                    SingletonHolder.sInstance.f25054h = true;
                    init(SingletonHolder.sInstance.f25050d.get());
                    run();
                } else {
                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
                    this.f25055i = false;
                    SingletonHolder.sInstance.f25047a.obtainMessage(2, -1, 0, "").sendToTarget();
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
        this.f25055i = false;
        SingletonHolder.sInstance.f25047a.obtainMessage(2, -1, 0, "").sendToTarget();
    }

    public BindCardEntry() {
        this.f25048b = null;
        this.f25054h = false;
        this.f25055i = true;
        d dVar = new d(BaiduWalletDelegate.getInstance().getAppContext());
        this.f25051e = dVar;
        dVar.setResponseCallback(this);
        this.f25047a = new Handler(Looper.getMainLooper()) { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (1 == i2) {
                    if (BindCardEntry.this.f25052f != null) {
                        BindCardEntry.this.f25052f.onResponse(CardAddResponse.getInstance());
                    }
                    if (BindCardEntry.this.f25053g != null) {
                        BindCardEntry.this.f25053g.finishWithoutAnim();
                        BindCardEntry.this.f25053g = null;
                    }
                    BindCardEntry.this.a();
                } else if (i2 != 0) {
                    if (2 == i2) {
                        if (BindCardEntry.this.f25055i) {
                            BindCardEntry.this.a(message.arg1, (String) message.obj);
                        }
                        if (BindCardEntry.this.f25052f != null) {
                            BindCardEntry.this.f25052f.onFailed(message.arg1, (String) message.obj);
                        }
                        if (BindCardEntry.this.f25053g != null) {
                            BindCardEntry.this.f25053g.finishWithoutAnim();
                            BindCardEntry.this.f25053g = null;
                        }
                        BindCardEntry.this.a();
                    }
                } else {
                    boolean z = false;
                    CardAddResponse.ConfirmWindow confirmWindow = CardAddResponse.getInstance().confirm_window;
                    if (confirmWindow != null && BindCardEntry.this.f25053g != null && !TextUtils.isEmpty(confirmWindow.content)) {
                        PromptTipDialog promptTipDialog = new PromptTipDialog(BindCardEntry.this.f25053g);
                        promptTipDialog.setTitleMessage(confirmWindow.title);
                        promptTipDialog.setMessage(confirmWindow.content);
                        promptTipDialog.setButtonMessage(TextUtils.isEmpty(confirmWindow.btn_name) ? "确认" : confirmWindow.btn_name);
                        promptTipDialog.setDefaultBtnListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                sendEmptyMessage(1);
                            }
                        });
                        promptTipDialog.show();
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    sendEmptyMessage(1);
                }
            }
        };
    }

    private String b() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f25052f = null;
        this.f25050d = null;
        this.f25049c = null;
        this.f25048b = null;
        this.f25051e.a((BindFastRequest) null);
        this.f25054h = false;
        this.f25055i = true;
        EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        EventBus.getInstance().unregister(this, BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Context appContext = BaiduWalletDelegate.getInstance().getAppContext();
        if (i2 == 5003) {
            GlobalUtils.toast(appContext, ResUtils.getString(appContext, "wallet_base_please_login"));
            AccountManager.getInstance(appContext).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (-2 == i2 || -3 == i2) {
            GlobalUtils.toast(appContext, ResUtils.getString(appContext, "fp_get_data_fail"));
        } else if (-8 == i2) {
            GlobalUtils.toast(appContext, ResUtils.getString(appContext, "ebpay_no_network"));
        } else {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(appContext, "fp_get_data_fail");
            }
            GlobalUtils.toast(appContext, str);
        }
    }
}
