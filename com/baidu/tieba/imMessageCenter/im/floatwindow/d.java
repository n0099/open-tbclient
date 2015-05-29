package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FloatingPersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.imMessageCenter.im.floatwindow.view.e {
    final /* synthetic */ b bts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bts = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.e
    public void Wb() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.bts.btd;
        if (!z) {
            z2 = this.bts.btc;
            if (!z2) {
                aVar = this.bts.bth;
                ArrayList<UserData> VM = aVar.VM();
                if (VM != null && !VM.isEmpty()) {
                    this.bts.VX();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), VM)));
                }
            }
        }
    }
}
