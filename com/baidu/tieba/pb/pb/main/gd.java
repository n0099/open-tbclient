package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gd extends CustomMessageListener {
    final /* synthetic */ fx evi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(fx fxVar, int i) {
        super(i);
        this.evi = fxVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cv cvVar;
        cv cvVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            cvVar = this.evi.etv;
            if (cvVar != null) {
                cvVar2 = this.evi.etv;
                cvVar2.notifyDataSetChanged();
            }
        }
    }
}
