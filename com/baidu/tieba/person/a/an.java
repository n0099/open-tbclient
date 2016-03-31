package com.baidu.tieba.person.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends CustomMessageListener {
    final /* synthetic */ al dwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(al alVar, int i) {
        super(i);
        this.dwc = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                this.dwc.dvT = true;
                i = this.dwc.dvS;
                if (i < responseUnreadPointNum.getNum()) {
                    this.dwc.dvS = responseUnreadPointNum.getNum();
                    this.dwc.h(true, 3);
                    this.dwc.aBL();
                }
            } else {
                this.dwc.dvT = false;
                this.dwc.dvS = 0;
            }
            this.dwc.aBJ();
        }
    }
}
