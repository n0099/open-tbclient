package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.os.Bundle;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.contract.CouponListContract;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.CouponListActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class CouponListPresenter extends CouponListContract.Presenter {
    public static final String TAG = "CouponListPresenter";
    public boolean isFromActivityJump;
    public CouponListActivity mActivity;
    public PayRequest mPayRequest;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f25406a;

        /* renamed from: b  reason: collision with root package name */
        public int f25407b;

        /* renamed from: c  reason: collision with root package name */
        public int f25408c;

        /* renamed from: d  reason: collision with root package name */
        public String f25409d;

        /* renamed from: e  reason: collision with root package name */
        public String f25410e;

        /* renamed from: f  reason: collision with root package name */
        public String f25411f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25412g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f25413h;
    }

    public CouponListPresenter(CouponListActivity couponListActivity) {
        super(couponListActivity);
        this.mActivity = couponListActivity;
        couponListActivity.setPresenter((CouponListContract.Presenter) this);
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.wallet.paysdk.contract.CouponListContract.Presenter
    public void calcPayamount(a aVar) {
        if (aVar != null && aVar.f25407b == -1) {
            this.mActivity.showLoading(0);
        } else {
            this.mActivity.setPageClickable(false);
        }
        com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, TAG);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CALCU_COUPON);
        if (aVar != null) {
            this.isFromActivityJump = false;
            cVar.a(aVar.f25408c, aVar.f25407b, !aVar.f25413h ? "4" : "0");
        } else {
            this.isFromActivityJump = true;
        }
        cVar.setResponseCallback(this);
        cVar.execBean();
    }

    @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i, int i2, String str) {
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

    @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i, Object obj, String str) {
        CouponListActivity couponListActivity = this.mActivity;
        if (couponListActivity == null) {
            return;
        }
        int i2 = 0;
        couponListActivity.dismissLoading(0);
        this.isFromActivityJump = false;
        if (i == 16) {
            PayStatisticsUtil.onEventEnd(StatServiceEvent.CALCU_COUPON, 0);
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
                for (int i3 = 0; i3 < calcPaymentResponse.coupon_list.length; i3++) {
                    a aVar = new a();
                    PayData.Coupon[] couponArr = calcPaymentResponse.coupon_list;
                    aVar.f25406a = couponArr[i3].icon_url;
                    aVar.f25407b = i3;
                    aVar.f25408c = 2;
                    aVar.f25409d = couponArr[i3].description;
                    aVar.f25410e = couponArr[i3].discount_msg;
                    aVar.f25411f = couponArr[i3].select_state_desc;
                    aVar.f25412g = couponArr[i3].getEnable();
                    aVar.f25413h = calcPaymentResponse.coupon_list[i3].getSelected();
                    arrayList.add(aVar);
                }
            }
            if (calcPaymentResponse.activity_list != null) {
                while (true) {
                    PayData.Discount[] discountArr = calcPaymentResponse.activity_list;
                    if (i2 >= discountArr.length) {
                        break;
                    }
                    if (discountArr[i2].isCommonDiscount()) {
                        a aVar2 = new a();
                        PayData.Discount[] discountArr2 = calcPaymentResponse.activity_list;
                        aVar2.f25406a = discountArr2[i2].icon_url;
                        aVar2.f25407b = i2;
                        aVar2.f25408c = 1;
                        aVar2.f25409d = discountArr2[i2].description;
                        aVar2.f25410e = discountArr2[i2].discount_msg;
                        aVar2.f25411f = discountArr2[i2].select_state_desc;
                        aVar2.f25412g = discountArr2[i2].getEnable();
                        aVar2.f25413h = calcPaymentResponse.activity_list[i2].getSelected();
                        arrayList.add(aVar2);
                    }
                    i2++;
                }
            }
            this.mActivity.reFreshUI(arrayList);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.isFromActivityJump = bundle.getBoolean("isFromActivityJump", false);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(TAG);
        this.mActivity = null;
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putSerializable("isFromActivityJump", Boolean.valueOf(this.isFromActivityJump));
        }
    }
}
