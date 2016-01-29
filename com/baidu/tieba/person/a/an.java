package com.baidu.tieba.person.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends CustomMessageListener {
    final /* synthetic */ al dbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(al alVar, int i) {
        super(i);
        this.dbz = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                this.dbz.dbr = true;
                i = this.dbz.dbq;
                if (i < responseUnreadPointNum.getNum()) {
                    this.dbz.dbq = responseUnreadPointNum.getNum();
                    this.dbz.f(true, 3);
                    this.dbz.auf();
                }
            } else {
                this.dbz.dbr = false;
                this.dbz.dbq = 0;
            }
            this.dbz.aud();
        }
    }
}
