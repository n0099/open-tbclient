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
public class d implements a.InterfaceC0065a {
    final /* synthetic */ b ceH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ceH = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0065a
    public void acZ() {
        boolean z;
        boolean z2;
        ArrayList<UserData> acK;
        z = this.ceH.cet;
        if (!z) {
            z2 = this.ceH.ces;
            if (!z2 && (acK = this.ceH.cex.acK()) != null && !acK.isEmpty()) {
                this.ceH.acV();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), acK)));
            }
        }
    }
}
