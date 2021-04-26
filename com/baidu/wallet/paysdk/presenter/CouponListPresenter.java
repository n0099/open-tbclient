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
        public String f26188a;

        /* renamed from: b  reason: collision with root package name */
        public int f26189b;

        /* renamed from: c  reason: collision with root package name */
        public int f26190c;

        /* renamed from: d  reason: collision with root package name */
        public String f26191d;

        /* renamed from: e  reason: collision with root package name */
        public String f26192e;

        /* renamed from: f  reason: collision with root package name */
        public String f26193f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f26194g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f26195h;
    }

    public CouponListPresenter(CouponListActivity couponListActivity) {
        super(couponListActivity);
        this.mActivity = couponListActivity;
        couponListActivity.setPresenter((CouponListContract.Presenter) this);
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    @Override // com.baidu.wallet.paysdk.contract.CouponListContract.Presenter
    public void calcPayamount(a aVar) {
        if (aVar != null && aVar.f26189b == -1) {
            this.mActivity.showLoading(0);
        } else {
            this.mActivity.setPageClickable(false);
        }
        com.baidu.wallet.paysdk.beans.c cVar = (com.baidu.wallet.paysdk.beans.c) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, TAG);
        PayStatisticsUtil.onEventStart(StatServiceEvent.CALCU_COUPON);
        if (aVar != null) {
            this.isFromActivityJump = false;
            cVar.a(aVar.f26190c, aVar.f26189b, !aVar.f26195h ? "4" : "0");
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
                    aVar.f26188a = couponArr[i4].icon_url;
                    aVar.f26189b = i4;
                    aVar.f26190c = 2;
                    aVar.f26191d = couponArr[i4].description;
                    aVar.f26192e = couponArr[i4].discount_msg;
                    aVar.f26193f = couponArr[i4].select_state_desc;
                    aVar.f26194g = couponArr[i4].getEnable();
                    aVar.f26195h = calcPaymentResponse.coupon_list[i4].getSelected();
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
                        aVar2.f26188a = discountArr2[i3].icon_url;
                        aVar2.f26189b = i3;
                        aVar2.f26190c = 1;
                        aVar2.f26191d = discountArr2[i3].description;
                        aVar2.f26192e = discountArr2[i3].discount_msg;
                        aVar2.f26193f = discountArr2[i3].select_state_desc;
                        aVar2.f26194g = discountArr2[i3].getEnable();
                        aVar2.f26195h = calcPaymentResponse.activity_list[i3].getSelected();
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
