package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf dts;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.dts = bfVar;
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
            kVar = this.dts.dtn;
            if (kVar != null) {
                kVar2 = this.dts.dtn;
                kVar2.gv(true);
            }
            azVar = this.dts.dtl;
            if (azVar != null) {
                azVar2 = this.dts.dtl;
                azVar2.gv(true);
            }
            jVar = this.dts.dtm;
            if (jVar != null) {
                jVar2 = this.dts.dtm;
                jVar2.gv(true);
            }
            MentionActivityConfig.newJumpIn = true;
            zVar = this.dts.dtk;
            if (zVar != null) {
                zVar2 = this.dts.dtk;
                zVar2.ayV();
            }
        }
    }
}
