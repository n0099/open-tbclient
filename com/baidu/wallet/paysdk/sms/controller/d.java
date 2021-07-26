package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ag;
import com.baidu.wallet.paysdk.beans.aj;
import com.baidu.wallet.paysdk.beans.s;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f26432a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f26433b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorContentResponse f26434c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f26435d;

    /* renamed from: e  reason: collision with root package name */
    public String f26436e;

    /* renamed from: f  reason: collision with root package name */
    public PayRequestCache.BindCategory f26437f;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f26438g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.b f26439h;

    /* renamed from: i  reason: collision with root package name */
    public aj f26440i;
    public com.baidu.wallet.paysdk.beans.h j;
    public String k;
    public boolean l;
    public boolean m;
    public y n;
    public SmsVerifyHandler o;
    public boolean p;
    public String q;

    public d() {
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
        this.l = true;
        this.m = false;
        this.p = false;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.BIND_CLICK_PAY);
            StatisticManager.onEventStart(StatServiceEvent.TIME_PAY);
            WalletGlobalUtils.safeShowDialog(this.f26432a, 0, "");
            if (this.n == null) {
                this.n = (y) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 13, ISmsController.BEAN_TAG);
            }
            this.n.setResponseCallback((WalletSmsActivity) this.f26432a);
            this.n.b(this.f26432a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
            this.n.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f26432a, 0, "");
            if (this.f26439h == null) {
                this.f26439h = (com.baidu.wallet.paysdk.beans.b) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 513, ISmsController.BEAN_TAG);
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.BIND_CARD);
            this.f26439h.a(this.f26438g);
            this.f26439h.setResponseCallback((WalletSmsActivity) this.f26432a);
            this.f26439h.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            BindFastRequest bindFastRequest = this.f26438g;
            if (bindFastRequest != null && bindFastRequest.isNeedCheckSms()) {
                WalletGlobalUtils.safeShowDialog(this.f26432a, 0, "");
                if (this.f26440i == null) {
                    this.f26440i = (aj) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 11, ISmsController.BEAN_TAG);
                }
                PayStatisticsUtil.onEventStart(StatServiceEvent.VERIFY_SMS);
                int i2 = this.f26438g.getmBindFrom();
                if (i2 != 6 && i2 != 7 && i2 != 8) {
                    this.f26440i.a(false);
                } else {
                    this.f26440i.a(true);
                }
                this.f26440i.a(this.f26438g);
                this.f26440i.setResponseCallback((WalletSmsActivity) this.f26432a);
                this.f26440i.execBean();
                return;
            }
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f26432a, 0, "");
            if (this.n == null) {
                this.n = (y) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 13, ISmsController.BEAN_TAG);
            }
            this.n.setResponseCallback((WalletSmsActivity) this.f26432a);
            this.n.b(this.f26432a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
            this.n.execBean();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.f26438g == null) {
            return;
        }
        PasswordController.getPassWordInstance().setPwd(this.f26432a, false, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f26441a;

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
                this.f26441a = this;
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i2, String str) {
                SmsUpdateUiInterface smsUpdateUiInterface;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || (smsUpdateUiInterface = this.f26441a.f26433b) == null) {
                    return;
                }
                smsUpdateUiInterface.clearSmsEditText();
                this.f26441a.f26433b.doStopCountDown();
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    int i2 = this.f26441a.f26438g.getmBindFrom();
                    if (i2 == 1) {
                        PayController.getInstance().bindSuccess(null);
                    } else if (i2 == 3) {
                        PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                    } else if (i2 == 4) {
                        PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                    } else if (i2 == 6 || i2 == 7 || i2 == 8) {
                        this.f26441a.h();
                    }
                }
            }
        }, this.f26437f);
        this.p = true;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            BindFastRequest bindFastRequest = this.f26438g;
            return (bindFastRequest == null || bindFastRequest.mBondCard == null || bindFastRequest.getmBindFrom() != 2 || this.f26438g.mBondCard.isNeedSendSms()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            String string = ResUtils.getString(this.f26432a, "ebpay_confirm");
            BindFastRequest bindFastRequest = this.f26438g;
            if (bindFastRequest == null) {
                return string;
            }
            int i2 = bindFastRequest.mBindFrom;
            if (i2 == 0) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    PayRequest payRequest = this.f26435d;
                    if (payRequest != null && payRequest.mMktSolution != null) {
                        return String.format(ResUtils.getString(this.f26432a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26435d.mMktSolution.easypay_amount));
                    }
                    if (this.f26438g != null) {
                        return String.format(ResUtils.getString(this.f26432a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26438g.getFinalPayAmount()));
                    }
                    return ResUtils.getString(this.f26432a, "ebpay_submit_pay");
                }
                return ResUtils.getString(this.f26432a, "wallet_base_next_step");
            } else if (i2 == 1) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    return ResUtils.getString(this.f26432a, "ebpay_pwd_done");
                }
                return ResUtils.getString(this.f26432a, "wallet_base_next_step");
            } else if (i2 == 2) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    PayRequest payRequest2 = this.f26435d;
                    if (payRequest2 != null) {
                        if (payRequest2.mMktSolution != null) {
                            return String.format(ResUtils.getString(this.f26432a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26435d.mMktSolution.easypay_amount));
                        }
                        return String.format(ResUtils.getString(this.f26432a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26435d.getFinalPayAmount()));
                    }
                    return ResUtils.getString(this.f26432a, "ebpay_submit_pay");
                }
                return ResUtils.getString(this.f26432a, "wallet_base_next_step");
            } else if (i2 != 3) {
                if (i2 == 6 || i2 == 7 || i2 == 8) {
                    if (PayDataCache.getInstance().hasMobilePwd()) {
                        if (com.baidu.wallet.paysdk.a.b.c()) {
                            PayRequest payRequest3 = this.f26435d;
                            if (payRequest3 != null && payRequest3.mMktSolution != null) {
                                return String.format(ResUtils.getString(this.f26432a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26435d.mMktSolution.easypay_amount));
                            }
                            if (this.f26438g != null) {
                                return String.format(ResUtils.getString(this.f26432a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26438g.getFinalPayAmount()));
                            }
                            return ResUtils.getString(this.f26432a, "ebpay_submit_pay");
                        }
                        return ResUtils.getString(this.f26432a, "bd_wallet_auth_submit_sign");
                    }
                    return ResUtils.getString(this.f26432a, "wallet_base_next_step");
                }
                return string;
            } else {
                return ResUtils.getString(this.f26432a, "wallet_base_next_step");
            }
        }
        return (String) invokeV.objValue;
    }

    private ArrayList<String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.f26435d;
            arrayList.add(payRequest != null ? payRequest.mSpNO : "");
            PayRequest payRequest2 = this.f26435d;
            arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
            if (i3 != 80320 && i3 != 80321 && i3 != 80326 && i3 != 80327) {
                if (obj instanceof ErrorContentResponse) {
                    ErrorContentResponse errorContentResponse = (ErrorContentResponse) obj;
                    if (errorContentResponse.card_item_required != null && this.f26438g.getmBindFrom() == 2) {
                        this.k = str;
                        this.f26434c = errorContentResponse;
                        WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                        WalletGlobalUtils.safeShowDialog(this.f26432a, 40, "");
                        return true;
                    } else if (i3 == 15500) {
                        this.k = str;
                        PayBaseActivity payBaseActivity = this.f26432a;
                        payBaseActivity.mPayErrorCode = i3;
                        payBaseActivity.mBeanId = i2;
                        this.f26434c = errorContentResponse;
                        WalletGlobalUtils.safeDismissDialog(payBaseActivity, 0);
                        WalletGlobalUtils.safeShowDialog(this.f26432a, 65316, "");
                        return true;
                    }
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
            PayDataCache.getInstance().cleanDetainmentDesc();
            if (obj instanceof ErrorContentResponse) {
                this.f26434c = (ErrorContentResponse) obj;
                if (!TextUtils.isEmpty(str)) {
                    this.k = str;
                    PayBaseActivity payBaseActivity2 = this.f26432a;
                    payBaseActivity2.mPayErrorCode = i3;
                    payBaseActivity2.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(payBaseActivity2, ISmsController.DIALOG_CANNOT_DISCOUNT, "");
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 == 65315) {
                return new PromptDialog(this.f26432a.getActivity());
            }
            if (i2 == 65316) {
                return new PromptDialog(this.f26432a.getActivity());
            }
            if (i2 == 65283) {
                return new PromptDialog(this.f26432a.getActivity());
            }
            if (i2 == 40) {
                return new PromptDialog(this.f26432a.getActivity());
            }
            return null;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.p) {
                PasswordController.getPassWordInstance().clearSetPwdListener();
            }
            this.f26432a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_INPUT_VCODE);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnPrepareDialog(int i2, Dialog dialog) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, dialog)) == null) {
            switch (i2) {
                case 40:
                    PromptDialog promptDialog = (PromptDialog) dialog;
                    promptDialog.setMessage(this.k);
                    promptDialog.hideNegativeButton();
                    promptDialog.setPositiveBtn(ResUtils.string(this.f26432a, "ebpay_know"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.sms.controller.d.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f26446a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ d f26447b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, promptDialog};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f26447b = this;
                            this.f26446a = promptDialog;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayController payController = PayController.getInstance();
                                d dVar = this.f26447b;
                                payController.updateCardInfoPay(dVar.f26432a, dVar.f26434c);
                                this.f26446a.dismiss();
                                this.f26447b.f26432a.finishWithoutAnim();
                            }
                        }
                    });
                    return true;
                case ISmsController.DIALOG_PROMPT /* 65283 */:
                    PromptDialog promptDialog2 = (PromptDialog) dialog;
                    promptDialog2.setMessage(this.k);
                    promptDialog2.setCanceledOnTouchOutside(false);
                    promptDialog2.hideNegativeButton();
                    return true;
                case ISmsController.DIALOG_CANNOT_DISCOUNT /* 65315 */:
                    StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
                    PromptDialog promptDialog3 = (PromptDialog) dialog;
                    promptDialog3.setMessage(this.k);
                    promptDialog3.showCloseBtn(false);
                    promptDialog3.setNegativeBtn(ResUtils.getString(this.f26432a, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.d.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ d f26442a;

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
                            this.f26442a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f26442a.f26432a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_cancel"));
                                WalletGlobalUtils.safeDismissDialog(this.f26442a.f26432a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                            }
                        }
                    });
                    promptDialog3.setPositiveBtn(ResUtils.getString(this.f26432a, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.d.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ d f26443a;

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
                            this.f26443a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f26443a.f26432a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                                d dVar = this.f26443a;
                                ErrorContentResponse errorContentResponse = dVar.f26434c;
                                if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                                    return;
                                }
                                if (dVar.j == null) {
                                    this.f26443a.j = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) this.f26443a.f26432a, 5, ISmsController.BEAN_TAG);
                                }
                                ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(this.f26443a.f26434c.mkt_solution);
                                PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
                                this.f26443a.j.a(this.f26443a.f26438g);
                                this.f26443a.j.setResponseCallback((WalletSmsActivity) this.f26443a.f26432a);
                                this.f26443a.j.execBean();
                                WalletGlobalUtils.safeShowDialog(this.f26443a.f26432a, 0, "");
                                WalletGlobalUtils.safeDismissDialog(this.f26443a.f26432a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                                d dVar2 = this.f26443a;
                                if (dVar2.f26433b != null) {
                                    String k = dVar2.k();
                                    if (!TextUtils.isEmpty(k)) {
                                        this.f26443a.f26433b.updateButtonTip(k);
                                    }
                                }
                                SmsUpdateUiInterface smsUpdateUiInterface = this.f26443a.f26433b;
                                if (smsUpdateUiInterface != null) {
                                    smsUpdateUiInterface.clearSmsEditText();
                                    this.f26443a.f26433b.doStartCountDown();
                                }
                            }
                        }
                    });
                    return true;
                case 65316:
                    StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_CARD_UPDATE);
                    PayRequest payRequest = this.f26435d;
                    if (payRequest != null && payRequest.mBondCard != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
                        this.f26435d.mBondCard.hideSMSDialog = true;
                    }
                    PromptDialog promptDialog4 = (PromptDialog) dialog;
                    promptDialog4.setMessage(this.k);
                    promptDialog4.showCloseBtn(false);
                    promptDialog4.setCanceledOnTouchOutside(false);
                    if (j()) {
                        promptDialog4.hideNegativeButton();
                    }
                    promptDialog4.setNegativeBtn(ResUtils.getString(this.f26432a, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.d.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ d f26444a;

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
                            this.f26444a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f26444a.f26432a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_cancel"));
                                WalletGlobalUtils.safeDismissDialog(this.f26444a.f26432a, 65316);
                                PayBaseActivity payBaseActivity2 = this.f26444a.f26432a;
                                if (payBaseActivity2 instanceof WalletSmsActivity) {
                                    payBaseActivity2.finishWithoutAnim();
                                }
                            }
                        }
                    });
                    promptDialog4.setPositiveBtn(ResUtils.string(this.f26432a, "ebpay_wallet_continue_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.d.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ d f26445a;

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
                            this.f26445a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f26445a.f26432a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                                StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                                WalletGlobalUtils.safeDismissDialog(this.f26445a.f26432a, 65316);
                                PayController payController = PayController.getInstance();
                                d dVar = this.f26445a;
                                payController.updateCardInfoPay(dVar.f26432a, dVar.f26434c);
                                this.f26445a.f26432a.finishWithoutAnim();
                            }
                        }
                    });
                    return true;
                default:
                    return false;
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            bundle.putSerializable("mBindRequest", this.f26438g);
            bundle.putSerializable("mPayRequest", this.f26435d);
            bundle.putSerializable("mCardInfoUpdateContent", this.f26434c);
            bundle.putBoolean("isSendSMSForCompletionPay", this.m);
            bundle.putString("mDialogMsg", this.k);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleFailure(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, str)) == null) {
            if (i3 == 65025) {
                GlobalUtils.toast(this.f26432a, str);
                PayRequestCache.getInstance().clearPaySdkRequestCache();
                PayBaseBeanActivity.exitEbpay();
                return true;
            } else if (i2 == 5 || i2 == 17) {
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f26432a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                a(i3, str);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, i3);
                return true;
            } else if (i2 == 11) {
                WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f26432a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                SmsVerifyHandler smsVerifyHandler = this.o;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifyFailure(i3, str);
                }
                PayStatisticsUtil.onEvent(StatServiceEvent.VERFY_SMS_FAIL);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.VERIFY_SMS, i3);
                return true;
            } else if (i2 != 13 && i2 != 513) {
                if (i2 == 264) {
                    a(i3, str);
                    return true;
                }
                return false;
            } else {
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f26432a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                if (i3 == 60500) {
                    this.k = str;
                    WalletGlobalUtils.safeShowDialog(this.f26432a, ISmsController.DIALOG_PROMPT, "");
                } else {
                    SmsVerifyHandler smsVerifyHandler2 = this.o;
                    if (smsVerifyHandler2 != null) {
                        smsVerifyHandler2.onSmsVerifyFailure(i3, str);
                    }
                }
                if (i2 == 13) {
                    BindFastRequest bindFastRequest = this.f26438g;
                    if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f26438g.getmBindFrom() == 6)) {
                        String orderNo = StatHelper.getOrderNo();
                        StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BIND_CARD_FAILED, StatHelper.collectData(orderNo, i3 + "", str));
                    }
                    StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, i3);
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.BIND_PAY_ACCEPT_FAIL, String.valueOf(i3));
                } else {
                    String sessionId = StatHelper.getSessionId();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, StatHelper.collectData(sessionId, i3 + "", str));
                    PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, i3);
                }
                return true;
            }
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean handleResponse(int i2, Object obj, String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, obj, str)) == null) {
            if (i2 == 5 || i2 == 17) {
                WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
                if (checkCardInfoResponse != null && checkCardInfoResponse.checkResponseValidity()) {
                    if (this.f26438g != null) {
                        this.f26438g.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
                        if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                            this.f26438g.setChannelNo(checkCardInfoResponse.channel_no);
                        }
                    }
                    if (this.l) {
                        this.l = false;
                        SmsUpdateUiInterface smsUpdateUiInterface = this.f26433b;
                        if (smsUpdateUiInterface != null) {
                            smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
                        }
                    }
                    SmsUpdateUiInterface smsUpdateUiInterface2 = this.f26433b;
                    if (smsUpdateUiInterface2 != null) {
                        smsUpdateUiInterface2.updateModifyPhoneUI(!TextUtils.isEmpty(checkCardInfoResponse.update_mobile_desc), checkCardInfoResponse.update_mobile_desc);
                    }
                }
                SmsVerifyHandler smsVerifyHandler = this.o;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendSuccess();
                }
                PayStatisticsUtil.onEventEnd(StatServiceEvent.CARD_CHECK, 0);
                return true;
            } else if (i2 == 11) {
                WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                PayStatisticsUtil.onEvent(StatServiceEvent.VERIFY_SMS_SUCCESS);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.VERIFY_SMS, 0);
                i();
                SmsVerifyHandler smsVerifyHandler2 = this.o;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifySuccess();
                }
                return true;
            } else if (i2 == 513) {
                WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                PayStatisticsUtil.onEventEnd(StatServiceEvent.BIND_CARD, 0);
                PayRequest payRequest = this.f26435d;
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    PayController.getInstance().bindExtSuccess(this.f26432a, obj);
                } else {
                    PayController.getInstance().bindSuccess(obj);
                }
                SmsVerifyHandler smsVerifyHandler3 = this.o;
                if (smsVerifyHandler3 != null) {
                    smsVerifyHandler3.onSmsVerifySuccess();
                }
                return true;
            } else if (i2 != 13) {
                if (i2 != 264) {
                    if (i2 == 15) {
                        return a(obj);
                    }
                    return false;
                }
                WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
                SmsVerifyHandler smsVerifyHandler4 = this.o;
                if (smsVerifyHandler4 != null) {
                    smsVerifyHandler4.onSmsSendSuccess();
                }
                return true;
            } else {
                BindFastRequest bindFastRequest = this.f26438g;
                if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f26438g.getmBindFrom() == 6)) {
                    StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_SUCCESS, StatHelper.getOrderNo());
                }
                StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, 0);
                PayStatisticsUtil.onEvent("paySuccess");
                SmsVerifyHandler smsVerifyHandler5 = this.o;
                if (smsVerifyHandler5 != null) {
                    smsVerifyHandler5.onSmsVerifySuccess();
                }
                return false;
            }
        }
        return invokeILL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String unicodeDecode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f26438g == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f26436e)) {
            unicodeDecode = !TextUtils.isEmpty(this.f26438g.getSendSmsphone()) ? this.f26438g.getSendSmsphone() : "";
        } else {
            unicodeDecode = SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.f26436e));
        }
        String str = unicodeDecode;
        String k = k();
        SmsUpdateUiInterface smsUpdateUiInterface = this.f26433b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", k, str, true);
            this.f26433b.updateModifyPhoneUI(!TextUtils.isEmpty(this.q), this.q);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isBelongPaySDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            BindFastRequest bindFastRequest = this.f26438g;
            if (bindFastRequest != null) {
                if (bindFastRequest.mBindFrom == 2 && this.m) {
                    c();
                    return 5320 != this.f26432a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
                }
                BindFastRequest bindFastRequest2 = this.f26438g;
                if (bindFastRequest2.mBindFrom == 8) {
                    c();
                    return 5320 != this.f26432a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
                }
                SmsUpdateUiInterface smsUpdateUiInterface = this.f26433b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(bindFastRequest2.getSmsLength(), this.f26438g.getSmsType());
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundle)) == null) {
            this.q = this.f26432a.getIntent().getStringExtra(BeanConstants.UPDATE_MOBILE_DESC);
            if (bundle == null) {
                this.m = this.f26432a.getIntent().getBooleanExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
                if (this.f26438g == null) {
                    this.f26438g = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
                }
                if (this.f26437f == null) {
                    this.f26437f = PayRequestCache.BindCategory.Other;
                }
                this.f26435d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                Serializable serializableExtra = this.f26432a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
                if (serializableExtra != null) {
                    this.f26436e = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
                }
            } else {
                this.m = bundle.getBoolean("isSendSMSForCompletionPay");
                this.k = bundle.getString("mDialogMsg");
                Serializable serializable = bundle.getSerializable("mBindRequest");
                if (serializable != null && (serializable instanceof BindFastRequest)) {
                    this.f26438g = (BindFastRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f26435d = (PayRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("mCardInfoUpdateContent");
                if (serializable3 != null && (serializable3 instanceof ErrorContentResponse)) {
                    this.f26434c = (ErrorContentResponse) serializable3;
                }
                this.f26436e = bundle.getString("phone_no");
            }
            BindFastRequest bindFastRequest = this.f26438g;
            if (bindFastRequest != null && bindFastRequest.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f26438g.getRequestId(), this.f26438g);
                if (this.f26438g.isRealPay() && (payRequest = this.f26435d) != null && payRequest.checkRequestValidity()) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f26435d.getRequestId(), this.f26435d);
                } else if (this.f26438g.isRealPay()) {
                    PayCallBackManager.callBackClientCancel(this.f26432a, "SmsControllerForBindSMS.onCreateCheckInvalide().1");
                    return false;
                }
                this.l = true;
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f26432a, "SmsControllerForBindSMS.onCreateCheckInvalide().2");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.NEXT_THIRD, l());
            BindFastRequest bindFastRequest = this.f26438g;
            if (bindFastRequest == null) {
                return;
            }
            bindFastRequest.mSmsVCode = str;
            int i2 = bindFastRequest.getmBindFrom();
            if (i2 == 0) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    e();
                } else {
                    g();
                }
            } else if (i2 == 1) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    f();
                } else {
                    g();
                }
            } else if (i2 == 2) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    e();
                } else {
                    g();
                }
            } else if (i2 == 3) {
                g();
            } else if (i2 == 6 || i2 == 7 || i2 == 8) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    h();
                } else {
                    g();
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void sendSms() {
        PayBaseActivity payBaseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (payBaseActivity = this.f26432a) == null) {
            return;
        }
        if (this.l) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f26432a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
            d();
        } else if (TextUtils.isEmpty(this.q)) {
            if (this.j == null) {
                this.j = (com.baidu.wallet.paysdk.beans.h) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 5, ISmsController.BEAN_TAG);
            }
            PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
            this.j.a(this.f26438g);
            this.j.setResponseCallback((WalletSmsActivity) this.f26432a);
            this.j.execBean();
        } else {
            com.baidu.wallet.paysdk.beans.g gVar = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 17, ISmsController.BEAN_TAG);
            gVar.setResponseCallback(this.f26432a);
            PayStatisticsUtil.onEventStart(StatServiceEvent.CARD_CHECK);
            gVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, payBaseActivity) == null) {
            this.f26432a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, smsUpdateUiInterface) == null) {
            this.f26433b = smsUpdateUiInterface;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsVerifyHandler(SmsVerifyHandler smsVerifyHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, smsVerifyHandler) == null) {
            this.o = smsVerifyHandler;
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && 5320 == this.f26432a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) && this.f26433b != null) {
            ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.f26432a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            this.f26433b.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ag agVar = (ag) PayBeanFactory.getInstance().getBean((Context) this.f26432a, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
            agVar.setResponseCallback(this.f26432a);
            agVar.execBean();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BindFastRequest bindFastRequest = this.f26438g;
            if (bindFastRequest == null) {
                return false;
            }
            int i2 = bindFastRequest.getmBindFrom();
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    private boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj)) == null) {
            if (obj instanceof GetCardInfoResponse) {
                this.f26432a.finishWithoutAnim();
                PayController.getInstance().completeCardPay(this.f26432a, this.f26435d.mBondCard, (GetCardInfoResponse) obj);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this.f26432a, 0);
            if (this.l) {
                this.l = false;
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f26432a.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler = this.o;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i2, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f26433b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.doStopCountDown();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s sVar = (s) PayBeanFactory.getInstance().getBean((Context) this.f26432a, 15, ISmsController.BEAN_TAG);
            sVar.setResponseCallback(this.f26432a);
            WalletGlobalUtils.safeShowDialog(this.f26432a, 0, "");
            sVar.execBean();
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bindFastRequest) == null) {
            this.f26438g = bindFastRequest;
        }
    }

    public void a(PayRequestCache.BindCategory bindCategory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bindCategory) == null) {
            if (bindCategory == null) {
                bindCategory = PayRequestCache.BindCategory.Other;
            }
            this.f26437f = bindCategory;
        }
    }
}
