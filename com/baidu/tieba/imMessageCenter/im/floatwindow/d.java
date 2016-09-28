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
public class d implements a.InterfaceC0071a {
    final /* synthetic */ b dqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dqc = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0071a
    public void axX() {
        boolean z;
        boolean z2;
        ArrayList<UserData> axI;
        z = this.dqc.dpO;
        if (!z) {
            z2 = this.dqc.dpN;
            if (!z2 && (axI = this.dqc.dpS.axI()) != null && !axI.isEmpty()) {
                this.dqc.axT();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m9getInst(), axI)));
            }
        }
    }
}
