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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.e;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes12.dex */
public class BindCardEntry implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequestCache.BindCategory f53355b;

    /* renamed from: c  reason: collision with root package name */
    public String f53356c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<? extends Context> f53357d;

    /* renamed from: e  reason: collision with root package name */
    public e f53358e;

    /* renamed from: f  reason: collision with root package name */
    public OnReturn f53359f;

    /* renamed from: g  reason: collision with root package name */
    public WelcomeActivity f53360g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53361h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53362i;

    /* loaded from: classes12.dex */
    public interface OnReturn {
        void onFailed(int i2, String str);

        void onResponse(CardAddResponse cardAddResponse);
    }

    /* loaded from: classes12.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static BindCardEntry sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1250650963, "Lcom/baidu/wallet/paysdk/api/BindCardEntry$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1250650963, "Lcom/baidu/wallet/paysdk/api/BindCardEntry$SingletonHolder;");
                    return;
                }
            }
            sInstance = new BindCardEntry();
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static BindFastRequest createBindRequest(PayRequestCache.BindCategory bindCategory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bindCategory)) == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            if (bindCategory != null && PayRequestCache.BindCategory.Other != bindCategory) {
                SingletonHolder.sInstance.f53355b = bindCategory;
                PayRequestCache.getInstance().addBeanRequestToCache(bindCategory.name(), bindFastRequest);
                SingletonHolder.sInstance.f53358e.a(bindFastRequest);
                return bindFastRequest;
            }
            throw new IllegalStateException("not support bind card for Paying");
        }
        return (BindFastRequest) invokeL.objValue;
    }

    public static OnReturn createCb4CheckPwdAndBind(Context context, BaiduPay.IBindCardCallback iBindCardCallback, Bundle bundle, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{context, iBindCardCallback, bundle, Boolean.valueOf(z), str})) == null) ? new OnReturn(z, str, context, iBindCardCallback, bundle) { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bundle val$bindBdl;
            public final /* synthetic */ BaiduPay.IBindCardCallback val$bindCb;
            public final /* synthetic */ boolean val$checkPwd;
            public final /* synthetic */ String val$checkPwdFrom;
            public final /* synthetic */ Context val$cntx;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Boolean.valueOf(z), str, context, iBindCardCallback, bundle};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$checkPwd = z;
                this.val$checkPwdFrom = str;
                this.val$cntx = context;
                this.val$bindCb = iBindCardCallback;
                this.val$bindBdl = bundle;
            }

            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
            public void onFailed(int i2, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                    BaiduPay.IBindCardCallback iBindCardCallback2 = this.val$bindCb;
                    if (iBindCardCallback2 != null) {
                        iBindCardCallback2.onChangeFailed(str2);
                    }
                    BaiduPay.getInstance().clearBindCallbackExt();
                }
            }

            @Override // com.baidu.wallet.paysdk.api.BindCardEntry.OnReturn
            public void onResponse(CardAddResponse cardAddResponse) {
                Activity loadingUi;
                UserData.UserModel userModel;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cardAddResponse) == null) || (loadingUi = BindCardEntry.getLoadingUi()) == null) {
                    return;
                }
                if (this.val$checkPwd && (userModel = cardAddResponse.user) != null && userModel.hasMobilePwd()) {
                    PasswordController.getPassWordInstance().checkPwd(loadingUi, this.val$checkPwdFrom, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass3 this$0;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                        public void onFail(int i2, String str2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, str2) == null) {
                                String sessionId = StatHelper.getSessionId();
                                List<String> collectData = StatHelper.collectData(sessionId, i2 + "", str2);
                                HashMap hashMap = new HashMap();
                                hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
                                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, collectData, hashMap);
                                BaiduPay.IBindCardCallback iBindCardCallback2 = this.this$0.val$bindCb;
                                if (iBindCardCallback2 != null) {
                                    iBindCardCallback2.onChangeFailed(str2);
                                }
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                BaiduPay.getInstance().clearBindCallbackExt();
                            }
                        }

                        @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                        public void onSucceed(String str2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                PasswordController.getPassWordInstance().clearCheckPwdListener();
                                Context loadingUi2 = BindCardEntry.getLoadingUi();
                                if (loadingUi2 == null) {
                                    loadingUi2 = this.this$0.val$cntx;
                                }
                                BaiduPay baiduPay = BaiduPay.getInstance();
                                AnonymousClass3 anonymousClass3 = this.this$0;
                                baiduPay.launchBindCardActivity(loadingUi2, anonymousClass3.val$bindCb, anonymousClass3.val$bindBdl);
                            }
                        }
                    });
                    return;
                }
                Context loadingUi2 = BindCardEntry.getLoadingUi();
                if (loadingUi2 == null) {
                    loadingUi2 = this.val$cntx;
                }
                BaiduPay.getInstance().launchBindCardActivity(loadingUi2, this.val$bindCb, this.val$bindBdl);
            }
        } : (OnReturn) invokeCommon.objValue;
    }

    public static PayRequestCache.BindCategory getBindScenario() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? SingletonHolder.sInstance.f53355b : (PayRequestCache.BindCategory) invokeV.objValue;
    }

    public static Activity getLoadingUi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (SingletonHolder.sInstance.f53360g == null) {
                return null;
            }
            return SingletonHolder.sInstance.f53360g.getActivity();
        }
        return (Activity) invokeV.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            if (context instanceof Activity) {
                SingletonHolder.sInstance.f53357d = new WeakReference<>(context);
            } else if (!(context instanceof BaseActivity)) {
                SingletonHolder.sInstance.f53357d = null;
            } else {
                Activity activity = ((BaseActivity) context).getActivity();
                SingletonHolder.sInstance.f53357d = new WeakReference<>(activity);
            }
            EventBus.getInstance().register(SingletonHolder.sInstance, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
            SingletonHolder.sInstance.f53358e.setResponseCallback(SingletonHolder.sInstance);
        }
    }

    public static void innerRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(SingletonHolder.sInstance.f53356c)) {
                sb.append(SingletonHolder.sInstance.f53356c);
                sb.setCharAt(sb.length() - 1, ',');
            } else {
                sb.append(StringUtil.ARRAY_START);
            }
            sb.append("request_type:");
            if (SingletonHolder.sInstance.f53355b != null) {
                sb.append(SingletonHolder.sInstance.f53355b.getScenario());
            } else {
                sb.append(PayRequestCache.BindCategory.Initiative.getScenario());
            }
            sb.append("}");
            SingletonHolder.sInstance.f53358e.a(sb.toString());
            SingletonHolder.sInstance.f53358e.execBean();
        }
    }

    public static void run() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            Context context = SingletonHolder.sInstance.f53357d != null ? SingletonHolder.sInstance.f53357d.get() : null;
            if (context == null) {
                return;
            }
            if (SingletonHolder.sInstance.f53358e.a() != null) {
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
                intent.addFlags(268435456);
                context.getApplicationContext().startActivity(intent);
                return;
            }
            throw new RuntimeException("should call createBindRequest() before running");
        }
    }

    public static void setCallback(OnReturn onReturn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, onReturn) == null) {
            SingletonHolder.sInstance.f53359f = onReturn;
        }
    }

    public static void setExtrParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            SingletonHolder.sInstance.f53356c = str;
        }
    }

    public static void setLoadingUi(WelcomeActivity welcomeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, welcomeActivity) == null) {
            SingletonHolder.sInstance.f53360g = welcomeActivity;
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
            CardAddResponse.updateContent(null);
            StatHelper.clearSensor();
            if (SingletonHolder.sInstance.f53355b == PayRequestCache.BindCategory.Initiative) {
                String b2 = b();
                List<String> collectData = StatHelper.collectData(b2, "cardAdd is failed");
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.BIND_CARD_USER_TYPE, "-1");
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, collectData, hashMap);
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(b2, i3 + "", str), hashMap);
            }
            if (this.f53359f != null) {
                this.a.obtainMessage(2, i3, 0, str).sendToTarget();
            }
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        CardAddErrorContent cardAddErrorContent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            CardAddResponse.updateContent(null);
            if (i3 != 16254 || obj == null || !(obj instanceof CardAddErrorContent) || SingletonHolder.sInstance.f53360g == null) {
                SingletonHolder.sInstance.a.obtainMessage(2, i3, 0, str).sendToTarget();
                return;
            }
            if (TextUtils.isEmpty(((CardAddErrorContent) obj).goto_url)) {
                SingletonHolder.sInstance.a.obtainMessage(2, i3, 0, str).sendToTarget();
                return;
            }
            StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_ENTER);
            H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this) { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindCardEntry this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                        pop();
                        if (!SingletonHolder.sInstance.f53361h) {
                            StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
                            this.this$0.f53362i = false;
                            SingletonHolder.sInstance.a.obtainMessage(2, -1, 0, "").sendToTarget();
                        }
                        SingletonHolder.sInstance.f53361h = false;
                    }
                }
            };
            h5LifeCycleCallback.push();
            EventBus.getInstance().register(SingletonHolder.sInstance, BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT, 0, EventBus.ThreadMode.MainThread);
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", cardAddErrorContent.goto_url + "?is_from_sdk=1");
            bundle.putParcelable("lifecycleLsnr", h5LifeCycleCallback);
            BaiduWalletDelegate.getInstance().openH5Module(SingletonHolder.sInstance.f53360g, bundle);
            SingletonHolder.sInstance.f53360g.finishWithoutAnim();
            SingletonHolder.sInstance.f53360g = null;
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            CardAddResponse.updateContent(obj);
            StatHelper.clearSensor();
            if (SingletonHolder.sInstance.f53355b == PayRequestCache.BindCategory.Initiative) {
                String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(NetworkBean.BizType.BindCard);
                StatHelper.cacheSessionId(sessionId);
                CardAddResponse cardAddResponse = (CardAddResponse) obj;
                if (cardAddResponse != null && (userModel = cardAddResponse.user) != null && 1 == userModel.has_mobile_password) {
                    StatHelper.cacheBindCardUserType("1");
                } else {
                    StatHelper.cacheBindCardUserType("0");
                }
                List<String> collectData = StatHelper.collectData(sessionId, new String[0]);
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, collectData, hashMap);
            }
            if (this.f53359f != null) {
                this.a.sendEmptyMessage(0);
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, event) == null) || event == null) {
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
        if (!BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT.equals(event.mEventKey) || SingletonHolder.sInstance.f53357d == null || SingletonHolder.sInstance.f53357d.get() == null) {
            return;
        }
        if (event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("confirm_result") && 1 == jSONObject.getInt("confirm_result")) {
                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_AGREE);
                    SingletonHolder.sInstance.f53361h = true;
                    init(SingletonHolder.sInstance.f53357d.get());
                    run();
                } else {
                    StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
                    this.f53362i = false;
                    SingletonHolder.sInstance.a.obtainMessage(2, -1, 0, "").sendToTarget();
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        StatisticManager.onEvent(PayStatServiceEvent.BIND_CARD_PASS_FAILED);
        this.f53362i = false;
        SingletonHolder.sInstance.a.obtainMessage(2, -1, 0, "").sendToTarget();
    }

    public BindCardEntry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53355b = null;
        this.f53361h = false;
        this.f53362i = true;
        e eVar = new e(BaiduWalletDelegate.getInstance().getAppContext());
        this.f53358e = eVar;
        eVar.setResponseCallback(this);
        this.a = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BindCardEntry this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (1 == i4) {
                        if (this.this$0.f53359f != null) {
                            this.this$0.f53359f.onResponse(CardAddResponse.getInstance());
                        }
                        if (this.this$0.f53360g != null) {
                            this.this$0.f53360g.finishWithoutAnim();
                            this.this$0.f53360g = null;
                        }
                        this.this$0.a();
                    } else if (i4 != 0) {
                        if (2 == i4) {
                            if (this.this$0.f53362i) {
                                this.this$0.a(message.arg1, (String) message.obj);
                            }
                            if (this.this$0.f53359f != null) {
                                this.this$0.f53359f.onFailed(message.arg1, (String) message.obj);
                            }
                            if (this.this$0.f53360g != null) {
                                this.this$0.f53360g.finishWithoutAnim();
                                this.this$0.f53360g = null;
                            }
                            this.this$0.a();
                        }
                    } else {
                        boolean z = false;
                        CardAddResponse.ConfirmWindow confirmWindow = CardAddResponse.getInstance().confirm_window;
                        if (confirmWindow != null && this.this$0.f53360g != null && !TextUtils.isEmpty(confirmWindow.content)) {
                            PromptTipDialog promptTipDialog = new PromptTipDialog(this.this$0.f53360g);
                            promptTipDialog.setTitleMessage(confirmWindow.title);
                            promptTipDialog.setMessage(confirmWindow.content);
                            promptTipDialog.setButtonMessage(TextUtils.isEmpty(confirmWindow.btn_name) ? "确认" : confirmWindow.btn_name);
                            promptTipDialog.setDefaultBtnListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.api.BindCardEntry.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                                        newInitContext2.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext2);
                                        int i5 = newInitContext2.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext2.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext2);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, view) == null) {
                                        sendEmptyMessage(1);
                                    }
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
            }
        };
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f53359f = null;
            this.f53357d = null;
            this.f53356c = null;
            this.f53355b = null;
            this.f53358e.a((BindFastRequest) null);
            this.f53361h = false;
            this.f53362i = true;
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
            EventBus.getInstance().unregister(this, BeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, this, i2, str) == null) {
            Context appContext = BaiduWalletDelegate.getInstance().getAppContext();
            if (i2 == 5003) {
                GlobalUtils.toast(appContext, ResUtils.getString(appContext, "dxm_wallet_base_please_login"));
                AccountManager.getInstance(appContext).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (-2 == i2 || -3 == i2) {
                GlobalUtils.toast(appContext, ResUtils.getString(appContext, "dxm_fp_get_data_fail"));
            } else if (-8 == i2) {
                GlobalUtils.toast(appContext, ResUtils.getString(appContext, "dxm_ebpay_no_network"));
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(appContext, "dxm_fp_get_data_fail");
                }
                GlobalUtils.toast(appContext, str);
            }
        }
    }
}
