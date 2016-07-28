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
    final /* synthetic */ b dcW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dcW = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.a.InterfaceC0067a
    public void asK() {
        boolean z;
        boolean z2;
        ArrayList<UserData> asv;
        z = this.dcW.dcI;
        if (!z) {
            z2 = this.dcW.dcH;
            if (!z2 && (asv = this.dcW.dcM.asv()) != null && !asv.isEmpty()) {
                this.dcW.asG();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_FLOATING_PERSONAL_CHAT, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m10getInst(), asv)));
            }
        }
    }
}
