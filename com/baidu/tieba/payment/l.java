package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ PaymentConfirmActivity cHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cHo = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        long j2;
        PaymentConfirmInfoData paymentConfirmInfoData;
        s sVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.f)) {
            int g = com.baidu.adp.lib.h.b.g(((com.baidu.tieba.tbadkCore.data.f) customResponsedMessage.getData()).aLV(), 0);
            PaymentConfirmActivity paymentConfirmActivity = this.cHo;
            j = paymentConfirmActivity.cHj;
            paymentConfirmActivity.cHj = j - g;
            j2 = this.cHo.cHj;
            if (j2 <= 0) {
                this.cHo.cHh = true;
                paymentConfirmInfoData = this.cHo.paymentConfirmInfoData;
                PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
                if (goods_info != null) {
                    sVar = this.cHo.cHe;
                    sVar.bk(goods_info.getTdou_num());
                }
            }
        }
    }
}
