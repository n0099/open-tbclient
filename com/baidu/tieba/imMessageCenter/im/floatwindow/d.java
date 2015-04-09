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
    final /* synthetic */ b bqI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bqI = bVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.e
    public void UK() {
        boolean z;
        boolean z2;
        a aVar;
        z = this.bqI.bqu;
        if (!z) {
            z2 = this.bqI.bqt;
            if (!z2) {
                aVar = this.bqI.bqy;
                ArrayList<UserData> Uv = aVar.Uv();
                if (Uv != null && !Uv.isEmpty()) {
                    this.bqI.UG();
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002011, new FloatingPersonalChatActivityConfig(TbadkCoreApplication.m411getInst(), Uv)));
                }
            }
        }
    }
}
