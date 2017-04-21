package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements View.OnClickListener {
    final /* synthetic */ en eqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(en enVar) {
        this.eqR = enVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.as asVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.as asVar7;
        com.baidu.tbadk.core.data.as asVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.as asVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.eqR.aaY;
        if (com.baidu.tbadk.core.util.bg.aK(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hB()) {
            asVar = this.eqR.eqQ;
            if (asVar != null) {
                asVar2 = this.eqR.eqQ;
                if (!StringUtils.isNull(asVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.eqR.aaY;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), w.l.book_plugin_not_install_tip);
                    } else if (view == this.eqR.eqN) {
                        asVar8 = this.eqR.eqQ;
                        String str = asVar8.bookId;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        tbPageContext5 = this.eqR.aaY;
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.k.Z(tbPageContext5.getPageActivity());
                        aoVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aa("obj_locate", "0").aa("obj_param1", str));
                        com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c11442");
                        asVar9 = this.eqR.eqQ;
                        TiebaStatic.log(asVar10.aa("obj_id", asVar9.bookId).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.eqR.eqP) {
                        tbPageContext3 = this.eqR.aaY;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        asVar6 = this.eqR.eqQ;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, asVar6.bookId));
                        tbPageContext4 = this.eqR.aaY;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c11442");
                        asVar7 = this.eqR.eqQ;
                        TiebaStatic.log(asVar11.aa("obj_id", asVar7.bookId).aa("obj_locate", "1"));
                    } else if (view == this.eqR.eqI) {
                        asVar3 = this.eqR.eqQ;
                        if (!StringUtils.isNull(asVar3.Xk)) {
                            com.baidu.tbadk.core.util.bb wn = com.baidu.tbadk.core.util.bb.wn();
                            tbPageContext2 = this.eqR.aaY;
                            asVar4 = this.eqR.eqQ;
                            wn.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{asVar4.Xk});
                            com.baidu.tbadk.core.util.as asVar12 = new com.baidu.tbadk.core.util.as("c11442");
                            asVar5 = this.eqR.eqQ;
                            TiebaStatic.log(asVar12.aa("obj_id", asVar5.bookId).aa("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
