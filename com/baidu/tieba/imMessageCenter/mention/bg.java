package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf czs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.czs = bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar;
        az azVar;
        j jVar;
        z zVar;
        z zVar2;
        j jVar2;
        az azVar2;
        k kVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            kVar = this.czs.czn;
            if (kVar != null) {
                kVar2 = this.czs.czn;
                kVar2.fi(true);
            }
            azVar = this.czs.czl;
            if (azVar != null) {
                azVar2 = this.czs.czl;
                azVar2.fi(true);
            }
            jVar = this.czs.czm;
            if (jVar != null) {
                jVar2 = this.czs.czm;
                jVar2.fi(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.czs.czk;
            if (zVar != null) {
                zVar2 = this.czs.czk;
                zVar2.ali();
            }
        }
    }
}
