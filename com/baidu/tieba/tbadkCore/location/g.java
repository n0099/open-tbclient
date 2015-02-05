package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d cas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.cas = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                this.cas.eE(false);
                this.cas.aS(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                jVar3 = this.cas.cam;
                if (jVar3 != null) {
                    jVar4 = this.cas.cam;
                    jVar4.fw(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.cas.eE(true);
            jVar = this.cas.cam;
            if (jVar != null) {
                jVar2 = this.cas.cam;
                jVar2.Fs();
            }
        }
    }
}
