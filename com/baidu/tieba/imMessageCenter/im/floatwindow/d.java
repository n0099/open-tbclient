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
public class d implements a.InterfaceC0067a {
    final /* synthetic */ b cZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cZY = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0067a
    public void arY() {
        boolean z;
        boolean z2;
        ArrayList<UserData> arJ;
        z = this.cZY.cZK;
        if (!z) {
            z2 = this.cZY.cZJ;
            if (!z2 && (arJ = this.cZY.cZO.arJ()) != null && !arJ.isEmpty()) {
                this.cZY.arU();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m9getInst(), arJ)));
            }
        }
    }
}
