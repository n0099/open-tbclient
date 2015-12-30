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
    private final /* synthetic */ TbPageContext SL;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a bzl;
    private final /* synthetic */ int dLH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(com.baidu.tbadk.core.dialog.a aVar, int i, TbPageContext tbPageContext) {
        this.bzl = aVar;
        this.dLH = i;
        this.SL = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bzl.dismiss();
        int i = 0;
        switch (this.dLH) {
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
            case 5:
                i = 18;
                TiebaStatic.log("c10767");
                break;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(this.SL.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i)));
    }
}
