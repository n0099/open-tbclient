package com.baidu.tieba.person.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends CustomMessageListener {
    final /* synthetic */ at ehI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(at atVar, int i) {
        super(i);
        this.ehI = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                this.ehI.ehz = true;
                i = this.ehI.ehy;
                if (i < responseUnreadPointNum.getNum()) {
                    this.ehI.ehy = responseUnreadPointNum.getNum();
                    this.ehI.m(true, 3);
                    this.ehI.aKY();
                }
            } else {
                this.ehI.ehz = false;
                this.ehI.ehy = 0;
            }
            this.ehI.aKW();
        }
    }
}
