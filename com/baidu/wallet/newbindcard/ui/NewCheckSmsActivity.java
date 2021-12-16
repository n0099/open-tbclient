package com.baidu.wallet.newbindcard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ad;
import com.baidu.wallet.paysdk.beans.b;
import com.baidu.wallet.paysdk.beans.g;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.baidu.walletsdk.pay.R;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.NumberSmsView;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes13.dex */
public class NewCheckSmsActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener, NumberSmsView.OnSmsChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f53846b;

    /* renamed from: c  reason: collision with root package name */
    public SafeScrollView f53847c;

    /* renamed from: d  reason: collision with root package name */
    public SafeKeyBoardEditText f53848d;

    /* renamed from: e  reason: collision with root package name */
    public NumberSmsView f53849e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f53850f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53851g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53852h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53853i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f53854j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f53855k;
    public BindFastRequest l;
    public CountDownTimer m;

    public NewCheckSmsActivity() {
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
        this.a = 6;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Intent intent = new Intent(this, NewSetPwdActivity.class);
            PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PWD, new PwdRequest());
            startActivityWithoutAnim(intent);
            finishWithoutAnim();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
            b bVar = (b) PayBeanFactory.getInstance().getBean((Context) this, 513, "NewCheckSmsActivity");
            bVar.a(this.l);
            bVar.setResponseCallback(this);
            bVar.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
            ad adVar = (ad) PayBeanFactory.getInstance().getBean((Context) this, 11, "NewCheckSmsActivity");
            adVar.a(this.l);
            adVar.setResponseCallback(this);
            adVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_check_sms_activity"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, a.a(), a.b(), a.c(), a.d(), StatHelper.SENSOR_ERR_2, "NewCheckSmsActivity onBackPressed");
            finishWithoutAnim();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (5 == i2 || 11 == i2 || 513 == i2) {
                a.a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, a.a(), a.b(), a.c(), a.d(), i3 + "", str);
                if (i3 == -8) {
                    if (TextUtils.isEmpty(str)) {
                        str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                    }
                    runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckSmsActivity.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ NewCheckSmsActivity f53857b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f53857b = this;
                            this.a = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                GlobalUtils.toast(this.f53857b, this.a);
                            }
                        }
                    });
                    return;
                }
                if (i3 == 5003) {
                    AccountManager.getInstance(this.mAct).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                a(str);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            int i3 = 0;
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (5 != i2) {
                if (513 == i2) {
                    BindCardResponse bindCardResponse = (BindCardResponse) obj;
                    a.a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, a.a(), a.b(), a.c(), a.d(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                    runOnUiThread(new Runnable(this, bindCardResponse != null ? bindCardResponse.card_no : "") { // from class: com.baidu.wallet.newbindcard.ui.NewCheckSmsActivity.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ NewCheckSmsActivity f53856b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f53856b = this;
                            this.a = r7;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                NewBindCardEntry.getInstance().newBindCardCallback("0", this.a, false);
                            }
                        }
                    });
                    return;
                } else if (11 == i2) {
                    a.a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, a.a(), a.b(), a.c(), a.d(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                    e();
                    return;
                } else {
                    return;
                }
            }
            CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            if (checkCardInfoResponse == null || !checkCardInfoResponse.checkResponseValidity()) {
                return;
            }
            a.a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, a.a(), a.b(), a.c(), a.d(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            if (this.l != null) {
                this.l.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 1);
                this.l.setSmsLength(checkCardInfoResponse.sms_length);
                this.l.setSmsType(checkCardInfoResponse.sms_type);
                if (TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                    return;
                }
                this.l.setChannelNo(checkCardInfoResponse.channel_no);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view == this.f53855k) {
                b(PayStatServiceEvent.NEW_CLICK_RESEND_SMS);
                this.f53849e.resetSms();
                c();
                b();
                d();
            } else if (view == this.f53854j) {
                b(PayStatServiceEvent.NEW_NOT_RECEIVE_SMS);
                WalletGlobalUtils.safeShowDialog(this, 23, "");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagActiveBindCard();
            a();
            b(PayStatServiceEvent.NEW_ENTER_SMS_PAGE);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SafeScrollView safeScrollView = this.f53847c;
            if (safeScrollView != null && safeScrollView.isPopupWindowShowing()) {
                this.f53847c.dismissKeyBoard(this.f53848d);
            }
            BeanManager.getInstance().removeAllBeans("NewCheckSmsActivity");
            CountDownTimer countDownTimer = this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.m = null;
            }
            super.onDestroy();
        }
    }

    @Override // com.dxmpay.wallet.base.widget.NumberSmsView.OnSmsChangedListener
    public void onSmsChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f53852h.setVisibility(8);
            if (i2 == this.a) {
                this.f53849e.setEnabled(false);
                BindFastRequest bindFastRequest = this.l;
                if (bindFastRequest != null) {
                    bindFastRequest.mSmsVCode = this.f53849e.getSms();
                }
                b(PayStatServiceEvent.NEW_CHECK_SMS);
                if (CardAddResponse.getInstance() != null && CardAddResponse.getInstance().user != null && CardAddResponse.getInstance().user.has_mobile_password == 1) {
                    f();
                } else {
                    g();
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.f53849e.requestFocus();
            }
            super.onWindowFocusChanged(z);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f53846b = (RelativeLayout) findViewById(R.id.relative_check_sms);
            this.f53847c = (SafeScrollView) findViewById(R.id.scrollview);
            this.f53849e = (NumberSmsView) findViewById(R.id.new_check_sms_input_box);
            this.f53850f = (TextView) findViewById(R.id.tv_new_check_sms_main_title);
            this.f53851g = (TextView) findViewById(R.id.tv_new_check_sms_subtitle);
            this.f53852h = (TextView) findViewById(R.id.tv_new_check_sms_error);
            this.f53855k = (TextView) findViewById(R.id.tv_new_check_resend_sms_time);
            this.f53853i = (TextView) findViewById(R.id.tv_new_check_sms_time);
            this.f53854j = (TextView) findViewById(R.id.tv_new_check_sms_tip);
            this.mLeftImg.setOnClickListener(this);
            this.f53855k.setOnClickListener(this);
            this.f53854j.setOnClickListener(this);
            this.f53849e.addNumberSmsChangedListenter(this);
            this.f53849e.setShowInputMethod(true);
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) findViewById(R.id.sms_input);
            this.f53848d = safeKeyBoardEditText;
            safeKeyBoardEditText.initSafeKeyBoardParams(this.f53846b, this.f53847c, this.f53849e, false);
            this.f53848d.setDisablePast(false);
            this.f53848d.setGap(20);
            BindFastRequest bindReq = NewBindCardEntry.getInstance().getBindReq();
            this.l = bindReq;
            if (bindReq == null) {
                NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewCheckSmsActivity bindFastRequest is null", false);
                finishWithoutAnim();
                return;
            }
            String sendSmsphone = bindReq.getSendSmsphone();
            if (!TextUtils.isEmpty(sendSmsphone)) {
                if (sendSmsphone.length() > 4) {
                    TextView textView = this.f53850f;
                    textView.setText("输入尾号" + sendSmsphone.substring(sendSmsphone.length() - 4, sendSmsphone.length()) + "的短信验证码");
                }
                TextView textView2 = this.f53851g;
                textView2.setText("验证码已发送至您的手机号" + ((Object) StringUtils.maskingPhoneNumber(sendSmsphone)));
            }
            if (!TextUtils.isEmpty(this.l.getSmsLength())) {
                this.a = Integer.parseInt(this.l.getSmsLength());
            }
            if (this.a < 1) {
                this.a = 6;
            }
            this.f53849e.initView(this.a);
            b();
            c();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            CountDownTimer countDownTimer = this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.m = null;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, 60000L, 1000L) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckSmsActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NewCheckSmsActivity a;

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
                    this.a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.f53855k.setEnabled(true);
                        this.a.f53855k.setVisibility(0);
                        this.a.f53853i.setVisibility(8);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.a.f53853i.setVisibility(0);
                        this.a.f53855k.setVisibility(8);
                        this.a.f53855k.setEnabled(false);
                        this.a.f53853i.setText(String.format(ResUtils.getString(this.a.getActivity(), "new_bind_card_check_sms_resend"), Integer.valueOf((int) (j2 / 1000))));
                    }
                }
            };
            this.m = countDownTimer2;
            countDownTimer2.start();
            this.f53855k.setEnabled(false);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f53849e.smsNomal();
            this.f53852h.setVisibility(8);
            this.f53849e.requestFocus();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            g gVar = (g) PayBeanFactory.getInstance().getBean((Context) this, 5, "NewCheckSmsActivity");
            gVar.a(this.l);
            gVar.setResponseCallback(this);
            gVar.execBean();
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            a.a(str, a.a(), a.b(), a.c(), a.d());
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            runOnUiThread(new Runnable(this, str) { // from class: com.baidu.wallet.newbindcard.ui.NewCheckSmsActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NewCheckSmsActivity f53858b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53858b = this;
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f53858b.f53849e.setEnabled(true);
                        this.f53858b.f53849e.resetSms();
                        this.f53858b.f53849e.requestFocus();
                        this.f53858b.f53849e.smsError();
                        this.f53858b.f53852h.setVisibility(0);
                        this.f53858b.f53852h.setText(this.a);
                    }
                }
            });
        }
    }
}
