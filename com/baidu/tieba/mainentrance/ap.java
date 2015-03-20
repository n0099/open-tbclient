package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SquareSearchActivity squareSearchActivity, int i) {
        super(i);
        this.bzG = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data;
        if (customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof ArrayList)) {
            return;
        }
        this.bzG.a(5, (ArrayList) data);
    }
}
