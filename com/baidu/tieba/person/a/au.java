package com.baidu.tieba.person.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends CustomMessageListener {
    final /* synthetic */ as dze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(as asVar, int i) {
        super(i);
        this.dze = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                this.dze.dyV = true;
                i = this.dze.dyU;
                if (i < responseUnreadPointNum.getNum()) {
                    this.dze.dyU = responseUnreadPointNum.getNum();
                    this.dze.j(true, 3);
                    this.dze.aCc();
                }
            } else {
                this.dze.dyV = false;
                this.dze.dyU = 0;
            }
            this.dze.aCa();
        }
    }
}
