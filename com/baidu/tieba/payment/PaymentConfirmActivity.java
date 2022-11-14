package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.jv4;
import com.baidu.tieba.jw7;
import com.baidu.tieba.kw7;
import com.baidu.tieba.lw7;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.py4;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.vy4;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class PaymentConfirmActivity extends BaseActivity<PaymentConfirmActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jw7 a;
    public PaymentConfirmModel<PaymentConfirmActivity> b;
    public PaymentConfirmRequestData c;
    public PaymentConfirmInfoData d;
    public boolean e;
    public String f;
    public boolean g;
    public long h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public HttpMessageListener n;
    public HttpMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes5.dex */
    public class a implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PaymentConfirmActivity c;

        public a(PaymentConfirmActivity paymentConfirmActivity, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = paymentConfirmActivity;
            this.a = i;
            this.b = str;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                this.c.c2(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        public b(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PaymentConfirmActivity b;

        public c(PaymentConfirmActivity paymentConfirmActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = paymentConfirmActivity;
            this.a = str;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.getPageContext().getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0de4), this.a, true, true, true)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        public d(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                this.a.closeActivity();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        public e(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                py4.k().u(this.a.Y1("payment_confirm_show"), !z);
                if (!z) {
                    py4.k().w(this.a.Y1("payment_confirm_notshow_count"), 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        public f(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.g) {
                    if (this.a.e) {
                        kw7.a("c10292");
                        this.a.a2();
                        return;
                    }
                    kw7.a("c10293");
                    this.a.Z1();
                    return;
                }
                this.a.k2(0, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PaymentConfirmActivity paymentConfirmActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                PaymentConfirmActivity paymentConfirmActivity = this.a;
                paymentConfirmActivity.hideLoadingView(paymentConfirmActivity.a.p());
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
                    ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
                    this.a.d = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
                    if (!responsePaymentConfirmInfoMessage.hasError() && this.a.d != null) {
                        PaymentConfirmActivity paymentConfirmActivity2 = this.a;
                        paymentConfirmActivity2.e = paymentConfirmActivity2.X1(paymentConfirmActivity2.d);
                        this.a.a.l(this.a.d, this.a.e);
                        PaymentConfirmActivity paymentConfirmActivity3 = this.a;
                        paymentConfirmActivity3.e2(paymentConfirmActivity3.d, this.a.e);
                    } else if (responsePaymentConfirmInfoMessage.getError() == 1) {
                        Intent intent = new Intent();
                        intent.putExtra(DealIntentService.KEY_CLASS, 32);
                        intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, this.a.c);
                        intent.putExtra(MemberPayStatistic.REFER_PAGE, this.a.k);
                        intent.putExtra(MemberPayStatistic.CLICK_ZONE, this.a.l);
                        TbadkCoreApplication.setIntent(intent);
                        ReloginManager.g().f(null);
                        this.a.closeActivity();
                    } else {
                        String errorString = responsePaymentConfirmInfoMessage.getErrorString();
                        if (StringUtils.isNull(errorString)) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
                        }
                        this.a.showToast(errorString);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PaymentConfirmActivity paymentConfirmActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayResultData.UnusualInfo describe;
            PayVcodeInfoData vcode;
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                this.a.a.n(true);
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
                    ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
                    if (!responsePaymentPayMessage.hasError()) {
                        int error = responsePaymentPayMessage.getError();
                        if (error == 0) {
                            kw7.a("c10294");
                            PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                            if (payRequestDataData != null && payRequestDataData.getDescribe() != null && payRequestDataData.getDescribe().getWord() != null) {
                                string = payRequestDataData.getDescribe().getWord();
                            } else {
                                string = this.a.getString(R.string.obfuscated_res_0x7f0f05e1);
                            }
                            new vy4().d(string);
                            if (!TextUtils.isEmpty(this.a.j)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001419));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001420, this.a.j));
                            }
                            if (this.a.c != null) {
                                PaymentConfirmActivity paymentConfirmActivity = this.a;
                                paymentConfirmActivity.i2(paymentConfirmActivity.c.getOrder_id());
                            }
                            this.a.closeActivity();
                            return;
                        } else if (error == 2270018) {
                            PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                            if (payRequestDataData2 == null) {
                                return;
                            }
                            this.a.k2(5, payRequestDataData2.getPubkey());
                            return;
                        } else if (error == 2150040) {
                            PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                            if (payRequestDataData3 != null && (vcode = payRequestDataData3.getVcode()) != null) {
                                this.a.d2(vcode);
                                return;
                            }
                            return;
                        } else if (error == 2) {
                            PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                            if (payRequestDataData4 == null) {
                                return;
                            }
                            this.a.k2(5 - payRequestDataData4.getWrongtime(), payRequestDataData4.getPubkey());
                            return;
                        } else if (error == 2190005) {
                            this.a.g = true;
                            this.a.k2(0, null);
                            return;
                        } else if (error == 2270066 || error == 2270040 || error == 2270041 || error == 2270042) {
                            this.a.l2(error);
                            return;
                        } else {
                            PayResultData payRequestDataData5 = responsePaymentPayMessage.getPayRequestDataData();
                            if (payRequestDataData5 != null && (describe = payRequestDataData5.getDescribe()) != null) {
                                String word = describe.getWord();
                                String url = describe.getUrl();
                                if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                                    this.a.j2(word, url);
                                    return;
                                }
                            }
                            vy4 vy4Var = new vy4();
                            String errorString = responsePaymentPayMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eff);
                            }
                            vy4Var.c(errorString);
                            return;
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PaymentConfirmActivity paymentConfirmActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    this.a.b2(null, null, null, null, str, false);
                } else {
                    this.a.b2(null, null, null, null, null, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        public j(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PaymentConfirmActivity b;

        public k(PaymentConfirmActivity paymentConfirmActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = paymentConfirmActivity;
            this.a = str;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
                String q = this.b.a.q();
                if (StringUtils.isNull(q)) {
                    return;
                }
                this.b.b2(this.a, q, null, null, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv4 a;
        public final /* synthetic */ PaymentConfirmActivity b;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public l(PaymentConfirmActivity paymentConfirmActivity, jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity, jv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = paymentConfirmActivity;
            this.a = jv4Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.setYesBtnClickable(!StringUtils.isNull(editable.toString()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PaymentConfirmActivity a;

        public m(PaymentConfirmActivity paymentConfirmActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {paymentConfirmActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = paymentConfirmActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PaymentConfirmActivity paymentConfirmActivity = this.a;
                paymentConfirmActivity.c2(2270066, paymentConfirmActivity.getResources().getString(R.string.obfuscated_res_0x7f0f109d));
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
        this.i = -1;
        this.j = "";
        this.n = new g(this, CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
        this.o = new h(this, CmdConfigHttp.CMD_PAYMENT_PAY);
        this.p = new i(this, 2001359);
    }

    public final void f2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.i == 2) {
                z = true;
            } else {
                z = false;
            }
            this.a = new jw7(this, z, this.m);
            this.a.r().setChecked(!py4.k().h(Y1("payment_confirm_show"), true));
            this.a.r().setOnCheckedChangeListener(new e(this));
            this.a.v().setOnClickListener(new f(this));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            try {
                Intent intent = getIntent();
                this.c = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
                this.i = intent.getIntExtra(PaymentConfirmActivityConfig.BOOK_TYPE, -1);
                this.j = intent.getStringExtra("book_id");
                this.k = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
                this.l = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
                this.m = this.c.getCurrency();
            } catch (Exception e2) {
                e2.printStackTrace();
                closeActivity();
            }
            this.b = new PaymentConfirmModel<>(getPageContext());
        }
    }

    public final String Y1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return str + this.f;
        }
        return (String) invokeL.objValue;
    }

    public final void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001367, str));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.a.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onCreate(bundle);
            initData();
            f2();
            h2();
            g2();
            kw7.a("c10291");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 230017 && intent != null) {
                b2(null, null, intent.getStringExtra(PayVcodeActivityConfig.VCODE_MD5), intent.getStringExtra(PayVcodeActivityConfig.VCODE_RESULT), null, false);
            }
        }
    }

    public final boolean X1(PaymentConfirmInfoData paymentConfirmInfoData) {
        InterceptResult invokeL;
        PaymentConfirmInfoData.UserInfo.UserScores parr_scores;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, paymentConfirmInfoData)) == null) {
            PaymentConfirmInfoData.UserInfo user_info = paymentConfirmInfoData.getUser_info();
            PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
            if (user_info != null && goods_info != null && (parr_scores = user_info.getParr_scores()) != null) {
                long scores_total = parr_scores.getScores_total();
                long tdou_num = goods_info.getTdou_num();
                if (scores_total - tdou_num >= 0) {
                    return true;
                }
                this.h = tdou_num - scores_total;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void d2(PayVcodeInfoData payVcodeInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, payVcodeInfoData) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayVcodeActivityConfig(getPageContext().getPageActivity(), payVcodeInfoData.getCaptcha_vcode_str(), payVcodeInfoData.getVcode_pic_url(), 230017)));
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CurrencyJumpHelper.gotoBuyTBeanPage(getPageContext().getPageActivity(), (float) this.h, this.k, this.l);
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b2(null, null, null, null, null, false);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.A();
            this.b.B();
            registerListener(this.n);
            this.o.setSelfListener(true);
            registerListener(this.o);
            registerListener(this.p);
        }
    }

    public final void b2(String str, String str2, String str3, String str4, String str5, boolean z) {
        PaymentConfirmInfoData paymentConfirmInfoData;
        PaymentConfirmInfoData.OrderInfo order_info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) && (paymentConfirmInfoData = this.d) != null && (order_info = paymentConfirmInfoData.getOrder_info()) != null) {
            showLoadingDialog(getResources().getString(R.string.obfuscated_res_0x7f0f0de0));
            this.a.n(false);
            PayRequestData payRequestData = new PayRequestData();
            payRequestData.setOrderId(order_info.getOrder_id());
            payRequestData.setSceneId(order_info.getScene_id());
            payRequestData.setOpenId(order_info.getOpen_id());
            payRequestData.setTbs(this.d.getTbs());
            if (!StringUtils.isNull(str2)) {
                payRequestData.setPassword(URLEncoder.encode(lw7.a(str2, str)));
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
            this.b.z(payRequestData);
        }
    }

    public final void c2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), str, TbConfig.WEB_URL_TDOU_UEG + i2, true, true, true)));
        }
    }

    public final void j2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            new jv4(getPageContext().getPageActivity()).setMessage(str).setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new d(this)).setPositiveButton(R.string.obfuscated_res_0x7f0f0de4, new c(this, str2)).create(getPageContext()).show();
        }
    }

    public final boolean e2(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        InterceptResult invokeLZ;
        PaymentConfirmInfoData.OrderInfo order_info;
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, paymentConfirmInfoData, z)) == null) {
            if (paymentConfirmInfoData != null && (order_info = paymentConfirmInfoData.getOrder_info()) != null && (cpath = order_info.getCpath()) != null) {
                if (z) {
                    if (cpath.getPay_cashier() == 1) {
                        a2();
                        return true;
                    }
                } else if (cpath.getGettdou_cashier() == 1) {
                    Z1();
                    return true;
                }
                if (cpath.getTip_exist() == 1 && !py4.k().h(Y1("payment_confirm_show"), true)) {
                    int l2 = py4.k().l(Y1("payment_confirm_notshow_count"), 0);
                    if (l2 < cpath.getTip_days()) {
                        py4.k().w(Y1("payment_confirm_notshow_count"), l2 + 1);
                        if (z) {
                            a2();
                            return true;
                        }
                        Z1();
                        return true;
                    } else if (l2 != 0) {
                        this.a.r().setChecked(false);
                    }
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (yi.F()) {
                showLoadingView(this.a.p(), false);
                this.b.C(this.c);
                return;
            }
            showNetRefreshViewNoClick(this.a.p(), getResources().getString(R.string.obfuscated_res_0x7f0f0c81));
        }
    }

    public final void k2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, str) == null) {
            ViewGroup u = this.a.u();
            this.a.z();
            this.a.B(i2);
            this.a.k();
            jv4 create = new jv4(getPageContext().getPageActivity()).setContentView(u).setPositiveButton(R.string.obfuscated_res_0x7f0f0f98, new k(this, str)).setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new j(this)).create(getPageContext());
            if (i2 <= 0) {
                create.setYesBtnClickable(false);
                this.a.m(false);
            } else {
                create.setYesBtnClickable(true);
                this.a.m(true);
            }
            if (this.a.s() != null) {
                if (StringUtils.isNull(this.a.q())) {
                    create.setYesBtnClickable(false);
                }
                this.a.s().addTextChangedListener(new l(this, create));
            }
            if (this.a.t() != null) {
                this.a.t().setOnClickListener(new m(this));
            }
            create.show();
        }
    }

    public final void l2(int i2) {
        String string;
        String str;
        String string2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            String str3 = "";
            if (i2 != 2270066) {
                switch (i2) {
                    case 2270040:
                        if (CurrencySwitchUtil.isYyIsConvert(this.m)) {
                            str = getResources().getString(R.string.obfuscated_res_0x7f0f0df3);
                        } else {
                            str = getResources().getString(R.string.obfuscated_res_0x7f0f0de6);
                        }
                        string2 = getResources().getString(R.string.obfuscated_res_0x7f0f035a);
                        break;
                    case 2270041:
                        if (CurrencySwitchUtil.isYyIsConvert(this.m)) {
                            str = getResources().getString(R.string.obfuscated_res_0x7f0f0df2);
                        } else {
                            str = getResources().getString(R.string.obfuscated_res_0x7f0f0de3);
                        }
                        string2 = getResources().getString(R.string.obfuscated_res_0x7f0f035a);
                        break;
                    case 2270042:
                        str = getResources().getString(R.string.obfuscated_res_0x7f0f0de5);
                        string2 = getResources().getString(R.string.obfuscated_res_0x7f0f0b2b);
                        break;
                    default:
                        str2 = "";
                        break;
                }
                new jv4(getPageContext().getPageActivity()).setMessage(str2).setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this)).setPositiveButton(str3, new a(this, i2, str3)).create(getPageContext()).show();
            }
            if (CurrencySwitchUtil.isYyIsConvert(this.m)) {
                string = getResources().getString(R.string.obfuscated_res_0x7f0f0df1);
            } else {
                string = getResources().getString(R.string.obfuscated_res_0x7f0f0de2);
            }
            str = string;
            string2 = getResources().getString(R.string.obfuscated_res_0x7f0f117c);
            String str4 = str;
            str3 = string2;
            str2 = str4;
            new jv4(getPageContext().getPageActivity()).setMessage(str2).setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this)).setPositiveButton(str3, new a(this, i2, str3)).create(getPageContext()).show();
        }
    }
}
