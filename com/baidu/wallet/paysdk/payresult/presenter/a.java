package com.baidu.wallet.paysdk.payresult.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.z;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.b;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.FeedbackDialog;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a implements b.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final String f62926f = "a";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<BaseActivity> f62927a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC1857b f62928b;

    /* renamed from: c  reason: collision with root package name */
    public int f62929c;

    /* renamed from: d  reason: collision with root package name */
    public PayRequest f62930d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62931e;

    /* renamed from: g  reason: collision with root package name */
    public IPayResultDataAdapter f62932g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(27409504, "Lcom/baidu/wallet/paysdk/payresult/presenter/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(27409504, "Lcom/baidu/wallet/paysdk/payresult/presenter/a;");
        }
    }

    public a(b.InterfaceC1857b interfaceC1857b, BaseActivity baseActivity, Bundle bundle) {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1857b, baseActivity, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62929c = 0;
        this.f62931e = true;
        this.f62927a = new WeakReference<>(baseActivity);
        this.f62928b = interfaceC1857b;
        d(bundle);
        if (this.f62929c == 1 && (payRequest = this.f62930d) != null) {
            IPayResultDataAdapter a2 = com.baidu.wallet.paysdk.payresult.adapters.a.a(baseActivity, payRequest.getPayFrom());
            this.f62932g = a2;
            if (a2 == null) {
                this.f62932g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f62927a.get(), this.f62929c);
                return;
            }
            return;
        }
        this.f62932g = com.baidu.wallet.paysdk.payresult.adapters.a.a(this.f62927a.get(), this.f62929c);
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62932g.isBelongPaySdk() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void c() {
        IPayResultDataAdapter iPayResultDataAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iPayResultDataAdapter = this.f62932g) == null) {
            return;
        }
        iPayResultDataAdapter.clearDataOnDestroy();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f62928b.showExpectedTime(this.f62932g.getExpectedTime());
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PayResultContent payResultContent = this.f62932g.getPayResultContent();
            if (payResultContent != null) {
                this.f62928b.setTitleLogo(payResultContent.title_url);
                this.f62928b.showPayResultRealMoneyText(payResultContent.cash_amount);
                this.f62928b.showTotalAmountInfo(payResultContent.total_amount, payResultContent.order_prefix, payResultContent.cash_amount);
                this.f62928b.showDiscountTypeInfo(payResultContent.discount_info, payResultContent.discount_amount, payResultContent.discount_prefix);
                this.f62928b.showPayTypeInfo(payResultContent.paytype_info, payResultContent.discount_amount, payResultContent.cash_amount, payResultContent.total_amount);
                return;
            }
            this.f62928b.showPayResultMoneyLayoutVisible(false);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public ArrayList<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            IPayResultDataAdapter iPayResultDataAdapter = this.f62932g;
            if (iPayResultDataAdapter == null) {
                return new ArrayList<>();
            }
            return iPayResultDataAdapter.getEventValue();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void g() {
        IPayResultDataAdapter iPayResultDataAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iPayResultDataAdapter = this.f62932g) == null) {
            return;
        }
        iPayResultDataAdapter.handleOKBtnOnclick();
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void h() {
        IPayResultDataAdapter iPayResultDataAdapter;
        PayResultContent.CrossMarket crossMarket;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iPayResultDataAdapter = this.f62932g) == null) {
            return;
        }
        if (iPayResultDataAdapter.getPayResultContent() != null) {
            this.f62928b.showAuthDialog(this.f62932g.getPayResultContent().compliance);
        }
        IPayResultDataAdapter iPayResultDataAdapter2 = this.f62932g;
        if (iPayResultDataAdapter2 == null || iPayResultDataAdapter2.getPayResultContent() == null || (crossMarket = this.f62932g.getPayResultContent().cross_market) == null || TextUtils.isEmpty(crossMarket.jump_url)) {
            return;
        }
        this.f62928b.showMarketDialog(crossMarket.pic_url, crossMarket.jump_url);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PayResultContent payResultContent = this.f62932g.getPayResultContent();
            if (this.f62932g.isPaySuccess()) {
                this.f62928b.showPaySuccess(a(this.f62932g.getPaySuccessContents(), payResultContent));
            } else {
                this.f62928b.showPaying(a(this.f62932g.getPayingContents(), payResultContent));
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean j() {
        InterceptResult invokeV;
        PayResultContent payResultContent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            IPayResultDataAdapter iPayResultDataAdapter = this.f62932g;
            if (iPayResultDataAdapter == null || (payResultContent = iPayResultDataAdapter.getPayResultContent()) == null || payResultContent.feedback_info == null || !this.f62931e) {
                return false;
            }
            this.f62931e = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public FeedbackDialog.a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            FeedbackDialog.a aVar = new FeedbackDialog.a();
            IPayResultDataAdapter iPayResultDataAdapter = this.f62932g;
            if (iPayResultDataAdapter != null && iPayResultDataAdapter.getPayResultContent() != null) {
                aVar.f63597a = this.f62932g.getPayResultContent().feedback_info;
                aVar.f63598b = new FeedbackDialog.b(this) { // from class: com.baidu.wallet.paysdk.payresult.presenter.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f62933a;

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
                        this.f62933a = this;
                    }

                    @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                    public void a(FeedbackDialog.c cVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                            z zVar = (z) PayBeanFactory.getInstance().getBean((Context) this.f62933a.f62927a.get(), PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, a.f62926f);
                            zVar.a(this.f62933a.f62932g.getPayResultContent().trans_no, cVar);
                            zVar.execBean();
                            this.f62933a.f62928b.finishPage();
                            this.f62933a.g();
                        }
                    }

                    @Override // com.baidu.wallet.paysdk.ui.widget.FeedbackDialog.b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f62933a.f62928b.finishPage();
                            this.f62933a.g();
                        }
                    }
                };
            }
            return aVar;
        }
        return (FeedbackDialog.a) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62932g != null : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            bundle.putSerializable(BeanConstants.KEY_PAY_RESULT_TYPE, Integer.valueOf(this.f62929c));
            PayRequest payRequest = this.f62930d;
            if (payRequest != null) {
                bundle.putSerializable("mPayRequest", payRequest);
            }
            IPayResultDataAdapter iPayResultDataAdapter = this.f62932g;
            if (iPayResultDataAdapter != null) {
                iPayResultDataAdapter.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) ? this.f62932g.onCreateCheckInvalide(bundle) : invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.presenter.b.a
    public boolean c(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bundle)) == null) {
            String actionBarTextId = this.f62932g.getActionBarTextId();
            if (TextUtils.isEmpty(actionBarTextId)) {
                actionBarTextId = "bd_wallet_payresult_title";
            }
            this.f62928b.initActionBar(actionBarTextId);
            this.f62928b.initViewElements();
            i();
            e();
            d();
            this.f62928b.showAuthorizeMsg(this.f62932g.getAuthorizeMsg());
            if (this.f62932g.isShowLBSPayText()) {
                b.InterfaceC1857b interfaceC1857b = this.f62928b;
                interfaceC1857b.setOKBtnText(ResUtils.getString(this.f62927a.get(), "ebpay_confirm_ret_msg") + this.f62932g.getLBSPayText());
            }
            if (this.f62932g.showResultPage()) {
                return true;
            }
            g();
            this.f62928b.finishPage();
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d(Bundle bundle) {
        PayResultContent payResultContent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            if (bundle != null) {
                this.f62929c = bundle.getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
                this.f62930d = (PayRequest) bundle.getSerializable("mPayRequest");
            } else if (this.f62927a.get().getIntent() == null || this.f62927a.get().getIntent().getExtras() == null) {
            } else {
                int i2 = this.f62927a.get().getIntent().getExtras().getInt(BeanConstants.KEY_PAY_RESULT_TYPE);
                this.f62929c = i2;
                if (i2 == 5 && (payResultContent = (PayResultContent) this.f62927a.get().getIntent().getExtras().get(BeanConstants.KEY_PAY_RESULT_HCE_DATA)) != null) {
                    PayDataCache.getInstance().setPayReslutContent(payResultContent);
                    PayRequestCache.getInstance().addBeanRequestToCache(BeanConstants.REQUEST_ID_PAY, new PayRequest());
                }
                this.f62930d = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            }
        }
    }

    private HashMap a(HashMap hashMap, PayResultContent payResultContent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, hashMap, payResultContent)) == null) {
            if (hashMap != null && payResultContent != null) {
                hashMap.put("update_phone_desc", payResultContent.subtitle_msg);
            }
            return hashMap;
        }
        return (HashMap) invokeLL.objValue;
    }
}
