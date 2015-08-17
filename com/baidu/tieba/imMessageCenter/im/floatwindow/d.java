package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.imMessageCenter.im.floatwindow.view.a;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0062a {
    final /* synthetic */ b bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bHk = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0062a
    public void XJ() {
        boolean z;
        boolean z2;
        ArrayList<UserData> Xu;
        z = this.bHk.bGW;
        if (!z) {
            z2 = this.bHk.bGV;
            if (!z2 && (Xu = this.bHk.bHa.Xu()) != null && !Xu.isEmpty()) {
                this.bHk.XF();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), Xu)));
            }
        }
    }
}
