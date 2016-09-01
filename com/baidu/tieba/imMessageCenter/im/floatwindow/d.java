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
public class d implements a.InterfaceC0068a {
    final /* synthetic */ b doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.doE = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0068a
    public void axy() {
        boolean z;
        boolean z2;
        ArrayList<UserData> axj;
        z = this.doE.doq;
        if (!z) {
            z2 = this.doE.dop;
            if (!z2 && (axj = this.doE.dou.axj()) != null && !axj.isEmpty()) {
                this.doE.axu();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m9getInst(), axj)));
            }
        }
    }
}
