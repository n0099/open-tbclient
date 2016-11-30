package com.baidu.tieba.recapp.report;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b flp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.flp = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d dVar;
        d dVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && i.gm()) {
            dVar = this.flp.fln;
            if (dVar != null) {
                dVar2 = this.flp.fln;
                dVar2.beH();
            }
        }
    }
}
