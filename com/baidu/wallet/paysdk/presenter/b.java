package com.baidu.wallet.paysdk.presenter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
/* loaded from: classes5.dex */
public class b extends a {
    public b(AuthorizeSignActivity authorizeSignActivity) {
        super(authorizeSignActivity);
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f25486b = 1;
        } else {
            this.f25486b = 2;
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public void b() {
        PayRequest payRequest;
        super.b();
        AuthorizeSignActivity authorizeSignActivity = this.f25485a;
        if (authorizeSignActivity == null || (payRequest = authorizeSignActivity.getPayRequest()) == null) {
            return;
        }
        String needToPayAmount = payRequest.getNeedToPayAmount();
        String orderPrice = payRequest.getOrderPrice();
        String discountAmount = payRequest.getDiscountAmount();
        String randomDiscountMsg = payRequest.getRandomDiscountMsg();
        boolean z = (TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) || StringUtils.fen2Yuan(discountAmount).equals("0.00")) ? false : true;
        SpannableString spannableString = new SpannableString(ResUtils.getString(this.f25485a.getApplicationContext(), "wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
        if (z) {
            spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        }
        String str = "-" + ResUtils.getString(this.f25485a.getApplicationContext(), "wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
        if (z) {
            this.f25485a.updateDiscountTxt(h(), payRequest.getGoodsName(), spannableString, payRequest.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.presenter.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayController.getInstance().gotoDiscountPage(b.this.f25485a);
                }
            });
        } else if (!TextUtils.isEmpty(randomDiscountMsg)) {
            this.f25485a.updateDiscountTxt(true, payRequest.getGoodsName(), null, randomDiscountMsg, null, StringUtils.fen2Yuan(needToPayAmount), null);
        } else {
            this.f25485a.updateDiscountTxt(h(), payRequest.getGoodsName(), null, payRequest.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.presenter.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayController.getInstance().gotoDiscountPage(b.this.f25485a);
                }
            });
        }
        this.f25485a.updateDiscountTitle(payRequest.title_url);
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, com.baidu.wallet.paysdk.presenter.e
    public boolean e() {
        return true;
    }

    public boolean h() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        return payRequest != null && payRequest.showCouponListEntry();
    }

    @Override // com.baidu.wallet.paysdk.presenter.a, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        view.getId();
        ResUtils.id(this.f25485a.getApplicationContext(), "sign_next_btn");
    }
}
