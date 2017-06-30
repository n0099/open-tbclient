package com.baidu.tieba.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a fvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.fvW = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.fvW.fvG;
                if (i < responseUnreadPointNum.getNum()) {
                    this.fvW.fvH = true;
                    a aVar = this.fvW;
                    z = this.fvW.fvH;
                    aVar.fvy = z ? true : this.fvW.fvy;
                    this.fvW.fvG = responseUnreadPointNum.getNum();
                    this.fvW.beR();
                    this.fvW.beQ();
                }
            }
            this.fvW.fvG = responseUnreadPointNum.getNum();
            this.fvW.fvH = false;
            this.fvW.beQ();
        }
    }
}
