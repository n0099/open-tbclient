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
    final /* synthetic */ b dvJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dvJ = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0070a
    public void azU() {
        boolean z;
        boolean z2;
        ArrayList<UserData> azF;
        z = this.dvJ.dvv;
        if (!z) {
            z2 = this.dvJ.dvu;
            if (!z2 && (azF = this.dvJ.dvz.azF()) != null && !azF.isEmpty()) {
                this.dvJ.azQ();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m9getInst(), azF)));
            }
        }
    }
}
