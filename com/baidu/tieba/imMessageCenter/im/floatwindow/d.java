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
public class d implements a.InterfaceC0062a {
    final /* synthetic */ b cuJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cuJ = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0062a
    public void ajK() {
        boolean z;
        boolean z2;
        ArrayList<UserData> ajv;
        z = this.cuJ.cuv;
        if (!z) {
            z2 = this.cuJ.cuu;
            if (!z2 && (ajv = this.cuJ.cuz.ajv()) != null && !ajv.isEmpty()) {
                this.cuJ.ajG();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m11getInst(), ajv)));
            }
        }
    }
}
