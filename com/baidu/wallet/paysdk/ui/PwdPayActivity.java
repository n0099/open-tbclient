package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterFactory;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForCashdesk;
import com.baidu.wallet.paysdk.presenter.PwdPayPresenterForScancode;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew;
import com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes13.dex */
public class PwdPayActivity extends HalfScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PwdPayActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public View f54370b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f54371c;

    /* renamed from: d  reason: collision with root package name */
    public View f54372d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f54373e;

    /* renamed from: f  reason: collision with root package name */
    public SafeKeyBoardEditText f54374f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54375g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54376h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54377i;

    /* renamed from: j  reason: collision with root package name */
    public SixNumberPwdView f54378j;

    /* renamed from: k  reason: collision with root package name */
    public PayLoadingImageViewNew f54379k;
    public View l;
    public SuccessImageViewNew m;
    public PwdPayContract.Presenter mPresenter;
    public PwdRequest n;
    public boolean o;
    public boolean p;
    public boolean q;
    public AtomicBoolean r;
    public boolean s;
    public View t;
    public CheckBox u;
    public TextView v;
    public boolean w;
    public int x;

    public PwdPayActivity() {
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
        this.r = new AtomicBoolean(false);
        this.s = false;
        this.w = true;
        this.x = 4;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_pwd_pay_layout"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    public void dismissLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mActionBar.setVisibility(0);
            this.o = false;
            this.f54373e.setVisibility(0);
            this.f54373e.dismissKeyBoard(this.f54374f);
            this.f54379k.stopAnimation();
            this.f54379k.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void doLivingPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PwdPayContract.Presenter presenter = this.mPresenter;
            if (presenter instanceof PwdPayPresenterForCashdesk) {
                ((PwdPayPresenterForCashdesk) presenter).doPay();
            }
        }
    }

    public void doVerifyFingerprint(IFingerprintPay iFingerprintPay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iFingerprintPay) == null) {
            this.f54378j.resetPwd();
            PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            this.n = pwdRequest;
            if (pwdRequest != null) {
                pwdRequest.mPayPass = null;
                pwdRequest.mConfirmPayPass = null;
            }
            if (this.r.compareAndSet(false, true)) {
                setPageTransparent(true);
            }
            if (iFingerprintPay == null) {
                GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
                return;
            }
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION);
            iFingerprintPay.verify(getActivity(), new FingerprintCallback(this, iFingerprintPay) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PwdPayActivity this$0;
                public final /* synthetic */ IFingerprintPay val$mFingerprintPay;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iFingerprintPay};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$mFingerprintPay = iFingerprintPay;
                }

                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, action, i2, str) == null) {
                        this.this$0.r.set(false);
                        if (action == IFingerprintPay.Action.VERIFY) {
                            if (i2 == 0) {
                                StatHelper.cacheCodeAndMsg(i2 + "", StatHelper.SENSOR_OK);
                            } else {
                                StatHelper.cacheCodeAndMsg(i2 + "", str);
                            }
                            if (i2 == 0) {
                                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, null, new String[0]);
                                this.this$0.mPresenter.onFPCheckOK(str);
                            } else if (i2 == 1) {
                                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, null, new String[0]);
                                this.this$0.mPresenter.onFPCheckCancel();
                            } else if (i2 == 3) {
                                this.this$0.turntoPwdPay(false, null);
                            } else {
                                this.this$0.turntoPwdPay(true, str);
                            }
                        }
                        this.val$mFingerprintPay.destory();
                    }
                }
            });
        }
    }

    public void forgetPassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f54378j.resetPwd();
            String findPayPwdUrl = SdkInitResponse.getInstance().getFindPayPwdUrl(getActivity());
            if (TextUtils.isEmpty(findPayPwdUrl)) {
                findPayPwdUrl = BeanConstants.API_FIND_PAY_PWD_URL;
            }
            BaiduWalletDelegate.getInstance().openH5Module(getActivity(), findPayPwdUrl, false);
            this.s = true;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mPresenter.handleActivityError();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) {
            if (i2 != 12) {
                dismissLoading(-1);
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, obj, str) == null) {
            PwdPayContract.Presenter presenter = this.mPresenter;
            if ((presenter instanceof PwdPayPresenterForScancode) && i2 == 12) {
                presenter.handleResponse(i2, obj, str);
            }
            super.handleResponse(i2, obj, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void hideFullScreenLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PwdPayContract.Presenter presenter = this.mPresenter;
            if ((presenter instanceof PwdPayPresenterForCashdesk) && ((PwdPayPresenterForCashdesk) presenter).shouldFullScreenLoading()) {
                showLikeDismissLadingPage();
            }
        }
    }

    public boolean isGatewaySignPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.o && this.mPresenter.directQuit()) {
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "pwdPayCancel");
            if (this.p) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
            } else if (com.baidu.wallet.paysdk.a.b.a()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, StatHelper.SENSOR_ERR_2, "authorizeBindCardCancel");
                StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "authorizeBindCardCancel");
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            dismissLoading(-1);
            this.f54378j.resetPwd();
            if (this.mPresenter.onBeanExecFailureWithErrContent(i2, i3, str, obj)) {
                return;
            }
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (view == this.f54372d) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
                forgetPassword();
            } else if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view == this.mRightTxt) {
                this.mPresenter.pwdAndFpTypeChange();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            getActivity().getWindow().setSoftInputMode(2);
            if (bundle == null) {
                Intent intent = this.mAct.getIntent();
                if (intent != null) {
                    this.x = intent.getIntExtra(PwdPayPresenterFactory.PWDPAYACTIVITY_FROM_KEY, -1);
                    this.q = intent.getBooleanExtra("gatewaySign", false);
                    this.p = intent.getBooleanExtra("IS_FOR_BIND_CARD_PAY", false);
                }
            } else {
                this.x = bundle.getInt("forwhat");
                this.q = bundle.getBoolean("gatewaySign", false);
                this.p = bundle.getBoolean("isforBindCardPay", false);
            }
            b();
            PwdPayContract.Presenter a = PwdPayPresenterFactory.a(this.x, this);
            this.mPresenter = a;
            if (a == null) {
                PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonCreate().1");
                return;
            }
            a.onCreate(bundle);
            if (bundle != null) {
                this.o = bundle.getBoolean("isloading");
                this.p = bundle.getBoolean("isforBindCardPay");
            }
            EventBus.getInstance().register(this, BeanConstants.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
            StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_PWD_PAY_ACTIVITY);
            if (PayRequestCache.getInstance().isPaying()) {
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                if (payRequest != null && payRequest.getPayWay() == 3) {
                    this.w = true;
                } else {
                    this.w = false;
                }
                if (this.w) {
                    StatisticManager.onEventStart(PayStatServiceEvent.PAY_CHECK_PWD_DURATION);
                }
            }
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            if (this.w) {
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_PWD_DURATION, null, new String[0]);
            }
            BeanManager.getInstance().removeAllBeans(TAG);
            if (this.s) {
                PasswordController.getPassWordInstance().clearForgetPasswdCallback();
            }
            PwdPayContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onDestroy();
            }
            this.mPresenter = null;
            EventBus.getInstance().unregister(this);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, event) == null) {
            if (event != null && BeanConstants.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
                if (event.mEventObj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                        if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                            if (this.n != null) {
                                PayRequestCache.getInstance().addBeanRequestToCache(this.n.getRequestId(), this.n);
                            }
                            if (this.f54371c != null) {
                                this.f54371c.setVisibility(8);
                            }
                            int i2 = 0;
                            try {
                                i2 = jSONObject.getInt("is_bind_card");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (1 == i2 && PayRequestCache.getInstance().isPaying() && this.f54371c != null) {
                                this.f54371c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.6
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ PwdPayActivity a;

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
                                        this.a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            BaseActivity.clearTasksTopOf(this.a);
                                            BaiduPayDelegate.getInstance().reOrderPay(this.a.getActivity());
                                        }
                                    }
                                }, 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            super.onModuleEvent(event);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onNegativeBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            PwdPayContract.Presenter presenter = this.mPresenter;
            if (presenter != null && presenter.dialogNevigateOper_QuitCashDesk()) {
                PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonNegativeBtnClick().1");
                return;
            }
            PwdPayContract.Presenter presenter2 = this.mPresenter;
            if (presenter2 == null || !presenter2.dialogNevigateOper_QuitCurrentPage()) {
                return;
            }
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, dialog) == null) {
            if (i2 == 12) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.a, 12);
                            this.a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog.hideNegativeButton();
            } else if (i2 == 17) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.mDialogMsg);
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_find_password"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_find_password"));
                            StatisticManager.onEvent(StatServiceEvent.EVENT_FIND_PWD_FROM_PWD_OVER_LIMIT);
                            WalletGlobalUtils.safeDismissDialog(this.a, 17);
                            this.a.d();
                            this.a.forgetPassword();
                        }
                    }
                });
                promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "dxm_ebpay_know"));
                            StatisticManager.onEvent(StatServiceEvent.EVENT_IGNOREPWD_OVER_LIMIT);
                            WalletGlobalUtils.safeDismissDialog(this.a, 17);
                            this.a.d();
                        }
                    }
                });
            } else if (i2 == 36) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.setNegativeBtn(ResUtils.getString(this, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.a, 36);
                            this.a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.a, 36);
                            PayController.getInstance().gotoPayTypePage(this.a, false);
                            this.a.finishWithoutAnim();
                        }
                    }
                });
            } else if (i2 != 37) {
                super.onPrepareDialog(i2, dialog);
            } else {
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(this.mDialogMsg);
                promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "dxm_ebpay_know"));
                            WalletGlobalUtils.safeDismissDialog(this.a, 37);
                            this.a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog4.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_use_other_paytype"));
                            WalletGlobalUtils.safeDismissDialog(this.a, 37);
                            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                            if (payRequest != null) {
                                payRequest.clearMktSolution();
                            }
                            PayController.getInstance().gotoPayTypePage(this.a, false);
                            this.a.finishWithoutAnim();
                        }
                    }
                });
            }
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 == 6) {
                StatHelper.statServiceEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
                this.mPresenter.onPwdChanged(this.f54378j.getPwd());
                return;
            }
            this.f54371c.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            bundle.putSerializable("isloading", Boolean.valueOf(this.o));
            bundle.putSerializable("pwdrequest", this.n);
            bundle.putSerializable("isforBindCardPay", Boolean.valueOf(this.p));
            bundle.putSerializable("gatewaySign", Boolean.valueOf(this.q));
            bundle.putSerializable("forwhat", Integer.valueOf(this.x));
            this.mPresenter.onSaveInstanceState(bundle);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)) == null || payRequest.getPayWay() != 3 || this.f54374f == null || payRequest.isPayByMktSolution) {
                return;
            }
            PayLoadingImageViewNew payLoadingImageViewNew = this.f54379k;
            if (payLoadingImageViewNew == null || payLoadingImageViewNew.getVisibility() != 0) {
                this.f54374f.requestFocus();
            }
        }
    }

    public void reFreshUI(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, obj) == null) {
        }
    }

    public void rightTextShow(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048598, this, z, str) == null) {
            if (z) {
                this.mRightTxt.setVisibility(0);
                this.mRightTxt.setOnClickListener(this);
                if (str != null) {
                    this.mRightTxt.setText(str);
                }
                this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_base_primary_color"));
                return;
            }
            this.mRightTxt.setVisibility(8);
        }
    }

    public void setErrorArea(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f54370b.setVisibility(z ? 0 : 8);
        }
    }

    public void setErrorTips(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048600, this, z, str) == null) {
            this.f54371c.setVisibility(z ? 0 : 8);
            if (str != null) {
                this.f54371c.setText(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(PwdPayContract.Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, presenter) == null) {
        }
    }

    public void setTitleText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f54375g.setText(str);
    }

    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.mActionBar.setVisibility(4);
            this.o = true;
            this.f54373e.setVisibility(8);
            this.f54373e.dismissKeyBoard(this.f54374f);
            this.f54379k.setVisibility(0);
            this.f54379k.startAnimation();
        }
    }

    public void showPWdInputView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                this.f54373e.setVisibility(0);
                this.f54378j.resetPwd();
                return;
            }
            this.f54373e.setVisibility(8);
            this.f54373e.dismissKeyBoard(this.f54374f);
        }
    }

    public void showPassError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f54370b.setVisibility(0);
            if (!TextUtils.isEmpty(str)) {
                this.f54371c.setText(str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f54371c.setVisibility(0);
            } else {
                this.f54371c.setVisibility(8);
            }
            this.f54372d.setVisibility(0);
            this.f54374f.initSafeKeyBoardParams(this.a, this.f54373e, this.f54378j, true);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
            PwdPayContract.Presenter presenter = this.mPresenter;
            if (presenter != null && !presenter.showSucAnim()) {
                if (z) {
                    PayController.getInstance().paySucess(this, payResultContent, 1);
                    return;
                } else {
                    PayController.getInstance().payPaying(this, payResultContent, 1);
                    return;
                }
            }
            dismissLoading(-1);
            this.o = true;
            this.mActionBar.setVisibility(4);
            this.f54373e.setVisibility(8);
            this.l.setVisibility(0);
            this.m.startAnimation(new SuccessImageViewNew.a(this, z, payResultContent, i2) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayResultContent f54381b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f54382c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PwdPayActivity f54383d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54383d = this;
                    this.a = z;
                    this.f54381b = payResultContent;
                    this.f54382c = i2;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.a) {
                            PayController.getInstance().paySucess(this.f54383d, this.f54381b, this.f54382c);
                        } else {
                            PayController.getInstance().payPaying(this.f54383d, this.f54381b, this.f54382c);
                        }
                    }
                }
            });
        }
    }

    public void showWarningTips(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f54376h.setText(str);
        this.f54376h.setVisibility(0);
    }

    public void turntoPwdPay(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048609, this, z, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", StatHelper.getPayFrom());
            ArrayList arrayList = new ArrayList();
            arrayList.add(StatHelper.getOrderNo());
            hashMap.put(StatHelper.PAY_WAY, "0");
            StatisticManager.onEventWithValues(PayStatServiceEvent.CHANGE_PAY_WAY, arrayList, hashMap);
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_CHECK_FINGERPRINT_DURATION, null, new String[0]);
            this.mPresenter.onTurntoPwdPay(z);
            showLikeLoadingPage(false);
            showWarningTips(str);
            a();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mActionBar.setVisibility(0);
            this.a = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "ebpay_pwdpay_layout"));
            SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
            this.f54373e = safeScrollView;
            safeScrollView.setVisibility(0);
            setSafeScrollView(this.f54373e);
            this.f54375g = (TextView) findViewById(ResUtils.id(this, "ebpay_pwd_title"));
            TextView textView = (TextView) findViewById(ResUtils.id(this, "warning_tips"));
            this.f54376h = textView;
            textView.setVisibility(4);
            SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box"));
            this.f54378j = sixNumberPwdView;
            sixNumberPwdView.setShowInputMethod(true);
            this.f54378j.addSixNumberPwdChangedListenter(this);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f54378j.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.f54374f = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.a, this.f54373e, this.f54378j, false);
            this.f54374f.setDisablePast(true);
            this.f54374f.setGap(20);
            View findViewById = findViewById(ResUtils.id(this, "bd_wallet_pwd_error_layout"));
            this.f54370b = findViewById;
            findViewById.setVisibility(0);
            TextView textView2 = (TextView) findViewById(ResUtils.id(this, "error_tip"));
            this.f54371c = textView2;
            textView2.setVisibility(8);
            View findViewById2 = findViewById(ResUtils.id(this, "forget_pwd"));
            this.f54372d = findViewById2;
            findViewById2.setVisibility(0);
            this.f54372d.setOnClickListener(this);
            PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
            this.f54379k = payLoadingImageViewNew;
            payLoadingImageViewNew.setVisibility(8);
            View findViewById3 = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
            this.l = findViewById3;
            findViewById3.setVisibility(8);
            this.m = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
            this.mLeftImg.setOnClickListener(this);
            this.t = findViewById(ResUtils.id(this, "protocol_display_area"));
            this.u = (CheckBox) findViewById(ResUtils.id(this, "ebpay_protocol"));
            this.v = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_text"));
            this.f54377i = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_msg"));
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            PwdPayContract.protocolModel needshowProtocolContainer = this.mPresenter.needshowProtocolContainer();
            if (needshowProtocolContainer != null && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_msg) && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_prefix) && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_url)) {
                this.v.setText(needshowProtocolContainer.passfree_protocol_prefix);
                this.f54377i.setText(needshowProtocolContainer.passfree_protocol_msg);
                this.f54377i.setOnClickListener(new View.OnClickListener(this, needshowProtocolContainer) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayContract.protocolModel a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f54380b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, needshowProtocolContainer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54380b = this;
                        this.a = needshowProtocolContainer;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BaiduWalletDelegate.getInstance().openH5Module(this.f54380b, this.a.passfree_protocol_url, false);
                        }
                    }
                });
                this.u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, needshowProtocolContainer) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayContract.protocolModel a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f54384b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, needshowProtocolContainer};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54384b = this;
                        this.a = needshowProtocolContainer;
                    }

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                            this.a.iClickCallback.onProtocolClicked(z);
                        }
                    }
                });
                this.u.setChecked(needshowProtocolContainer.checked);
                this.f54371c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PwdPayActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.a.f54371c.getVisibility() == 0) {
                                this.a.t.setVisibility(8);
                            } else {
                                this.a.t.setVisibility(0);
                            }
                        }
                    }
                });
                this.t.setVisibility(0);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f54370b.setVisibility(0);
            this.f54371c.setVisibility(8);
            this.f54372d.setVisibility(0);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c();
        }
    }
}
