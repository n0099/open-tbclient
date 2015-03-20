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
    final /* synthetic */ b bqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bqs = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.e
    public void Ux() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.bqs.bqe;
        if (!z) {
            z2 = this.bqs.bqd;
            if (!z2) {
                aVar = this.bqs.bqi;
                ArrayList<UserData> Ui = aVar.Ui();
                if (Ui != null && !Ui.isEmpty()) {
                    this.bqs.Ut();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), Ui)));
                }
            }
        }
    }
}
