package com.baidu.tieba.payment;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ PaymentConfirmActivity cdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PaymentConfirmActivity paymentConfirmActivity, int i) {
        super(i);
        this.cdS = paymentConfirmActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            if (!StringUtils.isNull(str)) {
                this.cdS.a(null, null, null, null, str, false);
            } else {
                this.cdS.a(null, null, null, null, null, true);
            }
        }
    }
}
