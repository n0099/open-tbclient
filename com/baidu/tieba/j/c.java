package com.baidu.tieba.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a flI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.flI = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.flI.flq;
                if (i < responseUnreadPointNum.getNum()) {
                    this.flI.fls = true;
                    a aVar = this.flI;
                    z = this.flI.fls;
                    aVar.flh = z ? true : this.flI.flh;
                    this.flI.flq = responseUnreadPointNum.getNum();
                    this.flI.baH();
                    this.flI.baG();
                }
            }
            this.flI.flq = responseUnreadPointNum.getNum();
            this.flI.fls = false;
            this.flI.baG();
        }
    }
}
