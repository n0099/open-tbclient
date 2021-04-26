package com.baidu.wallet.paysdk.banksign;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.j;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PostWebviewActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
/* loaded from: classes5.dex */
public class b implements a {
    @Override // com.baidu.wallet.paysdk.banksign.a
    public void a(Context context) {
        BaiduPayDelegate.getInstance().reOrderPay(context);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void b(Context context) {
        if (context == null) {
            return;
        }
        String i2 = com.baidu.wallet.paysdk.banksign.a.a.a().i();
        byte[] k = com.baidu.wallet.paysdk.banksign.a.a.a().k();
        String j = com.baidu.wallet.paysdk.banksign.a.a.a().j();
        if (TextUtils.isEmpty(j)) {
            j = ResUtils.getString(context, "dxmpay_banksign_web_title");
        }
        StatisticManager.onEvent(StatServiceEvent.EVENT_ENTER_BANK_SIGN);
        PostWebviewActivity.startPostWebview(context, i2, k, j);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void c(Context context) {
        if (context == null || !(context instanceof BusinessSignedGuideActivity)) {
            return;
        }
        ((BusinessSignedGuideActivity) context).bindcard();
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void d(Context context) {
        if (context == null) {
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
        PayController.getInstance().gotoPayTypePage(context, true);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void e(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, BusinessSignedGuideActivity.class);
        intent.putExtra("isActiveSign", com.baidu.wallet.paysdk.banksign.a.a.a().f());
        context.startActivity(intent);
    }

    @Override // com.baidu.wallet.paysdk.banksign.a
    public void a() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            j e2 = com.baidu.wallet.paysdk.banksign.a.a.a().e();
            PayTypeActivity d2 = com.baidu.wallet.paysdk.banksign.a.a.a().d();
            if (e2 != null) {
                e2.f();
                com.baidu.wallet.paysdk.banksign.a.a.a().a((j) null);
                return;
            } else if (d2 != null) {
                d2.jumpPwdPayActivity();
                d2.finishWithoutAnim();
                com.baidu.wallet.paysdk.banksign.a.a.a().a((PayTypeActivity) null);
                return;
            } else {
                return;
            }
        }
        OrderConfirmActivity c2 = com.baidu.wallet.paysdk.banksign.a.a.a().c();
        if (c2 != null) {
            c2.pay(com.baidu.wallet.paysdk.banksign.a.a.a().h(), com.baidu.wallet.paysdk.banksign.a.a.a().g(), true);
            com.baidu.wallet.paysdk.banksign.a.a.a().a((OrderConfirmActivity) null);
        }
    }
}
