package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.person.a.at atVar;
        com.baidu.tieba.person.a.at atVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.this$0.dyP = false;
                atVar = this.this$0.eoM;
                if (atVar != null) {
                    atVar2 = this.this$0.eoM;
                    atVar2.ii(false);
                    return;
                }
                return;
            }
            this.this$0.onUserChanged(false);
        }
    }
}
