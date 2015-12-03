package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.imMessageCenter.FloatingPersonalChatActivityConfig;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0070a {
    final /* synthetic */ b caG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.caG = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0070a
    public void abQ() {
        boolean z;
        boolean z2;
        ArrayList<UserData> abB;
        z = this.caG.cas;
        if (!z) {
            z2 = this.caG.car;
            if (!z2 && (abB = this.caG.caw.abB()) != null && !abB.isEmpty()) {
                this.caG.abM();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), abB)));
            }
        }
    }
}
