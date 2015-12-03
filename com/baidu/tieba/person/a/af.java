package com.baidu.tieba.person.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends CustomMessageListener {
    final /* synthetic */ ad cNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ad adVar, int i) {
        super(i);
        this.cNh = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                this.cNh.cMZ = true;
                i = this.cNh.cMY;
                if (i < responseUnreadPointNum.getNum()) {
                    this.cNh.cMY = responseUnreadPointNum.getNum();
                    this.cNh.c(true, 3);
                    this.cNh.aod();
                }
            } else {
                this.cNh.cMZ = false;
                this.cNh.cMY = 0;
            }
            this.cNh.aob();
        }
    }
}
