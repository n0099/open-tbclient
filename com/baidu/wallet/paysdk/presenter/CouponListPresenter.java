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
        public String f25547a;

        /* renamed from: b  reason: collision with root package name */
        public int f25548b;

        /* renamed from: c  reason: collision with root package name */
        public int f25549c;

        /* renamed from: d  reason: collision with root package name */
        public String f25550d;

        /* renamed from: e  reason: collision with root package name */
        public String f25551e;

        /* renamed from: f  reason: collision with root package name */
        public String f25552f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f25553g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f25554h;
    }

    public CouponListPresenter(CouponListActivity couponListActivity) {
        super(couponListActivity);
        this.mActivity = couponListActivity;
        couponListActivity.setPresenter((CouponListContract.Presenter) this);
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.wallet.paysdk.contract.CouponListContract.Presenter
    public void calcPayamount(a aVar) {
        if (aVar != null && aVar.f25548b == -1) {
            this.mActivity.showLoading(0);
        } else {
            this.mActivity.setPageClickable(false);
        }
        com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, TAG);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CALCU_COUPON);
        if (aVar != null) {
            this.isFromActivityJump = false;
            cVar.a(aVar.f25549c, aVar.f25548b, !aVar.f25554h ? "4" : "0");
        } else {
            this.isFromActivityJump = true;
        }
        cVar.setResponseCallback(this);
        cVar.execBean();
    }

    @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i2, int i3, String str) {
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
    public void handleResponse(int i2, Object obj, String str) {
        CouponListActivity couponListActivity = this.mActivity;
        if (couponListActivity == null) {
            return;
        }
        int i3 = 0;
        couponListActivity.dismissLoading(0);
        this.isFromActivityJump = false;
        if (i2 == 16) {
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
                for (int i4 = 0; i4 < calcPaymentResponse.coupon_list.length; i4++) {
                    a aVar = new a();
                    PayData.Coupon[] couponArr = calcPaymentResponse.coupon_list;
                    aVar.f25547a = couponArr[i4].icon_url;
                    aVar.f25548b = i4;
                    aVar.f25549c = 2;
                    aVar.f25550d = couponArr[i4].description;
                    aVar.f25551e = couponArr[i4].discount_msg;
                    aVar.f25552f = couponArr[i4].select_state_desc;
                    aVar.f25553g = couponArr[i4].getEnable();
                    aVar.f25554h = calcPaymentResponse.coupon_list[i4].getSelected();
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
                        aVar2.f25547a = discountArr2[i3].icon_url;
                        aVar2.f25548b = i3;
                        aVar2.f25549c = 1;
                        aVar2.f25550d = discountArr2[i3].description;
                        aVar2.f25551e = discountArr2[i3].discount_msg;
                        aVar2.f25552f = discountArr2[i3].select_state_desc;
                        aVar2.f25553g = discountArr2[i3].getEnable();
                        aVar2.f25554h = calcPaymentResponse.activity_list[i3].getSelected();
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
