package com.baidu.tieba.person.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ ah cRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ah ahVar, int i) {
        super(i);
        this.cRL = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                this.cRL.cRD = true;
                i = this.cRL.cRC;
                if (i < responseUnreadPointNum.getNum()) {
                    this.cRL.cRC = responseUnreadPointNum.getNum();
                    this.cRL.c(true, 3);
                    this.cRL.apn();
                }
            } else {
                this.cRL.cRD = false;
                this.cRL.cRC = 0;
            }
            this.cRL.apl();
        }
    }
}
