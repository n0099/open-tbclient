package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import b.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes9.dex */
public class PaymentConfirmActivity extends BaseActivity<PaymentConfirmActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int currency;
    public CustomMessageListener mBindPhoneListener;
    public String mBookId;
    public int mBookType;
    public CustomMessageListener mBuyTbeanListener;
    public String mClickZone;
    public long mNeedTbean;
    public boolean mPasswordFreeze;
    public HttpMessageListener mPayListener;
    public PaymentConfirmModel<PaymentConfirmActivity> mPaymentConfirmModel;
    public b.a.r0.j2.c mPaymentConfirmView;
    public String mReferPage;
    public PaymentConfirmRequestData mRequestData;
    public HttpMessageListener mRequestPaymentConfirmInfoListener;
    public String mUserId;
    public PaymentConfirmInfoData paymentConfirmInfoData;
    public boolean scoresEnough;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52072e;

        public a(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52072e = paymentConfirmActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PaymentConfirmActivity paymentConfirmActivity = this.f52072e;
                paymentConfirmActivity.goToUEGValidate(2270066, paymentConfirmActivity.getResources().getString(R.string.sapi_forget_password_title));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52073e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52074f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52075g;

        public b(PaymentConfirmActivity paymentConfirmActivity, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52075g = paymentConfirmActivity;
            this.f52073e = i2;
            this.f52074f = str;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f52075g.goToUEGValidate(this.f52073e, this.f52074f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52076e;

        public c(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52076e = paymentConfirmActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52078f;

        public d(PaymentConfirmActivity paymentConfirmActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52078f = paymentConfirmActivity;
            this.f52077e = str;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f52078f.getPageContext().getPageActivity(), this.f52078f.getResources().getString(R.string.payment_dilaog_error_button), this.f52077e, true, true, true)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52079e;

        public e(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52079e = paymentConfirmActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f52079e.closeActivity();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52080e;

        public f(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52080e = paymentConfirmActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                b.a.q0.s.e0.b.j().t(this.f52080e.generateSharedPkey("payment_confirm_show"), !z);
                if (z) {
                    return;
                }
                b.a.q0.s.e0.b.j().v(this.f52080e.generateSharedPkey("payment_confirm_notshow_count"), 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52081e;

        public g(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52081e = paymentConfirmActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f52081e.mPasswordFreeze) {
                    this.f52081e.showPasswordInputDialog(0, null);
                } else if (this.f52081e.scoresEnough) {
                    b.a.r0.j2.d.a("c10292");
                    this.f52081e.goToPayment();
                } else {
                    b.a.r0.j2.d.a("c10293");
                    this.f52081e.goToBuyTdouActivity();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52082a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PaymentConfirmActivity paymentConfirmActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52082a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                PaymentConfirmActivity paymentConfirmActivity = this.f52082a;
                paymentConfirmActivity.hideLoadingView(paymentConfirmActivity.mPaymentConfirmView.i());
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
                    return;
                }
                ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
                this.f52082a.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
                if (!responsePaymentConfirmInfoMessage.hasError() && this.f52082a.paymentConfirmInfoData != null) {
                    PaymentConfirmActivity paymentConfirmActivity2 = this.f52082a;
                    paymentConfirmActivity2.scoresEnough = paymentConfirmActivity2.caculateScoresEnough(paymentConfirmActivity2.paymentConfirmInfoData);
                    this.f52082a.mPaymentConfirmView.e(this.f52082a.paymentConfirmInfoData, this.f52082a.scoresEnough);
                    PaymentConfirmActivity paymentConfirmActivity3 = this.f52082a;
                    paymentConfirmActivity3.handleSkip(paymentConfirmActivity3.paymentConfirmInfoData, this.f52082a.scoresEnough);
                } else if (responsePaymentConfirmInfoMessage.getError() == 1) {
                    Intent intent = new Intent();
                    intent.putExtra(DealIntentService.KEY_CLASS, 32);
                    intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, this.f52082a.mRequestData);
                    intent.putExtra(MemberPayStatistic.REFER_PAGE, this.f52082a.mReferPage);
                    intent.putExtra(MemberPayStatistic.CLICK_ZONE, this.f52082a.mClickZone);
                    TbadkCoreApplication.setIntent(intent);
                    ReloginManager.g().f(null);
                    this.f52082a.closeActivity();
                } else {
                    String errorString = responsePaymentConfirmInfoMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = this.f52082a.getResources().getString(R.string.neterror);
                    }
                    this.f52082a.showToast(errorString);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52083a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PaymentConfirmActivity paymentConfirmActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52083a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayResultData.UnusualInfo describe;
            PayVcodeInfoData vcode;
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f52083a.closeLoadingDialog();
                this.f52083a.mPaymentConfirmView.g(true);
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
                    return;
                }
                ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
                if (!responsePaymentPayMessage.hasError()) {
                    int error = responsePaymentPayMessage.getError();
                    if (error == 0) {
                        b.a.r0.j2.d.a("c10294");
                        PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData != null && payRequestDataData.getDescribe() != null && payRequestDataData.getDescribe().getWord() != null) {
                            string = payRequestDataData.getDescribe().getWord();
                        } else {
                            string = this.f52083a.getString(R.string.exchange_success);
                        }
                        new b.a.q0.s.g0.c().c(string);
                        if (!TextUtils.isEmpty(this.f52083a.mBookId)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001419));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001420, this.f52083a.mBookId));
                        }
                        if (this.f52083a.mRequestData != null) {
                            PaymentConfirmActivity paymentConfirmActivity = this.f52083a;
                            paymentConfirmActivity.sendSuccessMessage(paymentConfirmActivity.mRequestData.getOrder_id());
                        }
                        this.f52083a.closeActivity();
                        return;
                    } else if (error == 2270018) {
                        PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData2 != null) {
                            this.f52083a.showPasswordInputDialog(5, payRequestDataData2.getPubkey());
                            return;
                        }
                        return;
                    } else if (error == 2150040) {
                        PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData3 == null || (vcode = payRequestDataData3.getVcode()) == null) {
                            return;
                        }
                        this.f52083a.goToVcodeActivity(vcode);
                        return;
                    } else if (error == 2) {
                        PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData4 != null) {
                            this.f52083a.showPasswordInputDialog(5 - payRequestDataData4.getWrongtime(), payRequestDataData4.getPubkey());
                            return;
                        }
                        return;
                    } else if (error == 2190005) {
                        this.f52083a.mPasswordFreeze = true;
                        this.f52083a.showPasswordInputDialog(0, null);
                        return;
                    } else if (error == 2270066 || error == 2270040 || error == 2270041 || error == 2270042) {
                        this.f52083a.showUEGDialog(error);
                        return;
                    } else {
                        PayResultData payRequestDataData5 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData5 != null && (describe = payRequestDataData5.getDescribe()) != null) {
                            String word = describe.getWord();
                            String url = describe.getUrl();
                            if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                                this.f52083a.showOtherErrorDialog(word, url);
                                return;
                            }
                        }
                        b.a.q0.s.g0.c cVar = new b.a.q0.s.g0.c();
                        String errorString = responsePaymentPayMessage.getErrorString();
                        if (StringUtils.isNull(errorString)) {
                            errorString = this.f52083a.getResources().getString(R.string.plugin_pay_error);
                        }
                        cVar.b(errorString);
                        return;
                    }
                }
                this.f52083a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52084a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PaymentConfirmActivity paymentConfirmActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52084a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    this.f52084a.goToPayment(null, null, null, null, str, false);
                } else {
                    this.f52084a.goToPayment(null, null, null, null, null, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52085a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PaymentConfirmActivity paymentConfirmActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52085a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.l3.j0.g)) {
                this.f52085a.mNeedTbean -= b.a.e.e.m.b.e(((b.a.r0.l3.j0.g) customResponsedMessage.getData()).a(), 0);
                if (this.f52085a.mNeedTbean <= 0) {
                    this.f52085a.scoresEnough = true;
                    PaymentConfirmInfoData.GoodsInfo goods_info = this.f52085a.paymentConfirmInfoData.getGoods_info();
                    if (goods_info != null) {
                        this.f52085a.mPaymentConfirmView.v(goods_info.getTdou_num(), goods_info.getCurrency());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52086e;

        public l(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52086e = paymentConfirmActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52087e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52088f;

        public m(PaymentConfirmActivity paymentConfirmActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52088f = paymentConfirmActivity;
            this.f52087e = str;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                String j = this.f52088f.mPaymentConfirmView.j();
                if (StringUtils.isNull(j)) {
                    return;
                }
                this.f52088f.goToPayment(this.f52087e, j, null, null, null, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f52089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PaymentConfirmActivity f52090f;

        public n(PaymentConfirmActivity paymentConfirmActivity, b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52090f = paymentConfirmActivity;
            this.f52089e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f52089e.setYesBtnClickable(!StringUtils.isNull(editable.toString()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    public PaymentConfirmActivity() {
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
        this.mBookType = -1;
        this.mBookId = "";
        this.mRequestPaymentConfirmInfoListener = new h(this, CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
        this.mPayListener = new i(this, CmdConfigHttp.CMD_PAYMENT_PAY);
        this.mBindPhoneListener = new j(this, 2001359);
        this.mBuyTbeanListener = new k(this, 2001227);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caculateScoresEnough(PaymentConfirmInfoData paymentConfirmInfoData) {
        InterceptResult invokeL;
        PaymentConfirmInfoData.UserInfo.UserScores parr_scores;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, this, paymentConfirmInfoData)) == null) {
            PaymentConfirmInfoData.UserInfo user_info = paymentConfirmInfoData.getUser_info();
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (user_info != null && goods_info != null && (parr_scores = user_info.getParr_scores()) != null) {
                long scores_total = parr_scores.getScores_total();
                long tdou_num = goods_info.getTdou_num();
                if (scores_total - tdou_num >= 0) {
                    return true;
                }
                this.mNeedTbean = tdou_num - scores_total;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateSharedPkey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, this, str)) == null) {
            return str + this.mUserId;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBuyTdouActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            CurrencyJumpHelper.gotoBuyTBeanPage(getPageContext().getPageActivity(), (float) this.mNeedTbean, this.mReferPage, this.mClickZone);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPayment(String str, String str2, String str3, String str4, String str5, boolean z) {
        PaymentConfirmInfoData paymentConfirmInfoData;
        PaymentConfirmInfoData.OrderInfo order_info;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) || (paymentConfirmInfoData = this.paymentConfirmInfoData) == null || (order_info = paymentConfirmInfoData.getOrder_info()) == null) {
            return;
        }
        showLoadingDialog(getResources().getString(R.string.payment_confirm_pay_loading));
        this.mPaymentConfirmView.g(false);
        PayRequestData payRequestData = new PayRequestData();
        payRequestData.setOrderId(order_info.getOrder_id());
        payRequestData.setSceneId(order_info.getScene_id());
        payRequestData.setOpenId(order_info.getOpen_id());
        payRequestData.setTbs(this.paymentConfirmInfoData.getTbs());
        if (!StringUtils.isNull(str2)) {
            payRequestData.setPassword(URLEncoder.encode(b.a.r0.j2.e.a.a(str2, str)));
        }
        if (!StringUtils.isNull(str3)) {
            payRequestData.setCaptchaVcodeStr(str3);
        }
        if (!StringUtils.isNull(str4)) {
            payRequestData.setCaptchaInputStr(str4);
        }
        if (!StringUtils.isNull(str5)) {
            payRequestData.setBindId(str5);
        }
        if (z) {
            payRequestData.setMobileCheck("1");
        }
        this.mPaymentConfirmModel.w(payRequestData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToUEGValidate(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65570, this, i2, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), str, TbConfig.WEB_URL_TDOU_UEG + i2, true, true, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToVcodeActivity(PayVcodeInfoData payVcodeInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, payVcodeInfoData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayVcodeActivityConfig(getPageContext().getPageActivity(), payVcodeInfoData.getCaptcha_vcode_str(), payVcodeInfoData.getVcode_pic_url(), 230017)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleSkip(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        InterceptResult invokeLZ;
        PaymentConfirmInfoData.OrderInfo order_info;
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65572, this, paymentConfirmInfoData, z)) == null) {
            if (paymentConfirmInfoData != null && (order_info = paymentConfirmInfoData.getOrder_info()) != null && (cpath = order_info.getCpath()) != null) {
                if (z) {
                    if (cpath.getPay_cashier() == 1) {
                        goToPayment();
                        return true;
                    }
                } else if (cpath.getGettdou_cashier() == 1) {
                    goToBuyTdouActivity();
                    return true;
                }
                if (cpath.getTip_exist() == 1 && !b.a.q0.s.e0.b.j().g(generateSharedPkey("payment_confirm_show"), true)) {
                    int k2 = b.a.q0.s.e0.b.j().k(generateSharedPkey("payment_confirm_notshow_count"), 0);
                    if (k2 < cpath.getTip_days()) {
                        b.a.q0.s.e0.b.j().v(generateSharedPkey("payment_confirm_notshow_count"), k2 + 1);
                        if (z) {
                            goToPayment();
                            return true;
                        }
                        goToBuyTdouActivity();
                        return true;
                    } else if (k2 != 0) {
                        this.mPaymentConfirmView.k().setChecked(false);
                    }
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            try {
                Intent intent = getIntent();
                this.mRequestData = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
                this.mBookType = intent.getIntExtra("book_type", -1);
                this.mBookId = intent.getStringExtra("book_id");
                this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
                this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
                this.currency = this.mRequestData.getCurrency();
            } catch (Exception e2) {
                e2.printStackTrace();
                closeActivity();
            }
            this.mPaymentConfirmModel = new PaymentConfirmModel<>(getPageContext());
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.mPaymentConfirmView = new b.a.r0.j2.c(this, this.mBookType == 2, this.currency);
            this.mPaymentConfirmView.k().setChecked(!b.a.q0.s.e0.b.j().g(generateSharedPkey("payment_confirm_show"), true));
            this.mPaymentConfirmView.k().setOnCheckedChangeListener(new f(this));
            this.mPaymentConfirmView.o().setOnClickListener(new g(this));
        }
    }

    private void loadPaymentConfirmData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            if (b.a.e.e.p.l.D()) {
                showLoadingView(this.mPaymentConfirmView.i(), false);
                this.mPaymentConfirmModel.z(this.mRequestData);
                return;
            }
            showNetRefreshViewNoClick(this.mPaymentConfirmView.i(), getResources().getString(R.string.neterror));
        }
    }

    private void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.mPaymentConfirmModel.x();
            this.mPaymentConfirmModel.y();
            registerListener(this.mRequestPaymentConfirmInfoListener);
            this.mPayListener.setSelfListener(true);
            registerListener(this.mPayListener);
            registerListener(this.mBindPhoneListener);
            registerListener(this.mBuyTbeanListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSuccessMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001367, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOtherErrorDialog(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65578, this, str, str2) == null) {
            new b.a.q0.s.s.a(getPageContext().getPageActivity()).setMessage(str).setNegativeButton(R.string.cancel, new e(this)).setPositiveButton(R.string.payment_dilaog_error_button, new d(this, str2)).create(getPageContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPasswordInputDialog(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65579, this, i2, str) == null) {
            ViewGroup n2 = this.mPaymentConfirmView.n();
            this.mPaymentConfirmView.s();
            this.mPaymentConfirmView.u(i2);
            this.mPaymentConfirmView.d();
            b.a.q0.s.s.a create = new b.a.q0.s.s.a(getPageContext().getPageActivity()).setContentView(n2).setPositiveButton(R.string.push_commit, new m(this, str)).setNegativeButton(R.string.cancel, new l(this)).create(getPageContext());
            if (i2 <= 0) {
                create.setYesBtnClickable(false);
                this.mPaymentConfirmView.f(false);
            } else {
                create.setYesBtnClickable(true);
                this.mPaymentConfirmView.f(true);
            }
            if (this.mPaymentConfirmView.l() != null) {
                if (StringUtils.isNull(this.mPaymentConfirmView.j())) {
                    create.setYesBtnClickable(false);
                }
                this.mPaymentConfirmView.l().addTextChangedListener(new n(this, create));
            }
            if (this.mPaymentConfirmView.m() != null) {
                this.mPaymentConfirmView.m().setOnClickListener(new a(this));
            }
            create.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUEGDialog(int i2) {
        String string;
        String str;
        String string2;
        String str2;
        String string3;
        String string4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65580, this, i2) == null) {
            String str3 = "";
            if (i2 != 2270066) {
                switch (i2) {
                    case 2270040:
                        if (CurrencySwitchUtil.isYyIsConvert(this.currency)) {
                            string3 = getResources().getString(R.string.payment_ybean_dilaog_error_recommend_bunding_phone);
                        } else {
                            string3 = getResources().getString(R.string.payment_dilaog_error_recommend_bunding_phone);
                        }
                        str = string3;
                        string2 = getResources().getString(R.string.bunding_phone);
                        break;
                    case 2270041:
                        if (CurrencySwitchUtil.isYyIsConvert(this.currency)) {
                            string4 = getResources().getString(R.string.payment_ybean_dilaog_error_bunding_phone);
                        } else {
                            string4 = getResources().getString(R.string.payment_dilaog_error_bunding_phone);
                        }
                        str = string4;
                        string2 = getResources().getString(R.string.bunding_phone);
                        break;
                    case 2270042:
                        str = getResources().getString(R.string.payment_dilaog_error_message_validate);
                        string2 = getResources().getString(R.string.msg_validate);
                        break;
                    default:
                        str2 = "";
                        break;
                }
                new b.a.q0.s.s.a(getPageContext().getPageActivity()).setMessage(str2).setNegativeButton(R.string.cancel, new c(this)).setPositiveButton(str3, new b(this, i2, str3)).create(getPageContext()).show();
            }
            if (CurrencySwitchUtil.isYyIsConvert(this.currency)) {
                string = getResources().getString(R.string.payment_ybean_dilaog_error_bunding_password);
            } else {
                string = getResources().getString(R.string.payment_dilaog_error_bunding_password);
            }
            str = string;
            string2 = getResources().getString(R.string.setup_password);
            String str4 = str;
            str3 = string2;
            str2 = str4;
            new b.a.q0.s.s.a(getPageContext().getPageActivity()).setMessage(str2).setNegativeButton(R.string.cancel, new c(this)).setPositiveButton(str3, new b(this, i2, str3)).create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 230017 && intent != null) {
                goToPayment(null, null, intent.getStringExtra(PayVcodeActivityConfig.VCODE_MD5), intent.getStringExtra(PayVcodeActivityConfig.VCODE_RESULT), null, false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mPaymentConfirmView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            initUI();
            register();
            loadPaymentConfirmData();
            b.a.r0.j2.d.a("c10291");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToPayment() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            goToPayment(null, null, null, null, null, false);
        }
    }
}
