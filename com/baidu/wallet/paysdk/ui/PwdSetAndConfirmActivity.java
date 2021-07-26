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
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
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
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.SixNumberPwdView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.n;
import com.baidu.wallet.paysdk.beans.p;
import com.baidu.wallet.paysdk.beans.x;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PwdSetAndConfirmActivity extends PayBaseActivity implements SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f26852a;

    /* renamed from: b  reason: collision with root package name */
    public View f26853b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26854c;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26855e;

    /* renamed from: f  reason: collision with root package name */
    public SixNumberPwdView f26856f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26857g;

    /* renamed from: h  reason: collision with root package name */
    public View f26858h;

    /* renamed from: i  reason: collision with root package name */
    public SafeKeyBoardEditText f26859i;
    public TextView j;
    public SafeScrollView k;
    public RelativeLayout l;
    public PwdRequest m;
    public BindFastRequest n;
    public PayRequest o;
    public p p;
    public n q;
    public y r;
    public com.baidu.wallet.paysdk.beans.b s;
    public CountDownTimer t;
    public final int u;
    public final int v;
    public final int w;

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
        this.f26852a = false;
        this.u = 1;
        this.v = 2;
        this.w = 18;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f26857g.setVisibility(8);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f26852a = false;
            int i2 = this.m.mFrom;
            if (i2 != 0) {
                if (i2 == 2) {
                    i();
                    return;
                }
                return;
            }
            switch (this.n.getmBindFrom()) {
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
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f26852a = true;
            PayRequest payRequest = this.o;
            PayStatisticsUtil.onEventWithValue(StatServiceEvent.BIND_CLICK_PAY, payRequest != null ? payRequest.mSpNO : "");
            StatisticManager.onEventStart(StatServiceEvent.TIME_PAY);
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (this.r == null) {
                this.r = (y) PayBeanFactory.getInstance().getBean((Context) getActivity(), 13, "PwdSetAndConfirmActivity");
            }
            this.r.setResponseCallback(this);
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            this.r.execBean();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (this.r == null) {
                this.r = (y) PayBeanFactory.getInstance().getBean((Context) this, 13, "PwdSetAndConfirmActivity");
            }
            this.r.setResponseCallback(this);
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(3);
            this.r.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (this.s == null) {
                this.s = (com.baidu.wallet.paysdk.beans.b) PayBeanFactory.getInstance().getBean((Context) getActivity(), 513, "PwdSetAndConfirmActivity");
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.BIND_CARD);
            this.s.a(this.n);
            this.s.setResponseCallback(this);
            this.s.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            this.m.mConfirmPayPass = getPwdConfirm();
            if (this.p == null) {
                this.p = (p) PayBeanFactory.getInstance().getBean((Context) getActivity(), 260, "PwdSetAndConfirmActivity");
            }
            int bindFromOrigin = this.n.getBindFromOrigin();
            PayStatisticsUtil.onEventStart((bindFromOrigin == 4 || bindFromOrigin == 5) ? StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD : StatServiceEvent.FIND_PASSWORD);
            this.p.a(this.n);
            this.p.setResponseCallback(this);
            this.p.execBean();
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            this.m.mConfirmPayPass = getPwdConfirm();
            if (this.q == null) {
                this.q = (n) PayBeanFactory.getInstance().getBean((Context) getActivity(), PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, "PwdSetAndConfirmActivity");
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD);
            this.q.setResponseCallback(this);
            this.q.execBean();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.m.mConfirmPayPass = getPwdConfirm();
            this.m.mRequestType = 3;
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            x xVar = (x) PayBeanFactory.getInstance().getBean((Context) getActivity(), 259, "PwdSetAndConfirmActivity");
            PayStatisticsUtil.onEventStart(StatServiceEvent.MODIFY_PASSWORD);
            xVar.setResponseCallback(this);
            xVar.execBean();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            int bindFromOrigin = this.n.getBindFromOrigin();
            if (bindFromOrigin == 4) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD, 0);
                PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
                EventBus eventBus = EventBus.getInstance();
                eventBus.getClass();
                eventBus.post(new EventBus.Event(eventBus, BeanConstants.EV_BANK_DETAIL_CARD_CHANGE, null));
            } else if (bindFromOrigin != 5) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD, 0);
                PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
                EventBus eventBus2 = EventBus.getInstance();
                eventBus2.getClass();
                eventBus2.post(new EventBus.Event(eventBus2, BeanConstants.EV_BANK_DETAIL_CARD_CHANGE, null));
            } else {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.COMPLETE_CARD, 0);
                PasswordController.getPassWordInstance().setPassByUserSucceed("");
                BaseActivity.clearTasksWithFlag(1);
            }
            if (this.n.mUseNewCardFindPwd && PayRequestCache.getInstance().isPaying()) {
                BaiduPayDelegate.getInstance().reOrderPay(getActivity());
            }
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f26856f.resetPwd();
            b();
        }
    }

    public String getPwdConfirm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26856f.getPwd() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            k();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if ((i3 == 100038 || (i3 >= 16420 && i3 <= 16439)) && i2 != 12) {
                a(str);
                return;
            }
            String str2 = "";
            if (i2 == 259) {
                PayStatisticsUtil.onEventEnd(StatServiceEvent.MODIFY_PASSWORD, i3);
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 3, "");
            } else if (i2 == 260) {
                a(i3, str);
            } else if (i2 == 524) {
                int i4 = this.n.mBindFrom;
                if (i4 == 5) {
                    GlobalUtils.toast(getActivity(), str);
                    str2 = StatServiceEvent.COMPLETE_CARD;
                } else if (i4 == 4) {
                    GlobalUtils.toast(getActivity(), str);
                    str2 = StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD;
                }
                PayStatisticsUtil.onEventEnd(str2, i3);
            } else if (i2 != 13 && i2 != 513) {
                super.handleFailure(i2, i3, str);
            } else {
                this.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this, 3, "");
                if (i2 == 13) {
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.BIND_PAY_ACCEPT_FAIL, String.valueOf(i3));
                    BindFastRequest bindFastRequest = this.n;
                    if (bindFastRequest != null) {
                        if (bindFastRequest.getmBindFrom() == 0 || this.n.getmBindFrom() == 6) {
                            String orderNo = StatHelper.getOrderNo();
                            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(orderNo, i3 + "", str));
                            return;
                        }
                        return;
                    }
                    return;
                }
                String sessionId = StatHelper.getSessionId();
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(sessionId, i3 + "", str));
                PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, i3);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            if (i2 == 259) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PasswordController.getPassWordInstance().editPwdSucceed(getPwdConfirm());
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_modify_success"));
                PayStatisticsUtil.onEventEnd(StatServiceEvent.MODIFY_PASSWORD, 0);
                BaseActivity.clearTasksWithFlag(1);
            } else if (i2 == 260) {
                j();
            } else if (i2 == 524) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                int i3 = this.n.mBindFrom;
                if (i3 == 5) {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.COMPLETE_CARD, 0);
                    PasswordController.getPassWordInstance().setPassByUserSucceed("");
                    BaseActivity.clearTasksWithFlag(1);
                } else if (i3 == 4) {
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD, 0);
                    PasswordController.getPassWordInstance().setPwdSucceed(getPwdConfirm());
                }
            } else if (i2 == 513) {
                WalletGlobalUtils.safeDismissDialog(this, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, 0);
                PayRequest payRequest = this.o;
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    PayController.getInstance().bindExtSuccess(this, obj);
                } else {
                    PayController.getInstance().bindSuccess(obj);
                }
                PasswordController.getPassWordInstance().setPassByUserSucceed("");
            } else {
                if (i2 == 13 && (bindFastRequest = this.n) != null && (bindFastRequest.getmBindFrom() == 0 || this.n.getmBindFrom() == 6)) {
                    StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_SUCCESS, StatHelper.getOrderNo());
                }
                super.handleResponse(i2, obj, str);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public boolean isBindPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26852a : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            PwdRequest pwdRequest = this.m;
            if (pwdRequest != null && pwdRequest.mFrom == 3) {
                PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            }
            PasswordController.getPassWordInstance().setPwdFail(-1, "");
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagPaySdk();
            setIsShowMultiWindowTips(true);
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("mPwdRequest");
                if (serializable != null && (serializable instanceof PwdRequest)) {
                    this.m = (PwdRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mBindRequest");
                if (serializable2 != null && (serializable2 instanceof BindFastRequest)) {
                    this.n = (BindFastRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("mPayRequest");
                if (serializable3 != null && (serializable3 instanceof PayRequest)) {
                    this.o = (PayRequest) serializable3;
                }
            } else {
                PayRequestCache.BindCategory bindCategory = PayRequestCache.BindCategory.Pwd;
                if (getIntent() != null) {
                    bindCategory = PayRequestCache.BindCategory.from(getIntent().getIntExtra(com.baidu.wallet.api.Constants.BDL_KEY_BINDCATEGORY, 0));
                }
                this.n = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(bindCategory.name());
                this.o = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                this.m = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            }
            String string = ResUtils.getString(this, "ebpay_pwd_set_tip");
            String string2 = ResUtils.getString(this, "ebpay_pwd_set_new_sub_tip");
            PwdRequest pwdRequest = this.m;
            if (pwdRequest == null) {
                PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().1");
                return;
            }
            int i2 = pwdRequest.mFrom;
            if (i2 != 2 && i2 != 4) {
                BindFastRequest bindFastRequest = this.n;
                if (bindFastRequest == null) {
                    PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().2");
                    return;
                }
                if (bindFastRequest.isRealPay()) {
                    if (this.o == null) {
                        PayCallBackManager.callBackClientCancel(this, "PwdSetAndConfirmActivityonCreate().3");
                        return;
                    }
                    if (!com.baidu.wallet.paysdk.a.b.a() || !com.baidu.wallet.paysdk.a.b.b()) {
                        string = ResUtils.getString(this, "ebpay_pwd_confim_tip_pay");
                    }
                    PayRequestCache.getInstance().addBeanRequestToCache(this.o.getRequestId(), this.o);
                }
                PayRequestCache.getInstance().addBeanRequestToCache(this.n.getRequestId(), this.n);
            }
            PayRequestCache.getInstance().addBeanRequestToCache(this.m.getRequestId(), this.m);
            setContentView(ResUtils.layout(this, "wallet_cashdesk_setandconfirm_pwd_activity"));
            getWindow().setSoftInputMode(2);
            this.k = (SafeScrollView) findViewById(ResUtils.id(this, "scrollview"));
            this.l = (RelativeLayout) findViewById(ResUtils.id(this, "root_view"));
            a(string, string2);
            initActionBar("ebpay_set_phone_paycode");
            setSafeScrollView(this.k);
            BindFastRequest bindFastRequest2 = this.n;
            if (bindFastRequest2 != null && bindFastRequest2.getmBindFrom() == 1) {
                setFlagActiveBindCard();
            }
            PwdRequest pwdRequest2 = this.m;
            if (pwdRequest2 == null || pwdRequest2.mFrom != 4) {
                return;
            }
            setFlagAuthFlow();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans("PwdSetAndConfirmActivity");
            CountDownTimer countDownTimer = this.t;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.t = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
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
                    public final /* synthetic */ PwdSetAndConfirmActivity f26863a;

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
                        this.f26863a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdSetAndConfirmActivity pwdSetAndConfirmActivity = this.f26863a;
                            pwdSetAndConfirmActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdSetAndConfirmActivity.getActivity(), "ebpay_wallet_continue_pay"));
                            WalletGlobalUtils.safeDismissDialog(this.f26863a, 1);
                            PayController payController = PayController.getInstance();
                            PwdSetAndConfirmActivity pwdSetAndConfirmActivity2 = this.f26863a;
                            payController.updateCardInfoPay(pwdSetAndConfirmActivity2, pwdSetAndConfirmActivity2.mErrorContent);
                        }
                    }
                });
                promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f26864a;

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
                        this.f26864a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdSetAndConfirmActivity pwdSetAndConfirmActivity = this.f26864a;
                            pwdSetAndConfirmActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdSetAndConfirmActivity.getActivity(), "ebpay_cancel"));
                            WalletGlobalUtils.safeDismissDialog(this.f26864a, 1);
                        }
                    }
                });
            } else if (i2 == 2) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.mDialogMsg);
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.showCloseBtn(false);
                promptDialog2.hideNegativeButton();
                promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f26865a;

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
                        this.f26865a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26865a, 2);
                        }
                    }
                });
            } else if (i2 == 3) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.hideTitle();
                promptDialog3.hideNegativeButton();
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.setPositiveBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f26866a;

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
                        this.f26866a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26866a.mAct, 3);
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
                    public final /* synthetic */ PromptDialog f26867a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PwdSetAndConfirmActivity f26868b;

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
                        this.f26868b = this;
                        this.f26867a = promptDialog4;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f26867a.dismiss();
                        }
                    }
                });
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 6) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
                this.m.mPayPass = getPwdConfirm();
                this.m.mConfirmPayPass = getPwdConfirm();
                c();
            } else if (i2 <= 0 || this.f26853b.getVisibility() != 0) {
            } else {
                b();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("mPwdRequest", this.m);
            BindFastRequest bindFastRequest = this.n;
            if (bindFastRequest != null) {
                bundle.putSerializable("mBindRequest", bindFastRequest);
            }
            PayRequest payRequest = this.o;
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
            if (!z || (safeKeyBoardEditText = this.f26859i) == null) {
                return;
            }
            safeKeyBoardEditText.requestFocus();
        }
    }

    public void resetPwdConfirm() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f26856f.resetPwd();
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
            PayRequest payRequest = this.o;
            arrayList.add(payRequest != null ? payRequest.mSpNO : "");
            PayRequest payRequest2 = this.o;
            arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, str, str2) == null) {
            this.f26853b = findViewById(ResUtils.id(this, "layout_confirm"));
            this.f26854c = (TextView) findViewById(ResUtils.id(this, "pwd_tip_confirm"));
            this.f26855e = (TextView) findViewById(ResUtils.id(this, "pwd_tip_sub"));
            SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box_confirm"));
            this.f26856f = sixNumberPwdView;
            sixNumberPwdView.setShowInputMethod(true);
            this.f26858h = findViewById(ResUtils.id(this, "error_area_confirm"));
            this.f26857g = (TextView) findViewById(ResUtils.id(this, "error_tip_confirm"));
            TextView textView = (TextView) findViewById(ResUtils.id(this, "what_is_pay_password"));
            this.j = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdSetAndConfirmActivity f26860a;

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
                    this.f26860a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeShowDialog(this.f26860a.mAct, 18, "");
                    }
                }
            });
            b();
            this.f26856f.addSixNumberPwdChangedListenter(this);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f26856f.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.f26859i = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.l, this.k, this.f26853b, false);
            this.f26859i.setGap(20);
            this.f26854c.setText(str);
            this.f26855e.setText(str2);
            this.f26859i.setDisablePast(true);
            this.f26859i.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.PwdSetAndConfirmActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdSetAndConfirmActivity f26861a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f26862b;

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
                    this.f26861a = this;
                    this.f26862b = false;
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
                    if (!(interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f26862b) {
                        return;
                    }
                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.CLICK_CONFIRM_PWD, this.f26861a.a());
                    this.f26862b = true;
                }
            });
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f26857g.setVisibility(8);
                return;
            }
            this.f26857g.setVisibility(0);
            this.f26857g.setText(str);
        }
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            int bindFromOrigin = this.n.getBindFromOrigin();
            PayStatisticsUtil.onEventEnd(bindFromOrigin != 4 ? bindFromOrigin != 5 ? StatServiceEvent.FIND_PASSWORD : StatServiceEvent.COMPLETE_CARD : StatServiceEvent.FIND_PASSWORD_FROM_OLD_CARD_RESET_PWD, i2);
            GlobalUtils.toast(getActivity(), str);
        }
    }
}
