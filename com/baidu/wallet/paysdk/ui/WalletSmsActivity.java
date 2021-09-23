package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler;
import com.baidu.wallet.paysdk.sms.controller.g;
import com.baidu.wallet.paysdk.sms.controller.h;
import com.baidu.wallet.paysdk.sms.controller.i;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.LoadingDialog;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.listener.DelegateOnDismissListener;
import com.dxmpay.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.NumberEditTextPasteFilter;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.List;
/* loaded from: classes8.dex */
public class WalletSmsActivity extends PayBaseActivity implements View.OnClickListener, SmsVerifyHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f63448a;

    /* renamed from: b  reason: collision with root package name */
    public int f63449b;

    /* renamed from: c  reason: collision with root package name */
    public ISmsController f63450c;

    /* renamed from: d  reason: collision with root package name */
    public SafeKeyBoardEditText f63451d;

    /* renamed from: e  reason: collision with root package name */
    public SafeScrollView f63452e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f63453f;

    /* renamed from: g  reason: collision with root package name */
    public Button f63454g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63455h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f63456i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f63457j;
    public View k;
    public TextView l;
    public Animation m;
    public boolean mHasVerifyCodeSend;
    public TextView mHelp;
    public Button mSendSms;
    public CountDownTimer mTimer;
    public TextView mTopPhoneTip;
    public Animation n;
    public int o;
    public int p;
    public TextView q;
    public boolean r;
    public String s;
    public Bundle t;
    public TextView u;
    public View v;
    public LinearLayout w;
    public int x;
    public boolean y;

    public WalletSmsActivity() {
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
        this.f63449b = -1;
        this.r = false;
        this.mHasVerifyCodeSend = false;
        this.x = 4;
        this.y = true;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void clearSmsEditText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f63451d.setText("");
            this.f63451d.requestFocus();
            this.f63457j.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void doStartCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            startCountDown();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void doStopCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            this.mSendSms.setText(ResUtils.getString(getActivity(), "ebpay_get_sms_code"));
            this.mSendSms.setTextSize(1, 11.0f);
            this.mSendSms.setEnabled(true);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d();
            super.finish();
            BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public void finishWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinearLayout linearLayout = this.w;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            d();
            super.finishWithoutAnim();
            BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
        }
    }

    @Override // com.dxmpay.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    public ISmsController getController(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i.a(i2) : (ISmsController) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            ISmsController iSmsController = this.f63450c;
            if (iSmsController == null || !iSmsController.handleFailure(i2, i3, str)) {
                super.handleFailure(i2, i3, str);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, obj, str) == null) {
            ISmsController iSmsController = this.f63450c;
            if (iSmsController == null || !iSmsController.handleResponse(i2, obj, str)) {
                super.handleResponse(i2, obj, str);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void initSMSActivityView(String str, String str2, String str3, String str4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)}) == null) {
            this.w.setVisibility(0);
            this.l.setText(ResUtils.string(this.f63448a, str));
            setPhoneNum(str4);
            if (TextUtils.isEmpty(str2)) {
                this.f63456i.setVisibility(8);
            } else {
                this.f63456i.setText(str2);
                this.f63456i.setVisibility(0);
            }
            this.f63454g.setText(str3);
            if (this.y) {
                return;
            }
            this.w.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public boolean isBindPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ISmsController iSmsController = this.f63450c;
            if (iSmsController != null && (iSmsController instanceof com.baidu.wallet.paysdk.sms.controller.c)) {
                return ((com.baidu.wallet.paysdk.sms.controller.c) iSmsController).b();
            }
            return super.isBindPay();
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f63449b == 8) {
                WalletGlobalUtils.safeShowDialog(this, 18, "");
                return;
            }
            a(StatHelper.SENSOR_ERR_2, "paySMSCancel");
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_CLOSE_FROM_SMS_VERIFY);
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (payRequest != null) {
                payRequest.clearMktSolution();
            }
            if (PayDataCache.getInstance().isFromPreCashier()) {
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_DURATION, null, new String[0]);
            }
            finishWithoutAnim();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            ErrorContentResponse errorContentResponse = (obj == null || !(obj instanceof ErrorContentResponse)) ? null : (ErrorContentResponse) obj;
            ISmsController iSmsController = this.f63450c;
            if (iSmsController == null || !iSmsController.doOnBeanExecFailureWithErrContent(i2, i3, str, obj)) {
                if (i3 == 51000 && errorContentResponse != null && (guidance = errorContentResponse.guidance) != null) {
                    this.mGuidance = guidance;
                    this.mPayErrorCode = i3;
                    this.mBeanId = i2;
                    if (guidance != null) {
                        WalletGlobalUtils.safeShowDialog(this, 53, "");
                        return;
                    } else {
                        super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                        return;
                    }
                }
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            if (view == this.f63457j) {
                clearSmsEditText();
            } else if (view == this.mSendSms) {
                StatHelper.statServiceEvent("getSmsCode");
                clearSmsEditText();
                startCountDown();
                c();
                b();
            } else if (view == this.f63454g) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (!this.mHasVerifyCodeSend) {
                    a((CharSequence) ResUtils.getString(getActivity(), "ebpay_sms_tips_get_code_first"));
                } else if (!a(this.f63451d.getText().toString())) {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_error_cer"));
                    this.f63451d.requestFocus();
                } else {
                    ISmsController iSmsController = this.f63450c;
                    if (iSmsController != null) {
                        iSmsController.onNextBtnClick(this.f63451d.getText().toString());
                    }
                }
            } else if (view == this.mHelp) {
                StatHelper.statServiceEvent("clickVcodeTip");
                WalletGlobalUtils.safeShowDialog(this, 23, "");
            } else if (view == this.k) {
                a(StatHelper.SENSOR_ERR_2, "paySMSCancel");
                StatHelper.statServiceEvent(StatServiceEvent.EVENT_CLOSE_FROM_SMS_VERIFY);
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_DURATION, null, new String[0]);
                }
                finishWithoutAnim();
            } else if (view.getId() == ResUtils.id(this, "ebpay_btn_modify_phone")) {
                StatHelper.statServiceEvent(PayStatServiceEvent.SMS_MODIFY_PHONE);
                ISmsController iSmsController2 = this.f63450c;
                if (iSmsController2 instanceof com.baidu.wallet.paysdk.sms.controller.a) {
                    ((com.baidu.wallet.paysdk.sms.controller.a) iSmsController2).a();
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"UseCheckPermission"})
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            this.f63448a = getActivity();
            this.t = bundle;
            if (bundle == null) {
                this.f63449b = getIntent().getIntExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, -1);
            } else {
                this.f63449b = bundle.getInt("SMS_FROM");
            }
            setContentView(ResUtils.layout(this.f63448a, "wallet_base_sms"));
            a();
            a(this.f63449b, getIntent().getBooleanExtra(BeanConstants.KEY_SEND_SMS_AUTO, false));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            ISmsController iSmsController = this.f63450c;
            if (iSmsController != null) {
                Dialog doOnCreateDialog = iSmsController.doOnCreateDialog(i2);
                return doOnCreateDialog != null ? doOnCreateDialog : super.onCreateDialog(i2);
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f63449b == 1 || com.baidu.wallet.paysdk.a.b.a()) {
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SMS_DURATION, null, new String[0]);
            }
            ISmsController iSmsController = this.f63450c;
            if (iSmsController != null) {
                iSmsController.doOnDestroy();
            }
            d();
            super.onDestroy();
            BeanManager.getInstance().removeAllBeans(ISmsController.BEAN_TAG);
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            this.f63450c = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            a(intent);
            a(this.f63449b, intent.getBooleanExtra(BeanConstants.KEY_SEND_SMS_AUTO, false));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048594, this, i2, dialog) == null) || this.f63450c == null) {
            return;
        }
        if (!(dialog instanceof LoadingDialog)) {
            try {
                if (this.m == null) {
                    this.m = AnimationUtils.loadAnimation(this, this.o);
                }
                this.f63452e.setAlwaysShowSoftKeyBoard(false);
                this.f63452e.startAnimation(this.m);
            } catch (Resources.NotFoundException unused) {
            }
            dialog.setOnDismissListener(new DelegateOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletSmsActivity f63461a;

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
                    this.f63461a = this;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        try {
                            if (this.f63461a.n == null) {
                                this.f63461a.n = AnimationUtils.loadAnimation(this.f63461a.getActivity(), this.f63461a.p);
                            }
                            this.f63461a.f63452e.setAlwaysShowSoftKeyBoard(true);
                            this.f63461a.f63452e.startAnimation(this.f63461a.n);
                        } catch (Resources.NotFoundException unused2) {
                        }
                    }
                }
            }));
        }
        if (this.f63450c.doOnPrepareDialog(i2, dialog)) {
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            SafeKeyBoardEditText safeKeyBoardEditText = this.f63451d;
            if (safeKeyBoardEditText != null) {
                safeKeyBoardEditText.requestFocus();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            ISmsController iSmsController = this.f63450c;
            if (iSmsController != null) {
                iSmsController.doOnSaveInstanceState(bundle);
            }
            bundle.putInt("SMS_FROM", this.f63449b);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsSendFailure(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, charSequence) == null) {
            GlobalUtils.toast(this, charSequence);
            a(i2 + "", charSequence.toString());
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsSendSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            a("0", StatHelper.SENSOR_OK);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsVerifyFailure(int i2, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, charSequence) == null) {
            a(i2 + "", charSequence.toString());
            if (TextUtils.isEmpty(this.s)) {
                this.s = ResUtils.getString(this, "ebpay_verify_fail");
            }
            a(charSequence);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler
    public void onSmsVerifySuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            a("0", StatHelper.SENSOR_OK);
        }
    }

    public void setPhoneNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.f63455h.setText(StringUtils.maskingPhoneNumber(str));
            } else {
                this.f63455h.setText("");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
            if (z) {
                PayController.getInstance().paySucess(this, payResultContent, i2);
            } else {
                PayController.getInstance().payPaying(this, payResultContent, i2);
            }
        }
    }

    public void startCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mHasVerifyCodeSend = true;
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, 60000L, 1000L) { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletSmsActivity f63460a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r11), Long.valueOf(r13)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63460a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WalletSmsActivity walletSmsActivity = this.f63460a;
                        walletSmsActivity.mSendSms.setText(ResUtils.getString(walletSmsActivity.getActivity(), "ebpay_get_sms_code"));
                        this.f63460a.mSendSms.setTextSize(1, 11.0f);
                        this.f63460a.mSendSms.setEnabled(true);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f63460a.mSendSms.setEnabled(false);
                        this.f63460a.mSendSms.setTextSize(1, 11.0f);
                        WalletSmsActivity walletSmsActivity = this.f63460a;
                        walletSmsActivity.mSendSms.setText(String.format(ResUtils.getString(walletSmsActivity.getActivity(), "ebpay_resend"), Integer.valueOf((int) (j2 / 1000))));
                    }
                }
            };
            this.mTimer = countDownTimer2;
            countDownTimer2.start();
            this.mSendSms.setEnabled(false);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void upDateSafeKeyBoradView(String str, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) || this.f63451d == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            i2 = 0;
        } else {
            try {
                i2 = Integer.parseInt(str2);
            } catch (Exception unused) {
                StatisticManager.onEvent("smsStyleNull");
                i2 = 0;
            }
            StatHelper.statServiceEvent("smsStyle", null, str2 + "");
        }
        int i3 = 10;
        if (!TextUtils.isEmpty(str)) {
            try {
                i3 = Integer.parseInt(str);
                this.x = i3;
            } catch (Exception unused2) {
                StatisticManager.onEvent("smsLengthNull");
            }
            StatHelper.statServiceEvent("smsLength", null, str + "");
        }
        if (i2 == 0) {
            this.f63451d.setInputType(2);
            getWindow().setSoftInputMode(2);
            this.f63451d.setUseSafeKeyBoard(true);
            this.f63451d.initSafeKeyBoardParams(this.f63453f, this.f63452e, this.mHelp, true);
            this.f63452e.setAlwaysShowSoftKeyBoard(true);
            List<IEditTextPasteFilter> editTextPasteFilters = this.f63451d.getEditTextPasteFilters();
            if (editTextPasteFilters != null) {
                editTextPasteFilters.clear();
                editTextPasteFilters.add(new NumberEditTextPasteFilter());
            }
        } else {
            this.f63451d.setInputType(1);
            List<IEditTextPasteFilter> editTextPasteFilters2 = this.f63451d.getEditTextPasteFilters();
            if (editTextPasteFilters2 != null) {
                editTextPasteFilters2.clear();
                editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
            }
            getWindow().setSoftInputMode(4);
            this.f63451d.initSafeKeyBoardParams(this.f63453f, this.f63452e, this.mHelp, true);
        }
        this.f63451d.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void updateButtonTip(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f63454g.setText(str);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.SmsUpdateUiInterface
    public void updateModifyPhoneUI(boolean z, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048606, this, z, charSequence) == null) {
            this.u.setText(charSequence);
            this.u.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.r) {
            this.v.setBackgroundColor(Color.parseColor("#54576A"));
            this.q.setVisibility(4);
            this.r = false;
        }
    }

    private void c() {
        ISmsController iSmsController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (iSmsController = this.f63450c) == null) {
            return;
        }
        iSmsController.sendSms();
    }

    private void d() {
        SafeScrollView safeScrollView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && (safeScrollView = this.f63452e) != null && safeScrollView.isPopupWindowShowing()) {
            this.f63452e.dismissKeyBoard(this.f63451d);
        }
    }

    private void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.y = getIntent().getBooleanExtra("showSMSDialog", true);
            this.f63450c = getController(i2);
            getBindCardFlagDelegate().a((BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.getInstance().getBindCategoryByIntent(getIntent())));
            ISmsController iSmsController = this.f63450c;
            if (iSmsController == null) {
                finish();
                return;
            }
            if (iSmsController instanceof com.baidu.wallet.paysdk.sms.controller.c) {
                com.baidu.wallet.paysdk.sms.controller.c cVar = (com.baidu.wallet.paysdk.sms.controller.c) iSmsController;
                PayRequestCache.BindCategory bindCategoryByIntent = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
                cVar.a(bindCategoryByIntent);
                cVar.a((BindFastRequest) PayRequestCache.getInstance().getRequest(bindCategoryByIntent));
            }
            this.f63450c.setSmsUpdateUIInterface(this);
            this.f63450c.setSmsVerifyHandler(this);
            this.f63450c.setActivity(this);
            if (this.f63450c.onCreateCheckInvalide(this.t)) {
                if (this.f63450c.isBelongPaySDK()) {
                    setFlagPaySdk();
                }
                this.f63450c.initSmsActivityView();
                ISmsController iSmsController2 = this.f63450c;
                if (!(iSmsController2 instanceof h) && !(iSmsController2 instanceof g)) {
                    clearSmsEditText();
                    startCountDown();
                }
                if (this.f63450c.isSendSmsOnCreate() || z) {
                    stopCountDown();
                    c();
                }
                if (i2 == 7) {
                    setFlagActiveBindCard();
                }
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f63453f = (ViewGroup) findViewById(ResUtils.id(this.f63448a, "root_view"));
            this.f63452e = (SafeScrollView) findViewById(ResUtils.id(this.f63448a, "scrollview"));
            this.f63455h = (TextView) findViewById(ResUtils.id(this.f63448a, "ebpay_sms_moblie"));
            this.mTopPhoneTip = (TextView) findViewById(ResUtils.id(this.f63448a, "ebpay_tip_top"));
            this.f63451d = (SafeKeyBoardEditText) findViewById(ResUtils.id(this.f63448a, "ebpay_message_vcode_id"));
            this.f63457j = (ImageView) findViewById(ResUtils.id(this.f63448a, "wallet_sms_clear"));
            this.mSendSms = (Button) findViewById(ResUtils.id(this.f63448a, "ebpay_sms_sendsms"));
            this.mHelp = (TextView) findViewById(ResUtils.id(this.f63448a, "ebpay_tip_bottom_right"));
            this.f63456i = (TextView) findViewById(ResUtils.id(this.f63448a, "ebpay_top_tip"));
            this.f63454g = (Button) findViewById(ResUtils.id(this.f63448a, "ebpay_next_btn"));
            this.w = (LinearLayout) findViewById(ResUtils.id(getActivity(), "lin_sms_dialog"));
            SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
            this.f63452e = safeScrollView;
            this.f63451d.initSafeKeyBoardParams(this.f63453f, safeScrollView, this.mHelp, false);
            this.f63451d.setUseSafeKeyBoard(true);
            this.f63457j.setOnClickListener(this);
            this.mSendSms.setOnClickListener(this);
            this.f63454g.setOnClickListener(this);
            this.mHelp.setOnClickListener(this);
            this.f63451d.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.WalletSmsActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WalletSmsActivity f63458a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f63459b;

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
                    this.f63458a = this;
                    this.f63459b = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        if (!TextUtils.isEmpty(editable.toString())) {
                            this.f63458a.f63457j.setVisibility(0);
                        } else {
                            this.f63458a.f63457j.setVisibility(8);
                        }
                        this.f63458a.f63454g.setEnabled(this.f63458a.a(editable.toString()));
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
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                        if (!this.f63459b) {
                            if (this.f63458a.f63450c != null) {
                                this.f63458a.f63450c.doOnEvent();
                            }
                            this.f63459b = true;
                        }
                        this.f63458a.b();
                    }
                }
            });
            View findViewById = findViewById(ResUtils.id(this.f63448a, "dialog_close"));
            this.k = findViewById;
            findViewById.setOnClickListener(this);
            this.l = (TextView) findViewById(ResUtils.id(this.f63448a, "dialog_title"));
            this.o = ResUtils.anim(this, "wallet_dialog_slide_to_left");
            this.p = ResUtils.anim(this, "wallet_dialog_slide_to_right");
            this.q = (TextView) findViewById(ResUtils.id(this, "ebpay_error_tip"));
            View findViewById2 = findViewById(ResUtils.id(this, "ebpay_sms_line_info"));
            this.v = findViewById2;
            findViewById2.setBackgroundColor(Color.parseColor("#54576A"));
            TextView textView = (TextView) findViewById(ResUtils.id(this, "ebpay_btn_modify_phone"));
            this.u = textView;
            textView.setOnClickListener(this);
            setSafeScrollView(this.f63452e);
            a(getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) ? !TextUtils.isEmpty(str) && str.length() >= this.x : invokeL.booleanValue;
    }

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, intent) == null) {
            int intExtra = intent.getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
            String stringExtra = intent.getStringExtra(BeanConstants.KEY_SMS_HINT);
            if (intExtra != 5320 || TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.mTopPhoneTip.setText(stringExtra);
        }
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            if (this.f63449b == 1 || com.baidu.wallet.paysdk.a.b.a()) {
                StatHelper.cacheCodeAndMsg(str, str2);
            }
        }
    }

    private void a(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, charSequence) == null) {
            this.v.setBackgroundColor(Color.parseColor("#FA5050"));
            this.q.setText(charSequence);
            this.q.setVisibility(0);
            this.r = true;
        }
    }
}
