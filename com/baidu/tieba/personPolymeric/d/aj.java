package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ ab eFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ab abVar, int i) {
        super(i);
        this.eFx = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.data.i iVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
            this.eFx.fIK.qK(iVar.pT());
        }
    }
}
