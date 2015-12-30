package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ d dLx;
    private final /* synthetic */ b dLy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, b bVar) {
        this.dLx = dVar;
        this.dLy = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.dLx.Md;
        aVar2.dismiss();
        if (this.dLy != null) {
            TbadkCoreApplication.m411getInst().setSkinType(0);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKINT_DATA_FROM_DB, this.dLy));
        }
    }
}
