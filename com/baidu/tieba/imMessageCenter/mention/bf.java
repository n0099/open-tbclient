package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends CustomMessageListener {
    final /* synthetic */ be cyt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(be beVar, int i) {
        super(i);
        this.cyt = beVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar;
        ay ayVar;
        j jVar;
        z zVar;
        z zVar2;
        j jVar2;
        ay ayVar2;
        k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            kVar = this.cyt.cyo;
            if (kVar != null) {
                kVar2 = this.cyt.cyo;
                kVar2.eG(true);
            }
            ayVar = this.cyt.cym;
            if (ayVar != null) {
                ayVar2 = this.cyt.cym;
                ayVar2.eG(true);
            }
            jVar = this.cyt.cyn;
            if (jVar != null) {
                jVar2 = this.cyt.cyn;
                jVar2.eG(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.cyt.cyl;
            if (zVar != null) {
                zVar2 = this.cyt.cyl;
                zVar2.akZ();
            }
        }
    }
}
