package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ TbPageContext RW;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a deq;
    private final /* synthetic */ int der;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.baidu.tbadk.core.dialog.a aVar, int i, TbPageContext tbPageContext) {
        this.deq = aVar;
        this.der = i;
        this.RW = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.deq.dismiss();
        int i = 0;
        switch (this.der) {
            case 1:
                i = 10;
                TiebaStatic.log("c10271");
                break;
            case 2:
                i = 13;
                TiebaStatic.log("c10282");
                break;
            case 3:
                i = 11;
                TiebaStatic.log("c10276");
                break;
            case 4:
                i = 14;
                TiebaStatic.log("c10285");
                break;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(this.RW.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i)));
    }
}
