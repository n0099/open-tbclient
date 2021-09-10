package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.contract.CouponListContract;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.CouponListActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class CouponListPresenter extends CouponListContract.Presenter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CouponListPresenter";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromActivityJump;
    public CouponListActivity mActivity;
    public PayRequest mPayRequest;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f62640a;

        /* renamed from: b  reason: collision with root package name */
        public int f62641b;

        /* renamed from: c  reason: collision with root package name */
        public int f62642c;

        /* renamed from: d  reason: collision with root package name */
        public String f62643d;

        /* renamed from: e  reason: collision with root package name */
        public String f62644e;

        /* renamed from: f  reason: collision with root package name */
        public String f62645f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f62646g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f62647h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponListPresenter(CouponListActivity couponListActivity) {
        super(couponListActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {couponListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivity = couponListActivity;
        couponListActivity.setPresenter((CouponListContract.Presenter) this);
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.wallet.paysdk.contract.CouponListContract.Presenter
    public void calcPayamount(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar != null && aVar.f62641b == -1) {
                this.mActivity.showLoading(0);
            } else {
                this.mActivity.setPageClickable(false);
            }
            com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, TAG);
            if (aVar != null) {
                this.isFromActivityJump = false;
                cVar.a(aVar.f62642c, aVar.f62641b, !aVar.f62647h ? "4" : "0");
            } else {
                this.isFromActivityJump = true;
            }
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this.mActivity, 0);
            GlobalUtils.toast(this.mActivity, str);
            this.mActivity.setPageClickable(true);
            if (this.isFromActivityJump) {
                this.mActivity.returnToPreviousPage();
            } else {
                this.mActivity.revertItemView();
            }
            this.isFromActivityJump = false;
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i2, Object obj, String str) {
        CouponListActivity couponListActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) || (couponListActivity = this.mActivity) == null) {
            return;
        }
        int i3 = 0;
        couponListActivity.dismissLoading(0);
        this.isFromActivityJump = false;
        if (i2 == 16) {
            CalcPaymentResponse calcPaymentResponse = obj instanceof CalcPaymentResponse ? (CalcPaymentResponse) obj : null;
            if (calcPaymentResponse == null) {
                return;
            }
            PayRequest payRequest = this.mPayRequest;
            if (payRequest != null) {
                payRequest.setCalcPayment(calcPaymentResponse);
                this.mPayRequest.calcPayPriceByRemote(calcPaymentResponse);
            }
            ArrayList<a> arrayList = new ArrayList<>();
            if (calcPaymentResponse.coupon_list != null) {
                for (int i4 = 0; i4 < calcPaymentResponse.coupon_list.length; i4++) {
                    a aVar = new a();
                    PayData.Coupon[] couponArr = calcPaymentResponse.coupon_list;
                    aVar.f62640a = couponArr[i4].icon_url;
                    aVar.f62641b = i4;
                    aVar.f62642c = 2;
                    aVar.f62643d = couponArr[i4].description;
                    aVar.f62644e = couponArr[i4].discount_msg;
                    aVar.f62645f = couponArr[i4].select_state_desc;
                    aVar.f62646g = couponArr[i4].getEnable();
                    aVar.f62647h = calcPaymentResponse.coupon_list[i4].getSelected();
                    arrayList.add(aVar);
                }
            }
            if (calcPaymentResponse.activity_list != null) {
                while (true) {
                    PayData.Discount[] discountArr = calcPaymentResponse.activity_list;
                    if (i3 >= discountArr.length) {
                        break;
                    }
                    if (discountArr[i3].isCommonDiscount()) {
                        a aVar2 = new a();
                        PayData.Discount[] discountArr2 = calcPaymentResponse.activity_list;
                        aVar2.f62640a = discountArr2[i3].icon_url;
                        aVar2.f62641b = i3;
                        aVar2.f62642c = 1;
                        aVar2.f62643d = discountArr2[i3].description;
                        aVar2.f62644e = discountArr2[i3].discount_msg;
                        aVar2.f62645f = discountArr2[i3].select_state_desc;
                        aVar2.f62646g = discountArr2[i3].getEnable();
                        aVar2.f62647h = calcPaymentResponse.activity_list[i3].getSelected();
                        arrayList.add(aVar2);
                    }
                    i3++;
                }
            }
            this.mActivity.reFreshUI(arrayList);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || bundle == null) {
            return;
        }
        this.isFromActivityJump = bundle.getBoolean("isFromActivityJump", false);
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BeanManager.getInstance().removeAllBeans(TAG);
            this.mActivity = null;
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) || bundle == null) {
            return;
        }
        bundle.putSerializable("isFromActivityJump", Boolean.valueOf(this.isFromActivityJump));
    }
}
