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
    final /* synthetic */ b btt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.btt = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.e
    public void Wc() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.btt.bte;
        if (!z) {
            z2 = this.btt.btd;
            if (!z2) {
                aVar = this.btt.bti;
                ArrayList<UserData> VN = aVar.VN();
                if (VN != null && !VN.isEmpty()) {
                    this.btt.VY();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), VN)));
                }
            }
        }
    }
}
