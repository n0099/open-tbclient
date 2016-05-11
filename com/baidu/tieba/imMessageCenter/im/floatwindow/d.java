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
    public void ajI() {
        boolean z;
        boolean z2;
        ArrayList<UserData> ajt;
        z = this.cuJ.cuv;
        if (!z) {
            z2 = this.cuJ.cuu;
            if (!z2 && (ajt = this.cuJ.cuz.ajt()) != null && !ajt.isEmpty()) {
                this.cuJ.ajE();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m11getInst(), ajt)));
            }
        }
    }
}
