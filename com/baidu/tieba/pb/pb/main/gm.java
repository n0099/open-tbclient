package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gm extends CustomMessageListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm(gg ggVar, int i) {
        super(i);
        this.eEv = ggVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dc dcVar;
        dc dcVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            dcVar = this.eEv.eCF;
            if (dcVar != null) {
                dcVar2 = this.eEv.eCF;
                dcVar2.notifyDataSetChanged();
            }
        }
    }
}
