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
    final /* synthetic */ b bKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bKW = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0062a
    public void Yt() {
        boolean z;
        boolean z2;
        ArrayList<UserData> Ye;
        z = this.bKW.bKI;
        if (!z) {
            z2 = this.bKW.bKH;
            if (!z2 && (Ye = this.bKW.bKM.Ye()) != null && !Ye.isEmpty()) {
                this.bKW.Yp();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), Ye)));
            }
        }
    }
}
