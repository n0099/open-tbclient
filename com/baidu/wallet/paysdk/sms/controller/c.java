package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ab;
import com.baidu.wallet.paysdk.beans.ad;
import com.baidu.wallet.paysdk.beans.q;
import com.baidu.wallet.paysdk.beans.w;
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
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayBaseActivity f59905a;

    /* renamed from: b  reason: collision with root package name */
    public SmsUpdateUiInterface f59906b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorContentResponse f59907c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f59908d;

    /* renamed from: e  reason: collision with root package name */
    public String f59909e;

    /* renamed from: f  reason: collision with root package name */
    public PayRequestCache.BindCategory f59910f;

    /* renamed from: g  reason: collision with root package name */
    public BindFastRequest f59911g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.wallet.paysdk.beans.b f59912h;

    /* renamed from: i  reason: collision with root package name */
    public ad f59913i;
    public com.baidu.wallet.paysdk.beans.g j;
    public String k;
    public boolean l;
    public boolean m;
    public w n;
    public SmsVerifyHandler o;
    public boolean p;
    public String q;

    public c() {
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
            WalletGlobalUtils.safeShowDialog(this.f59905a, 0, "");
            if (this.n == null) {
                this.n = (w) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 13, ISmsController.BEAN_TAG);
            }
            this.n.setResponseCallback((WalletSmsActivity) this.f59905a);
            this.n.b(this.f59905a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
            this.n.execBean();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f59905a, 0, "");
            if (this.f59912h == null) {
                this.f59912h = (com.baidu.wallet.paysdk.beans.b) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 513, ISmsController.BEAN_TAG);
            }
            this.f59912h.a(this.f59911g);
            this.f59912h.setResponseCallback((WalletSmsActivity) this.f59905a);
            this.f59912h.execBean();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            BindFastRequest bindFastRequest = this.f59911g;
            if (bindFastRequest != null && bindFastRequest.isNeedCheckSms()) {
                WalletGlobalUtils.safeShowDialog(this.f59905a, 0, "");
                if (this.f59913i == null) {
                    this.f59913i = (ad) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 11, ISmsController.BEAN_TAG);
                }
                int i2 = this.f59911g.getmBindFrom();
                if (i2 != 6 && i2 != 7 && i2 != 8) {
                    this.f59913i.a(false);
                } else {
                    this.f59913i.a(true);
                }
                this.f59913i.a(this.f59911g);
                this.f59913i.setResponseCallback((WalletSmsActivity) this.f59905a);
                this.f59913i.execBean();
                return;
            }
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            WalletGlobalUtils.safeShowDialog(this.f59905a, 0, "");
            if (this.n == null) {
                this.n = (w) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 13, ISmsController.BEAN_TAG);
            }
            this.n.setResponseCallback((WalletSmsActivity) this.f59905a);
            this.n.b(this.f59905a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320);
            this.n.execBean();
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.f59911g == null) {
            return;
        }
        PasswordController.getPassWordInstance().setPwd(this.f59905a, false, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f59914a;

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
                this.f59914a = this;
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onFail(int i2, String str) {
                SmsUpdateUiInterface smsUpdateUiInterface;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || (smsUpdateUiInterface = this.f59914a.f59906b) == null) {
                    return;
                }
                smsUpdateUiInterface.clearSmsEditText();
                this.f59914a.f59906b.doStopCountDown();
            }

            @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
            public void onSucceed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    int i2 = this.f59914a.f59911g.getmBindFrom();
                    if (i2 == 1) {
                        PayController.getInstance().bindSuccess(null);
                    } else if (i2 == 3) {
                        PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                    } else if (i2 == 4) {
                        PasswordController.getPassWordInstance().forgetPasswdSucceed(str);
                    } else if (i2 == 6 || i2 == 7 || i2 == 8) {
                        this.f59914a.h();
                    }
                }
            }
        }, this.f59910f);
        this.p = true;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            BindFastRequest bindFastRequest = this.f59911g;
            return (bindFastRequest == null || bindFastRequest.mBondCard == null || bindFastRequest.getmBindFrom() != 2 || this.f59911g.mBondCard.isNeedSendSms()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            String string = ResUtils.getString(this.f59905a, "dxm_ebpay_confirm");
            BindFastRequest bindFastRequest = this.f59911g;
            if (bindFastRequest == null) {
                return string;
            }
            int i2 = bindFastRequest.mBindFrom;
            if (i2 == 0) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    PayRequest payRequest = this.f59908d;
                    if (payRequest != null && payRequest.mMktSolution != null) {
                        return String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59908d.mMktSolution.easypay_amount));
                    }
                    if (this.f59911g != null) {
                        return String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59911g.getFinalPayAmount()));
                    }
                    return ResUtils.getString(this.f59905a, "ebpay_submit_pay");
                }
                return ResUtils.getString(this.f59905a, "wallet_base_next_step");
            } else if (i2 == 1) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    return ResUtils.getString(this.f59905a, "ebpay_pwd_done");
                }
                return ResUtils.getString(this.f59905a, "wallet_base_next_step");
            } else if (i2 == 2) {
                if (PayDataCache.getInstance().hasMobilePwd()) {
                    PayRequest payRequest2 = this.f59908d;
                    if (payRequest2 != null) {
                        if (payRequest2.mMktSolution != null) {
                            return String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59908d.mMktSolution.easypay_amount));
                        }
                        return String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59908d.getFinalPayAmount()));
                    }
                    return ResUtils.getString(this.f59905a, "ebpay_submit_pay");
                }
                return ResUtils.getString(this.f59905a, "wallet_base_next_step");
            } else if (i2 != 3) {
                if (i2 == 6 || i2 == 7 || i2 == 8) {
                    if (PayDataCache.getInstance().hasMobilePwd()) {
                        if (com.baidu.wallet.paysdk.a.b.c()) {
                            PayRequest payRequest3 = this.f59908d;
                            if (payRequest3 != null && payRequest3.mMktSolution != null) {
                                return String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59908d.mMktSolution.easypay_amount));
                            }
                            if (this.f59911g != null) {
                                return String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59911g.getFinalPayAmount()));
                            }
                            return ResUtils.getString(this.f59905a, "ebpay_submit_pay");
                        }
                        return ResUtils.getString(this.f59905a, "bd_wallet_auth_submit_sign");
                    }
                    return ResUtils.getString(this.f59905a, "wallet_base_next_step");
                }
                return string;
            } else {
                return ResUtils.getString(this.f59905a, "wallet_base_next_step");
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean doOnBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
            if (i3 != 80320 && i3 != 80321 && i3 != 80326 && i3 != 80327) {
                if (obj instanceof ErrorContentResponse) {
                    ErrorContentResponse errorContentResponse = (ErrorContentResponse) obj;
                    if (errorContentResponse.card_item_required != null && this.f59911g.getmBindFrom() == 2) {
                        this.k = str;
                        this.f59907c = errorContentResponse;
                        WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                        WalletGlobalUtils.safeShowDialog(this.f59905a, 40, "");
                        return true;
                    } else if (i3 == 15500) {
                        this.k = str;
                        PayBaseActivity payBaseActivity = this.f59905a;
                        payBaseActivity.mPayErrorCode = i3;
                        payBaseActivity.mBeanId = i2;
                        this.f59907c = errorContentResponse;
                        WalletGlobalUtils.safeDismissDialog(payBaseActivity, 0);
                        WalletGlobalUtils.safeShowDialog(this.f59905a, 65316, "");
                        return true;
                    }
                }
                return false;
            }
            WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
            PayDataCache.getInstance().cleanDetainmentDesc();
            if (obj instanceof ErrorContentResponse) {
                this.f59907c = (ErrorContentResponse) obj;
                if (!TextUtils.isEmpty(str)) {
                    this.k = str;
                    PayBaseActivity payBaseActivity2 = this.f59905a;
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
                return new PromptDialog(this.f59905a.getActivity());
            }
            if (i2 == 65316) {
                return new PromptDialog(this.f59905a.getActivity());
            }
            if (i2 == 65283) {
                return new PromptDialog(this.f59905a.getActivity());
            }
            if (i2 == 40) {
                return new PromptDialog(this.f59905a.getActivity());
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
            this.f59905a = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void doOnEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticManager.onEvent("clickInputVcode");
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
                    promptDialog.setPositiveBtn(ResUtils.string(this.f59905a, "dxm_ebpay_know"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.sms.controller.c.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ PromptDialog f59919a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f59920b;

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
                            this.f59920b = this;
                            this.f59919a = promptDialog;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayController payController = PayController.getInstance();
                                c cVar = this.f59920b;
                                payController.updateCardInfoPay(cVar.f59905a, cVar.f59907c);
                                this.f59919a.dismiss();
                                this.f59920b.f59905a.finishWithoutAnim();
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
                    StatisticManager.onEvent("showOrigPriceAlert");
                    PromptDialog promptDialog3 = (PromptDialog) dialog;
                    promptDialog3.setMessage(this.k);
                    promptDialog3.showCloseBtn(false);
                    promptDialog3.setNegativeBtn(ResUtils.getString(this.f59905a, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.c.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f59915a;

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
                            this.f59915a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f59915a.f59905a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "dxm_ebpay_cancel"));
                                WalletGlobalUtils.safeDismissDialog(this.f59915a.f59905a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                            }
                        }
                    });
                    promptDialog3.setPositiveBtn(ResUtils.getString(this.f59905a, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.c.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f59916a;

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
                            this.f59916a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f59916a.f59905a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "bd_wallet_pay_by_order_price"));
                                StatisticManager.onEvent("origPriceFromAlert");
                                c cVar = this.f59916a;
                                ErrorContentResponse errorContentResponse = cVar.f59907c;
                                if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                                    return;
                                }
                                if (cVar.j == null) {
                                    this.f59916a.j = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f59916a.f59905a, 5, ISmsController.BEAN_TAG);
                                }
                                ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(this.f59916a.f59907c.mkt_solution);
                                this.f59916a.j.a(this.f59916a.f59911g);
                                this.f59916a.j.setResponseCallback((WalletSmsActivity) this.f59916a.f59905a);
                                this.f59916a.j.execBean();
                                WalletGlobalUtils.safeShowDialog(this.f59916a.f59905a, 0, "");
                                WalletGlobalUtils.safeDismissDialog(this.f59916a.f59905a, ISmsController.DIALOG_CANNOT_DISCOUNT);
                                c cVar2 = this.f59916a;
                                if (cVar2.f59906b != null) {
                                    String k = cVar2.k();
                                    if (!TextUtils.isEmpty(k)) {
                                        this.f59916a.f59906b.updateButtonTip(k);
                                    }
                                }
                                SmsUpdateUiInterface smsUpdateUiInterface = this.f59916a.f59906b;
                                if (smsUpdateUiInterface != null) {
                                    smsUpdateUiInterface.clearSmsEditText();
                                    this.f59916a.f59906b.doStartCountDown();
                                }
                            }
                        }
                    });
                    return true;
                case 65316:
                    StatisticManager.onEvent("showCardOverDue");
                    PayRequest payRequest = this.f59908d;
                    if (payRequest != null && payRequest.mBondCard != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom)) {
                        this.f59908d.mBondCard.hideSMSDialog = true;
                    }
                    PromptDialog promptDialog4 = (PromptDialog) dialog;
                    promptDialog4.setMessage(this.k);
                    promptDialog4.showCloseBtn(false);
                    promptDialog4.setCanceledOnTouchOutside(false);
                    if (j()) {
                        promptDialog4.hideNegativeButton();
                    }
                    promptDialog4.setNegativeBtn(ResUtils.getString(this.f59905a, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.c.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f59917a;

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
                            this.f59917a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f59917a.f59905a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "dxm_ebpay_cancel"));
                                WalletGlobalUtils.safeDismissDialog(this.f59917a.f59905a, 65316);
                                PayBaseActivity payBaseActivity2 = this.f59917a.f59905a;
                                if (payBaseActivity2 instanceof WalletSmsActivity) {
                                    payBaseActivity2.finishWithoutAnim();
                                }
                            }
                        }
                    });
                    promptDialog4.setPositiveBtn(ResUtils.string(this.f59905a, "ebpay_wallet_continue_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.sms.controller.c.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f59918a;

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
                            this.f59918a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                PayBaseActivity payBaseActivity = this.f59918a.f59905a;
                                payBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(payBaseActivity, "ebpay_wallet_continue_pay"));
                                StatisticManager.onEvent("continueFromCardOverdue");
                                WalletGlobalUtils.safeDismissDialog(this.f59918a.f59905a, 65316);
                                PayController payController = PayController.getInstance();
                                c cVar = this.f59918a;
                                payController.updateCardInfoPay(cVar.f59905a, cVar.f59907c);
                                this.f59918a.f59905a.finishWithoutAnim();
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
            bundle.putSerializable("mBindRequest", this.f59911g);
            bundle.putSerializable("mPayRequest", this.f59908d);
            bundle.putSerializable("mCardInfoUpdateContent", this.f59907c);
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
                GlobalUtils.toast(this.f59905a, str);
                PayRequestCache.getInstance().clearPaySdkRequestCache();
                PayBaseBeanActivity.exitEbpay();
                return true;
            } else if (i2 == 5 || i2 == 17) {
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f59905a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                a(i3, str);
                return true;
            } else if (i2 == 11) {
                WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f59905a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                SmsVerifyHandler smsVerifyHandler = this.o;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsVerifyFailure(i3, str);
                }
                StatisticManager.onEvent("verifySmsFail");
                return true;
            } else if (i2 != 13 && i2 != 513) {
                if (i2 == 264) {
                    a(i3, str);
                    return true;
                }
                return false;
            } else {
                if (i3 == 5003) {
                    AccountManager.getInstance(this.f59905a).logout();
                    WalletLoginHelper.getInstance().logout(false);
                }
                WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                if (i3 == 60500) {
                    this.k = str;
                    WalletGlobalUtils.safeShowDialog(this.f59905a, ISmsController.DIALOG_PROMPT, "");
                } else {
                    SmsVerifyHandler smsVerifyHandler2 = this.o;
                    if (smsVerifyHandler2 != null) {
                        smsVerifyHandler2.onSmsVerifyFailure(i3, str);
                    }
                }
                if (i2 == 13) {
                    BindFastRequest bindFastRequest = this.f59911g;
                    if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f59911g.getmBindFrom() == 6)) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, i3 + "", str);
                        StatHelper.cacheCodeAndMsg(i3 + "", str);
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
                    }
                    StatisticManager.onEventWithValue("bindPayAcceptFail", String.valueOf(i3));
                } else {
                    String sessionId = StatHelper.getSessionId();
                    List<String> collectData = StatHelper.collectData(sessionId, i3 + "", str);
                    HashMap hashMap = new HashMap();
                    hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
                    StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, collectData, hashMap);
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
                WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
                if (checkCardInfoResponse != null && checkCardInfoResponse.checkResponseValidity()) {
                    if (this.f59911g != null) {
                        this.f59911g.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
                        if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                            this.f59911g.setChannelNo(checkCardInfoResponse.channel_no);
                        }
                    }
                    if (this.l) {
                        this.l = false;
                        SmsUpdateUiInterface smsUpdateUiInterface = this.f59906b;
                        if (smsUpdateUiInterface != null) {
                            smsUpdateUiInterface.upDateSafeKeyBoradView(checkCardInfoResponse.sms_length, checkCardInfoResponse.sms_type);
                        }
                    }
                    SmsUpdateUiInterface smsUpdateUiInterface2 = this.f59906b;
                    if (smsUpdateUiInterface2 != null) {
                        smsUpdateUiInterface2.updateModifyPhoneUI(!TextUtils.isEmpty(checkCardInfoResponse.update_mobile_desc), checkCardInfoResponse.update_mobile_desc);
                    }
                }
                SmsVerifyHandler smsVerifyHandler = this.o;
                if (smsVerifyHandler != null) {
                    smsVerifyHandler.onSmsSendSuccess();
                }
                return true;
            } else if (i2 == 11) {
                WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                StatisticManager.onEvent("verifySmsSuccess");
                i();
                SmsVerifyHandler smsVerifyHandler2 = this.o;
                if (smsVerifyHandler2 != null) {
                    smsVerifyHandler2.onSmsVerifySuccess();
                }
                return true;
            } else if (i2 == 513) {
                WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                PayRequest payRequest = this.f59908d;
                if (payRequest != null && BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) {
                    PayController.getInstance().bindExtSuccess(this.f59905a, obj);
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
                WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
                SmsVerifyHandler smsVerifyHandler4 = this.o;
                if (smsVerifyHandler4 != null) {
                    smsVerifyHandler4.onSmsSendSuccess();
                }
                return true;
            } else {
                BindFastRequest bindFastRequest = this.f59911g;
                if (bindFastRequest != null && (bindFastRequest.getmBindFrom() == 0 || this.f59911g.getmBindFrom() == 6)) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_SUCCESS);
                    StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                    StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
                }
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
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f59911g == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f59909e)) {
            unicodeDecode = !TextUtils.isEmpty(this.f59911g.getSendSmsphone()) ? this.f59911g.getSendSmsphone() : "";
        } else {
            unicodeDecode = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.f59909e));
        }
        String str = unicodeDecode;
        String k = k();
        SmsUpdateUiInterface smsUpdateUiInterface = this.f59906b;
        if (smsUpdateUiInterface != null) {
            smsUpdateUiInterface.initSMSActivityView("ebpay_sms_title_tip_security_check", "", k, str, true);
            this.f59906b.updateModifyPhoneUI(!TextUtils.isEmpty(this.q), this.q);
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
            BindFastRequest bindFastRequest = this.f59911g;
            if (bindFastRequest != null) {
                if (bindFastRequest.mBindFrom == 2 && this.m) {
                    c();
                    return 5320 != this.f59905a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
                }
                BindFastRequest bindFastRequest2 = this.f59911g;
                if (bindFastRequest2.mBindFrom == 8) {
                    c();
                    return 5320 != this.f59905a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
                }
                SmsUpdateUiInterface smsUpdateUiInterface = this.f59906b;
                if (smsUpdateUiInterface != null) {
                    smsUpdateUiInterface.upDateSafeKeyBoradView(bindFastRequest2.getSmsLength(), this.f59911g.getSmsType());
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
            this.q = this.f59905a.getIntent().getStringExtra(BeanConstants.UPDATE_MOBILE_DESC);
            if (bundle == null) {
                this.m = this.f59905a.getIntent().getBooleanExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
                if (this.f59911g == null) {
                    this.f59911g = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
                }
                if (this.f59910f == null) {
                    this.f59910f = PayRequestCache.BindCategory.Other;
                }
                this.f59908d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                Serializable serializableExtra = this.f59905a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
                if (serializableExtra != null) {
                    this.f59909e = ((ErrorContentResponse.Verify) serializableExtra).getVerifyMobile();
                }
            } else {
                this.m = bundle.getBoolean("isSendSMSForCompletionPay");
                this.k = bundle.getString("mDialogMsg");
                Serializable serializable = bundle.getSerializable("mBindRequest");
                if (serializable != null && (serializable instanceof BindFastRequest)) {
                    this.f59911g = (BindFastRequest) serializable;
                }
                Serializable serializable2 = bundle.getSerializable("mPayRequest");
                if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                    this.f59908d = (PayRequest) serializable2;
                }
                Serializable serializable3 = bundle.getSerializable("mCardInfoUpdateContent");
                if (serializable3 != null && (serializable3 instanceof ErrorContentResponse)) {
                    this.f59907c = (ErrorContentResponse) serializable3;
                }
                this.f59909e = bundle.getString("phone_no");
            }
            BindFastRequest bindFastRequest = this.f59911g;
            if (bindFastRequest != null && bindFastRequest.checkRequestValidity()) {
                PayRequestCache.getInstance().addBeanRequestToCache(this.f59911g.getRequestId(), this.f59911g);
                if (this.f59911g.isRealPay() && (payRequest = this.f59908d) != null && payRequest.checkRequestValidity()) {
                    PayRequestCache.getInstance().addBeanRequestToCache(this.f59908d.getRequestId(), this.f59908d);
                } else if (this.f59911g.isRealPay()) {
                    PayCallBackManager.callBackClientCancel(this.f59905a, "SmsControllerForBindSMS.onCreateCheckInvalide().1");
                    return false;
                }
                this.l = true;
                return true;
            }
            PayCallBackManager.callBackClientCancel(this.f59905a, "SmsControllerForBindSMS.onCreateCheckInvalide().2");
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void onNextBtnClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            StatHelper.statServiceEvent("thirdNext");
            BindFastRequest bindFastRequest = this.f59911g;
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
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (payBaseActivity = this.f59905a) == null) {
            return;
        }
        if (this.l) {
            WalletGlobalUtils.safeShowDialog(payBaseActivity, 0, "");
        }
        if (this.f59905a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) == 5320) {
            d();
        } else if (TextUtils.isEmpty(this.q)) {
            if (this.j == null) {
                this.j = (com.baidu.wallet.paysdk.beans.g) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 5, ISmsController.BEAN_TAG);
            }
            this.j.a(this.f59911g);
            this.j.setResponseCallback((WalletSmsActivity) this.f59905a);
            this.j.execBean();
        } else {
            com.baidu.wallet.paysdk.beans.f fVar = (com.baidu.wallet.paysdk.beans.f) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 17, ISmsController.BEAN_TAG);
            fVar.setResponseCallback(this.f59905a);
            fVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setActivity(PayBaseActivity payBaseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, payBaseActivity) == null) {
            this.f59905a = payBaseActivity;
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void setSmsUpdateUIInterface(SmsUpdateUiInterface smsUpdateUiInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, smsUpdateUiInterface) == null) {
            this.f59906b = smsUpdateUiInterface;
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
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && 5320 == this.f59905a.getIntent().getIntExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE) && this.f59906b != null) {
            ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) this.f59905a.getIntent().getSerializableExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA);
            this.f59906b.upDateSafeKeyBoradView(verify.sms_length, verify.sms_type);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) this.f59905a, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, ISmsController.BEAN_TAG);
            abVar.setResponseCallback(this.f59905a);
            abVar.execBean();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BindFastRequest bindFastRequest = this.f59911g;
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
                this.f59905a.finishWithoutAnim();
                PayController.getInstance().completeCardPay(this.f59905a, this.f59908d.mBondCard, (GetCardInfoResponse) obj);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this.f59905a, 0);
            if (this.l) {
                this.l = false;
            }
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.f59905a.getActivity(), "ebpay_send_fail");
            }
            SmsVerifyHandler smsVerifyHandler = this.o;
            if (smsVerifyHandler != null) {
                smsVerifyHandler.onSmsSendFailure(i2, str);
            }
            SmsUpdateUiInterface smsUpdateUiInterface = this.f59906b;
            if (smsUpdateUiInterface != null) {
                smsUpdateUiInterface.doStopCountDown();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q qVar = (q) PayBeanFactory.getInstance().getBean((Context) this.f59905a, 15, ISmsController.BEAN_TAG);
            qVar.setResponseCallback(this.f59905a);
            WalletGlobalUtils.safeShowDialog(this.f59905a, 0, "");
            qVar.execBean();
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bindFastRequest) == null) {
            this.f59911g = bindFastRequest;
        }
    }

    public void a(PayRequestCache.BindCategory bindCategory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bindCategory) == null) {
            if (bindCategory == null) {
                bindCategory = PayRequestCache.BindCategory.Other;
            }
            this.f59910f = bindCategory;
        }
    }
}
