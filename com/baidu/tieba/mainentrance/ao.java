package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.cLU = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage instanceof ResponseSearchPersonHistoryReadMessage)) {
            return;
        }
        this.cLU.a(6, ((ResponseSearchPersonHistoryReadMessage) customResponsedMessage).datas);
    }
}
