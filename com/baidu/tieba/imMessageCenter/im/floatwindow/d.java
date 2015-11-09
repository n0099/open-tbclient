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
    final /* synthetic */ b bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bLC = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0062a
    public void YK() {
        boolean z;
        boolean z2;
        ArrayList<UserData> Yv;
        z = this.bLC.bLo;
        if (!z) {
            z2 = this.bLC.bLn;
            if (!z2 && (Yv = this.bLC.bLs.Yv()) != null && !Yv.isEmpty()) {
                this.bLC.YG();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), Yv)));
            }
        }
    }
}
