package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
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
import com.baidu.wallet.api.BaiduWalletDelegate;
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
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.lollipop.json.JSONObject;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
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
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class PwdPayActivity extends HalfScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PwdPayActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f26559a;

    /* renamed from: b  reason: collision with root package name */
    public View f26560b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26561c;

    /* renamed from: e  reason: collision with root package name */
    public View f26562e;

    /* renamed from: f  reason: collision with root package name */
    public SafeScrollView f26563f;

    /* renamed from: g  reason: collision with root package name */
    public SafeKeyBoardEditText f26564g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26565h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26566i;
    public TextView j;
    public SixNumberPwdView k;
    public PayLoadingImageViewNew l;
    public View m;
    public PwdPayContract.Presenter mPresenter;
    public SuccessImageViewNew n;
    public PwdRequest o;
    public boolean p;
    public boolean q;
    public boolean r;
    public AtomicBoolean s;
    public boolean t;
    public View u;
    public CheckBox v;
    public TextView w;
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
        this.s = new AtomicBoolean(false);
        this.t = false;
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
            this.p = false;
            this.f26563f.setVisibility(0);
            this.f26563f.dismissKeyBoard(this.f26564g);
            this.l.stopAnimation();
            this.l.setVisibility(8);
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
            this.k.resetPwd();
            PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
            this.o = pwdRequest;
            if (pwdRequest != null) {
                pwdRequest.mPayPass = null;
                pwdRequest.mConfirmPayPass = null;
            }
            if (this.s.compareAndSet(false, true)) {
                setPageTransparent(true);
            }
            if (iFingerprintPay == null) {
                GlobalUtils.toast(this.mAct, "手机不支持指纹支付", 1);
            } else {
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
                            this.this$0.s.set(false);
                            if (action == IFingerprintPay.Action.VERIFY) {
                                if (i2 == 0) {
                                    this.this$0.mPresenter.onFPCheckOK(str);
                                } else if (i2 == 1) {
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
    }

    public void forgetPassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k.resetPwd();
            BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.getInstance();
            Activity activity = getActivity();
            baiduWalletDelegate.openH5Module(activity, DomainConfig.getInstance().getMHost() + BeanConstants.API_FIND_PASS, false);
            this.t = true;
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mPresenter.handleActivityError();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) {
            if (i2 != 12) {
                dismissLoading(-1);
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.p && this.mPresenter.directQuit()) {
            if (this.q) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getOrderNo(), "-2", "payBindCardCancel"));
            } else if (com.baidu.wallet.paysdk.a.b.a()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(StatHelper.getOrderNo(), "-2", "authorizeBindCardCancel"));
            }
            super.onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            dismissLoading(-1);
            this.k.resetPwd();
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
            if (view == this.f26562e) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
                forgetPassword();
            } else if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view == this.mRightTxt) {
                this.mPresenter.pwdAndFpTypeChange();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
                    this.r = intent.getBooleanExtra("gatewaySign", false);
                    this.q = intent.getBooleanExtra("IS_FOR_BIND_CARD_PAY", false);
                }
            } else {
                this.x = bundle.getInt("forwhat");
                this.r = bundle.getBoolean("gatewaySign", false);
                this.q = bundle.getBoolean("isforBindCardPay", false);
            }
            b();
            PwdPayContract.Presenter a2 = PwdPayPresenterFactory.a(this.x, this);
            this.mPresenter = a2;
            if (a2 == null) {
                PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonCreate().1");
                return;
            }
            a2.onCreate(bundle);
            if (bundle != null) {
                this.p = bundle.getBoolean("isloading");
                this.q = bundle.getBoolean("isforBindCardPay");
            }
            EventBus.getInstance().register(this, BankCardListActivity.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
            a();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(TAG);
            if (this.t) {
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
            if (event != null && BankCardListActivity.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
                if (event.mEventObj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                        if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                            if (this.o != null) {
                                PayRequestCache.getInstance().addBeanRequestToCache(this.o.getRequestId(), this.o);
                            }
                            if (this.f26561c != null) {
                                this.f26561c.setVisibility(8);
                            }
                            int i2 = 0;
                            try {
                                i2 = jSONObject.getInt("is_bind_card");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (1 == i2 && PayRequestCache.getInstance().isPaying() && this.f26561c != null) {
                                this.f26561c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.6
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ PwdPayActivity f26579a;

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
                                        this.f26579a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            BaseActivity.clearTasksTopOf(this.f26579a);
                                            BaiduPayDelegate.getInstance().reOrderPay(this.f26579a.getActivity());
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
            if (this.mPresenter.dialogNevigateOper_QuitCashDesk()) {
                PayCallBackManager.callBackClientCancel(this, "PwdPayActivityonNegativeBtnClick().1");
            } else if (this.mPresenter.dialogNevigateOper_QuitCurrentPage()) {
                finishWithoutAnim();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, dialog) == null) {
            if (i2 == 12) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26583a;

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
                        this.f26583a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26583a, 12);
                            this.f26583a.onNegativeBtnClick();
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

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26573a;

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
                        this.f26573a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.f26573a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_find_password"));
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FIND_PWD_FROM_PWD_OVER_LIMIT);
                            WalletGlobalUtils.safeDismissDialog(this.f26573a, 17);
                            this.f26573a.d();
                            this.f26573a.forgetPassword();
                        }
                    }
                });
                promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26574a;

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
                        this.f26574a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.f26574a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_know"));
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_IGNOREPWD_OVER_LIMIT);
                            WalletGlobalUtils.safeDismissDialog(this.f26574a, 17);
                            this.f26574a.d();
                        }
                    }
                });
            } else if (i2 == 36) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.setNegativeBtn(ResUtils.getString(this, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26571a;

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
                        this.f26571a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26571a, 36);
                            this.f26571a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog3.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26572a;

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
                        this.f26572a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26572a, 36);
                            PayController.getInstance().gotoPayTypePage(this.f26572a, false);
                            this.f26572a.finishWithoutAnim();
                        }
                    }
                });
            } else if (i2 != 37) {
                super.onPrepareDialog(i2, dialog);
            } else {
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(this.mDialogMsg);
                promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26569a;

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
                        this.f26569a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.f26569a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_know"));
                            WalletGlobalUtils.safeDismissDialog(this.f26569a, 37);
                            this.f26569a.onNegativeBtnClick();
                        }
                    }
                });
                promptDialog4.setPositiveBtn(ResUtils.getString(this, "ebpay_use_other_paytype"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26570a;

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
                        this.f26570a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PwdPayActivity pwdPayActivity = this.f26570a;
                            pwdPayActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdPayActivity.getActivity(), "ebpay_use_other_paytype"));
                            WalletGlobalUtils.safeDismissDialog(this.f26570a, 37);
                            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                            if (payRequest != null) {
                                payRequest.clearMktSolution();
                            }
                            PayController.getInstance().gotoPayTypePage(this.f26570a, false);
                            this.f26570a.finishWithoutAnim();
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.SixNumberPwdView.OnPwdChangedListener
    public void onPwdChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 == 6) {
                PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
                this.mPresenter.onPwdChanged(this.k.getPwd());
                return;
            }
            this.f26561c.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            bundle.putSerializable("isloading", Boolean.valueOf(this.p));
            bundle.putSerializable("pwdrequest", this.o);
            bundle.putSerializable("isforBindCardPay", Boolean.valueOf(this.q));
            bundle.putSerializable("gatewaySign", Boolean.valueOf(this.r));
            bundle.putSerializable("forwhat", Integer.valueOf(this.x));
            this.mPresenter.onSaveInstanceState(bundle);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        PayRequest payRequest;
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)) == null || payRequest.getPayWay() != 3 || (safeKeyBoardEditText = this.f26564g) == null) {
                return;
            }
            safeKeyBoardEditText.requestFocus();
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
            this.f26560b.setVisibility(z ? 0 : 8);
        }
    }

    public void setErrorTips(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048600, this, z, str) == null) {
            this.f26561c.setVisibility(z ? 0 : 8);
            if (str != null) {
                this.f26561c.setText(str);
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
        this.f26565h.setText(str);
    }

    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.mActionBar.setVisibility(4);
            this.p = true;
            this.f26563f.setVisibility(8);
            this.f26563f.dismissKeyBoard(this.f26564g);
            this.l.setVisibility(0);
            this.l.startAnimation();
        }
    }

    public void showPWdInputView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            if (z) {
                this.f26563f.setVisibility(0);
                this.k.resetPwd();
                return;
            }
            this.f26563f.setVisibility(8);
            this.f26563f.dismissKeyBoard(this.f26564g);
        }
    }

    public void showPassError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f26560b.setVisibility(0);
            if (!TextUtils.isEmpty(str)) {
                this.f26561c.setText(str);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f26561c.setVisibility(0);
            } else {
                this.f26561c.setVisibility(8);
            }
            this.f26562e.setVisibility(0);
            this.f26564g.initSafeKeyBoardParams(this.f26559a, this.f26563f, this.k, true);
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
            this.p = true;
            this.mActionBar.setVisibility(4);
            this.f26563f.setVisibility(8);
            this.m.setVisibility(0);
            this.n.startAnimation(new SuccessImageViewNew.a(this, z, payResultContent, i2) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f26575a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PayResultContent f26576b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f26577c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ PwdPayActivity f26578d;

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
                    this.f26578d = this;
                    this.f26575a = z;
                    this.f26576b = payResultContent;
                    this.f26577c = i2;
                }

                @Override // com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f26575a) {
                            PayController.getInstance().paySucess(this.f26578d, this.f26576b, this.f26577c);
                        } else {
                            PayController.getInstance().payPaying(this.f26578d, this.f26576b, this.f26577c);
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
        this.f26566i.setText(str);
        this.f26566i.setVisibility(0);
    }

    public void turntoPwdPay(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048609, this, z, str) == null) {
            this.mPresenter.onTurntoPwdPay(z);
            showLikeLoadingPage(false);
            showWarningTips(str);
            a();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mActionBar.setVisibility(0);
            this.f26559a = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "ebpay_pwdpay_layout"));
            SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
            this.f26563f = safeScrollView;
            safeScrollView.setVisibility(0);
            setSafeScrollView(this.f26563f);
            this.f26565h = (TextView) findViewById(ResUtils.id(this, "ebpay_pwd_title"));
            TextView textView = (TextView) findViewById(ResUtils.id(this, "warning_tips"));
            this.f26566i = textView;
            textView.setVisibility(4);
            SixNumberPwdView sixNumberPwdView = (SixNumberPwdView) findViewById(ResUtils.id(this, "pwd_input_box"));
            this.k = sixNumberPwdView;
            sixNumberPwdView.setShowInputMethod(true);
            this.k.addSixNumberPwdChangedListenter(this);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.k.findViewById(ResUtils.id(getActivity(), "pwd_input"));
            this.f26564g = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.f26559a, this.f26563f, this.k, false);
            this.f26564g.setDisablePast(true);
            this.f26564g.setGap(20);
            View findViewById = findViewById(ResUtils.id(this, "bd_wallet_pwd_error_layout"));
            this.f26560b = findViewById;
            findViewById.setVisibility(0);
            TextView textView2 = (TextView) findViewById(ResUtils.id(this, "error_tip"));
            this.f26561c = textView2;
            textView2.setVisibility(8);
            View findViewById2 = findViewById(ResUtils.id(this, "forget_pwd"));
            this.f26562e = findViewById2;
            findViewById2.setVisibility(0);
            this.f26562e.setOnClickListener(this);
            PayLoadingImageViewNew payLoadingImageViewNew = (PayLoadingImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_cashier_loading_view"));
            this.l = payLoadingImageViewNew;
            payLoadingImageViewNew.setVisibility(8);
            View findViewById3 = findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
            this.m = findViewById3;
            findViewById3.setVisibility(8);
            this.n = (SuccessImageViewNew) findViewById(ResUtils.id(this, "bd_wallet_success_logo"));
            this.mLeftImg.setOnClickListener(this);
            this.u = findViewById(ResUtils.id(this, "protocol_display_area"));
            this.v = (CheckBox) findViewById(ResUtils.id(this, "ebpay_protocol"));
            this.w = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_text"));
            this.j = (TextView) findViewById(ResUtils.id(this, "ebpay_protocol_msg"));
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            PwdPayContract.protocolModel needshowProtocolContainer = this.mPresenter.needshowProtocolContainer();
            if (needshowProtocolContainer != null && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_msg) && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_prefix) && !TextUtils.isEmpty(needshowProtocolContainer.passfree_protocol_url)) {
                this.w.setText(needshowProtocolContainer.passfree_protocol_prefix);
                this.j.setText(needshowProtocolContainer.passfree_protocol_msg);
                this.j.setOnClickListener(new View.OnClickListener(this, needshowProtocolContainer) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayContract.protocolModel f26567a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26568b;

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
                        this.f26568b = this;
                        this.f26567a = needshowProtocolContainer;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BaiduWalletDelegate.getInstance().openH5Module(this.f26568b, this.f26567a.passfree_protocol_url, false);
                        }
                    }
                });
                this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, needshowProtocolContainer) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayContract.protocolModel f26580a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26581b;

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
                        this.f26581b = this;
                        this.f26580a = needshowProtocolContainer;
                    }

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                            this.f26580a.iClickCallback.onProtocolClicked(z);
                        }
                    }
                });
                this.v.setChecked(needshowProtocolContainer.checked);
                this.f26561c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.wallet.paysdk.ui.PwdPayActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PwdPayActivity f26582a;

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
                        this.f26582a = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f26582a.f26561c.getVisibility() == 0) {
                                this.f26582a.u.setVisibility(8);
                            } else {
                                this.f26582a.u.setVisibility(0);
                            }
                        }
                    }
                });
                this.u.setVisibility(0);
                return;
            }
            this.u.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f26560b.setVisibility(0);
            this.f26561c.setVisibility(8);
            this.f26562e.setVisibility(0);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c();
        }
    }
}
