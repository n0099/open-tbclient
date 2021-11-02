package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.l;
import com.baidu.wallet.paysdk.beans.n;
import com.baidu.wallet.paysdk.beans.u;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class PwdSetAndConfirmActivity extends PayBaseActivity implements SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60281a;

    /* renamed from: b  reason: collision with root package name */
    public View f60282b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60283c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60284d;

    /* renamed from: e  reason: collision with root package name */
    public SixNumberPwdView f60285e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60286f;

    /* renamed from: g  reason: collision with root package name */
    public View f60287g;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardEditText f60288h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60289i;
    public SafeScrollView j;
    public RelativeLayout k;
    public PwdRequest l;
    public BindFastRequest m;
    public PayRequest n;
    public n o;
    public l p;
    public w q;
    public com.baidu.wallet.paysdk.beans.b r;
    public CountDownTimer s;
    public final int t;
    public final int u;
    public final int v;

    public PwdSetAndConfirmActivity() {
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
        this.f60281a = false;
        this.t = 1;
        this.u = 2;
        this.v = 18;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f60286f.setVisibility(8);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f60281a = false;
            int i2 = this.l.mFrom;
            if (i2 != 0) {
                if (i2 == 2) {
                    i();
                    return;
                }
                return;
            }
            switch (this.m.getmBindFrom()) {
                case 0:
                    d();
                    return;
                case 1:
                    f();
                    return;
                case 2:
                    d();
                    return;
                case 3:
                    g();
                    return;
                case 4:
                    h();
                    return;
                case 5:
                    h();
                    return;
                case 6:
                case 7:
                case 8:
                    e();
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f60281a = true;
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (this.q == null) {
                this.q = (w) PayBeanFactory.getInstance().getBean((Context) getActivity(), 13, "PwdSetAndConfirmActivity");
            }
            this.q.setResponseCallback(this);
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            this.q.execBean();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (this.q == null) {
                this.q = (w) PayBeanFactory.getInstance().getBean((Context) this, 13, "PwdSetAndConfirmActivity");
            }
            this.q.setResponseCallback(this);
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(3);
            this.q.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (this.r == null) {
                this.r = (com.baidu.wallet.paysdk.beans.b) PayBeanFactory.getInstance().getBean((Context) getActivity(), 513, "PwdSetAndConfirmActivity");
            }
            this.r.a(this.m);
            this.r.setResponseCallback(this);
            this.r.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            this.l.mConfirmPayPass = getPwdConfirm();
            if (this.o == null) {
                this.o = (n) PayBeanFactory.getInstance().getBean((Context) getActivity(), 260, "PwdSetAndConfirmActivity");
            }
            this.m.getBindFromOrigin();
            this.o.a(this.m);
            this.o.setResponseCallback(this);
            this.o.execBean();
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            this.l.mConfirmPayPass = getPwdConfirm();
            if (this.p == null) {
                this.p = (l) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, "PwdSetAndConfirmActivity");
            }
            this.p.setResponseCallback(this);
            this.p.execBean();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.l.mConfirmPayPass = getPwdConfirm();
            this.l.mRequestType = 3;
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            u uVar = (u) PayBeanFactory.getInstance().getBean((Context) getActivity(), 259, "PwdSetAndConfirmActivity");
            uVar.setResponseCallback(this);
            uVar.execBean();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            int bindFromOrigin = this.m.getBindFromOrigin();
            if (bindFromOrigin == 4) {
                PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.post(new EventBus.Event(eventBus, BeanConstants.EV_BANK_DETAIL_CARD_CHANGE, null));
            } else if (bindFromOrigin != 5) {
                PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
                EventBus eventBus2 = EventBus.getInstance();
                eventBus2.getClass();
                eventBus2.post(new EventBus.Event(eventBus2, BeanConstants.EV_BANK_DETAIL_CARD_CHANGE, null));
            } else {
                PasswordController.getPassWordInstance().setPassByUserSucceed("");
                BaseActivity.clearTasksWithFlag(1);
            }
            if (this.m.mUseNewCardFindPwd && PayRequestCache.getInstance().isPaying()) {
                BaiduPayDelegate.getInstance().reOrderPay(getActivity());
            }
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.f60285e.resetPwd();
            b();
        }
    }

    public String getPwdConfirm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60285e.getPwd() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            k();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if ((i3 == 100038 || (i3 >= 16420 && i3 <= 16439)) && i2 != 12) {
                a(str);
            } else if (i2 == 259) {
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 3, "");
            } else if (i2 == 260) {
                GlobalUtils.toast(getActivity(), str);
            } else if (i2 == 524) {
                int i4 = this.m.mBindFrom;
                if (i4 == 5 || i4 == 4) {
                    GlobalUtils.toast(getActivity(), str);
                }
            } else if (i2 != 13 && i2 != 513) {
                super.handleFailure(i2, i3, str);
            } else {
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 3, "");
                if (i2 == 13) {
                    StatisticManager.onEventWithValue("bindPayAcceptFail", String.valueOf(i3));
                    BindFastRequest bindFastRequest = this.m;
                    if (bindFastRequest != null) {
                        if (bindFastRequest.getmBindFrom() != 0 && this.m.getmBindFrom() != 6) {
                            if (this.m.getmBindFrom() == 2) {
                                StatHelper.cacheCodeAndMsg(i3 + "", str);
                                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, null, new String[0]);
                                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION, null, new String[0]);
                                return;
                            }
                            return;
                        }
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, i3 + "", str);
                        StatHelper.cacheCodeAndMsg(i3 + "", str);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, null, new String[0]);
                        return;
                    }
                    return;
                }
                String sessionId = StatHelper.getSessionId();
                List<String> collectData = StatHelper.collectData(sessionId, i3 + "", str);
                HashMap hashMap = new HashMap();
                hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, collectData, hashMap);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            if (i2 == 259) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PasswordController.getPassWordInstance().editPwdSucceed(getPwdConfirm());
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_modify_success"));
                BaseActivity.clearTasksWithFlag(1);
            } else if (i2 == 260) {
                j();
            } else if (i2 == 524) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                int i3 = this.m.mBindFrom;
                if (i3 == 5) {
                    PasswordController.getPassWordInstance().setPassByUserSucceed("");
                    BaseActivity.clearTasksWithFlag(1);
                } else if (i3 == 4) {
                    PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
                }
            } else if (i2 == 513) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PayRequest payRequest = this.n;
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    PayController.getInstance().bindExtSuccess(this, obj);
                } else {
                    PayController.getInstance().bindSuccess(obj);
                }
                PasswordController.getPassWordInstance().setPassByUserSucceed("");
            } else {
                if (i2 == 13 && (bindFastRequest = this.m) != null) {
                    if (bindFastRequest.getmBindFrom() != 0 && this.m.getmBindFrom() != 6) {
                        if (this.m.getmBindFrom() == 2) {
                            StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, null, new String[0]);
                            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION, null, new String[0]);
                        }
                    } else {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_SUCCESS);
                        StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, null, new String[0]);
                    }
                }
                super.handleResponse(i2, obj, str);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public boolean isBindPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60281a : invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PwdRequest pwdRequest = this.l;
            if (pwdRequest != null && pwdRequest.mFrom == 3) {
                PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            }
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "pwdSetAndConfirmCacel");
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SET_PWD_DURATION, null, new String[0]);
            PasswordController.getPassWordInstance().setPwdFail(-1, "");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            ErrorContentResponse errorContentResponse = (obj == null || !(obj instanceof ErrorContentResponse)) ? null : (ErrorContentResponse) obj;
            if (i3 == 15500) {
                this.mDialogMsg = str;
                this.mErrorContent = (ErrorContentResponse) obj;
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(this, 1, "");
            } else if (i3 == 80320 || i3 == 80321 || i3 == 80326 || i3 == 80327) {
                PayDataCache.getInstance().cleanDetainmentDesc();
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 2, "");
            } else if (i3 == 51000 && errorContentResponse != null && (guidance = errorContentResponse.guidance) != null) {
                this.mGuidance = guidance;
                if (guidance != null) {
                    k();
                    this.mPayErrorCode = i3;
                    this.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(this, 53, "");
                    return;
                }
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            } else {
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagPaySdk();
            setIsShowMultiWindowTips(true);
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("mPwdRequest");
                if (serializable != null && (serializable instanceof PwdRequest)) {
                    this.l = (PwdRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mBindRequest");
                if (serializable2 != null && (serializable2 instanceof BindFastRequest)) {
                    this.m = (BindFastRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("mPayRequest");
                if (serializable3 != null && (serializable3 instanceof PayRequest)) {
                    this.n = (PayRequest) serializable3;
                }
            } else {
                PayRequestCache.BindCategory bindCategory = PayRequestCache.BindCategory.Pwd;
                if (getIntent() != null) {
                    bindCategory = PayRequestCache.BindCategory.from(getIntent().getIntExtra("baidu.wallet.bindcard.category", 0));
                }
                this.m = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(bindCategory.name());
                this.n = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                this.l = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            }
            String string = ResUtils.getString(this, "ebpay_pwd_set_tip");
            String string2 = ResUtils.getString(this, "ebpay_pwd_set_new_sub_tip");
            PwdRequest pwdRequest = this.l;
            if (pwdRequest == null) {
                PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().1");
                return;
            }
            int i2 = pwdRequest.mFrom;
            if (i2 != 2 && i2 != 4) {
                BindFastRequest bindFastRequest = this.m;
                if (bindFastRequest == null) {
                    PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().2");
                    return;
                }
                if (bindFastRequest.isRealPay()) {
                    if (this.n == null) {
                        PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().3");
                        return;
                    }
                    if (!com.baidu.wallet.paysdk.a.b.a() || !com.baidu.wallet.paysdk.a.b.b()) {
                        string = ResUtils.getString(this, "ebpay_pwd_confim_tip_pay");
                    }
                    PayRequestCache.getInstance().addBeanRequestToCache(this.n.getRequestId(), this.n);
                }
                PayRequestCache.getInstance().addBeanRequestToCache(this.m.getRequestId(), this.m);
            }
            PayRequestCache.getInstance().addBeanRequestToCache(this.l.getRequestId(), this.l);
            setContentView(ResUtils.layout(this, "wallet_cashdesk_setandconfirm_pwd_activity"));
            getWindow().setSoftInputMode(2);
            this.j = (SafeScrollView) findViewById(ResUtils.id(this, "scrollview"));
            this.k = (RelativeLayout) findViewById(ResUtils.id(this, "root_view"));
            a(string, string2);
            initActionBar("ebpay_set_phone_paycode");
            setSafeScrollView(this.j);
            BindFastRequest bindFastRequest2 = this.m;
            if (bindFastRequest2 != null && bindFastRequest2.getmBindFrom() == 1) {
                setFlagActiveBindCard();
            }
            PwdRequest pwdRequest2 = this.l;
            if (pwdRequest2 != null && pwdRequest2.mFrom == 4) {
                setFlagAuthFlow();
            }
            StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_PWD_SET_ACTIVITY);
            if (PayRequestCache.getInstance().isPaying()) {
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_SET_PWD_DURATION);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 == 1) {
                return new PromptDialog(getActivity());
            }
            if (i2 == 2) {
                return new PromptDialog(getActivity());
            }
            if (i2 == 18) {
                return new PromptDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans("PwdSetAndConfirmActivity");
            CountDownTimer countDownTimer = this.s;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.s = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, dialog) == null) {
            if (i2 == 1) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.showCloseBtn(false);
                promptDialog.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_wallet_continue_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f60293a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60293a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdSetAndConfirmActivity pwdSetAndConfirmActivity = this.f60293a;
                            pwdSetAndConfirmActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdSetAndConfirmActivity.getActivity(), "ebpay_wallet_continue_pay"));
                            WalletGlobalUtils.safeDismissDialog(this.f60293a, 1);
                            PayController payController = PayController.getInstance();
                            PwdSetAndConfirmActivity pwdSetAndConfirmActivity2 = this.f60293a;
                            payController.updateCardInfoPay(pwdSetAndConfirmActivity2, pwdSetAndConfirmActivity2.mErrorContent);
                        }
                    }
                });
                promptDialog.setNegativeBtn(ResUtils.string(this, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f60294a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60294a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdSetAndConfirmActivity pwdSetAndConfirmActivity = this.f60294a;
                            pwdSetAndConfirmActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdSetAndConfirmActivity.getActivity(), "dxm_ebpay_cancel"));
                            WalletGlobalUtils.safeDismissDialog(this.f60294a, 1);
                        }
                    }
                });
            } else if (i2 == 2) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.mDialogMsg);
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.showCloseBtn(false);
                promptDialog2.hideNegativeButton();
                promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f60295a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60295a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f60295a, 2);
                        }
                    }
                });
            } else if (i2 == 3) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.hideTitle();
                promptDialog3.hideNegativeButton();
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.setPositiveBtn(ResUtils.string(this.mAct, "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f60296a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60296a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f60296a.mAct, 3);
                        }
                    }
                });
            } else if (i2 == 18) {
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(ResUtils.getString(this.mAct, "ebpay_pwd_promotion_message"));
                promptDialog4.setTitleText(ResUtils.getString(this.mAct, "ebpay_pwd_explain"));
                promptDialog4.hideNegativeButton();
                promptDialog4.setPositiveBtn(ResUtils.getString(this.mAct, "ebpay_pwd_close_promotion_dialog"), new View.OnClickListener(this, promptDialog4) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f60297a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f60298b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog4};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60298b = this;
                        this.f60297a = promptDialog4;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f60297a.dismiss();
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 6) {
                StatHelper.statServiceEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
                this.l.mPayPass = getPwdConfirm();
                this.l.mConfirmPayPass = getPwdConfirm();
                c();
            } else if (i2 <= 0 || this.f60282b.getVisibility() != 0) {
            } else {
                b();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("mPwdRequest", this.l);
            BindFastRequest bindFastRequest = this.m;
            if (bindFastRequest != null) {
                bundle.putSerializable("mBindRequest", bindFastRequest);
            }
            PayRequest payRequest = this.n;
            if (payRequest != null) {
                bundle.putSerializable("mPayRequest", payRequest);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (safeKeyBoardEditText = this.f60288h) == null) {
                return;
            }
            safeKeyBoardEditText.requestFocus();
        }
    }

    public void resetPwdConfirm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f60285e.resetPwd();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
            if (z) {
                PayController.getInstance().paySucess(this, payResultContent, i2);
            } else {
                PayController.getInstance().payPaying(this, payResultContent, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.n;
            arrayList.add(payRequest != null ? payRequest.mSpNO : "");
            PayRequest payRequest2 = this.n;
            arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            this.f60282b = findViewById(ResUtils.id(this, "layout_confirm"));
            this.f60283c = (TextView) findViewById(ResUtils.id(this, "pwd_tip_confirm"));
            this.f60284d = (TextView) findViewById(ResUtils.id(this, "pwd_tip_sub"));
            SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box_confirm"));
            this.f60285e = sixNumberPwdView;
            sixNumberPwdView.setShowInputMethod(true);
            this.f60287g = findViewById(ResUtils.id(this, "error_area_confirm"));
            this.f60286f = (TextView) findViewById(ResUtils.id(this, "error_tip_confirm"));
            TextView textView = (TextView) findViewById(ResUtils.id(this, "what_is_pay_password"));
            this.f60289i = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdSetAndConfirmActivity f60290a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60290a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeShowDialog(this.f60290a.mAct, 18, "");
                    }
                }
            });
            b();
            this.f60285e.addSixNumberPwdChangedListenter(this);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f60285e.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.f60288h = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.k, this.j, this.f60282b, false);
            this.f60288h.setGap(20);
            this.f60283c.setText(str);
            this.f60284d.setText(str2);
            this.f60288h.setDisablePast(true);
            this.f60288h.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdSetAndConfirmActivity f60291a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f60292b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60291a = this;
                    this.f60292b = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f60292b) {
                        return;
                    }
                    StatisticManager.onEventWithValues("clickConfirmPwd", this.f60291a.a());
                    this.f60292b = true;
                }
            });
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f60286f.setVisibility(8);
                return;
            }
            this.f60286f.setVisibility(0);
            this.f60286f.setText(str);
        }
    }
}
