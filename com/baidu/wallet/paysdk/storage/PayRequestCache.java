package com.baidu.wallet.paysdk.storage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanRequestBase;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class PayRequestCache implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, BeanRequestBase> f25603a;

    /* loaded from: classes5.dex */
    public enum BindCategory {
        Other(0),
        Initiative(11),
        Pwd(4);
        
        public int mScenario;

        BindCategory(int i2) {
            this.mScenario = i2;
        }

        public static BindCategory from(int i2) {
            if (11 == i2) {
                return Initiative;
            }
            if (4 == i2) {
                return Pwd;
            }
            return Other;
        }

        public int getScenario() {
            return this.mScenario;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PayRequestCache f25604a = new PayRequestCache();
    }

    public static BindFastRequest getBindRequest(Activity activity) {
        BindCategory bindCategory = BindCategory.Other;
        if (activity != null) {
            bindCategory = getInstance().getBindCategoryByIntent(activity.getIntent());
        }
        return (BindFastRequest) getInstance().getRequest(bindCategory);
    }

    public static PayRequestCache getInstance() {
        return a.f25604a;
    }

    public void addBeanRequestToCache(String str, BeanRequestBase beanRequestBase) {
        if (str == null || str.equals("") || beanRequestBase == null) {
            return;
        }
        this.f25603a.put(str, beanRequestBase);
    }

    public void clearPaySdkRequestCache() {
        LogUtil.e(PayRequestCache.class.getSimpleName(), "clearPaySdkRequestCache", null);
        Set<String> keySet = this.f25603a.keySet();
        HashSet<String> hashSet = new HashSet();
        for (String str : keySet) {
            if (this.f25603a.get(str) != null && this.f25603a.get(str).mBelongPaySdk) {
                hashSet.add(str);
            }
        }
        for (String str2 : hashSet) {
            removeBeanRequestFromCache(str2);
        }
    }

    public void clearRequestCache() {
        this.f25603a.clear();
    }

    public BeanRequestBase getBeanRequestFromCache(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return this.f25603a.get(str);
    }

    public BindCategory getBindCategoryByIntent(Intent intent) {
        if (intent == null) {
            return BindCategory.Other;
        }
        BindCategory bindCategory = BindCategory.Other;
        String stringExtra = intent.getStringExtra(Constants.BDL_KEY_FROM);
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                bindCategory = BindCategory.valueOf(stringExtra);
                if (isPaying()) {
                    return BindCategory.Other;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return bindCategory;
    }

    public BeanRequestBase getRequest(BindCategory bindCategory) {
        if (bindCategory == null) {
            return null;
        }
        return getBeanRequestFromCache(bindCategory.name());
    }

    public CardData.BondCard getSelectCard() {
        PayRequest.PayPrice payPrice;
        PayRequest payRequest = (PayRequest) getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest == null || (payPrice = payRequest.getPayPrice()) == null || payPrice.payType != PayRequest.PayPrice.PayType.BANKCARD) {
            return null;
        }
        return payRequest.mBondCard;
    }

    public boolean isAuthFastPay() {
        BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
        return bindFastRequest != null && bindFastRequest.getmBindFrom() == 8;
    }

    public boolean isBondPay() {
        if (PayDataCache.getInstance().hasBondCards()) {
            PayRequest payRequest = (PayRequest) getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
            if (payRequest == null || payRequest.getPayPrice().payType != PayRequest.PayPrice.PayType.BANKCARD || payRequest.mBondCard == null) {
                return false;
            }
            int indexOf = Arrays.asList(PayDataCache.getInstance().getBondCards()).indexOf(payRequest.mBondCard);
            return (bindFastRequest == null || !payRequest.mBondCard.equals(bindFastRequest.mBondCard)) ? indexOf >= 0 : (isCompletePay() || isAuthFastPay() || indexOf < 0) ? false : true;
        }
        return false;
    }

    public boolean isCompletePay() {
        BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
        return bindFastRequest != null && (bindFastRequest.getmBindFrom() == 2 || bindFastRequest.getmBindFrom() == 7);
    }

    public boolean isPaying() {
        PayRequest payRequest = (PayRequest) getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        return (payRequest == null || BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom())) ? false : true;
    }

    public void removeBeanRequestFromCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f25603a.remove(str);
    }

    public PayRequestCache() {
        this.f25603a = new HashMap<>();
    }
}
