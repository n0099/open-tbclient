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
    final /* synthetic */ b ctL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ctL = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0068a
    public void ajC() {
        boolean z;
        boolean z2;
        ArrayList<UserData> ajn;
        z = this.ctL.ctx;
        if (!z) {
            z2 = this.ctL.ctw;
            if (!z2 && (ajn = this.ctL.ctB.ajn()) != null && !ajn.isEmpty()) {
                this.ctL.ajy();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), ajn)));
            }
        }
    }
}
